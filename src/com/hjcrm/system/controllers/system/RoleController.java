package com.hjcrm.system.controllers.system;

import com.hjcrm.publics.constants.JumpViewConstans;
import com.hjcrm.publics.utils.JsonUtil;
import com.hjcrm.publics.utils.PageBean;
import com.hjcrm.publics.utils.UserContext;
import com.hjcrm.system.bean.Menu;
import com.hjcrm.system.bean.Role;
import com.hjcrm.system.bean.RoleForMenu;
import com.hjcrm.system.service.MenuService;
import com.hjcrm.system.service.RoleService;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

@Controller
public class RoleController {
    @Autowired
    private RoleService roleService;
    @Autowired
    private MenuService menuService;

    @RequestMapping("/system/roleMang")
    public String roleMang(){
        if (UserContext.getLoginUser()!=null){
            return JumpViewConstans.SYSTEM_ROLE_MANAGER;
        }

        return JumpViewConstans.NUll_Page;
    }
    /*
     * 查询所有角色
     * */
    @RequestMapping("/role/queryAllRole.do")
    @ResponseBody
    public String queryAllRole(Integer currentPage,Integer pageSize){
        List<Role> roles = roleService.queryAllRole(currentPage, pageSize);
        if(roles.size()>0){
            PageBean pb=new PageBean();
            pb.setCurrentPage(currentPage);
            pb.setCountResult(roleService.queryCountRole());
            return JsonUtil.jsonToPage(roles,pb);
        }
        return JumpViewConstans.NUll_Page;
    }
    /*
     * 添加或者修改角色
     * */
    @RequestMapping("/role/addOrUpdateRole.do")
    @ResponseBody
    public String addOrUpdateRole(Role role){
        if(roleService.addOrUpdateRole(role)>0) {
            return "success";
        }
        return "error";
    }
    /*
     * 删除角色
     * */
    @RequestMapping("/role/deleteRole.do")
    @ResponseBody
    public String deleteRole(String ids){
        if(roleService.deleteRole(ids)>0){
            return "success";
        }
        return "error";
    }
    /*
     * 查询角色所拥有的菜单并选中
     * */
    @RequestMapping("/rolemenu/queryAllMenuAndSelected.do")
    public @ResponseBody String queryAllMenuAndSelected(String roleid){
        List<Menu> menus=menuService.queryMenus();
        List<Menu> rolemenus=menuService.queryRoleMenus(roleid);
        if(rolemenus!=null && rolemenus.size()>0){
            for (int i=0;i<menus.size();i++) {
                for (int j = 0; j < rolemenus.size(); j++) {
                    if (menus.get(i).getMenuid() == rolemenus.get(j).getMenuid()) {
                        menus.get(i).setSelected(true);
                        break;
                    }
                }
            }
            for (int i=0;i<menus.size();i++) {
                List<Menu> secndMenus=menus.get(i).getChildren();
                if(secndMenus!=null && secndMenus.size()>0){
                    for (int j=0;j<secndMenus.size();j++){
                        for (int z = 0; z < rolemenus.size(); z++) {
                            if(secndMenus!=null){
                                if (secndMenus.get(j).getMenuid() == rolemenus.get(z).getMenuid()) {
                                    secndMenus.get(j).setSelected(true);
                                    break;
                                }
                            }
                        }
                    }
                }
            }
        }

        return JsonUtil.jsonToPage(menus,null);
    }
    /*
     * 给角色分配菜单
     * */
    @RequestMapping("/rolemenu/assignMenu.do")
    public @ResponseBody String assignMenu(String roleid,String menuid){
        if(StringUtils.isNotBlank(roleid)){
            roleService.deleteRolMenuByRid(roleid);
            if(StringUtils.isNotBlank(menuid)){
                for (String s:menuid.split(",")){
                    RoleForMenu rfm=new RoleForMenu();
                    rfm.setRoleid(Integer.parseInt(roleid));
                    rfm.setMenuid(Integer.parseInt(s));
                    roleService.addRoleMenu(rfm);
                }
            }
            return "success";
        }
        return "null";
    }
}

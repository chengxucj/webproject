package com.hjcrm.system.controllers.system;

import com.hjcrm.publics.constants.JumpViewConstans;
import com.hjcrm.publics.utils.JsonUtil;
import com.hjcrm.publics.utils.UserContext;
import com.hjcrm.system.bean.Menu;
import com.hjcrm.system.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

@Controller
public class MnuController {
    @Autowired
    private MenuService menuService;
    @RequestMapping("main.do")
    public String index(Model model){
        if(UserContext.getLoginUser()!=null){
            int roleid=UserContext.getLoginUser().getRoleid();
            List<Menu> menus = menuService.findMenus(roleid+"");
            model.addAttribute("menus",menus);
            return JumpViewConstans.SYSTEM_INDEX;
        }
        return "redirect:loginView.do";
    }
    @RequestMapping("/system/menuMang.do")
    public String menuMang(){
        if(UserContext.getLoginUser()!=null){
            return JumpViewConstans.SYSTEM_MEUN_MANAGER;
        }
        return  JumpViewConstans.NUll_Page;
    }
    /*
     * 查询所有菜单
     * */
    @RequestMapping("/menu/queryAllMenu.do")
    @ResponseBody
    public String menuList(){
        List<Menu> menus = menuService.queryMenus();
        if (menus.size()>0){
            return JsonUtil.jsonToPage(menus,null);
        }
        return  JumpViewConstans.NUll_Page;
    }
    /*
     * 添加或者修改菜单
     * */
    @RequestMapping("/menu/addOrUpdateMenu.do")
    @ResponseBody
    public String addOrUpdateMenu(Menu menu){
        menu.setRoleid(UserContext.getLoginUser().getRoleid());
        int row=menuService.addOrUpdateMenu(menu);
        if(row>0){
            return "success";
        }
        return "error";
    }
    /*
     * 删除菜单
     * */
    @RequestMapping("/menu/delete.do")
    @ResponseBody
    public String deleteMenu(String ids){
        List<Integer> list=new ArrayList<>();
        String str="";
        for(String s:ids.split(",")){
            if(menuService.selectSecndMenuid(Integer.parseInt(s))){
                str="删除的菜单含有一级菜单不能删除";
                continue;
            }
            if(menuService.selectRoleByMenu(Integer.parseInt(s))){
                str="有被分配的菜单不能删除";
                continue;
            }
            list.add(Integer.parseInt(s));
        }
        if(list.size()>0){
            if(menuService.delteMenu(list)>0){
                return "success";
            }
        }
        return str;
    }

}

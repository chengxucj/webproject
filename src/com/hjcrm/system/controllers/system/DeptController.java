package com.hjcrm.system.controllers.system;

import com.hjcrm.publics.constants.JumpViewConstans;
import com.hjcrm.publics.utils.JsonUtil;
import com.hjcrm.publics.utils.PageBean;
import com.hjcrm.publics.utils.UserContext;
import com.hjcrm.system.bean.Dept;
import com.hjcrm.system.bean.Role;
import com.hjcrm.system.service.DeptService;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

@Controller
public class DeptController {
    @Autowired
    private DeptService deptService;

    @RequestMapping("/dept/queryDept.do")
    @ResponseBody
    public String methoda(){
        List<Dept> depts = deptService.selectDepts();
        if(depts.size()>0){
            return  JsonUtil.jsonToPage(depts,null);
        }
        return JumpViewConstans.SYSTEM_INDEX;
    }
    /*
     * 根据部门id查询角色
     * */
    @RequestMapping("/role/queryRoleByDeptid.do")
    @ResponseBody
    public String queryRoleByDeptid(Integer deptid){
        if (deptid!=null){
            List<Role> roles = deptService.queryRoleBydeptid(deptid);
            if(roles.size()>0){
                return JsonUtil.jsonToPage(roles,null);
            }
        }

        return JumpViewConstans.SYSTEM_INDEX;
    }
    @RequestMapping("/system/deptMang.do")
    public String deptMang(){
        if(UserContext.getLoginUser()!=null){
            return  JumpViewConstans.SYSTEM_DEPT_MANAGER;
        }
        return  JumpViewConstans.NUll_Page;
    }
    /*
     * 查询所有部门
     * */
    @RequestMapping("/dept/queryDepts.do")
    public @ResponseBody String queryDepts(int currentPage,int pageSize){
        PageBean pb=new PageBean();
        pb.setCurrentPage((currentPage-1)*pageSize);
        pb.setPageSize(pageSize);
        List<Dept> list=deptService.queryDepts(pb);
        if(list.size()>0){
            pb.setCountResult(deptService.queryCountDept());
            pb.setCurrentPage(currentPage);
            return  JsonUtil.jsonToPage(list,pb);
        }
        return JumpViewConstans.NUll_Page;
    }
    /*
     * 添加or修改部门信息
     * */
    @RequestMapping("/dept/saveOrUpdate.do")
    public @ResponseBody String saveOrUpdate(Dept dept){
        int row=deptService.saveOrUpdate(dept);
        if(row>0){
            return "success";
        }
        return "error";
    }
    /*
     * 删除部门
     * */
    @RequestMapping("/dept/delete.do")
    public @ResponseBody String deleteDept(String ids){
        List<Integer> list=new ArrayList<>();
        if(StringUtils.isNotBlank(ids)){
            for (String s:ids.split(",")) {
                if(deptService.selectRoleBydeptid(Integer.parseInt(s))){
                    return "lose";
                }
                list.add(Integer.parseInt(s));
            }
        }
        if(list.size()>0){
            if(deptService.deleteDept(list)>0){
                return "success";
            }
        }
        return "error";
    }

}

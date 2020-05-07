package com.hjcrm.system.controllers.system;

import com.hjcrm.publics.constants.JumpViewConstans;
import com.hjcrm.publics.utils.JsonUtil;
import com.hjcrm.publics.utils.PageBean;
import com.hjcrm.publics.utils.UserContext;
import com.hjcrm.system.bean.User;
import com.hjcrm.system.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class UserController {
    @Autowired
    private UserService userService;
    @RequestMapping("/system/userMang.do")
    public String userMang(){
        if (UserContext.getLoginUser()!=null){
            return JumpViewConstans.SYSTEM_USER_MANAGER;
        }

        return JumpViewConstans.SYSTEM_LOGIN;
    }
    /*
    * 查询所有用户
    * */
    @RequestMapping("/system/userlist.do")
    @ResponseBody
    public String userList(Integer currentPage,Integer pageSize){
        PageBean pb=new PageBean();
        pb.setCurrentPage((currentPage-1)*pageSize);
        pb.setPageSize(pageSize);


        List<User> list=userService.queryUserList(pb);
        pb.setCurrentPage(currentPage);
        pb.setCountResult(userService.queryAllUserCount());
        return  JsonUtil.jsonToPage(list, pb);
    }
    /*
     * 添加或者修改用户
     * */
    @RequestMapping("/system/saveOrUpdate")
    @ResponseBody
    public String saveOrUpdate(User user){
        int row=userService.saveOrUpdate(user);
        if (row>0){
            return "success";
        }else {
            return JumpViewConstans.SYSTEM_INDEX;
        }
    }
    /*
     * 删除用户
     * */
    @RequestMapping("/system/deleteUser.do")
    @ResponseBody
    public String deleteUser(String ids){
        int row =userService.deleteUser(ids);
        if(row>0){
            return  "success";
        }
        return JumpViewConstans.SYSTEM_INDEX;
    }
}

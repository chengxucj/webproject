package com.hjcrm.system.controllers.system;

import com.hjcrm.publics.utils.UserContext;
import com.hjcrm.system.bean.User;
import com.hjcrm.publics.constants.JumpViewConstans;
import com.hjcrm.system.service.impl.UserServiceImpl;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import sun.security.provider.MD5;

@Controller
public class UserControl {
    @Autowired
    private UserServiceImpl userService;
    @RequestMapping("/loginView.do")
    public String logining(){
        return "system/login";
    }
    /*
     * 登录验证
     * */
    @RequestMapping("/login.do")
    public String login(String email,String password,String sign,Model model){

        if(StringUtils.isNotBlank(email)&&StringUtils.isNotBlank(password)){
            User user = userService.findUserByemail(email+sign);
            if(user==null){
                model.addAttribute("msg","1");
                return JumpViewConstans.SYSTEM_LOGIN;
            }

            if (userService.login(new User(user.getUserid(),password))==null){
                model.addAttribute("msg", "2");
                return JumpViewConstans.SYSTEM_LOGIN;
            }

            UserContext.setLoginUser(user);
            return "redirect:main.do";
        }
        return JumpViewConstans.SYSTEM_LOGIN;


    }
    @RequestMapping("/logout.do")
    public String loginout(){
        UserContext.clearLoginUser();
        return JumpViewConstans.SYSTEM_LOGIN;
    }
    /*
     * 修改密码
     * */
    @RequestMapping("/system/editPassword.do")
    public @ResponseBody String editPassword(String newPassword,String oldPassword,int userid){

        if(userService.queryPwdByid(oldPassword,userid)!=null){
           if(userService.editPassword(newPassword,userid)>0){
               return "success";
           }

       }
        return "3";
    }

}

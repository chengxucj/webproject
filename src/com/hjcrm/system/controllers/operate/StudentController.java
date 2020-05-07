package com.hjcrm.system.controllers.operate;

import com.hjcrm.publics.constants.JumpViewConstans;
import com.hjcrm.publics.utils.UserContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class StudentController {
    @RequestMapping("/student/studentMang.do")
    public String studentMang(){
        if(UserContext.getLoginUser()!=null){
            return JumpViewConstans.OPERATE_STUDENTMANG;
        }
        return JumpViewConstans.SYSTEM_INDEX;
    }


}

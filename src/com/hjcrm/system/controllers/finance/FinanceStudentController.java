package com.hjcrm.system.controllers.finance;

import com.hjcrm.publics.constants.JumpViewConstans;
import com.hjcrm.publics.utils.JsonUtil;
import com.hjcrm.publics.utils.PageBean;
import com.hjcrm.publics.utils.UserContext;
import com.hjcrm.system.bean.Student;
import com.hjcrm.system.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class FinanceStudentController {
    @Autowired
    private StudentService studentService;
    @RequestMapping("/finance/financeStudentMang.do")
    public String accountStudent(){
        if(UserContext.getLoginUser()!=null){
            return JumpViewConstans.FINANACE_STUDENTMANG;
        }
        return JumpViewConstans.SYSTEM_INDEX;
    }
    @RequestMapping("/report/queryStudentscaiwu.do")
    public @ResponseBody String queryStudentscaiwu(int userid,int deptid,int roleid,Integer currentPage,Integer pageSize){
        PageBean pb=new PageBean();
        pb.setCurrentPage((currentPage-1)*pageSize);
        pb.setPageSize(pageSize);
        List<Student> list=studentService.queryYesStudentMatchinfo(pb);
        if(list.size()>0){
            pb.setCurrentPage(currentPage);
            pb.setPageSize(studentService.queryCountYesStudent());
            return JsonUtil.jsonToPage(list,null);
        }
        return JumpViewConstans.NUll_Page;
    }

}

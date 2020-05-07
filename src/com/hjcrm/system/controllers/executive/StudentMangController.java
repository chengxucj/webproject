package com.hjcrm.system.controllers.executive;

import com.hjcrm.publics.constants.JumpViewConstans;
import com.hjcrm.publics.utils.JsonUtil;
import com.hjcrm.publics.utils.PageBean;
import com.hjcrm.publics.utils.SplitIdsUtil;
import com.hjcrm.publics.utils.UserContext;
import com.hjcrm.system.bean.Student;
import com.hjcrm.system.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class StudentMangController {
    @Autowired
    private StudentService studentService;
    @RequestMapping("/executive/studentMang.do")
    public String studentMang(){
        if(UserContext.getLoginUser()!=null){
            return JumpViewConstans.EXECUTIVE_STUDENTMANG;
        }
        return JumpViewConstans.SYSTEM_INDEX;
    }

    @RequestMapping("/student/queryStudents.do")
    public @ResponseBody String queryStudents(int userid,int deptid,Integer currentPage,Integer pageSize){
        PageBean pb=new PageBean();
        pb.setCurrentPage((currentPage-1)*pageSize);
        pb.setPageSize(pageSize);
        List<Student> list=null;
        if(deptid==4){
            list=studentService.queryStudents(pb);
        }else{
            System.out.println("触发");
            list=studentService.querySalesStudents(pb);
        }
        if(list!=null){
            if(list.size()>0){
                pb.setCountResult(studentService.queryCountStudent());
                pb.setCurrentPage(currentPage);
                return JsonUtil.jsonToPage(list,pb);
            }
        }

        return JumpViewConstans.NUll_Page;
    }
    @RequestMapping("/student/returnStudent.do")
    public @ResponseBody String returnStudent(int userid,String resourceIds,String studentIds,String returnNote){
        Map<String,Object> map=new HashMap<>();
        map.put("list", SplitIdsUtil.SplitIdstoList(studentIds));
        map.put("returnNote",returnNote);
        int row=studentService.returnStudent(map);
        if(row>0){
            return "success";
        }
        return  "error";
    }
    @RequestMapping("/executive/accountStudent.do")
    public String accountStudent(){
        if(UserContext.getLoginUser()!=null){
            return JumpViewConstans.EXECUTIVE_ACCOUNTSTUDENT;
        }
        return JumpViewConstans.SYSTEM_INDEX;
    }
    @RequestMapping("/student/queryYesStudentMatchinfo")
    public @ResponseBody String queryYesStudentMatchinfo(int userid,int deptid,int roleid,Integer currentPage,Integer pageSize){
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
    @RequestMapping("/executive/colseCourse.do")
    public String colseCourse(){
        if(UserContext.getLoginUser()!=null){
            return JumpViewConstans.FINANACE_COLSECOURSE;
        }
        return JumpViewConstans.SYSTEM_INDEX;
    }
}

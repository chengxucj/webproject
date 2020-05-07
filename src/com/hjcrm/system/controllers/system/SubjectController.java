package com.hjcrm.system.controllers.system;

import com.hjcrm.publics.constants.JumpViewConstans;
import com.hjcrm.publics.utils.JsonUtil;
import com.hjcrm.publics.utils.PageBean;
import com.hjcrm.publics.utils.UserContext;
import com.hjcrm.system.bean.Subject;
import com.hjcrm.system.service.SubjectService;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class SubjectController {
    @Autowired
    private SubjectService subjectService;
    @RequestMapping("/system/subjectMang.do")
    public String  subjectMang(){
        if(UserContext.getLoginUser()!=null){
            return JumpViewConstans.SYSTEM_SUBJECT;
        }
        return JumpViewConstans.SYSTEM_INDEX;
    }
    /*
     * 查询所有科目
     * */
    @RequestMapping("/subject/querySubject.do")
    public @ResponseBody String querySubject(Integer currentPage,Integer pageSize,Integer courseid){
        Map<String,Integer> map=new HashMap<>();
        if(currentPage!=null && pageSize!=null){
            map.put("currentPage",((currentPage-1)*pageSize));
            map.put("pageSize",pageSize);
            List<Subject> list=subjectService.querySubject(map);
            if(list.size()>0){
                PageBean pageBean=new PageBean();
                pageBean.setCountResult(subjectService.queryCountSubject());
                pageBean.setCurrentPage(currentPage);
                return JsonUtil.jsonToPage(list,pageBean);
            }
        }
        if(courseid!=null){
            map.put("courseid",courseid);
            List<Subject> list=subjectService.querySubject(map);
            return JsonUtil.jsonToPage(list,null);
        }

        return "";
    }
    /*
     * 添加或者修改科目
     * */
    @RequestMapping("/subject/addOrUpdateSubject.do")
    public @ResponseBody String addOrUpdateSubject(Subject subject){
        if(subject.getCourseid()==null){
            return  "error";
        }
        if(subjectService.addOrUpdateSubject(subject)>0){
            return "success";
        }
        return "failed";
    }
    /*
     * 删除科目
     * */
    @RequestMapping("/subject/deleteSubject.do")
    public @ResponseBody String deleteSubject(String subjectids){
        if(StringUtils.isNotBlank(subjectids)){
            if(subjectService.deleteSubject(subjectids)>0){
                return "success";
            }
        }
        return "error";
    }
}

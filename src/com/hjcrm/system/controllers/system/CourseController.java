package com.hjcrm.system.controllers.system;

import com.hjcrm.publics.constants.JumpViewConstans;
import com.hjcrm.publics.utils.JsonUtil;
import com.hjcrm.publics.utils.PageBean;
import com.hjcrm.publics.utils.UserContext;
import com.hjcrm.system.bean.Course;
import com.hjcrm.system.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

@Controller
public class CourseController {
    @Autowired
    private CourseService courseService;
    @RequestMapping("/system/courseMang.do")
    public String courseMang(){
        if(UserContext.getLoginUser()!=null){
            return JumpViewConstans.SYSTEM_COURSE;
        }
        return "redirect:loginView.do";
    }
//    查询所有课程信息
    @RequestMapping("/course/queryCourse.do")
    public @ResponseBody String queryCourse(PageBean pb){
            PageBean pageBean=new PageBean();
            pageBean.setCurrentPage((pb.getCurrentPage()-1)*pb.getPageSize());
            pageBean.setPageSize(pb.getPageSize());
            List<Course> list=courseService.queryCourse(pageBean);

            pageBean.setCountResult(courseService.selectCountCourse());
            pageBean.setCurrentPage(pb.getCurrentPage());
            if(list.size()>0){
                return JsonUtil.jsonToPage(list,pageBean);
            }
            return JumpViewConstans.NUll_Page;
    }
    /*
    * 添加课程
    * */
    @RequestMapping("/course/addCourse.do")
    public @ResponseBody String saveOrUpdate(Course course){
        if(courseService.saveOrUpdate(course)>0){
            return "success";
        }
        return "erroe";
    }
    /*
     * 删除课程
     * */
    @RequestMapping("/course/deleteCourse.do")
    public @ResponseBody String deleteCourse(String courseids){
        //处理前端传递的id
        List<Integer> idlist=new ArrayList<>();
        for (String s:courseids.split(",")){
            int id=Integer.parseInt(s.split(" ")[0]);
            if(courseService.selectSubidByCourse(id)){
                return "1";
            }
            idlist.add(id);
        }
        if(idlist.size()>0){
            if(courseService.deleteCourse(idlist)>0) return "success";
        }
        return "删除失败";
    }
}

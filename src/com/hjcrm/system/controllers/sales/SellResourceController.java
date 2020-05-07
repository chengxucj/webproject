package com.hjcrm.system.controllers.sales;

import com.hjcrm.publics.constants.JumpViewConstans;
import com.hjcrm.publics.utils.JsonUtil;
import com.hjcrm.publics.utils.PageBean;
import com.hjcrm.publics.utils.SplitIdsUtil;
import com.hjcrm.publics.utils.UserContext;
import com.hjcrm.system.bean.Dealrecord;
import com.hjcrm.system.bean.Resource;
import com.hjcrm.system.bean.Student;
import com.hjcrm.system.service.DealrecordService;
import com.hjcrm.system.service.ResourceService;
import com.hjcrm.system.service.SellResourceService;
import com.hjcrm.system.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class SellResourceController {
    @Autowired
    private ResourceService resourceService;
    @Autowired
    private SellResourceService sellResourceService;
    @Autowired
    private DealrecordService ds;
    @Autowired
    private StudentService studentService;
    @RequestMapping("/sales/resourcesMang.do")
    public String resourcesMang(){

        if(UserContext.getLoginUser()!=null){
            return JumpViewConstans.SALES_RESOURCE;
        }
        return JumpViewConstans.SYSTEM_INDEX;
    }

    @RequestMapping("/sales/queryResource.do")
    public @ResponseBody String querySalesResource(int userid,int deptid,int roleid,Integer currentPage,Integer pageSize){
        Map<String,Integer> map=new HashMap<>();
        map.put("belongId",userid);
        map.put("deptid",deptid);
        map.put("currentPage",(currentPage-1)*pageSize);
        map.put("pageSize",pageSize);
        List<Resource> list=resourceService.querySalesResource(map);
        if(list.size()>0){
            PageBean pb=new PageBean();
            pb.setCurrentPage(currentPage);
            pb.setPageSize(resourceService.queryCountRes());
            return JsonUtil.jsonToPage(list,pb);
        }
        return JumpViewConstans.NUll_Page;

    }
    /*
     * 跳转详细信息页面
     * */
    @RequestMapping("/resource/details.do")
    public String details(int resourceId, Model model){
        if(UserContext.getLoginUser()!=null){
            List<Resource> resource = resourceService.selectDetailsResource(resourceId);
            if(resource!=null){
                model.addAttribute("record",sellResourceService.selectVisitrecord(resource.get(0).getResourceId()));
                model.addAttribute("resource",resource);
                return JumpViewConstans.SALES_DATAILS;
            }

        }

        return  JumpViewConstans.SYSTEM_INDEX;
    }
    /*
     * 添加成交记录
     * */
    @RequestMapping("/resource/addDealrecord.do")
    public @ResponseBody String addDealrecord(Student student,String subjects){
        if(subjects.indexOf(",")!=-1){
            return "1";
        }
        if(sellResourceService.addDealrecord(student,subjects)>0){
            return "success";
        }
        return "-1";
    }

    @RequestMapping("/sales/studentMang.do")
    public String studentMang(){
        if (UserContext.getLoginUser()!=null){
            return JumpViewConstans.SALES_STUDENTMANG;
        }
        return JumpViewConstans.SYSTEM_INDEX;
    }
    /*
     * 提交回行政部
     * */
    @RequestMapping("/student/studentCommit.do")
    public @ResponseBody String studentCommit(String studentIds){
        if(studentService.studentCommit(SplitIdsUtil.SplitIdstoList(studentIds))>0){
            return "success";
        }
        return "error";
    }
}

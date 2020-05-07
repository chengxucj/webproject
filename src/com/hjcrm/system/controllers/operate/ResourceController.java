package com.hjcrm.system.controllers.operate;

import com.hjcrm.publics.constants.JumpViewConstans;
import com.hjcrm.publics.utils.ExcelReaderUtil;
import com.hjcrm.publics.utils.JsonUtil;
import com.hjcrm.publics.utils.PageBean;
import com.hjcrm.publics.utils.UserContext;
import com.hjcrm.system.bean.Resource;
import com.hjcrm.system.bean.User;
import com.hjcrm.system.bean.Visitrecord;
import com.hjcrm.system.service.ResourceService;
import com.hjcrm.system.service.SellResourceService;
import com.hjcrm.system.service.UserService;
import org.quartz.utils.Key;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.FileInputStream;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.*;

@Controller
public class ResourceController {
    @Autowired
    private UserService userService;
    @Autowired
    private ResourceService resourceService;
    @RequestMapping("/resource/resourcesMang.do")
    public String resourcesMang(){

        if(UserContext.getLoginUser()!=null){
            return JumpViewConstans.RESOURCESMANG;
        }
        return JumpViewConstans.SYSTEM_INDEX;
    }


    /*
     * 查询资源
     * */
    @RequestMapping("/resource/queryResource.do")
    public @ResponseBody String queryResource(Integer userid,Integer deptid,int roleid,Integer currentPage,Integer pageSize){
        Map<String,Integer> map=new HashMap<>();
        map.put("currentPage",((currentPage-1)*pageSize));
        map.put("pageSize",pageSize);
        map.put("userId",userid);
        List<Resource> list=resourceService.queryResource(map);
        if(list.size()>0){
            PageBean pb=new PageBean();
            pb.setCurrentPage(currentPage);
            pb.setPageSize(resourceService.queryCountRes());
            return JsonUtil.jsonToPage(list,pb);
        }
        return "";
    }
    /*
     * 查询所有创建人
     * */
    @RequestMapping("/resource/queryAllCreatePerson.do")
    public @ResponseBody String queryAllCreatePerson(){
        List<User> list=userService.queryUserList(null);
        if(list.size()>0){
            return JsonUtil.jsonToPage(list,null);
        }
        return "null";
    }
    @Autowired
    private SellResourceService sellResourceService;
    @RequestMapping("/resource/addResource.do")
    public @ResponseBody String addResource(Resource resource, String visitRecord){
        if(resource.getDeptid()==2){
            if(resourceService.addOrUpdateResource(resource)>2){
                return "success";
            }
        }
        if(UserContext.getLoginUser()!=null){
            resource.setCreaterName(UserContext.getLoginUser().getUsername());
            resource.setUserid(UserContext.getLoginUser().getUserid());
            resource.setDeptid(UserContext.getLoginUser().getDeptid());
        }
        resource.setCreate_time(new Timestamp(new Date().getTime()));
        if(resourceService.addOrUpdateResource(resource)>0){
            if(visitRecord!=null){
                Visitrecord vd=new Visitrecord();
                vd.setUserid(resource.getUserid());
                vd.setResourceId(resource.getResourceId());
                vd.setVisitRecord(visitRecord);
                vd.setCreate_time(new Timestamp(new Date().getTime()));
                sellResourceService.addVisitrecord(vd);
            }

            return "success";
        }
        return "error";
    }
    /*
     * 查询所有销售部员工
     * */
    @RequestMapping("/resource/queryAllXiaoShou.do")
    public @ResponseBody String queryAllXiaoShou(){
        List<User> list=resourceService.queryAllXiaoShou(UserContext.getLoginUser().getDeptid());
        if(list.size()>0){
            return JsonUtil.jsonToPage(list,null);
        }
        return JumpViewConstans.NUll_Page;
    }
    /*
     *  分配资源
     * */
    @RequestMapping("/resource/assigntoResource.do")
    public @ResponseBody String assigntoResource(String resourceIds,int belongid,String states){
        for (String s:states.split(",")){
            if(Integer.parseInt(s)==1){
                return "16";
            }
            if(Integer.parseInt(s)==2){
                return "16";
            }
        }
        if(resourceService.assigntoResource(resourceIds,belongid)>0){
            return "success";
        }
        return "error";
    }
    /*
    * 资源修改
    * */
    @RequestMapping("/resource/deleteResources.do")
    public @ResponseBody String deleteResources(int userid,String resourceId){
        List<Integer> list=new ArrayList<>();
        if(userid!=UserContext.getLoginUser().getUserid()){
            return "6";
        }
        for (String s:resourceId.split(",")){
            if(resourceService.queryResourceState(Integer.parseInt(resourceId))!=null){
                if(resourceService.queryResourceState(Integer.parseInt(resourceId))==1 || resourceService.queryResourceState(Integer.parseInt(resourceId))==2){
                    return "8";
                }
            } else{
                list.add(Integer.parseInt(resourceId));
            }

        }
        if(resourceService.deleteResources(list)>0){
            return "success";
        }
        return "error";
    }

}

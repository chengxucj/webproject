package com.hjcrm.system.controllers.patter;

import com.hjcrm.publics.constants.JumpViewConstans;
import com.hjcrm.publics.utils.JsonUtil;
import com.hjcrm.publics.utils.UserContext;
import com.hjcrm.system.bean.PatterType;
import com.hjcrm.system.service.PatterTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class PatterTypeController {
    @Autowired
    private PatterTypeService pts;
    @RequestMapping("/system/patterType.do")
    public String patterType(){
        if(UserContext.getLoginUser()!=null){
            return  JumpViewConstans.PATTER_PATTERTYPE;
        }
        return JumpViewConstans.SYSTEM_INDEX;
    }
    @RequestMapping("/course/queryPattertype.do")
    public @ResponseBody String queryPattertype(){
        List<PatterType> list=pts.queryPattertype();
        if(list.size()>0){
            return JsonUtil.jsonToPage(list,null);
        }
        return JumpViewConstans.NUll_Page;
    }
    @RequestMapping("/course/addPattertype.do")
    public @ResponseBody String addOrupdatePattertype(PatterType patterType){
        if(pts.addOrupdatePattertype(patterType)>0){
            return "success";
        }
        return  "error";
    }
    @RequestMapping("/course/deletepatterType.do")
    public @ResponseBody String deletepatterType(String patterTypeIds){
        if(pts.deletepatterType(patterTypeIds)>0){
            return "success";
        }
        return  "error";
    }
}

package com.hjcrm.system.controllers.patter;

import com.hjcrm.publics.constants.JumpViewConstans;
import com.hjcrm.publics.utils.JsonUtil;
import com.hjcrm.publics.utils.UserContext;
import com.hjcrm.system.bean.Patter;
import com.hjcrm.system.bean.PatterType;
import com.hjcrm.system.service.MypatterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class MypatterController {
    @Autowired
    private MypatterService mypatterService;

    @RequestMapping("/patter/myPatter.do")
    public String myPatter(){
        if(UserContext.getLoginUser()!=null){
            return JumpViewConstans.PATTER_MYPATTER;
        }
        return JumpViewConstans.SYSTEM_INDEX;
    }

    @RequestMapping("/patter/queryPatter.do")
    public @ResponseBody
    String queryPattertype(Patter patter){
        List<Patter> list=mypatterService.queryPatter(patter);
        if(list.size()>0){
            return JsonUtil.jsonToPage(list,null);
        }
        return "null";
    }
    @RequestMapping("/patter/queryPattertype.do")
    public @ResponseBody String queryPattertypeType(Patter patter){
        List<PatterType> list=mypatterService.queryPatterType(patter);
            if(list.size()>0){
            return JsonUtil.jsonToPage(list,null);
        }
        return "null";
    }
    @RequestMapping("/patter/saveOrUpdatePatter.do")
    public @ResponseBody String saveOrUpdatePatter(Patter patter){
        if(mypatterService.saveOrUpdatePatter(patter)>0){
            return  "success";
        }
        return "error";
    }
    @RequestMapping("/patter/deletePatter.do")
    public @ResponseBody String deletePatter(String patterids,int userid){
        if(mypatterService.deletePatter(patterids,userid)>0){
            return "success";
        }
        return "error";
    }
    @RequestMapping("/patter/updatePatterIsShare.do")
    public @ResponseBody String updatePatterIsShare(int patterid){
        if(mypatterService.updatePatterIsShare(patterid)>0){
            return "success";
        }
        return "error";
    }
}

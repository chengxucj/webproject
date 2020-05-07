package com.hjcrm.system.controllers.system;

import com.hjcrm.publics.constants.JumpViewConstans;
import com.hjcrm.publics.utils.JsonUtil;
import com.hjcrm.publics.utils.PageBean;
import com.hjcrm.publics.utils.UserContext;
import com.hjcrm.system.bean.SysMessage;
import com.hjcrm.system.service.SysMessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

@Controller
public class SystemMsgController {
    @Autowired
    private SysMessageService sysMessageService;

    @RequestMapping("/system/systemMessage.do")
    public String systemMessage(){
        if(UserContext.getLoginUser()!=null){
            return JumpViewConstans.SYSTEM_MESSAGE;
        }
        return JumpViewConstans.SYSTEM_INDEX;
    }
    /*
     * 查询所有系统信息
     * */
    @RequestMapping("/system/querySystemmessages.do")
    public @ResponseBody String querySysmessages(int currentPage,int pageSize){
        PageBean pageBean=new PageBean();
        pageBean.setCurrentPage((currentPage-1)*pageSize);
        pageBean.setPageSize(pageSize);
        List<SysMessage> list=sysMessageService.querySysmessages(pageBean);
        if(list.size()>0){
            pageBean.setCountResult(sysMessageService.queryCountMsg());
            pageBean.setCurrentPage(currentPage);
            return JsonUtil.jsonToPage(list,pageBean);
        }
        return "error";
    }
    /*
     * 添加或者修改消息
     * */
    @RequestMapping("/system/saveOrUpdateMessage.do")
    public @ResponseBody String saveOrUpdateMessage(SysMessage sysMessage){
        if(sysMessageService.saveOrUpdateMessage(sysMessage)>0){
            return "success";
        }
        return "error";
    }
    /*
     * 发布消息
     * */
    @RequestMapping("/system/sendMessage.do")
    public @ResponseBody String sendMessage(SysMessage sysMessage){
        if(sysMessage.getIssend()==1){
            sysMessage.setSend_time(new Timestamp(new Date().getTime()));
        }else{
            sysMessage.setSend_time(null);
        }
        if(sysMessageService.sendMessage(sysMessage)>0){
            return "success";
        }
        return "error";
    }


}

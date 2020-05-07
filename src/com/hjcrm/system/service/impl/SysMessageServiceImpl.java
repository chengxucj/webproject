package com.hjcrm.system.service.impl;

import com.hjcrm.publics.utils.PageBean;
import com.hjcrm.system.bean.Dept;
import com.hjcrm.system.bean.Role;
import com.hjcrm.system.bean.SysMessage;
import com.hjcrm.system.dao.DeptDao;
import com.hjcrm.system.dao.RoleDao;
import com.hjcrm.system.dao.SysMessageDao;
import com.hjcrm.system.service.DeptService;
import com.hjcrm.system.service.SysMessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("sysMessageService")
public class SysMessageServiceImpl implements SysMessageService {
    @Autowired
    private SysMessageDao sysMessageDao;
    @Override
    public List<SysMessage> querySysmessages(PageBean pageBean) {
        return sysMessageDao.querySysmessages(pageBean);
    }

    @Override
    public int queryCountMsg() {
        return sysMessageDao.queryCountMsg();
    }

    @Override
    public int saveOrUpdateMessage(SysMessage sysMessage) {
       if(sysMessage.getSystemmessageId()!=0){
           return sysMessageDao.upteSysMessage(sysMessage);
       }else{
           return sysMessageDao.saveSysMessage(sysMessage);
       }
    }

    @Override
    public int sendMessage(SysMessage sysMessage) {
        return sysMessageDao.sendMessage(sysMessage);
    }
}

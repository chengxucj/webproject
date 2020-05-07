package com.hjcrm.system.dao;

import com.hjcrm.publics.utils.PageBean;
import com.hjcrm.system.bean.Course;
import com.hjcrm.system.bean.SysMessage;

import java.util.List;

public interface SysMessageDao {
    List<SysMessage> querySysmessages(PageBean pageBean);
    int queryCountMsg();
    int saveSysMessage(SysMessage sysMessage);
    int upteSysMessage(SysMessage sysMessage);
    int sendMessage(SysMessage sysMessage);
}

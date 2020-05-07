package com.hjcrm.system.service;

import com.hjcrm.publics.utils.PageBean;
import com.hjcrm.system.bean.Menu;
import com.hjcrm.system.bean.SysMessage;

import java.util.List;

public interface SysMessageService {
    List<SysMessage> querySysmessages(PageBean pageBean);
    int queryCountMsg();
    int saveOrUpdateMessage(SysMessage sysMessage);
    int sendMessage(SysMessage sysMessage);
}

package com.hjcrm.system.service.impl;

import com.hjcrm.system.bean.Dealrecord;
import com.hjcrm.system.dao.DealrecordDao;
import com.hjcrm.system.service.DealrecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("dealrecordService")
public class DealrecordServiceImpl implements DealrecordService {
    @Autowired
    private DealrecordDao dealrecordDao;
    @Override
    public int addDealrecord(Dealrecord dealrecord) {
        return dealrecordDao.addDealrecord(dealrecord);
    }
}

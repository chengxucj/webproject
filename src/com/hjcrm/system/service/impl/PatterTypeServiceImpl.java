package com.hjcrm.system.service.impl;

import com.hjcrm.publics.utils.SplitIdsUtil;
import com.hjcrm.system.bean.PatterType;
import com.hjcrm.system.dao.PatterTypeDao;
import com.hjcrm.system.service.PatterTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service("patterTypeService")
public class PatterTypeServiceImpl implements PatterTypeService {
    @Autowired
    private PatterTypeDao patterTypeDao;
    @Override
    public List<PatterType> queryPattertype() {
        return patterTypeDao.queryPattertype();
    }

    @Override
    public int addOrupdatePattertype(PatterType patterType) {
        if(patterType.getPatterTypeId()!=0){
            return patterTypeDao.updatePattertype(patterType);
        }else{
            return patterTypeDao.addPattertype(patterType);
        }
    }

    @Override
    public int deletepatterType(String patterTypeIds) {
        List<Integer> list = SplitIdsUtil.SplitIdstoList(patterTypeIds);

        return patterTypeDao.deletepatterType(list);
    }
}

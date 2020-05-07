package com.hjcrm.system.service.impl;

import com.hjcrm.publics.utils.SplitIdsUtil;
import com.hjcrm.system.bean.Patter;
import com.hjcrm.system.bean.PatterType;
import com.hjcrm.system.dao.MyPatterDao;
import com.hjcrm.system.service.MypatterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service("mypatterService")
public class MypatterServiceImpl implements MypatterService {
    @Autowired
    private MyPatterDao myPatterDao;
    @Override
    public List<Patter> queryPatter(Patter patter) {
        return myPatterDao.queryPatter(patter);
    }

    @Override
    public List<PatterType> queryPatterType(Patter patter) {
        return myPatterDao.queryPatterType(patter);
    }

    @Override
    public int saveOrUpdatePatter(Patter patter) {
        if(patter.getPatterid()!=0){
            return  myPatterDao.updatePatter(patter);
        }else{
            return  myPatterDao.addPatter(patter);
        }
    }

    @Override
    public int deletePatter(String patterids, int userid) {
        List<Integer> list=SplitIdsUtil.SplitIdstoList(patterids);

        return myPatterDao.deletePatter(list,userid);
    }

    @Override
    public int updatePatterIsShare(int patterid) {
        return myPatterDao.updatePatterIsShare(patterid);
    }

}

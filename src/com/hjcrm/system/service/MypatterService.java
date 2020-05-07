package com.hjcrm.system.service;

import com.hjcrm.system.bean.Patter;
import com.hjcrm.system.bean.PatterType;

import java.util.List;

public interface MypatterService {
    List<Patter> queryPatter(Patter patter);
    List<PatterType> queryPatterType(Patter patter);
    int saveOrUpdatePatter(Patter patter);

    int deletePatter(String patterids,int userid);

    int updatePatterIsShare(int patterid);
}

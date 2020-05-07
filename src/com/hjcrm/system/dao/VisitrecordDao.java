package com.hjcrm.system.dao;

import com.hjcrm.system.bean.Visitrecord;

import java.util.List;

public interface VisitrecordDao {
    int addVisitrecord(Visitrecord visitrecord);
    List<Visitrecord> selectVisitrecord(int rid);
}

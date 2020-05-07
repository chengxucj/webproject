package com.hjcrm.system.service;

import com.hjcrm.system.bean.Dealrecord;
import com.hjcrm.system.bean.Student;
import com.hjcrm.system.bean.Visitrecord;

import java.util.List;

public interface SellResourceService {
    int addVisitrecord(Visitrecord visitrecord);
    List<Visitrecord> selectVisitrecord(int rid);
    int addDealrecord(Student student,String subjectid);
}

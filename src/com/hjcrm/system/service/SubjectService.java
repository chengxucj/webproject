package com.hjcrm.system.service;

import com.hjcrm.publics.utils.PageBean;
import com.hjcrm.system.bean.Subject;

import java.util.List;
import java.util.Map;

public interface SubjectService {

    List<Subject> querySubject(Map<String,Integer> map);
    int queryCountSubject();

    int addOrUpdateSubject(Subject subject);

    int deleteSubject(String ids);
}

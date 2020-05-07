package com.hjcrm.system.dao;

import com.hjcrm.publics.utils.PageBean;

import com.hjcrm.system.bean.Student;
import com.hjcrm.system.bean.Subject;

import java.util.List;
import java.util.Map;

public interface SubjectDao {
    List<Subject> querySubject(Map<String,Integer> map);
    int queryCountSubject();

    int addOrUpdateSubject2(Subject subject);

    int addOrUpdateSubject(Subject subject);
    Integer queryCourseIdBySubid(int subid);

    int deleteSubject(List<Integer> list);


}

package com.hjcrm.system.service;

import com.hjcrm.publics.utils.PageBean;
import com.hjcrm.system.bean.Student;

import java.util.List;
import java.util.Map;

public interface StudentService {
    List<Student> queryStudents(PageBean pageBean);

    int queryCountStudent();
    int returnStudent(Map<String,Object> map);

    List<Student> querySalesStudents(PageBean pb);
    int studentCommit(List<Integer> list);

    List<Student> queryYesStudentMatchinfo(PageBean pb);

    int queryCountYesStudent();
}

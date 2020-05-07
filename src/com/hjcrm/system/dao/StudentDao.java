package com.hjcrm.system.dao;

import com.hjcrm.publics.utils.PageBean;
import com.hjcrm.system.bean.Course;
import com.hjcrm.system.bean.Student;
import org.quartz.utils.Key;

import java.util.List;
import java.util.Map;

public interface StudentDao {
    int addStudent(Student student);
    int selectStudentidByRid(int rid);
    List<Student> queryStudents(PageBean pageBean);
    int returnStudent(Map<String,Object> map);

    int queryCountStudent();
    int studentCommit(List<Integer> list);
    List<Student> querySalesStudents(PageBean pb);

    List<Student> queryYesStudentMatchinfo(PageBean pb);
    int queryCountYesStudent();
}

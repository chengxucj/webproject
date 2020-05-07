package com.hjcrm.system.service.impl;

import com.hjcrm.publics.utils.PageBean;
import com.hjcrm.system.bean.Student;
import com.hjcrm.system.dao.StudentDao;
import com.hjcrm.system.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service("studentService")
public class StudentServiceImpl implements StudentService {
    @Autowired
    private StudentDao studentDao;
    @Override
    public List<Student> queryStudents(PageBean pageBean) {
        return studentDao.queryStudents(pageBean);
    }

    @Override
    public int queryCountStudent() {
        return studentDao.queryCountStudent();
    }

    @Override
    public int returnStudent(Map<String, Object> map) {
        return studentDao.returnStudent(map);
    }

    @Override
    public List<Student> querySalesStudents(PageBean pb) {
        return studentDao.querySalesStudents(pb);
    }

    @Override
    public int studentCommit(List<Integer> list) {
        return studentDao.studentCommit(list);
    }

    @Override
    public List<Student> queryYesStudentMatchinfo(PageBean pb) {
        return studentDao.queryYesStudentMatchinfo(pb);
    }

    @Override
    public int queryCountYesStudent() {
        return studentDao.queryCountYesStudent();
    }
}

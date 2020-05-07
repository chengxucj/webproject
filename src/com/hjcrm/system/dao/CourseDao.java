package com.hjcrm.system.dao;

import com.hjcrm.publics.utils.PageBean;
import com.hjcrm.system.bean.Course;
import com.hjcrm.system.bean.Dept;

import java.util.List;

public interface CourseDao {
    List<Course> queryCourse(PageBean pb);
    int selectCountCourse();
    int saveCourse(Course course);
    int updateCourse(Course course);

    int deleteCourse(List<Integer> idlist);
    List<Integer> selectSubidByCourse(int courseid);
}

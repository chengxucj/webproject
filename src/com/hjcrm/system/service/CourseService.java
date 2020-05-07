package com.hjcrm.system.service;

import com.hjcrm.publics.utils.PageBean;
import com.hjcrm.system.bean.Course;

import java.util.List;

public interface CourseService {
    List<Course> queryCourse(PageBean pb);
    int selectCountCourse();
    int saveOrUpdate(Course course);

    int deleteCourse(List<Integer> idlist);
    boolean selectSubidByCourse(int courseid);
}

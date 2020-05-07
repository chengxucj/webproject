package com.hjcrm.system.service.impl;

import com.hjcrm.publics.utils.PageBean;
import com.hjcrm.system.bean.Course;
import com.hjcrm.system.dao.CourseDao;
import com.hjcrm.system.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service("courseService")
public class CourserServiceImpl implements CourseService {
    @Autowired
    private CourseDao courseDao;
    @Override
    public List<Course> queryCourse(PageBean pb) {
        return courseDao.queryCourse(pb);
    }

    @Override
    public int selectCountCourse() {
        return courseDao.selectCountCourse();
    }

    @Override
    public int saveOrUpdate(Course course) {
        if(course.getCourseid()!=0){
            return  courseDao.updateCourse(course);
        }else{
            return courseDao.saveCourse(course);
        }
    }

    @Override
    public int deleteCourse(List<Integer> idlist) {
        return courseDao.deleteCourse(idlist);
    }

    @Override
    public boolean selectSubidByCourse(int courseid) {
        System.out.println(courseDao.selectSubidByCourse(courseid));
        return courseDao.selectSubidByCourse(courseid).size()>0;
    }
}

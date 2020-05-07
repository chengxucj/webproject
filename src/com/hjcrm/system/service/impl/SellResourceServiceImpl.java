package com.hjcrm.system.service.impl;

import com.hjcrm.system.bean.Dealrecord;
import com.hjcrm.system.bean.Resource;
import com.hjcrm.system.bean.Student;
import com.hjcrm.system.bean.Visitrecord;
import com.hjcrm.system.dao.DealrecordDao;
import com.hjcrm.system.dao.ResourceDao;
import com.hjcrm.system.dao.StudentDao;
import com.hjcrm.system.dao.VisitrecordDao;
import com.hjcrm.system.service.ResourceService;
import com.hjcrm.system.service.SellResourceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

@Service("sellResourceService")
public class SellResourceServiceImpl implements SellResourceService {
    @Autowired
    private ResourceDao resourceDao;
    @Autowired
    private VisitrecordDao visitrecordDao;
    @Autowired
    private StudentDao  studentDao;
    @Autowired
    private DealrecordDao  dealrecordDao;
    @Override
    public int addVisitrecord(Visitrecord visitrecord) {
        return visitrecordDao.addVisitrecord(visitrecord);
    }

    @Override
    public List<Visitrecord> selectVisitrecord(int rid) {
        return visitrecordDao.selectVisitrecord(rid);
    }

    @Override
    public int addDealrecord(Student student, String subjectid) {
        //修改状态
        if(resourceDao.updateStateById(student.getResourceId())>0){
            Resource resource=resourceDao.queryResourceByid(student.getResourceId());
            student.setQq(resource.getQq());
            student.setWeixin(resource.getWeixin());
            student.setTel(resource.getTel());
            student.setPhone(resource.getPhone());
            student.setCourseid(resource.getResourceId());
            student.setBelongid(resource.getBelongid());
            student.setStudentName(resource.getResourceName());
            student.setPhone(resource.getPhone());
            student.setAddress(resource.getAddress());
            student.setSex(resource.getSex());
            student.setSource(resource.getSource());
            student.setCourseid(resource.getCourseid());
            student.setResourceLevel(resource.getResourceLevel());
            student.setIdCard(resource.getIdCard());
            student.setEmail(resource.getEmail());
            student.setXiaoShouNote(resource.getXiaoShouNote());
            System.out.println(student);
            //添加学员
            if(studentDao.addStudent(student)>0){
                //添加成交信息
                Dealrecord dealrecord=new Dealrecord();
                dealrecord.setResourceId(student.getResourceId());
                dealrecord.setStudentId(studentDao.selectStudentidByRid(student.getResourceId()));
                dealrecord.setCourseid(student.getCourseid());
                dealrecord.setSubjectid(Integer.parseInt(subjectid));
                dealrecord.setUserid(student.getUserid());
                dealrecord.setCreate_time(new Timestamp(new Date().getTime()));

                return dealrecordDao.addDealrecord(dealrecord);
            }
        }

        return 0;
    }

}

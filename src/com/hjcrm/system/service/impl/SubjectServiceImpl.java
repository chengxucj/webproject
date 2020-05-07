package com.hjcrm.system.service.impl;

import com.hjcrm.publics.utils.PageBean;
import com.hjcrm.publics.utils.SplitIdsUtil;
import com.hjcrm.system.bean.Subject;
import com.hjcrm.system.dao.SubjectDao;
import com.hjcrm.system.service.SubjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service("subjectService")
public class SubjectServiceImpl implements SubjectService {
    @Autowired
    private SubjectDao subjectDao;
    @Override
    public List<Subject> querySubject(Map<String,Integer> map) {
        return subjectDao.querySubject(map);
    }

    @Override
    public int queryCountSubject() {
        return subjectDao.queryCountSubject();
    }

    @Override
    public int addOrUpdateSubject(Subject subject) {
        if(subject.getSubjectid()!=0){
            return subjectDao.addOrUpdateSubject2(subject);
        }else{
            return subjectDao.addOrUpdateSubject(subject);
        }
    }

    @Override
    public int deleteSubject(String ids) {
        List<Integer> list=SplitIdsUtil.SplitIdstoList(ids);
        return  subjectDao.deleteSubject(list);
    }


}

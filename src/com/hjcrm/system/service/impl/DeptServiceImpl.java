package com.hjcrm.system.service.impl;

import com.hjcrm.publics.utils.PageBean;
import com.hjcrm.system.bean.Dept;
import com.hjcrm.system.bean.Role;
import com.hjcrm.system.dao.DeptDao;
import com.hjcrm.system.dao.RoleDao;
import com.hjcrm.system.service.DeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service("deptService")
public class DeptServiceImpl implements DeptService {
    @Autowired
    private DeptDao deptDao;

    @Autowired
    private RoleDao roleDao;
    @Override
    public List<Dept> selectDepts() {
        return deptDao.queryDeptList();
    }

    @Override
    public List<Role> queryRoleBydeptid(int did) {
        return roleDao.queryRoleByDeptid(did);
    }

    @Override
    public List<Dept> queryDepts(PageBean pb) {
        return deptDao.findDepts(pb);
    }

    @Override
    public int queryCountDept() {
        return deptDao.queryCountDept();
    }

    @Override
    public int saveOrUpdate(Dept dept) {
        if(dept.getDeptid()!=0){
            return  deptDao.saveOrUpdate2(dept);
        }else {
            return deptDao.saveOrUpdate(dept);
        }
    }

    @Override
    public int deleteDept(List<Integer> list) {
        return deptDao.deleteDept(list);
    }

    @Override
    public boolean selectRoleBydeptid(int deptid) {
        return deptDao.selectRoleBydeptid(deptid)!=null;
    }
}

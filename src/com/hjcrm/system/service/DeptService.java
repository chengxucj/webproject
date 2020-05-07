package com.hjcrm.system.service;

import com.hjcrm.publics.utils.PageBean;
import com.hjcrm.system.bean.Dept;
import com.hjcrm.system.bean.Role;

import java.util.List;

public interface DeptService {
    List<Dept> selectDepts();
    List<Role> queryRoleBydeptid(int did);
    List<Dept> queryDepts(PageBean pb);
    int queryCountDept();
    int saveOrUpdate(Dept dept);
    int deleteDept(List<Integer> list);
    boolean selectRoleBydeptid(int deptid);
}


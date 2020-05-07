package com.hjcrm.system.dao;

import com.hjcrm.publics.utils.PageBean;
import com.hjcrm.system.bean.Dept;
import com.hjcrm.system.bean.User;

import java.util.List;

public interface DeptDao {
    List<Dept> queryDeptList();
    List<Dept> findDepts(PageBean pb);
    int queryCountDept();
    int saveOrUpdate(Dept dept);
    int saveOrUpdate2(Dept dept);
    int deleteDept(List<Integer> list);
    Integer selectRoleBydeptid(int deptid);
}

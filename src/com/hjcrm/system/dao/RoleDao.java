package com.hjcrm.system.dao;

import com.hjcrm.publics.utils.PageBean;
import com.hjcrm.system.bean.Role;
import com.hjcrm.system.bean.RoleForMenu;

import java.util.List;
import java.util.Map;

public interface RoleDao {
    List<Role> queryRoleByDeptid(int did);
    List<Role> queryAllRole(PageBean pageBean);
    int queryCountRole();
    int addOrUpdateRole(Role role);
    int addOrUpdateRole2(Role role);
    int deleteRole(List<Integer> list);
    int deleteRoleMenu(List<Integer> list);
    int deleteRolMenuByRid(int roleid);
    int addRoleMenu(RoleForMenu roleForMenu);
}

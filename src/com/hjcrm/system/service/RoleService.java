package com.hjcrm.system.service;

import com.hjcrm.system.bean.Role;
import com.hjcrm.system.bean.RoleForMenu;

import java.util.List;


public interface RoleService {
    List<Role> queryAllRole(Integer currentPage,Integer pageSize);
    int queryCountRole();
    int addOrUpdateRole(Role role);
    int deleteRole(String ids);
    int deleteRolMenuByRid(String roleid);
    int addRoleMenu(RoleForMenu roleForMenu);
}

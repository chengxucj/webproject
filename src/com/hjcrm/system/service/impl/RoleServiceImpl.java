package com.hjcrm.system.service.impl;

import com.hjcrm.publics.utils.PageBean;
import com.hjcrm.publics.utils.SplitIdsUtil;
import com.hjcrm.system.bean.Role;
import com.hjcrm.system.bean.RoleForMenu;
import com.hjcrm.system.dao.RoleDao;
import com.hjcrm.system.service.RoleService;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service("roleService")
public class RoleServiceImpl implements RoleService {
    @Autowired
    private RoleDao roleDao;

    @Override
    public List<Role> queryAllRole(Integer currentPage,Integer pageSize) {
        PageBean pb=new PageBean();
        pb.setCurrentPage((currentPage-1)*pageSize);
        pb.setPageSize(pageSize);
        return roleDao.queryAllRole(pb);
    }

    @Override
    public int queryCountRole() {
        return roleDao.queryCountRole();
    }

    @Override
    public int addOrUpdateRole(Role role) {
        if(role.getRoleid()!=0){
            return roleDao.addOrUpdateRole2(role);
        }else{
           return roleDao.addOrUpdateRole(role);
        }

    }

    @Override
    public int deleteRole(String ids) {
        List<Integer> list= SplitIdsUtil.SplitIdstoList(ids);
        if(roleDao.deleteRole(list)>0){
            return roleDao.deleteRoleMenu(list);
        }
        return -1;
    }

    @Override
    public int deleteRolMenuByRid(String roleid) {
        if(StringUtils.isNotBlank(roleid)){
            return roleDao.deleteRolMenuByRid(Integer.parseInt(roleid));
        }
        return 0;
    }

    @Override
    public int addRoleMenu(RoleForMenu roleForMenu) {
        return roleDao.addRoleMenu(roleForMenu);
    }

}

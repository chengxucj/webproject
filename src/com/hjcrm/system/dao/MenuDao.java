package com.hjcrm.system.dao;

import com.hjcrm.system.bean.Menu;
import com.hjcrm.system.bean.RoleForMenu;

import java.util.List;
import java.util.Map;

public interface MenuDao {
    List<Menu> queryMenus(Map<String,String> map);
    List<Menu> queryMenus2(Map<String,String> map);
    int addOrUpdateMenu(Menu menu);
    int deleteMenu(List<Integer> list);
    int addOrUpdateMenu2(Menu menu);
    List<Integer> selectMenupid(int id);
    List<Integer> selectRoleByMenu(int id);
}

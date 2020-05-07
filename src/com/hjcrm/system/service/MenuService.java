package com.hjcrm.system.service;

import com.hjcrm.publics.utils.PageBean;
import com.hjcrm.system.bean.Menu;

import java.util.List;

public interface MenuService {
    List<Menu> findMenus(String roleid);
    List<Menu> queryMenus();
    List<Menu> queryRoleMenus(String roleid);
    int addOrUpdateMenu(Menu menu);

    int delteMenu(List<Integer> list);
    boolean selectSecndMenuid(int id);
    boolean selectRoleByMenu(int id);
}

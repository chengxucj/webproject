package com.hjcrm.system.service.impl;

import com.hjcrm.publics.utils.SplitIdsUtil;
import com.hjcrm.system.bean.Menu;
import com.hjcrm.system.bean.RoleForMenu;
import com.hjcrm.system.dao.MenuDao;
import com.hjcrm.system.service.MenuService;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
@Service("menuService")
public class MenuServiceImpl implements MenuService {
    @Autowired
    private MenuDao menuDao;
    @Override
    public List<Menu> findMenus(String roleid) {
        Map<String,String> map= new HashMap<>();
        map.put("roleid",roleid);
        map.put("menuparaid","-1");
        List<Menu> menus = menuDao.queryMenus(map);
        for (Menu m:menus) {
           Map<String,String> pats=new HashMap<>();
            pats.put("roleid",roleid);
            pats.put("menuparaid",m.getMenuid()+"");
            List<Menu> secondMenus=menuDao.queryMenus(pats);
            m.setChildren(secondMenus);

        }

        return menus;
    }

    @Override
    public List<Menu> queryMenus() {
        Map<String,String> parmMap=new HashMap<>();
        parmMap.put("menuparaid","-1");
        List<Menu> menus = menuDao.queryMenus2(parmMap);
        for(Menu m:menus){
            parmMap.put("menuparaid",m.getMenuid()+"");
            List<Menu> sencendMenus= menuDao.queryMenus2(parmMap);
            if(sencendMenus.size()>0){
                m.setChildren(sencendMenus);
            }

        }
        return menus;
    }

    @Override
    public List<Menu> queryRoleMenus(String roleid) {
        Map<String,String> parmMap=new HashMap<>();
        parmMap.put("roleid",roleid);
        List<Menu> menus = menuDao.queryMenus2(parmMap);
        return menus;
    }

    @Override
    public int addOrUpdateMenu(Menu menu) {
        if(menu.getMenuid()>0){
            return menuDao.addOrUpdateMenu2(menu);
        }else{
            return menuDao.addOrUpdateMenu(menu);
        }

    }

    @Override
    public int delteMenu(List<Integer> list) {

        return menuDao.deleteMenu(list);
    }

    @Override
    public boolean selectSecndMenuid(int id) {
        for(int n:menuDao.selectMenupid(id)){
            if(n==-1){
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean selectRoleByMenu(int id) {
        return menuDao.selectRoleByMenu(id).size()>0;
    }
}

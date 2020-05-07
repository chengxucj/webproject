package com.hjcrm.system.bean;
/*
 * 角色和菜单关系
 * */
public class RoleForMenu {
    private int id;
    private int roleid;
    private int menuid;
    private int dr;

    public RoleForMenu() {
    }

    public RoleForMenu(int id, int roleid, int menuid, int dr) {
        this.id = id;
        this.roleid = roleid;
        this.menuid = menuid;
        this.dr = dr;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getRoleid() {
        return roleid;
    }

    public void setRoleid(int roleid) {
        this.roleid = roleid;
    }

    public int getMenuid() {
        return menuid;
    }

    public void setMenuid(int menuid) {
        this.menuid = menuid;
    }

    public int getDr() {
        return dr;
    }

    public void setDr(int dr) {
        this.dr = dr;
    }
}

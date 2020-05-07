package com.hjcrm.system.bean;

import java.sql.Timestamp;
/*
 * 用户
 * */
public class User {
    private int userid;//用户id
    private String username;//用户真实姓名
    private String nickname;//用户昵称
    private String password;//密码
    private String email;//邮箱
    private String userphoto;//头像
    private String phone;//手机号码
    private String mobile;//座机号码
    private int deptid;//部门ID
    private int roleid;//角色ID
    private int state;//'状态 0 可用  1不可用'
    private int sex;//性别  0男  1女
    private String wxopenid;//关联微信ID
    private String qqopenid;//关联QQID
    private int dr;//删除标志 0未删除 1已删除
    private Timestamp create_time;//创建时间
    private int create_id;//创建人
    private Timestamp update_time;//更新时间
    private int update_id;//更新人
    private String note;//备注
    private int ischange;//是否修改密码 0无1修改
    private int deptgroup;//

    private String rolename;
    private String deptname;
    public User() {

    }

    public User(int userid, String username, String nickname, String password, String email, String userphoto, String phone, String mobile, int deptid, int roleid, int state, int sex, String wxopenid, String qqopenid, int dr, Timestamp create_time, int create_id, Timestamp update_time, int update_id, String note, int ischange, int deptgroup) {
        this.userid = userid;
        this.username = username;
        this.nickname = nickname;
        this.password = password;
        this.email = email;
        this.userphoto = userphoto;
        this.phone = phone;
        this.mobile = mobile;
        this.deptid = deptid;
        this.roleid = roleid;
        this.state = state;
        this.sex = sex;
        this.wxopenid = wxopenid;
        this.qqopenid = qqopenid;
        this.dr = dr;
        this.create_time = create_time;
        this.create_id = create_id;
        this.update_time = update_time;
        this.update_id = update_id;
        this.note = note;
        this.ischange = ischange;
        this.deptgroup = deptgroup;
    }

    public User(int userid, String password) {
        this.userid=userid;
        this.password=password;
    }

    public int getUserid() {
        return userid;
    }

    public void setUserid(int userid) {
        this.userid = userid;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUserphoto() {
        return userphoto;
    }

    public void setUserphoto(String userphoto) {
        this.userphoto = userphoto;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public int getDeptid() {
        return deptid;
    }

    public void setDeptid(int deptid) {
        this.deptid = deptid;
    }

    public int getRoleid() {
        return roleid;
    }

    public void setRoleid(int roleid) {
        this.roleid = roleid;
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

    public int getSex() {
        return sex;
    }

    public void setSex(int sex) {
        this.sex = sex;
    }

    public String getWxopenid() {
        return wxopenid;
    }

    public void setWxopenid(String wxopenid) {
        this.wxopenid = wxopenid;
    }

    public String getQqopenid() {
        return qqopenid;
    }

    public void setQqopenid(String qqopenid) {
        this.qqopenid = qqopenid;
    }

    public int getDr() {
        return dr;
    }

    public void setDr(int dr) {
        this.dr = dr;
    }

    public Timestamp getCreate_time() {
        return create_time;
    }

    public void setCreate_time(Timestamp create_time) {
        this.create_time = create_time;
    }

    public int getCreate_id() {
        return create_id;
    }

    public void setCreate_id(int create_id) {
        this.create_id = create_id;
    }

    public Timestamp getUpdate_time() {
        return update_time;
    }

    public void setUpdate_time(Timestamp update_time) {
        this.update_time = update_time;
    }

    public int getUpdate_id() {
        return update_id;
    }

    public void setUpdate_id(int update_id) {
        this.update_id = update_id;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public int getIschange() {
        return ischange;
    }

    public void setIschange(int ischange) {
        this.ischange = ischange;
    }

    public int getDeptgroup() {
        return deptgroup;
    }

    public void setDeptgroup(int deptgroup) {
        this.deptgroup = deptgroup;
    }

    public String getRolename() {
        return rolename;
    }

    public void setRolename(String rolename) {
        this.rolename = rolename;
    }

    public String getDeptname() {
        return deptname;
    }

    public void setDeptname(String deptname) {
        this.deptname = deptname;
    }

    @Override
    public String toString() {
        return "User{" +
                "userid=" + userid +
                ", username='" + username + '\'' +
                ", nickname='" + nickname + '\'' +
                ", password='" + password + '\'' +
                ", email='" + email + '\'' +
                ", userphoto='" + userphoto + '\'' +
                ", phone='" + phone + '\'' +
                ", mobile='" + mobile + '\'' +
                ", deptid=" + deptid +
                ", roleid=" + roleid +
                ", state=" + state +
                ", sex=" + sex +
                ", wxopenid='" + wxopenid + '\'' +
                ", qqopenid='" + qqopenid + '\'' +
                ", dr=" + dr +
                ", create_time=" + create_time +
                ", create_id=" + create_id +
                ", update_time=" + update_time +
                ", update_id=" + update_id +
                ", note='" + note + '\'' +
                ", ischange=" + ischange +
                ", deptgroup=" + deptgroup +
                '}';
    }
}

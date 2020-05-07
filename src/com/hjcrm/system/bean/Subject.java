package com.hjcrm.system.bean;

import java.sql.Timestamp;
/*
 * 科目
 * */
public class Subject {
    private int subjectid; // bigint(20) NOT NULL AUTO_INCREMENT COMMENT '科目主键ID',
    private Integer courseid; // bigint(20) DEFAULT NULL COMMENT '所属课程ID',
    private String subjectname; // varchar(100) DEFAULT NULL COMMENT '科目名称',
    private String subjectcode; // varchar(50) DEFAULT NULL COMMENT '科目编码',
    private int create_id; // bigint(20) DEFAULT NULL COMMENT '创建人',
    private Timestamp create_time; // timestamp NULL DEFAULT NULL COMMENT '创建时间',
    private int update_id; // bigint(20) DEFAULT NULL COMMENT '修改人',
    private Timestamp update_time; // timestamp NULL DEFAULT NULL COMMENT '修改时间',
    private String note; // varchar(200) DEFAULT NULL COMMENT '备注',
    private int dr; // int(1) DEFAULT '0' COMMENT '删除标志 0未删除  1已删除',

    private String coursename;
    public Subject() {
       super();
    }

    public Subject(int subjectid, int courseid, String subjectname, String subjectcode, int create_id, Timestamp create_time, int update_id, Timestamp update_time, String note, int dr) {
        this.subjectid = subjectid;
        this.courseid = courseid;
        this.subjectname = subjectname;
        this.subjectcode = subjectcode;
        this.create_id = create_id;
        this.create_time = create_time;
        this.update_id = update_id;
        this.update_time = update_time;
        this.note = note;
        this.dr = dr;
    }

    public int getSubjectid() {
        return subjectid;
    }

    public void setSubjectid(int subjectid) {
        this.subjectid = subjectid;
    }

    public Integer getCourseid() {
        return courseid;
    }

    public void setCourseid(Integer courseid) {
        this.courseid = courseid;
    }

    public String getSubjectname() {
        return subjectname;
    }

    public void setSubjectname(String subjectname) {
        this.subjectname = subjectname;
    }

    public String getSubjectcode() {
        return subjectcode;
    }

    public void setSubjectcode(String subjectcode) {
        this.subjectcode = subjectcode;
    }

    public int getCreate_id() {
        return create_id;
    }

    public void setCreate_id(int create_id) {
        this.create_id = create_id;
    }

    public Timestamp getCreate_time() {
        return create_time;
    }

    public void setCreate_time(Timestamp create_time) {
        this.create_time = create_time;
    }

    public int getUpdate_id() {
        return update_id;
    }

    public void setUpdate_id(int update_id) {
        this.update_id = update_id;
    }

    public Timestamp getUpdate_time() {
        return update_time;
    }

    public void setUpdate_time(Timestamp update_time) {
        this.update_time = update_time;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public int getDr() {
        return dr;
    }

    public void setDr(int dr) {
        this.dr = dr;
    }

    public String getCoursename() {
        return coursename;
    }

    public void setCoursename(String coursename) {
        this.coursename = coursename;
    }
}

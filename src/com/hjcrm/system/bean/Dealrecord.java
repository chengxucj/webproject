package com.hjcrm.system.bean;

import java.sql.Timestamp;
/*
* 成交记录
* */
public class Dealrecord {
       private Integer dealrecordId;     //`dealrecordId` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '成交记录主键ID',
       private Integer resourceId;    // `resourceId` bigint(20) DEFAULT NULL COMMENT '资源ID',
       private Integer studentId;     //`studentId` bigint(20) DEFAULT NULL COMMENT '学员ID',
       private Integer courseid;     //`courseid` bigint(20) DEFAULT NULL COMMENT '课程ID',
       private Integer subjectid;    // `subjectid` bigint(20) DEFAULT NULL COMMENT '科目ID',
       private Integer userid;    // `userid` bigint(20) DEFAULT NULL COMMENT '创建人',
       private Timestamp create_time;     //`create_time` timestamp NULL DEFAULT NULL COMMENT '创建日期',
       private Integer update_id;     //`update_id` bigint(20) DEFAULT NULL COMMENT '修改人',
       private Timestamp update_time;    // `update_time` timestamp NULL DEFAULT NULL COMMENT '修改日期',
       private String note;     //`note` varchar(200) DEFAULT NULL COMMENT '备注',
       private Integer dr;    // `dr` int(1) DEFAULT '0' COMMENT '删除标志 0未删除  1已删除',
       private Timestamp scoretime;     //`scoretime` timestamp NULL DEFAULT NULL COMMENT '考试时间',
       private String score;    // `score` varchar(20) DEFAULT NULL COMMENT '考试成绩',
       private Integer ispass;     //`ispass` int(1) DEFAULT '0' COMMENT '是否通过 0未通过 1通过 2缺考',

    public Dealrecord() {
    }

    public Dealrecord(Integer dealrecordId, Integer resourceId, Integer studentId, Integer courseid, Integer subjectid, Integer userid, Timestamp create_time, Integer update_id, Timestamp update_time, String note, Integer dr, Timestamp scoretime, String score, Integer ispass) {
        this.dealrecordId = dealrecordId;
        this.resourceId = resourceId;
        this.studentId = studentId;
        this.courseid = courseid;
        this.subjectid = subjectid;
        this.userid = userid;
        this.create_time = create_time;
        this.update_id = update_id;
        this.update_time = update_time;
        this.note = note;
        this.dr = dr;
        this.scoretime = scoretime;
        this.score = score;
        this.ispass = ispass;
    }

    public Integer getDealrecordId() {
        return dealrecordId;
    }

    public Integer getResourceId() {
        return resourceId;
    }

    public Integer getStudentId() {
        return studentId;
    }

    public Integer getCourseid() {
        return courseid;
    }

    public Integer getSubjectid() {
        return subjectid;
    }

    public Integer getUserid() {
        return userid;
    }

    public Timestamp getCreate_time() {
        return create_time;
    }

    public Integer getUpdate_id() {
        return update_id;
    }

    public Timestamp getUpdate_time() {
        return update_time;
    }

    public String getNote() {
        return note;
    }

    public Integer getDr() {
        return dr;
    }

    public Timestamp getScoretime() {
        return scoretime;
    }

    public String getScore() {
        return score;
    }

    public Integer getIspass() {
        return ispass;
    }

    public void setDealrecordId(Integer dealrecordId) {
        this.dealrecordId = dealrecordId;
    }

    public void setResourceId(Integer resourceId) {
        this.resourceId = resourceId;
    }

    public void setStudentId(Integer studentId) {
        this.studentId = studentId;
    }

    public void setCourseid(Integer courseid) {
        this.courseid = courseid;
    }

    public void setSubjectid(Integer subjectid) {
        this.subjectid = subjectid;
    }

    public void setUserid(Integer userid) {
        this.userid = userid;
    }

    public void setCreate_time(Timestamp create_time) {
        this.create_time = create_time;
    }

    public void setUpdate_id(Integer update_id) {
        this.update_id = update_id;
    }

    public void setUpdate_time(Timestamp update_time) {
        this.update_time = update_time;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public void setDr(Integer dr) {
        this.dr = dr;
    }

    public void setScoretime(Timestamp scoretime) {
        this.scoretime = scoretime;
    }

    public void setScore(String score) {
        this.score = score;
    }

    public void setIspass(Integer ispass) {
        this.ispass = ispass;
    }

    @Override
    public String toString() {
        return "Dealrecord{" +
                "dealrecordId=" + dealrecordId +
                ", resourceId=" + resourceId +
                ", studentId=" + studentId +
                ", courseid=" + courseid +
                ", subjectid=" + subjectid +
                ", userid=" + userid +
                ", create_time=" + create_time +
                ", update_id=" + update_id +
                ", update_time=" + update_time +
                ", note='" + note + '\'' +
                ", dr=" + dr +
                ", scoretime=" + scoretime +
                ", score='" + score + '\'' +
                ", ispass=" + ispass +
                '}';
    }
}

package com.hack.graduation_project_system.domain;

import java.util.Date;

public class Project {
    private Integer projectid;

    private String projectname;

    private String need;

    private String submitid;

    private Boolean status;

    private Boolean choose;

    private Boolean specialproject;

    private Date time;

    private String contentfilename;

    public Project(Integer projectid, String projectname, String need, String submitid, Boolean status, Boolean choose, Boolean specialproject, Date time, String contentfilename) {
        this.projectid = projectid;
        this.projectname = projectname;
        this.need = need;
        this.submitid = submitid;
        this.status = status;
        this.choose = choose;
        this.specialproject = specialproject;
        this.time = time;
        this.contentfilename = contentfilename;
    }

    public Project() {
        super();
    }

    public Integer getProjectid() {
        return projectid;
    }

    public void setProjectid(Integer projectid) {
        this.projectid = projectid;
    }

    public String getProjectname() {
        return projectname;
    }

    public void setProjectname(String projectname) {
        this.projectname = projectname == null ? null : projectname.trim();
    }

    public String getNeed() {
        return need;
    }

    public void setNeed(String need) {
        this.need = need == null ? null : need.trim();
    }

    public String getSubmitid() {
        return submitid;
    }

    public void setSubmitid(String submitid) {
        this.submitid = submitid == null ? null : submitid.trim();
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    public Boolean getChoose() {
        return choose;
    }

    public void setChoose(Boolean choose) {
        this.choose = choose;
    }

    public Boolean getSpecialproject() {
        return specialproject;
    }

    public void setSpecialproject(Boolean specialproject) {
        this.specialproject = specialproject;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    public String getContentfilename() {
        return contentfilename;
    }

    public void setContentfilename(String contentfilename) {
        this.contentfilename = contentfilename == null ? null : contentfilename.trim();
    }
}
package com.hack.graduation_project_system.domain;

public class ProgressKey {
    private Integer studentid;

    private Integer projectid;

    public ProgressKey(Integer studentid, Integer projectid) {
        this.studentid = studentid;
        this.projectid = projectid;
    }

    public ProgressKey() {
        super();
    }

    public Integer getStudentid() {
        return studentid;
    }

    public void setStudentid(Integer studentid) {
        this.studentid = studentid;
    }

    public Integer getProjectid() {
        return projectid;
    }

    public void setProjectid(Integer projectid) {
        this.projectid = projectid;
    }
}
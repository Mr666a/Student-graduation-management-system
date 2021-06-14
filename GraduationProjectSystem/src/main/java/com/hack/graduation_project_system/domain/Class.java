package com.hack.graduation_project_system.domain;

public class Class {
    private String classid;

    private String classname;

    public Class(String classid, String classname) {
        this.classid = classid;
        this.classname = classname;
    }

    public Class() {
        super();
    }

    public String getClassid() {
        return classid;
    }

    public void setClassid(String classid) {
        this.classid = classid == null ? null : classid.trim();
    }

    public String getClassname() {
        return classname;
    }

    public void setClassname(String classname) {
        this.classname = classname == null ? null : classname.trim();
    }
}
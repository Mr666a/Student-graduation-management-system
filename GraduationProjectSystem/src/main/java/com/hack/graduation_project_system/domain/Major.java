package com.hack.graduation_project_system.domain;

public class Major {
    private String majorid;

    private String majorname;

    private Integer leaderid;

    public Major(String majorid, String majorname, Integer leaderid) {
        this.majorid = majorid;
        this.majorname = majorname;
        this.leaderid = leaderid;
    }

    public Major() {
        super();
    }

    public String getMajorid() {
        return majorid;
    }

    public void setMajorid(String majorid) {
        this.majorid = majorid == null ? null : majorid.trim();
    }

    public String getMajorname() {
        return majorname;
    }

    public void setMajorname(String majorname) {
        this.majorname = majorname == null ? null : majorname.trim();
    }

    public Integer getLeaderid() {
        return leaderid;
    }

    public void setLeaderid(Integer leaderid) {
        this.leaderid = leaderid;
    }
}
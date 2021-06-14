package com.hack.graduation_project_system.domain;

public class Teacher {
    private Integer teacherid;

    private String teachername;

    private String password;

    private String gender;

    private String phone;

    private String majorid;

    private String classid;

    public Teacher(Integer teacherid, String teachername, String password, String gender, String phone, String majorid, String classid) {
        this.teacherid = teacherid;
        this.teachername = teachername;
        this.password = password;
        this.gender = gender;
        this.phone = phone;
        this.majorid = majorid;
        this.classid = classid;
    }

    public Teacher() {
        super();
    }

    public Integer getTeacherid() {
        return teacherid;
    }

    public void setTeacherid(Integer teacherid) {
        this.teacherid = teacherid;
    }

    public String getTeachername() {
        return teachername;
    }

    public void setTeachername(String teachername) {
        this.teachername = teachername == null ? null : teachername.trim();
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender == null ? null : gender.trim();
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone == null ? null : phone.trim();
    }

    public String getMajorid() {
        return majorid;
    }

    public void setMajorid(String majorid) {
        this.majorid = majorid == null ? null : majorid.trim();
    }

    public String getClassid() {
        return classid;
    }

    public void setClassid(String classid) {
        this.classid = classid == null ? null : classid.trim();
    }
}
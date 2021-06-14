package com.hack.graduation_project_system.domain;

public class Leader {
    private Integer leaderid;

    private String leadername;

    private String password;

    private String gender;

    private String phone;

    private String majorid;

    private String role;

    public Leader(Integer leaderid, String leadername, String password, String gender, String phone, String majorid, String role) {
        this.leaderid = leaderid;
        this.leadername = leadername;
        this.password = password;
        this.gender = gender;
        this.phone = phone;
        this.majorid = majorid;
        this.role = role;
    }

    public Leader() {
        super();
    }

    public Integer getLeaderid() {
        return leaderid;
    }

    public void setLeaderid(Integer leaderid) {
        this.leaderid = leaderid;
    }

    public String getLeadername() {
        return leadername;
    }

    public void setLeadername(String leadername) {
        this.leadername = leadername == null ? null : leadername.trim();
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

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role == null ? null : role.trim();
    }
}
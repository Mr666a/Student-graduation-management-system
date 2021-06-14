package com.hack.graduation_project_system.domain;

public class Student {
    private Integer studentid;

    private String studentname;

    private String password;

    private String gender;

    private String majorid;

    private Integer projectid;

    private String classid;

    private Integer graduationdate;

    private String email;

    private String phone;

    private String id;

    private Integer grade;

    public Student(Integer studentid, String studentname, String password, String gender, String majorid, Integer projectid, String classid, Integer graduationdate, String email, String phone, String id, Integer grade) {
        this.studentid = studentid;
        this.studentname = studentname;
        this.password = password;
        this.gender = gender;
        this.majorid = majorid;
        this.projectid = projectid;
        this.classid = classid;
        this.graduationdate = graduationdate;
        this.email = email;
        this.phone = phone;
        this.id = id;
        this.grade = grade;
    }

    public Student() {
        super();
    }

    public Integer getStudentid() {
        return studentid;
    }

    public void setStudentid(Integer studentid) {
        this.studentid = studentid;
    }

    public String getStudentname() {
        return studentname;
    }

    public void setStudentname(String studentname) {
        this.studentname = studentname == null ? null : studentname.trim();
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

    public String getMajorid() {
        return majorid;
    }

    public void setMajorid(String majorid) {
        this.majorid = majorid == null ? null : majorid.trim();
    }

    public Integer getProjectid() {
        return projectid;
    }

    public void setProjectid(Integer projectid) {
        this.projectid = projectid;
    }

    public String getClassid() {
        return classid;
    }

    public void setClassid(String classid) {
        this.classid = classid == null ? null : classid.trim();
    }

    public Integer getGraduationdate() {
        return graduationdate;
    }

    public void setGraduationdate(Integer graduationdate) {
        this.graduationdate = graduationdate;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email == null ? null : email.trim();
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone == null ? null : phone.trim();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public Integer getGrade() {
        return grade;
    }

    public void setGrade(Integer grade) {
        this.grade = grade;
    }
}
package com.hack.graduation_project_system.pojo;

import org.springframework.stereotype.Component;

@Component
public class ProjectInfo {
    private Integer id;
    private String pName;
    //教师名字
    private String tName;
    //课题创建时间
    private String pDate;
    private String pLast;
    private String need;
    private String description;
    //是否被选择
    private boolean choice;

    private String file;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getpName() {
        return pName;
    }

    public void setpName(String pName) {
        this.pName = pName;
    }

    public String gettName() {
        return tName;
    }

    public void settName(String tName) {
        this.tName = tName;
    }

    public String getpDate() {
        return pDate;
    }

    public void setpDate(String pDate) {
        this.pDate = pDate;
    }

    public String getpLast() {
        return pLast;
    }

    public void setpLast(String pLast) {
        this.pLast = pLast;
    }

    public boolean isChoice() {
        return choice;
    }

    public void setChoice(boolean choice) {
        this.choice = choice;
    }

    public String getNeed() {
        return need;
    }

    public void setNeed(String need) {
        this.need = need;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getFile() {
        return file;
    }

    public void setFile(String file) {
        this.file = file;
    }
}

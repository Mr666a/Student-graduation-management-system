package com.hack.graduation_project_system.domain;

public class Progress extends ProgressKey {
    private String contentfilename;

    public Progress(Integer studentid, Integer projectid, String contentfilename) {
        super(studentid, projectid);
        this.contentfilename = contentfilename;
    }

    public Progress() {
        super();
    }

    public String getContentfilename() {
        return contentfilename;
    }

    public void setContentfilename(String contentfilename) {
        this.contentfilename = contentfilename == null ? null : contentfilename.trim();
    }
}
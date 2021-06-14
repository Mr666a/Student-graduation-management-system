package com.hack.graduation_project_system.pojo;

import org.springframework.stereotype.Component;

import java.io.Serializable;

@Component
public class ProgressInfo implements Serializable {
    private int percentage;
    private String progressMsg;
    private Message message;

    public ProgressInfo() {

    }
    public ProgressInfo(int percentage, String progressMsg) {
        super();
        this.percentage = percentage;
        this.progressMsg = progressMsg;
    }

    public int getPercentage() {
        return percentage;
    }

    public void setPercentage(int percentage) {
        this.percentage = percentage;
    }

    public String getProgressMsg() {
        return progressMsg;
    }

    public void setProgressMsg(String progressMsg) {
        this.progressMsg = progressMsg;
    }

    public Message getMessage() {
        return message;
    }

    public void setMessage(Message message) {
        this.message = message;
    }
    public String toString(){
        return "Student [percentage=" + percentage +", progressMsg=" + progressMsg + ", message=" + message + "]";
    }

}

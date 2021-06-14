package com.hack.graduation_project_system.pojo;

import org.springframework.stereotype.Component;

import java.io.Serializable;

@Component
public class Message implements Serializable {
    private int mid;
    private String message;

    public int getMid() {
        return mid;
    }

    public void setMid(int mid) {
        this.mid = mid;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
    public String toString(){
        return "Message [mid=" + mid + ", message=" + message + "]";
    }
}

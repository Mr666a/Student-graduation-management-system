package com.hack.graduation_project_system.Utils;

import org.springframework.stereotype.Component;

/**
 * 返回状态类
 * status:200 msg:success
 * status:201 msg:noExist 用户不存在
 * status:202 msg:errorPwd 密码错误
 */
@Component
public class Tips {
    private Integer status;
    private String msg;

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}

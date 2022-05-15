package com.spb.houqin.admin.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import com.spb.houqin.common.base.DataEntity;

import java.util.Date;


@TableName("login_log")
public class LoginLog extends DataEntity<LoginLog> {
    @TableField("ip")
    private String ip;

    @TableField("login_time")
    private Date loginTime;

    @TableField("login_name")
    private String loginName;

    @TableField("msg")
    private String msg;

    @TableField("reason")
    private String reason;

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public Date getLoginTime() {
        return loginTime;
    }

    public void setLoginTime(Date loginTime) {
        this.loginTime = loginTime;
    }

    public String getLoginName() {
        return loginName;
    }

    public void setLoginName(String loginName) {
        this.loginName = loginName;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }
}

package com.spb.houqin.admin.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import com.spb.houqin.common.base.DataEntity;

import java.util.Date;


@TableName("operation_log")
public class OperationLog extends DataEntity<OperationLog> {
    @TableField("user_name")
    private String userName;

    @TableField("action_time")
    private Date actionTime;

    @TableField("action")
    private String action;

    @TableField("msg")
    private String msg;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Date getActionTime() {
        return actionTime;
    }

    public void setActionTime(Date actionTime) {
        this.actionTime = actionTime;
    }

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}

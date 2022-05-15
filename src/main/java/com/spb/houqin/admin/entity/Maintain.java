package com.spb.houqin.admin.entity;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.FieldStrategy;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import com.spb.houqin.common.base.DataEntity;

import java.util.Date;


@TableName("sys_maintain")
public class Maintain extends DataEntity<Maintain> {
    /** 编号 */
    @TableField("number")
    private String number;

    /** 地点 */
    @TableField("place")
    private String place;

    /** 类型 */
    @TableField("type")
    private String type;

    /** 状态 */
    @TableField("satus")
    private String satus;

    /** 处理时间 */
    @TableField("handle_time")
    private Date handleTime;

    @TableField(exist = false)
    private String handleTimeStr;

    /** 维修工名 */
    @TableField("username")
    private String username;

    /** 工人id */
    @TableField("userid")
    private String userid;

    /** 普通员工 */
    @TableField("username2")
    private String username2;

    /** 员工id */
    @TableField("userid2")
    private String userid2;

    /** 评分 */
    @TableField("score")
    private String score;

    /** 评论 */
    @TableField("evaluate")
    private String evaluate;

    @TableField("remark2")
    private String  remark2;

    @TableField("img")
    private String  img;

    @TableField("toolname")
    private String toolname;

    @TableField("toolid")
    private String toolid;

    @TableField("amount")
    private String  amount;

    @TableField(exist = false)
    private String roleName;

    //备注
    @TableField(strategy= FieldStrategy.IGNORED)
    protected String remarks;

    @Override
    public String getRemarks() {
        return remarks;
    }

    @Override
    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    /**
     * 创建日期
     */
    @TableField(value = "create_date", fill = FieldFill.INSERT)
    protected Date createDate;

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getSatus() {
        return satus;
    }

    public void setSatus(String satus) {
        this.satus = satus;
    }

    public Date getHandleTime() {
        return handleTime;
    }

    public void setHandleTime(Date handleTime) {
        this.handleTime = handleTime;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid;
    }

    public String getUsername2() {
        return username2;
    }

    public void setUsername2(String username2) {
        this.username2 = username2;
    }

    public String getUserid2() {
        return userid2;
    }

    public void setUserid2(String userid2) {
        this.userid2 = userid2;
    }

    public String getScore() {
        return score;
    }

    public void setScore(String score) {
        this.score = score;
    }

    public String getEvaluate() {
        return evaluate;
    }

    public void setEvaluate(String evaluate) {
        this.evaluate = evaluate;
    }

    public String getRemark2() {
        return remark2;
    }

    public void setRemark2(String remark2) {
        this.remark2 = remark2;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public String getToolname() {
        return toolname;
    }

    public void setToolname(String toolname) {
        this.toolname = toolname;
    }

    public String getToolid() {
        return toolid;
    }

    public void setToolid(String toolid) {
        this.toolid = toolid;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public String getHandleTimeStr() {
        return handleTimeStr;
    }

    public void setHandleTimeStr(String handleTimeStr) {
        this.handleTimeStr = handleTimeStr;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }
}

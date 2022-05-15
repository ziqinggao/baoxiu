package com.spb.houqin.admin.entity;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import com.spb.houqin.common.base.DataEntity;
import com.spb.houqin.common.util.MD5Util;

import java.util.Date;


@TableName("user")
public class User extends DataEntity<User> {
    @TableField("user_name")
    private String userName;

    @TableField("login_name")
    private String loginName;

    @TableField("password")
    private String password;

    @TableField("phone")
    private String phone;

    @TableField("role_name")
    private String roleName;

    @TableField("sex")
    private String sex;

    @TableField("age")
    private Integer age;

    @TableField("locked")
    private Boolean locked;

//    @TableField(exist = false)
//    private String remarks;


    private static String remarks;

        /**
     * 创建日期
     */
    @TableField(value = "create_date", fill = FieldFill.INSERT)
    protected Date createDate;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getLoginName() {
        return loginName;
    }

    public void setLoginName(String loginName) {
        this.loginName = loginName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Boolean getLocked() {
        return locked;
    }

    public void setLocked(Boolean locked) {
        this.locked = locked;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }
}

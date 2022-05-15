package com.spb.houqin.admin.entity;


import com.spb.houqin.common.util.MD5Util;

public class Password {

    private String oldPassword;

    private String newPassword;

    private String ensurePassword;

    public String getOldPassword() {

        return oldPassword;
    }

    public void setOldPassword(String oldPassword) {
        this.oldPassword = oldPassword;
    }

    public String getNewPassword() {
        return newPassword;
    }

    public void setNewPassword(String newPassword) {
        this.newPassword = newPassword;
    }

    public String getEnsurePassword() {
        return ensurePassword;
    }

    public void setEnsurePassword(String ensurePassword) {
        this.ensurePassword = ensurePassword;
    }
}

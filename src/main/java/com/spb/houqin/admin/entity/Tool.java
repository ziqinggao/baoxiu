package com.spb.houqin.admin.entity;

import com.baomidou.mybatisplus.annotation.*;
import com.spb.houqin.common.base.DataEntity;

import java.util.Date;

@TableName("sys_tool")
public class Tool extends DataEntity<Tool> {
    /** 数量 */



    @TableField("amount")
    private String amount;

    /** 工具名 */
    @TableField("name")
    private String name;

    @TableField("money")
    private String money;

    @TableField("img")
    private String img;

    @TableField(strategy= FieldStrategy.IGNORED)
    protected String remarks;

    //    //规避plus long数变更为int主键
//    @TableId(type = IdType.AUTO)
//    private Integer id;


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

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMoney() {
        return money;
    }

    public void setMoney(String money) {
        this.money = money;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }
}

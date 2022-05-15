package com.spb.houqin.admin.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import com.spb.houqin.common.base.DataEntity;

import java.math.BigDecimal;


@TableName("statistics")
public class Statistics extends DataEntity<Statistics> {

    @TableField("money")
    private BigDecimal money;

    public BigDecimal getMoney() {
        return money;
    }

    public void setMoney(BigDecimal money) {
        this.money = money;
    }
}

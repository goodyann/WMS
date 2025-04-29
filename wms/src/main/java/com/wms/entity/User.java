package com.wms.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName("user")
public class User {
    @TableField("id")
    private int id;

    @TableField("no")
    private String no;

    @TableField("name")
    private String name;

    @TableField("password")
    private String password;

    @TableField("age")
    private int age;

    @TableField("sex")
    private int sex;

    @TableField("phone")
    private String phone;

    @TableField("role_id")
    private int roleId;

    @TableField("is_valid")
    private String isValid;
}

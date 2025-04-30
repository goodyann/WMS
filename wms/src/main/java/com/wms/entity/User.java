package com.wms.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
@TableName("user")
public class User {
    @JsonProperty("id")
    private Integer id;

    @JsonProperty("no")
    private String no;

    @JsonProperty("name")
    private String name;

    @JsonProperty("password")
    private String password;

    @JsonProperty("age")
    private Integer age;

    @JsonProperty("sex")
    private Integer sex;

    @JsonProperty("phone")
    private String phone;

    @TableField("role_id")
    @JsonProperty("role_id")
    private Integer roleId;

    @TableField("is_valid")
    @JsonProperty("is_valid")
    private String isValid;
}

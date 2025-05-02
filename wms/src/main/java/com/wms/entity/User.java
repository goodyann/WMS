package com.wms.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 
 * </p>
 *
 * @author wms
 * @since 2025-05-01
 */
@Data
@EqualsAndHashCode(callSuper = false)
@ApiModel(value="UserObject", description="")
public class User implements Serializable {
    public String getName() {
        return name; // write this setter method cause it seems lombok getName() does not work.
    }

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "Primary Key")
    @TableId(value = "id", type = IdType.AUTO)
    @JsonProperty("id")
    private Integer id;

    @ApiModelProperty(value = "Account")
    @JsonProperty("no")
    private String no;

    @JsonProperty("name")
    @ApiModelProperty(value = "Name")
    private String name;

    @JsonProperty("password")
    @ApiModelProperty(value = "Password")
    private String password;

    @JsonProperty("age")
    private Integer age;

    @ApiModelProperty(value = "Gender")
    @JsonProperty("sex")
    private Integer sex;

    @ApiModelProperty(value = "Phone number")
    @JsonProperty("phone")
    private String phone;

    @JsonProperty("role_id")
    private Integer roleId;

    @JsonProperty("is_valid")
    private String isValid;


}

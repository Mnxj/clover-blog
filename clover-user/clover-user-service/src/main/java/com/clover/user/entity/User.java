package com.clover.user.entity;


import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;

@Data
@TableName("user")
public class User implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value="ID",type = IdType.AUTO)
    private Long id;

    @TableField("USERNAME")
    private String username;

    @TableField("ROLE_CODE")
    private String roleCode;

    @TableField("URL")
    private String url;

    @TableField(value = "AUTOGRAPH")
    private String autograph;


}

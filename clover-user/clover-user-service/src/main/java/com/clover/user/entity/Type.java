package com.clover.user.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;

/**
 * @ClassName: Type
 * @Description:
 * @Author: Clover
 * @Date: 2021.04.18
 * Version: 1.0
 */
@Data
@TableName("type")
public class Type implements Serializable {
    private static final long serialVersionUID = 1L;

    @TableId(value="ID",type = IdType.AUTO)
    private Integer id;

    @TableField("TYPENAME")
    private String typename;
}

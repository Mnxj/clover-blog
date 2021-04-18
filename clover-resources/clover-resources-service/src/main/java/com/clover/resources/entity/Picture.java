package com.clover.resources.entity;

import lombok.Data;

import java.io.Serializable;

/**
 * @ClassName: Picture
 * @Description: 页面背景基本信息
 * @Author: Clover
 * @Date: 2021.04.15
 * Version: 1.0
 */

@Data
public class Picture implements Serializable {

    private String id;

    private String name;

    private String url;
}

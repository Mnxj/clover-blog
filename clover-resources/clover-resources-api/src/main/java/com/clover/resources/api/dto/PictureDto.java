package com.clover.resources.api.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import java.io.Serializable;

/**
 * @ClassName: PictureDto
 * @Description:
 * @Author: Clover
 * @Date: 2021.04.15
 * Version: 1.0
 */
@ApiModel(value = "PictureDto", description = "页面背景基本信息")
@Data
public class PictureDto implements Serializable {
    private static final long serialVersionUID = 1L;
    @ApiModelProperty("id")
    private String id;
    @ApiModelProperty("主题名字")
    private String name;
    @ApiModelProperty("图片地址")
    private String url;
}

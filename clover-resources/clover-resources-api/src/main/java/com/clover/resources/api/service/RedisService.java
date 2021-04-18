package com.clover.resources.api.service;

import com.clover.resources.api.dto.PictureDto;

import java.util.List;

/**
 * @ClassName: RedisSerivce
 * @Description:
 * @Author: Clover
 * @Date: 2021.04.15
 * Version: 1.0
 */
public interface RedisService {
    /**
     * 查询所有的背景图
     */
    List<Object> getAllPictureUrl();

    /**
     * 查询具体信息
     */
    String getPictureUrl(String id);
    /**
     * 修改背景信息
     */
    Boolean setPictureUrl(String id, PictureDto pictureVo);

    /**
     *设置更新消息
     */
    Boolean setStr(String id,String value);
    /**
     *获取更新消息
     */
    String getStr(String id);
    /**
     *添加访客记录
     */
    Boolean setVisitorCount(String day);
    /**
     *添加用户记录
     */
    Boolean setUserCount(String day);
    /**
     *获取访问记录
     */
    List<Object> getCount();
}

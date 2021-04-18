package com.clover.resources.service;


import com.clover.common.cache.Cache;
import com.clover.common.util.AWeekUtil;
import com.clover.common.util.DateUtil;
import com.clover.common.util.PictureUrlUtil;
import com.clover.resources.api.dto.PictureDto;
import com.clover.resources.api.service.RedisService;
import com.clover.resources.convert.PictureConvert;
import com.clover.resources.entity.Picture;
import org.apache.dubbo.config.annotation.Service;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 * @ClassName: RedisSerivce
 * @Description:
 * @Author: Clover
 * @Date: 2021.04.15
 * Version: 1.0
 */
@Service
public class RedisServiceImpl implements RedisService {
    @Autowired
    private Cache cache;

    @Override
    public List<Object> getAllPictureUrl() {
        List<Object> list = new ArrayList<>();
        for (PictureUrlUtil pictureUrlUtil : PictureUrlUtil.values()) {
            list.add(cache.hmget(pictureUrlUtil.getName()));
        }
        return list;
    }

    @Override
    public String getPictureUrl(String id) {
        Map<String, Object> hmget = (Map<String, Object>) cache.hmget(id);
        return (String) hmget.get("url");
    }

    @Override
    public Boolean setPictureUrl(String id, PictureDto pictureVo) {
        Picture picture = PictureConvert.INSTANCE.dto2entity(pictureVo);
        Map<String, Object> m1 = new HashMap<>();
        m1.put("id", picture.getId());
        m1.put("name", picture.getName());
        m1.put("url", picture.getUrl());
        return cache.hmset(id, m1);
    }

    @Override
    public Boolean setStr(String id, String value) {
        if (value == null) return false;
        cache.set(id, value);
        return cache.expire(id, 60 * 60 * 24 * 7);
    }

    @Override
    public String getStr(String id) {
        return cache.get(id);
    }

    @Override
    public Boolean setVisitorCount(String day) {
        String dayWeek = getDayWeek(day);
        int i = Integer.parseInt(getVisitorCount(dayWeek,"vCount"));
        return cache.hmset(dayWeek,"vCount",String.valueOf(i+1),0);
    }


    /**
     * 因为是操作redis，所以需要先把原数据查询出来，然后修改在加进入
     *
     * @param day
     * @return
     */
    @Override
    public Boolean setUserCount(String day) {
        String dayWeek = getDayWeek(day);
        int i = Integer.parseInt(getVisitorCount(dayWeek,"uCount"));
        return cache.hmset(dayWeek,"uCount",String.valueOf(i+1),0);
    }

    @Override
    public List<Object> getCount() {
        List<Object> list = new ArrayList<>();
        for (AWeekUtil pictureUrlUtil : AWeekUtil.values()) {
            list.add(cache.hmget(pictureUrlUtil.getName()));
        }
        return list;
    }
    // ==================================================Method=============================================


    /**
     * 根据枚举查询对应的名字
     *
     * @param day
     * @return
     */
    private String getDayWeek(String day) {
        StringBuffer sb = new StringBuffer();
        sb.append("DAY_");
        sb.append(DateUtil.getWeek(day));
        return AWeekUtil.valueOf(sb.toString()).getName();
    }

    private String getVisitorCount(String day,String data) {
        Object hget = cache.hget(day, data);
        if (hget==null){
            cache.hmset(day,getMap(day));
            hget = cache.hget(day, data);
        }
        return getCount(String.valueOf(hget));
    }

    private Map<String, Object> getMap(String day) {
        Map<String, Object> m1 = new HashMap<>();
        m1.put("id", day);
        m1.put("uCount", "0");
        m1.put("vCount", "0");
        return  m1;
    }

    private String getCount(String count) {
        if (count==null){
            return "0";
        }else{
            return count;
        }
    }
}

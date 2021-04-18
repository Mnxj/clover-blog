package com.clover.application.controller;

import com.clover.resources.api.dto.PictureDto;
import com.clover.resources.api.service.RedisService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @ClassName: RedisController
 * @Description: redis控制层
 * @Author: Clover
 * @Date: 2021.04.13
 * Version: 1.0
 */
@Slf4j
@RestController
@Api(description = "redis操作")
@RequestMapping("/redis/")
public class RedisController {
    @Reference
    RedisService serivce;
    //================================================背景图===============================================
    @ApiOperation("查询所有的背景图")
    @GetMapping("getAllPictureUrl")
    public List<Object> getAllPictureUrl() {
        return serivce.getAllPictureUrl();
    }
    @ApiOperation("查询具体信息")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "每个指定背景的id", required = true, dataType = "String", paramType = "path"),
    })
    @GetMapping("getPictureUrl/{id}")
    public String getPictureUrl(@PathVariable("id")String id) {
        return serivce.getPictureUrl(id);
    }
    @ApiOperation("修改背景信息")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "每个指定背景的id", required = true, dataType = "String", paramType = "path"),
            @ApiImplicitParam(name = "pictureVo", value = "具体详细参数", required = true, dataType = "String", paramType = "query"),
    })
    @PostMapping("setPictureUrl/{id}")
    public Boolean setPictureUrl(@PathVariable("id") String id,@RequestBody PictureDto pictureVo) {
       return serivce.setPictureUrl(id,pictureVo);
    }

    //================================================更新内容显示===============================================
    @ApiOperation("查询更新信息")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "id", required = true, dataType = "String", paramType = "path"),
    })
    @GetMapping("getStr/{id}")
    public String getStr(@PathVariable("id")String id) {
        return serivce.getStr(id);
    }
    @ApiOperation("更新信息")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "id", required = true, dataType = "String", paramType = "path"),
            @ApiImplicitParam(name = "value", value = "更新信息", required = true, dataType = "String", paramType = "query"),
    })
    @PostMapping("setStr/{id}")
    public Boolean setStr(@PathVariable("id")String id,String value) {

        return serivce.setStr(id,value);
    }
    //================================================浏览记录===============================================
    @ApiOperation("设置访客记录")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "day", value = "今天的日期", required = true, dataType = "String", paramType = "path"),
    })
    @GetMapping("setVisitorCount/{day}")
    public Boolean setVisitorCount(@PathVariable("day")String day) {
        return serivce.setVisitorCount(day);
    }
    @ApiOperation("设置用户记录")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "day", value = "今天的日期", required = true, dataType = "String", paramType = "path"),
    })
    @GetMapping("setUserCount/{day}")
    public Boolean setUserCount(@PathVariable("day")String day) {
        return serivce.setUserCount(day);
    }
    @ApiOperation("查询所有记录")
    @GetMapping("getCount")
    public List<Object> getCount() {
        return serivce.getCount();
    }
    //================================================浏览记录===============================================
//    @PostMapping("/sString")
//    public Set<String> sString(String key, String value) {
//        List<String> list=new ArrayList<>();
//        for (int i=0;i<10;i++){
//            list.add(RandomUuidUtil.getUUID());
//        }
//        cache.sSetAndTime("1025",60, JSONObject.toJSONString(list));
//        return cache.sGet("1025");
//    }


}


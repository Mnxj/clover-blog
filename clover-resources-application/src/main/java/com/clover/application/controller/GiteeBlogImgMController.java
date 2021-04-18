package com.clover.application.controller;


import com.clover.common.util.EncryptUtil;
import com.clover.common.util.RandomUuidUtil;
import com.clover.common.util.Result;
import com.clover.common.util.ResultUtil;
import com.clover.resources.api.service.GiteeBlogImgService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.HashMap;
import java.util.Map;


/**
 * @ClassName: GiteeBlogImgMController
 * @Description: 码云博客图床管理接口
 * @Author: Clover
 * @Date: 2021.04.12
 * Version: 1.0
 */
@Slf4j
@RestController
@Api(description = "码云博客图床管理接口")
@RequestMapping("/api/")
public class GiteeBlogImgMController {
    @Reference
    GiteeBlogImgService giteeBlogImgService;
    @PostMapping("saveImg")
    @ResponseBody

    public Result<Map<String, Object>> saveImg(@RequestParam( value= "file",required=false) MultipartFile file) throws Exception {
        String trueFileName = file.getOriginalFilename();
        String paramImgFile = EncryptUtil.encodeBase64(file.getBytes());
        return giteeBlogImgService.saveImg(trueFileName,paramImgFile);
    }
    @ApiOperation("查询所有的背景图")
    @GetMapping("refreshPage")
    @ResponseBody
    public Result<Map<String, Object>> refreshPage(){
        return giteeBlogImgService.refreshPage();
    }
}

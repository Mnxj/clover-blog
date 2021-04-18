package com.clover.application.controller;

import com.clover.user.api.UserService;
import com.clover.user.api.dto.UserDTO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


/**
 * @ClassName: UserController
 * @Description: 用户信息控制层
 * @Author: Clover
 * @Date: 2021.03.27
 * Version: 1.0
 */
@Api(value = "clover-用户", tags = "clover-用户", description = "clover-用户")
@RestController
public class UserController {
    @Reference
    private UserService service;

    @ApiOperation("商户创建应用")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "app", value = "应用信息", required = true, dataType = "int", paramType = "body")})
    @PostMapping(value = "/my/{x}/{y}")
    public int createApp(@PathVariable("x") int x,@PathVariable("y") int y){
        return  x/y;
    }

    @ApiOperation("用户创建")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "user", value = "用户信息", required = true, dataType = "UserDTO", paramType = "body")})
    @PostMapping(value = "/register")
    public UserDTO createApp(@RequestBody UserDTO userDTO){
        userDTO.setId(1111L);
        System.out.println(userDTO);
        return  service.createUser(userDTO);
    }
//    @ApiOperation("查询")
//    @PostMapping(value = "/select")
//    public List<UserDTO> getUser(){
//        List<UserDTO> list = service.list();
//        return list;
//    }

}

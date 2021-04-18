package com.clover.user;

import com.alibaba.fastjson.JSONObject;
import com.clover.user.api.dto.UserDTO;
import com.clover.user.convert.UserConvert;
import com.clover.user.entity.User;
import com.clover.user.mapper.UserMapper;
import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import java.util.List;

/**
 * @ClassName: MapperTest
 * @Description:
 * @Author: Clover
 * @Date: 2021.03.28
 * Version: 1.0
 */
@SpringBootTest
public class MapperTest {
    @Resource
    private UserMapper mapper;
}

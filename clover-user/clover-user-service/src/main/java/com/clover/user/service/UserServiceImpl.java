package com.clover.user.service;



import com.clover.common.domain.BusinessException;
import com.clover.user.api.UserService;
import com.clover.user.api.dto.UserDTO;
import com.clover.user.convert.UserConvert;
import com.clover.user.entity.User;
import com.clover.user.mapper.UserMapper;
import lombok.extern.slf4j.Slf4j;

import org.apache.dubbo.config.annotation.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author clover
 * @since 2021-03-28
 */
@Slf4j
@Service
@Transactional
public class UserServiceImpl implements UserService {
    @Autowired
    UserMapper mapper;

    @Override
    public UserDTO createUser(UserDTO userDTO) throws BusinessException {
        User user = UserConvert.INSTANCE.dto2entity(userDTO);
        int insert = mapper.insert(user);
        return insert==1?userDTO:new UserDTO();
    }
}

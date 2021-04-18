package com.clover.user.api;

import com.clover.common.domain.BusinessException;
import com.clover.user.api.dto.UserDTO;

/**
 * @InterfaceName: UserService
 * @Description: 用户服务类
 * @Author: Clover
 * @Date: 2021.03.28
 * Version: 1.0
 */
public interface UserService {
    /**
     * 添加用户
     * @param userDTO
     * @return
     * @throws BusinessException
     */
    UserDTO createUser(UserDTO userDTO) throws BusinessException;
}

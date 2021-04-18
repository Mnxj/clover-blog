package com.clover.user.convert;

import com.clover.user.api.dto.UserDTO;
import com.clover.user.entity.User;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

/**
 * @ClassName: UserConvert
 * @Description: Type conversion
 * @Author: Clover
 * @Date: 2021.03.28
 * Version: 1.0
 */
@Mapper
public interface UserConvert {
    UserConvert INSTANCE = Mappers.getMapper(UserConvert.class);
    UserDTO entity2dto(User user);
    User dto2entity(UserDTO user);

    List<UserDTO> entitylist2dto(List<User>  users);

    List<User> dtoList2entity(List<UserDTO>  userDTOS);

}

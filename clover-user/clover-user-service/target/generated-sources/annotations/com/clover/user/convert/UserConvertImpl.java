package com.clover.user.convert;

import com.clover.user.api.dto.UserDTO;
import com.clover.user.entity.User;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2021-03-28T21:21:10+0800",
    comments = "version: 1.3.0.Final, compiler: javac, environment: Java 1.8.0_271 (Oracle Corporation)"
)
public class UserConvertImpl implements UserConvert {

    @Override
    public UserDTO entity2dto(User user) {
        if ( user == null ) {
            return null;
        }

        UserDTO userDTO = new UserDTO();

        userDTO.setId( user.getId() );
        userDTO.setUsername( user.getUsername() );
        userDTO.setRoleCode( user.getRoleCode() );
        userDTO.setUrl( user.getUrl() );
        userDTO.setAutograph( user.getAutograph() );

        return userDTO;
    }

    @Override
    public User dto2entity(UserDTO user) {
        if ( user == null ) {
            return null;
        }

        User user1 = new User();

        user1.setId( user.getId() );
        user1.setUsername( user.getUsername() );
        user1.setRoleCode( user.getRoleCode() );
        user1.setUrl( user.getUrl() );
        user1.setAutograph( user.getAutograph() );

        return user1;
    }

    @Override
    public List<UserDTO> entitylist2dto(List<User> users) {
        if ( users == null ) {
            return null;
        }

        List<UserDTO> list = new ArrayList<UserDTO>( users.size() );
        for ( User user : users ) {
            list.add( entity2dto( user ) );
        }

        return list;
    }

    @Override
    public List<User> dtoList2entity(List<UserDTO> userDTOS) {
        if ( userDTOS == null ) {
            return null;
        }

        List<User> list = new ArrayList<User>( userDTOS.size() );
        for ( UserDTO userDTO : userDTOS ) {
            list.add( dto2entity( userDTO ) );
        }

        return list;
    }
}

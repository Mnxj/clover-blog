package com.clover.user.convert;


import com.clover.user.api.dto.TypeDTO;
import com.clover.user.entity.Type;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

/**
 * @InterfaceName: TypeConvert
 * @Description:
 * @Author: Clover
 * @Date: 2021.04.18
 * Version: 1.0
 */
@Mapper
public interface TypeConvert {
    TypeConvert INSTANCE= Mappers.getMapper(TypeConvert.class);
    TypeDTO entity2dto(Type type);
    Type dto2entity(TypeDTO typeDTO);
}

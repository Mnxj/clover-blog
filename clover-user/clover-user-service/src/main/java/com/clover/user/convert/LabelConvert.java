package com.clover.user.convert;

import com.clover.user.api.dto.LabelDTO;
import com.clover.user.entity.Label;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

/**
 * @InterfaceName: LabelConvert
 * @Description:
 * @Author: Clover
 * @Date: 2021.04.18
 * Version: 1.0
 */
@Mapper
public interface LabelConvert {
    LabelConvert INSTANCE= Mappers.getMapper(LabelConvert.class);
    LabelDTO entity2dto(Label label);
    Label dto2entity(LabelDTO labelDTO);
}

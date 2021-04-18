package com.clover.resources.convert;

import com.clover.resources.api.dto.PictureDto;
import com.clover.resources.entity.Picture;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

/**
 * @ClassName: PictureConvert
 * @Description:
 * @Author: Clover
 * @Date: 2021.04.15
 * Version: 1.0
 */
@Mapper
public interface PictureConvert {
    PictureConvert  INSTANCE = Mappers.getMapper(PictureConvert.class);
    PictureDto entity2dto(Picture entity);
    Picture dto2entity(PictureDto dto);
    List<PictureDto> listentity2listdto(List<Picture> PlatformChannel);
}

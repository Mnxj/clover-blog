package com.clover.resources.convert;

import com.clover.resources.api.dto.PictureDto;
import com.clover.resources.entity.Picture;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2021-04-18T18:00:30+0800",
    comments = "version: 1.3.0.Final, compiler: javac, environment: Java 1.8.0_271 (Oracle Corporation)"
)
public class PictureConvertImpl implements PictureConvert {

    @Override
    public PictureDto entity2dto(Picture entity) {
        if ( entity == null ) {
            return null;
        }

        PictureDto pictureDto = new PictureDto();

        pictureDto.setId( entity.getId() );
        pictureDto.setName( entity.getName() );
        pictureDto.setUrl( entity.getUrl() );

        return pictureDto;
    }

    @Override
    public Picture dto2entity(PictureDto dto) {
        if ( dto == null ) {
            return null;
        }

        Picture picture = new Picture();

        picture.setId( dto.getId() );
        picture.setName( dto.getName() );
        picture.setUrl( dto.getUrl() );

        return picture;
    }

    @Override
    public List<PictureDto> listentity2listdto(List<Picture> PlatformChannel) {
        if ( PlatformChannel == null ) {
            return null;
        }

        List<PictureDto> list = new ArrayList<PictureDto>( PlatformChannel.size() );
        for ( Picture picture : PlatformChannel ) {
            list.add( entity2dto( picture ) );
        }

        return list;
    }
}

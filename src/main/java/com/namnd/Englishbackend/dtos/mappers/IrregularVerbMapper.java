package com.namnd.Englishbackend.dtos.mappers;

import com.namnd.Englishbackend.Utils.Utils;
import com.namnd.Englishbackend.dtos.IrregularVebDto;
import com.namnd.Englishbackend.models.IrregularVerb;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

/**
 * @author nam.nd
 * @created 10/04/2021 - 10:10 PM
 */

@Component
public class IrregularVerbMapper {

    public IrregularVerb toEntity(IrregularVebDto dto){
        Utils.trimStringValuesOfObject(dto);

        IrregularVerb entity = new IrregularVerb();
        BeanUtils.copyProperties(dto, entity);

        if(!Utils.isNullOrEmpty(dto.getId())){
            entity.setId(Utils.stringToLong(dto.getId()));
        }

        return entity;
    }

    public IrregularVebDto toDto(IrregularVerb entity){
        IrregularVebDto dto = new IrregularVebDto();

        BeanUtils.copyProperties(entity, dto);
        dto.setId(Utils.longToString(entity.getId()));

        return dto;
    }
}

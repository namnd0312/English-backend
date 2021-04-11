package com.namnd.Englishbackend.services;

import com.namnd.Englishbackend.dtos.IrregularVebDto;
import com.namnd.Englishbackend.models.IrregularVerb;

import java.util.List;

/**
 * @author nam.nd
 * @created 10/04/2021 - 9:59 PM
 */
public interface IrregularService {

    void create(IrregularVebDto dto);

    IrregularVebDto update(IrregularVebDto dto);

    void deleteById(String id);

    IrregularVebDto findById(String id);

    List<IrregularVebDto> findAll();

}

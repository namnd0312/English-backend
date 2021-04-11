package com.namnd.Englishbackend.services.impl;

import com.namnd.Englishbackend.dtos.IrregularVebDto;
import com.namnd.Englishbackend.dtos.mappers.IrregularVerbMapper;
import com.namnd.Englishbackend.models.IrregularVerb;
import com.namnd.Englishbackend.repositories.IrregularVebRepository;
import com.namnd.Englishbackend.services.IrregularService;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Comparator;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.util.stream.Collectors;

/**
 * @author nam.nd
 * @created 10/04/2021 - 10:01 PM
 */

@Service
@Transactional
public class IrregularServiceImpl implements IrregularService {

    private final Logger LOG = LoggerFactory.getLogger(IrregularServiceImpl.class);

    @Autowired
    private IrregularVebRepository irregularVebRepository;

    @Autowired
    private IrregularVerbMapper mapper;

    @Override
    public void create(IrregularVebDto dto) {

        IrregularVerb irregularVerb = this.mapper.toEntity(dto);
        this.irregularVebRepository.save(irregularVerb);

    }

    @CachePut(value = "irregulars", key = "#dto.id")
    @Override
    public IrregularVebDto update(IrregularVebDto dto) {
        IrregularVerb irregularVerb = this.mapper.toEntity(dto);
        this.irregularVebRepository.save(irregularVerb);
        return dto;
    }

    @CacheEvict(value = "irregulars", key = "#id", allEntries = false)
    @Override
    public void deleteById(String id) {
        this.irregularVebRepository.deleteById(Long.parseLong(id));
    }

    @Cacheable(value = "irregulars", key = "#id",  unless="#result == null")
    @Override
    public IrregularVebDto findById(String id) {

        IrregularVerb irregularVeb = this.irregularVebRepository.findById(Long.parseLong(id)).orElse(null);
        LOG.info("truy vấn trục tiếp trong DB bắng id: {}", id);

        IrregularVebDto irregularVebDto;

        if (irregularVeb != null) {
            irregularVebDto = this.mapper.toDto(irregularVeb);
            return irregularVebDto;
        }
        return null;
    }

    @Override
    public List<IrregularVebDto> findAll() {
        List<IrregularVebDto> result = this.irregularVebRepository.findAll()
                .stream().sorted(Comparator.comparing(IrregularVerb::getVerb))
                .map(mapper::toDto)
                .collect(Collectors.toList());
        return result;
    }
}

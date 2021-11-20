package com.alkemy.icons.icons.service.implementacion;

import com.alkemy.icons.icons.dto.ContinenteDTO;
import com.alkemy.icons.icons.entity.ContinenteEntity;
import com.alkemy.icons.icons.mapper.ContinenteMapper;
import com.alkemy.icons.icons.repository.ContinenteRepository;
import com.alkemy.icons.icons.service.ContinenteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ContinenteServiceImple implements ContinenteService {

    @Autowired
    private ContinenteMapper continenteMapper;
    @Autowired
    private ContinenteRepository continenteRepository;
    @Override
    public ContinenteDTO save(ContinenteDTO continenteDTO) {
        ContinenteEntity entity = continenteMapper.continenteDTO2Entity(continenteDTO);
        ContinenteEntity entitySaved = continenteRepository.save(entity);
        ContinenteDTO result = continenteMapper.continenteEntity2Dto(entitySaved);
        return result;
    }

    @Override
    public List<ContinenteDTO> findAllContinentes() {
        List<ContinenteEntity> entities = continenteRepository.findAll();
        List<ContinenteDTO> result = continenteMapper.continenteEntityList2DTOList(entities);
        return result;
    }
}

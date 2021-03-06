package com.alkemy.icons.icons.service.implementacion;

import com.alkemy.icons.icons.dto.ContinenteDTO;
import com.alkemy.icons.icons.entity.ContinenteEntity;
import com.alkemy.icons.icons.exception.ParamNotFound;
import com.alkemy.icons.icons.mapper.ContinenteMapper;
import com.alkemy.icons.icons.repository.ContinenteRepository;
import com.alkemy.icons.icons.service.ContinenteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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
        return continenteMapper.continenteEntity2Dto(entitySaved);
    }

    @Override
    public List<ContinenteDTO> findAllContinentes() {
        List<ContinenteEntity> entities = continenteRepository.findAll();
        return continenteMapper.continenteEntityList2DTOList(entities);
    }

    @Override
    public void delete(Long id) {
        continenteRepository.deleteById(id);
    }

    @Override
    public ContinenteDTO getContinenteById(Long id) {
        Optional<ContinenteEntity> continenteEntity = this.continenteRepository.findById(id);

        if(!continenteEntity.isPresent()){
            throw new ParamNotFound("Continent id not valid");
        }
        ContinenteDTO continenteDTO = this.continenteMapper.continenteEntity2Dto(continenteEntity.get());

        return continenteDTO;

    }

    @Override
    public ContinenteDTO modify(Long id) {

        return null;


    }
}

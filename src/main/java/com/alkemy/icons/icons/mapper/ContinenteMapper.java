package com.alkemy.icons.icons.mapper;

import com.alkemy.icons.icons.dto.ContinenteDTO;
import com.alkemy.icons.icons.entity.ContinenteEntity;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class ContinenteMapper {
    public ContinenteEntity continenteDTO2Entity(ContinenteDTO continenteDTO){
        ContinenteEntity continenteEntity = new ContinenteEntity();
        continenteEntity.setImagen(continenteDTO.getImagen());
        continenteEntity.setDenominacion(continenteDTO.getDenominacion());
        return continenteEntity;
    }

    public ContinenteDTO continenteEntity2Dto (ContinenteEntity continenteEntity){
        ContinenteDTO dto = new ContinenteDTO();
        dto.setId(continenteEntity.getId());
        dto.setImagen(continenteEntity.getImagen());
        dto.setDenominacion(continenteEntity.getDenominacion());
        return dto;

    }

    public List<ContinenteDTO> continenteEntityList2DTOList (List<ContinenteEntity> continenteEntity){
        List<ContinenteDTO> listaDto = new ArrayList<>();
        for (ContinenteEntity cont: continenteEntity) {
            listaDto.add(this.continenteEntity2Dto(cont));
        }

        return listaDto;
    }
}

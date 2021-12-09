package com.alkemy.icons.icons.mapper;

import com.alkemy.icons.icons.dto.CountryBasicDTO;
import com.alkemy.icons.icons.dto.CountryDTO;
import com.alkemy.icons.icons.dto.IconoDTO;
import com.alkemy.icons.icons.entity.CountryEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Component
public class CountryMapper {

    //@Autowired
   // private IconMapper iconMapper;

    public CountryBasicDTO countryBasicEntityToDto(CountryEntity entity){
        CountryBasicDTO countryBasicDTO = new CountryBasicDTO();

        countryBasicDTO.setId(entity.getId());
        countryBasicDTO.setImagen(entity.getImagen());
        countryBasicDTO.setDenominacion(entity.getImagen());
        countryBasicDTO.setCantidadHabitantes(entity.getCantidadHabitantes());

        return countryBasicDTO;

    }

    public CountryEntity countryDTOtoEntity(CountryDTO countryDTO){
        CountryEntity country = new CountryEntity();
        country.setImagen(countryDTO.getImagen());
        country.setDenominacion(countryDTO.getDenominacion());
        country.setCantidadHabitantes(countryDTO.getCantidadHabitantes());
        country.setSuperficie(countryDTO.getSuperficie());

        country.setContinenteId(countryDTO.getContinenteId());

        return country;
    }

    public CountryDTO countryEntityToDTO(CountryEntity countryEntity){
        CountryDTO countryDTO = new CountryDTO();

        countryDTO.setId(countryEntity.getId());
        countryDTO.setImagen(countryEntity.getImagen());
        countryDTO.setDenominacion(countryEntity.getDenominacion());
        countryDTO.setCantidadHabitantes(countryEntity.getCantidadHabitantes());
        countryDTO.setSuperficie(countryEntity.getSuperficie());
        countryDTO.setContinenteId(countryEntity.getContinenteId());


        return countryDTO;
    }

    public List<CountryDTO> listCountryEntityToDTO(List<CountryEntity> countryEntityList, Boolean loadIcons){
        List<CountryDTO> list = new ArrayList<>();

        for (CountryEntity country: countryEntityList) {
            list.add(this.countryEntityToDTO(country));
        }

        return list;
    }


}

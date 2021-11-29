package com.alkemy.icons.icons.mapper;

import com.alkemy.icons.icons.dto.CountryDTO;
import com.alkemy.icons.icons.entity.CountryEntity;
import org.springframework.stereotype.Component;

@Component
public class CountryMapper {
    public CountryEntity countryDTOtoEntity(CountryDTO countryDTO){
        CountryEntity country = new CountryEntity();
        country.setImagen(countryDTO.getImagen());
        country.setDenominacion(countryDTO.getDenominacion());
        country.setCantidadHabitantes(countryDTO.getCantidadHabitantes());
        country.setSuperficie(countryDTO.getSuperficie());
        country.setContinente(countryDTO.getContinente());
        country.setIconos(countryDTO.getIconos());
        return country;
    }

    public CountryDTO countryEntityToDTO(CountryEntity countryEntity){
        CountryDTO countryDTO = new CountryDTO();

        countryDTO.setId(countryEntity.getId());
        countryDTO.setImagen(countryEntity.getImagen());
        countryDTO.setDenominacion(countryEntity.getDenominacion());
        countryDTO.setCantidadHabitantes(countryEntity.getCantidadHabitantes());
        countryDTO.setSuperficie(countryEntity.getSuperficie());
        countryDTO.setContinente(countryEntity.getContinente());
        countryDTO.setIconos(countryEntity.getIconos());
        return countryDTO;


    }
}

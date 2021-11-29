package com.alkemy.icons.icons.mapper;

import com.alkemy.icons.icons.dto.CountryDTO;
import com.alkemy.icons.icons.dto.IconoBasicoDTO;
import com.alkemy.icons.icons.dto.IconoDTO;
import com.alkemy.icons.icons.entity.IconsEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;

@Component
public class IconMapper {

    @Autowired
    private CountryMapper countryMapper;

    public IconsEntity iconDtoToEntity(IconoDTO iconoDTO){
        IconsEntity iconsEntity = new IconsEntity();
        iconsEntity.setImagen(iconoDTO.getImagen());
        iconsEntity.setDenominacion(iconoDTO.getDenominacion());
        iconsEntity.setFechaCreacion(this.string2LocalDate(iconoDTO.getFechaCreacion()));
        iconsEntity.setAltura(iconoDTO.getAltura());
        iconsEntity.setHistoria(iconoDTO.getHistoria());
        return iconsEntity;

    }

    /*Entities list to DTO must have a boolean*/
    public IconoDTO iconEntityToDto(IconsEntity entidad, Boolean loadCountries){
        IconoDTO iconoDto = new IconoDTO();
        iconoDto.setId(entidad.getId());
        iconoDto.setImagen(entidad.getImagen());
        iconoDto.setDenominacion(entidad.getDenominacion());
        iconoDto.setFechaCreacion(entidad.getFechaCreacion().toString());
        iconoDto.setAltura(entidad.getAltura());
        if (loadCountries){
            List<CountryDTO> countriesDto = this.countryMapper.listCountryEntityToDTO(entidad.getListaPaises(), loadCountries);
            iconoDto.setListaPaises(countriesDto);
        }
        iconoDto.setHistoria(entidad.getHistoria());
        return iconoDto;
    }

    private LocalDate string2LocalDate(String stringDate){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        return LocalDate.parse(stringDate,formatter);
    }



    public List<IconoDTO> listIconEntityToDto(Collection<IconsEntity> listaIconos, Boolean loadCountry){
       List <IconoDTO> listadoDto = new ArrayList<>();

        for (IconsEntity iconos: listaIconos) {
            listadoDto.add(this.iconEntityToDto(iconos,loadCountry));
        }

        return listadoDto;
    }

    public Set<IconsEntity> iconDtoListToEntity(List<IconoDTO> dtoList){
        Set<IconsEntity> listaEntity = new HashSet<>();
        for (IconoDTO iconosDto: dtoList) {
            listaEntity.add(this.iconDtoToEntity(iconosDto));
        }
        return  listaEntity;
    }

    public List<IconoBasicoDTO> iconEntityBasicToDtoList(Collection<IconsEntity> entities){
        List<IconoBasicoDTO> listaIconosBasicos = new ArrayList<>();
        IconoBasicoDTO iconoBasicoDTO;
        for (IconsEntity entity : entities   ) {
            iconoBasicoDTO = new IconoBasicoDTO();
            iconoBasicoDTO.setId(entity.getId());
            iconoBasicoDTO.setImagen(entity.getImagen());
            iconoBasicoDTO.setDenominacion(entity.getDenominacion());
            listaIconosBasicos.add(iconoBasicoDTO);
        }
        return listaIconosBasicos;
    }




}

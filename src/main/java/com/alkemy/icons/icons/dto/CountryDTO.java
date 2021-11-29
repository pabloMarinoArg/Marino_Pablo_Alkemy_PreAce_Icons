package com.alkemy.icons.icons.dto;

import com.alkemy.icons.icons.entity.IconsEntity;
import lombok.Data;

import java.util.HashSet;
import java.util.Set;

@Data
public class CountryDTO {
    private Long id;
    private String imagen;
    private String denominacion;
    private Long cantidadHabitantes;
    private Long superficie;
    private Set<IconsEntity> iconos = new HashSet<>();


}

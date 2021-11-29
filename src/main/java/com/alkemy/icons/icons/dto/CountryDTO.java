package com.alkemy.icons.icons.dto;

import com.alkemy.icons.icons.entity.ContinenteEntity;
import com.alkemy.icons.icons.entity.IconsEntity;
import lombok.Data;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Data
public class CountryDTO {
    private Long id;
    private String imagen;
    private String denominacion;
    private Long cantidadHabitantes;
    private Long continenteId;
    private Long superficie;
    private List<IconoDTO> iconos = new ArrayList<>();


}

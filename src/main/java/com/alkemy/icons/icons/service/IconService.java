package com.alkemy.icons.icons.service;


import com.alkemy.icons.icons.dto.IconoDTO;
import com.alkemy.icons.icons.entity.IconsEntity;

import java.util.List;
import java.util.Set;

public interface IconService {

    IconoDTO save (IconoDTO iconoDTO);
    List<IconoDTO> findAllIcons();
    List<IconoDTO> getByFilters(String name, String date, Set<Long> cities, String order);
    IconoDTO findIconDtoById(Long id);
    IconoDTO modify (Long id);


}

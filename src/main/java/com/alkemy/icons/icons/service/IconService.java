package com.alkemy.icons.icons.service;


import com.alkemy.icons.icons.dto.IconoDTO;
import com.alkemy.icons.icons.entity.IconsEntity;

import java.util.List;

public interface IconService {

    IconoDTO save (IconoDTO iconoDTO);
    List<IconoDTO> findAllIcons();



}

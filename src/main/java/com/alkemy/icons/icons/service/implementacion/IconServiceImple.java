package com.alkemy.icons.icons.service.implementacion;

import com.alkemy.icons.icons.dto.IconoDTO;
import com.alkemy.icons.icons.entity.IconsEntity;
import com.alkemy.icons.icons.mapper.IconMapper;
import com.alkemy.icons.icons.repository.IconRepository;
import com.alkemy.icons.icons.service.IconService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class IconServiceImple implements IconService {

    @Autowired
    private IconMapper iconMapper;
    @Autowired
    private IconRepository iconRepository;


    @Override
    public IconoDTO save(IconoDTO iconoDTO) {
        IconsEntity iconsEntity = iconMapper.iconDtoToEntity(iconoDTO);
        IconsEntity iconSaved = iconRepository.save(iconsEntity);
        return iconMapper.iconEntityToDto(iconSaved, false);
    }

    @Override
    public List<IconoDTO> findAllIcons() {
        List<IconsEntity> listado = iconRepository.findAll();

        return iconMapper.listIconEntityToDto(listado,false);
    }
}

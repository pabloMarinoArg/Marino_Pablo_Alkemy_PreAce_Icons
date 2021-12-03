package com.alkemy.icons.icons.service.implementacion;

import com.alkemy.icons.icons.dto.IconFiltersDTO;
import com.alkemy.icons.icons.dto.IconoDTO;
import com.alkemy.icons.icons.entity.IconsEntity;
import com.alkemy.icons.icons.mapper.IconMapper;
import com.alkemy.icons.icons.repository.IconRepository;
import com.alkemy.icons.icons.repository.specification.IconSpecification;
import com.alkemy.icons.icons.service.IconService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

@Service
public class IconServiceImple implements IconService {

    @Autowired
    private IconMapper iconMapper;
    @Autowired
    private IconRepository iconRepository;
    @Autowired
    private IconSpecification iconSpecification;


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

    @Override
    public List<IconoDTO> getByFilters(String name, String date, Set<Long> cities, String order) {
        IconFiltersDTO filtersDTO = new IconFiltersDTO(name, date, cities, order);
        List<IconsEntity> entities = this.iconRepository.findAll(this.iconSpecification.getByFilters(filtersDTO));
        return this.iconMapper.iconEntitySet2DTOList(entities,true);
    }
}

package com.alkemy.icons.icons.service.implementacion;

import com.alkemy.icons.icons.dto.CountryDTO;
import com.alkemy.icons.icons.dto.CountryFilterDTO;
import com.alkemy.icons.icons.dto.IconoDTO;
import com.alkemy.icons.icons.entity.CountryEntity;
import com.alkemy.icons.icons.entity.IconsEntity;
import com.alkemy.icons.icons.exception.ParamNotFound;
import com.alkemy.icons.icons.mapper.CountryMapper;
import com.alkemy.icons.icons.mapper.IconMapper;
import com.alkemy.icons.icons.repository.CountryRepository;
import com.alkemy.icons.icons.repository.specification.CountrySpecification;
import com.alkemy.icons.icons.service.CountryService;
import com.alkemy.icons.icons.service.IconService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class CountryServiceImple implements CountryService {
    @Autowired
    private CountryMapper countryMapper;
    @Autowired
    private CountryRepository countryRepository;
    @Autowired
    private CountrySpecification countrySpecification;

    @Autowired
    private IconService iconService;

    @Autowired
    private IconMapper iconMapper;

    @Override
    public CountryDTO save(CountryDTO countryDTO) {

        CountryEntity countryEntity = countryMapper.countryDTOtoEntity(countryDTO);
        CountryEntity countrySaved = countryRepository.save(countryEntity);

        return countryMapper.countryEntityToDTO(countrySaved);
    }




    @Override
    public List<CountryDTO> findAllCountries() {
        List<CountryEntity> listado = countryRepository.findAll();

        return countryMapper.listCountryEntityToDTO(listado, true );
    }

    @Override
    public void delete(Long id) {
        countryRepository.deleteById(id);
    }

    @Override
    public List<CountryDTO> getByFilters(String name, Long idContinente, String order) {
        CountryFilterDTO countryFilterDTO = new CountryFilterDTO(name, idContinente, order);
        List<CountryEntity> entities = this.countryRepository.findAll(this.countrySpecification.getByFilters(countryFilterDTO));

        return this.countryMapper.listCountryEntityToDTO(entities, true);
    }

    @Override
    public CountryDTO getCountryById(Long id) {
        Optional<CountryEntity> countryEntity = this.countryRepository.findById(id);
        if(!countryEntity.isPresent()){
            throw new ParamNotFound("Country id is not valid");
        }
        CountryDTO countryDTO = this.countryMapper.countryEntityToDTO(countryEntity.get());
        return countryDTO;
    }

    @Override
    public CountryDTO addIcon(Long idPais, Long idIcono) {

        CountryEntity country = this.countryMapper.countryDTOtoEntity(getCountryById(idPais));

        if(country == null){
            throw new ParamNotFound("Country id is not valid");
        }

        IconsEntity icono = this.iconMapper.iconDtoToEntity(this.iconService.findIconDtoById(idIcono));
        if(icono == null){
            throw new ParamNotFound("Icon id is not valid");
        }
        Set<IconsEntity> lista = country.getIconos();

        lista.add(icono);

        return save(this.countryMapper.countryEntityToDTO(country));


    }


    /* public IconoDTO findIconDtoById(Long id) {
        Optional<IconsEntity> iconoEntidad = iconRepository.findById(id);
        if(!iconoEntidad.isPresent()){
            throw new ParamNotFound("Icon id not valid");
        }
        IconoDTO iconoDTO = this.iconMapper.iconEntityToDto(iconoEntidad.get(),true);
        return iconoDTO;


    }*/

    @Override
    public CountryDTO modify(CountryDTO countryDTO, Long id) {
        Optional<CountryEntity> entity = this.countryRepository.findById(id);
        CountryEntity country = this.countryMapper.countryDTOtoEntity(countryDTO);
        entity.get().setImagen(country.getImagen());
        entity.get().setDenominacion(country.getDenominacion());
        entity.get().setSuperficie(country.getSuperficie());
        entity.get().setCantidadHabitantes(country.getCantidadHabitantes());
        entity.get().setDeleted(country.getDeleted());
        entity.get().setIconos(country.getIconos());
        CountryDTO dto = this.countryMapper.countryEntityToDTO(country);
        save(dto);
        return dto;

    }
}

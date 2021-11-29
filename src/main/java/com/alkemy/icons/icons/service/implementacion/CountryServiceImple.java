package com.alkemy.icons.icons.service.implementacion;

import com.alkemy.icons.icons.dto.CountryDTO;
import com.alkemy.icons.icons.entity.CountryEntity;
import com.alkemy.icons.icons.mapper.CountryMapper;
import com.alkemy.icons.icons.repository.CountryRepository;
import com.alkemy.icons.icons.service.CountryService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class CountryServiceImple implements CountryService {
    @Autowired
    private CountryMapper countryMapper;
    @Autowired
    private CountryRepository countryRepository;


    @Override
    public CountryDTO save(CountryDTO countryDTO) {

        CountryEntity countryEntity = countryMapper.countryDTOtoEntity(countryDTO);
        CountryEntity countrySaved = countryRepository.save(countryEntity);

        return countryMapper.countryEntityToDTO(countrySaved);
    }

    @Override
    public List<CountryDTO> findAllConuntries() {
        return null;
    }

    @Override
    public void delete(Long id) {
        countryRepository.deleteById(id);
    }
}

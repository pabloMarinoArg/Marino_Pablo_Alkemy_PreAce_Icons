package com.alkemy.icons.icons.service.implementacion;

import com.alkemy.icons.icons.dto.CountryDTO;
import com.alkemy.icons.icons.dto.CountryFilterDTO;
import com.alkemy.icons.icons.dto.IconoDTO;
import com.alkemy.icons.icons.entity.CountryEntity;
import com.alkemy.icons.icons.mapper.CountryMapper;
import com.alkemy.icons.icons.repository.CountryRepository;
import com.alkemy.icons.icons.repository.specification.CountrySpecification;
import com.alkemy.icons.icons.service.CountryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CountryServiceImple implements CountryService {
    @Autowired
    private CountryMapper countryMapper;
    @Autowired
    private CountryRepository countryRepository;
    @Autowired
    private CountrySpecification countrySpecification;

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
    public List<CountryDTO> getByFilters(String name, String idContinente, String order) {
        CountryFilterDTO countryFilterDTO = new CountryFilterDTO(name, idContinente, order);
        List<CountryEntity> entities = this.countryRepository.findAll(this.countrySpecification.getByFilters(countryFilterDTO));

        return this.countryMapper.listCountryEntityToDTO(entities, true);
    }
}

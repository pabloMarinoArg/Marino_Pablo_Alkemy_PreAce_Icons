package com.alkemy.icons.icons.service;


import com.alkemy.icons.icons.dto.CountryDTO;
import com.alkemy.icons.icons.dto.CountryFilterDTO;
import com.alkemy.icons.icons.dto.IconoDTO;

import java.util.List;
import java.util.Set;

public interface CountryService {

    CountryDTO save(CountryDTO countryDTO );
    List<CountryDTO> findAllCountries();
    void delete(Long id);
    List<CountryDTO> getByFilters(String name, Long idContinente, String order);
    CountryDTO modify(CountryDTO countryDTO,Long id);
    CountryDTO getCountryById(Long id);
    CountryDTO addIcon(Long idPais, Long idIcono);

}

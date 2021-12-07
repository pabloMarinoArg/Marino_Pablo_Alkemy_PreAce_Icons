package com.alkemy.icons.icons.controller;

import com.alkemy.icons.icons.dto.ContinenteDTO;
import com.alkemy.icons.icons.dto.CountryDTO;
import com.alkemy.icons.icons.dto.IconoDTO;
import com.alkemy.icons.icons.service.CountryService;
import com.alkemy.icons.icons.service.implementacion.CountryServiceImple;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("/countries")
public class CountryController {

    @Autowired
    private CountryServiceImple countryService;


    @PostMapping
    public ResponseEntity<CountryDTO> save (@RequestBody CountryDTO countryDTO){
        CountryDTO country = countryService.save(countryDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(country);

    }

    @GetMapping("/all")
    public ResponseEntity<List<CountryDTO>> findAllcountries(){
        List<CountryDTO> listado = countryService.findAllCountries();
        return ResponseEntity.ok().body(listado);
    }

    @GetMapping
    public ResponseEntity<List<CountryDTO>> getDetailsByFilters(
            @RequestParam(required = false) String name,
            @RequestParam(required = false) String idContinente,
            @RequestParam(required = false, defaultValue = "ASC") String order
    ){

        List<CountryDTO> countries = this.countryService.getByFilters(name, idContinente, order);

        return ResponseEntity.ok(countries);
    }



}

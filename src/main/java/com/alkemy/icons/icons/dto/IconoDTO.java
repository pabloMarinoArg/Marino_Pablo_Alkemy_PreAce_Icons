package com.alkemy.icons.icons.dto;

import com.alkemy.icons.icons.entity.CountryEntity;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.ManyToMany;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class IconoDTO {
    private Long id;
    private String imagen;
    private String denominacion;
    private String fechaCreacion;
    private Long altura;
    private String historia;
    private List<CountryEntity> listaPaises = new ArrayList<>();
}
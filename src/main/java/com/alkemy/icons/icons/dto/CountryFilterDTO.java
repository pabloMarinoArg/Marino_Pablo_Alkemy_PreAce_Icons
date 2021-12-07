package com.alkemy.icons.icons.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CountryFilterDTO {

    private String name;
    private Long idContinente;
    private String order;

    public CountryFilterDTO(String name, Long idContinente, String order) {
        this.name = name;
        this.idContinente = idContinente;
        this.order = order;
    }

    public Boolean isAsc(){return this.order.compareToIgnoreCase("ASC") == 0;}

    public Boolean isDesc(){return this.order.compareToIgnoreCase("DESC") == 0;}
}

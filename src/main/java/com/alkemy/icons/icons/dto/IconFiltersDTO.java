package com.alkemy.icons.icons.dto;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.Set;

@Getter
@Setter
public class IconFiltersDTO {

   private String name;
   private String date;
   private Set<Long> cities;
   private String order;

   public IconFiltersDTO(String name, String date, Set<Long> cities, String order) {
      this.name = name;
      this.date = date;
      this.cities = cities;
      this.order = order;
   }

   public Boolean isAsc(){return this.order.compareToIgnoreCase("ASC") == 0;}

   public Boolean isDesc(){return this.order.compareToIgnoreCase("DESC") == 0;}
}

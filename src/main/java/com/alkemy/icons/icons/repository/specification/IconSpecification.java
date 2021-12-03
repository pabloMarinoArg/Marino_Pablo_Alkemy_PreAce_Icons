package com.alkemy.icons.icons.repository.specification;

import com.alkemy.icons.icons.dto.IconFiltersDTO;
import com.alkemy.icons.icons.entity.CountryEntity;
import com.alkemy.icons.icons.entity.IconsEntity;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.criteria.*;

@Component
public class IconSpecification {
  public Specification<IconsEntity> getByFilters(IconFiltersDTO iconFiltersDTO){

      return (root, query, criteriaBuilder) ->{
          List<Predicate> predicates = new ArrayList<>();
          if(StringUtils.hasLength(iconFiltersDTO.getName())){
              predicates.add(
                      criteriaBuilder.like(
                              criteriaBuilder.lower(root.get("denominacion")),
                              "%"+iconFiltersDTO.getName().toLowerCase()+"%"
                      )
              );
          }

          if(StringUtils.hasLength(iconFiltersDTO.getDate())){
              DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
              LocalDate date = LocalDate.parse(iconFiltersDTO.getDate(),formatter);
              predicates.add(
                      criteriaBuilder.equal(root.<LocalDate>get("denominacion"),date)
              );

          }

          if(!CollectionUtils.isEmpty(iconFiltersDTO.getCities())){
              Join<CountryEntity,IconsEntity> join = root.join("countries", JoinType.INNER);
              Expression<String> citiesId = join.get("id");
              predicates.add(citiesId.in(iconFiltersDTO.getCities()));

          }

          //Remove duplicates
          query.distinct(true);

          String orderByField = "denominacion";
          query.orderBy(
                  iconFiltersDTO.isAsc()?
                          criteriaBuilder.asc(root.get(orderByField)) :
                          criteriaBuilder.desc(root.get(orderByField))
          );

          return criteriaBuilder.and(predicates.toArray(new Predicate[0]));
      };





  }
}

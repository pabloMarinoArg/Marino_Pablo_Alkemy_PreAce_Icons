package com.alkemy.icons.icons.repository.specification;

import com.alkemy.icons.icons.dto.CountryFilterDTO;
import com.alkemy.icons.icons.dto.IconFiltersDTO;
import com.alkemy.icons.icons.entity.CountryEntity;
import com.alkemy.icons.icons.entity.IconsEntity;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;
import org.springframework.util.NumberUtils;

import javax.persistence.criteria.Expression;
import javax.persistence.criteria.Join;
import javax.persistence.criteria.JoinType;
import javax.persistence.criteria.Predicate;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

@Component
public class CountrySpecification {
    public Specification<CountryEntity> getByFilters(CountryFilterDTO countryFilterDTO){

        return (root, query, criteriaBuilder) ->{
            List<Predicate> predicates = new ArrayList<>();
            if(StringUtils.hasLength(countryFilterDTO.getName())){
                predicates.add(
                        criteriaBuilder.like(
                                criteriaBuilder.lower(root.get("denominacion")),
                                "%"+countryFilterDTO.getName().toLowerCase()+"%"
                        )
                );
            }

            //si lo descomento todas las consultas vuelven con error
         /*   if(!NumberUtils.STANDARD_NUMBER_TYPES.isEmpty()){
                predicates.add(
                        criteriaBuilder.equal(
                                criteriaBuilder.lower(root.get("idContinente")),
                                countryFilterDTO.getIdContinente()
                        )

                );

            }*/

            //Remove duplicates
            query.distinct(true);

            String orderByField = "denominacion";
            query.orderBy(
                    countryFilterDTO.isAsc()?
                            criteriaBuilder.asc(root.get(orderByField)) :
                            criteriaBuilder.desc(root.get(orderByField))
            );

            return criteriaBuilder.and(predicates.toArray(new Predicate[0]));
        };





    }
}

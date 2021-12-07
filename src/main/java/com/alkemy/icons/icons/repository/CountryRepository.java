package com.alkemy.icons.icons.repository;

import com.alkemy.icons.icons.entity.CountryEntity;
import com.alkemy.icons.icons.entity.IconsEntity;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.List;

public interface CountryRepository extends JpaRepository<CountryEntity, Long>, JpaSpecificationExecutor<CountryEntity> {

    List<CountryEntity> findAll(Specification<CountryEntity> spec);
}

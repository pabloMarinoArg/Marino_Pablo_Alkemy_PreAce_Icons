package com.alkemy.icons.icons.repository;

import com.alkemy.icons.icons.entity.IconsEntity;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface IconRepository extends JpaRepository<IconsEntity,Long>, JpaSpecificationExecutor<IconsEntity> {

    List<IconsEntity> findAll(Specification<IconsEntity> spec);


}

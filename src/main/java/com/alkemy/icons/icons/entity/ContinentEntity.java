package com.alkemy.icons.icons.entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name="continente")
public class ContinentEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    private String imagen;
    private String denominacion;

}

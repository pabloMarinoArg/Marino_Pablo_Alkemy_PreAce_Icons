package com.alkemy.icons.icons.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name="pais")
@Data
public class CountryEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    private String imagen;
    private String denominacion;
    @Column(name="cant_habitantes")
    private Long cantidadHabitantes;
    private Long superficie;
    @ManyToOne(fetch = FetchType.EAGER,cascade = CascadeType.ALL)
    @JoinColumn(name="continente_id", insertable = false, updatable = false)
    private ContinentEntity continente;
    @Column(name = "continente_id", nullable = false)
    private Long continenteId;
    @ManyToMany(
            cascade = {
                    CascadeType.PERSIST,
                    CascadeType.MERGE
            })
    @JoinTable(
            name = "icono_pais",
            joinColumns = @JoinColumn(name= "pais_id"),
            inverseJoinColumns = @JoinColumn(name="icon_id"))
    private Set<IconsEntity> iconos = new HashSet<>();





}

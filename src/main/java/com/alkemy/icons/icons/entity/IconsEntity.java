package com.alkemy.icons.icons.entity;

import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@Table(name="icon")
public class IconsEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    private String imagenUrl;
    private String denominacion;
    @Column(name="fecha_creacion")
    @DateTimeFormat(pattern = "yyyy/MM/dd")
    private LocalDate fechaCreacion;
    private Long altura;
    private String historia;
    @ManyToMany(mappedBy = "iconos", cascade = CascadeType.ALL)
    private List<CountryEntity> listaPaises = new ArrayList<>();


}

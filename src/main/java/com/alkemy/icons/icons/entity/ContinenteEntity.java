package com.alkemy.icons.icons.entity;

import lombok.Data;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

import javax.persistence.*;

@Entity
@Data
@Table(name="continente")
@SQLDelete(sql= "UPDATE continente SET deleted = true WHERE id =?")
@Where(clause = "deleted=false")
public class ContinenteEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    private String imagen;
    private String denominacion;
    private Boolean deleted = Boolean.FALSE;

}

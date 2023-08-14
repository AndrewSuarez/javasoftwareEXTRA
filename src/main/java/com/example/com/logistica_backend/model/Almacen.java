package com.example.com.logistica_backend.model;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "almacen")
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter

public class Almacen {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Basic(optional = false)
    @Column(name = "id_almacen")
    private Long idAlmacen;

    @ManyToOne
    @JoinColumn(name = "id_tipo_almacen", referencedColumnName = "id_tipo_almacen")
    private TipoAlmacen tipoAlmacen;

    @Column(name = "direccion")
    private String direccion;

}

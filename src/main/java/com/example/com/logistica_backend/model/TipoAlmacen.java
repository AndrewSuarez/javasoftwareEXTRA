package com.example.com.logistica_backend.model;

import javax.persistence.*;
import lombok.*;

@Entity
@Table(name = "tipo_de_almacen")
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter

public class TipoAlmacen {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Basic(optional = false)
    @Column(name = "id_tipo_almacen")
    private Long idTipoAlmacen;

    @Column(name = "nombre")
    private String nombre;

}

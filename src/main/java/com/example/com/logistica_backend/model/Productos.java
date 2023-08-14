package com.example.com.logistica_backend.model;

import javax.persistence.*;
import lombok.*;

@Entity
@Table(name = "productos")
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter

public class Productos {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Basic(optional = false)
    @Column(name = "id_producto")
    private Long idProducto;

    @Column(name = "tipo_producto")
    private String tipoProducto;

}
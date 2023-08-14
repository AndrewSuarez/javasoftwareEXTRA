package com.example.com.logistica_backend.model;

import lombok.*;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "productos_de_envio")
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter

public class ProductosEnvio {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Basic(optional = false)
    @Column(name = "id_producto_envio")
    private Long idProductoEnvio;

    @ManyToOne
    @JoinColumn(name = "id_producto", referencedColumnName = "id_producto")
    private Productos productos;

    @Column(name = "cantidad")
    private Integer cantidad;

    @ManyToOne
    @JoinColumn(name = "id_envio", referencedColumnName = "id_envio")
    private Envio envio;


}
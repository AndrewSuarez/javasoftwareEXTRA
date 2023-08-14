package com.example.com.logistica_backend.model;

import lombok.*;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "envios")
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter

public class Envio {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Basic(optional = false)
    @Column(name = "id_envio")
    private Long idEnvio;

    @ManyToOne
    @JoinColumn(name = "id_cliente", referencedColumnName = "id_cliente")
    private Cliente cliente;

    @Column(name = "tipo_de_envio")
    private String tipoDeEnvio;

    @Column(name = "fecha_registro")
    private String fechaRegistro;

    @Column(name = "fecha_entrega")
    private String fechaEntrega;

    @ManyToOne
    @JoinColumn(name = "id_transporte", referencedColumnName = "id_transporte")
    private Transporte transporte;

    @ManyToOne
    @JoinColumn(name = "id_almacen", referencedColumnName = "id_almacen")
    private Almacen almacen;

    @Column(name = "precio_envio")
    private Integer precioEnvio;

    @ManyToOne
    @JoinColumn(name = "id_descuento", referencedColumnName = "id_descuento")
    private Descuentos descuento;



}

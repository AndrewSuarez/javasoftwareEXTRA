package com.example.com.logistica_backend.model;

import javax.persistence.*;
import lombok.*;

@Entity
@Table(name = "cliente")
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Basic(optional = false)
    @Column(name = "id_cliente")
    private Long idCliente;

    @Column(name = "nombre")
    private String nombre;

    @Column(name = "direccion")
    private String direccion;

    @Column(name = "telefono")
    private Integer telefono;

    @Column(name = "correo_electronico")
    private String correoElectronico;


}

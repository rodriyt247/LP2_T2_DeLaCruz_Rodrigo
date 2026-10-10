package com.examenT2.LP2_T2_DeLaCruz_Rodrigo.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import java.time.LocalDateTime;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "tbl_proveedor")
public class ProveedorDeLaCruzRodrigo {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_proveedor")
    private Integer idProveedor;

    private String ruc;

    @Column(name = "razon_social")
    private String razonSocial;

    @Column(name = "fecha_registro")
    private LocalDateTime fechaRegistro;

    private String direccion;

    @Column(name = "pagina_web")
    private String paginaWeb;

    
    @ManyToOne
    @JoinColumn(name = "id_rubro")
    private RubroDeLaCruzRodrigo rubro;
}
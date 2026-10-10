package com.examenT2.LP2_T2_DeLaCruz_Rodrigo.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import java.time.LocalDate;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "tbl_orden_compra")
public class OrdenCompraDeLaCruzRodrigo {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "nro_orden")
    private Integer nroOrden;

    @ManyToOne
    @JoinColumn(name = "id_proveedor")
    private ProveedorDeLaCruzRodrigo proveedor;

    @Column(name = "monto")
    private Double monto;

    @Column(name = "direccion_entrega")
    private String direccionEntrega;

    @Column(name = "fecha_entrega")
    private LocalDate fechaEntrega;

    @Column(name = "estado")
    private String estado;
    
    public String getEstadoDescripcion() {
        if (estado == null) return "";
        if (estado.equals("P")) return "Pendiente";
        if (estado.equals("C")) return "Completado";
        if (estado.equals("A")) return "Anulado";
        return "";
    }
}
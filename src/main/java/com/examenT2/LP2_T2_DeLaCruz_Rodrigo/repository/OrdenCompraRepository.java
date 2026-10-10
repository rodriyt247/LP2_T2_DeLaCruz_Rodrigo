package com.examenT2.LP2_T2_DeLaCruz_Rodrigo.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import com.examenT2.LP2_T2_DeLaCruz_Rodrigo.model.OrdenCompraDeLaCruzRodrigo;

public interface OrdenCompraRepository extends JpaRepository<OrdenCompraDeLaCruzRodrigo, Integer> {
    List<OrdenCompraDeLaCruzRodrigo> findAllByOrderByNroOrdenDesc();
}
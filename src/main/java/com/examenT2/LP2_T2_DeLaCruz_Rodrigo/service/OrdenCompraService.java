package com.examenT2.LP2_T2_DeLaCruz_Rodrigo.service;

import java.util.List;
import org.springframework.stereotype.Service;
import com.examenT2.LP2_T2_DeLaCruz_Rodrigo.dto.ResultadoResponse;
import com.examenT2.LP2_T2_DeLaCruz_Rodrigo.model.OrdenCompraDeLaCruzRodrigo;
import com.examenT2.LP2_T2_DeLaCruz_Rodrigo.repository.OrdenCompraRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class OrdenCompraService {
    
    private final OrdenCompraRepository ordenCompraRepository;
    
    public List<OrdenCompraDeLaCruzRodrigo> getAll(){
        return ordenCompraRepository.findAllByOrderByNroOrdenDesc();
    }
    
    public OrdenCompraDeLaCruzRodrigo getOne(Integer numero) {
        return ordenCompraRepository.findById(numero).orElse(null);
    }
    
    @Transactional
    public ResultadoResponse create(OrdenCompraDeLaCruzRodrigo orden) {
        try {
            var registrado = ordenCompraRepository.save(orden);
            var mensaje = String.format("Orden de compra Nro. %d registrada.", registrado.getNroOrden());
            return new ResultadoResponse(true, mensaje);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResultadoResponse(false, "Hubo un error al registrar");
        }
    }
    
    @Transactional
    public ResultadoResponse update(OrdenCompraDeLaCruzRodrigo orden) {
        try {
            var registrado = ordenCompraRepository.save(orden);
            var mensaje = String.format("Orden de compra Nro. %d actualizada.", registrado.getNroOrden());
            return new ResultadoResponse(true, mensaje);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResultadoResponse(false, "Hubo un error al actualizar");
        }
    }
}
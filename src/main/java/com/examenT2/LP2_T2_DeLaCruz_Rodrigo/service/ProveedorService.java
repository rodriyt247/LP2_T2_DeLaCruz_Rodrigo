package com.examenT2.LP2_T2_DeLaCruz_Rodrigo.service;

import java.util.List;
import org.springframework.stereotype.Service;
import com.examenT2.LP2_T2_DeLaCruz_Rodrigo.model.ProveedorDeLaCruzRodrigo;
import com.examenT2.LP2_T2_DeLaCruz_Rodrigo.repository.ProveedorRepository;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ProveedorService {
    
    private final ProveedorRepository proveedorRepository;
    
    public List<ProveedorDeLaCruzRodrigo> getAll(){
        return proveedorRepository.findAll();
    }
}
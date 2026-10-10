package com.examenT2.LP2_T2_DeLaCruz_Rodrigo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.examenT2.LP2_T2_DeLaCruz_Rodrigo.model.OrdenCompraDeLaCruzRodrigo;
import com.examenT2.LP2_T2_DeLaCruz_Rodrigo.service.OrdenCompraService;
import com.examenT2.LP2_T2_DeLaCruz_Rodrigo.service.ProveedorService;
import com.examenT2.LP2_T2_DeLaCruz_Rodrigo.util.Alert;

import lombok.RequiredArgsConstructor;

@Controller
@RequestMapping("ordencompra")
@RequiredArgsConstructor
public class OrdenCompraController {

    private final OrdenCompraService ordenCompraService;
    private final ProveedorService proveedorService;
    
    @GetMapping("listado")
    public String listado(Model model) {
        model.addAttribute("lstOrdenes", ordenCompraService.getAll());
        return "ordencompra/listado_DeLaCruz_Rodrigo";	
    }
    
    @GetMapping("nuevo")
    public String nuevo(Model model) {
        model.addAttribute("lstProveedores", proveedorService.getAll());
        model.addAttribute("orden", new OrdenCompraDeLaCruzRodrigo());
        return "ordencompra/nuevo_DeLaCruz_Rodrigo";
    }
    
    @PostMapping("registrar")
    public String registrar(@ModelAttribute OrdenCompraDeLaCruzRodrigo orden, RedirectAttributes flash) {
        var response = ordenCompraService.create(orden);
        flash.addFlashAttribute("alert", Alert.sweetToast(response.mensaje(), "success", 5000));
        return "redirect:/ordencompra/listado";
    }
    
    @GetMapping("edicion/{id}")
    public String edicion(@PathVariable Integer id, Model model) {
        model.addAttribute("lstProveedores", proveedorService.getAll());
        model.addAttribute("orden", ordenCompraService.getOne(id));
        return "ordencompra/edicion_DeLaCruz_Rodrigo";
    }
    
    @PostMapping("guardar")
    public String guardar(@ModelAttribute OrdenCompraDeLaCruzRodrigo orden, RedirectAttributes flash) {
        var response = ordenCompraService.update(orden);
        flash.addFlashAttribute("alert", Alert.sweetToast(response.mensaje(), "success", 5000));
        return "redirect:/ordencompra/listado";
    }
}
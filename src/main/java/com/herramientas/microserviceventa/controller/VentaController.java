package com.herramientas.microserviceventa.controller;

import com.herramientas.microserviceventa.entity.Venta;
import com.herramientas.microserviceventa.service.IVentaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/venta")
public class VentaController {
    private final IVentaService ventaService;

    @Autowired
    public VentaController(IVentaService ventaService) {
        this.ventaService = ventaService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<Venta> getVentaById (@PathVariable Long id) {
        return ResponseEntity.ok(ventaService.getVentaById(id));
    }

    @GetMapping
    public ResponseEntity<List<Venta>> getAllVentas () {
        return ResponseEntity.ok(ventaService.getAllVentas());
    }

    @GetMapping("/cliente/{id}")
    public ResponseEntity<List<Venta>> getVentaByClienteId (@PathVariable Long id) {
        return ResponseEntity.ok(ventaService.getVentasByClienteId(id));
    }

    @PostMapping
    public ResponseEntity<Venta> createVenta (@RequestBody Venta venta) {
        return ResponseEntity.status(HttpStatus.CREATED).body(ventaService.createVenta(venta));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Venta> updateVenta (@PathVariable Long id, @RequestBody Venta venta) {
        return ResponseEntity.ok(ventaService.updateVenta(id, venta));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteVentaById (@PathVariable Long id) {
        ventaService.deleteVenta(id);
        return ResponseEntity.noContent().build();
    }
}

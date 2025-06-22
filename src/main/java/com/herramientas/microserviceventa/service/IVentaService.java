package com.herramientas.microserviceventa.service;

import com.herramientas.microserviceventa.entity.Venta;

import java.util.List;

public interface IVentaService {
    Venta getVentaById(Long id);
    List<Venta> getAllVentas();
    List<Venta> getVentasByClienteId(Long clienteId);
    Venta createVenta(Venta venta);
    Venta updateVenta(Long id,Venta venta);
    void deleteVenta(Long id);
}

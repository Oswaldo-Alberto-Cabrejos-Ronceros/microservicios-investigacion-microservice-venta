package com.herramientas.microserviceventa.service.impl;

import com.herramientas.microserviceventa.dao.IVentaDao;
import com.herramientas.microserviceventa.entity.Venta;
import com.herramientas.microserviceventa.feignclients.ClienteFeignClient;
import com.herramientas.microserviceventa.models.Cliente;
import com.herramientas.microserviceventa.service.IVentaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class VentaServiceImpl implements IVentaService {

    private final IVentaDao ventaDao;
    private final ClienteFeignClient clienteFeignClient;

    @Autowired
    public VentaServiceImpl(IVentaDao ventaDao, ClienteFeignClient clienteFeignClient) {
        this.ventaDao = ventaDao;
        this.clienteFeignClient = clienteFeignClient;
    }

    @Transactional(readOnly = true)
    @Override
    public Venta getVentaById(Long id) {
        return ventaDao.findById(id).orElseThrow(()->new RuntimeException("No se encontro la venta"));
    }

    @Transactional(readOnly = true)
    @Override
    public List<Venta> getAllVentas() {
        return ventaDao.findAll();
    }

    @Transactional
    @Override
    public Venta createVenta(Venta venta) {
        //verificamos existencia de cliente
        Cliente cliente = clienteFeignClient.getClientById(venta.getClientId());
        if (cliente == null) {
            throw new RuntimeException("Cliente no encontrado");
        }
        return ventaDao.save(venta);
    }

    @Transactional
    @Override
    public Venta updateVenta(Long id, Venta venta) {
        Venta oldVenta = getVentaById(id);
        oldVenta.setFecha(venta.getFecha());
        oldVenta.setHora(venta.getHora());
        oldVenta.setNota(venta.getNota());
        oldVenta.setMonto(venta.getMonto());
        //verificamos existencia de cliente
        Cliente cliente = clienteFeignClient.getClientById(venta.getClientId());
        if (cliente == null) {
            throw new RuntimeException("Cliente no encontrado");
        }
        oldVenta.setClientId(cliente.getId());
        return ventaDao.save(oldVenta);
    }

    @Transactional
    @Override
    public void deleteVenta(Long id) {
        ventaDao.deleteById(id);
    }
}

package com.herramientas.microserviceventa.service.impl;

import com.herramientas.microserviceventa.dao.IVentaDao;
import com.herramientas.microserviceventa.entity.Venta;
import com.herramientas.microserviceventa.service.IVentaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class VentaServiceImpl implements IVentaService {

    private final IVentaDao ventaDao;

    @Autowired
    public VentaServiceImpl(IVentaDao ventaDao) {
        this.ventaDao = ventaDao;
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
        //despues verificar la exista del cliente
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
        //despues verificar existencia de cliente
        oldVenta.setClientId(venta.getClientId());
        return ventaDao.save(oldVenta);
    }

    @Transactional
    @Override
    public void deleteVenta(Long id) {
        ventaDao.deleteById(id);
    }
}

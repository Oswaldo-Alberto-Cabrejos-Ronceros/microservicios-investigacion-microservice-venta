package com.herramientas.microserviceventa.dao;

import com.herramientas.microserviceventa.entity.Venta;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IVentaDao extends JpaRepository<Venta, Long> {
List<Venta> findAllByClientId(Long clienteId);
}

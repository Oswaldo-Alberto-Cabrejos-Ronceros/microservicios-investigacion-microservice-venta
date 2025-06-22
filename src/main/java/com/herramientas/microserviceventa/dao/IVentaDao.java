package com.herramientas.microserviceventa.dao;

import com.herramientas.microserviceventa.entity.Venta;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IVentaDao extends JpaRepository<Venta, Long> {
}

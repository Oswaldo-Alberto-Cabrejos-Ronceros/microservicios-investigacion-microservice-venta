package com.herramientas.microserviceventa.feignclients;

import com.herramientas.microserviceventa.models.Cliente;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "microservice-cliente",url = "http://localhost:8003")

public interface ClienteFeignClient {
    @GetMapping("/api/clientes/{id}")
    Cliente getClientById(@PathVariable("id") Long id);
}

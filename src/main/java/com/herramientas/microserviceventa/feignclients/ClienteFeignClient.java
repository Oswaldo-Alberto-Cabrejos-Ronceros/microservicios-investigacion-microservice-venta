package com.herramientas.microserviceventa.feignclients;

import com.herramientas.microserviceventa.models.Cliente;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "microservice-cliente")

public interface ClienteFeignClient {
    @GetMapping("/clientes/{id}")
    Cliente getClientById(@PathVariable("id") Long id);
}

package com.herramientas.microserviceventa;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients
@SpringBootApplication
public class MicroserviceVentaApplication {

	public static void main(String[] args) {
		SpringApplication.run(MicroserviceVentaApplication.class, args);
	}

}

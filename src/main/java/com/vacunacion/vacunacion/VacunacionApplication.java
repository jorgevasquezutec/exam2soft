package com.vacunacion.vacunacion;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;


@SpringBootApplication
@ComponentScan({"controllers", "data", "repositories","services"})
public class VacunacionApplication {
	public static void main(String[] args) {
		SpringApplication.run(VacunacionApplication.class, args);
	}

}

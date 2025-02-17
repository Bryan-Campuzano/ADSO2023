// paquete al que pertenece
package com.app.web;

//importaciones necesarias
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

// notacion que utilizamos para denotar que es una aplicacion de Spring
@SpringBootApplication
public class CrudSpringBootColtext implements CommandLineRunner{

	public static void main(String[] args) {
		SpringApplication.run(CrudSpringBootColtext.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

	}

}

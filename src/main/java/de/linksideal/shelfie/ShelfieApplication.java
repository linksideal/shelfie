package de.linksideal.shelfie;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.servers.Server;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@OpenAPIDefinition(servers = {@Server(url = "/", description = "any description of Server URL")})
public class ShelfieApplication {

	public static void main(String[] args) {
		SpringApplication.run(ShelfieApplication.class, args);
	}

}

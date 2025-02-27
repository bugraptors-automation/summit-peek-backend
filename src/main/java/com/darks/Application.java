package com.darks;
/**
 * @author Er. Arundeep Randev
 * @since Jan 2025
 *
 */
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.servers.Server;

/**
 * Initialize.
 * <p>
 * The {@link OpenAPIDefinition} annotation was used to enable HTTPS.
 * </p>
 */

@OpenAPIDefinition(servers = {@Server(url = "/", description = "Default Server URL")})
@SpringBootApplication
public class Application {
	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
}

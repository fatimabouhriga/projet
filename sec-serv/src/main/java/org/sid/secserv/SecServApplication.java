package org.sid.secserv;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.sid.secserv.entity.Role;
import org.sid.secserv.service.RoleService;
import org.springframework.boot.CommandLineRunner;

@SpringBootApplication
@EnableGlobalMethodSecurity(prePostEnabled = true,securedEnabled = true)
public class SecServApplication {

	public static void main(String[] args) {
		SpringApplication.run(SecServApplication.class, args);
	}


}

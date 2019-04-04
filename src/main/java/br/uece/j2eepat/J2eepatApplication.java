package br.uece.j2eepat;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class J2eepatApplication {

	public static void main(String[] args) {
		SpringApplication.run(J2eepatApplication.class, args);
	}

}

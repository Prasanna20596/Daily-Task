package com.crud.audit;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

import com.crud.audit.auditmple.AuditorAwareImpl;

import org.springframework.data.domain.AuditorAware;

@SpringBootApplication
@EnableJpaAuditing(auditorAwareRef = "auditorAware")
public class SpringAuditApplication {

	@Bean
    public AuditorAware<String> auditorAware() {
        return new AuditorAwareImpl();
    }
	
	public static void main(String[] args) {
		SpringApplication.run(SpringAuditApplication.class, args);
	}

}

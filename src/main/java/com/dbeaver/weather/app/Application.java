package com.dbeaver.weather.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@ComponentScan(basePackages = "com.dbeaver.weather")
@EnableJpaRepositories(basePackages = "com.dbeaver.weather.repositories")
@EntityScan(basePackages = "com.dbeaver.weather.models")
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class);
    }
}

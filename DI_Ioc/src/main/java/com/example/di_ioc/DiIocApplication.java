package com.example.di_ioc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class DiIocApplication {

    @Autowired
    ConfigurableApplicationContext context;

    public static void main(String[] args) {
        SpringApplication.run(DiIocApplication.class, args);
    }

    public BottleDI getBeanOfBottleDI() {
        return context.getBean(BottleDI.class);
    }
}

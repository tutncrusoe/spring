package com.example.di_ioc_bean;

import com.example.di_ioc_bean.IoC.Car;

import com.example.di_ioc_bean.first_DI_principle.Engine;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class DiIocApplication {

    public static void main(String[] args) {
        SpringApplication.run(DiIocApplication.class, args);
        ApplicationContext context = SpringApplication.run(DiIocApplication.class, args);

        // Lấy ra bean có class cụ thể
        Car car = context.getBean(Car.class);

        // Lấy ra theo tên và class
        // Tuy là Engine.class nhưng Engine lại là interface
        Engine engine = context.getBean("ChinaEngine", Engine.class);
    }

}

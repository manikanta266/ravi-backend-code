package com.example.employee_demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@SpringBootApplication
@EnableWebMvc
public class EmployeeDemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(EmployeeDemoApplication.class, args);
    }

}

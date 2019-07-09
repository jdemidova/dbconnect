package com.practice.dbconnect;

import com.practice.dbconnect.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
public class Application implements CommandLineRunner { // рабочая версия

    @Autowired
    private EmployeeService employeesService;

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
         }

    @Override
    public void run(String... strings) {
        System.out.println(employeesService.getAll());
    }
}

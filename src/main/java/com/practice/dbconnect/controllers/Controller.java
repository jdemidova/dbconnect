package com.practice.dbconnect.controllers;

import com.practice.dbconnect.model.Employee;
import com.practice.dbconnect.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
//@RequestMapping("employees")
public class Controller {
    @Autowired
    private EmployeeService employeeService;

    @GetMapping
    public List<Employee> getAll() {
        return employeeService.getAll();
    }

}

package com.practice.dbconnect.rest;

import com.practice.dbconnect.model.Employee;
import com.practice.dbconnect.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
public class Controller {
    @Autowired
    private EmployeeService employeeService;

    @RequestMapping("/get_all")
    public List<Employee> getAll() {
        return employeeService.getAll();
    }

    @RequestMapping("/query_first")
    public List queryFirst() {
        return employeeService.queryFirst();
    }

    @RequestMapping("/query_second")
    public List querySecond() {
        return employeeService.querySecond();
    }
}

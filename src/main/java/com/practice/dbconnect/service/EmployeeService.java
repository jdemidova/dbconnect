package com.practice.dbconnect.service;

import com.practice.dbconnect.model.Employee;
import java.util.List;

public interface EmployeeService {
    List<Employee> getAll();
    Employee saveOrUpdate(Employee employee);
    void deleteById(Integer id);
    List queryFirst();
    List querySecond();
}

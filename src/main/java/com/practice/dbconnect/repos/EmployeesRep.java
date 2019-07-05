package com.practice.dbconnect.repos;

import com.practice.dbconnect.entities.Employees;
import org.springframework.context.annotation.Bean;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

//@Repository
public interface EmployeesRep extends CrudRepository<Employees, Integer> {
}

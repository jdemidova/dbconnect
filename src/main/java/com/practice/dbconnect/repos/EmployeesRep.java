package com.practice.dbconnect.repos;

import com.practice.dbconnect.model.Employee;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface EmployeesRep extends CrudRepository<Employee, Integer> {
}

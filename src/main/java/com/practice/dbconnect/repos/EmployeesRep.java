package com.practice.dbconnect.repos;

import com.practice.dbconnect.entities.EmployeeBean;
import org.springframework.data.repository.CrudRepository;

//@Repository
public interface EmployeesRep extends CrudRepository<EmployeeBean, Integer> {

}

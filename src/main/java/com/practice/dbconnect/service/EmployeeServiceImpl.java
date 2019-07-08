package com.practice.dbconnect.service;

import com.practice.dbconnect.model.Employee;
import com.practice.dbconnect.repos.EmployeesRep;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.ArrayList;
import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private EmployeesRep employeesRep;

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public Employee saveOrUpdate(Employee employee) {
        employeesRep.save(employee);
        return employee;
    }

    @Override
    public List<Employee> getAll() {
        List<Employee> result = new ArrayList<>();
        employeesRep.findAll().forEach(result::add);
        return result;
    }

    @Override
    public void deleteById(Integer id) {
        employeesRep.deleteById(id);
    }

    @Override
    public List<Employee> queryFirst() {
        List<Employee> result = entityManager.createNativeQuery
                ("select * from HR.EMPLOYEES").getResultList();


        return result;
    }

    @Override
    public List querySecond() {
        return null;
    }

}

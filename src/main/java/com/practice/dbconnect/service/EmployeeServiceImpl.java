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
    public List queryFirst() {
        List result = entityManager.createNativeQuery
                ("SELECT a.last_name name, a.salary wage, " +
                        "a.department_id dep_id, AVG(b.salary) avg_wage_in_dep" +
                        " FROM employees a, employees b" +
                        " WHERE a.department_id = b.department_id" +
                        " AND a.salary > (SELECT AVG(salary) FROM employees" +
                        " WHERE department_id = a.department_id)" +
                        " GROUP BY a.last_name, a.salary, a.department_id" +
                        " ORDER BY AVG(b.salary)").getResultList();
        return result;
    }

    @Override
    public List querySecond() {
        List result = entityManager.createNativeQuery("SELECT last_name" +
                " FROM HR.EMPLOYEES OUTER" +
                " WHERE EXISTS (SELECT 'X' FROM employees INNER" +
                " WHERE INNER.department_id = OUTER.department_id" +
                " AND INNER.hire_date > OUTER.hire_date" +
                " AND INNER.salary > OUTER.salary)").getResultList();
        return result;
    }

}

package com.practice.dbconnect.controllers;

import com.practice.dbconnect.model.Employee;
import org.springframework.web.bind.annotation.RestController;

import javax.persistence.criteria.CriteriaBuilder;
import java.sql.*;
import java.util.List;

@RestController
public class Query1Controller {
    static private Connection conn;
    private static Employee[] employees;

    public static Employee[] getQuery1Result() {
        try {
            conn = DriverManager.getConnection(
                    "jdbc:oracle:thin:@localhost:1522:orcl",
                    "HR","password");

            PreparedStatement stmt = conn.prepareStatement("SELECT a.last_name, a.salary, " +
                    "a.department_id, AVG(b.salary)" +
                    "FROM employees a, employees b" +
                    "WHERE a.department_id = b.department_id AND a.salary >" +
                    " (SELECT AVG(salary) FROM employees" +
                    "WHERE department_id = a.department_id)" +
                    "GROUP BY a.last_name, a.salary, a.department_id" +
                    "ORDER BY AVG(b.salary);");
            stmt.execute();
            ResultSet rs = stmt.getResultSet();
            rs.close();
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        System.out.println("getAll() complete");
        return employees;
    }
}

package com.practice.dbconnect;

import com.practice.dbconnect.entities.Employees;
import com.practice.dbconnect.repos.EmployeesRep;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Date;
import java.util.Map;

@Controller
public class StartController {

//    @Autowired
//    private com.practice.dbconnect.repos.EmployeesRep empRep;

    @GetMapping("/greeting")
    public String greeting(@RequestParam(name="name", required=false, defaultValue="World") String name,
                           Map<String, Object> model) {
        model.put("name", name);
        return "greeting";
    }

    @GetMapping
    public String main(Map<String, Object> model) {
        //Iterable<Employees> e = empRep.findAll();
        model.put("q", "qwe");
        return "main";
    }

    @PostMapping
    public String add(@RequestParam String first_name, @RequestParam String last_name,
                      @RequestParam String email, @RequestParam String phone_number,
                      @RequestParam Date hire_date, @RequestParam String job_id,
                      @RequestParam Double salary, @RequestParam Double commission_pct,
                      @RequestParam Integer manager_id, @RequestParam Integer department_id, Map<String, Object> model) {
        Employees employees = new Employees(first_name, last_name, email, phone_number,
                hire_date, job_id, salary, commission_pct, manager_id, department_id);
//        empRep.save(employees);
//        Iterable<Employees> e = empRep.findAll();
//        model.put("q", e);
        return "main";
    }
}

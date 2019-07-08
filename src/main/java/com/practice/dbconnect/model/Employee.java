package com.practice.dbconnect.model;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Table(name = "EMPLOYEES")
public class Employee {

    public Employee() {}

    public Employee(Integer employeeId, String firstName,
                    String lastName, String email,
                    String phoneNumber, Date hireDate,
                    String jobId, Double salary, Double commissionPct,
                    Integer managerId, Integer departmentId) {
        this.employeeId = employeeId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.hireDate = hireDate;
        this.jobId = jobId;
        this.salary = salary;
        this.commissionPct = commissionPct;
        this.managerId = managerId;
        this.departmentId = departmentId;
    }

    @Id
    //@GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "employee_id", nullable = false)
    private Integer employeeId;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name", nullable = false)
    private String lastName;

    @Column(name = "email", nullable = false)
    private String email;

    @Column(name = "phone_number")
    private String phoneNumber;

    @Column(name = "hire_date", nullable = false)
    private Date hireDate;

    @Column(name = "job_id", nullable = false)
    private String jobId;

    @Column(name = "salary")
    private Double salary;

    @Column(name = "commission_pct")
    private Double commissionPct;

    @Column(name = "manager_id")
    private Integer managerId;

    @Column(name = "department_id")
    private Integer departmentId;

    public Integer getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(Integer employee_Id) {
        employeeId = employee_Id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String first_Name) {
        firstName = first_Name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public Date getHireDate() {
        return hireDate;
    }

    public void setHireDate(Date hireDate) {
        this.hireDate = hireDate;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinTable(name = "JOBS", joinColumns = {
            @JoinColumn(referencedColumnName = "job_id",
                    foreignKey = @ForeignKey(name = "EMP_JOB_FK")) } )
    public String getJobId() {
        return jobId;
    }

    public void setJobId(String jobId) {
        this.jobId = jobId;
    }

    public Double getSalary() {
        return salary;
    }

    public void setSalary(Double salary) {
        this.salary = salary;
    }

    public Double getCommissionPct() {
        return commissionPct;
    }

    public void setCommissionPct(Double commissionPct) {
        this.commissionPct = commissionPct;
    }

    @OneToOne(fetch = FetchType.LAZY) //???
    @JoinTable(name = "EMPLOYEES", joinColumns = {
            @JoinColumn(referencedColumnName = "employee_id",
                    foreignKey = @ForeignKey(name = "EMP_MANAGER_FK")) } )
    public Integer getManagerId() {
        return managerId;
    }

    public void setManagerId(Integer managerId) {
        this.managerId = managerId;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinTable(name = "DEPARTMENTS", joinColumns = {
            @JoinColumn(referencedColumnName = "department_id",
                    foreignKey = @ForeignKey(name = "EMP_DEPT_FK")) } )
    public Integer getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(Integer departmentId) {
        this.departmentId = departmentId;
    }

    @Override
    public String toString() {
        return this.firstName + " " + this.lastName;
    }
}

package com.practice.dbconnect.model;

import javax.persistence.*;
import java.util.Date;

@Entity
@IdClass(JobHistoryId.class)
@Table(name = "JOB_HISTORY")
public class JobHistory {
    @Id
    @Column(name = "employee_id", nullable = false)
    private Integer employeeId;

    @Id
    @Column(name = "start_date", nullable = false)
    private Date startDate;

    @Column(name = "end_date", nullable = false)
    private Date endDate;

    @Column(name = "job_id", nullable = false)
    private String jobId;

    @Column(name = "department_id")
    private Integer departmentId;

    public JobHistory() {}

    public JobHistory(Integer employeeId, Date startDate,
                      Date endDate, String jobId, Integer departmentId) {
        this.employeeId = employeeId;
        this.startDate = startDate;
        this.endDate = endDate;
        this.jobId = jobId;
        this.departmentId = departmentId;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinTable(name = "EMPLOYEES", joinColumns = {
            @JoinColumn(referencedColumnName = "employee_id" ,foreignKey = @ForeignKey(name = "JHIST_EMP_FK")) } )
    public Integer getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(Integer employeeId) {
        this.employeeId = employeeId;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinTable(name = "JOBS", joinColumns = {
            @JoinColumn(referencedColumnName = "job_id" ,foreignKey = @ForeignKey(name = "JHIST_JOB_FK")) } )
    public String getJobId() {
        return jobId;
    }

    public void setJobId(String jobId) {
        this.jobId = jobId;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinTable(name = "DEPARTMENTS", joinColumns = {
            @JoinColumn(referencedColumnName = "department_id" ,foreignKey = @ForeignKey(name = "JHIST_DEPT_FK")) } )
    public Integer getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(Integer departmentId) {
        this.departmentId = departmentId;
    }
}

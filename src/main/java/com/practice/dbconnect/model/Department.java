package com.practice.dbconnect.model;

import javax.persistence.*;

@Entity
@Table(name = "DEPARTMENTS")
public class Department {
    @Id
    @Column(name = "department_id", nullable = false)
    private Integer departmentId;

    @Column(name = "department_name", nullable = false)
    private String departmentName;

    @Column(name = "manager_id")
    private Integer managerId;

    @Column(name = "location_id")
    private Integer locationId;

    public Department() {}

    public Department(Integer departmentId,
                      String departmentName, Integer managerId, Integer locationId) {
        this.departmentId = departmentId;
        this.departmentName = departmentName;
        this.managerId = managerId;
        this.locationId = locationId;
    }

    public Integer getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(Integer departmentId) {
        this.departmentId = departmentId;
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinTable(name = "EMPLOYEES", joinColumns = {
    @JoinColumn(referencedColumnName = "employee_id", foreignKey = @ForeignKey(name = "DEPT_MGR_FK")) } )
    public Integer getManagerId() {
        return managerId;
    }

    public void setManagerId(Integer managerId) {
        this.managerId = managerId;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinTable(name = "LOCATIONS", joinColumns = {
    @JoinColumn(referencedColumnName = "location_id", foreignKey = @ForeignKey(name = "DEPT_LOC_FK")) } )
    public Integer getLocationId() {
        return locationId;
    }

    public void setLocationId(Integer locationId) {
        this.locationId = locationId;
    }
}

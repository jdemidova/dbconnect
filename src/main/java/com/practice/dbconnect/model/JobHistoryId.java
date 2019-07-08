package com.practice.dbconnect.model;

import java.io.Serializable;
import java.util.Date;


public class JobHistoryId implements Serializable {

    private Integer employeeId;
    private Date startDate;

    public JobHistoryId() { }

    public JobHistoryId(Integer employeeId, Date startDate) {
        this.employeeId = employeeId;
        this.startDate = startDate;
    }

    public Integer getEmployeeId() {
        return employeeId;
    }

    public Date getStartDate() {
        return startDate;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result
                + ((startDate == null) ? 0 : startDate.hashCode());
        result = prime * result + employeeId;
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        JobHistoryId other = (JobHistoryId) obj;
        if (startDate == null) {
            if (other.startDate != null)
                return false;
        } else if (!startDate.equals(other.startDate))
            return false;
        if (employeeId != other.employeeId)
            return false;
        return true;
    }
}

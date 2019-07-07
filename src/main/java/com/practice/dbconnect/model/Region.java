package com.practice.dbconnect.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class RegionBean {
    @Id
    private Double regionId;
    private String regionName;

    public RegionBean(Double regionId, String regionName) {
        this.regionId = regionId;
        this.regionName = regionName;
    }

    public Double getRegionId() {
        return regionId;
    }

    public void setRegionId(Double regionId) {
        this.regionId = regionId;
    }

    public String getRegionName() {
        return regionName;
    }

    public void setRegionName(String regionName) {
        this.regionName = regionName;
    }
}

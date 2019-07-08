package com.practice.dbconnect.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "REGIONS")
public class Region {
    @Id
    private Double regionId;

    @Column(name = "region_name")
    private String regionName;

    public Region(Double regionId, String regionName) {
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

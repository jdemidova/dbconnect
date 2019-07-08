package com.practice.dbconnect.model;

import javax.persistence.*;

@Entity
@Table(name = "COUNTRIES")
public class Country {
    @Id
    @Column(name = "country_id", nullable = false)
    private String countryId;

    @Column(name = "country_name")
    private String countryName;

    @Column(name = "region_id")
    private Integer regionId;

    public Country(String countryId, String countryName, Integer regionId) {
        this.countryId = countryId;
        this.countryName = countryName;
        this.regionId = regionId;
    }
    public Country() {}

    public String getCountryId() {
        return countryId;
    }

    public void setCountryId(String countryId) {
        this.countryId = countryId;
    }

    public String getCountryName() {
        return countryName;
    }

    public void setCountryName(String countryName) {
        this.countryName = countryName;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinTable(name = "DEPARTMENTS", joinColumns = {
    @JoinColumn(referencedColumnName = "region_id" ,foreignKey = @ForeignKey(name = "COUNTR_REG_FK")) } )
    public Integer getRegionId() {
        return regionId;
    }

    public void setRegionId(Integer regionId) {
        this.regionId = regionId;
    }
}

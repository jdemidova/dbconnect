package com.practice.dbconnect.model;

import javax.persistence.*;

@Entity
@Table(name = "LOCATIONS")
public class Location {
    @Id
    @Column(name = "location_id", nullable = false)
    private Integer locationId;

    @Column(name = "street_address")
    private String streetAddress;

    @Column(name = "postal_code")
    private  String postalCode;

    @Column(name = "city", nullable = false)
    private String city;

    @Column(name = "state_province")
    private String stateProvince;

    @Column(name = "country_id")
    private String countryId;

    public Location() {}

    public Location(Integer locationId, String streetAddress,
                    String postalCode, String city,
                    String stateProvince, String countryId) {
        this.locationId = locationId;
        this.streetAddress = streetAddress;
        this.postalCode = postalCode;
        this.city = city;
        this.stateProvince = stateProvince;
        this.countryId = countryId;
    }

    public Integer getLocationId() {
        return locationId;
    }

    public void setLocationId(Integer locationId) {
        this.locationId = locationId;
    }

    public String getStreetAddress() {
        return streetAddress;
    }

    public void setStreetAddress(String streetAddress) {
        this.streetAddress = streetAddress;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getStateProvince() {
        return stateProvince;
    }

    public void setStateProvince(String stateProvince) {
        this.stateProvince = stateProvince;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinTable(name = "COUNTRIES", joinColumns = {
            @JoinColumn(referencedColumnName = "country_id" ,foreignKey = @ForeignKey(name = "LOC_C_ID_FK")) } )
    public String getCountryId() {
        return countryId;
    }

    public void setCountryId(String countryId) {
        this.countryId = countryId;
    }

}

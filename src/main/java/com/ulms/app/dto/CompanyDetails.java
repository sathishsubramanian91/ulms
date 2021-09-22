package com.ulms.app.dto;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.UniqueConstraint;

@Data
public class CompanyDetails {
    private String uniqueId;
    private String companyName;
    private String contactPerson;
    private String natureOfBusiness;
    private String gstNumber;
    private String panNumber;
    private String address;
    private String city;
    private String district;
    private String state;
    private String country;
    private String contactNumber;

}

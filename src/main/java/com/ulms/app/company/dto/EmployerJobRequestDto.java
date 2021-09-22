package com.ulms.app.company.dto;

import lombok.Data;

import java.sql.Date;

@Data
public class EmployerJobRequestDto {
    private Long Id;
    private String skills;
    private Long noOfPplRequired;
    private Date requiredFromDate;
    private Date requiredToDate;
    private String salaryType;
    private Double salary;
    private Boolean accommodation;
    private Boolean foodProvided;
    private String description;
    
}

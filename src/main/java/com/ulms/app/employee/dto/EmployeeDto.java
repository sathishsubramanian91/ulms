package com.ulms.app.employee.dto;

import lombok.Data;

@Data
public class EmployeeDto {
        private Long Id;
        private String employeeName;
        private String aadharNumber;
        private String panNumber;
        private String address;
        private String city;
        private String district;
        private String state;
        private String country;
        private String contactNumber;
        private String uniqueId;
        private String skills;
}

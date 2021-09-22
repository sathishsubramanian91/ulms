package com.ulms.app.employee.entity;

import com.ulms.app.repo.BaseId;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.Size;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
public class EmployeEntity extends BaseId {

    private String employeeName;
    @Size(min = 12,max = 12)
    private String aadharNumber;
    private String panNumber;
    @Column(columnDefinition = "Text")
    private String address;
    private String city;
    private String district;
    private String state;
    private String country;
    private String contactNumber;
    private String uniqueId;
    private String skills;

}

package com.ulms.app.company.entity;

import com.ulms.app.repo.BaseId;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.Entity;
import java.sql.Date;

@Entity
@Data
@NoArgsConstructor
@ToString(callSuper = true)
@AllArgsConstructor
public class EmployerJobRequest extends BaseId {

    private String skills;
    private Long noOfPplRequired;
    private Date requiredFromDate;
    private Date requiredToDate;
    private String salaryType;
    private Double salary;
    private Boolean accommodation;
    private Boolean foodProvided;
    @Column(columnDefinition = "Text")
    private String description;
}

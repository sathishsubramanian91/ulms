package com.ulms.app.user.entity;


import com.ulms.app.repo.BaseId;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
public class AdminContactEntity  extends BaseId {

    private String contactPersonName;
    private String primaryMobileNumber;
    private String secondaryMobileNumber;
    private String officeLandline;
    private String emailAddress;
    private Long userDetailsEntityId;
}

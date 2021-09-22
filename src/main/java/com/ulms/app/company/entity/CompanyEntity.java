package com.ulms.app.company.entity;

import com.ulms.app.repo.BaseId;
import com.ulms.app.user.entity.UserDetailEntity;
import lombok.*;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
@ToString(callSuper = true)
@AllArgsConstructor
public class CompanyEntity extends BaseId {

    @Column(columnDefinition = "Text")
    private String uniqueId;
    private String companyName;
    private String gstNumber;
    private String panNumber;
    @Column(columnDefinition = "Text")
    private String address;
    private String city;
    private String district;
    private String state;
    private String country;
    private String contactPerson;
    private String natureOfBusiness;
    private String contactNumber;

    @OneToOne(fetch = FetchType.LAZY, orphanRemoval = true)
    private UserDetailEntity userDetailEntity;

}

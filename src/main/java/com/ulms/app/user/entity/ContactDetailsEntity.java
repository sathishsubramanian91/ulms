package com.ulms.app.user.entity;

import com.ulms.app.repo.BaseId;
import lombok.*;

import javax.persistence.Entity;

@Entity
@Data
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@AllArgsConstructor
public class ContactDetailsEntity extends BaseId {
    private String name;
    private String primaryMobileNumber;
    private String secondaryMobileNumber;
    private String landline;
    private String emailAddress;
}

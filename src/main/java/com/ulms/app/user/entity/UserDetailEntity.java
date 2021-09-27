package com.ulms.app.user.entity;


import com.ulms.app.repo.BaseId;
import lombok.*;

import javax.persistence.Entity;
import javax.persistence.OneToOne;

@Entity
@Data
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@AllArgsConstructor
public class UserDetailEntity extends BaseId {
    private String firstname;
    private String lastname;
    private String username;
    private String password;
    private String email;
    private String role;
    private Boolean isActivated;
    private Boolean isActive;

}

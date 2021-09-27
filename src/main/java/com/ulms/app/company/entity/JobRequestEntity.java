package com.ulms.app.company.entity;

import com.ulms.app.repo.BaseId;
import com.ulms.app.user.entity.UserDetailEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@ToString(callSuper = true)
@AllArgsConstructor
public class JobRequestEntity  extends BaseId {

    @ManyToOne(cascade = CascadeType.DETACH)
    UserDetailEntity user;

    private Date requestedDate;
    private String status;

    @OneToMany(cascade = CascadeType.ALL,orphanRemoval = true)
    @JoinColumn(name = "requestId")
    List<EmployerJobRequest> jobRequestList;


}

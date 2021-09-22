package com.ulms.app.user.entity;

import com.ulms.app.repo.BaseId;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class SubCategory extends BaseId {
    private String name;
    private Long skillId;
}

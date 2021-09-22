package com.ulms.app.user.dto;


import lombok.Data;

import java.util.List;

@Data
public class SkillsDto {
    public Long id;
    public String name;
    public List<String> subCategory;

}

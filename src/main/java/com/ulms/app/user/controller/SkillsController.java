package com.ulms.app.user.controller;


import com.ulms.app.user.dto.SkillsDto;
import com.ulms.app.user.services.SkillServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/skills")
public class SkillsController {

    @Autowired
    private SkillServices skillServices;

    @GetMapping("/")
    public ResponseEntity<List<SkillsDto>> getAllSkills(){

        return ResponseEntity.ok(skillServices.getAllSkills());
    }

    @PostMapping("/")
    public ResponseEntity saveSkills(@RequestBody SkillsDto skill){
       boolean saved= skillServices.save(skill);
       if (saved){
           return ResponseEntity.status(HttpStatus.CREATED).build();
       }
       return ResponseEntity.status(HttpStatus.ALREADY_REPORTED).build();
    }

    @DeleteMapping("/{id}")
    public void deleteSkill(@PathVariable("id") Long id){
         skillServices.delete(id);
    }

    @PostMapping("/{skill}/{subskill}")
    public void addSubCategory(@PathVariable("skill") String skill,@PathVariable("subskill") String subskill){

        skillServices.save(skill,subskill);
    }

    @DeleteMapping("/{skill}/{subskill}")
    public void deleteSubCategory(@PathVariable("skill") String skill,@PathVariable("subskill") String subskill){
        skillServices.delete(skill,subskill);
    }

}

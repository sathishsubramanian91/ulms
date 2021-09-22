package com.ulms.app.company.controller;

import com.ulms.app.company.dto.EmployerJobRequestDto;
import com.ulms.app.company.services.JobRequestServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/job")
public class JobsController {

    @Autowired
    JobRequestServices jobRequestServices;


    @PostMapping("/request")
    public ResponseEntity postJob(@RequestBody List<EmployerJobRequestDto> jobRequest){
       Boolean isPosted= jobRequestServices.postJob(jobRequest);
       return isPosted ? ResponseEntity.accepted().build() : ResponseEntity.status(500).build();
    }





}

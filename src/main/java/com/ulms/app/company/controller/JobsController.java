package com.ulms.app.company.controller;

import com.ulms.app.company.dto.EmployerJobRequestDto;
import com.ulms.app.company.dto.JobRequestResponseDto;
import com.ulms.app.company.services.JobRequestServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/job")
public class JobsController {

    @Autowired
    JobRequestServices jobRequestServices;


    @PostMapping("/request")
    public ResponseEntity<String> postJob(@RequestBody List<EmployerJobRequestDto> jobRequest){
       Long postId= jobRequestServices.postJob(jobRequest);
       return new ResponseEntity<>("Request ID: "+postId, HttpStatus.ACCEPTED);
    }
    @GetMapping("/request")
    public ResponseEntity<JobRequestResponseDto> getAllRequests(){
      List<JobRequestResponseDto> jobRequests=jobRequestServices.getRequests();

      return new ResponseEntity(jobRequests,HttpStatus.OK);

    }





}

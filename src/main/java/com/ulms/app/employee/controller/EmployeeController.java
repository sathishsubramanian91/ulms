package com.ulms.app.employee.controller;

import com.ulms.app.employee.dto.EmployeeDto;
import com.ulms.app.employee.services.EmployeeServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/emp")
public class EmployeeController {

    @Autowired
    private EmployeeServices employeeServices;

    @PostMapping("/")
    public ResponseEntity<EmployeeDto> register(@RequestBody EmployeeDto employeeDto){

       EmployeeDto emp= employeeServices.saveOrUpdate(employeeDto);

       return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(emp);
    }
    @GetMapping("/")
    public ResponseEntity<List<EmployeeDto>> getAllEmp(){
       return ResponseEntity.ok(employeeServices.getAllEmp());
    }

    @PutMapping("/")
    public ResponseEntity<EmployeeDto> update(@RequestBody EmployeeDto employeeDto){
        EmployeeDto emp= employeeServices.saveOrUpdate(employeeDto);
        return  ResponseEntity.status(HttpStatus.CREATED).body(emp);
    }

}

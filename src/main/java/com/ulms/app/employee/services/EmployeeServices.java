package com.ulms.app.employee.services;

import com.ulms.app.employee.dto.EmployeeDto;
import com.ulms.app.employee.entity.EmployeEntity;
import com.ulms.app.employee.repo.EmployeRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class EmployeeServices {

    @Autowired
    EmployeRepository employeRepository;

    @Autowired
    ModelMapper modelMapper;


    @Transactional
    public EmployeeDto saveOrUpdate(EmployeeDto employeeDto) {


       EmployeEntity emp= modelMapper.map(employeeDto, EmployeEntity.class);
       if(emp.getId() == null){
          emp= employeRepository.saveAndFlush(emp);
          String uniqueId= String.format("EMP_%d",emp.getId());
          emp.setUniqueId(uniqueId);
       }else{
           emp =employeRepository.saveAndFlush(emp);
       }

       EmployeeDto employeeDto1= modelMapper.map(emp, EmployeeDto.class);
       return employeeDto1;
    }

    public List<EmployeeDto> getAllEmp() {

       List<EmployeEntity> emps=employeRepository.findAll();
       return emps.stream().map(each -> modelMapper.map(each,EmployeeDto.class)).collect(Collectors.toList());

    }
}

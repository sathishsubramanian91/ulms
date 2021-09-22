package com.ulms.app.company.services;

import com.ulms.app.company.dto.EmployerJobRequestDto;
import com.ulms.app.company.entity.EmployerJobRequest;
import com.ulms.app.company.repo.EmployerJobRequestRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class JobRequestServices {

    @Autowired
    EmployerJobRequestRepository jobRequestRepository;

    @Autowired
    ModelMapper modelMapper;

    public Boolean postJob(List<EmployerJobRequestDto> jobRequest) {
       List<EmployerJobRequest> employerRequest= jobRequest.stream().map(each -> modelMapper.map(each,EmployerJobRequest.class)).collect(Collectors.toList());
        jobRequestRepository.saveAll(employerRequest);
        return  true;
    }

    public List<EmployerJobRequestDto> getAllJob(){
        List<EmployerJobRequest> jobRequests=jobRequestRepository.findAll();
       return jobRequests.stream().map(each -> modelMapper.map(each, EmployerJobRequestDto.class)).collect(Collectors.toList());
    }
    public Boolean deleteJobRequest(Long id){
        try {
            jobRequestRepository.deleteById(id);
        }catch(Exception ex){
            System.out.println("Exception occured "+ex);
            return false;
        }
        return true;
    }


}

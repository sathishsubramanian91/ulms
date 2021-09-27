package com.ulms.app.company.services;

import com.ulms.app.company.dto.EmployerJobRequestDto;
import com.ulms.app.company.entity.EmployerJobRequest;
import com.ulms.app.company.entity.JobRequestEntity;
import com.ulms.app.company.repo.EmployerJobRequestRepository;
import com.ulms.app.company.repo.JobRequestEntityRepository;
import com.ulms.app.security.services.AppUserDetails;
import com.ulms.app.user.entity.UserDetailEntity;
import com.ulms.app.user.repo.UserDetailRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class JobRequestServices {

    @Autowired
    EmployerJobRequestRepository jobRequestRepository;

    @Autowired
    UserDetailRepository userDetailRepository;

    @Autowired
    JobRequestEntityRepository jobRequestEntityRepository;

    @Autowired
    ModelMapper modelMapper;

    @Transactional
    public Boolean postJob(List<EmployerJobRequestDto> jobRequest) {
        JobRequestEntity jobRequestPage=new JobRequestEntity();
        AppUserDetails appUserDetails= (AppUserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        String username= appUserDetails.getUsername();
        Optional<UserDetailEntity> userDetailEntity=userDetailRepository.findByUsername(username);
       if( userDetailEntity.isEmpty())
           throw new RuntimeException("User is not found, can't create a request");
        if(userDetailEntity.get().getIsActivated() == false)
            throw new RuntimeException("User is not activated. please re-activate again and request");

        jobRequestPage.setUser(userDetailEntity.get());

        jobRequestPage= jobRequestEntityRepository.save(jobRequestPage);

        Long requestId= jobRequestPage.getId();

        List<EmployerJobRequest> employerRequest= jobRequest.stream()
                .map(each -> modelMapper.map(each,EmployerJobRequest.class))
                .map(request -> {request.setRequestId(requestId); return request;})
                .collect(Collectors.toList());
        jobRequestPage.setJobRequestList(jobRequestRepository.saveAll(employerRequest));

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

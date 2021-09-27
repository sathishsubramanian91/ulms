package com.ulms.app.company.services;

import com.ulms.app.company.dto.EmployerJobRequestDto;
import com.ulms.app.company.dto.JobRequestResponseDto;
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
import java.sql.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

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
    public Long postJob(List<EmployerJobRequestDto> jobRequest) {
        JobRequestEntity jobRequestPage=new JobRequestEntity();
        AppUserDetails appUserDetails= (AppUserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        String username= appUserDetails.getUsername();
        Optional<UserDetailEntity> userDetailEntity=userDetailRepository.findByUsername(username);
       if( userDetailEntity.isEmpty())
           throw new RuntimeException("User is not found, can't create a request");
        if(userDetailEntity.get().getIsActivated() == false)
            throw new RuntimeException("User is not activated. please re-activate again and request");

        jobRequestPage.setUser(userDetailEntity.get());
        jobRequestPage.setRequestedDate(new Date(System.currentTimeMillis()));
        jobRequestPage.setStatus("New");
        jobRequestPage= jobRequestEntityRepository.save(jobRequestPage);

        Long requestId= jobRequestPage.getId();

        List<EmployerJobRequest> employerRequest= jobRequest.stream()
                .map(each -> modelMapper.map(each,EmployerJobRequest.class))
                .map(request -> {request.setRequestId(requestId); return request;})
                .collect(Collectors.toList());
        jobRequestPage.setJobRequestList(jobRequestRepository.saveAll(employerRequest));

        return jobRequestPage.getId();
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


    @Transactional
    public List<JobRequestResponseDto> getRequests() {

      AppUserDetails appUserDetails=(AppUserDetails) SecurityContextHolder.getContext().
             getAuthentication().getPrincipal();
      String username=appUserDetails.getUsername();
      UserDetailEntity userDetailEntity= userDetailRepository.findByUsername(username).get();
      Long id=userDetailEntity.getId();
      List<JobRequestEntity> jobRequestEntities= jobRequestEntityRepository.findRequestByUserId(id);
      return convertToJobRequestsDto(jobRequestEntities);

    }

    private List<JobRequestResponseDto> convertToJobRequestsDto(List<JobRequestEntity> jobRequestEntities) {

        return jobRequestEntities.stream().flatMap(s -> Stream.ofNullable(s)).
                map(each -> {
                    JobRequestResponseDto responseDto=new JobRequestResponseDto();
                    responseDto.setRaisedBy(each.getUser().getUsername());
                    responseDto.setRaisedOn(each.getRequestedDate());
                    responseDto.setStatus(each.getStatus());
                    responseDto.setRequests( each.getJobRequestList().stream()
                            .flatMap(m -> Stream.ofNullable(m)).map(
                                    request -> {
                                        EmployerJobRequestDto request1=new EmployerJobRequestDto();
                                        request1.setId(request.getId());
                                        request1.setAccommodation(request.getAccommodation());
                                        request1.setDescription(request.getDescription());
                                        request1.setFoodProvided(request.getFoodProvided());
                                        request1.setNoOfPplRequired(request.getNoOfPplRequired());
                                        request1.setSalary(request.getSalary());
                                        request1.setSalaryType(request.getSalaryType());
                                        request1.setSkills(request.getSkills());
                                        request1.setRequiredFromDate(request.getRequiredFromDate());
                                        request1.setRequiredToDate(request.getRequiredToDate());
                                        return request1;
                                    }
                            ).collect(Collectors.toList()));
                    return responseDto;
                }).collect(Collectors.toList());

    }
}

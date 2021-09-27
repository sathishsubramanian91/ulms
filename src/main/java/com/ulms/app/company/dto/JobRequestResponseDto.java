package com.ulms.app.company.dto;

import com.ulms.app.company.entity.EmployerJobRequest;
import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
public class JobRequestResponseDto {
    private String raisedBy;
    private Date raisedOn;
    private String status;
    private List<EmployerJobRequestDto> requests;
}

package com.ulms.app.company.services;


import com.ulms.app.dto.CompanyDetails;
import com.ulms.app.company.repo.CompanyDetailsRepository;
import com.ulms.app.company.entity.CompanyEntity;
import com.ulms.app.user.entity.UserDetailEntity;
import com.ulms.app.user.repo.UserDetailRepository;
import com.ulms.app.security.services.AppUserDetails;
import com.ulms.app.util.ConvertToEntity;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
public class CompanyServices {

    @Autowired
    UserDetailRepository userDetailRepository;

    @Autowired
    ModelMapper modelMapper;

    @Autowired
    ConvertToEntity convertToEntity;

    @Autowired
    CompanyDetailsRepository companyDetailsRepository;

    @Transactional
    public CompanyDetails register(CompanyDetails companyDetails) {

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        AppUserDetails user = (AppUserDetails) authentication.getPrincipal();

        UserDetailEntity userDetailEntity = userDetailRepository.findByUsername(user.getUsername()).get();
        CompanyEntity companyEntity = convertToEntity.convert(companyDetails);
        companyEntity.setUserDetailEntity(userDetailEntity);

        CompanyEntity companyEntity1 = companyDetailsRepository.saveAndFlush(companyEntity);
        if(companyEntity1.getUniqueId()==null)
            companyEntity1.setUniqueId("ORG_"+companyEntity1.getId());
        return convertToEntity.convert(companyEntity1);
    }

}

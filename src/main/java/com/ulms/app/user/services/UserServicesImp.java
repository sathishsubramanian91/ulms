package com.ulms.app.user.services;

import com.ulms.app.dto.OrgSignUpRequest;
import com.ulms.app.user.entity.UserDetailEntity;
import com.ulms.app.user.repo.UserDetailRepository;
import com.ulms.app.util.mail.MailServices;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@Slf4j
public class UserServicesImp implements UserServices {



    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    @Autowired
    private UserDetailRepository userDetailRepository;


    @Autowired
    private MailServices mailServices;



    @Override
    public boolean register(OrgSignUpRequest signUpRequest) {
        Optional<UserDetailEntity> userDetailOptional = userDetailRepository.findByUsername(signUpRequest.getUsername());
        if (userDetailOptional.isPresent())
            throw new RuntimeException("User exists already");
        try {
            UserDetailEntity userDetailEntity = new UserDetailEntity();
            userDetailEntity.setUsername(signUpRequest.getUsername());
            userDetailEntity.setOrgName(signUpRequest.getOrgName());
            userDetailEntity.setPassword(passwordEncoder.encode(signUpRequest.getPassword()));
            userDetailEntity.setRole(signUpRequest.getRole());
            userDetailEntity.setEmail(signUpRequest.getEmail());
            userDetailEntity.setIsActive(true);
            userDetailEntity.setIsActivated(false);
            userDetailEntity = userDetailRepository.saveAndFlush(userDetailEntity);
            sendmail(userDetailEntity);
        }catch(Exception ex){
            ex.printStackTrace();
            return false;
        }
        return true;
    }

    @Override
    public boolean verifyun(String username) {
        Optional<UserDetailEntity> userDetailOptional = userDetailRepository.findByUsername(username);
        return userDetailOptional.isPresent() ? true : false;
    }

    private void sendmail(UserDetailEntity userDetailEntity) {

        SimpleMailMessage message=new SimpleMailMessage();
        message.setTo(userDetailEntity.getUsername());
        message.setFrom(userDetailEntity.getEmail());
        message.setSubject("Activate your account!!!");
        message.setText("Hi "+userDetailEntity.getUsername()+"\n"+"\tPlease click the link http://localhost:8081/api/v1/mail/activate/"+userDetailEntity.getId()+" to activate your account\n Thanks \n\nRegards\nAdmin ");
        mailServices.sendMail(message);
    }
}




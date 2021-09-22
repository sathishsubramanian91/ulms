package com.ulms.app.util.mail;

import com.ulms.app.user.entity.UserDetailEntity;
import com.ulms.app.user.repo.UserDetailRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping("/api/v1/mail")
public class MailController {

    @Autowired
    private UserDetailRepository userDetailRepository;


    @GetMapping("/activate/{id}")
    public ResponseEntity activate(@PathVariable Long id){

        Optional<UserDetailEntity> user=userDetailRepository.findById(id);
        if(!user.isEmpty()){
            if(user.get().getIsActivated()){
                return ResponseEntity.ok("Account is already activated");
            }
            user.get().setIsActivated(true);
            user.get().setIsActive(true);
            userDetailRepository.saveAndFlush(user.get());
        }else{
            return ResponseEntity.ok("User is not present in DB");
        }


        return ResponseEntity.ok("Account has been activated!!!");
    }

}

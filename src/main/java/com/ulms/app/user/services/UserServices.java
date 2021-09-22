package com.ulms.app.user.services;

import com.ulms.app.dto.OrgSignUpRequest;

public interface UserServices {
    boolean register(OrgSignUpRequest signUpRequest);
    boolean verifyun(String username);

}

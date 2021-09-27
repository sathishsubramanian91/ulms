package com.ulms.app.user.services;

import com.ulms.app.dto.SignUp;

public interface UserServices {
    boolean register(SignUp signUpRequest);
    boolean verifyun(String username);

}

package com.project.registration.registration.Service;

import com.project.registration.registration.Models.User;
import com.project.registration.registration.Web.UserRegistrationDTO;

public interface UserService {
    User Save(UserRegistrationDTO userRegistrationDTO);
}

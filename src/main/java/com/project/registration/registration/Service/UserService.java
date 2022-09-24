package com.project.registration.registration.Service;

import com.project.registration.registration.Models.User;
import com.project.registration.registration.Web.UserRegistrationDTO;

import java.security.NoSuchAlgorithmException;

public interface UserService {
    User Save(UserRegistrationDTO userRegistrationDTO) throws NoSuchAlgorithmException;
}

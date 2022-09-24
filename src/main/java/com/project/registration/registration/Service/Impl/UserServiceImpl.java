package com.project.registration.registration.Service.Impl;

import com.project.registration.registration.Models.Role;
import com.project.registration.registration.Models.User;
import com.project.registration.registration.Repository.UserRepository;
import com.project.registration.registration.Service.UserService;
import com.project.registration.registration.Web.UserRegistrationDTO;
import org.springframework.stereotype.Service;

import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;

import static com.project.registration.registration.Config.Utils.getSHA;

@Service
public class UserServiceImpl implements UserService {

    private UserRepository _userRepository;

    public UserServiceImpl(UserRepository userRepository){
        super();
        this._userRepository = userRepository;
    }
    @Override
    public User Save(UserRegistrationDTO userRegistrationDTO) throws NoSuchAlgorithmException {
        User user = new User(userRegistrationDTO.getFirstName(),
                userRegistrationDTO.getLastName(),
                userRegistrationDTO.getEmail(), String.valueOf(getSHA(userRegistrationDTO.getPassword())),
                (Collection<Role>) Arrays.asList(new Role("ROLE_USER")));

        System.out.println(user.toString());
        return _userRepository.save(user);
    }
}

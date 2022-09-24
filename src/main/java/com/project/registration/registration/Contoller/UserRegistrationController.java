package com.project.registration.registration.Contoller;

import com.project.registration.registration.Service.UserService;
import com.project.registration.registration.Web.UserRegistrationDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.security.NoSuchAlgorithmException;

@Service
@Controller
@RequestMapping("/registration")
public class UserRegistrationController {

    private UserService _userService;

    public UserRegistrationController(UserService userService){
        super();
        this._userService = userService;
    }

    @ModelAttribute("user")
    public UserRegistrationDTO userRegistrationDTO(){
        return new UserRegistrationDTO();
    }


    @GetMapping
    public String showRegistrationForm(Model model){
        model.addAttribute("user",new UserRegistrationDTO());
        return "registration";
    }

    @PostMapping
    public String registerUserAccount(@ModelAttribute("user")UserRegistrationDTO registrationDto) throws NoSuchAlgorithmException {
        System.out.println(registrationDto.toString());
        _userService.Save(registrationDto);
        return "redirect:/registration?success";
    }
}

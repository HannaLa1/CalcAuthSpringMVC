package spring.application.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import spring.application.entity.User;
import spring.application.service.AuthorizationService;

import java.util.Random;

@Controller
@RequestMapping("/registration")
public class RegistrationController {
    private final AuthorizationService storage;

    @Autowired
    public RegistrationController(AuthorizationService storage) {
        this.storage = storage;
    }

    @GetMapping
    public String registrationPage(){
        return "registration";
    }

    @PostMapping
    public String registration(@ModelAttribute("login") String login,
                               @ModelAttribute("password1") String password1,
                               @ModelAttribute("password2") String password2,
                               @ModelAttribute("submit") String submitType,
                               @ModelAttribute("userName") String username,
                               Model model){

        User user = storage.getData(login, password1);

        if (password1.equals(password2)){
            if (submitType.equals("registr")) {
                user.setLogin(login);
                user.setPassword(password1);
                user.setUserName(username);
                user.setRole(String.valueOf(User.Role.values()[new Random().nextInt(User.Role.values().length)]));

                storage.insertData(user);

                model.addAttribute("successMessage", "Registration done successfully, now you can LogIn..");
                return "login";
            }
        }else {
            model.addAttribute("mess", "Confirm the password again...");
            return "registration";
        }

        return "registration";
    }
}

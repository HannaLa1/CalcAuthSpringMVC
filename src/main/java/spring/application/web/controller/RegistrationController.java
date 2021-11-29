package spring.application.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import spring.application.entity.User;
import spring.application.service.AuthorizationService;

import javax.validation.Valid;
import java.util.Random;

@Controller
@RequestMapping("/registration")
public class RegistrationController {
    private final AuthorizationService authorizationService;

    public RegistrationController(AuthorizationService authorizationService) {
        this.authorizationService = authorizationService;
    }

    @GetMapping
    public ModelAndView registrationPage(ModelAndView modelAndView){
        modelAndView.setViewName("registration");
        return modelAndView;
    }

    @PostMapping
    public ModelAndView registration(@Valid User user, BindingResult bindingResult,
                                     @ModelAttribute("submit") String submitType,
                                     ModelAndView modelAndView){
        if (bindingResult.hasErrors()){
            modelAndView.setViewName("registration");
            return modelAndView;
        }

        if (submitType.equals("registr")) {
            user.setRole(String.valueOf(User.Role.values()[new Random().nextInt(User.Role.values().length)]));

            authorizationService.insertData(user);

            modelAndView.setViewName("login");
            modelAndView.addObject("successMessage", "Registration done successfully, now you can LogIn..");
            return modelAndView;
        }else {
            modelAndView.setViewName("registration");
            modelAndView.addObject("mess", "Confirm the password again...");
        }

        modelAndView.setViewName("registration");
        return modelAndView;
    }
}

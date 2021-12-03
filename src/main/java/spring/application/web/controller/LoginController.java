package spring.application.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import spring.application.entity.Role;
import spring.application.entity.User;
import spring.application.service.AuthorizationService;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

@Controller
@RequestMapping("/login")
public class LoginController {
    private final AuthorizationService authorizationService;

    public LoginController(AuthorizationService authorizationService) {
        this.authorizationService = authorizationService;
    }

    @GetMapping
    public ModelAndView loginPage(ModelAndView modelAndView) {
        modelAndView.setViewName("login");
        return modelAndView;
    }

    @PostMapping
    public ModelAndView login(@Valid User user, BindingResult bindingResult,
                              @ModelAttribute("submit") String submitType,
                              ModelAndView modelAndView, HttpSession session) {

        User u = authorizationService.findByLogAndPass(user.getLogin(), user.getPassword());

        if (bindingResult.hasErrors())
        {
            modelAndView.setViewName("login");
            return modelAndView;
        }

        if (submitType.equals("logIn") && u != null && u.getUserName() != null) {
            session.setAttribute("user", u);

            if (u.getRole().name().equals("ADMIN")) {
                modelAndView.setViewName("redirect:/admin");
            } else if (u.getRole().name().equals("USER")) {
                modelAndView.setViewName("redirect:/calc");
            }
        } else {
            modelAndView.addObject("msg", "Exist Registered user, please Registration..!!");
            modelAndView.setViewName("registration");
        }

        return modelAndView;
    }
}

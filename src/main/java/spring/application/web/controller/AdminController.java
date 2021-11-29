package spring.application.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import spring.application.entity.User;
import spring.application.service.AuthorizationService;

import java.util.List;

@Controller
@RequestMapping("/admin")
public class AdminController {
    private final AuthorizationService authorizationService;

    public AdminController(AuthorizationService authorizationService) {
        this.authorizationService = authorizationService;
    }

    @GetMapping
    public ModelAndView adminPage(ModelAndView modelAndView){
        List<User> userList = authorizationService.getAllUsers();
        modelAndView.setViewName("admin");
        modelAndView.addObject("userList", userList);

        return modelAndView;
    }
}

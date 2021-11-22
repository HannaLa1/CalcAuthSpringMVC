package spring.application.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import spring.application.entity.User;
import spring.application.service.AuthorizationService;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/login")
public class LoginController {
    private final AuthorizationService storage;

    @Autowired
    public LoginController(AuthorizationService storage) {
        this.storage = storage;
    }

    @GetMapping
    public String loginPage(Model model){
        return "login";
    }

    @PostMapping
    public String login(@ModelAttribute("login") String login,
                        @ModelAttribute("password1") String password,
                        @ModelAttribute("submit") String submitType,
                        Model model, HttpSession session){
        User user = storage.getData(login, password);

        if (submitType.equals("logIn") && user != null && user.getUserName() != null) {
            session.setAttribute("user", user);
            session.setAttribute("userId", user.getId());
            session.setAttribute("username", user.getUserName());

            if(user.getRole().equals("ADMIN")){
                return "redirect:/admin";
            }else if(user.getRole().equals("USER")){
                return "redirect:/calc";
            }
        } else if (submitType.equals("registration")) {
            return "registration";
        } else {
            model.addAttribute("message", "Exist Registered user, please Registration..!!");
            return "registration";
        }

        return "login";
    }
}

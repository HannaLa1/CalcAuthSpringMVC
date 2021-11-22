package spring.application.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import spring.application.entity.User;
import spring.application.service.AuthorizationService;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequestMapping("/admin")
public class AdminController {
    private final AuthorizationService storage;

    @Autowired
    public AdminController(AuthorizationService storage) {
        this.storage = storage;
    }

    @GetMapping
    public String adminPage(HttpSession session){
        List<User> userList = storage.getAllUsers();
        session.setAttribute("userList", userList);

        return "admin";
    }
}

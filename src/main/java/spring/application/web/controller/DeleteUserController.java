package spring.application.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import spring.application.service.AuthorizationService;
import spring.application.service.CalcService;

@Controller
@RequestMapping("/deleteUser")
public class DeleteUserController {
    private final AuthorizationService authorizationService;

    public DeleteUserController(AuthorizationService authorizationService) {
        this.authorizationService = authorizationService;
    }

    @GetMapping("/{id}")
    public ModelAndView deleteUserPage(@PathVariable("id") long id, ModelAndView modelAndView){
        authorizationService.delete(id);
        modelAndView.setViewName("redirect:/admin");

        return modelAndView;
    }
}

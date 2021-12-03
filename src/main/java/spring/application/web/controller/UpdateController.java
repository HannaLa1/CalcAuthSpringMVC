package spring.application.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import spring.application.service.AuthorizationService;

@Controller
@RequestMapping("/update")
public class UpdateController {
    private final AuthorizationService authorizationService;

    public UpdateController(AuthorizationService authorizationService) {
        this.authorizationService = authorizationService;
    }

    @GetMapping("/{id}")
    public ModelAndView updatePage(@PathVariable("id") long id, ModelAndView modelAndView){
        modelAndView.setViewName("update");
        return modelAndView;
    }

    @PostMapping("/{id}")
    public ModelAndView update(@PathVariable("id") long id, String password, ModelAndView modelAndView){
        authorizationService.update(id, password);
        modelAndView.setViewName("redirect:/admin");

        return modelAndView;
    }
}

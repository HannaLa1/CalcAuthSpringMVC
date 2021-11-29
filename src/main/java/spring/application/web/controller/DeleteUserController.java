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
    private final CalcService calcService;

    public DeleteUserController(AuthorizationService authorizationService, CalcService calcService) {
        this.authorizationService = authorizationService;
        this.calcService = calcService;
    }

    @GetMapping("/{id}")
    public ModelAndView deleteUserPage(@PathVariable("id") int id, ModelAndView modelAndView){
        calcService.deleteByUserId(id);
        authorizationService.deleteData(id);
        modelAndView.setViewName("redirect:/admin");

        return modelAndView;
    }
}

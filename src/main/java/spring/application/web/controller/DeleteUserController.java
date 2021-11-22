package spring.application.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import spring.application.service.AuthorizationService;
import spring.application.service.CalcService;

@Controller
@RequestMapping("/deleteUser")
public class DeleteUserController {
    private final AuthorizationService storage;
    private final CalcService calcService;

    @Autowired
    public DeleteUserController(AuthorizationService storage, CalcService calcService) {
        this.storage = storage;
        this.calcService = calcService;
    }

    @GetMapping("/{id}")
    public String deleteUserPage(@PathVariable("id") int id){

        calcService.deleteByUserId(id);
        storage.deleteData(id);
        return "redirect:/admin";
    }
}

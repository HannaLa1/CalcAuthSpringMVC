package spring.application.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import spring.application.service.AuthorizationService;

@Controller
@RequestMapping("/update")
public class UpdateController {
    private final AuthorizationService storage;

    @Autowired
    public UpdateController(AuthorizationService storage) {
        this.storage = storage;
    }

    @GetMapping("/{id}")
    public String updatePage(@PathVariable("id") int id, Model model){
        model.addAttribute("id", id);
        return "update";
    }

    @PostMapping("/{id}")
    public String update(@PathVariable("id") int id, @ModelAttribute("password") String password,
                         @ModelAttribute("submit") String submitType){
        if (submitType.equals("Submit")){
            storage.update(id, password);
        }

        return "redirect:/admin";
    }
}

package spring.application.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import spring.application.service.CalcService;

@Controller
@RequestMapping("/delete")
public class DeleteController {
    private final CalcService storage;

    @Autowired
    public DeleteController(CalcService storage) {
        this.storage = storage;
    }

    @GetMapping("/{id}")
    public String deletePage(@PathVariable("id") int id){
        storage.deleteData(id);

        return "redirect:/calc";
    }
}

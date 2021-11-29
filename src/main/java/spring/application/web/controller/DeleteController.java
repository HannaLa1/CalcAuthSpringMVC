package spring.application.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import spring.application.service.CalcService;

@Controller
@RequestMapping("/delete")
public class DeleteController {
    private final CalcService calcService;

    public DeleteController(CalcService calcService) {
        this.calcService = calcService;
    }

    @GetMapping("/{id}")
    public ModelAndView deletePage(@PathVariable("id") int id, ModelAndView modelAndView){
        calcService.deleteData(id);
        modelAndView.setViewName("redirect:/calc");

        return modelAndView;
    }
}

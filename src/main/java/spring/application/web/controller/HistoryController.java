package spring.application.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import spring.application.entity.Operation;
import spring.application.service.CalcService;

import java.util.List;

@Controller
@RequestMapping("/history")
public class HistoryController {
    private final CalcService calcService;

    public HistoryController(CalcService calcService) {
        this.calcService = calcService;
    }

    @GetMapping("/{id}")
    public ModelAndView historyPage(@PathVariable("id") int id, ModelAndView modelAndView){
        //List<Operation> operationList = calcService.getData(id);
        modelAndView.setViewName("history");
        //modelAndView.addObject("operations", operationList);

        return modelAndView;
    }
}

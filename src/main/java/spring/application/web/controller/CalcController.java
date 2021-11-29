package spring.application.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import spring.application.entity.Operation;
import spring.application.entity.User;
import spring.application.service.CalcService;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequestMapping("/calc")
public class CalcController {
    private final CalcService calcService;

    public CalcController(CalcService calcService) {
        this.calcService = calcService;
    }

    @GetMapping
    public ModelAndView calcPage(ModelAndView modelAndView, HttpSession session){
        int id = (((User) session.getAttribute("user")).getId());

        List<Operation> operationList = calcService.getData(id);
        modelAndView.setViewName("calc");
        modelAndView.addObject("operationList", operationList);

        return modelAndView;
    }

    @PostMapping
    public ModelAndView calc(Operation op, @ModelAttribute("submit") String operation,
                       ModelAndView modelAndView, HttpSession session){
        int id = (((User) session.getAttribute("user")).getId());

        double result = calcService.doOperation(id, op.getNum1(), op.getNum2(), operation);
        modelAndView.addObject("result", result);

        List<Operation> operationList = calcService.getData(id);
        modelAndView.setViewName("calc");
        modelAndView.addObject("operationList", operationList);

        return modelAndView;
    }
}

package spring.application.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import spring.application.entity.Operation;
import spring.application.service.CalcService;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequestMapping("/calc")
public class CalcController {
    private final CalcService storage;

    @Autowired
    public CalcController(CalcService storage) {
        this.storage = storage;
    }

    @GetMapping
    public String calcPage(HttpSession session){

        int id = (int) session.getAttribute("userId");
        List<Operation> operationList = storage.getData(id);
        session.setAttribute("operationList", operationList);

        for (Operation op : operationList) {
            session.setAttribute("operationId", op.getId());
        }

        return "calc";
    }

    @PostMapping
    public String calc(@ModelAttribute("num1") double num1,
                       @ModelAttribute("num2") double num2,
                       @ModelAttribute("submit") String operation,
                       HttpSession session){
        int id = (int) session.getAttribute("userId");

        double result = storage.doOperation(num1, num2, operation);
        session.setAttribute("result", result);
        storage.insertData(new Operation(id, num1, num2, result, operation));

        List<Operation> operationList = storage.getData(id);
        session.setAttribute("operationList", operationList);

        return "calc";
    }
}

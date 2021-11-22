package spring.application.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import spring.application.entity.Operation;
import spring.application.service.CalcService;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequestMapping("/history")
public class HistoryController {
    private final CalcService storage;

    @Autowired
    public HistoryController(CalcService storage) {
        this.storage = storage;
    }

    @GetMapping("/{id}")
    public String historyPage(@PathVariable("id") int id, HttpSession session){
        List<Operation> operationList = storage.getData(id);
        session.setAttribute("operations", operationList);

        return "history";
    }
}

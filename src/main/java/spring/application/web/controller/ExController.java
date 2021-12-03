package spring.application.web.controller;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

@ControllerAdvice
public class ExController {

    @ExceptionHandler(NullPointerException.class)
    public ModelAndView error(ModelAndView modelAndView){
        modelAndView.setViewName("redirect:/error");
        return modelAndView;
    }
}

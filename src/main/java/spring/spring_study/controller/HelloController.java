package spring.spring_study.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HelloController {
    @GetMapping("hello") //url 매핑
    public String hello(Model model){
        model.addAttribute("data","hello!!"); //키-data, data-"hello!!"
        return "hello"; //resources:templets->(ViewName)hello.html 로 매핑
    }
}

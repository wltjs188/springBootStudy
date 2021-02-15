package spring.spring_study.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import spring.spring_study.domain.Member;

@Controller
public class HomeController {
    @GetMapping("/")
    public String home(){
        return "home";
    }
}

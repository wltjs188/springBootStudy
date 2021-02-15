package spring.spring_study.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import spring.spring_study.service.MemberService;

@Controller
public class MemberController {
    private final MemberService memberService;

    @Autowired //스프링컨테이너에 있는 memberService 넣어줌 (의존성 주입)
    public MemberController(MemberService memberService){
        this.memberService = memberService;
    }
}

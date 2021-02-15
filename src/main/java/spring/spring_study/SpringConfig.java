package spring.spring_study;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import spring.spring_study.domain.Member;
import spring.spring_study.repository.MemberRepository;
import spring.spring_study.repository.MemoryMemberRepository;
import spring.spring_study.service.MemberService;

@Configuration //자바 코드로 직접 스프링 빈 등록
public class SpringConfig {
    
    @Bean
    public MemberService memberService(){
        return new MemberService(memberRepository());
    }
    @Bean
    public MemberRepository memberRepository(){
        return new MemoryMemberRepository();
    }
}

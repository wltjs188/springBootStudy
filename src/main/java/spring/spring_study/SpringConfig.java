package spring.spring_study;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import spring.spring_study.repository.JdbcMemberRepository;
import spring.spring_study.repository.JdbcTemplateMemberRepository;
import spring.spring_study.repository.JpaMemberRepository;
import spring.spring_study.repository.MemberRepository;
import spring.spring_study.service.MemberService;

import javax.persistence.EntityManager;
import javax.sql.DataSource;

@Configuration //자바 코드로 직접 스프링 빈 등록
public class SpringConfig {

/*    private DataSource dataSource;

    @Autowired //스프링이 자체적으로 DataSource 넣어줌
    public SpringConfig(DataSource dataSource) {
        this.dataSource = dataSource;
    }*/

    @Autowired
    private EntityManager em;

    public SpringConfig(EntityManager em) {
        this.em = em;
    }

    @Bean
    public MemberService memberService(){
        return new MemberService(memberRepository());
    }
    @Bean
    public MemberRepository memberRepository(){
//        return new MemoryMemberRepository();
//        return new JdbcMemberRepository(dataSource);
//        return new JdbcTemplateMemberRepository(dataSource);
        return new JpaMemberRepository(em);
    }

}
package spring.spring_study;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import spring.spring_study.aop.TimeTraceAop;
import spring.spring_study.repository.JdbcMemberRepository;
import spring.spring_study.repository.JdbcTemplateMemberRepository;
import spring.spring_study.repository.JpaMemberRepository;
import spring.spring_study.repository.MemberRepository;
import spring.spring_study.service.MemberService;

import javax.persistence.EntityManager;
import javax.sql.DataSource;
import java.sql.Time;

@Configuration //자바 코드로 직접 스프링 빈 등록
public class SpringConfig {

/*    private DataSource dataSource; //jdbc,jdbcTemplate

    @Autowired //스프링이 자체적으로 DataSource 넣어줌
    public SpringConfig(DataSource dataSource) {
        this.dataSource = dataSource;
    }*/

/*    @Autowired //jpa
    private EntityManager em;

    public SpringConfig(EntityManager em) {
        this.em = em;
    }*/

    private final MemberRepository memberRepository;
    @Autowired
    public SpringConfig(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    @Bean
    public MemberService memberService(){
        return new MemberService(memberRepository);
    }

/* aop
    @Bean
    public TimeTraceAop timeTraceAop(){
        return new TimeTraceAop();
    }
*/

/*    @Bean
    public MemberRepository memberRepository() {
//        return new MemoryMemberRepository();
//        return new JdbcMemberRepository(dataSource);   jdbc
//        return new JdbcTemplateMemberRepository(dataSource);   jdbcTemplate
//        return new JpaMemberRepository(em);   jpa

    }*/

}
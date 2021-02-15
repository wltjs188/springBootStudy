package spring.spring_study.service;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;
import spring.spring_study.domain.Member;
import spring.spring_study.repository.MemberRepository;
import spring.spring_study.repository.MemoryMemberRepository;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

@SpringBootTest
@Transactional //rollback
class MemberServiceIntegrationTest {

    @Autowired MemberRepository memberRepository;
    @Autowired MemberService memberService;

    @Test
    void 회원가입() { //테스트는 한글로 적어도 무방함
        //give
        Member member = new Member();
        member.setName("spring3");

        //when
        Long saveId = memberService.join(member);

        //then
        Member findMembers = memberService.findOne(saveId).get();
        assertThat(member.getName()).isEqualTo(findMembers.getName());
    }
    @Test
    public void 중복_회원_예외(){

        Member member1 = new Member();
        member1.setName("spring");

        Member member2 = new Member();
        member2.setName("spring");

        memberService.join(member1);

        IllegalStateException e = assertThrows(IllegalStateException.class, () -> memberService.join(member2));

    }


    @Test
    void findMembers() {
    }

    @Test
    void findOne() {
    }
}
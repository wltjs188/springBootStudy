package spring.spring_study.service;

import org.junit.Before;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import spring.spring_study.domain.Member;
import spring.spring_study.repository.MemoryMemberRepository;
import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertThrows;


class MemberServiceTest {

    MemoryMemberRepository memberRepository;
    MemberService memberService;

    @BeforeEach //@Test단위 실행 전 반복
    public void BeforeEach(){
        memberRepository = new MemoryMemberRepository();
        memberService = new MemberService(memberRepository);
    }
    @AfterEach //@Test단위 실행 후 반복
    public void AfterEach(){
        memberRepository.clearStore(); //테스트가 끝날때마다 데이터 지워줌
    }


    @Test
    void 회원가입() { //테스트는 한글로 적어도 무방함
        //give
        Member member = new Member();
        member.setName("hello");

        //when
        Long saveId = memberService.join(member);

        //then
        Member findMembers = memberService.findOne(saveId).get();
        assertThat(member.getName()).isEqualTo(findMembers.getName());
    }
    @Test
    public void 중복_회원_예외(){
        //given
        Member member1 = new Member();
        member1.setName("spring");

        Member member2 = new Member();
        member2.setName("spring");

        //when
/*
        memberService.join(member1);
        try {
            memberService.join(member2);
        }catch (IllegalStateException e){
            assertThat(e.getMessage()).isEqualTo("이미 존재하는 회원입니다.");
        }
/*
 try-catch 사용하지 않고 assertThrows 사용
 */
        memberService.join(member1);
        IllegalStateException e = assertThrows(IllegalStateException.class, () -> memberService.join(member2));

        //then
    }


    @Test
    void findMembers() {
    }

    @Test
    void findOne() {
    }
}
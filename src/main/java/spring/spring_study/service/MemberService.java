package spring.spring_study.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import spring.spring_study.domain.Member;
import spring.spring_study.repository.MemberRepository;
import java.util.List;
import java.util.Optional;

//@Service
@Transactional
public class MemberService {

    private MemberRepository memberRepository;

//    @Autowired
    public MemberService(MemberRepository memberRepository){ //dependency injection (의존성주입)
        this.memberRepository = memberRepository;
    }

    /*
       회원가입
     */
    public Long join(Member member){
        validateDuplicateMember(member); //중복 회원 검증
        memberRepository.save(member);
        return member.getId();

    }

    private void validateDuplicateMember(Member member) //중복 회원 검증
    {
        memberRepository.findByName(member.getName())
                .ifPresent(m ->{
                    throw new IllegalStateException("이미 존재하는 회원입니다.");
                });
    }

    /*
        전체 회원 조회
     */
    public List<Member> findMembers(){
        return memberRepository.findAll();
    }

    public Optional<Member> findOne(Long memberId){
        return memberRepository.findById(memberId);
    }
}

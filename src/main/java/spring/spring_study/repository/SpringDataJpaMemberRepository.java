package spring.spring_study.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import spring.spring_study.domain.Member;

import java.util.Optional;

public interface SpringDataJpaMemberRepository extends JpaRepository<Member, Long>,MemberRepository {

    //select m from Member m where m.name = ?
    @Override
    Optional<Member> findByName(String name);

    
}

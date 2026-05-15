package io.eddie.examquestionbank.dao.member;

import com.querydsl.jpa.impl.JPAQueryFactory;
import io.eddie.examquestionbank.dao.*;
import jakarta.persistence.EntityManager;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Repository
@Slf4j
@RequiredArgsConstructor
public class MemberRepository{

    private final JPAQueryFactory jpaQueryFactory;
    private final EntityManager entityManager;

    //저장
    @Transactional
    public Member memberSave(Member member){
        entityManager.persist(member);

        return member;
    }

    //하나검색
    @Transactional(readOnly = true)
    public Optional<Member> findById(Long id){
        jpaQueryFactory.selectFrom(QMember.member)
                .where(QMember.member.id.eq(id))
                .fetchFirst();

        return Optional.ofNullable(entityManager.find(Member.class, id));
    }

    @Transactional(readOnly = true)
    public Optional<Member> findByUserName(String username){
        jpaQueryFactory.selectFrom(QMember.member)
                .where(QMember.member.username.eq(username))
                .fetchFirst();

        return Optional.ofNullable(entityManager.find(Member.class, username));
    }

    //전체 검색
    @Transactional(readOnly = true)
    public List<Member> findAllMember(String username){
      return jpaQueryFactory.selectFrom(QMember.member)
              .fetch();
    }

    // 수정 : 시큐리티 하고 해야할듯함 ㅇㅊㅇ 여기선 테스트만진행하겠음
    @Transactional
    public void updateMember(Long id, String role, String password){
        Member member= entityManager.find(Member.class, id);
        member.setPassword(password);
        member.setRole(Role.valueOf(role));
    }

    //삭제
    public void memberDelete(Member member){
        entityManager.remove(member);
    }
}
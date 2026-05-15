package io.eddie.examquestionbank.dao.member;

import io.eddie.examquestionbank.dao.Member;
import io.eddie.examquestionbank.util.TestUtil;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

/**
 * packageName    : io.eddie.examquestionbank.dao.member
 * fileName       : MemberRepositoryTest
 * author         : Admin
 * date           : 26. 5. 15.
 * description    :
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 26. 5. 15.        Admin       최초 생성
 */
@Slf4j
@SpringBootTest
class MemberRepositoryTest {

    @Autowired
    MemberRepository memberRepository;

    Member member_item;

    //테스트 전 작업
    @BeforeEach
    void init() {
        member_item = TestUtil.generateMember(); //필드에 할당
        memberRepository.memberSave(member_item);
    }

    //저장 테스트
    @Test
    void it_will_mamberSave(){
        Member member = TestUtil.generateMember();
        Member result = memberRepository.memberSave(member);

        //있는지확인
        assertNotNull(result.getId());
    }

    //찾기 테스트
    @Test
    void it_will_find_member_id(){
       /* Optional<Member> memberOpt= memberRepository.findById(member_item.getId());
        assertTrue(memberOpt.isPresent()); //Optional 객체인 memberOpt 값이 있는지 확인

        Member member = memberRepository.findById(member_item.getId()).get();
        assertEquals(member.getId(), member_item.getId());*/

        // 조회를 한 번만 수행하고, 결과가 없으면 바로 실패하도록 처리
        Member foundMember = memberRepository.findById(member_item.getId())
                .orElseThrow(() -> new AssertionError("Member를 찾을 수 없습니다."));

        // ID 비교
        assertEquals(member_item.getId(), foundMember.getId());
    }

}
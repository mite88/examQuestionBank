package com.example.examquestionbank.dao.member;

import com.example.examquestionbank.dao.Member;
import com.example.examquestionbank.dao.Role;
import com.example.examquestionbank.util.TestUtil;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
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
@Transactional
class MemberRepositoryTest {

    @Autowired
    MemberRepository memberRepository;

    Member member_item;

    @Autowired
    EntityManager em;

    //테스트 전 작업
    @BeforeEach
    void init() {
        member_item = TestUtil.generateMember(); //필드에 할당
        memberRepository.memberSave(member_item);

        // 영속성 컨텍스트를 비워 실제 DB로부터의 조회를 보장
        em.flush();
        em.clear();
    }

    //저장 테스트
    @Test
    void it_will_memberSave(){
        Member member = TestUtil.generateMember();
        Member result = memberRepository.memberSave(member);

        //있는지확인
        assertNotNull(result.getId());
    }

    //찾기 테스트
    @Test
    @DisplayName("아이디(PK)로 회원 단건 검색 테스트")
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

    @Test
    @DisplayName("유저네임으로 회원 단건 검색 테스트")
    void it_will_find_by_username() {
        // when
        Member foundMember = memberRepository.findByUserName(member_item.getUsername())
                .orElseThrow(() -> new AssertionError("해당 username의 Member를 찾을 수 없습니다."));

        // then
        assertEquals(member_item.getId(), foundMember.getId());
        assertEquals(member_item.getUsername(), foundMember.getUsername());
    }

    @Test
    @DisplayName("전체 회원 조회 테스트")
    void it_will_find_all_member() {
        // given - 추가 유저 저장
        Member additionalMember = TestUtil.generateMember();
        memberRepository.memberSave(additionalMember);

        em.flush();
        em.clear();

        // when 전체찾기라 빈값처리
        List<Member> members = memberRepository.findAllMember("");

        // then (init에서 넣은 1명 + 방금 추가한 1명 = 2명 이상이여야함)
        assertTrue(members.size() >= 2, "전체 회원 수는 2명 이상이어야 합니다.");

        // 목록에 내가 넣은 유저들이 포함되어 있는지 검증
        boolean hasInitMember = members.stream().anyMatch(m -> m.getId().equals(member_item.getId()));
        boolean hasAdditionalMember = members.stream().anyMatch(m -> m.getId().equals(additionalMember.getId()));

        assertTrue(hasInitMember);
        assertTrue(hasAdditionalMember);
    }

    @Test
    @DisplayName("회원 수정 테스트")
    void it_will_update_member() {
        // given
        String newPassword = "update1234";
        String newRole = "ADMIN";

        // when
        memberRepository.updateMember(member_item.getId(), newRole, newPassword);

        // 영속성 컨텍스트의 변경 내용을 DB에 반영하고 다시 조회하여 검증
        em.flush();
        em.clear();

        // then
        Member updatedMember = memberRepository.findById(member_item.getId()).orElseThrow();
        assertEquals(newPassword, updatedMember.getPassword(), "비밀번호가 수정되어야 합니다.");
        assertEquals(Role.ADMIN, updatedMember.getRole(), "권한이 ADMIN으로 변경되어야 합니다.");
    }

    @Test
    @DisplayName("회원 삭제 테스트")
    void it_will_memberDelete() {
        // given - 삭제를 위해 영속성 컨텍스트에 다시 올림
        Member targetMember = em.find(Member.class, member_item.getId());

        // when
        memberRepository.memberDelete(targetMember);
        em.flush();
        em.clear();

        // then
        Optional<Member> deletedMember = memberRepository.findById(member_item.getId());
        assertTrue(deletedMember.isEmpty(), "삭제된 회원은 조회되지 않아야 합니다.");
    }



}
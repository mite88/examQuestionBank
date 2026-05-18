package com.example.examquestionbank.util;

import com.example.examquestionbank.dao.Member;
import com.example.examquestionbank.dao.Role;
import org.springframework.context.annotation.Configuration;

import java.util.UUID;

/**
 * packageName    : io.eddie.examquestionbank.util
 * fileName       : TestUtil
 * author         : Admin
 * date           : 26. 5. 15.
 * description    : 전체적으로써야하는거 정리
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 26. 5. 15.        Admin       최초 생성
 */
@Configuration
public class TestUtil {

    public static Member generateMember() { // static 메서드로 선언하면 호출이 간편합니다.
        // 호출될 때마다 무작위 8자리 문자열을 생성 (예: testUser_a1b2c3d4)
        String randomUsername = "testUser_" + UUID.randomUUID().toString().substring(0, 8);

        return Member.builder()
                .username(randomUsername) // 매번 고유한 아이디가 주입됨!
                .password("1234")
                .role(Role.USER)
                .build();
    }
}

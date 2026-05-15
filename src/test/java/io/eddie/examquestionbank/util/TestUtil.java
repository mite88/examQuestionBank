package io.eddie.examquestionbank.util;

import io.eddie.examquestionbank.dao.Member;
import io.eddie.examquestionbank.dao.Role;
import org.springframework.context.annotation.Configuration;

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
        return Member.builder()
                .username("testUser")
                .password("1234")
                .role(Role.USER) // 앞서 정의한 Role Enum 적용 [cite: 55, 57]
                .build();
    }
}

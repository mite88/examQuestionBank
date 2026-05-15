package io.eddie.examquestionbank.dao;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

/**
 * packageName    : io.eddie.examquestionbank.dao
 * fileName       : Role
 * author         : Admin
 * date           : 26. 5. 15.
 * description    : 회원등급 정의
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 26. 5. 15.        Admin       최초 생성
 */
@Getter
@RequiredArgsConstructor
public enum Role {

    //ADMIN,  // 관리자
    //USER,   // 사용자
    // 1. ROLE_ 접두사 필수, 2. 권한명, 3. 설명
    GUEST("ROLE_ADMIN", "관리자"), // 게스트
    USER("ROLE_USER", "사용자");

    private final String key;
    private final String title;
}

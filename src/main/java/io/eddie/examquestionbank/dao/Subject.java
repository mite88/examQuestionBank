package io.eddie.examquestionbank.dao;

import jakarta.persistence.*;
import lombok.*;
import lombok.extern.slf4j.Slf4j;

/**
 * packageName    : io.eddie.examquestionbank.dao
 * fileName       : Subject
 * author         : Admin
 * date           : 26. 5. 15.
 * description    : 과목 엔티티
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 26. 5. 15.        Admin       최초 생성
 */
@Entity
@Slf4j
@NoArgsConstructor(access = AccessLevel.PROTECTED) // JPA를 위한 기본 생성자
@AllArgsConstructor // 모든 필드를 가지는 생성자 (Builder 사용시 필요)
@Builder // 객체 생성을 편리하게 하기 위함 (필요시 추가)
@Table(name = "subjects")
public class Subject extends BaseTimeEntity{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String name; // 과목명

    public Subject(String name) {
        this.name = name;
    }


}

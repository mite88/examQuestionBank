package com.example.examquestionbank.dao;

import jakarta.persistence.*;
import lombok.*;
import lombok.extern.slf4j.Slf4j;

/**
 * packageName    : io.eddie.examquestionbank.dao
 * fileName       : Keyword
 * author         : Admin
 * date           : 26. 5. 15.
 * description    : 키워드 엔티티
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
@Table(name = "keywords")
public class Keyword extends BaseTimeEntity{

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name; // 키워드명

    @Lob
    private String description; // 키워드 설명

    private int importance; // 중요도 (1~5)

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "subject_id")
    private Subject subject; // 과목명

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id")
    private Member member; // 등록한 사용자

    @Builder
    public Keyword(String name, String description, int importance, Subject subject, Member member) {
        this.name = name;
        this.description = description;
        this.importance = importance;
        this.subject = subject;
        this.member = member;
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + "(" +
                "id = " + id + ")";
    }
}

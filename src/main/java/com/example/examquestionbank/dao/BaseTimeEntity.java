package com.example.examquestionbank.dao;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.data.annotation.*;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;

/**
 * packageName    : io.eddie.examquestionbank.dao
 * fileName       : BaseTimeEntity
 * author         : Admin
 * date           : 26. 5. 15.
 * description    : JPA Auditing 사용
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 26. 5. 15.        Admin       최초 생성
 */
@Getter
@MappedSuperclass // JPA Entity 클래스들이 해당 추상 클래스를 상속할 경우 createDate, modifiedDate를 컬럼으로 인식
@EntityListeners(AuditingEntityListener.class) // Auditing 기능 포함
public class BaseTimeEntity {
    /*
    https://webcoding-start.tistory.com/53
        JPA Auditing이란?
    - 엔티티가 생성되고 저장될 때, 수정될 때 시간을 자동으로 기록해주는 기능
    - @CreatedDate : 엔티티가 생성되고 저장될 때 시간을 자동으로 기록
    - @LastModifiedDate : 엔티티가 수정될 때 시간을 자동으로 기록
    - 위의 두 어노테이션은 Temporal을 지원함 (DATE, TIME, TIMESTAMP)
    * */

    //엔티티 생성되어 저장시 시간 자동저장
    @CreatedDate
    @Column(name = "created_date")
    private LocalDateTime createdDate;

    //엔티티값 변경시 시간 자동 저장
    @LastModifiedDate
    @Column(name = "update_date")
    private LocalDateTime updatedDate;
}

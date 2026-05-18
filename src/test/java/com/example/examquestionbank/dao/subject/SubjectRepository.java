package com.example.examquestionbank.dao.subject;

import com.querydsl.jpa.impl.JPAQueryFactory;
import jakarta.persistence.EntityManager;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


/**
 * packageName    : io.eddie.examquestionbank.dao.subject
 * fileName       : SubjectRepository
 * author         : Admin
 * date           : 26. 5. 15.
 * description    : 과목Repository
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 26. 5. 15.        Admin       최초 생성
 */
@Repository
@Slf4j
@RequiredArgsConstructor
public class SubjectRepository  {

    private final JPAQueryFactory jpaQueryFactory;
    private final EntityManager entityManager;


}
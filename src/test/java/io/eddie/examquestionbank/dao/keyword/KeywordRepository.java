package io.eddie.examquestionbank.dao.keyword;

import com.querydsl.jpa.impl.JPAQueryFactory;
import io.eddie.examquestionbank.dao.Keyword;
import io.eddie.examquestionbank.dao.Subject;
import jakarta.persistence.EntityManager;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
@Slf4j
@RequiredArgsConstructor
public class KeywordRepository {

    private final JPAQueryFactory jpaQueryFactory;
    private final EntityManager entityManager;


}
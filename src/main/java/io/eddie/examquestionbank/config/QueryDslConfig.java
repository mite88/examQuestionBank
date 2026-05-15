package io.eddie.examquestionbank.config;

import com.querydsl.jpa.impl.JPAQueryFactory;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class QueryDslConfig {

    @PersistenceContext
    private EntityManager entityManager;

    @Bean
    // public JPAQueryFactory queryDslConfig() { <--- 기존 (클래스명과 중복)
    public JPAQueryFactory jpaQueryFactory() { // <--- 이렇게 이름을 바꾸세요!
        return new JPAQueryFactory(entityManager);
    }
}
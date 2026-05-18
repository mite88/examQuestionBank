package com.example.examquestionbank.config;

import com.querydsl.jpa.impl.JPAQueryFactory;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class QueryDslConfig {

    @PersistenceContext // 이제 에러가 사라질 거예요!
    private EntityManager entityManager;

    @Bean
    public JPAQueryFactory jpaQueryFactory() { // 메소드 이름은 아까처럼 jpaQueryFactory로!
        return new JPAQueryFactory(entityManager);
    }
}
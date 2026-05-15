package io.eddie.examquestionbank.config;

import com.querydsl.jpa.impl.JPAQueryFactory;
import jakarta.persistence.EntityManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class QueryDslConfig {

    //메서드에서 반환되는 객체(JPAQueryFactory)를 스프링 컨테이너에 등록
    @Bean
    public JPAQueryFactory queryDslConfig(EntityManager entityManager){
        return new JPAQueryFactory(entityManager);
    }

}

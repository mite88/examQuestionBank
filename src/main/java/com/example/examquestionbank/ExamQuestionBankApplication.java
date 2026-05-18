package com.example.examquestionbank;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing // JPA Auditing활성화
@SpringBootApplication
public class ExamQuestionBankApplication {

    public static void main(String[] args) {
        SpringApplication.run(ExamQuestionBankApplication.class, args);
    }

}

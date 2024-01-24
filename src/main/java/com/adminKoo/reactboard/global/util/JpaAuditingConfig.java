package com.adminKoo.reactboard.global.util;


import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@Configuration
@EnableJpaAuditing
public class JpaAuditingConfig {
}

/* 해당 클래스의 역할
본래 RestApiApplication 에 @EnableJpaAuditing 을 해줘야 하지만
나중에 추가해주면 Mock 테스트 시, 문제가 발생할 수 있다.
@WebMvcTest(OOO.class)의 Controller Test를 진행할 때 문제가 될 수 있다.
왜냐하면 모든 테스트는 Application 클래스가 항상 로드되면서 실행이 되는데,
Auditing 어노테이션이 등록되어 있으면 모든 테스트가 항상 JPA 관련된 빈을 필요로 하고 있는 상태가 되기 때문이다.
@WebMvcTest 어노테이션은 JPA 관련 빈들을 로드하지 않기 때문에 문제가 발생한다.

그래서 따로 분리해서 Config 해줌

https://hellorennon.tistory.com/9
 */
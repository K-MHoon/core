package hello.core.singleton;

import hello.core.AppConfig;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class StatefulServiceTest {

    @Test
    void statefulServiceSingleton() {
        AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(TestConfig.class);

        StatefulService statefulService1 = ac.getBean("statefulService", StatefulService.class);
        StatefulService statefulService2 = ac.getBean("statefulService", StatefulService.class);

        //Thread A: A 사용자 10000원 주문
        statefulService1.order("userA", 10000);

        //Thread B: B 사용자 20000원 주문
        statefulService2.order("userB", 20000);

        //Thread A: A 사용자 주문 금액 조회
        int price = statefulService1.getPrice();
        // 사용자 A는 10000원을 기대했지만, 20000원 출력.
        System.out.println("price = " + price);

        assertEquals(statefulService1.getPrice(), 20000);

    }

    @Configuration
    static class TestConfig {

        @Bean
        public StatefulService statefulService() {
            return new StatefulService();
        }
    }
}

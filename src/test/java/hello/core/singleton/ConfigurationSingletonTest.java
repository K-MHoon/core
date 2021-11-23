package hello.core.singleton;

import hello.core.AppConfig;
import hello.core.member.MemberRepository;
import hello.core.member.MemberServiceImpl;
import hello.core.order.OrderServiceImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import static org.junit.jupiter.api.Assertions.assertSame;

public class ConfigurationSingletonTest {

    AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);

    @Test
    void configurationTest() {
        MemberServiceImpl memberService = ac.getBean("memberService", MemberServiceImpl.class);
        OrderServiceImpl orderService = ac.getBean("orderService", OrderServiceImpl.class);
        MemberRepository memberRepository = ac.getBean("memberRepository", MemberRepository.class);

        // 모두 같은 인스턴스를 참고한다.
        System.out.println("memberService.getMemberRepository() = " + memberService.getMemberRepository());
        System.out.println("orderService.getMemberRepository() = " + orderService.getMemberRepository());
        System.out.println("memberRepository = " + memberRepository);

        assertSame(memberService.getMemberRepository(), memberRepository);
        assertSame(orderService.getMemberRepository(), memberRepository);
    }

    @Test
    void configurationDeep() {
        AppConfig bean = ac.getBean(AppConfig.class);
        System.out.println("bean.getClass() = " + bean.getClass());
    }
}

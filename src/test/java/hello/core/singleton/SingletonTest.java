package hello.core.singleton;

import hello.core.AppConfig;
import hello.core.member.MemberService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import static org.junit.jupiter.api.Assertions.assertNotSame;
import static org.junit.jupiter.api.Assertions.assertSame;

public class SingletonTest {

    @Test
    @DisplayName("스프링 없는 순수한 DI 컨테이너")
    void pureContainer() {
        AppConfig appConfig = new AppConfig();

        //1. 조회 : 호출할 때마다 객체를 생성.
        MemberService memberService1 = appConfig.memberService();

        //2. 조회 : 호출할 때마다 객체를 생성.
        MemberService memberService2 = appConfig.memberService();

        // 참조 값이 다름.
        System.out.println("memberService1 = " + memberService1);
        System.out.println("memberService2 = " + memberService2);

        assertNotSame(memberService1, memberService2);

    }

    @Test
    @DisplayName("싱글톤 패턴을 적용한 객체 사용")
    public void singletonServiceTest() {

        // private로 막아두어서 컴파일 오류가 발생한다.
//        new SingletonService();

        //1. 조회: 호출할 때마다 같은 객체 반환
        SingletonService singletonService1 = SingletonService.getInstance();

        //2. 조회: 호출할 때마다 같은 객체 반환
        SingletonService singletonService2 = SingletonService.getInstance();

        //참조값이 같은 것 확인
        System.out.println("singletonService1 = " + singletonService1);
        System.out.println("singletonService2 = " + singletonService2);

        // singletonService1 == singletonService2
        assertSame(singletonService1, singletonService2);
        singletonService1.logic();
    }

    @Test
    @DisplayName("스프링 컨테이너와 싱글톤")
    void springContainer() {
        AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);

        //1. 조회: 호출할 때마다 같은 객체 반환
        MemberService memberService1 = ac.getBean("memberService", MemberService.class);

        //2. 조회: 호출할 때마다 같은 객체 반환
        MemberService memberService2 = ac.getBean("memberService", MemberService.class);

        //참조값 같은 것 확인
        System.out.println("memberService1 = " + memberService1);
        System.out.println("memberService2 = " + memberService2);

        assertSame(memberService1, memberService2);
    }
}

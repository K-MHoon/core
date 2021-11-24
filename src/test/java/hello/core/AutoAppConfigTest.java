package hello.core;

import hello.core.discount.DiscountPolicy;
import hello.core.member.MemberService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import static org.junit.jupiter.api.Assertions.*;

class AutoAppConfigTest {

    @Autowired
    private DiscountPolicy discountPolicy;

//    @Autowired
//    private  DiscountPolicy rateDiscountPolicy;

    @Test
    void basicScan() {
        AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(AutoAppConfig.class);
        MemberService memberService = ac.getBean(MemberService.class);
        Assertions.assertInstanceOf(MemberService.class, memberService);
    }
}
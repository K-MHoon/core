package hello.core;

import hello.core.discount.DiscountPolicy;
import hello.core.member.Member;
import hello.core.member.MemberRepository;
import hello.core.member.MemoryMemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScan.Filter;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;
import org.springframework.lang.Nullable;

import java.util.Optional;

@Configuration
@ComponentScan(
        excludeFilters = @Filter(type= FilterType.ANNOTATION, classes=Configuration.class)
)
public class AutoAppConfig {

    /**
     * 빈 주입 충돌 테스트 메서드
     * @return
     */
//    @Bean("memoryMemberRepository")
//    public MemberRepository memberRepository() {
//        return new MemoryMemberRepository();
//    }

//    //호출 안됨
//    @Autowired(required = false)
//    public void setNoBean1(Member member) {
//        System.out.println("setNoBean1 = " + member);
//    }
//
//    //null 호출
//    @Autowired
//    public void setNoBean2(@Nullable Member member) {
//        System.out.println("setNoBean2 = " + member);
//    }
//
//    //Optional.empty 호출
//    @Autowired(required = false)
//    public void setNoBean3(Optional<Member> member) {
//        System.out.println("setNoBean3 = " + member);
//    }

}

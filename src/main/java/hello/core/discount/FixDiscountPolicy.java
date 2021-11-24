package hello.core.discount;

import hello.core.member.Grade;
import hello.core.member.Member;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

/**
 * 고정된 금액을 할인하는 정책 클래스
 */
@Component
//@Qualifier("fixDiscountPolicy")
@Primary
public class FixDiscountPolicy implements DiscountPolicy {

    private int discountFixAmount = 1000;


    @Override
    public int discount(Member member, int price) {

        if(member.getGrade() == Grade.VIP) {
            return discountFixAmount;
        } else {
            return 0;
        }
    }
}

package hello.core.discount;

import hello.core.member.Grade;
import hello.core.member.Member;

/**
 * 고정된 금액을 할인하는 정책 클래스
 */
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

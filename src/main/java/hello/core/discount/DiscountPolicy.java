package hello.core.discount;

import hello.core.member.Member;
import org.springframework.stereotype.Repository;

@Repository
public interface DiscountPolicy {

    int discount(Member member, int price);
}

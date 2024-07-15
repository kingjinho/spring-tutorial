package hello.core.discount;

import hello.core.member.EGrade;
import hello.core.member.Member;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
@Qualifier("fixedDiscountPolicy")
public class FixedDiscountPolicy implements IDiscountPolicy {
    private final int discountFixAmount = 1000; //1000원

    @Override
    public int discount(Member member, int price) {
        if (member.getGrade() == EGrade.VIP) {
            return discountFixAmount;
        }
        return 0;
    }
}

package hello.core.discount;

import hello.core.member.EGrade;
import hello.core.member.Member;

public class RateDiscountPolicy implements IDiscountPolicy {

    private int discountPercent = 10;
    @Override
    public int discount(Member member, int price) {
        if(member.getGrade() == EGrade.VIP) {
            return price * discountPercent / 100;
        } else {
            return 0;
        }
    }
}

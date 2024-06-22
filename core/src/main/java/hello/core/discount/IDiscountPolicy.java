package hello.core.discount;

import hello.core.member.Member;

public interface IDiscountPolicy {

    int discount(Member member, int price);
}

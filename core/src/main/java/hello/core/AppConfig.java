package hello.core;

import hello.core.discount.FixedDiscountPolicy;
import hello.core.discount.IDiscountPolicy;
import hello.core.member.IMemberService;
import hello.core.member.MemberServiceImpl;
import hello.core.order.IOrderService;
import hello.core.order.OrderServiceImpl;
import hello.core.repository.IMemberRepository;
import hello.core.repository.MemoryMemberRepositoryImpl;

public class AppConfig {

    public IMemberService memberService() {
        return new MemberServiceImpl(memberRepository());
    }

    private IMemberRepository memberRepository() {
        return new MemoryMemberRepositoryImpl();
    }

    public IOrderService orderService() {
        return new OrderServiceImpl(
                memberRepository(),
                discountPolicy()
        );
    }

    public IDiscountPolicy discountPolicy() {
        return new FixedDiscountPolicy();
    }
}

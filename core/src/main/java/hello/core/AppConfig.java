package hello.core;

import hello.core.discount.FixedDiscountPolicy;
import hello.core.discount.IDiscountPolicy;
import hello.core.member.IMemberService;
import hello.core.member.MemberServiceImpl;
import hello.core.order.IOrderService;
import hello.core.order.OrderServiceImpl;
import hello.core.repository.IMemberRepository;
import hello.core.repository.MemoryMemberRepositoryImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

    @Bean
    public IMemberService memberService() {
        return new MemberServiceImpl(memberRepository());
    }

    @Bean
    public IMemberRepository memberRepository() {
        return new MemoryMemberRepositoryImpl();
    }

    @Bean
    public IOrderService orderService() {
        return new OrderServiceImpl(
                memberRepository(),
                discountPolicy()
        );
    }

    @Bean
    public IDiscountPolicy discountPolicy() {
        return new FixedDiscountPolicy();
    }
}

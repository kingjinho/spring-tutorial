package hello.core.order;

import hello.core.annotation.MainDiscountPolicy;
import hello.core.discount.IDiscountPolicy;
import hello.core.member.Member;
import hello.core.repository.IMemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class OrderServiceImpl implements IOrderService {

    private final IMemberRepository memberRepository;
    private final IDiscountPolicy discountPolicy;

    @Autowired
    public OrderServiceImpl(IMemberRepository memberRepository, @MainDiscountPolicy IDiscountPolicy discountPolicy) {
        this.memberRepository = memberRepository;
        this.discountPolicy = discountPolicy;
    }

    @Override
    public Order createOrder(Long memberId, String itemName, int itemPrice) {
        Member member = memberRepository.findById(memberId);
        int discountPrice = -1;
        if (member != null) {
            discountPrice = discountPolicy.discount(member, itemPrice);
        }

        return new Order(memberId, itemName, itemPrice, discountPrice);
    }

    public IMemberRepository getMemberRepository() {
        return memberRepository;
    }
}

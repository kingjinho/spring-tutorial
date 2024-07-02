package hello.core.order;

import hello.core.discount.FixedDiscountPolicy;
import hello.core.discount.IDiscountPolicy;
import hello.core.member.Member;
import hello.core.repository.IMemberRepository;
import hello.core.repository.MemoryMemberRepositoryImpl;

public class OrderServiceImpl implements IOrderService {

    private final IMemberRepository memberRepository;
    private final IDiscountPolicy discountPolicy;

    public OrderServiceImpl(IMemberRepository memberRepository, IDiscountPolicy discountPolicy) {
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

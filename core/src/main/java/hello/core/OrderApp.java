package hello.core;

import hello.core.member.EGrade;
import hello.core.member.IMemberService;
import hello.core.member.Member;
import hello.core.member.MemberServiceImpl;
import hello.core.order.IOrderService;
import hello.core.order.Order;
import hello.core.order.OrderServiceImpl;

public class OrderApp {

    public static void main(String[] args) {
        IMemberService memberService = new MemberServiceImpl();
        IOrderService orderService = new OrderServiceImpl();

        Long memberId = 1L;
        Member member = new Member(memberId, "memberA", EGrade.VIP);
        memberService.join(member);

        Order order = orderService.createOrder(member.getId(), "Banana", 5000);
        System.out.println("order = " + order.toString());


    }
}

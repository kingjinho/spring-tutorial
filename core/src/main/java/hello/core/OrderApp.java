package hello.core;

import hello.core.member.EGrade;
import hello.core.member.IMemberService;
import hello.core.member.Member;
import hello.core.order.IOrderService;
import hello.core.order.Order;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class OrderApp {

    public static void main(String[] args) {

        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfig.class);

        IMemberService memberService = applicationContext.getBean("memberService", IMemberService.class);
        IOrderService orderService = applicationContext.getBean("orderService", IOrderService.class);

        Long memberId = 1L;
        Member member = new Member(memberId, "memberA", EGrade.VIP);
        memberService.join(member);

        Order order = orderService.createOrder(member.getId(), "Banana", 5000);
        System.out.println("order = " + order.toString());
    }
}

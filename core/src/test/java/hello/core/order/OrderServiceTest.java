package hello.core.order;

import hello.core.AppConfig;
import hello.core.member.EGrade;
import hello.core.member.IMemberService;
import hello.core.member.Member;
import hello.core.member.MemberServiceImpl;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class OrderServiceTest {


    IMemberService memberService;
    IOrderService orderService;

    @BeforeEach
    public void beforeEach() {
        AppConfig appConfig = new AppConfig();
        memberService = appConfig.memberService();
        orderService = appConfig.orderService();
    }

    @Test
    void createOrder() {
        Long memberId = 1L;
        Member member = new Member(memberId, "memberA", EGrade.VIP);
        memberService.join(member);

        Order order = orderService.createOrder(member.getId(), "Banana", 5000);

        Assertions.assertThat(order.calculatePrice()).isEqualTo(4000);
    }
}

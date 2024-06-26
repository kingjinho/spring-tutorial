package hello.core;

import hello.core.member.EGrade;
import hello.core.member.IMemberService;
import hello.core.member.Member;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MemberApp {

    public static void main(String[] args) {
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfig.class);
        IMemberService memberService = applicationContext.getBean("memberService", IMemberService.class);

        Member member = new Member(1L, "memberA", EGrade.VIP);
        memberService.join(member);

        Member findMember = memberService.findById(1L);

        System.out.println("new member = " + member.getName());
        System.out.println("find member = " + findMember.getName());
    }
}

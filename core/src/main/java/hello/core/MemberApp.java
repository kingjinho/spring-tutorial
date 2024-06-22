package hello.core;

import hello.core.member.EGrade;
import hello.core.member.Member;
import hello.core.service.member.IMemberService;
import hello.core.service.member.MemberServiceImpl;

public class MemberApp {

    public static void main(String[] args) {
        IMemberService memberService = new MemberServiceImpl();
        Member member = new Member(1L, "memberA", EGrade.VIP);
        memberService.join(member);

        Member findMember = memberService.findById(1L);
        System.out.println("new member = " + member.getName());
        System.out.println("find member = " + findMember.getName());
    }
}

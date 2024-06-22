package hello.core.member;

import hello.core.service.member.IMemberService;
import hello.core.service.member.MemberServiceImpl;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class MemberServiceTest {

    IMemberService memberService = new MemberServiceImpl();

    @Test
    void join() {
        //given
        Member member = new Member(1L, "memberA", EGrade.VIP);

        //when
        memberService.join(member);
        Member findMember = memberService.findById(1L);

        //then
        Assertions.assertThat(member).isEqualTo(findMember);


    }
}

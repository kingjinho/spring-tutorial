package hello.core.member;

import hello.core.member.Member;

public interface IMemberService {

    void join(Member member);

    Member findById(Long memberId);
}

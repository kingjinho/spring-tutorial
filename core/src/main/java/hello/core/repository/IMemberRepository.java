package hello.core.repository;

import hello.core.member.Member;

public interface IMemberRepository {
    void save(Member member);
    Member findById(Long memberId);
}

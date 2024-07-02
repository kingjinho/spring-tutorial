package hello.core.member;

import hello.core.repository.IMemberRepository;
import hello.core.repository.MemoryMemberRepositoryImpl;

public class MemberServiceImpl implements IMemberService {

    private final IMemberRepository memberRepository;


    public MemberServiceImpl(IMemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    @Override
    public void join(Member member) {
        memberRepository.save(member);
    }

    @Override
    public Member findById(Long memberId) {
        return memberRepository.findById(memberId);
    }

    public IMemberRepository getMemberRepository() {
        return memberRepository;
    }
}

package hello.core.service.member;

import hello.core.member.Member;
import hello.core.repository.IMemberRepository;
import hello.core.repository.MemoryMemberRepositoryImpl;

public class MemberServiceImpl implements IMemberService {

    private final IMemberRepository memberRepository = new MemoryMemberRepositoryImpl();


//    public MemberServiceImpl(IMemberRepository memberRepository) {
//        this.memberRepository = memberRepository;
//    }

    @Override
    public void join(Member member) {
        memberRepository.save(member);
    }

    @Override
    public Member findById(Long memberId) {
        return memberRepository.findById(memberId);
    }
}

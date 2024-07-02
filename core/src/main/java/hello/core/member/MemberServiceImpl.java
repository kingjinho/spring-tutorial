package hello.core.member;

import hello.core.repository.IMemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class MemberServiceImpl implements IMemberService {

    private final IMemberRepository memberRepository;

    @Autowired
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

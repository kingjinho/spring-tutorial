package hello.core.repository;

import hello.core.member.Member;

import java.util.HashMap;
import java.util.Map;

public class MemoryMemberRepositoryImpl implements IMemberRepository {
    private static Map<Long, Member> store = new HashMap<>();

    @Override
    public void save(Member member) {
        store.put(member.getId(), member);

    }

    @Override
    public Member findById(Long memberId) {
        return store.get(memberId);
    }
}

package woopaca.practice.member.repository;

import org.springframework.stereotype.Component;
import woopaca.practice.member.entity.Member;

import java.util.HashMap;
import java.util.Map;

@Component
public class MemoryMemberRepository implements MemberRepository {

    private static final Map<String, Member> memory = new HashMap<>();

    @Override
    public void save(Member member) {
        memory.put(member.getId(), member);
    }

    @Override
    public Member findById(String id) {
        return memory.get(id);
    }

}
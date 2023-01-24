package woopaca.practice.member.repository;

import org.springframework.stereotype.Component;
import woopaca.practice.member.entity.User;

import java.util.HashMap;
import java.util.Map;

@Component
public class MemoryMemberRepository implements MemberRepository {

    private static final Map<String, User> memory = new HashMap<>();

    @Override
    public void save(User member) {
        memory.put(member.getId(), member);
    }

    @Override
    public User findById(String id) {
        return memory.get(id);
    }

}
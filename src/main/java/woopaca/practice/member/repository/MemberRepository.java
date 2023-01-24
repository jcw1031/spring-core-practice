package woopaca.practice.member.repository;

import woopaca.practice.member.entity.User;

public interface MemberRepository {

    void save(User member);

    User findById(String id);

}

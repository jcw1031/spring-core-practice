package woopaca.practice.member.service;

import woopaca.practice.member.entity.User;

public interface MemberService {

    void join(User member);

    User validateMember(String id);

    User findMember(String id);

}

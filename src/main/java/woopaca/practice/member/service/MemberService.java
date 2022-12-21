package woopaca.practice.member.service;

import woopaca.practice.member.entity.Member;

public interface MemberService {

    void join(Member member);

    Member findMember(String id);

}

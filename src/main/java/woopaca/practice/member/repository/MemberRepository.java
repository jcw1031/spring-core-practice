package woopaca.practice.member.repository;

import woopaca.practice.member.entity.Member;

import java.util.HashMap;
import java.util.Map;

public interface MemberRepository {

    void save(Member member);

    Member findById(String id);

}

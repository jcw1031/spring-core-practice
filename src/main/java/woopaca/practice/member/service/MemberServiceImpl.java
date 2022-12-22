package woopaca.practice.member.service;

import woopaca.practice.member.entity.Member;
import woopaca.practice.member.repository.MemberRepository;
import woopaca.practice.member.repository.MemoryMemberRepository;

public class MemberServiceImpl implements MemberService {

    private final MemberRepository memberRepository = new MemoryMemberRepository();

    @Override
    public void join(Member member) {

        memberRepository.save(member);
    }

    @Override
    public Member findMember(String id) {
        return memberRepository.findById(id);
    }

}

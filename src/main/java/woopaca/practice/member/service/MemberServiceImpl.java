package woopaca.practice.member.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import woopaca.practice.member.entity.Member;
import woopaca.practice.member.repository.MemberRepository;

@Component
public class MemberServiceImpl implements MemberService {

    private final MemberRepository memberRepository;

    @Autowired
    public MemberServiceImpl(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    @Override
    public void join(Member member) {
        memberRepository.save(member);
    }

    @Override
    public Member findMember(String id) {
        return memberRepository.findById(id);
    }

}

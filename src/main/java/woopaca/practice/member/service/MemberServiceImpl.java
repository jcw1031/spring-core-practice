package woopaca.practice.member.service;

import org.springframework.stereotype.Component;
import woopaca.practice.member.entity.User;
import woopaca.practice.member.repository.MemberRepository;

@Component
public class MemberServiceImpl implements MemberService {

    private final MemberRepository memberRepository;

    public MemberServiceImpl(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    @Override
    public void join(User member) {
        User findMember = memberRepository.findById(member.getId());
        if (findMember == null) {
            memberRepository.save(member);
            return;
        }
        throw new IllegalArgumentException();
    }

    @Override
    public User validateMember(String id) {
        User member = memberRepository.findById(id);
        if (member != null) {
            return member;
        }
        throw new IllegalArgumentException();
    }

    @Override
    public User findMember(String id) {
        return memberRepository.findById(id);
    }

}

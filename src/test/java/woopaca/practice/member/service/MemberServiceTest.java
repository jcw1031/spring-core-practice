package woopaca.practice.member.service;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import woopaca.practice.member.entity.Grade;
import woopaca.practice.member.entity.Member;

public class MemberServiceTest {

    MemberService memberService = new MemberServiceImpl();

    @Test
    void 회원가입() {
        //given
        Member member = new Member(1L, "Woopaca", Grade.VIP);

        //when
        memberService.join(member);
        Member findMember = memberService.findMember(1L);

        //then
        Assertions.assertThat(member).isEqualTo(findMember);

    }
}

package woopaca.practice.member.service;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import woopaca.practice.config.AppConfig;
import woopaca.practice.member.entity.Grade;
import woopaca.practice.member.entity.Member;

public class MemberServiceTest {

    MemberService memberService;

    @BeforeEach
    void beforeEach() {
        AppConfig appConfig = new AppConfig();
        memberService = appConfig.memberService();
    }

    @Test
    void 회원가입() {
        //given
        Member member = new Member("jcw1031", "Woopaca", Grade.VIP);

        //when
        memberService.join(member);
        Member findMember = memberService.findMember("jcw1031");

        //then
        Assertions.assertThat(member).isEqualTo(findMember);

    }
}

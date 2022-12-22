package woopaca.practice;

import woopaca.practice.config.AppConfig;
import woopaca.practice.member.entity.Grade;
import woopaca.practice.member.entity.Member;
import woopaca.practice.member.service.MemberService;

public class MemberApp {

    public static void main(String[] args) {
        AppConfig appConfig = new AppConfig();

        MemberService memberService = appConfig.memberService();
        Member member = new Member("jcw1031", "woopaca", Grade.VIP);

        memberService.join(member);

        Member findMember = memberService.findMember("jcw1031");
        System.out.println("member = " + member);
        System.out.println("findMember = " + findMember);
    }

}

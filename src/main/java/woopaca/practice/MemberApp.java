package woopaca.practice;

import woopaca.practice.member.entity.Grade;
import woopaca.practice.member.entity.Member;
import woopaca.practice.member.service.MemberService;
import woopaca.practice.member.service.MemberServiceImpl;

public class MemberApp {

    public static void main(String[] args) {

        MemberService memberService = new MemberServiceImpl();
        Member member = new Member("jcw1031", "woopaca", Grade.VIP);

        memberService.join(member);

        Member findMember = memberService.findMember("jcw1031");
        System.out.println("member = " + member);
        System.out.println("findMember = " + findMember);
    }

}

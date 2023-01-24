package woopaca.practice;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import woopaca.practice.member.entity.Grade;
import woopaca.practice.member.entity.User;
import woopaca.practice.member.service.MemberService;

public class MemberApp {

    public static void main(String[] args) {
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(AutoAppConfig.class);

        MemberService memberService = applicationContext.getBean("memberService", MemberService.class);
        User member = new User("jcw1031", "woopaca", Grade.VIP);

        memberService.join(member);

        User findMember = memberService.findMember("jcw1031");
        System.out.println("member = " + member);
        System.out.println("findMember = " + findMember);
    }

}

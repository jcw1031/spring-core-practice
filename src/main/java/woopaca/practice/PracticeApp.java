package woopaca.practice;

import org.w3c.dom.ls.LSOutput;
import woopaca.practice.member.entity.Member;
import woopaca.practice.member.service.MemberService;
import woopaca.practice.member.service.MemberServiceImpl;
import woopaca.practice.order.service.OrderService;
import woopaca.practice.order.service.OrderServiceImpl;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class PracticeApp {

    private static final MemberService memberService = new MemberServiceImpl();
    private static final OrderService orderService = new OrderServiceImpl();
    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {

        System.out.println("안녕하세요. 우파카마켓입니다.\n회원이신가요? [y/n]");
        String input = br.readLine();

        if (input.equals("y")) {
            isMember();
        }
        if (input.equals("n")) {
            isNotMember();
        }

    }

    public static void isMember() throws IOException {
        System.out.println("\n아이디가 무엇인가요?");
        String id = br.readLine();

        Member member = memberService.findMember(id);
        if (member == null) {
            throw new IllegalAccessError("[ ERROR ] 존재하지 않는 회원입니다!");
        }


    }

    public static void isNotMember() {

    }

    public static void loginSuccess(Member member) {
        System.out.println("반갑습니다 " + member.getName() + " 님!");


    }

    public static void order(Member member) throws IOException {
        System.out.println("어떤 상품을 구매하시겠어요? [ 카테고리 입력 ]");
        String category = br.readLine();

        
    }

}

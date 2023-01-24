package woopaca.practice.view;

import woopaca.practice.exception.ErrorMessage;
import woopaca.practice.member.entity.Grade;
import woopaca.practice.member.entity.User;
import woopaca.practice.member.service.MemberService;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import static woopaca.practice.PracticeApp.APPLICATION_CONTEXT;

public class MemberView {

    private final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private final MemberService memberService;

    public MemberView() {
        memberService = APPLICATION_CONTEXT.getBean(MemberService.class);
    }

    public void isMember() throws IOException {
        System.out.println("\n아이디가 무엇인가요?");
        String id = br.readLine();

        try {
            loginSuccess(memberService.validateMember(id));
        } catch (IllegalArgumentException exception) {
            System.out.println("무슨 일이야...");
            System.out.println(ErrorMessage.LOGIN_ERROR);
            new StartView();
        }
    }

    public void isNotMember() throws IOException {
        System.out.println("회원가입을 진행하기 위해 해당 정보를 입력해주세요.");
        String id;
        String name;

        System.out.print("\nID : ");
        id = br.readLine();
        System.out.print("\n이름 : ");
        name = br.readLine();

        User member = new User(id, name, Grade.VIP);
        try {
            memberService.join(member);
        } catch (IllegalArgumentException exception) {
            System.out.println(ErrorMessage.DUPLICATE_ID);
            isNotMember();
            return;
        }
        isMember();
    }

    public void loginSuccess(User member) throws IOException {
        OrderView orderView = new OrderView();
        System.out.println("반갑습니다 " + member.getName() + " 님!");

        while (true) {
            System.out.println("무엇을 하시겠습니까? [ 1.주문하기  2.주문 조회  3.로그아웃 ]");
            int input = Integer.parseInt(br.readLine());
            boolean isLogout = false;

            switch (input) {
                case 1: {
                    orderView.order(member);
                    break;
                }
                case 2: {
                    orderView.getOrderList(member);
                    break;
                }
                case 3: {
                    isLogout = true;
                    break;
                }
                default: {
                    System.out.println(ErrorMessage.SELECT_ERROR);
                    break;
                }
            }

            if (isLogout) {
                System.out.println("안녕히 가세요.");
//                new StartView();
                break;
            }
        }
    }

}

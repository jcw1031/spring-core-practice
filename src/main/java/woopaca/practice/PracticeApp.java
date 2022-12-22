package woopaca.practice;

import woopaca.practice.exception.ErrorMessage;
import woopaca.practice.item.entity.Category;
import woopaca.practice.member.entity.Grade;
import woopaca.practice.member.entity.Member;
import woopaca.practice.member.service.MemberService;
import woopaca.practice.member.service.MemberServiceImpl;
import woopaca.practice.order.entity.Order;
import woopaca.practice.order.service.OrderService;
import woopaca.practice.order.service.OrderServiceImpl;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

public class PracticeApp {

    private static final MemberService memberService = new MemberServiceImpl();
    private static final OrderService orderService = new OrderServiceImpl();
    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {

        isMemberOrNotMember();

    }

    public static void isMemberOrNotMember() throws IOException {
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
            System.out.println(ErrorMessage.LOGIN_ERROR);
            return;
        }

        loginSuccess(member);
    }

    public static void isNotMember() throws IOException {
        System.out.println("회원가입을 진행하기 위해 해당 정보를 입력해주세요.");
        String id;
        String name;

        System.out.print("\nID : ");
        id = br.readLine();
        System.out.print("\n이름 : ");
        name = br.readLine();

        Member member = new Member(id, name, Grade.BASIC);
        loginSuccess(member);
    }

    public static void loginSuccess(Member member) throws IOException {
        System.out.println("반갑습니다 " + member.getName() + " 님!");

        while (true) {
            System.out.println("무엇을 하시겠습니까? [ 1.주문하기  2.주문 조회  3.로그아웃 ]");
            int input = Integer.parseInt(br.readLine());
            boolean isLogout = false;

            switch (input) {
                case 1: {
                    order(member);
                    break;
                }
                case 2: {
                    getOrderList(member);
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
                break;
            }
        }
    }

    public static void order(Member member) throws IOException {

        while (true) {
            System.out.println("어떤 상품을 구매하시겠어요? [ 1.IT  2.Food  3.Living  4.ETC  5.뒤로 가기]");
            int category = Integer.parseInt(br.readLine());
            boolean isGoBack = false;

            switch (category) {
                case 1: {

                }
                case 2: {

                }
                case 3: {

                }
                case 4: {

                }
                case 5: {
                    isGoBack = true;
                    break;
                }
                default: {
                    System.out.println(ErrorMessage.SELECT_ERROR);
                    break;
                }
            }

            if (isGoBack) {
                break;
            }
        }
    }

    public static void getOrderList(Member member) {
        System.out.println("[ 주문 조회 ]");
        List<Order> list = orderService.findOrderList(member);

        if (list == null) {
            System.out.println(ErrorMessage.ORDER_LIST_EMPTY);
            return;
        }

        for (Order order : list) {
            System.out.println("-------");
            System.out.println("상품 이름 : " + order.getItem().getItemName() + "\t\t상품 가격 : " + order.getPrice() + "\t\t결제 금액 : " + order.calculateDiscount());
        }
        System.out.println();
    }

    public static void getItemByCategory(Category category) {

    }
}

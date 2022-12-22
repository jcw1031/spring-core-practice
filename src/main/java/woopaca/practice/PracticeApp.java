package woopaca.practice;

import woopaca.practice.config.AppConfig;
import woopaca.practice.exception.ErrorMessage;
import woopaca.practice.item.entity.Category;
import woopaca.practice.item.entity.Item;
import woopaca.practice.item.service.ItemService;
import woopaca.practice.member.entity.Grade;
import woopaca.practice.member.entity.Member;
import woopaca.practice.member.service.MemberService;
import woopaca.practice.order.entity.Order;
import woopaca.practice.order.service.OrderService;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class PracticeApp {
    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static MemberService memberService;
    private static OrderService orderService;
    private static ItemService itemService;

    public static void main(String[] args) throws IOException {
        AppConfig appConfig = new AppConfig();
        memberService = appConfig.memberService();
        orderService = appConfig.orderService();
        itemService = appConfig.itemService();

        List<Item> list = new ArrayList<>();
        list.add(new Item(1L, "맥북", 3400000, Category.IT));
        list.add(new Item(2L, "아이폰", 1290000, Category.IT));
        list.add(new Item(3L, "한돈 삼겹살 600g", 19900, Category.FOOD));
        list.add(new Item(4L, "아메리카노", 2500, Category.FOOD));
        list.add(new Item(5L, "DESKER 책상", 187000, Category.LIVING));
        list.add(new Item(6L, "dyson 청소기", 579000, Category.LIVING));
        list.add(new Item(7L, "공책", 4000, Category.ETC));
        list.add(new Item(8L, "볼펜", 7000, Category.ETC));
        list.add(new Item(9L, "백팩", 119000, Category.ETC));

        for (Item item : list) {
            itemService.register(item);
        }

        isMemberOrNotMember();

    }

    public static void isMemberOrNotMember() throws IOException {
        System.out.println("안녕하세요. 우파카마켓입니다.\n회원이신가요? [y/n]");
        String input = br.readLine();

        if (input.equals("y")) {
            isMember();
            return;
        }
        if (input.equals("n")) {
            isNotMember();
            return;
        }

        System.out.println(ErrorMessage.SELECT_ERROR);
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
        memberService.join(member);
        isMember();
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
                    getItemByCategory(Category.IT);
                    break;
                }
                case 2: {
                    getItemByCategory(Category.FOOD);
                    break;
                }
                case 3: {
                    getItemByCategory(Category.LIVING);
                    break;
                }
                case 4: {
                    getItemByCategory(Category.ETC);
                    break;
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
        List<Item> list = itemService.itemListInCategory(category);
        if (list == null) {
            System.out.println(ErrorMessage.ITEM_LIST_EMPTY);
            return;
        }

        for (Item item : list) {
            System.out.println("-------");
            System.out.println("상품 이름 : " + item.getItemName() + "\t\t상품 가격 : " + item.getItemPrice());
        }
        System.out.println();
    }
}

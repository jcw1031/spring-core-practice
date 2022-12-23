package woopaca.practice;

import woopaca.practice.config.AppConfig;
import woopaca.practice.exception.ErrorMessage;
import woopaca.practice.item.entity.Category;
import woopaca.practice.item.entity.Item;
import woopaca.practice.item.service.ItemService;
import woopaca.practice.member.entity.Member;
import woopaca.practice.member.service.MemberService;
import woopaca.practice.order.entity.Order;
import woopaca.practice.order.service.OrderService;
import woopaca.practice.view.StartView;

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

        StartView startView = new StartView();

    }
}

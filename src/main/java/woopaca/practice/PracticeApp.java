package woopaca.practice;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import woopaca.practice.exception.ErrorMessage;
import woopaca.practice.item.entity.Category;
import woopaca.practice.item.entity.Item;
import woopaca.practice.item.service.ItemService;
import woopaca.practice.view.StartView;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class PracticeApp {
    public static final ApplicationContext APPLICATION_CONTEXT = new AnnotationConfigApplicationContext(AutoAppConfig.class);

    public static void main(String[] args) throws IOException {
        ItemService itemService = APPLICATION_CONTEXT.getBean(ItemService.class);

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

        itemService.register(list);

        while (true) {
            try {
                new StartView();
                break;
            } catch (IllegalArgumentException exception) {
                System.out.println(ErrorMessage.SELECT_ERROR);
            }
        }
    }
}

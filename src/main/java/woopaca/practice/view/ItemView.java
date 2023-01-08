package woopaca.practice.view;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import woopaca.practice.AutoAppConfig;
import woopaca.practice.exception.ErrorMessage;
import woopaca.practice.item.entity.Category;
import woopaca.practice.item.entity.Item;
import woopaca.practice.item.service.ItemService;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

public class ItemView {

    private final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private final ItemService itemService;

    public ItemView() {
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(AutoAppConfig.class);
        itemService = applicationContext.getBean(ItemService.class);
    }

    public Item getItemByCategory(Category category) throws IOException {
        List<Item> list = itemService.itemListInCategory(category);
        if (list == null) {
            System.out.println(ErrorMessage.ITEM_LIST_EMPTY);
            return null;
        }

        int i = 1;
        for (Item item : list) {
            System.out.println("-------");
            System.out.println("번호 : " + i++ + "\t\t상품 이름 : " + item.getItemName() + "\t\t상품 가격 : " + item.getItemPrice());
        }
        System.out.println();

        System.out.println("구매할 상품의 번호를 입력하세요.");
        int input = Integer.parseInt(br.readLine());

        return selectItem(list, input);
    }

    public Item selectItem(List<Item> list, int number) {
        return list.get(number - 1);
    }

}

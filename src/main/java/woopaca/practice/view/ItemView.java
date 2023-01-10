package woopaca.practice.view;

import woopaca.practice.exception.ErrorMessage;
import woopaca.practice.item.entity.Category;
import woopaca.practice.item.entity.Item;
import woopaca.practice.item.service.ItemService;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

import static woopaca.practice.PracticeApp.APPLICATION_CONTEXT;

public class ItemView {

    private final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private final ItemService itemService;

    public ItemView() {
        itemService = APPLICATION_CONTEXT.getBean(ItemService.class);
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

        if (input > list.size()) {
            throw new IllegalArgumentException();
        }

        return selectItem(list, input);
    }

    public Item selectItem(List<Item> list, int number) {
        return list.get(number - 1);
    }

}

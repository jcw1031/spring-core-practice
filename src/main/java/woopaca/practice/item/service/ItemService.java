package woopaca.practice.item.service;

import woopaca.practice.item.entity.Category;
import woopaca.practice.item.entity.Item;

import java.util.List;

public interface ItemService {

    void register(Item item);

    List<Item> itemListInCategory(Category category);

}

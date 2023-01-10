package woopaca.practice.item.service;

import woopaca.practice.item.entity.Category;
import woopaca.practice.item.entity.Item;

import java.util.List;

public interface ItemService {

    void register(List<Item> items);

    List<Item> itemListInCategory(Category category);

}

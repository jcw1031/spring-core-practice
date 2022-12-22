package woopaca.practice.item.repository;

import woopaca.practice.item.entity.Category;
import woopaca.practice.item.entity.Item;

import java.util.List;

public interface ItemRepository {

    void save(Item item);

    List<Item> findByCategory(Category category);

}

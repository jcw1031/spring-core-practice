package woopaca.practice.item.repository;

import woopaca.practice.item.entity.Item;

public interface ItemRepository {

    void save(Item item);

    Item findById(Long itemId);

}

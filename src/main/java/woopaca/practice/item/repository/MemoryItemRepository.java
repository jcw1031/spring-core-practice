package woopaca.practice.item.repository;

import woopaca.practice.item.entity.Item;

import java.util.HashMap;
import java.util.Map;

public class MemoryItemRepository implements ItemRepository {

    private static final Map<Long, Item> memory = new HashMap<>();

    @Override
    public void save(Item item) {
        memory.put(item.getItemId(), item);
    }

    @Override
    public Item findById(Long itemId) {
        return memory.get(itemId);
    }

}

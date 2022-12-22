package woopaca.practice.item.repository;

import woopaca.practice.item.entity.Category;
import woopaca.practice.item.entity.Item;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MemoryItemRepository implements ItemRepository {

    private static final Map<Category, List<Item>> memory = new HashMap<>();

    @Override
    public void save(Item item) {
        List<Item> list = memory.get(item.getCategory());
        list.add(item);
    }

    @Override
    public List<Item> findByCategory(Category category) {
        return memory.get(category);
    }

}

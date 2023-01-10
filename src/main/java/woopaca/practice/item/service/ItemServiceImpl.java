package woopaca.practice.item.service;

import org.springframework.stereotype.Component;
import woopaca.practice.item.entity.Category;
import woopaca.practice.item.entity.Item;
import woopaca.practice.item.repository.ItemRepository;

import java.util.List;

@Component
public class ItemServiceImpl implements ItemService {

    private final ItemRepository itemRepository;

    public ItemServiceImpl(ItemRepository itemRepository) {
        this.itemRepository = itemRepository;
    }

    @Override
    public void register(List<Item> items) {
        for (Item item : items) {
            if (item != null) {
                itemRepository.save(item);
            }
        }
    }

    @Override
    public List<Item> itemListInCategory(Category category) {
        return itemRepository.findByCategory(category);
    }
}

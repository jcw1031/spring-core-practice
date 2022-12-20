package woopaca.practice.item.entity;

public class Item {

    private String itemName;
    private int itemPrice;
    private Category category;

    public Item(String itemName, int itemPrice, Category category) {
        this.itemName = itemName;
        this.itemPrice = itemPrice;
        this.category = category;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public int getItemPrice() {
        return itemPrice;
    }

    public void setItemPrice(int itemPrice) {
        this.itemPrice = itemPrice;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }
}

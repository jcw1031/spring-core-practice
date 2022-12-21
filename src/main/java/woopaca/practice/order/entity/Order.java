package woopaca.practice.order.entity;

import woopaca.practice.item.entity.Item;
import woopaca.practice.member.entity.Member;

public class Order {

    private Member member;
    private Item item;
    private int price;
    private int discountPrice;

    public Order(Member member, Item item, int price, int discountPrice) {
        this.member = member;
        this.item = item;
        this.price = price;
        this.discountPrice = discountPrice;
    }

    public int calculateDiscount() {
        return price - discountPrice;
    }

    public Member getMember() {
        return member;
    }

    public void setMember(Member member) {
        this.member = member;
    }

    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getDiscountPrice() {
        return discountPrice;
    }

    public void setDiscountPrice(int discountPrice) {
        this.discountPrice = discountPrice;
    }

    @Override
    public String toString() {
        return "\nOrder {\n" +
                "member=" + member +
                ",\nitem=" + item +
                ",\nprice=" + price +
                ",\ndiscountPrice=" + discountPrice +
                '}';
    }
}

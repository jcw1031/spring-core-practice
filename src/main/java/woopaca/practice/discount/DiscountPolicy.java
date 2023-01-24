package woopaca.practice.discount;

import woopaca.practice.member.entity.User;

public interface DiscountPolicy {

    int discount(User member, int price);

}

package woopaca.practice.discount;

import woopaca.practice.member.entity.Member;

public interface DiscountPolicy {

    int discount(Member member, int price);

}

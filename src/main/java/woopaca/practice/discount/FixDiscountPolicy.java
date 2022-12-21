package woopaca.practice.discount;

import woopaca.practice.member.entity.Grade;
import woopaca.practice.member.entity.Member;

public class FixDiscountPolicy implements DiscountPolicy {

    private final int DISCOUNT_FIX_AMOUNT = 1000;

    @Override
    public int discount(Member member, int price) {
        if (member.getGrade() == Grade.VIP) {
            return DISCOUNT_FIX_AMOUNT;
        } else {
            return 0;
        }
    }
}

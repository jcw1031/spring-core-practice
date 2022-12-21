package woopaca.practice.discount;

import woopaca.practice.member.entity.Grade;
import woopaca.practice.member.entity.Member;

public class FlexibleDiscountPolicy implements DiscountPolicy {

    @Override
    public int discount(Member member, int price) {
        if (member.getGrade() == Grade.VIP) {
            return (int) (price * 0.05);
        }

        return 0;
    }
}

package woopaca.practice.order.repository;

import woopaca.practice.member.entity.Member;
import woopaca.practice.order.entity.Order;

public interface OrderRepository {

    void save(Order order);

    Order findByMember(Member member);

}

package woopaca.practice.order.repository;

import woopaca.practice.member.entity.Member;
import woopaca.practice.order.entity.Order;

import java.util.List;

public interface OrderRepository {

    void save(Order order);

    List<Order> findByMember(Member member);

}

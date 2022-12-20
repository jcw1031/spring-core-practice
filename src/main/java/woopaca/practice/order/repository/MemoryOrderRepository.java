package woopaca.practice.order.repository;

import woopaca.practice.member.entity.Member;
import woopaca.practice.order.entity.Order;

import java.util.HashMap;
import java.util.Map;

public class MemoryOrderRepository implements OrderRepository {

    Map<Member, Order> memory = new HashMap<>();

    @Override
    public void save(Order order) {
        memory.put(order.getMember(), order);
    }

    @Override
    public Order findByMember(Member member) {
        return memory.get(member);
    }
}

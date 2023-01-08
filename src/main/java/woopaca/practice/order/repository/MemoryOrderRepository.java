package woopaca.practice.order.repository;

import org.springframework.stereotype.Component;
import woopaca.practice.member.entity.Member;
import woopaca.practice.order.entity.Order;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class MemoryOrderRepository implements OrderRepository {

    Map<Member, List<Order>> memory = new HashMap<>();

    @Override
    public void save(Order order) {
        if (memory.containsKey(order.getMember())) {
            List<Order> list = memory.get(order.getMember());
            list.add(order);
            return;
        }

        List<Order> list = new ArrayList<>();
        list.add(order);
        memory.put(order.getMember(), list);
    }

    @Override
    public List<Order> findByMember(Member member) {
        return memory.get(member);
    }
}

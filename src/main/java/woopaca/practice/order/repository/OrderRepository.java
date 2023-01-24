package woopaca.practice.order.repository;

import org.springframework.stereotype.Component;
import woopaca.practice.member.entity.User;
import woopaca.practice.order.entity.Order;

import java.util.List;

@Component
public interface OrderRepository {

    void save(Order order);

    List<Order> findByMember(User member);

}

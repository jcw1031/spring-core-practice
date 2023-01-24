package woopaca.practice.order.service;

import org.springframework.stereotype.Component;
import woopaca.practice.discount.DiscountPolicy;
import woopaca.practice.item.entity.Item;
import woopaca.practice.member.entity.User;
import woopaca.practice.order.entity.Order;
import woopaca.practice.order.repository.OrderRepository;

import java.util.List;

@Component
public class OrderServiceImpl implements OrderService {

    private final OrderRepository orderRepository;
    private final DiscountPolicy discountPolicy;

    public OrderServiceImpl(OrderRepository orderRepository, DiscountPolicy discountPolicy) {
        this.orderRepository = orderRepository;
        this.discountPolicy = discountPolicy;
    }

    @Override
    public Order createOrder(User member, Item item) {
        int price = item.getItemPrice();
        int discountPrice = discountPolicy.discount(member, price);

        Order order = new Order(member, item, price, discountPrice);
        orderRepository.save(order);

        return order;
    }

    @Override
    public List<Order> findOrderList(User member) {
        return orderRepository.findByMember(member);
    }
}

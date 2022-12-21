package woopaca.practice.order.service;

import woopaca.practice.discount.DiscountPolicy;
import woopaca.practice.discount.FlexibleDiscountPolicy;
import woopaca.practice.item.entity.Item;
import woopaca.practice.member.entity.Member;
import woopaca.practice.order.entity.Order;
import woopaca.practice.order.repository.MemoryOrderRepository;
import woopaca.practice.order.repository.OrderRepository;

import java.util.List;

public class OrderServiceImpl implements OrderService {

    private final OrderRepository orderRepository = new MemoryOrderRepository();
    private final DiscountPolicy discountPolicy = new FlexibleDiscountPolicy();

    @Override
    public Order createOrder(Member member, Item item) {
        int price = item.getItemPrice();
        int discountPrice = discountPolicy.discount(member, price);

        Order order = new Order(member, item, price, discountPrice);
        orderRepository.save(order);

        return order;
    }

    @Override
    public List<Order> findOrderList(Member member) {
        return orderRepository.findByMember(member);
    }
}

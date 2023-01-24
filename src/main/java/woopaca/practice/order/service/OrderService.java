package woopaca.practice.order.service;

import woopaca.practice.item.entity.Item;
import woopaca.practice.member.entity.User;
import woopaca.practice.order.entity.Order;

import java.util.List;

public interface OrderService {

    Order createOrder(User member, Item item);

    List<Order> findOrderList(User member);
}

package woopaca.practice.order.service;

import woopaca.practice.item.entity.Item;
import woopaca.practice.member.entity.Member;
import woopaca.practice.order.entity.Order;

import java.util.List;

public interface OrderService {

    Order createOrder(Member member, Item item);

    List<Order> findOrderList(Member member);
}

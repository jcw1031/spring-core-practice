package woopaca.practice.order.service;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import woopaca.practice.item.entity.Category;
import woopaca.practice.item.entity.Item;
import woopaca.practice.member.entity.Grade;
import woopaca.practice.member.entity.Member;
import woopaca.practice.order.entity.Order;

import java.util.List;

public class OrderServiceTest {

    OrderService orderService = new OrderServiceImpl();

    @Test
    void 주문() {
        //given
        Member member = new Member(1L, "지찬우", Grade.VIP);
        Item item1 = new Item(1L, "맥북", 3400000, Category.IT);
        Item item2 = new Item(2L, "아이폰", 1200000, Category.IT);

        //when
        Order order1 = orderService.createOrder(member, item1);
        Order order2 = orderService.createOrder(member, item2);
        List<Order> list = orderService.findOrderList(member);

        //then
        Assertions.assertThat(list.get(0)).isEqualTo(order1);
        Assertions.assertThat(list.get(1)).isEqualTo(order2);

        System.out.println("list = " + list);
    }
}

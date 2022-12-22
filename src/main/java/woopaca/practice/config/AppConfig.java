package woopaca.practice.config;

import woopaca.practice.discount.FlexibleDiscountPolicy;
import woopaca.practice.item.repository.MemoryItemRepository;
import woopaca.practice.item.service.ItemService;
import woopaca.practice.item.service.ItemServiceImpl;
import woopaca.practice.member.repository.MemoryMemberRepository;
import woopaca.practice.member.service.MemberService;
import woopaca.practice.member.service.MemberServiceImpl;
import woopaca.practice.order.repository.MemoryOrderRepository;
import woopaca.practice.order.service.OrderService;
import woopaca.practice.order.service.OrderServiceImpl;

public class AppConfig {

    public MemberService memberService() {
        return new MemberServiceImpl(new MemoryMemberRepository());
    }

    public OrderService orderService() {
        return new OrderServiceImpl(new MemoryOrderRepository(), new FlexibleDiscountPolicy());
    }

    public ItemService itemService() {
        return new ItemServiceImpl(new MemoryItemRepository());
    }
}

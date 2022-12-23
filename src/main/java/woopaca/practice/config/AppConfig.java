package woopaca.practice.config;

import woopaca.practice.discount.DiscountPolicy;
import woopaca.practice.discount.FlexibleDiscountPolicy;
import woopaca.practice.item.repository.ItemRepository;
import woopaca.practice.item.repository.MemoryItemRepository;
import woopaca.practice.item.service.ItemService;
import woopaca.practice.item.service.ItemServiceImpl;
import woopaca.practice.member.repository.MemberRepository;
import woopaca.practice.member.repository.MemoryMemberRepository;
import woopaca.practice.member.service.MemberService;
import woopaca.practice.member.service.MemberServiceImpl;
import woopaca.practice.order.repository.MemoryOrderRepository;
import woopaca.practice.order.repository.OrderRepository;
import woopaca.practice.order.service.OrderService;
import woopaca.practice.order.service.OrderServiceImpl;

public class AppConfig {

    /**
     * MemberService
     */
    public MemberService memberService() {
        return new MemberServiceImpl(memberRepository());
    }

    /**
     * OrderService
     */
    public OrderService orderService() {
        return new OrderServiceImpl(orderRepository(), discountPolicy());
    }

    /**
     * ItemService
     */
    public ItemService itemService() {
        return new ItemServiceImpl(itemRepository());
    }

    /**
     * MemberRepository
     */
    private MemberRepository memberRepository() {
        return new MemoryMemberRepository();
    }

    /**
     * OrderRepository
     */
    private OrderRepository orderRepository() {
        return new MemoryOrderRepository();
    }

    /**
     * ItemRepository
     */
    private ItemRepository itemRepository() {
        return new MemoryItemRepository();
    }

    /**
     * DiscountPolicy
     */
    private DiscountPolicy discountPolicy() {
        return new FlexibleDiscountPolicy();
    }

}

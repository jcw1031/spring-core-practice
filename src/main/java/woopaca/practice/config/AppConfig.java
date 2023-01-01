package woopaca.practice.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
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

@Configuration
public class AppConfig {

    /**
     * MemberService
     */
    @Bean
    public MemberService memberService() {
        return new MemberServiceImpl(memberRepository());
    }

    /**
     * OrderService
     */
    @Bean
    public OrderService orderService() {
        return new OrderServiceImpl(orderRepository(), discountPolicy());
    }

    /**
     * ItemService
     */
    @Bean
    public ItemService itemService() {
        return new ItemServiceImpl(itemRepository());
    }

    /**
     * MemberRepository
     */
    @Bean
    public MemberRepository memberRepository() {
        return new MemoryMemberRepository();
    }

    /**
     * OrderRepository
     */
    @Bean
    public OrderRepository orderRepository() {
        return new MemoryOrderRepository();
    }

    /**
     * ItemRepository
     */
    @Bean
    public ItemRepository itemRepository() {
        return new MemoryItemRepository();
    }

    /**
     * DiscountPolicy
     */
    @Bean
    public DiscountPolicy discountPolicy() {
        return new FlexibleDiscountPolicy();
    }

}

package woopaca.practice.view;

import woopaca.practice.exception.ErrorMessage;
import woopaca.practice.item.entity.Category;
import woopaca.practice.item.entity.Item;
import woopaca.practice.member.entity.User;
import woopaca.practice.order.entity.Order;
import woopaca.practice.order.service.OrderService;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

import static woopaca.practice.PracticeApp.APPLICATION_CONTEXT;

public class OrderView {

    private final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private final OrderService orderService;

    public OrderView() {
        orderService = APPLICATION_CONTEXT.getBean(OrderService.class);
    }

    public void order(User member) throws IOException {
        ItemView itemView = new ItemView();
        Item item = null;

        while (true) {
            System.out.println("어떤 상품을 구매하시겠어요? [ 1.IT  2.Food  3.Living  4.ETC  5.뒤로 가기]");
            boolean isGoBack = false;

            try {
                int category = Integer.parseInt(br.readLine());

                switch (category) {
                    case 1: {
                        item = itemView.getItemByCategory(Category.IT);
                        break;
                    }
                    case 2: {
                        item = itemView.getItemByCategory(Category.FOOD);
                        break;
                    }
                    case 3: {
                        item = itemView.getItemByCategory(Category.LIVING);
                        break;
                    }
                    case 4: {
                        item = itemView.getItemByCategory(Category.ETC);
                        break;
                    }
                    case 5: {
                        isGoBack = true;
                        break;
                    }
                    default: {
                        System.out.println(ErrorMessage.SELECT_ERROR);
                        break;
                    }
                }
            } catch (IllegalArgumentException exception) {
                System.out.println(ErrorMessage.SELECT_ERROR);
                continue;
            }
            if (isGoBack) {
                break;
            }

            if (item != null) {
                orderService.createOrder(member, item);
                System.out.println(item.getItemName() + " 주문 완료!\n");
            }
        }
    }

    public void getOrderList(User member) {
        System.out.println("[ 주문 조회 ]");
        List<Order> orderList = orderService.findOrderList(member);

        if (orderList == null) {
            System.out.println(ErrorMessage.ORDER_LIST_EMPTY);
            return;
        }

        for (Order order : orderList) {
            System.out.println("-------");
            System.out.println("상품 이름 : " + order.getItem().getItemName() + "\t\t상품 가격 : " + order.getPrice() + "\t\t결제 금액 : " + order.calculateDiscount());
        }
        System.out.println();
    }
}

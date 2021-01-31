package kitchenpos.order;

import java.util.Arrays;
import java.util.List;

public class Orders {
	private List<Order> orders;

	public Orders(List<Order> orders) {
		this.orders = orders;
	}

	public boolean containsOderStatuses(List<OrderStatus> orderStatuses) {
		return orders.stream()
			.anyMatch(order -> order.containsOrderStatus(orderStatuses));

	}

	public void validateStatusNotCompletion() {
		if (containsOderStatuses(Arrays.asList(OrderStatus.COMPLETION, OrderStatus.MEAL))) {
			throw new IllegalArgumentException("완료되지 않은 주문이 있습니다.");
		}
	}
}
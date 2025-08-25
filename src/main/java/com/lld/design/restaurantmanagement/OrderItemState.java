package com.lld.design.restaurantmanagement;

public interface OrderItemState {
	void next(OrderItem item);
    void prev(OrderItem item);
    String getStatus();
}

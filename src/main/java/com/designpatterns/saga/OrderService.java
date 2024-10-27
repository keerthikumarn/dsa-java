package com.designpatterns.saga;

public class OrderService extends Service<String> {

	@Override
	public String getName() {
		return "Creating an order service..";
	}

}

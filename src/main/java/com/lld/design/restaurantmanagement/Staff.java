package com.lld.design.restaurantmanagement;

public abstract class Staff {

	private int staffId;
	private String name;

	public Staff(int staffId, String name) {
		this.staffId = staffId;
		this.name = name;
	}

	public int getStaffId() {
		return staffId;
	}

	public String getName() {
		return name;
	}
}

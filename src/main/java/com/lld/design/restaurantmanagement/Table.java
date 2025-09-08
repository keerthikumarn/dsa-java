package com.lld.design.restaurantmanagement;

public class Table {

	private int tableId;
	private int capacity;
	private TableStatus status;

	public Table(int tableId, int capacity) {
		this.tableId = tableId;
		this.capacity = capacity;
		this.status = TableStatus.AVAILABLE;
	}

	public int getTableId() {
		return tableId;
	}

	public void setTableId(int tableId) {
		this.tableId = tableId;
	}

	public int getCapacity() {
		return capacity;
	}

	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}

	public TableStatus getStatus() {
		return status;
	}

	public void setStatus(TableStatus status) {
		this.status = status;
	}

	public void reserve() {
		if (this.status == TableStatus.RESERVED) {
			throw new IllegalStateException("Table is already reserved.");
		}
		this.status = TableStatus.RESERVED;
	}

	public boolean isAvailable() {
		return this.status == TableStatus.AVAILABLE;
	}
	}

}

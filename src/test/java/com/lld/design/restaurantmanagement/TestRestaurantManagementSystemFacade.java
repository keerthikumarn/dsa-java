package com.lld.design.restaurantmanagement;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class TestRestaurantManagementSystemFacade {

	private RestaurantManagementSystemFacade facade;

	@BeforeEach
	void setUp() {
		facade = RestaurantManagementSystemFacade.getInstance();
	}

	@Test
	void addTableShouldAddTableWithValidData() {
		Table table = facade.addTable(1, 4);
		assertNotNull(table);
		assertEquals(1, table.getTableId());
		assertEquals(4, table.getCapacity());
	}

	@Test
	void addWaiterShouldAddWaiterWithValidData() {
		Waiter waiter = facade.addWaiter(101, "John");
		assertNotNull(waiter);
		assertEquals(101, waiter.getStaffId());
		assertEquals("John", waiter.getName());
	}

	@Test
	void addChefShouldAddChefWithValidData() {
		Chef chef = facade.addChef(201, "Alice");
		assertNotNull(chef);
		assertEquals(201, chef.getStaffId());
		assertEquals("Alice", chef.getName());
	}

	@Test
	void addMenuItemShouldAddMenuItemWithValidData() {
		MenuItem item = facade.addMenuItem("M001", "Pasta", 12.99);
		assertNotNull(item);
		assertEquals("M001", item.getId());
		assertEquals("Pasta", item.getName());
		assertEquals(12.99, item.getPrice());
	}

	@Test
	void addTableShouldThrowExceptionForInvalidCapacity() {
		Exception exception = assertThrows(IllegalArgumentException.class, () -> {
			facade.addTable(2, -1);
		});
		assertEquals("Capacity must be greater than 0", exception.getMessage());
	}

	@Test
    void addMenuItemShouldThrowExceptionForNegativePrice() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            facade.addMenuItem("M002", "Burger", -5.0);
        });
        assertEquals("Price cannot be negative", exception.getMessage());

	}
}

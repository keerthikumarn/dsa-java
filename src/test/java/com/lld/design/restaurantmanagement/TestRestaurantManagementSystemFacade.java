package com.lld.design.restaurantmanagement;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.function.Executable;

import java.util.Collections;

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
	
	@Test
    void takeOrderShouldCreateOrderWhenValidInputsProvided() {
		facade.reset();
        facade.addTable(1, 4);
        facade.addWaiter(1, "Keerthi Kumar N");
        facade.addChef(1, "Chef A");
        facade.addMenuItem("1", "Biriyani", 10.0);
        Order order = facade.takeOrder(1, 1, Collections.singletonList("1"));
        assertEquals(1, order.getOrderId());
        assertEquals(1, order.getTableId());
        assertEquals(1, order.getOrderItems().size());
    }

    @Test
    void takeOrderShouldThrowExceptionWhenInvalidWaiterIdProvided() {
        facade.addTable(1, 4);
        facade.addChef(1, "Chef A");
        facade.addMenuItem("1", "Pizza", 10.0);
        Executable executable = () -> facade.takeOrder(1, 99, Collections.singletonList("1"));
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, executable);
        assertEquals("Invalid waiter ID", exception.getMessage());
    }

    @Test
    void takeOrderShouldThrowExceptionWhenNoChefsAvailable() {
        facade.addTable(1, 4);
        facade.addWaiter(1, "John");
        facade.addMenuItem("1", "Pizza", 10.0);
        Executable executable = () -> facade.takeOrder(1, 1, Collections.singletonList("1"));
        IllegalStateException exception = assertThrows(IllegalStateException.class, executable);
        assertEquals("No chefs available", exception.getMessage());
    }

    @Test
    void takeOrderShouldThrowExceptionWhenMenuItemIdIsInvalid() {
        facade.addTable(1, 4);
        facade.addWaiter(1, "John");
        facade.addChef(1, "Chef A");
        Executable executable = () -> facade.takeOrder(1, 1, Collections.singletonList("99"));
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, executable);
        assertEquals("Menu item with ID 99 not found.", exception.getMessage());
    }

    @Test
    void takeOrder_ShouldHandleEmptyMenuItemList() {
        facade.addTable(1, 4);
        facade.addWaiter(1, "John");
        facade.addChef(1, "Chef A");
        Order order = facade.takeOrder(1, 1, Collections.emptyList());
        assertNotNull(order);
        assertEquals(0, order.getOrderItems().size());
    }
}

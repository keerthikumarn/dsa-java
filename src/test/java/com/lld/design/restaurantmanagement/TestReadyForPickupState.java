package com.lld.design.restaurantmanagement;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.ArgumentMatchers.any;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class TestReadyForPickupState {

    @Test
    @DisplayName("next should notify observers when called")
    void nextNotifiesObservers() {
        OrderItem mockItem = mock(OrderItem.class);
        ReadyForPickupState state = new ReadyForPickupState();
        state.next(mockItem);
        verify(mockItem).notifyObservers();
    }

    @Test
    @DisplayName("prev should set state to PreparingState")
    void prevSetsStateToPreparingState() {
        OrderItem mockItem = mock(OrderItem.class);
        ReadyForPickupState state = new ReadyForPickupState();
        state.prev(mockItem);
        verify(mockItem).setState(any(PreparingState.class));
    }

    @Test
    @DisplayName("getStatus should return READY_FOR_PICKUP")
    void getStatusReturnsReadyForPickup() {
        ReadyForPickupState state = new ReadyForPickupState();
        String status = state.getStatus();
        assertEquals("READY_FOR_PICKUP", status);
    }
}


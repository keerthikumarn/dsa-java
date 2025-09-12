package com.lld.design.restaurantmanagement;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.ArgumentMatchers.any;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class TestOrderedState {

    @Test
    @DisplayName("next should set state to PreparingState")
    void nextSetsStateToPreparingState() {
        OrderItem mockItem = mock(OrderItem.class);
        OrderedState state = new OrderedState();
        state.next(mockItem);
        verify(mockItem).setState(any(PreparingState.class));
    }

    @Test
    @DisplayName("prev should print root state message")
    void prevPrintsRootStateMessage() {
        OrderedState state = new OrderedState();
        OrderItem mockItem = mock(OrderItem.class);
        state.prev(mockItem);
    }

    @Test
    @DisplayName("getStatus should return ORDERED")
    void getStatusReturnsOrdered() {
        OrderedState state = new OrderedState();
        String status = state.getStatus();
        assertEquals("ORDERED", status);
    }
}


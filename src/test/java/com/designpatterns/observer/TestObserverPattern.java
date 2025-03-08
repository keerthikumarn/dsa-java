package com.designpatterns.observer;
import static org.mockito.Mockito.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class TestObserverPattern {

    private DeliveryData deliveryData;
    private Observer mockObserver1;
    private Observer mockObserver2;

    @BeforeEach
    void setUp() {
        deliveryData = new DeliveryData();
        mockObserver1 = mock(Observer.class);
        mockObserver2 = mock(Observer.class);
    }

    @Test
    void observersReceiveUpdateWhenLocationChanges() {
        deliveryData.register(mockObserver1);
        deliveryData.register(mockObserver2);
        deliveryData.locationChanged();
        verify(mockObserver1, times(1)).update("Dummy place - 1");
        verify(mockObserver2, times(1)).update("Dummy place - 1");
    }

    @Test
    void observerDoesNotReceiveUpdateAfterUnregister() {
        deliveryData.register(mockObserver1);
        deliveryData.unregister(mockObserver1);
        deliveryData.locationChanged();
        verify(mockObserver1, never()).update(anyString());
    }

    @Test
    void noObserversRegistered() {
        deliveryData.locationChanged();
        verify(mockObserver1, never()).update(anyString());
        verify(mockObserver2, never()).update(anyString());
    }

    @Test
    void multipleLocationChanges() {
        deliveryData.register(mockObserver1);
        deliveryData.locationChanged();
        deliveryData.locationChanged();
        verify(mockObserver1, times(2)).update("Dummy place - 1");
    }

}

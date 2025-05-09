package com.designpatterns.observer;

import java.util.ArrayList;
import java.util.List;

public class DeliveryData implements Subject {

	private List<Observer> observers;
	private String location;

	public DeliveryData() {
		this.observers = new ArrayList<>();
	}

	@Override
	public void register(Observer obj) {
		observers.add(obj);
	}

	@Override
	public void unregister(Observer obj) {
		observers.remove(obj);
	}

	@Override
	public void notifyObservers() {
		for (Observer obj : observers) {
			obj.update(location);
		}
	}

	public String getLocation() {
		return "Dummy place - 1";
	}

	public void locationChanged() {
		this.location = getLocation();
		notifyObservers();
	}
}

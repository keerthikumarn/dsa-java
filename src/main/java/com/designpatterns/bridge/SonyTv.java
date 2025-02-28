package com.designpatterns.bridge;

public class SonyTv implements Remote {

	private int volume = 0;

	@Override
	public void turnOn() {
		System.out.println("Turning on Sony TV");
	}

	@Override
	public void turnOff() {
		System.out.println("Turning off Sony TV");
	}

	@Override
	public void setVolume(int volume) {
		this.volume = volume;
		System.out.println("Setting volume to " + this.volume);
	}

}

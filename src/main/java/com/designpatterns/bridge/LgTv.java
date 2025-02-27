package com.designpatterns.bridge;

public class LgTv implements Remote {

	private int volume = 0;

	@Override
	public void turnOn() {
		System.out.println("Turning on LG TV");
	}

	@Override
	public void turnOff() {
		System.out.println("Turning off LG TV");
	}

	@Override
	public void setVolume(int volume) {
		this.volume = volume;
		System.out.println("Setting volume to " + this.volume);
	}

}

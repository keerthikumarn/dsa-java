package com.designpatterns.bridge;

public class AdvancedRemote extends AbstractRemoteControl {

	public AdvancedRemote(Remote remote) {
		super(remote);
	}

	@Override
	public void turnOn() {
		System.out.println("Advanced Remote: Turning TV ON...");
		remote.turnOn();
	}

	@Override
	public void turnOff() {
		System.out.println("Advanced Remote: Turning TV OFF...");
		remote.turnOff();
	}

	@Override
	public void setVolume(int volume) {
		System.out.println("Advanced Remote: Adjusting volume...");
		remote.setVolume(volume);
	}

	public void mute() {
		System.out.println("Advanced Remote: Muting TV...");
		remote.setVolume(0);
	}
}

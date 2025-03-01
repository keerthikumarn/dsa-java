package com.designpatterns.bridge;

public class BasicRemote extends AbstractRemoteControl {

	public BasicRemote(Remote remote) {
		super(remote);
	}

	@Override
	public void turnOn() {
		System.out.println("Basic Remote: Turning TV ON...");
		remote.turnOn();

	}

	@Override
	public void turnOff() {
		System.out.println("Basic Remote: Turning TV OFF...");
		remote.turnOff();

	}

	@Override
	public void setVolume(int volume) {
		System.out.println("Basic Remote: Adjusting volume...");
		remote.setVolume(volume);
	}
	
	public void mute() {
		System.out.println("Advanced Remote: Muting TV...");
        remote.setVolume(0);
	}

}

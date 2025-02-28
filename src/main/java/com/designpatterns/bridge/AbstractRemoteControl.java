package com.designpatterns.bridge;

public abstract class AbstractRemoteControl {

	protected Remote remote;

	public AbstractRemoteControl(Remote remote) {
		this.remote = remote;
	}

	public abstract void turnOn();

	public abstract void turnOff();

	public abstract void setVolume(int volume);

}

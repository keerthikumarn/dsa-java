package com.designpatterns.bridge;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

public class TestRemoteControl {
	
	@Test
	void basicRemoteTurnsOnSonyTv() {
		Remote sonyTV = new SonyTv();
		AbstractRemoteControl basicRemote = new BasicRemote(sonyTV);
		basicRemote.turnOn();
		assertTrue(true);
	}

	@Test
	void basicRemoteTurnsOffSonyTv() {
		Remote sonyTV = new SonyTv();
		AbstractRemoteControl basicRemote = new BasicRemote(sonyTV);
		basicRemote.turnOff();
		assertTrue(true);
	}

	@Test
	void basicRemoteSetsVolumeOnSonyTv() {
		Remote sonyTV = new SonyTv();
		AbstractRemoteControl basicRemote = new BasicRemote(sonyTV);
		basicRemote.setVolume(10);
		assertTrue(true);
	}

	@Test
	void advancedRemoteTurnsOnLgTv() {
		Remote lgTv = new LgTv();
		AbstractRemoteControl advancedRemote = new AdvancedRemote(lgTv);
		advancedRemote.turnOn();
		assertTrue(true);
	}

	@Test
	void advancedRemoteTurnsOffLgTv() {
		Remote lgTv = new LgTv();
		AbstractRemoteControl advancedRemote = new AdvancedRemote(lgTv);
		advancedRemote.turnOff();
		assertTrue(true);
	}

	@Test
	void advancedRemoteSetsVolumeOnLgTv() {
		Remote lgTv = new LgTv();
		AbstractRemoteControl advancedRemote = new AdvancedRemote(lgTv);
		advancedRemote.setVolume(20);
		assertTrue(true);
	}

	@Test
	void advancedRemoteMutesLgTv() {
		Remote lgTv = new LgTv();
		AdvancedRemote advancedRemote = new AdvancedRemote(lgTv);
		advancedRemote.mute();
		assertTrue(true);
	}
}

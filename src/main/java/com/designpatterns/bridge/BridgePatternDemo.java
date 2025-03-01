package com.designpatterns.bridge;

public class BridgePatternDemo {
    public static void main(String[] args) {
        // Using a Basic Remote with a Sony TV
        Remote sonyTV = new SonyTv();
        AbstractRemoteControl basicRemote = new BasicRemote(sonyTV);
        
        System.out.println("Using Basic Remote with Sony TV:");
        basicRemote.turnOn();
        basicRemote.setVolume(15);
        basicRemote.turnOff();
        
        System.out.println("\n-----------------------\n");

        // Using an Advanced Remote with a Lg TV
        Remote lgTv = new LgTv();
        AbstractRemoteControl advancedRemote = new AdvancedRemote(lgTv);

        System.out.println("Using Advanced Remote with LG TV:");
        advancedRemote.turnOn();
        advancedRemote.setVolume(20);
        ((AdvancedRemote) advancedRemote).mute();
        advancedRemote.turnOff();
    }
}


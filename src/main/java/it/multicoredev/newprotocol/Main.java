package it.multicoredev.newprotocol;

import org.github.jamm.MemoryMeter;

public class Main {

    public static void main(String... args){
        IPPacket object = new IPPacket((byte) 2, 22, 222);
        MemoryMeter memoryMeter = new MemoryMeter();
        System.out.println("Object type: " + object.getClass() +
                ", size: " + memoryMeter.measure(object) + " bytes");
    }
}

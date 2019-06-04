package it.multicoredev.newprotocol;

import it.multicoredev.newprotocol.packets.IP;
import org.github.jamm.MemoryMeter;

public class Main {

    public static MemoryMeter memoryMeter = new MemoryMeter();

    public static void main(String... args){
        IP object = new IP(Protocol.CUSTOM, 22, 222);
        MemoryMeter memoryMeter = new MemoryMeter();
        System.out.println("Object type: " + object.getClass() +
                ", size: " + memoryMeter.measure(object) + " bytes");
    }
}

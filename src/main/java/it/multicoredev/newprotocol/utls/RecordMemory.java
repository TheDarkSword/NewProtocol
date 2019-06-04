package it.multicoredev.newprotocol.utls;

import it.multicoredev.newprotocol.Packet;

import java.util.ArrayList;

public class RecordMemory {

    private ArrayList<Packet> received;

    public RecordMemory(){
        received = new ArrayList<>();
    }

    public boolean wasAnOldPacket(Packet packet){
        return received.contains(packet);
    }
}

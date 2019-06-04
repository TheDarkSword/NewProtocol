package it.multicoredev.newprotocol.packets;

import it.multicoredev.newprotocol.Main;
import it.multicoredev.newprotocol.Packet;
import it.multicoredev.newprotocol.Protocol;
import it.multicoredev.newprotocol.network.exception.ExceededNumberException;
import it.multicoredev.newprotocol.utls.BITS;
import it.multicoredev.newprotocol.utls.Field;
import it.multicoredev.newprotocol.utls.IPAddress;

public class UDP implements Packet {

    private IP ipPacket;
    private Field sourcePort;
    private Field destinationPort;
    private Field length;
    private Field checksum;
    private Object data;

    public UDP(String sourceAddress, String destinationAddress, int sourcePort, int destinationPort, int length, Object data){
        this(new IPAddress(sourceAddress), new IPAddress(destinationAddress), sourcePort, destinationPort, length, data);
    }

    public UDP(IPAddress sourceAddress, IPAddress destinationAddress, int sourcePort, int destinationPort, int length, Object data){
        this(sourceAddress.getValue(), destinationAddress.getValue(), sourcePort, destinationPort, length, data);
    }

    public UDP(long sourceAddress, long destinationAddress, int sourcePort, int destinationPort, int length, Object data){
        this.ipPacket = new IP(Protocol.UDP, sourceAddress, destinationAddress);
        this.sourcePort = new Field(BITS.BIT16, sourcePort);
        this.destinationPort = new Field(BITS.BIT16, destinationPort);
        this.length = new Field(BITS.BIT16, length);
        this.checksum = new Field(BITS.BIT16, calculateChecksum());
        if(Main.memoryMeter.measure(data) > 496) throw new ExceededNumberException("Too many expansive");
        this.data = data;
    }

    public long getSourcePort(){
        return sourcePort.getValue();
    }

    public long getDestinationPort(){
        return destinationPort.getValue();
    }

    public long getLength(){
        return length.getValue();
    }

    public long getChecksum(){
        return checksum.getValue();
    }

    public long calculateChecksum(){
        return -1;
    }

    @Override
    public IPAddress getSourceIp() {
        return new IPAddress(ipPacket.getSourceAddress().getValue());
    }

    @Override
    public IPAddress getDestinationIp() {
        return new IPAddress(ipPacket.getSourceAddress().getValue());
    }
}

package it.multicoredev.newprotocol.packets;

import it.multicoredev.newprotocol.Packet;
import it.multicoredev.newprotocol.Protocol;
import it.multicoredev.newprotocol.utls.BITS;
import it.multicoredev.newprotocol.utls.Field;
import it.multicoredev.newprotocol.utls.IPAddress;

public class IP {

    private Field version;
    private Field ihl;
    private Field tos;
    private Field totalLength;
    private Field identification;
    private Field flags;
    private Field fragmentOffset;
    private Field timeToLive;
    private Field protocol;
    private Field headerChecksum;
    private Field sourceAddress;
    private Field destinationAddress;
    private Field options;
    private Packet data;

    public IP(long protocol, long sourceAddress, long destinationAddress){
        this(4, 160, 0, 20, 1, 0, 0, 10, protocol, sourceAddress, destinationAddress, 0, null);
    }

    public IP(Protocol protocol, long sourceAddress, long destinationAddress){
        this(4, 160, 0, 20, 1, 0, 0, 10, protocol.get(), sourceAddress, destinationAddress, 0, null);
    }

    public IP(long protocol, IPAddress sourceAddress, IPAddress destinationAddress){
        this(4, 160, 0, 20, 1, 0, 0, 10, protocol, sourceAddress.getValue(), destinationAddress.getValue(), 0, null);
    }

    public IP(long version, long ihl, long tos, long totalLength, long identification, long flags, long fragmentOffset, long timeToLive, Protocol protocol,
              IPAddress sourceAddress, IPAddress destinationAddress, long options){
        this(version, ihl, tos, totalLength, identification, flags, fragmentOffset, timeToLive, protocol.get(), sourceAddress.getValue(), destinationAddress.getValue(), options, null);
    }

    public IP(long version, long ihl, long tos, long totalLength, long identification, long flags, long fragmentOffset, long timeToLive, Protocol protocol,
              IPAddress sourceAddress, IPAddress destinationAddress, long options, Packet data){
        this(version, ihl, tos, totalLength, identification, flags, fragmentOffset, timeToLive, protocol.get(), sourceAddress.getValue(), destinationAddress.getValue(), options, data);
    }

    public IP(long version, long ihl, long tos, long totalLength, long identification, long flags, long fragmentionOffset, long timeToLive, long protocol,
              long sourceAddress, long destinationAddress, long options){
        this(version, ihl, tos, totalLength, identification, flags, fragmentionOffset, timeToLive, protocol, sourceAddress, destinationAddress, options, null);
    }

    public IP(long version, long ihl, long tos, long totalLength, long identification, long flags, long fragmentOffset, long timeToLive, long protocol,
              long sourceAddress, long destinationAddress, long options, Packet data){
        this.version = new Field(BITS.BIT4, version);
        this.ihl = new Field(BITS.BIT4, ihl);
        this.tos = new Field(BITS.BIT8, tos);
        this.totalLength = new Field(BITS.BIT16, totalLength);
        this.identification = new Field(BITS.BIT16, identification);
        this.flags = new Field(BITS.BIT3, flags);
        this.fragmentOffset = new Field(BITS.BIT13, fragmentOffset);
        this.timeToLive = new Field(BITS.BIT8, timeToLive);
        this.protocol = new Field(BITS.BIT8, protocol);
        this.sourceAddress = new Field(BITS.BIT32, sourceAddress);
        this.destinationAddress = new Field(BITS.BIT32, destinationAddress);
        this.options = new Field(BITS.BIT32, options);
        this.data = data;

        calculateChecksum();
    }

    private void calculateChecksum(){
        IPAddress sourceIP = new IPAddress(sourceAddress.getValue());
        IPAddress destinationIP = new IPAddress(destinationAddress.getValue());
        long first = ((version.getValue() <<  12) | (ihl.getValue() << 8) | (tos.getValue()));
        long second = totalLength.getValue();
        long third = identification.getValue();
        long fourth = (flags.getValue() << 13 | fragmentOffset.getValue());
        long fifth = (timeToLive.getValue() << 8 | protocol.getValue());
        long sixth = (sourceIP.getOctet(3) << 8 | sourceIP.getOctet(2));
        long seventh = (sourceIP.getOctet(1) << 8 | sourceIP.getOctet(0));
        long eighth = (destinationIP.getOctet(3) << 8 | destinationIP.getOctet(2));
        long ninth = (destinationIP.getOctet(1) << 8 | destinationIP.getOctet(0));
        headerChecksum = new Field(BITS.BIT16, ~(first + second + third + fourth + fifth + sixth + seventh + eighth + ninth));
    }

    public long getHeaderChecksum() {
        return headerChecksum.getValue();
    }

    public Field getSourceAddress() {
        return sourceAddress;
    }

    public Field getDestinationAddress() {
        return destinationAddress;
    }
}

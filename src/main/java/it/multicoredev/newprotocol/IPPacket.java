package it.multicoredev.newprotocol;

import it.multicoredev.newprotocol.utls.IPAddress;

public class IPPacket {

    private byte version;
    private byte ihl;
    private byte tos;
    private short totalLength;
    private short identification;
    private byte flags;
    private short fragmentionOffset;
    private byte timeToLive;
    private byte protocol;
    private short headerChecksum;
    private int sourceAddress;
    private int destinationAddress;
    private int options;
    private Object data;

    public IPPacket(byte protocol, int sourceAddress, int destinationAddress){
        this((byte) 4, (byte) 160, (byte) 0, (short) 20, (short) 1, (byte) 0, (byte) 0, (byte) 10, protocol, sourceAddress, destinationAddress, 0, null);
    }

    public IPPacket(byte protocol, IPAddress sourceAddress, IPAddress destinationAddress){
        this((byte) 4, (byte) 160, (byte) 0, (short) 20, (short) 1, (byte) 0, (byte) 0, (byte) 10, protocol, sourceAddress.getValue(), destinationAddress.getValue(), 0, null);
    }

    public IPPacket(byte version, byte ihl, byte tos, short totalLength, short identification, byte flags, short fragmentionOffset, byte timeToLive, Protocol protocol,
                    IPAddress sourceAddress, IPAddress destinationAddress, int options){
        this(version, ihl, tos, totalLength, identification, flags, fragmentionOffset, timeToLive, protocol.get(), sourceAddress.getValue(), destinationAddress.getValue(), options, null);
    }

    public IPPacket(byte version, byte ihl, byte tos, short totalLength, short identification, byte flags, short fragmentionOffset, byte timeToLive, Protocol protocol,
                    IPAddress sourceAddress, IPAddress destinationAddress, int options, Object data){
        this(version, ihl, tos, totalLength, identification, flags, fragmentionOffset, timeToLive, protocol.get(), sourceAddress.getValue(), destinationAddress.getValue(), options, data);
    }

    public IPPacket(byte version, byte ihl, byte tos, short totalLength, short identification, byte flags, short fragmentionOffset, byte timeToLive, byte protocol,
                    int sourceAddress, int destinationAddress, int options){
        this(version, ihl, tos, totalLength, identification, flags, fragmentionOffset, timeToLive, protocol, sourceAddress, destinationAddress, options, null);
    }

    public IPPacket(byte version, byte ihl, byte tos, short totalLength, short identification, byte flags, short fragmentionOffset, byte timeToLive, byte protocol,
                    int sourceAddress, int destinationAddress, int options, Object data){
        this.version = version;
        this.ihl = ihl;
        this.tos = tos;
        this.totalLength = totalLength;
        this.identification = identification;
        this.flags = flags;
        this.fragmentionOffset = fragmentionOffset;
        this.timeToLive = timeToLive;
        this.protocol = protocol;
        this.sourceAddress = sourceAddress;
        this.destinationAddress = destinationAddress;
        this.options = options;
        this.data = data;

        calculateChecksum();
    }

    protected void calculateChecksum(){
        IPAddress sourceIP = new IPAddress(sourceAddress);
        IPAddress destinationIP = new IPAddress(destinationAddress);
        short first = (short) ((version <<  12) | (ihl << 8) | (tos));
        short second = totalLength;
        short third = identification;
        short fourth = (short) (flags << 13 | fragmentionOffset);
        short fifth = (short) (timeToLive << 8 | protocol);
        short sixth = (short) (sourceIP.getOctet(3) << 8 | sourceIP.getOctet(2));
        short seventh = (short) (sourceIP.getOctet(1) << 8 | sourceIP.getOctet(0));
        short eighth = (short) (destinationIP.getOctet(3) << 8 | destinationIP.getOctet(2));
        short ninth = (short) (destinationIP.getOctet(1) << 8 | destinationIP.getOctet(0));
        headerChecksum = ((short) ~(first + second + third + fourth + fifth + sixth + seventh + eighth + ninth));
    }
}

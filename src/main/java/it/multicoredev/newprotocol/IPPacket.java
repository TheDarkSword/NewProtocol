package it.multicoredev.newprotocol;

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
    private double data;

    public IPPacket(byte version, byte ihl, byte tos, short totalLength, short identification, byte flags, short fragmentionOffset, byte timeToLive, byte protocol,
                    int sourceAddress, int destinationAddress, int options){
        this(version, ihl, tos, totalLength, identification, flags, fragmentionOffset, timeToLive, protocol, sourceAddress, destinationAddress, options, 0);
    }

    public IPPacket(byte version, byte ihl, byte tos, short totalLength, short identification, byte flags, short fragmentionOffset, byte timeToLive, byte protocol,
                    int sourceAddress, int destinationAddress, int options, double data){
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

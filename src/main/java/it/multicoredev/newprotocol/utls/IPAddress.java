package it.multicoredev.newprotocol.utls;

public class IPAddress {

    private final long value;

    public IPAddress(long value) {
        this.value = value;
    }

    public IPAddress(String stringValue) {
        String[] parts = stringValue.split("\\.");
        if( parts.length != 4 ) {
            throw new IllegalArgumentException();
        }
        value =
                (Long.parseLong(parts[0], 10) << (8*3)) & 0xFF000000 |
                        (Long.parseLong(parts[1], 10) << (8*2)) & 0x00FF0000 |
                        (Long.parseLong(parts[2], 10) << (8)) & 0x0000FF00 |
                        (Long.parseLong(parts[3], 10)) & 0x000000FF;
    }

    public long getOctet(int i) {

        if( i<0 || i>=4 ) throw new IndexOutOfBoundsException();

        return (value >> (i*8)) & 0x000000FF;
    }

    public String getIp(){
        return this.toString();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        for(int i=3; i>=0; --i) {
            sb.append(getOctet(i));
            if( i!= 0) sb.append(".");
        }

        return sb.toString();

    }

    @Override
    public boolean equals(Object obj) {
        return obj instanceof IPAddress && value == ((IPAddress) obj).value;
    }

    @Override
    public int hashCode() {
        return (int) value;
    }

    public long getValue() {
        return value;
    }

    public IPAddress next() {
        return new IPAddress(value+1);
    }

    public boolean isInSubnet(IPAddress ipAddress){
        return getOctet(3) == ipAddress.getOctet(3) && getOctet(2) == ipAddress.getOctet(2) && getOctet(1) == ipAddress.getOctet(1);
    }
}

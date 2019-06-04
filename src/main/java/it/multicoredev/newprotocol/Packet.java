package it.multicoredev.newprotocol;

import it.multicoredev.newprotocol.utls.IPAddress;

public interface Packet {

    IPAddress getSourceIp();

    IPAddress getDestinationIp();
}

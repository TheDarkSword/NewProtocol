package it.multicoredev.newprotocol.network;

import it.multicoredev.newprotocol.utls.IPAddress;

public class Connector {

    private String portName;
    private boolean isConnected;
    private CableConnector cableConnector;
    private IPAddress ipAddress;

    public Connector(String portName){
        this.portName = portName;
    }

    public String getPortName() {
        return portName;
    }

    public boolean isConnected() {
        return isConnected;
    }

    public CableConnector getCableConnector() {
        return cableConnector;
    }

    public IPAddress getIpAddress() {
        return ipAddress;
    }

    public void setPortName(String portName) {
        this.portName = portName;
    }

    public void setConnected(boolean connected) {
        isConnected = connected;
    }

    public void setCableConnector(CableConnector cableConnector) {
        this.cableConnector = cableConnector;
        setConnected(cableConnector != null);
    }

    public void setIpAddress(IPAddress ipAddress) {
        this.ipAddress = ipAddress;
    }
}

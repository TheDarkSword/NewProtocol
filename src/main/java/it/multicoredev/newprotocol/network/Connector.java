package it.multicoredev.newprotocol.network;

public class Connector {

    private String portName;
    private boolean isConnected;
    private CableConnector cableConnector;

    public Connector(){

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

    public void setPortName(String portName) {
        this.portName = portName;
    }

    public void setConnected(boolean connected) {
        isConnected = connected;
    }

    public void setCableConnector(CableConnector cableConnector) {
        this.cableConnector = cableConnector;
        if(cableConnector == null) setConnected(false);
        else setConnected(true);
    }
}

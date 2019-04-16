package it.multicoredev.newprotocol.network;

public class NetworkObject {

    protected Connector[] connectors;

    public NetworkObject(int size){
        connectors = new Connector[size];
        for(int i = 0; i < size; i++){
            connectors[i] = new Connector();
        }
    }

    public Connector[] getConnectors() {
        return connectors;
    }

    public void setConnectors(Connector[] connectors) {
        this.connectors = connectors;
    }
}

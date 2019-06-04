package it.multicoredev.newprotocol.network;

import it.multicoredev.newprotocol.utls.RecordMemory;

public class NetworkObject {

    protected Connector[] connectors;
    protected RecordMemory recordMemory;

    public NetworkObject(int size) {
        connectors = new Connector[size];
        for(int i = 0; i < size; i++){
            connectors[i] = new Connector("FastEthernet " + (i+1) + "/0");
        }

        recordMemory = new RecordMemory();
    }

    public Connector[] getConnectors() {
        return connectors;
    }

    public void setConnectors(Connector[] connectors) {
        this.connectors = connectors;
    }
}

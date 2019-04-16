package it.multicoredev.newprotocol.network;

public class CableConnector {

    private NetworkObject networkObject1;
    private Connector connector1;
    private NetworkObject networkObject2;
    private Connector connector2;

    public CableConnector(){

    }

    public CableConnector(NetworkObject networkObject1, NetworkObject networkObject2, Connector connector1, Connector connector2){
        this.networkObject1 = networkObject1;
        this.networkObject2 = networkObject2;
        this.connector1 = connector1;
        this.connector2 = connector2;
    }

    public NetworkObject getNetworkObject1() {
        return networkObject1;
    }

    public NetworkObject getNetworkObject2() {
        return networkObject2;
    }

    public Connector getConnector1() {
        return connector1;
    }

    public Connector getConnector2() {
        return connector2;
    }

    public void setNetworkObject1(NetworkObject networkObject1) {
        this.networkObject1 = networkObject1;
    }

    public void setNetworkObject2(NetworkObject networkObject1) {
        this.networkObject1 = networkObject1;
    }

    public void setConnector1(Connector connector1) {
        this.connector1 = connector1;
    }

    public void setConnector2(Connector connector2) {
        this.connector2 = connector2;
    }
}

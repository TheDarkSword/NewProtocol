package it.multicoredev.newprotocol.network;

import it.multicoredev.newprotocol.Packet;
import it.multicoredev.newprotocol.network.exception.NoConnectorsException;
import it.multicoredev.newprotocol.utls.IPAddress;

import java.util.ArrayList;

public class Switch extends NetworkObject {

    private ArrayList<NetworkObject> networkObjects;

    public Switch() {
        super(24);
        networkObjects = new ArrayList<>();
    }

    public ArrayList<NetworkObject> getNetworkObjects() {
        return networkObjects;
    }

    public void setNetworkObjects(ArrayList<NetworkObject> networkObjects) {
        this.networkObjects = networkObjects;
    }

    public void addNetworkObject(NetworkObject networkObject) {
        this.networkObjects.add(networkObject);
    }

    public NetworkObject getNetworkObject(int index) {
        return this.networkObjects.get(index);
    }

    public void connect(NetworkObject networkObject) throws NoConnectorsException {
        for (Connector connector : connectors) {
            if (!connector.isConnected()) {
                for (Connector objectConnector : networkObject.getConnectors()) {
                    if (!objectConnector.isConnected()) {
                        connector.setCableConnector(new CableConnector(this, networkObject, connector, objectConnector));
                        return;
                    }
                }
                throw new NoConnectorsException("Interface 2 [" + networkObject.getClass().getSimpleName() + "] haven't connectors available");
            }
        }
        throw new NoConnectorsException("Interface 1 [" + getClass().getSimpleName() + "] haven't connectors available");
    }

    public void sendToNext(Packet packet){
        if(recordMemory.wasAnOldPacket(packet)) return;
        for (Connector connector : connectors) {

        }
    }
}

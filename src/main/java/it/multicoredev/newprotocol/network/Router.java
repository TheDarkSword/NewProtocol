package it.multicoredev.newprotocol.network;

import it.multicoredev.newprotocol.Packet;
import it.multicoredev.newprotocol.network.exception.NoConnectorsException;
import it.multicoredev.newprotocol.utls.IPAddress;

import java.util.ArrayList;

public class Router extends NetworkObject {

    private ArrayList<NetworkObject> networkObjects;

    public Router() {
        super(3);
        networkObjects = new ArrayList<>();
    }

    public Router(int size) {
        super(size);
        networkObjects = new ArrayList<>();
    }

    public ArrayList<NetworkObject> getNetworkObjects() {
        return networkObjects;
    }

    public void setNetworkObjects(ArrayList<NetworkObject> computers) {
        this.networkObjects = computers;
    }

    public void addNetworkObject(NetworkObject networkObject){
        this.networkObjects.add(networkObject);
    }

    public NetworkObject getNetworkObject(int index){
        return this.networkObjects.get(index);
    }

    public void connect(NetworkObject networkObject, String networkAddress) throws NoConnectorsException {
        for (Connector connector : connectors) {
            if (!connector.isConnected()) {
                for(Connector objectConnector : networkObject.getConnectors()){
                    if (!objectConnector.isConnected()) {
                        connector.setCableConnector(new CableConnector(this, networkObject, connector, objectConnector, networkAddress));
                        return;
                    }
                }
                throw new NoConnectorsException("Interface 2 haven't connectors available");
            }
        }
        throw new NoConnectorsException("Interface 1 haven't connectors available");
    }

    public void sendToNext(Packet packet){
        if(recordMemory.wasAnOldPacket(packet)) return;
        for (Connector connector : connectors) {
            if(connector.getCableConnector().getNetwork().isInSubnet(packet.getDestinationIp())){
                connector.getCableConnector().getNetworkObject2().receivedPacket(packet);
            }
        }
    }

    @Override
    public void receivedPacket(Packet packet) {
        sendToNext(packet);
    }
}

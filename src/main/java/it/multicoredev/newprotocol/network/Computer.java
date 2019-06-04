package it.multicoredev.newprotocol.network;

import it.multicoredev.newprotocol.network.exception.NoConnectorsException;

import java.util.ArrayList;

public class Computer extends NetworkObject {

    private ArrayList<NetworkObject> networkObjects;

    public Computer() {
        super(1);
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

    public void connect(Router router) throws NoConnectorsException {
        for(int i = 0; i < connectors.length; i++){
            if(!connectors[i].isConnected()){
                for(int j = 0; j < router.getConnectors().length; j++){
                    if(!connectors[j].isConnected()){
                        connectors[i].setCableConnector(new CableConnector(this, router, connectors[i], connectors[j]));
                        return;
                    }
                }
                throw new NoConnectorsException("Interface 2 haven't connectors available");
            }
        }
        throw new NoConnectorsException("Interface 1 haven't connectors available");
    }
}

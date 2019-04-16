package it.multicoredev.newprotocol.network;

import it.multicoredev.newprotocol.network.exception.NoConnectorsException;

import java.util.ArrayList;

public class Router extends NetworkObject {

    private ArrayList<Computer> computers;

    public Router(){
        super(12);
        computers = new ArrayList<>();
    }

    public ArrayList<Computer> getComputers() {
        return computers;
    }

    public void setComputers(ArrayList<Computer> computers) {
        this.computers = computers;
    }

    public void addComputer(Computer computer){
        this.computers.add(computer);
    }

    public Computer getComputer(int index){
        return this.computers.get(index);
    }

    public void connect(NetworkObject router) throws NoConnectorsException {
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

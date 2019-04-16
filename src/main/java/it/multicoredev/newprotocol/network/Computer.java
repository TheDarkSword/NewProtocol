package it.multicoredev.newprotocol.network;

import it.multicoredev.newprotocol.utls.IPAddress;
import it.multicoredev.newprotocol.network.exception.NoConnectorsException;

public class Computer extends NetworkObject {

    private Router router;
    private IPAddress ipAddress;

    public Computer() {
        this(null);
    }

    public Computer(Router router) {
        this(router, 0);
    }

    public Computer(Router router, IPAddress ipAddress){
        super(1);
        this.router = router;
        this.ipAddress = ipAddress;
    }

    public Computer(Router router, int ipAddress){
        super(1);
        this.router = router;
        this.ipAddress = new IPAddress(ipAddress);
    }

    public Computer(Router router, String ipAddress){
        super(1);
        this.router = router;
        this.ipAddress = new IPAddress(ipAddress);
    }

    public Router getRouter() {
        return router;
    }

    public IPAddress getIpAddress() {
        return ipAddress;
    }

    public String getIP(){
        return ipAddress.getIp();
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

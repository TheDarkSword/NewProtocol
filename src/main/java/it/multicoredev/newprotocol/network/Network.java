package it.multicoredev.newprotocol.network;

import it.multicoredev.newprotocol.Packet;

import java.util.ArrayList;

public class Network {

    private ArrayList<Router> routers;

    public Network(){
        routers = new ArrayList<>();
    }

    public Network(int size){
        routers = new ArrayList<>();

        for(int i = 0; i < size; i++){
            routers.add(new Router());
        }
    }

    public Network(int size, int routerPort){
        routers = new ArrayList<>();

        for(int i = 0; i < size; i++){
            routers.add(new Router(routerPort));
        }
    }

    public ArrayList<Router> getRouters() {
        return routers;
    }

    public void addRouter() {
        routers.add(new Router());
    }

    public void addRouter(int size) {
        routers.add(new Router(size));
    }

    public void sendPacket(Packet packet){

    }
}

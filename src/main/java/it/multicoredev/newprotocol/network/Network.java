package it.multicoredev.newprotocol.network;

import java.util.ArrayList;

public class Network {

    ArrayList<Router> routers;

    public Network(){
        routers = new ArrayList<>();
    }

    public Network(int size){
        routers = new ArrayList<>();

        for(int i = 0; i < size; i++){
            routers.add(new Router());
        }
    }
}

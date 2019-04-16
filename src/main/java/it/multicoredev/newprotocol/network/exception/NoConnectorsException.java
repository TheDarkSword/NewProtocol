package it.multicoredev.newprotocol.network.exception;

public class NoConnectorsException extends Exception {

    public NoConnectorsException(){
        super();
    }

    public NoConnectorsException(String message){
        super(message);
    }

    public NoConnectorsException(String message, Throwable cause){
        super(message, cause);
    }

    public NoConnectorsException(Throwable cause){
        super(cause);
    }

    protected NoConnectorsException(String message, Throwable cause,
                        boolean enableSuppression,
                        boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}

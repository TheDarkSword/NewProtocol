package it.multicoredev.newprotocol.network.exception;

public class ExceededNumberException extends RuntimeException {

    public ExceededNumberException(){
        super();
    }

    public ExceededNumberException(String message){
        super(message);
    }

    public ExceededNumberException(String message, Throwable cause){
        super(message, cause);
    }

    public ExceededNumberException(Throwable cause){
        super(cause);
    }

    protected ExceededNumberException(String message, Throwable cause,
                                    boolean enableSuppression,
                                    boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}

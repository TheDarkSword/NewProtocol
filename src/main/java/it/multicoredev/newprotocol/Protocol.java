package it.multicoredev.newprotocol;

public enum Protocol {

    TCP((byte)6),
    UDP((byte)17),
    CUSTOM((byte)21);

    private byte code;
    Protocol(byte code){
        this.code = code;
    }

    public byte get() {
        return code;
    }
}

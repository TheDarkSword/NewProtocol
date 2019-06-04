package it.multicoredev.newprotocol.utls;

import it.multicoredev.newprotocol.network.exception.ExceededNumberException;

public class Field {

    private BITS type;
    private long value;

    public Field(BITS type, long value) {
        this.type = type;
        setValue(value);
    }

    public Field(BITS type){
        this.type = type;
        this.value = -1;
    }

    public BITS getType() {
        return type;
    }

    public long getValue() {
        if(isLegitLength(value)) return value;
        else throw new ExceededNumberException("Wrong Value");
    }

    public void setValue(long value) {
        if(isLegitLength(value)) this.value = value;
        else throw new ExceededNumberException("Number exceeded the limit");
    }

    private boolean isLegitLength(long value){
        return type.getMaxValue() > value || value >= 0;
    }
}

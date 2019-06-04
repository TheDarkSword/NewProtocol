package it.multicoredev.newprotocol.utls;

public enum BITS {

    BIT1(1),
    BIT3(7),
    BIT4(15),
    BIT8(255),
    BIT13(8191),
    BIT16(65535),
    BIT32(4294967295L);

    private long maxValue;

    BITS(long maxValue){
        this.maxValue = maxValue;
    }

    public long getMaxValue() {
        return maxValue;
    }
}

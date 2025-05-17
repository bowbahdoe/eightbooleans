package dev.mccue.eightbooleans;

import java.util.function.Function;

public final class EightBooleans {
    private final byte value;

    private EightBooleans(byte value) {
        this.value = value;
    }

    public static EightBooleans allFalse() {
        return new EightBooleans((byte) 0b00000000);
    }

    public static EightBooleans allTrue() {
        return new EightBooleans((byte) 0b11111111);
    }

    public boolean get(int bit) {
        if (bit < 0 || bit > 7) {
            throw new IllegalArgumentException("" + bit);
        }

        return (value & (1 << bit)) != 0;
    }

    public EightBooleans set(int bit, boolean b) {
        return new EightBooleans((byte) switch (bit) {
            case 0 -> (b ? value | 0b00000001 : value & 0b11111110);
            case 1 -> (b ? value | 0b00000010 : value & 0b11111101);
            case 2 -> (b ? value | 0b00000100 : value & 0b11111011);
            case 3 -> (b ? value | 0b00001000 : value & 0b11110111);
            case 4 -> (b ? value | 0b00010000 : value & 0b11101111);
            case 5 -> (b ? value | 0b00100000 : value & 0b11011111);
            case 6 -> (b ? value | 0b01000000 : value & 0b10111111);
            case 7 -> (b ? value | 0b10000000 : value & 0b01111111);
            default -> {
                throw new IllegalArgumentException("" + bit);
            }
        });
    }

    public boolean getFirst() {
        return get(0);
    }

    public boolean getSecond() {
        return get(1);
    }

    public boolean getThird() {
        return get(2);
    }

    public boolean getFourth() {
        return get(3);
    }

    public boolean getFifth() {
        return get(4);
    }

    public boolean getSixth() {
        return get(5);
    }

    public boolean getSeventh() {
        return get(6);
    }

    public boolean getEighth() {
        return get(7);
    }

    public EightBooleans setFirst(boolean b) {
        return set(0, b);
    }

    public EightBooleans setSecond(boolean b) {
        return set(1, b);
    }

    public EightBooleans setThird(boolean b) {
        return set(2, b);
    }

    public EightBooleans setFourth(boolean b) {
        return set(3, b);
    }

    public EightBooleans setFifth(boolean b) {
        return set(4, b);
    }

    public EightBooleans setSixth(boolean b) {
        return set(5, b);
    }

    public EightBooleans setSeventh(boolean b) {
        return set(6, b);
    }

    public EightBooleans setEighth(boolean b) {
        return set(7, b);
    }

    @Override
    public String toString() {
        Function<Boolean, Integer> bitToInt = b -> b ? 1 : 0;
        return "EightBooleans["
                + bitToInt.apply(getEighth())
                + bitToInt.apply(getSeventh())
                + bitToInt.apply(getSixth())
                + bitToInt.apply(getFifth())
                + bitToInt.apply(getFourth())
                + bitToInt.apply(getThird())
                + bitToInt.apply(getSecond())
                + bitToInt.apply(getFirst())
                + "]";
    }

    @Override
    public boolean equals(Object obj) {
        return obj instanceof EightBooleans bbs && value == bbs.value;
    }

    @Override
    public int hashCode() {
        return Byte.hashCode(value);
    }
}

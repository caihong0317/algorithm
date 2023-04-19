package com.caihong.effectivejava;

import java.util.Comparator;
import java.util.Objects;

public class PhoneNumber implements Comparable<PhoneNumber>, Cloneable {
    private final short areaCode;
    private final short prefix;
    private final short lineNum;

    private int hashCode;

    public PhoneNumber(int areaCode, int prefix, int lineNum) {
        this.areaCode = rangeCheck(areaCode, 999, "areaCode");
        this.prefix = rangeCheck(prefix, 999, "prefix");
        this.lineNum = rangeCheck(lineNum, 999, "lineNum");
    }

    private static short rangeCheck(int value, int max, String tag) {
        if (value < 0 || value > max) {
            throw new IllegalArgumentException(tag + ": " + value);
        }
        return (short) value;
    }

    public short getAreaCode() {
        return areaCode;
    }

    public short getPrefix() {
        return prefix;
    }

    public short getLineNum() {
        return lineNum;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof PhoneNumber)) {
            return false;
        }
        PhoneNumber other = (PhoneNumber) obj;
        return areaCode == other.areaCode && prefix == other.prefix
            && lineNum == other.lineNum;
    }

    @Override
    public int hashCode() {
//        return Objects.hash(areaCode, prefix, lineNum); // 不推荐
        int result = hashCode;
        if (result == 0) {
            result = Short.hashCode(areaCode);
            result = 31 * result + Short.hashCode(prefix);
            result = 31 * result + Short.hashCode(lineNum);
            hashCode = result;
        }
        return result;
    }

    @Override
    public String toString() {
        return String.format("%03d-%03d-%03d", areaCode, prefix, lineNum); // 为何得用%03d
    }

    @Override
    public int compareTo(PhoneNumber other) {
        int result = Short.compare(areaCode, other.areaCode);
        if (result == 0) {
            result = Short.compare(prefix, other.prefix);
            if (result == 0) {
                result = Short.compare(lineNum, other.lineNum);
            }
        }
        return result;
    }

    @Override
    public PhoneNumber clone() {
        try {
            return (PhoneNumber) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new AssertionError();
        }
    }

    public static Comparator<PhoneNumber> NATURAL_ORDER = Comparator.comparingInt(PhoneNumber::getAreaCode)
        .thenComparingInt(PhoneNumber::getPrefix).thenComparingInt(PhoneNumber::getLineNum);

    // 能否工作未知
    public static Comparator<PhoneNumber> REVERSE_ORDER = Comparator.reverseOrder();

    public static void main(String[] args) {
        PhoneNumber number = new PhoneNumber(129, 378, 155);
        System.out.println(number);
    }
}

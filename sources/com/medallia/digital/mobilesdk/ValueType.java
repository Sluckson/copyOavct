package com.medallia.digital.mobilesdk;

enum ValueType {
    TypeString,
    TypeInteger,
    TypeDouble,
    TypeLong,
    TypeBoolean;

    protected static ValueType fromString(String str) {
        if (TypeString.name().equals(str)) {
            return TypeString;
        }
        if (TypeInteger.name().equals(str)) {
            return TypeInteger;
        }
        if (TypeDouble.name().equals(str)) {
            return TypeDouble;
        }
        if (TypeLong.name().equals(str)) {
            return TypeLong;
        }
        if (TypeBoolean.name().equals(str)) {
            return TypeBoolean;
        }
        return null;
    }
}

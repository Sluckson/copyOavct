package com.google.inject.internal;

final class Hashing {
    private static final int CUTOFF = 536870912;
    private static final int MAX_TABLE_SIZE = 1073741824;

    static int smear(int i) {
        int i2 = i ^ ((i >>> 20) ^ (i >>> 12));
        return (i2 >>> 4) ^ ((i2 >>> 7) ^ i2);
    }

    private Hashing() {
    }

    static int chooseTableSize(int i) {
        if (i < 536870912) {
            return Integer.highestOneBit(i) << 2;
        }
        Preconditions.checkArgument(i < 1073741824, "collection too large");
        return 1073741824;
    }
}

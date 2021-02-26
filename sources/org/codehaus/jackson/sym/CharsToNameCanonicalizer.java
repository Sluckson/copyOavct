package org.codehaus.jackson.sym;

import java.util.Arrays;

public final class CharsToNameCanonicalizer {
    protected static final int DEFAULT_TABLE_SIZE = 64;
    static final int MAX_ENTRIES_FOR_REUSE = 12000;
    protected static final int MAX_TABLE_SIZE = 65536;
    static final CharsToNameCanonicalizer sBootstrapSymbolTable = new CharsToNameCanonicalizer();
    protected Bucket[] _buckets;
    protected final boolean _canonicalize;
    protected boolean _dirty;
    protected int _indexMask;
    protected final boolean _intern;
    protected CharsToNameCanonicalizer _parent;
    protected int _size;
    protected int _sizeThreshold;
    protected String[] _symbols;

    public static CharsToNameCanonicalizer createRoot() {
        return sBootstrapSymbolTable.makeOrphan();
    }

    private CharsToNameCanonicalizer() {
        this._canonicalize = true;
        this._intern = true;
        this._dirty = true;
        initTables(64);
    }

    private void initTables(int i) {
        this._symbols = new String[i];
        this._buckets = new Bucket[(i >> 1)];
        this._indexMask = i - 1;
        this._size = 0;
        this._sizeThreshold = i - (i >> 2);
    }

    private CharsToNameCanonicalizer(CharsToNameCanonicalizer charsToNameCanonicalizer, boolean z, boolean z2, String[] strArr, Bucket[] bucketArr, int i) {
        this._parent = charsToNameCanonicalizer;
        this._canonicalize = z;
        this._intern = z2;
        this._symbols = strArr;
        this._buckets = bucketArr;
        this._size = i;
        int length = strArr.length;
        this._sizeThreshold = length - (length >> 2);
        this._indexMask = length - 1;
        this._dirty = false;
    }

    public synchronized CharsToNameCanonicalizer makeChild(boolean z, boolean z2) {
        return new CharsToNameCanonicalizer(this, z, z2, this._symbols, this._buckets, this._size);
    }

    private CharsToNameCanonicalizer makeOrphan() {
        return new CharsToNameCanonicalizer((CharsToNameCanonicalizer) null, true, true, this._symbols, this._buckets, this._size);
    }

    private synchronized void mergeChild(CharsToNameCanonicalizer charsToNameCanonicalizer) {
        if (charsToNameCanonicalizer.size() > 12000) {
            initTables(64);
        } else if (charsToNameCanonicalizer.size() > size()) {
            this._symbols = charsToNameCanonicalizer._symbols;
            this._buckets = charsToNameCanonicalizer._buckets;
            this._size = charsToNameCanonicalizer._size;
            this._sizeThreshold = charsToNameCanonicalizer._sizeThreshold;
            this._indexMask = charsToNameCanonicalizer._indexMask;
        } else {
            return;
        }
        this._dirty = false;
    }

    public void release() {
        CharsToNameCanonicalizer charsToNameCanonicalizer;
        if (maybeDirty() && (charsToNameCanonicalizer = this._parent) != null) {
            charsToNameCanonicalizer.mergeChild(this);
            this._dirty = false;
        }
    }

    public int size() {
        return this._size;
    }

    public boolean maybeDirty() {
        return this._dirty;
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x0020 A[LOOP:0: B:12:0x0020->B:15:0x002d, LOOP_START, PHI: r2 
      PHI: (r2v4 int) = (r2v3 int), (r2v6 int) binds: [B:11:0x001f, B:15:0x002d] A[DONT_GENERATE, DONT_INLINE]] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.String findSymbol(char[] r6, int r7, int r8, int r9) {
        /*
            r5 = this;
            r0 = 1
            if (r8 >= r0) goto L_0x0006
            java.lang.String r6 = ""
            return r6
        L_0x0006:
            boolean r1 = r5._canonicalize
            if (r1 != 0) goto L_0x0010
            java.lang.String r9 = new java.lang.String
            r9.<init>(r6, r7, r8)
            return r9
        L_0x0010:
            int r1 = r5._indexMask
            r9 = r9 & r1
            java.lang.String[] r1 = r5._symbols
            r1 = r1[r9]
            if (r1 == 0) goto L_0x0041
            int r2 = r1.length()
            if (r2 != r8) goto L_0x0032
            r2 = 0
        L_0x0020:
            char r3 = r1.charAt(r2)
            int r4 = r7 + r2
            char r4 = r6[r4]
            if (r3 == r4) goto L_0x002b
            goto L_0x002f
        L_0x002b:
            int r2 = r2 + 1
            if (r2 < r8) goto L_0x0020
        L_0x002f:
            if (r2 != r8) goto L_0x0032
            return r1
        L_0x0032:
            org.codehaus.jackson.sym.CharsToNameCanonicalizer$Bucket[] r1 = r5._buckets
            int r2 = r9 >> 1
            r1 = r1[r2]
            if (r1 == 0) goto L_0x0041
            java.lang.String r1 = r1.find(r6, r7, r8)
            if (r1 == 0) goto L_0x0041
            return r1
        L_0x0041:
            boolean r1 = r5._dirty
            if (r1 != 0) goto L_0x004b
            r5.copyArrays()
            r5._dirty = r0
            goto L_0x005b
        L_0x004b:
            int r1 = r5._size
            int r2 = r5._sizeThreshold
            if (r1 < r2) goto L_0x005b
            r5.rehash()
            int r9 = calcHash(r6, r7, r8)
            int r1 = r5._indexMask
            r9 = r9 & r1
        L_0x005b:
            int r1 = r5._size
            int r1 = r1 + r0
            r5._size = r1
            java.lang.String r1 = new java.lang.String
            r1.<init>(r6, r7, r8)
            boolean r6 = r5._intern
            if (r6 == 0) goto L_0x006f
            org.codehaus.jackson.util.InternCache r6 = org.codehaus.jackson.util.InternCache.instance
            java.lang.String r1 = r6.intern(r1)
        L_0x006f:
            java.lang.String[] r6 = r5._symbols
            r7 = r6[r9]
            if (r7 != 0) goto L_0x0078
            r6[r9] = r1
            goto L_0x0085
        L_0x0078:
            int r6 = r9 >> 1
            org.codehaus.jackson.sym.CharsToNameCanonicalizer$Bucket[] r7 = r5._buckets
            org.codehaus.jackson.sym.CharsToNameCanonicalizer$Bucket r8 = new org.codehaus.jackson.sym.CharsToNameCanonicalizer$Bucket
            r9 = r7[r6]
            r8.<init>(r1, r9)
            r7[r6] = r8
        L_0x0085:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: org.codehaus.jackson.sym.CharsToNameCanonicalizer.findSymbol(char[], int, int, int):java.lang.String");
    }

    public static int calcHash(char[] cArr, int i, int i2) {
        int i3 = cArr[0];
        for (int i4 = 1; i4 < i2; i4++) {
            i3 = (i3 * 31) + cArr[i4];
        }
        return i3;
    }

    public static int calcHash(String str) {
        int charAt = str.charAt(0);
        int length = str.length();
        for (int i = 1; i < length; i++) {
            charAt = (charAt * 31) + str.charAt(i);
        }
        return charAt;
    }

    private void copyArrays() {
        String[] strArr = this._symbols;
        int length = strArr.length;
        this._symbols = new String[length];
        System.arraycopy(strArr, 0, this._symbols, 0, length);
        Bucket[] bucketArr = this._buckets;
        int length2 = bucketArr.length;
        this._buckets = new Bucket[length2];
        System.arraycopy(bucketArr, 0, this._buckets, 0, length2);
    }

    private void rehash() {
        String[] strArr = this._symbols;
        int i = r1 + r1;
        if (i > 65536) {
            this._size = 0;
            Arrays.fill(strArr, (Object) null);
            Arrays.fill(this._buckets, (Object) null);
            this._dirty = true;
            return;
        }
        Bucket[] bucketArr = this._buckets;
        this._symbols = new String[i];
        this._buckets = new Bucket[(i >> 1)];
        this._indexMask = i - 1;
        int i2 = this._sizeThreshold;
        this._sizeThreshold = i2 + i2;
        int i3 = 0;
        for (String str : strArr) {
            if (str != null) {
                i3++;
                int calcHash = calcHash(str) & this._indexMask;
                String[] strArr2 = this._symbols;
                if (strArr2[calcHash] == null) {
                    strArr2[calcHash] = str;
                } else {
                    int i4 = calcHash >> 1;
                    Bucket[] bucketArr2 = this._buckets;
                    bucketArr2[i4] = new Bucket(str, bucketArr2[i4]);
                }
            }
        }
        int i5 = r1 >> 1;
        for (int i6 = 0; i6 < i5; i6++) {
            for (Bucket bucket = bucketArr[i6]; bucket != null; bucket = bucket.getNext()) {
                i3++;
                String symbol = bucket.getSymbol();
                int calcHash2 = calcHash(symbol) & this._indexMask;
                String[] strArr3 = this._symbols;
                if (strArr3[calcHash2] == null) {
                    strArr3[calcHash2] = symbol;
                } else {
                    int i7 = calcHash2 >> 1;
                    Bucket[] bucketArr3 = this._buckets;
                    bucketArr3[i7] = new Bucket(symbol, bucketArr3[i7]);
                }
            }
        }
        if (i3 != this._size) {
            throw new Error("Internal error on SymbolTable.rehash(): had " + this._size + " entries; now have " + i3 + ".");
        }
    }

    static final class Bucket {
        private final String _symbol;
        private final Bucket mNext;

        public Bucket(String str, Bucket bucket) {
            this._symbol = str;
            this.mNext = bucket;
        }

        public String getSymbol() {
            return this._symbol;
        }

        public Bucket getNext() {
            return this.mNext;
        }

        /* JADX WARNING: Removed duplicated region for block: B:4:0x000b A[LOOP:1: B:4:0x000b->B:7:0x0018, LOOP_START, PHI: r2 
          PHI: (r2v2 int) = (r2v1 int), (r2v4 int) binds: [B:3:0x000a, B:7:0x0018] A[DONT_GENERATE, DONT_INLINE]] */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public java.lang.String find(char[] r6, int r7, int r8) {
            /*
                r5 = this;
                java.lang.String r0 = r5._symbol
                org.codehaus.jackson.sym.CharsToNameCanonicalizer$Bucket r1 = r5.mNext
            L_0x0004:
                int r2 = r0.length()
                if (r2 != r8) goto L_0x001d
                r2 = 0
            L_0x000b:
                char r3 = r0.charAt(r2)
                int r4 = r7 + r2
                char r4 = r6[r4]
                if (r3 == r4) goto L_0x0016
                goto L_0x001a
            L_0x0016:
                int r2 = r2 + 1
                if (r2 < r8) goto L_0x000b
            L_0x001a:
                if (r2 != r8) goto L_0x001d
                return r0
            L_0x001d:
                if (r1 != 0) goto L_0x0021
                r6 = 0
                return r6
            L_0x0021:
                java.lang.String r0 = r1.getSymbol()
                org.codehaus.jackson.sym.CharsToNameCanonicalizer$Bucket r1 = r1.getNext()
                goto L_0x0004
            */
            throw new UnsupportedOperationException("Method not decompiled: org.codehaus.jackson.sym.CharsToNameCanonicalizer.Bucket.find(char[], int, int):java.lang.String");
        }
    }
}

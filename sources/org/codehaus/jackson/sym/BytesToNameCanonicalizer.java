package org.codehaus.jackson.sym;

import androidx.core.view.InputDeviceCompat;
import java.util.Arrays;
import org.codehaus.jackson.util.InternCache;

public final class BytesToNameCanonicalizer {
    protected static final int DEFAULT_TABLE_SIZE = 64;
    static final int INITIAL_COLLISION_LEN = 32;
    static final int LAST_VALID_BUCKET = 254;
    static final int MAX_ENTRIES_FOR_REUSE = 6000;
    protected static final int MAX_TABLE_SIZE = 65536;
    static final int MIN_HASH_SIZE = 16;
    private int _collCount;
    private int _collEnd;
    private Bucket[] _collList;
    private boolean _collListShared;
    private int _count;
    final boolean _intern;
    private int[] _mainHash;
    private int _mainHashMask;
    private boolean _mainHashShared;
    private Name[] _mainNames;
    private boolean _mainNamesShared;
    private transient boolean _needRehash;
    final BytesToNameCanonicalizer _parent;

    public static final int calcHash(int i) {
        int i2 = i ^ (i >>> 16);
        return i2 ^ (i2 >>> 8);
    }

    public static final int calcHash(int i, int i2) {
        int i3 = (i * 31) + i2;
        int i4 = i3 ^ (i3 >>> 16);
        return i4 ^ (i4 >>> 8);
    }

    public static BytesToNameCanonicalizer createRoot() {
        return new BytesToNameCanonicalizer(64, true);
    }

    public synchronized BytesToNameCanonicalizer makeChild(boolean z, boolean z2) {
        return new BytesToNameCanonicalizer(this, z2);
    }

    public void release() {
        BytesToNameCanonicalizer bytesToNameCanonicalizer;
        if (maybeDirty() && (bytesToNameCanonicalizer = this._parent) != null) {
            bytesToNameCanonicalizer.mergeChild(this);
            markAsShared();
        }
    }

    private BytesToNameCanonicalizer(int i, boolean z) {
        this._parent = null;
        this._intern = z;
        int i2 = 16;
        if (i >= 16) {
            if (((i - 1) & i) != 0) {
                while (i2 < i) {
                    i2 += i2;
                }
            } else {
                i2 = i;
            }
        }
        initTables(i2);
    }

    private BytesToNameCanonicalizer(BytesToNameCanonicalizer bytesToNameCanonicalizer, boolean z) {
        this._parent = bytesToNameCanonicalizer;
        this._intern = z;
        this._count = bytesToNameCanonicalizer._count;
        this._mainHashMask = bytesToNameCanonicalizer._mainHashMask;
        this._mainHash = bytesToNameCanonicalizer._mainHash;
        this._mainNames = bytesToNameCanonicalizer._mainNames;
        this._collList = bytesToNameCanonicalizer._collList;
        this._collCount = bytesToNameCanonicalizer._collCount;
        this._collEnd = bytesToNameCanonicalizer._collEnd;
        this._needRehash = false;
        this._mainHashShared = true;
        this._mainNamesShared = true;
        this._collListShared = true;
    }

    private void initTables(int i) {
        this._count = 0;
        this._mainHash = new int[i];
        this._mainNames = new Name[i];
        this._mainHashShared = false;
        this._mainNamesShared = false;
        this._mainHashMask = i - 1;
        this._collListShared = true;
        this._collList = null;
        this._collEnd = 0;
        this._needRehash = false;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:12:0x0039, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private synchronized void mergeChild(org.codehaus.jackson.sym.BytesToNameCanonicalizer r3) {
        /*
            r2 = this;
            monitor-enter(r2)
            int r0 = r3._count     // Catch:{ all -> 0x003a }
            int r1 = r2._count     // Catch:{ all -> 0x003a }
            if (r0 > r1) goto L_0x0009
            monitor-exit(r2)
            return
        L_0x0009:
            int r0 = r3.size()     // Catch:{ all -> 0x003a }
            r1 = 6000(0x1770, float:8.408E-42)
            if (r0 <= r1) goto L_0x0017
            r3 = 64
            r2.initTables(r3)     // Catch:{ all -> 0x003a }
            goto L_0x0038
        L_0x0017:
            int r0 = r3._count     // Catch:{ all -> 0x003a }
            r2._count = r0     // Catch:{ all -> 0x003a }
            int[] r0 = r3._mainHash     // Catch:{ all -> 0x003a }
            r2._mainHash = r0     // Catch:{ all -> 0x003a }
            org.codehaus.jackson.sym.Name[] r0 = r3._mainNames     // Catch:{ all -> 0x003a }
            r2._mainNames = r0     // Catch:{ all -> 0x003a }
            r0 = 1
            r2._mainHashShared = r0     // Catch:{ all -> 0x003a }
            r2._mainNamesShared = r0     // Catch:{ all -> 0x003a }
            int r0 = r3._mainHashMask     // Catch:{ all -> 0x003a }
            r2._mainHashMask = r0     // Catch:{ all -> 0x003a }
            org.codehaus.jackson.sym.BytesToNameCanonicalizer$Bucket[] r0 = r3._collList     // Catch:{ all -> 0x003a }
            r2._collList = r0     // Catch:{ all -> 0x003a }
            int r0 = r3._collCount     // Catch:{ all -> 0x003a }
            r2._collCount = r0     // Catch:{ all -> 0x003a }
            int r3 = r3._collEnd     // Catch:{ all -> 0x003a }
            r2._collEnd = r3     // Catch:{ all -> 0x003a }
        L_0x0038:
            monitor-exit(r2)
            return
        L_0x003a:
            r3 = move-exception
            monitor-exit(r2)
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: org.codehaus.jackson.sym.BytesToNameCanonicalizer.mergeChild(org.codehaus.jackson.sym.BytesToNameCanonicalizer):void");
    }

    private void markAsShared() {
        this._mainHashShared = true;
        this._mainNamesShared = true;
        this._collListShared = true;
    }

    public int size() {
        return this._count;
    }

    public boolean maybeDirty() {
        return !this._mainHashShared;
    }

    public static Name getEmptyName() {
        return Name1.getEmptyName();
    }

    public Name findName(int i) {
        Bucket bucket;
        int calcHash = calcHash(i);
        int i2 = this._mainHashMask & calcHash;
        int i3 = this._mainHash[i2];
        if ((((i3 >> 8) ^ calcHash) << 8) == 0) {
            Name name = this._mainNames[i2];
            if (name == null) {
                return null;
            }
            if (name.equals(i)) {
                return name;
            }
        } else if (i3 == 0) {
            return null;
        }
        int i4 = i3 & 255;
        if (i4 <= 0 || (bucket = this._collList[i4 - 1]) == null) {
            return null;
        }
        return bucket.find(calcHash, i, 0);
    }

    public Name findName(int i, int i2) {
        Bucket bucket;
        int calcHash = calcHash(i, i2);
        int i3 = this._mainHashMask & calcHash;
        int i4 = this._mainHash[i3];
        if ((((i4 >> 8) ^ calcHash) << 8) == 0) {
            Name name = this._mainNames[i3];
            if (name == null) {
                return null;
            }
            if (name.equals(i, i2)) {
                return name;
            }
        } else if (i4 == 0) {
            return null;
        }
        int i5 = i4 & 255;
        if (i5 <= 0 || (bucket = this._collList[i5 - 1]) == null) {
            return null;
        }
        return bucket.find(calcHash, i, i2);
    }

    public Name findName(int[] iArr, int i) {
        Bucket bucket;
        int calcHash = calcHash(iArr, i);
        int i2 = this._mainHashMask & calcHash;
        int i3 = this._mainHash[i2];
        if ((((i3 >> 8) ^ calcHash) << 8) == 0) {
            Name name = this._mainNames[i2];
            if (name == null || name.equals(iArr, i)) {
                return name;
            }
        } else if (i3 == 0) {
            return null;
        }
        int i4 = i3 & 255;
        if (i4 <= 0 || (bucket = this._collList[i4 - 1]) == null) {
            return null;
        }
        return bucket.find(calcHash, iArr, i);
    }

    public Name addName(String str, int i, int i2) {
        if (this._intern) {
            str = InternCache.instance.intern(str);
        }
        int calcHash = i2 == 0 ? calcHash(i) : calcHash(i, i2);
        Name constructName = constructName(calcHash, str, i, i2);
        _addSymbol(calcHash, constructName);
        return constructName;
    }

    public Name addName(String str, int[] iArr, int i) {
        if (this._intern) {
            str = InternCache.instance.intern(str);
        }
        int calcHash = calcHash(iArr, i);
        Name constructName = constructName(calcHash, str, iArr, i);
        _addSymbol(calcHash, constructName);
        return constructName;
    }

    public static final int calcHash(int[] iArr, int i) {
        int i2 = iArr[0];
        for (int i3 = 1; i3 < i; i3++) {
            i2 = (i2 * 31) + iArr[i3];
        }
        int i4 = (i2 >>> 16) ^ i2;
        return i4 ^ (i4 >>> 8);
    }

    private void _addSymbol(int i, Name name) {
        int i2;
        if (this._mainHashShared) {
            unshareMain();
        }
        if (this._needRehash) {
            rehash();
        }
        this._count++;
        int i3 = this._mainHashMask & i;
        if (this._mainNames[i3] == null) {
            this._mainHash[i3] = i << 8;
            if (this._mainNamesShared) {
                unshareNames();
            }
            this._mainNames[i3] = name;
        } else {
            if (this._collListShared) {
                unshareCollision();
            }
            this._collCount++;
            int i4 = this._mainHash[i3];
            int i5 = i4 & 255;
            if (i5 == 0) {
                i2 = this._collEnd;
                if (i2 <= 254) {
                    this._collEnd = i2 + 1;
                    if (i2 >= this._collList.length) {
                        expandCollision();
                    }
                } else {
                    i2 = findBestBucket();
                }
                this._mainHash[i3] = (i4 & InputDeviceCompat.SOURCE_ANY) | (i2 + 1);
            } else {
                i2 = i5 - 1;
            }
            Bucket[] bucketArr = this._collList;
            bucketArr[i2] = new Bucket(name, bucketArr[i2]);
        }
        int length = this._mainHash.length;
        int i6 = this._count;
        if (i6 > (length >> 1)) {
            int i7 = length >> 2;
            if (i6 > length - i7) {
                this._needRehash = true;
            } else if (this._collCount >= i7) {
                this._needRehash = true;
            }
        }
    }

    private void rehash() {
        int i;
        this._needRehash = false;
        this._mainNamesShared = false;
        int length = this._mainHash.length;
        int i2 = length + length;
        if (i2 > 65536) {
            nukeSymbols();
            return;
        }
        this._mainHash = new int[i2];
        this._mainHashMask = i2 - 1;
        Name[] nameArr = this._mainNames;
        this._mainNames = new Name[i2];
        int i3 = 0;
        for (int i4 = 0; i4 < length; i4++) {
            Name name = nameArr[i4];
            if (name != null) {
                i3++;
                int hashCode = name.hashCode();
                int i5 = this._mainHashMask & hashCode;
                this._mainNames[i5] = name;
                this._mainHash[i5] = hashCode << 8;
            }
        }
        int i6 = this._collEnd;
        if (i6 != 0) {
            this._collCount = 0;
            this._collEnd = 0;
            this._collListShared = false;
            Bucket[] bucketArr = this._collList;
            this._collList = new Bucket[bucketArr.length];
            for (int i7 = 0; i7 < i6; i7++) {
                for (Bucket bucket = bucketArr[i7]; bucket != null; bucket = bucket._next) {
                    i3++;
                    Name name2 = bucket._name;
                    int hashCode2 = name2.hashCode();
                    int i8 = this._mainHashMask & hashCode2;
                    int[] iArr = this._mainHash;
                    int i9 = iArr[i8];
                    Name[] nameArr2 = this._mainNames;
                    if (nameArr2[i8] == null) {
                        iArr[i8] = hashCode2 << 8;
                        nameArr2[i8] = name2;
                    } else {
                        this._collCount++;
                        int i10 = i9 & 255;
                        if (i10 == 0) {
                            i = this._collEnd;
                            if (i <= 254) {
                                this._collEnd = i + 1;
                                if (i >= this._collList.length) {
                                    expandCollision();
                                }
                            } else {
                                i = findBestBucket();
                            }
                            this._mainHash[i8] = (i9 & InputDeviceCompat.SOURCE_ANY) | (i + 1);
                        } else {
                            i = i10 - 1;
                        }
                        Bucket[] bucketArr2 = this._collList;
                        bucketArr2[i] = new Bucket(name2, bucketArr2[i]);
                    }
                }
            }
            if (i3 != this._count) {
                throw new RuntimeException("Internal error: count after rehash " + i3 + "; should be " + this._count);
            }
        }
    }

    private void nukeSymbols() {
        this._count = 0;
        Arrays.fill(this._mainHash, 0);
        Arrays.fill(this._mainNames, (Object) null);
        Arrays.fill(this._collList, (Object) null);
        this._collCount = 0;
        this._collEnd = 0;
    }

    private int findBestBucket() {
        Bucket[] bucketArr = this._collList;
        int i = this._collEnd;
        int i2 = Integer.MAX_VALUE;
        int i3 = -1;
        for (int i4 = 0; i4 < i; i4++) {
            int length = bucketArr[i4].length();
            if (length < i2) {
                if (length == 1) {
                    return i4;
                }
                i3 = i4;
                i2 = length;
            }
        }
        return i3;
    }

    private void unshareMain() {
        int[] iArr = this._mainHash;
        int length = iArr.length;
        this._mainHash = new int[length];
        System.arraycopy(iArr, 0, this._mainHash, 0, length);
        this._mainHashShared = false;
    }

    private void unshareCollision() {
        Bucket[] bucketArr = this._collList;
        if (bucketArr == null) {
            this._collList = new Bucket[32];
        } else {
            int length = bucketArr.length;
            this._collList = new Bucket[length];
            System.arraycopy(bucketArr, 0, this._collList, 0, length);
        }
        this._collListShared = false;
    }

    private void unshareNames() {
        Name[] nameArr = this._mainNames;
        int length = nameArr.length;
        this._mainNames = new Name[length];
        System.arraycopy(nameArr, 0, this._mainNames, 0, length);
        this._mainNamesShared = false;
    }

    private void expandCollision() {
        Bucket[] bucketArr = this._collList;
        int length = bucketArr.length;
        this._collList = new Bucket[(length + length)];
        System.arraycopy(bucketArr, 0, this._collList, 0, length);
    }

    private static Name constructName(int i, String str, int i2, int i3) {
        if (i3 == 0) {
            return new Name1(str, i, i2);
        }
        return new Name2(str, i, i2, i3);
    }

    private static Name constructName(int i, String str, int[] iArr, int i2) {
        if (i2 < 4) {
            if (i2 == 1) {
                return new Name1(str, i, iArr[0]);
            }
            if (i2 == 2) {
                return new Name2(str, i, iArr[0], iArr[1]);
            }
            if (i2 == 3) {
                return new Name3(str, i, iArr[0], iArr[1], iArr[2]);
            }
        }
        int[] iArr2 = new int[i2];
        for (int i3 = 0; i3 < i2; i3++) {
            iArr2[i3] = iArr[i3];
        }
        return new NameN(str, i, iArr2, i2);
    }

    static final class Bucket {
        protected final Name _name;
        protected final Bucket _next;

        Bucket(Name name, Bucket bucket) {
            this._name = name;
            this._next = bucket;
        }

        public int length() {
            int i = 1;
            for (Bucket bucket = this._next; bucket != null; bucket = bucket._next) {
                i++;
            }
            return i;
        }

        public Name find(int i, int i2, int i3) {
            if (this._name.hashCode() == i && this._name.equals(i2, i3)) {
                return this._name;
            }
            for (Bucket bucket = this._next; bucket != null; bucket = bucket._next) {
                Name name = bucket._name;
                if (name.hashCode() == i && name.equals(i2, i3)) {
                    return name;
                }
            }
            return null;
        }

        public Name find(int i, int[] iArr, int i2) {
            if (this._name.hashCode() == i && this._name.equals(iArr, i2)) {
                return this._name;
            }
            for (Bucket bucket = this._next; bucket != null; bucket = bucket._next) {
                Name name = bucket._name;
                if (name.hashCode() == i && name.equals(iArr, i2)) {
                    return name;
                }
            }
            return null;
        }
    }
}

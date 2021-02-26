package com.lowagie.text.pdf;

import java.util.Arrays;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class IntHashtable implements Cloneable {
    private transient int count;
    private float loadFactor;
    private transient Entry[] table;
    private int threshold;

    public IntHashtable() {
        this(150, 0.75f);
    }

    public IntHashtable(int i) {
        this(i, 0.75f);
    }

    public IntHashtable(int i, float f) {
        if (i < 0) {
            throw new IllegalArgumentException("Illegal Capacity: " + i);
        } else if (f > 0.0f) {
            i = i == 0 ? 1 : i;
            this.loadFactor = f;
            this.table = new Entry[i];
            this.threshold = (int) (((float) i) * f);
        } else {
            throw new IllegalArgumentException("Illegal Load: " + f);
        }
    }

    public int size() {
        return this.count;
    }

    public boolean isEmpty() {
        return this.count == 0;
    }

    public boolean contains(int i) {
        Entry[] entryArr = this.table;
        int length = entryArr.length;
        while (true) {
            int i2 = length - 1;
            if (length <= 0) {
                return false;
            }
            for (Entry entry = entryArr[i2]; entry != null; entry = entry.next) {
                if (entry.value == i) {
                    return true;
                }
            }
            length = i2;
        }
    }

    public boolean containsValue(int i) {
        return contains(i);
    }

    public boolean containsKey(int i) {
        Entry[] entryArr = this.table;
        for (Entry entry = entryArr[(Integer.MAX_VALUE & i) % entryArr.length]; entry != null; entry = entry.next) {
            if (entry.hash == i && entry.key == i) {
                return true;
            }
        }
        return false;
    }

    public int get(int i) {
        Entry[] entryArr = this.table;
        for (Entry entry = entryArr[(Integer.MAX_VALUE & i) % entryArr.length]; entry != null; entry = entry.next) {
            if (entry.hash == i && entry.key == i) {
                return entry.value;
            }
        }
        return 0;
    }

    /* access modifiers changed from: protected */
    public void rehash() {
        Entry[] entryArr = this.table;
        int length = entryArr.length;
        int i = (length * 2) + 1;
        Entry[] entryArr2 = new Entry[i];
        this.threshold = (int) (((float) i) * this.loadFactor);
        this.table = entryArr2;
        while (true) {
            int i2 = length - 1;
            if (length > 0) {
                Entry entry = entryArr[i2];
                while (entry != null) {
                    Entry entry2 = entry.next;
                    int i3 = (entry.hash & Integer.MAX_VALUE) % i;
                    entry.next = entryArr2[i3];
                    entryArr2[i3] = entry;
                    entry = entry2;
                }
                length = i2;
            } else {
                return;
            }
        }
    }

    public int put(int i, int i2) {
        Entry[] entryArr = this.table;
        int i3 = Integer.MAX_VALUE & i;
        int length = i3 % entryArr.length;
        for (Entry entry = entryArr[length]; entry != null; entry = entry.next) {
            if (entry.hash == i && entry.key == i) {
                int i4 = entry.value;
                entry.value = i2;
                return i4;
            }
        }
        if (this.count >= this.threshold) {
            rehash();
            entryArr = this.table;
            length = i3 % entryArr.length;
        }
        entryArr[length] = new Entry(i, i, i2, entryArr[length]);
        this.count++;
        return 0;
    }

    public int remove(int i) {
        Entry[] entryArr = this.table;
        int length = (Integer.MAX_VALUE & i) % entryArr.length;
        Entry entry = entryArr[length];
        Entry entry2 = null;
        while (true) {
            Entry entry3 = entry2;
            entry2 = entry;
            Entry entry4 = entry3;
            if (entry2 == null) {
                return 0;
            }
            if (entry2.hash == i && entry2.key == i) {
                if (entry4 != null) {
                    entry4.next = entry2.next;
                } else {
                    entryArr[length] = entry2.next;
                }
                this.count--;
                int i2 = entry2.value;
                entry2.value = 0;
                return i2;
            }
            entry = entry2.next;
        }
    }

    public void clear() {
        Entry[] entryArr = this.table;
        int length = entryArr.length;
        while (true) {
            length--;
            if (length < 0) {
                this.count = 0;
                return;
            }
            entryArr[length] = null;
        }
    }

    static class Entry {
        int hash;
        int key;
        Entry next;
        int value;

        protected Entry(int i, int i2, int i3, Entry entry) {
            this.hash = i;
            this.key = i2;
            this.value = i3;
            this.next = entry;
        }

        public int getKey() {
            return this.key;
        }

        public int getValue() {
            return this.value;
        }

        /* access modifiers changed from: protected */
        public Object clone() {
            int i = this.hash;
            int i2 = this.key;
            int i3 = this.value;
            Entry entry = this.next;
            return new Entry(i, i2, i3, entry != null ? (Entry) entry.clone() : null);
        }
    }

    static class IntHashtableIterator implements Iterator {
        Entry entry;
        int index;
        Entry[] table;

        IntHashtableIterator(Entry[] entryArr) {
            this.table = entryArr;
            this.index = entryArr.length;
        }

        public boolean hasNext() {
            Entry entry2;
            if (this.entry != null) {
                return true;
            }
            do {
                int i = this.index;
                this.index = i - 1;
                if (i <= 0) {
                    return false;
                }
                entry2 = this.table[this.index];
                this.entry = entry2;
            } while (entry2 == null);
            return true;
        }

        public Object next() {
            Entry entry2;
            if (this.entry == null) {
                do {
                    int i = this.index;
                    this.index = i - 1;
                    if (i <= 0) {
                        break;
                    }
                    entry2 = this.table[this.index];
                    this.entry = entry2;
                } while (entry2 == null);
            }
            Entry entry3 = this.entry;
            if (entry3 != null) {
                this.entry = entry3.next;
                return entry3;
            }
            throw new NoSuchElementException("IntHashtableIterator");
        }

        public void remove() {
            throw new UnsupportedOperationException("remove() not supported.");
        }
    }

    public Iterator getEntryIterator() {
        return new IntHashtableIterator(this.table);
    }

    public int[] toOrderedKeys() {
        int[] keys = getKeys();
        Arrays.sort(keys);
        return keys;
    }

    public int[] getKeys() {
        int i;
        int[] iArr = new int[this.count];
        int length = this.table.length;
        int i2 = 0;
        Entry entry = null;
        while (true) {
            if (entry == null) {
                while (true) {
                    i = length - 1;
                    if (length <= 0 || (entry = this.table[i]) != null) {
                        length = i;
                    } else {
                        length = i;
                    }
                }
                length = i;
            }
            if (entry == null) {
                return iArr;
            }
            Entry entry2 = entry.next;
            iArr[i2] = entry.key;
            entry = entry2;
            i2++;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:10:0x0019 A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:11:0x001a  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public int getOneKey() {
        /*
            r4 = this;
            int r0 = r4.count
            r1 = 0
            if (r0 != 0) goto L_0x0006
            return r1
        L_0x0006:
            com.lowagie.text.pdf.IntHashtable$Entry[] r0 = r4.table
            int r0 = r0.length
            r2 = 0
        L_0x000a:
            int r3 = r0 + -1
            if (r0 <= 0) goto L_0x0017
            com.lowagie.text.pdf.IntHashtable$Entry[] r0 = r4.table
            r2 = r0[r3]
            if (r2 == 0) goto L_0x0015
            goto L_0x0017
        L_0x0015:
            r0 = r3
            goto L_0x000a
        L_0x0017:
            if (r2 != 0) goto L_0x001a
            return r1
        L_0x001a:
            int r0 = r2.key
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.lowagie.text.pdf.IntHashtable.getOneKey():int");
    }

    public Object clone() {
        try {
            IntHashtable intHashtable = (IntHashtable) super.clone();
            intHashtable.table = new Entry[this.table.length];
            int length = this.table.length;
            while (true) {
                int i = length - 1;
                if (length <= 0) {
                    return intHashtable;
                }
                intHashtable.table[i] = this.table[i] != null ? (Entry) this.table[i].clone() : null;
                length = i;
            }
        } catch (CloneNotSupportedException unused) {
            throw new InternalError();
        }
    }
}

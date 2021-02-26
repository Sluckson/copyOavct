package com.lowagie.text.pdf.hyphenation;

import java.io.PrintStream;
import java.io.Serializable;
import java.util.Enumeration;
import java.util.Stack;
import kotlin.jvm.internal.CharCompanionObject;

public class TernaryTree implements Cloneable, Serializable {
    protected static final int BLOCK_SIZE = 2048;
    private static final long serialVersionUID = 5313366505322983510L;

    /* renamed from: eq */
    protected char[] f799eq;
    protected char freenode;

    /* renamed from: hi */
    protected char[] f800hi;

    /* renamed from: kv */
    protected CharVector f801kv;
    protected int length;

    /* renamed from: lo */
    protected char[] f802lo;
    protected char root;

    /* renamed from: sc */
    protected char[] f803sc;

    TernaryTree() {
        init();
    }

    /* access modifiers changed from: protected */
    public void init() {
        this.root = 0;
        this.freenode = 1;
        this.length = 0;
        this.f802lo = new char[2048];
        this.f800hi = new char[2048];
        this.f799eq = new char[2048];
        this.f803sc = new char[2048];
        this.f801kv = new CharVector();
    }

    public void insert(String str, char c) {
        int length2 = str.length() + 1;
        int i = this.freenode + length2;
        char[] cArr = this.f799eq;
        if (i > cArr.length) {
            redimNodeArrays(cArr.length + 2048);
        }
        int i2 = length2 - 1;
        char[] cArr2 = new char[length2];
        str.getChars(0, i2, cArr2, 0);
        cArr2[i2] = 0;
        this.root = insert(this.root, cArr2, 0, c);
    }

    public void insert(char[] cArr, int i, char c) {
        int strlen = this.freenode + strlen(cArr) + 1;
        char[] cArr2 = this.f799eq;
        if (strlen > cArr2.length) {
            redimNodeArrays(cArr2.length + 2048);
        }
        this.root = insert(this.root, cArr, i, c);
    }

    private char insert(char c, char[] cArr, int i, char c2) {
        int strlen = strlen(cArr, i);
        if (c == 0) {
            char c3 = this.freenode;
            this.freenode = (char) (c3 + 1);
            this.f799eq[c3] = c2;
            this.length++;
            this.f800hi[c3] = 0;
            if (strlen > 0) {
                this.f803sc[c3] = CharCompanionObject.MAX_VALUE;
                this.f802lo[c3] = (char) this.f801kv.alloc(strlen + 1);
                strcpy(this.f801kv.getArray(), this.f802lo[c3], cArr, i);
            } else {
                this.f803sc[c3] = 0;
                this.f802lo[c3] = 0;
            }
            return c3;
        }
        char[] cArr2 = this.f803sc;
        if (cArr2[c] == 65535) {
            char c4 = this.freenode;
            this.freenode = (char) (c4 + 1);
            char[] cArr3 = this.f802lo;
            cArr3[c4] = cArr3[c];
            char[] cArr4 = this.f799eq;
            cArr4[c4] = cArr4[c];
            cArr3[c] = 0;
            if (strlen > 0) {
                cArr2[c] = this.f801kv.get(cArr3[c4]);
                this.f799eq[c] = c4;
                char[] cArr5 = this.f802lo;
                cArr5[c4] = (char) (cArr5[c4] + 1);
                if (this.f801kv.get(cArr5[c4]) == 0) {
                    this.f802lo[c4] = 0;
                    this.f803sc[c4] = 0;
                    this.f800hi[c4] = 0;
                } else {
                    this.f803sc[c4] = CharCompanionObject.MAX_VALUE;
                }
            } else {
                cArr2[c4] = CharCompanionObject.MAX_VALUE;
                this.f800hi[c] = c4;
                cArr2[c] = 0;
                cArr4[c] = c2;
                this.length++;
                return c;
            }
        }
        char c5 = cArr[i];
        char[] cArr6 = this.f803sc;
        if (c5 < cArr6[c]) {
            char[] cArr7 = this.f802lo;
            cArr7[c] = insert(cArr7[c], cArr, i, c2);
        } else if (c5 != cArr6[c]) {
            char[] cArr8 = this.f800hi;
            cArr8[c] = insert(cArr8[c], cArr, i, c2);
        } else if (c5 != 0) {
            char[] cArr9 = this.f799eq;
            cArr9[c] = insert(cArr9[c], cArr, i + 1, c2);
        } else {
            this.f799eq[c] = c2;
        }
        return c;
    }

    public static int strcmp(char[] cArr, int i, char[] cArr2, int i2) {
        while (cArr[i] == cArr2[i2]) {
            if (cArr[i] == 0) {
                return 0;
            }
            i++;
            i2++;
        }
        return cArr[i] - cArr2[i2];
    }

    public static int strcmp(String str, char[] cArr, int i) {
        int length2 = str.length();
        int i2 = 0;
        while (i2 < length2) {
            int i3 = i + i2;
            int charAt = str.charAt(i2) - cArr[i3];
            if (charAt != 0 || cArr[i3] == 0) {
                return charAt;
            }
            i2++;
        }
        int i4 = i + i2;
        if (cArr[i4] != 0) {
            return -cArr[i4];
        }
        return 0;
    }

    public static void strcpy(char[] cArr, int i, char[] cArr2, int i2) {
        while (cArr2[i2] != 0) {
            cArr[i] = cArr2[i2];
            i++;
            i2++;
        }
        cArr[i] = 0;
    }

    public static int strlen(char[] cArr, int i) {
        int i2 = 0;
        while (i < cArr.length && cArr[i] != 0) {
            i2++;
            i++;
        }
        return i2;
    }

    public static int strlen(char[] cArr) {
        return strlen(cArr, 0);
    }

    public int find(String str) {
        int length2 = str.length();
        char[] cArr = new char[(length2 + 1)];
        str.getChars(0, length2, cArr, 0);
        cArr[length2] = 0;
        return find(cArr, 0);
    }

    public int find(char[] cArr, int i) {
        char c = this.root;
        while (c != 0) {
            char[] cArr2 = this.f803sc;
            if (cArr2[c] != 65535) {
                char c2 = cArr[i];
                int i2 = c2 - cArr2[c];
                if (i2 == 0) {
                    if (c2 == 0) {
                        return this.f799eq[c];
                    }
                    i++;
                    c = this.f799eq[c];
                } else if (i2 < 0) {
                    c = this.f802lo[c];
                } else {
                    c = this.f800hi[c];
                }
            } else if (strcmp(cArr, i, this.f801kv.getArray(), this.f802lo[c]) == 0) {
                return this.f799eq[c];
            } else {
                return -1;
            }
        }
        return -1;
    }

    public boolean knows(String str) {
        return find(str) >= 0;
    }

    private void redimNodeArrays(int i) {
        char[] cArr = this.f802lo;
        int length2 = i < cArr.length ? i : cArr.length;
        char[] cArr2 = new char[i];
        System.arraycopy(this.f802lo, 0, cArr2, 0, length2);
        this.f802lo = cArr2;
        char[] cArr3 = new char[i];
        System.arraycopy(this.f800hi, 0, cArr3, 0, length2);
        this.f800hi = cArr3;
        char[] cArr4 = new char[i];
        System.arraycopy(this.f799eq, 0, cArr4, 0, length2);
        this.f799eq = cArr4;
        char[] cArr5 = new char[i];
        System.arraycopy(this.f803sc, 0, cArr5, 0, length2);
        this.f803sc = cArr5;
    }

    public int size() {
        return this.length;
    }

    public Object clone() {
        TernaryTree ternaryTree = new TernaryTree();
        ternaryTree.f802lo = (char[]) this.f802lo.clone();
        ternaryTree.f800hi = (char[]) this.f800hi.clone();
        ternaryTree.f799eq = (char[]) this.f799eq.clone();
        ternaryTree.f803sc = (char[]) this.f803sc.clone();
        ternaryTree.f801kv = (CharVector) this.f801kv.clone();
        ternaryTree.root = this.root;
        ternaryTree.freenode = this.freenode;
        ternaryTree.length = this.length;
        return ternaryTree;
    }

    /* access modifiers changed from: protected */
    public void insertBalanced(String[] strArr, char[] cArr, int i, int i2) {
        if (i2 >= 1) {
            int i3 = i2 >> 1;
            int i4 = i3 + i;
            insert(strArr[i4], cArr[i4]);
            insertBalanced(strArr, cArr, i, i3);
            insertBalanced(strArr, cArr, i4 + 1, (i2 - i3) - 1);
        }
    }

    public void balance() {
        int i = this.length;
        String[] strArr = new String[i];
        char[] cArr = new char[i];
        Iterator iterator = new Iterator();
        int i2 = 0;
        while (iterator.hasMoreElements()) {
            cArr[i2] = iterator.getValue();
            strArr[i2] = (String) iterator.nextElement();
            i2++;
        }
        init();
        insertBalanced(strArr, cArr, 0, i);
    }

    public void trimToSize() {
        balance();
        redimNodeArrays(this.freenode);
        CharVector charVector = new CharVector();
        charVector.alloc(1);
        compact(charVector, new TernaryTree(), this.root);
        this.f801kv = charVector;
        this.f801kv.trimToSize();
    }

    private void compact(CharVector charVector, TernaryTree ternaryTree, char c) {
        if (c != 0) {
            if (this.f803sc[c] == 65535) {
                int find = ternaryTree.find(this.f801kv.getArray(), this.f802lo[c]);
                if (find < 0) {
                    find = charVector.alloc(strlen(this.f801kv.getArray(), this.f802lo[c]) + 1);
                    strcpy(charVector.getArray(), find, this.f801kv.getArray(), this.f802lo[c]);
                    ternaryTree.insert(charVector.getArray(), find, (char) find);
                }
                this.f802lo[c] = (char) find;
                return;
            }
            compact(charVector, ternaryTree, this.f802lo[c]);
            if (this.f803sc[c] != 0) {
                compact(charVector, ternaryTree, this.f799eq[c]);
            }
            compact(charVector, ternaryTree, this.f800hi[c]);
        }
    }

    public Enumeration keys() {
        return new Iterator();
    }

    public class Iterator implements Enumeration {
        int cur = -1;
        String curkey;

        /* renamed from: ks */
        StringBuffer f804ks = new StringBuffer();

        /* renamed from: ns */
        Stack f805ns = new Stack();

        private class Item implements Cloneable {
            char child;
            char parent;

            public Item() {
                this.parent = 0;
                this.child = 0;
            }

            public Item(char c, char c2) {
                this.parent = c;
                this.child = c2;
            }

            public Object clone() {
                return new Item(this.parent, this.child);
            }
        }

        public Iterator() {
            rewind();
        }

        public void rewind() {
            this.f805ns.removeAllElements();
            this.f804ks.setLength(0);
            this.cur = TernaryTree.this.root;
            run();
        }

        public Object nextElement() {
            String str = this.curkey;
            this.cur = m384up();
            run();
            return str;
        }

        public char getValue() {
            if (this.cur >= 0) {
                return TernaryTree.this.f799eq[this.cur];
            }
            return 0;
        }

        public boolean hasMoreElements() {
            return this.cur != -1;
        }

        /* renamed from: up */
        private int m384up() {
            new Item();
            if (this.f805ns.empty()) {
                return -1;
            }
            if (this.cur != 0 && TernaryTree.this.f803sc[this.cur] == 0) {
                return TernaryTree.this.f802lo[this.cur];
            }
            boolean z = true;
            char c = 0;
            while (z) {
                Item item = (Item) this.f805ns.pop();
                item.child = (char) (item.child + 1);
                char c2 = item.child;
                if (c2 != 1) {
                    if (c2 == 2) {
                        c = TernaryTree.this.f800hi[item.parent];
                        this.f805ns.push(item.clone());
                        if (this.f804ks.length() > 0) {
                            StringBuffer stringBuffer = this.f804ks;
                            stringBuffer.setLength(stringBuffer.length() - 1);
                        }
                    } else if (this.f805ns.empty()) {
                        return -1;
                    } else {
                        z = true;
                    }
                } else if (TernaryTree.this.f803sc[item.parent] != 0) {
                    c = TernaryTree.this.f799eq[item.parent];
                    this.f805ns.push(item.clone());
                    this.f804ks.append(TernaryTree.this.f803sc[item.parent]);
                } else {
                    item.child = (char) (item.child + 1);
                    this.f805ns.push(item.clone());
                    c = TernaryTree.this.f800hi[item.parent];
                }
                z = false;
            }
            return c;
        }

        /* JADX WARNING: type inference failed for: r4v1, types: [int] */
        /* JADX WARNING: Multi-variable type inference failed */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        private int run() {
            /*
                r8 = this;
                int r0 = r8.cur
                r1 = -1
                if (r0 != r1) goto L_0x0006
                return r1
            L_0x0006:
                r0 = 0
                r2 = 0
            L_0x0008:
                int r3 = r8.cur
                r4 = 65535(0xffff, float:9.1834E-41)
                r5 = 1
                if (r3 != 0) goto L_0x0011
                goto L_0x0033
            L_0x0011:
                com.lowagie.text.pdf.hyphenation.TernaryTree r3 = com.lowagie.text.pdf.hyphenation.TernaryTree.this
                char[] r3 = r3.f803sc
                int r6 = r8.cur
                char r3 = r3[r6]
                if (r3 != r4) goto L_0x001d
            L_0x001b:
                r2 = 1
                goto L_0x0033
            L_0x001d:
                java.util.Stack r3 = r8.f805ns
                com.lowagie.text.pdf.hyphenation.TernaryTree$Iterator$Item r7 = new com.lowagie.text.pdf.hyphenation.TernaryTree$Iterator$Item
                char r6 = (char) r6
                r7.<init>(r6, r0)
                r3.push(r7)
                com.lowagie.text.pdf.hyphenation.TernaryTree r3 = com.lowagie.text.pdf.hyphenation.TernaryTree.this
                char[] r3 = r3.f803sc
                int r6 = r8.cur
                char r3 = r3[r6]
                if (r3 != 0) goto L_0x007e
                goto L_0x001b
            L_0x0033:
                if (r2 == 0) goto L_0x0073
                java.lang.StringBuffer r1 = new java.lang.StringBuffer
                java.lang.StringBuffer r2 = r8.f804ks
                java.lang.String r2 = r2.toString()
                r1.<init>(r2)
                com.lowagie.text.pdf.hyphenation.TernaryTree r2 = com.lowagie.text.pdf.hyphenation.TernaryTree.this
                char[] r2 = r2.f803sc
                int r3 = r8.cur
                char r2 = r2[r3]
                if (r2 != r4) goto L_0x006c
                com.lowagie.text.pdf.hyphenation.TernaryTree r2 = com.lowagie.text.pdf.hyphenation.TernaryTree.this
                char[] r2 = r2.f802lo
                int r3 = r8.cur
                char r2 = r2[r3]
            L_0x0052:
                com.lowagie.text.pdf.hyphenation.TernaryTree r3 = com.lowagie.text.pdf.hyphenation.TernaryTree.this
                com.lowagie.text.pdf.hyphenation.CharVector r3 = r3.f801kv
                char r3 = r3.get(r2)
                if (r3 != 0) goto L_0x005d
                goto L_0x006c
            L_0x005d:
                com.lowagie.text.pdf.hyphenation.TernaryTree r3 = com.lowagie.text.pdf.hyphenation.TernaryTree.this
                com.lowagie.text.pdf.hyphenation.CharVector r3 = r3.f801kv
                int r4 = r2 + 1
                char r2 = r3.get(r2)
                r1.append(r2)
                r2 = r4
                goto L_0x0052
            L_0x006c:
                java.lang.String r1 = r1.toString()
                r8.curkey = r1
                return r0
            L_0x0073:
                int r3 = r8.m384up()
                r8.cur = r3
                int r3 = r8.cur
                if (r3 != r1) goto L_0x0008
                return r1
            L_0x007e:
                com.lowagie.text.pdf.hyphenation.TernaryTree r3 = com.lowagie.text.pdf.hyphenation.TernaryTree.this
                char[] r3 = r3.f802lo
                int r4 = r8.cur
                char r3 = r3[r4]
                r8.cur = r3
                goto L_0x0008
            */
            throw new UnsupportedOperationException("Method not decompiled: com.lowagie.text.pdf.hyphenation.TernaryTree.Iterator.run():int");
        }
    }

    public void printStats() {
        PrintStream printStream = System.out;
        printStream.println("Number of keys = " + Integer.toString(this.length));
        PrintStream printStream2 = System.out;
        printStream2.println("Node count = " + Integer.toString(this.freenode));
        PrintStream printStream3 = System.out;
        printStream3.println("Key Array length = " + Integer.toString(this.f801kv.length()));
    }
}

package com.lowagie.text.pdf;

import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;

public class SequenceList {
    protected static final int COMMA = 1;
    private static final int DIGIT = 1;
    private static final int DIGIT2 = 3;
    protected static final int END = 6;
    protected static final char EOT = '￿';
    private static final int FIRST = 0;
    protected static final int MINUS = 2;
    protected static final int NOT = 3;
    private static final String NOT_OTHER = "-,!0123456789";
    protected static final int NUMBER = 5;
    private static final int OTHER = 2;
    protected static final int TEXT = 4;
    protected boolean even;
    protected int high;
    protected boolean inverse;
    protected int low;
    protected int number;
    protected boolean odd;
    protected String other;
    protected int ptr = 0;
    protected char[] text;

    protected SequenceList(String str) {
        this.text = str.toCharArray();
    }

    /* access modifiers changed from: protected */
    public char nextChar() {
        char c;
        do {
            int i = this.ptr;
            char[] cArr = this.text;
            if (i >= cArr.length) {
                return 65535;
            }
            this.ptr = i + 1;
            c = cArr[i];
        } while (c <= ' ');
        return c;
    }

    /* access modifiers changed from: protected */
    public void putBack() {
        this.ptr--;
        if (this.ptr < 0) {
            this.ptr = 0;
        }
    }

    /* access modifiers changed from: protected */
    public int getType() {
        StringBuffer stringBuffer = new StringBuffer();
        char c = 0;
        while (true) {
            char nextChar = nextChar();
            if (nextChar == 65535) {
                if (c == 1) {
                    String stringBuffer2 = stringBuffer.toString();
                    this.other = stringBuffer2;
                    this.number = Integer.parseInt(stringBuffer2);
                    return 5;
                } else if (c != 2) {
                    return 6;
                } else {
                    this.other = stringBuffer.toString().toLowerCase();
                    return 4;
                }
            } else if (c != 0) {
                if (c != 1) {
                    if (c != 2) {
                        continue;
                    } else if (NOT_OTHER.indexOf(nextChar) < 0) {
                        stringBuffer.append(nextChar);
                    } else {
                        putBack();
                        this.other = stringBuffer.toString().toLowerCase();
                        return 4;
                    }
                } else if (nextChar < '0' || nextChar > '9') {
                    putBack();
                    String stringBuffer3 = stringBuffer.toString();
                    this.other = stringBuffer3;
                    this.number = Integer.parseInt(stringBuffer3);
                } else {
                    stringBuffer.append(nextChar);
                }
            } else if (nextChar == '!') {
                return 3;
            } else {
                if (nextChar == ',') {
                    return 1;
                }
                if (nextChar == '-') {
                    return 2;
                }
                stringBuffer.append(nextChar);
                c = (nextChar < '0' || nextChar > '9') ? (char) 2 : 1;
            }
        }
        putBack();
        String stringBuffer32 = stringBuffer.toString();
        this.other = stringBuffer32;
        this.number = Integer.parseInt(stringBuffer32);
        return 5;
    }

    private void otherProc() {
        if (this.other.equals("odd") || this.other.equals("o")) {
            this.odd = true;
            this.even = false;
        } else if (this.other.equals("even") || this.other.equals("e")) {
            this.odd = false;
            this.even = true;
        }
    }

    /* access modifiers changed from: protected */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x005e  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean getAttributes() {
        /*
            r7 = this;
            r0 = -1
            r7.low = r0
            r7.high = r0
            r0 = 0
            r7.inverse = r0
            r7.even = r0
            r7.odd = r0
            r1 = 3
            r2 = 1
            r3 = 2
        L_0x000f:
            r4 = 2
        L_0x0010:
            int r5 = r7.getType()
            r6 = 6
            if (r5 == r6) goto L_0x005c
            if (r5 != r2) goto L_0x001a
            goto L_0x005c
        L_0x001a:
            if (r4 == r2) goto L_0x0047
            r6 = 5
            if (r4 == r3) goto L_0x0034
            if (r4 == r1) goto L_0x0022
            goto L_0x0010
        L_0x0022:
            if (r5 == r3) goto L_0x0010
            if (r5 == r1) goto L_0x0031
            if (r5 == r6) goto L_0x002c
            r7.otherProc()
            goto L_0x000f
        L_0x002c:
            int r4 = r7.number
            r7.high = r4
            goto L_0x000f
        L_0x0031:
            r7.inverse = r2
            goto L_0x000f
        L_0x0034:
            if (r5 == r3) goto L_0x005a
            if (r5 == r1) goto L_0x0044
            if (r5 != r6) goto L_0x0040
            int r4 = r7.number
            r7.low = r4
            r4 = 1
            goto L_0x0010
        L_0x0040:
            r7.otherProc()
            goto L_0x0010
        L_0x0044:
            r7.inverse = r2
            goto L_0x0010
        L_0x0047:
            if (r5 == r3) goto L_0x005a
            if (r5 == r1) goto L_0x0053
            int r4 = r7.low
            r7.high = r4
            r7.otherProc()
            goto L_0x000f
        L_0x0053:
            r7.inverse = r2
            int r4 = r7.low
            r7.high = r4
            goto L_0x000f
        L_0x005a:
            r4 = 3
            goto L_0x0010
        L_0x005c:
            if (r4 != r2) goto L_0x0062
            int r1 = r7.low
            r7.high = r1
        L_0x0062:
            if (r5 != r6) goto L_0x0065
            return r2
        L_0x0065:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.lowagie.text.pdf.SequenceList.getAttributes():boolean");
    }

    public static List expand(String str, int i) {
        int i2;
        SequenceList sequenceList = new SequenceList(str);
        LinkedList linkedList = new LinkedList();
        boolean z = false;
        while (!z) {
            z = sequenceList.getAttributes();
            int i3 = -1;
            if (sequenceList.low != -1 || sequenceList.high != -1 || sequenceList.even || sequenceList.odd) {
                int i4 = 1;
                if (sequenceList.low < 1) {
                    sequenceList.low = 1;
                }
                int i5 = sequenceList.high;
                if (i5 < 1 || i5 > i) {
                    sequenceList.high = i;
                }
                if (sequenceList.low > i) {
                    sequenceList.low = i;
                }
                if (sequenceList.inverse) {
                    int i6 = sequenceList.low;
                    int i7 = sequenceList.high;
                    if (i6 > i7) {
                        sequenceList.low = i7;
                        sequenceList.high = i6;
                    }
                    ListIterator listIterator = linkedList.listIterator();
                    while (listIterator.hasNext()) {
                        int intValue = ((Integer) listIterator.next()).intValue();
                        if ((!sequenceList.even || (intValue & 1) != 1) && ((!sequenceList.odd || (intValue & 1) != 0) && intValue >= sequenceList.low && intValue <= sequenceList.high)) {
                            listIterator.remove();
                        }
                    }
                } else if (sequenceList.low > sequenceList.high) {
                    if (sequenceList.odd || sequenceList.even) {
                        if (sequenceList.even) {
                            sequenceList.low &= -2;
                        } else {
                            int i8 = sequenceList.low;
                            if ((i8 & 1) == 1) {
                                i4 = 0;
                            }
                            sequenceList.low = i8 - i4;
                        }
                        i3 = -2;
                    }
                    for (int i9 = sequenceList.low; i9 >= sequenceList.high; i9 += i3) {
                        linkedList.add(new Integer(i9));
                    }
                } else {
                    if (sequenceList.odd || sequenceList.even) {
                        i2 = 2;
                        if (sequenceList.odd) {
                            sequenceList.low |= 1;
                        } else {
                            int i10 = sequenceList.low;
                            if ((i10 & 1) != 1) {
                                i4 = 0;
                            }
                            sequenceList.low = i10 + i4;
                        }
                    } else {
                        i2 = 1;
                    }
                    for (int i11 = sequenceList.low; i11 <= sequenceList.high; i11 += i2) {
                        linkedList.add(new Integer(i11));
                    }
                }
            }
        }
        return linkedList;
    }
}

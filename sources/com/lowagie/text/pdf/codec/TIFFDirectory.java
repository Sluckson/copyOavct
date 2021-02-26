package com.lowagie.text.pdf.codec;

import com.lowagie.text.pdf.RandomAccessFileOrArray;
import java.io.EOFException;
import java.io.IOException;
import java.io.Serializable;
import java.util.Enumeration;
import java.util.Hashtable;

public class TIFFDirectory implements Serializable {
    private static final long serialVersionUID = -168636766193675380L;
    private static final int[] sizeOfType;
    long IFDOffset = 8;
    Hashtable fieldIndex = new Hashtable();
    TIFFField[] fields;
    boolean isBigEndian;
    long nextIFDOffset = 0;
    int numEntries;

    private static boolean isValidEndianTag(int i) {
        return i == 18761 || i == 19789;
    }

    TIFFDirectory() {
    }

    public TIFFDirectory(RandomAccessFileOrArray randomAccessFileOrArray, int i) throws IOException {
        long filePointer = (long) randomAccessFileOrArray.getFilePointer();
        randomAccessFileOrArray.seek(0);
        int readUnsignedShort = randomAccessFileOrArray.readUnsignedShort();
        if (isValidEndianTag(readUnsignedShort)) {
            int i2 = 0;
            this.isBigEndian = readUnsignedShort == 19789;
            if (readUnsignedShort(randomAccessFileOrArray) == 42) {
                long readUnsignedInt = readUnsignedInt(randomAccessFileOrArray);
                while (i2 < i) {
                    if (readUnsignedInt != 0) {
                        randomAccessFileOrArray.seek(readUnsignedInt);
                        randomAccessFileOrArray.skip((long) (readUnsignedShort(randomAccessFileOrArray) * 12));
                        readUnsignedInt = readUnsignedInt(randomAccessFileOrArray);
                        i2++;
                    } else {
                        throw new IllegalArgumentException("Directory number too large.");
                    }
                }
                randomAccessFileOrArray.seek(readUnsignedInt);
                initialize(randomAccessFileOrArray);
                randomAccessFileOrArray.seek(filePointer);
                return;
            }
            throw new IllegalArgumentException("Bad magic number, should be 42.");
        }
        throw new IllegalArgumentException("Bad endianness tag (not 0x4949 or 0x4d4d).");
    }

    public TIFFDirectory(RandomAccessFileOrArray randomAccessFileOrArray, long j, int i) throws IOException {
        long filePointer = (long) randomAccessFileOrArray.getFilePointer();
        randomAccessFileOrArray.seek(0);
        int readUnsignedShort = randomAccessFileOrArray.readUnsignedShort();
        if (isValidEndianTag(readUnsignedShort)) {
            this.isBigEndian = readUnsignedShort == 19789;
            randomAccessFileOrArray.seek(j);
            for (int i2 = 0; i2 < i; i2++) {
                randomAccessFileOrArray.seek(j + ((long) (readUnsignedShort(randomAccessFileOrArray) * 12)));
                j = readUnsignedInt(randomAccessFileOrArray);
                randomAccessFileOrArray.seek(j);
            }
            initialize(randomAccessFileOrArray);
            randomAccessFileOrArray.seek(filePointer);
            return;
        }
        throw new IllegalArgumentException("Bad endianness tag (not 0x4949 or 0x4d4d).");
    }

    static {
        int[] iArr = new int[13];
        iArr[1] = 1;
        iArr[2] = 1;
        iArr[3] = 2;
        iArr[4] = 4;
        iArr[5] = 8;
        iArr[6] = 1;
        iArr[7] = 1;
        iArr[8] = 2;
        iArr[9] = 4;
        iArr[10] = 8;
        iArr[11] = 4;
        iArr[12] = 8;
        sizeOfType = iArr;
    }

    /*  JADX ERROR: JadxRuntimeException in pass: InitCodeVariables
        jadx.core.utils.exceptions.JadxRuntimeException: Several immutable types in one variable: [byte[], char[], short[]], vars: [r4v7 ?, r4v8 ?, r4v9 ?, r4v11 ?, r4v12 ?, r4v13 ?, r4v16 ?, r4v17 ?, r4v18 ?, r4v21 ?, r4v22 ?, r4v23 ?]
        	at jadx.core.dex.visitors.InitCodeVariables.setCodeVarType(InitCodeVariables.java:102)
        	at jadx.core.dex.visitors.InitCodeVariables.setCodeVar(InitCodeVariables.java:78)
        	at jadx.core.dex.visitors.InitCodeVariables.initCodeVar(InitCodeVariables.java:69)
        	at jadx.core.dex.visitors.InitCodeVariables.initCodeVars(InitCodeVariables.java:51)
        	at jadx.core.dex.visitors.InitCodeVariables.visit(InitCodeVariables.java:32)
        */
    private void initialize(com.lowagie.text.pdf.RandomAccessFileOrArray r19) throws java.io.IOException {
        /*
            r18 = this;
            r0 = r18
            r1 = r19
            int r2 = r19.length()
            long r2 = (long) r2
            int r4 = r19.getFilePointer()
            long r4 = (long) r4
            r0.IFDOffset = r4
            int r4 = r18.readUnsignedShort(r19)
            r0.numEntries = r4
            int r4 = r0.numEntries
            com.lowagie.text.pdf.codec.TIFFField[] r4 = new com.lowagie.text.pdf.codec.TIFFField[r4]
            r0.fields = r4
            r6 = 0
            r7 = 0
            r8 = 0
        L_0x0020:
            int r10 = r0.numEntries
            if (r7 >= r10) goto L_0x016a
            int r10 = (r8 > r2 ? 1 : (r8 == r2 ? 0 : -1))
            if (r10 < 0) goto L_0x002a
            goto L_0x016a
        L_0x002a:
            int r8 = r18.readUnsignedShort(r19)
            int r9 = r18.readUnsignedShort(r19)
            long r10 = r18.readUnsignedInt(r19)
            int r11 = (int) r10
            int r10 = r19.getFilePointer()
            r12 = 4
            int r10 = r10 + r12
            long r13 = (long) r10
            r10 = 1
            int[] r15 = sizeOfType     // Catch:{ ArrayIndexOutOfBoundsException -> 0x0054 }
            r15 = r15[r9]     // Catch:{ ArrayIndexOutOfBoundsException -> 0x0054 }
            int r15 = r15 * r11
            if (r15 <= r12) goto L_0x0052
            long r4 = r18.readUnsignedInt(r19)     // Catch:{ ArrayIndexOutOfBoundsException -> 0x0054 }
            int r12 = (r4 > r2 ? 1 : (r4 == r2 ? 0 : -1))
            if (r12 >= 0) goto L_0x0054
            r1.seek((long) r4)     // Catch:{ ArrayIndexOutOfBoundsException -> 0x0054 }
        L_0x0052:
            r4 = 1
            goto L_0x0055
        L_0x0054:
            r4 = 0
        L_0x0055:
            if (r4 == 0) goto L_0x0161
            java.util.Hashtable r4 = r0.fieldIndex
            java.lang.Integer r5 = new java.lang.Integer
            r5.<init>(r8)
            java.lang.Integer r12 = new java.lang.Integer
            r12.<init>(r7)
            r4.put(r5, r12)
            r4 = 0
            r5 = 2
            switch(r9) {
                case 1: goto L_0x0114;
                case 2: goto L_0x0114;
                case 3: goto L_0x0104;
                case 4: goto L_0x00f5;
                case 5: goto L_0x00d1;
                case 6: goto L_0x0114;
                case 7: goto L_0x0114;
                case 8: goto L_0x00c1;
                case 9: goto L_0x00b1;
                case 10: goto L_0x008d;
                case 11: goto L_0x007d;
                case 12: goto L_0x006d;
                default: goto L_0x006b;
            }
        L_0x006b:
            goto L_0x0158
        L_0x006d:
            double[] r4 = new double[r11]
            r5 = 0
        L_0x0070:
            if (r5 < r11) goto L_0x0074
            goto L_0x0158
        L_0x0074:
            double r16 = r18.readDouble(r19)
            r4[r5] = r16
            int r5 = r5 + 1
            goto L_0x0070
        L_0x007d:
            float[] r4 = new float[r11]
            r5 = 0
        L_0x0080:
            if (r5 < r11) goto L_0x0084
            goto L_0x0158
        L_0x0084:
            float r10 = r18.readFloat(r19)
            r4[r5] = r10
            int r5 = r5 + 1
            goto L_0x0080
        L_0x008d:
            int[] r4 = new int[]{r11, r5}
            java.lang.Class<int> r5 = int.class
            java.lang.Object r4 = java.lang.reflect.Array.newInstance(r5, r4)
            int[][] r4 = (int[][]) r4
            r5 = 0
        L_0x009a:
            if (r5 < r11) goto L_0x009e
            goto L_0x0158
        L_0x009e:
            r12 = r4[r5]
            int r16 = r18.readInt(r19)
            r12[r6] = r16
            r12 = r4[r5]
            int r16 = r18.readInt(r19)
            r12[r10] = r16
            int r5 = r5 + 1
            goto L_0x009a
        L_0x00b1:
            int[] r4 = new int[r11]
            r5 = 0
        L_0x00b4:
            if (r5 < r11) goto L_0x00b8
            goto L_0x0158
        L_0x00b8:
            int r10 = r18.readInt(r19)
            r4[r5] = r10
            int r5 = r5 + 1
            goto L_0x00b4
        L_0x00c1:
            short[] r4 = new short[r11]
            r5 = 0
        L_0x00c4:
            if (r5 < r11) goto L_0x00c8
            goto L_0x0158
        L_0x00c8:
            short r10 = r18.readShort(r19)
            r4[r5] = r10
            int r5 = r5 + 1
            goto L_0x00c4
        L_0x00d1:
            int[] r4 = new int[]{r11, r5}
            java.lang.Class<long> r5 = long.class
            java.lang.Object r4 = java.lang.reflect.Array.newInstance(r5, r4)
            long[][] r4 = (long[][]) r4
            r5 = 0
        L_0x00de:
            if (r5 < r11) goto L_0x00e2
            goto L_0x0158
        L_0x00e2:
            r12 = r4[r5]
            long r16 = r18.readUnsignedInt(r19)
            r12[r6] = r16
            r12 = r4[r5]
            long r16 = r18.readUnsignedInt(r19)
            r12[r10] = r16
            int r5 = r5 + 1
            goto L_0x00de
        L_0x00f5:
            long[] r4 = new long[r11]
            r5 = 0
        L_0x00f8:
            if (r5 < r11) goto L_0x00fb
            goto L_0x0158
        L_0x00fb:
            long r16 = r18.readUnsignedInt(r19)
            r4[r5] = r16
            int r5 = r5 + 1
            goto L_0x00f8
        L_0x0104:
            char[] r4 = new char[r11]
            r5 = 0
        L_0x0107:
            if (r5 < r11) goto L_0x010a
            goto L_0x0158
        L_0x010a:
            int r10 = r18.readUnsignedShort(r19)
            char r10 = (char) r10
            r4[r5] = r10
            int r5 = r5 + 1
            goto L_0x0107
        L_0x0114:
            byte[] r4 = new byte[r11]
            r1.readFully(r4, r6, r11)
            if (r9 != r5) goto L_0x0158
            java.util.ArrayList r5 = new java.util.ArrayList
            r5.<init>()
            r10 = 0
            r12 = 0
        L_0x0122:
            if (r10 < r11) goto L_0x013b
            int r4 = r5.size()
            java.lang.String[] r10 = new java.lang.String[r4]
            r11 = 0
        L_0x012b:
            if (r11 < r4) goto L_0x0130
            r11 = r4
            r4 = r10
            goto L_0x0158
        L_0x0130:
            java.lang.Object r12 = r5.get(r11)
            java.lang.String r12 = (java.lang.String) r12
            r10[r11] = r12
            int r11 = r11 + 1
            goto L_0x012b
        L_0x013b:
            if (r10 >= r11) goto L_0x0147
            int r16 = r10 + 1
            byte r10 = r4[r10]
            if (r10 != 0) goto L_0x0144
            goto L_0x0149
        L_0x0144:
            r10 = r16
            goto L_0x013b
        L_0x0147:
            r16 = r10
        L_0x0149:
            java.lang.String r10 = new java.lang.String
            int r6 = r16 - r12
            r10.<init>(r4, r12, r6)
            r5.add(r10)
            r10 = r16
            r12 = r10
            r6 = 0
            goto L_0x0122
        L_0x0158:
            com.lowagie.text.pdf.codec.TIFFField[] r5 = r0.fields
            com.lowagie.text.pdf.codec.TIFFField r6 = new com.lowagie.text.pdf.codec.TIFFField
            r6.<init>(r8, r9, r11, r4)
            r5[r7] = r6
        L_0x0161:
            r1.seek((long) r13)
            int r7 = r7 + 1
            r8 = r13
            r6 = 0
            goto L_0x0020
        L_0x016a:
            long r1 = r18.readUnsignedInt(r19)     // Catch:{ Exception -> 0x0171 }
            r0.nextIFDOffset = r1     // Catch:{ Exception -> 0x0171 }
            goto L_0x0175
        L_0x0171:
            r1 = 0
            r0.nextIFDOffset = r1
        L_0x0175:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.lowagie.text.pdf.codec.TIFFDirectory.initialize(com.lowagie.text.pdf.RandomAccessFileOrArray):void");
    }

    public int getNumEntries() {
        return this.numEntries;
    }

    public TIFFField getField(int i) {
        Integer num = (Integer) this.fieldIndex.get(new Integer(i));
        if (num == null) {
            return null;
        }
        return this.fields[num.intValue()];
    }

    public boolean isTagPresent(int i) {
        return this.fieldIndex.containsKey(new Integer(i));
    }

    public int[] getTags() {
        int[] iArr = new int[this.fieldIndex.size()];
        Enumeration keys = this.fieldIndex.keys();
        int i = 0;
        while (keys.hasMoreElements()) {
            iArr[i] = ((Integer) keys.nextElement()).intValue();
            i++;
        }
        return iArr;
    }

    public TIFFField[] getFields() {
        return this.fields;
    }

    public byte getFieldAsByte(int i, int i2) {
        return this.fields[((Integer) this.fieldIndex.get(new Integer(i))).intValue()].getAsBytes()[i2];
    }

    public byte getFieldAsByte(int i) {
        return getFieldAsByte(i, 0);
    }

    public long getFieldAsLong(int i, int i2) {
        return this.fields[((Integer) this.fieldIndex.get(new Integer(i))).intValue()].getAsLong(i2);
    }

    public long getFieldAsLong(int i) {
        return getFieldAsLong(i, 0);
    }

    public float getFieldAsFloat(int i, int i2) {
        return this.fields[((Integer) this.fieldIndex.get(new Integer(i))).intValue()].getAsFloat(i2);
    }

    public float getFieldAsFloat(int i) {
        return getFieldAsFloat(i, 0);
    }

    public double getFieldAsDouble(int i, int i2) {
        return this.fields[((Integer) this.fieldIndex.get(new Integer(i))).intValue()].getAsDouble(i2);
    }

    public double getFieldAsDouble(int i) {
        return getFieldAsDouble(i, 0);
    }

    private short readShort(RandomAccessFileOrArray randomAccessFileOrArray) throws IOException {
        if (this.isBigEndian) {
            return randomAccessFileOrArray.readShort();
        }
        return randomAccessFileOrArray.readShortLE();
    }

    private int readUnsignedShort(RandomAccessFileOrArray randomAccessFileOrArray) throws IOException {
        if (this.isBigEndian) {
            return randomAccessFileOrArray.readUnsignedShort();
        }
        return randomAccessFileOrArray.readUnsignedShortLE();
    }

    private int readInt(RandomAccessFileOrArray randomAccessFileOrArray) throws IOException {
        if (this.isBigEndian) {
            return randomAccessFileOrArray.readInt();
        }
        return randomAccessFileOrArray.readIntLE();
    }

    private long readUnsignedInt(RandomAccessFileOrArray randomAccessFileOrArray) throws IOException {
        if (this.isBigEndian) {
            return randomAccessFileOrArray.readUnsignedInt();
        }
        return randomAccessFileOrArray.readUnsignedIntLE();
    }

    private long readLong(RandomAccessFileOrArray randomAccessFileOrArray) throws IOException {
        if (this.isBigEndian) {
            return randomAccessFileOrArray.readLong();
        }
        return randomAccessFileOrArray.readLongLE();
    }

    private float readFloat(RandomAccessFileOrArray randomAccessFileOrArray) throws IOException {
        if (this.isBigEndian) {
            return randomAccessFileOrArray.readFloat();
        }
        return randomAccessFileOrArray.readFloatLE();
    }

    private double readDouble(RandomAccessFileOrArray randomAccessFileOrArray) throws IOException {
        if (this.isBigEndian) {
            return randomAccessFileOrArray.readDouble();
        }
        return randomAccessFileOrArray.readDoubleLE();
    }

    private static int readUnsignedShort(RandomAccessFileOrArray randomAccessFileOrArray, boolean z) throws IOException {
        if (z) {
            return randomAccessFileOrArray.readUnsignedShort();
        }
        return randomAccessFileOrArray.readUnsignedShortLE();
    }

    private static long readUnsignedInt(RandomAccessFileOrArray randomAccessFileOrArray, boolean z) throws IOException {
        if (z) {
            return randomAccessFileOrArray.readUnsignedInt();
        }
        return randomAccessFileOrArray.readUnsignedIntLE();
    }

    public static int getNumDirectories(RandomAccessFileOrArray randomAccessFileOrArray) throws IOException {
        long filePointer = (long) randomAccessFileOrArray.getFilePointer();
        randomAccessFileOrArray.seek(0);
        int readUnsignedShort = randomAccessFileOrArray.readUnsignedShort();
        if (isValidEndianTag(readUnsignedShort)) {
            int i = 0;
            boolean z = readUnsignedShort == 19789;
            if (readUnsignedShort(randomAccessFileOrArray, z) == 42) {
                randomAccessFileOrArray.seek(4);
                long readUnsignedInt = readUnsignedInt(randomAccessFileOrArray, z);
                while (readUnsignedInt != 0) {
                    i++;
                    try {
                        randomAccessFileOrArray.seek(readUnsignedInt);
                        randomAccessFileOrArray.skip((long) (readUnsignedShort(randomAccessFileOrArray, z) * 12));
                        readUnsignedInt = readUnsignedInt(randomAccessFileOrArray, z);
                    } catch (EOFException unused) {
                    }
                }
                randomAccessFileOrArray.seek(filePointer);
                return i;
            }
            throw new IllegalArgumentException("Bad magic number, should be 42.");
        }
        throw new IllegalArgumentException("Bad endianness tag (not 0x4949 or 0x4d4d).");
    }

    public boolean isBigEndian() {
        return this.isBigEndian;
    }

    public long getIFDOffset() {
        return this.IFDOffset;
    }

    public long getNextIFDOffset() {
        return this.nextIFDOffset;
    }
}

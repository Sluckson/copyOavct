package com.wowza.gocoder.sdk.support.wmstransport.wms.amf;

import java.nio.ByteBuffer;

/* compiled from: GoCoderSDK */
public class AMFPacket {
    public static final String TAG = "AMFPacket";
    private long absTimecode = 0;
    private byte[] dataA = null;
    private ByteBuffer dataB = null;
    private int dataLoc = 0;
    private long seq = 0;
    private int size = 0;
    private int src = 0;
    private long timecode = 0;
    private int type = 20;

    public AMFPacket() {
    }

    public AMFPacket(int i, int i2, int i3) {
        this.type = i;
        this.src = i2;
        this.size = i3;
        this.dataA = new byte[i3];
        this.dataLoc = 0;
    }

    public AMFPacket(int i, int i2, byte[] bArr) {
        this.type = i;
        this.src = i2;
        this.size = bArr.length;
        this.dataA = bArr;
        this.dataLoc = 0;
    }

    public AMFPacket clone() {
        return clone(false);
    }

    public AMFPacket clone(boolean z) {
        AMFPacket aMFPacket = new AMFPacket();
        aMFPacket.size = this.size;
        aMFPacket.type = this.type;
        aMFPacket.src = this.src;
        aMFPacket.timecode = this.timecode;
        aMFPacket.absTimecode = this.absTimecode;
        aMFPacket.seq = this.seq;
        if (z) {
            byte[] bArr = this.dataA;
            if (bArr != null) {
                aMFPacket.dataA = new byte[bArr.length];
                byte[] bArr2 = this.dataA;
                byte[] bArr3 = aMFPacket.dataA;
                System.arraycopy(bArr2, 0, bArr3, 0, bArr3.length);
            }
            ByteBuffer byteBuffer = this.dataB;
            if (byteBuffer != null) {
                byte[] array = byteBuffer.array();
                byte[] bArr4 = new byte[array.length];
                if (array != null) {
                    System.arraycopy(array, 0, bArr4, 0, bArr4.length);
                    aMFPacket.dataB = ByteBuffer.wrap(bArr4);
                }
            }
        } else {
            aMFPacket.dataA = this.dataA;
            aMFPacket.dataB = this.dataB;
        }
        aMFPacket.dataLoc = this.dataLoc;
        return aMFPacket;
    }

    public int getSize() {
        return this.size;
    }

    public void setSize(int i) {
        this.size = i;
    }

    public void truncatePacket(int i) {
        this.size = i;
        byte[] bArr = new byte[i];
        byte[] bArr2 = this.dataA;
        if (bArr2 != null) {
            System.arraycopy(bArr2, 0, bArr, 0, bArr.length);
            this.dataA = bArr;
            return;
        }
        ByteBuffer byteBuffer = this.dataB;
        if (byteBuffer != null) {
            byte[] array = byteBuffer.array();
            if (array != null) {
                System.arraycopy(array, 0, bArr, 0, bArr.length);
            }
            this.dataB = ByteBuffer.wrap(bArr);
        }
    }

    public int getMissing() {
        if (this.dataA == null && this.dataB == null) {
            return this.size;
        }
        return this.size - this.dataLoc;
    }

    public void setDataBuffer(ByteBuffer byteBuffer) {
        if (byteBuffer != null) {
            this.size = byteBuffer.limit();
        }
        this.dataA = null;
        this.dataB = byteBuffer;
    }

    public void setDataBuffer(byte[] bArr) {
        if (bArr != null) {
            this.size = bArr.length;
        }
        this.dataA = bArr;
        this.dataB = null;
    }

    public int addData(byte[] bArr, int i, int i2) {
        int i3;
        int i4;
        byte[] bArr2 = this.dataA;
        if (bArr2 != null) {
            int i5 = this.dataLoc;
            if (i2 > 0) {
                try {
                    System.arraycopy(bArr, i, bArr2, i5, i2);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            this.dataLoc += i2;
            i3 = this.size;
            i4 = this.dataLoc;
        } else {
            ByteBuffer byteBuffer = this.dataB;
            if (byteBuffer == null) {
                return 0;
            }
            try {
                byteBuffer.put(bArr, i, i2);
                this.dataLoc += i2;
            } catch (Exception e2) {
                e2.printStackTrace();
            }
            i3 = this.size;
            i4 = this.dataLoc;
        }
        return i3 - i4;
    }

    public int getType() {
        return this.type;
    }

    public void setType(int i) {
        this.type = i;
    }

    public int getSrc() {
        return this.src;
    }

    public void setSrc(int i) {
        this.src = i;
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("{AMFPacket:");
        stringBuffer.append(" size: " + this.size + ", ");
        stringBuffer.append(" type: " + this.type + ", ");
        stringBuffer.append(" src: " + this.src + ", ");
        stringBuffer.append(" seq: " + this.seq + ", ");
        stringBuffer.append(" absTimecode: " + this.absTimecode + ", ");
        stringBuffer.append(" timecode: " + this.timecode + "}");
        return stringBuffer.toString();
    }

    public long getTimecode() {
        return this.timecode;
    }

    public void setTimecodes(long j, long j2) {
        this.timecode = j;
        this.absTimecode = j2;
    }

    public void setTimecode(long j) {
        this.timecode = j;
    }

    public long getAbsTimecode() {
        return this.absTimecode;
    }

    public void setAbsTimecode(long j) {
        this.absTimecode = j;
    }

    public long getSeq() {
        return this.seq;
    }

    public void setSeq(long j) {
        this.seq = j;
    }

    public boolean isAudio() {
        return this.type == 8;
    }

    public boolean isVideo() {
        return this.type == 9;
    }

    public ByteBuffer getDataBuffer() {
        byte[] bArr = this.dataA;
        if (bArr != null) {
            return ByteBuffer.wrap(bArr);
        }
        ByteBuffer byteBuffer = this.dataB;
        if (byteBuffer != null) {
            return byteBuffer;
        }
        return null;
    }

    public byte[] getData() {
        byte[] bArr = this.dataA;
        if (bArr != null) {
            return bArr;
        }
        ByteBuffer byteBuffer = this.dataB;
        byte[] bArr2 = null;
        if (byteBuffer == null) {
            return null;
        }
        try {
            bArr2 = byteBuffer.array();
        } catch (Exception unused) {
        }
        if (bArr2 != null) {
            return bArr2;
        }
        byte[] bArr3 = new byte[this.dataB.limit()];
        int position = this.dataB.position();
        this.dataB.position(0);
        this.dataB.get(bArr3);
        this.dataB.position(position);
        return bArr3;
    }

    public int getFirstByte() {
        byte b;
        if (this.size > 0) {
            byte[] bArr = this.dataA;
            if (bArr != null) {
                b = bArr[0];
            } else {
                ByteBuffer byteBuffer = this.dataB;
                if (byteBuffer != null) {
                    b = byteBuffer.get(0);
                }
            }
            return b & 255;
        }
        return 0;
    }

    public int getSecondByte() {
        byte b;
        if (this.size <= 1) {
            return 0;
        }
        byte[] bArr = this.dataA;
        if (bArr != null) {
            b = bArr[1];
        } else {
            ByteBuffer byteBuffer = this.dataB;
            if (byteBuffer == null) {
                return 0;
            }
            b = byteBuffer.get(1);
        }
        return b & 255;
    }

    public static int calcTotalPacketSize(int i, int i2, int i3, int i4, boolean z) {
        int i5 = 2;
        int i6 = 0;
        int i7 = 4;
        int i8 = i2 + (i4 > 255 ? 2 : i4 >= 64 ? 1 : 0) + (z ? 4 : 0);
        if (i4 <= 255) {
            i5 = i4 >= 64 ? 1 : 0;
        }
        int i9 = i5 + 1;
        if (!z) {
            i7 = 0;
        }
        int i10 = i9 + i7;
        int i11 = i / i3;
        if (i % i3 > 0) {
            i6 = 1;
        }
        return i8 + (i10 * ((i11 + i6) - 1)) + i;
    }

    public int addDataEx(byte[] bArr, int i, int i2, int i3) {
        byte[] bArr2 = this.dataA;
        if (bArr2 == null) {
            return 0;
        }
        int i4 = this.dataLoc;
        if (i3 > 0) {
            try {
                System.arraycopy(bArr, i, bArr2, i2, i3);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        this.dataLoc += i3;
        return this.size - this.dataLoc;
    }
}

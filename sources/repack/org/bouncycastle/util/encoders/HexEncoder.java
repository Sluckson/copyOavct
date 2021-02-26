package repack.org.bouncycastle.util.encoders;

import com.lowagie.text.pdf.ByteBuffer;
import java.io.IOException;
import java.io.OutputStream;

public class HexEncoder implements Encoder {
    protected final byte[] decodingTable = new byte[128];
    protected final byte[] encodingTable = {ByteBuffer.ZERO, 49, 50, 51, 52, 53, 54, 55, 56, 57, 97, 98, 99, 100, 101, 102};

    private boolean ignore(char c) {
        return c == 10 || c == 13 || c == 9 || c == ' ';
    }

    /* access modifiers changed from: protected */
    public void initialiseDecodingTable() {
        int i = 0;
        while (true) {
            byte[] bArr = this.encodingTable;
            if (i >= bArr.length) {
                byte[] bArr2 = this.decodingTable;
                bArr2[65] = bArr2[97];
                bArr2[66] = bArr2[98];
                bArr2[67] = bArr2[99];
                bArr2[68] = bArr2[100];
                bArr2[69] = bArr2[101];
                bArr2[70] = bArr2[102];
                return;
            }
            this.decodingTable[bArr[i]] = (byte) i;
            i++;
        }
    }

    public HexEncoder() {
        initialiseDecodingTable();
    }

    public int encode(byte[] bArr, int i, int i2, OutputStream outputStream) throws IOException {
        for (int i3 = i; i3 < i + i2; i3++) {
            byte b = bArr[i3] & 255;
            outputStream.write(this.encodingTable[b >>> 4]);
            outputStream.write(this.encodingTable[b & 15]);
        }
        return i2 * 2;
    }

    public int decode(byte[] bArr, int i, int i2, OutputStream outputStream) throws IOException {
        int i3 = i2 + i;
        while (i3 > i && ignore((char) bArr[i3 - 1])) {
            i3--;
        }
        int i4 = 0;
        while (i < i3) {
            while (i < i3 && ignore((char) bArr[i])) {
                i++;
            }
            int i5 = i + 1;
            byte b = this.decodingTable[bArr[i]];
            while (i5 < i3 && ignore((char) bArr[i5])) {
                i5++;
            }
            outputStream.write((b << 4) | this.decodingTable[bArr[i5]]);
            i4++;
            i = i5 + 1;
        }
        return i4;
    }

    public int decode(String str, OutputStream outputStream) throws IOException {
        int length = str.length();
        while (length > 0 && ignore(str.charAt(length - 1))) {
            length--;
        }
        int i = 0;
        int i2 = 0;
        while (i < length) {
            while (i < length && ignore(str.charAt(i))) {
                i++;
            }
            int i3 = i + 1;
            byte b = this.decodingTable[str.charAt(i)];
            while (i3 < length && ignore(str.charAt(i3))) {
                i3++;
            }
            outputStream.write((b << 4) | this.decodingTable[str.charAt(i3)]);
            i2++;
            i = i3 + 1;
        }
        return i2;
    }
}

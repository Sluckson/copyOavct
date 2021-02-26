package org.codehaus.jackson.impl;

import java.io.ByteArrayInputStream;
import java.io.CharConversionException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import org.codehaus.jackson.JsonEncoding;
import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.JsonParser;
import org.codehaus.jackson.ObjectCodec;
import org.codehaus.jackson.format.InputAccessor;
import org.codehaus.jackson.format.MatchStrength;
import org.codehaus.jackson.p063io.IOContext;
import org.codehaus.jackson.p063io.MergedStream;
import org.codehaus.jackson.p063io.UTF32Reader;
import org.codehaus.jackson.sym.BytesToNameCanonicalizer;
import org.codehaus.jackson.sym.CharsToNameCanonicalizer;

public final class ByteSourceBootstrapper {
    static final byte UTF8_BOM_1 = -17;
    static final byte UTF8_BOM_2 = -69;
    static final byte UTF8_BOM_3 = -65;
    protected boolean _bigEndian = true;
    private final boolean _bufferRecyclable;
    protected int _bytesPerChar = 0;
    final IOContext _context;
    final InputStream _in;
    final byte[] _inputBuffer;
    private int _inputEnd;
    protected int _inputProcessed;
    private int _inputPtr;

    public ByteSourceBootstrapper(IOContext iOContext, InputStream inputStream) {
        this._context = iOContext;
        this._in = inputStream;
        this._inputBuffer = iOContext.allocReadIOBuffer();
        this._inputPtr = 0;
        this._inputEnd = 0;
        this._inputProcessed = 0;
        this._bufferRecyclable = true;
    }

    public ByteSourceBootstrapper(IOContext iOContext, byte[] bArr, int i, int i2) {
        this._context = iOContext;
        this._in = null;
        this._inputBuffer = bArr;
        this._inputPtr = i;
        this._inputEnd = i2 + i;
        this._inputProcessed = -i;
        this._bufferRecyclable = false;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:11:0x005c, code lost:
        if (checkUTF16((r1[r5 + 1] & 255) | ((r1[r5] & 255) << 8)) != false) goto L_0x005e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:7:0x003f, code lost:
        if (checkUTF16(r1 >>> 16) != false) goto L_0x005e;
     */
    /* JADX WARNING: Removed duplicated region for block: B:14:0x0061  */
    /* JADX WARNING: Removed duplicated region for block: B:15:0x0064  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public org.codehaus.jackson.JsonEncoding detectEncoding() throws java.io.IOException, org.codehaus.jackson.JsonParseException {
        /*
            r8 = this;
            r0 = 4
            boolean r1 = r8.ensureLoaded(r0)
            r2 = 2
            r3 = 1
            r4 = 0
            if (r1 == 0) goto L_0x0042
            byte[] r1 = r8._inputBuffer
            int r5 = r8._inputPtr
            byte r6 = r1[r5]
            int r6 = r6 << 24
            int r7 = r5 + 1
            byte r7 = r1[r7]
            r7 = r7 & 255(0xff, float:3.57E-43)
            int r7 = r7 << 16
            r6 = r6 | r7
            int r7 = r5 + 2
            byte r7 = r1[r7]
            r7 = r7 & 255(0xff, float:3.57E-43)
            int r7 = r7 << 8
            r6 = r6 | r7
            int r5 = r5 + 3
            byte r1 = r1[r5]
            r1 = r1 & 255(0xff, float:3.57E-43)
            r1 = r1 | r6
            boolean r5 = r8.handleBOM(r1)
            if (r5 == 0) goto L_0x0032
            goto L_0x005e
        L_0x0032:
            boolean r5 = r8.checkUTF32(r1)
            if (r5 == 0) goto L_0x0039
            goto L_0x005e
        L_0x0039:
            int r1 = r1 >>> 16
            boolean r1 = r8.checkUTF16(r1)
            if (r1 == 0) goto L_0x005f
            goto L_0x005e
        L_0x0042:
            boolean r1 = r8.ensureLoaded(r2)
            if (r1 == 0) goto L_0x005f
            byte[] r1 = r8._inputBuffer
            int r5 = r8._inputPtr
            byte r6 = r1[r5]
            r6 = r6 & 255(0xff, float:3.57E-43)
            int r6 = r6 << 8
            int r5 = r5 + r3
            byte r1 = r1[r5]
            r1 = r1 & 255(0xff, float:3.57E-43)
            r1 = r1 | r6
            boolean r1 = r8.checkUTF16(r1)
            if (r1 == 0) goto L_0x005f
        L_0x005e:
            r4 = 1
        L_0x005f:
            if (r4 != 0) goto L_0x0064
            org.codehaus.jackson.JsonEncoding r0 = org.codehaus.jackson.JsonEncoding.UTF8
            goto L_0x008a
        L_0x0064:
            int r1 = r8._bytesPerChar
            if (r1 == r3) goto L_0x0088
            if (r1 == r2) goto L_0x007e
            if (r1 != r0) goto L_0x0076
            boolean r0 = r8._bigEndian
            if (r0 == 0) goto L_0x0073
            org.codehaus.jackson.JsonEncoding r0 = org.codehaus.jackson.JsonEncoding.UTF32_BE
            goto L_0x008a
        L_0x0073:
            org.codehaus.jackson.JsonEncoding r0 = org.codehaus.jackson.JsonEncoding.UTF32_LE
            goto L_0x008a
        L_0x0076:
            java.lang.RuntimeException r0 = new java.lang.RuntimeException
            java.lang.String r1 = "Internal error"
            r0.<init>(r1)
            throw r0
        L_0x007e:
            boolean r0 = r8._bigEndian
            if (r0 == 0) goto L_0x0085
            org.codehaus.jackson.JsonEncoding r0 = org.codehaus.jackson.JsonEncoding.UTF16_BE
            goto L_0x008a
        L_0x0085:
            org.codehaus.jackson.JsonEncoding r0 = org.codehaus.jackson.JsonEncoding.UTF16_LE
            goto L_0x008a
        L_0x0088:
            org.codehaus.jackson.JsonEncoding r0 = org.codehaus.jackson.JsonEncoding.UTF8
        L_0x008a:
            org.codehaus.jackson.io.IOContext r1 = r8._context
            r1.setEncoding(r0)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: org.codehaus.jackson.impl.ByteSourceBootstrapper.detectEncoding():org.codehaus.jackson.JsonEncoding");
    }

    /* renamed from: org.codehaus.jackson.impl.ByteSourceBootstrapper$1 */
    static /* synthetic */ class C49051 {
        static final /* synthetic */ int[] $SwitchMap$org$codehaus$jackson$JsonEncoding = new int[JsonEncoding.values().length];

        /* JADX WARNING: Can't wrap try/catch for region: R(12:0|1|2|3|4|5|6|7|8|9|10|12) */
        /* JADX WARNING: Code restructure failed: missing block: B:13:?, code lost:
            return;
         */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0014 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001f */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x002a */
        /* JADX WARNING: Missing exception handler attribute for start block: B:9:0x0035 */
        static {
            /*
                org.codehaus.jackson.JsonEncoding[] r0 = org.codehaus.jackson.JsonEncoding.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                $SwitchMap$org$codehaus$jackson$JsonEncoding = r0
                int[] r0 = $SwitchMap$org$codehaus$jackson$JsonEncoding     // Catch:{ NoSuchFieldError -> 0x0014 }
                org.codehaus.jackson.JsonEncoding r1 = org.codehaus.jackson.JsonEncoding.UTF32_BE     // Catch:{ NoSuchFieldError -> 0x0014 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0014 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0014 }
            L_0x0014:
                int[] r0 = $SwitchMap$org$codehaus$jackson$JsonEncoding     // Catch:{ NoSuchFieldError -> 0x001f }
                org.codehaus.jackson.JsonEncoding r1 = org.codehaus.jackson.JsonEncoding.UTF32_LE     // Catch:{ NoSuchFieldError -> 0x001f }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001f }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001f }
            L_0x001f:
                int[] r0 = $SwitchMap$org$codehaus$jackson$JsonEncoding     // Catch:{ NoSuchFieldError -> 0x002a }
                org.codehaus.jackson.JsonEncoding r1 = org.codehaus.jackson.JsonEncoding.UTF16_BE     // Catch:{ NoSuchFieldError -> 0x002a }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x002a }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x002a }
            L_0x002a:
                int[] r0 = $SwitchMap$org$codehaus$jackson$JsonEncoding     // Catch:{ NoSuchFieldError -> 0x0035 }
                org.codehaus.jackson.JsonEncoding r1 = org.codehaus.jackson.JsonEncoding.UTF16_LE     // Catch:{ NoSuchFieldError -> 0x0035 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0035 }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0035 }
            L_0x0035:
                int[] r0 = $SwitchMap$org$codehaus$jackson$JsonEncoding     // Catch:{ NoSuchFieldError -> 0x0040 }
                org.codehaus.jackson.JsonEncoding r1 = org.codehaus.jackson.JsonEncoding.UTF8     // Catch:{ NoSuchFieldError -> 0x0040 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0040 }
                r2 = 5
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0040 }
            L_0x0040:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: org.codehaus.jackson.impl.ByteSourceBootstrapper.C49051.<clinit>():void");
        }
    }

    public Reader constructReader() throws IOException {
        JsonEncoding encoding = this._context.getEncoding();
        int i = C49051.$SwitchMap$org$codehaus$jackson$JsonEncoding[encoding.ordinal()];
        if (i == 1 || i == 2) {
            IOContext iOContext = this._context;
            return new UTF32Reader(iOContext, this._in, this._inputBuffer, this._inputPtr, this._inputEnd, iOContext.getEncoding().isBigEndian());
        } else if (i == 3 || i == 4 || i == 5) {
            InputStream inputStream = this._in;
            if (inputStream == null) {
                inputStream = new ByteArrayInputStream(this._inputBuffer, this._inputPtr, this._inputEnd);
            } else {
                int i2 = this._inputPtr;
                int i3 = this._inputEnd;
                if (i2 < i3) {
                    inputStream = new MergedStream(this._context, inputStream, this._inputBuffer, i2, i3);
                }
            }
            return new InputStreamReader(inputStream, encoding.getJavaName());
        } else {
            throw new RuntimeException("Internal error");
        }
    }

    public JsonParser constructParser(int i, ObjectCodec objectCodec, BytesToNameCanonicalizer bytesToNameCanonicalizer, CharsToNameCanonicalizer charsToNameCanonicalizer) throws IOException, JsonParseException {
        int i2 = i;
        JsonEncoding detectEncoding = detectEncoding();
        boolean enabledIn = JsonParser.Feature.CANONICALIZE_FIELD_NAMES.enabledIn(i);
        boolean enabledIn2 = JsonParser.Feature.INTERN_FIELD_NAMES.enabledIn(i);
        if (detectEncoding != JsonEncoding.UTF8 || !enabledIn) {
            return new ReaderBasedParser(this._context, i, constructReader(), objectCodec, charsToNameCanonicalizer.makeChild(enabledIn, enabledIn2));
        }
        BytesToNameCanonicalizer bytesToNameCanonicalizer2 = bytesToNameCanonicalizer;
        return new Utf8StreamParser(this._context, i, this._in, objectCodec, bytesToNameCanonicalizer.makeChild(enabledIn, enabledIn2), this._inputBuffer, this._inputPtr, this._inputEnd, this._bufferRecyclable);
    }

    public static MatchStrength hasJSONFormat(InputAccessor inputAccessor) throws IOException {
        if (!inputAccessor.hasMoreBytes()) {
            return MatchStrength.INCONCLUSIVE;
        }
        byte nextByte = inputAccessor.nextByte();
        if (nextByte == -17) {
            if (!inputAccessor.hasMoreBytes()) {
                return MatchStrength.INCONCLUSIVE;
            }
            if (inputAccessor.nextByte() != -69) {
                return MatchStrength.NO_MATCH;
            }
            if (!inputAccessor.hasMoreBytes()) {
                return MatchStrength.INCONCLUSIVE;
            }
            if (inputAccessor.nextByte() != -65) {
                return MatchStrength.NO_MATCH;
            }
            if (!inputAccessor.hasMoreBytes()) {
                return MatchStrength.INCONCLUSIVE;
            }
            nextByte = inputAccessor.nextByte();
        }
        int skipSpace = skipSpace(inputAccessor, nextByte);
        if (skipSpace < 0) {
            return MatchStrength.INCONCLUSIVE;
        }
        if (skipSpace == 123) {
            int skipSpace2 = skipSpace(inputAccessor);
            if (skipSpace2 < 0) {
                return MatchStrength.INCONCLUSIVE;
            }
            if (skipSpace2 == 34 || skipSpace2 == 125) {
                return MatchStrength.SOLID_MATCH;
            }
            return MatchStrength.NO_MATCH;
        } else if (skipSpace == 91) {
            int skipSpace3 = skipSpace(inputAccessor);
            if (skipSpace3 < 0) {
                return MatchStrength.INCONCLUSIVE;
            }
            if (skipSpace3 == 93 || skipSpace3 == 91) {
                return MatchStrength.SOLID_MATCH;
            }
            return MatchStrength.SOLID_MATCH;
        } else {
            MatchStrength matchStrength = MatchStrength.WEAK_MATCH;
            if (skipSpace == 34) {
                return matchStrength;
            }
            if (skipSpace <= 57 && skipSpace >= 48) {
                return matchStrength;
            }
            if (skipSpace == 45) {
                int skipSpace4 = skipSpace(inputAccessor);
                if (skipSpace4 < 0) {
                    return MatchStrength.INCONCLUSIVE;
                }
                return (skipSpace4 > 57 || skipSpace4 < 48) ? MatchStrength.NO_MATCH : matchStrength;
            } else if (skipSpace == 110) {
                return tryMatch(inputAccessor, "ull", matchStrength);
            } else {
                if (skipSpace == 116) {
                    return tryMatch(inputAccessor, "rue", matchStrength);
                }
                if (skipSpace == 102) {
                    return tryMatch(inputAccessor, "alse", matchStrength);
                }
                return MatchStrength.NO_MATCH;
            }
        }
    }

    private static final MatchStrength tryMatch(InputAccessor inputAccessor, String str, MatchStrength matchStrength) throws IOException {
        int length = str.length();
        for (int i = 0; i < length; i++) {
            if (!inputAccessor.hasMoreBytes()) {
                return MatchStrength.INCONCLUSIVE;
            }
            if (inputAccessor.nextByte() != str.charAt(i)) {
                return MatchStrength.NO_MATCH;
            }
        }
        return matchStrength;
    }

    private static final int skipSpace(InputAccessor inputAccessor) throws IOException {
        if (!inputAccessor.hasMoreBytes()) {
            return -1;
        }
        return skipSpace(inputAccessor, inputAccessor.nextByte());
    }

    private static final int skipSpace(InputAccessor inputAccessor, byte b) throws IOException {
        while (true) {
            byte b2 = b & 255;
            if (b2 != 32 && b2 != 13 && b2 != 10 && b2 != 9) {
                return b2;
            }
            if (!inputAccessor.hasMoreBytes()) {
                return -1;
            }
            b = inputAccessor.nextByte();
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:14:0x003a  */
    /* JADX WARNING: Removed duplicated region for block: B:16:0x0044  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private boolean handleBOM(int r7) throws java.io.IOException {
        /*
            r6 = this;
            r0 = -16842752(0xfffffffffeff0000, float:-1.6947657E38)
            r1 = 65534(0xfffe, float:9.1833E-41)
            r2 = 65279(0xfeff, float:9.1475E-41)
            r3 = 0
            r4 = 1
            if (r7 == r0) goto L_0x0030
            r0 = -131072(0xfffffffffffe0000, float:NaN)
            r5 = 4
            if (r7 == r0) goto L_0x0026
            if (r7 == r2) goto L_0x001c
            if (r7 == r1) goto L_0x0016
            goto L_0x0035
        L_0x0016:
            java.lang.String r0 = "2143"
            r6.reportWeirdUCS4(r0)
            goto L_0x0030
        L_0x001c:
            r6._bigEndian = r4
            int r7 = r6._inputPtr
            int r7 = r7 + r5
            r6._inputPtr = r7
            r6._bytesPerChar = r5
            return r4
        L_0x0026:
            int r7 = r6._inputPtr
            int r7 = r7 + r5
            r6._inputPtr = r7
            r6._bytesPerChar = r5
            r6._bigEndian = r3
            return r4
        L_0x0030:
            java.lang.String r0 = "3412"
            r6.reportWeirdUCS4(r0)
        L_0x0035:
            int r0 = r7 >>> 16
            r5 = 2
            if (r0 != r2) goto L_0x0044
            int r7 = r6._inputPtr
            int r7 = r7 + r5
            r6._inputPtr = r7
            r6._bytesPerChar = r5
            r6._bigEndian = r4
            return r4
        L_0x0044:
            if (r0 != r1) goto L_0x0050
            int r7 = r6._inputPtr
            int r7 = r7 + r5
            r6._inputPtr = r7
            r6._bytesPerChar = r5
            r6._bigEndian = r3
            return r4
        L_0x0050:
            int r7 = r7 >>> 8
            r0 = 15711167(0xefbbbf, float:2.2016034E-38)
            if (r7 != r0) goto L_0x0062
            int r7 = r6._inputPtr
            int r7 = r7 + 3
            r6._inputPtr = r7
            r6._bytesPerChar = r4
            r6._bigEndian = r4
            return r4
        L_0x0062:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: org.codehaus.jackson.impl.ByteSourceBootstrapper.handleBOM(int):boolean");
    }

    private boolean checkUTF32(int i) throws IOException {
        if ((i >> 8) == 0) {
            this._bigEndian = true;
        } else if ((16777215 & i) == 0) {
            this._bigEndian = false;
        } else if ((-16711681 & i) == 0) {
            reportWeirdUCS4("3412");
        } else if ((i & -65281) != 0) {
            return false;
        } else {
            reportWeirdUCS4("2143");
        }
        this._bytesPerChar = 4;
        return true;
    }

    private boolean checkUTF16(int i) {
        if ((65280 & i) == 0) {
            this._bigEndian = true;
        } else if ((i & 255) != 0) {
            return false;
        } else {
            this._bigEndian = false;
        }
        this._bytesPerChar = 2;
        return true;
    }

    private void reportWeirdUCS4(String str) throws IOException {
        throw new CharConversionException("Unsupported UCS-4 endianness (" + str + ") detected");
    }

    /* access modifiers changed from: protected */
    public boolean ensureLoaded(int i) throws IOException {
        int i2;
        int i3 = this._inputEnd - this._inputPtr;
        while (i3 < i) {
            InputStream inputStream = this._in;
            if (inputStream == null) {
                i2 = -1;
            } else {
                byte[] bArr = this._inputBuffer;
                int i4 = this._inputEnd;
                i2 = inputStream.read(bArr, i4, bArr.length - i4);
            }
            if (i2 < 1) {
                return false;
            }
            this._inputEnd += i2;
            i3 += i2;
        }
        return true;
    }
}

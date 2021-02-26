package repack.org.bouncycastle.asn1;

import java.io.ByteArrayInputStream;
import java.io.EOFException;
import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;
import repack.org.bouncycastle.util.p072io.Streams;

public class ASN1InputStream extends FilterInputStream implements DERTags {
    private final boolean lazyEvaluate;
    private final int limit;

    static int findLimit(InputStream inputStream) {
        if (inputStream instanceof LimitedInputStream) {
            return ((LimitedInputStream) inputStream).getRemaining();
        }
        if (inputStream instanceof ByteArrayInputStream) {
            return ((ByteArrayInputStream) inputStream).available();
        }
        return Integer.MAX_VALUE;
    }

    public ASN1InputStream(InputStream inputStream) {
        this(inputStream, findLimit(inputStream));
    }

    public ASN1InputStream(byte[] bArr) {
        this((InputStream) new ByteArrayInputStream(bArr), bArr.length);
    }

    public ASN1InputStream(byte[] bArr, boolean z) {
        this(new ByteArrayInputStream(bArr), bArr.length, z);
    }

    public ASN1InputStream(InputStream inputStream, int i) {
        this(inputStream, i, false);
    }

    public ASN1InputStream(InputStream inputStream, int i, boolean z) {
        super(inputStream);
        this.limit = i;
        this.lazyEvaluate = z;
    }

    /* access modifiers changed from: protected */
    public int readLength() throws IOException {
        return readLength(this, this.limit);
    }

    /* access modifiers changed from: protected */
    public void readFully(byte[] bArr) throws IOException {
        if (Streams.readFully(this, bArr) != bArr.length) {
            throw new EOFException("EOF encountered in middle of object");
        }
    }

    /* access modifiers changed from: protected */
    public DERObject buildObject(int i, int i2, int i3) throws IOException {
        boolean z = (i & 32) != 0;
        DefiniteLengthInputStream definiteLengthInputStream = new DefiniteLengthInputStream(this, i3);
        if ((i & 64) != 0) {
            return new DERApplicationSpecific(z, i2, definiteLengthInputStream.toByteArray());
        }
        if ((i & 128) != 0) {
            return new ASN1StreamParser((InputStream) definiteLengthInputStream).readTaggedObject(z, i2);
        }
        if (!z) {
            return createPrimitiveDERObject(i2, definiteLengthInputStream.toByteArray());
        }
        if (i2 == 4) {
            return new BERConstructedOctetString(buildDEREncodableVector(definiteLengthInputStream).f5828v);
        }
        if (i2 == 8) {
            return new DERExternal(buildDEREncodableVector(definiteLengthInputStream));
        }
        if (i2 != 16) {
            if (i2 != 17) {
                return new DERUnknownTag(true, i2, definiteLengthInputStream.toByteArray());
            }
            return DERFactory.createSet(buildDEREncodableVector(definiteLengthInputStream), false);
        } else if (this.lazyEvaluate) {
            return new LazyDERSequence(definiteLengthInputStream.toByteArray());
        } else {
            return DERFactory.createSequence(buildDEREncodableVector(definiteLengthInputStream));
        }
    }

    /* access modifiers changed from: package-private */
    public ASN1EncodableVector buildEncodableVector() throws IOException {
        ASN1EncodableVector aSN1EncodableVector = new ASN1EncodableVector();
        while (true) {
            DERObject readObject = readObject();
            if (readObject == null) {
                return aSN1EncodableVector;
            }
            aSN1EncodableVector.add(readObject);
        }
    }

    /* access modifiers changed from: package-private */
    public ASN1EncodableVector buildDEREncodableVector(DefiniteLengthInputStream definiteLengthInputStream) throws IOException {
        return new ASN1InputStream((InputStream) definiteLengthInputStream).buildEncodableVector();
    }

    public DERObject readObject() throws IOException {
        int read = read();
        if (read > 0) {
            int readTagNumber = readTagNumber(this, read);
            boolean z = (read & 32) != 0;
            int readLength = readLength();
            if (readLength >= 0) {
                try {
                    return buildObject(read, readTagNumber, readLength);
                } catch (IllegalArgumentException e) {
                    throw new ASN1Exception("corrupted stream detected", e);
                }
            } else if (z) {
                ASN1StreamParser aSN1StreamParser = new ASN1StreamParser(new IndefiniteLengthInputStream(this, this.limit), this.limit);
                if ((read & 64) != 0) {
                    return new BERApplicationSpecificParser(readTagNumber, aSN1StreamParser).getLoadedObject();
                }
                if ((read & 128) != 0) {
                    return new BERTaggedObjectParser(true, readTagNumber, aSN1StreamParser).getLoadedObject();
                }
                if (readTagNumber == 4) {
                    return new BEROctetStringParser(aSN1StreamParser).getLoadedObject();
                }
                if (readTagNumber == 8) {
                    return new DERExternalParser(aSN1StreamParser).getLoadedObject();
                }
                if (readTagNumber == 16) {
                    return new BERSequenceParser(aSN1StreamParser).getLoadedObject();
                }
                if (readTagNumber == 17) {
                    return new BERSetParser(aSN1StreamParser).getLoadedObject();
                }
                throw new IOException("unknown BER object encountered");
            } else {
                throw new IOException("indefinite length primitive encoding encountered");
            }
        } else if (read != 0) {
            return null;
        } else {
            throw new IOException("unexpected end-of-contents marker");
        }
    }

    static int readTagNumber(InputStream inputStream, int i) throws IOException {
        int i2 = i & 31;
        if (i2 != 31) {
            return i2;
        }
        int i3 = 0;
        int read = inputStream.read();
        if ((read & 127) != 0) {
            while (read >= 0 && (read & 128) != 0) {
                i3 = (i3 | (read & 127)) << 7;
                read = inputStream.read();
            }
            if (read >= 0) {
                return i3 | (read & 127);
            }
            throw new EOFException("EOF found inside tag value.");
        }
        throw new IOException("corrupted stream - invalid high tag number found");
    }

    static int readLength(InputStream inputStream, int i) throws IOException {
        int read = inputStream.read();
        if (read < 0) {
            throw new EOFException("EOF found when length expected");
        } else if (read == 128) {
            return -1;
        } else {
            if (read <= 127) {
                return read;
            }
            int i2 = read & 127;
            if (i2 <= 4) {
                int i3 = 0;
                int i4 = 0;
                while (i3 < i2) {
                    int read2 = inputStream.read();
                    if (read2 >= 0) {
                        i4 = (i4 << 8) + read2;
                        i3++;
                    } else {
                        throw new EOFException("EOF found reading length");
                    }
                }
                if (i4 < 0) {
                    throw new IOException("corrupted stream - negative length found");
                } else if (i4 < i) {
                    return i4;
                } else {
                    throw new IOException("corrupted stream - out of bounds length found");
                }
            } else {
                throw new IOException("DER length more than 4 bytes: " + i2);
            }
        }
    }

    static DERObject createPrimitiveDERObject(int i, byte[] bArr) {
        switch (i) {
            case 1:
                return new ASN1Boolean(bArr);
            case 2:
                return new ASN1Integer(bArr);
            case 3:
                return DERBitString.fromOctetString(bArr);
            case 4:
                return new DEROctetString(bArr);
            case 5:
                return DERNull.INSTANCE;
            case 6:
                return new ASN1ObjectIdentifier(bArr);
            case 10:
                return new ASN1Enumerated(bArr);
            case 12:
                return new DERUTF8String(bArr);
            case 18:
                return new DERNumericString(bArr);
            case 19:
                return new DERPrintableString(bArr);
            case 20:
                return new DERT61String(bArr);
            case 22:
                return new DERIA5String(bArr);
            case 23:
                return new ASN1UTCTime(bArr);
            case 24:
                return new ASN1GeneralizedTime(bArr);
            case 26:
                return new DERVisibleString(bArr);
            case 27:
                return new DERGeneralString(bArr);
            case 28:
                return new DERUniversalString(bArr);
            case 30:
                return new DERBMPString(bArr);
            default:
                return new DERUnknownTag(false, i, bArr);
        }
    }
}

package p011io.grpc;

import com.google.common.p013io.BaseEncoding;
import java.nio.charset.Charset;
import p011io.grpc.Metadata;

@Internal
/* renamed from: io.grpc.InternalMetadata */
public final class InternalMetadata {
    @Internal
    public static final BaseEncoding BASE64_ENCODING_OMIT_PADDING = Metadata.BASE64_ENCODING_OMIT_PADDING;
    @Internal
    public static final Charset US_ASCII = Charset.forName("US-ASCII");

    @Internal
    /* renamed from: io.grpc.InternalMetadata$TrustedAsciiMarshaller */
    public interface TrustedAsciiMarshaller<T> extends Metadata.TrustedAsciiMarshaller<T> {
    }

    @Internal
    public static <T> Metadata.Key<T> keyOf(String str, TrustedAsciiMarshaller<T> trustedAsciiMarshaller) {
        boolean z = false;
        if (str != null && !str.isEmpty() && str.charAt(0) == ':') {
            z = true;
        }
        return Metadata.Key.m4597of(str, z, trustedAsciiMarshaller);
    }

    @Internal
    public static <T> Metadata.Key<T> keyOf(String str, Metadata.AsciiMarshaller<T> asciiMarshaller) {
        boolean z = false;
        if (str != null && !str.isEmpty() && str.charAt(0) == ':') {
            z = true;
        }
        return Metadata.Key.m4596of(str, z, asciiMarshaller);
    }

    @Internal
    public static Metadata newMetadata(byte[]... bArr) {
        return new Metadata(bArr);
    }

    @Internal
    public static Metadata newMetadata(int i, byte[]... bArr) {
        return new Metadata(i, bArr);
    }

    @Internal
    public static byte[][] serialize(Metadata metadata) {
        return metadata.serialize();
    }

    @Internal
    public static int headerCount(Metadata metadata) {
        return metadata.headerCount();
    }
}
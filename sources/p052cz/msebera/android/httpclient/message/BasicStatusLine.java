package p052cz.msebera.android.httpclient.message;

import java.io.Serializable;
import p052cz.msebera.android.httpclient.ProtocolVersion;
import p052cz.msebera.android.httpclient.StatusLine;
import p052cz.msebera.android.httpclient.annotation.Immutable;
import p052cz.msebera.android.httpclient.util.Args;
import p052cz.msebera.android.httpclient.util.CharArrayBuffer;

@Immutable
/* renamed from: cz.msebera.android.httpclient.message.BasicStatusLine */
public class BasicStatusLine implements StatusLine, Cloneable, Serializable {
    private static final long serialVersionUID = -2443303766890459269L;
    private final ProtocolVersion protoVersion;
    private final String reasonPhrase;
    private final int statusCode;

    public BasicStatusLine(ProtocolVersion protocolVersion, int i, String str) {
        this.protoVersion = (ProtocolVersion) Args.notNull(protocolVersion, "Version");
        this.statusCode = Args.notNegative(i, "Status code");
        this.reasonPhrase = str;
    }

    public int getStatusCode() {
        return this.statusCode;
    }

    public ProtocolVersion getProtocolVersion() {
        return this.protoVersion;
    }

    public String getReasonPhrase() {
        return this.reasonPhrase;
    }

    public String toString() {
        return BasicLineFormatter.INSTANCE.formatStatusLine((CharArrayBuffer) null, (StatusLine) this).toString();
    }

    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}

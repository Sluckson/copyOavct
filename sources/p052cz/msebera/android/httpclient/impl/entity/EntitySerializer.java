package p052cz.msebera.android.httpclient.impl.entity;

import java.io.IOException;
import java.io.OutputStream;
import p052cz.msebera.android.httpclient.HttpEntity;
import p052cz.msebera.android.httpclient.HttpException;
import p052cz.msebera.android.httpclient.HttpMessage;
import p052cz.msebera.android.httpclient.annotation.Immutable;
import p052cz.msebera.android.httpclient.entity.ContentLengthStrategy;
import p052cz.msebera.android.httpclient.impl.p053io.ChunkedOutputStream;
import p052cz.msebera.android.httpclient.impl.p053io.ContentLengthOutputStream;
import p052cz.msebera.android.httpclient.impl.p053io.IdentityOutputStream;
import p052cz.msebera.android.httpclient.p054io.SessionOutputBuffer;
import p052cz.msebera.android.httpclient.util.Args;

@Immutable
@Deprecated
/* renamed from: cz.msebera.android.httpclient.impl.entity.EntitySerializer */
public class EntitySerializer {
    private final ContentLengthStrategy lenStrategy;

    public EntitySerializer(ContentLengthStrategy contentLengthStrategy) {
        this.lenStrategy = (ContentLengthStrategy) Args.notNull(contentLengthStrategy, "Content length strategy");
    }

    /* access modifiers changed from: protected */
    public OutputStream doSerialize(SessionOutputBuffer sessionOutputBuffer, HttpMessage httpMessage) throws HttpException, IOException {
        long determineLength = this.lenStrategy.determineLength(httpMessage);
        if (determineLength == -2) {
            return new ChunkedOutputStream(sessionOutputBuffer);
        }
        if (determineLength == -1) {
            return new IdentityOutputStream(sessionOutputBuffer);
        }
        return new ContentLengthOutputStream(sessionOutputBuffer, determineLength);
    }

    public void serialize(SessionOutputBuffer sessionOutputBuffer, HttpMessage httpMessage, HttpEntity httpEntity) throws HttpException, IOException {
        Args.notNull(sessionOutputBuffer, "Session output buffer");
        Args.notNull(httpMessage, "HTTP message");
        Args.notNull(httpEntity, "HTTP entity");
        OutputStream doSerialize = doSerialize(sessionOutputBuffer, httpMessage);
        httpEntity.writeTo(doSerialize);
        doSerialize.close();
    }
}

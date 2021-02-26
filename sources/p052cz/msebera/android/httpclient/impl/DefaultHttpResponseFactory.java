package p052cz.msebera.android.httpclient.impl;

import java.util.Locale;
import p052cz.msebera.android.httpclient.HttpResponse;
import p052cz.msebera.android.httpclient.HttpResponseFactory;
import p052cz.msebera.android.httpclient.ProtocolVersion;
import p052cz.msebera.android.httpclient.ReasonPhraseCatalog;
import p052cz.msebera.android.httpclient.StatusLine;
import p052cz.msebera.android.httpclient.annotation.Immutable;
import p052cz.msebera.android.httpclient.message.BasicHttpResponse;
import p052cz.msebera.android.httpclient.message.BasicStatusLine;
import p052cz.msebera.android.httpclient.protocol.HttpContext;
import p052cz.msebera.android.httpclient.util.Args;

@Immutable
/* renamed from: cz.msebera.android.httpclient.impl.DefaultHttpResponseFactory */
public class DefaultHttpResponseFactory implements HttpResponseFactory {
    public static final DefaultHttpResponseFactory INSTANCE = new DefaultHttpResponseFactory();
    protected final ReasonPhraseCatalog reasonCatalog;

    public DefaultHttpResponseFactory(ReasonPhraseCatalog reasonPhraseCatalog) {
        this.reasonCatalog = (ReasonPhraseCatalog) Args.notNull(reasonPhraseCatalog, "Reason phrase catalog");
    }

    public DefaultHttpResponseFactory() {
        this(EnglishReasonPhraseCatalog.INSTANCE);
    }

    public HttpResponse newHttpResponse(ProtocolVersion protocolVersion, int i, HttpContext httpContext) {
        Args.notNull(protocolVersion, "HTTP version");
        Locale determineLocale = determineLocale(httpContext);
        return new BasicHttpResponse((StatusLine) new BasicStatusLine(protocolVersion, i, this.reasonCatalog.getReason(i, determineLocale)), this.reasonCatalog, determineLocale);
    }

    public HttpResponse newHttpResponse(StatusLine statusLine, HttpContext httpContext) {
        Args.notNull(statusLine, "Status line");
        return new BasicHttpResponse(statusLine, this.reasonCatalog, determineLocale(httpContext));
    }

    /* access modifiers changed from: protected */
    public Locale determineLocale(HttpContext httpContext) {
        return Locale.getDefault();
    }
}

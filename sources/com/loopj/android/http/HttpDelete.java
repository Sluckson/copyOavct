package com.loopj.android.http;

import java.net.URI;
import p052cz.msebera.android.httpclient.client.methods.HttpEntityEnclosingRequestBase;

public final class HttpDelete extends HttpEntityEnclosingRequestBase {
    public static final String METHOD_NAME = "DELETE";

    public String getMethod() {
        return "DELETE";
    }

    public HttpDelete() {
    }

    public HttpDelete(URI uri) {
        setURI(uri);
    }

    public HttpDelete(String str) {
        setURI(URI.create(str));
    }
}

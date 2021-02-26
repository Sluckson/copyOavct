package com.loopj.android.http;

import java.net.URI;
import p052cz.msebera.android.httpclient.client.methods.HttpEntityEnclosingRequestBase;

public final class HttpGet extends HttpEntityEnclosingRequestBase {
    public static final String METHOD_NAME = "GET";

    public String getMethod() {
        return "GET";
    }

    public HttpGet() {
    }

    public HttpGet(URI uri) {
        setURI(uri);
    }

    public HttpGet(String str) {
        setURI(URI.create(str));
    }
}

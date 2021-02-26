package com.loopj.android.http;

import org.xml.sax.helpers.DefaultHandler;
import p052cz.msebera.android.httpclient.Header;

public abstract class SaxAsyncHttpResponseHandler<T extends DefaultHandler> extends AsyncHttpResponseHandler {
    private static final String LOG_TAG = "SaxAsyncHttpRH";
    private T handler = null;

    public abstract void onFailure(int i, Header[] headerArr, T t);

    public abstract void onSuccess(int i, Header[] headerArr, T t);

    public SaxAsyncHttpResponseHandler(T t) {
        if (t != null) {
            this.handler = t;
            return;
        }
        throw new Error("null instance of <T extends DefaultHandler> passed to constructor");
    }

    /* access modifiers changed from: protected */
    /* JADX WARNING: Code restructure failed: missing block: B:19:0x0046, code lost:
        if (r4 != null) goto L_0x0032;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:25:0x0053, code lost:
        if (r4 != null) goto L_0x0032;
     */
    /* JADX WARNING: Removed duplicated region for block: B:30:0x005d A[SYNTHETIC, Splitter:B:30:0x005d] */
    /* JADX WARNING: Unknown top exception splitter block from list: {B:22:0x004b=Splitter:B:22:0x004b, B:16:0x003e=Splitter:B:16:0x003e} */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public byte[] getResponseData(p052cz.msebera.android.httpclient.HttpEntity r7) throws java.io.IOException {
        /*
            r6 = this;
            java.lang.String r0 = "getResponseData exception"
            java.lang.String r1 = "SaxAsyncHttpRH"
            r2 = 0
            if (r7 == 0) goto L_0x0061
            java.io.InputStream r7 = r7.getContent()
            if (r7 == 0) goto L_0x0061
            javax.xml.parsers.SAXParserFactory r3 = javax.xml.parsers.SAXParserFactory.newInstance()     // Catch:{ SAXException -> 0x0049, ParserConfigurationException -> 0x003c, all -> 0x003a }
            javax.xml.parsers.SAXParser r3 = r3.newSAXParser()     // Catch:{ SAXException -> 0x0049, ParserConfigurationException -> 0x003c, all -> 0x003a }
            org.xml.sax.XMLReader r3 = r3.getXMLReader()     // Catch:{ SAXException -> 0x0049, ParserConfigurationException -> 0x003c, all -> 0x003a }
            T r4 = r6.handler     // Catch:{ SAXException -> 0x0049, ParserConfigurationException -> 0x003c, all -> 0x003a }
            r3.setContentHandler(r4)     // Catch:{ SAXException -> 0x0049, ParserConfigurationException -> 0x003c, all -> 0x003a }
            java.io.InputStreamReader r4 = new java.io.InputStreamReader     // Catch:{ SAXException -> 0x0049, ParserConfigurationException -> 0x003c, all -> 0x003a }
            java.lang.String r5 = r6.getCharset()     // Catch:{ SAXException -> 0x0049, ParserConfigurationException -> 0x003c, all -> 0x003a }
            r4.<init>(r7, r5)     // Catch:{ SAXException -> 0x0049, ParserConfigurationException -> 0x003c, all -> 0x003a }
            org.xml.sax.InputSource r5 = new org.xml.sax.InputSource     // Catch:{ SAXException -> 0x0038, ParserConfigurationException -> 0x0036 }
            r5.<init>(r4)     // Catch:{ SAXException -> 0x0038, ParserConfigurationException -> 0x0036 }
            r3.parse(r5)     // Catch:{ SAXException -> 0x0038, ParserConfigurationException -> 0x0036 }
            com.loopj.android.http.AsyncHttpClient.silentCloseInputStream(r7)
        L_0x0032:
            r4.close()     // Catch:{ IOException -> 0x0061 }
            goto L_0x0061
        L_0x0036:
            r3 = move-exception
            goto L_0x003e
        L_0x0038:
            r3 = move-exception
            goto L_0x004b
        L_0x003a:
            r0 = move-exception
            goto L_0x0058
        L_0x003c:
            r3 = move-exception
            r4 = r2
        L_0x003e:
            com.loopj.android.http.LogInterface r5 = com.loopj.android.http.AsyncHttpClient.log     // Catch:{ all -> 0x0056 }
            r5.mo51337e(r1, r0, r3)     // Catch:{ all -> 0x0056 }
            com.loopj.android.http.AsyncHttpClient.silentCloseInputStream(r7)
            if (r4 == 0) goto L_0x0061
            goto L_0x0032
        L_0x0049:
            r3 = move-exception
            r4 = r2
        L_0x004b:
            com.loopj.android.http.LogInterface r5 = com.loopj.android.http.AsyncHttpClient.log     // Catch:{ all -> 0x0056 }
            r5.mo51337e(r1, r0, r3)     // Catch:{ all -> 0x0056 }
            com.loopj.android.http.AsyncHttpClient.silentCloseInputStream(r7)
            if (r4 == 0) goto L_0x0061
            goto L_0x0032
        L_0x0056:
            r0 = move-exception
            r2 = r4
        L_0x0058:
            com.loopj.android.http.AsyncHttpClient.silentCloseInputStream(r7)
            if (r2 == 0) goto L_0x0060
            r2.close()     // Catch:{ IOException -> 0x0060 }
        L_0x0060:
            throw r0
        L_0x0061:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.loopj.android.http.SaxAsyncHttpResponseHandler.getResponseData(cz.msebera.android.httpclient.HttpEntity):byte[]");
    }

    public void onSuccess(int i, Header[] headerArr, byte[] bArr) {
        onSuccess(i, headerArr, this.handler);
    }

    public void onFailure(int i, Header[] headerArr, byte[] bArr, Throwable th) {
        onFailure(i, headerArr, this.handler);
    }
}

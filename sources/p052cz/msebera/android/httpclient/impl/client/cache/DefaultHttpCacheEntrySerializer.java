package p052cz.msebera.android.httpclient.impl.client.cache;

import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import p052cz.msebera.android.httpclient.annotation.Immutable;
import p052cz.msebera.android.httpclient.client.cache.HttpCacheEntry;
import p052cz.msebera.android.httpclient.client.cache.HttpCacheEntrySerializationException;
import p052cz.msebera.android.httpclient.client.cache.HttpCacheEntrySerializer;

@Immutable
/* renamed from: cz.msebera.android.httpclient.impl.client.cache.DefaultHttpCacheEntrySerializer */
public class DefaultHttpCacheEntrySerializer implements HttpCacheEntrySerializer {
    public void writeTo(HttpCacheEntry httpCacheEntry, OutputStream outputStream) throws IOException {
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(outputStream);
        try {
            objectOutputStream.writeObject(httpCacheEntry);
        } finally {
            objectOutputStream.close();
        }
    }

    public HttpCacheEntry readFrom(InputStream inputStream) throws IOException {
        ObjectInputStream objectInputStream = new ObjectInputStream(inputStream);
        try {
            HttpCacheEntry httpCacheEntry = (HttpCacheEntry) objectInputStream.readObject();
            objectInputStream.close();
            return httpCacheEntry;
        } catch (ClassNotFoundException e) {
            throw new HttpCacheEntrySerializationException("Class not found: " + e.getMessage(), e);
        } catch (Throwable th) {
            objectInputStream.close();
            throw th;
        }
    }
}

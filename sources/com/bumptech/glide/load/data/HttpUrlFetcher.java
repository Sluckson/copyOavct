package com.bumptech.glide.load.data;

import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.VisibleForTesting;
import com.bumptech.glide.Priority;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.HttpException;
import com.bumptech.glide.load.data.DataFetcher;
import com.bumptech.glide.load.model.GlideUrl;
import com.bumptech.glide.util.ContentLengthInputStream;
import com.bumptech.glide.util.LogTime;
import com.google.firebase.perf.network.FirebasePerfUrlConnection;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URISyntaxException;
import java.net.URL;
import java.net.URLConnection;
import java.util.Map;

public class HttpUrlFetcher implements DataFetcher<InputStream> {
    @VisibleForTesting
    static final HttpUrlConnectionFactory DEFAULT_CONNECTION_FACTORY = new DefaultHttpUrlConnectionFactory();
    private static final int MAXIMUM_REDIRECTS = 5;
    private static final String TAG = "HttpUrlFetcher";
    private final HttpUrlConnectionFactory connectionFactory;
    private final GlideUrl glideUrl;
    private volatile boolean isCancelled;
    private InputStream stream;
    private final int timeout;
    private HttpURLConnection urlConnection;

    interface HttpUrlConnectionFactory {
        HttpURLConnection build(URL url) throws IOException;
    }

    public HttpUrlFetcher(GlideUrl glideUrl2, int i) {
        this(glideUrl2, i, DEFAULT_CONNECTION_FACTORY);
    }

    @VisibleForTesting
    HttpUrlFetcher(GlideUrl glideUrl2, int i, HttpUrlConnectionFactory httpUrlConnectionFactory) {
        this.glideUrl = glideUrl2;
        this.timeout = i;
        this.connectionFactory = httpUrlConnectionFactory;
    }

    public void loadData(Priority priority, DataFetcher.DataCallback<? super InputStream> dataCallback) {
        long logTime = LogTime.getLogTime();
        try {
            InputStream loadDataWithRedirects = loadDataWithRedirects(this.glideUrl.toURL(), 0, (URL) null, this.glideUrl.getHeaders());
            if (Log.isLoggable(TAG, 2)) {
                Log.v(TAG, "Finished http url fetcher fetch in " + LogTime.getElapsedMillis(logTime) + " ms and loaded " + loadDataWithRedirects);
            }
            dataCallback.onDataReady(loadDataWithRedirects);
        } catch (IOException e) {
            if (Log.isLoggable(TAG, 3)) {
                Log.d(TAG, "Failed to load data for url", e);
            }
            dataCallback.onLoadFailed(e);
        }
    }

    private InputStream loadDataWithRedirects(URL url, int i, URL url2, Map<String, String> map) throws IOException {
        if (i < 5) {
            if (url2 != null) {
                try {
                    if (url.toURI().equals(url2.toURI())) {
                        throw new HttpException("In re-direct loop");
                    }
                } catch (URISyntaxException unused) {
                }
            }
            this.urlConnection = this.connectionFactory.build(url);
            for (Map.Entry next : map.entrySet()) {
                this.urlConnection.addRequestProperty((String) next.getKey(), (String) next.getValue());
            }
            this.urlConnection.setConnectTimeout(this.timeout);
            this.urlConnection.setReadTimeout(this.timeout);
            this.urlConnection.setUseCaches(false);
            this.urlConnection.setDoInput(true);
            this.urlConnection.setInstanceFollowRedirects(false);
            this.urlConnection.connect();
            this.stream = this.urlConnection.getInputStream();
            if (this.isCancelled) {
                return null;
            }
            int responseCode = this.urlConnection.getResponseCode();
            int i2 = responseCode / 100;
            if (i2 == 2) {
                return getStreamForSuccessfulRequest(this.urlConnection);
            }
            if (i2 == 3) {
                String headerField = this.urlConnection.getHeaderField("Location");
                if (!TextUtils.isEmpty(headerField)) {
                    URL url3 = new URL(url, headerField);
                    cleanup();
                    return loadDataWithRedirects(url3, i + 1, url, map);
                }
                throw new HttpException("Received empty or null redirect url");
            } else if (responseCode == -1) {
                throw new HttpException(responseCode);
            } else {
                throw new HttpException(this.urlConnection.getResponseMessage(), responseCode);
            }
        } else {
            throw new HttpException("Too many (> 5) redirects!");
        }
    }

    private InputStream getStreamForSuccessfulRequest(HttpURLConnection httpURLConnection) throws IOException {
        if (TextUtils.isEmpty(httpURLConnection.getContentEncoding())) {
            this.stream = ContentLengthInputStream.obtain(httpURLConnection.getInputStream(), (long) httpURLConnection.getContentLength());
        } else {
            if (Log.isLoggable(TAG, 3)) {
                Log.d(TAG, "Got non empty content encoding: " + httpURLConnection.getContentEncoding());
            }
            this.stream = httpURLConnection.getInputStream();
        }
        return this.stream;
    }

    public void cleanup() {
        InputStream inputStream = this.stream;
        if (inputStream != null) {
            try {
                inputStream.close();
            } catch (IOException unused) {
            }
        }
        HttpURLConnection httpURLConnection = this.urlConnection;
        if (httpURLConnection != null) {
            httpURLConnection.disconnect();
        }
        this.urlConnection = null;
    }

    public void cancel() {
        this.isCancelled = true;
    }

    @NonNull
    public Class<InputStream> getDataClass() {
        return InputStream.class;
    }

    @NonNull
    public DataSource getDataSource() {
        return DataSource.REMOTE;
    }

    private static class DefaultHttpUrlConnectionFactory implements HttpUrlConnectionFactory {
        DefaultHttpUrlConnectionFactory() {
        }

        public HttpURLConnection build(URL url) throws IOException {
            return (HttpURLConnection) ((URLConnection) FirebasePerfUrlConnection.instrument(url.openConnection()));
        }
    }
}

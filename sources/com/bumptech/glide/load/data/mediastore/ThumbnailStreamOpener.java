package com.bumptech.glide.load.data.mediastore;

import android.content.ContentResolver;
import android.database.Cursor;
import android.net.Uri;
import android.text.TextUtils;
import android.util.Log;
import com.bumptech.glide.load.ImageHeaderParser;
import com.bumptech.glide.load.ImageHeaderParserUtils;
import com.bumptech.glide.load.engine.bitmap_recycle.ArrayPool;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

class ThumbnailStreamOpener {
    private static final FileService DEFAULT_SERVICE = new FileService();
    private static final String TAG = "ThumbStreamOpener";
    private final ArrayPool byteArrayPool;
    private final ContentResolver contentResolver;
    private final List<ImageHeaderParser> parsers;
    private final ThumbnailQuery query;
    private final FileService service;

    public ThumbnailStreamOpener(List<ImageHeaderParser> list, ThumbnailQuery thumbnailQuery, ArrayPool arrayPool, ContentResolver contentResolver2) {
        this(list, DEFAULT_SERVICE, thumbnailQuery, arrayPool, contentResolver2);
    }

    public ThumbnailStreamOpener(List<ImageHeaderParser> list, FileService fileService, ThumbnailQuery thumbnailQuery, ArrayPool arrayPool, ContentResolver contentResolver2) {
        this.service = fileService;
        this.query = thumbnailQuery;
        this.byteArrayPool = arrayPool;
        this.contentResolver = contentResolver2;
        this.parsers = list;
    }

    public int getOrientation(Uri uri) {
        InputStream inputStream = null;
        try {
            InputStream openInputStream = this.contentResolver.openInputStream(uri);
            int orientation = ImageHeaderParserUtils.getOrientation(this.parsers, openInputStream, this.byteArrayPool);
            if (openInputStream != null) {
                try {
                    openInputStream.close();
                } catch (IOException unused) {
                }
            }
            return orientation;
        } catch (IOException | NullPointerException e) {
            if (Log.isLoggable(TAG, 3)) {
                Log.d(TAG, "Failed to open uri: " + uri, e);
            }
            if (inputStream == null) {
                return -1;
            }
            try {
                inputStream.close();
                return -1;
            } catch (IOException unused2) {
                return -1;
            }
        } catch (Throwable th) {
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (IOException unused3) {
                }
            }
            throw th;
        }
    }

    public InputStream open(Uri uri) throws FileNotFoundException {
        Cursor query2 = this.query.query(uri);
        if (query2 != null) {
            try {
                if (query2.moveToFirst()) {
                    String string = query2.getString(0);
                    if (TextUtils.isEmpty(string)) {
                        return null;
                    }
                    File file = this.service.get(string);
                    Uri fromFile = (!this.service.exists(file) || this.service.length(file) <= 0) ? null : Uri.fromFile(file);
                    if (query2 != null) {
                        query2.close();
                    }
                    if (fromFile == null) {
                        return null;
                    }
                    try {
                        return this.contentResolver.openInputStream(fromFile);
                    } catch (NullPointerException e) {
                        throw ((FileNotFoundException) new FileNotFoundException("NPE opening uri: " + fromFile).initCause(e));
                    }
                }
            } finally {
                if (query2 != null) {
                    query2.close();
                }
            }
        }
        if (query2 != null) {
            query2.close();
        }
        return null;
    }
}

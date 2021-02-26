package com.iaai.android.old.analytics;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.content.Context;
import android.content.UriMatcher;
import android.database.ContentObserver;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.database.sqlite.SQLiteQueryBuilder;
import android.net.Uri;
import com.iaai.android.old.analytics.AnalyticsContract;
import com.lowagie.text.ElementTags;

public class AnalyticsProvider extends ContentProvider {
    public static final Uri CONTENT_URI = Uri.parse("content://com.iaai.provider.AnalyticsLite");
    private static final String DATABASE_NAME = "Analytics.db";
    private static final int DATABASE_VERSION = 2;
    private static final UriMatcher sUriMatcher = new UriMatcher(-1);
    private AnalyticsDatabase mAnalyticsDatabase;

    static {
        sUriMatcher.addURI(AnalyticsContract.AUTHORITY, "analytics", 1);
        sUriMatcher.addURI(AnalyticsContract.AUTHORITY, ElementTags.REFERENCE, 2);
    }

    private static class UriMatchCode {
        private static final int ANALYTICS = 1;
        private static final int REFERENCE = 2;

        private UriMatchCode() {
        }
    }

    private static class AnalyticsDatabase extends SQLiteOpenHelper {
        AnalyticsDatabase(Context context) {
            super(context, AnalyticsProvider.DATABASE_NAME, (SQLiteDatabase.CursorFactory) null, 2);
        }

        public void onCreate(SQLiteDatabase sQLiteDatabase) {
            createAnalyticsTable(sQLiteDatabase);
            createReferenceTable(sQLiteDatabase);
        }

        public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
            sQLiteDatabase.execSQL("DROP TABLE IF EXISTS Analytics");
            sQLiteDatabase.execSQL("DROP TABLE IF EXISTS Reference");
            onCreate(sQLiteDatabase);
        }

        private void createAnalyticsTable(SQLiteDatabase sQLiteDatabase) {
            sQLiteDatabase.execSQL("CREATE TABLE Analytics (AnalyticsID INTEGER PRIMARY KEY AUTOINCREMENT,UserID INTEGER,BranchNumber INTEGER,StockNumber INTEGER,AnalyticsTypeID INTEGER NOT NULL,UTCDateTime LONG NOT NULL,OSVersion TEXT,LaneNumber TEXT,DeviceModel TEXT,BeaconMajor TEXT,BeaconMinor TEXT );");
        }

        private void createReferenceTable(SQLiteDatabase sQLiteDatabase) {
            sQLiteDatabase.execSQL("CREATE TABLE Reference (AnalyticsTypeID INTEGER,AnalyticsTypeDesc TEXT,IsActive INTEGER );");
        }
    }

    public boolean onCreate() {
        this.mAnalyticsDatabase = new AnalyticsDatabase(getContext());
        return true;
    }

    public Cursor query(Uri uri, String[] strArr, String str, String[] strArr2, String str2) {
        SQLiteQueryBuilder sQLiteQueryBuilder = new SQLiteQueryBuilder();
        int match = sUriMatcher.match(uri);
        if (match == 1) {
            sQLiteQueryBuilder.setTables(AnalyticsContract.Analytics.TABLE_NAME);
        } else if (match == 2) {
            sQLiteQueryBuilder.setTables(AnalyticsContract.Reference.TABLE_NAME);
        } else {
            throw new IllegalArgumentException("Unknown URI " + uri);
        }
        Cursor query = sQLiteQueryBuilder.query(this.mAnalyticsDatabase.getReadableDatabase(), strArr, str, strArr2, (String) null, (String) null, str2);
        query.setNotificationUri(getContext().getContentResolver(), uri);
        return query;
    }

    public String getType(Uri uri) {
        int match = sUriMatcher.match(uri);
        if (match == 1) {
            return AnalyticsContract.Analytics.CONTENT_TYPE;
        }
        if (match == 2) {
            return AnalyticsContract.Reference.CONTENT_TYPE;
        }
        throw new IllegalArgumentException("Unknown URI " + uri);
    }

    public Uri insert(Uri uri, ContentValues contentValues) {
        ContentValues contentValues2;
        String str;
        if (contentValues != null) {
            contentValues2 = new ContentValues(contentValues);
        } else {
            contentValues2 = new ContentValues();
        }
        int match = sUriMatcher.match(uri);
        if (match == 1) {
            str = AnalyticsContract.Analytics.TABLE_NAME;
        } else if (match == 2) {
            str = AnalyticsContract.Reference.TABLE_NAME;
        } else {
            throw new IllegalArgumentException("Unknown URI " + uri);
        }
        if (this.mAnalyticsDatabase.getWritableDatabase().insert(str, (String) null, contentValues2) > 0) {
            getContext().getContentResolver().notifyChange(uri, (ContentObserver) null, false);
            return uri;
        }
        throw new SQLException("Failed to insert row into " + uri);
    }

    public int delete(Uri uri, String str, String[] strArr) {
        int i;
        SQLiteDatabase writableDatabase = this.mAnalyticsDatabase.getWritableDatabase();
        int match = sUriMatcher.match(uri);
        if (match == 1) {
            i = writableDatabase.delete(AnalyticsContract.Analytics.TABLE_NAME, str, strArr);
        } else if (match == 2) {
            i = writableDatabase.delete(AnalyticsContract.Reference.TABLE_NAME, str, strArr);
        } else {
            throw new IllegalArgumentException("Unknown URI " + uri);
        }
        getContext().getContentResolver().notifyChange(uri, (ContentObserver) null, false);
        return i;
    }

    public int update(Uri uri, ContentValues contentValues, String str, String[] strArr) {
        int i;
        SQLiteDatabase writableDatabase = this.mAnalyticsDatabase.getWritableDatabase();
        int match = sUriMatcher.match(uri);
        if (match == 1) {
            i = writableDatabase.update(AnalyticsContract.Analytics.TABLE_NAME, contentValues, str, strArr);
        } else if (match == 2) {
            i = writableDatabase.update(AnalyticsContract.Reference.TABLE_NAME, contentValues, str, strArr);
        } else {
            throw new IllegalArgumentException("Unknown URI " + uri);
        }
        getContext().getContentResolver().notifyChange(uri, (ContentObserver) null, false);
        return i;
    }
}

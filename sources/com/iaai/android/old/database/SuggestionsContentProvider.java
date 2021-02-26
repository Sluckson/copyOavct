package com.iaai.android.old.database;

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
import androidx.annotation.Nullable;
import com.iaai.android.old.database.SuggestionsContract;

public class SuggestionsContentProvider extends ContentProvider {
    public static final Uri CONTENT_URI = Uri.parse("content://com.iaai.provider.suggestions");
    private static final String DATABASE_NAME = "suggestions.db";
    private static final int DATABASE_VERSION = 1;
    private static final UriMatcher sUriMatcher = new UriMatcher(-1);
    private SuggestionsDatabase mSuggestionsDatabase;

    @Nullable
    public String getType(Uri uri) {
        return "";
    }

    static {
        sUriMatcher.addURI(SuggestionsContract.AUTHORITY, SuggestionsContract.Suggestions.TABLE_NAME, 1);
    }

    private static class UriMatchCode {
        private static final int SUGGESTIONS = 1;

        private UriMatchCode() {
        }
    }

    private static class SuggestionsDatabase extends SQLiteOpenHelper {
        SuggestionsDatabase(Context context) {
            super(context, SuggestionsContentProvider.DATABASE_NAME, (SQLiteDatabase.CursorFactory) null, 1);
        }

        public void onCreate(SQLiteDatabase sQLiteDatabase) {
            createSuggestionsTable(sQLiteDatabase);
        }

        public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
            sQLiteDatabase.execSQL("DROP TABLE IF EXISTS suggestions");
            onCreate(sQLiteDatabase);
        }

        private void createSuggestionsTable(SQLiteDatabase sQLiteDatabase) {
            sQLiteDatabase.execSQL("CREATE TABLE suggestions (suggestionsID INTEGER PRIMARY KEY AUTOINCREMENT,userID INTEGER,branchnumber INTEGER,frequency INTEGER,priority INTEGER,utcdatetime LONG NOT NULL );");
        }
    }

    public boolean onCreate() {
        this.mSuggestionsDatabase = new SuggestionsDatabase(getContext());
        return true;
    }

    @Nullable
    public Cursor query(Uri uri, String[] strArr, String str, String[] strArr2, String str2) {
        SQLiteQueryBuilder sQLiteQueryBuilder = new SQLiteQueryBuilder();
        if (sUriMatcher.match(uri) == 1) {
            sQLiteQueryBuilder.setTables(SuggestionsContract.Suggestions.TABLE_NAME);
            Cursor query = sQLiteQueryBuilder.query(this.mSuggestionsDatabase.getReadableDatabase(), strArr, str, strArr2, (String) null, (String) null, str2);
            query.setNotificationUri(getContext().getContentResolver(), uri);
            return query;
        }
        throw new IllegalArgumentException("Unknown URI " + uri);
    }

    @Nullable
    public Uri insert(Uri uri, ContentValues contentValues) {
        ContentValues contentValues2;
        if (contentValues != null) {
            contentValues2 = new ContentValues(contentValues);
        } else {
            contentValues2 = new ContentValues();
        }
        if (sUriMatcher.match(uri) != 1) {
            throw new IllegalArgumentException("Unknown URI " + uri);
        } else if (this.mSuggestionsDatabase.getWritableDatabase().insert(SuggestionsContract.Suggestions.TABLE_NAME, (String) null, contentValues2) > 0) {
            getContext().getContentResolver().notifyChange(uri, (ContentObserver) null, false);
            return uri;
        } else {
            throw new SQLException("Failed to insert row into " + uri);
        }
    }

    public int delete(Uri uri, String str, String[] strArr) {
        SQLiteDatabase writableDatabase = this.mSuggestionsDatabase.getWritableDatabase();
        if (sUriMatcher.match(uri) == 1) {
            int delete = writableDatabase.delete(SuggestionsContract.Suggestions.TABLE_NAME, str, strArr);
            getContext().getContentResolver().notifyChange(uri, (ContentObserver) null, false);
            return delete;
        }
        throw new IllegalArgumentException("Unknown URI " + uri);
    }

    public int update(Uri uri, ContentValues contentValues, String str, String[] strArr) {
        SQLiteDatabase writableDatabase = this.mSuggestionsDatabase.getWritableDatabase();
        if (sUriMatcher.match(uri) == 1) {
            int update = writableDatabase.update(SuggestionsContract.Suggestions.TABLE_NAME, contentValues, str, strArr);
            getContext().getContentResolver().notifyChange(uri, (ContentObserver) null, false);
            return update;
        }
        throw new IllegalArgumentException("Unknown URI " + uri);
    }
}

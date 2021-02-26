package com.iaai.android.bdt.database;

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
import com.iaai.android.bdt.database.RecentViewContract;
import com.iaai.android.old.database.SuggestionsContract;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(mo66931bv = {1, 0, 3}, mo66932d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u0000 \u001c2\u00020\u0001:\u0003\u001c\u001d\u001eB\u0005¢\u0006\u0002\u0010\u0002J/\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00010\n2\u000e\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\fH\u0016¢\u0006\u0002\u0010\rJ\u0012\u0010\u000e\u001a\u0004\u0018\u00010\n2\u0006\u0010\u0007\u001a\u00020\bH\u0016J\u001c\u0010\u000f\u001a\u0004\u0018\u00010\b2\u0006\u0010\u0007\u001a\u00020\b2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011H\u0016J\b\u0010\u0012\u001a\u00020\u0013H\u0016JK\u0010\u0014\u001a\u0004\u0018\u00010\u00152\u0006\u0010\u0007\u001a\u00020\b2\u000e\u0010\u0016\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\f2\b\u0010\t\u001a\u0004\u0018\u00010\n2\u000e\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\f2\b\u0010\u0017\u001a\u0004\u0018\u00010\nH\u0016¢\u0006\u0002\u0010\u0018J9\u0010\u0019\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\b\u0010\u001a\u001a\u0004\u0018\u00010\u00112\b\u0010\t\u001a\u0004\u0018\u00010\n2\u000e\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\fH\u0016¢\u0006\u0002\u0010\u001bR\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u0002\n\u0000¨\u0006\u001f"}, mo66933d2 = {"Lcom/iaai/android/bdt/database/RecentViewAuctionContentProvider;", "Landroid/content/ContentProvider;", "()V", "mSuggestionsDatabase", "Lcom/iaai/android/bdt/database/RecentViewAuctionContentProvider$SuggestionsDatabase;", "delete", "", "uri", "Landroid/net/Uri;", "selection", "", "selectionArgs", "", "(Landroid/net/Uri;Ljava/lang/String;[Ljava/lang/String;)I", "getType", "insert", "initialValues", "Landroid/content/ContentValues;", "onCreate", "", "query", "Landroid/database/Cursor;", "projection", "sortOrder", "(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;", "update", "values", "(Landroid/net/Uri;Landroid/content/ContentValues;Ljava/lang/String;[Ljava/lang/String;)I", "Companion", "SuggestionsDatabase", "UriMatchCode", "app_productionRelease"}, mo66934k = 1, mo66935mv = {1, 1, 13})
/* compiled from: RecentViewAuctionContentProvider.kt */
public final class RecentViewAuctionContentProvider extends ContentProvider {
    /* access modifiers changed from: private */
    public static final Uri CONTENT_URI = Uri.parse("content://" + RecentViewContract.Companion.getAUTHORITY());
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    /* access modifiers changed from: private */
    public static final String DATABASE_NAME = DATABASE_NAME;
    /* access modifiers changed from: private */
    public static final int DATABASE_VERSION = 1;
    private static final UriMatcher sUriMatcher = new UriMatcher(-1);
    private SuggestionsDatabase mSuggestionsDatabase;

    @Nullable
    public String getType(@NotNull Uri uri) {
        Intrinsics.checkParameterIsNotNull(uri, "uri");
        return "";
    }

    @Metadata(mo66931bv = {1, 0, 3}, mo66932d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\bÂ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0014\u0010\u0003\u001a\u00020\u0004XD¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, mo66933d2 = {"Lcom/iaai/android/bdt/database/RecentViewAuctionContentProvider$UriMatchCode;", "", "()V", "SUGGESTIONS", "", "getSUGGESTIONS", "()I", "app_productionRelease"}, mo66934k = 1, mo66935mv = {1, 1, 13})
    /* compiled from: RecentViewAuctionContentProvider.kt */
    private static final class UriMatchCode {
        public static final UriMatchCode INSTANCE = new UriMatchCode();
        private static final int SUGGESTIONS = 1;

        private UriMatchCode() {
        }

        public final int getSUGGESTIONS() {
            return SUGGESTIONS;
        }
    }

    @Metadata(mo66931bv = {1, 0, 3}, mo66932d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\b\u0002\u0018\u00002\u00020\u0001B\u000f\b\u0000\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0010\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0002J\u0010\u0010\t\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0016J \u0010\n\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\fH\u0016¨\u0006\u000e"}, mo66933d2 = {"Lcom/iaai/android/bdt/database/RecentViewAuctionContentProvider$SuggestionsDatabase;", "Landroid/database/sqlite/SQLiteOpenHelper;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "createSuggestionsTable", "", "db", "Landroid/database/sqlite/SQLiteDatabase;", "onCreate", "onUpgrade", "oldVersion", "", "newVersion", "app_productionRelease"}, mo66934k = 1, mo66935mv = {1, 1, 13})
    /* compiled from: RecentViewAuctionContentProvider.kt */
    private static final class SuggestionsDatabase extends SQLiteOpenHelper {
        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public SuggestionsDatabase(@NotNull Context context) {
            super(context, RecentViewAuctionContentProvider.DATABASE_NAME, (SQLiteDatabase.CursorFactory) null, RecentViewAuctionContentProvider.DATABASE_VERSION);
            Intrinsics.checkParameterIsNotNull(context, "context");
        }

        public void onCreate(@NotNull SQLiteDatabase sQLiteDatabase) {
            Intrinsics.checkParameterIsNotNull(sQLiteDatabase, "db");
            createSuggestionsTable(sQLiteDatabase);
        }

        public void onUpgrade(@NotNull SQLiteDatabase sQLiteDatabase, int i, int i2) {
            Intrinsics.checkParameterIsNotNull(sQLiteDatabase, "db");
            sQLiteDatabase.execSQL("DROP TABLE IF EXISTS " + RecentViewContract.Suggestions.Companion.getTABLE_NAME());
            onCreate(sQLiteDatabase);
        }

        private final void createSuggestionsTable(SQLiteDatabase sQLiteDatabase) {
            sQLiteDatabase.execSQL("CREATE TABLE " + RecentViewContract.Suggestions.Companion.getTABLE_NAME() + " (" + RecentViewContract.Suggestions.Companion.getCOLUMN_NAME_SUGGESTIONS_ID() + " INTEGER PRIMARY KEY AUTOINCREMENT," + RecentViewContract.Suggestions.Companion.getCOLUMN_NAME_USER_ID() + " INTEGER," + RecentViewContract.Suggestions.Companion.getCOLUMN_NAME_BRANCH_NO() + " INTEGER," + RecentViewContract.Suggestions.Companion.getCOLUMN_NAME_FREQUENCY() + " INTEGER," + RecentViewContract.Suggestions.Companion.getCOLUMN_NAME_PRIORITY() + " INTEGER," + RecentViewContract.Suggestions.Companion.getCOLUMN_NAME_AUCTION_DATE() + " TEXT," + RecentViewContract.Suggestions.Companion.getCOLUMN_NAME_UTC_DATE() + " LONG NOT NULL " + ");");
        }
    }

    public boolean onCreate() {
        Context context = getContext();
        Intrinsics.checkExpressionValueIsNotNull(context, "context");
        this.mSuggestionsDatabase = new SuggestionsDatabase(context);
        return true;
    }

    @Nullable
    public Cursor query(@NotNull Uri uri, @Nullable String[] strArr, @Nullable String str, @Nullable String[] strArr2, @Nullable String str2) {
        Intrinsics.checkParameterIsNotNull(uri, "uri");
        SQLiteQueryBuilder sQLiteQueryBuilder = new SQLiteQueryBuilder();
        if (sUriMatcher.match(uri) == UriMatchCode.INSTANCE.getSUGGESTIONS()) {
            sQLiteQueryBuilder.setTables(RecentViewContract.Suggestions.Companion.getTABLE_NAME());
            SuggestionsDatabase suggestionsDatabase = this.mSuggestionsDatabase;
            if (suggestionsDatabase == null) {
                Intrinsics.throwNpe();
            }
            Cursor query = sQLiteQueryBuilder.query(suggestionsDatabase.getReadableDatabase(), strArr, str, strArr2, (String) null, (String) null, str2);
            Context context = getContext();
            if (context == null) {
                Intrinsics.throwNpe();
            }
            query.setNotificationUri(context.getContentResolver(), uri);
            return query;
        }
        throw new IllegalArgumentException("Unknown URI " + uri);
    }

    @Nullable
    public Uri insert(@NotNull Uri uri, @Nullable ContentValues contentValues) {
        ContentValues contentValues2;
        Intrinsics.checkParameterIsNotNull(uri, "uri");
        if (contentValues != null) {
            contentValues2 = new ContentValues(contentValues);
        } else {
            contentValues2 = new ContentValues();
        }
        if (sUriMatcher.match(uri) == UriMatchCode.INSTANCE.getSUGGESTIONS()) {
            String table_name = RecentViewContract.Suggestions.Companion.getTABLE_NAME();
            SuggestionsDatabase suggestionsDatabase = this.mSuggestionsDatabase;
            if (suggestionsDatabase == null) {
                Intrinsics.throwNpe();
            }
            if (suggestionsDatabase.getWritableDatabase().insert(table_name, (String) null, contentValues2) > 0) {
                Context context = getContext();
                if (context == null) {
                    Intrinsics.throwNpe();
                }
                context.getContentResolver().notifyChange(uri, (ContentObserver) null, false);
                return uri;
            }
            throw new SQLException("Failed to insert row into " + uri);
        }
        throw new IllegalArgumentException("Unknown URI " + uri);
    }

    public int delete(@NotNull Uri uri, @Nullable String str, @Nullable String[] strArr) {
        Intrinsics.checkParameterIsNotNull(uri, "uri");
        SuggestionsDatabase suggestionsDatabase = this.mSuggestionsDatabase;
        if (suggestionsDatabase == null) {
            Intrinsics.throwNpe();
        }
        SQLiteDatabase writableDatabase = suggestionsDatabase.getWritableDatabase();
        if (sUriMatcher.match(uri) == UriMatchCode.INSTANCE.getSUGGESTIONS()) {
            int delete = writableDatabase.delete(RecentViewContract.Suggestions.Companion.getTABLE_NAME(), str, strArr);
            Context context = getContext();
            if (context == null) {
                Intrinsics.throwNpe();
            }
            context.getContentResolver().notifyChange(uri, (ContentObserver) null, false);
            return delete;
        }
        throw new IllegalArgumentException("Unknown URI " + uri);
    }

    public int update(@NotNull Uri uri, @Nullable ContentValues contentValues, @Nullable String str, @Nullable String[] strArr) {
        Intrinsics.checkParameterIsNotNull(uri, "uri");
        SuggestionsDatabase suggestionsDatabase = this.mSuggestionsDatabase;
        if (suggestionsDatabase == null) {
            Intrinsics.throwNpe();
        }
        SQLiteDatabase writableDatabase = suggestionsDatabase.getWritableDatabase();
        if (sUriMatcher.match(uri) == UriMatchCode.INSTANCE.getSUGGESTIONS()) {
            int update = writableDatabase.update(RecentViewContract.Suggestions.Companion.getTABLE_NAME(), contentValues, str, strArr);
            Context context = getContext();
            if (context == null) {
                Intrinsics.throwNpe();
            }
            context.getContentResolver().notifyChange(uri, (ContentObserver) null, false);
            return update;
        }
        throw new IllegalArgumentException("Unknown URI " + uri);
    }

    @Metadata(mo66931bv = {1, 0, 3}, mo66932d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0019\u0010\u0003\u001a\n \u0005*\u0004\u0018\u00010\u00040\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u000e\u0010\b\u001a\u00020\tXD¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bXD¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0004¢\u0006\u0002\n\u0000¨\u0006\u000e"}, mo66933d2 = {"Lcom/iaai/android/bdt/database/RecentViewAuctionContentProvider$Companion;", "", "()V", "CONTENT_URI", "Landroid/net/Uri;", "kotlin.jvm.PlatformType", "getCONTENT_URI", "()Landroid/net/Uri;", "DATABASE_NAME", "", "DATABASE_VERSION", "", "sUriMatcher", "Landroid/content/UriMatcher;", "app_productionRelease"}, mo66934k = 1, mo66935mv = {1, 1, 13})
    /* compiled from: RecentViewAuctionContentProvider.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final Uri getCONTENT_URI() {
            return RecentViewAuctionContentProvider.CONTENT_URI;
        }
    }

    static {
        sUriMatcher.addURI(RecentViewContract.Companion.getAUTHORITY(), SuggestionsContract.Suggestions.TABLE_NAME, UriMatchCode.INSTANCE.getSUGGESTIONS());
    }
}

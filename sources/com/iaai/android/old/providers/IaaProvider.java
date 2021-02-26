package com.iaai.android.old.providers;

import android.content.ContentProvider;
import android.content.ContentUris;
import android.content.ContentValues;
import android.content.Context;
import android.content.UriMatcher;
import android.database.ContentObserver;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.net.Uri;
import android.text.TextUtils;
import com.iaai.android.old.providers.IaaContent;
import java.util.HashMap;
import java.util.Map;
import roboguice.util.C5058Ln;

public class IaaProvider extends ContentProvider {
    private static final String DATABASE_NAME = "iaai.db";
    private static final int DATABASE_VERSION = 7;
    public static final String TABLE_ALERT = "alert";
    public static final String TABLE_C2DM_REGISTRATION = "c2dmregistration";
    public static final String TABLE_SEARCH_HISTORY = "searchhistory";
    private static final int URL_MATCH_ALERT = 5;
    private static final int URL_MATCH_ALERT_PK = 6;
    private static final int URL_MATCH_C2DM_REGISTRATION = 3;
    private static final int URL_MATCH_C2DM_REGISTRATION_PK = 4;
    private static final int URL_MATCH_SEARCH_HISTORY = 1;
    private static final int URL_MATCH_SEARCH_HISTORY_PK = 2;
    private static Map<String, String> alertProjectionMap = new HashMap();
    private static Map<String, String> c2dmProjectionMap = new HashMap();
    private static final UriMatcher sUriMatcher = new UriMatcher(-1);
    private static Map<String, String> searchHistoryProjectionMap = new HashMap();
    private DatabaseHelper mOpenHelper;

    static {
        sUriMatcher.addURI(IaaContent.AUTHORITY, "searchhistory", 1);
        sUriMatcher.addURI(IaaContent.AUTHORITY, "searchhistory/#", 2);
        sUriMatcher.addURI(IaaContent.AUTHORITY, "c2dmregistration", 3);
        sUriMatcher.addURI(IaaContent.AUTHORITY, "c2dmregistration/#", 4);
        sUriMatcher.addURI(IaaContent.AUTHORITY, "alert", 5);
        sUriMatcher.addURI(IaaContent.AUTHORITY, "alert/#", 6);
        addToProjectionMap(searchHistoryProjectionMap, "_id");
        addToProjectionMap(searchHistoryProjectionMap, IaaContent.SearchHistory.SEARCH_TEXT);
        addToProjectionMap(searchHistoryProjectionMap, IaaContent.IaaBaseColumns.CREATED_ON);
        addToProjectionMap(c2dmProjectionMap, "_id");
        addToProjectionMap(c2dmProjectionMap, IaaContent.C2dmRegistration.REGISTRATION_ID);
        addToProjectionMap(c2dmProjectionMap, IaaContent.C2dmRegistration.SENDER_ID);
        addToProjectionMap(c2dmProjectionMap, IaaContent.C2dmRegistration.IS_SYNC);
        addToProjectionMap(c2dmProjectionMap, IaaContent.IaaBaseColumns.CREATED_ON);
        addToProjectionMap(alertProjectionMap, "_id");
        addToProjectionMap(alertProjectionMap, IaaContent.Alert.ALERT_ID);
        addToProjectionMap(alertProjectionMap, IaaContent.Alert.EVENT_ID);
        addToProjectionMap(alertProjectionMap, "title");
        addToProjectionMap(alertProjectionMap, IaaContent.Alert.DETAIL);
        addToProjectionMap(alertProjectionMap, IaaContent.Alert.IS_READ);
        addToProjectionMap(alertProjectionMap, IaaContent.Alert.ALERT_DATETIME);
        addToProjectionMap(alertProjectionMap, IaaContent.IaaBaseColumns.CREATED_ON);
    }

    private static void addToProjectionMap(Map<String, String> map, String str) {
        map.put(str, str);
    }

    private static class DatabaseHelper extends SQLiteOpenHelper {
        String SENDER_ID_GCM = "483894526844";

        DatabaseHelper(Context context) {
            super(context, IaaProvider.DATABASE_NAME, (SQLiteDatabase.CursorFactory) null, 7);
        }

        public void onCreate(SQLiteDatabase sQLiteDatabase) {
            sQLiteDatabase.execSQL("CREATE TABLE searchhistory (_id INTEGER PRIMARY KEY,searchText TEXT NOT NULL UNIQUE,created TIMESTAMP NOT NULL DEFAULT current_timestamp);");
            sQLiteDatabase.execSQL("CREATE TABLE c2dmregistration (_id INTEGER PRIMARY KEY,registrationId TEXT,senderId TEXT,isSync INTEGER,created TIMESTAMP NOT NULL DEFAULT current_timestamp);");
            sQLiteDatabase.execSQL("CREATE TABLE alert (_id INTEGER PRIMARY KEY,alertId INTEGER,eventId INTEGER,title TEXT,detail TEXT,isRead INTEGER,alertDateTime TIMESTAMP NOT NULL DEFAULT current_timestamp,created TIMESTAMP NOT NULL DEFAULT current_timestamp);");
        }

        public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
            C5058Ln.m4841w("Upgrading database from version %d to %d, which will destroy all old data", Integer.valueOf(i), Integer.valueOf(i2));
            String fCMRegistrationId = getFCMRegistrationId(-1, sQLiteDatabase);
            C5058Ln.m4841w("Upgrading database registrationID", fCMRegistrationId, fCMRegistrationId);
            sQLiteDatabase.execSQL("DROP TABLE IF EXISTS searchhistory;");
            sQLiteDatabase.execSQL("DROP TABLE IF EXISTS c2dmregistration;");
            sQLiteDatabase.execSQL("DROP TABLE IF EXISTS alert;");
            onCreate(sQLiteDatabase);
            insertFCMRegistrationId(fCMRegistrationId, sQLiteDatabase);
        }

        /* JADX WARNING: Removed duplicated region for block: B:17:0x0032  */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        private java.lang.String getFCMRegistrationId(int r10, android.database.sqlite.SQLiteDatabase r11) {
            /*
                r9 = this;
                r10 = 0
                java.lang.String r1 = "c2dmregistration"
                r2 = 0
                r3 = 0
                r4 = 0
                r5 = 0
                r6 = 0
                r7 = 0
                r0 = r11
                android.database.Cursor r11 = r0.query(r1, r2, r3, r4, r5, r6, r7)     // Catch:{ all -> 0x002c }
                boolean r0 = r11.moveToFirst()     // Catch:{ all -> 0x002a }
                if (r0 == 0) goto L_0x0024
                java.lang.String r10 = "registrationId"
                int r10 = r11.getColumnIndex(r10)     // Catch:{ all -> 0x002a }
                java.lang.String r10 = r11.getString(r10)     // Catch:{ all -> 0x002a }
                if (r11 == 0) goto L_0x0023
                r11.close()
            L_0x0023:
                return r10
            L_0x0024:
                if (r11 == 0) goto L_0x0029
                r11.close()
            L_0x0029:
                return r10
            L_0x002a:
                r10 = move-exception
                goto L_0x0030
            L_0x002c:
                r11 = move-exception
                r8 = r11
                r11 = r10
                r10 = r8
            L_0x0030:
                if (r11 == 0) goto L_0x0035
                r11.close()
            L_0x0035:
                throw r10
            */
            throw new UnsupportedOperationException("Method not decompiled: com.iaai.android.old.providers.IaaProvider.DatabaseHelper.getFCMRegistrationId(int, android.database.sqlite.SQLiteDatabase):java.lang.String");
        }

        public void insertFCMRegistrationId(String str, SQLiteDatabase sQLiteDatabase) {
            ContentValues contentValues = new ContentValues();
            contentValues.put(IaaContent.C2dmRegistration.REGISTRATION_ID, str);
            contentValues.put(IaaContent.C2dmRegistration.SENDER_ID, this.SENDER_ID_GCM);
            contentValues.put(IaaContent.C2dmRegistration.IS_SYNC, 0);
            Long valueOf = Long.valueOf(sQLiteDatabase.insert("c2dmregistration", (String) null, contentValues));
            C5058Ln.m4841w("Upgrading database record", valueOf, valueOf);
        }
    }

    public boolean onCreate() {
        this.mOpenHelper = new DatabaseHelper(getContext());
        return true;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:10:0x0088, code lost:
        r0.setTables(r3);
        r0.setProjectionMap(r2);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:11:0x008e, code lost:
        if (r5 == null) goto L_0x0093;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:12:0x0090, code lost:
        r0.appendWhere(r5);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:14:0x0097, code lost:
        if (android.text.TextUtils.isEmpty(r13) == false) goto L_0x009b;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:15:0x0099, code lost:
        r13 = "created DESC";
     */
    /* JADX WARNING: Code restructure failed: missing block: B:16:0x009b, code lost:
        r10 = r0.query(r1, r10, r11, r12, (java.lang.String) null, (java.lang.String) null, r13);
        r10.setNotificationUri(getContext().getContentResolver(), r9);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:17:0x00b0, code lost:
        return r10;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:5:0x0048, code lost:
        r2 = alertProjectionMap;
        r3 = "alert";
     */
    /* JADX WARNING: Code restructure failed: missing block: B:7:0x0066, code lost:
        r2 = c2dmProjectionMap;
        r3 = "c2dmregistration";
     */
    /* JADX WARNING: Code restructure failed: missing block: B:9:0x0084, code lost:
        r2 = searchHistoryProjectionMap;
        r3 = "searchhistory";
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public android.database.Cursor query(android.net.Uri r9, java.lang.String[] r10, java.lang.String r11, java.lang.String[] r12, java.lang.String r13) {
        /*
            r8 = this;
            android.database.sqlite.SQLiteQueryBuilder r0 = new android.database.sqlite.SQLiteQueryBuilder
            r0.<init>()
            com.iaai.android.old.providers.IaaProvider$DatabaseHelper r1 = r8.mOpenHelper
            android.database.sqlite.SQLiteDatabase r1 = r1.getReadableDatabase()
            android.content.UriMatcher r2 = sUriMatcher
            int r2 = r2.match(r9)
            r3 = 1
            java.lang.String r4 = "_id="
            r5 = 0
            switch(r2) {
                case 1: goto L_0x0084;
                case 2: goto L_0x006b;
                case 3: goto L_0x0066;
                case 4: goto L_0x004d;
                case 5: goto L_0x0048;
                case 6: goto L_0x002f;
                default: goto L_0x0018;
            }
        L_0x0018:
            java.lang.IllegalArgumentException r10 = new java.lang.IllegalArgumentException
            java.lang.StringBuilder r11 = new java.lang.StringBuilder
            r11.<init>()
            java.lang.String r12 = "Unknown URI "
            r11.append(r12)
            r11.append(r9)
            java.lang.String r9 = r11.toString()
            r10.<init>(r9)
            throw r10
        L_0x002f:
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            r2.append(r4)
            java.util.List r4 = r9.getPathSegments()
            java.lang.Object r3 = r4.get(r3)
            java.lang.String r3 = (java.lang.String) r3
            r2.append(r3)
            java.lang.String r5 = r2.toString()
        L_0x0048:
            java.util.Map<java.lang.String, java.lang.String> r2 = alertProjectionMap
            java.lang.String r3 = "alert"
            goto L_0x0088
        L_0x004d:
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            r2.append(r4)
            java.util.List r4 = r9.getPathSegments()
            java.lang.Object r3 = r4.get(r3)
            java.lang.String r3 = (java.lang.String) r3
            r2.append(r3)
            java.lang.String r5 = r2.toString()
        L_0x0066:
            java.util.Map<java.lang.String, java.lang.String> r2 = c2dmProjectionMap
            java.lang.String r3 = "c2dmregistration"
            goto L_0x0088
        L_0x006b:
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            r2.append(r4)
            java.util.List r4 = r9.getPathSegments()
            java.lang.Object r3 = r4.get(r3)
            java.lang.String r3 = (java.lang.String) r3
            r2.append(r3)
            java.lang.String r5 = r2.toString()
        L_0x0084:
            java.util.Map<java.lang.String, java.lang.String> r2 = searchHistoryProjectionMap
            java.lang.String r3 = "searchhistory"
        L_0x0088:
            r0.setTables(r3)
            r0.setProjectionMap(r2)
            if (r5 == 0) goto L_0x0093
            r0.appendWhere(r5)
        L_0x0093:
            boolean r2 = android.text.TextUtils.isEmpty(r13)
            if (r2 == 0) goto L_0x009b
            java.lang.String r13 = "created DESC"
        L_0x009b:
            r7 = r13
            r5 = 0
            r6 = 0
            r2 = r10
            r3 = r11
            r4 = r12
            android.database.Cursor r10 = r0.query(r1, r2, r3, r4, r5, r6, r7)
            android.content.Context r11 = r8.getContext()
            android.content.ContentResolver r11 = r11.getContentResolver()
            r10.setNotificationUri(r11, r9)
            return r10
        */
        throw new UnsupportedOperationException("Method not decompiled: com.iaai.android.old.providers.IaaProvider.query(android.net.Uri, java.lang.String[], java.lang.String, java.lang.String[], java.lang.String):android.database.Cursor");
    }

    public String getType(Uri uri) {
        switch (sUriMatcher.match(uri)) {
            case 1:
                return IaaContent.SearchHistory.CONTENT_TYPE;
            case 2:
                return IaaContent.SearchHistory.CONTENT_ITEM_TYPE;
            case 3:
                return IaaContent.C2dmRegistration.CONTENT_TYPE;
            case 4:
                return IaaContent.C2dmRegistration.CONTENT_ITEM_TYPE;
            case 5:
                return IaaContent.Alert.CONTENT_TYPE;
            case 6:
                return IaaContent.Alert.CONTENT_ITEM_TYPE;
            default:
                throw new IllegalArgumentException("Unknown URI " + uri);
        }
    }

    public Uri insert(Uri uri, ContentValues contentValues) {
        String str;
        Uri uri2;
        ContentValues contentValues2;
        int match = sUriMatcher.match(uri);
        if (match == 1) {
            uri2 = IaaContent.SearchHistory.CONTENT_URI;
            str = "searchhistory";
        } else if (match == 3) {
            uri2 = IaaContent.C2dmRegistration.CONTENT_URI;
            str = "c2dmregistration";
        } else if (match == 5) {
            uri2 = IaaContent.Alert.CONTENT_URI;
            str = "alert";
        } else {
            throw new IllegalArgumentException("Insertion failed - URI[" + uri + "]");
        }
        if (contentValues != null) {
            contentValues2 = new ContentValues(contentValues);
        } else {
            contentValues2 = new ContentValues();
        }
        if (!contentValues2.containsKey(IaaContent.IaaBaseColumns.CREATED_ON)) {
            contentValues2.put(IaaContent.IaaBaseColumns.CREATED_ON, Long.valueOf(System.currentTimeMillis()));
        }
        long insert = this.mOpenHelper.getWritableDatabase().insert(str, (String) null, contentValues2);
        if (insert > 0) {
            Uri withAppendedId = ContentUris.withAppendedId(uri2, insert);
            getContext().getContentResolver().notifyChange(withAppendedId, (ContentObserver) null);
            return withAppendedId;
        }
        throw new SQLException("Failed to insert row into " + uri);
    }

    public int delete(Uri uri, String str, String[] strArr) {
        int i;
        SQLiteDatabase writableDatabase = this.mOpenHelper.getWritableDatabase();
        String str2 = "";
        switch (sUriMatcher.match(uri)) {
            case 1:
                i = writableDatabase.delete("searchhistory", str, strArr);
                break;
            case 2:
                StringBuilder sb = new StringBuilder();
                sb.append("_id=");
                sb.append(uri.getPathSegments().get(1));
                if (!TextUtils.isEmpty(str)) {
                    str2 = " AND (" + str + ')';
                }
                sb.append(str2);
                i = writableDatabase.delete("searchhistory", sb.toString(), strArr);
                break;
            case 3:
                i = writableDatabase.delete("c2dmregistration", str, strArr);
                break;
            case 4:
                StringBuilder sb2 = new StringBuilder();
                sb2.append("_id=");
                sb2.append(uri.getPathSegments().get(1));
                if (!TextUtils.isEmpty(str)) {
                    str2 = " AND (" + str + ')';
                }
                sb2.append(str2);
                i = writableDatabase.delete("c2dmregistration", sb2.toString(), strArr);
                break;
            case 5:
                i = writableDatabase.delete("alert", str, strArr);
                break;
            case 6:
                StringBuilder sb3 = new StringBuilder();
                sb3.append("_id=");
                sb3.append(uri.getPathSegments().get(1));
                if (!TextUtils.isEmpty(str)) {
                    str2 = " AND (" + str + ')';
                }
                sb3.append(str2);
                i = writableDatabase.delete("alert", sb3.toString(), strArr);
                break;
            default:
                throw new IllegalArgumentException("Unknown URI " + uri);
        }
        getContext().getContentResolver().notifyChange(uri, (ContentObserver) null);
        return i;
    }

    public int update(Uri uri, ContentValues contentValues, String str, String[] strArr) {
        int i;
        SQLiteDatabase writableDatabase = this.mOpenHelper.getWritableDatabase();
        String str2 = "";
        switch (sUriMatcher.match(uri)) {
            case 1:
                i = writableDatabase.update("searchhistory", contentValues, str, strArr);
                break;
            case 2:
                StringBuilder sb = new StringBuilder();
                sb.append("_id=");
                sb.append(uri.getPathSegments().get(1));
                if (!TextUtils.isEmpty(str)) {
                    str2 = " AND (" + str + ')';
                }
                sb.append(str2);
                i = writableDatabase.update("searchhistory", contentValues, sb.toString(), strArr);
                break;
            case 3:
                i = writableDatabase.update("c2dmregistration", contentValues, str, strArr);
                break;
            case 4:
                StringBuilder sb2 = new StringBuilder();
                sb2.append("_id=");
                sb2.append(uri.getPathSegments().get(1));
                if (!TextUtils.isEmpty(str)) {
                    str2 = " AND (" + str + ')';
                }
                sb2.append(str2);
                i = writableDatabase.update("c2dmregistration", contentValues, sb2.toString(), strArr);
                break;
            case 5:
                i = writableDatabase.update("alert", contentValues, str, strArr);
                break;
            case 6:
                StringBuilder sb3 = new StringBuilder();
                sb3.append("_id=");
                sb3.append(uri.getPathSegments().get(1));
                if (!TextUtils.isEmpty(str)) {
                    str2 = " AND (" + str + ')';
                }
                sb3.append(str2);
                i = writableDatabase.update("alert", contentValues, sb3.toString(), strArr);
                break;
            default:
                throw new IllegalArgumentException("Unknown URI " + uri);
        }
        getContext().getContentResolver().notifyChange(uri, (ContentObserver) null);
        return i;
    }
}

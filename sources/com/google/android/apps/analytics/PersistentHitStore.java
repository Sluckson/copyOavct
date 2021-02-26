package com.google.android.apps.analytics;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Map;
import java.util.Random;
import org.codehaus.jackson.util.MinimalPrettyPrinter;

class PersistentHitStore implements HitStore {
    private static final String ACCOUNT_ID = "account_id";
    private static final String ACTION = "action";
    private static final String CATEGORY = "category";
    /* access modifiers changed from: private */
    public static final String CREATE_CUSTOM_VARIABLES_TABLE = ("CREATE TABLE custom_variables (" + String.format(" '%s' INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL,", new Object[]{CUSTOMVAR_ID}) + String.format(" '%s' INTEGER NOT NULL,", new Object[]{EVENT_ID}) + String.format(" '%s' INTEGER NOT NULL,", new Object[]{CUSTOMVAR_INDEX}) + String.format(" '%s' CHAR(64) NOT NULL,", new Object[]{CUSTOMVAR_NAME}) + String.format(" '%s' CHAR(64) NOT NULL,", new Object[]{CUSTOMVAR_VALUE}) + String.format(" '%s' INTEGER NOT NULL);", new Object[]{CUSTOMVAR_SCOPE}));
    /* access modifiers changed from: private */
    public static final String CREATE_CUSTOM_VAR_CACHE_TABLE = ("CREATE TABLE IF NOT EXISTS custom_var_cache (" + String.format(" '%s' INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL,", new Object[]{CUSTOMVAR_ID}) + String.format(" '%s' INTEGER NOT NULL,", new Object[]{EVENT_ID}) + String.format(" '%s' INTEGER NOT NULL,", new Object[]{CUSTOMVAR_INDEX}) + String.format(" '%s' CHAR(64) NOT NULL,", new Object[]{CUSTOMVAR_NAME}) + String.format(" '%s' CHAR(64) NOT NULL,", new Object[]{CUSTOMVAR_VALUE}) + String.format(" '%s' INTEGER NOT NULL);", new Object[]{CUSTOMVAR_SCOPE}));
    /* access modifiers changed from: private */
    public static final String CREATE_EVENTS_TABLE = ("CREATE TABLE events (" + String.format(" '%s' INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL,", new Object[]{EVENT_ID}) + String.format(" '%s' INTEGER NOT NULL,", new Object[]{USER_ID}) + String.format(" '%s' CHAR(256) NOT NULL,", new Object[]{ACCOUNT_ID}) + String.format(" '%s' INTEGER NOT NULL,", new Object[]{RANDOM_VAL}) + String.format(" '%s' INTEGER NOT NULL,", new Object[]{TIMESTAMP_FIRST}) + String.format(" '%s' INTEGER NOT NULL,", new Object[]{TIMESTAMP_PREVIOUS}) + String.format(" '%s' INTEGER NOT NULL,", new Object[]{TIMESTAMP_CURRENT}) + String.format(" '%s' INTEGER NOT NULL,", new Object[]{VISITS}) + String.format(" '%s' CHAR(256) NOT NULL,", new Object[]{"category"}) + String.format(" '%s' CHAR(256) NOT NULL,", new Object[]{ACTION}) + String.format(" '%s' CHAR(256), ", new Object[]{LABEL}) + String.format(" '%s' INTEGER,", new Object[]{"value"}) + String.format(" '%s' INTEGER,", new Object[]{SCREEN_WIDTH}) + String.format(" '%s' INTEGER);", new Object[]{SCREEN_HEIGHT}));
    /* access modifiers changed from: private */
    public static final String CREATE_HITS_TABLE;
    private static final String CREATE_INSTALL_REFERRER_TABLE = "CREATE TABLE install_referrer (referrer TEXT PRIMARY KEY NOT NULL);";
    /* access modifiers changed from: private */
    public static final String CREATE_ITEM_EVENTS_TABLE = ("CREATE TABLE item_events (" + String.format(" '%s' INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL,", new Object[]{"item_id"}) + String.format(" '%s' INTEGER NOT NULL,", new Object[]{EVENT_ID}) + String.format(" '%s' TEXT NOT NULL,", new Object[]{ORDER_ID}) + String.format(" '%s' TEXT NOT NULL,", new Object[]{ITEM_SKU}) + String.format(" '%s' TEXT,", new Object[]{"item_name"}) + String.format(" '%s' TEXT,", new Object[]{"item_category"}) + String.format(" '%s' TEXT NOT NULL,", new Object[]{ITEM_PRICE}) + String.format(" '%s' TEXT NOT NULL);", new Object[]{ITEM_COUNT}));
    private static final String CREATE_REFERRER_TABLE = "CREATE TABLE IF NOT EXISTS referrer (referrer TEXT PRIMARY KEY NOT NULL,timestamp_referrer INTEGER NOT NULL,referrer_visit INTEGER NOT NULL DEFAULT 1,referrer_index INTEGER NOT NULL DEFAULT 1);";
    /* access modifiers changed from: private */
    public static final String CREATE_SESSION_TABLE;
    /* access modifiers changed from: private */
    public static final String CREATE_TRANSACTION_EVENTS_TABLE = ("CREATE TABLE transaction_events (" + String.format(" '%s' INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL,", new Object[]{TRANSACTION_ID}) + String.format(" '%s' INTEGER NOT NULL,", new Object[]{EVENT_ID}) + String.format(" '%s' TEXT NOT NULL,", new Object[]{ORDER_ID}) + String.format(" '%s' TEXT,", new Object[]{STORE_NAME}) + String.format(" '%s' TEXT NOT NULL,", new Object[]{TOTAL_COST}) + String.format(" '%s' TEXT,", new Object[]{TOTAL_TAX}) + String.format(" '%s' TEXT);", new Object[]{SHIPPING_COST}));
    private static final String CUSTOMVAR_ID = "cv_id";
    private static final String CUSTOMVAR_INDEX = "cv_index";
    private static final String CUSTOMVAR_NAME = "cv_name";
    private static final String CUSTOMVAR_SCOPE = "cv_scope";
    private static final String CUSTOMVAR_VALUE = "cv_value";
    private static final String CUSTOM_VARIABLE_COLUMN_TYPE = "CHAR(64) NOT NULL";
    private static final String DATABASE_NAME = "google_analytics.db";
    private static final int DATABASE_VERSION = 5;
    private static final String EVENT_ID = "event_id";
    private static final String HIT_ID = "hit_id";
    private static final String HIT_STRING = "hit_string";
    private static final String HIT_TIMESTAMP = "hit_time";
    private static final String ITEM_CATEGORY = "item_category";
    private static final String ITEM_COUNT = "item_count";
    private static final String ITEM_ID = "item_id";
    private static final String ITEM_NAME = "item_name";
    private static final String ITEM_PRICE = "item_price";
    private static final String ITEM_SKU = "item_sku";
    private static final String LABEL = "label";
    private static final int MAX_HITS = 1000;
    private static final String ORDER_ID = "order_id";
    private static final String RANDOM_VAL = "random_val";
    static final String REFERRER = "referrer";
    static final String REFERRER_COLUMN = "referrer";
    static final String REFERRER_INDEX = "referrer_index";
    static final String REFERRER_VISIT = "referrer_visit";
    private static final String SCREEN_HEIGHT = "screen_height";
    private static final String SCREEN_WIDTH = "screen_width";
    private static final String SHIPPING_COST = "tran_shippingcost";
    private static final String STORE_ID = "store_id";
    private static final String STORE_NAME = "tran_storename";
    private static final String TIMESTAMP_CURRENT = "timestamp_current";
    private static final String TIMESTAMP_FIRST = "timestamp_first";
    private static final String TIMESTAMP_PREVIOUS = "timestamp_previous";
    static final String TIMESTAMP_REFERRER = "timestamp_referrer";
    private static final String TOTAL_COST = "tran_totalcost";
    private static final String TOTAL_TAX = "tran_totaltax";
    private static final String TRANSACTION_ID = "tran_id";
    private static final String USER_ID = "user_id";
    private static final String VALUE = "value";
    private static final String VISITS = "visits";
    private boolean anonymizeIp;
    private DataBaseHelper databaseHelper;
    private volatile int numStoredHits;
    private Random random;
    private int sampleRate;
    private boolean sessionStarted;
    private int storeId;
    private long timestampCurrent;
    private long timestampFirst;
    private long timestampPrevious;
    private boolean useStoredVisitorVars;
    /* access modifiers changed from: private */
    public CustomVariableBuffer visitorCVCache;
    private int visits;

    static class DataBaseHelper extends SQLiteOpenHelper {
        private final int databaseVersion;
        private final PersistentHitStore store;

        public DataBaseHelper(Context context, PersistentHitStore persistentHitStore) {
            this(context, PersistentHitStore.DATABASE_NAME, 5, persistentHitStore);
        }

        DataBaseHelper(Context context, String str, int i, PersistentHitStore persistentHitStore) {
            super(context, str, (SQLiteDatabase.CursorFactory) null, i);
            this.databaseVersion = i;
            this.store = persistentHitStore;
        }

        public DataBaseHelper(Context context, String str, PersistentHitStore persistentHitStore) {
            this(context, str, 5, persistentHitStore);
        }

        private void createECommerceTables(SQLiteDatabase sQLiteDatabase) {
            sQLiteDatabase.execSQL("DROP TABLE IF EXISTS transaction_events;");
            sQLiteDatabase.execSQL(PersistentHitStore.CREATE_TRANSACTION_EVENTS_TABLE);
            sQLiteDatabase.execSQL("DROP TABLE IF EXISTS item_events;");
            sQLiteDatabase.execSQL(PersistentHitStore.CREATE_ITEM_EVENTS_TABLE);
        }

        private void createHitTable(SQLiteDatabase sQLiteDatabase) {
            sQLiteDatabase.execSQL("DROP TABLE IF EXISTS hits;");
            sQLiteDatabase.execSQL(PersistentHitStore.CREATE_HITS_TABLE);
        }

        private void createReferrerTable(SQLiteDatabase sQLiteDatabase) {
            sQLiteDatabase.execSQL("DROP TABLE IF EXISTS referrer;");
            sQLiteDatabase.execSQL(PersistentHitStore.CREATE_REFERRER_TABLE);
        }

        /* JADX WARNING: Removed duplicated region for block: B:42:0x00bc  */
        /* JADX WARNING: Removed duplicated region for block: B:61:0x00e6  */
        /* JADX WARNING: Removed duplicated region for block: B:67:0x00f7  */
        /* JADX WARNING: Removed duplicated region for block: B:70:0x0100  */
        /* JADX WARNING: Removed duplicated region for block: B:77:? A[RETURN, SYNTHETIC] */
        /* JADX WARNING: Removed duplicated region for block: B:78:? A[RETURN, SYNTHETIC] */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        private void fixReferrerTable(android.database.sqlite.SQLiteDatabase r17) {
            /*
                r16 = this;
                r1 = 0
                java.lang.String r3 = "referrer"
                r4 = 0
                r5 = 0
                r6 = 0
                r7 = 0
                r8 = 0
                r9 = 0
                r2 = r17
                android.database.Cursor r2 = r2.query(r3, r4, r5, r6, r7, r8, r9)     // Catch:{ SQLiteException -> 0x00d8, all -> 0x00d3 }
                java.lang.String[] r0 = r2.getColumnNames()     // Catch:{ SQLiteException -> 0x00ce, all -> 0x00ca }
                r3 = 0
                r4 = 0
                r5 = 0
            L_0x0016:
                int r6 = r0.length     // Catch:{ SQLiteException -> 0x00ce, all -> 0x00ca }
                java.lang.String r7 = "referrer_visit"
                java.lang.String r8 = "referrer_index"
                r9 = 1
                if (r3 >= r6) goto L_0x0034
                r6 = r0[r3]     // Catch:{ SQLiteException -> 0x00ce, all -> 0x00ca }
                boolean r6 = r6.equals(r8)     // Catch:{ SQLiteException -> 0x00ce, all -> 0x00ca }
                if (r6 == 0) goto L_0x0028
                r4 = 1
                goto L_0x0031
            L_0x0028:
                r6 = r0[r3]     // Catch:{ SQLiteException -> 0x00ce, all -> 0x00ca }
                boolean r6 = r6.equals(r7)     // Catch:{ SQLiteException -> 0x00ce, all -> 0x00ca }
                if (r6 == 0) goto L_0x0031
                r5 = 1
            L_0x0031:
                int r3 = r3 + 1
                goto L_0x0016
            L_0x0034:
                if (r4 == 0) goto L_0x003d
                if (r5 != 0) goto L_0x0039
                goto L_0x003d
            L_0x0039:
                r3 = r17
                goto L_0x00ba
            L_0x003d:
                boolean r0 = r2.moveToFirst()     // Catch:{ SQLiteException -> 0x00ce, all -> 0x00ca }
                java.lang.String r3 = "timestamp_referrer"
                java.lang.String r4 = "referrer"
                if (r0 == 0) goto L_0x0079
                int r0 = r2.getColumnIndex(r7)     // Catch:{ SQLiteException -> 0x00ce, all -> 0x00ca }
                int r5 = r2.getColumnIndex(r8)     // Catch:{ SQLiteException -> 0x00ce, all -> 0x00ca }
                com.google.android.apps.analytics.Referrer r6 = new com.google.android.apps.analytics.Referrer     // Catch:{ SQLiteException -> 0x00ce, all -> 0x00ca }
                int r10 = r2.getColumnIndex(r4)     // Catch:{ SQLiteException -> 0x00ce, all -> 0x00ca }
                java.lang.String r11 = r2.getString(r10)     // Catch:{ SQLiteException -> 0x00ce, all -> 0x00ca }
                int r10 = r2.getColumnIndex(r3)     // Catch:{ SQLiteException -> 0x00ce, all -> 0x00ca }
                long r12 = r2.getLong(r10)     // Catch:{ SQLiteException -> 0x00ce, all -> 0x00ca }
                r10 = -1
                if (r0 != r10) goto L_0x0066
                r14 = 1
                goto L_0x006b
            L_0x0066:
                int r0 = r2.getInt(r0)     // Catch:{ SQLiteException -> 0x00ce, all -> 0x00ca }
                r14 = r0
            L_0x006b:
                if (r5 != r10) goto L_0x006f
                r15 = 1
                goto L_0x0074
            L_0x006f:
                int r9 = r2.getInt(r5)     // Catch:{ SQLiteException -> 0x00ce, all -> 0x00ca }
                r15 = r9
            L_0x0074:
                r10 = r6
                r10.<init>(r11, r12, r14, r15)     // Catch:{ SQLiteException -> 0x00ce, all -> 0x00ca }
                goto L_0x007a
            L_0x0079:
                r6 = r1
            L_0x007a:
                r17.beginTransaction()     // Catch:{ SQLiteException -> 0x00ce, all -> 0x00ca }
                r16.createReferrerTable(r17)     // Catch:{ SQLiteException -> 0x00ce, all -> 0x00ca }
                if (r6 == 0) goto L_0x00b5
                android.content.ContentValues r0 = new android.content.ContentValues     // Catch:{ SQLiteException -> 0x00ce, all -> 0x00ca }
                r0.<init>()     // Catch:{ SQLiteException -> 0x00ce, all -> 0x00ca }
                java.lang.String r5 = r6.getReferrerString()     // Catch:{ SQLiteException -> 0x00ce, all -> 0x00ca }
                r0.put(r4, r5)     // Catch:{ SQLiteException -> 0x00ce, all -> 0x00ca }
                long r9 = r6.getTimeStamp()     // Catch:{ SQLiteException -> 0x00ce, all -> 0x00ca }
                java.lang.Long r5 = java.lang.Long.valueOf(r9)     // Catch:{ SQLiteException -> 0x00ce, all -> 0x00ca }
                r0.put(r3, r5)     // Catch:{ SQLiteException -> 0x00ce, all -> 0x00ca }
                int r3 = r6.getVisit()     // Catch:{ SQLiteException -> 0x00ce, all -> 0x00ca }
                java.lang.Integer r3 = java.lang.Integer.valueOf(r3)     // Catch:{ SQLiteException -> 0x00ce, all -> 0x00ca }
                r0.put(r7, r3)     // Catch:{ SQLiteException -> 0x00ce, all -> 0x00ca }
                int r3 = r6.getIndex()     // Catch:{ SQLiteException -> 0x00ce, all -> 0x00ca }
                java.lang.Integer r3 = java.lang.Integer.valueOf(r3)     // Catch:{ SQLiteException -> 0x00ce, all -> 0x00ca }
                r0.put(r8, r3)     // Catch:{ SQLiteException -> 0x00ce, all -> 0x00ca }
                r3 = r17
                r3.insert(r4, r1, r0)     // Catch:{ SQLiteException -> 0x00c8, all -> 0x00c6 }
                goto L_0x00b7
            L_0x00b5:
                r3 = r17
            L_0x00b7:
                r17.setTransactionSuccessful()     // Catch:{ SQLiteException -> 0x00c8, all -> 0x00c6 }
            L_0x00ba:
                if (r2 == 0) goto L_0x00bf
                r2.close()
            L_0x00bf:
                boolean r0 = r17.inTransaction()
                if (r0 == 0) goto L_0x00f2
                goto L_0x00ef
            L_0x00c6:
                r0 = move-exception
                goto L_0x00f5
            L_0x00c8:
                r0 = move-exception
                goto L_0x00d1
            L_0x00ca:
                r0 = move-exception
                r3 = r17
                goto L_0x00f5
            L_0x00ce:
                r0 = move-exception
                r3 = r17
            L_0x00d1:
                r1 = r2
                goto L_0x00db
            L_0x00d3:
                r0 = move-exception
                r3 = r17
            L_0x00d6:
                r2 = r1
                goto L_0x00f5
            L_0x00d8:
                r0 = move-exception
                r3 = r17
            L_0x00db:
                java.lang.String r2 = "GoogleAnalyticsTracker"
                java.lang.String r0 = r0.toString()     // Catch:{ all -> 0x00f3 }
                android.util.Log.e(r2, r0)     // Catch:{ all -> 0x00f3 }
                if (r1 == 0) goto L_0x00e9
                r1.close()
            L_0x00e9:
                boolean r0 = r17.inTransaction()
                if (r0 == 0) goto L_0x00f2
            L_0x00ef:
                boolean unused = com.google.android.apps.analytics.PersistentHitStore.endTransaction(r17)
            L_0x00f2:
                return
            L_0x00f3:
                r0 = move-exception
                goto L_0x00d6
            L_0x00f5:
                if (r2 == 0) goto L_0x00fa
                r2.close()
            L_0x00fa:
                boolean r1 = r17.inTransaction()
                if (r1 == 0) goto L_0x0103
                boolean unused = com.google.android.apps.analytics.PersistentHitStore.endTransaction(r17)
            L_0x0103:
                throw r0
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.android.apps.analytics.PersistentHitStore.DataBaseHelper.fixReferrerTable(android.database.sqlite.SQLiteDatabase):void");
        }

        private void migrateEventsToHits(SQLiteDatabase sQLiteDatabase, int i) {
            this.store.loadExistingSession(sQLiteDatabase);
            PersistentHitStore persistentHitStore = this.store;
            CustomVariableBuffer unused = persistentHitStore.visitorCVCache = persistentHitStore.getVisitorVarBuffer(sQLiteDatabase);
            Event[] peekEvents = this.store.peekEvents(1000, sQLiteDatabase, i);
            for (Event access$800 : peekEvents) {
                this.store.putEvent(access$800, sQLiteDatabase, false);
            }
            sQLiteDatabase.execSQL("DELETE from events;");
            sQLiteDatabase.execSQL("DELETE from item_events;");
            sQLiteDatabase.execSQL("DELETE from transaction_events;");
            sQLiteDatabase.execSQL("DELETE from custom_variables;");
        }

        /* JADX WARNING: Removed duplicated region for block: B:33:0x008b  */
        /* JADX WARNING: Removed duplicated region for block: B:35:0x0090  */
        /* JADX WARNING: Removed duplicated region for block: B:39:0x0098  */
        /* JADX WARNING: Removed duplicated region for block: B:41:0x009d  */
        /* JADX WARNING: Removed duplicated region for block: B:46:? A[RETURN, SYNTHETIC] */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        private void migratePreV4Referrer(android.database.sqlite.SQLiteDatabase r16) {
            /*
                r15 = this;
                java.lang.String r0 = "referrer"
                r1 = 0
                java.lang.String r3 = "install_referrer"
                java.lang.String[] r4 = new java.lang.String[]{r0}     // Catch:{ SQLiteException -> 0x007e, all -> 0x007a }
                r5 = 0
                r6 = 0
                r7 = 0
                r8 = 0
                r9 = 0
                r2 = r16
                android.database.Cursor r2 = r2.query(r3, r4, r5, r6, r7, r8, r9)     // Catch:{ SQLiteException -> 0x007e, all -> 0x007a }
                r3 = 0
                boolean r5 = r2.moveToFirst()     // Catch:{ SQLiteException -> 0x0076, all -> 0x0073 }
                if (r5 == 0) goto L_0x0068
                r5 = 0
                java.lang.String r6 = r2.getString(r5)     // Catch:{ SQLiteException -> 0x0076, all -> 0x0073 }
                java.lang.String r8 = "session"
                r9 = 0
                r10 = 0
                r11 = 0
                r12 = 0
                r13 = 0
                r14 = 0
                r7 = r16
                android.database.Cursor r7 = r7.query(r8, r9, r10, r11, r12, r13, r14)     // Catch:{ SQLiteException -> 0x0076, all -> 0x0073 }
                boolean r8 = r7.moveToFirst()     // Catch:{ SQLiteException -> 0x0066, all -> 0x0064 }
                if (r8 == 0) goto L_0x0039
                long r3 = r7.getLong(r5)     // Catch:{ SQLiteException -> 0x0066, all -> 0x0064 }
            L_0x0039:
                android.content.ContentValues r5 = new android.content.ContentValues     // Catch:{ SQLiteException -> 0x0066, all -> 0x0064 }
                r5.<init>()     // Catch:{ SQLiteException -> 0x0066, all -> 0x0064 }
                r5.put(r0, r6)     // Catch:{ SQLiteException -> 0x0066, all -> 0x0064 }
                java.lang.String r6 = "timestamp_referrer"
                java.lang.Long r3 = java.lang.Long.valueOf(r3)     // Catch:{ SQLiteException -> 0x0066, all -> 0x0064 }
                r5.put(r6, r3)     // Catch:{ SQLiteException -> 0x0066, all -> 0x0064 }
                java.lang.String r3 = "referrer_visit"
                r4 = 1
                java.lang.Integer r6 = java.lang.Integer.valueOf(r4)     // Catch:{ SQLiteException -> 0x0066, all -> 0x0064 }
                r5.put(r3, r6)     // Catch:{ SQLiteException -> 0x0066, all -> 0x0064 }
                java.lang.String r3 = "referrer_index"
                java.lang.Integer r4 = java.lang.Integer.valueOf(r4)     // Catch:{ SQLiteException -> 0x0066, all -> 0x0064 }
                r5.put(r3, r4)     // Catch:{ SQLiteException -> 0x0066, all -> 0x0064 }
                r3 = r16
                r3.insert(r0, r1, r5)     // Catch:{ SQLiteException -> 0x0066, all -> 0x0064 }
                r1 = r7
                goto L_0x0068
            L_0x0064:
                r0 = move-exception
                goto L_0x0096
            L_0x0066:
                r0 = move-exception
                goto L_0x0078
            L_0x0068:
                if (r2 == 0) goto L_0x006d
                r2.close()
            L_0x006d:
                if (r1 == 0) goto L_0x0093
                r1.close()
                goto L_0x0093
            L_0x0073:
                r0 = move-exception
                r7 = r1
                goto L_0x0096
            L_0x0076:
                r0 = move-exception
                r7 = r1
            L_0x0078:
                r1 = r2
                goto L_0x0080
            L_0x007a:
                r0 = move-exception
                r2 = r1
                r7 = r2
                goto L_0x0096
            L_0x007e:
                r0 = move-exception
                r7 = r1
            L_0x0080:
                java.lang.String r2 = "GoogleAnalyticsTracker"
                java.lang.String r0 = r0.toString()     // Catch:{ all -> 0x0094 }
                android.util.Log.e(r2, r0)     // Catch:{ all -> 0x0094 }
                if (r1 == 0) goto L_0x008e
                r1.close()
            L_0x008e:
                if (r7 == 0) goto L_0x0093
                r7.close()
            L_0x0093:
                return
            L_0x0094:
                r0 = move-exception
                r2 = r1
            L_0x0096:
                if (r2 == 0) goto L_0x009b
                r2.close()
            L_0x009b:
                if (r7 == 0) goto L_0x00a0
                r7.close()
            L_0x00a0:
                throw r0
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.android.apps.analytics.PersistentHitStore.DataBaseHelper.migratePreV4Referrer(android.database.sqlite.SQLiteDatabase):void");
        }

        /* access modifiers changed from: package-private */
        public void createCustomVariableTables(SQLiteDatabase sQLiteDatabase) {
            sQLiteDatabase.execSQL("DROP TABLE IF EXISTS custom_variables;");
            sQLiteDatabase.execSQL(PersistentHitStore.CREATE_CUSTOM_VARIABLES_TABLE);
            sQLiteDatabase.execSQL("DROP TABLE IF EXISTS custom_var_cache;");
            sQLiteDatabase.execSQL(PersistentHitStore.CREATE_CUSTOM_VAR_CACHE_TABLE);
            for (int i = 1; i <= 5; i++) {
                ContentValues contentValues = new ContentValues();
                contentValues.put(PersistentHitStore.EVENT_ID, 0);
                contentValues.put(PersistentHitStore.CUSTOMVAR_INDEX, Integer.valueOf(i));
                contentValues.put(PersistentHitStore.CUSTOMVAR_NAME, "");
                contentValues.put(PersistentHitStore.CUSTOMVAR_SCOPE, 3);
                contentValues.put(PersistentHitStore.CUSTOMVAR_VALUE, "");
                sQLiteDatabase.insert("custom_var_cache", PersistentHitStore.EVENT_ID, contentValues);
            }
        }

        public void onCreate(SQLiteDatabase sQLiteDatabase) {
            sQLiteDatabase.execSQL("DROP TABLE IF EXISTS events;");
            sQLiteDatabase.execSQL(PersistentHitStore.CREATE_EVENTS_TABLE);
            sQLiteDatabase.execSQL("DROP TABLE IF EXISTS install_referrer;");
            sQLiteDatabase.execSQL(PersistentHitStore.CREATE_INSTALL_REFERRER_TABLE);
            sQLiteDatabase.execSQL("DROP TABLE IF EXISTS session;");
            sQLiteDatabase.execSQL(PersistentHitStore.CREATE_SESSION_TABLE);
            if (this.databaseVersion > 1) {
                createCustomVariableTables(sQLiteDatabase);
            }
            if (this.databaseVersion > 2) {
                createECommerceTables(sQLiteDatabase);
            }
            if (this.databaseVersion > 3) {
                createHitTable(sQLiteDatabase);
                createReferrerTable(sQLiteDatabase);
            }
        }

        public void onDowngrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
            Log.w(GoogleAnalyticsTracker.LOG_TAG, "Downgrading database version from " + i + " to " + i2 + " not recommended.");
            sQLiteDatabase.execSQL(PersistentHitStore.CREATE_REFERRER_TABLE);
            sQLiteDatabase.execSQL(PersistentHitStore.CREATE_HITS_TABLE);
            sQLiteDatabase.execSQL(PersistentHitStore.CREATE_CUSTOM_VAR_CACHE_TABLE);
            sQLiteDatabase.execSQL(PersistentHitStore.CREATE_SESSION_TABLE);
            HashSet hashSet = new HashSet();
            Cursor query = sQLiteDatabase.query("custom_var_cache", (String[]) null, (String) null, (String[]) null, (String) null, (String) null, (String) null, (String) null);
            while (query.moveToNext()) {
                try {
                    hashSet.add(Integer.valueOf(query.getInt(query.getColumnIndex(PersistentHitStore.CUSTOMVAR_INDEX))));
                } catch (SQLiteException e) {
                    Log.e(GoogleAnalyticsTracker.LOG_TAG, "Error on downgrade: " + e.toString());
                } catch (Throwable th) {
                    query.close();
                    throw th;
                }
            }
            query.close();
            for (int i3 = 1; i3 <= 5; i3++) {
                try {
                    if (!hashSet.contains(Integer.valueOf(i3))) {
                        ContentValues contentValues = new ContentValues();
                        contentValues.put(PersistentHitStore.EVENT_ID, 0);
                        contentValues.put(PersistentHitStore.CUSTOMVAR_INDEX, Integer.valueOf(i3));
                        contentValues.put(PersistentHitStore.CUSTOMVAR_NAME, "");
                        contentValues.put(PersistentHitStore.CUSTOMVAR_SCOPE, 3);
                        contentValues.put(PersistentHitStore.CUSTOMVAR_VALUE, "");
                        sQLiteDatabase.insert("custom_var_cache", PersistentHitStore.EVENT_ID, contentValues);
                    }
                } catch (SQLiteException e2) {
                    Log.e(GoogleAnalyticsTracker.LOG_TAG, "Error inserting custom variable on downgrade: " + e2.toString());
                }
            }
        }

        public void onOpen(SQLiteDatabase sQLiteDatabase) {
            if (sQLiteDatabase.isReadOnly()) {
                Log.w(GoogleAnalyticsTracker.LOG_TAG, "Warning: Need to update database, but it's read only.");
            } else {
                fixReferrerTable(sQLiteDatabase);
            }
        }

        public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
            if (i > i2) {
                onDowngrade(sQLiteDatabase, i, i2);
                return;
            }
            if (i < 2 && i2 > 1) {
                createCustomVariableTables(sQLiteDatabase);
            }
            if (i < 3 && i2 > 2) {
                createECommerceTables(sQLiteDatabase);
            }
            if (i < 4 && i2 > 3) {
                createHitTable(sQLiteDatabase);
                createReferrerTable(sQLiteDatabase);
                migrateEventsToHits(sQLiteDatabase, i);
                migratePreV4Referrer(sQLiteDatabase);
            }
        }
    }

    static {
        StringBuilder sb = new StringBuilder();
        sb.append("CREATE TABLE IF NOT EXISTS session (");
        sb.append(String.format(" '%s' INTEGER PRIMARY KEY,", new Object[]{TIMESTAMP_FIRST}));
        sb.append(String.format(" '%s' INTEGER NOT NULL,", new Object[]{TIMESTAMP_PREVIOUS}));
        sb.append(String.format(" '%s' INTEGER NOT NULL,", new Object[]{TIMESTAMP_CURRENT}));
        sb.append(String.format(" '%s' INTEGER NOT NULL,", new Object[]{VISITS}));
        sb.append(String.format(" '%s' INTEGER NOT NULL);", new Object[]{STORE_ID}));
        CREATE_SESSION_TABLE = sb.toString();
        StringBuilder sb2 = new StringBuilder();
        sb2.append("CREATE TABLE IF NOT EXISTS hits (");
        sb2.append(String.format(" '%s' INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL,", new Object[]{HIT_ID}));
        sb2.append(String.format(" '%s' TEXT NOT NULL,", new Object[]{HIT_STRING}));
        sb2.append(String.format(" '%s' INTEGER NOT NULL);", new Object[]{HIT_TIMESTAMP}));
        CREATE_HITS_TABLE = sb2.toString();
    }

    PersistentHitStore(Context context) {
        this(context, DATABASE_NAME, 5);
    }

    PersistentHitStore(Context context, String str) {
        this(context, str, 5);
    }

    PersistentHitStore(Context context, String str, int i) {
        this.sampleRate = 100;
        this.random = new Random();
        this.databaseHelper = new DataBaseHelper(context, str, i, this);
        loadExistingSession();
        this.visitorCVCache = getVisitorVarBuffer();
    }

    PersistentHitStore(DataBaseHelper dataBaseHelper) {
        this.sampleRate = 100;
        this.random = new Random();
        this.databaseHelper = dataBaseHelper;
        loadExistingSession();
        this.visitorCVCache = getVisitorVarBuffer();
    }

    /* access modifiers changed from: private */
    public static boolean endTransaction(SQLiteDatabase sQLiteDatabase) {
        try {
            sQLiteDatabase.endTransaction();
            return true;
        } catch (SQLiteException e) {
            Log.e(GoogleAnalyticsTracker.LOG_TAG, "exception ending transaction:" + e.toString());
            return false;
        }
    }

    static String formatReferrer(String str) {
        if (str == null) {
            return null;
        }
        if (!str.contains("=")) {
            if (str.contains("%3D")) {
                try {
                    str = URLDecoder.decode(str, "UTF-8");
                } catch (UnsupportedEncodingException unused) {
                }
            }
            return null;
        }
        Map<String, String> parseURLParameters = Utils.parseURLParameters(str);
        boolean z = parseURLParameters.get("utm_campaign") != null;
        boolean z2 = parseURLParameters.get("utm_medium") != null;
        boolean z3 = parseURLParameters.get("utm_source") != null;
        if ((parseURLParameters.get("gclid") != null) || (z && z2 && z3)) {
            String[][] strArr = {new String[]{"utmcid", parseURLParameters.get("utm_id")}, new String[]{"utmcsr", parseURLParameters.get("utm_source")}, new String[]{"utmgclid", parseURLParameters.get("gclid")}, new String[]{"utmccn", parseURLParameters.get("utm_campaign")}, new String[]{"utmcmd", parseURLParameters.get("utm_medium")}, new String[]{"utmctr", parseURLParameters.get("utm_term")}, new String[]{"utmcct", parseURLParameters.get("utm_content")}};
            StringBuilder sb = new StringBuilder();
            boolean z4 = true;
            for (int i = 0; i < strArr.length; i++) {
                if (strArr[i][1] != null) {
                    String replace = strArr[i][1].replace("+", "%20").replace(MinimalPrettyPrinter.DEFAULT_ROOT_VALUE_SEPARATOR, "%20");
                    if (z4) {
                        z4 = false;
                    } else {
                        sb.append("|");
                    }
                    sb.append(strArr[i][0]);
                    sb.append("=");
                    sb.append(replace);
                }
            }
            return sb.toString();
        }
        Log.w(GoogleAnalyticsTracker.LOG_TAG, "Badly formatted referrer missing campaign, medium and source or click ID");
        return null;
    }

    private Referrer getAndUpdateReferrer(SQLiteDatabase sQLiteDatabase) {
        Referrer readCurrentReferrer = readCurrentReferrer(sQLiteDatabase);
        if (readCurrentReferrer == null) {
            return null;
        }
        if (readCurrentReferrer.getTimeStamp() != 0) {
            return readCurrentReferrer;
        }
        int index = readCurrentReferrer.getIndex();
        String referrerString = readCurrentReferrer.getReferrerString();
        ContentValues contentValues = new ContentValues();
        contentValues.put("referrer", referrerString);
        contentValues.put(TIMESTAMP_REFERRER, Long.valueOf(this.timestampCurrent));
        contentValues.put(REFERRER_VISIT, Integer.valueOf(this.visits));
        contentValues.put(REFERRER_INDEX, Integer.valueOf(index));
        if (setReferrerDatabase(sQLiteDatabase, contentValues)) {
            return new Referrer(referrerString, this.timestampCurrent, this.visits, index);
        }
        return null;
    }

    /* access modifiers changed from: private */
    public void putEvent(Event event, SQLiteDatabase sQLiteDatabase, boolean z) {
        if (!event.isSessionInitialized()) {
            event.setRandomVal(this.random.nextInt(Integer.MAX_VALUE));
            event.setTimestampFirst((int) this.timestampFirst);
            event.setTimestampPrevious((int) this.timestampPrevious);
            event.setTimestampCurrent((int) this.timestampCurrent);
            event.setVisits(this.visits);
        }
        event.setAnonymizeIp(this.anonymizeIp);
        if (event.getUserId() == -1) {
            event.setUserId(this.storeId);
        }
        putCustomVariables(event, sQLiteDatabase);
        Referrer andUpdateReferrer = getAndUpdateReferrer(sQLiteDatabase);
        String[] split = event.accountId.split(",");
        if (split.length == 1) {
            writeEventToDatabase(event, andUpdateReferrer, sQLiteDatabase, z);
            return;
        }
        for (String event2 : split) {
            writeEventToDatabase(new Event(event, event2), andUpdateReferrer, sQLiteDatabase, z);
        }
    }

    private boolean setReferrerDatabase(SQLiteDatabase sQLiteDatabase, ContentValues contentValues) {
        try {
            sQLiteDatabase.beginTransaction();
            sQLiteDatabase.delete("referrer", (String) null, (String[]) null);
            sQLiteDatabase.insert("referrer", (String) null, contentValues);
            sQLiteDatabase.setTransactionSuccessful();
            return !sQLiteDatabase.inTransaction() || endTransaction(sQLiteDatabase);
        } catch (SQLiteException e) {
            Log.e(GoogleAnalyticsTracker.LOG_TAG, e.toString());
            if (!sQLiteDatabase.inTransaction() || !endTransaction(sQLiteDatabase)) {
            }
            return false;
        } catch (Throwable th) {
            if (sQLiteDatabase.inTransaction() && !endTransaction(sQLiteDatabase)) {
                return false;
            }
            throw th;
        }
    }

    public void clearReferrer() {
        try {
            this.databaseHelper.getWritableDatabase().delete("referrer", (String) null, (String[]) null);
        } catch (SQLiteException e) {
            Log.e(GoogleAnalyticsTracker.LOG_TAG, e.toString());
        }
    }

    public synchronized void deleteHit(long j) {
        try {
            this.numStoredHits -= this.databaseHelper.getWritableDatabase().delete("hits", "hit_id = ?", new String[]{Long.toString(j)});
        } catch (SQLiteException e) {
            Log.e(GoogleAnalyticsTracker.LOG_TAG, e.toString());
        }
        return;
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Code restructure failed: missing block: B:12:0x0063, code lost:
        if (r1 == null) goto L_0x0068;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:13:0x0065, code lost:
        r1.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:14:0x0068, code lost:
        return r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:6:0x0054, code lost:
        if (r1 != null) goto L_0x0065;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public com.google.android.apps.analytics.CustomVariableBuffer getCustomVariables(long r11, android.database.sqlite.SQLiteDatabase r13) {
        /*
            r10 = this;
            com.google.android.apps.analytics.CustomVariableBuffer r0 = new com.google.android.apps.analytics.CustomVariableBuffer
            r0.<init>()
            r1 = 0
            java.lang.String r3 = "custom_variables"
            r4 = 0
            java.lang.String r5 = "event_id= ?"
            r2 = 1
            java.lang.String[] r6 = new java.lang.String[r2]     // Catch:{ SQLiteException -> 0x0059 }
            r2 = 0
            java.lang.String r11 = java.lang.Long.toString(r11)     // Catch:{ SQLiteException -> 0x0059 }
            r6[r2] = r11     // Catch:{ SQLiteException -> 0x0059 }
            r7 = 0
            r8 = 0
            r9 = 0
            r2 = r13
            android.database.Cursor r1 = r2.query(r3, r4, r5, r6, r7, r8, r9)     // Catch:{ SQLiteException -> 0x0059 }
        L_0x001d:
            boolean r11 = r1.moveToNext()     // Catch:{ SQLiteException -> 0x0059 }
            if (r11 == 0) goto L_0x0054
            com.google.android.apps.analytics.CustomVariable r11 = new com.google.android.apps.analytics.CustomVariable     // Catch:{ SQLiteException -> 0x0059 }
            java.lang.String r12 = "cv_index"
            int r12 = r1.getColumnIndex(r12)     // Catch:{ SQLiteException -> 0x0059 }
            int r12 = r1.getInt(r12)     // Catch:{ SQLiteException -> 0x0059 }
            java.lang.String r13 = "cv_name"
            int r13 = r1.getColumnIndex(r13)     // Catch:{ SQLiteException -> 0x0059 }
            java.lang.String r13 = r1.getString(r13)     // Catch:{ SQLiteException -> 0x0059 }
            java.lang.String r2 = "cv_value"
            int r2 = r1.getColumnIndex(r2)     // Catch:{ SQLiteException -> 0x0059 }
            java.lang.String r2 = r1.getString(r2)     // Catch:{ SQLiteException -> 0x0059 }
            java.lang.String r3 = "cv_scope"
            int r3 = r1.getColumnIndex(r3)     // Catch:{ SQLiteException -> 0x0059 }
            int r3 = r1.getInt(r3)     // Catch:{ SQLiteException -> 0x0059 }
            r11.<init>(r12, r13, r2, r3)     // Catch:{ SQLiteException -> 0x0059 }
            r0.setCustomVariable(r11)     // Catch:{ SQLiteException -> 0x0059 }
            goto L_0x001d
        L_0x0054:
            if (r1 == 0) goto L_0x0068
            goto L_0x0065
        L_0x0057:
            r11 = move-exception
            goto L_0x0069
        L_0x0059:
            r11 = move-exception
            java.lang.String r12 = "GoogleAnalyticsTracker"
            java.lang.String r11 = r11.toString()     // Catch:{ all -> 0x0057 }
            android.util.Log.e(r12, r11)     // Catch:{ all -> 0x0057 }
            if (r1 == 0) goto L_0x0068
        L_0x0065:
            r1.close()
        L_0x0068:
            return r0
        L_0x0069:
            if (r1 == 0) goto L_0x006e
            r1.close()
        L_0x006e:
            throw r11
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.apps.analytics.PersistentHitStore.getCustomVariables(long, android.database.sqlite.SQLiteDatabase):com.google.android.apps.analytics.CustomVariableBuffer");
    }

    /* access modifiers changed from: package-private */
    public DataBaseHelper getDatabaseHelper() {
        return this.databaseHelper;
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Code restructure failed: missing block: B:10:0x0072, code lost:
        if (r10 != null) goto L_0x0087;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:19:0x0085, code lost:
        if (r10 != null) goto L_0x0087;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:20:0x0087, code lost:
        r10.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:21:0x008a, code lost:
        return null;
     */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x008e  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public com.google.android.apps.analytics.Item getItem(long r10, android.database.sqlite.SQLiteDatabase r12) {
        /*
            r9 = this;
            r0 = 0
            java.lang.String r2 = "item_events"
            r3 = 0
            java.lang.String r4 = "event_id= ?"
            r1 = 1
            java.lang.String[] r5 = new java.lang.String[r1]     // Catch:{ SQLiteException -> 0x007a, all -> 0x0077 }
            r1 = 0
            java.lang.String r10 = java.lang.Long.toString(r10)     // Catch:{ SQLiteException -> 0x007a, all -> 0x0077 }
            r5[r1] = r10     // Catch:{ SQLiteException -> 0x007a, all -> 0x0077 }
            r6 = 0
            r7 = 0
            r8 = 0
            r1 = r12
            android.database.Cursor r10 = r1.query(r2, r3, r4, r5, r6, r7, r8)     // Catch:{ SQLiteException -> 0x007a, all -> 0x0077 }
            boolean r11 = r10.moveToFirst()     // Catch:{ SQLiteException -> 0x0075 }
            if (r11 == 0) goto L_0x0072
            com.google.android.apps.analytics.Item$Builder r11 = new com.google.android.apps.analytics.Item$Builder     // Catch:{ SQLiteException -> 0x0075 }
            java.lang.String r12 = "order_id"
            int r12 = r10.getColumnIndex(r12)     // Catch:{ SQLiteException -> 0x0075 }
            java.lang.String r2 = r10.getString(r12)     // Catch:{ SQLiteException -> 0x0075 }
            java.lang.String r12 = "item_sku"
            int r12 = r10.getColumnIndex(r12)     // Catch:{ SQLiteException -> 0x0075 }
            java.lang.String r3 = r10.getString(r12)     // Catch:{ SQLiteException -> 0x0075 }
            java.lang.String r12 = "item_price"
            int r12 = r10.getColumnIndex(r12)     // Catch:{ SQLiteException -> 0x0075 }
            double r4 = r10.getDouble(r12)     // Catch:{ SQLiteException -> 0x0075 }
            java.lang.String r12 = "item_count"
            int r12 = r10.getColumnIndex(r12)     // Catch:{ SQLiteException -> 0x0075 }
            long r6 = r10.getLong(r12)     // Catch:{ SQLiteException -> 0x0075 }
            r1 = r11
            r1.<init>(r2, r3, r4, r6)     // Catch:{ SQLiteException -> 0x0075 }
            java.lang.String r12 = "item_name"
            int r12 = r10.getColumnIndex(r12)     // Catch:{ SQLiteException -> 0x0075 }
            java.lang.String r12 = r10.getString(r12)     // Catch:{ SQLiteException -> 0x0075 }
            com.google.android.apps.analytics.Item$Builder r11 = r11.setItemName(r12)     // Catch:{ SQLiteException -> 0x0075 }
            java.lang.String r12 = "item_category"
            int r12 = r10.getColumnIndex(r12)     // Catch:{ SQLiteException -> 0x0075 }
            java.lang.String r12 = r10.getString(r12)     // Catch:{ SQLiteException -> 0x0075 }
            com.google.android.apps.analytics.Item$Builder r11 = r11.setItemCategory(r12)     // Catch:{ SQLiteException -> 0x0075 }
            com.google.android.apps.analytics.Item r11 = r11.build()     // Catch:{ SQLiteException -> 0x0075 }
            if (r10 == 0) goto L_0x0071
            r10.close()
        L_0x0071:
            return r11
        L_0x0072:
            if (r10 == 0) goto L_0x008a
            goto L_0x0087
        L_0x0075:
            r11 = move-exception
            goto L_0x007c
        L_0x0077:
            r11 = move-exception
            r10 = r0
            goto L_0x008c
        L_0x007a:
            r11 = move-exception
            r10 = r0
        L_0x007c:
            java.lang.String r12 = "GoogleAnalyticsTracker"
            java.lang.String r11 = r11.toString()     // Catch:{ all -> 0x008b }
            android.util.Log.e(r12, r11)     // Catch:{ all -> 0x008b }
            if (r10 == 0) goto L_0x008a
        L_0x0087:
            r10.close()
        L_0x008a:
            return r0
        L_0x008b:
            r11 = move-exception
        L_0x008c:
            if (r10 == 0) goto L_0x0091
            r10.close()
        L_0x0091:
            throw r11
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.apps.analytics.PersistentHitStore.getItem(long, android.database.sqlite.SQLiteDatabase):com.google.android.apps.analytics.Item");
    }

    public int getNumStoredHits() {
        return this.numStoredHits;
    }

    /* JADX WARNING: type inference failed for: r0v0, types: [java.lang.String[], android.database.Cursor] */
    /* JADX WARNING: type inference failed for: r0v1, types: [android.database.Cursor] */
    /* JADX WARNING: type inference failed for: r0v2, types: [android.database.Cursor] */
    /* JADX WARNING: Code restructure failed: missing block: B:13:0x002c, code lost:
        if (r0 == 0) goto L_0x002f;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:14:0x002f, code lost:
        return r1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:6:0x001a, code lost:
        if (r0 != 0) goto L_0x001c;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:7:0x001c, code lost:
        r0.close();
     */
    /* JADX WARNING: Failed to insert additional move for type inference */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public int getNumStoredHitsFromDb() {
        /*
            r4 = this;
            r0 = 0
            r1 = 0
            com.google.android.apps.analytics.PersistentHitStore$DataBaseHelper r2 = r4.databaseHelper     // Catch:{ SQLiteException -> 0x0022 }
            android.database.sqlite.SQLiteDatabase r2 = r2.getReadableDatabase()     // Catch:{ SQLiteException -> 0x0022 }
            java.lang.String r3 = "SELECT COUNT(*) from hits"
            android.database.Cursor r0 = r2.rawQuery(r3, r0)     // Catch:{ SQLiteException -> 0x0022 }
            boolean r2 = r0.moveToFirst()     // Catch:{ SQLiteException -> 0x0022 }
            if (r2 == 0) goto L_0x001a
            long r1 = r0.getLong(r1)     // Catch:{ SQLiteException -> 0x0022 }
            int r2 = (int) r1
            r1 = r2
        L_0x001a:
            if (r0 == 0) goto L_0x002f
        L_0x001c:
            r0.close()
            goto L_0x002f
        L_0x0020:
            r1 = move-exception
            goto L_0x0030
        L_0x0022:
            r2 = move-exception
            java.lang.String r3 = "GoogleAnalyticsTracker"
            java.lang.String r2 = r2.toString()     // Catch:{ all -> 0x0020 }
            android.util.Log.e(r3, r2)     // Catch:{ all -> 0x0020 }
            if (r0 == 0) goto L_0x002f
            goto L_0x001c
        L_0x002f:
            return r1
        L_0x0030:
            if (r0 == 0) goto L_0x0035
            r0.close()
        L_0x0035:
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.apps.analytics.PersistentHitStore.getNumStoredHitsFromDb():int");
    }

    public Referrer getReferrer() {
        try {
            return readCurrentReferrer(this.databaseHelper.getReadableDatabase());
        } catch (SQLiteException e) {
            Log.e(GoogleAnalyticsTracker.LOG_TAG, e.toString());
            return null;
        }
    }

    public String getSessionId() {
        if (!this.sessionStarted) {
            return null;
        }
        return Integer.toString((int) this.timestampCurrent);
    }

    public int getStoreId() {
        return this.storeId;
    }

    /* access modifiers changed from: package-private */
    public long getTimestampCurrent() {
        return this.timestampCurrent;
    }

    /* access modifiers changed from: package-private */
    public long getTimestampFirst() {
        return this.timestampFirst;
    }

    /* access modifiers changed from: package-private */
    public long getTimestampPrevious() {
        return this.timestampPrevious;
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Code restructure failed: missing block: B:10:0x006b, code lost:
        if (r10 != null) goto L_0x0080;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:19:0x007e, code lost:
        if (r10 != null) goto L_0x0080;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:20:0x0080, code lost:
        r10.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:21:0x0083, code lost:
        return null;
     */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x0087  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public com.google.android.apps.analytics.Transaction getTransaction(long r10, android.database.sqlite.SQLiteDatabase r12) {
        /*
            r9 = this;
            r0 = 0
            java.lang.String r2 = "transaction_events"
            r3 = 0
            java.lang.String r4 = "event_id= ?"
            r1 = 1
            java.lang.String[] r5 = new java.lang.String[r1]     // Catch:{ SQLiteException -> 0x0073, all -> 0x0070 }
            r1 = 0
            java.lang.String r10 = java.lang.Long.toString(r10)     // Catch:{ SQLiteException -> 0x0073, all -> 0x0070 }
            r5[r1] = r10     // Catch:{ SQLiteException -> 0x0073, all -> 0x0070 }
            r6 = 0
            r7 = 0
            r8 = 0
            r1 = r12
            android.database.Cursor r10 = r1.query(r2, r3, r4, r5, r6, r7, r8)     // Catch:{ SQLiteException -> 0x0073, all -> 0x0070 }
            boolean r11 = r10.moveToFirst()     // Catch:{ SQLiteException -> 0x006e }
            if (r11 == 0) goto L_0x006b
            com.google.android.apps.analytics.Transaction$Builder r11 = new com.google.android.apps.analytics.Transaction$Builder     // Catch:{ SQLiteException -> 0x006e }
            java.lang.String r12 = "order_id"
            int r12 = r10.getColumnIndex(r12)     // Catch:{ SQLiteException -> 0x006e }
            java.lang.String r12 = r10.getString(r12)     // Catch:{ SQLiteException -> 0x006e }
            java.lang.String r1 = "tran_totalcost"
            int r1 = r10.getColumnIndex(r1)     // Catch:{ SQLiteException -> 0x006e }
            double r1 = r10.getDouble(r1)     // Catch:{ SQLiteException -> 0x006e }
            r11.<init>(r12, r1)     // Catch:{ SQLiteException -> 0x006e }
            java.lang.String r12 = "tran_storename"
            int r12 = r10.getColumnIndex(r12)     // Catch:{ SQLiteException -> 0x006e }
            java.lang.String r12 = r10.getString(r12)     // Catch:{ SQLiteException -> 0x006e }
            com.google.android.apps.analytics.Transaction$Builder r11 = r11.setStoreName(r12)     // Catch:{ SQLiteException -> 0x006e }
            java.lang.String r12 = "tran_totaltax"
            int r12 = r10.getColumnIndex(r12)     // Catch:{ SQLiteException -> 0x006e }
            double r1 = r10.getDouble(r12)     // Catch:{ SQLiteException -> 0x006e }
            com.google.android.apps.analytics.Transaction$Builder r11 = r11.setTotalTax(r1)     // Catch:{ SQLiteException -> 0x006e }
            java.lang.String r12 = "tran_shippingcost"
            int r12 = r10.getColumnIndex(r12)     // Catch:{ SQLiteException -> 0x006e }
            double r1 = r10.getDouble(r12)     // Catch:{ SQLiteException -> 0x006e }
            com.google.android.apps.analytics.Transaction$Builder r11 = r11.setShippingCost(r1)     // Catch:{ SQLiteException -> 0x006e }
            com.google.android.apps.analytics.Transaction r11 = r11.build()     // Catch:{ SQLiteException -> 0x006e }
            if (r10 == 0) goto L_0x006a
            r10.close()
        L_0x006a:
            return r11
        L_0x006b:
            if (r10 == 0) goto L_0x0083
            goto L_0x0080
        L_0x006e:
            r11 = move-exception
            goto L_0x0075
        L_0x0070:
            r11 = move-exception
            r10 = r0
            goto L_0x0085
        L_0x0073:
            r11 = move-exception
            r10 = r0
        L_0x0075:
            java.lang.String r12 = "GoogleAnalyticsTracker"
            java.lang.String r11 = r11.toString()     // Catch:{ all -> 0x0084 }
            android.util.Log.e(r12, r11)     // Catch:{ all -> 0x0084 }
            if (r10 == 0) goto L_0x0083
        L_0x0080:
            r10.close()
        L_0x0083:
            return r0
        L_0x0084:
            r11 = move-exception
        L_0x0085:
            if (r10 == 0) goto L_0x008a
            r10.close()
        L_0x008a:
            throw r11
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.apps.analytics.PersistentHitStore.getTransaction(long, android.database.sqlite.SQLiteDatabase):com.google.android.apps.analytics.Transaction");
    }

    public String getVisitorCustomVar(int i) {
        CustomVariable customVariableAt = this.visitorCVCache.getCustomVariableAt(i);
        if (customVariableAt == null || customVariableAt.getScope() != 1) {
            return null;
        }
        return customVariableAt.getValue();
    }

    public String getVisitorId() {
        if (!this.sessionStarted) {
            return null;
        }
        return String.format("%d.%d", new Object[]{Integer.valueOf(this.storeId), Long.valueOf(this.timestampFirst)});
    }

    /* access modifiers changed from: package-private */
    public CustomVariableBuffer getVisitorVarBuffer() {
        try {
            return getVisitorVarBuffer(this.databaseHelper.getReadableDatabase());
        } catch (SQLiteException e) {
            Log.e(GoogleAnalyticsTracker.LOG_TAG, e.toString());
            return new CustomVariableBuffer();
        }
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Code restructure failed: missing block: B:12:0x0063, code lost:
        if (r1 == null) goto L_0x0068;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:13:0x0065, code lost:
        r1.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:14:0x0068, code lost:
        return r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:6:0x0054, code lost:
        if (r1 != null) goto L_0x0065;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public com.google.android.apps.analytics.CustomVariableBuffer getVisitorVarBuffer(android.database.sqlite.SQLiteDatabase r11) {
        /*
            r10 = this;
            com.google.android.apps.analytics.CustomVariableBuffer r0 = new com.google.android.apps.analytics.CustomVariableBuffer
            r0.<init>()
            r1 = 0
            java.lang.String r3 = "custom_var_cache"
            r4 = 0
            java.lang.String r5 = "cv_scope= ?"
            r2 = 1
            java.lang.String[] r6 = new java.lang.String[r2]     // Catch:{ SQLiteException -> 0x0059 }
            r7 = 0
            java.lang.String r2 = java.lang.Integer.toString(r2)     // Catch:{ SQLiteException -> 0x0059 }
            r6[r7] = r2     // Catch:{ SQLiteException -> 0x0059 }
            r7 = 0
            r8 = 0
            r9 = 0
            r2 = r11
            android.database.Cursor r1 = r2.query(r3, r4, r5, r6, r7, r8, r9)     // Catch:{ SQLiteException -> 0x0059 }
        L_0x001d:
            boolean r11 = r1.moveToNext()     // Catch:{ SQLiteException -> 0x0059 }
            if (r11 == 0) goto L_0x0054
            com.google.android.apps.analytics.CustomVariable r11 = new com.google.android.apps.analytics.CustomVariable     // Catch:{ SQLiteException -> 0x0059 }
            java.lang.String r2 = "cv_index"
            int r2 = r1.getColumnIndex(r2)     // Catch:{ SQLiteException -> 0x0059 }
            int r2 = r1.getInt(r2)     // Catch:{ SQLiteException -> 0x0059 }
            java.lang.String r3 = "cv_name"
            int r3 = r1.getColumnIndex(r3)     // Catch:{ SQLiteException -> 0x0059 }
            java.lang.String r3 = r1.getString(r3)     // Catch:{ SQLiteException -> 0x0059 }
            java.lang.String r4 = "cv_value"
            int r4 = r1.getColumnIndex(r4)     // Catch:{ SQLiteException -> 0x0059 }
            java.lang.String r4 = r1.getString(r4)     // Catch:{ SQLiteException -> 0x0059 }
            java.lang.String r5 = "cv_scope"
            int r5 = r1.getColumnIndex(r5)     // Catch:{ SQLiteException -> 0x0059 }
            int r5 = r1.getInt(r5)     // Catch:{ SQLiteException -> 0x0059 }
            r11.<init>(r2, r3, r4, r5)     // Catch:{ SQLiteException -> 0x0059 }
            r0.setCustomVariable(r11)     // Catch:{ SQLiteException -> 0x0059 }
            goto L_0x001d
        L_0x0054:
            if (r1 == 0) goto L_0x0068
            goto L_0x0065
        L_0x0057:
            r11 = move-exception
            goto L_0x0069
        L_0x0059:
            r11 = move-exception
            java.lang.String r2 = "GoogleAnalyticsTracker"
            java.lang.String r11 = r11.toString()     // Catch:{ all -> 0x0057 }
            android.util.Log.e(r2, r11)     // Catch:{ all -> 0x0057 }
            if (r1 == 0) goto L_0x0068
        L_0x0065:
            r1.close()
        L_0x0068:
            return r0
        L_0x0069:
            if (r1 == 0) goto L_0x006e
            r1.close()
        L_0x006e:
            throw r11
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.apps.analytics.PersistentHitStore.getVisitorVarBuffer(android.database.sqlite.SQLiteDatabase):com.google.android.apps.analytics.CustomVariableBuffer");
    }

    /* access modifiers changed from: package-private */
    public int getVisits() {
        return this.visits;
    }

    public void loadExistingSession() {
        try {
            loadExistingSession(this.databaseHelper.getWritableDatabase());
        } catch (SQLiteException e) {
            Log.e(GoogleAnalyticsTracker.LOG_TAG, e.toString());
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:30:0x00bf  */
    /* JADX WARNING: Removed duplicated region for block: B:34:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void loadExistingSession(android.database.sqlite.SQLiteDatabase r10) {
        /*
            r9 = this;
            r0 = 0
            java.lang.String r2 = "session"
            r3 = 0
            r4 = 0
            r5 = 0
            r6 = 0
            r7 = 0
            r8 = 0
            r1 = r10
            android.database.Cursor r1 = r1.query(r2, r3, r4, r5, r6, r7, r8)     // Catch:{ SQLiteException -> 0x00ad }
            boolean r2 = r1.moveToFirst()     // Catch:{ SQLiteException -> 0x00a8, all -> 0x00a5 }
            r3 = 1
            r4 = 0
            r5 = 0
            if (r2 == 0) goto L_0x0053
            long r7 = r1.getLong(r4)     // Catch:{ SQLiteException -> 0x00a8, all -> 0x00a5 }
            r9.timestampFirst = r7     // Catch:{ SQLiteException -> 0x00a8, all -> 0x00a5 }
            long r7 = r1.getLong(r3)     // Catch:{ SQLiteException -> 0x00a8, all -> 0x00a5 }
            r9.timestampPrevious = r7     // Catch:{ SQLiteException -> 0x00a8, all -> 0x00a5 }
            r0 = 2
            long r7 = r1.getLong(r0)     // Catch:{ SQLiteException -> 0x00a8, all -> 0x00a5 }
            r9.timestampCurrent = r7     // Catch:{ SQLiteException -> 0x00a8, all -> 0x00a5 }
            r0 = 3
            int r0 = r1.getInt(r0)     // Catch:{ SQLiteException -> 0x00a8, all -> 0x00a5 }
            r9.visits = r0     // Catch:{ SQLiteException -> 0x00a8, all -> 0x00a5 }
            r0 = 4
            int r0 = r1.getInt(r0)     // Catch:{ SQLiteException -> 0x00a8, all -> 0x00a5 }
            r9.storeId = r0     // Catch:{ SQLiteException -> 0x00a8, all -> 0x00a5 }
            com.google.android.apps.analytics.Referrer r10 = r9.readCurrentReferrer(r10)     // Catch:{ SQLiteException -> 0x00a8, all -> 0x00a5 }
            long r7 = r9.timestampFirst     // Catch:{ SQLiteException -> 0x00a8, all -> 0x00a5 }
            int r0 = (r7 > r5 ? 1 : (r7 == r5 ? 0 : -1))
            if (r0 == 0) goto L_0x004e
            if (r10 == 0) goto L_0x004f
            long r7 = r10.getTimeStamp()     // Catch:{ SQLiteException -> 0x00a8, all -> 0x00a5 }
            int r10 = (r7 > r5 ? 1 : (r7 == r5 ? 0 : -1))
            if (r10 == 0) goto L_0x004e
            goto L_0x004f
        L_0x004e:
            r3 = 0
        L_0x004f:
            r9.sessionStarted = r3     // Catch:{ SQLiteException -> 0x00a8, all -> 0x00a5 }
            r0 = r1
            goto L_0x00a2
        L_0x0053:
            r9.sessionStarted = r4     // Catch:{ SQLiteException -> 0x00a8, all -> 0x00a5 }
            r9.useStoredVisitorVars = r3     // Catch:{ SQLiteException -> 0x00a8, all -> 0x00a5 }
            java.security.SecureRandom r2 = new java.security.SecureRandom     // Catch:{ SQLiteException -> 0x00a8, all -> 0x00a5 }
            r2.<init>()     // Catch:{ SQLiteException -> 0x00a8, all -> 0x00a5 }
            int r2 = r2.nextInt()     // Catch:{ SQLiteException -> 0x00a8, all -> 0x00a5 }
            r3 = 2147483647(0x7fffffff, float:NaN)
            r2 = r2 & r3
            r9.storeId = r2     // Catch:{ SQLiteException -> 0x00a8, all -> 0x00a5 }
            r1.close()     // Catch:{ SQLiteException -> 0x00a8, all -> 0x00a5 }
            android.content.ContentValues r1 = new android.content.ContentValues     // Catch:{ SQLiteException -> 0x00ad }
            r1.<init>()     // Catch:{ SQLiteException -> 0x00ad }
            java.lang.String r2 = "timestamp_first"
            java.lang.Long r3 = java.lang.Long.valueOf(r5)     // Catch:{ SQLiteException -> 0x00ad }
            r1.put(r2, r3)     // Catch:{ SQLiteException -> 0x00ad }
            java.lang.String r2 = "timestamp_previous"
            java.lang.Long r3 = java.lang.Long.valueOf(r5)     // Catch:{ SQLiteException -> 0x00ad }
            r1.put(r2, r3)     // Catch:{ SQLiteException -> 0x00ad }
            java.lang.String r2 = "timestamp_current"
            java.lang.Long r3 = java.lang.Long.valueOf(r5)     // Catch:{ SQLiteException -> 0x00ad }
            r1.put(r2, r3)     // Catch:{ SQLiteException -> 0x00ad }
            java.lang.String r2 = "visits"
            java.lang.Integer r3 = java.lang.Integer.valueOf(r4)     // Catch:{ SQLiteException -> 0x00ad }
            r1.put(r2, r3)     // Catch:{ SQLiteException -> 0x00ad }
            java.lang.String r2 = "store_id"
            int r3 = r9.storeId     // Catch:{ SQLiteException -> 0x00ad }
            java.lang.Integer r3 = java.lang.Integer.valueOf(r3)     // Catch:{ SQLiteException -> 0x00ad }
            r1.put(r2, r3)     // Catch:{ SQLiteException -> 0x00ad }
            java.lang.String r2 = "session"
            r10.insert(r2, r0, r1)     // Catch:{ SQLiteException -> 0x00ad }
        L_0x00a2:
            if (r0 == 0) goto L_0x00bc
            goto L_0x00b9
        L_0x00a5:
            r10 = move-exception
            r0 = r1
            goto L_0x00bd
        L_0x00a8:
            r10 = move-exception
            r0 = r1
            goto L_0x00ae
        L_0x00ab:
            r10 = move-exception
            goto L_0x00bd
        L_0x00ad:
            r10 = move-exception
        L_0x00ae:
            java.lang.String r1 = "GoogleAnalyticsTracker"
            java.lang.String r10 = r10.toString()     // Catch:{ all -> 0x00ab }
            android.util.Log.e(r1, r10)     // Catch:{ all -> 0x00ab }
            if (r0 == 0) goto L_0x00bc
        L_0x00b9:
            r0.close()
        L_0x00bc:
            return
        L_0x00bd:
            if (r0 == 0) goto L_0x00c2
            r0.close()
        L_0x00c2:
            throw r10
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.apps.analytics.PersistentHitStore.loadExistingSession(android.database.sqlite.SQLiteDatabase):void");
    }

    public Event[] peekEvents(int i, SQLiteDatabase sQLiteDatabase, int i2) {
        SQLiteDatabase sQLiteDatabase2 = sQLiteDatabase;
        ArrayList arrayList = new ArrayList();
        Cursor cursor = null;
        try {
            Cursor query = sQLiteDatabase.query("events", (String[]) null, (String) null, (String[]) null, (String) null, (String) null, EVENT_ID, Integer.toString(i));
            while (query.moveToNext()) {
                Event event = new Event(query.getLong(0), query.getString(2), query.getInt(3), query.getInt(4), query.getInt(5), query.getInt(6), query.getInt(7), query.getString(8), query.getString(9), query.getString(10), query.getInt(11), query.getInt(12), query.getInt(13));
                event.setUserId(query.getInt(1));
                long j = query.getLong(query.getColumnIndex(EVENT_ID));
                if ("__##GOOGLETRANSACTION##__".equals(event.category)) {
                    Transaction transaction = getTransaction(j, sQLiteDatabase2);
                    if (transaction == null) {
                        Log.w(GoogleAnalyticsTracker.LOG_TAG, "missing expected transaction for event " + j);
                    }
                    event.setTransaction(transaction);
                } else if ("__##GOOGLEITEM##__".equals(event.category)) {
                    Item item = getItem(j, sQLiteDatabase2);
                    if (item == null) {
                        Log.w(GoogleAnalyticsTracker.LOG_TAG, "missing expected item for event " + j);
                    }
                    event.setItem(item);
                } else {
                    event.setCustomVariableBuffer(i2 > 1 ? getCustomVariables(j, sQLiteDatabase2) : new CustomVariableBuffer());
                    arrayList.add(event);
                }
                int i3 = i2;
                arrayList.add(event);
            }
            if (query != null) {
                query.close();
            }
            return (Event[]) arrayList.toArray(new Event[arrayList.size()]);
        } catch (SQLiteException e) {
            Log.e(GoogleAnalyticsTracker.LOG_TAG, e.toString());
            Event[] eventArr = new Event[0];
            if (cursor != null) {
                cursor.close();
            }
            return eventArr;
        } catch (Throwable th) {
            if (cursor != null) {
                cursor.close();
            }
            throw th;
        }
    }

    public Hit[] peekHits() {
        return peekHits(1000);
    }

    public Hit[] peekHits(int i) {
        ArrayList arrayList = new ArrayList();
        Cursor cursor = null;
        try {
            Cursor query = this.databaseHelper.getReadableDatabase().query("hits", (String[]) null, (String) null, (String[]) null, (String) null, (String) null, HIT_ID, Integer.toString(i));
            while (query.moveToNext()) {
                arrayList.add(new Hit(query.getString(1), query.getLong(0)));
            }
            if (query != null) {
                query.close();
            }
            return (Hit[]) arrayList.toArray(new Hit[arrayList.size()]);
        } catch (SQLiteException e) {
            Log.e(GoogleAnalyticsTracker.LOG_TAG, e.toString());
            Hit[] hitArr = new Hit[0];
            if (cursor != null) {
                cursor.close();
            }
            return hitArr;
        } catch (Throwable th) {
            if (cursor != null) {
                cursor.close();
            }
            throw th;
        }
    }

    /* access modifiers changed from: package-private */
    public void putCustomVariables(Event event, SQLiteDatabase sQLiteDatabase) {
        if (!"__##GOOGLEITEM##__".equals(event.category) && !"__##GOOGLETRANSACTION##__".equals(event.category)) {
            try {
                CustomVariableBuffer customVariableBuffer = event.getCustomVariableBuffer();
                if (this.useStoredVisitorVars) {
                    if (customVariableBuffer == null) {
                        customVariableBuffer = new CustomVariableBuffer();
                        event.setCustomVariableBuffer(customVariableBuffer);
                    }
                    for (int i = 1; i <= 5; i++) {
                        CustomVariable customVariableAt = this.visitorCVCache.getCustomVariableAt(i);
                        CustomVariable customVariableAt2 = customVariableBuffer.getCustomVariableAt(i);
                        if (customVariableAt != null && customVariableAt2 == null) {
                            customVariableBuffer.setCustomVariable(customVariableAt);
                        }
                    }
                    this.useStoredVisitorVars = false;
                }
                if (customVariableBuffer != null) {
                    for (int i2 = 1; i2 <= 5; i2++) {
                        if (!customVariableBuffer.isIndexAvailable(i2)) {
                            CustomVariable customVariableAt3 = customVariableBuffer.getCustomVariableAt(i2);
                            ContentValues contentValues = new ContentValues();
                            contentValues.put(EVENT_ID, 0);
                            contentValues.put(CUSTOMVAR_INDEX, Integer.valueOf(customVariableAt3.getIndex()));
                            contentValues.put(CUSTOMVAR_NAME, customVariableAt3.getName());
                            contentValues.put(CUSTOMVAR_SCOPE, Integer.valueOf(customVariableAt3.getScope()));
                            contentValues.put(CUSTOMVAR_VALUE, customVariableAt3.getValue());
                            sQLiteDatabase.update("custom_var_cache", contentValues, "cv_index = ?", new String[]{Integer.toString(customVariableAt3.getIndex())});
                            if (customVariableAt3.getScope() == 1) {
                                this.visitorCVCache.setCustomVariable(customVariableAt3);
                            } else {
                                this.visitorCVCache.clearCustomVariableAt(customVariableAt3.getIndex());
                            }
                        }
                    }
                }
            } catch (SQLiteException e) {
                Log.e(GoogleAnalyticsTracker.LOG_TAG, e.toString());
            }
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:25:0x0058, code lost:
        if (r0.inTransaction() != false) goto L_0x005a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:27:0x005e, code lost:
        r5 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:39:0x0088, code lost:
        if (r0.inTransaction() != false) goto L_0x008a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:40:0x008a, code lost:
        endTransaction(r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:41:0x008d, code lost:
        throw r5;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:42:0x008e, code lost:
        r5 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:49:0x00ae, code lost:
        throw r5;
     */
    /* JADX WARNING: Exception block dominator not found, dom blocks: [B:23:0x0054, B:30:0x0063] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void putEvent(com.google.android.apps.analytics.Event r5) {
        /*
            r4 = this;
            int r0 = r4.numStoredHits
            r1 = 1000(0x3e8, float:1.401E-42)
            if (r0 < r1) goto L_0x000e
            java.lang.String r5 = "GoogleAnalyticsTracker"
            java.lang.String r0 = "Store full. Not storing last event."
            android.util.Log.w(r5, r0)
            return
        L_0x000e:
            int r0 = r4.sampleRate
            r1 = 100
            if (r0 == r1) goto L_0x003c
            int r0 = r5.getUserId()
            r2 = -1
            if (r0 != r2) goto L_0x001e
            int r0 = r4.storeId
            goto L_0x0022
        L_0x001e:
            int r0 = r5.getUserId()
        L_0x0022:
            int r0 = r0 % 10000
            int r2 = r4.sampleRate
            int r2 = r2 * 100
            if (r0 < r2) goto L_0x003c
            com.google.android.apps.analytics.GoogleAnalyticsTracker r5 = com.google.android.apps.analytics.GoogleAnalyticsTracker.getInstance()
            boolean r5 = r5.getDebug()
            if (r5 == 0) goto L_0x003b
            java.lang.String r5 = "GoogleAnalyticsTracker"
            java.lang.String r0 = "User has been sampled out. Aborting hit."
            android.util.Log.v(r5, r0)
        L_0x003b:
            return
        L_0x003c:
            monitor-enter(r4)
            com.google.android.apps.analytics.PersistentHitStore$DataBaseHelper r0 = r4.databaseHelper     // Catch:{ SQLiteException -> 0x0090 }
            android.database.sqlite.SQLiteDatabase r0 = r0.getWritableDatabase()     // Catch:{ SQLiteException -> 0x0090 }
            r0.beginTransaction()     // Catch:{ SQLiteException -> 0x0060 }
            boolean r1 = r4.sessionStarted     // Catch:{ SQLiteException -> 0x0060 }
            if (r1 != 0) goto L_0x004d
            r4.storeUpdatedSession(r0)     // Catch:{ SQLiteException -> 0x0060 }
        L_0x004d:
            r1 = 1
            r4.putEvent(r5, r0, r1)     // Catch:{ SQLiteException -> 0x0060 }
            r0.setTransactionSuccessful()     // Catch:{ SQLiteException -> 0x0060 }
            boolean r5 = r0.inTransaction()     // Catch:{ all -> 0x008e }
            if (r5 == 0) goto L_0x0082
        L_0x005a:
            endTransaction(r0)     // Catch:{ all -> 0x008e }
            goto L_0x0082
        L_0x005e:
            r5 = move-exception
            goto L_0x0084
        L_0x0060:
            r5 = move-exception
            java.lang.String r1 = "GoogleAnalyticsTracker"
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ all -> 0x005e }
            r2.<init>()     // Catch:{ all -> 0x005e }
            java.lang.String r3 = "putEventOuter:"
            r2.append(r3)     // Catch:{ all -> 0x005e }
            java.lang.String r5 = r5.toString()     // Catch:{ all -> 0x005e }
            r2.append(r5)     // Catch:{ all -> 0x005e }
            java.lang.String r5 = r2.toString()     // Catch:{ all -> 0x005e }
            android.util.Log.e(r1, r5)     // Catch:{ all -> 0x005e }
            boolean r5 = r0.inTransaction()     // Catch:{ all -> 0x008e }
            if (r5 == 0) goto L_0x0082
            goto L_0x005a
        L_0x0082:
            monitor-exit(r4)     // Catch:{ all -> 0x008e }
            return
        L_0x0084:
            boolean r1 = r0.inTransaction()     // Catch:{ all -> 0x008e }
            if (r1 == 0) goto L_0x008d
            endTransaction(r0)     // Catch:{ all -> 0x008e }
        L_0x008d:
            throw r5     // Catch:{ all -> 0x008e }
        L_0x008e:
            r5 = move-exception
            goto L_0x00ad
        L_0x0090:
            r5 = move-exception
            java.lang.String r0 = "GoogleAnalyticsTracker"
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ all -> 0x008e }
            r1.<init>()     // Catch:{ all -> 0x008e }
            java.lang.String r2 = "Can't get db: "
            r1.append(r2)     // Catch:{ all -> 0x008e }
            java.lang.String r5 = r5.toString()     // Catch:{ all -> 0x008e }
            r1.append(r5)     // Catch:{ all -> 0x008e }
            java.lang.String r5 = r1.toString()     // Catch:{ all -> 0x008e }
            android.util.Log.e(r0, r5)     // Catch:{ all -> 0x008e }
            monitor-exit(r4)     // Catch:{ all -> 0x008e }
            return
        L_0x00ad:
            monitor-exit(r4)     // Catch:{ all -> 0x008e }
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.apps.analytics.PersistentHitStore.putEvent(com.google.android.apps.analytics.Event):void");
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x005f  */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x0066  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public com.google.android.apps.analytics.Referrer readCurrentReferrer(android.database.sqlite.SQLiteDatabase r14) {
        /*
            r13 = this;
            java.lang.String r0 = "referrer_index"
            java.lang.String r1 = "referrer_visit"
            java.lang.String r2 = "timestamp_referrer"
            java.lang.String r3 = "referrer"
            r4 = 0
            java.lang.String r6 = "referrer"
            java.lang.String[] r7 = new java.lang.String[]{r3, r2, r1, r0}     // Catch:{ SQLiteException -> 0x0052, all -> 0x004f }
            r8 = 0
            r9 = 0
            r10 = 0
            r11 = 0
            r12 = 0
            r5 = r14
            android.database.Cursor r14 = r5.query(r6, r7, r8, r9, r10, r11, r12)     // Catch:{ SQLiteException -> 0x0052, all -> 0x004f }
            boolean r5 = r14.moveToFirst()     // Catch:{ SQLiteException -> 0x004d }
            if (r5 == 0) goto L_0x0046
            int r2 = r14.getColumnIndex(r2)     // Catch:{ SQLiteException -> 0x004d }
            long r7 = r14.getLong(r2)     // Catch:{ SQLiteException -> 0x004d }
            int r1 = r14.getColumnIndex(r1)     // Catch:{ SQLiteException -> 0x004d }
            int r9 = r14.getInt(r1)     // Catch:{ SQLiteException -> 0x004d }
            int r0 = r14.getColumnIndex(r0)     // Catch:{ SQLiteException -> 0x004d }
            int r10 = r14.getInt(r0)     // Catch:{ SQLiteException -> 0x004d }
            int r0 = r14.getColumnIndex(r3)     // Catch:{ SQLiteException -> 0x004d }
            java.lang.String r6 = r14.getString(r0)     // Catch:{ SQLiteException -> 0x004d }
            com.google.android.apps.analytics.Referrer r0 = new com.google.android.apps.analytics.Referrer     // Catch:{ SQLiteException -> 0x004d }
            r5 = r0
            r5.<init>(r6, r7, r9, r10)     // Catch:{ SQLiteException -> 0x004d }
            goto L_0x0047
        L_0x0046:
            r0 = r4
        L_0x0047:
            if (r14 == 0) goto L_0x004c
            r14.close()
        L_0x004c:
            return r0
        L_0x004d:
            r0 = move-exception
            goto L_0x0054
        L_0x004f:
            r0 = move-exception
            r14 = r4
            goto L_0x0064
        L_0x0052:
            r0 = move-exception
            r14 = r4
        L_0x0054:
            java.lang.String r1 = "GoogleAnalyticsTracker"
            java.lang.String r0 = r0.toString()     // Catch:{ all -> 0x0063 }
            android.util.Log.e(r1, r0)     // Catch:{ all -> 0x0063 }
            if (r14 == 0) goto L_0x0062
            r14.close()
        L_0x0062:
            return r4
        L_0x0063:
            r0 = move-exception
        L_0x0064:
            if (r14 == 0) goto L_0x0069
            r14.close()
        L_0x0069:
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.apps.analytics.PersistentHitStore.readCurrentReferrer(android.database.sqlite.SQLiteDatabase):com.google.android.apps.analytics.Referrer");
    }

    public void setAnonymizeIp(boolean z) {
        this.anonymizeIp = z;
    }

    public boolean setReferrer(String str) {
        String formatReferrer = formatReferrer(str);
        if (formatReferrer == null) {
            return false;
        }
        try {
            SQLiteDatabase writableDatabase = this.databaseHelper.getWritableDatabase();
            Referrer readCurrentReferrer = readCurrentReferrer(writableDatabase);
            ContentValues contentValues = new ContentValues();
            contentValues.put("referrer", formatReferrer);
            contentValues.put(TIMESTAMP_REFERRER, 0L);
            contentValues.put(REFERRER_VISIT, 0);
            long j = 1;
            if (readCurrentReferrer != null) {
                long index = (long) readCurrentReferrer.getIndex();
                j = readCurrentReferrer.getTimeStamp() > 0 ? 1 + index : index;
            }
            contentValues.put(REFERRER_INDEX, Long.valueOf(j));
            if (!setReferrerDatabase(writableDatabase, contentValues)) {
                return false;
            }
            startNewVisit();
            return true;
        } catch (SQLiteException e) {
            Log.e(GoogleAnalyticsTracker.LOG_TAG, e.toString());
            return false;
        }
    }

    public void setSampleRate(int i) {
        this.sampleRate = i;
    }

    public synchronized void startNewVisit() {
        this.sessionStarted = false;
        this.useStoredVisitorVars = true;
        this.numStoredHits = getNumStoredHitsFromDb();
    }

    /* access modifiers changed from: package-private */
    public void storeUpdatedSession(SQLiteDatabase sQLiteDatabase) {
        SQLiteDatabase writableDatabase = this.databaseHelper.getWritableDatabase();
        writableDatabase.delete("session", (String) null, (String[]) null);
        if (this.timestampFirst == 0) {
            long currentTimeMillis = System.currentTimeMillis() / 1000;
            this.timestampFirst = currentTimeMillis;
            this.timestampPrevious = currentTimeMillis;
            this.timestampCurrent = currentTimeMillis;
            this.visits = 1;
        } else {
            this.timestampPrevious = this.timestampCurrent;
            this.timestampCurrent = System.currentTimeMillis() / 1000;
            long j = this.timestampCurrent;
            if (j == this.timestampPrevious) {
                this.timestampCurrent = j + 1;
            }
            this.visits++;
        }
        ContentValues contentValues = new ContentValues();
        contentValues.put(TIMESTAMP_FIRST, Long.valueOf(this.timestampFirst));
        contentValues.put(TIMESTAMP_PREVIOUS, Long.valueOf(this.timestampPrevious));
        contentValues.put(TIMESTAMP_CURRENT, Long.valueOf(this.timestampCurrent));
        contentValues.put(VISITS, Integer.valueOf(this.visits));
        contentValues.put(STORE_ID, Integer.valueOf(this.storeId));
        writableDatabase.insert("session", (String) null, contentValues);
        this.sessionStarted = true;
    }

    /* access modifiers changed from: package-private */
    public void writeEventToDatabase(Event event, Referrer referrer, SQLiteDatabase sQLiteDatabase, boolean z) throws SQLiteException {
        ContentValues contentValues = new ContentValues();
        contentValues.put(HIT_STRING, HitBuilder.constructHitRequestPath(event, referrer));
        contentValues.put(HIT_TIMESTAMP, Long.valueOf(z ? System.currentTimeMillis() : 0));
        sQLiteDatabase.insert("hits", (String) null, contentValues);
        this.numStoredHits++;
    }
}

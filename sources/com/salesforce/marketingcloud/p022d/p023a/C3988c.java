package com.salesforce.marketingcloud.p022d.p023a;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.database.Cursor;
import android.database.DatabaseUtils;
import android.database.sqlite.SQLiteDatabase;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import com.google.android.exoplayer2.metadata.icy.IcyHeaders;
import com.salesforce.marketingcloud.C4039h;
import com.salesforce.marketingcloud.messages.inbox.InboxMessage;
import com.salesforce.marketingcloud.p022d.C4013f;
import com.salesforce.marketingcloud.p022d.p023a.p024a.C3964a;
import com.salesforce.marketingcloud.p027e.C4022a;
import com.salesforce.marketingcloud.p027e.C4029h;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.List;
import java.util.Locale;

@SuppressLint({"UnknownNullness"})
@RestrictTo({RestrictTo.Scope.LIBRARY})
/* renamed from: com.salesforce.marketingcloud.d.a.c */
public final class C3988c extends C3979b implements C4013f {

    /* renamed from: a */
    public static final String f2742a = "cloud_page_messages";

    /* renamed from: b */
    public static final String[] f2743b = {"id", "start_date", "end_date", "message_type", "content_type", "url", "subject", "read", "message_deleted", "custom", "keys", "title", "alert", "sound", "mediaUrl", "mediaAlt", C3991a.f2769q, "request_id"};

    /* renamed from: c */
    public static final String f2744c = "CREATE TABLE cloud_page_messages (id VARCHAR PRIMARY KEY, start_date VARCHAR, end_date VARCHAR, message_type INTEGER, content_type INTEGER, url VARCHAR, subject VARCHAR, read SMALLINT, message_deleted SMALLINT, custom VARCHAR, keys VARCHAR, title VARCHAR, alert VARCHAR, sound VARCHAR, mediaUrl VARCHAR, mediaAlt VARCHAR, message_hash VARCHAR, request_id VARCHAR);";

    /* renamed from: d */
    private static final String f2745d = C4039h.m2810a((Class<?>) C3988c.class);

    /* renamed from: g */
    private static final int f2746g = 0;

    /* renamed from: h */
    private static final int f2747h = 1;

    /* renamed from: i */
    private static final int f2748i = 0;

    /* renamed from: j */
    private static final int f2749j = 1;

    /* renamed from: com.salesforce.marketingcloud.d.a.c$2 */
    static /* synthetic */ class C39902 {

        /* renamed from: a */
        static final /* synthetic */ int[] f2752a = new int[C4013f.C4014a.values().length];

        /* JADX WARNING: Can't wrap try/catch for region: R(10:0|1|2|3|4|5|6|7|8|10) */
        /* JADX WARNING: Can't wrap try/catch for region: R(8:0|1|2|3|4|5|6|(3:7|8|10)) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0014 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001f */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x002a */
        static {
            /*
                com.salesforce.marketingcloud.d.f$a[] r0 = com.salesforce.marketingcloud.p022d.C4013f.C4014a.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f2752a = r0
                int[] r0 = f2752a     // Catch:{ NoSuchFieldError -> 0x0014 }
                com.salesforce.marketingcloud.d.f$a r1 = com.salesforce.marketingcloud.p022d.C4013f.C4014a.READ     // Catch:{ NoSuchFieldError -> 0x0014 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0014 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0014 }
            L_0x0014:
                int[] r0 = f2752a     // Catch:{ NoSuchFieldError -> 0x001f }
                com.salesforce.marketingcloud.d.f$a r1 = com.salesforce.marketingcloud.p022d.C4013f.C4014a.UNREAD     // Catch:{ NoSuchFieldError -> 0x001f }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001f }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001f }
            L_0x001f:
                int[] r0 = f2752a     // Catch:{ NoSuchFieldError -> 0x002a }
                com.salesforce.marketingcloud.d.f$a r1 = com.salesforce.marketingcloud.p022d.C4013f.C4014a.DELETED     // Catch:{ NoSuchFieldError -> 0x002a }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x002a }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x002a }
            L_0x002a:
                int[] r0 = f2752a     // Catch:{ NoSuchFieldError -> 0x0035 }
                com.salesforce.marketingcloud.d.f$a r1 = com.salesforce.marketingcloud.p022d.C4013f.C4014a.NOT_DELETED     // Catch:{ NoSuchFieldError -> 0x0035 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0035 }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0035 }
            L_0x0035:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.salesforce.marketingcloud.p022d.p023a.C3988c.C39902.<clinit>():void");
        }
    }

    /* renamed from: com.salesforce.marketingcloud.d.a.c$a */
    public static class C3991a {

        /* renamed from: a */
        public static final String f2753a = "id";

        /* renamed from: b */
        public static final String f2754b = "start_date";

        /* renamed from: c */
        public static final String f2755c = "end_date";

        /* renamed from: d */
        public static final String f2756d = "message_type";

        /* renamed from: e */
        public static final String f2757e = "content_type";

        /* renamed from: f */
        public static final String f2758f = "url";

        /* renamed from: g */
        public static final String f2759g = "subject";

        /* renamed from: h */
        public static final String f2760h = "read";

        /* renamed from: i */
        public static final String f2761i = "message_deleted";

        /* renamed from: j */
        public static final String f2762j = "custom";

        /* renamed from: k */
        public static final String f2763k = "keys";

        /* renamed from: l */
        public static final String f2764l = "title";

        /* renamed from: m */
        public static final String f2765m = "alert";

        /* renamed from: n */
        public static final String f2766n = "sound";

        /* renamed from: o */
        public static final String f2767o = "mediaUrl";

        /* renamed from: p */
        public static final String f2768p = "mediaAlt";

        /* renamed from: q */
        public static final String f2769q = "message_hash";

        /* renamed from: r */
        public static final String f2770r = "request_id";
    }

    public C3988c(SQLiteDatabase sQLiteDatabase) {
        super(sQLiteDatabase);
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(15:0|1|2|(1:4)|5|6|7|8|9|10|(1:12)(1:13)|14|(1:16)(1:17)|18|21) */
    /* JADX WARNING: Missing exception handler attribute for start block: B:9:0x0105 */
    /* JADX WARNING: Removed duplicated region for block: B:12:0x0116 A[Catch:{ Exception -> 0x012e }] */
    /* JADX WARNING: Removed duplicated region for block: B:13:0x0118 A[Catch:{ Exception -> 0x012e }] */
    /* JADX WARNING: Removed duplicated region for block: B:16:0x0128 A[Catch:{ Exception -> 0x012e }] */
    /* JADX WARNING: Removed duplicated region for block: B:17:0x0129 A[Catch:{ Exception -> 0x012e }] */
    @androidx.annotation.Nullable
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static com.salesforce.marketingcloud.messages.inbox.InboxMessage m2558a(@androidx.annotation.NonNull android.database.Cursor r5, @androidx.annotation.NonNull com.salesforce.marketingcloud.p027e.C4022a r6) {
        /*
            r0 = 0
            r1 = 0
            com.salesforce.marketingcloud.messages.inbox.InboxMessage$a r2 = com.salesforce.marketingcloud.messages.inbox.InboxMessage.m3127e()     // Catch:{ Exception -> 0x012e }
            java.lang.String r3 = "id"
            int r3 = r5.getColumnIndex(r3)     // Catch:{ Exception -> 0x012e }
            java.lang.String r3 = r5.getString(r3)     // Catch:{ Exception -> 0x012e }
            r2.mo56763h(r3)     // Catch:{ Exception -> 0x012e }
            java.lang.String r3 = "start_date"
            int r3 = r5.getColumnIndex(r3)     // Catch:{ Exception -> 0x012e }
            java.lang.String r3 = r5.getString(r3)     // Catch:{ Exception -> 0x012e }
            java.util.Date r3 = com.salesforce.marketingcloud.p027e.C4029h.m2770a((java.lang.String) r3)     // Catch:{ Exception -> 0x012e }
            r2.mo56752a((java.util.Date) r3)     // Catch:{ Exception -> 0x012e }
            java.lang.String r3 = "end_date"
            int r3 = r5.getColumnIndex(r3)     // Catch:{ Exception -> 0x012e }
            java.lang.String r3 = r5.getString(r3)     // Catch:{ Exception -> 0x012e }
            java.util.Date r3 = com.salesforce.marketingcloud.p027e.C4029h.m2770a((java.lang.String) r3)     // Catch:{ Exception -> 0x012e }
            r2.mo56757b((java.util.Date) r3)     // Catch:{ Exception -> 0x012e }
            java.lang.String r3 = "message_type"
            int r3 = r5.getColumnIndex(r3)     // Catch:{ Exception -> 0x012e }
            int r3 = r5.getInt(r3)     // Catch:{ Exception -> 0x012e }
            r2.mo56749a((int) r3)     // Catch:{ Exception -> 0x012e }
            java.lang.String r3 = "content_type"
            int r3 = r5.getColumnIndex(r3)     // Catch:{ Exception -> 0x012e }
            int r3 = r5.getInt(r3)     // Catch:{ Exception -> 0x012e }
            r2.mo56755b((int) r3)     // Catch:{ Exception -> 0x012e }
            java.lang.String r3 = "url"
            int r3 = r5.getColumnIndex(r3)     // Catch:{ Exception -> 0x012e }
            java.lang.String r3 = r5.getString(r3)     // Catch:{ Exception -> 0x012e }
            java.lang.String r3 = r6.mo56545b(r3)     // Catch:{ Exception -> 0x012e }
            r2.mo56764i(r3)     // Catch:{ Exception -> 0x012e }
            java.lang.String r3 = "subject"
            int r3 = r5.getColumnIndex(r3)     // Catch:{ Exception -> 0x012e }
            java.lang.String r3 = r5.getString(r3)     // Catch:{ Exception -> 0x012e }
            java.lang.String r3 = r6.mo56545b(r3)     // Catch:{ Exception -> 0x012e }
            r2.mo56758c(r3)     // Catch:{ Exception -> 0x012e }
            java.lang.String r3 = "custom"
            int r3 = r5.getColumnIndex(r3)     // Catch:{ Exception -> 0x012e }
            java.lang.String r3 = r5.getString(r3)     // Catch:{ Exception -> 0x012e }
            java.lang.String r3 = r6.mo56545b(r3)     // Catch:{ Exception -> 0x012e }
            r2.mo56759d(r3)     // Catch:{ Exception -> 0x012e }
            java.lang.String r3 = "keys"
            int r3 = r5.getColumnIndex(r3)     // Catch:{ Exception -> 0x012e }
            java.lang.String r3 = r5.getString(r3)     // Catch:{ Exception -> 0x012e }
            java.lang.String r3 = r6.mo56545b(r3)     // Catch:{ Exception -> 0x012e }
            if (r3 == 0) goto L_0x0099
            java.util.Map r3 = com.salesforce.marketingcloud.p027e.C4029h.m2778c((java.lang.String) r3)     // Catch:{ Exception -> 0x012e }
            r2.mo56753a((java.util.Map<java.lang.String, java.lang.String>) r3)     // Catch:{ Exception -> 0x012e }
        L_0x0099:
            java.lang.String r3 = "message_hash"
            int r3 = r5.getColumnIndex(r3)     // Catch:{ Exception -> 0x012e }
            java.lang.String r3 = r5.getString(r3)     // Catch:{ Exception -> 0x012e }
            r2.mo56756b((java.lang.String) r3)     // Catch:{ Exception -> 0x012e }
            java.lang.String r3 = "request_id"
            int r3 = r5.getColumnIndex(r3)     // Catch:{ Exception -> 0x012e }
            java.lang.String r3 = r5.getString(r3)     // Catch:{ Exception -> 0x012e }
            r2.mo56751a((java.lang.String) r3)     // Catch:{ Exception -> 0x012e }
            java.lang.String r3 = "title"
            int r3 = r5.getColumnIndex(r3)     // Catch:{ Exception -> 0x012e }
            java.lang.String r3 = r5.getString(r3)     // Catch:{ Exception -> 0x012e }
            java.lang.String r3 = r6.mo56545b(r3)     // Catch:{ Exception -> 0x012e }
            r2.mo56760e(r3)     // Catch:{ Exception -> 0x012e }
            java.lang.String r3 = "alert"
            int r3 = r5.getColumnIndex(r3)     // Catch:{ Exception -> 0x012e }
            java.lang.String r3 = r5.getString(r3)     // Catch:{ Exception -> 0x012e }
            java.lang.String r3 = r6.mo56545b(r3)     // Catch:{ Exception -> 0x012e }
            r2.mo56761f(r3)     // Catch:{ Exception -> 0x012e }
            java.lang.String r3 = "sound"
            int r3 = r5.getColumnIndex(r3)     // Catch:{ Exception -> 0x012e }
            java.lang.String r3 = r5.getString(r3)     // Catch:{ Exception -> 0x012e }
            r2.mo56762g(r3)     // Catch:{ Exception -> 0x012e }
            java.lang.String r3 = "mediaUrl"
            int r3 = r5.getColumnIndex(r3)     // Catch:{ IllegalStateException -> 0x0105 }
            java.lang.String r3 = r5.getString(r3)     // Catch:{ IllegalStateException -> 0x0105 }
            java.lang.String r3 = r6.mo56545b(r3)     // Catch:{ IllegalStateException -> 0x0105 }
            java.lang.String r4 = "mediaAlt"
            int r4 = r5.getColumnIndex(r4)     // Catch:{ IllegalStateException -> 0x0105 }
            java.lang.String r4 = r5.getString(r4)     // Catch:{ IllegalStateException -> 0x0105 }
            java.lang.String r6 = r6.mo56545b(r4)     // Catch:{ IllegalStateException -> 0x0105 }
            com.salesforce.marketingcloud.messages.inbox.InboxMessage$Media r6 = com.salesforce.marketingcloud.messages.inbox.InboxMessage.Media.create(r3, r6)     // Catch:{ IllegalStateException -> 0x0105 }
            r2.mo56750a((com.salesforce.marketingcloud.messages.inbox.InboxMessage.Media) r6)     // Catch:{ IllegalStateException -> 0x0105 }
        L_0x0105:
            com.salesforce.marketingcloud.messages.inbox.InboxMessage r1 = r2.mo56754a()     // Catch:{ Exception -> 0x012e }
            java.lang.String r6 = "read"
            int r6 = r5.getColumnIndex(r6)     // Catch:{ Exception -> 0x012e }
            int r6 = r5.getInt(r6)     // Catch:{ Exception -> 0x012e }
            r2 = 1
            if (r6 != r2) goto L_0x0118
            r6 = 1
            goto L_0x0119
        L_0x0118:
            r6 = 0
        L_0x0119:
            r1.mo56765a((boolean) r6)     // Catch:{ Exception -> 0x012e }
            java.lang.String r6 = "message_deleted"
            int r6 = r5.getColumnIndex(r6)     // Catch:{ Exception -> 0x012e }
            int r5 = r5.getInt(r6)     // Catch:{ Exception -> 0x012e }
            if (r5 != r2) goto L_0x0129
            goto L_0x012a
        L_0x0129:
            r2 = 0
        L_0x012a:
            r1.mo56766b((boolean) r2)     // Catch:{ Exception -> 0x012e }
            goto L_0x0138
        L_0x012e:
            r5 = move-exception
            java.lang.String r6 = f2745d
            java.lang.Object[] r0 = new java.lang.Object[r0]
            java.lang.String r2 = "Failed to hydrate a InboxMessage from our local storage."
            com.salesforce.marketingcloud.C4039h.m2830e(r6, r5, r2, r0)
        L_0x0138:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.salesforce.marketingcloud.p022d.p023a.C3988c.m2558a(android.database.Cursor, com.salesforce.marketingcloud.e.a):com.salesforce.marketingcloud.messages.inbox.InboxMessage");
    }

    /* renamed from: a */
    private static String m2559a(String str, Object... objArr) {
        return String.format(Locale.ENGLISH, str, objArr);
    }

    /* renamed from: a */
    private String[] m2560a(Cursor cursor) {
        int i = 0;
        if (cursor == null) {
            return new String[0];
        }
        String[] strArr = new String[cursor.getCount()];
        if (cursor.moveToFirst()) {
            do {
                strArr[i] = cursor.getString(cursor.getColumnIndex("id"));
                i++;
            } while (cursor.moveToNext());
        }
        cursor.close();
        return strArr;
    }

    @NonNull
    /* renamed from: b */
    private static List<InboxMessage> m2561b(@NonNull Cursor cursor, @NonNull C4022a aVar) {
        List<InboxMessage> emptyList = Collections.emptyList();
        if (cursor != null) {
            if (cursor.moveToFirst()) {
                ArrayList arrayList = new ArrayList();
                do {
                    InboxMessage a = m2558a(cursor, aVar);
                    if (a != null) {
                        arrayList.add(a);
                    }
                } while (cursor.moveToNext());
                emptyList = arrayList;
            }
            cursor.close();
        }
        return emptyList;
    }

    /* renamed from: c */
    private static ContentValues m2562c(InboxMessage inboxMessage, @NonNull C4022a aVar) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("id", inboxMessage.mo56741id());
        contentValues.put("start_date", C4029h.m2766a(inboxMessage.startDateUtc()));
        contentValues.put("end_date", C4029h.m2766a(inboxMessage.endDateUtc()));
        contentValues.put("message_type", Integer.valueOf(inboxMessage.mo56734c()));
        contentValues.put("content_type", Integer.valueOf(inboxMessage.mo56737d()));
        contentValues.put("url", aVar.mo56544a(inboxMessage.url()));
        contentValues.put("subject", aVar.mo56544a(inboxMessage.subject()));
        contentValues.put("read", Integer.valueOf(inboxMessage.read() ? 1 : 0));
        contentValues.put("message_deleted", Integer.valueOf(inboxMessage.deleted() ? 1 : 0));
        contentValues.put("custom", aVar.mo56544a(inboxMessage.custom()));
        contentValues.put("keys", aVar.mo56544a(C4029h.m2767a(inboxMessage.customKeys())));
        contentValues.put("title", aVar.mo56544a(inboxMessage.title()));
        contentValues.put("alert", aVar.mo56544a(inboxMessage.alert()));
        contentValues.put("sound", inboxMessage.sound());
        if (inboxMessage.media() != null) {
            contentValues.put("mediaUrl", aVar.mo56544a(inboxMessage.media().url()));
            contentValues.put("mediaAlt", aVar.mo56544a(inboxMessage.media().altText()));
        }
        contentValues.put(C3991a.f2769q, inboxMessage.mo56733b());
        contentValues.put("request_id", inboxMessage.mo56731a());
        return contentValues;
    }

    /* renamed from: a */
    public int mo56465a() {
        return mo56462c((String) null);
    }

    /* renamed from: a */
    public int mo56466a(@NonNull C4013f.C4014a aVar) {
        String[] strArr;
        String str;
        String a = C4029h.m2766a(new Date());
        String a2 = m2559a("(%1$s IS NULL OR %1$s<?) AND (%2$s IS NULL OR %2$s>?)", "start_date", "end_date");
        int i = C39902.f2752a[aVar.ordinal()];
        if (i == 1 || i == 2) {
            str = a2 + m2559a(" AND %s=? AND %s=?", "read", "message_deleted");
            strArr = new String[4];
            strArr[0] = a;
            strArr[1] = a;
            strArr[2] = aVar == C4013f.C4014a.READ ? String.valueOf(1) : String.valueOf(0);
            strArr[3] = String.valueOf(0);
        } else if (i == 3 || i == 4) {
            str = a2 + m2559a(" AND %s=?", "message_deleted");
            strArr = new String[3];
            strArr[0] = a;
            strArr[1] = a;
            strArr[2] = aVar == C4013f.C4014a.DELETED ? String.valueOf(1) : String.valueOf(0);
        } else {
            throw new IllegalArgumentException("Unknown MessageStatus while getting message counts.");
        }
        return (int) DatabaseUtils.queryNumEntries(this.f2730f, f2742a, str, strArr);
    }

    @Nullable
    /* renamed from: a */
    public InboxMessage mo56467a(@NonNull String str, @NonNull C4022a aVar) {
        Cursor a = mo56461a(f2743b, m2559a("%s = ?", "id"), new String[]{str}, (String) null, (String) null, (String) null, IcyHeaders.REQUEST_HEADER_ENABLE_METADATA_VALUE);
        InboxMessage inboxMessage = null;
        if (a != null) {
            if (a.moveToFirst()) {
                inboxMessage = m2558a(a, aVar);
            }
            a.close();
        }
        return inboxMessage;
    }

    @NonNull
    /* renamed from: a */
    public List<InboxMessage> mo56468a(@NonNull C4022a aVar) {
        String[] strArr = {String.valueOf(8), String.valueOf(2)};
        return m2561b(mo56459a(f2743b, m2559a("%s=? AND %s=?", "message_type", "content_type"), strArr), aVar);
    }

    @NonNull
    /* renamed from: a */
    public List<InboxMessage> mo56469a(@NonNull C4022a aVar, C4013f.C4014a aVar2) {
        String[] strArr;
        String str;
        String a = C4029h.m2766a(new Date());
        String a2 = m2559a("(%1$s IS NULL OR %1$s<?) AND (%2$s IS NULL OR %2$s>?)", "start_date", "end_date");
        int i = C39902.f2752a[aVar2.ordinal()];
        if (i == 1 || i == 2) {
            str = a2 + m2559a(" AND %s=? AND %s=?", "read", "message_deleted");
            strArr = new String[4];
            strArr[0] = a;
            strArr[1] = a;
            strArr[2] = aVar2 == C4013f.C4014a.READ ? String.valueOf(1) : String.valueOf(0);
            strArr[3] = String.valueOf(0);
        } else if (i == 3 || i == 4) {
            str = a2 + m2559a(" AND %s=?", "message_deleted");
            strArr = new String[3];
            strArr[0] = a;
            strArr[1] = a;
            strArr[2] = aVar2 == C4013f.C4014a.DELETED ? String.valueOf(1) : String.valueOf(0);
        } else {
            throw new IllegalArgumentException("Unknown MessageStatus while getting message counts.");
        }
        List<InboxMessage> b = m2561b(mo56459a(f2743b, str, strArr), aVar);
        final Date date = new Date();
        Collections.sort(b, new Comparator<InboxMessage>() {
            /* renamed from: a */
            public int compare(InboxMessage inboxMessage, InboxMessage inboxMessage2) {
                return (inboxMessage.startDateUtc() != null ? inboxMessage.startDateUtc() : date).compareTo(inboxMessage2.startDateUtc() != null ? inboxMessage2.startDateUtc() : date) * -1;
            }
        });
        return b;
    }

    /* renamed from: a */
    public void mo56449a(C4022a aVar, C4022a aVar2, SQLiteDatabase sQLiteDatabase) {
        C4022a aVar3 = aVar;
        C4022a aVar4 = aVar2;
        SQLiteDatabase sQLiteDatabase2 = sQLiteDatabase;
        Cursor query = sQLiteDatabase2.query("messages", C3964a.C3971d.f2648a, m2559a("%s=? AND %s=?", "content_type", "message_type"), new String[]{String.valueOf(2), String.valueOf(1)}, (String) null, (String) null, (String) null);
        if (query != null) {
            if (query.moveToFirst()) {
                do {
                    ContentValues contentValues = new ContentValues();
                    contentValues.put("subject", aVar4.mo56544a(aVar3.mo56545b(query.getString(query.getColumnIndex("subject")))));
                    contentValues.put("url", aVar4.mo56544a(aVar3.mo56545b(query.getString(query.getColumnIndex("url")))));
                    contentValues.put("id", query.getString(query.getColumnIndex("id")));
                    contentValues.put("content_type", Integer.valueOf(query.getInt(query.getColumnIndex("content_type"))));
                    contentValues.put("message_type", 8);
                    contentValues.put("start_date", query.getString(query.getColumnIndex("start_date")));
                    contentValues.put("end_date", query.getString(query.getColumnIndex("end_date")));
                    contentValues.put("read", Integer.valueOf(query.getInt(query.getColumnIndex("read"))));
                    contentValues.put("message_deleted", Integer.valueOf(query.getInt(query.getColumnIndex("message_deleted"))));
                    contentValues.put("custom", aVar4.mo56544a(query.getString(query.getColumnIndex("custom"))));
                    contentValues.put("keys", aVar4.mo56544a(aVar3.mo56545b(query.getString(query.getColumnIndex("keys")))));
                    contentValues.put("alert", aVar4.mo56544a(aVar3.mo56545b(query.getString(query.getColumnIndex("alert")))));
                    contentValues.put("sound", query.getString(query.getColumnIndex("sound")));
                    contentValues.put(C3991a.f2769q, "nohash");
                    mo56455a(contentValues);
                } while (query.moveToNext());
            }
            query.close();
        }
        new C3992d(this.f2730f).mo56449a(aVar3, aVar4, sQLiteDatabase);
    }

    /* renamed from: a */
    public void mo56470a(@NonNull InboxMessage inboxMessage, @NonNull C4022a aVar) {
        ContentValues c = m2562c(inboxMessage, aVar);
        if (mo56453a(c, m2559a("%s = ?", "id"), new String[]{inboxMessage.mo56741id()}) == 0) {
            mo56455a(c);
        }
    }

    /* renamed from: a */
    public boolean mo56471a(@NonNull String str) {
        return DatabaseUtils.queryNumEntries(this.f2730f, f2742a, "id=?", new String[]{str}) > 0;
    }

    /* renamed from: b */
    public int mo56472b(@NonNull InboxMessage inboxMessage, @NonNull C4022a aVar) {
        return mo56453a(m2562c(inboxMessage, aVar), m2559a("%s = ?", "id"), new String[]{inboxMessage.mo56741id()});
    }

    @NonNull
    /* renamed from: b */
    public List<InboxMessage> mo56473b(@NonNull C4022a aVar) {
        return mo56469a(aVar, C4013f.C4014a.NOT_DELETED);
    }

    @NonNull
    /* renamed from: b */
    public String[] mo56474b() {
        String a = C4029h.m2766a(new Date());
        String[] a2 = m2560a(mo56459a(new String[]{"id"}, "(start_date IS NULL OR start_date<?) AND (end_date IS NULL OR end_date>?) AND message_deleted=?", new String[]{a, a, String.valueOf(0)}));
        List emptyList = Collections.emptyList();
        if (a2.length > 0) {
            emptyList = new ArrayList();
            ContentValues contentValues = new ContentValues(1);
            contentValues.put("message_deleted", 1);
            for (String str : a2) {
                if (mo56453a(contentValues, "id=?", new String[]{str}) > 0) {
                    emptyList.add(str);
                }
            }
        }
        return (String[]) emptyList.toArray(new String[0]);
    }

    @NonNull
    /* renamed from: c */
    public String[] mo56475c() {
        String a = C4029h.m2766a(new Date());
        String[] a2 = m2560a(mo56459a(new String[]{"id"}, "(start_date IS NULL OR start_date<?) AND (end_date IS NULL OR end_date>?) AND read=? AND message_deleted=?", new String[]{a, a, String.valueOf(0), String.valueOf(0)}));
        List emptyList = Collections.emptyList();
        if (a2.length > 0) {
            emptyList = new ArrayList();
            ContentValues contentValues = new ContentValues(1);
            contentValues.put("read", 1);
            for (String str : a2) {
                if (mo56453a(contentValues, "id=?", new String[]{str}) > 0) {
                    emptyList.add(str);
                }
            }
        }
        return (String[]) emptyList.toArray(new String[emptyList.size()]);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: e */
    public String mo56450e() {
        return f2742a;
    }
}

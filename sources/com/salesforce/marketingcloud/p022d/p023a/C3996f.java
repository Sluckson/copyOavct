package com.salesforce.marketingcloud.p022d.p023a;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.exoplayer2.metadata.icy.IcyHeaders;
import com.salesforce.marketingcloud.C4039h;
import com.salesforce.marketingcloud.messages.Message;
import com.salesforce.marketingcloud.p022d.C4017i;
import com.salesforce.marketingcloud.p027e.C4022a;
import com.salesforce.marketingcloud.p027e.C4029h;
import java.util.Locale;

@SuppressLint({"UnknownNullness"})
/* renamed from: com.salesforce.marketingcloud.d.a.f */
public final class C3996f extends C3979b implements C4017i {

    /* renamed from: a */
    public static final String f2784a = "messages";

    /* renamed from: b */
    public static final String[] f2785b = {"id", "title", "alert", "sound", "mediaUrl", "mediaAlt", "open_direct", "start_date", "end_date", "message_type", "content_type", "url", "custom", "keys", "period_show_count", "last_shown_date", "next_allowed_show", "show_count", "message_limit", "rolling_period", "period_type", "number_of_periods", "messages_per_period", "proximity", "notify_id"};

    /* renamed from: c */
    public static final String f2786c = "CREATE TABLE messages (id VARCHAR PRIMARY KEY, title VARCHAR, alert VARCHAR, sound VARCHAR, mediaUrl VARCHAR, mediaAlt VARCHAR, open_direct VARCHAR, start_date VARCHAR, end_date VARCHAR, message_type INTEGER, content_type INTEGER, url VARCHAR, custom VARCHAR, keys VARCHAR, period_show_count INTEGER, last_shown_date VARCHAR, next_allowed_show VARCHAR, show_count INTEGER, message_limit INTEGER, rolling_period SMALLINT, period_type INTEGER, number_of_periods INTEGER, messages_per_period INTEGER, proximity INTEGER, notify_id INTEGER );";

    /* renamed from: d */
    private static final String f2787d = C4039h.m2810a((Class<?>) C3996f.class);

    /* renamed from: com.salesforce.marketingcloud.d.a.f$a */
    public static class C3997a {

        /* renamed from: a */
        public static final String f2788a = "id";

        /* renamed from: b */
        public static final String f2789b = "title";

        /* renamed from: c */
        public static final String f2790c = "alert";

        /* renamed from: d */
        public static final String f2791d = "sound";

        /* renamed from: e */
        public static final String f2792e = "mediaUrl";

        /* renamed from: f */
        public static final String f2793f = "mediaAlt";

        /* renamed from: g */
        public static final String f2794g = "open_direct";

        /* renamed from: h */
        public static final String f2795h = "start_date";

        /* renamed from: i */
        public static final String f2796i = "end_date";

        /* renamed from: j */
        public static final String f2797j = "message_type";

        /* renamed from: k */
        public static final String f2798k = "content_type";

        /* renamed from: l */
        public static final String f2799l = "url";

        /* renamed from: m */
        public static final String f2800m = "custom";

        /* renamed from: n */
        public static final String f2801n = "keys";

        /* renamed from: o */
        public static final String f2802o = "period_show_count";

        /* renamed from: p */
        public static final String f2803p = "show_count";

        /* renamed from: q */
        public static final String f2804q = "last_shown_date";

        /* renamed from: r */
        public static final String f2805r = "next_allowed_show";

        /* renamed from: s */
        public static final String f2806s = "message_limit";

        /* renamed from: t */
        public static final String f2807t = "rolling_period";

        /* renamed from: u */
        public static final String f2808u = "period_type";

        /* renamed from: v */
        public static final String f2809v = "number_of_periods";

        /* renamed from: w */
        public static final String f2810w = "messages_per_period";

        /* renamed from: x */
        public static final String f2811x = "proximity";

        /* renamed from: y */
        public static final String f2812y = "notify_id";
    }

    public C3996f(SQLiteDatabase sQLiteDatabase) {
        super(sQLiteDatabase);
    }

    @Nullable
    /* renamed from: a */
    private static Message m2591a(@NonNull Cursor cursor, @NonNull C4022a aVar) {
        Message.C4068a a = Message.m2974a();
        try {
            a.mo56625a(cursor.getString(cursor.getColumnIndex("id")));
            a.mo56631b(aVar.mo56545b(cursor.getString(cursor.getColumnIndex("title"))));
            a.mo56634c(aVar.mo56545b(cursor.getString(cursor.getColumnIndex("alert"))));
            a.mo56636d(cursor.getString(cursor.getColumnIndex("sound")));
            try {
                a.mo56624a(Message.Media.create(aVar.mo56545b(cursor.getString(cursor.getColumnIndex("mediaUrl"))), aVar.mo56545b(cursor.getString(cursor.getColumnIndex("mediaAlt")))));
            } catch (IllegalStateException unused) {
            }
            a.mo56626a(C4029h.m2770a(cursor.getString(cursor.getColumnIndex("start_date"))));
            a.mo56632b(C4029h.m2770a(cursor.getString(cursor.getColumnIndex("end_date"))));
            a.mo56623a(cursor.getInt(cursor.getColumnIndex("message_type")));
            a.mo56630b(cursor.getInt(cursor.getColumnIndex("content_type")));
            a.mo56638e(aVar.mo56545b(cursor.getString(cursor.getColumnIndex("url"))));
            a.mo56642g(aVar.mo56545b(cursor.getString(cursor.getColumnIndex("custom"))));
            a.mo56633c(cursor.getInt(cursor.getColumnIndex("messages_per_period")));
            a.mo56635d(cursor.getInt(cursor.getColumnIndex("number_of_periods")));
            a.mo56637e(cursor.getInt(cursor.getColumnIndex("period_type")));
            boolean z = true;
            if (cursor.getInt(cursor.getColumnIndex("rolling_period")) != 1) {
                z = false;
            }
            a.mo56628a(z);
            a.mo56639f(cursor.getInt(cursor.getColumnIndex("message_limit")));
            a.mo56641g(cursor.getInt(cursor.getColumnIndex("proximity")));
            a.mo56640f(aVar.mo56545b(cursor.getString(cursor.getColumnIndex("open_direct"))));
            String b = aVar.mo56545b(cursor.getString(cursor.getColumnIndex("keys")));
            if (b != null) {
                a.mo56627a(C4029h.m2778c(b));
            }
            Message a2 = a.mo56629a();
            a2.mo56667a(cursor.getInt(cursor.getColumnIndex("notify_id")));
            a2.mo56671c(cursor.getInt(cursor.getColumnIndex("period_show_count")));
            a2.mo56668a(C4029h.m2770a(cursor.getString(cursor.getColumnIndex("next_allowed_show"))));
            a2.mo56669b(cursor.getInt(cursor.getColumnIndex("show_count")));
            a2.mo56670b(C4029h.m2770a(cursor.getString(cursor.getColumnIndex("last_shown_date"))));
            return a2;
        } catch (Exception e) {
            C4039h.m2830e(f2787d, e, "Unable to read message from DB", new Object[0]);
            return null;
        }
    }

    /* renamed from: a */
    private static String m2592a(String str, Object... objArr) {
        return String.format(Locale.ENGLISH, str, objArr);
    }

    /* renamed from: b */
    private static ContentValues m2593b(Message message, @NonNull C4022a aVar) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("id", message.mo56608id());
        contentValues.put("title", aVar.mo56544a(message.title()));
        contentValues.put("alert", aVar.mo56544a(message.alert()));
        contentValues.put("sound", message.sound());
        if (message.media() != null) {
            contentValues.put("mediaUrl", aVar.mo56544a(message.media().url()));
            contentValues.put("mediaAlt", aVar.mo56544a(message.media().altText()));
        }
        contentValues.put("start_date", C4029h.m2766a(message.startDateUtc()));
        contentValues.put("end_date", C4029h.m2766a(message.endDateUtc()));
        contentValues.put("message_type", Integer.valueOf(message.messageType()));
        contentValues.put("content_type", Integer.valueOf(message.contentType()));
        contentValues.put("url", aVar.mo56544a(message.url()));
        contentValues.put("custom", aVar.mo56544a(message.custom()));
        contentValues.put("messages_per_period", Integer.valueOf(message.messagesPerPeriod()));
        contentValues.put("number_of_periods", Integer.valueOf(message.numberOfPeriods()));
        contentValues.put("period_type", Integer.valueOf(message.periodType()));
        contentValues.put("rolling_period", Integer.valueOf(message.isRollingPeriod() ? 1 : 0));
        contentValues.put("message_limit", Integer.valueOf(message.messageLimit()));
        contentValues.put("proximity", Integer.valueOf(message.proximity()));
        contentValues.put("open_direct", aVar.mo56544a(message.openDirect()));
        contentValues.put("keys", aVar.mo56544a(C4029h.m2767a(message.customKeys())));
        contentValues.put("next_allowed_show", C4029h.m2766a(message.getNextAllowedShow()));
        contentValues.put("period_show_count", Integer.valueOf(message.getPeriodShowCount()));
        contentValues.put("notify_id", Integer.valueOf(message.getNotifyId()));
        contentValues.put("show_count", Integer.valueOf(message.getShowCount()));
        contentValues.put("last_shown_date", C4029h.m2766a(message.getLastShownDate()));
        return contentValues;
    }

    /* renamed from: a */
    public int mo56486a(int i) {
        return mo56454a(m2592a("%s = ?", "message_type"), new String[]{String.valueOf(i)});
    }

    /* renamed from: a */
    public int mo56487a(@NonNull String str) {
        return mo56454a(m2592a("%s = ?", "id"), new String[]{str});
    }

    /* renamed from: a */
    public int mo56488a(@NonNull String str, int i) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("notify_id", Integer.valueOf(i));
        return mo56453a(contentValues, m2592a("%s = ?", "id"), new String[]{str});
    }

    /* renamed from: a */
    public Message mo56489a(@NonNull String str, @NonNull C4022a aVar) {
        Cursor a = mo56461a(f2785b, m2592a("%s = ?", "id"), new String[]{str}, (String) null, (String) null, (String) null, IcyHeaders.REQUEST_HEADER_ENABLE_METADATA_VALUE);
        Message message = null;
        if (a != null) {
            if (a.moveToFirst()) {
                message = m2591a(a, aVar);
            }
            a.close();
        }
        return message;
    }

    /* renamed from: a */
    public void mo56449a(C4022a aVar, C4022a aVar2, SQLiteDatabase sQLiteDatabase) {
        Cursor rawQuery = sQLiteDatabase.rawQuery(m2592a("SELECT * FROM %1$s WHERE %2$s = ? OR %2$s = ? OR %2$s = ?", "messages", "message_type"), new String[]{String.valueOf(3), String.valueOf(4), String.valueOf(5)});
        if (rawQuery != null) {
            if (rawQuery.moveToFirst()) {
                do {
                    ContentValues contentValues = new ContentValues();
                    contentValues.put("id", rawQuery.getString(rawQuery.getColumnIndex("id")));
                    contentValues.put("alert", aVar2.mo56544a(aVar.mo56545b(rawQuery.getString(rawQuery.getColumnIndex("alert")))));
                    contentValues.put("sound", rawQuery.getString(rawQuery.getColumnIndex("sound")));
                    contentValues.put("open_direct", aVar2.mo56544a(aVar.mo56545b(rawQuery.getString(rawQuery.getColumnIndex("open_direct")))));
                    contentValues.put("start_date", rawQuery.getString(rawQuery.getColumnIndex("start_date")));
                    contentValues.put("end_date", rawQuery.getString(rawQuery.getColumnIndex("end_date")));
                    contentValues.put("message_type", Integer.valueOf(rawQuery.getInt(rawQuery.getColumnIndex("message_type"))));
                    contentValues.put("content_type", Integer.valueOf(rawQuery.getInt(rawQuery.getColumnIndex("content_type"))));
                    contentValues.put("url", aVar2.mo56544a(aVar.mo56545b(rawQuery.getString(rawQuery.getColumnIndex("url")))));
                    contentValues.put("keys", aVar2.mo56544a(aVar.mo56545b(rawQuery.getString(rawQuery.getColumnIndex("keys")))));
                    contentValues.put("period_show_count", Integer.valueOf(rawQuery.getInt(rawQuery.getColumnIndex("period_show_count"))));
                    contentValues.put("show_count", Integer.valueOf(rawQuery.getInt(rawQuery.getColumnIndex("show_count"))));
                    contentValues.put("last_shown_date", rawQuery.getString(rawQuery.getColumnIndex("last_shown_date")));
                    contentValues.put("next_allowed_show", rawQuery.getString(rawQuery.getColumnIndex("next_allowed_show")));
                    contentValues.put("message_limit", Integer.valueOf(rawQuery.getInt(rawQuery.getColumnIndex("message_limit"))));
                    contentValues.put("rolling_period", Integer.valueOf(rawQuery.getInt(rawQuery.getColumnIndex("rolling_period"))));
                    contentValues.put("period_type", Integer.valueOf(rawQuery.getInt(rawQuery.getColumnIndex("period_type"))));
                    contentValues.put("number_of_periods", Integer.valueOf(rawQuery.getInt(rawQuery.getColumnIndex("number_of_periods"))));
                    contentValues.put("messages_per_period", Integer.valueOf(rawQuery.getInt(rawQuery.getColumnIndex("messages_per_period"))));
                    contentValues.put("proximity", Integer.valueOf(rawQuery.getInt(rawQuery.getColumnIndex("proximity"))));
                    contentValues.put("notify_id", Integer.valueOf(rawQuery.getInt(rawQuery.getColumnIndex("notify_id"))));
                    mo56455a(contentValues);
                } while (rawQuery.moveToNext());
            }
            rawQuery.close();
        }
        new C3988c(this.f2730f).mo56449a(aVar, aVar2, sQLiteDatabase);
    }

    /* renamed from: a */
    public void mo56490a(@NonNull Message message, @NonNull C4022a aVar) {
        ContentValues b = m2593b(message, aVar);
        if (mo56453a(b, m2592a("%s = ?", "id"), new String[]{message.mo56608id()}) == 0) {
            mo56455a(b);
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: e */
    public String mo56450e() {
        return "messages";
    }
}

package com.salesforce.marketingcloud.p022d.p023a;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import androidx.annotation.NonNull;
import com.google.android.exoplayer2.metadata.icy.IcyHeaders;
import com.salesforce.marketingcloud.C4039h;
import com.salesforce.marketingcloud.location.LatLon;
import com.salesforce.marketingcloud.messages.Region;
import com.salesforce.marketingcloud.p022d.C4019k;
import com.salesforce.marketingcloud.p027e.C4022a;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Locale;

@SuppressLint({"UnknownNullness"})
/* renamed from: com.salesforce.marketingcloud.d.a.g */
public final class C3998g extends C3979b implements C4019k {

    /* renamed from: a */
    public static final String f2813a = "regions";

    /* renamed from: b */
    public static final String[] f2814b = {"id", "latitude", "longitude", "radius", "beacon_guid", "beacon_major", "beacon_minor", "description", "name", "location_type", C3999a.f2827k};

    /* renamed from: c */
    public static final String f2815c = "CREATE TABLE regions (id VARCHAR PRIMARY KEY, latitude VARCHAR, longitude VARCHAR, radius INTEGER, beacon_guid VARCHAR, beacon_major INTEGER, beacon_minor INTEGER, description VARCHAR, name VARCHAR, location_type INTEGER, is_inside SMALLINT );";

    /* renamed from: d */
    private static final String f2816d = C4039h.m2810a((Class<?>) C3998g.class);

    /* renamed from: com.salesforce.marketingcloud.d.a.g$a */
    public static class C3999a {

        /* renamed from: a */
        public static final String f2817a = "id";

        /* renamed from: b */
        public static final String f2818b = "latitude";

        /* renamed from: c */
        public static final String f2819c = "longitude";

        /* renamed from: d */
        public static final String f2820d = "radius";

        /* renamed from: e */
        public static final String f2821e = "beacon_guid";

        /* renamed from: f */
        public static final String f2822f = "beacon_major";

        /* renamed from: g */
        public static final String f2823g = "beacon_minor";

        /* renamed from: h */
        public static final String f2824h = "description";

        /* renamed from: i */
        public static final String f2825i = "name";

        /* renamed from: j */
        public static final String f2826j = "location_type";

        /* renamed from: k */
        public static final String f2827k = "is_inside";
    }

    public C3998g(SQLiteDatabase sQLiteDatabase) {
        super(sQLiteDatabase);
    }

    /* renamed from: a */
    private static Region m2601a(Cursor cursor, @NonNull C4022a aVar) {
        try {
            Region.C4071a a = Region.m3012a();
            a.mo56658a(cursor.getString(cursor.getColumnIndex("id")));
            a.mo56657a(LatLon.m2843a(Double.valueOf(aVar.mo56545b(cursor.getString(cursor.getColumnIndex("latitude")))).doubleValue(), Double.valueOf(aVar.mo56545b(cursor.getString(cursor.getColumnIndex("longitude")))).doubleValue()));
            a.mo56656a(cursor.getInt(cursor.getColumnIndex("radius")));
            a.mo56662b(aVar.mo56545b(cursor.getString(cursor.getColumnIndex("beacon_guid"))));
            a.mo56661b(cursor.getInt(cursor.getColumnIndex("beacon_major")));
            a.mo56663c(cursor.getInt(cursor.getColumnIndex("beacon_minor")));
            a.mo56665d(cursor.getInt(cursor.getColumnIndex("location_type")));
            a.mo56664c(aVar.mo56545b(cursor.getString(cursor.getColumnIndex("name"))));
            a.mo56666d(aVar.mo56545b(cursor.getString(cursor.getColumnIndex("description"))));
            Region a2 = a.mo56660a();
            boolean z = true;
            if (cursor.getInt(cursor.getColumnIndex(C3999a.f2827k)) != 1) {
                z = false;
            }
            a2.mo56686a(z);
            return a2;
        } catch (Exception e) {
            C4039h.m2830e(f2816d, e, "Unable to read region from DB", new Object[0]);
            return null;
        }
    }

    /* renamed from: a */
    private static String m2602a(String str, Object... objArr) {
        return String.format(Locale.ENGLISH, str, objArr);
    }

    /* renamed from: b */
    private static ContentValues m2603b(Region region, @NonNull C4022a aVar) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("id", region.mo56647id());
        contentValues.put("latitude", aVar.mo56544a(String.valueOf(region.center().latitude())));
        contentValues.put("longitude", aVar.mo56544a(String.valueOf(region.center().longitude())));
        contentValues.put("radius", Integer.valueOf(region.radius()));
        contentValues.put("beacon_guid", aVar.mo56544a(region.proximityUuid()));
        contentValues.put("beacon_major", Integer.valueOf(region.major()));
        contentValues.put("beacon_minor", Integer.valueOf(region.minor()));
        contentValues.put("description", aVar.mo56544a(region.description()));
        contentValues.put("name", aVar.mo56544a(region.name()));
        contentValues.put("location_type", Integer.valueOf(region.regionType()));
        contentValues.put(C3999a.f2827k, Integer.valueOf(region.mo56687b() ? 1 : 0));
        return contentValues;
    }

    /* renamed from: a */
    public int mo56491a() {
        ContentValues contentValues = new ContentValues();
        contentValues.put(C3999a.f2827k, 0);
        return mo56453a(contentValues, (String) null, (String[]) null);
    }

    /* renamed from: a */
    public int mo56492a(int i) {
        return mo56454a(m2602a("%s = ?", "location_type"), new String[]{String.valueOf(i)});
    }

    /* renamed from: a */
    public int mo56493a(@NonNull String str) {
        return mo56454a(m2602a("%s = ?", "id"), new String[]{str});
    }

    /* renamed from: a */
    public int mo56494a(@NonNull String str, boolean z) {
        ContentValues contentValues = new ContentValues();
        contentValues.put(C3999a.f2827k, Integer.valueOf(z ? 1 : 0));
        return mo56453a(contentValues, m2602a("%s = ?", "id"), new String[]{str});
    }

    /* renamed from: a */
    public Region mo56495a(@NonNull C4022a aVar) {
        Cursor a = mo56461a(f2814b, m2602a("%s = ?", "id"), new String[]{Region.C4072b.f3088a}, (String) null, (String) null, (String) null, IcyHeaders.REQUEST_HEADER_ENABLE_METADATA_VALUE);
        Region.C4072b bVar = null;
        if (a != null) {
            if (a.moveToFirst()) {
                try {
                    bVar = new Region.C4072b(LatLon.m2843a(Double.valueOf(aVar.mo56545b(a.getString(a.getColumnIndex("latitude")))).doubleValue(), Double.valueOf(aVar.mo56545b(a.getString(a.getColumnIndex("longitude")))).doubleValue()), a.getInt(a.getColumnIndex("radius")));
                } catch (Exception e) {
                    C4039h.m2830e(f2816d, e, "Unable to read magic region from DB.", new Object[0]);
                }
            }
            a.close();
        }
        return bVar;
    }

    /* renamed from: a */
    public Region mo56496a(String str, @NonNull C4022a aVar) {
        Cursor a = mo56461a(f2814b, m2602a("%s = ?", "id"), new String[]{str}, (String) null, (String) null, (String) null, IcyHeaders.REQUEST_HEADER_ENABLE_METADATA_VALUE);
        Region region = null;
        if (a != null) {
            if (a.moveToFirst()) {
                region = m2601a(a, aVar);
            }
            a.close();
        }
        return region;
    }

    @NonNull
    /* renamed from: a */
    public List<Region> mo56497a(int i, C4022a aVar) {
        List<Region> emptyList = Collections.emptyList();
        Cursor a = mo56459a(f2814b, m2602a("%s = ?", "location_type"), new String[]{String.valueOf(i)});
        if (a != null) {
            if (a.moveToFirst()) {
                ArrayList arrayList = new ArrayList(a.getCount());
                do {
                    Region a2 = m2601a(a, aVar);
                    if (a2 != null) {
                        arrayList.add(a2);
                    }
                } while (a.moveToNext());
                emptyList = arrayList;
            }
            a.close();
        }
        return emptyList;
    }

    /* renamed from: a */
    public void mo56449a(C4022a aVar, C4022a aVar2, SQLiteDatabase sQLiteDatabase) {
    }

    /* renamed from: a */
    public void mo56498a(@NonNull Region region, @NonNull C4022a aVar) {
        ContentValues b = m2603b(region, aVar);
        if (mo56453a(b, m2602a("%s = ?", "id"), new String[]{region.mo56647id()}) == 0) {
            mo56455a(b);
        }
    }

    /* renamed from: b */
    public int mo56499b() {
        return mo56462c((String) null);
    }

    @NonNull
    /* renamed from: b */
    public List<String> mo56500b(int i) {
        List<String> emptyList = Collections.emptyList();
        Cursor a = mo56459a(new String[]{"id"}, m2602a("%s = ?", "location_type"), new String[]{String.valueOf(i)});
        if (a != null) {
            if (a.moveToFirst()) {
                ArrayList arrayList = new ArrayList();
                int columnIndex = a.getColumnIndex("id");
                do {
                    arrayList.add(a.getString(columnIndex));
                } while (a.moveToNext());
                emptyList = arrayList;
            }
            a.close();
        }
        return emptyList;
    }

    @NonNull
    /* renamed from: c */
    public List<String> mo56501c(int i) {
        List<String> emptyList = Collections.emptyList();
        Cursor a = mo56459a(new String[]{"id"}, m2602a("%s = ? AND %s = ?", "location_type", C3999a.f2827k), new String[]{String.valueOf(i), IcyHeaders.REQUEST_HEADER_ENABLE_METADATA_VALUE});
        if (a != null) {
            if (a.moveToFirst()) {
                ArrayList arrayList = new ArrayList(a.getCount());
                int columnIndex = a.getColumnIndex("id");
                do {
                    arrayList.add(a.getString(columnIndex));
                } while (a.moveToNext());
                emptyList = arrayList;
            }
            a.close();
        }
        return emptyList;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: e */
    public String mo56450e() {
        return "regions";
    }
}

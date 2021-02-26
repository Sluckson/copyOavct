package com.salesforce.marketingcloud.p022d.p023a;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.salesforce.marketingcloud.C4039h;
import com.salesforce.marketingcloud.location.LatLon;
import com.salesforce.marketingcloud.p022d.C4015g;
import com.salesforce.marketingcloud.p027e.C4022a;
import java.util.Locale;

@SuppressLint({"UnknownNullness"})
/* renamed from: com.salesforce.marketingcloud.d.a.e */
public final class C3994e extends C3979b implements C4015g {

    /* renamed from: a */
    public static final String f2777a = "location_table";

    /* renamed from: b */
    public static final String f2778b = "CREATE TABLE location_table (id INTEGER PRIMARY KEY CHECK (id = 0), latitude VARCHAR, longitude VARCHAR );";

    /* renamed from: c */
    public static final String[] f2779c = {"id", "latitude", "longitude"};

    /* renamed from: d */
    private static final String f2780d = C4039h.m2810a((Class<?>) C3994e.class);

    /* renamed from: com.salesforce.marketingcloud.d.a.e$a */
    public static class C3995a {

        /* renamed from: a */
        public static final String f2781a = "id";

        /* renamed from: b */
        public static final String f2782b = "latitude";

        /* renamed from: c */
        public static final String f2783c = "longitude";
    }

    public C3994e(SQLiteDatabase sQLiteDatabase) {
        super(sQLiteDatabase);
    }

    /* renamed from: a */
    public int mo56483a() {
        return mo56462c((String) null);
    }

    @Nullable
    /* renamed from: a */
    public LatLon mo56484a(@NonNull C4022a aVar) {
        Cursor a = mo56459a(f2779c, String.format(Locale.ENGLISH, "%s = ?", new Object[]{"id"}), new String[]{"0"});
        LatLon latLon = null;
        if (a != null) {
            if (a.moveToFirst()) {
                try {
                    latLon = LatLon.m2843a(Double.valueOf(aVar.mo56545b(a.getString(a.getColumnIndex("latitude")))).doubleValue(), Double.valueOf(aVar.mo56545b(a.getString(a.getColumnIndex("longitude")))).doubleValue());
                } catch (Exception e) {
                    C4039h.m2830e(f2780d, e, "Unable to read location from database.", new Object[0]);
                }
            }
            a.close();
        }
        return latLon;
    }

    /* renamed from: a */
    public void mo56449a(C4022a aVar, C4022a aVar2, SQLiteDatabase sQLiteDatabase) {
    }

    /* renamed from: a */
    public void mo56485a(@NonNull LatLon latLon, @NonNull C4022a aVar) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("id", 0);
        contentValues.put("latitude", aVar.mo56544a(Double.toString(latLon.latitude())));
        contentValues.put("longitude", aVar.mo56544a(Double.toString(latLon.longitude())));
        if (mo56453a(contentValues, String.format(Locale.ENGLISH, "%s = ?", new Object[]{"id"}), new String[]{"0"}) == 0) {
            mo56455a(contentValues);
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: e */
    public String mo56450e() {
        return f2777a;
    }
}

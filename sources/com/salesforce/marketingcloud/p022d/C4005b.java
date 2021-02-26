package com.salesforce.marketingcloud.p022d;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.SharedPreferences;
import androidx.annotation.NonNull;
import com.salesforce.marketingcloud.C4039h;
import com.salesforce.marketingcloud.p022d.C4007c;
import com.salesforce.marketingcloud.p022d.p023a.C4004j;
import com.salesforce.marketingcloud.p027e.C4022a;
import java.io.File;
import java.util.Locale;

@SuppressLint({"UnknownNullness"})
/* renamed from: com.salesforce.marketingcloud.d.b */
public abstract class C4005b extends C4010d {

    /* renamed from: a */
    protected static final String f2866a = "create_date";

    /* renamed from: f */
    private static final String f2867f = "storagedb.db";

    /* renamed from: g */
    private static final String f2868g = "ETSharedPrefs";

    /* renamed from: h */
    private static final String f2869h = C4039h.m2810a((Class<?>) C4005b.class);

    /* renamed from: i */
    private static final String f2870i = "mcsdk_%s";

    /* renamed from: b */
    protected final String f2871b;

    /* renamed from: c */
    protected final Context f2872c;

    /* renamed from: d */
    protected final C4022a f2873d;

    C4005b(@NonNull Context context, @NonNull C4022a aVar, @NonNull String str, @NonNull String str2) {
        super(str, str2);
        this.f2872c = context;
        this.f2873d = aVar;
        this.f2871b = str;
        if (!mo56536h() && mo56535g() && mo56534f()) {
            try {
                mo56537i();
            } catch (Exception e) {
                C4039h.m2830e(f2869h, e, "Unable to migrate data to BU specific storage", new Object[0]);
            }
        }
    }

    /* renamed from: a */
    static String m2645a(String str) {
        return String.format(Locale.ENGLISH, f2870i, new Object[]{str});
    }

    /* renamed from: f */
    private boolean mo56534f() {
        return mo56519a(this.f2872c.getSharedPreferences(f2868g, 0));
    }

    /* renamed from: g */
    private boolean mo56535g() {
        File databasePath = this.f2872c.getDatabasePath(f2867f);
        return databasePath != null && databasePath.exists();
    }

    /* renamed from: h */
    private boolean mo56536h() {
        File databasePath = this.f2872c.getDatabasePath(C4004j.m2636a(this.f2871b));
        return databasePath != null && databasePath.exists();
    }

    /* renamed from: i */
    private void mo56537i() {
        File databasePath = this.f2872c.getDatabasePath(f2867f);
        if (databasePath != null && databasePath.exists()) {
            try {
                if (!databasePath.renameTo(new File(databasePath.getParent(), C4004j.m2636a(this.f2871b)))) {
                    C4039h.m2829e(f2869h, "Unable to rename storagedb.db to BU specific naming scheme", new Object[0]);
                }
            } catch (Exception e) {
                C4039h.m2830e(f2869h, e, "Unable to rename storagedb.db to BU specific naming scheme", new Object[0]);
            }
        }
        File file = new File(this.f2872c.getApplicationInfo().dataDir, "shared_prefs/");
        if (file.exists()) {
            File file2 = new File(file, "ETCustomerPrefs.xml");
            if (file2.exists()) {
                try {
                    if (!file2.renameTo(new File(file, C4007c.C4008a.m2655b(this.f2871b) + ".xml"))) {
                        C4039h.m2829e(f2869h, "Unable to rename ETCustomerPrefs.xml to BU specific naming scheme", new Object[0]);
                    }
                } catch (Exception e2) {
                    C4039h.m2830e(f2869h, e2, "Unable to rename ETCustomerPrefs.xml to BU specific naming scheme", new Object[0]);
                }
            }
            File file3 = new File(file, "ETSharedPrefs.xml");
            if (file3.exists()) {
                try {
                    if (!file3.renameTo(new File(file, m2645a(this.f2871b) + ".xml"))) {
                        C4039h.m2829e(f2869h, "Unable to rename ETSharedPrefs.xml to BU specific naming scheme", new Object[0]);
                    }
                } catch (Exception e3) {
                    C4039h.m2830e(f2869h, e3, "Unable to rename ETSharedPrefs.xml to BU specific naming scheme", new Object[0]);
                }
            }
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public abstract boolean mo56519a(SharedPreferences sharedPreferences);
}

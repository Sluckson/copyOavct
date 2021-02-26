package com.salesforce.marketingcloud.p017a;

import android.annotation.SuppressLint;
import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.os.Build;
import android.os.Bundle;
import androidx.annotation.IntRange;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.annotation.Size;
import androidx.annotation.VisibleForTesting;
import androidx.core.app.NotificationCompat;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;
import com.salesforce.marketingcloud.C4038g;
import com.salesforce.marketingcloud.C4039h;
import com.salesforce.marketingcloud.InitializationStatus;
import com.salesforce.marketingcloud.MCReceiver;
import com.salesforce.marketingcloud.p017a.C3848a;
import com.salesforce.marketingcloud.p020b.C3929a;
import com.salesforce.marketingcloud.p020b.C3930b;
import com.salesforce.marketingcloud.p020b.C3931c;
import com.salesforce.marketingcloud.p022d.C4016h;
import com.salesforce.marketingcloud.p027e.C4028g;
import com.salesforce.marketingcloud.p027e.C4029h;
import java.util.Date;
import java.util.EnumSet;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

@SuppressLint({"UnknownNullness"})
@RestrictTo({RestrictTo.Scope.LIBRARY})
/* renamed from: com.salesforce.marketingcloud.a.b */
public class C3872b extends C4038g implements C3930b {
    @RestrictTo({RestrictTo.Scope.LIBRARY})

    /* renamed from: a */
    public static final String f2241a = "com.salesforce.marketingcloud.ACTION_ALARM_WAKE_EVENT";
    @RestrictTo({RestrictTo.Scope.LIBRARY})

    /* renamed from: b */
    public static final String f2242b = "com.salesforce.marketingcloud.WAKE_FOR_ALARM";

    /* renamed from: c */
    static final String f2243c = "pending_alarms";

    /* renamed from: d */
    static final String f2244d = "alarm_listeners";

    /* renamed from: e */
    static final String f2245e = "scheduled_for";

    /* renamed from: g */
    private static final long f2246g = 0;
    /* access modifiers changed from: private */

    /* renamed from: h */
    public static final String f2247h = C4039h.m2810a((Class<?>) C3872b.class);
    @VisibleForTesting

    /* renamed from: f */
    BroadcastReceiver f2248f;

    /* renamed from: i */
    private final Map<C3848a.C3850a, C3874a> f2249i = new HashMap();

    /* renamed from: j */
    private final C3931c f2250j;

    /* renamed from: k */
    private Context f2251k;

    /* renamed from: l */
    private C4016h f2252l;

    /* renamed from: m */
    private SharedPreferences f2253m;

    /* renamed from: com.salesforce.marketingcloud.a.b$1 */
    static /* synthetic */ class C38731 {

        /* renamed from: a */
        static final /* synthetic */ int[] f2254a = new int[C3929a.values().length];

        static {
            try {
                f2254a[C3929a.BEHAVIOR_DEVICE_BOOT_COMPLETE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
        }
    }

    /* renamed from: com.salesforce.marketingcloud.a.b$a */
    public interface C3874a {
        /* renamed from: a */
        void mo56216a(@NonNull C3848a.C3850a aVar);
    }

    /* renamed from: com.salesforce.marketingcloud.a.b$b */
    class C3875b extends BroadcastReceiver {
        C3875b() {
        }

        public void onReceive(Context context, Intent intent) {
            long currentTimeMillis = System.currentTimeMillis();
            if (intent == null) {
                C4039h.m2817a(C3872b.f2247h, "Received null intent", new Object[0]);
                return;
            }
            String action = intent.getAction();
            if (action == null) {
                C4039h.m2817a(C3872b.f2247h, "Received null action", new Object[0]);
                return;
            }
            Bundle extras = intent.getExtras();
            if (extras == null) {
                C4039h.m2817a(C3872b.f2247h, "Intent had no extras", new Object[0]);
                return;
            }
            char c = 65535;
            if (action.hashCode() == -1436687111 && action.equals(C3872b.f2241a)) {
                c = 0;
            }
            if (c != 0) {
                C4039h.m2820b(C3872b.f2247h, "Received unknown action: %s", action);
                return;
            }
            String string = extras.getString("com.salesforce.marketingcloud.WAKE_FOR_ALARM", (String) null);
            if (string != null) {
                C4039h.m2817a(C3872b.f2247h, "ACTION_ALARM_WAKE_EVENT had extra: %s", string);
                try {
                    C3848a.C3850a valueOf = C3848a.C3850a.valueOf(string);
                    C3872b.this.mo56212c(valueOf);
                    if (valueOf.mo56199b().mo56189a()) {
                        for (C3848a.C3850a aVar : C3848a.C3850a.values()) {
                            if (aVar.mo56199b().mo56189a() && C3872b.this.mo56208a(aVar, currentTimeMillis)) {
                                C3872b.this.mo56213c(aVar);
                                C3872b.this.mo56212c(aVar);
                            }
                        }
                    }
                } catch (IllegalArgumentException unused) {
                    C4039h.m2826d(C3872b.f2247h, "Woke for an unknown alarm: %s", string);
                }
            }
        }
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public C3872b(@NonNull Context context, @NonNull C4016h hVar, @NonNull C3931c cVar) {
        this.f2251k = context;
        this.f2252l = hVar;
        this.f2250j = (C3931c) C4028g.m2762a(cVar, "BehaviorManager is null");
        this.f2253m = hVar.mo56532e();
    }

    @NonNull
    /* renamed from: a */
    private static PendingIntent m2126a(@NonNull Context context, @Nullable String str, @NonNull Integer num) {
        return PendingIntent.getBroadcast(context, num.intValue(), MCReceiver.m2064a(context, str), 134217728);
    }

    /* renamed from: a */
    private void m2127a(long j) {
        for (C3848a.C3850a aVar : C3848a.C3850a.values()) {
            C3848a b = aVar.mo56199b();
            long j2 = this.f2253m.getLong(b.mo56195g(), 0);
            if (j2 > 0) {
                if (mo56208a(aVar, j)) {
                    mo56201a(this.f2251k, aVar, this.f2253m.getLong(b.mo56191c(), b.mo56192d()), j2);
                } else {
                    mo56212c(aVar);
                }
            }
        }
    }

    /* renamed from: a */
    private void m2128a(@NonNull C3848a.C3850a aVar, @IntRange(from = 0) long j, @IntRange(from = 0, mo669to = 86400000) long j2) {
        C4039h.m2820b(f2247h, "Setting the %s Alarm Flag ...", aVar.name());
        this.f2253m.edit().putLong(aVar.mo56199b().mo56195g(), j).putLong(aVar.mo56199b().mo56191c(), j2).apply();
    }

    /* renamed from: a */
    private boolean m2129a(@NonNull C3848a.C3850a aVar, boolean z) {
        if (!aVar.mo56198a(this.f2252l)) {
            C4039h.m2820b(f2247h, "shouldCreateAlarm() for %s Alarm was FALSE.  Aborting alarm creation.", aVar.name());
            return false;
        }
        long currentTimeMillis = System.currentTimeMillis();
        long b = mo56209b(aVar);
        if (!mo56208a(aVar, currentTimeMillis)) {
            C4039h.m2820b(f2247h, "No pending %s Alarm. Creating one ...", aVar.name());
            m2128a(aVar, currentTimeMillis, b);
            mo56201a(this.f2251k, aVar, z ? 1000 : b, currentTimeMillis);
            return true;
        } else if (z) {
            return false;
        } else {
            C4039h.m2820b(f2247h, "%s Send Pending ... will send at %s", aVar.name(), C4029h.m2766a(new Date(this.f2252l.mo56532e().getLong(aVar.mo56199b().mo56195g(), 0) + b)));
            return false;
        }
    }

    @NonNull
    /* renamed from: a */
    public final JSONObject mo56200a() {
        C3848a.C3850a[] aVarArr;
        JSONObject jSONObject = new JSONObject();
        JSONArray jSONArray = new JSONArray();
        long currentTimeMillis = System.currentTimeMillis();
        try {
            C3848a.C3850a[] values = C3848a.C3850a.values();
            int length = values.length;
            int i = 0;
            while (i < length) {
                C3848a.C3850a aVar = values[i];
                JSONObject jSONObject2 = new JSONObject();
                boolean a = mo56208a(aVar, currentTimeMillis);
                jSONObject2.put(aVar.name(), a);
                if (a) {
                    aVarArr = values;
                    jSONObject2.put(f2245e, C4029h.m2766a(new Date(this.f2253m.getLong(aVar.mo56199b().mo56195g(), 0) + this.f2253m.getLong(aVar.mo56199b().mo56191c(), 0))));
                } else {
                    aVarArr = values;
                }
                jSONArray.put(jSONObject2);
                i++;
                values = aVarArr;
            }
            jSONObject.put(f2243c, jSONArray);
            JSONArray jSONArray2 = new JSONArray();
            for (Map.Entry next : this.f2249i.entrySet()) {
                jSONArray2.put(String.format(Locale.ENGLISH, "%s:%s", new Object[]{((C3848a.C3850a) next.getKey()).name(), next.getValue()}));
            }
            jSONObject.put(f2244d, jSONArray2);
        } catch (JSONException e) {
            C4039h.m2830e(f2247h, e, "Failed to generate Component State JSONObject.", new Object[0]);
        }
        return jSONObject;
    }

    /* access modifiers changed from: package-private */
    @VisibleForTesting
    /* renamed from: a */
    public void mo56201a(@NonNull Context context, @NonNull C3848a.C3850a aVar, @IntRange(from = 0, mo669to = 86400000) long j, @IntRange(from = 0) long j2) {
        PendingIntent a = m2126a(context, aVar.name(), Integer.valueOf(aVar.mo56199b().mo56196h()));
        AlarmManager alarmManager = (AlarmManager) context.getSystemService(NotificationCompat.CATEGORY_ALARM);
        long j3 = j2 + j;
        String a2 = C4029h.m2766a(new Date(j3));
        try {
            if (Build.VERSION.SDK_INT >= 19) {
                alarmManager.setExact(0, j3, a);
            } else {
                alarmManager.set(0, j3, a);
            }
            C4039h.m2817a(f2247h, "%s Alarm scheduled to wake at %s.", aVar.name(), a2);
        } catch (Exception e) {
            C4039h.m2827d(f2247h, e, "Failed to schedule alarm %s for %s", aVar.name(), a2);
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public final void mo56202a(@NonNull InitializationStatus.C3832a aVar) {
        this.f2250j.mo56346a((C3930b) this, (EnumSet<C3929a>) EnumSet.of(C3929a.BEHAVIOR_DEVICE_BOOT_COMPLETE));
        this.f2248f = new C3875b();
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction(f2241a);
        LocalBroadcastManager.getInstance(this.f2251k).registerReceiver(this.f2248f, intentFilter);
    }

    @SuppressLint({"LambdaLast"})
    @RestrictTo({RestrictTo.Scope.LIBRARY})
    /* renamed from: a */
    public void mo56203a(@NonNull C3874a aVar, @NonNull C3848a.C3850a... aVarArr) {
        synchronized (this.f2249i) {
            for (C3848a.C3850a put : aVarArr) {
                this.f2249i.put(put, aVar);
            }
        }
    }

    /* renamed from: a */
    public final void mo56204a(@NonNull C3929a aVar, @NonNull Bundle bundle) {
        if (C38731.f2254a[aVar.ordinal()] == 1) {
            m2127a(bundle.getLong("timestamp"));
        }
    }

    /* renamed from: a */
    public final void mo56205a(boolean z) {
        if (z) {
            mo56213c(C3848a.C3850a.values());
        }
        Context context = this.f2251k;
        if (context != null) {
            LocalBroadcastManager.getInstance(context).unregisterReceiver(this.f2248f);
        }
        this.f2250j.mo56345a((C3930b) this);
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    /* renamed from: a */
    public void mo56206a(@NonNull C3848a.C3850a... aVarArr) {
        synchronized (this.f2249i) {
            for (C3848a.C3850a remove : aVarArr) {
                this.f2249i.remove(remove);
            }
        }
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    /* renamed from: a */
    public boolean mo56207a(@NonNull C3848a.C3850a aVar) {
        return aVar.mo56199b().mo56190b() && m2129a(aVar, true);
    }

    /* access modifiers changed from: package-private */
    @VisibleForTesting
    /* renamed from: a */
    public final boolean mo56208a(@NonNull C3848a.C3850a aVar, @IntRange(from = 0) long j) {
        return this.f2253m.getLong(aVar.mo56199b().mo56195g(), 0) > j - this.f2253m.getLong(aVar.mo56199b().mo56191c(), 0);
    }

    /* access modifiers changed from: package-private */
    @VisibleForTesting
    /* renamed from: b */
    public final long mo56209b(@NonNull C3848a.C3850a aVar) {
        long j = this.f2253m.getLong(aVar.mo56199b().mo56191c(), 0);
        long d = j == 0 ? aVar.mo56199b().mo56192d() : (long) (((double) j) * aVar.mo56199b().mo56193e());
        if (d <= aVar.mo56199b().mo56194f()) {
            return d;
        }
        long f = aVar.mo56199b().mo56194f();
        C4039h.m2820b(f2247h, "%s MAX INTERVAL exceeded. Setting interval to %s milliseconds.", aVar.name(), Long.valueOf(f));
        return f;
    }

    @NonNull
    /* renamed from: b */
    public final String mo56210b() {
        return "AlarmScheduler";
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    /* renamed from: b */
    public void mo56211b(@Size(min = 1) @NonNull C3848a.C3850a... aVarArr) {
        for (C3848a.C3850a a : aVarArr) {
            m2129a(a, false);
        }
    }

    /* access modifiers changed from: package-private */
    @VisibleForTesting
    /* renamed from: c */
    public void mo56212c(C3848a.C3850a aVar) {
        mo56215e(aVar);
        C3874a aVar2 = this.f2249i.get(aVar);
        if (aVar2 != null) {
            aVar2.mo56216a(aVar);
        }
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    /* renamed from: c */
    public void mo56213c(@Size(min = 1) @NonNull C3848a.C3850a... aVarArr) {
        for (C3848a.C3850a aVar : aVarArr) {
            mo56214d(aVar);
            mo56215e(aVar);
            try {
                ((AlarmManager) this.f2251k.getSystemService(NotificationCompat.CATEGORY_ALARM)).cancel(m2126a(this.f2251k, aVar.name(), Integer.valueOf(aVar.mo56199b().mo56196h())));
                C4039h.m2820b(f2247h, "Reset %s alarm.", aVar.name());
            } catch (Exception e) {
                C4039h.m2827d(f2247h, e, "Could not cancel %s alarm.", aVar.name());
            }
        }
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    /* renamed from: d */
    public void mo56214d(@Size(min = 1) @NonNull C3848a.C3850a... aVarArr) {
        for (C3848a.C3850a aVar : aVarArr) {
            C4039h.m2820b(f2247h, "Resetting %s Alarm Interval.", aVar.name());
            this.f2253m.edit().putLong(aVar.mo56199b().mo56191c(), 0).apply();
        }
    }

    /* access modifiers changed from: package-private */
    @VisibleForTesting
    /* renamed from: e */
    public void mo56215e(@Size(min = 1) @NonNull C3848a.C3850a... aVarArr) {
        for (C3848a.C3850a aVar : aVarArr) {
            C4039h.m2820b(f2247h, "Resetting %s Alarm Active Flag to FALSE", aVar.name());
            this.f2253m.edit().putLong(aVar.mo56199b().mo56195g(), 0).apply();
        }
    }
}

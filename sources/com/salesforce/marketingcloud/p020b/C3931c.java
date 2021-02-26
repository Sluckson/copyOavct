package com.salesforce.marketingcloud.p020b;

import android.annotation.SuppressLint;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.collection.ArrayMap;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;
import com.salesforce.marketingcloud.C4038g;
import com.salesforce.marketingcloud.C4039h;
import com.salesforce.marketingcloud.InitializationStatus;
import com.salesforce.marketingcloud.p027e.C4028g;
import java.util.Collections;
import java.util.EnumSet;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.RejectedExecutionException;
import org.json.JSONObject;

@SuppressLint({"UnknownNullness"})
@RestrictTo({RestrictTo.Scope.LIBRARY})
/* renamed from: com.salesforce.marketingcloud.b.c */
public class C3931c extends C4038g {

    /* renamed from: a */
    public static final String f2467a = "timestamp";

    /* renamed from: b */
    static final int f2468b = 1;
    /* access modifiers changed from: private */

    /* renamed from: c */
    public static final String f2469c = C4039h.m2810a((Class<?>) C3931c.class);

    /* renamed from: d */
    private final ExecutorService f2470d;

    /* renamed from: e */
    private final ArrayMap<C3929a, Set<C3930b>> f2471e = new ArrayMap<>();

    /* renamed from: f */
    private final Map<C3929a, Bundle> f2472f = new ArrayMap(1);

    /* renamed from: g */
    private final Context f2473g;

    /* renamed from: h */
    private BroadcastReceiver f2474h;

    /* renamed from: com.salesforce.marketingcloud.b.c$a */
    private class C3933a extends BroadcastReceiver {
        private C3933a() {
        }

        public void onReceive(Context context, Intent intent) {
            if (intent == null) {
                C4039h.m2817a(C3931c.f2469c, "Received null intent", new Object[0]);
                return;
            }
            String action = intent.getAction();
            if (action == null) {
                C4039h.m2817a(C3931c.f2469c, "Received null action", new Object[0]);
                return;
            }
            C3929a a = C3929a.m2331a(action);
            if (a != null) {
                C3931c.this.m2334a(a, intent.getExtras());
            }
        }
    }

    /* renamed from: com.salesforce.marketingcloud.b.c$b */
    static class C3934b implements Runnable {

        /* renamed from: a */
        final Set<C3930b> f2476a;

        /* renamed from: b */
        final C3929a f2477b;

        /* renamed from: c */
        final Bundle f2478c;

        C3934b(Set<C3930b> set, C3929a aVar, Bundle bundle) {
            this.f2476a = set;
            this.f2477b = aVar;
            this.f2478c = bundle;
        }

        public void run() {
            for (C3930b next : this.f2476a) {
                if (next != null) {
                    try {
                        next.mo56204a(this.f2477b, this.f2478c);
                    } catch (Exception e) {
                        C4039h.m2830e(C3931c.f2469c, e, "Failure delivering behavior %s to %s", this.f2477b.f2465n, next.getClass().getName());
                    }
                }
            }
        }
    }

    public C3931c(@NonNull Context context) {
        this.f2473g = context;
        this.f2470d = Executors.newSingleThreadExecutor();
    }

    /* renamed from: a */
    public static void m2333a(@NonNull Context context, @NonNull C3929a aVar, @Nullable Bundle bundle) {
        C4028g.m2762a(context, "Context is null");
        C4028g.m2762a(aVar, "Behavior is null");
        Intent intent = new Intent(aVar.f2465n);
        if (bundle != null) {
            intent.putExtras(bundle);
        }
        LocalBroadcastManager.getInstance(context).sendBroadcast(intent);
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m2334a(@NonNull C3929a aVar, @Nullable Bundle bundle) {
        if (bundle == null) {
            bundle = new Bundle();
        }
        bundle.putLong("timestamp", System.currentTimeMillis());
        C4039h.m2820b(f2469c, "Behavior found: %s", aVar.name());
        synchronized (this.f2471e) {
            Set set = this.f2471e.get(aVar);
            if (set != null && !set.isEmpty()) {
                try {
                    this.f2470d.submit(new C3934b(Collections.unmodifiableSet(set), aVar, bundle));
                } catch (RejectedExecutionException e) {
                    C4039h.m2830e(f2469c, e, "Unable to deliver behavior %s.", aVar.f2465n);
                }
            }
        }
        if (aVar.f2466o) {
            synchronized (this.f2472f) {
                this.f2472f.put(aVar, bundle);
            }
        }
    }

    @Nullable
    /* renamed from: a */
    public final JSONObject mo56200a() {
        return null;
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void mo56202a(@NonNull InitializationStatus.C3832a aVar) {
        this.f2474h = new C3933a();
        IntentFilter intentFilter = new IntentFilter();
        for (C3929a aVar2 : C3929a.values()) {
            intentFilter.addAction(aVar2.f2465n);
        }
        LocalBroadcastManager.getInstance(this.f2473g).registerReceiver(this.f2474h, intentFilter);
    }

    /* renamed from: a */
    public void mo56345a(@NonNull C3930b bVar) {
        synchronized (this.f2471e) {
            for (Map.Entry<C3929a, Set<C3930b>> value : this.f2471e.entrySet()) {
                ((Set) value.getValue()).remove(bVar);
            }
        }
    }

    @SuppressLint({"LambdaLast"})
    /* renamed from: a */
    public void mo56346a(@NonNull C3930b bVar, @NonNull EnumSet<C3929a> enumSet) {
        C4028g.m2762a(bVar, "BehaviorListener is null");
        C4028g.m2762a(enumSet, "Behavior set is null");
        synchronized (this.f2471e) {
            C4039h.m2820b(f2469c, "Registering %s for behaviors: %s", bVar.getClass().getName(), enumSet.toString());
            Iterator it = enumSet.iterator();
            while (it.hasNext()) {
                C3929a aVar = (C3929a) it.next();
                Set set = this.f2471e.get(aVar);
                if (set == null) {
                    set = new HashSet();
                    this.f2471e.put(aVar, set);
                }
                set.add(bVar);
            }
        }
        synchronized (this.f2472f) {
            Iterator it2 = enumSet.iterator();
            while (it2.hasNext()) {
                C3929a aVar2 = (C3929a) it2.next();
                if (aVar2.f2466o && this.f2472f.containsKey(aVar2)) {
                    bVar.mo56204a(aVar2, this.f2472f.get(aVar2));
                }
            }
        }
    }

    /* renamed from: a */
    public final void mo56205a(boolean z) {
        Context context = this.f2473g;
        if (context != null) {
            LocalBroadcastManager.getInstance(context).unregisterReceiver(this.f2474h);
        }
    }

    @NonNull
    /* renamed from: b */
    public final String mo56210b() {
        return "BehaviorManager";
    }
}

package com.salesforce.marketingcloud.proximity;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import androidx.annotation.NonNull;
import androidx.annotation.VisibleForTesting;
import androidx.collection.ArraySet;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;
import com.salesforce.marketingcloud.C4039h;
import com.salesforce.marketingcloud.InitializationStatus;
import com.salesforce.marketingcloud.p027e.C4026e;
import com.salesforce.marketingcloud.p027e.C4028g;
import com.salesforce.marketingcloud.proximity.C4124g;
import java.util.List;
import java.util.Set;
import org.altbeacon.beacon.service.BeaconService;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.salesforce.marketingcloud.proximity.c */
class C4117c extends C4124g {

    /* renamed from: e */
    private final Context f3344e;

    /* renamed from: f */
    private final Set<C4124g.C4125a> f3345f = new ArraySet();

    /* renamed from: g */
    private final C4115b f3346g;

    /* renamed from: h */
    private BroadcastReceiver f3347h;

    /* renamed from: i */
    private int f3348i;

    /* renamed from: j */
    private int f3349j;

    /* renamed from: com.salesforce.marketingcloud.proximity.c$a */
    private class C4119a extends BroadcastReceiver {
        private C4119a() {
        }

        public void onReceive(Context context, Intent intent) {
            if (intent == null) {
                C4039h.m2817a(C4124g.f3356d, "Received null intent.", new Object[0]);
                return;
            }
            String action = intent.getAction();
            if (action == null) {
                C4039h.m2817a(C4124g.f3356d, "Received null action", new Object[0]);
                return;
            }
            char c = 65535;
            int hashCode = action.hashCode();
            if (hashCode != 351071323) {
                if (hashCode == 1959909049 && action.equals(C4124g.f3354b)) {
                    c = 1;
                }
            } else if (action.equals(C4124g.f3353a)) {
                c = 0;
            }
            if (c == 0) {
                C4117c.this.mo56918a((C4122e) intent.getParcelableExtra(C4124g.f3355c));
            } else if (c != 1) {
                C4039h.m2820b(C4124g.f3356d, "Received unknown action: ", action);
            } else {
                C4117c.this.mo56921b((C4122e) intent.getParcelableExtra(C4124g.f3355c));
            }
        }
    }

    public C4117c(@NonNull Context context) {
        C4028g.m2762a(context, "Context is null");
        this.f3344e = context;
        if (C4026e.m2758a(context.getPackageManager(), new Intent(context, BeaconService.class))) {
            this.f3346g = new C4115b(context);
            return;
        }
        throw new IllegalStateException("AltBeacon service not found");
    }

    /* renamed from: a */
    public JSONObject mo56200a() {
        JSONObject jSONObject;
        try {
            jSONObject = m3355f();
            try {
                jSONObject.put("enteredEvents", this.f3348i);
                jSONObject.put("exitedEvents", this.f3349j);
                jSONObject.put("proximityListeners", this.f3345f.size());
            } catch (JSONException e) {
                e = e;
            }
        } catch (JSONException e2) {
            e = e2;
            jSONObject = null;
            C4039h.m2830e(f3356d, e, "Failed to create component state.", new Object[0]);
            return jSONObject;
        }
        return jSONObject;
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void mo56202a(@NonNull InitializationStatus.C3832a aVar) {
        aVar.mo56108d(false);
        this.f3347h = new C4119a();
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction(C4124g.f3353a);
        intentFilter.addAction(C4124g.f3354b);
        LocalBroadcastManager.getInstance(this.f3344e).registerReceiver(this.f3347h, intentFilter);
    }

    /* access modifiers changed from: package-private */
    @VisibleForTesting
    /* renamed from: a */
    public void mo56918a(C4122e eVar) {
        synchronized (this.f3345f) {
            this.f3348i++;
            if (!this.f3345f.isEmpty() && eVar != null) {
                C4039h.m2823c(f3356d, "Entered %s", eVar);
                for (C4124g.C4125a next : this.f3345f) {
                    if (next != null) {
                        next.mo56812a(eVar);
                    }
                }
            }
        }
    }

    /* renamed from: a */
    public void mo56919a(@NonNull C4124g.C4125a aVar) {
        synchronized (this.f3345f) {
            if (aVar != null) {
                this.f3345f.add(aVar);
            }
        }
    }

    /* renamed from: a */
    public void mo56920a(List<C4122e> list) {
        if (list != null) {
            C4039h.m2823c(f3356d, "unmonitorBeaconRegions(%d region)", Integer.valueOf(list.size()));
            this.f3346g.mo56909a(list);
        }
    }

    /* renamed from: a */
    public void mo56205a(boolean z) {
        mo56925d();
        Context context = this.f3344e;
        if (context != null && this.f3347h != null) {
            LocalBroadcastManager.getInstance(context).unregisterReceiver(this.f3347h);
        }
    }

    /* access modifiers changed from: package-private */
    @VisibleForTesting
    /* renamed from: b */
    public void mo56921b(C4122e eVar) {
        synchronized (this.f3345f) {
            this.f3349j++;
            if (!this.f3345f.isEmpty() && eVar != null) {
                C4039h.m2823c(f3356d, "Exited %s", eVar);
                for (C4124g.C4125a next : this.f3345f) {
                    if (next != null) {
                        next.mo56813b(eVar);
                    }
                }
            }
        }
    }

    /* renamed from: b */
    public void mo56922b(@NonNull C4124g.C4125a aVar) {
        synchronized (this.f3345f) {
            this.f3345f.remove(aVar);
        }
    }

    /* renamed from: b */
    public void mo56923b(List<C4122e> list) {
        if (list != null) {
            C4039h.m2823c(f3356d, "monitorBeaconRegions(%d region)", Integer.valueOf(list.size()));
            this.f3346g.mo56910b(list);
        }
    }

    /* renamed from: c */
    public boolean mo56924c() {
        return true;
    }

    /* renamed from: d */
    public void mo56925d() {
        C4115b bVar = this.f3346g;
        if (bVar != null) {
            bVar.mo56908a();
        }
    }
}

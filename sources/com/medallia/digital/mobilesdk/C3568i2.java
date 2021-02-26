package com.medallia.digital.mobilesdk;

import androidx.annotation.VisibleForTesting;
import com.medallia.digital.mobilesdk.C3792y;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

/* renamed from: com.medallia.digital.mobilesdk.i2 */
class C3568i2 {

    /* renamed from: a */
    protected Queue<C3433a2> f1283a = new LinkedList();

    /* renamed from: b */
    protected Queue<C3433a2> f1284b = new LinkedList();

    /* renamed from: c */
    protected C3519f2 f1285c;

    /* renamed from: com.medallia.digital.mobilesdk.i2$a */
    class C3569a implements C3519f2 {
        C3569a() {
        }

        /* renamed from: a */
        public void mo55375a(C3433a2 a2Var) {
            C3519f2 f2Var = C3568i2.this.f1285c;
            if (f2Var != null) {
                f2Var.mo55375a(a2Var);
            }
            C3568i2 i2Var = C3568i2.this;
            i2Var.mo55479a(i2Var.mo55478a());
        }
    }

    C3568i2() {
    }

    /* renamed from: a */
    private void m971a(String str) {
        Boolean b = C3785x1.m1892b(str);
        if (b != null) {
            AnalyticsBridge.getInstance().reportDeleteStorageEvent(str, b.booleanValue());
        }
    }

    /* renamed from: a */
    private void m972a(LinkedHashMap<String, C3433a2> linkedHashMap) {
        ArrayList<? extends C3792y> c = C3782x0.m1872d().mo55913c(C3792y.C3793a.FormData, new Object[0]);
        if (c != null) {
            Iterator<? extends C3792y> it = c.iterator();
            while (it.hasNext()) {
                C3433a2 a2Var = (C3433a2) it.next();
                if (linkedHashMap.get(a2Var.getFormId()) == null) {
                    C3782x0.m1872d().mo55908a((C3792y) a2Var);
                    List<ResourceContract> b = a2Var.mo55187b();
                    if (b != null) {
                        for (ResourceContract next : b) {
                            C3782x0.m1872d().mo55908a((C3792y) next);
                            m971a(next.getLocalUrl());
                        }
                    }
                }
            }
        }
    }

    @VisibleForTesting
    /* renamed from: a */
    public C3433a2 mo55478a() {
        return (this.f1284b.size() > 0 ? this.f1284b : this.f1283a).poll();
    }

    @VisibleForTesting
    /* renamed from: a */
    public void mo55479a(C3433a2 a2Var) {
        if (a2Var == null) {
            C3490e3.m661b("LoadForms - finished updating forms");
            AnalyticsBridge.getInstance().setFormResourcesReady(true);
            AnalyticsBridge.getInstance().reportResourcesSizeEvent();
            return;
        }
        new C3457c2(a2Var, new C3569a()).mo55249a();
    }

    @VisibleForTesting
    /* renamed from: a */
    public void mo55480a(HashMap<String, C3525f5> hashMap) {
        if (hashMap != null && hashMap.size() != 0) {
            for (C3525f5 next : hashMap.values()) {
                C3782x0.m1872d().mo55908a((C3792y) next);
                m971a(next.mo55378a());
            }
        }
    }

    @VisibleForTesting
    /* renamed from: a */
    public void mo55481a(HashMap<String, C3525f5> hashMap, C3433a2 a2Var) {
        C3525f5 f5Var;
        if (hashMap != null && a2Var != null && a2Var.mo55190d() != null && (f5Var = hashMap.get(a2Var.mo55190d())) != null && f5Var.mo55380b() != null && f5Var.mo55380b().equals(a2Var.mo55190d())) {
            hashMap.remove(f5Var.mo55380b());
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void mo55482a(LinkedHashMap<String, C3433a2> linkedHashMap, C3519f2 f2Var) {
        if (linkedHashMap != null) {
            this.f1285c = f2Var;
            ArrayList<? extends C3792y> c = C3782x0.m1872d().mo55913c(C3792y.C3793a.Template, new Object[0]);
            HashMap hashMap = new HashMap();
            Iterator<? extends C3792y> it = c.iterator();
            while (it.hasNext()) {
                C3525f5 f5Var = (C3525f5) it.next();
                hashMap.put(f5Var.mo55380b(), f5Var);
            }
            m972a(linkedHashMap);
            this.f1283a = new LinkedList();
            for (Map.Entry next : linkedHashMap.entrySet()) {
                mo55481a((HashMap<String, C3525f5>) hashMap, (C3433a2) next.getValue());
                this.f1283a.add(next.getValue());
            }
            mo55480a((HashMap<String, C3525f5>) hashMap);
            if (this.f1283a != null) {
                mo55479a(mo55478a());
            }
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: b */
    public boolean mo55483b(C3433a2 a2Var) {
        if (a2Var == null || !this.f1283a.contains(a2Var)) {
            return false;
        }
        C3433a2 element = this.f1283a.element();
        if (element == null || element.getFormId().equals(a2Var.getFormId())) {
            return true;
        }
        this.f1283a.remove(a2Var);
        this.f1284b.add(a2Var);
        C3490e3.m661b("Promoting form " + a2Var.getFormId());
        if (this.f1283a.size() != 0) {
            return true;
        }
        mo55479a(mo55478a());
        return true;
    }
}

package com.medallia.digital.mobilesdk;

import androidx.annotation.VisibleForTesting;
import com.medallia.digital.mobilesdk.C3792y;
import java.io.File;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/* renamed from: com.medallia.digital.mobilesdk.n4 */
class C3649n4 {

    /* renamed from: d */
    private static final int f1585d = 5;

    /* renamed from: a */
    protected C3651b f1586a;

    /* renamed from: b */
    private int f1587b;

    /* renamed from: c */
    private Queue<List<ResourceContract>> f1588c;

    /* renamed from: com.medallia.digital.mobilesdk.n4$a */
    class C3650a implements C3660o4<File> {

        /* renamed from: a */
        final /* synthetic */ ResourceContract f1589a;

        /* renamed from: b */
        final /* synthetic */ List f1590b;

        C3650a(ResourceContract resourceContract, List list) {
            this.f1589a = resourceContract;
            this.f1590b = list;
        }

        /* renamed from: a */
        public void mo55254a() {
        }

        /* renamed from: a */
        public void mo55256a(C3586j3 j3Var) {
            C3649n4.m1360a(C3649n4.this);
            C3490e3.m661b(this.f1589a.getRemoteUrl() + " download failed");
            C3649n4.this.f1586a.mo55260b(this.f1589a);
            C3649n4.this.m1364b(this.f1590b);
        }

        /* renamed from: a */
        public void mo55257a(File file) {
            C3649n4.m1360a(C3649n4.this);
            if (file != null) {
                C3490e3.m661b(this.f1589a.getRemoteUrl() + " download complete");
                C3649n4.this.f1586a.mo55259a(this.f1589a);
                C3782x0.m1872d().mo55915c((C3792y) this.f1589a);
            } else {
                C3490e3.m661b(this.f1589a.getRemoteUrl() + " download failed");
                C3649n4.this.f1586a.mo55260b(this.f1589a);
            }
            C3649n4.this.m1364b(this.f1590b);
        }
    }

    /* renamed from: com.medallia.digital.mobilesdk.n4$b */
    protected interface C3651b {
        /* renamed from: a */
        void mo55259a(ResourceContract resourceContract);

        /* renamed from: b */
        void mo55260b(ResourceContract resourceContract);
    }

    protected C3649n4(List<ResourceContract> list, C3651b bVar) {
        this.f1586a = bVar;
        if (list != null) {
            this.f1588c = m1365c(list);
            m1361a();
        }
    }

    /* renamed from: a */
    static /* synthetic */ int m1360a(C3649n4 n4Var) {
        int i = n4Var.f1587b;
        n4Var.f1587b = i - 1;
        return i;
    }

    @VisibleForTesting
    /* renamed from: a */
    private void m1361a() {
        Queue<List<ResourceContract>> queue = this.f1588c;
        if (queue != null) {
            mo55683a(queue.poll());
        }
    }

    /* renamed from: a */
    private void m1362a(ResourceContract resourceContract, List<ResourceContract> list) {
        C3646n3.m1337m().mo55668a(resourceContract.getRemoteUrl(), resourceContract.getLocalUrl(), new C3650a(resourceContract, list));
    }

    /* access modifiers changed from: private */
    @VisibleForTesting
    /* renamed from: b */
    public void m1364b(List<ResourceContract> list) {
        if (list != null && list.size() != 0 && this.f1587b == 0) {
            m1361a();
        }
    }

    @VisibleForTesting
    /* renamed from: c */
    private Queue<List<ResourceContract>> m1365c(List<ResourceContract> list) {
        LinkedList linkedList = new LinkedList();
        int size = list.size();
        int i = 0;
        while (i < size) {
            int i2 = i + 5;
            linkedList.add(new ArrayList(list.subList(i, Math.min(size, i2))));
            i = i2;
        }
        return linkedList;
    }

    @VisibleForTesting
    /* renamed from: a */
    public void mo55682a(ResourceContract resourceContract, ResourceContract resourceContract2) {
        Boolean b;
        if (resourceContract != null && resourceContract2 != null) {
            if ((!resourceContract.getRemoteUrl().equals(resourceContract2.getRemoteUrl()) || !resourceContract.getChecksum().equals(resourceContract2.getChecksum())) && (b = C3785x1.m1892b(resourceContract.getLocalUrl())) != null) {
                AnalyticsBridge.getInstance().reportDeleteStorageEvent(resourceContract.getLocalUrl(), b.booleanValue());
            }
        }
    }

    @VisibleForTesting
    /* renamed from: a */
    public void mo55683a(List<ResourceContract> list) {
        if (list != null) {
            this.f1587b = list.size();
            for (ResourceContract next : list) {
                ResourceContract resourceContract = (ResourceContract) C3782x0.m1872d().mo55911b(C3792y.C3793a.Resource, next.getRemoteUrl());
                if (next.equals(resourceContract)) {
                    C3490e3.m661b(resourceContract.getRemoteUrl() + " loaded from db");
                    this.f1586a.mo55259a(next);
                    this.f1587b = this.f1587b - 1;
                    m1364b(list);
                } else {
                    mo55682a(resourceContract, next);
                    m1362a(next, list);
                }
            }
        }
    }
}

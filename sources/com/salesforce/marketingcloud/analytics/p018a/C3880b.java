package com.salesforce.marketingcloud.analytics.p018a;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.RestrictTo;
import com.salesforce.marketingcloud.C4039h;
import com.salesforce.marketingcloud.analytics.C3910d;
import com.salesforce.marketingcloud.analytics.C3923k;
import com.salesforce.marketingcloud.messages.Region;
import com.salesforce.marketingcloud.messages.inbox.InboxMessage;
import com.salesforce.marketingcloud.notifications.NotificationMessage;
import com.salesforce.marketingcloud.p022d.C3961a;
import com.salesforce.marketingcloud.p022d.C4016h;
import com.salesforce.marketingcloud.p027e.C4028g;
import java.util.Arrays;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

@RestrictTo({RestrictTo.Scope.LIBRARY})
/* renamed from: com.salesforce.marketingcloud.analytics.a.b */
public final class C3880b extends C3923k {

    /* renamed from: a */
    private static final String f2271a = C4039h.m2810a((Class<?>) C3880b.class);

    /* renamed from: b */
    private static final int f2272b = 0;

    /* renamed from: c */
    private final C4016h f2273c;

    public C3880b(@NonNull C4016h hVar) {
        this.f2273c = (C4016h) C4028g.m2762a(hVar, "MCStorage may not be null.");
    }

    /* renamed from: a */
    public static void m2166a(@NonNull C4016h hVar, boolean z) {
        if (z) {
            hVar.mo56535g().mo56444d(0);
        }
    }

    /* renamed from: a */
    private void m2167a(@NonNull Region region, Date date) {
        try {
            this.f2273c.mo56535g().mo56436a(C3910d.m2283a(date, 0, region.regionType() == 1 ? 11 : 13, Collections.singletonList(region.mo56647id()), false), this.f2273c.mo56524a());
        } catch (Exception e) {
            C4039h.m2830e(f2271a, e, "Failed to record EtAnalyticItem for startTimeInRegion", new Object[0]);
        }
    }

    /* renamed from: b */
    private void m2168b(@NonNull Region region, @NonNull Date date) {
        try {
            List<C3910d> a = this.f2273c.mo56535g().mo56435a(region, this.f2273c.mo56524a());
            if (!a.isEmpty()) {
                for (C3910d next : a) {
                    int seconds = (int) TimeUnit.MILLISECONDS.toSeconds(date.getTime() - next.mo56311b().getTime());
                    if (seconds > 0) {
                        next.mo56312b(seconds);
                        next.mo56310a(true);
                        this.f2273c.mo56535g().mo56439b(next, this.f2273c.mo56524a());
                    }
                }
            }
        } catch (Exception e) {
            C4039h.m2830e(f2271a, e, "Failed to record EtAnalyticItem for stopTimeInRegion.", new Object[0]);
        }
    }

    /* renamed from: a */
    public void mo56255a(long j) {
        if (!this.f2273c.mo56535g().mo56447e(0)) {
            try {
                this.f2273c.mo56535g().mo56436a(C3910d.m2281a(new Date(j), 0, 4), this.f2273c.mo56524a());
            } catch (Exception e) {
                C4039h.m2830e(f2271a, e, "Failed to create our EtAnalyticItem for TimeInApp.", new Object[0]);
            }
        }
    }

    /* renamed from: a */
    public void mo56256a(@NonNull Region region) {
        Date date = new Date();
        m2167a(region, date);
        try {
            this.f2273c.mo56535g().mo56436a(C3910d.m2283a(date, 0, region.regionType() == 1 ? 6 : 12, Collections.singletonList(region.mo56647id()), true), this.f2273c.mo56524a());
        } catch (Exception e) {
            C4039h.m2830e(f2271a, e, "Failed to record EtAnalyticItem for Geofence region entry.", new Object[0]);
        }
    }

    /* renamed from: a */
    public void mo56254a(boolean z) {
        if (z) {
            this.f2273c.mo56535g().mo56444d(0);
        }
    }

    /* renamed from: b */
    public void mo56257b(long j) {
        try {
            for (C3910d next : this.f2273c.mo56535g().mo56445d()) {
                int seconds = (int) TimeUnit.MILLISECONDS.toSeconds(j - next.mo56311b().getTime());
                if (seconds > 0) {
                    next.mo56312b(seconds);
                    next.mo56310a(true);
                    this.f2273c.mo56535g().mo56439b(next, this.f2273c.mo56524a());
                }
            }
        } catch (Exception e) {
            C4039h.m2830e(f2271a, e, "Failed to update our EtAnalytic TimeInApp.", new Object[0]);
        }
    }

    /* renamed from: b */
    public void mo56258b(@NonNull Region region) {
        Date date = new Date();
        m2168b(region, date);
        if (region.regionType() != 3) {
            try {
                this.f2273c.mo56535g().mo56436a(C3910d.m2283a(date, 0, 7, Collections.singletonList(region.mo56647id()), true), this.f2273c.mo56524a());
            } catch (Exception e) {
                C4039h.m2830e(f2271a, e, "Failed to record EtAnalyticItem for Geofence region exit.", new Object[0]);
            }
        }
    }

    /* renamed from: b */
    public void mo56259b(@NonNull NotificationMessage notificationMessage) {
        List list;
        try {
            if (this.f2273c.mo56535g().mo56447e(0)) {
                mo56257b(0);
            }
            C3961a g = this.f2273c.mo56535g();
            Date date = new Date();
            if (TextUtils.isEmpty(notificationMessage.regionId())) {
                list = Arrays.asList(new String[]{notificationMessage.mo56835id()});
            } else {
                list = Arrays.asList(new String[]{notificationMessage.mo56835id(), notificationMessage.regionId()});
            }
            g.mo56436a(C3910d.m2283a(date, 0, 5, list, false), this.f2273c.mo56524a());
        } catch (Exception e) {
            C4039h.m2830e(f2271a, e, "Failed to store EtAnalyticItem for message opened.", new Object[0]);
        }
    }

    /* renamed from: c */
    public void mo56260c(long j) {
        try {
            List<C3910d> d = this.f2273c.mo56535g().mo56446d(this.f2273c.mo56524a());
            if (!d.isEmpty()) {
                for (C3910d next : d) {
                    int seconds = (int) TimeUnit.MILLISECONDS.toSeconds(j - next.mo56311b().getTime());
                    if (seconds > 0) {
                        next.mo56312b(seconds);
                        next.mo56310a(true);
                        this.f2273c.mo56535g().mo56439b(next, this.f2273c.mo56524a());
                    }
                }
            }
        } catch (Exception e) {
            C4039h.m2830e(f2271a, e, "Failed to update local storage for stopTimeInAllRegions.", new Object[0]);
        }
    }

    public void trackInboxOpenEvent(@NonNull InboxMessage inboxMessage) {
        if (inboxMessage == null) {
            C4039h.m2826d(f2271a, "InboxMessage was null. Call to trackInboxOpenEvent() ignored.", new Object[0]);
            return;
        }
        try {
            this.f2273c.mo56535g().mo56436a(C3910d.m2282a(new Date(), 0, 15, Collections.singletonList(inboxMessage.mo56741id()), inboxMessage.mo56731a(), true), this.f2273c.mo56524a());
        } catch (Exception e) {
            C4039h.m2827d(f2271a, e, "Failed to record analytic event for Inbox Message Opened.", new Object[0]);
        }
    }
}

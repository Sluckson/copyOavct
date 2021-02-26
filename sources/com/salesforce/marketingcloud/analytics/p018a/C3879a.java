package com.salesforce.marketingcloud.analytics.p018a;

import android.annotation.SuppressLint;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.RestrictTo;
import com.salesforce.marketingcloud.C4039h;
import com.salesforce.marketingcloud.analytics.C3910d;
import com.salesforce.marketingcloud.analytics.C3923k;
import com.salesforce.marketingcloud.messages.inbox.InboxMessage;
import com.salesforce.marketingcloud.notifications.NotificationMessage;
import com.salesforce.marketingcloud.p022d.C4016h;
import com.salesforce.marketingcloud.p027e.C4028g;
import java.util.Arrays;
import java.util.Collections;
import java.util.Date;

@SuppressLint({"UnknownNullness"})
@RestrictTo({RestrictTo.Scope.LIBRARY})
/* renamed from: com.salesforce.marketingcloud.analytics.a.a */
public class C3879a extends C3923k {

    /* renamed from: a */
    private static final String f2268a = C4039h.m2810a((Class<?>) C3879a.class);

    /* renamed from: b */
    private static final int f2269b = 0;

    /* renamed from: c */
    private final C4016h f2270c;

    public C3879a(C4016h hVar) {
        this.f2270c = (C4016h) C4028g.m2762a(hVar, "MCStorage may not be null");
    }

    /* renamed from: a */
    public static void m2162a(C4016h hVar, boolean z) {
        if (z) {
            hVar.mo56535g().mo56441c(0);
        }
    }

    /* renamed from: a */
    public void mo56252a(@NonNull InboxMessage inboxMessage) {
        try {
            this.f2270c.mo56535g().mo56436a(C3910d.m2282a(new Date(), 0, 14, Collections.singletonList(inboxMessage.mo56741id()), inboxMessage.mo56731a(), true), this.f2270c.mo56524a());
        } catch (Exception unused) {
            C4039h.m2829e(f2268a, "Failed to record message downloaded analytic for message: %s", inboxMessage.mo56741id());
        }
    }

    /* renamed from: a */
    public void mo56253a(@NonNull NotificationMessage notificationMessage) {
        try {
            if (!TextUtils.isEmpty(notificationMessage.mo56835id()) && !TextUtils.isEmpty(notificationMessage.regionId())) {
                this.f2270c.mo56535g().mo56436a(C3910d.m2283a(new Date(), 0, 3, Arrays.asList(new String[]{notificationMessage.mo56835id(), notificationMessage.regionId()}), true), this.f2270c.mo56524a());
            }
        } catch (Exception e) {
            C4039h.m2830e(f2268a, e, "Failed to record EtAnalyticItem for region message displayed.", new Object[0]);
        }
    }

    /* renamed from: a */
    public void mo56254a(boolean z) {
        if (z) {
            this.f2270c.mo56535g().mo56441c(0);
        }
    }
}

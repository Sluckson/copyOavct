package com.salesforce.marketingcloud.messages.inbox;

import android.annotation.SuppressLint;
import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.annotation.VisibleForTesting;
import com.salesforce.marketingcloud.C3956d;
import com.salesforce.marketingcloud.C4037f;
import com.salesforce.marketingcloud.C4039h;
import com.salesforce.marketingcloud.InitializationStatus;
import com.salesforce.marketingcloud.MarketingCloudConfig;
import com.salesforce.marketingcloud.analytics.C3920i;
import com.salesforce.marketingcloud.messages.inbox.InboxMessageManager;
import com.salesforce.marketingcloud.notifications.NotificationManager;
import com.salesforce.marketingcloud.notifications.NotificationMessage;
import com.salesforce.marketingcloud.p017a.C3848a;
import com.salesforce.marketingcloud.p017a.C3872b;
import com.salesforce.marketingcloud.p020b.C3929a;
import com.salesforce.marketingcloud.p020b.C3930b;
import com.salesforce.marketingcloud.p020b.C3931c;
import com.salesforce.marketingcloud.p021c.C3944d;
import com.salesforce.marketingcloud.p021c.C3946e;
import com.salesforce.marketingcloud.p021c.C3949f;
import com.salesforce.marketingcloud.p021c.C3953g;
import com.salesforce.marketingcloud.p022d.C4016h;
import com.salesforce.marketingcloud.p027e.C4028g;
import java.util.Collections;
import java.util.EnumSet;
import java.util.List;
import java.util.Map;
import org.json.JSONObject;

@SuppressLint({"UnknownNullness"})
@RestrictTo({RestrictTo.Scope.LIBRARY})
/* renamed from: com.salesforce.marketingcloud.messages.inbox.c */
public class C4094c implements C3872b.C3874a, C3930b, C3949f.C3951a, C4037f, InboxMessageManager {

    /* renamed from: a */
    private static final String f3196a = C4039h.m2810a((Class<?>) C4094c.class);

    /* renamed from: b */
    private final MarketingCloudConfig f3197b;

    /* renamed from: c */
    private final C4016h f3198c;

    /* renamed from: d */
    private final String f3199d;

    /* renamed from: e */
    private final C3931c f3200e;

    /* renamed from: f */
    private final C3872b f3201f;

    /* renamed from: g */
    private final C3949f f3202g;

    /* renamed from: h */
    private final C3920i f3203h;

    /* renamed from: i */
    private C4096d f3204i;

    /* renamed from: com.salesforce.marketingcloud.messages.inbox.c$1 */
    static /* synthetic */ class C40951 {

        /* renamed from: a */
        static final /* synthetic */ int[] f3205a = new int[C3929a.values().length];

        /* renamed from: b */
        static final /* synthetic */ int[] f3206b = new int[C3848a.C3850a.values().length];

        /* JADX WARNING: Can't wrap try/catch for region: R(15:0|(2:1|2)|3|5|6|7|9|10|11|12|13|14|15|16|18) */
        /* JADX WARNING: Can't wrap try/catch for region: R(16:0|1|2|3|5|6|7|9|10|11|12|13|14|15|16|18) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:11:0x0032 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:13:0x003c */
        /* JADX WARNING: Missing exception handler attribute for start block: B:15:0x0047 */
        static {
            /*
                com.salesforce.marketingcloud.a.a$a[] r0 = com.salesforce.marketingcloud.p017a.C3848a.C3850a.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f3206b = r0
                r0 = 1
                int[] r1 = f3206b     // Catch:{ NoSuchFieldError -> 0x0014 }
                com.salesforce.marketingcloud.a.a$a r2 = com.salesforce.marketingcloud.p017a.C3848a.C3850a.FETCH_INBOX_MESSAGES     // Catch:{ NoSuchFieldError -> 0x0014 }
                int r2 = r2.ordinal()     // Catch:{ NoSuchFieldError -> 0x0014 }
                r1[r2] = r0     // Catch:{ NoSuchFieldError -> 0x0014 }
            L_0x0014:
                r1 = 2
                int[] r2 = f3206b     // Catch:{ NoSuchFieldError -> 0x001f }
                com.salesforce.marketingcloud.a.a$a r3 = com.salesforce.marketingcloud.p017a.C3848a.C3850a.UPDATE_INBOX_MESSAGE_STATUS     // Catch:{ NoSuchFieldError -> 0x001f }
                int r3 = r3.ordinal()     // Catch:{ NoSuchFieldError -> 0x001f }
                r2[r3] = r1     // Catch:{ NoSuchFieldError -> 0x001f }
            L_0x001f:
                com.salesforce.marketingcloud.b.a[] r2 = com.salesforce.marketingcloud.p020b.C3929a.values()
                int r2 = r2.length
                int[] r2 = new int[r2]
                f3205a = r2
                int[] r2 = f3205a     // Catch:{ NoSuchFieldError -> 0x0032 }
                com.salesforce.marketingcloud.b.a r3 = com.salesforce.marketingcloud.p020b.C3929a.BEHAVIOR_APP_FOREGROUNDED     // Catch:{ NoSuchFieldError -> 0x0032 }
                int r3 = r3.ordinal()     // Catch:{ NoSuchFieldError -> 0x0032 }
                r2[r3] = r0     // Catch:{ NoSuchFieldError -> 0x0032 }
            L_0x0032:
                int[] r0 = f3205a     // Catch:{ NoSuchFieldError -> 0x003c }
                com.salesforce.marketingcloud.b.a r2 = com.salesforce.marketingcloud.p020b.C3929a.BEHAVIOR_APP_BACKGROUNDED     // Catch:{ NoSuchFieldError -> 0x003c }
                int r2 = r2.ordinal()     // Catch:{ NoSuchFieldError -> 0x003c }
                r0[r2] = r1     // Catch:{ NoSuchFieldError -> 0x003c }
            L_0x003c:
                int[] r0 = f3205a     // Catch:{ NoSuchFieldError -> 0x0047 }
                com.salesforce.marketingcloud.b.a r1 = com.salesforce.marketingcloud.p020b.C3929a.BEHAVIOR_SDK_PUSH_RECEIVED     // Catch:{ NoSuchFieldError -> 0x0047 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0047 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0047 }
            L_0x0047:
                int[] r0 = f3205a     // Catch:{ NoSuchFieldError -> 0x0052 }
                com.salesforce.marketingcloud.b.a r1 = com.salesforce.marketingcloud.p020b.C3929a.BEHAVIOR_SDK_NOTIFICATION_OPENED     // Catch:{ NoSuchFieldError -> 0x0052 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0052 }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0052 }
            L_0x0052:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.salesforce.marketingcloud.messages.inbox.C4094c.C40951.<clinit>():void");
        }
    }

    public C4094c(MarketingCloudConfig marketingCloudConfig, C4016h hVar, String str, C3931c cVar, C3872b bVar, C3949f fVar, C3920i iVar) {
        this.f3197b = (MarketingCloudConfig) C4028g.m2762a(marketingCloudConfig, "MarketingCloudConfig is null.");
        this.f3198c = (C4016h) C4028g.m2762a(hVar, "Storage is null.");
        this.f3199d = (String) C4028g.m2761a(str, "You must provide the Device ID.");
        this.f3200e = (C3931c) C4028g.m2762a(cVar, "BehaviorManager is null.");
        this.f3201f = (C3872b) C4028g.m2762a(bVar, "AlarmScheduler is null.");
        this.f3202g = (C3949f) C4028g.m2762a(fVar, "RequestManager is null.");
        this.f3203h = (C3920i) C4028g.m2762a(iVar, "InboxAnalyticEventListener is null.");
    }

    @VisibleForTesting(otherwise = 5)
    C4094c(C4096d dVar) {
        this.f3197b = null;
        this.f3198c = null;
        this.f3199d = null;
        this.f3200e = null;
        this.f3201f = null;
        this.f3202g = null;
        this.f3203h = null;
        this.f3204i = dVar;
    }

    /* renamed from: a */
    private static boolean m3157a(@NonNull Bundle bundle) {
        return String.valueOf(8).equals(bundle.getString("_mt"));
    }

    /* renamed from: a */
    public static boolean m3158a(@NonNull Map<String, String> map) {
        return String.valueOf(8).equals(map.get("_mt"));
    }

    @Nullable
    /* renamed from: a */
    public JSONObject mo56200a() {
        C4096d dVar = this.f3204i;
        if (dVar != null) {
            return dVar.mo56794a();
        }
        return null;
    }

    /* renamed from: a */
    public void mo56338a(int i) {
        if (C3956d.m2459b(i, 128)) {
            this.f3204i = null;
            C4096d.m3169a(this.f3198c, this.f3201f, C3956d.m2460c(i, 128));
            this.f3200e.mo56345a((C3930b) this);
            this.f3201f.mo56206a(C3848a.C3850a.FETCH_INBOX_MESSAGES, C3848a.C3850a.UPDATE_INBOX_MESSAGE_STATUS);
            this.f3202g.mo56414a(C3944d.INBOX_MESSAGE);
            this.f3202g.mo56414a(C3944d.INBOX_STATUS);
        } else if (this.f3204i == null && this.f3197b.inboxEnabled()) {
            mo56793c();
        }
    }

    /* renamed from: a */
    public void mo56339a(@NonNull InitializationStatus.C3832a aVar, int i) {
        if (C3956d.m2457a(i, 128) && this.f3197b.inboxEnabled()) {
            mo56793c();
        }
    }

    /* renamed from: a */
    public void mo56216a(@NonNull C3848a.C3850a aVar) {
        if (this.f3204i != null) {
            int i = C40951.f3206b[aVar.ordinal()];
            if (i == 1) {
                this.f3204i.mo56805d();
            } else if (i == 2) {
                this.f3204i.mo56806e();
            }
        }
    }

    /* renamed from: a */
    public void mo56204a(@NonNull C3929a aVar, @NonNull Bundle bundle) {
        NotificationMessage notificationMessage;
        if (this.f3204i != null) {
            int i = C40951.f3205a[aVar.ordinal()];
            if (i == 1) {
                this.f3204i.mo56802b();
            } else if (i == 2) {
                this.f3204i.mo56804c();
            } else if (i != 3) {
                if (i == 4 && (notificationMessage = (NotificationMessage) bundle.get(NotificationManager.f3287h)) != null) {
                    this.f3204i.mo56800a(notificationMessage);
                }
            } else if (m3157a(bundle)) {
                try {
                    this.f3204i.mo56799a(InboxMessage.m3125a(bundle));
                } catch (Exception e) {
                    C4039h.m2830e(f3196a, e, "Failed to seed inbox_messages table with message: %s.", bundle.getString("_m"));
                }
            }
        }
    }

    /* renamed from: a */
    public void mo56262a(C3946e eVar, C3953g gVar) {
        if (this.f3204i == null) {
            return;
        }
        if (C3944d.INBOX_MESSAGE == eVar.mo56383h()) {
            if (gVar.mo56419h()) {
                this.f3204i.mo56798a(gVar);
            } else {
                this.f3204i.mo56795a(gVar.mo56361c(), gVar.mo56360b());
            }
        } else if (C3944d.INBOX_STATUS != eVar.mo56383h()) {
        } else {
            if (gVar.mo56419h()) {
                this.f3204i.mo56797a(eVar);
            } else {
                this.f3204i.mo56803b(gVar.mo56361c(), gVar.mo56360b());
            }
        }
    }

    /* renamed from: a */
    public void mo56205a(boolean z) {
        C3872b bVar = this.f3201f;
        if (bVar != null) {
            bVar.mo56206a(C3848a.C3850a.FETCH_INBOX_MESSAGES, C3848a.C3850a.UPDATE_INBOX_MESSAGE_STATUS);
        }
        C3931c cVar = this.f3200e;
        if (cVar != null) {
            cVar.mo56345a((C3930b) this);
        }
    }

    @NonNull
    /* renamed from: b */
    public final String mo56210b() {
        return "InboxMessageManager";
    }

    /* access modifiers changed from: package-private */
    /* renamed from: c */
    public void mo56793c() {
        this.f3204i = new C4096d(this.f3197b, this.f3198c, this.f3199d, this.f3201f, this.f3202g, this.f3203h);
        this.f3202g.mo56415a(C3944d.INBOX_MESSAGE, (C3949f.C3951a) this);
        this.f3202g.mo56415a(C3944d.INBOX_STATUS, (C3949f.C3951a) this);
        this.f3201f.mo56203a((C3872b.C3874a) this, C3848a.C3850a.FETCH_INBOX_MESSAGES, C3848a.C3850a.UPDATE_INBOX_MESSAGE_STATUS);
        this.f3200e.mo56346a((C3930b) this, (EnumSet<C3929a>) EnumSet.of(C3929a.BEHAVIOR_APP_FOREGROUNDED, C3929a.BEHAVIOR_SDK_PUSH_RECEIVED, C3929a.BEHAVIOR_APP_BACKGROUNDED, C3929a.BEHAVIOR_SDK_NOTIFICATION_OPENED));
    }

    public void deleteMessage(@NonNull InboxMessage inboxMessage) {
        C4096d dVar = this.f3204i;
        if (dVar != null) {
            dVar.deleteMessage(inboxMessage);
        } else {
            C4039h.m2826d(f3196a, "Inbox messaging is disabled.  Call to deleteMessage() was ignored.", new Object[0]);
        }
    }

    public int getDeletedMessageCount() {
        C4096d dVar = this.f3204i;
        if (dVar != null) {
            return dVar.getDeletedMessageCount();
        }
        C4039h.m2826d(f3196a, "Inbox messaging is disabled.  Call to getDeletedMessageCount() was ignored.", new Object[0]);
        return 0;
    }

    @NonNull
    public List<InboxMessage> getDeletedMessages() {
        List<InboxMessage> emptyList = Collections.emptyList();
        C4096d dVar = this.f3204i;
        if (dVar != null) {
            return dVar.getDeletedMessages();
        }
        C4039h.m2826d(f3196a, "Inbox messaging is disabled.  Call to getDeletedMessages() was ignored.", new Object[0]);
        return emptyList;
    }

    public int getMessageCount() {
        C4096d dVar = this.f3204i;
        if (dVar != null) {
            return dVar.getMessageCount();
        }
        C4039h.m2826d(f3196a, "Inbox messaging is disabled.  Call to getMessageCount() was ignored.", new Object[0]);
        return 0;
    }

    @NonNull
    public List<InboxMessage> getMessages() {
        List<InboxMessage> emptyList = Collections.emptyList();
        C4096d dVar = this.f3204i;
        if (dVar != null) {
            return dVar.getMessages();
        }
        C4039h.m2826d(f3196a, "Inbox messaging is disabled.  Call to getMessages() was ignored.", new Object[0]);
        return emptyList;
    }

    public int getReadMessageCount() {
        C4096d dVar = this.f3204i;
        if (dVar != null) {
            return dVar.getReadMessageCount();
        }
        C4039h.m2826d(f3196a, "Inbox messaging is disabled.  Call to getReadMessageCount() was ignored.", new Object[0]);
        return 0;
    }

    @NonNull
    public List<InboxMessage> getReadMessages() {
        List<InboxMessage> emptyList = Collections.emptyList();
        C4096d dVar = this.f3204i;
        if (dVar != null) {
            return dVar.getReadMessages();
        }
        C4039h.m2826d(f3196a, "Inbox messaging is disabled.  Call to getReadMessages() was ignored.", new Object[0]);
        return emptyList;
    }

    public int getUnreadMessageCount() {
        C4096d dVar = this.f3204i;
        if (dVar != null) {
            return dVar.getUnreadMessageCount();
        }
        C4039h.m2826d(f3196a, "Inbox messaging is disabled.  Call to getUnreadMessageCount() was ignored.", new Object[0]);
        return 0;
    }

    @NonNull
    public List<InboxMessage> getUnreadMessages() {
        List<InboxMessage> emptyList = Collections.emptyList();
        C4096d dVar = this.f3204i;
        if (dVar != null) {
            return dVar.getUnreadMessages();
        }
        C4039h.m2826d(f3196a, "Inbox messaging is disabled.  Call to getUnreadMessages() was ignored.", new Object[0]);
        return emptyList;
    }

    public void markAllMessagesDeleted() {
        C4096d dVar = this.f3204i;
        if (dVar != null) {
            dVar.markAllMessagesDeleted();
        } else {
            C4039h.m2826d(f3196a, "Inbox messaging is disabled.  Call to markAllMessagesDeleted() was ignored.", new Object[0]);
        }
    }

    public void markAllMessagesRead() {
        C4096d dVar = this.f3204i;
        if (dVar != null) {
            dVar.markAllMessagesRead();
        } else {
            C4039h.m2826d(f3196a, "Inbox messaging is disabled.  Call to markAllMessagesRead() was ignored.", new Object[0]);
        }
    }

    public void refreshInbox(InboxMessageManager.InboxRefreshListener inboxRefreshListener) {
        C4096d dVar = this.f3204i;
        if (dVar != null) {
            dVar.refreshInbox(inboxRefreshListener);
            return;
        }
        C4039h.m2826d(f3196a, "Inbox messaging is disabled.  Call to refreshInbox() was ignored.", new Object[0]);
        if (inboxRefreshListener != null) {
            try {
                inboxRefreshListener.onRefreshComplete(false);
            } catch (Exception unused) {
                C4039h.m2829e(f3196a, "InboxRefreshListener threw an exception.", new Object[0]);
            }
        }
    }

    public void registerInboxResponseListener(@NonNull InboxMessageManager.InboxResponseListener inboxResponseListener) {
        C4096d dVar = this.f3204i;
        if (dVar != null) {
            dVar.registerInboxResponseListener(inboxResponseListener);
        } else {
            C4039h.m2826d(f3196a, "Inbox messaging is disabled.  Call to registerInboxResponseListener() was ignored.", new Object[0]);
        }
    }

    public void setMessageRead(@NonNull InboxMessage inboxMessage) {
        C4096d dVar = this.f3204i;
        if (dVar != null) {
            dVar.setMessageRead(inboxMessage);
        } else {
            C4039h.m2826d(f3196a, "Inbox messaging is disabled.  Call to setMessageRead() was ignored.", new Object[0]);
        }
    }

    public void unregisterInboxResponseListener(@NonNull InboxMessageManager.InboxResponseListener inboxResponseListener) {
        C4096d dVar = this.f3204i;
        if (dVar != null) {
            dVar.unregisterInboxResponseListener(inboxResponseListener);
        } else {
            C4039h.m2826d(f3196a, "Inbox messaging is disabled.  Call to unregisterInboxResponseListener() was ignored.", new Object[0]);
        }
    }
}

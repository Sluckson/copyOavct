package com.salesforce.marketingcloud.messages.inbox;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import androidx.collection.ArraySet;
import com.iaai.android.old.utils.constants.Constants;
import com.salesforce.marketingcloud.C4039h;
import com.salesforce.marketingcloud.MarketingCloudConfig;
import com.salesforce.marketingcloud.analytics.C3920i;
import com.salesforce.marketingcloud.messages.inbox.InboxMessageManager;
import com.salesforce.marketingcloud.notifications.NotificationMessage;
import com.salesforce.marketingcloud.p017a.C3848a;
import com.salesforce.marketingcloud.p017a.C3872b;
import com.salesforce.marketingcloud.p021c.C3944d;
import com.salesforce.marketingcloud.p021c.C3946e;
import com.salesforce.marketingcloud.p021c.C3949f;
import com.salesforce.marketingcloud.p021c.C3953g;
import com.salesforce.marketingcloud.p022d.C4013f;
import com.salesforce.marketingcloud.p022d.C4016h;
import com.salesforce.marketingcloud.p027e.C4029h;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.salesforce.marketingcloud.messages.inbox.d */
class C4096d implements InboxMessageManager {
    @VisibleForTesting

    /* renamed from: a */
    static final String f3207a = "_sfmc_last_inbox_message_refresh_request_timestamp";

    /* renamed from: b */
    private static final String f3208b = C4039h.m2810a((Class<?>) C4096d.class);

    /* renamed from: c */
    private final Set<InboxMessageManager.InboxResponseListener> f3209c = new ArraySet();

    /* renamed from: d */
    private final MarketingCloudConfig f3210d;

    /* renamed from: e */
    private final C4016h f3211e;

    /* renamed from: f */
    private final String f3212f;

    /* renamed from: g */
    private final C3872b f3213g;

    /* renamed from: h */
    private final C3949f f3214h;

    /* renamed from: i */
    private final C3920i f3215i;

    /* renamed from: j */
    private InboxMessageManager.InboxRefreshListener f3216j;

    /* renamed from: k */
    private boolean f3217k = false;

    C4096d(MarketingCloudConfig marketingCloudConfig, C4016h hVar, String str, C3872b bVar, C3949f fVar, C3920i iVar) {
        this.f3210d = marketingCloudConfig;
        this.f3211e = hVar;
        this.f3212f = str;
        this.f3213g = bVar;
        this.f3214h = fVar;
        this.f3215i = iVar;
    }

    /* renamed from: a */
    private JSONArray m3168a(Map<String, Integer> map) {
        JSONArray jSONArray = new JSONArray();
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put(Constants.DEVICEID_HEADER, this.f3212f);
            String a = C4029h.m2766a(new Date());
            for (Map.Entry next : map.entrySet()) {
                JSONObject jSONObject2 = new JSONObject();
                try {
                    int intValue = ((Integer) next.getValue()).intValue();
                    jSONObject2.put("messageId", next.getKey());
                    jSONObject2.put("action", intValue == 2 ? "Deleted" : intValue == 1 ? "Viewed" : "Unread");
                    jSONObject2.put("actionDate", a);
                    jSONObject2.put("actionParameters", jSONObject);
                    jSONArray.put(jSONObject2);
                } catch (JSONException e) {
                    C4039h.m2830e(f3208b, e, "Failed to add message %s to InboxMessageStatusUpdate payload.", next);
                }
            }
        } catch (JSONException e2) {
            C4039h.m2830e(f3208b, e2, "DeviceID failed to convert to JSON and is required by this REST call.", new Object[0]);
        }
        return jSONArray;
    }

    /* renamed from: a */
    static void m3169a(C4016h hVar, C3872b bVar, boolean z) {
        bVar.mo56213c(C3848a.C3850a.FETCH_INBOX_MESSAGES, C3848a.C3850a.UPDATE_INBOX_MESSAGE_STATUS);
        if (z) {
            hVar.mo56541m().mo56465a();
            hVar.mo56542n().mo56482b();
        }
    }

    /* renamed from: a */
    private void m3170a(boolean z) {
        InboxMessageManager.InboxRefreshListener inboxRefreshListener = this.f3216j;
        if (inboxRefreshListener != null) {
            try {
                inboxRefreshListener.onRefreshComplete(z);
            } catch (Exception e) {
                C4039h.m2830e(f3208b, e, "InboxRefreshListener threw an exception", new Object[0]);
            }
            this.f3216j = null;
        }
    }

    /* renamed from: a */
    private boolean m3171a(@NonNull C4016h hVar) {
        return System.currentTimeMillis() < hVar.mo56532e().getLong(f3207a, 0) + 60000;
    }

    /* renamed from: b */
    private static boolean m3172b(InboxMessage inboxMessage) {
        return inboxMessage.mo56734c() == 1 && inboxMessage.mo56737d() == 2;
    }

    /* renamed from: c */
    private void m3173c(@NonNull InboxMessage inboxMessage) {
        try {
            if (this.f3211e.mo56541m().mo56472b(inboxMessage, this.f3211e.mo56524a()) > 0 && !m3172b(inboxMessage)) {
                this.f3211e.mo56542n().mo56480a(inboxMessage);
            }
        } catch (Exception unused) {
            C4039h.m2826d(f3208b, "Failed to update local storage for message: %s", inboxMessage.mo56741id());
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public JSONObject mo56794a() {
        List<InboxMessage> b = this.f3211e.mo56541m().mo56473b(this.f3211e.mo56524a());
        JSONObject jSONObject = new JSONObject();
        JSONArray jSONArray = new JSONArray();
        try {
            if (!b.isEmpty()) {
                for (InboxMessage next : b) {
                    JSONObject jSONObject2 = new JSONObject();
                    jSONObject2.put("subject", next.subject());
                    jSONObject2.put("start_date", next.startDateUtc());
                    jSONObject2.put("end_date", next.endDateUtc());
                    jSONObject2.put("url", next.url());
                    jSONArray.put(jSONObject2);
                }
            }
            jSONObject.put("inbox_messages", jSONArray);
            JSONArray jSONArray2 = new JSONArray();
            if (!this.f3209c.isEmpty()) {
                for (InboxMessageManager.InboxResponseListener obj : this.f3209c) {
                    jSONArray2.put(obj.toString());
                }
            }
            jSONObject.put("inbox_response_listeners", jSONArray2);
            return jSONObject;
        } catch (JSONException e) {
            C4039h.m2830e(f3208b, e, "Failed to create our component state JSONObject.", new Object[0]);
            return null;
        }
    }

    /* access modifiers changed from: package-private */
    @VisibleForTesting
    /* renamed from: a */
    public void mo56795a(int i, String str) {
        C4039h.m2823c(f3208b, "Request failed: %d - %s", Integer.valueOf(i), str);
        m3170a(false);
        this.f3213g.mo56211b(C3848a.C3850a.FETCH_INBOX_MESSAGES);
    }

    /* access modifiers changed from: package-private */
    @VisibleForTesting
    /* renamed from: a */
    public void mo56796a(long j) {
        this.f3211e.mo56532e().edit().putLong(f3207a, j).apply();
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo56797a(C3946e eVar) {
        if (eVar.mo56409j() != null) {
            String[] split = eVar.mo56409j().split("\\s*,\\s*");
            this.f3213g.mo56214d(C3848a.C3850a.UPDATE_INBOX_MESSAGE_STATUS);
            this.f3211e.mo56542n().mo56481a(split);
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo56798a(C3953g gVar) {
        int length;
        try {
            JSONArray optJSONArray = new JSONObject(gVar.mo56359a()).optJSONArray("messages");
            List emptyList = Collections.emptyList();
            if (optJSONArray != null && (length = optJSONArray.length()) > 0) {
                emptyList = new ArrayList(length);
                for (int i = 0; i < length; i++) {
                    try {
                        emptyList.add(InboxMessage.m3126b(optJSONArray.getJSONObject(i)));
                    } catch (Exception e) {
                        C4039h.m2830e(f3208b, e, "Failed to parse inbox message", new Object[0]);
                    }
                }
            }
            mo56801a((List<InboxMessage>) emptyList);
            m3170a(true);
        } catch (Exception e2) {
            C4039h.m2830e(f3208b, e2, "Failed to parse inbox messages response", new Object[0]);
            mo56795a(-1, "Failed to parse response");
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo56799a(InboxMessage inboxMessage) {
        this.f3211e.mo56541m().mo56470a(inboxMessage, this.f3211e.mo56524a());
        if (this.f3217k) {
            mo56805d();
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo56800a(NotificationMessage notificationMessage) {
        InboxMessage a;
        if (this.f3210d.markMessageReadOnInboxNotificationOpen() && (a = this.f3211e.mo56541m().mo56467a(notificationMessage.mo56835id(), this.f3211e.mo56524a())) != null) {
            setMessageRead(a);
        }
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Removed duplicated region for block: B:33:0x00d5  */
    @androidx.annotation.VisibleForTesting
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void mo56801a(@androidx.annotation.NonNull java.util.List<com.salesforce.marketingcloud.messages.inbox.InboxMessage> r10) {
        /*
            r9 = this;
            com.salesforce.marketingcloud.a.b r0 = r9.f3213g
            r1 = 1
            com.salesforce.marketingcloud.a.a$a[] r2 = new com.salesforce.marketingcloud.p017a.C3848a.C3850a[r1]
            com.salesforce.marketingcloud.a.a$a r3 = com.salesforce.marketingcloud.p017a.C3848a.C3850a.FETCH_INBOX_MESSAGES
            r4 = 0
            r2[r4] = r3
            r0.mo56214d(r2)
            com.salesforce.marketingcloud.d.h r0 = r9.f3211e
            com.salesforce.marketingcloud.d.f r0 = r0.mo56541m()
            com.salesforce.marketingcloud.d.h r2 = r9.f3211e
            com.salesforce.marketingcloud.e.a r2 = r2.mo56524a()
            java.util.List r2 = r0.mo56468a((com.salesforce.marketingcloud.p027e.C4022a) r2)
            java.util.Iterator r2 = r2.iterator()
        L_0x0021:
            boolean r3 = r2.hasNext()
            if (r3 == 0) goto L_0x006e
            java.lang.Object r3 = r2.next()
            com.salesforce.marketingcloud.messages.inbox.InboxMessage r3 = (com.salesforce.marketingcloud.messages.inbox.InboxMessage) r3
            java.util.Iterator r5 = r10.iterator()
        L_0x0031:
            boolean r6 = r5.hasNext()
            if (r6 == 0) goto L_0x004d
            java.lang.Object r6 = r5.next()
            com.salesforce.marketingcloud.messages.inbox.InboxMessage r6 = (com.salesforce.marketingcloud.messages.inbox.InboxMessage) r6
            java.lang.String r7 = r3.mo56741id()
            java.lang.String r6 = r6.mo56741id()
            boolean r6 = r7.equals(r6)
            if (r6 == 0) goto L_0x0031
            r5 = 1
            goto L_0x004e
        L_0x004d:
            r5 = 0
        L_0x004e:
            if (r5 != 0) goto L_0x0021
            r3.mo56766b((boolean) r1)
            com.salesforce.marketingcloud.d.h r5 = r9.f3211e     // Catch:{ Exception -> 0x005d }
            com.salesforce.marketingcloud.e.a r5 = r5.mo56524a()     // Catch:{ Exception -> 0x005d }
            r0.mo56470a((com.salesforce.marketingcloud.messages.inbox.InboxMessage) r3, (com.salesforce.marketingcloud.p027e.C4022a) r5)     // Catch:{ Exception -> 0x005d }
            goto L_0x0021
        L_0x005d:
            r5 = move-exception
            java.lang.String r6 = f3208b
            java.lang.Object[] r7 = new java.lang.Object[r1]
            java.lang.String r3 = r3.mo56741id()
            r7[r4] = r3
            java.lang.String r3 = "InboxMessage %s could not be marked as deleted."
            com.salesforce.marketingcloud.C4039h.m2830e(r6, r5, r3, r7)
            goto L_0x0021
        L_0x006e:
            boolean r2 = r10.isEmpty()
            if (r2 != 0) goto L_0x00f5
            java.util.Iterator r2 = r10.iterator()
        L_0x0078:
            boolean r3 = r2.hasNext()
            if (r3 == 0) goto L_0x00f5
            java.lang.Object r3 = r2.next()
            com.salesforce.marketingcloud.messages.inbox.InboxMessage r3 = (com.salesforce.marketingcloud.messages.inbox.InboxMessage) r3
            java.lang.String r5 = r3.mo56741id()
            com.salesforce.marketingcloud.d.h r6 = r9.f3211e
            com.salesforce.marketingcloud.e.a r6 = r6.mo56524a()
            com.salesforce.marketingcloud.messages.inbox.InboxMessage r5 = r0.mo56467a((java.lang.String) r5, (com.salesforce.marketingcloud.p027e.C4022a) r6)
            if (r5 == 0) goto L_0x00d2
            java.lang.String r6 = r5.mo56733b()
            boolean r6 = android.text.TextUtils.isEmpty(r6)
            if (r6 == 0) goto L_0x00ad
            boolean r6 = r5.read()
            r3.mo56765a((boolean) r6)
            boolean r5 = r5.deleted()
            r3.mo56766b((boolean) r5)
            goto L_0x00d2
        L_0x00ad:
            java.lang.String r6 = r5.mo56733b()
            java.lang.String r7 = r3.mo56733b()
            boolean r6 = r6.equals(r7)
            if (r6 == 0) goto L_0x00d2
            boolean r6 = r5.read()
            r3.mo56765a((boolean) r6)
            boolean r6 = r5.deleted()
            r3.mo56766b((boolean) r6)
            java.util.Date r5 = r5.startDateUtc()
            if (r5 != 0) goto L_0x00d0
            goto L_0x00d2
        L_0x00d0:
            r5 = 0
            goto L_0x00d3
        L_0x00d2:
            r5 = 1
        L_0x00d3:
            if (r5 == 0) goto L_0x00da
            com.salesforce.marketingcloud.analytics.i r5 = r9.f3215i
            r5.mo56252a(r3)
        L_0x00da:
            com.salesforce.marketingcloud.d.h r5 = r9.f3211e     // Catch:{ Exception -> 0x00e4 }
            com.salesforce.marketingcloud.e.a r5 = r5.mo56524a()     // Catch:{ Exception -> 0x00e4 }
            r0.mo56470a((com.salesforce.marketingcloud.messages.inbox.InboxMessage) r3, (com.salesforce.marketingcloud.p027e.C4022a) r5)     // Catch:{ Exception -> 0x00e4 }
            goto L_0x0078
        L_0x00e4:
            r5 = move-exception
            java.lang.String r6 = f3208b
            java.lang.Object[] r7 = new java.lang.Object[r1]
            java.lang.String r3 = r3.mo56741id()
            r7[r4] = r3
            java.lang.String r3 = "Failed to persist state for message %s"
            com.salesforce.marketingcloud.C4039h.m2830e(r6, r5, r3, r7)
            goto L_0x0078
        L_0x00f5:
            java.util.Set<com.salesforce.marketingcloud.messages.inbox.InboxMessageManager$InboxResponseListener> r0 = r9.f3209c
            monitor-enter(r0)
            java.util.Set<com.salesforce.marketingcloud.messages.inbox.InboxMessageManager$InboxResponseListener> r2 = r9.f3209c     // Catch:{ all -> 0x012f }
            boolean r2 = r2.isEmpty()     // Catch:{ all -> 0x012f }
            if (r2 != 0) goto L_0x012d
            java.util.Set<com.salesforce.marketingcloud.messages.inbox.InboxMessageManager$InboxResponseListener> r2 = r9.f3209c     // Catch:{ all -> 0x012f }
            java.util.Iterator r2 = r2.iterator()     // Catch:{ all -> 0x012f }
        L_0x0106:
            boolean r3 = r2.hasNext()     // Catch:{ all -> 0x012f }
            if (r3 == 0) goto L_0x012d
            java.lang.Object r3 = r2.next()     // Catch:{ all -> 0x012f }
            com.salesforce.marketingcloud.messages.inbox.InboxMessageManager$InboxResponseListener r3 = (com.salesforce.marketingcloud.messages.inbox.InboxMessageManager.InboxResponseListener) r3     // Catch:{ all -> 0x012f }
            if (r3 == 0) goto L_0x0106
            r3.onInboxMessagesChanged(r10)     // Catch:{ Exception -> 0x0118 }
            goto L_0x0106
        L_0x0118:
            r5 = move-exception
            java.lang.String r6 = f3208b     // Catch:{ all -> 0x012f }
            java.lang.String r7 = "%s threw an exception while processing the inbox messages response"
            java.lang.Object[] r8 = new java.lang.Object[r1]     // Catch:{ all -> 0x012f }
            java.lang.Class r3 = r3.getClass()     // Catch:{ all -> 0x012f }
            java.lang.String r3 = r3.getName()     // Catch:{ all -> 0x012f }
            r8[r4] = r3     // Catch:{ all -> 0x012f }
            com.salesforce.marketingcloud.C4039h.m2830e(r6, r5, r7, r8)     // Catch:{ all -> 0x012f }
            goto L_0x0106
        L_0x012d:
            monitor-exit(r0)     // Catch:{ all -> 0x012f }
            return
        L_0x012f:
            r10 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x012f }
            throw r10
        */
        throw new UnsupportedOperationException("Method not decompiled: com.salesforce.marketingcloud.messages.inbox.C4096d.mo56801a(java.util.List):void");
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public void mo56802b() {
        this.f3217k = true;
        mo56805d();
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public void mo56803b(int i, String str) {
        C4039h.m2823c(f3208b, "Request failed: %d - %s", Integer.valueOf(i), str);
        this.f3213g.mo56211b(C3848a.C3850a.UPDATE_INBOX_MESSAGE_STATUS);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: c */
    public void mo56804c() {
        this.f3217k = false;
        mo56806e();
    }

    /* access modifiers changed from: package-private */
    /* renamed from: d */
    public void mo56805d() {
        C3949f fVar = this.f3214h;
        C3944d dVar = C3944d.INBOX_MESSAGE;
        MarketingCloudConfig marketingCloudConfig = this.f3210d;
        fVar.mo56416a(dVar.mo56404a(marketingCloudConfig, C3944d.m2387b(marketingCloudConfig.applicationId(), this.f3212f)));
        mo56796a(System.currentTimeMillis());
    }

    public void deleteMessage(@Nullable InboxMessage inboxMessage) {
        if (inboxMessage == null) {
            C4039h.m2829e(f3208b, "InboxMessage was null and could not be updated.  Call to deleteMessage() ignored.", new Object[0]);
            return;
        }
        inboxMessage.mo56766b(true);
        m3173c(inboxMessage);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: e */
    public void mo56806e() {
        Map<String, Integer> a = this.f3211e.mo56542n().mo56478a();
        if (a.size() > 0) {
            C3949f fVar = this.f3214h;
            C3944d dVar = C3944d.INBOX_STATUS;
            MarketingCloudConfig marketingCloudConfig = this.f3210d;
            fVar.mo56416a(dVar.mo56405a(marketingCloudConfig, C3944d.m2383a(marketingCloudConfig.applicationId()), m3168a(a).toString()).mo56408a(TextUtils.join(",", a.keySet())));
        }
    }

    public int getDeletedMessageCount() {
        return this.f3211e.mo56541m().mo56466a(C4013f.C4014a.DELETED);
    }

    @NonNull
    public List<InboxMessage> getDeletedMessages() {
        return this.f3211e.mo56541m().mo56469a(this.f3211e.mo56524a(), C4013f.C4014a.DELETED);
    }

    public int getMessageCount() {
        return this.f3211e.mo56541m().mo56466a(C4013f.C4014a.NOT_DELETED);
    }

    @NonNull
    public List<InboxMessage> getMessages() {
        return this.f3211e.mo56541m().mo56469a(this.f3211e.mo56524a(), C4013f.C4014a.NOT_DELETED);
    }

    public int getReadMessageCount() {
        return this.f3211e.mo56541m().mo56466a(C4013f.C4014a.READ);
    }

    @NonNull
    public List<InboxMessage> getReadMessages() {
        return this.f3211e.mo56541m().mo56469a(this.f3211e.mo56524a(), C4013f.C4014a.READ);
    }

    public int getUnreadMessageCount() {
        return this.f3211e.mo56541m().mo56466a(C4013f.C4014a.UNREAD);
    }

    @NonNull
    public List<InboxMessage> getUnreadMessages() {
        return this.f3211e.mo56541m().mo56469a(this.f3211e.mo56524a(), C4013f.C4014a.UNREAD);
    }

    public void markAllMessagesDeleted() {
        String[] b = this.f3211e.mo56541m().mo56474b();
        if (b.length > 0) {
            this.f3211e.mo56542n().mo56479a(2, b);
        }
    }

    public void markAllMessagesRead() {
        String[] c = this.f3211e.mo56541m().mo56475c();
        if (c.length > 0) {
            this.f3211e.mo56542n().mo56479a(1, c);
        }
    }

    public void refreshInbox(InboxMessageManager.InboxRefreshListener inboxRefreshListener) {
        this.f3216j = inboxRefreshListener;
        if (m3171a(this.f3211e)) {
            C4039h.m2826d(f3208b, "1 minute inbox refresh rate limit exceeded.  Can refresh again on or after %s", C4029h.m2766a(new Date(this.f3211e.mo56532e().getLong(f3207a, 0) + 60000)));
            m3170a(false);
            return;
        }
        C4039h.m2817a(f3208b, "Refreshing inbox messages", new Object[0]);
        mo56805d();
    }

    public void registerInboxResponseListener(@NonNull InboxMessageManager.InboxResponseListener inboxResponseListener) {
        if (inboxResponseListener != null) {
            synchronized (this.f3209c) {
                this.f3209c.add(inboxResponseListener);
            }
        }
    }

    public void setMessageRead(@Nullable InboxMessage inboxMessage) {
        if (inboxMessage == null) {
            C4039h.m2829e(f3208b, "InboxMessage was null and could not be updated.  Call to setMessageRead() ignored.", new Object[0]);
            return;
        }
        inboxMessage.mo56765a(true);
        m3173c(inboxMessage);
    }

    public void unregisterInboxResponseListener(@NonNull InboxMessageManager.InboxResponseListener inboxResponseListener) {
        synchronized (this.f3209c) {
            this.f3209c.remove(inboxResponseListener);
        }
    }
}

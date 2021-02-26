package com.salesforce.marketingcloud.notifications;

import com.salesforce.marketingcloud.notifications.NotificationMessage;
import java.util.Map;

/* renamed from: com.salesforce.marketingcloud.notifications.a */
abstract class C4105a extends C$$AutoValue_NotificationMessage {
    C4105a(String str, String str2, int i, String str3, NotificationMessage.Sound sound, String str4, String str5, String str6, NotificationMessage.Type type, NotificationMessage.Trigger trigger, String str7, String str8, String str9, Map<String, String> map, String str10, Map<String, String> map2) {
        super(str, str2, i, str3, sound, str4, str5, str6, type, trigger, str7, str8, str9, map, str10, map2);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public final NotificationMessage mo56879a(int i) {
        return new C4106b(mo56835id(), regionId(), i, alert(), sound(), soundName(), title(), subTitle(), type(), trigger(), url(), mediaUrl(), mediaAltText(), customKeys(), custom(), payload());
    }
}

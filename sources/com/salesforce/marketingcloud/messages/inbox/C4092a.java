package com.salesforce.marketingcloud.messages.inbox;

import com.salesforce.marketingcloud.messages.inbox.InboxMessage;
import com.salesforce.marketingcloud.p027e.C4029h;
import java.util.Date;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONObject;
import repack.org.bouncycastle.cms.CMSAttributeTableGenerator;

/* renamed from: com.salesforce.marketingcloud.messages.inbox.a */
final class C4092a extends C$AutoValue_InboxMessage {

    /* renamed from: d */
    private static final C4029h.C4031b f3191d = new C4029h.C4031b();

    /* renamed from: e */
    private static final InboxMessage.C4091b f3192e = new InboxMessage.C4091b();

    /* renamed from: f */
    private static final C4029h.C4030a f3193f = new C4029h.C4030a();

    C4092a(String str, String str2, String str3, Map<String, String> map, String str4, String str5, String str6, String str7, InboxMessage.Media media, String str8, Date date, Date date2, int i, int i2, String str9) {
        super(str, str2, str3, map, str4, str5, str6, str7, media, str8, date, date2, i, i2, str9);
    }

    /* renamed from: a */
    static C4092a m3156a(JSONObject jSONObject) {
        JSONObject jSONObject2 = jSONObject;
        Date date = new Date();
        Iterator<String> keys = jSONObject.keys();
        Date date2 = date;
        String str = null;
        String str2 = null;
        String str3 = null;
        Map<String, String> map = null;
        String str4 = null;
        String str5 = null;
        String str6 = null;
        String str7 = null;
        InboxMessage.Media media = null;
        String str8 = null;
        Date date3 = null;
        String str9 = null;
        int i = 0;
        int i2 = 0;
        while (keys.hasNext()) {
            String next = keys.next();
            if (!jSONObject2.isNull(next)) {
                char c = 65535;
                switch (next.hashCode()) {
                    case -1867885268:
                        if (next.equals("subject")) {
                            c = 2;
                            break;
                        }
                        break;
                    case -1349088399:
                        if (next.equals("custom")) {
                            c = 4;
                            break;
                        }
                        break;
                    case -873093151:
                        if (next.equals("messageType")) {
                            c = 12;
                            break;
                        }
                        break;
                    case -389131437:
                        if (next.equals(CMSAttributeTableGenerator.CONTENT_TYPE)) {
                            c = 13;
                            break;
                        }
                        break;
                    case 3355:
                        if (next.equals("id")) {
                            c = 9;
                            break;
                        }
                        break;
                    case 116079:
                        if (next.equals("url")) {
                            c = 14;
                            break;
                        }
                        break;
                    case 3195150:
                        if (next.equals("hash")) {
                            c = 1;
                            break;
                        }
                        break;
                    case 3288564:
                        if (next.equals("keys")) {
                            c = 3;
                            break;
                        }
                        break;
                    case 92899676:
                        if (next.equals("alert")) {
                            c = 6;
                            break;
                        }
                        break;
                    case 103772132:
                        if (next.equals("media")) {
                            c = 8;
                            break;
                        }
                        break;
                    case 109627663:
                        if (next.equals("sound")) {
                            c = 7;
                            break;
                        }
                        break;
                    case 110371416:
                        if (next.equals("title")) {
                            c = 5;
                            break;
                        }
                        break;
                    case 693933066:
                        if (next.equals("requestId")) {
                            c = 0;
                            break;
                        }
                        break;
                    case 1308858452:
                        if (next.equals("startDateUtc")) {
                            c = 10;
                            break;
                        }
                        break;
                    case 1670810043:
                        if (next.equals("endDateUtc")) {
                            c = 11;
                            break;
                        }
                        break;
                }
                switch (c) {
                    case 0:
                        str = jSONObject2.getString(next);
                        break;
                    case 1:
                        str2 = jSONObject2.getString(next);
                        break;
                    case 2:
                        str3 = jSONObject2.getString(next);
                        break;
                    case 3:
                        map = f3191d.mo56247b(jSONObject2, next);
                        break;
                    case 4:
                        str4 = jSONObject2.getString(next);
                        break;
                    case 5:
                        str5 = jSONObject2.getString(next);
                        break;
                    case 6:
                        str6 = jSONObject2.getString(next);
                        break;
                    case 7:
                        str7 = jSONObject2.getString(next);
                        break;
                    case 8:
                        media = f3192e.mo56247b(jSONObject2, next);
                        break;
                    case 9:
                        str8 = jSONObject2.getString(next);
                        break;
                    case 10:
                        date2 = f3193f.mo56247b(jSONObject2, next);
                        break;
                    case 11:
                        date3 = f3193f.mo56247b(jSONObject2, next);
                        break;
                    case 12:
                        i = jSONObject2.getInt(next);
                        break;
                    case 13:
                        i2 = jSONObject2.getInt(next);
                        break;
                    case 14:
                        str9 = jSONObject2.getString(next);
                        break;
                }
            }
        }
        return new C4092a(str, str2, str3, map, str4, str5, str6, str7, media, str8, date2, date3, i, i2, str9);
    }
}

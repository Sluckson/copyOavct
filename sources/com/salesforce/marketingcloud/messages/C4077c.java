package com.salesforce.marketingcloud.messages;

import com.salesforce.marketingcloud.location.LatLon;
import com.salesforce.marketingcloud.messages.Message;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import org.json.JSONObject;

/* renamed from: com.salesforce.marketingcloud.messages.c */
final class C4077c extends C$AutoValue_Region {

    /* renamed from: a */
    private static final LatLon.C4043a f3097a = new LatLon.C4043a();

    /* renamed from: b */
    private static final Message.C4070c f3098b = new Message.C4070c();

    C4077c(String str, LatLon latLon, int i, String str2, int i2, int i3, int i4, String str3, String str4, List<Message> list) {
        super(str, latLon, i, str2, i2, i3, i4, str3, str4, list);
    }

    /* renamed from: a */
    static C4077c m3039a(JSONObject jSONObject) {
        List<Message> emptyList = Collections.emptyList();
        Iterator<String> keys = jSONObject.keys();
        List<Message> list = emptyList;
        String str = null;
        LatLon latLon = null;
        String str2 = null;
        String str3 = null;
        String str4 = null;
        int i = 0;
        int i2 = 0;
        int i3 = 0;
        int i4 = 0;
        while (keys.hasNext()) {
            String next = keys.next();
            if (!jSONObject.isNull(next)) {
                char c = 65535;
                switch (next.hashCode()) {
                    case -1724546052:
                        if (next.equals("description")) {
                            c = 8;
                            break;
                        }
                        break;
                    case -1364013995:
                        if (next.equals("center")) {
                            c = 1;
                            break;
                        }
                        break;
                    case -938578798:
                        if (next.equals("radius")) {
                            c = 2;
                            break;
                        }
                        break;
                    case -462094004:
                        if (next.equals("messages")) {
                            c = 9;
                            break;
                        }
                        break;
                    case -58277745:
                        if (next.equals("locationType")) {
                            c = 6;
                            break;
                        }
                        break;
                    case 3355:
                        if (next.equals("id")) {
                            c = 0;
                            break;
                        }
                        break;
                    case 3373707:
                        if (next.equals("name")) {
                            c = 7;
                            break;
                        }
                        break;
                    case 103658937:
                        if (next.equals("major")) {
                            c = 4;
                            break;
                        }
                        break;
                    case 103901109:
                        if (next.equals("minor")) {
                            c = 5;
                            break;
                        }
                        break;
                    case 1646829786:
                        if (next.equals("proximityUuid")) {
                            c = 3;
                            break;
                        }
                        break;
                }
                switch (c) {
                    case 0:
                        str = jSONObject.getString(next);
                        break;
                    case 1:
                        latLon = f3097a.mo56247b(jSONObject, next);
                        break;
                    case 2:
                        i = jSONObject.getInt(next);
                        break;
                    case 3:
                        str2 = jSONObject.getString(next);
                        break;
                    case 4:
                        i2 = jSONObject.getInt(next);
                        break;
                    case 5:
                        i3 = jSONObject.getInt(next);
                        break;
                    case 6:
                        i4 = jSONObject.getInt(next);
                        break;
                    case 7:
                        str3 = jSONObject.getString(next);
                        break;
                    case 8:
                        str4 = jSONObject.getString(next);
                        break;
                    case 9:
                        list = f3098b.mo56247b(jSONObject, next);
                        break;
                }
            }
        }
        return new C4077c(str, latLon, i, str2, i2, i3, i4, str3, str4, list);
    }
}

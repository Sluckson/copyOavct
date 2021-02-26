package com.salesforce.marketingcloud.messages.push;

import android.content.Context;
import android.content.Intent;
import android.content.pm.ComponentInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import com.google.firebase.FirebaseApp;
import com.iaai.android.old.providers.IaaContent;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

/* renamed from: com.salesforce.marketingcloud.messages.push.b */
final class C4102b {

    /* renamed from: a */
    private static final String f3252a = "com.google.android.c2dm.intent.RECEIVE";

    /* renamed from: b */
    private static final String f3253b = "com.google.firebase.INSTANCE_ID_EVENT";

    /* renamed from: c */
    private static final String f3254c = "com.google.firebase.MESSAGING_EVENT";

    private C4102b() {
    }

    /* renamed from: a */
    private static ComponentInfo m3223a(ResolveInfo resolveInfo) {
        if (resolveInfo.activityInfo != null) {
            return resolveInfo.activityInfo;
        }
        if (resolveInfo.serviceInfo != null) {
            return resolveInfo.serviceInfo;
        }
        return null;
    }

    /* renamed from: a */
    private static JSONArray m3224a(Context context) {
        JSONArray jSONArray = new JSONArray();
        try {
            List<FirebaseApp> apps = FirebaseApp.getApps(context);
            if (!apps.isEmpty()) {
                for (FirebaseApp firebaseApp : apps) {
                    jSONArray.put(firebaseApp.toString());
                }
            }
        } catch (Exception unused) {
        }
        return jSONArray;
    }

    /* renamed from: a */
    private static JSONArray m3225a(String str, List<ResolveInfo> list) {
        JSONArray jSONArray = new JSONArray();
        if (list != null && !list.isEmpty()) {
            for (ResolveInfo next : list) {
                ComponentInfo a = m3223a(next);
                if (a != null && str.equals(a.processName)) {
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("name", a.name);
                    jSONObject.put("priority", next.priority);
                    jSONArray.put(jSONObject);
                }
            }
        }
        return jSONArray;
    }

    /* renamed from: a */
    static JSONObject m3226a(Context context, String str, String str2) {
        PackageManager packageManager = context.getPackageManager();
        String packageName = context.getPackageName();
        JSONObject jSONObject = new JSONObject();
        Object obj = str;
        if (str == null) {
            obj = JSONObject.NULL;
        }
        jSONObject.put(IaaContent.C2dmRegistration.SENDER_ID, obj);
        Object obj2 = str2;
        if (str2 == null) {
            obj2 = JSONObject.NULL;
        }
        jSONObject.put("deviceToken", obj2);
        jSONObject.put("firebaseApps", m3224a(context));
        jSONObject.put("c2dmReceiver", m3225a(packageName, packageManager.queryBroadcastReceivers(new Intent(f3252a), 0)));
        jSONObject.put("instanceIdService", m3225a(packageName, packageManager.queryIntentServices(new Intent(f3253b), 0)));
        jSONObject.put("messagingService", m3225a(packageName, packageManager.queryIntentServices(new Intent(f3254c), 0)));
        return jSONObject;
    }
}

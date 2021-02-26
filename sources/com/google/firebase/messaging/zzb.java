package com.google.firebase.messaging;

import android.annotation.TargetApi;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.drawable.AdaptiveIconDrawable;
import android.os.Build;
import android.os.Bundle;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.Log;
import androidx.core.content.ContextCompat;
import java.util.concurrent.atomic.AtomicInteger;

/* compiled from: com.google.firebase:firebase-messaging@@20.2.1 */
public final class zzb {
    private static final AtomicInteger zza = new AtomicInteger((int) SystemClock.elapsedRealtime());

    /* JADX WARNING: Removed duplicated region for block: B:54:0x01c5  */
    /* JADX WARNING: Removed duplicated region for block: B:58:0x01d6  */
    /* JADX WARNING: Removed duplicated region for block: B:64:0x020f  */
    /* JADX WARNING: Removed duplicated region for block: B:67:0x021f  */
    /* JADX WARNING: Removed duplicated region for block: B:72:0x0250  */
    /* JADX WARNING: Removed duplicated region for block: B:75:0x025f  */
    /* JADX WARNING: Removed duplicated region for block: B:78:0x026f  */
    /* JADX WARNING: Removed duplicated region for block: B:81:0x0279  */
    /* JADX WARNING: Removed duplicated region for block: B:84:0x028b  */
    /* JADX WARNING: Removed duplicated region for block: B:87:0x0294  */
    /* JADX WARNING: Removed duplicated region for block: B:90:0x029e  */
    /* JADX WARNING: Removed duplicated region for block: B:93:0x02b2  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    static com.google.firebase.messaging.zza zza(android.content.Context r9, com.google.firebase.messaging.zzt r10) {
        /*
            android.content.pm.PackageManager r0 = r9.getPackageManager()
            java.lang.String r1 = r9.getPackageName()
            android.os.Bundle r0 = zza((android.content.pm.PackageManager) r0, (java.lang.String) r1)
            java.lang.String r1 = r9.getPackageName()
            java.lang.String r2 = "gcm.n.android_channel_id"
            java.lang.String r2 = r10.zza((java.lang.String) r2)
            java.lang.String r2 = zzb(r9, r2, r0)
            android.content.res.Resources r3 = r9.getResources()
            android.content.pm.PackageManager r4 = r9.getPackageManager()
            androidx.core.app.NotificationCompat$Builder r5 = new androidx.core.app.NotificationCompat$Builder
            r5.<init>(r9, r2)
            java.lang.String r2 = "gcm.n.title"
            java.lang.String r2 = r10.zza(r3, r1, r2)
            boolean r6 = android.text.TextUtils.isEmpty(r2)
            if (r6 != 0) goto L_0x0036
            r5.setContentTitle(r2)
        L_0x0036:
            java.lang.String r2 = "gcm.n.body"
            java.lang.String r2 = r10.zza(r3, r1, r2)
            boolean r6 = android.text.TextUtils.isEmpty(r2)
            if (r6 != 0) goto L_0x0051
            r5.setContentText(r2)
            androidx.core.app.NotificationCompat$BigTextStyle r6 = new androidx.core.app.NotificationCompat$BigTextStyle
            r6.<init>()
            androidx.core.app.NotificationCompat$BigTextStyle r2 = r6.bigText(r2)
            r5.setStyle(r2)
        L_0x0051:
            java.lang.String r2 = "gcm.n.icon"
            java.lang.String r2 = r10.zza((java.lang.String) r2)
            int r2 = zza(r4, r3, r1, r2, r0)
            r5.setSmallIcon(r2)
            java.lang.String r2 = r10.zzb()
            boolean r6 = android.text.TextUtils.isEmpty(r2)
            r7 = 2
            r8 = 0
            if (r6 == 0) goto L_0x006c
            r2 = r8
            goto L_0x00b1
        L_0x006c:
            java.lang.String r6 = "default"
            boolean r6 = r6.equals(r2)
            if (r6 != 0) goto L_0x00ad
            java.lang.String r6 = "raw"
            int r3 = r3.getIdentifier(r2, r6, r1)
            if (r3 == 0) goto L_0x00ad
            java.lang.String r3 = java.lang.String.valueOf(r1)
            int r3 = r3.length()
            int r3 = r3 + 24
            java.lang.String r6 = java.lang.String.valueOf(r2)
            int r6 = r6.length()
            int r3 = r3 + r6
            java.lang.StringBuilder r6 = new java.lang.StringBuilder
            r6.<init>(r3)
            java.lang.String r3 = "android.resource://"
            r6.append(r3)
            r6.append(r1)
            java.lang.String r3 = "/raw/"
            r6.append(r3)
            r6.append(r2)
            java.lang.String r2 = r6.toString()
            android.net.Uri r2 = android.net.Uri.parse(r2)
            goto L_0x00b1
        L_0x00ad:
            android.net.Uri r2 = android.media.RingtoneManager.getDefaultUri(r7)
        L_0x00b1:
            if (r2 == 0) goto L_0x00b6
            r5.setSound(r2)
        L_0x00b6:
            java.lang.String r2 = "gcm.n.click_action"
            java.lang.String r2 = r10.zza((java.lang.String) r2)
            boolean r3 = android.text.TextUtils.isEmpty(r2)
            java.lang.String r6 = "FirebaseMessaging"
            if (r3 != 0) goto L_0x00d2
            android.content.Intent r3 = new android.content.Intent
            r3.<init>(r2)
            r3.setPackage(r1)
            r1 = 268435456(0x10000000, float:2.5243549E-29)
            r3.setFlags(r1)
            goto L_0x00f2
        L_0x00d2:
            android.net.Uri r2 = r10.zza()
            if (r2 == 0) goto L_0x00e6
            android.content.Intent r3 = new android.content.Intent
            java.lang.String r4 = "android.intent.action.VIEW"
            r3.<init>(r4)
            r3.setPackage(r1)
            r3.setData(r2)
            goto L_0x00f2
        L_0x00e6:
            android.content.Intent r1 = r4.getLaunchIntentForPackage(r1)
            if (r1 != 0) goto L_0x00f1
            java.lang.String r2 = "No activity found to launch app"
            android.util.Log.w(r6, r2)
        L_0x00f1:
            r3 = r1
        L_0x00f2:
            java.lang.String r1 = "google.c.a.e"
            if (r3 != 0) goto L_0x00f8
            r2 = r8
            goto L_0x012f
        L_0x00f8:
            r2 = 67108864(0x4000000, float:1.5046328E-36)
            r3.addFlags(r2)
            android.os.Bundle r2 = r10.zze()
            r3.putExtras(r2)
            java.util.concurrent.atomic.AtomicInteger r2 = zza
            int r2 = r2.incrementAndGet()
            r4 = 1073741824(0x40000000, float:2.0)
            android.app.PendingIntent r2 = android.app.PendingIntent.getActivity(r9, r2, r3, r4)
            boolean r3 = r10.zzb(r1)
            if (r3 == 0) goto L_0x012f
            android.content.Intent r3 = new android.content.Intent
            java.lang.String r4 = "com.google.firebase.messaging.NOTIFICATION_OPEN"
            r3.<init>(r4)
            android.os.Bundle r4 = r10.zzf()
            android.content.Intent r3 = r3.putExtras(r4)
            java.lang.String r4 = "pending_intent"
            android.content.Intent r2 = r3.putExtra(r4, r2)
            android.app.PendingIntent r2 = zza((android.content.Context) r9, (android.content.Intent) r2)
        L_0x012f:
            r5.setContentIntent(r2)
            boolean r1 = r10.zzb(r1)
            if (r1 != 0) goto L_0x013a
            r1 = r8
            goto L_0x014d
        L_0x013a:
            android.content.Intent r1 = new android.content.Intent
            java.lang.String r2 = "com.google.firebase.messaging.NOTIFICATION_DISMISS"
            r1.<init>(r2)
            android.os.Bundle r2 = r10.zzf()
            android.content.Intent r1 = r1.putExtras(r2)
            android.app.PendingIntent r1 = zza((android.content.Context) r9, (android.content.Intent) r1)
        L_0x014d:
            if (r1 == 0) goto L_0x0152
            r5.setDeleteIntent(r1)
        L_0x0152:
            java.lang.String r1 = "gcm.n.color"
            java.lang.String r1 = r10.zza((java.lang.String) r1)
            java.lang.Integer r9 = zza(r9, r1, r0)
            if (r9 == 0) goto L_0x0165
            int r9 = r9.intValue()
            r5.setColor(r9)
        L_0x0165:
            java.lang.String r9 = "gcm.n.sticky"
            boolean r9 = r10.zzb(r9)
            r0 = 1
            r9 = r9 ^ r0
            r5.setAutoCancel(r9)
            java.lang.String r9 = "gcm.n.local_only"
            boolean r9 = r10.zzb(r9)
            r5.setLocalOnly(r9)
            java.lang.String r9 = "gcm.n.ticker"
            java.lang.String r9 = r10.zza((java.lang.String) r9)
            if (r9 == 0) goto L_0x0184
            r5.setTicker(r9)
        L_0x0184:
            java.lang.String r9 = "gcm.n.notification_priority"
            java.lang.Integer r9 = r10.zzc(r9)
            if (r9 != 0) goto L_0x018e
        L_0x018c:
            r9 = r8
            goto L_0x01c3
        L_0x018e:
            int r1 = r9.intValue()
            r2 = -2
            if (r1 < r2) goto L_0x019b
            int r1 = r9.intValue()
            if (r1 <= r7) goto L_0x01c3
        L_0x019b:
            java.lang.String r9 = java.lang.String.valueOf(r9)
            java.lang.String r1 = java.lang.String.valueOf(r9)
            int r1 = r1.length()
            int r1 = r1 + 72
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>(r1)
            java.lang.String r1 = "notificationPriority is invalid "
            r2.append(r1)
            r2.append(r9)
            java.lang.String r9 = ". Skipping setting notificationPriority."
            r2.append(r9)
            java.lang.String r9 = r2.toString()
            android.util.Log.w(r6, r9)
            goto L_0x018c
        L_0x01c3:
            if (r9 == 0) goto L_0x01cc
            int r9 = r9.intValue()
            r5.setPriority(r9)
        L_0x01cc:
            java.lang.String r9 = "gcm.n.visibility"
            java.lang.Integer r9 = r10.zzc(r9)
            if (r9 != 0) goto L_0x01d6
        L_0x01d4:
            r9 = r8
            goto L_0x020d
        L_0x01d6:
            int r1 = r9.intValue()
            r2 = -1
            if (r1 < r2) goto L_0x01e3
            int r1 = r9.intValue()
            if (r1 <= r0) goto L_0x020d
        L_0x01e3:
            java.lang.String r9 = java.lang.String.valueOf(r9)
            java.lang.String r1 = java.lang.String.valueOf(r9)
            int r1 = r1.length()
            int r1 = r1 + 53
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>(r1)
            java.lang.String r1 = "visibility is invalid: "
            r2.append(r1)
            r2.append(r9)
            java.lang.String r9 = ". Skipping setting visibility."
            r2.append(r9)
            java.lang.String r9 = r2.toString()
            java.lang.String r1 = "NotificationParams"
            android.util.Log.w(r1, r9)
            goto L_0x01d4
        L_0x020d:
            if (r9 == 0) goto L_0x0216
            int r9 = r9.intValue()
            r5.setVisibility(r9)
        L_0x0216:
            java.lang.String r9 = "gcm.n.notification_count"
            java.lang.Integer r9 = r10.zzc(r9)
            if (r9 != 0) goto L_0x021f
            goto L_0x024e
        L_0x021f:
            int r1 = r9.intValue()
            if (r1 >= 0) goto L_0x024d
            java.lang.String r9 = java.lang.String.valueOf(r9)
            java.lang.String r1 = java.lang.String.valueOf(r9)
            int r1 = r1.length()
            int r1 = r1 + 67
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>(r1)
            java.lang.String r1 = "notificationCount is invalid: "
            r2.append(r1)
            r2.append(r9)
            java.lang.String r9 = ". Skipping setting notificationCount."
            r2.append(r9)
            java.lang.String r9 = r2.toString()
            android.util.Log.w(r6, r9)
            goto L_0x024e
        L_0x024d:
            r8 = r9
        L_0x024e:
            if (r8 == 0) goto L_0x0257
            int r9 = r8.intValue()
            r5.setNumber(r9)
        L_0x0257:
            java.lang.String r9 = "gcm.n.event_time"
            java.lang.Long r9 = r10.zzd(r9)
            if (r9 == 0) goto L_0x0269
            r5.setShowWhen(r0)
            long r1 = r9.longValue()
            r5.setWhen(r1)
        L_0x0269:
            long[] r9 = r10.zzc()
            if (r9 == 0) goto L_0x0272
            r5.setVibrate(r9)
        L_0x0272:
            int[] r9 = r10.zzd()
            r1 = 0
            if (r9 == 0) goto L_0x0282
            r2 = r9[r1]
            r3 = r9[r0]
            r9 = r9[r7]
            r5.setLights(r2, r3, r9)
        L_0x0282:
            java.lang.String r9 = "gcm.n.default_sound"
            boolean r9 = r10.zzb(r9)
            if (r9 == 0) goto L_0x028b
            goto L_0x028c
        L_0x028b:
            r0 = 0
        L_0x028c:
            java.lang.String r9 = "gcm.n.default_vibrate_timings"
            boolean r9 = r10.zzb(r9)
            if (r9 == 0) goto L_0x0296
            r0 = r0 | 2
        L_0x0296:
            java.lang.String r9 = "gcm.n.default_light_settings"
            boolean r9 = r10.zzb(r9)
            if (r9 == 0) goto L_0x02a0
            r0 = r0 | 4
        L_0x02a0:
            r5.setDefaults(r0)
            com.google.firebase.messaging.zza r9 = new com.google.firebase.messaging.zza
            java.lang.String r0 = "gcm.n.tag"
            java.lang.String r10 = r10.zza((java.lang.String) r0)
            boolean r0 = android.text.TextUtils.isEmpty(r10)
            if (r0 != 0) goto L_0x02b2
            goto L_0x02c9
        L_0x02b2:
            long r2 = android.os.SystemClock.uptimeMillis()
            r10 = 37
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>(r10)
            java.lang.String r10 = "FCM-Notification:"
            r0.append(r10)
            r0.append(r2)
            java.lang.String r10 = r0.toString()
        L_0x02c9:
            r9.<init>(r5, r10, r1)
            return r9
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.firebase.messaging.zzb.zza(android.content.Context, com.google.firebase.messaging.zzt):com.google.firebase.messaging.zza");
    }

    @TargetApi(26)
    private static boolean zza(Resources resources, int i) {
        if (Build.VERSION.SDK_INT != 26) {
            return true;
        }
        try {
            if (!(resources.getDrawable(i, (Resources.Theme) null) instanceof AdaptiveIconDrawable)) {
                return true;
            }
            StringBuilder sb = new StringBuilder(77);
            sb.append("Adaptive icons cannot be used in notifications. Ignoring icon id: ");
            sb.append(i);
            Log.e("FirebaseMessaging", sb.toString());
            return false;
        } catch (Resources.NotFoundException unused) {
            StringBuilder sb2 = new StringBuilder(66);
            sb2.append("Couldn't find resource ");
            sb2.append(i);
            sb2.append(", treating it as an invalid icon");
            Log.e("FirebaseMessaging", sb2.toString());
            return false;
        }
    }

    private static int zza(PackageManager packageManager, Resources resources, String str, String str2, Bundle bundle) {
        if (!TextUtils.isEmpty(str2)) {
            int identifier = resources.getIdentifier(str2, "drawable", str);
            if (identifier != 0 && zza(resources, identifier)) {
                return identifier;
            }
            int identifier2 = resources.getIdentifier(str2, "mipmap", str);
            if (identifier2 != 0 && zza(resources, identifier2)) {
                return identifier2;
            }
            StringBuilder sb = new StringBuilder(String.valueOf(str2).length() + 61);
            sb.append("Icon resource ");
            sb.append(str2);
            sb.append(" not found. Notification will use default icon.");
            Log.w("FirebaseMessaging", sb.toString());
        }
        int i = bundle.getInt("com.google.firebase.messaging.default_notification_icon", 0);
        if (i == 0 || !zza(resources, i)) {
            try {
                i = packageManager.getApplicationInfo(str, 0).icon;
            } catch (PackageManager.NameNotFoundException e) {
                String valueOf = String.valueOf(e);
                StringBuilder sb2 = new StringBuilder(String.valueOf(valueOf).length() + 35);
                sb2.append("Couldn't get own application info: ");
                sb2.append(valueOf);
                Log.w("FirebaseMessaging", sb2.toString());
            }
        }
        if (i == 0 || !zza(resources, i)) {
            return 17301651;
        }
        return i;
    }

    private static Integer zza(Context context, String str, Bundle bundle) {
        if (Build.VERSION.SDK_INT < 21) {
            return null;
        }
        if (!TextUtils.isEmpty(str)) {
            try {
                return Integer.valueOf(Color.parseColor(str));
            } catch (IllegalArgumentException unused) {
                StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 56);
                sb.append("Color is invalid: ");
                sb.append(str);
                sb.append(". Notification will use default color.");
                Log.w("FirebaseMessaging", sb.toString());
            }
        }
        int i = bundle.getInt("com.google.firebase.messaging.default_notification_color", 0);
        if (i != 0) {
            try {
                return Integer.valueOf(ContextCompat.getColor(context, i));
            } catch (Resources.NotFoundException unused2) {
                Log.w("FirebaseMessaging", "Cannot find the color resource referenced in AndroidManifest.");
            }
        }
        return null;
    }

    private static Bundle zza(PackageManager packageManager, String str) {
        try {
            ApplicationInfo applicationInfo = packageManager.getApplicationInfo(str, 128);
            if (!(applicationInfo == null || applicationInfo.metaData == null)) {
                return applicationInfo.metaData;
            }
        } catch (PackageManager.NameNotFoundException e) {
            String valueOf = String.valueOf(e);
            StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 35);
            sb.append("Couldn't get own application info: ");
            sb.append(valueOf);
            Log.w("FirebaseMessaging", sb.toString());
        }
        return Bundle.EMPTY;
    }

    @TargetApi(26)
    private static String zzb(Context context, String str, Bundle bundle) {
        if (Build.VERSION.SDK_INT < 26) {
            return null;
        }
        try {
            if (context.getPackageManager().getApplicationInfo(context.getPackageName(), 0).targetSdkVersion < 26) {
                return null;
            }
            NotificationManager notificationManager = (NotificationManager) context.getSystemService(NotificationManager.class);
            if (!TextUtils.isEmpty(str)) {
                if (notificationManager.getNotificationChannel(str) != null) {
                    return str;
                }
                StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 122);
                sb.append("Notification Channel requested (");
                sb.append(str);
                sb.append(") has not been created by the app. Manifest configuration, or default, value will be used.");
                Log.w("FirebaseMessaging", sb.toString());
            }
            String string = bundle.getString("com.google.firebase.messaging.default_notification_channel_id");
            if (TextUtils.isEmpty(string)) {
                Log.w("FirebaseMessaging", "Missing Default Notification Channel metadata in AndroidManifest. Default value will be used.");
            } else if (notificationManager.getNotificationChannel(string) != null) {
                return string;
            } else {
                Log.w("FirebaseMessaging", "Notification Channel set in AndroidManifest.xml has not been created by the app. Default value will be used.");
            }
            if (notificationManager.getNotificationChannel("fcm_fallback_notification_channel") == null) {
                notificationManager.createNotificationChannel(new NotificationChannel("fcm_fallback_notification_channel", context.getString(context.getResources().getIdentifier("fcm_fallback_notification_channel_label", "string", context.getPackageName())), 3));
            }
            return "fcm_fallback_notification_channel";
        } catch (PackageManager.NameNotFoundException unused) {
            return null;
        }
    }

    private static PendingIntent zza(Context context, Intent intent) {
        return PendingIntent.getBroadcast(context, zza.incrementAndGet(), new Intent("com.google.firebase.MESSAGING_EVENT").setComponent(new ComponentName(context, "com.google.firebase.iid.FirebaseInstanceIdReceiver")).putExtra("wrapped_intent", intent), 1073741824);
    }
}

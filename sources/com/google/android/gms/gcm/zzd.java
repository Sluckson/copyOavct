package com.google.android.gms.gcm;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.Log;
import java.util.MissingFormatArgumentException;
import java.util.concurrent.atomic.AtomicInteger;
import org.json.JSONArray;
import org.json.JSONException;

final class zzd {
    static zzd zzk;
    private final Context zzl;
    private String zzm;
    private final AtomicInteger zzn = new AtomicInteger((int) SystemClock.elapsedRealtime());

    static synchronized zzd zzd(Context context) {
        zzd zzd;
        synchronized (zzd.class) {
            if (zzk == null) {
                zzk = new zzd(context);
            }
            zzd = zzk;
        }
        return zzd;
    }

    static String zzd(Bundle bundle, String str) {
        String string = bundle.getString(str);
        return string == null ? bundle.getString(str.replace("gcm.n.", "gcm.notification.")) : string;
    }

    private zzd(Context context) {
        this.zzl = context.getApplicationContext();
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Removed duplicated region for block: B:16:0x009c  */
    /* JADX WARNING: Removed duplicated region for block: B:17:0x009e  */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x0102  */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x0116  */
    /* JADX WARNING: Removed duplicated region for block: B:32:0x0148  */
    /* JADX WARNING: Removed duplicated region for block: B:44:0x019b  */
    /* JADX WARNING: Removed duplicated region for block: B:50:0x01cb  */
    /* JADX WARNING: Removed duplicated region for block: B:63:0x0227  */
    /* JADX WARNING: Removed duplicated region for block: B:66:0x0230  */
    /* JADX WARNING: Removed duplicated region for block: B:69:0x0245  */
    /* JADX WARNING: Removed duplicated region for block: B:71:0x024e  */
    /* JADX WARNING: Removed duplicated region for block: B:73:0x0253  */
    /* JADX WARNING: Removed duplicated region for block: B:75:0x0258  */
    /* JADX WARNING: Removed duplicated region for block: B:78:0x026b  */
    /* JADX WARNING: Removed duplicated region for block: B:81:0x0280  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean zze(android.os.Bundle r14) {
        /*
            r13 = this;
            java.lang.String r0 = "gcm.n.title"
            java.lang.String r0 = r13.zze(r14, r0)
            boolean r1 = android.text.TextUtils.isEmpty(r0)
            if (r1 == 0) goto L_0x001c
            android.content.Context r0 = r13.zzl
            android.content.pm.ApplicationInfo r0 = r0.getApplicationInfo()
            android.content.Context r1 = r13.zzl
            android.content.pm.PackageManager r1 = r1.getPackageManager()
            java.lang.CharSequence r0 = r0.loadLabel(r1)
        L_0x001c:
            java.lang.String r1 = "gcm.n.body"
            java.lang.String r1 = r13.zze(r14, r1)
            java.lang.String r2 = "gcm.n.icon"
            java.lang.String r2 = zzd(r14, r2)
            boolean r3 = android.text.TextUtils.isEmpty(r2)
            java.lang.String r4 = "GcmNotification"
            if (r3 != 0) goto L_0x0077
            android.content.Context r3 = r13.zzl
            android.content.res.Resources r3 = r3.getResources()
            android.content.Context r5 = r13.zzl
            java.lang.String r5 = r5.getPackageName()
            java.lang.String r6 = "drawable"
            int r5 = r3.getIdentifier(r2, r6, r5)
            if (r5 == 0) goto L_0x0045
            goto L_0x0089
        L_0x0045:
            android.content.Context r5 = r13.zzl
            java.lang.String r5 = r5.getPackageName()
            java.lang.String r6 = "mipmap"
            int r5 = r3.getIdentifier(r2, r6, r5)
            if (r5 == 0) goto L_0x0054
            goto L_0x0089
        L_0x0054:
            java.lang.String r3 = java.lang.String.valueOf(r2)
            int r3 = r3.length()
            int r3 = r3 + 57
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            r5.<init>(r3)
            java.lang.String r3 = "Icon resource "
            r5.append(r3)
            r5.append(r2)
            java.lang.String r2 = " not found. Notification will use app icon."
            r5.append(r2)
            java.lang.String r2 = r5.toString()
            android.util.Log.w(r4, r2)
        L_0x0077:
            android.content.Context r2 = r13.zzl
            android.content.pm.ApplicationInfo r2 = r2.getApplicationInfo()
            int r2 = r2.icon
            if (r2 != 0) goto L_0x0088
            r2 = 17301651(0x1080093, float:2.4979667E-38)
            r5 = 17301651(0x1080093, float:2.4979667E-38)
            goto L_0x0089
        L_0x0088:
            r5 = r2
        L_0x0089:
            java.lang.String r2 = "gcm.n.color"
            java.lang.String r2 = zzd(r14, r2)
            java.lang.String r3 = "gcm.n.sound2"
            java.lang.String r3 = zzd(r14, r3)
            boolean r6 = android.text.TextUtils.isEmpty(r3)
            r7 = 0
            if (r6 == 0) goto L_0x009e
            r3 = r7
            goto L_0x00f6
        L_0x009e:
            java.lang.String r6 = "default"
            boolean r6 = r6.equals(r3)
            if (r6 != 0) goto L_0x00f1
            android.content.Context r6 = r13.zzl
            android.content.res.Resources r6 = r6.getResources()
            android.content.Context r8 = r13.zzl
            java.lang.String r8 = r8.getPackageName()
            java.lang.String r9 = "raw"
            int r6 = r6.getIdentifier(r3, r9, r8)
            if (r6 == 0) goto L_0x00f1
            android.content.Context r6 = r13.zzl
            java.lang.String r6 = r6.getPackageName()
            java.lang.String r8 = java.lang.String.valueOf(r6)
            int r8 = r8.length()
            int r8 = r8 + 24
            java.lang.String r9 = java.lang.String.valueOf(r3)
            int r9 = r9.length()
            int r8 = r8 + r9
            java.lang.StringBuilder r9 = new java.lang.StringBuilder
            r9.<init>(r8)
            java.lang.String r8 = "android.resource://"
            r9.append(r8)
            r9.append(r6)
            java.lang.String r6 = "/raw/"
            r9.append(r6)
            r9.append(r3)
            java.lang.String r3 = r9.toString()
            android.net.Uri r3 = android.net.Uri.parse(r3)
            goto L_0x00f6
        L_0x00f1:
            r3 = 2
            android.net.Uri r3 = android.media.RingtoneManager.getDefaultUri(r3)
        L_0x00f6:
            java.lang.String r6 = "gcm.n.click_action"
            java.lang.String r6 = zzd(r14, r6)
            boolean r8 = android.text.TextUtils.isEmpty(r6)
            if (r8 != 0) goto L_0x0116
            android.content.Intent r8 = new android.content.Intent
            r8.<init>(r6)
            android.content.Context r6 = r13.zzl
            java.lang.String r6 = r6.getPackageName()
            r8.setPackage(r6)
            r6 = 268435456(0x10000000, float:2.5243549E-29)
            r8.setFlags(r6)
            goto L_0x012f
        L_0x0116:
            android.content.Context r6 = r13.zzl
            android.content.pm.PackageManager r6 = r6.getPackageManager()
            android.content.Context r8 = r13.zzl
            java.lang.String r8 = r8.getPackageName()
            android.content.Intent r8 = r6.getLaunchIntentForPackage(r8)
            if (r8 != 0) goto L_0x012f
            java.lang.String r6 = "No activity found to launch app"
            android.util.Log.w(r4, r6)
            r6 = r7
            goto L_0x0170
        L_0x012f:
            android.os.Bundle r6 = new android.os.Bundle
            r6.<init>(r14)
            com.google.android.gms.gcm.GcmListenerService.zzd(r6)
            r8.putExtras(r6)
            java.util.Set r6 = r6.keySet()
            java.util.Iterator r6 = r6.iterator()
        L_0x0142:
            boolean r9 = r6.hasNext()
            if (r9 == 0) goto L_0x0162
            java.lang.Object r9 = r6.next()
            java.lang.String r9 = (java.lang.String) r9
            java.lang.String r10 = "gcm.n."
            boolean r10 = r9.startsWith(r10)
            if (r10 != 0) goto L_0x015e
            java.lang.String r10 = "gcm.notification."
            boolean r10 = r9.startsWith(r10)
            if (r10 == 0) goto L_0x0142
        L_0x015e:
            r8.removeExtra(r9)
            goto L_0x0142
        L_0x0162:
            android.content.Context r6 = r13.zzl
            java.util.concurrent.atomic.AtomicInteger r9 = r13.zzn
            int r9 = r9.getAndIncrement()
            r10 = 1073741824(0x40000000, float:2.0)
            android.app.PendingIntent r6 = android.app.PendingIntent.getActivity(r6, r9, r8, r10)
        L_0x0170:
            java.lang.String r8 = "gcm.n.android_channel_id"
            java.lang.String r8 = zzd(r14, r8)
            boolean r9 = com.google.android.gms.common.util.PlatformVersion.isAtLeastO()
            r10 = 3
            if (r9 == 0) goto L_0x0211
            android.content.Context r9 = r13.zzl
            android.content.pm.ApplicationInfo r9 = r9.getApplicationInfo()
            int r9 = r9.targetSdkVersion
            r11 = 26
            if (r9 >= r11) goto L_0x018b
            goto L_0x0211
        L_0x018b:
            android.content.Context r7 = r13.zzl
            java.lang.Class<android.app.NotificationManager> r9 = android.app.NotificationManager.class
            java.lang.Object r7 = r7.getSystemService(r9)
            android.app.NotificationManager r7 = (android.app.NotificationManager) r7
            boolean r9 = android.text.TextUtils.isEmpty(r8)
            if (r9 != 0) goto L_0x01c5
            android.app.NotificationChannel r9 = r7.getNotificationChannel(r8)
            if (r9 == 0) goto L_0x01a2
            goto L_0x01c9
        L_0x01a2:
            java.lang.String r9 = java.lang.String.valueOf(r8)
            int r9 = r9.length()
            int r9 = r9 + 122
            java.lang.StringBuilder r11 = new java.lang.StringBuilder
            r11.<init>(r9)
            java.lang.String r9 = "Notification Channel requested ("
            r11.append(r9)
            r11.append(r8)
            java.lang.String r8 = ") has not been created by the app. Manifest configuration, or default, value will be used."
            r11.append(r8)
            java.lang.String r8 = r11.toString()
            android.util.Log.w(r4, r8)
        L_0x01c5:
            java.lang.String r8 = r13.zzm
            if (r8 == 0) goto L_0x01cb
        L_0x01c9:
            r7 = r8
            goto L_0x0211
        L_0x01cb:
            android.os.Bundle r8 = r13.zzf()
            java.lang.String r9 = "com.google.android.gms.gcm.default_notification_channel_id"
            java.lang.String r8 = r8.getString(r9)
            r13.zzm = r8
            java.lang.String r8 = r13.zzm
            boolean r8 = android.text.TextUtils.isEmpty(r8)
            if (r8 != 0) goto L_0x01f0
            java.lang.String r8 = r13.zzm
            android.app.NotificationChannel r8 = r7.getNotificationChannel(r8)
            if (r8 == 0) goto L_0x01ea
            java.lang.String r7 = r13.zzm
            goto L_0x0211
        L_0x01ea:
            java.lang.String r8 = "Notification Channel set in AndroidManifest.xml has not been created by the app. Default value will be used."
            android.util.Log.w(r4, r8)
            goto L_0x01f5
        L_0x01f0:
            java.lang.String r8 = "Missing Default Notification Channel metadata in AndroidManifest. Default value will be used."
            android.util.Log.w(r4, r8)
        L_0x01f5:
            java.lang.String r8 = "fcm_fallback_notification_channel"
            android.app.NotificationChannel r9 = r7.getNotificationChannel(r8)
            if (r9 != 0) goto L_0x020d
            android.app.NotificationChannel r9 = new android.app.NotificationChannel
            android.content.Context r11 = r13.zzl
            int r12 = com.google.android.gms.gcm.C1294R.string.gcm_fallback_notification_channel_label
            java.lang.String r11 = r11.getString(r12)
            r9.<init>(r8, r11, r10)
            r7.createNotificationChannel(r9)
        L_0x020d:
            r13.zzm = r8
            java.lang.String r7 = r13.zzm
        L_0x0211:
            androidx.core.app.NotificationCompat$Builder r8 = new androidx.core.app.NotificationCompat$Builder
            android.content.Context r9 = r13.zzl
            r8.<init>(r9)
            r9 = 1
            androidx.core.app.NotificationCompat$Builder r8 = r8.setAutoCancel(r9)
            androidx.core.app.NotificationCompat$Builder r5 = r8.setSmallIcon(r5)
            boolean r8 = android.text.TextUtils.isEmpty(r0)
            if (r8 != 0) goto L_0x022a
            r5.setContentTitle(r0)
        L_0x022a:
            boolean r0 = android.text.TextUtils.isEmpty(r1)
            if (r0 != 0) goto L_0x023f
            r5.setContentText(r1)
            androidx.core.app.NotificationCompat$BigTextStyle r0 = new androidx.core.app.NotificationCompat$BigTextStyle
            r0.<init>()
            androidx.core.app.NotificationCompat$BigTextStyle r0 = r0.bigText(r1)
            r5.setStyle(r0)
        L_0x023f:
            boolean r0 = android.text.TextUtils.isEmpty(r2)
            if (r0 != 0) goto L_0x024c
            int r0 = android.graphics.Color.parseColor(r2)
            r5.setColor(r0)
        L_0x024c:
            if (r3 == 0) goto L_0x0251
            r5.setSound(r3)
        L_0x0251:
            if (r6 == 0) goto L_0x0256
            r5.setContentIntent(r6)
        L_0x0256:
            if (r7 == 0) goto L_0x025b
            r5.setChannelId(r7)
        L_0x025b:
            android.app.Notification r0 = r5.build()
            java.lang.String r1 = "gcm.n.tag"
            java.lang.String r14 = zzd(r14, r1)
            boolean r1 = android.util.Log.isLoggable(r4, r10)
            if (r1 == 0) goto L_0x0270
            java.lang.String r1 = "Showing notification"
            android.util.Log.d(r4, r1)
        L_0x0270:
            android.content.Context r1 = r13.zzl
            java.lang.String r2 = "notification"
            java.lang.Object r1 = r1.getSystemService(r2)
            android.app.NotificationManager r1 = (android.app.NotificationManager) r1
            boolean r2 = android.text.TextUtils.isEmpty(r14)
            if (r2 == 0) goto L_0x0297
            long r2 = android.os.SystemClock.uptimeMillis()
            r14 = 37
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>(r14)
            java.lang.String r14 = "GCM-Notification:"
            r4.append(r14)
            r4.append(r2)
            java.lang.String r14 = r4.toString()
        L_0x0297:
            r2 = 0
            r1.notify(r14, r2, r0)
            return r9
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.gcm.zzd.zze(android.os.Bundle):boolean");
    }

    private final String zze(Bundle bundle, String str) {
        String zzd = zzd(bundle, str);
        if (!TextUtils.isEmpty(zzd)) {
            return zzd;
        }
        String valueOf = String.valueOf(str);
        String zzd2 = zzd(bundle, "_loc_key".length() != 0 ? valueOf.concat("_loc_key") : new String(valueOf));
        if (TextUtils.isEmpty(zzd2)) {
            return null;
        }
        Resources resources = this.zzl.getResources();
        int identifier = resources.getIdentifier(zzd2, "string", this.zzl.getPackageName());
        if (identifier == 0) {
            String valueOf2 = String.valueOf(str);
            String substring = ("_loc_key".length() != 0 ? valueOf2.concat("_loc_key") : new String(valueOf2)).substring(6);
            StringBuilder sb = new StringBuilder(String.valueOf(substring).length() + 49 + String.valueOf(zzd2).length());
            sb.append(substring);
            sb.append(" resource not found: ");
            sb.append(zzd2);
            sb.append(" Default value will be used.");
            Log.w("GcmNotification", sb.toString());
            return null;
        }
        String valueOf3 = String.valueOf(str);
        String zzd3 = zzd(bundle, "_loc_args".length() != 0 ? valueOf3.concat("_loc_args") : new String(valueOf3));
        if (TextUtils.isEmpty(zzd3)) {
            return resources.getString(identifier);
        }
        try {
            JSONArray jSONArray = new JSONArray(zzd3);
            Object[] objArr = new String[jSONArray.length()];
            for (int i = 0; i < objArr.length; i++) {
                objArr[i] = jSONArray.opt(i);
            }
            return resources.getString(identifier, objArr);
        } catch (JSONException unused) {
            String valueOf4 = String.valueOf(str);
            String substring2 = ("_loc_args".length() != 0 ? valueOf4.concat("_loc_args") : new String(valueOf4)).substring(6);
            StringBuilder sb2 = new StringBuilder(String.valueOf(substring2).length() + 41 + String.valueOf(zzd3).length());
            sb2.append("Malformed ");
            sb2.append(substring2);
            sb2.append(": ");
            sb2.append(zzd3);
            sb2.append("  Default value will be used.");
            Log.w("GcmNotification", sb2.toString());
            return null;
        } catch (MissingFormatArgumentException e) {
            StringBuilder sb3 = new StringBuilder(String.valueOf(zzd2).length() + 58 + String.valueOf(zzd3).length());
            sb3.append("Missing format argument for ");
            sb3.append(zzd2);
            sb3.append(": ");
            sb3.append(zzd3);
            sb3.append(" Default value will be used.");
            Log.w("GcmNotification", sb3.toString(), e);
            return null;
        }
    }

    private final Bundle zzf() {
        ApplicationInfo applicationInfo;
        try {
            applicationInfo = this.zzl.getPackageManager().getApplicationInfo(this.zzl.getPackageName(), 128);
        } catch (PackageManager.NameNotFoundException unused) {
            applicationInfo = null;
        }
        if (applicationInfo == null || applicationInfo.metaData == null) {
            return Bundle.EMPTY;
        }
        return applicationInfo.metaData;
    }
}

package com.salesforce.marketingcloud.notifications;

import android.app.NotificationChannel;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import androidx.annotation.DrawableRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.firebase.perf.network.FirebasePerfUrlConnection;
import com.salesforce.marketingcloud.C3839R;
import com.salesforce.marketingcloud.C4039h;
import com.salesforce.marketingcloud.notifications.NotificationManager;
import com.salesforce.marketingcloud.notifications.NotificationMessage;
import com.salesforce.marketingcloud.p027e.C4029h;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;

/* renamed from: com.salesforce.marketingcloud.notifications.d */
class C4112d implements NotificationManager.NotificationBuilder {

    /* renamed from: a */
    private static final String f3321a = C4039h.m2810a((Class<?>) C4112d.class);

    /* renamed from: b */
    private final NotificationManager.NotificationLaunchIntentProvider f3322b;

    /* renamed from: c */
    private final NotificationManager.NotificationBuilder f3323c;

    /* renamed from: d */
    private final NotificationManager.NotificationChannelIdProvider f3324d;

    /* renamed from: e */
    private final int f3325e;

    /* renamed from: com.salesforce.marketingcloud.notifications.d$1 */
    static /* synthetic */ class C41131 {

        /* renamed from: a */
        static final /* synthetic */ int[] f3326a = new int[NotificationMessage.Sound.values().length];

        /* JADX WARNING: Can't wrap try/catch for region: R(8:0|1|2|3|4|5|6|8) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0014 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001f */
        static {
            /*
                com.salesforce.marketingcloud.notifications.NotificationMessage$Sound[] r0 = com.salesforce.marketingcloud.notifications.NotificationMessage.Sound.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f3326a = r0
                int[] r0 = f3326a     // Catch:{ NoSuchFieldError -> 0x0014 }
                com.salesforce.marketingcloud.notifications.NotificationMessage$Sound r1 = com.salesforce.marketingcloud.notifications.NotificationMessage.Sound.CUSTOM     // Catch:{ NoSuchFieldError -> 0x0014 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0014 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0014 }
            L_0x0014:
                int[] r0 = f3326a     // Catch:{ NoSuchFieldError -> 0x001f }
                com.salesforce.marketingcloud.notifications.NotificationMessage$Sound r1 = com.salesforce.marketingcloud.notifications.NotificationMessage.Sound.DEFAULT     // Catch:{ NoSuchFieldError -> 0x001f }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001f }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001f }
            L_0x001f:
                int[] r0 = f3326a     // Catch:{ NoSuchFieldError -> 0x002a }
                com.salesforce.marketingcloud.notifications.NotificationMessage$Sound r1 = com.salesforce.marketingcloud.notifications.NotificationMessage.Sound.NONE     // Catch:{ NoSuchFieldError -> 0x002a }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x002a }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x002a }
            L_0x002a:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.salesforce.marketingcloud.notifications.C4112d.C41131.<clinit>():void");
        }
    }

    C4112d(@DrawableRes int i, @Nullable NotificationManager.NotificationLaunchIntentProvider notificationLaunchIntentProvider, @Nullable NotificationManager.NotificationBuilder notificationBuilder, @Nullable NotificationManager.NotificationChannelIdProvider notificationChannelIdProvider) {
        this.f3322b = notificationLaunchIntentProvider;
        this.f3323c = notificationBuilder;
        this.f3324d = notificationChannelIdProvider;
        this.f3325e = i;
    }

    /* renamed from: a */
    private static Uri m3293a(Context context, String str, Uri uri) {
        int identifier = context.getResources().getIdentifier(m3296a(str), "raw", context.getPackageName());
        if (identifier <= 0) {
            return uri;
        }
        return Uri.parse("android.resource://" + context.getPackageName() + "/" + identifier);
    }

    /* JADX WARNING: Removed duplicated region for block: B:16:0x006b  */
    /* JADX WARNING: Removed duplicated region for block: B:17:0x0070  */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x007c  */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x009e  */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x00b2  */
    @androidx.annotation.NonNull
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    static androidx.core.app.NotificationCompat.Builder m3294a(android.content.Context r5, com.salesforce.marketingcloud.notifications.NotificationMessage r6, java.lang.String r7, int r8) {
        /*
            androidx.core.app.NotificationCompat$Builder r0 = new androidx.core.app.NotificationCompat$Builder
            r0.<init>(r5, r7)
            android.content.pm.ApplicationInfo r7 = r5.getApplicationInfo()
            int r7 = r7.icon
            if (r7 <= 0) goto L_0x0018
            android.content.res.Resources r1 = r5.getResources()
            android.graphics.Bitmap r7 = android.graphics.BitmapFactory.decodeResource(r1, r7)
            r0.setLargeIcon(r7)
        L_0x0018:
            r0.setSmallIcon(r8)
            java.lang.String r7 = r6.title()
            r0.setContentTitle(r7)
            java.lang.String r7 = r6.mediaUrl()
            boolean r7 = android.text.TextUtils.isEmpty(r7)
            r8 = 1
            r1 = 0
            if (r7 != 0) goto L_0x005e
            java.lang.String r7 = r6.mediaUrl()     // Catch:{ Exception -> 0x004e }
            android.graphics.Bitmap r7 = m3297b(r7)     // Catch:{ Exception -> 0x004e }
            if (r7 == 0) goto L_0x005e
            androidx.core.app.NotificationCompat$BigPictureStyle r2 = new androidx.core.app.NotificationCompat$BigPictureStyle     // Catch:{ Exception -> 0x004e }
            r2.<init>()     // Catch:{ Exception -> 0x004e }
            androidx.core.app.NotificationCompat$BigPictureStyle r7 = r2.bigPicture(r7)     // Catch:{ Exception -> 0x004e }
            java.lang.String r2 = r6.alert()     // Catch:{ Exception -> 0x004e }
            androidx.core.app.NotificationCompat$BigPictureStyle r7 = r7.setSummaryText(r2)     // Catch:{ Exception -> 0x004e }
            r0.setStyle(r7)     // Catch:{ Exception -> 0x004e }
            r7 = 1
            goto L_0x005f
        L_0x004e:
            r7 = move-exception
            java.lang.String r2 = f3321a
            java.lang.Object[] r3 = new java.lang.Object[r8]
            java.lang.String r4 = r6.mediaUrl()
            r3[r1] = r4
            java.lang.String r4 = "Unable to load notification image %s"
            com.salesforce.marketingcloud.C4039h.m2830e(r2, r7, r4, r3)
        L_0x005e:
            r7 = 0
        L_0x005f:
            if (r7 != 0) goto L_0x0070
            java.lang.String r2 = r6.mediaAltText()
            boolean r2 = android.text.TextUtils.isEmpty(r2)
            if (r2 != 0) goto L_0x0070
            java.lang.String r2 = r6.mediaAltText()
            goto L_0x0074
        L_0x0070:
            java.lang.String r2 = r6.alert()
        L_0x0074:
            r0.setContentText(r2)
            r0.setTicker(r2)
            if (r7 != 0) goto L_0x0090
            androidx.core.app.NotificationCompat$BigTextStyle r7 = new androidx.core.app.NotificationCompat$BigTextStyle
            r7.<init>()
            androidx.core.app.NotificationCompat$BigTextStyle r7 = r7.bigText(r2)
            java.lang.String r2 = r6.title()
            androidx.core.app.NotificationCompat$BigTextStyle r7 = r7.setBigContentTitle(r2)
            r0.setStyle(r7)
        L_0x0090:
            int[] r7 = com.salesforce.marketingcloud.notifications.C4112d.C41131.f3326a
            com.salesforce.marketingcloud.notifications.NotificationMessage$Sound r2 = r6.sound()
            int r2 = r2.ordinal()
            r7 = r7[r2]
            if (r7 == r8) goto L_0x00b2
            r5 = 2
            if (r7 == r5) goto L_0x00af
            r5 = 3
            if (r7 == r5) goto L_0x00a5
            goto L_0x00bf
        L_0x00a5:
            java.lang.String r5 = f3321a
            java.lang.Object[] r6 = new java.lang.Object[r1]
            java.lang.String r7 = "No sound was set for notification."
            com.salesforce.marketingcloud.C4039h.m2820b(r5, r7, r6)
            goto L_0x00bf
        L_0x00af:
            android.net.Uri r5 = android.provider.Settings.System.DEFAULT_NOTIFICATION_URI
            goto L_0x00bc
        L_0x00b2:
            java.lang.String r6 = r6.soundName()
            android.net.Uri r7 = android.provider.Settings.System.DEFAULT_NOTIFICATION_URI
            android.net.Uri r5 = m3293a(r5, r6, r7)
        L_0x00bc:
            r0.setSound(r5)
        L_0x00bf:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.salesforce.marketingcloud.notifications.C4112d.m3294a(android.content.Context, com.salesforce.marketingcloud.notifications.NotificationMessage, java.lang.String, int):androidx.core.app.NotificationCompat$Builder");
    }

    /* renamed from: a */
    static String m3295a(Context context, boolean z) {
        android.app.NotificationManager notificationManager;
        if (C4029h.m2772a() && (notificationManager = (android.app.NotificationManager) context.getSystemService("notification")) != null && (notificationManager.getNotificationChannel(NotificationManager.DEFAULT_CHANNEL_ID) == null || z)) {
            NotificationChannel notificationChannel = new NotificationChannel(NotificationManager.DEFAULT_CHANNEL_ID, context.getString(C3839R.string.mcsdk_default_notification_channel_name), 3);
            notificationChannel.enableLights(false);
            notificationChannel.enableVibration(false);
            notificationChannel.setShowBadge(true);
            notificationChannel.setLockscreenVisibility(0);
            notificationManager.createNotificationChannel(notificationChannel);
        }
        return NotificationManager.DEFAULT_CHANNEL_ID;
    }

    /* renamed from: a */
    private static String m3296a(String str) {
        return (str == null || str.lastIndexOf(".") <= 0) ? str : str.substring(0, str.lastIndexOf("."));
    }

    /* renamed from: b */
    private static Bitmap m3297b(String str) {
        try {
            HttpURLConnection httpURLConnection = (HttpURLConnection) ((URLConnection) FirebasePerfUrlConnection.instrument(new URL(str).openConnection()));
            httpURLConnection.setDoInput(true);
            httpURLConnection.setReadTimeout(30000);
            httpURLConnection.setConnectTimeout(30000);
            httpURLConnection.connect();
            return BitmapFactory.decodeStream(httpURLConnection.getInputStream());
        } catch (Exception e) {
            C4039h.m2830e(f3321a, e, "Unable to download image %s", str);
            return null;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:10:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0017  */
    @android.annotation.SuppressLint({"NewApi"})
    /* renamed from: b */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private java.lang.String m3298b(android.content.Context r5, com.salesforce.marketingcloud.notifications.NotificationMessage r6) {
        /*
            r4 = this;
            com.salesforce.marketingcloud.notifications.NotificationManager$NotificationChannelIdProvider r0 = r4.f3324d
            r1 = 0
            if (r0 == 0) goto L_0x0014
            java.lang.String r6 = r0.getNotificationChannelId(r5, r6)     // Catch:{ Exception -> 0x000a }
            goto L_0x0015
        L_0x000a:
            r6 = move-exception
            java.lang.String r0 = f3321a
            java.lang.Object[] r2 = new java.lang.Object[r1]
            java.lang.String r3 = "Exception thrown while app determined channel id for notification message."
            com.salesforce.marketingcloud.C4039h.m2830e(r0, r6, r3, r2)
        L_0x0014:
            r6 = 0
        L_0x0015:
            if (r6 != 0) goto L_0x001c
            m3295a((android.content.Context) r5, (boolean) r1)
            java.lang.String r6 = "com.salesforce.marketingcloud.DEFAULT_CHANNEL"
        L_0x001c:
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.salesforce.marketingcloud.notifications.C4112d.m3298b(android.content.Context, com.salesforce.marketingcloud.notifications.NotificationMessage):java.lang.String");
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public PendingIntent mo56890a(Context context, @NonNull NotificationMessage notificationMessage) {
        NotificationManager.NotificationLaunchIntentProvider notificationLaunchIntentProvider = this.f3322b;
        if (notificationLaunchIntentProvider != null) {
            return notificationLaunchIntentProvider.getNotificationPendingIntent(context, notificationMessage);
        }
        Intent launchIntentForPackage = context.getPackageManager().getLaunchIntentForPackage(context.getPackageName());
        if (launchIntentForPackage == null) {
            return null;
        }
        launchIntentForPackage.putExtra(NotificationManager.f3287h, notificationMessage).addFlags(134217728);
        return PendingIntent.getActivity(context, notificationMessage.notificationId(), launchIntentForPackage, 134217728);
    }

    /* JADX WARNING: Removed duplicated region for block: B:8:0x0017  */
    @androidx.annotation.NonNull
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public androidx.core.app.NotificationCompat.Builder setupNotificationBuilder(@androidx.annotation.NonNull android.content.Context r5, @androidx.annotation.NonNull com.salesforce.marketingcloud.notifications.NotificationMessage r6) {
        /*
            r4 = this;
            com.salesforce.marketingcloud.notifications.NotificationManager$NotificationBuilder r0 = r4.f3323c
            if (r0 == 0) goto L_0x0014
            androidx.core.app.NotificationCompat$Builder r0 = r0.setupNotificationBuilder(r5, r6)     // Catch:{ Exception -> 0x0009 }
            goto L_0x0015
        L_0x0009:
            r0 = move-exception
            java.lang.String r1 = f3321a
            r2 = 0
            java.lang.Object[] r2 = new java.lang.Object[r2]
            java.lang.String r3 = "Custom notification builder threw an exception.  Using default notification builder."
            com.salesforce.marketingcloud.C4039h.m2830e(r1, r0, r3, r2)
        L_0x0014:
            r0 = 0
        L_0x0015:
            if (r0 != 0) goto L_0x002f
            java.lang.String r0 = r4.m3298b(r5, r6)
            int r1 = r4.f3325e
            androidx.core.app.NotificationCompat$Builder r0 = m3294a(r5, r6, r0, r1)
            android.app.PendingIntent r1 = r4.mo56890a((android.content.Context) r5, (com.salesforce.marketingcloud.notifications.NotificationMessage) r6)
            if (r1 == 0) goto L_0x002f
            r2 = 1
            android.app.PendingIntent r5 = com.salesforce.marketingcloud.notifications.NotificationManager.redirectIntentForAnalytics(r5, r1, r6, r2)
            r0.setContentIntent(r5)
        L_0x002f:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.salesforce.marketingcloud.notifications.C4112d.setupNotificationBuilder(android.content.Context, com.salesforce.marketingcloud.notifications.NotificationMessage):androidx.core.app.NotificationCompat$Builder");
    }
}

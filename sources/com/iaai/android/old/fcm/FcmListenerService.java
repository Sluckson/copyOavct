package com.iaai.android.old.fcm;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.os.Build;
import android.provider.Settings;
import android.util.Log;
import androidx.core.app.NotificationCompat;
import com.google.firebase.messaging.FirebaseMessagingService;
import com.google.inject.Injector;
import com.iaai.android.C2723R;
import com.iaai.android.IaaiApplication;
import com.iaai.android.bdt.feature.auctionMainPage.BDTAuctionMainListActivity;
import com.iaai.android.bdt.feature.landing.BDTLandingPageActivity;
import com.iaai.android.bdt.utils.Constants_MVVM;
import com.iaai.android.old.activities.MDBuyNowOfferListActivity;
import com.iaai.android.old.managers.AlertManager;

public class FcmListenerService extends FirebaseMessagingService {
    public static String CHANNEL_ID = "IAABuyer ChannelID -1";
    public static int NOTIFICATION_ID = 1;
    public static String TAG_DIGITAL_NEGOTATION = "Negotiation Offer";
    private String TAG = "FcmListenerService";
    private NotificationManager mNotificationManager;

    public void onNewToken(String str) {
        Injector injector = ((IaaiApplication) getApplication()).getInjector();
        ((IaaiApplication) getApplication()).getComponent().getPreferenceHelper().put(Constants_MVVM.FCM_REGISTERED_TOKEN, str);
        ((AlertManager) injector.getInstance(AlertManager.class)).persistFCMRegistrationId(str);
        Log.d("onNewToken-->", str);
        super.onNewToken(str);
    }

    /* JADX WARNING: Removed duplicated region for block: B:16:0x003a  */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x0046  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onMessageReceived(com.google.firebase.messaging.RemoteMessage r5) {
        /*
            r4 = this;
            java.lang.String r0 = ""
            super.onMessageReceived(r5)
            boolean r1 = com.salesforce.marketingcloud.messages.push.PushMessageManager.isMarketingCloudPush((com.google.firebase.messaging.RemoteMessage) r5)
            if (r1 == 0) goto L_0x000c
            goto L_0x0067
        L_0x000c:
            java.util.Map r5 = r5.getData()
            int r1 = r5.size()
            if (r1 <= 0) goto L_0x0067
            java.lang.String r1 = "header"
            java.lang.Object r1 = r5.get(r1)     // Catch:{ NullPointerException -> 0x002d }
            java.lang.String r1 = r1.toString()     // Catch:{ NullPointerException -> 0x002d }
            java.lang.String r2 = "message"
            java.lang.Object r5 = r5.get(r2)     // Catch:{ NullPointerException -> 0x002b }
            java.lang.String r0 = r5.toString()     // Catch:{ NullPointerException -> 0x002b }
            goto L_0x0032
        L_0x002b:
            r5 = move-exception
            goto L_0x002f
        L_0x002d:
            r5 = move-exception
            r1 = r0
        L_0x002f:
            r5.printStackTrace()
        L_0x0032:
            java.lang.String r5 = TAG_DIGITAL_NEGOTATION
            boolean r5 = r1.startsWith(r5)
            if (r5 == 0) goto L_0x0046
            boolean r5 = com.iaai.android.IaaiApplication.is_app_in_bg
            if (r5 == 0) goto L_0x0042
            r4.sendNotification(r0, r1)
            goto L_0x0049
        L_0x0042:
            r4.sendForegroundNotificationForManageOffer(r0, r1)
            goto L_0x0049
        L_0x0046:
            r4.sendNotification(r0, r1)
        L_0x0049:
            java.lang.String r5 = r4.TAG
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r3 = "Received: "
            r2.append(r3)
            r2.append(r1)
            java.lang.String r1 = " "
            r2.append(r1)
            r2.append(r0)
            java.lang.String r0 = r2.toString()
            android.util.Log.i(r5, r0)
        L_0x0067:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.iaai.android.old.fcm.FcmListenerService.onMessageReceived(com.google.firebase.messaging.RemoteMessage):void");
    }

    private void sendNotification(String str, String str2) {
        PendingIntent pendingIntent;
        this.mNotificationManager = (NotificationManager) getSystemService("notification");
        if (str2.startsWith("Buy Now Offer Available")) {
            pendingIntent = PendingIntent.getActivity(this, 0, new Intent(this, MDBuyNowOfferListActivity.class), 0);
        } else if (str2.startsWith(TAG_DIGITAL_NEGOTATION)) {
            Intent intent = new Intent(this, BDTLandingPageActivity.class);
            intent.addFlags(536870912);
            intent.putExtra(Constants_MVVM.EXTRA_ORIGIN_PUSH_NOTIFICATION, true);
            intent.putExtra(Constants_MVVM.EXTRA_ORIGIN_PUSH_NOTIFICATION_TYPE, TAG_DIGITAL_NEGOTATION);
            pendingIntent = PendingIntent.getActivity(this, 0, intent, 134217728);
        } else {
            IaaiApplication iaaiApplication = (IaaiApplication) getApplication();
            pendingIntent = IaaiApplication.isBDTEnabled ? PendingIntent.getActivity(this, 0, new Intent(this, BDTAuctionMainListActivity.class), 0) : null;
        }
        NotificationCompat.Builder autoCancel = new NotificationCompat.Builder(this, CHANNEL_ID).setSmallIcon(C2723R.C2725drawable.logo_iaa).setContentTitle(str2).setSound(Settings.System.DEFAULT_NOTIFICATION_URI).setStyle(new NotificationCompat.BigTextStyle().bigText(str)).setContentText(str).setAutoCancel(true);
        if (Build.VERSION.SDK_INT >= 26) {
            createNotificationChannel();
        }
        autoCancel.setContentIntent(pendingIntent);
        this.mNotificationManager.notify(NOTIFICATION_ID, autoCancel.build());
    }

    private void createNotificationChannel() {
        if (Build.VERSION.SDK_INT >= 26) {
            String string = getString(C2723R.string.channel_name);
            String string2 = getString(C2723R.string.channel_description);
            NotificationChannel notificationChannel = new NotificationChannel(CHANNEL_ID, string, 4);
            notificationChannel.setDescription(string2);
            this.mNotificationManager.createNotificationChannel(notificationChannel);
        }
    }

    private void sendForegroundNotificationForManageOffer(String str, String str2) {
        this.mNotificationManager = (NotificationManager) getSystemService("notification");
        Intent intent = new Intent(this, BDTLandingPageActivity.class);
        intent.addFlags(536870912);
        intent.putExtra(Constants_MVVM.EXTRA_ORIGIN_PUSH_NOTIFICATION, true);
        intent.putExtra(Constants_MVVM.EXTRA_ORIGIN_PUSH_NOTIFICATION_TYPE, TAG_DIGITAL_NEGOTATION);
        PendingIntent activity = PendingIntent.getActivity(this, 0, intent, 134217728);
        NotificationCompat.Builder autoCancel = new NotificationCompat.Builder(this, CHANNEL_ID).setSmallIcon(C2723R.C2725drawable.logo_iaa).setContentTitle(str2).setSound(Settings.System.DEFAULT_NOTIFICATION_URI).setStyle(new NotificationCompat.BigTextStyle().bigText(str)).setContentText(str).setPriority(1).addAction(C2723R.C2725drawable.ic_manage_offers, "Manage Offer", activity).setOngoing(false).setAutoCancel(true);
        if (Build.VERSION.SDK_INT >= 26) {
            String string = getString(C2723R.string.channel_name);
            String string2 = getString(C2723R.string.channel_description);
            NotificationChannel notificationChannel = new NotificationChannel(CHANNEL_ID, string, 4);
            notificationChannel.setDescription(string2);
            this.mNotificationManager.createNotificationChannel(notificationChannel);
        }
        autoCancel.setContentIntent(activity);
        this.mNotificationManager.notify(NOTIFICATION_ID, autoCancel.build());
    }
}

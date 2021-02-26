package com.google.android.gms.appinvite;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;

@Deprecated
public class AppInviteReferral {
    private AppInviteReferral() {
    }

    public static boolean hasReferral(Intent intent) {
        return (intent == null || intent.getBundleExtra("com.google.android.gms.appinvite.REFERRAL_BUNDLE") == null) ? false : true;
    }

    public static boolean isOpenedFromPlayStore(Intent intent) {
        if (!hasReferral(intent) || !intent.getBundleExtra("com.google.android.gms.appinvite.REFERRAL_BUNDLE").getBoolean("com.google.android.gms.appinvite.OPENED_FROM_PLAY_STORE", false)) {
            return false;
        }
        return true;
    }

    public static String getInvitationId(Intent intent) {
        Bundle bundleExtra;
        if (intent == null || (bundleExtra = intent.getBundleExtra("com.google.android.gms.appinvite.REFERRAL_BUNDLE")) == null) {
            return null;
        }
        return bundleExtra.getString("com.google.android.gms.appinvite.INVITATION_ID");
    }

    public static String getDeepLink(Intent intent) {
        Bundle bundleExtra;
        if (intent == null || (bundleExtra = intent.getBundleExtra("com.google.android.gms.appinvite.REFERRAL_BUNDLE")) == null) {
            return null;
        }
        return bundleExtra.getString("com.google.android.gms.appinvite.DEEP_LINK");
    }

    @Deprecated
    public static Intent addPlayStoreReferrerToIntent(Intent intent, Intent intent2) {
        Bundle zza = zza(intent);
        if (!(zza == null || intent2 == null)) {
            intent2.putExtra("com.google.android.gms.appinvite.REFERRAL_BUNDLE", zza);
        }
        return intent2;
    }

    @Deprecated
    public static Intent addReferralDataToIntent(String str, String str2, Intent intent) {
        if (intent == null) {
            return null;
        }
        return intent.putExtra("com.google.android.gms.appinvite.REFERRAL_BUNDLE", zza(str, str2, false));
    }

    private static Bundle zza(String str, String str2, boolean z) {
        Bundle bundle = new Bundle();
        bundle.putString("com.google.android.gms.appinvite.INVITATION_ID", str);
        if (str2 != null) {
            bundle.putString("com.google.android.gms.appinvite.DEEP_LINK", str2);
        }
        bundle.putBoolean("com.google.android.gms.appinvite.OPENED_FROM_PLAY_STORE", z);
        return bundle;
    }

    private static Bundle zza(Intent intent) {
        if (!(intent == null || !intent.getAction().equals("com.android.vending.INSTALL_REFERRER") || intent.getStringExtra("referrer") == null)) {
            String stringExtra = intent.getStringExtra("referrer");
            try {
                String decode = URLDecoder.decode(stringExtra, "UTF-8");
                String valueOf = String.valueOf(decode);
                Uri parse = Uri.parse(valueOf.length() != 0 ? "s://a.b.c?".concat(valueOf) : new String("s://a.b.c?"));
                String queryParameter = parse.getQueryParameter("invitation_id");
                String queryParameter2 = parse.getQueryParameter("deep_link_id");
                if (queryParameter != null || queryParameter2 != null) {
                    return zza(queryParameter, queryParameter2, true);
                }
                String valueOf2 = String.valueOf(decode);
                Log.w("AppInviteRef", valueOf2.length() != 0 ? "Missing  Referrer query params: ".concat(valueOf2) : new String("Missing  Referrer query params: "));
                return null;
            } catch (UnsupportedEncodingException unused) {
                String valueOf3 = String.valueOf(stringExtra);
                Log.e("AppInviteRef", valueOf3.length() != 0 ? "Error parsing Play Store referrer URL: ".concat(valueOf3) : new String("Error parsing Play Store referrer URL: "));
            }
        }
        return null;
    }
}

package com.google.android.gms.appinvite;

import android.accounts.Account;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.google.android.gms.common.internal.AccountType;
import com.google.android.gms.common.internal.Preconditions;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.Map;
import p052cz.msebera.android.httpclient.HttpHost;

public final class AppInviteInvitation {
    private static final String[] zzf = {"jpg", "jpeg", "png"};

    private AppInviteInvitation() {
    }

    public static String[] getInvitationIds(int i, @NonNull Intent intent) {
        if (i == -1) {
            return intent.getStringArrayExtra("com.google.android.gms.appinvite.RESULT_INVITATION_IDS");
        }
        return null;
    }

    /* access modifiers changed from: private */
    public static Bundle zza(Map<String, String> map) {
        Bundle bundle = new Bundle();
        for (String next : map.keySet()) {
            bundle.putString(next, map.get(next));
        }
        return bundle;
    }

    public static final class IntentBuilder {
        public static final int MAX_CALL_TO_ACTION_TEXT_LENGTH = 20;
        public static final int MAX_EMAIL_HTML_CONTENT = 512000;
        public static final int MAX_MESSAGE_LENGTH = 100;
        public static final int MIN_CALL_TO_ACTION_TEXT_LENGTH = 2;
        private final Intent intent = new Intent("com.google.android.gms.appinvite.ACTION_APP_INVITE");
        private String zzg;
        private String zzh;

        @Retention(RetentionPolicy.SOURCE)
        public @interface PlatformMode {
            public static final int PROJECT_PLATFORM_ANDROID = 2;
            public static final int PROJECT_PLATFORM_IOS = 1;
        }

        public IntentBuilder(@NonNull CharSequence charSequence) {
            Preconditions.checkNotNull(charSequence);
            this.intent.putExtra("com.google.android.gms.appinvite.TITLE", charSequence);
            this.intent.setPackage("com.google.android.gms");
        }

        public final IntentBuilder setAccount(Account account) {
            if (account == null || !AccountType.GOOGLE.equals(account.type)) {
                this.intent.removeExtra("com.google.android.gms.appinvite.ACCOUNT_NAME");
            } else {
                this.intent.putExtra("com.google.android.gms.appinvite.ACCOUNT_NAME", account);
            }
            return this;
        }

        public final IntentBuilder setMessage(CharSequence charSequence) {
            if (charSequence == null || charSequence.length() <= 100) {
                this.intent.putExtra("com.google.android.gms.appinvite.MESSAGE", charSequence);
                return this;
            }
            throw new IllegalArgumentException(String.format("Message must be %d chars or less.", new Object[]{100}));
        }

        public final IntentBuilder setEmailSubject(String str) {
            this.zzg = str;
            return this;
        }

        public final IntentBuilder setEmailHtmlContent(String str) {
            if (str == null || str.getBytes().length <= 512000) {
                this.zzh = str;
                return this;
            }
            throw new IllegalArgumentException(String.format("Email html content must be %d bytes or less.", new Object[]{Integer.valueOf(MAX_EMAIL_HTML_CONTENT)}));
        }

        public final IntentBuilder setDeepLink(Uri uri) {
            if (uri != null) {
                this.intent.putExtra("com.google.android.gms.appinvite.DEEP_LINK_URL", uri);
            } else {
                this.intent.removeExtra("com.google.android.gms.appinvite.DEEP_LINK_URL");
            }
            return this;
        }

        public final IntentBuilder setAdditionalReferralParameters(Map<String, String> map) {
            if (map != null) {
                this.intent.putExtra("com.google.android.gms.appinvite.REFERRAL_PARAMETERS_URI", AppInviteInvitation.zza(map));
            } else {
                this.intent.removeExtra("com.google.android.gms.appinvite.REFERRAL_PARAMETERS_URI");
            }
            return this;
        }

        public final IntentBuilder setGoogleAnalyticsTrackingId(String str) {
            this.intent.putExtra("com.google.android.gms.appinvite.GOOGLE_ANALYTICS_TRACKING_ID", str);
            return this;
        }

        public final IntentBuilder setAndroidMinimumVersionCode(int i) {
            this.intent.putExtra("com.google.android.gms.appinvite.appMinimumVersionCode", i);
            return this;
        }

        public final IntentBuilder setCustomImage(Uri uri) {
            Preconditions.checkNotNull(uri);
            Preconditions.checkArgument(uri.isAbsolute(), "Image uri is not an absolute uri. Did you forget to add a scheme to the Uri?");
            String lowerCase = uri.getScheme().toLowerCase();
            boolean z = false;
            boolean z2 = lowerCase.equals("android.resource") || lowerCase.equals("content") || lowerCase.equals("file");
            Preconditions.checkArgument(z2 || lowerCase.equals(HttpHost.DEFAULT_SCHEME_NAME) || lowerCase.equals("https"), "Image uri must be a content URI with scheme \"android.resource\", \"content\" or \"file\", or a network url with scheme \"http\" or \"https\".");
            if (!z2) {
                String lastPathSegment = uri.getLastPathSegment();
                String str = null;
                if (!(lastPathSegment == null || lastPathSegment.lastIndexOf(".") == -1)) {
                    str = lastPathSegment.substring(lastPathSegment.lastIndexOf(".") + 1, lastPathSegment.length()).toLowerCase();
                }
                if (TextUtils.isEmpty(str) || AppInviteInvitation.zza(str)) {
                    z = true;
                }
                Preconditions.checkArgument(z, String.valueOf(str).concat(" images are not supported. Only jpg, jpeg, or png images are supported."));
            }
            this.intent.setData(uri.buildUpon().scheme(lowerCase).build());
            if (z2) {
                this.intent.addFlags(1);
            }
            return this;
        }

        public final IntentBuilder setCallToActionText(CharSequence charSequence) {
            if (charSequence == null || charSequence.length() < 2 || charSequence.length() > 20) {
                throw new IllegalArgumentException(String.format("Text must be between %d and %d chars in length.", new Object[]{2, 20}));
            }
            this.intent.putExtra("com.google.android.gms.appinvite.BUTTON_TEXT", charSequence);
            return this;
        }

        public final IntentBuilder setOtherPlatformsTargetApplication(int i, String str) throws IllegalArgumentException {
            if (i == 1) {
                this.intent.putExtra("com.google.android.gms.appinvite.iosTargetApplication", str);
            } else if (i == 2) {
                this.intent.putExtra("com.google.android.gms.appinvite.androidTargetApplication", str);
            } else {
                throw new IllegalArgumentException("targetPlatform must be either PROJECT_PLATFORM_IOS or PROJECT_PLATFORM_ANDROID.");
            }
            return this;
        }

        public final Intent build() {
            if (!TextUtils.isEmpty(this.zzg)) {
                Preconditions.checkNotEmpty(this.zzh, "Email html content must be set when email subject is set.");
                Preconditions.checkArgument(this.intent.getData() == null, "Custom image must not be set when email html content is set.");
                Preconditions.checkArgument(TextUtils.isEmpty(this.intent.getCharSequenceExtra("com.google.android.gms.appinvite.BUTTON_TEXT")), "Call to action text must not be set when email html content is set.");
                this.intent.putExtra("com.google.android.gms.appinvite.EMAIL_SUBJECT", this.zzg);
                this.intent.putExtra("com.google.android.gms.appinvite.EMAIL_CONTENT", this.zzh);
            } else if (!TextUtils.isEmpty(this.zzh)) {
                throw new IllegalArgumentException("Email subject must be set when email html content is set.");
            }
            return this.intent;
        }
    }

    /* access modifiers changed from: private */
    public static boolean zza(String str) {
        int i = 0;
        while (true) {
            String[] strArr = zzf;
            if (i >= strArr.length) {
                return false;
            }
            if (strArr[i].equals(str)) {
                return true;
            }
            i++;
        }
    }
}

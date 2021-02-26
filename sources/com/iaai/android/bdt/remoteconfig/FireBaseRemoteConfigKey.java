package com.iaai.android.bdt.remoteconfig;

import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(mo66931bv = {1, 0, 3}, mo66932d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001:\u0001\u0003B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0004"}, mo66933d2 = {"Lcom/iaai/android/bdt/remoteconfig/FireBaseRemoteConfigKey;", "", "()V", "FirebaseConfigKey", "app_productionRelease"}, mo66934k = 1, mo66935mv = {1, 1, 13})
/* compiled from: FireBaseRemoteConfigKey.kt */
public final class FireBaseRemoteConfigKey {
    public static final FireBaseRemoteConfigKey INSTANCE = new FireBaseRemoteConfigKey();

    private FireBaseRemoteConfigKey() {
    }

    @Metadata(mo66931bv = {1, 0, 3}, mo66932d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000f\b\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011¨\u0006\u0012"}, mo66933d2 = {"Lcom/iaai/android/bdt/remoteconfig/FireBaseRemoteConfigKey$FirebaseConfigKey;", "", "value", "", "(Ljava/lang/String;ILjava/lang/String;)V", "getValue", "()Ljava/lang/String;", "DEEP_LINK", "ANNOUNCEMENT", "MEDALLIA_INFO", "MANAGE_OFFER_HINT_SCREEN_FLAG", "BROKER_COMMUNITY_FLAG", "MEDALLIA_CUSTOM_PARAMETER", "GOOGLE_PLAY_BUYER_APP_VERSION", "MINIMUM_BUYER_APP_VERSION", "ADS_URL", "VEHICLE_GRADE_INFORMATION_FLAG", "SOFT_LOGIN_TIMEOUT", "app_productionRelease"}, mo66934k = 1, mo66935mv = {1, 1, 13})
    /* compiled from: FireBaseRemoteConfigKey.kt */
    public enum FirebaseConfigKey {
        DEEP_LINK("deeplink_info"),
        ANNOUNCEMENT("announcement"),
        MEDALLIA_INFO("medallia_feedback_info"),
        MANAGE_OFFER_HINT_SCREEN_FLAG("manage_offer_hint_screen_flag"),
        BROKER_COMMUNITY_FLAG("broker_community_flag"),
        MEDALLIA_CUSTOM_PARAMETER("medallia_events"),
        GOOGLE_PLAY_BUYER_APP_VERSION("current_app_version"),
        MINIMUM_BUYER_APP_VERSION("min_app_version"),
        ADS_URL("ads_url"),
        VEHICLE_GRADE_INFORMATION_FLAG("vehicle_grade_info_flag"),
        SOFT_LOGIN_TIMEOUT("soft_login_timeout");
        
        @NotNull
        private final String value;

        private FirebaseConfigKey(String str) {
            this.value = str;
        }

        @NotNull
        public final String getValue() {
            return this.value;
        }
    }
}

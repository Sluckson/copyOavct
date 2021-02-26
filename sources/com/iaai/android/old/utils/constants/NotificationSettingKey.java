package com.iaai.android.old.utils.constants;

public enum NotificationSettingKey {
    OUTBID,
    WON_TODAY,
    AWARD_PENDING_STATUS_CHANGES,
    PAYMENT_POSTED,
    VEHICLE_PICKED_UP,
    WATCH_LIST_SALE;

    public String getPreferenceKey(NotificationSettingType notificationSettingType) {
        return "pref_key_" + toString().toLowerCase() + "_" + notificationSettingType.toString().toLowerCase();
    }
}

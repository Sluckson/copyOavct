package com.braintreepayments.cardform.utils;

import android.text.TextUtils;
import java.util.Calendar;

public class DateValidator {
    private static final DateValidator INSTANCE = new DateValidator(Calendar.getInstance());
    public static final int MAXIMUM_VALID_YEAR_DIFFERENCE = 20;
    private final Calendar mCalendar;

    protected DateValidator(Calendar calendar) {
        this.mCalendar = calendar;
    }

    public static boolean isValid(String str, String str2) {
        return INSTANCE.isValidHelper(str, str2);
    }

    /* access modifiers changed from: protected */
    public boolean isValidHelper(String str, String str2) {
        int parseInt;
        int i;
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2) && TextUtils.isDigitsOnly(str) && TextUtils.isDigitsOnly(str2) && (parseInt = Integer.parseInt(str)) >= 1 && parseInt <= 12) {
            int currentTwoDigitYear = getCurrentTwoDigitYear();
            int length = str2.length();
            if (length == 2) {
                i = Integer.parseInt(str2);
            } else if (length == 4) {
                i = Integer.parseInt(str2.substring(2));
            }
            if (i == currentTwoDigitYear && parseInt < getCurrentMonth()) {
                return false;
            }
            if ((i >= currentTwoDigitYear || (i + 100) - currentTwoDigitYear <= 20) && i <= currentTwoDigitYear + 20) {
                return true;
            }
            return false;
        }
        return false;
    }

    private int getCurrentMonth() {
        return this.mCalendar.get(2) + 1;
    }

    private int getCurrentTwoDigitYear() {
        return this.mCalendar.get(1) % 100;
    }
}

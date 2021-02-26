package com.iaai.android.old.utils.p016ui;

import android.text.Html;
import android.text.TextUtils;
import android.widget.TextView;
import com.iaai.android.C2723R;
import com.iaai.android.old.utils.DateHelper;
import com.iaai.android.old.utils.constants.Constants;
import java.io.UnsupportedEncodingException;
import java.math.BigDecimal;
import java.net.URLEncoder;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Date;
import roboguice.util.C5058Ln;

/* renamed from: com.iaai.android.old.utils.ui.UiUtils */
public class UiUtils {
    public static String formatString(String str) {
        return str == null ? "" : str;
    }

    public static String formatCurrency(BigDecimal bigDecimal) {
        return formatCurrency(bigDecimal, true);
    }

    public static String formatCurrency(BigDecimal bigDecimal, boolean z) {
        if (bigDecimal == null) {
            return "";
        }
        if (z) {
            return DecimalFormat.getCurrencyInstance(Constants.APP_LOCALE).format(bigDecimal);
        }
        return "$" + NumberFormat.getIntegerInstance(Constants.APP_LOCALE).format((long) bigDecimal.intValue());
    }

    public static String formatCurrencyFromString(String str, boolean z) {
        if (str == null || str.length() == 0) {
            return "";
        }
        BigDecimal bigDecimal = new BigDecimal(str);
        if (z) {
            return DecimalFormat.getCurrencyInstance(Constants.APP_LOCALE).format(bigDecimal);
        }
        return "$" + NumberFormat.getIntegerInstance(Constants.APP_LOCALE).format(bigDecimal);
    }

    public static String formatNumber(BigDecimal bigDecimal) {
        return bigDecimal == null ? "" : DecimalFormat.getNumberInstance(Constants.APP_LOCALE).format(bigDecimal);
    }

    public static String formatNumberFromString(String str) {
        if (str == null) {
            return "";
        }
        BigDecimal bigDecimal = new BigDecimal(str);
        return "" + NumberFormat.getIntegerInstance(Constants.APP_LOCALE).format(bigDecimal);
    }

    public static String formatNextAuctionDate(Date date) {
        if (date == null) {
            return "";
        }
        return DateHelper.format(date, date.getMinutes() == 0 ? Constants.DATE_PATTERN_NEXT_AUCTION_DATE_TIME_HOUR_ONLY : Constants.DATE_PATTERN_NEXT_AUCTION_DATE_TIME);
    }

    public static String formatIBuyFastDate(Date date) {
        if (date == null) {
            return "";
        }
        return DateHelper.format(date, date.getMinutes() == 0 ? Constants.DATE_PATTERN_IBUY_FAST_HOUR_ONLY : Constants.DATE_PATTERN_IBUY_FAST);
    }

    public static BigDecimal toBigDecimal(String str) {
        String replaceAll = str.replaceAll("[,\\$]", "");
        if (TextUtils.isEmpty(replaceAll)) {
            return BigDecimal.ZERO;
        }
        return new BigDecimal(replaceAll);
    }

    public static void setLinkText(TextView textView, CharSequence charSequence) {
        setLinkText(textView, charSequence, true);
    }

    public static void setLinkText(TextView textView, CharSequence charSequence, boolean z) {
        textView.setTextColor(textView.getResources().getColor(C2723R.C2724color.iaa_txt_blue));
        if (z) {
            textView.setText(Html.fromHtml(String.format("<u>%s</u>", new Object[]{charSequence})));
            return;
        }
        textView.setText(charSequence);
    }

    public static String encodeString(String str) {
        try {
            return URLEncoder.encode(str, "utf-8");
        } catch (UnsupportedEncodingException e) {
            C5058Ln.m4834e(e, "Unable to enable text[%s]", str);
            return null;
        }
    }
}

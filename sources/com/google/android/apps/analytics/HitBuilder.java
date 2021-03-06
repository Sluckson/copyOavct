package com.google.android.apps.analytics;

import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import java.util.Locale;

class HitBuilder {
    static final String FAKE_DOMAIN_HASH = "1";
    private static final String GOOGLE_ANALYTICS_GIF_PATH = "/__utm.gif";
    private static final int X10_PROJECT_NAMES = 8;
    private static final int X10_PROJECT_SCOPES = 11;
    private static final int X10_PROJECT_VALUES = 9;

    HitBuilder() {
    }

    static void appendCurrencyValue(StringBuilder sb, String str, double d) {
        sb.append(str);
        sb.append("=");
        double floor = Math.floor((d * 1000000.0d) + 0.5d) / 1000000.0d;
        if (floor != FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE) {
            sb.append(Double.toString(floor));
        }
    }

    private static void appendStringValue(StringBuilder sb, String str, String str2) {
        sb.append(str);
        sb.append("=");
        if (str2 != null && str2.trim().length() > 0) {
            sb.append(AnalyticsParameterEncoder.encode(str2));
        }
    }

    private static String constructEventRequestPath(Event event, Referrer referrer) {
        Locale locale = Locale.getDefault();
        StringBuilder sb = new StringBuilder();
        StringBuilder sb2 = new StringBuilder();
        sb2.append(String.format("5(%s*%s", new Object[]{encode(event.category), encode(event.action)}));
        if (event.label != null) {
            sb2.append("*");
            sb2.append(encode(event.label));
        }
        sb2.append(")");
        if (event.value > -1) {
            sb2.append(String.format("(%d)", new Object[]{Integer.valueOf(event.value)}));
        }
        sb2.append(getCustomVariableParams(event));
        sb.append(GOOGLE_ANALYTICS_GIF_PATH);
        sb.append("?utmwv=4.8.1ma");
        sb.append("&utmn=");
        sb.append(event.getRandomVal());
        sb.append("&utmt=event");
        sb.append("&utme=");
        sb.append(sb2.toString());
        sb.append("&utmcs=UTF-8");
        sb.append(String.format("&utmsr=%dx%d", new Object[]{Integer.valueOf(event.screenWidth), Integer.valueOf(event.screenHeight)}));
        sb.append(String.format("&utmul=%s-%s", new Object[]{locale.getLanguage(), locale.getCountry()}));
        sb.append("&utmac=");
        sb.append(event.accountId);
        sb.append("&utmcc=");
        sb.append(getEscapedCookieString(event, referrer));
        if (event.getAdHitId() != 0) {
            sb.append("&utmhid=");
            sb.append(event.getAdHitId());
        }
        return sb.toString();
    }

    public static String constructHitRequestPath(Event event, Referrer referrer) {
        StringBuilder sb = new StringBuilder();
        sb.append("__##GOOGLEPAGEVIEW##__".equals(event.category) ? constructPageviewRequestPath(event, referrer) : "__##GOOGLEITEM##__".equals(event.category) ? constructItemRequestPath(event, referrer) : "__##GOOGLETRANSACTION##__".equals(event.category) ? constructTransactionRequestPath(event, referrer) : constructEventRequestPath(event, referrer));
        if (event.getAnonymizeIp()) {
            sb.append("&aip=1");
        }
        if (!event.getUseServerTime()) {
            sb.append("&utmht=" + System.currentTimeMillis());
        }
        return sb.toString();
    }

    private static String constructItemRequestPath(Event event, Referrer referrer) {
        StringBuilder sb = new StringBuilder();
        sb.append(GOOGLE_ANALYTICS_GIF_PATH);
        sb.append("?utmwv=4.8.1ma");
        sb.append("&utmn=");
        sb.append(event.getRandomVal());
        sb.append("&utmt=item");
        Item item = event.getItem();
        if (item != null) {
            appendStringValue(sb, "&utmtid", item.getOrderId());
            appendStringValue(sb, "&utmipc", item.getItemSKU());
            appendStringValue(sb, "&utmipn", item.getItemName());
            appendStringValue(sb, "&utmiva", item.getItemCategory());
            appendCurrencyValue(sb, "&utmipr", item.getItemPrice());
            sb.append("&utmiqt=");
            if (item.getItemCount() != 0) {
                sb.append(item.getItemCount());
            }
        }
        sb.append("&utmac=");
        sb.append(event.accountId);
        sb.append("&utmcc=");
        sb.append(getEscapedCookieString(event, referrer));
        return sb.toString();
    }

    private static String constructPageviewRequestPath(Event event, Referrer referrer) {
        String str = event.action != null ? event.action : "";
        if (!str.startsWith("/")) {
            str = "/" + str;
        }
        String encode = encode(str);
        String customVariableParams = getCustomVariableParams(event);
        Locale locale = Locale.getDefault();
        StringBuilder sb = new StringBuilder();
        sb.append(GOOGLE_ANALYTICS_GIF_PATH);
        sb.append("?utmwv=4.8.1ma");
        sb.append("&utmn=");
        sb.append(event.getRandomVal());
        if (customVariableParams.length() > 0) {
            sb.append("&utme=");
            sb.append(customVariableParams);
        }
        sb.append("&utmcs=UTF-8");
        sb.append(String.format("&utmsr=%dx%d", new Object[]{Integer.valueOf(event.screenWidth), Integer.valueOf(event.screenHeight)}));
        sb.append(String.format("&utmul=%s-%s", new Object[]{locale.getLanguage(), locale.getCountry()}));
        sb.append("&utmp=");
        sb.append(encode);
        sb.append("&utmac=");
        sb.append(event.accountId);
        sb.append("&utmcc=");
        sb.append(getEscapedCookieString(event, referrer));
        if (event.getAdHitId() != 0) {
            sb.append("&utmhid=");
            sb.append(event.getAdHitId());
        }
        return sb.toString();
    }

    private static String constructTransactionRequestPath(Event event, Referrer referrer) {
        StringBuilder sb = new StringBuilder();
        sb.append(GOOGLE_ANALYTICS_GIF_PATH);
        sb.append("?utmwv=4.8.1ma");
        sb.append("&utmn=");
        sb.append(event.getRandomVal());
        sb.append("&utmt=tran");
        Transaction transaction = event.getTransaction();
        if (transaction != null) {
            appendStringValue(sb, "&utmtid", transaction.getOrderId());
            appendStringValue(sb, "&utmtst", transaction.getStoreName());
            appendCurrencyValue(sb, "&utmtto", transaction.getTotalCost());
            appendCurrencyValue(sb, "&utmttx", transaction.getTotalTax());
            appendCurrencyValue(sb, "&utmtsp", transaction.getShippingCost());
            appendStringValue(sb, "&utmtci", "");
            appendStringValue(sb, "&utmtrg", "");
            appendStringValue(sb, "&utmtco", "");
        }
        sb.append("&utmac=");
        sb.append(event.accountId);
        sb.append("&utmcc=");
        sb.append(getEscapedCookieString(event, referrer));
        return sb.toString();
    }

    private static void createX10Project(CustomVariable[] customVariableArr, StringBuilder sb, int i) {
        String str;
        sb.append(i);
        sb.append("(");
        boolean z = true;
        for (int i2 = 0; i2 < customVariableArr.length; i2++) {
            if (customVariableArr[i2] != null) {
                CustomVariable customVariable = customVariableArr[i2];
                if (!z) {
                    sb.append("*");
                } else {
                    z = false;
                }
                sb.append(customVariable.getIndex());
                sb.append("!");
                if (i == 8) {
                    str = customVariable.getName();
                } else if (i == 9) {
                    str = customVariable.getValue();
                } else if (i == 11) {
                    sb.append(customVariable.getScope());
                }
                sb.append(x10Escape(encode(str)));
            }
        }
        sb.append(")");
    }

    private static String encode(String str) {
        return AnalyticsParameterEncoder.encode(str);
    }

    public static String getCustomVariableParams(Event event) {
        StringBuilder sb = new StringBuilder();
        CustomVariableBuffer customVariableBuffer = event.getCustomVariableBuffer();
        if (customVariableBuffer == null || !customVariableBuffer.hasCustomVariables()) {
            return "";
        }
        CustomVariable[] customVariableArray = customVariableBuffer.getCustomVariableArray();
        createX10Project(customVariableArray, sb, 8);
        createX10Project(customVariableArray, sb, 9);
        createX10Project(customVariableArray, sb, 11);
        return sb.toString();
    }

    public static String getEscapedCookieString(Event event, Referrer referrer) {
        StringBuilder sb = new StringBuilder();
        sb.append("__utma=");
        sb.append("1");
        sb.append(".");
        sb.append(event.getUserId());
        sb.append(".");
        sb.append(event.getTimestampFirst());
        sb.append(".");
        sb.append(event.getTimestampPrevious());
        sb.append(".");
        sb.append(event.getTimestampCurrent());
        sb.append(".");
        sb.append(event.getVisits());
        sb.append(";");
        if (referrer != null) {
            sb.append("+__utmz=");
            sb.append("1");
            sb.append(".");
            sb.append(referrer.getTimeStamp());
            sb.append(".");
            sb.append(Integer.valueOf(referrer.getVisit()).toString());
            sb.append(".");
            sb.append(Integer.valueOf(referrer.getIndex()).toString());
            sb.append(".");
            sb.append(referrer.getReferrerString());
            sb.append(";");
        }
        return encode(sb.toString());
    }

    private static String x10Escape(String str) {
        return str.replace("'", "'0").replace(")", "'1").replace("*", "'2").replace("!", "'3");
    }
}

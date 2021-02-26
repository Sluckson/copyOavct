package com.iaai.android.old.utils;

import android.content.Context;
import android.util.Log;
import com.iaai.android.old.models.ToBePickedUpVehicles;

public class EVPPDFUtil {
    private final String offsite = "file:///android_asset/evp/ic_offsite.png";
    private final String vpr1 = "file:///android_asset/evp/vpr_1.png";
    private final String vpr2 = "file:///android_asset/evp/vpr_2.png";

    public EVPPDFUtil(Context context) {
    }

    /* JADX WARNING: Removed duplicated region for block: B:36:0x005a A[SYNTHETIC, Splitter:B:36:0x005a] */
    /* JADX WARNING: Removed duplicated region for block: B:41:0x0062 A[Catch:{ Exception -> 0x005e }] */
    /* JADX WARNING: Removed duplicated region for block: B:43:0x0067 A[Catch:{ Exception -> 0x005e }] */
    /* JADX WARNING: Removed duplicated region for block: B:49:0x0073 A[SYNTHETIC, Splitter:B:49:0x0073] */
    /* JADX WARNING: Removed duplicated region for block: B:54:0x007b A[Catch:{ Exception -> 0x0077 }] */
    /* JADX WARNING: Removed duplicated region for block: B:56:0x0080 A[Catch:{ Exception -> 0x0077 }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.lang.StringBuilder readFromFile(java.lang.String r4, android.content.Context r5) {
        /*
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            r1 = 0
            android.content.res.Resources r5 = r5.getResources()     // Catch:{ Exception -> 0x0052, all -> 0x004e }
            android.content.res.AssetManager r5 = r5.getAssets()     // Catch:{ Exception -> 0x0052, all -> 0x004e }
            r2 = 0
            java.io.InputStream r4 = r5.open(r4, r2)     // Catch:{ Exception -> 0x0052, all -> 0x004e }
            java.io.InputStreamReader r5 = new java.io.InputStreamReader     // Catch:{ Exception -> 0x0048, all -> 0x0045 }
            r5.<init>(r4)     // Catch:{ Exception -> 0x0048, all -> 0x0045 }
            java.io.BufferedReader r2 = new java.io.BufferedReader     // Catch:{ Exception -> 0x003e, all -> 0x003a }
            r2.<init>(r5)     // Catch:{ Exception -> 0x003e, all -> 0x003a }
        L_0x001d:
            java.lang.String r1 = r2.readLine()     // Catch:{ Exception -> 0x0035, all -> 0x0033 }
            if (r1 == 0) goto L_0x0027
            r0.append(r1)     // Catch:{ Exception -> 0x0035, all -> 0x0033 }
            goto L_0x001d
        L_0x0027:
            r5.close()     // Catch:{ Exception -> 0x005e }
            if (r4 == 0) goto L_0x002f
            r4.close()     // Catch:{ Exception -> 0x005e }
        L_0x002f:
            r2.close()     // Catch:{ Exception -> 0x005e }
            goto L_0x006e
        L_0x0033:
            r0 = move-exception
            goto L_0x003c
        L_0x0035:
            r1 = move-exception
            r3 = r5
            r5 = r4
            r4 = r1
            goto L_0x0043
        L_0x003a:
            r0 = move-exception
            r2 = r1
        L_0x003c:
            r1 = r5
            goto L_0x0071
        L_0x003e:
            r2 = move-exception
            r3 = r5
            r5 = r4
            r4 = r2
            r2 = r1
        L_0x0043:
            r1 = r3
            goto L_0x0055
        L_0x0045:
            r0 = move-exception
            r2 = r1
            goto L_0x0071
        L_0x0048:
            r5 = move-exception
            r2 = r1
            r3 = r5
            r5 = r4
            r4 = r3
            goto L_0x0055
        L_0x004e:
            r0 = move-exception
            r4 = r1
            r2 = r4
            goto L_0x0071
        L_0x0052:
            r4 = move-exception
            r5 = r1
            r2 = r5
        L_0x0055:
            r4.printStackTrace()     // Catch:{ all -> 0x006f }
            if (r1 == 0) goto L_0x0060
            r1.close()     // Catch:{ Exception -> 0x005e }
            goto L_0x0060
        L_0x005e:
            r4 = move-exception
            goto L_0x006b
        L_0x0060:
            if (r5 == 0) goto L_0x0065
            r5.close()     // Catch:{ Exception -> 0x005e }
        L_0x0065:
            if (r2 == 0) goto L_0x006e
            r2.close()     // Catch:{ Exception -> 0x005e }
            goto L_0x006e
        L_0x006b:
            r4.printStackTrace()
        L_0x006e:
            return r0
        L_0x006f:
            r0 = move-exception
            r4 = r5
        L_0x0071:
            if (r1 == 0) goto L_0x0079
            r1.close()     // Catch:{ Exception -> 0x0077 }
            goto L_0x0079
        L_0x0077:
            r4 = move-exception
            goto L_0x0084
        L_0x0079:
            if (r4 == 0) goto L_0x007e
            r4.close()     // Catch:{ Exception -> 0x0077 }
        L_0x007e:
            if (r2 == 0) goto L_0x0087
            r2.close()     // Catch:{ Exception -> 0x0077 }
            goto L_0x0087
        L_0x0084:
            r4.printStackTrace()
        L_0x0087:
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.iaai.android.old.utils.EVPPDFUtil.readFromFile(java.lang.String, android.content.Context):java.lang.StringBuilder");
    }

    public static String replaceFromHeaderFile(StringBuilder sb, String str, String str2, String str3) {
        return sb.toString();
    }

    public static String replaceFromBranchFile(StringBuilder sb, String str, String str2, String str3, String str4, String str5, int i, String str6, String str7) {
        int indexOf = sb.indexOf("~vehicleCount~");
        sb.replace(indexOf, indexOf + 14, "" + i);
        int indexOf2 = sb.indexOf("~branchName~");
        sb.replace(indexOf2, indexOf2 + 12, str);
        int indexOf3 = sb.indexOf("~addressLine1~");
        sb.replace(indexOf3, indexOf3 + 14, str2);
        int indexOf4 = sb.indexOf("~addressLine2~");
        sb.replace(indexOf4, indexOf4 + 14, str3);
        int indexOf5 = sb.indexOf("~pinNumber~");
        sb.replace(indexOf5, indexOf5 + 11, str4);
        int indexOf6 = sb.indexOf("~branchNote~");
        sb.replace(indexOf6, indexOf6 + 12, str5);
        int indexOf7 = sb.indexOf("~buyerName~");
        sb.replace(indexOf7, indexOf7 + 11, str6);
        int indexOf8 = sb.indexOf("~buyerTitle~");
        sb.replace(indexOf8, indexOf8 + 12, str7);
        int indexOf9 = sb.indexOf("~header1~");
        sb.replace(indexOf9, indexOf9 + 9, str7);
        return sb.toString();
    }

    public static String replaceFromVehicleFile(StringBuilder sb, ToBePickedUpVehicles toBePickedUpVehicles) {
        int indexOf = sb.indexOf("~imgURL~");
        Log.e("IMAGE URL", toBePickedUpVehicles.imageUrl);
        sb.replace(indexOf, indexOf + 8, "<img src=\"" + toBePickedUpVehicles.imageUrl + "\" class=\"img-responsive\"></img>");
        int indexOf2 = sb.indexOf("~ymm~");
        sb.replace(indexOf2, indexOf2 + 5, toBePickedUpVehicles.yearMakeModel);
        int indexOf3 = sb.indexOf("~vehicleStock~");
        sb.replace(indexOf3, indexOf3 + 14, toBePickedUpVehicles.stockNumber);
        if (toBePickedUpVehicles.offsiteSaleIndicator.equals("true")) {
            int indexOf4 = sb.indexOf("~offsiteStyle~");
            sb.replace(indexOf4, indexOf4 + 14, "");
        } else {
            int indexOf5 = sb.indexOf("~offsiteStyle~");
            sb.replace(indexOf5, indexOf5 + 14, ";display:none");
        }
        if (toBePickedUpVehicles.salvageFeeIndicator.equals("true")) {
            int indexOf6 = sb.indexOf("~feeStyle~");
            sb.replace(indexOf6, indexOf6 + 10, "");
        } else {
            int indexOf7 = sb.indexOf("~feeStyle~");
            sb.replace(indexOf7, indexOf7 + 10, ";display:none");
        }
        return sb.toString();
    }
}

package com.google.firebase.perf.network;

import android.util.Log;
import androidx.annotation.NonNull;
import com.google.android.gms.internal.p010firebaseperf.zzbg;
import org.apache.http.Header;
import org.apache.http.HttpMessage;
import org.apache.http.HttpResponse;

/* compiled from: com.google.firebase:firebase-perf@@19.0.7 */
public final class zzg {
    public static Long zza(@NonNull HttpMessage httpMessage) {
        try {
            Header firstHeader = httpMessage.getFirstHeader("content-length");
            if (firstHeader != null) {
                return Long.valueOf(Long.parseLong(firstHeader.getValue()));
            }
            return null;
        } catch (NumberFormatException unused) {
            Log.d("FirebasePerformance", "The content-length value is not a valid number");
            return null;
        }
    }

    public static String zza(@NonNull HttpResponse httpResponse) {
        String value;
        Header firstHeader = httpResponse.getFirstHeader("content-type");
        if (firstHeader == null || (value = firstHeader.getValue()) == null) {
            return null;
        }
        return value;
    }

    public static void zza(zzbg zzbg) {
        if (!zzbg.zzbh()) {
            zzbg.zzbj();
        }
        zzbg.zzbk();
    }
}

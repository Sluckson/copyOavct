package com.google.android.datatransport.cct;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build;
import androidx.annotation.Nullable;
import com.google.android.datatransport.Encoding;
import com.google.android.datatransport.cct.p007a.zzo;
import com.google.android.datatransport.cct.p007a.zzp;
import com.google.android.datatransport.cct.p007a.zzq;
import com.google.android.datatransport.cct.p007a.zzr;
import com.google.android.datatransport.cct.p007a.zzt;
import com.google.android.datatransport.cct.p007a.zzu;
import com.google.android.datatransport.runtime.EncodedPayload;
import com.google.android.datatransport.runtime.EventInternal;
import com.google.android.datatransport.runtime.backends.BackendRequest;
import com.google.android.datatransport.runtime.backends.BackendResponse;
import com.google.android.datatransport.runtime.backends.TransportBackend;
import com.google.android.datatransport.runtime.logging.Logging;
import com.google.android.datatransport.runtime.retries.Retries;
import com.google.android.datatransport.runtime.time.Clock;
import com.google.firebase.encoders.DataEncoder;
import com.google.firebase.encoders.json.JsonDataEncoderBuilder;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TimeZone;

final class zzc implements TransportBackend {
    private final DataEncoder zza = new JsonDataEncoderBuilder().configureWith(com.google.android.datatransport.cct.p007a.zzb.zza).ignoreNullValues(true).build();
    private final ConnectivityManager zzb;
    final URL zzc;
    private final Clock zzd;
    private final Clock zze;
    private final int zzf;

    static final class zza {
        final URL zza;
        final zzo zzb;
        @Nullable
        final String zzc;

        zza(URL url, zzo zzo, @Nullable String str) {
            this.zza = url;
            this.zzb = zzo;
            this.zzc = str;
        }

        /* access modifiers changed from: package-private */
        public zza zza(URL url) {
            return new zza(url, this.zzb, this.zzc);
        }
    }

    static final class zzb {
        final int zza;
        @Nullable
        final URL zzb;
        final long zzc;

        zzb(int i, @Nullable URL url, long j) {
            this.zza = i;
            this.zzb = url;
            this.zzc = j;
        }
    }

    zzc(Context context, Clock clock, Clock clock2) {
        this.zzb = (ConnectivityManager) context.getSystemService("connectivity");
        this.zzc = zza(CCTDestination.zza);
        this.zzd = clock2;
        this.zze = clock;
        this.zzf = 40000;
    }

    private static URL zza(String str) {
        try {
            return new URL(str);
        } catch (MalformedURLException e) {
            throw new IllegalArgumentException("Invalid url: " + str, e);
        }
    }

    public EventInternal decorate(EventInternal eventInternal) {
        int i;
        int i2;
        NetworkInfo activeNetworkInfo = this.zzb.getActiveNetworkInfo();
        EventInternal.Builder addMetadata = eventInternal.toBuilder().addMetadata("sdk-version", Build.VERSION.SDK_INT).addMetadata("model", Build.MODEL).addMetadata("hardware", Build.HARDWARE).addMetadata("device", Build.DEVICE).addMetadata("product", Build.PRODUCT).addMetadata("os-uild", Build.ID).addMetadata("manufacturer", Build.MANUFACTURER).addMetadata("fingerprint", Build.FINGERPRINT);
        Calendar.getInstance();
        EventInternal.Builder addMetadata2 = addMetadata.addMetadata("tz-offset", (long) (TimeZone.getDefault().getOffset(Calendar.getInstance().getTimeInMillis()) / 1000));
        if (activeNetworkInfo == null) {
            i = zzt.zzc.NONE.zza();
        } else {
            i = activeNetworkInfo.getType();
        }
        EventInternal.Builder addMetadata3 = addMetadata2.addMetadata("net-type", i);
        if (activeNetworkInfo == null) {
            i2 = zzt.zzb.UNKNOWN_MOBILE_SUBTYPE.zza();
        } else {
            i2 = activeNetworkInfo.getSubtype();
            if (i2 == -1) {
                i2 = zzt.zzb.COMBINED.zza();
            } else if (zzt.zzb.zza(i2) == null) {
                i2 = 0;
            }
        }
        return addMetadata3.addMetadata("mobile-subtype", i2).build();
    }

    public BackendResponse send(BackendRequest backendRequest) {
        zzq.zza zza2;
        HashMap hashMap = new HashMap();
        for (EventInternal next : backendRequest.getEvents()) {
            String transportName = next.getTransportName();
            if (!hashMap.containsKey(transportName)) {
                ArrayList arrayList = new ArrayList();
                arrayList.add(next);
                hashMap.put(transportName, arrayList);
            } else {
                ((List) hashMap.get(transportName)).add(next);
            }
        }
        ArrayList arrayList2 = new ArrayList();
        for (Map.Entry entry : hashMap.entrySet()) {
            EventInternal eventInternal = (EventInternal) ((List) entry.getValue()).get(0);
            zzr.zza zza3 = zzr.zza().zza(zzu.DEFAULT).zza(this.zze.getTime()).zzb(this.zzd.getTime()).zza(zzp.zza().zza(zzp.zzb.ANDROID_FIREBASE).zza(com.google.android.datatransport.cct.p007a.zza.zza().zza(Integer.valueOf(eventInternal.getInteger("sdk-version"))).zze(eventInternal.get("model")).zzc(eventInternal.get("hardware")).zza(eventInternal.get("device")).zzg(eventInternal.get("product")).zzf(eventInternal.get("os-uild")).zzd(eventInternal.get("manufacturer")).zzb(eventInternal.get("fingerprint")).zza()).zza());
            try {
                zza3.zza(Integer.parseInt((String) entry.getKey()));
            } catch (NumberFormatException unused) {
                zza3.zzb((String) entry.getKey());
            }
            ArrayList arrayList3 = new ArrayList();
            for (EventInternal eventInternal2 : (List) entry.getValue()) {
                EncodedPayload encodedPayload = eventInternal2.getEncodedPayload();
                Encoding encoding = encodedPayload.getEncoding();
                if (encoding.equals(Encoding.m28of("proto"))) {
                    zza2 = zzq.zza(encodedPayload.getBytes());
                } else if (encoding.equals(Encoding.m28of("json"))) {
                    zza2 = zzq.zza(new String(encodedPayload.getBytes(), Charset.forName("UTF-8")));
                } else {
                    Logging.m36w("CctTransportBackend", "Received event of unsupported encoding %s. Skipping...", encoding);
                }
                zza2.zza(eventInternal2.getEventMillis()).zzb(eventInternal2.getUptimeMillis()).zzc(eventInternal2.getLong("tz-offset")).zza(zzt.zza().zza(zzt.zzc.zza(eventInternal2.getInteger("net-type"))).zza(zzt.zzb.zza(eventInternal2.getInteger("mobile-subtype"))).zza());
                if (eventInternal2.getCode() != null) {
                    zza2.zza(eventInternal2.getCode());
                }
                arrayList3.add(zza2.zza());
            }
            zza3.zza((List<zzq>) arrayList3);
            arrayList2.add(zza3.zza());
        }
        zzo zza4 = zzo.zza(arrayList2);
        String str = null;
        URL url = this.zzc;
        if (backendRequest.getExtras() != null) {
            try {
                CCTDestination fromByteArray = CCTDestination.fromByteArray(backendRequest.getExtras());
                if (fromByteArray.getAPIKey() != null) {
                    str = fromByteArray.getAPIKey();
                }
                if (fromByteArray.getEndPoint() != null) {
                    url = zza(fromByteArray.getEndPoint());
                }
            } catch (IllegalArgumentException unused2) {
                return BackendResponse.fatalError();
            }
        }
        try {
            zzb zzb2 = (zzb) Retries.retry(5, new zza(url, zza4, str), zza.zza(this), zzb.zza());
            if (zzb2.zza == 200) {
                return BackendResponse.m29ok(zzb2.zzc);
            }
            int i = zzb2.zza;
            if (i < 500) {
                if (i != 404) {
                    return BackendResponse.fatalError();
                }
            }
            return BackendResponse.transientError();
        } catch (IOException e) {
            Logging.m34e("CctTransportBackend", "Could not make request to the backend", e);
            return BackendResponse.transientError();
        }
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Missing exception handler attribute for start block: B:43:0x011c */
    /* JADX WARNING: Missing exception handler attribute for start block: B:56:0x0139 */
    /* JADX WARNING: Missing exception handler attribute for start block: B:62:0x0140 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public com.google.android.datatransport.cct.zzc.zzb zza(com.google.android.datatransport.cct.zzc.zza r14) throws java.io.IOException {
        /*
            r13 = this;
            java.net.URL r0 = r14.zza
            java.lang.String r1 = "CctTransportBackend"
            java.lang.String r2 = "Making request to: %s"
            com.google.android.datatransport.runtime.logging.Logging.m31d((java.lang.String) r1, (java.lang.String) r2, (java.lang.Object) r0)
            java.net.URL r0 = r14.zza
            java.net.URLConnection r0 = r0.openConnection()
            java.lang.Object r0 = com.google.firebase.perf.network.FirebasePerfUrlConnection.instrument(r0)
            java.net.URLConnection r0 = (java.net.URLConnection) r0
            java.net.HttpURLConnection r0 = (java.net.HttpURLConnection) r0
            r2 = 30000(0x7530, float:4.2039E-41)
            r0.setConnectTimeout(r2)
            int r2 = r13.zzf
            r0.setReadTimeout(r2)
            r2 = 1
            r0.setDoOutput(r2)
            r3 = 0
            r0.setInstanceFollowRedirects(r3)
            java.lang.String r4 = "POST"
            r0.setRequestMethod(r4)
            java.lang.Object[] r2 = new java.lang.Object[r2]
            java.lang.String r4 = "2.3.1"
            r2[r3] = r4
            java.lang.String r3 = "datatransport/%s android/"
            java.lang.String r2 = java.lang.String.format(r3, r2)
            java.lang.String r3 = "User-Agent"
            r0.setRequestProperty(r3, r2)
            java.lang.String r2 = "gzip"
            java.lang.String r3 = "Content-Encoding"
            r0.setRequestProperty(r3, r2)
            java.lang.String r4 = "Content-Type"
            java.lang.String r5 = "application/json"
            r0.setRequestProperty(r4, r5)
            java.lang.String r5 = "Accept-Encoding"
            r0.setRequestProperty(r5, r2)
            java.lang.String r5 = r14.zzc
            if (r5 == 0) goto L_0x005b
            java.lang.String r6 = "X-Goog-Api-Key"
            r0.setRequestProperty(r6, r5)
        L_0x005b:
            r5 = 0
            r7 = 0
            java.io.OutputStream r8 = r0.getOutputStream()     // Catch:{ ConnectException -> 0x0153, UnknownHostException -> 0x0151, EncodingException -> 0x0143, IOException -> 0x0141 }
            java.util.zip.GZIPOutputStream r9 = new java.util.zip.GZIPOutputStream     // Catch:{ Throwable -> 0x013a }
            r9.<init>(r8)     // Catch:{ Throwable -> 0x013a }
            com.google.firebase.encoders.DataEncoder r10 = r13.zza     // Catch:{ Throwable -> 0x0135 }
            com.google.android.datatransport.cct.a.zzo r14 = r14.zzb     // Catch:{ Throwable -> 0x0135 }
            java.io.BufferedWriter r11 = new java.io.BufferedWriter     // Catch:{ Throwable -> 0x0135 }
            java.io.OutputStreamWriter r12 = new java.io.OutputStreamWriter     // Catch:{ Throwable -> 0x0135 }
            r12.<init>(r9)     // Catch:{ Throwable -> 0x0135 }
            r11.<init>(r12)     // Catch:{ Throwable -> 0x0135 }
            r10.encode(r14, r11)     // Catch:{ Throwable -> 0x0135 }
            r9.close()     // Catch:{ Throwable -> 0x013a }
            if (r8 == 0) goto L_0x0080
            r8.close()     // Catch:{ ConnectException -> 0x0153, UnknownHostException -> 0x0151, EncodingException -> 0x0143, IOException -> 0x0141 }
        L_0x0080:
            int r14 = r0.getResponseCode()
            java.lang.StringBuilder r8 = new java.lang.StringBuilder
            r8.<init>()
            java.lang.String r9 = "Status Code: "
            r8.append(r9)
            r8.append(r14)
            java.lang.String r8 = r8.toString()
            com.google.android.datatransport.runtime.logging.Logging.m35i(r1, r8)
            java.lang.StringBuilder r8 = new java.lang.StringBuilder
            r8.<init>()
            java.lang.String r9 = "Content-Type: "
            r8.append(r9)
            java.lang.String r4 = r0.getHeaderField(r4)
            r8.append(r4)
            java.lang.String r4 = r8.toString()
            com.google.android.datatransport.runtime.logging.Logging.m35i(r1, r4)
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>()
            java.lang.String r8 = "Content-Encoding: "
            r4.append(r8)
            java.lang.String r8 = r0.getHeaderField(r3)
            r4.append(r8)
            java.lang.String r4 = r4.toString()
            com.google.android.datatransport.runtime.logging.Logging.m35i(r1, r4)
            r1 = 302(0x12e, float:4.23E-43)
            if (r14 == r1) goto L_0x0124
            r1 = 301(0x12d, float:4.22E-43)
            if (r14 == r1) goto L_0x0124
            r1 = 307(0x133, float:4.3E-43)
            if (r14 != r1) goto L_0x00d5
            goto L_0x0124
        L_0x00d5:
            r1 = 200(0xc8, float:2.8E-43)
            if (r14 == r1) goto L_0x00df
            com.google.android.datatransport.cct.zzc$zzb r0 = new com.google.android.datatransport.cct.zzc$zzb
            r0.<init>(r14, r7, r5)
            return r0
        L_0x00df:
            java.io.InputStream r1 = r0.getInputStream()
            java.lang.String r0 = r0.getHeaderField(r3)     // Catch:{ Throwable -> 0x011d }
            boolean r0 = r2.equals(r0)     // Catch:{ Throwable -> 0x011d }
            if (r0 == 0) goto L_0x00f3
            java.util.zip.GZIPInputStream r0 = new java.util.zip.GZIPInputStream     // Catch:{ Throwable -> 0x011d }
            r0.<init>(r1)     // Catch:{ Throwable -> 0x011d }
            goto L_0x00f4
        L_0x00f3:
            r0 = r1
        L_0x00f4:
            java.io.BufferedReader r2 = new java.io.BufferedReader     // Catch:{ Throwable -> 0x0116 }
            java.io.InputStreamReader r3 = new java.io.InputStreamReader     // Catch:{ Throwable -> 0x0116 }
            r3.<init>(r0)     // Catch:{ Throwable -> 0x0116 }
            r2.<init>(r3)     // Catch:{ Throwable -> 0x0116 }
            com.google.android.datatransport.cct.a.zzs r2 = com.google.android.datatransport.cct.p007a.zzs.zza(r2)     // Catch:{ Throwable -> 0x0116 }
            long r2 = r2.zza()     // Catch:{ Throwable -> 0x0116 }
            com.google.android.datatransport.cct.zzc$zzb r4 = new com.google.android.datatransport.cct.zzc$zzb     // Catch:{ Throwable -> 0x0116 }
            r4.<init>(r14, r7, r2)     // Catch:{ Throwable -> 0x0116 }
            if (r0 == 0) goto L_0x0110
            r0.close()     // Catch:{ Throwable -> 0x011d }
        L_0x0110:
            if (r1 == 0) goto L_0x0115
            r1.close()
        L_0x0115:
            return r4
        L_0x0116:
            r14 = move-exception
            if (r0 == 0) goto L_0x011c
            r0.close()     // Catch:{ Throwable -> 0x011c }
        L_0x011c:
            throw r14     // Catch:{ Throwable -> 0x011d }
        L_0x011d:
            r14 = move-exception
            if (r1 == 0) goto L_0x0123
            r1.close()     // Catch:{ Throwable -> 0x0123 }
        L_0x0123:
            throw r14
        L_0x0124:
            java.lang.String r1 = "Location"
            java.lang.String r0 = r0.getHeaderField(r1)
            com.google.android.datatransport.cct.zzc$zzb r1 = new com.google.android.datatransport.cct.zzc$zzb
            java.net.URL r2 = new java.net.URL
            r2.<init>(r0)
            r1.<init>(r14, r2, r5)
            return r1
        L_0x0135:
            r14 = move-exception
            r9.close()     // Catch:{ Throwable -> 0x0139 }
        L_0x0139:
            throw r14     // Catch:{ Throwable -> 0x013a }
        L_0x013a:
            r14 = move-exception
            if (r8 == 0) goto L_0x0140
            r8.close()     // Catch:{ Throwable -> 0x0140 }
        L_0x0140:
            throw r14     // Catch:{ ConnectException -> 0x0153, UnknownHostException -> 0x0151, EncodingException -> 0x0143, IOException -> 0x0141 }
        L_0x0141:
            r14 = move-exception
            goto L_0x0144
        L_0x0143:
            r14 = move-exception
        L_0x0144:
            java.lang.String r0 = "Couldn't encode request, returning with 400"
            com.google.android.datatransport.runtime.logging.Logging.m34e(r1, r0, r14)
            com.google.android.datatransport.cct.zzc$zzb r14 = new com.google.android.datatransport.cct.zzc$zzb
            r0 = 400(0x190, float:5.6E-43)
            r14.<init>(r0, r7, r5)
            return r14
        L_0x0151:
            r14 = move-exception
            goto L_0x0154
        L_0x0153:
            r14 = move-exception
        L_0x0154:
            java.lang.String r0 = "Couldn't open connection, returning with 500"
            com.google.android.datatransport.runtime.logging.Logging.m34e(r1, r0, r14)
            com.google.android.datatransport.cct.zzc$zzb r14 = new com.google.android.datatransport.cct.zzc$zzb
            r0 = 500(0x1f4, float:7.0E-43)
            r14.<init>(r0, r7, r5)
            return r14
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.datatransport.cct.zzc.zza(com.google.android.datatransport.cct.zzc$zza):com.google.android.datatransport.cct.zzc$zzb");
    }

    static /* synthetic */ zza zza(zza zza2, zzb zzb2) {
        URL url = zzb2.zzb;
        if (url == null) {
            return null;
        }
        Logging.m31d("CctTransportBackend", "Following redirect to: %s", (Object) url);
        return zza2.zza(zzb2.zzb);
    }
}

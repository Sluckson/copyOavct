package com.medallia.digital.mobilesdk;

import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;

/* renamed from: com.medallia.digital.mobilesdk.y5 */
class C3802y5 {

    /* renamed from: a */
    static final int f2065a = 1024;

    C3802y5() {
    }

    /* renamed from: a */
    static ByteArrayOutputStream m1953a(InputStream inputStream) {
        byte[] bArr = new byte[1024];
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        while (true) {
            int read = inputStream.read(bArr);
            if (read == -1) {
                return byteArrayOutputStream;
            }
            byteArrayOutputStream.write(bArr, 0, read);
        }
    }

    /* renamed from: a */
    static boolean m1954a() {
        try {
            ConnectivityManager connectivityManager = (ConnectivityManager) C3595k3.m1060d().mo55513b().getSystemService("connectivity");
            if (connectivityManager == null) {
                return true;
            }
            NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
            return activeNetworkInfo != null && activeNetworkInfo.isConnectedOrConnecting();
        } catch (Exception e) {
            C3490e3.m663c(e.getMessage());
            return true;
        }
    }
}

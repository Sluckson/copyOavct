package lib.android.paypal.com.magnessdk.p058a;

import android.os.Environment;
import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import lib.android.paypal.com.magnessdk.C4825c;

/* renamed from: lib.android.paypal.com.magnessdk.a.a */
public class C4819a {

    /* renamed from: a */
    private static final int f5517a = 1024;

    /* renamed from: b */
    private boolean f5518b = false;

    /* renamed from: c */
    private boolean f5519c = false;

    /* renamed from: d */
    private File f5520d;

    public C4819a() {
        m4643a();
        this.f5520d = Environment.getExternalStorageDirectory();
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x002c  */
    /* JADX WARNING: Removed duplicated region for block: B:15:0x0038  */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void m4643a() {
        /*
            r5 = this;
            java.lang.String r0 = android.os.Environment.getExternalStorageState()
            int r1 = r0.hashCode()
            r2 = 1242932856(0x4a15a678, float:2451870.0)
            r3 = 0
            r4 = 1
            if (r1 == r2) goto L_0x001f
            r2 = 1299749220(0x4d789964, float:2.60675136E8)
            if (r1 == r2) goto L_0x0015
            goto L_0x0029
        L_0x0015:
            java.lang.String r1 = "mounted_ro"
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto L_0x0029
            r0 = 1
            goto L_0x002a
        L_0x001f:
            java.lang.String r1 = "mounted"
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto L_0x0029
            r0 = 0
            goto L_0x002a
        L_0x0029:
            r0 = -1
        L_0x002a:
            if (r0 == 0) goto L_0x0038
            if (r0 == r4) goto L_0x0033
            r5.f5519c = r3
            r5.f5518b = r3
            goto L_0x003c
        L_0x0033:
            r5.f5518b = r4
            r5.f5519c = r3
            goto L_0x003c
        L_0x0038:
            r5.f5519c = r4
            r5.f5518b = r4
        L_0x003c:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: lib.android.paypal.com.magnessdk.p058a.C4819a.m4643a():void");
    }

    /* renamed from: a */
    public void mo68908a(String str) {
        this.f5520d = new File(str);
    }

    /* renamed from: a */
    public void mo68909a(String str, byte[] bArr) {
        FileOutputStream fileOutputStream;
        if (this.f5518b && this.f5519c) {
            FileOutputStream fileOutputStream2 = null;
            try {
                if (!this.f5520d.mkdirs()) {
                    if (!this.f5520d.isDirectory()) {
                        fileOutputStream = null;
                        C4825c.m4658a(getClass(), (Closeable) fileOutputStream);
                    }
                }
                fileOutputStream = new FileOutputStream(new File(this.f5520d, str));
                try {
                    fileOutputStream.write(bArr);
                    C4825c.m4658a(getClass(), (Closeable) fileOutputStream);
                } catch (Throwable th) {
                    fileOutputStream2 = fileOutputStream;
                    th = th;
                    C4825c.m4658a(getClass(), (Closeable) fileOutputStream2);
                    throw th;
                }
            } catch (Throwable th2) {
                th = th2;
                C4825c.m4658a(getClass(), (Closeable) fileOutputStream2);
                throw th;
            }
        }
    }

    /* renamed from: b */
    public String mo68910b(String str) {
        FileInputStream fileInputStream;
        byte[] bArr = new byte[1024];
        String str2 = null;
        if (this.f5519c) {
            try {
                fileInputStream = new FileInputStream(new File(this.f5520d, str));
                try {
                    ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                    for (int read = fileInputStream.read(bArr, 0, 1024); read != -1; read = fileInputStream.read(bArr, 0, 1024)) {
                        byteArrayOutputStream.write(bArr, 0, read);
                    }
                    str2 = new String(byteArrayOutputStream.toByteArray(), "UTF-8");
                    C4825c.m4658a(getClass(), (Closeable) fileInputStream);
                } catch (Throwable th) {
                    th = th;
                    C4825c.m4658a(getClass(), (Closeable) fileInputStream);
                    throw th;
                }
            } catch (Throwable th2) {
                th = th2;
                fileInputStream = null;
                C4825c.m4658a(getClass(), (Closeable) fileInputStream);
                throw th;
            }
        }
        return str2;
    }

    /* renamed from: c */
    public boolean mo68911c(String str) {
        return new File(this.f5520d, str).delete();
    }
}

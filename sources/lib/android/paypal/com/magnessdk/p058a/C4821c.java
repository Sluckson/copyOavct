package lib.android.paypal.com.magnessdk.p058a;

import java.io.Closeable;
import java.io.File;
import java.io.FileOutputStream;
import java.io.RandomAccessFile;
import lib.android.paypal.com.magnessdk.C4825c;
import lib.android.paypal.com.magnessdk.p059b.C4823a;

/* renamed from: lib.android.paypal.com.magnessdk.a.c */
public final class C4821c {
    private C4821c() {
    }

    /* renamed from: a */
    public static String m4648a(File file) {
        RandomAccessFile randomAccessFile = null;
        try {
            RandomAccessFile randomAccessFile2 = new RandomAccessFile(file, "r");
            try {
                byte[] bArr = new byte[((int) randomAccessFile2.length())];
                randomAccessFile2.readFully(bArr);
                String str = new String(bArr, "UTF-8");
                C4825c.m4658a((Class<?>) C4821c.class, (Closeable) randomAccessFile2);
                return str;
            } catch (Exception e) {
                e = e;
                randomAccessFile = randomAccessFile2;
                try {
                    C4823a.m4654a((Class<?>) C4821c.class, 3, (Throwable) e);
                    C4825c.m4658a((Class<?>) C4821c.class, (Closeable) randomAccessFile);
                    return "";
                } catch (Throwable th) {
                    th = th;
                    randomAccessFile2 = randomAccessFile;
                    C4825c.m4658a((Class<?>) C4821c.class, (Closeable) randomAccessFile2);
                    throw th;
                }
            } catch (Throwable th2) {
                th = th2;
                C4825c.m4658a((Class<?>) C4821c.class, (Closeable) randomAccessFile2);
                throw th;
            }
        } catch (Exception e2) {
            e = e2;
            C4823a.m4654a((Class<?>) C4821c.class, 3, (Throwable) e);
            C4825c.m4658a((Class<?>) C4821c.class, (Closeable) randomAccessFile);
            return "";
        }
    }

    /* renamed from: a */
    public static boolean m4649a(File file, String str) {
        FileOutputStream fileOutputStream = null;
        try {
            FileOutputStream fileOutputStream2 = new FileOutputStream(file);
            try {
                fileOutputStream2.write(str.getBytes("UTF-8"));
                C4825c.m4658a((Class<?>) C4821c.class, (Closeable) fileOutputStream2);
                return true;
            } catch (Exception e) {
                e = e;
                fileOutputStream = fileOutputStream2;
                try {
                    C4823a.m4654a((Class<?>) C4821c.class, 3, (Throwable) e);
                    C4825c.m4658a((Class<?>) C4821c.class, (Closeable) fileOutputStream);
                    return false;
                } catch (Throwable th) {
                    th = th;
                    C4825c.m4658a((Class<?>) C4821c.class, (Closeable) fileOutputStream);
                    throw th;
                }
            } catch (Throwable th2) {
                th = th2;
                fileOutputStream = fileOutputStream2;
                C4825c.m4658a((Class<?>) C4821c.class, (Closeable) fileOutputStream);
                throw th;
            }
        } catch (Exception e2) {
            e = e2;
            C4823a.m4654a((Class<?>) C4821c.class, 3, (Throwable) e);
            C4825c.m4658a((Class<?>) C4821c.class, (Closeable) fileOutputStream);
            return false;
        }
    }

    /* renamed from: b */
    public static boolean m4650b(File file) {
        try {
            if (file.exists()) {
                C4823a.m4653a((Class<?>) C4821c.class, 0, "deleting CachedConfigDataFromDisk");
                return file.delete();
            }
        } catch (Exception e) {
            C4823a.m4654a((Class<?>) C4821c.class, 3, (Throwable) e);
        }
        return false;
    }
}

package com.lowagie.text.pdf;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.lang.reflect.Method;
import java.nio.BufferUnderflowException;
import java.nio.ByteBuffer;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.security.AccessController;
import java.security.PrivilegedAction;

public class MappedRandomAccessFile {
    private FileChannel channel = null;
    private MappedByteBuffer mappedByteBuffer = null;

    public MappedRandomAccessFile(String str, String str2) throws FileNotFoundException, IOException {
        if (str2.equals("rw")) {
            init(new RandomAccessFile(str, str2).getChannel(), FileChannel.MapMode.READ_WRITE);
        } else {
            init(new FileInputStream(str).getChannel(), FileChannel.MapMode.READ_ONLY);
        }
    }

    private void init(FileChannel fileChannel, FileChannel.MapMode mapMode) throws IOException {
        this.channel = fileChannel;
        this.mappedByteBuffer = fileChannel.map(mapMode, 0, fileChannel.size());
        this.mappedByteBuffer.load();
    }

    public FileChannel getChannel() {
        return this.channel;
    }

    public int read() {
        try {
            return this.mappedByteBuffer.get() & 255;
        } catch (BufferUnderflowException unused) {
            return -1;
        }
    }

    public int read(byte[] bArr, int i, int i2) {
        int position = this.mappedByteBuffer.position();
        int limit = this.mappedByteBuffer.limit();
        if (position == limit) {
            return -1;
        }
        if ((position + i2) - i > limit) {
            i2 = limit - position;
        }
        this.mappedByteBuffer.get(bArr, i, i2);
        return i2;
    }

    public long getFilePointer() {
        return (long) this.mappedByteBuffer.position();
    }

    public void seek(long j) {
        this.mappedByteBuffer.position((int) j);
    }

    public long length() {
        return (long) this.mappedByteBuffer.limit();
    }

    public void close() throws IOException {
        clean(this.mappedByteBuffer);
        this.mappedByteBuffer = null;
        FileChannel fileChannel = this.channel;
        if (fileChannel != null) {
            fileChannel.close();
        }
        this.channel = null;
    }

    /* access modifiers changed from: protected */
    public void finalize() throws Throwable {
        close();
        super.finalize();
    }

    public static boolean clean(final ByteBuffer byteBuffer) {
        if (byteBuffer == null || !byteBuffer.isDirect()) {
            return false;
        }
        return ((Boolean) AccessController.doPrivileged(new PrivilegedAction() {
            public Object run() {
                Boolean bool = Boolean.FALSE;
                try {
                    Method method = byteBuffer.getClass().getMethod("cleaner", (Class[]) null);
                    method.setAccessible(true);
                    Object invoke = method.invoke(byteBuffer, (Object[]) null);
                    invoke.getClass().getMethod("clean", (Class[]) null).invoke(invoke, (Object[]) null);
                    return Boolean.TRUE;
                } catch (Exception unused) {
                    return bool;
                }
            }
        })).booleanValue();
    }
}

package com.google.android.exoplayer2.upstream.cache;

import android.net.Uri;
import android.util.Pair;
import androidx.annotation.Nullable;
import com.google.android.exoplayer2.upstream.DataSource;
import com.google.android.exoplayer2.upstream.DataSourceException;
import com.google.android.exoplayer2.upstream.DataSpec;
import com.google.android.exoplayer2.upstream.cache.Cache;
import com.google.android.exoplayer2.upstream.cache.ContentMetadata;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.PriorityTaskManager;
import java.io.EOFException;
import java.io.IOException;
import java.util.concurrent.atomic.AtomicBoolean;

public final class CacheUtil {
    public static final int DEFAULT_BUFFER_SIZE_BYTES = 131072;
    public static final CacheKeyFactory DEFAULT_CACHE_KEY_FACTORY = $$Lambda$CacheUtil$uQzD0N2Max0h6DuMDYcCbN2peIo.INSTANCE;

    public interface ProgressListener {
        void onProgress(long j, long j2, long j3);
    }

    static /* synthetic */ String lambda$static$0(DataSpec dataSpec) {
        return dataSpec.key != null ? dataSpec.key : generateKey(dataSpec.uri);
    }

    public static String generateKey(Uri uri) {
        return uri.toString();
    }

    public static Pair<Long, Long> getCached(DataSpec dataSpec, Cache cache, @Nullable CacheKeyFactory cacheKeyFactory) {
        DataSpec dataSpec2 = dataSpec;
        String buildCacheKey = buildCacheKey(dataSpec2, cacheKeyFactory);
        long j = dataSpec2.absoluteStreamPosition;
        long requestLength = getRequestLength(dataSpec2, cache, buildCacheKey);
        long j2 = j;
        long j3 = requestLength;
        long j4 = 0;
        while (j3 != 0) {
            int i = (j3 > -1 ? 1 : (j3 == -1 ? 0 : -1));
            long cachedLength = cache.getCachedLength(buildCacheKey, j2, i != 0 ? j3 : Long.MAX_VALUE);
            if (cachedLength <= 0) {
                cachedLength = -cachedLength;
                if (cachedLength == Long.MAX_VALUE) {
                    break;
                }
            } else {
                j4 += cachedLength;
            }
            j2 += cachedLength;
            if (i == 0) {
                cachedLength = 0;
            }
            j3 -= cachedLength;
        }
        return Pair.create(Long.valueOf(requestLength), Long.valueOf(j4));
    }

    public static void cache(DataSpec dataSpec, Cache cache, @Nullable CacheKeyFactory cacheKeyFactory, DataSource dataSource, @Nullable ProgressListener progressListener, @Nullable AtomicBoolean atomicBoolean) throws IOException, InterruptedException {
        cache(dataSpec, cache, cacheKeyFactory, new CacheDataSource(cache, dataSource), new byte[131072], (PriorityTaskManager) null, 0, progressListener, atomicBoolean, false);
    }

    public static void cache(DataSpec dataSpec, Cache cache, @Nullable CacheKeyFactory cacheKeyFactory, CacheDataSource cacheDataSource, byte[] bArr, PriorityTaskManager priorityTaskManager, int i, @Nullable ProgressListener progressListener, @Nullable AtomicBoolean atomicBoolean, boolean z) throws IOException, InterruptedException {
        ProgressNotifier progressNotifier;
        long j;
        long j2;
        DataSpec dataSpec2 = dataSpec;
        ProgressListener progressListener2 = progressListener;
        Assertions.checkNotNull(cacheDataSource);
        Assertions.checkNotNull(bArr);
        String buildCacheKey = buildCacheKey(dataSpec2, cacheKeyFactory);
        if (progressListener2 != null) {
            progressNotifier = new ProgressNotifier(progressListener2);
            Pair<Long, Long> cached = getCached(dataSpec, cache, cacheKeyFactory);
            progressNotifier.init(((Long) cached.first).longValue(), ((Long) cached.second).longValue());
            j = ((Long) cached.first).longValue();
            Cache cache2 = cache;
        } else {
            j = getRequestLength(dataSpec2, cache, buildCacheKey);
            progressNotifier = null;
        }
        ProgressNotifier progressNotifier2 = progressNotifier;
        long j3 = dataSpec2.absoluteStreamPosition;
        boolean z2 = j == -1;
        long j4 = j;
        long j5 = j3;
        while (j4 != 0) {
            throwExceptionIfInterruptedOrCancelled(atomicBoolean);
            long cachedLength = cache.getCachedLength(buildCacheKey, j5, z2 ? Long.MAX_VALUE : j4);
            if (cachedLength > 0) {
                j2 = cachedLength;
            } else {
                long j6 = -cachedLength;
                long j7 = j6 == Long.MAX_VALUE ? -1 : j6;
                j2 = j6;
                if (readAndDiscard(dataSpec, j5, j7, cacheDataSource, bArr, priorityTaskManager, i, progressNotifier2, j7 == j4, atomicBoolean) < j2) {
                    if (z && !z2) {
                        throw new EOFException();
                    }
                    return;
                }
            }
            j5 += j2;
            if (!z2) {
                j4 -= j2;
            }
        }
    }

    private static long getRequestLength(DataSpec dataSpec, Cache cache, String str) {
        if (dataSpec.length != -1) {
            return dataSpec.length;
        }
        long contentLength = ContentMetadata.CC.getContentLength(cache.getContentMetadata(str));
        if (contentLength == -1) {
            return -1;
        }
        return contentLength - dataSpec.absoluteStreamPosition;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:22:0x0042, code lost:
        r13 = r7;
        r0 = false;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static long readAndDiscard(com.google.android.exoplayer2.upstream.DataSpec r15, long r16, long r18, com.google.android.exoplayer2.upstream.DataSource r20, byte[] r21, com.google.android.exoplayer2.util.PriorityTaskManager r22, int r23, @androidx.annotation.Nullable com.google.android.exoplayer2.upstream.cache.CacheUtil.ProgressNotifier r24, boolean r25, java.util.concurrent.atomic.AtomicBoolean r26) throws java.io.IOException, java.lang.InterruptedException {
        /*
            r1 = r15
            r2 = r20
            r3 = r21
            r4 = r24
            long r5 = r1.absoluteStreamPosition
            long r5 = r16 - r5
            r7 = -1
            int r0 = (r18 > r7 ? 1 : (r18 == r7 ? 0 : -1))
            if (r0 == 0) goto L_0x0014
            long r9 = r5 + r18
            goto L_0x0015
        L_0x0014:
            r9 = r7
        L_0x0015:
            r11 = r5
        L_0x0016:
            if (r22 == 0) goto L_0x001b
            r22.proceed(r23)
        L_0x001b:
            throwExceptionIfInterruptedOrCancelled(r26)
            int r14 = (r9 > r7 ? 1 : (r9 == r7 ? 0 : -1))
            if (r14 == 0) goto L_0x0040
            r17 = r14
            long r13 = r9 - r11
            com.google.android.exoplayer2.upstream.DataSpec r0 = r15.subrange(r11, r13)     // Catch:{ IOException -> 0x0032 }
            long r13 = r2.open(r0)     // Catch:{ IOException -> 0x0032 }
            r0 = 1
            goto L_0x0044
        L_0x0030:
            r0 = move-exception
            goto L_0x0086
        L_0x0032:
            r0 = move-exception
            if (r25 == 0) goto L_0x003f
            boolean r13 = isCausedByPositionOutOfRange(r0)     // Catch:{ PriorityTooLowException -> 0x008a, all -> 0x0030 }
            if (r13 == 0) goto L_0x003f
            com.google.android.exoplayer2.util.Util.closeQuietly((com.google.android.exoplayer2.upstream.DataSource) r20)     // Catch:{ PriorityTooLowException -> 0x008a, all -> 0x0030 }
            goto L_0x0042
        L_0x003f:
            throw r0     // Catch:{ PriorityTooLowException -> 0x008a, all -> 0x0030 }
        L_0x0040:
            r17 = r14
        L_0x0042:
            r13 = r7
            r0 = 0
        L_0x0044:
            if (r0 != 0) goto L_0x004e
            com.google.android.exoplayer2.upstream.DataSpec r0 = r15.subrange(r11, r7)     // Catch:{ PriorityTooLowException -> 0x008a, all -> 0x0030 }
            long r13 = r2.open(r0)     // Catch:{ PriorityTooLowException -> 0x008a, all -> 0x0030 }
        L_0x004e:
            if (r25 == 0) goto L_0x005a
            if (r4 == 0) goto L_0x005a
            int r0 = (r13 > r7 ? 1 : (r13 == r7 ? 0 : -1))
            if (r0 == 0) goto L_0x005a
            long r13 = r13 + r11
            r4.onRequestLengthResolved(r13)     // Catch:{ PriorityTooLowException -> 0x008a, all -> 0x0030 }
        L_0x005a:
            int r0 = (r11 > r9 ? 1 : (r11 == r9 ? 0 : -1))
            if (r0 == 0) goto L_0x0090
            throwExceptionIfInterruptedOrCancelled(r26)     // Catch:{ PriorityTooLowException -> 0x008a, all -> 0x0030 }
            if (r17 == 0) goto L_0x006d
            int r0 = r3.length     // Catch:{ PriorityTooLowException -> 0x008a, all -> 0x0030 }
            long r13 = (long) r0     // Catch:{ PriorityTooLowException -> 0x008a, all -> 0x0030 }
            long r7 = r9 - r11
            long r7 = java.lang.Math.min(r13, r7)     // Catch:{ PriorityTooLowException -> 0x008a, all -> 0x0030 }
            int r0 = (int) r7     // Catch:{ PriorityTooLowException -> 0x008a, all -> 0x0030 }
            goto L_0x006e
        L_0x006d:
            int r0 = r3.length     // Catch:{ PriorityTooLowException -> 0x008a, all -> 0x0030 }
        L_0x006e:
            r7 = 0
            int r0 = r2.read(r3, r7, r0)     // Catch:{ PriorityTooLowException -> 0x008a, all -> 0x0030 }
            r8 = -1
            if (r0 != r8) goto L_0x007c
            if (r4 == 0) goto L_0x0090
            r4.onRequestLengthResolved(r11)     // Catch:{ PriorityTooLowException -> 0x008a, all -> 0x0030 }
            goto L_0x0090
        L_0x007c:
            long r13 = (long) r0     // Catch:{ PriorityTooLowException -> 0x008a, all -> 0x0030 }
            long r11 = r11 + r13
            if (r4 == 0) goto L_0x0083
            r4.onBytesCached(r13)     // Catch:{ PriorityTooLowException -> 0x008a, all -> 0x0030 }
        L_0x0083:
            r7 = -1
            goto L_0x005a
        L_0x0086:
            com.google.android.exoplayer2.util.Util.closeQuietly((com.google.android.exoplayer2.upstream.DataSource) r20)
            throw r0
        L_0x008a:
            com.google.android.exoplayer2.util.Util.closeQuietly((com.google.android.exoplayer2.upstream.DataSource) r20)
            r7 = -1
            goto L_0x0016
        L_0x0090:
            long r11 = r11 - r5
            com.google.android.exoplayer2.util.Util.closeQuietly((com.google.android.exoplayer2.upstream.DataSource) r20)
            return r11
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.upstream.cache.CacheUtil.readAndDiscard(com.google.android.exoplayer2.upstream.DataSpec, long, long, com.google.android.exoplayer2.upstream.DataSource, byte[], com.google.android.exoplayer2.util.PriorityTaskManager, int, com.google.android.exoplayer2.upstream.cache.CacheUtil$ProgressNotifier, boolean, java.util.concurrent.atomic.AtomicBoolean):long");
    }

    public static void remove(DataSpec dataSpec, Cache cache, @Nullable CacheKeyFactory cacheKeyFactory) {
        remove(cache, buildCacheKey(dataSpec, cacheKeyFactory));
    }

    public static void remove(Cache cache, String str) {
        for (CacheSpan removeSpan : cache.getCachedSpans(str)) {
            try {
                cache.removeSpan(removeSpan);
            } catch (Cache.CacheException unused) {
            }
        }
    }

    static boolean isCausedByPositionOutOfRange(IOException iOException) {
        Throwable th;
        while (th != null) {
            if ((th instanceof DataSourceException) && ((DataSourceException) th).reason == 0) {
                return true;
            }
            Throwable cause = th.getCause();
            th = iOException;
            th = cause;
        }
        return false;
    }

    private static String buildCacheKey(DataSpec dataSpec, @Nullable CacheKeyFactory cacheKeyFactory) {
        if (cacheKeyFactory == null) {
            cacheKeyFactory = DEFAULT_CACHE_KEY_FACTORY;
        }
        return cacheKeyFactory.buildCacheKey(dataSpec);
    }

    private static void throwExceptionIfInterruptedOrCancelled(AtomicBoolean atomicBoolean) throws InterruptedException {
        if (Thread.interrupted() || (atomicBoolean != null && atomicBoolean.get())) {
            throw new InterruptedException();
        }
    }

    private CacheUtil() {
    }

    private static final class ProgressNotifier {
        private long bytesCached;
        private final ProgressListener listener;
        private long requestLength;

        public ProgressNotifier(ProgressListener progressListener) {
            this.listener = progressListener;
        }

        public void init(long j, long j2) {
            this.requestLength = j;
            this.bytesCached = j2;
            this.listener.onProgress(j, j2, 0);
        }

        public void onRequestLengthResolved(long j) {
            if (this.requestLength == -1 && j != -1) {
                this.requestLength = j;
                this.listener.onProgress(j, this.bytesCached, 0);
            }
        }

        public void onBytesCached(long j) {
            this.bytesCached += j;
            this.listener.onProgress(this.requestLength, this.bytesCached, j);
        }
    }
}

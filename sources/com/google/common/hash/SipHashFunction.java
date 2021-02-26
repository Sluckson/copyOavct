package com.google.common.hash;

import com.google.common.base.Preconditions;
import com.google.errorprone.annotations.Immutable;
import java.io.Serializable;
import java.nio.ByteBuffer;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

@Immutable
final class SipHashFunction extends AbstractHashFunction implements Serializable {
    static final HashFunction SIP_HASH_24 = new SipHashFunction(2, 4, 506097522914230528L, 1084818905618843912L);
    private static final long serialVersionUID = 0;

    /* renamed from: c */
    private final int f315c;

    /* renamed from: d */
    private final int f316d;

    /* renamed from: k0 */
    private final long f317k0;

    /* renamed from: k1 */
    private final long f318k1;

    public int bits() {
        return 64;
    }

    SipHashFunction(int i, int i2, long j, long j2) {
        boolean z = true;
        Preconditions.checkArgument(i > 0, "The number of SipRound iterations (c=%s) during Compression must be positive.", i);
        Preconditions.checkArgument(i2 <= 0 ? false : z, "The number of SipRound iterations (d=%s) during Finalization must be positive.", i2);
        this.f315c = i;
        this.f316d = i2;
        this.f317k0 = j;
        this.f318k1 = j2;
    }

    public Hasher newHasher() {
        return new SipHasher(this.f315c, this.f316d, this.f317k0, this.f318k1);
    }

    public String toString() {
        return "Hashing.sipHash" + this.f315c + "" + this.f316d + "(" + this.f317k0 + ", " + this.f318k1 + ")";
    }

    public boolean equals(@NullableDecl Object obj) {
        if (!(obj instanceof SipHashFunction)) {
            return false;
        }
        SipHashFunction sipHashFunction = (SipHashFunction) obj;
        if (this.f315c == sipHashFunction.f315c && this.f316d == sipHashFunction.f316d && this.f317k0 == sipHashFunction.f317k0 && this.f318k1 == sipHashFunction.f318k1) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return (int) ((((long) ((getClass().hashCode() ^ this.f315c) ^ this.f316d)) ^ this.f317k0) ^ this.f318k1);
    }

    private static final class SipHasher extends AbstractStreamingHasher {
        private static final int CHUNK_SIZE = 8;

        /* renamed from: b */
        private long f319b = 0;

        /* renamed from: c */
        private final int f320c;

        /* renamed from: d */
        private final int f321d;
        private long finalM = 0;

        /* renamed from: v0 */
        private long f322v0 = 8317987319222330741L;

        /* renamed from: v1 */
        private long f323v1 = 7237128888997146477L;

        /* renamed from: v2 */
        private long f324v2 = 7816392313619706465L;

        /* renamed from: v3 */
        private long f325v3 = 8387220255154660723L;

        SipHasher(int i, int i2, long j, long j2) {
            super(8);
            this.f320c = i;
            this.f321d = i2;
            this.f322v0 ^= j;
            this.f323v1 ^= j2;
            this.f324v2 ^= j;
            this.f325v3 ^= j2;
        }

        /* access modifiers changed from: protected */
        public void process(ByteBuffer byteBuffer) {
            this.f319b += 8;
            processM(byteBuffer.getLong());
        }

        /* access modifiers changed from: protected */
        public void processRemaining(ByteBuffer byteBuffer) {
            this.f319b += (long) byteBuffer.remaining();
            int i = 0;
            while (byteBuffer.hasRemaining()) {
                this.finalM ^= (((long) byteBuffer.get()) & 255) << i;
                i += 8;
            }
        }

        public HashCode makeHash() {
            this.finalM ^= this.f319b << 56;
            processM(this.finalM);
            this.f324v2 ^= 255;
            sipRound(this.f321d);
            return HashCode.fromLong(((this.f322v0 ^ this.f323v1) ^ this.f324v2) ^ this.f325v3);
        }

        private void processM(long j) {
            this.f325v3 ^= j;
            sipRound(this.f320c);
            this.f322v0 = j ^ this.f322v0;
        }

        private void sipRound(int i) {
            for (int i2 = 0; i2 < i; i2++) {
                long j = this.f322v0;
                long j2 = this.f323v1;
                this.f322v0 = j + j2;
                this.f324v2 += this.f325v3;
                this.f323v1 = Long.rotateLeft(j2, 13);
                this.f325v3 = Long.rotateLeft(this.f325v3, 16);
                long j3 = this.f323v1;
                long j4 = this.f322v0;
                this.f323v1 = j3 ^ j4;
                this.f325v3 ^= this.f324v2;
                this.f322v0 = Long.rotateLeft(j4, 32);
                long j5 = this.f324v2;
                long j6 = this.f323v1;
                this.f324v2 = j5 + j6;
                this.f322v0 += this.f325v3;
                this.f323v1 = Long.rotateLeft(j6, 17);
                this.f325v3 = Long.rotateLeft(this.f325v3, 21);
                long j7 = this.f323v1;
                long j8 = this.f324v2;
                this.f323v1 = j7 ^ j8;
                this.f325v3 ^= this.f322v0;
                this.f324v2 = Long.rotateLeft(j8, 32);
            }
        }
    }
}

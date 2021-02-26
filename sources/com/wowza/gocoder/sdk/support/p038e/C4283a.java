package com.wowza.gocoder.sdk.support.p038e;

import java.util.concurrent.ConcurrentLinkedQueue;

/* renamed from: com.wowza.gocoder.sdk.support.e.a */
/* compiled from: GoCoderSDK */
public class C4283a {

    /* renamed from: a */
    private static final String f4151a = "a";

    /* renamed from: b */
    private ConcurrentLinkedQueue<C4284a> f4152b = new ConcurrentLinkedQueue<>();

    /* renamed from: c */
    private long f4153c = 0;

    /* renamed from: d */
    private long f4154d = 0;

    /* renamed from: e */
    private long f4155e = 0;

    /* renamed from: com.wowza.gocoder.sdk.support.e.a$a */
    /* compiled from: GoCoderSDK */
    static class C4284a {

        /* renamed from: a */
        public static final int f4156a = 1;

        /* renamed from: b */
        public static final int f4157b = 2;

        /* renamed from: c */
        public static final int f4158c = 3;

        /* renamed from: d */
        public static final int f4159d = 4;

        /* renamed from: e */
        public static final int f4160e = 5;

        /* renamed from: f */
        public static final int f4161f = 6;

        /* renamed from: g */
        private int f4162g;

        /* renamed from: h */
        private long f4163h;

        /* renamed from: i */
        private byte[] f4164i;

        /* renamed from: j */
        private long f4165j;

        C4284a(int i, long j, byte[] bArr, long j2) {
            this.f4162g = i;
            this.f4163h = j;
            this.f4164i = (byte[]) bArr.clone();
            this.f4165j = j2;
        }

        /* renamed from: a */
        public int mo59103a() {
            return this.f4162g;
        }

        /* renamed from: b */
        public long mo59104b() {
            return this.f4163h;
        }

        /* renamed from: c */
        public long mo59105c() {
            return this.f4165j;
        }

        /* access modifiers changed from: package-private */
        /* renamed from: d */
        public byte[] mo59106d() {
            return this.f4164i;
        }
    }

    /* renamed from: a */
    public long mo59094a() {
        return this.f4154d;
    }

    /* renamed from: b */
    public long mo59096b() {
        return this.f4153c;
    }

    /* renamed from: a */
    public void mo59095a(int i, long j, byte[] bArr, long j2) {
        if (this.f4152b.isEmpty()) {
            this.f4153c = j;
        }
        this.f4154d = j;
        this.f4155e += (long) bArr.length;
        this.f4152b.add(new C4284a(i, j, bArr, j2));
    }

    /* renamed from: c */
    public C4284a mo59097c() {
        C4284a poll = this.f4152b.size() > 0 ? this.f4152b.poll() : null;
        if (poll != null) {
            this.f4155e -= (long) poll.mo59106d().length;
        }
        if (!this.f4152b.isEmpty()) {
            this.f4153c = this.f4152b.peek().mo59104b();
        } else {
            this.f4154d = 0;
            this.f4153c = 0;
        }
        return poll;
    }

    /* renamed from: d */
    public void mo59098d() {
        this.f4153c = 0;
        this.f4154d = 0;
        this.f4155e = 0;
        this.f4152b.clear();
    }

    /* renamed from: e */
    public long mo59099e() {
        return (long) this.f4152b.size();
    }

    /* renamed from: f */
    public long mo59100f() {
        return this.f4155e;
    }

    /* renamed from: g */
    public boolean mo59101g() {
        return this.f4152b.isEmpty();
    }

    /* renamed from: h */
    public long mo59102h() {
        return this.f4154d - this.f4153c;
    }
}

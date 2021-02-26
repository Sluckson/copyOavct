package p011io.grpc.perfmark;

import p011io.grpc.perfmark.PerfTag;

/* renamed from: io.grpc.perfmark.InternalPerfMark */
public final class InternalPerfMark {
    private static final long NULL_NUMERIC_TAG = 0;
    private static final String NULL_STRING_TAG = null;

    /* renamed from: io.grpc.perfmark.InternalPerfMark$InternalPerfMarkTask */
    public static abstract class InternalPerfMarkTask extends PerfMarkTask {
    }

    private InternalPerfMark() {
    }

    public static PerfTag createPerfTag(long j, String str) {
        return PerfTag.TagFactory.create(j, str);
    }

    public static PerfTag createPerfTag(String str) {
        return PerfTag.TagFactory.create(0, str);
    }

    public static PerfTag createPerfTag(long j) {
        return PerfTag.TagFactory.create(j, NULL_STRING_TAG);
    }
}

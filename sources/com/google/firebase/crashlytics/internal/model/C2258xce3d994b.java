package com.google.firebase.crashlytics.internal.model;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.firebase.crashlytics.internal.model.CrashlyticsReport;

/* renamed from: com.google.firebase.crashlytics.internal.model.AutoValue_CrashlyticsReport_Session_Event_Application_Execution_Thread_Frame */
final class C2258xce3d994b extends CrashlyticsReport.Session.Event.Application.Execution.Thread.Frame {
    private final String file;
    private final int importance;
    private final long offset;

    /* renamed from: pc */
    private final long f352pc;
    private final String symbol;

    private C2258xce3d994b(long j, String str, @Nullable String str2, long j2, int i) {
        this.f352pc = j;
        this.symbol = str;
        this.file = str2;
        this.offset = j2;
        this.importance = i;
    }

    public long getPc() {
        return this.f352pc;
    }

    @NonNull
    public String getSymbol() {
        return this.symbol;
    }

    @Nullable
    public String getFile() {
        return this.file;
    }

    public long getOffset() {
        return this.offset;
    }

    public int getImportance() {
        return this.importance;
    }

    public String toString() {
        return "Frame{pc=" + this.f352pc + ", symbol=" + this.symbol + ", file=" + this.file + ", offset=" + this.offset + ", importance=" + this.importance + "}";
    }

    public boolean equals(Object obj) {
        String str;
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof CrashlyticsReport.Session.Event.Application.Execution.Thread.Frame)) {
            return false;
        }
        CrashlyticsReport.Session.Event.Application.Execution.Thread.Frame frame = (CrashlyticsReport.Session.Event.Application.Execution.Thread.Frame) obj;
        if (this.f352pc == frame.getPc() && this.symbol.equals(frame.getSymbol()) && ((str = this.file) != null ? str.equals(frame.getFile()) : frame.getFile() == null) && this.offset == frame.getOffset() && this.importance == frame.getImportance()) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        long j = this.f352pc;
        int hashCode = (((((int) (j ^ (j >>> 32))) ^ 1000003) * 1000003) ^ this.symbol.hashCode()) * 1000003;
        String str = this.file;
        int hashCode2 = str == null ? 0 : str.hashCode();
        long j2 = this.offset;
        return this.importance ^ ((((hashCode ^ hashCode2) * 1000003) ^ ((int) ((j2 >>> 32) ^ j2))) * 1000003);
    }

    /* renamed from: com.google.firebase.crashlytics.internal.model.AutoValue_CrashlyticsReport_Session_Event_Application_Execution_Thread_Frame$Builder */
    static final class Builder extends CrashlyticsReport.Session.Event.Application.Execution.Thread.Frame.Builder {
        private String file;
        private Integer importance;
        private Long offset;

        /* renamed from: pc */
        private Long f353pc;
        private String symbol;

        Builder() {
        }

        public CrashlyticsReport.Session.Event.Application.Execution.Thread.Frame.Builder setPc(long j) {
            this.f353pc = Long.valueOf(j);
            return this;
        }

        public CrashlyticsReport.Session.Event.Application.Execution.Thread.Frame.Builder setSymbol(String str) {
            if (str != null) {
                this.symbol = str;
                return this;
            }
            throw new NullPointerException("Null symbol");
        }

        public CrashlyticsReport.Session.Event.Application.Execution.Thread.Frame.Builder setFile(String str) {
            this.file = str;
            return this;
        }

        public CrashlyticsReport.Session.Event.Application.Execution.Thread.Frame.Builder setOffset(long j) {
            this.offset = Long.valueOf(j);
            return this;
        }

        public CrashlyticsReport.Session.Event.Application.Execution.Thread.Frame.Builder setImportance(int i) {
            this.importance = Integer.valueOf(i);
            return this;
        }

        public CrashlyticsReport.Session.Event.Application.Execution.Thread.Frame build() {
            String str = "";
            if (this.f353pc == null) {
                str = str + " pc";
            }
            if (this.symbol == null) {
                str = str + " symbol";
            }
            if (this.offset == null) {
                str = str + " offset";
            }
            if (this.importance == null) {
                str = str + " importance";
            }
            if (str.isEmpty()) {
                return new C2258xce3d994b(this.f353pc.longValue(), this.symbol, this.file, this.offset.longValue(), this.importance.intValue());
            }
            throw new IllegalStateException("Missing required properties:" + str);
        }
    }
}

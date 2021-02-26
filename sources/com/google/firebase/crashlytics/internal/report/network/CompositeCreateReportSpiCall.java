package com.google.firebase.crashlytics.internal.report.network;

import com.google.firebase.crashlytics.internal.report.model.CreateReportRequest;
import com.google.firebase.crashlytics.internal.report.model.Report;

public class CompositeCreateReportSpiCall implements CreateReportSpiCall {
    private final DefaultCreateReportSpiCall javaReportSpiCall;
    private final NativeCreateReportSpiCall nativeReportSpiCall;

    public CompositeCreateReportSpiCall(DefaultCreateReportSpiCall defaultCreateReportSpiCall, NativeCreateReportSpiCall nativeCreateReportSpiCall) {
        this.javaReportSpiCall = defaultCreateReportSpiCall;
        this.nativeReportSpiCall = nativeCreateReportSpiCall;
    }

    /* renamed from: com.google.firebase.crashlytics.internal.report.network.CompositeCreateReportSpiCall$1 */
    static /* synthetic */ class C22711 {

        /* renamed from: $SwitchMap$com$google$firebase$crashlytics$internal$report$model$Report$Type */
        static final /* synthetic */ int[] f354xc221d5a6 = new int[Report.Type.values().length];

        /* JADX WARNING: Can't wrap try/catch for region: R(6:0|1|2|3|4|6) */
        /* JADX WARNING: Code restructure failed: missing block: B:7:?, code lost:
            return;
         */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0014 */
        static {
            /*
                com.google.firebase.crashlytics.internal.report.model.Report$Type[] r0 = com.google.firebase.crashlytics.internal.report.model.Report.Type.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f354xc221d5a6 = r0
                int[] r0 = f354xc221d5a6     // Catch:{ NoSuchFieldError -> 0x0014 }
                com.google.firebase.crashlytics.internal.report.model.Report$Type r1 = com.google.firebase.crashlytics.internal.report.model.Report.Type.JAVA     // Catch:{ NoSuchFieldError -> 0x0014 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0014 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0014 }
            L_0x0014:
                int[] r0 = f354xc221d5a6     // Catch:{ NoSuchFieldError -> 0x001f }
                com.google.firebase.crashlytics.internal.report.model.Report$Type r1 = com.google.firebase.crashlytics.internal.report.model.Report.Type.NATIVE     // Catch:{ NoSuchFieldError -> 0x001f }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001f }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001f }
            L_0x001f:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.firebase.crashlytics.internal.report.network.CompositeCreateReportSpiCall.C22711.<clinit>():void");
        }
    }

    public boolean invoke(CreateReportRequest createReportRequest, boolean z) {
        int i = C22711.f354xc221d5a6[createReportRequest.report.getType().ordinal()];
        if (i == 1) {
            this.javaReportSpiCall.invoke(createReportRequest, z);
            return true;
        } else if (i != 2) {
            return false;
        } else {
            this.nativeReportSpiCall.invoke(createReportRequest, z);
            return true;
        }
    }
}

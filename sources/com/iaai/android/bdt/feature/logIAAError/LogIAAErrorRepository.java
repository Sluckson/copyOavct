package com.iaai.android.bdt.feature.logIAAError;

import androidx.core.app.NotificationCompat;
import com.iaai.android.bdt.model.logIAAError.LogIAAErrorRequest;
import com.iaai.android.bdt.model.logIAAError.LogIAAErrorResponse;
import com.iaai.android.bdt.network.Repository;
import com.iaai.android.bdt.network.Service;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import p011io.reactivex.Observable;
import repack.org.bouncycastle.cms.CMSAttributeTableGenerator;

@Metadata(mo66931bv = {1, 0, 3}, mo66932d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u000f\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u001c\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bR\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000¨\u0006\f"}, mo66933d2 = {"Lcom/iaai/android/bdt/feature/logIAAError/LogIAAErrorRepository;", "Lcom/iaai/android/bdt/network/Repository;", "service", "Lcom/iaai/android/bdt/network/Service;", "(Lcom/iaai/android/bdt/network/Service;)V", "logIAAError", "Lio/reactivex/Observable;", "Lcom/iaai/android/bdt/model/logIAAError/LogIAAErrorResponse;", "contentType", "", "logIAAErrorRequest", "Lcom/iaai/android/bdt/model/logIAAError/LogIAAErrorRequest;", "app_productionRelease"}, mo66934k = 1, mo66935mv = {1, 1, 13})
/* compiled from: LogIAAErrorRepository.kt */
public final class LogIAAErrorRepository implements Repository {
    private final Service service;

    @Inject
    public LogIAAErrorRepository(@NotNull Service service2) {
        Intrinsics.checkParameterIsNotNull(service2, NotificationCompat.CATEGORY_SERVICE);
        this.service = service2;
    }

    @NotNull
    public final Observable<LogIAAErrorResponse> logIAAError(@NotNull String str, @NotNull LogIAAErrorRequest logIAAErrorRequest) {
        Intrinsics.checkParameterIsNotNull(str, CMSAttributeTableGenerator.CONTENT_TYPE);
        Intrinsics.checkParameterIsNotNull(logIAAErrorRequest, "logIAAErrorRequest");
        return this.service.logIAAError(str, logIAAErrorRequest);
    }
}

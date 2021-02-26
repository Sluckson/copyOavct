package com.iaai.android.bdt.feature.productDetail.costCalculator;

import androidx.core.app.NotificationCompat;
import com.iaai.android.bdt.model.productDetail.costCalculator.CostCalculatorResponse;
import com.iaai.android.bdt.model.productDetail.costCalculator.RequestBody;
import com.iaai.android.bdt.network.Repository;
import com.iaai.android.bdt.network.Service;
import com.iaai.android.bdt.utils.Constants_MVVM;
import java.math.BigDecimal;
import java.math.BigInteger;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import p011io.reactivex.Observable;

@Metadata(mo66931bv = {1, 0, 3}, mo66932d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u000f\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004Jd\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0013\u001a\u00020\u00112\u0006\u0010\u0014\u001a\u00020\u00112\u0006\u0010\u0015\u001a\u00020\u00112\u0006\u0010\u0016\u001a\u00020\u0011R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0017"}, mo66933d2 = {"Lcom/iaai/android/bdt/feature/productDetail/costCalculator/CostCalculatorRepository;", "Lcom/iaai/android/bdt/network/Repository;", "service", "Lcom/iaai/android/bdt/network/Service;", "(Lcom/iaai/android/bdt/network/Service;)V", "getCostCalValue", "Lio/reactivex/Observable;", "Lcom/iaai/android/bdt/model/productDetail/costCalculator/CostCalculatorResponse;", "salvageId", "Ljava/math/BigDecimal;", "stockNumber", "bidAmount", "Ljava/math/BigInteger;", "buyerId", "", "userId", "pikUpZip", "", "dropOffZip", "vin", "runAndDrive", "employeeId", "branchCode", "app_productionRelease"}, mo66934k = 1, mo66935mv = {1, 1, 13})
/* compiled from: CostCalculatorRepository.kt */
public final class CostCalculatorRepository implements Repository {
    private final Service service;

    @Inject
    public CostCalculatorRepository(@NotNull Service service2) {
        Intrinsics.checkParameterIsNotNull(service2, NotificationCompat.CATEGORY_SERVICE);
        this.service = service2;
    }

    @NotNull
    public final Observable<CostCalculatorResponse> getCostCalValue(@NotNull BigDecimal bigDecimal, @NotNull BigDecimal bigDecimal2, @NotNull BigInteger bigInteger, int i, int i2, @NotNull String str, @NotNull String str2, @NotNull String str3, @NotNull String str4, @NotNull String str5, @NotNull String str6) {
        Intrinsics.checkParameterIsNotNull(bigDecimal, "salvageId");
        Intrinsics.checkParameterIsNotNull(bigDecimal2, "stockNumber");
        BigInteger bigInteger2 = bigInteger;
        Intrinsics.checkParameterIsNotNull(bigInteger2, "bidAmount");
        String str7 = str;
        Intrinsics.checkParameterIsNotNull(str7, "pikUpZip");
        String str8 = str2;
        Intrinsics.checkParameterIsNotNull(str8, "dropOffZip");
        String str9 = str3;
        Intrinsics.checkParameterIsNotNull(str9, Constants_MVVM.EXTRA_VIN);
        String str10 = str4;
        Intrinsics.checkParameterIsNotNull(str10, "runAndDrive");
        String str11 = str5;
        Intrinsics.checkParameterIsNotNull(str11, "employeeId");
        String str12 = str6;
        Intrinsics.checkParameterIsNotNull(str12, Constants_MVVM.EXTRA_BRANCH_CODE);
        return this.service.getCostBreakDown(new RequestBody(bigDecimal, bigDecimal2, bigInteger2, i, i2, str7, str8, str9, str10, str11, str12));
    }
}

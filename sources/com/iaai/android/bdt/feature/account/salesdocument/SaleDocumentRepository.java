package com.iaai.android.bdt.feature.account.salesdocument;

import androidx.core.app.NotificationCompat;
import com.iaai.android.bdt.model.MyAccount.MBRequestBody;
import com.iaai.android.bdt.model.MyAccount.ManageBranchPrefResponse;
import com.iaai.android.bdt.model.MyAccount.SaleDocBranchFilterResponse;
import com.iaai.android.bdt.model.MyAccount.SaleDocumentListResponse;
import com.iaai.android.bdt.model.MyAccount.SaleDocumentRequestBody;
import com.iaai.android.bdt.network.Repository;
import com.iaai.android.bdt.network.Service;
import com.iaai.android.old.utils.constants.Constants;
import java.util.List;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import p011io.reactivex.Observable;
import repack.org.bouncycastle.cms.CMSAttributeTableGenerator;

@Metadata(mo66931bv = {1, 0, 3}, mo66932d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u000f\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004JD\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\t2\u0006\u0010\r\u001a\u00020\t2\u0006\u0010\u000e\u001a\u00020\t2\u0006\u0010\u000f\u001a\u00020\u0010JB\u0010\u0011\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00130\u00120\u00062\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\t2\u0006\u0010\r\u001a\u00020\t2\u0006\u0010\u000e\u001a\u00020\tJD\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00150\u00062\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\t2\u0006\u0010\r\u001a\u00020\t2\u0006\u0010\u000e\u001a\u00020\t2\u0006\u0010\u000f\u001a\u00020\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0017"}, mo66933d2 = {"Lcom/iaai/android/bdt/feature/account/salesdocument/SaleDocumentRepository;", "Lcom/iaai/android/bdt/network/Repository;", "service", "Lcom/iaai/android/bdt/network/Service;", "(Lcom/iaai/android/bdt/network/Service;)V", "getManageBranchPrefList", "Lio/reactivex/Observable;", "Lcom/iaai/android/bdt/model/MyAccount/ManageBranchPrefResponse;", "authHeader", "", "deviceid", "devicetype", "apikey", "contentType", "appversion", "requestBody", "Lcom/iaai/android/bdt/model/MyAccount/MBRequestBody;", "getSaleDocumentBranchList", "", "Lcom/iaai/android/bdt/model/MyAccount/SaleDocBranchFilterResponse;", "getSaleDocumentList", "Lcom/iaai/android/bdt/model/MyAccount/SaleDocumentListResponse;", "Lcom/iaai/android/bdt/model/MyAccount/SaleDocumentRequestBody;", "app_productionRelease"}, mo66934k = 1, mo66935mv = {1, 1, 13})
/* compiled from: SaleDocumentRepository.kt */
public final class SaleDocumentRepository implements Repository {
    private final Service service;

    @Inject
    public SaleDocumentRepository(@NotNull Service service2) {
        Intrinsics.checkParameterIsNotNull(service2, NotificationCompat.CATEGORY_SERVICE);
        this.service = service2;
    }

    @NotNull
    public final Observable<SaleDocumentListResponse> getSaleDocumentList(@NotNull String str, @NotNull String str2, @NotNull String str3, @NotNull String str4, @NotNull String str5, @NotNull String str6, @NotNull SaleDocumentRequestBody saleDocumentRequestBody) {
        Intrinsics.checkParameterIsNotNull(str, "authHeader");
        Intrinsics.checkParameterIsNotNull(str2, "deviceid");
        Intrinsics.checkParameterIsNotNull(str3, Constants.DEVICETYPE_HEADER);
        Intrinsics.checkParameterIsNotNull(str4, "apikey");
        Intrinsics.checkParameterIsNotNull(str5, CMSAttributeTableGenerator.CONTENT_TYPE);
        Intrinsics.checkParameterIsNotNull(str6, "appversion");
        SaleDocumentRequestBody saleDocumentRequestBody2 = saleDocumentRequestBody;
        Intrinsics.checkParameterIsNotNull(saleDocumentRequestBody2, "requestBody");
        return this.service.getSaleDocumentInstructionList(str, str2, str3, str4, str5, str6, saleDocumentRequestBody2);
    }

    @NotNull
    public final Observable<List<SaleDocBranchFilterResponse>> getSaleDocumentBranchList(@NotNull String str, @NotNull String str2, @NotNull String str3, @NotNull String str4, @NotNull String str5, @NotNull String str6) {
        Intrinsics.checkParameterIsNotNull(str, "authHeader");
        Intrinsics.checkParameterIsNotNull(str2, "deviceid");
        Intrinsics.checkParameterIsNotNull(str3, Constants.DEVICETYPE_HEADER);
        Intrinsics.checkParameterIsNotNull(str4, "apikey");
        Intrinsics.checkParameterIsNotNull(str5, CMSAttributeTableGenerator.CONTENT_TYPE);
        Intrinsics.checkParameterIsNotNull(str6, "appversion");
        return this.service.getSaleDocumentBranchList(str, str2, str3, str4, str5, str6);
    }

    @NotNull
    public final Observable<ManageBranchPrefResponse> getManageBranchPrefList(@NotNull String str, @NotNull String str2, @NotNull String str3, @NotNull String str4, @NotNull String str5, @NotNull String str6, @NotNull MBRequestBody mBRequestBody) {
        Intrinsics.checkParameterIsNotNull(str, "authHeader");
        Intrinsics.checkParameterIsNotNull(str2, "deviceid");
        Intrinsics.checkParameterIsNotNull(str3, Constants.DEVICETYPE_HEADER);
        Intrinsics.checkParameterIsNotNull(str4, "apikey");
        Intrinsics.checkParameterIsNotNull(str5, CMSAttributeTableGenerator.CONTENT_TYPE);
        Intrinsics.checkParameterIsNotNull(str6, "appversion");
        MBRequestBody mBRequestBody2 = mBRequestBody;
        Intrinsics.checkParameterIsNotNull(mBRequestBody2, "requestBody");
        return this.service.getManageBranchPrefList(str, str2, str3, str4, str5, str6, mBRequestBody2);
    }
}

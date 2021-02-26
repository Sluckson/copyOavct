package com.iaai.android.bdt.feature.myAccount;

import androidx.core.app.NotificationCompat;
import com.iaai.android.bdt.feature.myAccount.toBePaid.TempRequestBody;
import com.iaai.android.bdt.model.MyAccount.InsertRepOrAddressRequest;
import com.iaai.android.bdt.model.MyAccount.InsertRepOrAddressResponse;
import com.iaai.android.bdt.model.MyAccount.SaleDocCountryStateParentModel;
import com.iaai.android.bdt.model.toBePaid.MakePayPalPaymentRequest;
import com.iaai.android.bdt.model.toBePaid.PayPalCheckOutResponse;
import com.iaai.android.bdt.model.toBePaid.PayPalCreateCustomerResponse;
import com.iaai.android.bdt.model.toBePaid.PayPalInfoResponse;
import com.iaai.android.bdt.model.toBePaid.PayPalPaymentRequest;
import com.iaai.android.bdt.model.toBePaid.PayPalTokenResponse;
import com.iaai.android.bdt.model.toBePaid.getDeliveryMethod.GetDeliveryMethodRequest;
import com.iaai.android.bdt.model.toBePaid.getDeliveryMethod.GetDeliveryMethodResponse;
import com.iaai.android.bdt.model.toBePaid.paymentDueList.PaymentDueListResponse;
import com.iaai.android.bdt.model.toBePaid.saleDocument.GetSaleDocListRequest;
import com.iaai.android.bdt.model.toBePaid.saleDocument.SaleDocResponse;
import com.iaai.android.bdt.model.toBePaid.saleDocument.SaveDeliveryRequest;
import com.iaai.android.bdt.model.toBePaid.saleDocument.defaultResponse.GetSaleDocListResponse;
import com.iaai.android.bdt.model.toBePaid.saleDocument.groupedByBranch.GetSaleDocListGroupResponse;
import com.iaai.android.bdt.network.Repository;
import com.iaai.android.bdt.network.Service;
import com.iaai.android.bdt.utils.Utils;
import com.iaai.android.old.utils.constants.Constants;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import p011io.reactivex.Observable;
import repack.org.bouncycastle.cms.CMSAttributeTableGenerator;

@Metadata(mo66931bv = {1, 0, 3}, mo66932d1 = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u000f\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J$\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\fJD\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000e0\u00062\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\u000f\u001a\u00020\t2\u0006\u0010\u0010\u001a\u00020\t2\u0006\u0010\u0011\u001a\u00020\t2\u0006\u0010\u0012\u001a\u00020\t2\u0006\u0010\u0013\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\u0014J\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00160\u0006J$\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00180\u00062\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\u0019J\u0014\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u001b0\u00062\u0006\u0010\b\u001a\u00020\tJD\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u001d0\u00062\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\u000f\u001a\u00020\t2\u0006\u0010\u0010\u001a\u00020\t2\u0006\u0010\u0011\u001a\u00020\t2\u0006\u0010\u0012\u001a\u00020\t2\u0006\u0010\u0013\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\u0014J\u001c\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u001f0\u00062\u0006\u0010 \u001a\u00020!2\u0006\u0010\"\u001a\u00020\tJ4\u0010#\u001a\b\u0012\u0004\u0012\u00020$0\u00062\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\u000f\u001a\u00020\t2\u0006\u0010\u0010\u001a\u00020\t2\u0006\u0010\u0013\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020%J4\u0010&\u001a\b\u0012\u0004\u0012\u00020'0\u00062\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\u000f\u001a\u00020\t2\u0006\u0010\u0010\u001a\u00020\t2\u0006\u0010\u0013\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020%J$\u0010(\u001a\b\u0012\u0004\u0012\u00020)0\u00062\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020*JD\u0010+\u001a\b\u0012\u0004\u0012\u00020,0\u00062\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\u000f\u001a\u00020\t2\u0006\u0010\u0010\u001a\u00020\t2\u0006\u0010\u0011\u001a\u00020\t2\u0006\u0010\u0012\u001a\u00020\t2\u0006\u0010\u0013\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020-R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000¨\u0006."}, mo66933d2 = {"Lcom/iaai/android/bdt/feature/myAccount/MyAccountRepository;", "Lcom/iaai/android/bdt/network/Repository;", "service", "Lcom/iaai/android/bdt/network/Service;", "(Lcom/iaai/android/bdt/network/Service;)V", "applyDeliveryMethod", "Lio/reactivex/Observable;", "Lcom/iaai/android/bdt/model/toBePaid/saleDocument/SaleDocResponse;", "authHeader", "", "deviceType", "requestBody", "Lcom/iaai/android/bdt/model/toBePaid/saleDocument/SaveDeliveryRequest;", "createPayPalCustomerID", "Lcom/iaai/android/bdt/model/toBePaid/PayPalCreateCustomerResponse;", "deviceid", "devicetype", "apikey", "contentType", "appversion", "Lcom/iaai/android/bdt/model/toBePaid/PayPalPaymentRequest;", "getCountryStateList", "Lcom/iaai/android/bdt/model/MyAccount/SaleDocCountryStateParentModel;", "getDeliveryMethods", "Lcom/iaai/android/bdt/model/toBePaid/getDeliveryMethod/GetDeliveryMethodResponse;", "Lcom/iaai/android/bdt/model/toBePaid/getDeliveryMethod/GetDeliveryMethodRequest;", "getPayPalInfo", "Lcom/iaai/android/bdt/model/toBePaid/PayPalInfoResponse;", "getPayPalToken", "Lcom/iaai/android/bdt/model/toBePaid/PayPalTokenResponse;", "getPaymentDueList", "Lcom/iaai/android/bdt/model/toBePaid/paymentDueList/PaymentDueListResponse;", "tempRequestBody", "Lcom/iaai/android/bdt/feature/myAccount/toBePaid/TempRequestBody;", "authString", "getSaleDocList", "Lcom/iaai/android/bdt/model/toBePaid/saleDocument/defaultResponse/GetSaleDocListResponse;", "Lcom/iaai/android/bdt/model/toBePaid/saleDocument/GetSaleDocListRequest;", "getSaleDocListGroup", "Lcom/iaai/android/bdt/model/toBePaid/saleDocument/groupedByBranch/GetSaleDocListGroupResponse;", "insertRepOrAddress", "Lcom/iaai/android/bdt/model/MyAccount/InsertRepOrAddressResponse;", "Lcom/iaai/android/bdt/model/MyAccount/InsertRepOrAddressRequest;", "makePayPalCheckOut", "Lcom/iaai/android/bdt/model/toBePaid/PayPalCheckOutResponse;", "Lcom/iaai/android/bdt/model/toBePaid/MakePayPalPaymentRequest;", "app_productionRelease"}, mo66934k = 1, mo66935mv = {1, 1, 13})
/* compiled from: MyAccountRepository.kt */
public final class MyAccountRepository implements Repository {
    private final Service service;

    @Inject
    public MyAccountRepository(@NotNull Service service2) {
        Intrinsics.checkParameterIsNotNull(service2, NotificationCompat.CATEGORY_SERVICE);
        this.service = service2;
    }

    @NotNull
    public final Observable<PaymentDueListResponse> getPaymentDueList(@NotNull TempRequestBody tempRequestBody, @NotNull String str) {
        Intrinsics.checkParameterIsNotNull(tempRequestBody, "tempRequestBody");
        Intrinsics.checkParameterIsNotNull(str, "authString");
        Service service2 = this.service;
        String userAgent = Utils.getUserAgent();
        Intrinsics.checkExpressionValueIsNotNull(userAgent, "Utils.getUserAgent()");
        return service2.getPaymentDueList(userAgent, str, tempRequestBody.getPageNumber(), tempRequestBody.getCount(), tempRequestBody.getSortBy(), tempRequestBody.getSortAsc(), tempRequestBody.getPaymentMethod(), tempRequestBody.getOnlymyitems());
    }

    @NotNull
    public final Observable<PayPalTokenResponse> getPayPalToken(@NotNull String str, @NotNull String str2, @NotNull String str3, @NotNull String str4, @NotNull String str5, @NotNull String str6, @NotNull PayPalPaymentRequest payPalPaymentRequest) {
        Intrinsics.checkParameterIsNotNull(str, "authHeader");
        Intrinsics.checkParameterIsNotNull(str2, "deviceid");
        Intrinsics.checkParameterIsNotNull(str3, Constants.DEVICETYPE_HEADER);
        Intrinsics.checkParameterIsNotNull(str4, "apikey");
        Intrinsics.checkParameterIsNotNull(str5, CMSAttributeTableGenerator.CONTENT_TYPE);
        Intrinsics.checkParameterIsNotNull(str6, "appversion");
        PayPalPaymentRequest payPalPaymentRequest2 = payPalPaymentRequest;
        Intrinsics.checkParameterIsNotNull(payPalPaymentRequest2, "requestBody");
        return this.service.getPayPalToken(str, str2, str3, str4, str5, str6, payPalPaymentRequest2);
    }

    @NotNull
    public final Observable<PayPalCreateCustomerResponse> createPayPalCustomerID(@NotNull String str, @NotNull String str2, @NotNull String str3, @NotNull String str4, @NotNull String str5, @NotNull String str6, @NotNull PayPalPaymentRequest payPalPaymentRequest) {
        Intrinsics.checkParameterIsNotNull(str, "authHeader");
        Intrinsics.checkParameterIsNotNull(str2, "deviceid");
        Intrinsics.checkParameterIsNotNull(str3, Constants.DEVICETYPE_HEADER);
        Intrinsics.checkParameterIsNotNull(str4, "apikey");
        Intrinsics.checkParameterIsNotNull(str5, CMSAttributeTableGenerator.CONTENT_TYPE);
        Intrinsics.checkParameterIsNotNull(str6, "appversion");
        PayPalPaymentRequest payPalPaymentRequest2 = payPalPaymentRequest;
        Intrinsics.checkParameterIsNotNull(payPalPaymentRequest2, "requestBody");
        return this.service.createPayPalCustomerID(str, str2, str3, str4, str5, str6, payPalPaymentRequest2);
    }

    @NotNull
    public final Observable<PayPalCheckOutResponse> makePayPalCheckOut(@NotNull String str, @NotNull String str2, @NotNull String str3, @NotNull String str4, @NotNull String str5, @NotNull String str6, @NotNull MakePayPalPaymentRequest makePayPalPaymentRequest) {
        Intrinsics.checkParameterIsNotNull(str, "authHeader");
        Intrinsics.checkParameterIsNotNull(str2, "deviceid");
        Intrinsics.checkParameterIsNotNull(str3, Constants.DEVICETYPE_HEADER);
        Intrinsics.checkParameterIsNotNull(str4, "apikey");
        Intrinsics.checkParameterIsNotNull(str5, CMSAttributeTableGenerator.CONTENT_TYPE);
        Intrinsics.checkParameterIsNotNull(str6, "appversion");
        MakePayPalPaymentRequest makePayPalPaymentRequest2 = makePayPalPaymentRequest;
        Intrinsics.checkParameterIsNotNull(makePayPalPaymentRequest2, "requestBody");
        return this.service.makePayPalCheckOut(str, str2, str3, str4, str5, str6, makePayPalPaymentRequest2);
    }

    @NotNull
    public final Observable<PayPalInfoResponse> getPayPalInfo(@NotNull String str) {
        Intrinsics.checkParameterIsNotNull(str, "authHeader");
        return this.service.getGetPayPalInfo(str);
    }

    @NotNull
    public final Observable<GetSaleDocListGroupResponse> getSaleDocListGroup(@NotNull String str, @NotNull String str2, @NotNull String str3, @NotNull String str4, @NotNull GetSaleDocListRequest getSaleDocListRequest) {
        Intrinsics.checkParameterIsNotNull(str, "authHeader");
        Intrinsics.checkParameterIsNotNull(str2, "deviceid");
        Intrinsics.checkParameterIsNotNull(str3, Constants.DEVICETYPE_HEADER);
        Intrinsics.checkParameterIsNotNull(str4, "appversion");
        Intrinsics.checkParameterIsNotNull(getSaleDocListRequest, "requestBody");
        return this.service.getSaleDocListGroup(str, str2, str3, str4, getSaleDocListRequest);
    }

    @NotNull
    public final Observable<GetSaleDocListResponse> getSaleDocList(@NotNull String str, @NotNull String str2, @NotNull String str3, @NotNull String str4, @NotNull GetSaleDocListRequest getSaleDocListRequest) {
        Intrinsics.checkParameterIsNotNull(str, "authHeader");
        Intrinsics.checkParameterIsNotNull(str2, "deviceid");
        Intrinsics.checkParameterIsNotNull(str3, Constants.DEVICETYPE_HEADER);
        Intrinsics.checkParameterIsNotNull(str4, "appversion");
        Intrinsics.checkParameterIsNotNull(getSaleDocListRequest, "requestBody");
        return this.service.getSaleDocList(str, str2, str3, str4, getSaleDocListRequest);
    }

    @NotNull
    public final Observable<GetDeliveryMethodResponse> getDeliveryMethods(@NotNull String str, @NotNull String str2, @NotNull GetDeliveryMethodRequest getDeliveryMethodRequest) {
        Intrinsics.checkParameterIsNotNull(str, "authHeader");
        Intrinsics.checkParameterIsNotNull(str2, "deviceType");
        Intrinsics.checkParameterIsNotNull(getDeliveryMethodRequest, "requestBody");
        return this.service.getDeliveryMethods(str, str2, getDeliveryMethodRequest);
    }

    @NotNull
    public final Observable<SaleDocResponse> applyDeliveryMethod(@NotNull String str, @NotNull String str2, @NotNull SaveDeliveryRequest saveDeliveryRequest) {
        Intrinsics.checkParameterIsNotNull(str, "authHeader");
        Intrinsics.checkParameterIsNotNull(str2, "deviceType");
        Intrinsics.checkParameterIsNotNull(saveDeliveryRequest, "requestBody");
        return this.service.applyDeliveryMethods(str, str2, saveDeliveryRequest);
    }

    @NotNull
    public final Observable<SaleDocCountryStateParentModel> getCountryStateList() {
        return this.service.getCountryStateList();
    }

    @NotNull
    public final Observable<InsertRepOrAddressResponse> insertRepOrAddress(@NotNull String str, @NotNull String str2, @NotNull InsertRepOrAddressRequest insertRepOrAddressRequest) {
        Intrinsics.checkParameterIsNotNull(str, "authHeader");
        Intrinsics.checkParameterIsNotNull(str2, "deviceType");
        Intrinsics.checkParameterIsNotNull(insertRepOrAddressRequest, "requestBody");
        return this.service.insertRepOrAddress(str, str2, insertRepOrAddressRequest);
    }
}

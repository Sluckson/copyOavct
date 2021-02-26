package com.iaai.android.bdt.network;

import com.iaai.android.bdt.model.DashBoardDetails;
import com.iaai.android.bdt.model.MyAccount.BDTDashboardResponse;
import com.iaai.android.bdt.model.MyAccount.BuyNowOfferListResponse;
import com.iaai.android.bdt.model.MyAccount.InsertRepOrAddressRequest;
import com.iaai.android.bdt.model.MyAccount.InsertRepOrAddressResponse;
import com.iaai.android.bdt.model.MyAccount.MBRequestBody;
import com.iaai.android.bdt.model.MyAccount.ManageBranchPrefResponse;
import com.iaai.android.bdt.model.MyAccount.SaleDocBranchFilterResponse;
import com.iaai.android.bdt.model.MyAccount.SaleDocCountryStateParentModel;
import com.iaai.android.bdt.model.MyAccount.SaleDocumentListResponse;
import com.iaai.android.bdt.model.MyAccount.SaleDocumentRequestBody;
import com.iaai.android.bdt.model.MyAccount.ToBePickedUpResponse;
import com.iaai.android.bdt.model.MyAccount.VehicleReceiptPDFResponse;
import com.iaai.android.bdt.model.MyAccount.WatchListResponse;
import com.iaai.android.bdt.model.auctionSalesList.AuctionSalesListResponse;
import com.iaai.android.bdt.model.auctionSalesList.RequestBody;
import com.iaai.android.bdt.model.auctionmainlist.AuctionMainListResponse;
import com.iaai.android.bdt.model.digitalNegotiation.DigitalNegotiationListClass;
import com.iaai.android.bdt.model.digitalNegotiation.ManageOfferSendActionRequestBody;
import com.iaai.android.bdt.model.digitalNegotiation.ManageOfferSendActionResponse;
import com.iaai.android.bdt.model.fastSearch.FastSearchResponse;
import com.iaai.android.bdt.model.fastSearch.MakeModelMaster;
import com.iaai.android.bdt.model.fastSearch.SearchInputV2;
import com.iaai.android.bdt.model.fastSearchFilter2.FastSearchRequestBody;
import com.iaai.android.bdt.model.fastSearchFilter2.FastSearchResponse2;
import com.iaai.android.bdt.model.fastSearchFilter2.SearchMappingArray;
import com.iaai.android.bdt.model.logIAAError.LogIAAErrorRequest;
import com.iaai.android.bdt.model.logIAAError.LogIAAErrorResponse;
import com.iaai.android.bdt.model.login.AuctionRuleResponse;
import com.iaai.android.bdt.model.login.BDTForgotPasswordResponse;
import com.iaai.android.bdt.model.login.BDTLoginResponse;
import com.iaai.android.bdt.model.login.FCMTokenRequest;
import com.iaai.android.bdt.model.login.FCMTokenResponse;
import com.iaai.android.bdt.model.login.GenerateOTPResponse;
import com.iaai.android.bdt.model.productDetail.biddingInfo.ProductDetailResponse;
import com.iaai.android.bdt.model.productDetail.buyNow.BuyNowResult;
import com.iaai.android.bdt.model.productDetail.buyNowOffer.BDTBuyNowOfferResult;
import com.iaai.android.bdt.model.productDetail.chromeSection.ChromeData;
import com.iaai.android.bdt.model.productDetail.costCalculator.CostCalculatorResponse;
import com.iaai.android.bdt.model.productDetail.partsSection.PartsSectionResponse;
import com.iaai.android.bdt.model.productDetail.prebid.PreBidBidHistory;
import com.iaai.android.bdt.model.productDetail.prebid.PreBidPlacedResult;
import com.iaai.android.bdt.model.productDetail.reports.PremiumVehicleReportModel;
import com.iaai.android.bdt.model.profile.UpdateWatchListResponse;
import com.iaai.android.bdt.model.quickFilter.QuickFilterResponse;
import com.iaai.android.bdt.model.recommendedVehicles.RecommendedVehiclesResponse;
import com.iaai.android.bdt.model.saveSearch.SaveSearchRequest;
import com.iaai.android.bdt.model.saveSearch.SaveSearchResponse;
import com.iaai.android.bdt.model.savedSearchList.SavedSearchListResponse;
import com.iaai.android.bdt.model.termsofuse.AuctionRuleAcceptModel;
import com.iaai.android.bdt.model.termsofuse.TermsOfUseResponse;
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
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import p011io.reactivex.Observable;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.Query;
import retrofit2.http.Url;

@Metadata(mo66931bv = {1, 0, 3}, mo66932d1 = {"\u0000Ì\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J@\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\b\b\u0001\u0010\u0005\u001a\u00020\u00062\b\b\u0001\u0010\u0007\u001a\u00020\u00062\b\b\u0001\u0010\b\u001a\u00020\u00062\b\b\u0001\u0010\t\u001a\u00020\u00062\b\b\u0001\u0010\n\u001a\u00020\u0006H'JN\u0010\u000b\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\f0\u00032\b\b\u0001\u0010\r\u001a\u00020\u00062\b\b\u0001\u0010\u000e\u001a\u00020\u00062\b\b\u0001\u0010\u000f\u001a\u00020\u00062\b\b\u0001\u0010\u0010\u001a\u00020\u00062\b\b\u0001\u0010\u0011\u001a\u00020\u00062\n\b\u0001\u0010\u0005\u001a\u0004\u0018\u00010\u0006H'J,\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00130\u00032\b\b\u0001\u0010\u0014\u001a\u00020\u00062\b\b\u0001\u0010\u000f\u001a\u00020\u00062\b\b\u0001\u0010\u0015\u001a\u00020\u0016H'JV\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00180\u00032\b\b\u0001\u0010\u0014\u001a\u00020\u00062\b\b\u0001\u0010\u0007\u001a\u00020\u00062\b\b\u0001\u0010\u0005\u001a\u00020\u00062\b\b\u0001\u0010\b\u001a\u00020\u00062\b\b\u0001\u0010\u0019\u001a\u00020\u00062\b\b\u0001\u0010\u001a\u001a\u00020\u00062\n\b\u0001\u0010\u001b\u001a\u0004\u0018\u00010\u0006H'J\"\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u001d0\u00032\b\b\u0001\u0010\r\u001a\u00020\u00062\b\b\u0001\u0010\u001e\u001a\u00020\u0006H'JT\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020 0\u00032\b\b\u0001\u0010\u0014\u001a\u00020\u00062\b\b\u0001\u0010\u0019\u001a\u00020\u00062\b\b\u0001\u0010\u001a\u001a\u00020\u00062\b\b\u0001\u0010!\u001a\u00020\u00062\b\b\u0001\u0010\"\u001a\u00020\u00062\b\b\u0001\u0010\u0005\u001a\u00020\u00062\b\b\u0001\u0010\u0015\u001a\u00020#H'J@\u0010$\u001a\b\u0012\u0004\u0012\u00020\u00060\u00032\b\b\u0001\u0010\u0005\u001a\u00020\u00062\b\b\u0001\u0010\u0007\u001a\u00020\u00062\b\b\u0001\u0010\b\u001a\u00020\u00062\b\b\u0001\u0010\t\u001a\u00020\u00062\b\b\u0001\u0010\n\u001a\u00020\u0006H'JT\u0010%\u001a\b\u0012\u0004\u0012\u00020\u001d0\u00032\b\b\u0001\u0010\"\u001a\u00020\u00062\b\b\u0001\u0010\u0014\u001a\u00020\u00062\b\b\u0001\u0010\u001a\u001a\u00020\u00062\b\b\u0001\u0010&\u001a\u00020\u00062\b\b\u0001\u0010!\u001a\u00020\u00062\b\b\u0001\u0010'\u001a\u00020\u00062\b\b\u0001\u0010(\u001a\u00020\u0006H'J,\u0010)\u001a\b\u0012\u0004\u0012\u00020*0\u00032\b\b\u0001\u0010\"\u001a\u00020\u00062\b\b\u0001\u0010\u0015\u001a\u00020+2\b\b\u0001\u0010\u0014\u001a\u00020\u0006H'J6\u0010,\u001a\b\u0012\u0004\u0012\u00020-0\u00032\b\b\u0001\u0010\r\u001a\u00020\u00062\b\b\u0001\u0010.\u001a\u00020\u00062\b\b\u0001\u0010/\u001a\u00020\u00062\b\b\u0001\u0010\u000f\u001a\u00020\u0006H'J@\u00100\u001a\b\u0012\u0004\u0012\u0002010\u00032\b\b\u0001\u0010\r\u001a\u00020\u00062\b\b\u0001\u0010\u0005\u001a\u00020\u00062\b\b\u0001\u0010\u001e\u001a\u00020\u00062\b\b\u0001\u0010/\u001a\u00020\u00062\b\b\u0001\u0010\u000f\u001a\u00020\u0006H'JT\u00102\u001a\b\u0012\u0004\u0012\u0002030\u00032\b\b\u0001\u0010\u0019\u001a\u00020\u00062\b\b\u0001\u0010\u001a\u001a\u00020\u00062\b\b\u0001\u00104\u001a\u00020\u001d2\b\b\u0001\u00105\u001a\u00020\u00062\b\b\u0001\u00106\u001a\u00020\u00062\b\b\u0001\u00107\u001a\u00020\u00062\b\b\u0001\u00108\u001a\u00020\u0006H'J\"\u00109\u001a\b\u0012\u0004\u0012\u00020:0\u00032\b\b\u0001\u0010\u0014\u001a\u00020\u00062\b\b\u0001\u0010\u0015\u001a\u00020;H'JF\u0010<\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020>0=0\u00032\b\b\u0001\u0010\u0005\u001a\u00020\u00062\b\b\u0001\u0010\u0007\u001a\u00020\u00062\b\b\u0001\u0010\b\u001a\u00020\u00062\b\b\u0001\u0010\u0019\u001a\u00020\u00062\b\b\u0001\u0010\u001a\u001a\u00020\u0006H'J\u0018\u0010?\u001a\b\u0012\u0004\u0012\u00020\u00060\u00032\b\b\u0001\u0010\r\u001a\u00020\u0006H'J\"\u0010@\u001a\b\u0012\u0004\u0012\u00020\u00060\u00032\b\b\u0001\u0010\r\u001a\u00020\u00062\b\b\u0001\u0010\u0005\u001a\u00020\u0006H'Jh\u0010A\u001a\b\u0012\u0004\u0012\u00020B0\u00032\b\b\u0001\u0010\r\u001a\u00020\u00062\b\b\u0001\u0010\u0005\u001a\u00020\u00062\b\b\u0001\u0010C\u001a\u00020D2\b\b\u0001\u0010E\u001a\u00020D2\b\b\u0001\u0010F\u001a\u00020\u00062\b\b\u0001\u0010G\u001a\u00020\u001d2\b\b\u0001\u0010H\u001a\u00020\u00062\b\b\u0001\u0010I\u001a\u00020\u00062\b\b\u0001\u0010J\u001a\u00020DH'J\u0018\u0010K\u001a\b\u0012\u0004\u0012\u00020L0\u00032\b\b\u0001\u0010\u0007\u001a\u00020\u0006H'J\u0018\u0010M\u001a\b\u0012\u0004\u0012\u00020N0\u00032\b\b\u0001\u0010\u0015\u001a\u00020OH'J\u000e\u0010P\u001a\b\u0012\u0004\u0012\u00020Q0\u0003H'J@\u0010R\u001a\b\u0012\u0004\u0012\u00020S0\u00032\b\b\u0001\u0010T\u001a\u00020D2\b\b\u0001\u0010\u0014\u001a\u00020\u00062\b\b\u0001\u0010\u0019\u001a\u00020\u00062\b\b\u0001\u0010\u000f\u001a\u00020\u00062\b\b\u0001\u0010U\u001a\u00020DH'JJ\u0010V\u001a\b\u0012\u0004\u0012\u00020W0\u00032\b\b\u0001\u0010\u0014\u001a\u00020\u00062\b\b\u0001\u0010\r\u001a\u00020\u00062\b\b\u0001\u0010\u0005\u001a\u00020\u00062\b\b\u0001\u0010U\u001a\u00020\u00062\b\b\u0001\u0010/\u001a\u00020\u00062\b\b\u0001\u0010\u000f\u001a\u00020\u0006H'J,\u0010X\u001a\b\u0012\u0004\u0012\u00020Y0\u00032\b\b\u0001\u0010\u0014\u001a\u00020\u00062\b\b\u0001\u0010\u000f\u001a\u00020\u00062\b\b\u0001\u0010\u0015\u001a\u00020ZH'J\u0018\u0010[\u001a\b\u0012\u0004\u0012\u00020\\0\u00032\b\b\u0001\u0010\u0014\u001a\u00020\u0006H'J\u0014\u0010]\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020^0=0\u0003H'JT\u0010_\u001a\b\u0012\u0004\u0012\u00020`0\u00032\b\b\u0001\u0010\u0014\u001a\u00020\u00062\b\b\u0001\u0010\u0019\u001a\u00020\u00062\b\b\u0001\u0010\u001a\u001a\u00020\u00062\b\b\u0001\u0010!\u001a\u00020\u00062\b\b\u0001\u0010\"\u001a\u00020\u00062\b\b\u0001\u0010\u0005\u001a\u00020\u00062\b\b\u0001\u0010\u0015\u001a\u00020aH'J,\u0010b\u001a\b\u0012\u0004\u0012\u00020c0\u00032\b\b\u0001\u0010\u0014\u001a\u00020\u00062\b\b\u0001\u0010\u0019\u001a\u00020\u00062\b\b\u0001\u0010d\u001a\u00020\u0006H'J\u001e\u0010e\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020f0=0\u00032\b\b\u0001\u0010d\u001a\u00020\u0006H'JT\u0010g\u001a\b\u0012\u0004\u0012\u00020h0\u00032\b\b\u0001\u0010\u0014\u001a\u00020\u00062\b\b\u0001\u0010\u0019\u001a\u00020\u00062\b\b\u0001\u0010\u001a\u001a\u00020\u00062\b\b\u0001\u0010!\u001a\u00020\u00062\b\b\u0001\u0010\"\u001a\u00020\u00062\b\b\u0001\u0010\u0005\u001a\u00020\u00062\b\b\u0001\u0010\u0015\u001a\u00020#H'J^\u0010i\u001a\b\u0012\u0004\u0012\u00020j0\u00032\b\b\u0001\u0010\r\u001a\u00020\u00062\b\b\u0001\u0010\u0014\u001a\u00020\u00062\b\b\u0001\u0010k\u001a\u00020D2\b\b\u0001\u0010l\u001a\u00020D2\b\b\u0001\u0010F\u001a\u00020\u00062\b\b\u0001\u0010m\u001a\u00020\u00062\b\b\u0001\u0010n\u001a\u00020\u00062\b\b\u0001\u0010U\u001a\u00020\u0006H'J\u0014\u0010o\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020p0=0\u0003H'J\"\u0010q\u001a\b\u0012\u0004\u0012\u00020r0\u00032\b\b\u0001\u0010s\u001a\u00020\u00062\b\b\u0001\u0010\u0014\u001a\u00020\u0006H'J@\u0010t\u001a\b\u0012\u0004\u0012\u00020u0\u00032\b\b\u0001\u0010\u0007\u001a\u00020\u00062\b\b\u0001\u0010\u0005\u001a\u00020\u00062\b\b\u0001\u0010\u0019\u001a\u00020\u00062\b\b\u0001\u0010\u001a\u001a\u00020\u00062\b\b\u0001\u0010v\u001a\u00020\u0006H'J\u0014\u0010w\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020p0=0\u0003H'JJ\u0010x\u001a\b\u0012\u0004\u0012\u00020y0\u00032\b\b\u0001\u0010\u0014\u001a\u00020\u00062\b\b\u0001\u0010z\u001a\u00020\u00062\b\b\u0001\u0010{\u001a\u00020\u00062\b\b\u0001\u0010|\u001a\u00020\u00062\b\b\u0001\u0010\u0019\u001a\u00020\u00062\b\b\u0001\u0010\u001a\u001a\u00020\u0006H'J\u001e\u0010}\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020~0=0\u00032\b\b\u0001\u0010\u0014\u001a\u00020\u0006H'JB\u0010\u001a\t\u0012\u0005\u0012\u00030\u00010\u00032\b\b\u0001\u0010\u0014\u001a\u00020\u00062\b\b\u0001\u0010\u0019\u001a\u00020\u00062\b\b\u0001\u0010\u001a\u001a\u00020\u00062\b\b\u0001\u0010\u0005\u001a\u00020\u00062\t\b\u0001\u0010\u0015\u001a\u00030\u0001H'JC\u0010\u0001\u001a\t\u0012\u0005\u0012\u00030\u00010\u00032\b\b\u0001\u0010\u0014\u001a\u00020\u00062\b\b\u0001\u0010\u0019\u001a\u00020\u00062\b\b\u0001\u0010\u001a\u001a\u00020\u00062\b\b\u0001\u0010\u0005\u001a\u00020\u00062\t\b\u0001\u0010\u0015\u001a\u00030\u0001H'JR\u0010\u0001\u001a\u000f\u0012\u000b\u0012\t\u0012\u0005\u0012\u00030\u00010=0\u00032\b\b\u0001\u0010\u0014\u001a\u00020\u00062\b\b\u0001\u0010\u0019\u001a\u00020\u00062\b\b\u0001\u0010\u001a\u001a\u00020\u00062\b\b\u0001\u0010!\u001a\u00020\u00062\b\b\u0001\u0010\"\u001a\u00020\u00062\b\b\u0001\u0010\u0005\u001a\u00020\u0006H'JW\u0010\u0001\u001a\t\u0012\u0005\u0012\u00030\u00010\u00032\b\b\u0001\u0010\u0014\u001a\u00020\u00062\b\b\u0001\u0010\u0019\u001a\u00020\u00062\b\b\u0001\u0010\u001a\u001a\u00020\u00062\b\b\u0001\u0010!\u001a\u00020\u00062\b\b\u0001\u0010\"\u001a\u00020\u00062\b\b\u0001\u0010\u0005\u001a\u00020\u00062\t\b\u0001\u0010\u0015\u001a\u00030\u0001H'J_\u0010\u0001\u001a\u001c\u0012\u0018\u0012\u0016\u0012\u0005\u0012\u00030\u00010\u0001j\n\u0012\u0005\u0012\u00030\u0001`\u00010\u00032\b\b\u0001\u0010\u0014\u001a\u00020\u00062\b\b\u0001\u0010\u0019\u001a\u00020\u00062\b\b\u0001\u0010\u001a\u001a\u00020\u00062\b\b\u0001\u0010!\u001a\u00020\u00062\b\b\u0001\u0010\"\u001a\u00020\u00062\b\b\u0001\u0010\u0005\u001a\u00020\u0006H'J\u0016\u0010\u0001\u001a\u000f\u0012\u000b\u0012\t\u0012\u0005\u0012\u00030\u00010=0\u0003H'J$\u0010\u0001\u001a\t\u0012\u0005\u0012\u00030\u00010\u00032\b\b\u0001\u0010\u0014\u001a\u00020\u00062\b\b\u0001\u0010\r\u001a\u00020\u0006H'Jl\u0010\u0001\u001a\t\u0012\u0005\u0012\u00030\u00010\u00032\b\b\u0001\u0010\u0014\u001a\u00020\u00062\b\b\u0001\u0010\u0005\u001a\u00020\u00062\b\b\u0001\u0010\u0019\u001a\u00020\u00062\b\b\u0001\u0010\u001a\u001a\u00020\u00062\b\b\u0001\u0010U\u001a\u00020\u00062\t\b\u0001\u0010\u0001\u001a\u00020D2\b\b\u0001\u0010l\u001a\u00020D2\b\b\u0001\u0010F\u001a\u00020\u00062\t\b\u0001\u0010\u0001\u001a\u00020DH'J\u001f\u0010\u0001\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020D0=0\u00032\b\b\u0001\u0010\u0005\u001a\u00020\u0006H'J\u0001\u0010\u0001\u001a\t\u0012\u0005\u0012\u00030\u00010\u00032\b\b\u0001\u0010\u0014\u001a\u00020\u00062\b\b\u0001\u0010\u0005\u001a\u00020\u00062\b\b\u0001\u0010\u0019\u001a\u00020\u00062\b\b\u0001\u0010\u001a\u001a\u00020\u00062\b\b\u0001\u0010U\u001a\u00020\u00062\t\b\u0001\u0010\u0001\u001a\u00020D2\t\b\u0001\u0010\u0001\u001a\u00020D2\b\b\u0001\u0010l\u001a\u00020D2\t\b\u0001\u0010\u0001\u001a\u00020\u00062\b\b\u0001\u0010F\u001a\u00020\u00062\t\b\u0001\u0010\u0001\u001a\u00020D2\t\b\u0001\u0010\u0001\u001a\u00020\u0006H'J/\u0010\u0001\u001a\t\u0012\u0005\u0012\u00030\u00010\u00032\t\b\u0001\u0010\u0001\u001a\u00020\u00062\b\b\u0001\u0010\u0014\u001a\u00020\u00062\b\b\u0001\u0010\u000f\u001a\u00020\u0006H'J/\u0010\u0001\u001a\t\u0012\u0005\u0012\u00030\u00010\u00032\b\b\u0001\u0010\u0014\u001a\u00020\u00062\b\b\u0001\u0010\u000f\u001a\u00020\u00062\t\b\u0001\u0010\u0015\u001a\u00030 \u0001H'JN\u0010¡\u0001\u001a\t\u0012\u0005\u0012\u00030¢\u00010\u00032\b\b\u0001\u0010\u0014\u001a\u00020\u00062\b\b\u0001\u0010\u000f\u001a\u00020\u00062\b\b\u0001\u0010&\u001a\u00020\u00062\t\b\u0001\u0010£\u0001\u001a\u00020\u00062\b\b\u0001\u0010'\u001a\u00020\u00062\t\b\u0001\u0010\u0015\u001a\u00030¤\u0001H'J%\u0010¥\u0001\u001a\t\u0012\u0005\u0012\u00030¦\u00010\u00032\b\b\u0001\u0010\"\u001a\u00020\u00062\t\b\u0001\u0010\u0015\u001a\u00030§\u0001H'J8\u0010¨\u0001\u001a\t\u0012\u0005\u0012\u00030©\u00010\u00032\b\b\u0001\u0010\u0014\u001a\u00020\u00062\b\b\u0001\u0010\r\u001a\u00020\u00062\b\b\u0001\u0010/\u001a\u00020\u00062\b\b\u0001\u0010\u000f\u001a\u00020\u0006H'JW\u0010ª\u0001\u001a\t\u0012\u0005\u0012\u00030«\u00010\u00032\b\b\u0001\u0010\u0014\u001a\u00020\u00062\b\b\u0001\u0010\u0019\u001a\u00020\u00062\b\b\u0001\u0010\u001a\u001a\u00020\u00062\b\b\u0001\u0010!\u001a\u00020\u00062\b\b\u0001\u0010\"\u001a\u00020\u00062\b\b\u0001\u0010\u0005\u001a\u00020\u00062\t\b\u0001\u0010\u0015\u001a\u00030¬\u0001H'Jk\u0010­\u0001\u001a\t\u0012\u0005\u0012\u00030®\u00010\u00032\b\b\u0001\u0010\u0014\u001a\u00020\u00062\b\b\u0001\u0010\u0019\u001a\u00020\u00062\b\b\u0001\u0010\u001a\u001a\u00020\u00062\b\b\u0001\u0010!\u001a\u00020\u00062\b\b\u0001\u0010\"\u001a\u00020\u00062\b\b\u0001\u0010\u0005\u001a\u00020\u00062\b\b\u0001\u0010\u0007\u001a\u00020\u00062\b\b\u0001\u0010\b\u001a\u00020\u00062\t\b\u0001\u0010\u0015\u001a\u00030¯\u0001H'JC\u0010°\u0001\u001a\t\u0012\u0005\u0012\u00030±\u00010\u00032\b\b\u0001\u0010\u0014\u001a\u00020\u00062\b\b\u0001\u0010\r\u001a\u00020\u00062\b\b\u0001\u0010/\u001a\u00020\u00062\b\b\u0001\u0010\u000f\u001a\u00020\u00062\t\b\u0001\u0010\u0015\u001a\u00030²\u0001H'JX\u0010³\u0001\u001a\t\u0012\u0005\u0012\u00030´\u00010\u00032\b\b\u0001\u0010\u0014\u001a\u00020\u00062\b\b\u0001\u0010\u000f\u001a\u00020\u00062\b\b\u0001\u0010&\u001a\u00020\u00062\t\b\u0001\u0010£\u0001\u001a\u00020\u00062\b\b\u0001\u0010'\u001a\u00020\u00062\b\b\u0001\u0010\"\u001a\u00020\u00062\t\b\u0001\u0010\u0015\u001a\u00030µ\u0001H'JW\u0010¶\u0001\u001a\t\u0012\u0005\u0012\u00030·\u00010\u00032\b\b\u0001\u0010\u0014\u001a\u00020\u00062\b\b\u0001\u0010\u0019\u001a\u00020\u00062\b\b\u0001\u0010\u001a\u001a\u00020\u00062\b\b\u0001\u0010!\u001a\u00020\u00062\b\b\u0001\u0010\"\u001a\u00020\u00062\b\b\u0001\u0010\u0005\u001a\u00020\u00062\t\b\u0001\u0010\u0015\u001a\u00030¸\u0001H'JL\u0010¹\u0001\u001a\t\u0012\u0005\u0012\u00030º\u00010\u00032\b\b\u0001\u0010\u0014\u001a\u00020\u00062\b\b\u0001\u0010\u0007\u001a\u00020\u00062\b\b\u0001\u0010\u0005\u001a\u00020\u00062\b\b\u0001\u0010\u0019\u001a\u00020\u00062\b\b\u0001\u0010\u001a\u001a\u00020\u00062\b\b\u0001\u0010\"\u001a\u00020\u0006H'JB\u0010»\u0001\u001a\b\u0012\u0004\u0012\u0002010\u00032\b\b\u0001\u0010\r\u001a\u00020\u00062\b\b\u0001\u0010\u0005\u001a\u00020\u00062\t\b\u0001\u0010¼\u0001\u001a\u00020\u00062\b\b\u0001\u0010/\u001a\u00020\u00062\b\b\u0001\u0010\u000f\u001a\u00020\u0006H'¨\u0006½\u0001"}, mo66933d2 = {"Lcom/iaai/android/bdt/network/Service;", "", "acceptBuyNowOffer", "Lio/reactivex/Observable;", "Lcom/iaai/android/bdt/model/productDetail/buyNowOffer/BDTBuyNowOfferResult;", "userId", "", "itemId", "auctionId", "branchid", "stockno", "acceptTermsOfUse", "Lcom/iaai/android/bdt/model/termsofuse/TermsOfUseResponse;", "userAgent", "deviceId", "deviceType", "ipAddress", "accepted", "applyDeliveryMethods", "Lcom/iaai/android/bdt/model/toBePaid/saleDocument/SaleDocResponse;", "authHeader", "requestBody", "Lcom/iaai/android/bdt/model/toBePaid/saleDocument/SaveDeliveryRequest;", "buyNow", "Lcom/iaai/android/bdt/model/productDetail/buyNow/BuyNowResult;", "culturecode", "devicetype", "IsUpstreamStock", "checkIsValidEmail", "", "email", "createPayPalCustomerID", "Lcom/iaai/android/bdt/model/toBePaid/PayPalCreateCustomerResponse;", "logger", "action", "Lcom/iaai/android/bdt/model/toBePaid/PayPalPaymentRequest;", "declineBuyNowOffer", "deleteSavedSearchList", "deviceid", "appversion", "savedText", "fastSearchV2", "Lcom/iaai/android/bdt/model/fastSearchFilter2/FastSearchResponse2;", "Lcom/iaai/android/bdt/model/fastSearchFilter2/FastSearchRequestBody;", "forgotPassword", "Lcom/iaai/android/bdt/model/login/BDTForgotPasswordResponse;", "username", "cultureCode", "generateOTP", "Lcom/iaai/android/bdt/model/login/GenerateOTPResponse;", "getAuctionMainList", "Lcom/iaai/android/bdt/model/auctionmainlist/AuctionMainListResponse;", "SortAscending", "query", "date", "Latitude", "Longitude", "getAuctionSalesList", "Lcom/iaai/android/bdt/model/auctionSalesList/AuctionSalesListResponse;", "Lcom/iaai/android/bdt/model/auctionSalesList/RequestBody;", "getBidHistory", "", "Lcom/iaai/android/bdt/model/productDetail/prebid/PreBidBidHistory;", "getBuyNowCloseTime", "getBuyNowOfferCount", "getBuyNowOfferList", "Lcom/iaai/android/bdt/model/MyAccount/BuyNowOfferListResponse;", "pagesize", "", "pagenumber", "sortBy", "sortasc", "salestatus", "bidstatus", "timezone", "getChromeDataByItemId", "Lcom/iaai/android/bdt/model/productDetail/chromeSection/ChromeData;", "getCostBreakDown", "Lcom/iaai/android/bdt/model/productDetail/costCalculator/CostCalculatorResponse;", "Lcom/iaai/android/bdt/model/productDetail/costCalculator/RequestBody;", "getCountryStateList", "Lcom/iaai/android/bdt/model/MyAccount/SaleDocCountryStateParentModel;", "getDashBoardDeatils", "Lcom/iaai/android/bdt/model/DashBoardDetails;", "userid", "onlymyitems", "getDashboardInfo", "Lcom/iaai/android/bdt/model/MyAccount/BDTDashboardResponse;", "getDeliveryMethods", "Lcom/iaai/android/bdt/model/toBePaid/getDeliveryMethod/GetDeliveryMethodResponse;", "Lcom/iaai/android/bdt/model/toBePaid/getDeliveryMethod/GetDeliveryMethodRequest;", "getGetPayPalInfo", "Lcom/iaai/android/bdt/model/toBePaid/PayPalInfoResponse;", "getMakeModelMasterData", "Lcom/iaai/android/bdt/model/fastSearch/MakeModelMaster;", "getManageBranchPrefList", "Lcom/iaai/android/bdt/model/MyAccount/ManageBranchPrefResponse;", "Lcom/iaai/android/bdt/model/MyAccount/MBRequestBody;", "getNegotiationList", "Lcom/iaai/android/bdt/model/digitalNegotiation/DigitalNegotiationListClass;", "salvageId", "getPartsSection", "Lcom/iaai/android/bdt/model/productDetail/partsSection/PartsSectionResponse;", "getPayPalToken", "Lcom/iaai/android/bdt/model/toBePaid/PayPalTokenResponse;", "getPaymentDueList", "Lcom/iaai/android/bdt/model/toBePaid/paymentDueList/PaymentDueListResponse;", "pageNumber", "count", "sortAsc", "paymentType", "getPopularCategoriesV4", "Lcom/iaai/android/bdt/model/quickFilter/QuickFilterResponse;", "getPremiumVehicleReport", "Lcom/iaai/android/bdt/model/productDetail/reports/PremiumVehicleReportModel;", "URL", "getProductDetail", "Lcom/iaai/android/bdt/model/productDetail/biddingInfo/ProductDetailResponse;", "tenantCode", "getQuickFilters", "getReceiptData", "Lcom/iaai/android/bdt/model/MyAccount/VehicleReceiptPDFResponse;", "receiptnumber", "receipttype", "salvageid", "getRecommendedVehicles", "Lcom/iaai/android/bdt/model/recommendedVehicles/RecommendedVehiclesResponse;", "getSaleDocList", "Lcom/iaai/android/bdt/model/toBePaid/saleDocument/defaultResponse/GetSaleDocListResponse;", "Lcom/iaai/android/bdt/model/toBePaid/saleDocument/GetSaleDocListRequest;", "getSaleDocListGroup", "Lcom/iaai/android/bdt/model/toBePaid/saleDocument/groupedByBranch/GetSaleDocListGroupResponse;", "getSaleDocumentBranchList", "Lcom/iaai/android/bdt/model/MyAccount/SaleDocBranchFilterResponse;", "getSaleDocumentInstructionList", "Lcom/iaai/android/bdt/model/MyAccount/SaleDocumentListResponse;", "Lcom/iaai/android/bdt/model/MyAccount/SaleDocumentRequestBody;", "getSavedSearchList", "Ljava/util/ArrayList;", "Lcom/iaai/android/bdt/model/savedSearchList/SavedSearchListResponse;", "Lkotlin/collections/ArrayList;", "getSearchMapping", "Lcom/iaai/android/bdt/model/fastSearchFilter2/SearchMappingArray;", "getTermsOfUseAuctionRule", "Lcom/iaai/android/bdt/model/login/AuctionRuleResponse;", "getToBePickedUpList", "Lcom/iaai/android/bdt/model/MyAccount/ToBePickedUpResponse;", "startIndex", "sortDirection", "getWatchList", "getWatchingList", "Lcom/iaai/android/bdt/model/MyAccount/WatchListResponse;", "lbsParentID", "status", "keyword", "insertAcceptAuctionRule", "Lcom/iaai/android/bdt/model/termsofuse/AuctionRuleAcceptModel;", "ipaddress", "insertRepOrAddress", "Lcom/iaai/android/bdt/model/MyAccount/InsertRepOrAddressResponse;", "Lcom/iaai/android/bdt/model/MyAccount/InsertRepOrAddressRequest;", "loadFastSearchV2", "Lcom/iaai/android/bdt/model/fastSearch/FastSearchResponse;", "apikey", "Lcom/iaai/android/bdt/model/fastSearch/SearchInputV2;", "logIAAError", "Lcom/iaai/android/bdt/model/logIAAError/LogIAAErrorResponse;", "Lcom/iaai/android/bdt/model/logIAAError/LogIAAErrorRequest;", "login", "Lcom/iaai/android/bdt/model/login/BDTLoginResponse;", "makePayPalCheckOut", "Lcom/iaai/android/bdt/model/toBePaid/PayPalCheckOutResponse;", "Lcom/iaai/android/bdt/model/toBePaid/MakePayPalPaymentRequest;", "placePreBid", "Lcom/iaai/android/bdt/model/productDetail/prebid/PreBidPlacedResult;", "Lcom/iaai/android/bdt/model/productDetail/prebid/RequestBody;", "registerFCMToken", "Lcom/iaai/android/bdt/model/login/FCMTokenResponse;", "Lcom/iaai/android/bdt/model/login/FCMTokenRequest;", "saveSearch", "Lcom/iaai/android/bdt/model/saveSearch/SaveSearchResponse;", "Lcom/iaai/android/bdt/model/saveSearch/SaveSearchRequest;", "sendManageOfferAction", "Lcom/iaai/android/bdt/model/digitalNegotiation/ManageOfferSendActionResponse;", "Lcom/iaai/android/bdt/model/digitalNegotiation/ManageOfferSendActionRequestBody;", "updateWatchStatus", "Lcom/iaai/android/bdt/model/profile/UpdateWatchListResponse;", "validateOTP", "otp", "app_productionRelease"}, mo66934k = 1, mo66935mv = {1, 1, 13})
/* compiled from: Service.kt */
public interface Service {
    @NotNull
    @GET("/acserviceswebapi/api/AcceptBuyNowOffer/")
    Observable<BDTBuyNowOfferResult> acceptBuyNowOffer(@NotNull @Query("userid") String str, @NotNull @Query("itemid") String str2, @NotNull @Query("auctionid") String str3, @NotNull @Query("branchid") String str4, @NotNull @Query("stockno") String str5);

    @NotNull
    @GET("LoginService.svc/savetermsofuse/")
    Observable<TermsOfUseResponse> acceptTermsOfUse(@NotNull @Header("User-Agent") String str, @NotNull @Header("deviceId") String str2, @NotNull @Header("devicetype") String str3, @NotNull @Query("ip") String str4, @NotNull @Query("acceptedterms") String str5, @Nullable @Query("userid") String str6);

    @NotNull
    @POST("acserviceswebapi/api/savesaledoc")
    Observable<SaleDocResponse> applyDeliveryMethods(@NotNull @Header("Authorization") String str, @NotNull @Header("devicetype") String str2, @NotNull @Body SaveDeliveryRequest saveDeliveryRequest);

    @NotNull
    @POST("/PreBidding.svc/buynowibuyfast/itemid/{itemId}/")
    Observable<BuyNowResult> buyNow(@NotNull @Header("Authorization") String str, @NotNull @Path("itemId") String str2, @NotNull @Query("userid") String str3, @NotNull @Query("auctionid") String str4, @NotNull @Query("culturecode") String str5, @NotNull @Query("devicetype") String str6, @Nullable @Query("IsUpstreamStock") String str7);

    @NotNull
    @GET("acserviceswebapi/api/IsValidEmail/")
    Observable<Boolean> checkIsValidEmail(@NotNull @Header("User-Agent") String str, @NotNull @Query("email") String str2);

    @NotNull
    @POST("acserviceswebapi/api/createpaypalcustomer/")
    Observable<PayPalCreateCustomerResponse> createPayPalCustomerID(@NotNull @Header("Authorization") String str, @NotNull @Header("deviceid") String str2, @NotNull @Header("devicetype") String str3, @NotNull @Header("apikey") String str4, @NotNull @Header("Content-Type") String str5, @NotNull @Header("appversion") String str6, @NotNull @Body PayPalPaymentRequest payPalPaymentRequest);

    @NotNull
    @GET("acserviceswebapi/api/DeclineBuyNowOffer/")
    Observable<String> declineBuyNowOffer(@NotNull @Query("userid") String str, @NotNull @Query("itemid") String str2, @NotNull @Query("auctionid") String str3, @NotNull @Query("branchid") String str4, @NotNull @Query("stockno") String str5);

    @NotNull
    @GET("/acserviceswebapi/api/deletesavedsearch/")
    Observable<Boolean> deleteSavedSearchList(@NotNull @Header("Content-Type") String str, @NotNull @Header("Authorization") String str2, @NotNull @Header("devicetype") String str3, @NotNull @Header("deviceid") String str4, @NotNull @Header("apikey") String str5, @NotNull @Header("appversion") String str6, @NotNull @Query("savedtext") String str7);

    @NotNull
    @POST("acserviceswebapi/api/searchV2/")
    Observable<FastSearchResponse2> fastSearchV2(@NotNull @Header("Content-Type") String str, @NotNull @Body FastSearchRequestBody fastSearchRequestBody, @NotNull @Header("Authorization") String str2);

    @NotNull
    @GET("/LoginService.svc/GetpasswordUrl/")
    Observable<BDTForgotPasswordResponse> forgotPassword(@NotNull @Header("User-Agent") String str, @NotNull @Query("username") String str2, @NotNull @Query("culturecode") String str3, @NotNull @Query("deviceType") String str4);

    @NotNull
    @GET("acserviceswebapi/api/GenerateOTP/")
    Observable<GenerateOTPResponse> generateOTP(@NotNull @Header("User-Agent") String str, @NotNull @Query("userid") String str2, @NotNull @Query("email") String str3, @NotNull @Query("culturecode") String str4, @NotNull @Query("deviceType") String str5);

    @NotNull
    @GET("/AuctionSaleListV2.svc/auctionlocations/")
    Observable<AuctionMainListResponse> getAuctionMainList(@NotNull @Query("culturecode") String str, @NotNull @Query("devicetype") String str2, @Query("SortAscending") boolean z, @NotNull @Query("query") String str3, @NotNull @Query("Date") String str4, @NotNull @Query("Latitude") String str5, @NotNull @Query("Longitude") String str6);

    @NotNull
    @POST("/AuctionSaleListV2.svc/auctionsalelist/")
    Observable<AuctionSalesListResponse> getAuctionSalesList(@NotNull @Header("Authorization") String str, @NotNull @Body RequestBody requestBody);

    @NotNull
    @GET("/PreBidding.svc/bidhistory/")
    Observable<List<PreBidBidHistory>> getBidHistory(@NotNull @Query("userid") String str, @NotNull @Query("itemid") String str2, @NotNull @Query("auctionid") String str3, @NotNull @Query("culturecode") String str4, @NotNull @Query("devicetype") String str5);

    @NotNull
    @GET("acserviceswebapi/api/GetBuyNowOfferCloseTimeCST/")
    Observable<String> getBuyNowCloseTime(@NotNull @Header("User-Agent") String str);

    @NotNull
    @GET("/acserviceswebapi/api/GetBuyNowOfferCount")
    Observable<String> getBuyNowOfferCount(@NotNull @Header("User-Agent") String str, @NotNull @Query("userid") String str2);

    @NotNull
    @GET("acserviceswebapi/api/GetBuyNowVehicleList/")
    Observable<BuyNowOfferListResponse> getBuyNowOfferList(@NotNull @Header("User-Agent") String str, @NotNull @Query("userid") String str2, @Query("pagesize") int i, @Query("pagenumber") int i2, @NotNull @Query("sortby") String str3, @Query("sortasc") boolean z, @NotNull @Query("salestatus") String str4, @NotNull @Query("bidstatus") String str5, @Query("timezone") int i3);

    @NotNull
    @GET("acserviceswebapi/api/GetChromeDataByItem/{itemId}")
    Observable<ChromeData> getChromeDataByItemId(@NotNull @Path("itemId") String str);

    @NotNull
    @POST("acserviceswebapi/api/CostCalculator/")
    Observable<CostCalculatorResponse> getCostBreakDown(@NotNull @Body com.iaai.android.bdt.model.productDetail.costCalculator.RequestBody requestBody);

    @NotNull
    @GET("acserviceswebapi/api/getcountrystateinfo/")
    Observable<SaleDocCountryStateParentModel> getCountryStateList();

    @NotNull
    @GET("DashBoard.svc/dashboard/V2/userid/{userid}/")
    Observable<DashBoardDetails> getDashBoardDeatils(@Path("userid") int i, @NotNull @Header("Authorization") String str, @NotNull @Query("culturecode") String str2, @NotNull @Query("deviceType") String str3, @Query("onlymyitems") int i2);

    @NotNull
    @GET("/DashBoard.svc/dashboard/V2/userid/{userid}/")
    Observable<BDTDashboardResponse> getDashboardInfo(@NotNull @Header("Authorization") String str, @NotNull @Header("User-Agent") String str2, @NotNull @Path("userid") String str3, @NotNull @Query("onlymyitems") String str4, @NotNull @Query("culturecode") String str5, @NotNull @Query("deviceType") String str6);

    @NotNull
    @POST("acserviceswebapi/api/getdeliverymethods")
    Observable<GetDeliveryMethodResponse> getDeliveryMethods(@NotNull @Header("Authorization") String str, @NotNull @Header("devicetype") String str2, @NotNull @Body GetDeliveryMethodRequest getDeliveryMethodRequest);

    @NotNull
    @GET("acserviceswebapi/api/GetPayPalInfo/")
    Observable<PayPalInfoResponse> getGetPayPalInfo(@NotNull @Header("Authorization") String str);

    @NotNull
    @GET("/acserviceswebapi/api/GetMakeModel/")
    Observable<List<MakeModelMaster>> getMakeModelMasterData();

    @NotNull
    @POST("acserviceswebapi/api/getbranchdefaults/")
    Observable<ManageBranchPrefResponse> getManageBranchPrefList(@NotNull @Header("Authorization") String str, @NotNull @Header("deviceid") String str2, @NotNull @Header("devicetype") String str3, @NotNull @Header("apikey") String str4, @NotNull @Header("Content-Type") String str5, @NotNull @Header("appversion") String str6, @NotNull @Body MBRequestBody mBRequestBody);

    @NotNull
    @GET("acserviceswebapi/api/GetNegotiationList/")
    Observable<DigitalNegotiationListClass> getNegotiationList(@NotNull @Header("Authorization") String str, @NotNull @Query("culturecode") String str2, @NotNull @Query("salvageid") String str3);

    @NotNull
    @GET("/acserviceswebapi/api/GetHollanderParts/")
    Observable<List<PartsSectionResponse>> getPartsSection(@NotNull @Query("salvageid") String str);

    @NotNull
    @POST("acserviceswebapi/api/generatepaypaltoken/")
    Observable<PayPalTokenResponse> getPayPalToken(@NotNull @Header("Authorization") String str, @NotNull @Header("deviceid") String str2, @NotNull @Header("devicetype") String str3, @NotNull @Header("apikey") String str4, @NotNull @Header("Content-Type") String str5, @NotNull @Header("appversion") String str6, @NotNull @Body PayPalPaymentRequest payPalPaymentRequest);

    @NotNull
    @GET("acserviceswebapi/api/GetPaymentDueList/")
    Observable<PaymentDueListResponse> getPaymentDueList(@NotNull @Header("User-Agent") String str, @NotNull @Header("Authorization") String str2, @Query("pagenumber") int i, @Query("count") int i2, @NotNull @Query("sortby") String str3, @NotNull @Query("sortasc") String str4, @NotNull @Query("paymenttype") String str5, @NotNull @Query("onlymyitems") String str6);

    @NotNull
    @GET("/acserviceswebapi/api/GetPopularCategoriesV4/")
    Observable<List<QuickFilterResponse>> getPopularCategoriesV4();

    @NotNull
    @GET("")
    Observable<PremiumVehicleReportModel> getPremiumVehicleReport(@NotNull @Url String str, @NotNull @Header("Authorization") String str2);

    @NotNull
    @GET("/acserviceswebapi/api/GetVehicleDetailsV2/")
    Observable<ProductDetailResponse> getProductDetail(@NotNull @Query("itemId") String str, @NotNull @Query("userId") String str2, @NotNull @Query("culturecode") String str3, @NotNull @Query("devicetype") String str4, @NotNull @Query("tenant") String str5);

    @NotNull
    @GET("/acserviceswebapi/api/GetPopularCategoriesV3/")
    Observable<List<QuickFilterResponse>> getQuickFilters();

    @NotNull
    @GET("VehicleDetails.svc/Asapreceipt/")
    Observable<VehicleReceiptPDFResponse> getReceiptData(@NotNull @Header("Authorization") String str, @NotNull @Query("receiptnumber") String str2, @NotNull @Query("receipttype") String str3, @NotNull @Query("salvageid") String str4, @NotNull @Query("culturecode") String str5, @NotNull @Query("devicetype") String str6);

    @NotNull
    @GET("/acserviceswebapi/api/GetRecommendation/")
    Observable<List<RecommendedVehiclesResponse>> getRecommendedVehicles(@NotNull @Header("Authorization") String str);

    @NotNull
    @POST("acserviceswebapi/api/getsaledoclist/")
    Observable<GetSaleDocListResponse> getSaleDocList(@NotNull @Header("Authorization") String str, @NotNull @Header("deviceid") String str2, @NotNull @Header("devicetype") String str3, @NotNull @Header("appversion") String str4, @NotNull @Body GetSaleDocListRequest getSaleDocListRequest);

    @NotNull
    @POST("acserviceswebapi/api/getsaledoclistgroup/")
    Observable<GetSaleDocListGroupResponse> getSaleDocListGroup(@NotNull @Header("Authorization") String str, @NotNull @Header("deviceid") String str2, @NotNull @Header("devicetype") String str3, @NotNull @Header("appversion") String str4, @NotNull @Body GetSaleDocListRequest getSaleDocListRequest);

    @NotNull
    @GET("acserviceswebapi/api/getsaledocbranchfilter/")
    Observable<List<SaleDocBranchFilterResponse>> getSaleDocumentBranchList(@NotNull @Header("Authorization") String str, @NotNull @Header("deviceid") String str2, @NotNull @Header("devicetype") String str3, @NotNull @Header("apikey") String str4, @NotNull @Header("Content-Type") String str5, @NotNull @Header("appversion") String str6);

    @NotNull
    @POST("acserviceswebapi/api/getsaledoclist/")
    Observable<SaleDocumentListResponse> getSaleDocumentInstructionList(@NotNull @Header("Authorization") String str, @NotNull @Header("deviceid") String str2, @NotNull @Header("devicetype") String str3, @NotNull @Header("apikey") String str4, @NotNull @Header("Content-Type") String str5, @NotNull @Header("appversion") String str6, @NotNull @Body SaleDocumentRequestBody saleDocumentRequestBody);

    @NotNull
    @GET("acserviceswebapi/api/getsavedsearch/")
    Observable<ArrayList<SavedSearchListResponse>> getSavedSearchList(@NotNull @Header("Authorization") String str, @NotNull @Header("deviceid") String str2, @NotNull @Header("devicetype") String str3, @NotNull @Header("apikey") String str4, @NotNull @Header("Content-Type") String str5, @NotNull @Header("appversion") String str6);

    @NotNull
    @GET("acserviceswebapi/api/GetSearchMapping/")
    Observable<List<SearchMappingArray>> getSearchMapping();

    @NotNull
    @GET("/acserviceswebapi/api/GetTermsOfUse/")
    Observable<AuctionRuleResponse> getTermsOfUseAuctionRule(@NotNull @Header("Authorization") String str, @NotNull @Header("User-Agent") String str2);

    @NotNull
    @GET("Dashboard.svc/tobepickeduplist/userid/{userid}/")
    Observable<ToBePickedUpResponse> getToBePickedUpList(@NotNull @Header("Authorization") String str, @NotNull @Path("userid") String str2, @NotNull @Query("culturecode") String str3, @NotNull @Query("devicetype") String str4, @NotNull @Query("onlymyitems") String str5, @Query("startindex") int i, @Query("count") int i2, @NotNull @Query("sortby") String str6, @Query("direction") int i3);

    @NotNull
    @GET("/acserviceswebapi/api/GetWatchList/")
    Observable<List<Integer>> getWatchList(@NotNull @Query("userid") String str);

    @NotNull
    @GET("/dashboard.svc/myvehicles/userid/{userid}/")
    Observable<WatchListResponse> getWatchingList(@NotNull @Header("Authorization") String str, @NotNull @Path("userid") String str2, @NotNull @Query("culturecode") String str3, @NotNull @Query("devicetype") String str4, @NotNull @Query("onlymyitems") String str5, @Query("lbsparentind") int i, @Query("startindex") int i2, @Query("count") int i3, @NotNull @Query("status") String str6, @NotNull @Query("sortby") String str7, @Query("direction") int i4, @NotNull @Query("keyword") String str8);

    @NotNull
    @GET("acserviceswebapi/api/InsertTermsOfUse/")
    Observable<AuctionRuleAcceptModel> insertAcceptAuctionRule(@NotNull @Query("ipaddress") String str, @NotNull @Header("Authorization") String str2, @NotNull @Header("devicetype") String str3);

    @NotNull
    @POST("acserviceswebapi/api/insertreporaddress/")
    Observable<InsertRepOrAddressResponse> insertRepOrAddress(@NotNull @Header("Authorization") String str, @NotNull @Header("devicetype") String str2, @NotNull @Body InsertRepOrAddressRequest insertRepOrAddressRequest);

    @NotNull
    @POST("acserviceswebapi/api/Search/")
    Observable<FastSearchResponse> loadFastSearchV2(@NotNull @Header("Authorization") String str, @NotNull @Header("devicetype") String str2, @NotNull @Header("deviceid") String str3, @NotNull @Header("apikey") String str4, @NotNull @Header("appversion") String str5, @NotNull @Body SearchInputV2 searchInputV2);

    @NotNull
    @POST("acserviceswebapi/api/GenerateLog")
    Observable<LogIAAErrorResponse> logIAAError(@NotNull @Header("Content-Type") String str, @NotNull @Body LogIAAErrorRequest logIAAErrorRequest);

    @NotNull
    @GET("/LoginService.svc/login/")
    Observable<BDTLoginResponse> login(@NotNull @Header("Authorization") String str, @NotNull @Header("User-Agent") String str2, @NotNull @Query("culturecode") String str3, @NotNull @Query("deviceType") String str4);

    @NotNull
    @POST("acserviceswebapi/api/makepaypalpayment/")
    Observable<PayPalCheckOutResponse> makePayPalCheckOut(@NotNull @Header("Authorization") String str, @NotNull @Header("deviceid") String str2, @NotNull @Header("devicetype") String str3, @NotNull @Header("apikey") String str4, @NotNull @Header("Content-Type") String str5, @NotNull @Header("appversion") String str6, @NotNull @Body MakePayPalPaymentRequest makePayPalPaymentRequest);

    @NotNull
    @POST("/PreBidding.svc/placebid/")
    Observable<PreBidPlacedResult> placePreBid(@NotNull @Header("Authorization") String str, @NotNull @Query("culturecode") String str2, @NotNull @Query("devicetype") String str3, @NotNull @Query("logger") String str4, @NotNull @Query("action") String str5, @NotNull @Query("userid") String str6, @NotNull @Query("itemid") String str7, @NotNull @Query("auctionid") String str8, @NotNull @Body com.iaai.android.bdt.model.productDetail.prebid.RequestBody requestBody);

    @NotNull
    @POST("AcceptingTokens.svc/tokeninformation/")
    Observable<FCMTokenResponse> registerFCMToken(@NotNull @Header("Authorization") String str, @NotNull @Header("User-Agent") String str2, @NotNull @Query("culturecode") String str3, @NotNull @Query("deviceType") String str4, @NotNull @Body FCMTokenRequest fCMTokenRequest);

    @NotNull
    @POST("acserviceswebapi/api/insertsavedsearch/")
    Observable<SaveSearchResponse> saveSearch(@NotNull @Header("Authorization") String str, @NotNull @Header("devicetype") String str2, @NotNull @Header("deviceid") String str3, @NotNull @Header("apikey") String str4, @NotNull @Header("appversion") String str5, @NotNull @Header("Content-Type") String str6, @NotNull @Body SaveSearchRequest saveSearchRequest);

    @NotNull
    @POST("acserviceswebapi/api/UpdateAction/")
    Observable<ManageOfferSendActionResponse> sendManageOfferAction(@NotNull @Header("Authorization") String str, @NotNull @Header("deviceid") String str2, @NotNull @Header("devicetype") String str3, @NotNull @Header("apikey") String str4, @NotNull @Header("Content-Type") String str5, @NotNull @Header("appversion") String str6, @NotNull @Body ManageOfferSendActionRequestBody manageOfferSendActionRequestBody);

    @NotNull
    @GET("Prebidding.svc/watchlist/itemid/{itemId}")
    Observable<UpdateWatchListResponse> updateWatchStatus(@NotNull @Header("Authorization") String str, @NotNull @Path("itemId") String str2, @NotNull @Query("userid") String str3, @NotNull @Query("culturecode") String str4, @NotNull @Query("devicetype") String str5, @NotNull @Query("action") String str6);

    @NotNull
    @GET("acserviceswebapi/api/ValidateOTP/")
    Observable<GenerateOTPResponse> validateOTP(@NotNull @Header("User-Agent") String str, @NotNull @Query("userid") String str2, @NotNull @Query("otp") String str3, @NotNull @Query("culturecode") String str4, @NotNull @Query("deviceType") String str5);
}

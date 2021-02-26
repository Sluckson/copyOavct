package com.iaai.android.bdt.injection.module;

import com.iaai.android.bdt.base.BaseActivity;
import com.iaai.android.bdt.feature.account.BDTMyAccountActivity;
import com.iaai.android.bdt.feature.account.BDTSettingsActivity;
import com.iaai.android.bdt.feature.account.buyNowOfferList.BuyNowOfferListActivity;
import com.iaai.android.bdt.feature.account.salesdocument.SalesDocumentActivity;
import com.iaai.android.bdt.feature.account.salesdocument.manageBranchPref.ManageBranchPrefActivity;
import com.iaai.android.bdt.feature.account.tobepickedup.ToPickedUpAccountActivity;
import com.iaai.android.bdt.feature.account.watchlist.PreSaleListActivity;
import com.iaai.android.bdt.feature.account.watchlist.ReceiptDPFActivity;
import com.iaai.android.bdt.feature.applaunch.SplashActivity;
import com.iaai.android.bdt.feature.auctionMainPage.AuctionDateListActivity;
import com.iaai.android.bdt.feature.auctionMainPage.BDTAuctionMainListActivity;
import com.iaai.android.bdt.feature.auctionSalesList.AuctionSalesListActivity;
import com.iaai.android.bdt.feature.digitalNegotiation.ManageOfferListActivity;
import com.iaai.android.bdt.feature.fastSearchFilter.newFindVehicle.FastSearchFilterActivity;
import com.iaai.android.bdt.feature.fastSearchFilter.newFindVehicle.SearchByACVActivity;
import com.iaai.android.bdt.feature.fastSearchFilter.newFindVehicle.SearchByDistanceActivity;
import com.iaai.android.bdt.feature.fastSearchFilter.newFindVehicle.SearchByOdometerActivity;
import com.iaai.android.bdt.feature.fastSearchFilter.refinerResults.RefinerResultActivity;
import com.iaai.android.bdt.feature.fastSearchFilter.savedSearch.SavedSearchActivity;
import com.iaai.android.bdt.feature.findVehiclePage.filter.FilterActivity;
import com.iaai.android.bdt.feature.findVehiclePage.filter.FindVehicleFilterActivity;
import com.iaai.android.bdt.feature.findVehiclePage.filter.MakeModelFilterActivity;
import com.iaai.android.bdt.feature.findVehiclePage.filter.SubFilterActivity;
import com.iaai.android.bdt.feature.findVehiclePage.searchResult.SearchResultActivity;
import com.iaai.android.bdt.feature.landing.BDTLandingPageActivity;
import com.iaai.android.bdt.feature.landing.LandingBRESectionActivity;
import com.iaai.android.bdt.feature.login.BDTForgotPasswordActivity;
import com.iaai.android.bdt.feature.login.BDTLoginActivity;
import com.iaai.android.bdt.feature.login.BDTPromptPasswordDialogActivity;
import com.iaai.android.bdt.feature.login.BDTTermsOfUseActivity;
import com.iaai.android.bdt.feature.login.emailValidation.EmailConfirmationActivity;
import com.iaai.android.bdt.feature.login.emailValidation.ValidateOTPActivity;
import com.iaai.android.bdt.feature.main.MainActivity;
import com.iaai.android.bdt.feature.myAccount.toBePaid.BDTPaymentActivity;
import com.iaai.android.bdt.feature.myAccount.toBePaid.BDTPaymentMethodActivity;
import com.iaai.android.bdt.feature.myAccount.toBePaid.saleDocList.DeliveryMethodActivity;
import com.iaai.android.bdt.feature.myAccount.toBePaid.saleDocList.SaleDocListActivity;
import com.iaai.android.bdt.feature.onBoarding.OnBoardingActivity;
import com.iaai.android.bdt.feature.productDetail.EngineVideoActivity;
import com.iaai.android.bdt.feature.productDetail.ProductDetailActivity;
import com.iaai.android.bdt.feature.productDetail.reports.BDTPremiumVehicleReportActivity;
import com.iaai.android.bdt.feature.productDetail.reports.IAAConditionReportActivity;
import com.iaai.android.bdt.feature.productDetail.vehicleimage.Product360ImageActivity;
import com.iaai.android.bdt.feature.termsofuse.TermsOfUseAuctionRuleActivity;
import com.iaai.android.bdt.feature.utilsActivity.WebViewActivity;
import dagger.Module;
import dagger.android.ContributesAndroidInjector;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(mo66931bv = {1, 0, 3}, mo66932d1 = {"\u0000ü\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b'\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\r\u0010\u0003\u001a\u00020\u0004H!¢\u0006\u0002\b\u0005J\r\u0010\u0006\u001a\u00020\u0007H!¢\u0006\u0002\b\bJ\r\u0010\t\u001a\u00020\nH!¢\u0006\u0002\b\u000bJ\r\u0010\f\u001a\u00020\rH!¢\u0006\u0002\b\u000eJ\r\u0010\u000f\u001a\u00020\u0010H!¢\u0006\u0002\b\u0011J\r\u0010\u0012\u001a\u00020\u0013H!¢\u0006\u0002\b\u0014J\r\u0010\u0015\u001a\u00020\u0016H!¢\u0006\u0002\b\u0017J\r\u0010\u0018\u001a\u00020\u0019H!¢\u0006\u0002\b\u001aJ\r\u0010\u001b\u001a\u00020\u001cH!¢\u0006\u0002\b\u001dJ\r\u0010\u001e\u001a\u00020\u001fH!¢\u0006\u0002\b J\r\u0010!\u001a\u00020\"H!¢\u0006\u0002\b#J\r\u0010$\u001a\u00020%H!¢\u0006\u0002\b&J\r\u0010'\u001a\u00020(H!¢\u0006\u0002\b)J\r\u0010*\u001a\u00020+H!¢\u0006\u0002\b,J\r\u0010-\u001a\u00020.H!¢\u0006\u0002\b/J\r\u00100\u001a\u000201H!¢\u0006\u0002\b2J\r\u00103\u001a\u000204H!¢\u0006\u0002\b5J\r\u00106\u001a\u000207H!¢\u0006\u0002\b8J\r\u00109\u001a\u00020:H!¢\u0006\u0002\b;J\r\u0010<\u001a\u00020=H!¢\u0006\u0002\b>J\r\u0010?\u001a\u00020@H!¢\u0006\u0002\bAJ\r\u0010B\u001a\u00020CH!¢\u0006\u0002\bDJ\r\u0010E\u001a\u00020FH!¢\u0006\u0002\bGJ\r\u0010H\u001a\u00020IH!¢\u0006\u0002\bJJ\r\u0010K\u001a\u00020LH!¢\u0006\u0002\bMJ\r\u0010N\u001a\u00020OH!¢\u0006\u0002\bPJ\r\u0010Q\u001a\u00020RH!¢\u0006\u0002\bSJ\r\u0010T\u001a\u00020UH!¢\u0006\u0002\bVJ\r\u0010W\u001a\u00020XH!¢\u0006\u0002\bYJ\r\u0010Z\u001a\u00020[H!¢\u0006\u0002\b\\J\r\u0010]\u001a\u00020^H!¢\u0006\u0002\b_J\r\u0010`\u001a\u00020aH!¢\u0006\u0002\bbJ\r\u0010c\u001a\u00020dH!¢\u0006\u0002\beJ\r\u0010f\u001a\u00020gH!¢\u0006\u0002\bhJ\r\u0010i\u001a\u00020jH!¢\u0006\u0002\bkJ\r\u0010l\u001a\u00020mH!¢\u0006\u0002\bnJ\r\u0010o\u001a\u00020pH!¢\u0006\u0002\bqJ\r\u0010r\u001a\u00020sH!¢\u0006\u0002\btJ\r\u0010u\u001a\u00020vH!¢\u0006\u0002\bwJ\r\u0010x\u001a\u00020yH!¢\u0006\u0002\bzJ\r\u0010{\u001a\u00020|H!¢\u0006\u0002\b}J\u000e\u0010~\u001a\u00020H!¢\u0006\u0003\b\u0001J\u0010\u0010\u0001\u001a\u00030\u0001H!¢\u0006\u0003\b\u0001J\u0010\u0010\u0001\u001a\u00030\u0001H!¢\u0006\u0003\b\u0001J\u0010\u0010\u0001\u001a\u00030\u0001H!¢\u0006\u0003\b\u0001J\u0010\u0010\u0001\u001a\u00030\u0001H!¢\u0006\u0003\b\u0001¨\u0006\u0001"}, mo66933d2 = {"Lcom/iaai/android/bdt/injection/module/ActivityModule;", "", "()V", "contributeAFCTermsPage", "Lcom/iaai/android/bdt/feature/account/watchlist/ReceiptDPFActivity;", "contributeAFCTermsPage$app_productionRelease", "contributeAuctionDateListActivity", "Lcom/iaai/android/bdt/feature/auctionMainPage/AuctionDateListActivity;", "contributeAuctionDateListActivity$app_productionRelease", "contributeAuctionProductDetailActivity", "Lcom/iaai/android/bdt/feature/productDetail/ProductDetailActivity;", "contributeAuctionProductDetailActivity$app_productionRelease", "contributeAuctionSalesListActivity", "Lcom/iaai/android/bdt/feature/auctionSalesList/AuctionSalesListActivity;", "contributeAuctionSalesListActivity$app_productionRelease", "contributeBDTAuctionMainListActivity", "Lcom/iaai/android/bdt/feature/auctionMainPage/BDTAuctionMainListActivity;", "contributeBDTAuctionMainListActivity$app_productionRelease", "contributeBDTFindVehicleActivity", "Lcom/iaai/android/bdt/feature/landing/BDTLandingPageActivity;", "contributeBDTFindVehicleActivity$app_productionRelease", "contributeBDTForgotPasswordActivity", "Lcom/iaai/android/bdt/feature/login/BDTForgotPasswordActivity;", "contributeBDTForgotPasswordActivity$app_productionRelease", "contributeBDTLoginActivity", "Lcom/iaai/android/bdt/feature/login/BDTLoginActivity;", "contributeBDTLoginActivity$app_productionRelease", "contributeBDTMyAccountActivity", "Lcom/iaai/android/bdt/feature/account/BDTMyAccountActivity;", "contributeBDTMyAccountActivity$app_productionRelease", "contributeBDTPaymentMethodActivity", "Lcom/iaai/android/bdt/feature/myAccount/toBePaid/BDTPaymentMethodActivity;", "contributeBDTPaymentMethodActivity$app_productionRelease", "contributeBDTPremiumVehicleReportActivity", "Lcom/iaai/android/bdt/feature/productDetail/reports/BDTPremiumVehicleReportActivity;", "contributeBDTPremiumVehicleReportActivity$app_productionRelease", "contributeBDTPromptPasswordDialogActivity", "Lcom/iaai/android/bdt/feature/login/BDTPromptPasswordDialogActivity;", "contributeBDTPromptPasswordDialogActivity$app_productionRelease", "contributeBDTSettingsActivity", "Lcom/iaai/android/bdt/feature/account/BDTSettingsActivity;", "contributeBDTSettingsActivity$app_productionRelease", "contributeBDTTermsOfUseActivity", "Lcom/iaai/android/bdt/feature/login/BDTTermsOfUseActivity;", "contributeBDTTermsOfUseActivity$app_productionRelease", "contributeBaseActivity", "Lcom/iaai/android/bdt/base/BaseActivity;", "contributeBaseActivity$app_productionRelease", "contributeBuyNowOfferListActivity", "Lcom/iaai/android/bdt/feature/account/buyNowOfferList/BuyNowOfferListActivity;", "contributeBuyNowOfferListActivity$app_productionRelease", "contributeCreditCardActivity", "Lcom/iaai/android/bdt/feature/myAccount/toBePaid/BDTPaymentActivity;", "contributeCreditCardActivity$app_productionRelease", "contributeDeliveryMethodActivity", "Lcom/iaai/android/bdt/feature/myAccount/toBePaid/saleDocList/DeliveryMethodActivity;", "contributeDeliveryMethodActivity$app_productionRelease", "contributeEmailConfirmationActivity", "Lcom/iaai/android/bdt/feature/login/emailValidation/EmailConfirmationActivity;", "contributeEmailConfirmationActivity$app_productionRelease", "contributeEngineVideoActivity", "Lcom/iaai/android/bdt/feature/productDetail/EngineVideoActivity;", "contributeEngineVideoActivity$app_productionRelease", "contributeFastSearchFilterActivity", "Lcom/iaai/android/bdt/feature/fastSearchFilter/newFindVehicle/FastSearchFilterActivity;", "contributeFastSearchFilterActivity$app_productionRelease", "contributeFilterActivity", "Lcom/iaai/android/bdt/feature/findVehiclePage/filter/FilterActivity;", "contributeFilterActivity$app_productionRelease", "contributeFindVehicleFilterActivity", "Lcom/iaai/android/bdt/feature/findVehiclePage/filter/FindVehicleFilterActivity;", "contributeFindVehicleFilterActivity$app_productionRelease", "contributeIAAConditionReportActivity", "Lcom/iaai/android/bdt/feature/productDetail/reports/IAAConditionReportActivity;", "contributeIAAConditionReportActivity$app_productionRelease", "contributeLandingBRESectionActivity", "Lcom/iaai/android/bdt/feature/landing/LandingBRESectionActivity;", "contributeLandingBRESectionActivity$app_productionRelease", "contributeMainActivity", "Lcom/iaai/android/bdt/feature/main/MainActivity;", "contributeMainActivity$app_productionRelease", "contributeMakeModelFilterActivity", "Lcom/iaai/android/bdt/feature/findVehiclePage/filter/MakeModelFilterActivity;", "contributeMakeModelFilterActivity$app_productionRelease", "contributeManageBranchPrefActivity", "Lcom/iaai/android/bdt/feature/account/salesdocument/manageBranchPref/ManageBranchPrefActivity;", "contributeManageBranchPrefActivity$app_productionRelease", "contributeManageOfferListActivity", "Lcom/iaai/android/bdt/feature/digitalNegotiation/ManageOfferListActivity;", "contributeManageOfferListActivity$app_productionRelease", "contributeOnBoardingActivityActivity", "Lcom/iaai/android/bdt/feature/onBoarding/OnBoardingActivity;", "contributeOnBoardingActivityActivity$app_productionRelease", "contributeProduct360ImageActivity", "Lcom/iaai/android/bdt/feature/productDetail/vehicleimage/Product360ImageActivity;", "contributeProduct360ImageActivity$app_productionRelease", "contributeRefinerResultActivity", "Lcom/iaai/android/bdt/feature/fastSearchFilter/refinerResults/RefinerResultActivity;", "contributeRefinerResultActivity$app_productionRelease", "contributeSaleDocListActivity", "Lcom/iaai/android/bdt/feature/myAccount/toBePaid/saleDocList/SaleDocListActivity;", "contributeSaleDocListActivity$app_productionRelease", "contributeSalesDocumentActivity", "Lcom/iaai/android/bdt/feature/account/salesdocument/SalesDocumentActivity;", "contributeSalesDocumentActivity$app_productionRelease", "contributeSavedSearchActivity", "Lcom/iaai/android/bdt/feature/fastSearchFilter/savedSearch/SavedSearchActivity;", "contributeSavedSearchActivity$app_productionRelease", "contributeSearchByACVActivity", "Lcom/iaai/android/bdt/feature/fastSearchFilter/newFindVehicle/SearchByACVActivity;", "contributeSearchByACVActivity$app_productionRelease", "contributeSearchByDistanceActivity", "Lcom/iaai/android/bdt/feature/fastSearchFilter/newFindVehicle/SearchByDistanceActivity;", "contributeSearchByDistanceActivity$app_productionRelease", "contributeSearchByOdometerActivity", "Lcom/iaai/android/bdt/feature/fastSearchFilter/newFindVehicle/SearchByOdometerActivity;", "contributeSearchByOdometerActivity$app_productionRelease", "contributeSearchResultActivity", "Lcom/iaai/android/bdt/feature/findVehiclePage/searchResult/SearchResultActivity;", "contributeSearchResultActivity$app_productionRelease", "contributeSplashActivity", "Lcom/iaai/android/bdt/feature/applaunch/SplashActivity;", "contributeSplashActivity$app_productionRelease", "contributeSubFilterActivity", "Lcom/iaai/android/bdt/feature/findVehiclePage/filter/SubFilterActivity;", "contributeSubFilterActivity$app_productionRelease", "contributeTermsOfUseAuctionRuleActivity", "Lcom/iaai/android/bdt/feature/termsofuse/TermsOfUseAuctionRuleActivity;", "contributeTermsOfUseAuctionRuleActivity$app_productionRelease", "contributeToBePickedUpAccountActivity", "Lcom/iaai/android/bdt/feature/account/tobepickedup/ToPickedUpAccountActivity;", "contributeToBePickedUpAccountActivity$app_productionRelease", "contributeValidateOTPActivity", "Lcom/iaai/android/bdt/feature/login/emailValidation/ValidateOTPActivity;", "contributeValidateOTPActivity$app_productionRelease", "contributeWatchListActivity", "Lcom/iaai/android/bdt/feature/account/watchlist/PreSaleListActivity;", "contributeWatchListActivity$app_productionRelease", "contributeWebViewActivity", "Lcom/iaai/android/bdt/feature/utilsActivity/WebViewActivity;", "contributeWebViewActivity$app_productionRelease", "app_productionRelease"}, mo66934k = 1, mo66935mv = {1, 1, 13})
@Module
/* compiled from: ActivityModule.kt */
public abstract class ActivityModule {
    @ContributesAndroidInjector
    @NotNull
    public abstract ReceiptDPFActivity contributeAFCTermsPage$app_productionRelease();

    @ContributesAndroidInjector
    @NotNull
    public abstract AuctionDateListActivity contributeAuctionDateListActivity$app_productionRelease();

    @ContributesAndroidInjector
    @NotNull
    public abstract ProductDetailActivity contributeAuctionProductDetailActivity$app_productionRelease();

    @ContributesAndroidInjector
    @NotNull
    public abstract AuctionSalesListActivity contributeAuctionSalesListActivity$app_productionRelease();

    @ContributesAndroidInjector
    @NotNull
    public abstract BDTAuctionMainListActivity contributeBDTAuctionMainListActivity$app_productionRelease();

    @ContributesAndroidInjector
    @NotNull
    public abstract BDTLandingPageActivity contributeBDTFindVehicleActivity$app_productionRelease();

    @ContributesAndroidInjector
    @NotNull
    public abstract BDTForgotPasswordActivity contributeBDTForgotPasswordActivity$app_productionRelease();

    @ContributesAndroidInjector
    @NotNull
    public abstract BDTLoginActivity contributeBDTLoginActivity$app_productionRelease();

    @ContributesAndroidInjector
    @NotNull
    public abstract BDTMyAccountActivity contributeBDTMyAccountActivity$app_productionRelease();

    @ContributesAndroidInjector
    @NotNull
    public abstract BDTPaymentMethodActivity contributeBDTPaymentMethodActivity$app_productionRelease();

    @ContributesAndroidInjector
    @NotNull
    public abstract BDTPremiumVehicleReportActivity contributeBDTPremiumVehicleReportActivity$app_productionRelease();

    @ContributesAndroidInjector
    @NotNull
    public abstract BDTPromptPasswordDialogActivity contributeBDTPromptPasswordDialogActivity$app_productionRelease();

    @ContributesAndroidInjector
    @NotNull
    public abstract BDTSettingsActivity contributeBDTSettingsActivity$app_productionRelease();

    @ContributesAndroidInjector
    @NotNull
    public abstract BDTTermsOfUseActivity contributeBDTTermsOfUseActivity$app_productionRelease();

    @ContributesAndroidInjector
    @NotNull
    public abstract BaseActivity contributeBaseActivity$app_productionRelease();

    @ContributesAndroidInjector
    @NotNull
    public abstract BuyNowOfferListActivity contributeBuyNowOfferListActivity$app_productionRelease();

    @ContributesAndroidInjector
    @NotNull
    public abstract BDTPaymentActivity contributeCreditCardActivity$app_productionRelease();

    @ContributesAndroidInjector
    @NotNull
    public abstract DeliveryMethodActivity contributeDeliveryMethodActivity$app_productionRelease();

    @ContributesAndroidInjector
    @NotNull
    public abstract EmailConfirmationActivity contributeEmailConfirmationActivity$app_productionRelease();

    @ContributesAndroidInjector
    @NotNull
    public abstract EngineVideoActivity contributeEngineVideoActivity$app_productionRelease();

    @ContributesAndroidInjector
    @NotNull
    public abstract FastSearchFilterActivity contributeFastSearchFilterActivity$app_productionRelease();

    @ContributesAndroidInjector
    @NotNull
    public abstract FilterActivity contributeFilterActivity$app_productionRelease();

    @ContributesAndroidInjector
    @NotNull
    public abstract FindVehicleFilterActivity contributeFindVehicleFilterActivity$app_productionRelease();

    @ContributesAndroidInjector
    @NotNull
    public abstract IAAConditionReportActivity contributeIAAConditionReportActivity$app_productionRelease();

    @ContributesAndroidInjector
    @NotNull
    public abstract LandingBRESectionActivity contributeLandingBRESectionActivity$app_productionRelease();

    @ContributesAndroidInjector
    @NotNull
    public abstract MainActivity contributeMainActivity$app_productionRelease();

    @ContributesAndroidInjector
    @NotNull
    public abstract MakeModelFilterActivity contributeMakeModelFilterActivity$app_productionRelease();

    @ContributesAndroidInjector
    @NotNull
    public abstract ManageBranchPrefActivity contributeManageBranchPrefActivity$app_productionRelease();

    @ContributesAndroidInjector
    @NotNull
    public abstract ManageOfferListActivity contributeManageOfferListActivity$app_productionRelease();

    @ContributesAndroidInjector
    @NotNull
    public abstract OnBoardingActivity contributeOnBoardingActivityActivity$app_productionRelease();

    @ContributesAndroidInjector
    @NotNull
    public abstract Product360ImageActivity contributeProduct360ImageActivity$app_productionRelease();

    @ContributesAndroidInjector
    @NotNull
    public abstract RefinerResultActivity contributeRefinerResultActivity$app_productionRelease();

    @ContributesAndroidInjector
    @NotNull
    public abstract SaleDocListActivity contributeSaleDocListActivity$app_productionRelease();

    @ContributesAndroidInjector
    @NotNull
    public abstract SalesDocumentActivity contributeSalesDocumentActivity$app_productionRelease();

    @ContributesAndroidInjector
    @NotNull
    public abstract SavedSearchActivity contributeSavedSearchActivity$app_productionRelease();

    @ContributesAndroidInjector
    @NotNull
    public abstract SearchByACVActivity contributeSearchByACVActivity$app_productionRelease();

    @ContributesAndroidInjector
    @NotNull
    public abstract SearchByDistanceActivity contributeSearchByDistanceActivity$app_productionRelease();

    @ContributesAndroidInjector
    @NotNull
    public abstract SearchByOdometerActivity contributeSearchByOdometerActivity$app_productionRelease();

    @ContributesAndroidInjector
    @NotNull
    public abstract SearchResultActivity contributeSearchResultActivity$app_productionRelease();

    @ContributesAndroidInjector
    @NotNull
    public abstract SplashActivity contributeSplashActivity$app_productionRelease();

    @ContributesAndroidInjector
    @NotNull
    public abstract SubFilterActivity contributeSubFilterActivity$app_productionRelease();

    @ContributesAndroidInjector
    @NotNull
    public abstract TermsOfUseAuctionRuleActivity contributeTermsOfUseAuctionRuleActivity$app_productionRelease();

    @ContributesAndroidInjector
    @NotNull
    public abstract ToPickedUpAccountActivity contributeToBePickedUpAccountActivity$app_productionRelease();

    @ContributesAndroidInjector
    @NotNull
    public abstract ValidateOTPActivity contributeValidateOTPActivity$app_productionRelease();

    @ContributesAndroidInjector
    @NotNull
    public abstract PreSaleListActivity contributeWatchListActivity$app_productionRelease();

    @ContributesAndroidInjector
    @NotNull
    public abstract WebViewActivity contributeWebViewActivity$app_productionRelease();
}

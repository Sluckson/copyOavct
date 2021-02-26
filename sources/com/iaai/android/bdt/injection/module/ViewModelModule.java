package com.iaai.android.bdt.injection.module;

import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import com.iaai.android.bdt.factory.AppViewModelFactory;
import com.iaai.android.bdt.feature.account.MyAccountViewModel;
import com.iaai.android.bdt.feature.account.buyNowOfferList.BuyNowOfferListViewModel;
import com.iaai.android.bdt.feature.account.salesdocument.SaleDocumentViewModel;
import com.iaai.android.bdt.feature.account.tobepickedup.ToBePickedUpViewModel;
import com.iaai.android.bdt.feature.account.watchlist.PreSaleListViewModel;
import com.iaai.android.bdt.feature.applaunch.MakeModelViewModel;
import com.iaai.android.bdt.feature.auctionMainPage.AuctionMainListViewModel;
import com.iaai.android.bdt.feature.auctionSalesList.AuctionSalesListViewModel;
import com.iaai.android.bdt.feature.digitalNegotiation.ManageOfferListViewModel;
import com.iaai.android.bdt.feature.fastSearchFilter.newFindVehicle.FastSearchFilterViewModel;
import com.iaai.android.bdt.feature.fastSearchFilter.savedSearch.SavedSearchListViewModel;
import com.iaai.android.bdt.feature.landing.LandingPageViewModel;
import com.iaai.android.bdt.feature.landing.quickFilter.QuickFilterViewModel;
import com.iaai.android.bdt.feature.login.ForgotPasswordViewModel;
import com.iaai.android.bdt.feature.login.LoginViewModel;
import com.iaai.android.bdt.feature.login.TermsOfUseViewModel;
import com.iaai.android.bdt.feature.login.emailValidation.EmailConfirmationViewModel;
import com.iaai.android.bdt.feature.login.emailValidation.ValidateOTPViewModel;
import com.iaai.android.bdt.feature.myAccount.toBePaid.ToBePaidViewModel;
import com.iaai.android.bdt.feature.myAccount.toBePaid.saleDocList.DeliveryInstructionViewModel;
import com.iaai.android.bdt.feature.myAccount.toBePaid.saleDocList.DeliveryMethodViewModel;
import com.iaai.android.bdt.feature.myAccount.toBePaid.saleDocList.InsertRepOrAddViewModel;
import com.iaai.android.bdt.feature.myAccount.toBePaid.saleDocList.SaleDocListViewModel;
import com.iaai.android.bdt.feature.productDetail.ProductDetailViewModel;
import com.iaai.android.bdt.feature.productDetail.buyNow.BuyNowViewModel;
import com.iaai.android.bdt.feature.productDetail.chromeSection.ChromeSectionViewModel;
import com.iaai.android.bdt.feature.productDetail.costCalculator.CostCalculatorViewModel;
import com.iaai.android.bdt.feature.productDetail.prebid.PreBidViewModel;
import com.iaai.android.bdt.feature.productDetail.reports.PremiunVehicleReportViewModel;
import com.iaai.android.bdt.feature.termsofuse.AuctionRuleViewModel;
import com.iaai.android.bdt.feature.viewPager.FastSearchViewModel;
import dagger.Binds;
import dagger.Module;
import dagger.multibindings.IntoMap;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(mo66931bv = {1, 0, 3}, mo66932d1 = {"\u0000\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\b!\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0015\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H!¢\u0006\u0002\b\u0007J\u0015\u0010\b\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\nH!¢\u0006\u0002\b\u000bJ\u0015\u0010\f\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\u000eH!¢\u0006\u0002\b\u000fJ\u0015\u0010\u0010\u001a\u00020\u00042\u0006\u0010\u0011\u001a\u00020\u0012H!¢\u0006\u0002\b\u0013J\u0015\u0010\u0014\u001a\u00020\u00042\u0006\u0010\u0015\u001a\u00020\u0016H!¢\u0006\u0002\b\u0017J\u0015\u0010\u0018\u001a\u00020\u00042\u0006\u0010\u0019\u001a\u00020\u001aH!¢\u0006\u0002\b\u001bJ\u0015\u0010\u001c\u001a\u00020\u00042\u0006\u0010\u001d\u001a\u00020\u001eH!¢\u0006\u0002\b\u001fJ\u0015\u0010 \u001a\u00020\u00042\u0006\u0010!\u001a\u00020\"H!¢\u0006\u0002\b#J\u0015\u0010$\u001a\u00020\u00042\u0006\u0010%\u001a\u00020&H!¢\u0006\u0002\b'J\u0015\u0010(\u001a\u00020\u00042\u0006\u0010)\u001a\u00020*H!¢\u0006\u0002\b+J\u0015\u0010,\u001a\u00020\u00042\u0006\u0010-\u001a\u00020.H!¢\u0006\u0002\b/J\u0015\u00100\u001a\u00020\u00042\u0006\u00101\u001a\u000202H!¢\u0006\u0002\b3J\u0015\u00104\u001a\u00020\u00042\u0006\u00105\u001a\u000206H!¢\u0006\u0002\b7J\u0015\u00108\u001a\u00020\u00042\u0006\u00109\u001a\u00020:H!¢\u0006\u0002\b;J\u0015\u0010<\u001a\u00020\u00042\u0006\u0010=\u001a\u00020>H!¢\u0006\u0002\b?J\u0015\u0010@\u001a\u00020\u00042\u0006\u0010A\u001a\u00020BH!¢\u0006\u0002\bCJ\u0015\u0010D\u001a\u00020\u00042\u0006\u0010E\u001a\u00020FH!¢\u0006\u0002\bGJ\u0015\u0010H\u001a\u00020\u00042\u0006\u0010I\u001a\u00020JH!¢\u0006\u0002\bKJ\u0015\u0010L\u001a\u00020\u00042\u0006\u0010M\u001a\u00020NH!¢\u0006\u0002\bOJ\u0015\u0010P\u001a\u00020\u00042\u0006\u0010Q\u001a\u00020RH!¢\u0006\u0002\bSJ\u0015\u0010T\u001a\u00020\u00042\u0006\u0010U\u001a\u00020VH!¢\u0006\u0002\bWJ\u0015\u0010X\u001a\u00020\u00042\u0006\u0010Y\u001a\u00020ZH!¢\u0006\u0002\b[J\u0015\u0010\\\u001a\u00020\u00042\u0006\u0010]\u001a\u00020^H!¢\u0006\u0002\b_J\u0015\u0010`\u001a\u00020\u00042\u0006\u0010a\u001a\u00020bH!¢\u0006\u0002\bcJ\u0015\u0010d\u001a\u00020\u00042\u0006\u0010e\u001a\u00020fH!¢\u0006\u0002\bgJ\u0015\u0010h\u001a\u00020\u00042\u0006\u0010i\u001a\u00020jH!¢\u0006\u0002\bkJ\u0015\u0010l\u001a\u00020\u00042\u0006\u0010m\u001a\u00020nH!¢\u0006\u0002\boJ\u0015\u0010p\u001a\u00020\u00042\u0006\u0010q\u001a\u00020rH!¢\u0006\u0002\bsJ\u0015\u0010t\u001a\u00020u2\u0006\u0010v\u001a\u00020wH!¢\u0006\u0002\bxJ\u0015\u0010y\u001a\u00020\u00042\u0006\u0010\u0011\u001a\u00020zH!¢\u0006\u0002\b{J\u0015\u0010|\u001a\u00020\u00042\u0006\u0010}\u001a\u00020~H!¢\u0006\u0002\bJ\u0019\u0010\u0001\u001a\u00020\u00042\b\u0010\u0001\u001a\u00030\u0001H!¢\u0006\u0003\b\u0001¨\u0006\u0001"}, mo66933d2 = {"Lcom/iaai/android/bdt/injection/module/ViewModelModule;", "", "()V", "bindAuctionMainListViewModels", "Landroidx/lifecycle/ViewModel;", "auctionMainListViewModel", "Lcom/iaai/android/bdt/feature/auctionMainPage/AuctionMainListViewModel;", "bindAuctionMainListViewModels$app_productionRelease", "bindAuctionRuleViewModel", "auctionRuleViewModel", "Lcom/iaai/android/bdt/feature/termsofuse/AuctionRuleViewModel;", "bindAuctionRuleViewModel$app_productionRelease", "bindAuctionSalesListViewModels", "auctionSalesListViewModel", "Lcom/iaai/android/bdt/feature/auctionSalesList/AuctionSalesListViewModel;", "bindAuctionSalesListViewModels$app_productionRelease", "bindBuyNowOfferListViewMode", "preSaleListViewModel", "Lcom/iaai/android/bdt/feature/account/buyNowOfferList/BuyNowOfferListViewModel;", "bindBuyNowOfferListViewMode$app_productionRelease", "bindBuyNowViewModels", "buyNowViewModel", "Lcom/iaai/android/bdt/feature/productDetail/buyNow/BuyNowViewModel;", "bindBuyNowViewModels$app_productionRelease", "bindChromeSectionViewModel", "chromeSectionViewModel", "Lcom/iaai/android/bdt/feature/productDetail/chromeSection/ChromeSectionViewModel;", "bindChromeSectionViewModel$app_productionRelease", "bindCostCalculatorViewModel", "costCalculatorViewModel", "Lcom/iaai/android/bdt/feature/productDetail/costCalculator/CostCalculatorViewModel;", "bindCostCalculatorViewModel$app_productionRelease", "bindDeliveryInstructionViewModel", "deliveryInstructionViewModel", "Lcom/iaai/android/bdt/feature/myAccount/toBePaid/saleDocList/DeliveryInstructionViewModel;", "bindDeliveryInstructionViewModel$app_productionRelease", "bindDeliveryMethodViewModel", "deliveryMethodViewModel", "Lcom/iaai/android/bdt/feature/myAccount/toBePaid/saleDocList/DeliveryMethodViewModel;", "bindDeliveryMethodViewModel$app_productionRelease", "bindEmailConfirmationViewModel", "emailConfirmationViewModel", "Lcom/iaai/android/bdt/feature/login/emailValidation/EmailConfirmationViewModel;", "bindEmailConfirmationViewModel$app_productionRelease", "bindFastSearchFilterViewModel", "fastSearchFilterViewModel", "Lcom/iaai/android/bdt/feature/fastSearchFilter/newFindVehicle/FastSearchFilterViewModel;", "bindFastSearchFilterViewModel$app_productionRelease", "bindForgotPasswordViewModel", "forgotPasswordViewModel", "Lcom/iaai/android/bdt/feature/login/ForgotPasswordViewModel;", "bindForgotPasswordViewModel$app_productionRelease", "bindInsertRepOrAddViewModel", "insertRepOrAddViewModel", "Lcom/iaai/android/bdt/feature/myAccount/toBePaid/saleDocList/InsertRepOrAddViewModel;", "bindInsertRepOrAddViewModel$app_productionRelease", "bindLandingPageViewModel", "landingPageViewModel", "Lcom/iaai/android/bdt/feature/landing/LandingPageViewModel;", "bindLandingPageViewModel$app_productionRelease", "bindLoginViewModel", "loginViewModel", "Lcom/iaai/android/bdt/feature/login/LoginViewModel;", "bindLoginViewModel$app_productionRelease", "bindMakeModelViewModel", "makeModelViewModel", "Lcom/iaai/android/bdt/feature/applaunch/MakeModelViewModel;", "bindMakeModelViewModel$app_productionRelease", "bindManageOfferListViewModel", "manageOfferListViewModel", "Lcom/iaai/android/bdt/feature/digitalNegotiation/ManageOfferListViewModel;", "bindManageOfferListViewModel$app_productionRelease", "bindMyAccountViewModel", "myAccountViewModel", "Lcom/iaai/android/bdt/feature/account/MyAccountViewModel;", "bindMyAccountViewModel$app_productionRelease", "bindPagerViewModel", "fastSearchViewModel", "Lcom/iaai/android/bdt/feature/viewPager/FastSearchViewModel;", "bindPagerViewModel$app_productionRelease", "bindPreBidViewModels", "preBidViewModel", "Lcom/iaai/android/bdt/feature/productDetail/prebid/PreBidViewModel;", "bindPreBidViewModels$app_productionRelease", "bindPremiunVehicleReportViewModel", "premiunVehicleReportViewModel", "Lcom/iaai/android/bdt/feature/productDetail/reports/PremiunVehicleReportViewModel;", "bindPremiunVehicleReportViewModel$app_productionRelease", "bindProductDetailViewModels", "productDetailViewModel", "Lcom/iaai/android/bdt/feature/productDetail/ProductDetailViewModel;", "bindProductDetailViewModels$app_productionRelease", "bindQuickFilterViewModels", "quickFilterViewModel", "Lcom/iaai/android/bdt/feature/landing/quickFilter/QuickFilterViewModel;", "bindQuickFilterViewModels$app_productionRelease", "bindSaleDocListViewModel", "saleDocListViewModel", "Lcom/iaai/android/bdt/feature/myAccount/toBePaid/saleDocList/SaleDocListViewModel;", "bindSaleDocListViewModel$app_productionRelease", "bindSavedSearchListViewModel", "savedSearchListViewModel", "Lcom/iaai/android/bdt/feature/fastSearchFilter/savedSearch/SavedSearchListViewModel;", "bindSavedSearchListViewModel$app_productionRelease", "bindTermsOfUseViewModel", "termsOfUseViewModel", "Lcom/iaai/android/bdt/feature/login/TermsOfUseViewModel;", "bindTermsOfUseViewModel$app_productionRelease", "bindToBePaidViewModel", "toBePaidViewModel", "Lcom/iaai/android/bdt/feature/myAccount/toBePaid/ToBePaidViewModel;", "bindToBePaidViewModel$app_productionRelease", "bindValidateOTPViewModel", "validateOTPViewModel", "Lcom/iaai/android/bdt/feature/login/emailValidation/ValidateOTPViewModel;", "bindValidateOTPViewModel$app_productionRelease", "bindViewModelFactory", "Landroidx/lifecycle/ViewModelProvider$Factory;", "factory", "Lcom/iaai/android/bdt/factory/AppViewModelFactory;", "bindViewModelFactory$app_productionRelease", "bindWatchListViewModel", "Lcom/iaai/android/bdt/feature/account/watchlist/PreSaleListViewModel;", "bindWatchListViewModel$app_productionRelease", "bindsaleDocumentViewModel", "saleDocumentViewModel", "Lcom/iaai/android/bdt/feature/account/salesdocument/SaleDocumentViewModel;", "bindsaleDocumentViewModel$app_productionRelease", "bindtoBePickedUpViewModel", "toBePickedUpViewModel", "Lcom/iaai/android/bdt/feature/account/tobepickedup/ToBePickedUpViewModel;", "bindtoBePickedUpViewModel$app_productionRelease", "app_productionRelease"}, mo66934k = 1, mo66935mv = {1, 1, 13})
@Module
/* compiled from: ViewModelModule.kt */
public abstract class ViewModelModule {
    @Binds
    @ViewModelKey(AuctionMainListViewModel.class)
    @IntoMap
    @NotNull
    public abstract ViewModel bindAuctionMainListViewModels$app_productionRelease(@NotNull AuctionMainListViewModel auctionMainListViewModel);

    @Binds
    @ViewModelKey(AuctionRuleViewModel.class)
    @IntoMap
    @NotNull
    public abstract ViewModel bindAuctionRuleViewModel$app_productionRelease(@NotNull AuctionRuleViewModel auctionRuleViewModel);

    @Binds
    @ViewModelKey(AuctionSalesListViewModel.class)
    @IntoMap
    @NotNull
    public abstract ViewModel bindAuctionSalesListViewModels$app_productionRelease(@NotNull AuctionSalesListViewModel auctionSalesListViewModel);

    @Binds
    @ViewModelKey(BuyNowOfferListViewModel.class)
    @IntoMap
    @NotNull
    public abstract ViewModel bindBuyNowOfferListViewMode$app_productionRelease(@NotNull BuyNowOfferListViewModel buyNowOfferListViewModel);

    @Binds
    @ViewModelKey(BuyNowViewModel.class)
    @IntoMap
    @NotNull
    public abstract ViewModel bindBuyNowViewModels$app_productionRelease(@NotNull BuyNowViewModel buyNowViewModel);

    @Binds
    @ViewModelKey(ChromeSectionViewModel.class)
    @IntoMap
    @NotNull
    public abstract ViewModel bindChromeSectionViewModel$app_productionRelease(@NotNull ChromeSectionViewModel chromeSectionViewModel);

    @Binds
    @ViewModelKey(CostCalculatorViewModel.class)
    @IntoMap
    @NotNull
    public abstract ViewModel bindCostCalculatorViewModel$app_productionRelease(@NotNull CostCalculatorViewModel costCalculatorViewModel);

    @Binds
    @ViewModelKey(DeliveryInstructionViewModel.class)
    @IntoMap
    @NotNull
    public abstract ViewModel bindDeliveryInstructionViewModel$app_productionRelease(@NotNull DeliveryInstructionViewModel deliveryInstructionViewModel);

    @Binds
    @ViewModelKey(DeliveryMethodViewModel.class)
    @IntoMap
    @NotNull
    public abstract ViewModel bindDeliveryMethodViewModel$app_productionRelease(@NotNull DeliveryMethodViewModel deliveryMethodViewModel);

    @Binds
    @ViewModelKey(EmailConfirmationViewModel.class)
    @IntoMap
    @NotNull
    public abstract ViewModel bindEmailConfirmationViewModel$app_productionRelease(@NotNull EmailConfirmationViewModel emailConfirmationViewModel);

    @Binds
    @ViewModelKey(FastSearchFilterViewModel.class)
    @IntoMap
    @NotNull
    public abstract ViewModel bindFastSearchFilterViewModel$app_productionRelease(@NotNull FastSearchFilterViewModel fastSearchFilterViewModel);

    @Binds
    @ViewModelKey(ForgotPasswordViewModel.class)
    @IntoMap
    @NotNull
    public abstract ViewModel bindForgotPasswordViewModel$app_productionRelease(@NotNull ForgotPasswordViewModel forgotPasswordViewModel);

    @Binds
    @ViewModelKey(InsertRepOrAddViewModel.class)
    @IntoMap
    @NotNull
    public abstract ViewModel bindInsertRepOrAddViewModel$app_productionRelease(@NotNull InsertRepOrAddViewModel insertRepOrAddViewModel);

    @Binds
    @ViewModelKey(LandingPageViewModel.class)
    @IntoMap
    @NotNull
    public abstract ViewModel bindLandingPageViewModel$app_productionRelease(@NotNull LandingPageViewModel landingPageViewModel);

    @Binds
    @ViewModelKey(LoginViewModel.class)
    @IntoMap
    @NotNull
    public abstract ViewModel bindLoginViewModel$app_productionRelease(@NotNull LoginViewModel loginViewModel);

    @Binds
    @ViewModelKey(MakeModelViewModel.class)
    @IntoMap
    @NotNull
    public abstract ViewModel bindMakeModelViewModel$app_productionRelease(@NotNull MakeModelViewModel makeModelViewModel);

    @Binds
    @ViewModelKey(ManageOfferListViewModel.class)
    @IntoMap
    @NotNull
    public abstract ViewModel bindManageOfferListViewModel$app_productionRelease(@NotNull ManageOfferListViewModel manageOfferListViewModel);

    @Binds
    @ViewModelKey(MyAccountViewModel.class)
    @IntoMap
    @NotNull
    public abstract ViewModel bindMyAccountViewModel$app_productionRelease(@NotNull MyAccountViewModel myAccountViewModel);

    @Binds
    @ViewModelKey(FastSearchViewModel.class)
    @IntoMap
    @NotNull
    public abstract ViewModel bindPagerViewModel$app_productionRelease(@NotNull FastSearchViewModel fastSearchViewModel);

    @Binds
    @ViewModelKey(PreBidViewModel.class)
    @IntoMap
    @NotNull
    public abstract ViewModel bindPreBidViewModels$app_productionRelease(@NotNull PreBidViewModel preBidViewModel);

    @Binds
    @ViewModelKey(PremiunVehicleReportViewModel.class)
    @IntoMap
    @NotNull
    public abstract ViewModel bindPremiunVehicleReportViewModel$app_productionRelease(@NotNull PremiunVehicleReportViewModel premiunVehicleReportViewModel);

    @Binds
    @ViewModelKey(ProductDetailViewModel.class)
    @IntoMap
    @NotNull
    public abstract ViewModel bindProductDetailViewModels$app_productionRelease(@NotNull ProductDetailViewModel productDetailViewModel);

    @Binds
    @ViewModelKey(QuickFilterViewModel.class)
    @IntoMap
    @NotNull
    public abstract ViewModel bindQuickFilterViewModels$app_productionRelease(@NotNull QuickFilterViewModel quickFilterViewModel);

    @Binds
    @ViewModelKey(SaleDocListViewModel.class)
    @IntoMap
    @NotNull
    public abstract ViewModel bindSaleDocListViewModel$app_productionRelease(@NotNull SaleDocListViewModel saleDocListViewModel);

    @Binds
    @ViewModelKey(SavedSearchListViewModel.class)
    @IntoMap
    @NotNull
    public abstract ViewModel bindSavedSearchListViewModel$app_productionRelease(@NotNull SavedSearchListViewModel savedSearchListViewModel);

    @Binds
    @ViewModelKey(TermsOfUseViewModel.class)
    @IntoMap
    @NotNull
    public abstract ViewModel bindTermsOfUseViewModel$app_productionRelease(@NotNull TermsOfUseViewModel termsOfUseViewModel);

    @Binds
    @ViewModelKey(ToBePaidViewModel.class)
    @IntoMap
    @NotNull
    public abstract ViewModel bindToBePaidViewModel$app_productionRelease(@NotNull ToBePaidViewModel toBePaidViewModel);

    @Binds
    @ViewModelKey(ValidateOTPViewModel.class)
    @IntoMap
    @NotNull
    public abstract ViewModel bindValidateOTPViewModel$app_productionRelease(@NotNull ValidateOTPViewModel validateOTPViewModel);

    @NotNull
    @Binds
    public abstract ViewModelProvider.Factory bindViewModelFactory$app_productionRelease(@NotNull AppViewModelFactory appViewModelFactory);

    @Binds
    @ViewModelKey(PreSaleListViewModel.class)
    @IntoMap
    @NotNull
    public abstract ViewModel bindWatchListViewModel$app_productionRelease(@NotNull PreSaleListViewModel preSaleListViewModel);

    @Binds
    @ViewModelKey(SaleDocumentViewModel.class)
    @IntoMap
    @NotNull
    public abstract ViewModel bindsaleDocumentViewModel$app_productionRelease(@NotNull SaleDocumentViewModel saleDocumentViewModel);

    @Binds
    @ViewModelKey(ToBePickedUpViewModel.class)
    @IntoMap
    @NotNull
    public abstract ViewModel bindtoBePickedUpViewModel$app_productionRelease(@NotNull ToBePickedUpViewModel toBePickedUpViewModel);
}

package com.iaai.android.bdt.injection.module;

import com.iaai.android.bdt.feature.account.AccountSettingFragment;
import com.iaai.android.bdt.feature.account.MyListFragment;
import com.iaai.android.bdt.feature.account.buyNowOfferList.BuyNowOfferListFragment;
import com.iaai.android.bdt.feature.account.salesdocument.SalesDocumentFragment;
import com.iaai.android.bdt.feature.account.tobepickedup.ToBePickedUpListFragment;
import com.iaai.android.bdt.feature.account.watchlist.PreSaleListFragment;
import com.iaai.android.bdt.feature.auctionMainPage.AuctionMainListFragment;
import com.iaai.android.bdt.feature.auctionSalesList.AuctionSalesListFragment;
import com.iaai.android.bdt.feature.digitalNegotiation.ManageOfferListFragment;
import com.iaai.android.bdt.feature.fastSearchFilter.newFindVehicle.FastSearchFilterFragment;
import com.iaai.android.bdt.feature.fastSearchFilter.refinerResults.RefinerResultFragment;
import com.iaai.android.bdt.feature.findVehiclePage.filter.FilterFragment;
import com.iaai.android.bdt.feature.findVehiclePage.searchResult.SearchResultListFragment;
import com.iaai.android.bdt.feature.landing.LandingViewPagerFragment;
import com.iaai.android.bdt.feature.landing.quickFilter.QuickLinksFragment;
import com.iaai.android.bdt.feature.landing.quickFilter.SearchByAuctionFragment;
import com.iaai.android.bdt.feature.landing.quickFilter.SearchByVehicleFragment;
import com.iaai.android.bdt.feature.landing.recommendedVehicles.RecommendedVehiclesFragment;
import com.iaai.android.bdt.feature.myAccount.toBePaid.BDTToBePaidFragment;
import com.iaai.android.bdt.feature.myAccount.toBePaid.ToBePaidConfirmationFragment;
import com.iaai.android.bdt.feature.myAccount.toBePaid.creditCard.SelectCreditCardFragment;
import com.iaai.android.bdt.feature.myAccount.toBePaid.reviewPayment.ToBePaidReviewFragment;
import com.iaai.android.bdt.feature.myAccount.toBePaid.saleDocList.DeliveryInstructionFragment;
import com.iaai.android.bdt.feature.myAccount.toBePaid.saleDocList.InsertRepOrAddFragment;
import com.iaai.android.bdt.feature.productDetail.ProductDetailFragment;
import com.iaai.android.bdt.feature.productDetail.ViewPagerFragment;
import com.iaai.android.bdt.feature.productDetail.buyNow.BuyNowFragment;
import com.iaai.android.bdt.feature.productDetail.chromeSection.ChromeSectionFragment;
import com.iaai.android.bdt.feature.productDetail.costCalculator.CostCalculatorFragment;
import com.iaai.android.bdt.feature.productDetail.prebid.PreBidFragment;
import dagger.Module;
import dagger.android.ContributesAndroidInjector;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(mo66931bv = {1, 0, 3}, mo66932d1 = {"\u0000ü\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b'\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\r\u0010\u0003\u001a\u00020\u0004H!¢\u0006\u0002\b\u0005J\r\u0010\u0006\u001a\u00020\u0007H!¢\u0006\u0002\b\bJ\r\u0010\t\u001a\u00020\nH!¢\u0006\u0002\b\u000bJ\r\u0010\f\u001a\u00020\rH!¢\u0006\u0002\b\u000eJ\r\u0010\u000f\u001a\u00020\u0010H!¢\u0006\u0002\b\u0011J\r\u0010\u0012\u001a\u00020\u0013H!¢\u0006\u0002\b\u0014J\r\u0010\u0015\u001a\u00020\u0016H!¢\u0006\u0002\b\u0017J\r\u0010\u0018\u001a\u00020\u0019H!¢\u0006\u0002\b\u001aJ\r\u0010\u001b\u001a\u00020\u001cH!¢\u0006\u0002\b\u001dJ\r\u0010\u001e\u001a\u00020\u001fH!¢\u0006\u0002\b J\r\u0010!\u001a\u00020\"H!¢\u0006\u0002\b#J\r\u0010$\u001a\u00020%H!¢\u0006\u0002\b&J\r\u0010'\u001a\u00020(H!¢\u0006\u0002\b)J\r\u0010*\u001a\u00020+H!¢\u0006\u0002\b,J\r\u0010-\u001a\u00020.H!¢\u0006\u0002\b/J\r\u00100\u001a\u000201H!¢\u0006\u0002\b2J\r\u00103\u001a\u000204H!¢\u0006\u0002\b5J\r\u00106\u001a\u000207H!¢\u0006\u0002\b8J\r\u00109\u001a\u00020:H!¢\u0006\u0002\b;J\r\u0010<\u001a\u00020=H!¢\u0006\u0002\b>J\r\u0010?\u001a\u00020@H!¢\u0006\u0002\bAJ\r\u0010B\u001a\u00020CH!¢\u0006\u0002\bDJ\r\u0010E\u001a\u00020FH!¢\u0006\u0002\bGJ\r\u0010H\u001a\u00020IH!¢\u0006\u0002\bJJ\r\u0010K\u001a\u00020LH!¢\u0006\u0002\bMJ\r\u0010N\u001a\u00020OH!¢\u0006\u0002\bPJ\r\u0010Q\u001a\u00020RH!¢\u0006\u0002\bSJ\r\u0010T\u001a\u00020UH!¢\u0006\u0002\bVJ\r\u0010W\u001a\u00020XH!¢\u0006\u0002\bYJ\r\u0010Z\u001a\u00020[H!¢\u0006\u0002\b\\¨\u0006]"}, mo66933d2 = {"Lcom/iaai/android/bdt/injection/module/FragmentModule;", "", "()V", "contributeAccountSettingFragment", "Lcom/iaai/android/bdt/feature/account/AccountSettingFragment;", "contributeAccountSettingFragment$app_productionRelease", "contributeAuctionMainList", "Lcom/iaai/android/bdt/feature/auctionMainPage/AuctionMainListFragment;", "contributeAuctionMainList$app_productionRelease", "contributeAuctionSalesList", "Lcom/iaai/android/bdt/feature/auctionSalesList/AuctionSalesListFragment;", "contributeAuctionSalesList$app_productionRelease", "contributeBuyNow", "Lcom/iaai/android/bdt/feature/productDetail/buyNow/BuyNowFragment;", "contributeBuyNow$app_productionRelease", "contributeBuyNowOfferListFragment", "Lcom/iaai/android/bdt/feature/account/buyNowOfferList/BuyNowOfferListFragment;", "contributeBuyNowOfferListFragment$app_productionRelease", "contributeChromeSection", "Lcom/iaai/android/bdt/feature/productDetail/chromeSection/ChromeSectionFragment;", "contributeChromeSection$app_productionRelease", "contributeCostCalculator", "Lcom/iaai/android/bdt/feature/productDetail/costCalculator/CostCalculatorFragment;", "contributeCostCalculator$app_productionRelease", "contributeDeliveryInstructionFragment", "Lcom/iaai/android/bdt/feature/myAccount/toBePaid/saleDocList/DeliveryInstructionFragment;", "contributeDeliveryInstructionFragment$app_productionRelease", "contributeFastSearchFilterFragment", "Lcom/iaai/android/bdt/feature/fastSearchFilter/newFindVehicle/FastSearchFilterFragment;", "contributeFastSearchFilterFragment$app_productionRelease", "contributeFilterFragment", "Lcom/iaai/android/bdt/feature/findVehiclePage/filter/FilterFragment;", "contributeFilterFragment$app_productionRelease", "contributeFindVehicle", "Lcom/iaai/android/bdt/feature/landing/quickFilter/QuickLinksFragment;", "contributeFindVehicle$app_productionRelease", "contributeInsertRepOrAddFragment", "Lcom/iaai/android/bdt/feature/myAccount/toBePaid/saleDocList/InsertRepOrAddFragment;", "contributeInsertRepOrAddFragment$app_productionRelease", "contributeLandingViewPagerFragment", "Lcom/iaai/android/bdt/feature/landing/LandingViewPagerFragment;", "contributeLandingViewPagerFragment$app_productionRelease", "contributeManageOfferListFragment", "Lcom/iaai/android/bdt/feature/digitalNegotiation/ManageOfferListFragment;", "contributeManageOfferListFragment$app_productionRelease", "contributeMyListFragment", "Lcom/iaai/android/bdt/feature/account/MyListFragment;", "contributeMyListFragment$app_productionRelease", "contributePreBid", "Lcom/iaai/android/bdt/feature/productDetail/prebid/PreBidFragment;", "contributePreBid$app_productionRelease", "contributeProductDetail", "Lcom/iaai/android/bdt/feature/productDetail/ProductDetailFragment;", "contributeProductDetail$app_productionRelease", "contributeRecommendedVehiclesFragment", "Lcom/iaai/android/bdt/feature/landing/recommendedVehicles/RecommendedVehiclesFragment;", "contributeRecommendedVehiclesFragment$app_productionRelease", "contributeRefinerResultFragment", "Lcom/iaai/android/bdt/feature/fastSearchFilter/refinerResults/RefinerResultFragment;", "contributeRefinerResultFragment$app_productionRelease", "contributeSalesDocumentFragment", "Lcom/iaai/android/bdt/feature/account/salesdocument/SalesDocumentFragment;", "contributeSalesDocumentFragment$app_productionRelease", "contributeSearchByAuction", "Lcom/iaai/android/bdt/feature/landing/quickFilter/SearchByAuctionFragment;", "contributeSearchByAuction$app_productionRelease", "contributeSearchByVehicle", "Lcom/iaai/android/bdt/feature/landing/quickFilter/SearchByVehicleFragment;", "contributeSearchByVehicle$app_productionRelease", "contributeSearchResultListFragment", "Lcom/iaai/android/bdt/feature/findVehiclePage/searchResult/SearchResultListFragment;", "contributeSearchResultListFragment$app_productionRelease", "contributeSelectCreditCardFragment", "Lcom/iaai/android/bdt/feature/myAccount/toBePaid/creditCard/SelectCreditCardFragment;", "contributeSelectCreditCardFragment$app_productionRelease", "contributeSelectVehiclesCreditCardFragment", "Lcom/iaai/android/bdt/feature/myAccount/toBePaid/BDTToBePaidFragment;", "contributeSelectVehiclesCreditCardFragment$app_productionRelease", "contributeToBePaidConfirmationFragment", "Lcom/iaai/android/bdt/feature/myAccount/toBePaid/ToBePaidConfirmationFragment;", "contributeToBePaidConfirmationFragment$app_productionRelease", "contributeToBePaidReviewFragment", "Lcom/iaai/android/bdt/feature/myAccount/toBePaid/reviewPayment/ToBePaidReviewFragment;", "contributeToBePaidReviewFragment$app_productionRelease", "contributeToBePickedUpListFragment", "Lcom/iaai/android/bdt/feature/account/tobepickedup/ToBePickedUpListFragment;", "contributeToBePickedUpListFragment$app_productionRelease", "contributeViewPager", "Lcom/iaai/android/bdt/feature/productDetail/ViewPagerFragment;", "contributeViewPager$app_productionRelease", "contributeWatchListFragment", "Lcom/iaai/android/bdt/feature/account/watchlist/PreSaleListFragment;", "contributeWatchListFragment$app_productionRelease", "app_productionRelease"}, mo66934k = 1, mo66935mv = {1, 1, 13})
@Module
/* compiled from: FragmentModule.kt */
public abstract class FragmentModule {
    @ContributesAndroidInjector
    @NotNull
    public abstract AccountSettingFragment contributeAccountSettingFragment$app_productionRelease();

    @ContributesAndroidInjector
    @NotNull
    public abstract AuctionMainListFragment contributeAuctionMainList$app_productionRelease();

    @ContributesAndroidInjector
    @NotNull
    public abstract AuctionSalesListFragment contributeAuctionSalesList$app_productionRelease();

    @ContributesAndroidInjector
    @NotNull
    public abstract BuyNowFragment contributeBuyNow$app_productionRelease();

    @ContributesAndroidInjector
    @NotNull
    public abstract BuyNowOfferListFragment contributeBuyNowOfferListFragment$app_productionRelease();

    @ContributesAndroidInjector
    @NotNull
    public abstract ChromeSectionFragment contributeChromeSection$app_productionRelease();

    @ContributesAndroidInjector
    @NotNull
    public abstract CostCalculatorFragment contributeCostCalculator$app_productionRelease();

    @ContributesAndroidInjector
    @NotNull
    public abstract DeliveryInstructionFragment contributeDeliveryInstructionFragment$app_productionRelease();

    @ContributesAndroidInjector
    @NotNull
    public abstract FastSearchFilterFragment contributeFastSearchFilterFragment$app_productionRelease();

    @ContributesAndroidInjector
    @NotNull
    public abstract FilterFragment contributeFilterFragment$app_productionRelease();

    @ContributesAndroidInjector
    @NotNull
    public abstract QuickLinksFragment contributeFindVehicle$app_productionRelease();

    @ContributesAndroidInjector
    @NotNull
    public abstract InsertRepOrAddFragment contributeInsertRepOrAddFragment$app_productionRelease();

    @ContributesAndroidInjector
    @NotNull
    public abstract LandingViewPagerFragment contributeLandingViewPagerFragment$app_productionRelease();

    @ContributesAndroidInjector
    @NotNull
    public abstract ManageOfferListFragment contributeManageOfferListFragment$app_productionRelease();

    @ContributesAndroidInjector
    @NotNull
    public abstract MyListFragment contributeMyListFragment$app_productionRelease();

    @ContributesAndroidInjector
    @NotNull
    public abstract PreBidFragment contributePreBid$app_productionRelease();

    @ContributesAndroidInjector
    @NotNull
    public abstract ProductDetailFragment contributeProductDetail$app_productionRelease();

    @ContributesAndroidInjector
    @NotNull
    public abstract RecommendedVehiclesFragment contributeRecommendedVehiclesFragment$app_productionRelease();

    @ContributesAndroidInjector
    @NotNull
    public abstract RefinerResultFragment contributeRefinerResultFragment$app_productionRelease();

    @ContributesAndroidInjector
    @NotNull
    public abstract SalesDocumentFragment contributeSalesDocumentFragment$app_productionRelease();

    @ContributesAndroidInjector
    @NotNull
    public abstract SearchByAuctionFragment contributeSearchByAuction$app_productionRelease();

    @ContributesAndroidInjector
    @NotNull
    public abstract SearchByVehicleFragment contributeSearchByVehicle$app_productionRelease();

    @ContributesAndroidInjector
    @NotNull
    public abstract SearchResultListFragment contributeSearchResultListFragment$app_productionRelease();

    @ContributesAndroidInjector
    @NotNull
    public abstract SelectCreditCardFragment contributeSelectCreditCardFragment$app_productionRelease();

    @ContributesAndroidInjector
    @NotNull
    public abstract BDTToBePaidFragment contributeSelectVehiclesCreditCardFragment$app_productionRelease();

    @ContributesAndroidInjector
    @NotNull
    public abstract ToBePaidConfirmationFragment contributeToBePaidConfirmationFragment$app_productionRelease();

    @ContributesAndroidInjector
    @NotNull
    public abstract ToBePaidReviewFragment contributeToBePaidReviewFragment$app_productionRelease();

    @ContributesAndroidInjector
    @NotNull
    public abstract ToBePickedUpListFragment contributeToBePickedUpListFragment$app_productionRelease();

    @ContributesAndroidInjector
    @NotNull
    public abstract ViewPagerFragment contributeViewPager$app_productionRelease();

    @ContributesAndroidInjector
    @NotNull
    public abstract PreSaleListFragment contributeWatchListFragment$app_productionRelease();
}

package com.iaai.android.bdt.injection.component;

import android.app.Activity;
import android.app.Application;
import android.app.Fragment;
import android.content.BroadcastReceiver;
import android.content.ContentProvider;
import android.content.Context;
import android.content.SharedPreferences;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import com.google.common.collect.ImmutableMap;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import com.iaai.android.IaaiApplication;
import com.iaai.android.IaaiApplication_MembersInjector;
import com.iaai.android.bdt.base.BaseActivity;
import com.iaai.android.bdt.base.BaseActivity_MembersInjector;
import com.iaai.android.bdt.base.MVVMNavDrawerActivity_MembersInjector;
import com.iaai.android.bdt.factory.AppViewModelFactory;
import com.iaai.android.bdt.factory.AppViewModelFactory_Factory;
import com.iaai.android.bdt.feature.account.AccountSettingFragment;
import com.iaai.android.bdt.feature.account.AccountSettingFragment_MembersInjector;
import com.iaai.android.bdt.feature.account.BDTMyAccountActivity;
import com.iaai.android.bdt.feature.account.BDTMyAccountActivity_MembersInjector;
import com.iaai.android.bdt.feature.account.BDTSettingsActivity;
import com.iaai.android.bdt.feature.account.MyAccountRepository_Factory;
import com.iaai.android.bdt.feature.account.MyAccountViewModel;
import com.iaai.android.bdt.feature.account.MyAccountViewModel_Factory;
import com.iaai.android.bdt.feature.account.MyListFragment;
import com.iaai.android.bdt.feature.account.MyListFragment_MembersInjector;
import com.iaai.android.bdt.feature.account.buyNowOfferList.BuyNowOfferListActivity;
import com.iaai.android.bdt.feature.account.buyNowOfferList.BuyNowOfferListActivity_MembersInjector;
import com.iaai.android.bdt.feature.account.buyNowOfferList.BuyNowOfferListFragment;
import com.iaai.android.bdt.feature.account.buyNowOfferList.BuyNowOfferListFragment_MembersInjector;
import com.iaai.android.bdt.feature.account.buyNowOfferList.BuyNowOfferListRepository_Factory;
import com.iaai.android.bdt.feature.account.buyNowOfferList.BuyNowOfferListViewModel;
import com.iaai.android.bdt.feature.account.buyNowOfferList.BuyNowOfferListViewModel_Factory;
import com.iaai.android.bdt.feature.account.salesdocument.SaleDocumentRepository_Factory;
import com.iaai.android.bdt.feature.account.salesdocument.SaleDocumentViewModel;
import com.iaai.android.bdt.feature.account.salesdocument.SaleDocumentViewModel_Factory;
import com.iaai.android.bdt.feature.account.salesdocument.SalesDocumentActivity;
import com.iaai.android.bdt.feature.account.salesdocument.SalesDocumentActivity_MembersInjector;
import com.iaai.android.bdt.feature.account.salesdocument.SalesDocumentFragment;
import com.iaai.android.bdt.feature.account.salesdocument.SalesDocumentFragment_MembersInjector;
import com.iaai.android.bdt.feature.account.salesdocument.manageBranchPref.ManageBranchPrefActivity;
import com.iaai.android.bdt.feature.account.salesdocument.manageBranchPref.ManageBranchPrefActivity_MembersInjector;
import com.iaai.android.bdt.feature.account.tobepickedup.ToBePickedUpListFragment;
import com.iaai.android.bdt.feature.account.tobepickedup.ToBePickedUpListFragment_MembersInjector;
import com.iaai.android.bdt.feature.account.tobepickedup.ToBePickedUpRepository_Factory;
import com.iaai.android.bdt.feature.account.tobepickedup.ToBePickedUpViewModel;
import com.iaai.android.bdt.feature.account.tobepickedup.ToBePickedUpViewModel_Factory;
import com.iaai.android.bdt.feature.account.tobepickedup.ToPickedUpAccountActivity;
import com.iaai.android.bdt.feature.account.tobepickedup.ToPickedUpAccountActivity_MembersInjector;
import com.iaai.android.bdt.feature.account.watchlist.PreSaleListActivity;
import com.iaai.android.bdt.feature.account.watchlist.PreSaleListActivity_MembersInjector;
import com.iaai.android.bdt.feature.account.watchlist.PreSaleListFragment;
import com.iaai.android.bdt.feature.account.watchlist.PreSaleListFragment_MembersInjector;
import com.iaai.android.bdt.feature.account.watchlist.PreSaleListRepository_Factory;
import com.iaai.android.bdt.feature.account.watchlist.PreSaleListViewModel;
import com.iaai.android.bdt.feature.account.watchlist.PreSaleListViewModel_Factory;
import com.iaai.android.bdt.feature.account.watchlist.ReceiptDPFActivity;
import com.iaai.android.bdt.feature.account.watchlist.ReceiptDPFActivity_MembersInjector;
import com.iaai.android.bdt.feature.applaunch.MakeModelMasterRepository_Factory;
import com.iaai.android.bdt.feature.applaunch.MakeModelViewModel;
import com.iaai.android.bdt.feature.applaunch.MakeModelViewModel_Factory;
import com.iaai.android.bdt.feature.applaunch.SplashActivity;
import com.iaai.android.bdt.feature.applaunch.SplashActivity_MembersInjector;
import com.iaai.android.bdt.feature.auctionMainPage.AuctionDateListActivity;
import com.iaai.android.bdt.feature.auctionMainPage.AuctionMainListFragment;
import com.iaai.android.bdt.feature.auctionMainPage.AuctionMainListFragment_MembersInjector;
import com.iaai.android.bdt.feature.auctionMainPage.AuctionMainListRepository_Factory;
import com.iaai.android.bdt.feature.auctionMainPage.AuctionMainListViewModel;
import com.iaai.android.bdt.feature.auctionMainPage.AuctionMainListViewModel_Factory;
import com.iaai.android.bdt.feature.auctionMainPage.BDTAuctionMainListActivity;
import com.iaai.android.bdt.feature.auctionMainPage.BDTAuctionMainListActivity_MembersInjector;
import com.iaai.android.bdt.feature.auctionSalesList.AuctionSalesListActivity;
import com.iaai.android.bdt.feature.auctionSalesList.AuctionSalesListActivity_MembersInjector;
import com.iaai.android.bdt.feature.auctionSalesList.AuctionSalesListFragment;
import com.iaai.android.bdt.feature.auctionSalesList.AuctionSalesListFragment_MembersInjector;
import com.iaai.android.bdt.feature.auctionSalesList.AuctionSalesListRepository_Factory;
import com.iaai.android.bdt.feature.auctionSalesList.AuctionSalesListViewModel;
import com.iaai.android.bdt.feature.auctionSalesList.AuctionSalesListViewModel_Factory;
import com.iaai.android.bdt.feature.digitalNegotiation.ManageOfferListActivity;
import com.iaai.android.bdt.feature.digitalNegotiation.ManageOfferListActivity_MembersInjector;
import com.iaai.android.bdt.feature.digitalNegotiation.ManageOfferListFragment;
import com.iaai.android.bdt.feature.digitalNegotiation.ManageOfferListFragment_MembersInjector;
import com.iaai.android.bdt.feature.digitalNegotiation.ManageOfferListRepository_Factory;
import com.iaai.android.bdt.feature.digitalNegotiation.ManageOfferListViewModel;
import com.iaai.android.bdt.feature.digitalNegotiation.ManageOfferListViewModel_Factory;
import com.iaai.android.bdt.feature.fastSearchFilter.newFindVehicle.FastSearchFilterActivity;
import com.iaai.android.bdt.feature.fastSearchFilter.newFindVehicle.FastSearchFilterFragment;
import com.iaai.android.bdt.feature.fastSearchFilter.newFindVehicle.FastSearchFilterFragment_MembersInjector;
import com.iaai.android.bdt.feature.fastSearchFilter.newFindVehicle.FastSearchFilterRepository_Factory;
import com.iaai.android.bdt.feature.fastSearchFilter.newFindVehicle.FastSearchFilterViewModel;
import com.iaai.android.bdt.feature.fastSearchFilter.newFindVehicle.FastSearchFilterViewModel_Factory;
import com.iaai.android.bdt.feature.fastSearchFilter.newFindVehicle.SearchByACVActivity;
import com.iaai.android.bdt.feature.fastSearchFilter.newFindVehicle.SearchByDistanceActivity;
import com.iaai.android.bdt.feature.fastSearchFilter.newFindVehicle.SearchByOdometerActivity;
import com.iaai.android.bdt.feature.fastSearchFilter.refinerResults.RefinerResultActivity;
import com.iaai.android.bdt.feature.fastSearchFilter.refinerResults.RefinerResultActivity_MembersInjector;
import com.iaai.android.bdt.feature.fastSearchFilter.refinerResults.RefinerResultFragment;
import com.iaai.android.bdt.feature.fastSearchFilter.refinerResults.RefinerResultFragment_MembersInjector;
import com.iaai.android.bdt.feature.fastSearchFilter.savedSearch.SavedSearchActivity;
import com.iaai.android.bdt.feature.fastSearchFilter.savedSearch.SavedSearchActivity_MembersInjector;
import com.iaai.android.bdt.feature.fastSearchFilter.savedSearch.SavedSearchListRepository_Factory;
import com.iaai.android.bdt.feature.fastSearchFilter.savedSearch.SavedSearchListViewModel;
import com.iaai.android.bdt.feature.fastSearchFilter.savedSearch.SavedSearchListViewModel_Factory;
import com.iaai.android.bdt.feature.findVehiclePage.filter.FilterActivity;
import com.iaai.android.bdt.feature.findVehiclePage.filter.FilterFragment;
import com.iaai.android.bdt.feature.findVehiclePage.filter.FilterFragment_MembersInjector;
import com.iaai.android.bdt.feature.findVehiclePage.filter.FindVehicleFilterActivity;
import com.iaai.android.bdt.feature.findVehiclePage.filter.MakeModelFilterActivity;
import com.iaai.android.bdt.feature.findVehiclePage.filter.SubFilterActivity;
import com.iaai.android.bdt.feature.findVehiclePage.searchResult.SearchResultActivity;
import com.iaai.android.bdt.feature.findVehiclePage.searchResult.SearchResultListFragment;
import com.iaai.android.bdt.feature.findVehiclePage.searchResult.SearchResultListFragment_MembersInjector;
import com.iaai.android.bdt.feature.landing.BDTLandingPageActivity;
import com.iaai.android.bdt.feature.landing.BDTLandingPageActivity_MembersInjector;
import com.iaai.android.bdt.feature.landing.LandingBRESectionActivity;
import com.iaai.android.bdt.feature.landing.LandingPageRepository_Factory;
import com.iaai.android.bdt.feature.landing.LandingPageViewModel;
import com.iaai.android.bdt.feature.landing.LandingPageViewModel_Factory;
import com.iaai.android.bdt.feature.landing.LandingViewPagerFragment;
import com.iaai.android.bdt.feature.landing.LandingViewPagerFragment_MembersInjector;
import com.iaai.android.bdt.feature.landing.quickFilter.QuickFilterRepository_Factory;
import com.iaai.android.bdt.feature.landing.quickFilter.QuickFilterViewModel;
import com.iaai.android.bdt.feature.landing.quickFilter.QuickFilterViewModel_Factory;
import com.iaai.android.bdt.feature.landing.quickFilter.QuickLinksFragment;
import com.iaai.android.bdt.feature.landing.quickFilter.QuickLinksFragment_MembersInjector;
import com.iaai.android.bdt.feature.landing.quickFilter.SearchByAuctionFragment;
import com.iaai.android.bdt.feature.landing.quickFilter.SearchByVehicleFragment;
import com.iaai.android.bdt.feature.landing.quickFilter.SearchByVehicleFragment_MembersInjector;
import com.iaai.android.bdt.feature.landing.recommendedVehicles.RecommendedVehiclesFragment;
import com.iaai.android.bdt.feature.logIAAError.LogIAAErrorRepository_Factory;
import com.iaai.android.bdt.feature.login.BDTForgotPasswordActivity;
import com.iaai.android.bdt.feature.login.BDTForgotPasswordActivity_MembersInjector;
import com.iaai.android.bdt.feature.login.BDTLoginActivity;
import com.iaai.android.bdt.feature.login.BDTLoginActivity_MembersInjector;
import com.iaai.android.bdt.feature.login.BDTPromptPasswordDialogActivity;
import com.iaai.android.bdt.feature.login.BDTPromptPasswordDialogActivity_MembersInjector;
import com.iaai.android.bdt.feature.login.BDTTermsOfUseActivity;
import com.iaai.android.bdt.feature.login.BDTTermsOfUseActivity_MembersInjector;
import com.iaai.android.bdt.feature.login.ForgotPasswordViewModel;
import com.iaai.android.bdt.feature.login.ForgotPasswordViewModel_Factory;
import com.iaai.android.bdt.feature.login.LoginRepository_Factory;
import com.iaai.android.bdt.feature.login.LoginViewModel;
import com.iaai.android.bdt.feature.login.LoginViewModel_Factory;
import com.iaai.android.bdt.feature.login.SessionManager;
import com.iaai.android.bdt.feature.login.TermsOfUseViewModel;
import com.iaai.android.bdt.feature.login.TermsOfUseViewModel_Factory;
import com.iaai.android.bdt.feature.login.emailValidation.EmailConfirmationActivity;
import com.iaai.android.bdt.feature.login.emailValidation.EmailConfirmationActivity_MembersInjector;
import com.iaai.android.bdt.feature.login.emailValidation.EmailConfirmationViewModel;
import com.iaai.android.bdt.feature.login.emailValidation.EmailConfirmationViewModel_Factory;
import com.iaai.android.bdt.feature.login.emailValidation.ValidateOTPActivity;
import com.iaai.android.bdt.feature.login.emailValidation.ValidateOTPActivity_MembersInjector;
import com.iaai.android.bdt.feature.login.emailValidation.ValidateOTPViewModel;
import com.iaai.android.bdt.feature.login.emailValidation.ValidateOTPViewModel_Factory;
import com.iaai.android.bdt.feature.main.MainActivity;
import com.iaai.android.bdt.feature.myAccount.toBePaid.BDTPaymentActivity;
import com.iaai.android.bdt.feature.myAccount.toBePaid.BDTPaymentMethodActivity;
import com.iaai.android.bdt.feature.myAccount.toBePaid.BDTPaymentMethodActivity_MembersInjector;
import com.iaai.android.bdt.feature.myAccount.toBePaid.BDTToBePaidFragment;
import com.iaai.android.bdt.feature.myAccount.toBePaid.BDTToBePaidFragment_MembersInjector;
import com.iaai.android.bdt.feature.myAccount.toBePaid.ToBePaidConfirmationFragment;
import com.iaai.android.bdt.feature.myAccount.toBePaid.ToBePaidViewModel;
import com.iaai.android.bdt.feature.myAccount.toBePaid.ToBePaidViewModel_Factory;
import com.iaai.android.bdt.feature.myAccount.toBePaid.creditCard.SelectCreditCardFragment;
import com.iaai.android.bdt.feature.myAccount.toBePaid.reviewPayment.ToBePaidReviewFragment;
import com.iaai.android.bdt.feature.myAccount.toBePaid.reviewPayment.ToBePaidReviewFragment_MembersInjector;
import com.iaai.android.bdt.feature.myAccount.toBePaid.saleDocList.DeliveryInstructionFragment;
import com.iaai.android.bdt.feature.myAccount.toBePaid.saleDocList.DeliveryInstructionFragment_MembersInjector;
import com.iaai.android.bdt.feature.myAccount.toBePaid.saleDocList.DeliveryInstructionViewModel;
import com.iaai.android.bdt.feature.myAccount.toBePaid.saleDocList.DeliveryInstructionViewModel_Factory;
import com.iaai.android.bdt.feature.myAccount.toBePaid.saleDocList.DeliveryMethodActivity;
import com.iaai.android.bdt.feature.myAccount.toBePaid.saleDocList.DeliveryMethodActivity_MembersInjector;
import com.iaai.android.bdt.feature.myAccount.toBePaid.saleDocList.DeliveryMethodViewModel;
import com.iaai.android.bdt.feature.myAccount.toBePaid.saleDocList.DeliveryMethodViewModel_Factory;
import com.iaai.android.bdt.feature.myAccount.toBePaid.saleDocList.InsertRepOrAddFragment;
import com.iaai.android.bdt.feature.myAccount.toBePaid.saleDocList.InsertRepOrAddFragment_MembersInjector;
import com.iaai.android.bdt.feature.myAccount.toBePaid.saleDocList.InsertRepOrAddViewModel;
import com.iaai.android.bdt.feature.myAccount.toBePaid.saleDocList.InsertRepOrAddViewModel_Factory;
import com.iaai.android.bdt.feature.myAccount.toBePaid.saleDocList.SaleDocListActivity;
import com.iaai.android.bdt.feature.myAccount.toBePaid.saleDocList.SaleDocListActivity_MembersInjector;
import com.iaai.android.bdt.feature.myAccount.toBePaid.saleDocList.SaleDocListViewModel;
import com.iaai.android.bdt.feature.myAccount.toBePaid.saleDocList.SaleDocListViewModel_Factory;
import com.iaai.android.bdt.feature.onBoarding.OnBoardingActivity;
import com.iaai.android.bdt.feature.productDetail.EngineVideoActivity;
import com.iaai.android.bdt.feature.productDetail.ProductDetailActivity;
import com.iaai.android.bdt.feature.productDetail.ProductDetailActivity_MembersInjector;
import com.iaai.android.bdt.feature.productDetail.ProductDetailFragment;
import com.iaai.android.bdt.feature.productDetail.ProductDetailFragment_MembersInjector;
import com.iaai.android.bdt.feature.productDetail.ProductDetailRepository_Factory;
import com.iaai.android.bdt.feature.productDetail.ProductDetailViewModel;
import com.iaai.android.bdt.feature.productDetail.ProductDetailViewModel_Factory;
import com.iaai.android.bdt.feature.productDetail.ViewPagerFragment;
import com.iaai.android.bdt.feature.productDetail.ViewPagerFragment_MembersInjector;
import com.iaai.android.bdt.feature.productDetail.buyNow.BuyNowFragment;
import com.iaai.android.bdt.feature.productDetail.buyNow.BuyNowFragment_MembersInjector;
import com.iaai.android.bdt.feature.productDetail.buyNow.BuyNowRepository_Factory;
import com.iaai.android.bdt.feature.productDetail.buyNow.BuyNowViewModel;
import com.iaai.android.bdt.feature.productDetail.buyNow.BuyNowViewModel_Factory;
import com.iaai.android.bdt.feature.productDetail.chromeSection.ChromeSectionFragment;
import com.iaai.android.bdt.feature.productDetail.chromeSection.ChromeSectionFragment_MembersInjector;
import com.iaai.android.bdt.feature.productDetail.chromeSection.ChromeSectionRepository_Factory;
import com.iaai.android.bdt.feature.productDetail.chromeSection.ChromeSectionViewModel;
import com.iaai.android.bdt.feature.productDetail.chromeSection.ChromeSectionViewModel_Factory;
import com.iaai.android.bdt.feature.productDetail.costCalculator.CostCalculatorFragment;
import com.iaai.android.bdt.feature.productDetail.costCalculator.CostCalculatorFragment_MembersInjector;
import com.iaai.android.bdt.feature.productDetail.costCalculator.CostCalculatorRepository_Factory;
import com.iaai.android.bdt.feature.productDetail.costCalculator.CostCalculatorViewModel;
import com.iaai.android.bdt.feature.productDetail.costCalculator.CostCalculatorViewModel_Factory;
import com.iaai.android.bdt.feature.productDetail.prebid.PreBidFragment;
import com.iaai.android.bdt.feature.productDetail.prebid.PreBidFragment_MembersInjector;
import com.iaai.android.bdt.feature.productDetail.prebid.PreBidRepository_Factory;
import com.iaai.android.bdt.feature.productDetail.prebid.PreBidViewModel;
import com.iaai.android.bdt.feature.productDetail.prebid.PreBidViewModel_Factory;
import com.iaai.android.bdt.feature.productDetail.reports.BDTPremiumVehicleReportActivity;
import com.iaai.android.bdt.feature.productDetail.reports.BDTPremiumVehicleReportActivity_MembersInjector;
import com.iaai.android.bdt.feature.productDetail.reports.IAAConditionReportActivity;
import com.iaai.android.bdt.feature.productDetail.reports.IAAConditionReportActivity_MembersInjector;
import com.iaai.android.bdt.feature.productDetail.reports.PremiumVehicleReportRepository_Factory;
import com.iaai.android.bdt.feature.productDetail.reports.PremiunVehicleReportViewModel;
import com.iaai.android.bdt.feature.productDetail.reports.PremiunVehicleReportViewModel_Factory;
import com.iaai.android.bdt.feature.productDetail.vehicleimage.Product360ImageActivity;
import com.iaai.android.bdt.feature.termsofuse.AuctionRuleRepository_Factory;
import com.iaai.android.bdt.feature.termsofuse.AuctionRuleViewModel;
import com.iaai.android.bdt.feature.termsofuse.AuctionRuleViewModel_Factory;
import com.iaai.android.bdt.feature.termsofuse.TermsOfUseAuctionRuleActivity;
import com.iaai.android.bdt.feature.termsofuse.TermsOfUseAuctionRuleActivity_MembersInjector;
import com.iaai.android.bdt.feature.utilsActivity.WebViewActivity;
import com.iaai.android.bdt.feature.viewPager.FastSearchListRepository_Factory;
import com.iaai.android.bdt.feature.viewPager.FastSearchViewModel;
import com.iaai.android.bdt.feature.viewPager.FastSearchViewModel_Factory;
import com.iaai.android.bdt.feature.watchList.WatchRepository_Factory;
import com.iaai.android.bdt.injection.module.ActivityModule_ContributeAFCTermsPage$app_productionRelease;
import com.iaai.android.bdt.injection.module.ActivityModule_ContributeBDTLoginActivity$app_productionRelease;
import com.iaai.android.bdt.injection.module.ActivityModule_ContributeBaseActivity$app_productionRelease;
import com.iaai.android.bdt.injection.module.ActivityModule_ContributeFilterActivity$app_productionRelease;
import com.iaai.android.bdt.injection.module.ActivityModule_ContributeMainActivity$app_productionRelease;
import com.iaai.android.bdt.injection.module.ActivityModule_ContributeSplashActivity$app_productionRelease;
import com.iaai.android.bdt.injection.module.ActivityModule_ContributeSubFilterActivity$app_productionRelease;
import com.iaai.android.bdt.injection.module.ActivityModule_ContributeWatchListActivity$app_productionRelease;
import com.iaai.android.bdt.injection.module.ActivityModule_ContributeWebViewActivity$app_productionRelease;
import com.iaai.android.bdt.injection.module.ApplicationModule;
import com.iaai.android.bdt.injection.module.ApplicationModule_ProvideContext$app_productionReleaseFactory;
import com.iaai.android.bdt.injection.module.C2833xec933ff9;
import com.iaai.android.bdt.injection.module.C2834x86694b49;
import com.iaai.android.bdt.injection.module.C2835x9781d273;
import com.iaai.android.bdt.injection.module.C2836xb8eae034;
import com.iaai.android.bdt.injection.module.C2837xfcc08fcd;
import com.iaai.android.bdt.injection.module.C2838x7cf6479a;
import com.iaai.android.bdt.injection.module.C2839x5866c2bb;
import com.iaai.android.bdt.injection.module.C2840xc5ac0c61;
import com.iaai.android.bdt.injection.module.C2841x2bca5525;
import com.iaai.android.bdt.injection.module.C2842x9e94083;
import com.iaai.android.bdt.injection.module.C2843xcac342df;
import com.iaai.android.bdt.injection.module.C2844xbb69ae5;
import com.iaai.android.bdt.injection.module.C2845x87ed9a74;
import com.iaai.android.bdt.injection.module.C2846xb9ae6495;
import com.iaai.android.bdt.injection.module.C2847xd8231361;
import com.iaai.android.bdt.injection.module.C2848x7f1a6ddb;
import com.iaai.android.bdt.injection.module.C2849x8913c883;
import com.iaai.android.bdt.injection.module.C2850xe66294a8;
import com.iaai.android.bdt.injection.module.C2851xa1b806f5;
import com.iaai.android.bdt.injection.module.C2852xd7732dd2;
import com.iaai.android.bdt.injection.module.C2853xa62b51f1;
import com.iaai.android.bdt.injection.module.C2854xfcdecd5d;
import com.iaai.android.bdt.injection.module.C2855xfefe3896;
import com.iaai.android.bdt.injection.module.C2856x1ff4a1df;
import com.iaai.android.bdt.injection.module.C2857x207dec96;
import com.iaai.android.bdt.injection.module.C2858xa65e9bc7;
import com.iaai.android.bdt.injection.module.C2859xf0fafcc;
import com.iaai.android.bdt.injection.module.C2860x22c96259;
import com.iaai.android.bdt.injection.module.C2861xd6519331;
import com.iaai.android.bdt.injection.module.C2862x7ad821b9;
import com.iaai.android.bdt.injection.module.C2863xd79c7c1f;
import com.iaai.android.bdt.injection.module.C2864xbce57620;
import com.iaai.android.bdt.injection.module.C2865xf001133a;
import com.iaai.android.bdt.injection.module.C2866xb82e191;
import com.iaai.android.bdt.injection.module.C2867xe32272e0;
import com.iaai.android.bdt.injection.module.C2868xe976bf5e;
import com.iaai.android.bdt.injection.module.C2869xfd7b965f;
import com.iaai.android.bdt.injection.module.C2870x80ca0a6c;
import com.iaai.android.bdt.injection.module.C2871x1a1caac9;
import com.iaai.android.bdt.injection.module.C2872x8eb16d2f;
import com.iaai.android.bdt.injection.module.C2873x6a2e7676;
import com.iaai.android.bdt.injection.module.C2874x9a4341e6;
import com.iaai.android.bdt.injection.module.C2875x7d0d59c8;
import com.iaai.android.bdt.injection.module.C2876xa481e86;
import com.iaai.android.bdt.injection.module.C2877x93a7a693;
import com.iaai.android.bdt.injection.module.C2878x2357de1;
import com.iaai.android.bdt.injection.module.C2879x16e3ea2e;
import com.iaai.android.bdt.injection.module.C2880xc39d780e;
import com.iaai.android.bdt.injection.module.C2881x8adf5b73;
import com.iaai.android.bdt.injection.module.C2882xf1800fef;
import com.iaai.android.bdt.injection.module.C2883x76239e11;
import com.iaai.android.bdt.injection.module.C2884xb2f399f8;
import com.iaai.android.bdt.injection.module.C2885x2d128e2b;
import com.iaai.android.bdt.injection.module.C2886xfdee3d8e;
import com.iaai.android.bdt.injection.module.C2887x47b12c83;
import com.iaai.android.bdt.injection.module.CustomInterceptor;
import com.iaai.android.bdt.injection.module.FragmentModule_ContributeAuctionMainList$app_productionRelease;
import com.iaai.android.bdt.injection.module.FragmentModule_ContributeAuctionSalesList$app_productionRelease;
import com.iaai.android.bdt.injection.module.FragmentModule_ContributeBuyNow$app_productionRelease;
import com.iaai.android.bdt.injection.module.FragmentModule_ContributeChromeSection$app_productionRelease;
import com.iaai.android.bdt.injection.module.FragmentModule_ContributeCostCalculator$app_productionRelease;
import com.iaai.android.bdt.injection.module.FragmentModule_ContributeFilterFragment$app_productionRelease;
import com.iaai.android.bdt.injection.module.FragmentModule_ContributeFindVehicle$app_productionRelease;
import com.iaai.android.bdt.injection.module.FragmentModule_ContributeMyListFragment$app_productionRelease;
import com.iaai.android.bdt.injection.module.FragmentModule_ContributePreBid$app_productionRelease;
import com.iaai.android.bdt.injection.module.FragmentModule_ContributeProductDetail$app_productionRelease;
import com.iaai.android.bdt.injection.module.FragmentModule_ContributeSearchByAuction$app_productionRelease;
import com.iaai.android.bdt.injection.module.FragmentModule_ContributeSearchByVehicle$app_productionRelease;
import com.iaai.android.bdt.injection.module.FragmentModule_ContributeViewPager$app_productionRelease;
import com.iaai.android.bdt.injection.module.FragmentModule_ContributeWatchListFragment$app_productionRelease;
import com.iaai.android.bdt.injection.module.NetworkModule;
import com.iaai.android.bdt.injection.module.NetworkModule_ProvideHttpClientFactory;
import com.iaai.android.bdt.injection.module.NetworkModule_ProvideInterceptorFactory;
import com.iaai.android.bdt.injection.module.NetworkModule_ProvideRetrofitFactory;
import com.iaai.android.bdt.injection.module.NetworkModule_ProvideServiceFactory;
import com.iaai.android.bdt.injection.module.PersistenceModule;
import com.iaai.android.bdt.injection.module.UserSessionModule;
import com.iaai.android.bdt.injection.module.UserSessionModule_SessionManagerFactory;
import com.iaai.android.bdt.network.Service;
import com.iaai.android.bdt.utils.SharedPrefsHelper;
import com.iaai.android.bdt.utils.SharedPrefsHelper_Factory;
import dagger.android.AndroidInjector;
import dagger.android.DaggerApplication;
import dagger.android.DaggerApplication_MembersInjector;
import dagger.android.DispatchingAndroidInjector;
import dagger.android.DispatchingAndroidInjector_Factory;
import dagger.internal.DoubleCheck;
import dagger.internal.MapProviderFactory;
import dagger.internal.Preconditions;
import java.util.Map;
import javax.inject.Provider;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;

public final class DaggerAppComponent implements AppComponent {
    private Provider<C2872x8eb16d2f.AccountSettingFragmentSubcomponent.Builder> accountSettingFragmentSubcomponentBuilderProvider;
    /* access modifiers changed from: private */
    public Provider<AppViewModelFactory> appViewModelFactoryProvider;
    private ApplicationModule applicationModule;
    private Provider<C2833xec933ff9.AuctionDateListActivitySubcomponent.Builder> auctionDateListActivitySubcomponentBuilderProvider;
    private Provider<FragmentModule_ContributeAuctionMainList$app_productionRelease.AuctionMainListFragmentSubcomponent.Builder> auctionMainListFragmentSubcomponentBuilderProvider;
    private AuctionMainListRepository_Factory auctionMainListRepositoryProvider;
    private AuctionMainListViewModel_Factory auctionMainListViewModelProvider;
    private AuctionRuleRepository_Factory auctionRuleRepositoryProvider;
    private AuctionRuleViewModel_Factory auctionRuleViewModelProvider;
    private Provider<C2835x9781d273.AuctionSalesListActivitySubcomponent.Builder> auctionSalesListActivitySubcomponentBuilderProvider;
    private Provider<FragmentModule_ContributeAuctionSalesList$app_productionRelease.AuctionSalesListFragmentSubcomponent.Builder> auctionSalesListFragmentSubcomponentBuilderProvider;
    private AuctionSalesListRepository_Factory auctionSalesListRepositoryProvider;
    private AuctionSalesListViewModel_Factory auctionSalesListViewModelProvider;
    private Provider<C2836xb8eae034.BDTAuctionMainListActivitySubcomponent.Builder> bDTAuctionMainListActivitySubcomponentBuilderProvider;
    private Provider<C2838x7cf6479a.BDTForgotPasswordActivitySubcomponent.Builder> bDTForgotPasswordActivitySubcomponentBuilderProvider;
    private Provider<C2837xfcc08fcd.BDTLandingPageActivitySubcomponent.Builder> bDTLandingPageActivitySubcomponentBuilderProvider;
    private Provider<ActivityModule_ContributeBDTLoginActivity$app_productionRelease.BDTLoginActivitySubcomponent.Builder> bDTLoginActivitySubcomponentBuilderProvider;
    private Provider<C2839x5866c2bb.BDTMyAccountActivitySubcomponent.Builder> bDTMyAccountActivitySubcomponentBuilderProvider;
    private Provider<C2846xb9ae6495.BDTPaymentActivitySubcomponent.Builder> bDTPaymentActivitySubcomponentBuilderProvider;
    private Provider<C2840xc5ac0c61.BDTPaymentMethodActivitySubcomponent.Builder> bDTPaymentMethodActivitySubcomponentBuilderProvider;
    private Provider<C2841x2bca5525.BDTPremiumVehicleReportActivitySubcomponent.Builder> bDTPremiumVehicleReportActivitySubcomponentBuilderProvider;
    private Provider<C2842x9e94083.BDTPromptPasswordDialogActivitySubcomponent.Builder> bDTPromptPasswordDialogActivitySubcomponentBuilderProvider;
    private Provider<C2843xcac342df.BDTSettingsActivitySubcomponent.Builder> bDTSettingsActivitySubcomponentBuilderProvider;
    private Provider<C2844xbb69ae5.BDTTermsOfUseActivitySubcomponent.Builder> bDTTermsOfUseActivitySubcomponentBuilderProvider;
    private Provider<C2884xb2f399f8.BDTToBePaidFragmentSubcomponent.Builder> bDTToBePaidFragmentSubcomponentBuilderProvider;
    private Provider<ActivityModule_ContributeBaseActivity$app_productionRelease.BaseActivitySubcomponent.Builder> baseActivitySubcomponentBuilderProvider;
    private Provider<FragmentModule_ContributeBuyNow$app_productionRelease.BuyNowFragmentSubcomponent.Builder> buyNowFragmentSubcomponentBuilderProvider;
    private Provider<C2845x87ed9a74.BuyNowOfferListActivitySubcomponent.Builder> buyNowOfferListActivitySubcomponentBuilderProvider;
    private Provider<C2873x6a2e7676.BuyNowOfferListFragmentSubcomponent.Builder> buyNowOfferListFragmentSubcomponentBuilderProvider;
    private BuyNowOfferListRepository_Factory buyNowOfferListRepositoryProvider;
    private BuyNowOfferListViewModel_Factory buyNowOfferListViewModelProvider;
    private BuyNowRepository_Factory buyNowRepositoryProvider;
    private BuyNowViewModel_Factory buyNowViewModelProvider;
    private Provider<FragmentModule_ContributeChromeSection$app_productionRelease.ChromeSectionFragmentSubcomponent.Builder> chromeSectionFragmentSubcomponentBuilderProvider;
    private ChromeSectionRepository_Factory chromeSectionRepositoryProvider;
    private ChromeSectionViewModel_Factory chromeSectionViewModelProvider;
    private Provider<FragmentModule_ContributeCostCalculator$app_productionRelease.CostCalculatorFragmentSubcomponent.Builder> costCalculatorFragmentSubcomponentBuilderProvider;
    private CostCalculatorRepository_Factory costCalculatorRepositoryProvider;
    private CostCalculatorViewModel_Factory costCalculatorViewModelProvider;
    private Provider<C2874x9a4341e6.DeliveryInstructionFragmentSubcomponent.Builder> deliveryInstructionFragmentSubcomponentBuilderProvider;
    private DeliveryInstructionViewModel_Factory deliveryInstructionViewModelProvider;
    private Provider<C2847xd8231361.DeliveryMethodActivitySubcomponent.Builder> deliveryMethodActivitySubcomponentBuilderProvider;
    private DeliveryMethodViewModel_Factory deliveryMethodViewModelProvider;
    private Provider<C2848x7f1a6ddb.EmailConfirmationActivitySubcomponent.Builder> emailConfirmationActivitySubcomponentBuilderProvider;
    private EmailConfirmationViewModel_Factory emailConfirmationViewModelProvider;
    private Provider<C2849x8913c883.EngineVideoActivitySubcomponent.Builder> engineVideoActivitySubcomponentBuilderProvider;
    private Provider<C2850xe66294a8.FastSearchFilterActivitySubcomponent.Builder> fastSearchFilterActivitySubcomponentBuilderProvider;
    private Provider<C2875x7d0d59c8.FastSearchFilterFragmentSubcomponent.Builder> fastSearchFilterFragmentSubcomponentBuilderProvider;
    private FastSearchFilterRepository_Factory fastSearchFilterRepositoryProvider;
    private FastSearchFilterViewModel_Factory fastSearchFilterViewModelProvider;
    private FastSearchListRepository_Factory fastSearchListRepositoryProvider;
    private FastSearchViewModel_Factory fastSearchViewModelProvider;
    private Provider<ActivityModule_ContributeFilterActivity$app_productionRelease.FilterActivitySubcomponent.Builder> filterActivitySubcomponentBuilderProvider;
    private Provider<FragmentModule_ContributeFilterFragment$app_productionRelease.FilterFragmentSubcomponent.Builder> filterFragmentSubcomponentBuilderProvider;
    private Provider<C2851xa1b806f5.FindVehicleFilterActivitySubcomponent.Builder> findVehicleFilterActivitySubcomponentBuilderProvider;
    private ForgotPasswordViewModel_Factory forgotPasswordViewModelProvider;
    private Provider<C2852xd7732dd2.IAAConditionReportActivitySubcomponent.Builder> iAAConditionReportActivitySubcomponentBuilderProvider;
    private Provider<C2876xa481e86.InsertRepOrAddFragmentSubcomponent.Builder> insertRepOrAddFragmentSubcomponentBuilderProvider;
    private InsertRepOrAddViewModel_Factory insertRepOrAddViewModelProvider;
    private Provider<C2853xa62b51f1.LandingBRESectionActivitySubcomponent.Builder> landingBRESectionActivitySubcomponentBuilderProvider;
    private LandingPageRepository_Factory landingPageRepositoryProvider;
    private LandingPageViewModel_Factory landingPageViewModelProvider;
    private Provider<C2877x93a7a693.LandingViewPagerFragmentSubcomponent.Builder> landingViewPagerFragmentSubcomponentBuilderProvider;
    private LogIAAErrorRepository_Factory logIAAErrorRepositoryProvider;
    private LoginRepository_Factory loginRepositoryProvider;
    private LoginViewModel_Factory loginViewModelProvider;
    private Provider<ActivityModule_ContributeMainActivity$app_productionRelease.MainActivitySubcomponent.Builder> mainActivitySubcomponentBuilderProvider;
    private Provider<C2854xfcdecd5d.MakeModelFilterActivitySubcomponent.Builder> makeModelFilterActivitySubcomponentBuilderProvider;
    private MakeModelMasterRepository_Factory makeModelMasterRepositoryProvider;
    private MakeModelViewModel_Factory makeModelViewModelProvider;
    private Provider<C2855xfefe3896.ManageBranchPrefActivitySubcomponent.Builder> manageBranchPrefActivitySubcomponentBuilderProvider;
    private Provider<C2856x1ff4a1df.ManageOfferListActivitySubcomponent.Builder> manageOfferListActivitySubcomponentBuilderProvider;
    private Provider<C2878x2357de1.ManageOfferListFragmentSubcomponent.Builder> manageOfferListFragmentSubcomponentBuilderProvider;
    private ManageOfferListRepository_Factory manageOfferListRepositoryProvider;
    private ManageOfferListViewModel_Factory manageOfferListViewModelProvider;
    private Provider<Map<Class<? extends ViewModel>, Provider<ViewModel>>> mapOfClassOfAndProviderOfViewModelProvider;
    private MyAccountRepository_Factory myAccountRepositoryProvider;
    private com.iaai.android.bdt.feature.myAccount.MyAccountRepository_Factory myAccountRepositoryProvider2;
    private MyAccountViewModel_Factory myAccountViewModelProvider;
    private Provider<FragmentModule_ContributeMyListFragment$app_productionRelease.MyListFragmentSubcomponent.Builder> myListFragmentSubcomponentBuilderProvider;
    private Provider<C2857x207dec96.OnBoardingActivitySubcomponent.Builder> onBoardingActivitySubcomponentBuilderProvider;
    private Provider<FragmentModule_ContributePreBid$app_productionRelease.PreBidFragmentSubcomponent.Builder> preBidFragmentSubcomponentBuilderProvider;
    private PreBidRepository_Factory preBidRepositoryProvider;
    private PreBidViewModel_Factory preBidViewModelProvider;
    private Provider<ActivityModule_ContributeWatchListActivity$app_productionRelease.PreSaleListActivitySubcomponent.Builder> preSaleListActivitySubcomponentBuilderProvider;
    private Provider<FragmentModule_ContributeWatchListFragment$app_productionRelease.PreSaleListFragmentSubcomponent.Builder> preSaleListFragmentSubcomponentBuilderProvider;
    private PreSaleListRepository_Factory preSaleListRepositoryProvider;
    private PreSaleListViewModel_Factory preSaleListViewModelProvider;
    private PremiumVehicleReportRepository_Factory premiumVehicleReportRepositoryProvider;
    private PremiunVehicleReportViewModel_Factory premiunVehicleReportViewModelProvider;
    private Provider<C2858xa65e9bc7.Product360ImageActivitySubcomponent.Builder> product360ImageActivitySubcomponentBuilderProvider;
    private Provider<C2834x86694b49.ProductDetailActivitySubcomponent.Builder> productDetailActivitySubcomponentBuilderProvider;
    private Provider<FragmentModule_ContributeProductDetail$app_productionRelease.ProductDetailFragmentSubcomponent.Builder> productDetailFragmentSubcomponentBuilderProvider;
    private ProductDetailRepository_Factory productDetailRepositoryProvider;
    private ProductDetailViewModel_Factory productDetailViewModelProvider;
    private Provider<OkHttpClient> provideHttpClientProvider;
    private Provider<CustomInterceptor> provideInterceptorProvider;
    private Provider<Retrofit> provideRetrofitProvider;
    private Provider<Service> provideServiceProvider;
    private Provider<SharedPreferences> provideSharedPreferences$app_productionReleaseProvider;
    private QuickFilterRepository_Factory quickFilterRepositoryProvider;
    private QuickFilterViewModel_Factory quickFilterViewModelProvider;
    private Provider<FragmentModule_ContributeFindVehicle$app_productionRelease.QuickLinksFragmentSubcomponent.Builder> quickLinksFragmentSubcomponentBuilderProvider;
    private Provider<ActivityModule_ContributeAFCTermsPage$app_productionRelease.ReceiptDPFActivitySubcomponent.Builder> receiptDPFActivitySubcomponentBuilderProvider;
    private Provider<C2879x16e3ea2e.RecommendedVehiclesFragmentSubcomponent.Builder> recommendedVehiclesFragmentSubcomponentBuilderProvider;
    private Provider<C2859xf0fafcc.RefinerResultActivitySubcomponent.Builder> refinerResultActivitySubcomponentBuilderProvider;
    private Provider<C2880xc39d780e.RefinerResultFragmentSubcomponent.Builder> refinerResultFragmentSubcomponentBuilderProvider;
    private Provider<C2860x22c96259.SaleDocListActivitySubcomponent.Builder> saleDocListActivitySubcomponentBuilderProvider;
    private SaleDocListViewModel_Factory saleDocListViewModelProvider;
    private SaleDocumentRepository_Factory saleDocumentRepositoryProvider;
    private SaleDocumentViewModel_Factory saleDocumentViewModelProvider;
    private Provider<C2861xd6519331.SalesDocumentActivitySubcomponent.Builder> salesDocumentActivitySubcomponentBuilderProvider;
    private Provider<C2881x8adf5b73.SalesDocumentFragmentSubcomponent.Builder> salesDocumentFragmentSubcomponentBuilderProvider;
    private Provider<C2862x7ad821b9.SavedSearchActivitySubcomponent.Builder> savedSearchActivitySubcomponentBuilderProvider;
    private SavedSearchListRepository_Factory savedSearchListRepositoryProvider;
    private SavedSearchListViewModel_Factory savedSearchListViewModelProvider;
    private Provider<C2863xd79c7c1f.SearchByACVActivitySubcomponent.Builder> searchByACVActivitySubcomponentBuilderProvider;
    private Provider<FragmentModule_ContributeSearchByAuction$app_productionRelease.SearchByAuctionFragmentSubcomponent.Builder> searchByAuctionFragmentSubcomponentBuilderProvider;
    private Provider<C2864xbce57620.SearchByDistanceActivitySubcomponent.Builder> searchByDistanceActivitySubcomponentBuilderProvider;
    private Provider<C2865xf001133a.SearchByOdometerActivitySubcomponent.Builder> searchByOdometerActivitySubcomponentBuilderProvider;
    private Provider<FragmentModule_ContributeSearchByVehicle$app_productionRelease.SearchByVehicleFragmentSubcomponent.Builder> searchByVehicleFragmentSubcomponentBuilderProvider;
    private Provider<C2866xb82e191.SearchResultActivitySubcomponent.Builder> searchResultActivitySubcomponentBuilderProvider;
    private Provider<C2882xf1800fef.SearchResultListFragmentSubcomponent.Builder> searchResultListFragmentSubcomponentBuilderProvider;
    private Provider<C2883x76239e11.SelectCreditCardFragmentSubcomponent.Builder> selectCreditCardFragmentSubcomponentBuilderProvider;
    /* access modifiers changed from: private */
    public Provider<SessionManager> sessionManagerProvider;
    /* access modifiers changed from: private */
    public Provider<SharedPrefsHelper> sharedPrefsHelperProvider;
    private Provider<ActivityModule_ContributeSplashActivity$app_productionRelease.SplashActivitySubcomponent.Builder> splashActivitySubcomponentBuilderProvider;
    private Provider<ActivityModule_ContributeSubFilterActivity$app_productionRelease.SubFilterActivitySubcomponent.Builder> subFilterActivitySubcomponentBuilderProvider;
    private Provider<C2867xe32272e0.TermsOfUseAuctionRuleActivitySubcomponent.Builder> termsOfUseAuctionRuleActivitySubcomponentBuilderProvider;
    private TermsOfUseViewModel_Factory termsOfUseViewModelProvider;
    private Provider<C2885x2d128e2b.ToBePaidConfirmationFragmentSubcomponent.Builder> toBePaidConfirmationFragmentSubcomponentBuilderProvider;
    private Provider<C2886xfdee3d8e.ToBePaidReviewFragmentSubcomponent.Builder> toBePaidReviewFragmentSubcomponentBuilderProvider;
    private ToBePaidViewModel_Factory toBePaidViewModelProvider;
    private Provider<C2887x47b12c83.ToBePickedUpListFragmentSubcomponent.Builder> toBePickedUpListFragmentSubcomponentBuilderProvider;
    private ToBePickedUpRepository_Factory toBePickedUpRepositoryProvider;
    private ToBePickedUpViewModel_Factory toBePickedUpViewModelProvider;
    private Provider<C2868xe976bf5e.ToPickedUpAccountActivitySubcomponent.Builder> toPickedUpAccountActivitySubcomponentBuilderProvider;
    private Provider<C2869xfd7b965f.ValidateOTPActivitySubcomponent.Builder> validateOTPActivitySubcomponentBuilderProvider;
    private ValidateOTPViewModel_Factory validateOTPViewModelProvider;
    private Provider<FragmentModule_ContributeViewPager$app_productionRelease.ViewPagerFragmentSubcomponent.Builder> viewPagerFragmentSubcomponentBuilderProvider;
    private WatchRepository_Factory watchRepositoryProvider;
    private Provider<ActivityModule_ContributeWebViewActivity$app_productionRelease.WebViewActivitySubcomponent.Builder> webViewActivitySubcomponentBuilderProvider;

    private DaggerAppComponent(Builder builder) {
        initialize(builder);
        initialize2(builder);
    }

    public static Builder builder() {
        return new Builder();
    }

    private Map<Class<? extends Activity>, Provider<AndroidInjector.Factory<? extends Activity>>> getMapOfClassOfAndProviderOfFactoryOf() {
        return ImmutableMap.builderWithExpectedSize(46).put(MainActivity.class, this.mainActivitySubcomponentBuilderProvider).put(AuctionSalesListActivity.class, this.auctionSalesListActivitySubcomponentBuilderProvider).put(BDTAuctionMainListActivity.class, this.bDTAuctionMainListActivitySubcomponentBuilderProvider).put(AuctionDateListActivity.class, this.auctionDateListActivitySubcomponentBuilderProvider).put(ProductDetailActivity.class, this.productDetailActivitySubcomponentBuilderProvider).put(Product360ImageActivity.class, this.product360ImageActivitySubcomponentBuilderProvider).put(BaseActivity.class, this.baseActivitySubcomponentBuilderProvider).put(BDTPremiumVehicleReportActivity.class, this.bDTPremiumVehicleReportActivitySubcomponentBuilderProvider).put(IAAConditionReportActivity.class, this.iAAConditionReportActivitySubcomponentBuilderProvider).put(BDTLandingPageActivity.class, this.bDTLandingPageActivitySubcomponentBuilderProvider).put(FilterActivity.class, this.filterActivitySubcomponentBuilderProvider).put(SubFilterActivity.class, this.subFilterActivitySubcomponentBuilderProvider).put(MakeModelFilterActivity.class, this.makeModelFilterActivitySubcomponentBuilderProvider).put(SearchResultActivity.class, this.searchResultActivitySubcomponentBuilderProvider).put(SplashActivity.class, this.splashActivitySubcomponentBuilderProvider).put(FindVehicleFilterActivity.class, this.findVehicleFilterActivitySubcomponentBuilderProvider).put(EngineVideoActivity.class, this.engineVideoActivitySubcomponentBuilderProvider).put(TermsOfUseAuctionRuleActivity.class, this.termsOfUseAuctionRuleActivitySubcomponentBuilderProvider).put(OnBoardingActivity.class, this.onBoardingActivitySubcomponentBuilderProvider).put(LandingBRESectionActivity.class, this.landingBRESectionActivitySubcomponentBuilderProvider).put(ManageOfferListActivity.class, this.manageOfferListActivitySubcomponentBuilderProvider).put(BDTPaymentActivity.class, this.bDTPaymentActivitySubcomponentBuilderProvider).put(BDTLoginActivity.class, this.bDTLoginActivitySubcomponentBuilderProvider).put(BDTForgotPasswordActivity.class, this.bDTForgotPasswordActivitySubcomponentBuilderProvider).put(EmailConfirmationActivity.class, this.emailConfirmationActivitySubcomponentBuilderProvider).put(ValidateOTPActivity.class, this.validateOTPActivitySubcomponentBuilderProvider).put(BDTTermsOfUseActivity.class, this.bDTTermsOfUseActivitySubcomponentBuilderProvider).put(BDTMyAccountActivity.class, this.bDTMyAccountActivitySubcomponentBuilderProvider).put(BDTPromptPasswordDialogActivity.class, this.bDTPromptPasswordDialogActivitySubcomponentBuilderProvider).put(PreSaleListActivity.class, this.preSaleListActivitySubcomponentBuilderProvider).put(BDTSettingsActivity.class, this.bDTSettingsActivitySubcomponentBuilderProvider).put(BDTPaymentMethodActivity.class, this.bDTPaymentMethodActivitySubcomponentBuilderProvider).put(WebViewActivity.class, this.webViewActivitySubcomponentBuilderProvider).put(BuyNowOfferListActivity.class, this.buyNowOfferListActivitySubcomponentBuilderProvider).put(ToPickedUpAccountActivity.class, this.toPickedUpAccountActivitySubcomponentBuilderProvider).put(ReceiptDPFActivity.class, this.receiptDPFActivitySubcomponentBuilderProvider).put(SalesDocumentActivity.class, this.salesDocumentActivitySubcomponentBuilderProvider).put(SaleDocListActivity.class, this.saleDocListActivitySubcomponentBuilderProvider).put(DeliveryMethodActivity.class, this.deliveryMethodActivitySubcomponentBuilderProvider).put(ManageBranchPrefActivity.class, this.manageBranchPrefActivitySubcomponentBuilderProvider).put(FastSearchFilterActivity.class, this.fastSearchFilterActivitySubcomponentBuilderProvider).put(RefinerResultActivity.class, this.refinerResultActivitySubcomponentBuilderProvider).put(SearchByDistanceActivity.class, this.searchByDistanceActivitySubcomponentBuilderProvider).put(SavedSearchActivity.class, this.savedSearchActivitySubcomponentBuilderProvider).put(SearchByOdometerActivity.class, this.searchByOdometerActivitySubcomponentBuilderProvider).put(SearchByACVActivity.class, this.searchByACVActivitySubcomponentBuilderProvider).build();
    }

    private DispatchingAndroidInjector<Activity> getDispatchingAndroidInjectorOfActivity() {
        return DispatchingAndroidInjector_Factory.newDispatchingAndroidInjector(getMapOfClassOfAndProviderOfFactoryOf());
    }

    private DispatchingAndroidInjector<BroadcastReceiver> getDispatchingAndroidInjectorOfBroadcastReceiver() {
        return DispatchingAndroidInjector_Factory.newDispatchingAndroidInjector(ImmutableMap.m165of());
    }

    private DispatchingAndroidInjector<Fragment> getDispatchingAndroidInjectorOfFragment() {
        return DispatchingAndroidInjector_Factory.newDispatchingAndroidInjector(ImmutableMap.m165of());
    }

    private DispatchingAndroidInjector<android.app.Service> getDispatchingAndroidInjectorOfService() {
        return DispatchingAndroidInjector_Factory.newDispatchingAndroidInjector(ImmutableMap.m165of());
    }

    private DispatchingAndroidInjector<ContentProvider> getDispatchingAndroidInjectorOfContentProvider() {
        return DispatchingAndroidInjector_Factory.newDispatchingAndroidInjector(ImmutableMap.m165of());
    }

    private Map<Class<? extends androidx.fragment.app.Fragment>, Provider<AndroidInjector.Factory<? extends androidx.fragment.app.Fragment>>> getMapOfClassOfAndProviderOfFactoryOf2() {
        return ImmutableMap.builderWithExpectedSize(30).put(ProductDetailFragment.class, this.productDetailFragmentSubcomponentBuilderProvider).put(AuctionSalesListFragment.class, this.auctionSalesListFragmentSubcomponentBuilderProvider).put(AuctionMainListFragment.class, this.auctionMainListFragmentSubcomponentBuilderProvider).put(PreBidFragment.class, this.preBidFragmentSubcomponentBuilderProvider).put(ViewPagerFragment.class, this.viewPagerFragmentSubcomponentBuilderProvider).put(BuyNowFragment.class, this.buyNowFragmentSubcomponentBuilderProvider).put(CostCalculatorFragment.class, this.costCalculatorFragmentSubcomponentBuilderProvider).put(ChromeSectionFragment.class, this.chromeSectionFragmentSubcomponentBuilderProvider).put(QuickLinksFragment.class, this.quickLinksFragmentSubcomponentBuilderProvider).put(SearchByAuctionFragment.class, this.searchByAuctionFragmentSubcomponentBuilderProvider).put(SearchByVehicleFragment.class, this.searchByVehicleFragmentSubcomponentBuilderProvider).put(SearchResultListFragment.class, this.searchResultListFragmentSubcomponentBuilderProvider).put(FilterFragment.class, this.filterFragmentSubcomponentBuilderProvider).put(RecommendedVehiclesFragment.class, this.recommendedVehiclesFragmentSubcomponentBuilderProvider).put(LandingViewPagerFragment.class, this.landingViewPagerFragmentSubcomponentBuilderProvider).put(SelectCreditCardFragment.class, this.selectCreditCardFragmentSubcomponentBuilderProvider).put(BDTToBePaidFragment.class, this.bDTToBePaidFragmentSubcomponentBuilderProvider).put(ManageOfferListFragment.class, this.manageOfferListFragmentSubcomponentBuilderProvider).put(PreSaleListFragment.class, this.preSaleListFragmentSubcomponentBuilderProvider).put(MyListFragment.class, this.myListFragmentSubcomponentBuilderProvider).put(AccountSettingFragment.class, this.accountSettingFragmentSubcomponentBuilderProvider).put(ToBePaidReviewFragment.class, this.toBePaidReviewFragmentSubcomponentBuilderProvider).put(ToBePaidConfirmationFragment.class, this.toBePaidConfirmationFragmentSubcomponentBuilderProvider).put(BuyNowOfferListFragment.class, this.buyNowOfferListFragmentSubcomponentBuilderProvider).put(ToBePickedUpListFragment.class, this.toBePickedUpListFragmentSubcomponentBuilderProvider).put(SalesDocumentFragment.class, this.salesDocumentFragmentSubcomponentBuilderProvider).put(DeliveryInstructionFragment.class, this.deliveryInstructionFragmentSubcomponentBuilderProvider).put(InsertRepOrAddFragment.class, this.insertRepOrAddFragmentSubcomponentBuilderProvider).put(FastSearchFilterFragment.class, this.fastSearchFilterFragmentSubcomponentBuilderProvider).put(RefinerResultFragment.class, this.refinerResultFragmentSubcomponentBuilderProvider).build();
    }

    /* access modifiers changed from: private */
    public DispatchingAndroidInjector<androidx.fragment.app.Fragment> getDispatchingAndroidInjectorOfFragment2() {
        return DispatchingAndroidInjector_Factory.newDispatchingAndroidInjector(getMapOfClassOfAndProviderOfFactoryOf2());
    }

    private void initialize(Builder builder) {
        this.mainActivitySubcomponentBuilderProvider = new Provider<ActivityModule_ContributeMainActivity$app_productionRelease.MainActivitySubcomponent.Builder>() {
            public ActivityModule_ContributeMainActivity$app_productionRelease.MainActivitySubcomponent.Builder get() {
                return new MainActivitySubcomponentBuilder();
            }
        };
        this.auctionSalesListActivitySubcomponentBuilderProvider = new Provider<C2835x9781d273.AuctionSalesListActivitySubcomponent.Builder>() {
            public C2835x9781d273.AuctionSalesListActivitySubcomponent.Builder get() {
                return new AuctionSalesListActivitySubcomponentBuilder();
            }
        };
        this.bDTAuctionMainListActivitySubcomponentBuilderProvider = new Provider<C2836xb8eae034.BDTAuctionMainListActivitySubcomponent.Builder>() {
            public C2836xb8eae034.BDTAuctionMainListActivitySubcomponent.Builder get() {
                return new BDTAuctionMainListActivitySubcomponentBuilder();
            }
        };
        this.auctionDateListActivitySubcomponentBuilderProvider = new Provider<C2833xec933ff9.AuctionDateListActivitySubcomponent.Builder>() {
            public C2833xec933ff9.AuctionDateListActivitySubcomponent.Builder get() {
                return new AuctionDateListActivitySubcomponentBuilder();
            }
        };
        this.productDetailActivitySubcomponentBuilderProvider = new Provider<C2834x86694b49.ProductDetailActivitySubcomponent.Builder>() {
            public C2834x86694b49.ProductDetailActivitySubcomponent.Builder get() {
                return new ProductDetailActivitySubcomponentBuilder();
            }
        };
        this.product360ImageActivitySubcomponentBuilderProvider = new Provider<C2858xa65e9bc7.Product360ImageActivitySubcomponent.Builder>() {
            public C2858xa65e9bc7.Product360ImageActivitySubcomponent.Builder get() {
                return new Product360ImageActivitySubcomponentBuilder();
            }
        };
        this.baseActivitySubcomponentBuilderProvider = new Provider<ActivityModule_ContributeBaseActivity$app_productionRelease.BaseActivitySubcomponent.Builder>() {
            public ActivityModule_ContributeBaseActivity$app_productionRelease.BaseActivitySubcomponent.Builder get() {
                return new BaseActivitySubcomponentBuilder();
            }
        };
        this.bDTPremiumVehicleReportActivitySubcomponentBuilderProvider = new Provider<C2841x2bca5525.BDTPremiumVehicleReportActivitySubcomponent.Builder>() {
            public C2841x2bca5525.BDTPremiumVehicleReportActivitySubcomponent.Builder get() {
                return new BDTPremiumVehicleReportActivitySubcomponentBuilder();
            }
        };
        this.iAAConditionReportActivitySubcomponentBuilderProvider = new Provider<C2852xd7732dd2.IAAConditionReportActivitySubcomponent.Builder>() {
            public C2852xd7732dd2.IAAConditionReportActivitySubcomponent.Builder get() {
                return new IAAConditionReportActivitySubcomponentBuilder();
            }
        };
        this.bDTLandingPageActivitySubcomponentBuilderProvider = new Provider<C2837xfcc08fcd.BDTLandingPageActivitySubcomponent.Builder>() {
            public C2837xfcc08fcd.BDTLandingPageActivitySubcomponent.Builder get() {
                return new BDTLandingPageActivitySubcomponentBuilder();
            }
        };
        this.filterActivitySubcomponentBuilderProvider = new Provider<ActivityModule_ContributeFilterActivity$app_productionRelease.FilterActivitySubcomponent.Builder>() {
            public ActivityModule_ContributeFilterActivity$app_productionRelease.FilterActivitySubcomponent.Builder get() {
                return new FilterActivitySubcomponentBuilder();
            }
        };
        this.subFilterActivitySubcomponentBuilderProvider = new Provider<ActivityModule_ContributeSubFilterActivity$app_productionRelease.SubFilterActivitySubcomponent.Builder>() {
            public ActivityModule_ContributeSubFilterActivity$app_productionRelease.SubFilterActivitySubcomponent.Builder get() {
                return new SubFilterActivitySubcomponentBuilder();
            }
        };
        this.makeModelFilterActivitySubcomponentBuilderProvider = new Provider<C2854xfcdecd5d.MakeModelFilterActivitySubcomponent.Builder>() {
            public C2854xfcdecd5d.MakeModelFilterActivitySubcomponent.Builder get() {
                return new MakeModelFilterActivitySubcomponentBuilder();
            }
        };
        this.searchResultActivitySubcomponentBuilderProvider = new Provider<C2866xb82e191.SearchResultActivitySubcomponent.Builder>() {
            public C2866xb82e191.SearchResultActivitySubcomponent.Builder get() {
                return new SearchResultActivitySubcomponentBuilder();
            }
        };
        this.splashActivitySubcomponentBuilderProvider = new Provider<ActivityModule_ContributeSplashActivity$app_productionRelease.SplashActivitySubcomponent.Builder>() {
            public ActivityModule_ContributeSplashActivity$app_productionRelease.SplashActivitySubcomponent.Builder get() {
                return new SplashActivitySubcomponentBuilder();
            }
        };
        this.findVehicleFilterActivitySubcomponentBuilderProvider = new Provider<C2851xa1b806f5.FindVehicleFilterActivitySubcomponent.Builder>() {
            public C2851xa1b806f5.FindVehicleFilterActivitySubcomponent.Builder get() {
                return new FindVehicleFilterActivitySubcomponentBuilder();
            }
        };
        this.engineVideoActivitySubcomponentBuilderProvider = new Provider<C2849x8913c883.EngineVideoActivitySubcomponent.Builder>() {
            public C2849x8913c883.EngineVideoActivitySubcomponent.Builder get() {
                return new EngineVideoActivitySubcomponentBuilder();
            }
        };
        this.termsOfUseAuctionRuleActivitySubcomponentBuilderProvider = new Provider<C2867xe32272e0.TermsOfUseAuctionRuleActivitySubcomponent.Builder>() {
            public C2867xe32272e0.TermsOfUseAuctionRuleActivitySubcomponent.Builder get() {
                return new TermsOfUseAuctionRuleActivitySubcomponentBuilder();
            }
        };
        this.onBoardingActivitySubcomponentBuilderProvider = new Provider<C2857x207dec96.OnBoardingActivitySubcomponent.Builder>() {
            public C2857x207dec96.OnBoardingActivitySubcomponent.Builder get() {
                return new OnBoardingActivitySubcomponentBuilder();
            }
        };
        this.landingBRESectionActivitySubcomponentBuilderProvider = new Provider<C2853xa62b51f1.LandingBRESectionActivitySubcomponent.Builder>() {
            public C2853xa62b51f1.LandingBRESectionActivitySubcomponent.Builder get() {
                return new LandingBRESectionActivitySubcomponentBuilder();
            }
        };
        this.manageOfferListActivitySubcomponentBuilderProvider = new Provider<C2856x1ff4a1df.ManageOfferListActivitySubcomponent.Builder>() {
            public C2856x1ff4a1df.ManageOfferListActivitySubcomponent.Builder get() {
                return new ManageOfferListActivitySubcomponentBuilder();
            }
        };
        this.bDTPaymentActivitySubcomponentBuilderProvider = new Provider<C2846xb9ae6495.BDTPaymentActivitySubcomponent.Builder>() {
            public C2846xb9ae6495.BDTPaymentActivitySubcomponent.Builder get() {
                return new BDTPaymentActivitySubcomponentBuilder();
            }
        };
        this.bDTLoginActivitySubcomponentBuilderProvider = new Provider<ActivityModule_ContributeBDTLoginActivity$app_productionRelease.BDTLoginActivitySubcomponent.Builder>() {
            public ActivityModule_ContributeBDTLoginActivity$app_productionRelease.BDTLoginActivitySubcomponent.Builder get() {
                return new BDTLoginActivitySubcomponentBuilder();
            }
        };
        this.bDTForgotPasswordActivitySubcomponentBuilderProvider = new Provider<C2838x7cf6479a.BDTForgotPasswordActivitySubcomponent.Builder>() {
            public C2838x7cf6479a.BDTForgotPasswordActivitySubcomponent.Builder get() {
                return new BDTForgotPasswordActivitySubcomponentBuilder();
            }
        };
        this.emailConfirmationActivitySubcomponentBuilderProvider = new Provider<C2848x7f1a6ddb.EmailConfirmationActivitySubcomponent.Builder>() {
            public C2848x7f1a6ddb.EmailConfirmationActivitySubcomponent.Builder get() {
                return new EmailConfirmationActivitySubcomponentBuilder();
            }
        };
        this.validateOTPActivitySubcomponentBuilderProvider = new Provider<C2869xfd7b965f.ValidateOTPActivitySubcomponent.Builder>() {
            public C2869xfd7b965f.ValidateOTPActivitySubcomponent.Builder get() {
                return new ValidateOTPActivitySubcomponentBuilder();
            }
        };
        this.bDTTermsOfUseActivitySubcomponentBuilderProvider = new Provider<C2844xbb69ae5.BDTTermsOfUseActivitySubcomponent.Builder>() {
            public C2844xbb69ae5.BDTTermsOfUseActivitySubcomponent.Builder get() {
                return new BDTTermsOfUseActivitySubcomponentBuilder();
            }
        };
        this.bDTMyAccountActivitySubcomponentBuilderProvider = new Provider<C2839x5866c2bb.BDTMyAccountActivitySubcomponent.Builder>() {
            public C2839x5866c2bb.BDTMyAccountActivitySubcomponent.Builder get() {
                return new BDTMyAccountActivitySubcomponentBuilder();
            }
        };
        this.bDTPromptPasswordDialogActivitySubcomponentBuilderProvider = new Provider<C2842x9e94083.BDTPromptPasswordDialogActivitySubcomponent.Builder>() {
            public C2842x9e94083.BDTPromptPasswordDialogActivitySubcomponent.Builder get() {
                return new BDTPromptPasswordDialogActivitySubcomponentBuilder();
            }
        };
        this.preSaleListActivitySubcomponentBuilderProvider = new Provider<ActivityModule_ContributeWatchListActivity$app_productionRelease.PreSaleListActivitySubcomponent.Builder>() {
            public ActivityModule_ContributeWatchListActivity$app_productionRelease.PreSaleListActivitySubcomponent.Builder get() {
                return new PreSaleListActivitySubcomponentBuilder();
            }
        };
        this.bDTSettingsActivitySubcomponentBuilderProvider = new Provider<C2843xcac342df.BDTSettingsActivitySubcomponent.Builder>() {
            public C2843xcac342df.BDTSettingsActivitySubcomponent.Builder get() {
                return new BDTSettingsActivitySubcomponentBuilder();
            }
        };
        this.bDTPaymentMethodActivitySubcomponentBuilderProvider = new Provider<C2840xc5ac0c61.BDTPaymentMethodActivitySubcomponent.Builder>() {
            public C2840xc5ac0c61.BDTPaymentMethodActivitySubcomponent.Builder get() {
                return new BDTPaymentMethodActivitySubcomponentBuilder();
            }
        };
        this.webViewActivitySubcomponentBuilderProvider = new Provider<ActivityModule_ContributeWebViewActivity$app_productionRelease.WebViewActivitySubcomponent.Builder>() {
            public ActivityModule_ContributeWebViewActivity$app_productionRelease.WebViewActivitySubcomponent.Builder get() {
                return new WebViewActivitySubcomponentBuilder();
            }
        };
        this.buyNowOfferListActivitySubcomponentBuilderProvider = new Provider<C2845x87ed9a74.BuyNowOfferListActivitySubcomponent.Builder>() {
            public C2845x87ed9a74.BuyNowOfferListActivitySubcomponent.Builder get() {
                return new BuyNowOfferListActivitySubcomponentBuilder();
            }
        };
        this.toPickedUpAccountActivitySubcomponentBuilderProvider = new Provider<C2868xe976bf5e.ToPickedUpAccountActivitySubcomponent.Builder>() {
            public C2868xe976bf5e.ToPickedUpAccountActivitySubcomponent.Builder get() {
                return new ToPickedUpAccountActivitySubcomponentBuilder();
            }
        };
        this.receiptDPFActivitySubcomponentBuilderProvider = new Provider<ActivityModule_ContributeAFCTermsPage$app_productionRelease.ReceiptDPFActivitySubcomponent.Builder>() {
            public ActivityModule_ContributeAFCTermsPage$app_productionRelease.ReceiptDPFActivitySubcomponent.Builder get() {
                return new ReceiptDPFActivitySubcomponentBuilder();
            }
        };
        this.salesDocumentActivitySubcomponentBuilderProvider = new Provider<C2861xd6519331.SalesDocumentActivitySubcomponent.Builder>() {
            public C2861xd6519331.SalesDocumentActivitySubcomponent.Builder get() {
                return new SalesDocumentActivitySubcomponentBuilder();
            }
        };
        this.saleDocListActivitySubcomponentBuilderProvider = new Provider<C2860x22c96259.SaleDocListActivitySubcomponent.Builder>() {
            public C2860x22c96259.SaleDocListActivitySubcomponent.Builder get() {
                return new SaleDocListActivitySubcomponentBuilder();
            }
        };
        this.deliveryMethodActivitySubcomponentBuilderProvider = new Provider<C2847xd8231361.DeliveryMethodActivitySubcomponent.Builder>() {
            public C2847xd8231361.DeliveryMethodActivitySubcomponent.Builder get() {
                return new DeliveryMethodActivitySubcomponentBuilder();
            }
        };
        this.manageBranchPrefActivitySubcomponentBuilderProvider = new Provider<C2855xfefe3896.ManageBranchPrefActivitySubcomponent.Builder>() {
            public C2855xfefe3896.ManageBranchPrefActivitySubcomponent.Builder get() {
                return new ManageBranchPrefActivitySubcomponentBuilder();
            }
        };
        this.fastSearchFilterActivitySubcomponentBuilderProvider = new Provider<C2850xe66294a8.FastSearchFilterActivitySubcomponent.Builder>() {
            public C2850xe66294a8.FastSearchFilterActivitySubcomponent.Builder get() {
                return new FastSearchFilterActivitySubcomponentBuilder();
            }
        };
        this.refinerResultActivitySubcomponentBuilderProvider = new Provider<C2859xf0fafcc.RefinerResultActivitySubcomponent.Builder>() {
            public C2859xf0fafcc.RefinerResultActivitySubcomponent.Builder get() {
                return new RefinerResultActivitySubcomponentBuilder();
            }
        };
        this.searchByDistanceActivitySubcomponentBuilderProvider = new Provider<C2864xbce57620.SearchByDistanceActivitySubcomponent.Builder>() {
            public C2864xbce57620.SearchByDistanceActivitySubcomponent.Builder get() {
                return new SearchByDistanceActivitySubcomponentBuilder();
            }
        };
        this.savedSearchActivitySubcomponentBuilderProvider = new Provider<C2862x7ad821b9.SavedSearchActivitySubcomponent.Builder>() {
            public C2862x7ad821b9.SavedSearchActivitySubcomponent.Builder get() {
                return new SavedSearchActivitySubcomponentBuilder();
            }
        };
        this.searchByOdometerActivitySubcomponentBuilderProvider = new Provider<C2865xf001133a.SearchByOdometerActivitySubcomponent.Builder>() {
            public C2865xf001133a.SearchByOdometerActivitySubcomponent.Builder get() {
                return new SearchByOdometerActivitySubcomponentBuilder();
            }
        };
        this.searchByACVActivitySubcomponentBuilderProvider = new Provider<C2863xd79c7c1f.SearchByACVActivitySubcomponent.Builder>() {
            public C2863xd79c7c1f.SearchByACVActivitySubcomponent.Builder get() {
                return new SearchByACVActivitySubcomponentBuilder();
            }
        };
        this.productDetailFragmentSubcomponentBuilderProvider = new Provider<FragmentModule_ContributeProductDetail$app_productionRelease.ProductDetailFragmentSubcomponent.Builder>() {
            public FragmentModule_ContributeProductDetail$app_productionRelease.ProductDetailFragmentSubcomponent.Builder get() {
                return new ProductDetailFragmentSubcomponentBuilder();
            }
        };
        this.auctionSalesListFragmentSubcomponentBuilderProvider = new Provider<FragmentModule_ContributeAuctionSalesList$app_productionRelease.AuctionSalesListFragmentSubcomponent.Builder>() {
            public FragmentModule_ContributeAuctionSalesList$app_productionRelease.AuctionSalesListFragmentSubcomponent.Builder get() {
                return new AuctionSalesListFragmentSubcomponentBuilder();
            }
        };
        this.auctionMainListFragmentSubcomponentBuilderProvider = new Provider<FragmentModule_ContributeAuctionMainList$app_productionRelease.AuctionMainListFragmentSubcomponent.Builder>() {
            public FragmentModule_ContributeAuctionMainList$app_productionRelease.AuctionMainListFragmentSubcomponent.Builder get() {
                return new AuctionMainListFragmentSubcomponentBuilder();
            }
        };
        this.preBidFragmentSubcomponentBuilderProvider = new Provider<FragmentModule_ContributePreBid$app_productionRelease.PreBidFragmentSubcomponent.Builder>() {
            public FragmentModule_ContributePreBid$app_productionRelease.PreBidFragmentSubcomponent.Builder get() {
                return new PreBidFragmentSubcomponentBuilder();
            }
        };
        this.viewPagerFragmentSubcomponentBuilderProvider = new Provider<FragmentModule_ContributeViewPager$app_productionRelease.ViewPagerFragmentSubcomponent.Builder>() {
            public FragmentModule_ContributeViewPager$app_productionRelease.ViewPagerFragmentSubcomponent.Builder get() {
                return new ViewPagerFragmentSubcomponentBuilder();
            }
        };
        this.buyNowFragmentSubcomponentBuilderProvider = new Provider<FragmentModule_ContributeBuyNow$app_productionRelease.BuyNowFragmentSubcomponent.Builder>() {
            public FragmentModule_ContributeBuyNow$app_productionRelease.BuyNowFragmentSubcomponent.Builder get() {
                return new BuyNowFragmentSubcomponentBuilder();
            }
        };
        this.costCalculatorFragmentSubcomponentBuilderProvider = new Provider<FragmentModule_ContributeCostCalculator$app_productionRelease.CostCalculatorFragmentSubcomponent.Builder>() {
            public FragmentModule_ContributeCostCalculator$app_productionRelease.CostCalculatorFragmentSubcomponent.Builder get() {
                return new CostCalculatorFragmentSubcomponentBuilder();
            }
        };
        this.chromeSectionFragmentSubcomponentBuilderProvider = new Provider<FragmentModule_ContributeChromeSection$app_productionRelease.ChromeSectionFragmentSubcomponent.Builder>() {
            public FragmentModule_ContributeChromeSection$app_productionRelease.ChromeSectionFragmentSubcomponent.Builder get() {
                return new ChromeSectionFragmentSubcomponentBuilder();
            }
        };
        this.quickLinksFragmentSubcomponentBuilderProvider = new Provider<FragmentModule_ContributeFindVehicle$app_productionRelease.QuickLinksFragmentSubcomponent.Builder>() {
            public FragmentModule_ContributeFindVehicle$app_productionRelease.QuickLinksFragmentSubcomponent.Builder get() {
                return new QuickLinksFragmentSubcomponentBuilder();
            }
        };
        this.searchByAuctionFragmentSubcomponentBuilderProvider = new Provider<FragmentModule_ContributeSearchByAuction$app_productionRelease.SearchByAuctionFragmentSubcomponent.Builder>() {
            public FragmentModule_ContributeSearchByAuction$app_productionRelease.SearchByAuctionFragmentSubcomponent.Builder get() {
                return new SearchByAuctionFragmentSubcomponentBuilder();
            }
        };
        this.searchByVehicleFragmentSubcomponentBuilderProvider = new Provider<FragmentModule_ContributeSearchByVehicle$app_productionRelease.SearchByVehicleFragmentSubcomponent.Builder>() {
            public FragmentModule_ContributeSearchByVehicle$app_productionRelease.SearchByVehicleFragmentSubcomponent.Builder get() {
                return new SearchByVehicleFragmentSubcomponentBuilder();
            }
        };
        this.searchResultListFragmentSubcomponentBuilderProvider = new Provider<C2882xf1800fef.SearchResultListFragmentSubcomponent.Builder>() {
            public C2882xf1800fef.SearchResultListFragmentSubcomponent.Builder get() {
                return new SearchResultListFragmentSubcomponentBuilder();
            }
        };
        this.filterFragmentSubcomponentBuilderProvider = new Provider<FragmentModule_ContributeFilterFragment$app_productionRelease.FilterFragmentSubcomponent.Builder>() {
            public FragmentModule_ContributeFilterFragment$app_productionRelease.FilterFragmentSubcomponent.Builder get() {
                return new FilterFragmentSubcomponentBuilder();
            }
        };
        this.recommendedVehiclesFragmentSubcomponentBuilderProvider = new Provider<C2879x16e3ea2e.RecommendedVehiclesFragmentSubcomponent.Builder>() {
            public C2879x16e3ea2e.RecommendedVehiclesFragmentSubcomponent.Builder get() {
                return new RecommendedVehiclesFragmentSubcomponentBuilder();
            }
        };
        this.landingViewPagerFragmentSubcomponentBuilderProvider = new Provider<C2877x93a7a693.LandingViewPagerFragmentSubcomponent.Builder>() {
            public C2877x93a7a693.LandingViewPagerFragmentSubcomponent.Builder get() {
                return new LandingViewPagerFragmentSubcomponentBuilder();
            }
        };
        this.selectCreditCardFragmentSubcomponentBuilderProvider = new Provider<C2883x76239e11.SelectCreditCardFragmentSubcomponent.Builder>() {
            public C2883x76239e11.SelectCreditCardFragmentSubcomponent.Builder get() {
                return new SelectCreditCardFragmentSubcomponentBuilder();
            }
        };
        this.bDTToBePaidFragmentSubcomponentBuilderProvider = new Provider<C2884xb2f399f8.BDTToBePaidFragmentSubcomponent.Builder>() {
            public C2884xb2f399f8.BDTToBePaidFragmentSubcomponent.Builder get() {
                return new BDTToBePaidFragmentSubcomponentBuilder();
            }
        };
        this.manageOfferListFragmentSubcomponentBuilderProvider = new Provider<C2878x2357de1.ManageOfferListFragmentSubcomponent.Builder>() {
            public C2878x2357de1.ManageOfferListFragmentSubcomponent.Builder get() {
                return new ManageOfferListFragmentSubcomponentBuilder();
            }
        };
        this.preSaleListFragmentSubcomponentBuilderProvider = new Provider<FragmentModule_ContributeWatchListFragment$app_productionRelease.PreSaleListFragmentSubcomponent.Builder>() {
            public FragmentModule_ContributeWatchListFragment$app_productionRelease.PreSaleListFragmentSubcomponent.Builder get() {
                return new PreSaleListFragmentSubcomponentBuilder();
            }
        };
        this.myListFragmentSubcomponentBuilderProvider = new Provider<FragmentModule_ContributeMyListFragment$app_productionRelease.MyListFragmentSubcomponent.Builder>() {
            public FragmentModule_ContributeMyListFragment$app_productionRelease.MyListFragmentSubcomponent.Builder get() {
                return new MyListFragmentSubcomponentBuilder();
            }
        };
        this.accountSettingFragmentSubcomponentBuilderProvider = new Provider<C2872x8eb16d2f.AccountSettingFragmentSubcomponent.Builder>() {
            public C2872x8eb16d2f.AccountSettingFragmentSubcomponent.Builder get() {
                return new AccountSettingFragmentSubcomponentBuilder();
            }
        };
        this.toBePaidReviewFragmentSubcomponentBuilderProvider = new Provider<C2886xfdee3d8e.ToBePaidReviewFragmentSubcomponent.Builder>() {
            public C2886xfdee3d8e.ToBePaidReviewFragmentSubcomponent.Builder get() {
                return new ToBePaidReviewFragmentSubcomponentBuilder();
            }
        };
        this.toBePaidConfirmationFragmentSubcomponentBuilderProvider = new Provider<C2885x2d128e2b.ToBePaidConfirmationFragmentSubcomponent.Builder>() {
            public C2885x2d128e2b.ToBePaidConfirmationFragmentSubcomponent.Builder get() {
                return new ToBePaidConfirmationFragmentSubcomponentBuilder();
            }
        };
        this.buyNowOfferListFragmentSubcomponentBuilderProvider = new Provider<C2873x6a2e7676.BuyNowOfferListFragmentSubcomponent.Builder>() {
            public C2873x6a2e7676.BuyNowOfferListFragmentSubcomponent.Builder get() {
                return new BuyNowOfferListFragmentSubcomponentBuilder();
            }
        };
        this.toBePickedUpListFragmentSubcomponentBuilderProvider = new Provider<C2887x47b12c83.ToBePickedUpListFragmentSubcomponent.Builder>() {
            public C2887x47b12c83.ToBePickedUpListFragmentSubcomponent.Builder get() {
                return new ToBePickedUpListFragmentSubcomponentBuilder();
            }
        };
        this.salesDocumentFragmentSubcomponentBuilderProvider = new Provider<C2881x8adf5b73.SalesDocumentFragmentSubcomponent.Builder>() {
            public C2881x8adf5b73.SalesDocumentFragmentSubcomponent.Builder get() {
                return new SalesDocumentFragmentSubcomponentBuilder();
            }
        };
        this.deliveryInstructionFragmentSubcomponentBuilderProvider = new Provider<C2874x9a4341e6.DeliveryInstructionFragmentSubcomponent.Builder>() {
            public C2874x9a4341e6.DeliveryInstructionFragmentSubcomponent.Builder get() {
                return new DeliveryInstructionFragmentSubcomponentBuilder();
            }
        };
        this.insertRepOrAddFragmentSubcomponentBuilderProvider = new Provider<C2876xa481e86.InsertRepOrAddFragmentSubcomponent.Builder>() {
            public C2876xa481e86.InsertRepOrAddFragmentSubcomponent.Builder get() {
                return new InsertRepOrAddFragmentSubcomponentBuilder();
            }
        };
        this.fastSearchFilterFragmentSubcomponentBuilderProvider = new Provider<C2875x7d0d59c8.FastSearchFilterFragmentSubcomponent.Builder>() {
            public C2875x7d0d59c8.FastSearchFilterFragmentSubcomponent.Builder get() {
                return new FastSearchFilterFragmentSubcomponentBuilder();
            }
        };
        this.refinerResultFragmentSubcomponentBuilderProvider = new Provider<C2880xc39d780e.RefinerResultFragmentSubcomponent.Builder>() {
            public C2880xc39d780e.RefinerResultFragmentSubcomponent.Builder get() {
                return new RefinerResultFragmentSubcomponentBuilder();
            }
        };
        this.provideInterceptorProvider = DoubleCheck.provider(NetworkModule_ProvideInterceptorFactory.create(builder.networkModule));
        this.applicationModule = builder.applicationModule;
        this.sessionManagerProvider = DoubleCheck.provider(UserSessionModule_SessionManagerFactory.create(builder.userSessionModule));
        this.provideSharedPreferences$app_productionReleaseProvider = DoubleCheck.provider(C2871x1a1caac9.create(builder.applicationModule));
        this.sharedPrefsHelperProvider = DoubleCheck.provider(SharedPrefsHelper_Factory.create(this.provideSharedPreferences$app_productionReleaseProvider));
        this.provideHttpClientProvider = DoubleCheck.provider(NetworkModule_ProvideHttpClientFactory.create(builder.networkModule, this.provideInterceptorProvider));
        this.provideRetrofitProvider = DoubleCheck.provider(NetworkModule_ProvideRetrofitFactory.create(builder.networkModule, this.provideHttpClientProvider));
        this.provideServiceProvider = DoubleCheck.provider(NetworkModule_ProvideServiceFactory.create(builder.networkModule, this.provideRetrofitProvider));
        this.auctionSalesListRepositoryProvider = AuctionSalesListRepository_Factory.create(this.provideServiceProvider);
        this.watchRepositoryProvider = WatchRepository_Factory.create(this.provideServiceProvider);
        this.auctionSalesListViewModelProvider = AuctionSalesListViewModel_Factory.create(this.auctionSalesListRepositoryProvider, this.watchRepositoryProvider);
        this.auctionMainListRepositoryProvider = AuctionMainListRepository_Factory.create(this.provideServiceProvider);
        this.auctionMainListViewModelProvider = AuctionMainListViewModel_Factory.create(this.auctionMainListRepositoryProvider);
        this.productDetailRepositoryProvider = ProductDetailRepository_Factory.create(this.provideServiceProvider);
        this.productDetailViewModelProvider = ProductDetailViewModel_Factory.create(this.productDetailRepositoryProvider, this.watchRepositoryProvider);
        this.preBidRepositoryProvider = PreBidRepository_Factory.create(this.provideServiceProvider);
        this.preBidViewModelProvider = PreBidViewModel_Factory.create(this.preBidRepositoryProvider, this.productDetailRepositoryProvider);
        this.fastSearchListRepositoryProvider = FastSearchListRepository_Factory.create(this.provideServiceProvider);
        this.fastSearchViewModelProvider = FastSearchViewModel_Factory.create(this.fastSearchListRepositoryProvider, this.watchRepositoryProvider);
        this.buyNowRepositoryProvider = BuyNowRepository_Factory.create(this.provideServiceProvider);
        this.buyNowViewModelProvider = BuyNowViewModel_Factory.create(this.buyNowRepositoryProvider);
        this.costCalculatorRepositoryProvider = CostCalculatorRepository_Factory.create(this.provideServiceProvider);
        this.costCalculatorViewModelProvider = CostCalculatorViewModel_Factory.create(this.costCalculatorRepositoryProvider);
        this.chromeSectionRepositoryProvider = ChromeSectionRepository_Factory.create(this.provideServiceProvider);
    }

    private void initialize2(Builder builder) {
        this.chromeSectionViewModelProvider = ChromeSectionViewModel_Factory.create(this.chromeSectionRepositoryProvider);
        this.premiumVehicleReportRepositoryProvider = PremiumVehicleReportRepository_Factory.create(this.provideServiceProvider);
        this.premiunVehicleReportViewModelProvider = PremiunVehicleReportViewModel_Factory.create(this.premiumVehicleReportRepositoryProvider);
        this.quickFilterRepositoryProvider = QuickFilterRepository_Factory.create(this.provideServiceProvider);
        this.fastSearchFilterRepositoryProvider = FastSearchFilterRepository_Factory.create(this.provideServiceProvider);
        this.savedSearchListRepositoryProvider = SavedSearchListRepository_Factory.create(this.provideServiceProvider);
        this.quickFilterViewModelProvider = QuickFilterViewModel_Factory.create(this.quickFilterRepositoryProvider, this.fastSearchListRepositoryProvider, this.fastSearchFilterRepositoryProvider, this.savedSearchListRepositoryProvider);
        this.makeModelMasterRepositoryProvider = MakeModelMasterRepository_Factory.create(this.provideServiceProvider);
        this.makeModelViewModelProvider = MakeModelViewModel_Factory.create(this.makeModelMasterRepositoryProvider);
        this.auctionRuleRepositoryProvider = AuctionRuleRepository_Factory.create(this.provideServiceProvider);
        this.auctionRuleViewModelProvider = AuctionRuleViewModel_Factory.create(this.auctionRuleRepositoryProvider);
        this.landingPageRepositoryProvider = LandingPageRepository_Factory.create(this.provideServiceProvider);
        this.landingPageViewModelProvider = LandingPageViewModel_Factory.create(this.landingPageRepositoryProvider);
        this.manageOfferListRepositoryProvider = ManageOfferListRepository_Factory.create(this.provideServiceProvider);
        this.manageOfferListViewModelProvider = ManageOfferListViewModel_Factory.create(this.manageOfferListRepositoryProvider);
        this.loginRepositoryProvider = LoginRepository_Factory.create(this.provideServiceProvider);
        this.loginViewModelProvider = LoginViewModel_Factory.create(this.loginRepositoryProvider);
        this.forgotPasswordViewModelProvider = ForgotPasswordViewModel_Factory.create(this.loginRepositoryProvider);
        this.emailConfirmationViewModelProvider = EmailConfirmationViewModel_Factory.create(this.loginRepositoryProvider);
        this.validateOTPViewModelProvider = ValidateOTPViewModel_Factory.create(this.loginRepositoryProvider);
        this.termsOfUseViewModelProvider = TermsOfUseViewModel_Factory.create(this.loginRepositoryProvider);
        this.myAccountRepositoryProvider = MyAccountRepository_Factory.create(this.provideServiceProvider);
        this.myAccountViewModelProvider = MyAccountViewModel_Factory.create(this.myAccountRepositoryProvider);
        this.myAccountRepositoryProvider2 = com.iaai.android.bdt.feature.myAccount.MyAccountRepository_Factory.create(this.provideServiceProvider);
        this.logIAAErrorRepositoryProvider = LogIAAErrorRepository_Factory.create(this.provideServiceProvider);
        this.toBePaidViewModelProvider = ToBePaidViewModel_Factory.create(this.myAccountRepositoryProvider2, this.logIAAErrorRepositoryProvider);
        this.preSaleListRepositoryProvider = PreSaleListRepository_Factory.create(this.provideServiceProvider);
        this.preSaleListViewModelProvider = PreSaleListViewModel_Factory.create(this.preSaleListRepositoryProvider, this.watchRepositoryProvider);
        this.buyNowOfferListRepositoryProvider = BuyNowOfferListRepository_Factory.create(this.provideServiceProvider);
        this.buyNowOfferListViewModelProvider = BuyNowOfferListViewModel_Factory.create(this.buyNowOfferListRepositoryProvider);
        this.toBePickedUpRepositoryProvider = ToBePickedUpRepository_Factory.create(this.provideServiceProvider);
        this.toBePickedUpViewModelProvider = ToBePickedUpViewModel_Factory.create(this.toBePickedUpRepositoryProvider);
        this.saleDocumentRepositoryProvider = SaleDocumentRepository_Factory.create(this.provideServiceProvider);
        this.saleDocumentViewModelProvider = SaleDocumentViewModel_Factory.create(this.saleDocumentRepositoryProvider);
        this.saleDocListViewModelProvider = SaleDocListViewModel_Factory.create(this.myAccountRepositoryProvider2);
        this.deliveryInstructionViewModelProvider = DeliveryInstructionViewModel_Factory.create(this.myAccountRepositoryProvider2);
        this.deliveryMethodViewModelProvider = DeliveryMethodViewModel_Factory.create(this.myAccountRepositoryProvider2);
        this.insertRepOrAddViewModelProvider = InsertRepOrAddViewModel_Factory.create(this.myAccountRepositoryProvider2);
        this.fastSearchFilterViewModelProvider = FastSearchFilterViewModel_Factory.create(this.fastSearchFilterRepositoryProvider, this.watchRepositoryProvider, this.savedSearchListRepositoryProvider);
        this.savedSearchListViewModelProvider = SavedSearchListViewModel_Factory.create(this.savedSearchListRepositoryProvider);
        this.mapOfClassOfAndProviderOfViewModelProvider = MapProviderFactory.builder(31).put((Object) AuctionSalesListViewModel.class, (Provider) this.auctionSalesListViewModelProvider).put((Object) AuctionMainListViewModel.class, (Provider) this.auctionMainListViewModelProvider).put((Object) ProductDetailViewModel.class, (Provider) this.productDetailViewModelProvider).put((Object) PreBidViewModel.class, (Provider) this.preBidViewModelProvider).put((Object) FastSearchViewModel.class, (Provider) this.fastSearchViewModelProvider).put((Object) BuyNowViewModel.class, (Provider) this.buyNowViewModelProvider).put((Object) CostCalculatorViewModel.class, (Provider) this.costCalculatorViewModelProvider).put((Object) ChromeSectionViewModel.class, (Provider) this.chromeSectionViewModelProvider).put((Object) PremiunVehicleReportViewModel.class, (Provider) this.premiunVehicleReportViewModelProvider).put((Object) QuickFilterViewModel.class, (Provider) this.quickFilterViewModelProvider).put((Object) MakeModelViewModel.class, (Provider) this.makeModelViewModelProvider).put((Object) AuctionRuleViewModel.class, (Provider) this.auctionRuleViewModelProvider).put((Object) LandingPageViewModel.class, (Provider) this.landingPageViewModelProvider).put((Object) ManageOfferListViewModel.class, (Provider) this.manageOfferListViewModelProvider).put((Object) LoginViewModel.class, (Provider) this.loginViewModelProvider).put((Object) ForgotPasswordViewModel.class, (Provider) this.forgotPasswordViewModelProvider).put((Object) EmailConfirmationViewModel.class, (Provider) this.emailConfirmationViewModelProvider).put((Object) ValidateOTPViewModel.class, (Provider) this.validateOTPViewModelProvider).put((Object) TermsOfUseViewModel.class, (Provider) this.termsOfUseViewModelProvider).put((Object) MyAccountViewModel.class, (Provider) this.myAccountViewModelProvider).put((Object) ToBePaidViewModel.class, (Provider) this.toBePaidViewModelProvider).put((Object) PreSaleListViewModel.class, (Provider) this.preSaleListViewModelProvider).put((Object) BuyNowOfferListViewModel.class, (Provider) this.buyNowOfferListViewModelProvider).put((Object) ToBePickedUpViewModel.class, (Provider) this.toBePickedUpViewModelProvider).put((Object) SaleDocumentViewModel.class, (Provider) this.saleDocumentViewModelProvider).put((Object) SaleDocListViewModel.class, (Provider) this.saleDocListViewModelProvider).put((Object) DeliveryInstructionViewModel.class, (Provider) this.deliveryInstructionViewModelProvider).put((Object) DeliveryMethodViewModel.class, (Provider) this.deliveryMethodViewModelProvider).put((Object) InsertRepOrAddViewModel.class, (Provider) this.insertRepOrAddViewModelProvider).put((Object) FastSearchFilterViewModel.class, (Provider) this.fastSearchFilterViewModelProvider).put((Object) SavedSearchListViewModel.class, (Provider) this.savedSearchListViewModelProvider).build();
        this.appViewModelFactoryProvider = DoubleCheck.provider(AppViewModelFactory_Factory.create(this.mapOfClassOfAndProviderOfViewModelProvider));
    }

    public void inject(DaggerApplication daggerApplication) {
        injectDaggerApplication(daggerApplication);
    }

    public void inject(IaaiApplication iaaiApplication) {
        injectIaaiApplication(iaaiApplication);
    }

    public Context getContext() {
        return ApplicationModule_ProvideContext$app_productionReleaseFactory.proxyProvideContext$app_productionRelease(this.applicationModule);
    }

    public Application getApplication() {
        return C2870x80ca0a6c.proxyProvideApplication$app_productionRelease(this.applicationModule);
    }

    public SessionManager sessionManager() {
        return this.sessionManagerProvider.get();
    }

    public SharedPrefsHelper getPreferenceHelper() {
        return this.sharedPrefsHelperProvider.get();
    }

    @CanIgnoreReturnValue
    private DaggerApplication injectDaggerApplication(DaggerApplication daggerApplication) {
        DaggerApplication_MembersInjector.injectActivityInjector(daggerApplication, getDispatchingAndroidInjectorOfActivity());
        DaggerApplication_MembersInjector.injectBroadcastReceiverInjector(daggerApplication, getDispatchingAndroidInjectorOfBroadcastReceiver());
        DaggerApplication_MembersInjector.injectFragmentInjector(daggerApplication, getDispatchingAndroidInjectorOfFragment());
        DaggerApplication_MembersInjector.injectServiceInjector(daggerApplication, getDispatchingAndroidInjectorOfService());
        DaggerApplication_MembersInjector.injectContentProviderInjector(daggerApplication, getDispatchingAndroidInjectorOfContentProvider());
        DaggerApplication_MembersInjector.injectSetInjected(daggerApplication);
        return daggerApplication;
    }

    @CanIgnoreReturnValue
    private IaaiApplication injectIaaiApplication(IaaiApplication iaaiApplication) {
        IaaiApplication_MembersInjector.injectDispatchingAndroidInjector(iaaiApplication, getDispatchingAndroidInjectorOfActivity());
        IaaiApplication_MembersInjector.injectDispatchingFragmentInjector(iaaiApplication, getDispatchingAndroidInjectorOfFragment2());
        IaaiApplication_MembersInjector.injectCustomInterceptor(iaaiApplication, this.provideInterceptorProvider.get());
        return iaaiApplication;
    }

    public static final class Builder {
        /* access modifiers changed from: private */
        public ApplicationModule applicationModule;
        /* access modifiers changed from: private */
        public NetworkModule networkModule;
        /* access modifiers changed from: private */
        public UserSessionModule userSessionModule;

        private Builder() {
        }

        public AppComponent build() {
            if (this.networkModule == null) {
                this.networkModule = new NetworkModule();
            }
            if (this.applicationModule != null) {
                if (this.userSessionModule == null) {
                    this.userSessionModule = new UserSessionModule();
                }
                return new DaggerAppComponent(this);
            }
            throw new IllegalStateException(ApplicationModule.class.getCanonicalName() + " must be set");
        }

        public Builder networkModule(NetworkModule networkModule2) {
            this.networkModule = (NetworkModule) Preconditions.checkNotNull(networkModule2);
            return this;
        }

        @Deprecated
        public Builder persistenceModule(PersistenceModule persistenceModule) {
            Preconditions.checkNotNull(persistenceModule);
            return this;
        }

        public Builder userSessionModule(UserSessionModule userSessionModule2) {
            this.userSessionModule = (UserSessionModule) Preconditions.checkNotNull(userSessionModule2);
            return this;
        }

        public Builder applicationModule(ApplicationModule applicationModule2) {
            this.applicationModule = (ApplicationModule) Preconditions.checkNotNull(applicationModule2);
            return this;
        }
    }

    private final class MainActivitySubcomponentBuilder extends ActivityModule_ContributeMainActivity$app_productionRelease.MainActivitySubcomponent.Builder {
        private MainActivity seedInstance;

        private MainActivitySubcomponentBuilder() {
        }

        public ActivityModule_ContributeMainActivity$app_productionRelease.MainActivitySubcomponent build() {
            if (this.seedInstance != null) {
                return new MainActivitySubcomponentImpl(this);
            }
            throw new IllegalStateException(MainActivity.class.getCanonicalName() + " must be set");
        }

        public void seedInstance(MainActivity mainActivity) {
            this.seedInstance = (MainActivity) Preconditions.checkNotNull(mainActivity);
        }
    }

    private final class MainActivitySubcomponentImpl implements ActivityModule_ContributeMainActivity$app_productionRelease.MainActivitySubcomponent {
        public void inject(MainActivity mainActivity) {
        }

        private MainActivitySubcomponentImpl(MainActivitySubcomponentBuilder mainActivitySubcomponentBuilder) {
        }
    }

    private final class AuctionSalesListActivitySubcomponentBuilder extends C2835x9781d273.AuctionSalesListActivitySubcomponent.Builder {
        private AuctionSalesListActivity seedInstance;

        private AuctionSalesListActivitySubcomponentBuilder() {
        }

        public C2835x9781d273.AuctionSalesListActivitySubcomponent build() {
            if (this.seedInstance != null) {
                return new AuctionSalesListActivitySubcomponentImpl(this);
            }
            throw new IllegalStateException(AuctionSalesListActivity.class.getCanonicalName() + " must be set");
        }

        public void seedInstance(AuctionSalesListActivity auctionSalesListActivity) {
            this.seedInstance = (AuctionSalesListActivity) Preconditions.checkNotNull(auctionSalesListActivity);
        }
    }

    private final class AuctionSalesListActivitySubcomponentImpl implements C2835x9781d273.AuctionSalesListActivitySubcomponent {
        private AuctionSalesListActivitySubcomponentImpl(AuctionSalesListActivitySubcomponentBuilder auctionSalesListActivitySubcomponentBuilder) {
        }

        public void inject(AuctionSalesListActivity auctionSalesListActivity) {
            injectAuctionSalesListActivity(auctionSalesListActivity);
        }

        @CanIgnoreReturnValue
        private AuctionSalesListActivity injectAuctionSalesListActivity(AuctionSalesListActivity auctionSalesListActivity) {
            BaseActivity_MembersInjector.injectDispatchingAndroidInjector(auctionSalesListActivity, DaggerAppComponent.this.getDispatchingAndroidInjectorOfFragment2());
            AuctionSalesListActivity_MembersInjector.injectViewModelFactory(auctionSalesListActivity, (ViewModelProvider.Factory) DaggerAppComponent.this.appViewModelFactoryProvider.get());
            AuctionSalesListActivity_MembersInjector.injectSessionManager(auctionSalesListActivity, (SessionManager) DaggerAppComponent.this.sessionManagerProvider.get());
            return auctionSalesListActivity;
        }
    }

    private final class BDTAuctionMainListActivitySubcomponentBuilder extends C2836xb8eae034.BDTAuctionMainListActivitySubcomponent.Builder {
        private BDTAuctionMainListActivity seedInstance;

        private BDTAuctionMainListActivitySubcomponentBuilder() {
        }

        public C2836xb8eae034.BDTAuctionMainListActivitySubcomponent build() {
            if (this.seedInstance != null) {
                return new BDTAuctionMainListActivitySubcomponentImpl(this);
            }
            throw new IllegalStateException(BDTAuctionMainListActivity.class.getCanonicalName() + " must be set");
        }

        public void seedInstance(BDTAuctionMainListActivity bDTAuctionMainListActivity) {
            this.seedInstance = (BDTAuctionMainListActivity) Preconditions.checkNotNull(bDTAuctionMainListActivity);
        }
    }

    private final class BDTAuctionMainListActivitySubcomponentImpl implements C2836xb8eae034.BDTAuctionMainListActivitySubcomponent {
        private BDTAuctionMainListActivitySubcomponentImpl(BDTAuctionMainListActivitySubcomponentBuilder bDTAuctionMainListActivitySubcomponentBuilder) {
        }

        public void inject(BDTAuctionMainListActivity bDTAuctionMainListActivity) {
            injectBDTAuctionMainListActivity(bDTAuctionMainListActivity);
        }

        @CanIgnoreReturnValue
        private BDTAuctionMainListActivity injectBDTAuctionMainListActivity(BDTAuctionMainListActivity bDTAuctionMainListActivity) {
            BaseActivity_MembersInjector.injectDispatchingAndroidInjector(bDTAuctionMainListActivity, DaggerAppComponent.this.getDispatchingAndroidInjectorOfFragment2());
            MVVMNavDrawerActivity_MembersInjector.injectSessionManager(bDTAuctionMainListActivity, (SessionManager) DaggerAppComponent.this.sessionManagerProvider.get());
            MVVMNavDrawerActivity_MembersInjector.injectSharedPrefsHelper(bDTAuctionMainListActivity, (SharedPrefsHelper) DaggerAppComponent.this.sharedPrefsHelperProvider.get());
            BDTAuctionMainListActivity_MembersInjector.injectViewModelFactory(bDTAuctionMainListActivity, (ViewModelProvider.Factory) DaggerAppComponent.this.appViewModelFactoryProvider.get());
            return bDTAuctionMainListActivity;
        }
    }

    private final class AuctionDateListActivitySubcomponentBuilder extends C2833xec933ff9.AuctionDateListActivitySubcomponent.Builder {
        private AuctionDateListActivity seedInstance;

        private AuctionDateListActivitySubcomponentBuilder() {
        }

        public C2833xec933ff9.AuctionDateListActivitySubcomponent build() {
            if (this.seedInstance != null) {
                return new AuctionDateListActivitySubcomponentImpl(this);
            }
            throw new IllegalStateException(AuctionDateListActivity.class.getCanonicalName() + " must be set");
        }

        public void seedInstance(AuctionDateListActivity auctionDateListActivity) {
            this.seedInstance = (AuctionDateListActivity) Preconditions.checkNotNull(auctionDateListActivity);
        }
    }

    private final class AuctionDateListActivitySubcomponentImpl implements C2833xec933ff9.AuctionDateListActivitySubcomponent {
        private AuctionDateListActivitySubcomponentImpl(AuctionDateListActivitySubcomponentBuilder auctionDateListActivitySubcomponentBuilder) {
        }

        public void inject(AuctionDateListActivity auctionDateListActivity) {
            injectAuctionDateListActivity(auctionDateListActivity);
        }

        @CanIgnoreReturnValue
        private AuctionDateListActivity injectAuctionDateListActivity(AuctionDateListActivity auctionDateListActivity) {
            BaseActivity_MembersInjector.injectDispatchingAndroidInjector(auctionDateListActivity, DaggerAppComponent.this.getDispatchingAndroidInjectorOfFragment2());
            return auctionDateListActivity;
        }
    }

    private final class ProductDetailActivitySubcomponentBuilder extends C2834x86694b49.ProductDetailActivitySubcomponent.Builder {
        private ProductDetailActivity seedInstance;

        private ProductDetailActivitySubcomponentBuilder() {
        }

        public C2834x86694b49.ProductDetailActivitySubcomponent build() {
            if (this.seedInstance != null) {
                return new ProductDetailActivitySubcomponentImpl(this);
            }
            throw new IllegalStateException(ProductDetailActivity.class.getCanonicalName() + " must be set");
        }

        public void seedInstance(ProductDetailActivity productDetailActivity) {
            this.seedInstance = (ProductDetailActivity) Preconditions.checkNotNull(productDetailActivity);
        }
    }

    private final class ProductDetailActivitySubcomponentImpl implements C2834x86694b49.ProductDetailActivitySubcomponent {
        private ProductDetailActivitySubcomponentImpl(ProductDetailActivitySubcomponentBuilder productDetailActivitySubcomponentBuilder) {
        }

        public void inject(ProductDetailActivity productDetailActivity) {
            injectProductDetailActivity(productDetailActivity);
        }

        @CanIgnoreReturnValue
        private ProductDetailActivity injectProductDetailActivity(ProductDetailActivity productDetailActivity) {
            BaseActivity_MembersInjector.injectDispatchingAndroidInjector(productDetailActivity, DaggerAppComponent.this.getDispatchingAndroidInjectorOfFragment2());
            ProductDetailActivity_MembersInjector.injectViewModelFactory(productDetailActivity, (ViewModelProvider.Factory) DaggerAppComponent.this.appViewModelFactoryProvider.get());
            return productDetailActivity;
        }
    }

    private final class Product360ImageActivitySubcomponentBuilder extends C2858xa65e9bc7.Product360ImageActivitySubcomponent.Builder {
        private Product360ImageActivity seedInstance;

        private Product360ImageActivitySubcomponentBuilder() {
        }

        public C2858xa65e9bc7.Product360ImageActivitySubcomponent build() {
            if (this.seedInstance != null) {
                return new Product360ImageActivitySubcomponentImpl(this);
            }
            throw new IllegalStateException(Product360ImageActivity.class.getCanonicalName() + " must be set");
        }

        public void seedInstance(Product360ImageActivity product360ImageActivity) {
            this.seedInstance = (Product360ImageActivity) Preconditions.checkNotNull(product360ImageActivity);
        }
    }

    private final class Product360ImageActivitySubcomponentImpl implements C2858xa65e9bc7.Product360ImageActivitySubcomponent {
        public void inject(Product360ImageActivity product360ImageActivity) {
        }

        private Product360ImageActivitySubcomponentImpl(Product360ImageActivitySubcomponentBuilder product360ImageActivitySubcomponentBuilder) {
        }
    }

    private final class BaseActivitySubcomponentBuilder extends ActivityModule_ContributeBaseActivity$app_productionRelease.BaseActivitySubcomponent.Builder {
        private BaseActivity seedInstance;

        private BaseActivitySubcomponentBuilder() {
        }

        public ActivityModule_ContributeBaseActivity$app_productionRelease.BaseActivitySubcomponent build() {
            if (this.seedInstance != null) {
                return new BaseActivitySubcomponentImpl(this);
            }
            throw new IllegalStateException(BaseActivity.class.getCanonicalName() + " must be set");
        }

        public void seedInstance(BaseActivity baseActivity) {
            this.seedInstance = (BaseActivity) Preconditions.checkNotNull(baseActivity);
        }
    }

    private final class BaseActivitySubcomponentImpl implements ActivityModule_ContributeBaseActivity$app_productionRelease.BaseActivitySubcomponent {
        private BaseActivitySubcomponentImpl(BaseActivitySubcomponentBuilder baseActivitySubcomponentBuilder) {
        }

        public void inject(BaseActivity baseActivity) {
            injectBaseActivity(baseActivity);
        }

        @CanIgnoreReturnValue
        private BaseActivity injectBaseActivity(BaseActivity baseActivity) {
            BaseActivity_MembersInjector.injectDispatchingAndroidInjector(baseActivity, DaggerAppComponent.this.getDispatchingAndroidInjectorOfFragment2());
            return baseActivity;
        }
    }

    private final class BDTPremiumVehicleReportActivitySubcomponentBuilder extends C2841x2bca5525.BDTPremiumVehicleReportActivitySubcomponent.Builder {
        private BDTPremiumVehicleReportActivity seedInstance;

        private BDTPremiumVehicleReportActivitySubcomponentBuilder() {
        }

        public C2841x2bca5525.BDTPremiumVehicleReportActivitySubcomponent build() {
            if (this.seedInstance != null) {
                return new BDTPremiumVehicleReportActivitySubcomponentImpl(this);
            }
            throw new IllegalStateException(BDTPremiumVehicleReportActivity.class.getCanonicalName() + " must be set");
        }

        public void seedInstance(BDTPremiumVehicleReportActivity bDTPremiumVehicleReportActivity) {
            this.seedInstance = (BDTPremiumVehicleReportActivity) Preconditions.checkNotNull(bDTPremiumVehicleReportActivity);
        }
    }

    private final class BDTPremiumVehicleReportActivitySubcomponentImpl implements C2841x2bca5525.BDTPremiumVehicleReportActivitySubcomponent {
        private BDTPremiumVehicleReportActivitySubcomponentImpl(BDTPremiumVehicleReportActivitySubcomponentBuilder bDTPremiumVehicleReportActivitySubcomponentBuilder) {
        }

        public void inject(BDTPremiumVehicleReportActivity bDTPremiumVehicleReportActivity) {
            injectBDTPremiumVehicleReportActivity(bDTPremiumVehicleReportActivity);
        }

        @CanIgnoreReturnValue
        private BDTPremiumVehicleReportActivity injectBDTPremiumVehicleReportActivity(BDTPremiumVehicleReportActivity bDTPremiumVehicleReportActivity) {
            BaseActivity_MembersInjector.injectDispatchingAndroidInjector(bDTPremiumVehicleReportActivity, DaggerAppComponent.this.getDispatchingAndroidInjectorOfFragment2());
            BDTPremiumVehicleReportActivity_MembersInjector.injectViewModelFactory(bDTPremiumVehicleReportActivity, (ViewModelProvider.Factory) DaggerAppComponent.this.appViewModelFactoryProvider.get());
            BDTPremiumVehicleReportActivity_MembersInjector.injectSessionManager(bDTPremiumVehicleReportActivity, (SessionManager) DaggerAppComponent.this.sessionManagerProvider.get());
            return bDTPremiumVehicleReportActivity;
        }
    }

    private final class IAAConditionReportActivitySubcomponentBuilder extends C2852xd7732dd2.IAAConditionReportActivitySubcomponent.Builder {
        private IAAConditionReportActivity seedInstance;

        private IAAConditionReportActivitySubcomponentBuilder() {
        }

        public C2852xd7732dd2.IAAConditionReportActivitySubcomponent build() {
            if (this.seedInstance != null) {
                return new IAAConditionReportActivitySubcomponentImpl(this);
            }
            throw new IllegalStateException(IAAConditionReportActivity.class.getCanonicalName() + " must be set");
        }

        public void seedInstance(IAAConditionReportActivity iAAConditionReportActivity) {
            this.seedInstance = (IAAConditionReportActivity) Preconditions.checkNotNull(iAAConditionReportActivity);
        }
    }

    private final class IAAConditionReportActivitySubcomponentImpl implements C2852xd7732dd2.IAAConditionReportActivitySubcomponent {
        private IAAConditionReportActivitySubcomponentImpl(IAAConditionReportActivitySubcomponentBuilder iAAConditionReportActivitySubcomponentBuilder) {
        }

        public void inject(IAAConditionReportActivity iAAConditionReportActivity) {
            injectIAAConditionReportActivity(iAAConditionReportActivity);
        }

        @CanIgnoreReturnValue
        private IAAConditionReportActivity injectIAAConditionReportActivity(IAAConditionReportActivity iAAConditionReportActivity) {
            BaseActivity_MembersInjector.injectDispatchingAndroidInjector(iAAConditionReportActivity, DaggerAppComponent.this.getDispatchingAndroidInjectorOfFragment2());
            IAAConditionReportActivity_MembersInjector.injectViewModelFactory(iAAConditionReportActivity, (ViewModelProvider.Factory) DaggerAppComponent.this.appViewModelFactoryProvider.get());
            return iAAConditionReportActivity;
        }
    }

    private final class BDTLandingPageActivitySubcomponentBuilder extends C2837xfcc08fcd.BDTLandingPageActivitySubcomponent.Builder {
        private BDTLandingPageActivity seedInstance;

        private BDTLandingPageActivitySubcomponentBuilder() {
        }

        public C2837xfcc08fcd.BDTLandingPageActivitySubcomponent build() {
            if (this.seedInstance != null) {
                return new BDTLandingPageActivitySubcomponentImpl(this);
            }
            throw new IllegalStateException(BDTLandingPageActivity.class.getCanonicalName() + " must be set");
        }

        public void seedInstance(BDTLandingPageActivity bDTLandingPageActivity) {
            this.seedInstance = (BDTLandingPageActivity) Preconditions.checkNotNull(bDTLandingPageActivity);
        }
    }

    private final class BDTLandingPageActivitySubcomponentImpl implements C2837xfcc08fcd.BDTLandingPageActivitySubcomponent {
        private BDTLandingPageActivitySubcomponentImpl(BDTLandingPageActivitySubcomponentBuilder bDTLandingPageActivitySubcomponentBuilder) {
        }

        public void inject(BDTLandingPageActivity bDTLandingPageActivity) {
            injectBDTLandingPageActivity(bDTLandingPageActivity);
        }

        @CanIgnoreReturnValue
        private BDTLandingPageActivity injectBDTLandingPageActivity(BDTLandingPageActivity bDTLandingPageActivity) {
            BaseActivity_MembersInjector.injectDispatchingAndroidInjector(bDTLandingPageActivity, DaggerAppComponent.this.getDispatchingAndroidInjectorOfFragment2());
            MVVMNavDrawerActivity_MembersInjector.injectSessionManager(bDTLandingPageActivity, (SessionManager) DaggerAppComponent.this.sessionManagerProvider.get());
            MVVMNavDrawerActivity_MembersInjector.injectSharedPrefsHelper(bDTLandingPageActivity, (SharedPrefsHelper) DaggerAppComponent.this.sharedPrefsHelperProvider.get());
            BDTLandingPageActivity_MembersInjector.injectViewModelFactory(bDTLandingPageActivity, (ViewModelProvider.Factory) DaggerAppComponent.this.appViewModelFactoryProvider.get());
            return bDTLandingPageActivity;
        }
    }

    private final class FilterActivitySubcomponentBuilder extends ActivityModule_ContributeFilterActivity$app_productionRelease.FilterActivitySubcomponent.Builder {
        private FilterActivity seedInstance;

        private FilterActivitySubcomponentBuilder() {
        }

        public ActivityModule_ContributeFilterActivity$app_productionRelease.FilterActivitySubcomponent build() {
            if (this.seedInstance != null) {
                return new FilterActivitySubcomponentImpl(this);
            }
            throw new IllegalStateException(FilterActivity.class.getCanonicalName() + " must be set");
        }

        public void seedInstance(FilterActivity filterActivity) {
            this.seedInstance = (FilterActivity) Preconditions.checkNotNull(filterActivity);
        }
    }

    private final class FilterActivitySubcomponentImpl implements ActivityModule_ContributeFilterActivity$app_productionRelease.FilterActivitySubcomponent {
        private FilterActivitySubcomponentImpl(FilterActivitySubcomponentBuilder filterActivitySubcomponentBuilder) {
        }

        public void inject(FilterActivity filterActivity) {
            injectFilterActivity(filterActivity);
        }

        @CanIgnoreReturnValue
        private FilterActivity injectFilterActivity(FilterActivity filterActivity) {
            BaseActivity_MembersInjector.injectDispatchingAndroidInjector(filterActivity, DaggerAppComponent.this.getDispatchingAndroidInjectorOfFragment2());
            return filterActivity;
        }
    }

    private final class SubFilterActivitySubcomponentBuilder extends ActivityModule_ContributeSubFilterActivity$app_productionRelease.SubFilterActivitySubcomponent.Builder {
        private SubFilterActivity seedInstance;

        private SubFilterActivitySubcomponentBuilder() {
        }

        public ActivityModule_ContributeSubFilterActivity$app_productionRelease.SubFilterActivitySubcomponent build() {
            if (this.seedInstance != null) {
                return new SubFilterActivitySubcomponentImpl(this);
            }
            throw new IllegalStateException(SubFilterActivity.class.getCanonicalName() + " must be set");
        }

        public void seedInstance(SubFilterActivity subFilterActivity) {
            this.seedInstance = (SubFilterActivity) Preconditions.checkNotNull(subFilterActivity);
        }
    }

    private final class SubFilterActivitySubcomponentImpl implements ActivityModule_ContributeSubFilterActivity$app_productionRelease.SubFilterActivitySubcomponent {
        private SubFilterActivitySubcomponentImpl(SubFilterActivitySubcomponentBuilder subFilterActivitySubcomponentBuilder) {
        }

        public void inject(SubFilterActivity subFilterActivity) {
            injectSubFilterActivity(subFilterActivity);
        }

        @CanIgnoreReturnValue
        private SubFilterActivity injectSubFilterActivity(SubFilterActivity subFilterActivity) {
            BaseActivity_MembersInjector.injectDispatchingAndroidInjector(subFilterActivity, DaggerAppComponent.this.getDispatchingAndroidInjectorOfFragment2());
            return subFilterActivity;
        }
    }

    private final class MakeModelFilterActivitySubcomponentBuilder extends C2854xfcdecd5d.MakeModelFilterActivitySubcomponent.Builder {
        private MakeModelFilterActivity seedInstance;

        private MakeModelFilterActivitySubcomponentBuilder() {
        }

        public C2854xfcdecd5d.MakeModelFilterActivitySubcomponent build() {
            if (this.seedInstance != null) {
                return new MakeModelFilterActivitySubcomponentImpl(this);
            }
            throw new IllegalStateException(MakeModelFilterActivity.class.getCanonicalName() + " must be set");
        }

        public void seedInstance(MakeModelFilterActivity makeModelFilterActivity) {
            this.seedInstance = (MakeModelFilterActivity) Preconditions.checkNotNull(makeModelFilterActivity);
        }
    }

    private final class MakeModelFilterActivitySubcomponentImpl implements C2854xfcdecd5d.MakeModelFilterActivitySubcomponent {
        private MakeModelFilterActivitySubcomponentImpl(MakeModelFilterActivitySubcomponentBuilder makeModelFilterActivitySubcomponentBuilder) {
        }

        public void inject(MakeModelFilterActivity makeModelFilterActivity) {
            injectMakeModelFilterActivity(makeModelFilterActivity);
        }

        @CanIgnoreReturnValue
        private MakeModelFilterActivity injectMakeModelFilterActivity(MakeModelFilterActivity makeModelFilterActivity) {
            BaseActivity_MembersInjector.injectDispatchingAndroidInjector(makeModelFilterActivity, DaggerAppComponent.this.getDispatchingAndroidInjectorOfFragment2());
            return makeModelFilterActivity;
        }
    }

    private final class SearchResultActivitySubcomponentBuilder extends C2866xb82e191.SearchResultActivitySubcomponent.Builder {
        private SearchResultActivity seedInstance;

        private SearchResultActivitySubcomponentBuilder() {
        }

        public C2866xb82e191.SearchResultActivitySubcomponent build() {
            if (this.seedInstance != null) {
                return new SearchResultActivitySubcomponentImpl(this);
            }
            throw new IllegalStateException(SearchResultActivity.class.getCanonicalName() + " must be set");
        }

        public void seedInstance(SearchResultActivity searchResultActivity) {
            this.seedInstance = (SearchResultActivity) Preconditions.checkNotNull(searchResultActivity);
        }
    }

    private final class SearchResultActivitySubcomponentImpl implements C2866xb82e191.SearchResultActivitySubcomponent {
        private SearchResultActivitySubcomponentImpl(SearchResultActivitySubcomponentBuilder searchResultActivitySubcomponentBuilder) {
        }

        public void inject(SearchResultActivity searchResultActivity) {
            injectSearchResultActivity(searchResultActivity);
        }

        @CanIgnoreReturnValue
        private SearchResultActivity injectSearchResultActivity(SearchResultActivity searchResultActivity) {
            BaseActivity_MembersInjector.injectDispatchingAndroidInjector(searchResultActivity, DaggerAppComponent.this.getDispatchingAndroidInjectorOfFragment2());
            return searchResultActivity;
        }
    }

    private final class SplashActivitySubcomponentBuilder extends ActivityModule_ContributeSplashActivity$app_productionRelease.SplashActivitySubcomponent.Builder {
        private SplashActivity seedInstance;

        private SplashActivitySubcomponentBuilder() {
        }

        public ActivityModule_ContributeSplashActivity$app_productionRelease.SplashActivitySubcomponent build() {
            if (this.seedInstance != null) {
                return new SplashActivitySubcomponentImpl(this);
            }
            throw new IllegalStateException(SplashActivity.class.getCanonicalName() + " must be set");
        }

        public void seedInstance(SplashActivity splashActivity) {
            this.seedInstance = (SplashActivity) Preconditions.checkNotNull(splashActivity);
        }
    }

    private final class SplashActivitySubcomponentImpl implements ActivityModule_ContributeSplashActivity$app_productionRelease.SplashActivitySubcomponent {
        private SplashActivitySubcomponentImpl(SplashActivitySubcomponentBuilder splashActivitySubcomponentBuilder) {
        }

        public void inject(SplashActivity splashActivity) {
            injectSplashActivity(splashActivity);
        }

        @CanIgnoreReturnValue
        private SplashActivity injectSplashActivity(SplashActivity splashActivity) {
            SplashActivity_MembersInjector.injectViewModelFactory(splashActivity, (ViewModelProvider.Factory) DaggerAppComponent.this.appViewModelFactoryProvider.get());
            return splashActivity;
        }
    }

    private final class FindVehicleFilterActivitySubcomponentBuilder extends C2851xa1b806f5.FindVehicleFilterActivitySubcomponent.Builder {
        private FindVehicleFilterActivity seedInstance;

        private FindVehicleFilterActivitySubcomponentBuilder() {
        }

        public C2851xa1b806f5.FindVehicleFilterActivitySubcomponent build() {
            if (this.seedInstance != null) {
                return new FindVehicleFilterActivitySubcomponentImpl(this);
            }
            throw new IllegalStateException(FindVehicleFilterActivity.class.getCanonicalName() + " must be set");
        }

        public void seedInstance(FindVehicleFilterActivity findVehicleFilterActivity) {
            this.seedInstance = (FindVehicleFilterActivity) Preconditions.checkNotNull(findVehicleFilterActivity);
        }
    }

    private final class FindVehicleFilterActivitySubcomponentImpl implements C2851xa1b806f5.FindVehicleFilterActivitySubcomponent {
        private FindVehicleFilterActivitySubcomponentImpl(FindVehicleFilterActivitySubcomponentBuilder findVehicleFilterActivitySubcomponentBuilder) {
        }

        public void inject(FindVehicleFilterActivity findVehicleFilterActivity) {
            injectFindVehicleFilterActivity(findVehicleFilterActivity);
        }

        @CanIgnoreReturnValue
        private FindVehicleFilterActivity injectFindVehicleFilterActivity(FindVehicleFilterActivity findVehicleFilterActivity) {
            BaseActivity_MembersInjector.injectDispatchingAndroidInjector(findVehicleFilterActivity, DaggerAppComponent.this.getDispatchingAndroidInjectorOfFragment2());
            MVVMNavDrawerActivity_MembersInjector.injectSessionManager(findVehicleFilterActivity, (SessionManager) DaggerAppComponent.this.sessionManagerProvider.get());
            MVVMNavDrawerActivity_MembersInjector.injectSharedPrefsHelper(findVehicleFilterActivity, (SharedPrefsHelper) DaggerAppComponent.this.sharedPrefsHelperProvider.get());
            return findVehicleFilterActivity;
        }
    }

    private final class EngineVideoActivitySubcomponentBuilder extends C2849x8913c883.EngineVideoActivitySubcomponent.Builder {
        private EngineVideoActivity seedInstance;

        private EngineVideoActivitySubcomponentBuilder() {
        }

        public C2849x8913c883.EngineVideoActivitySubcomponent build() {
            if (this.seedInstance != null) {
                return new EngineVideoActivitySubcomponentImpl(this);
            }
            throw new IllegalStateException(EngineVideoActivity.class.getCanonicalName() + " must be set");
        }

        public void seedInstance(EngineVideoActivity engineVideoActivity) {
            this.seedInstance = (EngineVideoActivity) Preconditions.checkNotNull(engineVideoActivity);
        }
    }

    private final class EngineVideoActivitySubcomponentImpl implements C2849x8913c883.EngineVideoActivitySubcomponent {
        public void inject(EngineVideoActivity engineVideoActivity) {
        }

        private EngineVideoActivitySubcomponentImpl(EngineVideoActivitySubcomponentBuilder engineVideoActivitySubcomponentBuilder) {
        }
    }

    private final class TermsOfUseAuctionRuleActivitySubcomponentBuilder extends C2867xe32272e0.TermsOfUseAuctionRuleActivitySubcomponent.Builder {
        private TermsOfUseAuctionRuleActivity seedInstance;

        private TermsOfUseAuctionRuleActivitySubcomponentBuilder() {
        }

        public C2867xe32272e0.TermsOfUseAuctionRuleActivitySubcomponent build() {
            if (this.seedInstance != null) {
                return new TermsOfUseAuctionRuleActivitySubcomponentImpl(this);
            }
            throw new IllegalStateException(TermsOfUseAuctionRuleActivity.class.getCanonicalName() + " must be set");
        }

        public void seedInstance(TermsOfUseAuctionRuleActivity termsOfUseAuctionRuleActivity) {
            this.seedInstance = (TermsOfUseAuctionRuleActivity) Preconditions.checkNotNull(termsOfUseAuctionRuleActivity);
        }
    }

    private final class TermsOfUseAuctionRuleActivitySubcomponentImpl implements C2867xe32272e0.TermsOfUseAuctionRuleActivitySubcomponent {
        private TermsOfUseAuctionRuleActivitySubcomponentImpl(TermsOfUseAuctionRuleActivitySubcomponentBuilder termsOfUseAuctionRuleActivitySubcomponentBuilder) {
        }

        public void inject(TermsOfUseAuctionRuleActivity termsOfUseAuctionRuleActivity) {
            injectTermsOfUseAuctionRuleActivity(termsOfUseAuctionRuleActivity);
        }

        @CanIgnoreReturnValue
        private TermsOfUseAuctionRuleActivity injectTermsOfUseAuctionRuleActivity(TermsOfUseAuctionRuleActivity termsOfUseAuctionRuleActivity) {
            TermsOfUseAuctionRuleActivity_MembersInjector.injectViewModelFactory(termsOfUseAuctionRuleActivity, (ViewModelProvider.Factory) DaggerAppComponent.this.appViewModelFactoryProvider.get());
            TermsOfUseAuctionRuleActivity_MembersInjector.injectSessionManager(termsOfUseAuctionRuleActivity, (SessionManager) DaggerAppComponent.this.sessionManagerProvider.get());
            return termsOfUseAuctionRuleActivity;
        }
    }

    private final class OnBoardingActivitySubcomponentBuilder extends C2857x207dec96.OnBoardingActivitySubcomponent.Builder {
        private OnBoardingActivity seedInstance;

        private OnBoardingActivitySubcomponentBuilder() {
        }

        public C2857x207dec96.OnBoardingActivitySubcomponent build() {
            if (this.seedInstance != null) {
                return new OnBoardingActivitySubcomponentImpl(this);
            }
            throw new IllegalStateException(OnBoardingActivity.class.getCanonicalName() + " must be set");
        }

        public void seedInstance(OnBoardingActivity onBoardingActivity) {
            this.seedInstance = (OnBoardingActivity) Preconditions.checkNotNull(onBoardingActivity);
        }
    }

    private final class OnBoardingActivitySubcomponentImpl implements C2857x207dec96.OnBoardingActivitySubcomponent {
        public void inject(OnBoardingActivity onBoardingActivity) {
        }

        private OnBoardingActivitySubcomponentImpl(OnBoardingActivitySubcomponentBuilder onBoardingActivitySubcomponentBuilder) {
        }
    }

    private final class LandingBRESectionActivitySubcomponentBuilder extends C2853xa62b51f1.LandingBRESectionActivitySubcomponent.Builder {
        private LandingBRESectionActivity seedInstance;

        private LandingBRESectionActivitySubcomponentBuilder() {
        }

        public C2853xa62b51f1.LandingBRESectionActivitySubcomponent build() {
            if (this.seedInstance != null) {
                return new LandingBRESectionActivitySubcomponentImpl(this);
            }
            throw new IllegalStateException(LandingBRESectionActivity.class.getCanonicalName() + " must be set");
        }

        public void seedInstance(LandingBRESectionActivity landingBRESectionActivity) {
            this.seedInstance = (LandingBRESectionActivity) Preconditions.checkNotNull(landingBRESectionActivity);
        }
    }

    private final class LandingBRESectionActivitySubcomponentImpl implements C2853xa62b51f1.LandingBRESectionActivitySubcomponent {
        private LandingBRESectionActivitySubcomponentImpl(LandingBRESectionActivitySubcomponentBuilder landingBRESectionActivitySubcomponentBuilder) {
        }

        public void inject(LandingBRESectionActivity landingBRESectionActivity) {
            injectLandingBRESectionActivity(landingBRESectionActivity);
        }

        @CanIgnoreReturnValue
        private LandingBRESectionActivity injectLandingBRESectionActivity(LandingBRESectionActivity landingBRESectionActivity) {
            BaseActivity_MembersInjector.injectDispatchingAndroidInjector(landingBRESectionActivity, DaggerAppComponent.this.getDispatchingAndroidInjectorOfFragment2());
            return landingBRESectionActivity;
        }
    }

    private final class ManageOfferListActivitySubcomponentBuilder extends C2856x1ff4a1df.ManageOfferListActivitySubcomponent.Builder {
        private ManageOfferListActivity seedInstance;

        private ManageOfferListActivitySubcomponentBuilder() {
        }

        public C2856x1ff4a1df.ManageOfferListActivitySubcomponent build() {
            if (this.seedInstance != null) {
                return new ManageOfferListActivitySubcomponentImpl(this);
            }
            throw new IllegalStateException(ManageOfferListActivity.class.getCanonicalName() + " must be set");
        }

        public void seedInstance(ManageOfferListActivity manageOfferListActivity) {
            this.seedInstance = (ManageOfferListActivity) Preconditions.checkNotNull(manageOfferListActivity);
        }
    }

    private final class ManageOfferListActivitySubcomponentImpl implements C2856x1ff4a1df.ManageOfferListActivitySubcomponent {
        private ManageOfferListActivitySubcomponentImpl(ManageOfferListActivitySubcomponentBuilder manageOfferListActivitySubcomponentBuilder) {
        }

        public void inject(ManageOfferListActivity manageOfferListActivity) {
            injectManageOfferListActivity(manageOfferListActivity);
        }

        @CanIgnoreReturnValue
        private ManageOfferListActivity injectManageOfferListActivity(ManageOfferListActivity manageOfferListActivity) {
            BaseActivity_MembersInjector.injectDispatchingAndroidInjector(manageOfferListActivity, DaggerAppComponent.this.getDispatchingAndroidInjectorOfFragment2());
            ManageOfferListActivity_MembersInjector.injectViewModelFactory(manageOfferListActivity, (ViewModelProvider.Factory) DaggerAppComponent.this.appViewModelFactoryProvider.get());
            ManageOfferListActivity_MembersInjector.injectSessionManager(manageOfferListActivity, (SessionManager) DaggerAppComponent.this.sessionManagerProvider.get());
            return manageOfferListActivity;
        }
    }

    private final class BDTPaymentActivitySubcomponentBuilder extends C2846xb9ae6495.BDTPaymentActivitySubcomponent.Builder {
        private BDTPaymentActivity seedInstance;

        private BDTPaymentActivitySubcomponentBuilder() {
        }

        public C2846xb9ae6495.BDTPaymentActivitySubcomponent build() {
            if (this.seedInstance != null) {
                return new BDTPaymentActivitySubcomponentImpl(this);
            }
            throw new IllegalStateException(BDTPaymentActivity.class.getCanonicalName() + " must be set");
        }

        public void seedInstance(BDTPaymentActivity bDTPaymentActivity) {
            this.seedInstance = (BDTPaymentActivity) Preconditions.checkNotNull(bDTPaymentActivity);
        }
    }

    private final class BDTPaymentActivitySubcomponentImpl implements C2846xb9ae6495.BDTPaymentActivitySubcomponent {
        private BDTPaymentActivitySubcomponentImpl(BDTPaymentActivitySubcomponentBuilder bDTPaymentActivitySubcomponentBuilder) {
        }

        public void inject(BDTPaymentActivity bDTPaymentActivity) {
            injectBDTPaymentActivity(bDTPaymentActivity);
        }

        @CanIgnoreReturnValue
        private BDTPaymentActivity injectBDTPaymentActivity(BDTPaymentActivity bDTPaymentActivity) {
            BaseActivity_MembersInjector.injectDispatchingAndroidInjector(bDTPaymentActivity, DaggerAppComponent.this.getDispatchingAndroidInjectorOfFragment2());
            return bDTPaymentActivity;
        }
    }

    private final class BDTLoginActivitySubcomponentBuilder extends ActivityModule_ContributeBDTLoginActivity$app_productionRelease.BDTLoginActivitySubcomponent.Builder {
        private BDTLoginActivity seedInstance;

        private BDTLoginActivitySubcomponentBuilder() {
        }

        public ActivityModule_ContributeBDTLoginActivity$app_productionRelease.BDTLoginActivitySubcomponent build() {
            if (this.seedInstance != null) {
                return new BDTLoginActivitySubcomponentImpl(this);
            }
            throw new IllegalStateException(BDTLoginActivity.class.getCanonicalName() + " must be set");
        }

        public void seedInstance(BDTLoginActivity bDTLoginActivity) {
            this.seedInstance = (BDTLoginActivity) Preconditions.checkNotNull(bDTLoginActivity);
        }
    }

    private final class BDTLoginActivitySubcomponentImpl implements ActivityModule_ContributeBDTLoginActivity$app_productionRelease.BDTLoginActivitySubcomponent {
        private BDTLoginActivitySubcomponentImpl(BDTLoginActivitySubcomponentBuilder bDTLoginActivitySubcomponentBuilder) {
        }

        public void inject(BDTLoginActivity bDTLoginActivity) {
            injectBDTLoginActivity(bDTLoginActivity);
        }

        @CanIgnoreReturnValue
        private BDTLoginActivity injectBDTLoginActivity(BDTLoginActivity bDTLoginActivity) {
            BaseActivity_MembersInjector.injectDispatchingAndroidInjector(bDTLoginActivity, DaggerAppComponent.this.getDispatchingAndroidInjectorOfFragment2());
            BDTLoginActivity_MembersInjector.injectViewModelFactory(bDTLoginActivity, (ViewModelProvider.Factory) DaggerAppComponent.this.appViewModelFactoryProvider.get());
            BDTLoginActivity_MembersInjector.injectSessionManager(bDTLoginActivity, (SessionManager) DaggerAppComponent.this.sessionManagerProvider.get());
            BDTLoginActivity_MembersInjector.injectSharedPrefsHelper(bDTLoginActivity, (SharedPrefsHelper) DaggerAppComponent.this.sharedPrefsHelperProvider.get());
            return bDTLoginActivity;
        }
    }

    private final class BDTForgotPasswordActivitySubcomponentBuilder extends C2838x7cf6479a.BDTForgotPasswordActivitySubcomponent.Builder {
        private BDTForgotPasswordActivity seedInstance;

        private BDTForgotPasswordActivitySubcomponentBuilder() {
        }

        public C2838x7cf6479a.BDTForgotPasswordActivitySubcomponent build() {
            if (this.seedInstance != null) {
                return new BDTForgotPasswordActivitySubcomponentImpl(this);
            }
            throw new IllegalStateException(BDTForgotPasswordActivity.class.getCanonicalName() + " must be set");
        }

        public void seedInstance(BDTForgotPasswordActivity bDTForgotPasswordActivity) {
            this.seedInstance = (BDTForgotPasswordActivity) Preconditions.checkNotNull(bDTForgotPasswordActivity);
        }
    }

    private final class BDTForgotPasswordActivitySubcomponentImpl implements C2838x7cf6479a.BDTForgotPasswordActivitySubcomponent {
        private BDTForgotPasswordActivitySubcomponentImpl(BDTForgotPasswordActivitySubcomponentBuilder bDTForgotPasswordActivitySubcomponentBuilder) {
        }

        public void inject(BDTForgotPasswordActivity bDTForgotPasswordActivity) {
            injectBDTForgotPasswordActivity(bDTForgotPasswordActivity);
        }

        @CanIgnoreReturnValue
        private BDTForgotPasswordActivity injectBDTForgotPasswordActivity(BDTForgotPasswordActivity bDTForgotPasswordActivity) {
            BDTForgotPasswordActivity_MembersInjector.injectViewModelFactory(bDTForgotPasswordActivity, (ViewModelProvider.Factory) DaggerAppComponent.this.appViewModelFactoryProvider.get());
            return bDTForgotPasswordActivity;
        }
    }

    private final class EmailConfirmationActivitySubcomponentBuilder extends C2848x7f1a6ddb.EmailConfirmationActivitySubcomponent.Builder {
        private EmailConfirmationActivity seedInstance;

        private EmailConfirmationActivitySubcomponentBuilder() {
        }

        public C2848x7f1a6ddb.EmailConfirmationActivitySubcomponent build() {
            if (this.seedInstance != null) {
                return new EmailConfirmationActivitySubcomponentImpl(this);
            }
            throw new IllegalStateException(EmailConfirmationActivity.class.getCanonicalName() + " must be set");
        }

        public void seedInstance(EmailConfirmationActivity emailConfirmationActivity) {
            this.seedInstance = (EmailConfirmationActivity) Preconditions.checkNotNull(emailConfirmationActivity);
        }
    }

    private final class EmailConfirmationActivitySubcomponentImpl implements C2848x7f1a6ddb.EmailConfirmationActivitySubcomponent {
        private EmailConfirmationActivitySubcomponentImpl(EmailConfirmationActivitySubcomponentBuilder emailConfirmationActivitySubcomponentBuilder) {
        }

        public void inject(EmailConfirmationActivity emailConfirmationActivity) {
            injectEmailConfirmationActivity(emailConfirmationActivity);
        }

        @CanIgnoreReturnValue
        private EmailConfirmationActivity injectEmailConfirmationActivity(EmailConfirmationActivity emailConfirmationActivity) {
            BaseActivity_MembersInjector.injectDispatchingAndroidInjector(emailConfirmationActivity, DaggerAppComponent.this.getDispatchingAndroidInjectorOfFragment2());
            EmailConfirmationActivity_MembersInjector.injectViewModelFactory(emailConfirmationActivity, (ViewModelProvider.Factory) DaggerAppComponent.this.appViewModelFactoryProvider.get());
            return emailConfirmationActivity;
        }
    }

    private final class ValidateOTPActivitySubcomponentBuilder extends C2869xfd7b965f.ValidateOTPActivitySubcomponent.Builder {
        private ValidateOTPActivity seedInstance;

        private ValidateOTPActivitySubcomponentBuilder() {
        }

        public C2869xfd7b965f.ValidateOTPActivitySubcomponent build() {
            if (this.seedInstance != null) {
                return new ValidateOTPActivitySubcomponentImpl(this);
            }
            throw new IllegalStateException(ValidateOTPActivity.class.getCanonicalName() + " must be set");
        }

        public void seedInstance(ValidateOTPActivity validateOTPActivity) {
            this.seedInstance = (ValidateOTPActivity) Preconditions.checkNotNull(validateOTPActivity);
        }
    }

    private final class ValidateOTPActivitySubcomponentImpl implements C2869xfd7b965f.ValidateOTPActivitySubcomponent {
        private ValidateOTPActivitySubcomponentImpl(ValidateOTPActivitySubcomponentBuilder validateOTPActivitySubcomponentBuilder) {
        }

        public void inject(ValidateOTPActivity validateOTPActivity) {
            injectValidateOTPActivity(validateOTPActivity);
        }

        @CanIgnoreReturnValue
        private ValidateOTPActivity injectValidateOTPActivity(ValidateOTPActivity validateOTPActivity) {
            BaseActivity_MembersInjector.injectDispatchingAndroidInjector(validateOTPActivity, DaggerAppComponent.this.getDispatchingAndroidInjectorOfFragment2());
            ValidateOTPActivity_MembersInjector.injectViewModelFactory(validateOTPActivity, (ViewModelProvider.Factory) DaggerAppComponent.this.appViewModelFactoryProvider.get());
            return validateOTPActivity;
        }
    }

    private final class BDTTermsOfUseActivitySubcomponentBuilder extends C2844xbb69ae5.BDTTermsOfUseActivitySubcomponent.Builder {
        private BDTTermsOfUseActivity seedInstance;

        private BDTTermsOfUseActivitySubcomponentBuilder() {
        }

        public C2844xbb69ae5.BDTTermsOfUseActivitySubcomponent build() {
            if (this.seedInstance != null) {
                return new BDTTermsOfUseActivitySubcomponentImpl(this);
            }
            throw new IllegalStateException(BDTTermsOfUseActivity.class.getCanonicalName() + " must be set");
        }

        public void seedInstance(BDTTermsOfUseActivity bDTTermsOfUseActivity) {
            this.seedInstance = (BDTTermsOfUseActivity) Preconditions.checkNotNull(bDTTermsOfUseActivity);
        }
    }

    private final class BDTTermsOfUseActivitySubcomponentImpl implements C2844xbb69ae5.BDTTermsOfUseActivitySubcomponent {
        private BDTTermsOfUseActivitySubcomponentImpl(BDTTermsOfUseActivitySubcomponentBuilder bDTTermsOfUseActivitySubcomponentBuilder) {
        }

        public void inject(BDTTermsOfUseActivity bDTTermsOfUseActivity) {
            injectBDTTermsOfUseActivity(bDTTermsOfUseActivity);
        }

        @CanIgnoreReturnValue
        private BDTTermsOfUseActivity injectBDTTermsOfUseActivity(BDTTermsOfUseActivity bDTTermsOfUseActivity) {
            BDTTermsOfUseActivity_MembersInjector.injectViewModelFactory(bDTTermsOfUseActivity, (ViewModelProvider.Factory) DaggerAppComponent.this.appViewModelFactoryProvider.get());
            BDTTermsOfUseActivity_MembersInjector.injectSessionManager(bDTTermsOfUseActivity, (SessionManager) DaggerAppComponent.this.sessionManagerProvider.get());
            return bDTTermsOfUseActivity;
        }
    }

    private final class BDTMyAccountActivitySubcomponentBuilder extends C2839x5866c2bb.BDTMyAccountActivitySubcomponent.Builder {
        private BDTMyAccountActivity seedInstance;

        private BDTMyAccountActivitySubcomponentBuilder() {
        }

        public C2839x5866c2bb.BDTMyAccountActivitySubcomponent build() {
            if (this.seedInstance != null) {
                return new BDTMyAccountActivitySubcomponentImpl(this);
            }
            throw new IllegalStateException(BDTMyAccountActivity.class.getCanonicalName() + " must be set");
        }

        public void seedInstance(BDTMyAccountActivity bDTMyAccountActivity) {
            this.seedInstance = (BDTMyAccountActivity) Preconditions.checkNotNull(bDTMyAccountActivity);
        }
    }

    private final class BDTMyAccountActivitySubcomponentImpl implements C2839x5866c2bb.BDTMyAccountActivitySubcomponent {
        private BDTMyAccountActivitySubcomponentImpl(BDTMyAccountActivitySubcomponentBuilder bDTMyAccountActivitySubcomponentBuilder) {
        }

        public void inject(BDTMyAccountActivity bDTMyAccountActivity) {
            injectBDTMyAccountActivity(bDTMyAccountActivity);
        }

        @CanIgnoreReturnValue
        private BDTMyAccountActivity injectBDTMyAccountActivity(BDTMyAccountActivity bDTMyAccountActivity) {
            BaseActivity_MembersInjector.injectDispatchingAndroidInjector(bDTMyAccountActivity, DaggerAppComponent.this.getDispatchingAndroidInjectorOfFragment2());
            MVVMNavDrawerActivity_MembersInjector.injectSessionManager(bDTMyAccountActivity, (SessionManager) DaggerAppComponent.this.sessionManagerProvider.get());
            MVVMNavDrawerActivity_MembersInjector.injectSharedPrefsHelper(bDTMyAccountActivity, (SharedPrefsHelper) DaggerAppComponent.this.sharedPrefsHelperProvider.get());
            BDTMyAccountActivity_MembersInjector.injectViewModelFactory(bDTMyAccountActivity, (ViewModelProvider.Factory) DaggerAppComponent.this.appViewModelFactoryProvider.get());
            return bDTMyAccountActivity;
        }
    }

    private final class BDTPromptPasswordDialogActivitySubcomponentBuilder extends C2842x9e94083.BDTPromptPasswordDialogActivitySubcomponent.Builder {
        private BDTPromptPasswordDialogActivity seedInstance;

        private BDTPromptPasswordDialogActivitySubcomponentBuilder() {
        }

        public C2842x9e94083.BDTPromptPasswordDialogActivitySubcomponent build() {
            if (this.seedInstance != null) {
                return new BDTPromptPasswordDialogActivitySubcomponentImpl(this);
            }
            throw new IllegalStateException(BDTPromptPasswordDialogActivity.class.getCanonicalName() + " must be set");
        }

        public void seedInstance(BDTPromptPasswordDialogActivity bDTPromptPasswordDialogActivity) {
            this.seedInstance = (BDTPromptPasswordDialogActivity) Preconditions.checkNotNull(bDTPromptPasswordDialogActivity);
        }
    }

    private final class BDTPromptPasswordDialogActivitySubcomponentImpl implements C2842x9e94083.BDTPromptPasswordDialogActivitySubcomponent {
        private BDTPromptPasswordDialogActivitySubcomponentImpl(BDTPromptPasswordDialogActivitySubcomponentBuilder bDTPromptPasswordDialogActivitySubcomponentBuilder) {
        }

        public void inject(BDTPromptPasswordDialogActivity bDTPromptPasswordDialogActivity) {
            injectBDTPromptPasswordDialogActivity(bDTPromptPasswordDialogActivity);
        }

        @CanIgnoreReturnValue
        private BDTPromptPasswordDialogActivity injectBDTPromptPasswordDialogActivity(BDTPromptPasswordDialogActivity bDTPromptPasswordDialogActivity) {
            BDTPromptPasswordDialogActivity_MembersInjector.injectViewModelFactory(bDTPromptPasswordDialogActivity, (ViewModelProvider.Factory) DaggerAppComponent.this.appViewModelFactoryProvider.get());
            BDTPromptPasswordDialogActivity_MembersInjector.injectSessionManager(bDTPromptPasswordDialogActivity, (SessionManager) DaggerAppComponent.this.sessionManagerProvider.get());
            BDTPromptPasswordDialogActivity_MembersInjector.injectSharedPrefsHelper(bDTPromptPasswordDialogActivity, (SharedPrefsHelper) DaggerAppComponent.this.sharedPrefsHelperProvider.get());
            return bDTPromptPasswordDialogActivity;
        }
    }

    private final class PreSaleListActivitySubcomponentBuilder extends ActivityModule_ContributeWatchListActivity$app_productionRelease.PreSaleListActivitySubcomponent.Builder {
        private PreSaleListActivity seedInstance;

        private PreSaleListActivitySubcomponentBuilder() {
        }

        public ActivityModule_ContributeWatchListActivity$app_productionRelease.PreSaleListActivitySubcomponent build() {
            if (this.seedInstance != null) {
                return new PreSaleListActivitySubcomponentImpl(this);
            }
            throw new IllegalStateException(PreSaleListActivity.class.getCanonicalName() + " must be set");
        }

        public void seedInstance(PreSaleListActivity preSaleListActivity) {
            this.seedInstance = (PreSaleListActivity) Preconditions.checkNotNull(preSaleListActivity);
        }
    }

    private final class PreSaleListActivitySubcomponentImpl implements ActivityModule_ContributeWatchListActivity$app_productionRelease.PreSaleListActivitySubcomponent {
        private PreSaleListActivitySubcomponentImpl(PreSaleListActivitySubcomponentBuilder preSaleListActivitySubcomponentBuilder) {
        }

        public void inject(PreSaleListActivity preSaleListActivity) {
            injectPreSaleListActivity(preSaleListActivity);
        }

        @CanIgnoreReturnValue
        private PreSaleListActivity injectPreSaleListActivity(PreSaleListActivity preSaleListActivity) {
            BaseActivity_MembersInjector.injectDispatchingAndroidInjector(preSaleListActivity, DaggerAppComponent.this.getDispatchingAndroidInjectorOfFragment2());
            PreSaleListActivity_MembersInjector.injectViewModelFactory(preSaleListActivity, (ViewModelProvider.Factory) DaggerAppComponent.this.appViewModelFactoryProvider.get());
            PreSaleListActivity_MembersInjector.injectSessionManager(preSaleListActivity, (SessionManager) DaggerAppComponent.this.sessionManagerProvider.get());
            return preSaleListActivity;
        }
    }

    private final class BDTSettingsActivitySubcomponentBuilder extends C2843xcac342df.BDTSettingsActivitySubcomponent.Builder {
        private BDTSettingsActivity seedInstance;

        private BDTSettingsActivitySubcomponentBuilder() {
        }

        public C2843xcac342df.BDTSettingsActivitySubcomponent build() {
            if (this.seedInstance != null) {
                return new BDTSettingsActivitySubcomponentImpl(this);
            }
            throw new IllegalStateException(BDTSettingsActivity.class.getCanonicalName() + " must be set");
        }

        public void seedInstance(BDTSettingsActivity bDTSettingsActivity) {
            this.seedInstance = (BDTSettingsActivity) Preconditions.checkNotNull(bDTSettingsActivity);
        }
    }

    private final class BDTSettingsActivitySubcomponentImpl implements C2843xcac342df.BDTSettingsActivitySubcomponent {
        public void inject(BDTSettingsActivity bDTSettingsActivity) {
        }

        private BDTSettingsActivitySubcomponentImpl(BDTSettingsActivitySubcomponentBuilder bDTSettingsActivitySubcomponentBuilder) {
        }
    }

    private final class BDTPaymentMethodActivitySubcomponentBuilder extends C2840xc5ac0c61.BDTPaymentMethodActivitySubcomponent.Builder {
        private BDTPaymentMethodActivity seedInstance;

        private BDTPaymentMethodActivitySubcomponentBuilder() {
        }

        public C2840xc5ac0c61.BDTPaymentMethodActivitySubcomponent build() {
            if (this.seedInstance != null) {
                return new BDTPaymentMethodActivitySubcomponentImpl(this);
            }
            throw new IllegalStateException(BDTPaymentMethodActivity.class.getCanonicalName() + " must be set");
        }

        public void seedInstance(BDTPaymentMethodActivity bDTPaymentMethodActivity) {
            this.seedInstance = (BDTPaymentMethodActivity) Preconditions.checkNotNull(bDTPaymentMethodActivity);
        }
    }

    private final class BDTPaymentMethodActivitySubcomponentImpl implements C2840xc5ac0c61.BDTPaymentMethodActivitySubcomponent {
        private BDTPaymentMethodActivitySubcomponentImpl(BDTPaymentMethodActivitySubcomponentBuilder bDTPaymentMethodActivitySubcomponentBuilder) {
        }

        public void inject(BDTPaymentMethodActivity bDTPaymentMethodActivity) {
            injectBDTPaymentMethodActivity(bDTPaymentMethodActivity);
        }

        @CanIgnoreReturnValue
        private BDTPaymentMethodActivity injectBDTPaymentMethodActivity(BDTPaymentMethodActivity bDTPaymentMethodActivity) {
            BaseActivity_MembersInjector.injectDispatchingAndroidInjector(bDTPaymentMethodActivity, DaggerAppComponent.this.getDispatchingAndroidInjectorOfFragment2());
            BDTPaymentMethodActivity_MembersInjector.injectViewModelFactory(bDTPaymentMethodActivity, (ViewModelProvider.Factory) DaggerAppComponent.this.appViewModelFactoryProvider.get());
            BDTPaymentMethodActivity_MembersInjector.injectSharedPrefsHelper(bDTPaymentMethodActivity, (SharedPrefsHelper) DaggerAppComponent.this.sharedPrefsHelperProvider.get());
            BDTPaymentMethodActivity_MembersInjector.injectSessionManager(bDTPaymentMethodActivity, (SessionManager) DaggerAppComponent.this.sessionManagerProvider.get());
            return bDTPaymentMethodActivity;
        }
    }

    private final class WebViewActivitySubcomponentBuilder extends ActivityModule_ContributeWebViewActivity$app_productionRelease.WebViewActivitySubcomponent.Builder {
        private WebViewActivity seedInstance;

        private WebViewActivitySubcomponentBuilder() {
        }

        public ActivityModule_ContributeWebViewActivity$app_productionRelease.WebViewActivitySubcomponent build() {
            if (this.seedInstance != null) {
                return new WebViewActivitySubcomponentImpl(this);
            }
            throw new IllegalStateException(WebViewActivity.class.getCanonicalName() + " must be set");
        }

        public void seedInstance(WebViewActivity webViewActivity) {
            this.seedInstance = (WebViewActivity) Preconditions.checkNotNull(webViewActivity);
        }
    }

    private final class WebViewActivitySubcomponentImpl implements ActivityModule_ContributeWebViewActivity$app_productionRelease.WebViewActivitySubcomponent {
        public void inject(WebViewActivity webViewActivity) {
        }

        private WebViewActivitySubcomponentImpl(WebViewActivitySubcomponentBuilder webViewActivitySubcomponentBuilder) {
        }
    }

    private final class BuyNowOfferListActivitySubcomponentBuilder extends C2845x87ed9a74.BuyNowOfferListActivitySubcomponent.Builder {
        private BuyNowOfferListActivity seedInstance;

        private BuyNowOfferListActivitySubcomponentBuilder() {
        }

        public C2845x87ed9a74.BuyNowOfferListActivitySubcomponent build() {
            if (this.seedInstance != null) {
                return new BuyNowOfferListActivitySubcomponentImpl(this);
            }
            throw new IllegalStateException(BuyNowOfferListActivity.class.getCanonicalName() + " must be set");
        }

        public void seedInstance(BuyNowOfferListActivity buyNowOfferListActivity) {
            this.seedInstance = (BuyNowOfferListActivity) Preconditions.checkNotNull(buyNowOfferListActivity);
        }
    }

    private final class BuyNowOfferListActivitySubcomponentImpl implements C2845x87ed9a74.BuyNowOfferListActivitySubcomponent {
        private BuyNowOfferListActivitySubcomponentImpl(BuyNowOfferListActivitySubcomponentBuilder buyNowOfferListActivitySubcomponentBuilder) {
        }

        public void inject(BuyNowOfferListActivity buyNowOfferListActivity) {
            injectBuyNowOfferListActivity(buyNowOfferListActivity);
        }

        @CanIgnoreReturnValue
        private BuyNowOfferListActivity injectBuyNowOfferListActivity(BuyNowOfferListActivity buyNowOfferListActivity) {
            BaseActivity_MembersInjector.injectDispatchingAndroidInjector(buyNowOfferListActivity, DaggerAppComponent.this.getDispatchingAndroidInjectorOfFragment2());
            BuyNowOfferListActivity_MembersInjector.injectViewModelFactory(buyNowOfferListActivity, (ViewModelProvider.Factory) DaggerAppComponent.this.appViewModelFactoryProvider.get());
            BuyNowOfferListActivity_MembersInjector.injectSessionManager(buyNowOfferListActivity, (SessionManager) DaggerAppComponent.this.sessionManagerProvider.get());
            return buyNowOfferListActivity;
        }
    }

    private final class ToPickedUpAccountActivitySubcomponentBuilder extends C2868xe976bf5e.ToPickedUpAccountActivitySubcomponent.Builder {
        private ToPickedUpAccountActivity seedInstance;

        private ToPickedUpAccountActivitySubcomponentBuilder() {
        }

        public C2868xe976bf5e.ToPickedUpAccountActivitySubcomponent build() {
            if (this.seedInstance != null) {
                return new ToPickedUpAccountActivitySubcomponentImpl(this);
            }
            throw new IllegalStateException(ToPickedUpAccountActivity.class.getCanonicalName() + " must be set");
        }

        public void seedInstance(ToPickedUpAccountActivity toPickedUpAccountActivity) {
            this.seedInstance = (ToPickedUpAccountActivity) Preconditions.checkNotNull(toPickedUpAccountActivity);
        }
    }

    private final class ToPickedUpAccountActivitySubcomponentImpl implements C2868xe976bf5e.ToPickedUpAccountActivitySubcomponent {
        private ToPickedUpAccountActivitySubcomponentImpl(ToPickedUpAccountActivitySubcomponentBuilder toPickedUpAccountActivitySubcomponentBuilder) {
        }

        public void inject(ToPickedUpAccountActivity toPickedUpAccountActivity) {
            injectToPickedUpAccountActivity(toPickedUpAccountActivity);
        }

        @CanIgnoreReturnValue
        private ToPickedUpAccountActivity injectToPickedUpAccountActivity(ToPickedUpAccountActivity toPickedUpAccountActivity) {
            BaseActivity_MembersInjector.injectDispatchingAndroidInjector(toPickedUpAccountActivity, DaggerAppComponent.this.getDispatchingAndroidInjectorOfFragment2());
            ToPickedUpAccountActivity_MembersInjector.injectViewModelFactory(toPickedUpAccountActivity, (ViewModelProvider.Factory) DaggerAppComponent.this.appViewModelFactoryProvider.get());
            ToPickedUpAccountActivity_MembersInjector.injectSessionManager(toPickedUpAccountActivity, (SessionManager) DaggerAppComponent.this.sessionManagerProvider.get());
            return toPickedUpAccountActivity;
        }
    }

    private final class ReceiptDPFActivitySubcomponentBuilder extends ActivityModule_ContributeAFCTermsPage$app_productionRelease.ReceiptDPFActivitySubcomponent.Builder {
        private ReceiptDPFActivity seedInstance;

        private ReceiptDPFActivitySubcomponentBuilder() {
        }

        public ActivityModule_ContributeAFCTermsPage$app_productionRelease.ReceiptDPFActivitySubcomponent build() {
            if (this.seedInstance != null) {
                return new ReceiptDPFActivitySubcomponentImpl(this);
            }
            throw new IllegalStateException(ReceiptDPFActivity.class.getCanonicalName() + " must be set");
        }

        public void seedInstance(ReceiptDPFActivity receiptDPFActivity) {
            this.seedInstance = (ReceiptDPFActivity) Preconditions.checkNotNull(receiptDPFActivity);
        }
    }

    private final class ReceiptDPFActivitySubcomponentImpl implements ActivityModule_ContributeAFCTermsPage$app_productionRelease.ReceiptDPFActivitySubcomponent {
        private ReceiptDPFActivitySubcomponentImpl(ReceiptDPFActivitySubcomponentBuilder receiptDPFActivitySubcomponentBuilder) {
        }

        public void inject(ReceiptDPFActivity receiptDPFActivity) {
            injectReceiptDPFActivity(receiptDPFActivity);
        }

        @CanIgnoreReturnValue
        private ReceiptDPFActivity injectReceiptDPFActivity(ReceiptDPFActivity receiptDPFActivity) {
            BaseActivity_MembersInjector.injectDispatchingAndroidInjector(receiptDPFActivity, DaggerAppComponent.this.getDispatchingAndroidInjectorOfFragment2());
            ReceiptDPFActivity_MembersInjector.injectViewModelFactory(receiptDPFActivity, (ViewModelProvider.Factory) DaggerAppComponent.this.appViewModelFactoryProvider.get());
            ReceiptDPFActivity_MembersInjector.injectSessionManager(receiptDPFActivity, (SessionManager) DaggerAppComponent.this.sessionManagerProvider.get());
            return receiptDPFActivity;
        }
    }

    private final class SalesDocumentActivitySubcomponentBuilder extends C2861xd6519331.SalesDocumentActivitySubcomponent.Builder {
        private SalesDocumentActivity seedInstance;

        private SalesDocumentActivitySubcomponentBuilder() {
        }

        public C2861xd6519331.SalesDocumentActivitySubcomponent build() {
            if (this.seedInstance != null) {
                return new SalesDocumentActivitySubcomponentImpl(this);
            }
            throw new IllegalStateException(SalesDocumentActivity.class.getCanonicalName() + " must be set");
        }

        public void seedInstance(SalesDocumentActivity salesDocumentActivity) {
            this.seedInstance = (SalesDocumentActivity) Preconditions.checkNotNull(salesDocumentActivity);
        }
    }

    private final class SalesDocumentActivitySubcomponentImpl implements C2861xd6519331.SalesDocumentActivitySubcomponent {
        private SalesDocumentActivitySubcomponentImpl(SalesDocumentActivitySubcomponentBuilder salesDocumentActivitySubcomponentBuilder) {
        }

        public void inject(SalesDocumentActivity salesDocumentActivity) {
            injectSalesDocumentActivity(salesDocumentActivity);
        }

        @CanIgnoreReturnValue
        private SalesDocumentActivity injectSalesDocumentActivity(SalesDocumentActivity salesDocumentActivity) {
            BaseActivity_MembersInjector.injectDispatchingAndroidInjector(salesDocumentActivity, DaggerAppComponent.this.getDispatchingAndroidInjectorOfFragment2());
            SalesDocumentActivity_MembersInjector.injectViewModelFactory(salesDocumentActivity, (ViewModelProvider.Factory) DaggerAppComponent.this.appViewModelFactoryProvider.get());
            SalesDocumentActivity_MembersInjector.injectSessionManager(salesDocumentActivity, (SessionManager) DaggerAppComponent.this.sessionManagerProvider.get());
            return salesDocumentActivity;
        }
    }

    private final class SaleDocListActivitySubcomponentBuilder extends C2860x22c96259.SaleDocListActivitySubcomponent.Builder {
        private SaleDocListActivity seedInstance;

        private SaleDocListActivitySubcomponentBuilder() {
        }

        public C2860x22c96259.SaleDocListActivitySubcomponent build() {
            if (this.seedInstance != null) {
                return new SaleDocListActivitySubcomponentImpl(this);
            }
            throw new IllegalStateException(SaleDocListActivity.class.getCanonicalName() + " must be set");
        }

        public void seedInstance(SaleDocListActivity saleDocListActivity) {
            this.seedInstance = (SaleDocListActivity) Preconditions.checkNotNull(saleDocListActivity);
        }
    }

    private final class SaleDocListActivitySubcomponentImpl implements C2860x22c96259.SaleDocListActivitySubcomponent {
        private SaleDocListActivitySubcomponentImpl(SaleDocListActivitySubcomponentBuilder saleDocListActivitySubcomponentBuilder) {
        }

        public void inject(SaleDocListActivity saleDocListActivity) {
            injectSaleDocListActivity(saleDocListActivity);
        }

        @CanIgnoreReturnValue
        private SaleDocListActivity injectSaleDocListActivity(SaleDocListActivity saleDocListActivity) {
            BaseActivity_MembersInjector.injectDispatchingAndroidInjector(saleDocListActivity, DaggerAppComponent.this.getDispatchingAndroidInjectorOfFragment2());
            SaleDocListActivity_MembersInjector.injectViewModelFactory(saleDocListActivity, (ViewModelProvider.Factory) DaggerAppComponent.this.appViewModelFactoryProvider.get());
            SaleDocListActivity_MembersInjector.injectSessionManager(saleDocListActivity, (SessionManager) DaggerAppComponent.this.sessionManagerProvider.get());
            return saleDocListActivity;
        }
    }

    private final class DeliveryMethodActivitySubcomponentBuilder extends C2847xd8231361.DeliveryMethodActivitySubcomponent.Builder {
        private DeliveryMethodActivity seedInstance;

        private DeliveryMethodActivitySubcomponentBuilder() {
        }

        public C2847xd8231361.DeliveryMethodActivitySubcomponent build() {
            if (this.seedInstance != null) {
                return new DeliveryMethodActivitySubcomponentImpl(this);
            }
            throw new IllegalStateException(DeliveryMethodActivity.class.getCanonicalName() + " must be set");
        }

        public void seedInstance(DeliveryMethodActivity deliveryMethodActivity) {
            this.seedInstance = (DeliveryMethodActivity) Preconditions.checkNotNull(deliveryMethodActivity);
        }
    }

    private final class DeliveryMethodActivitySubcomponentImpl implements C2847xd8231361.DeliveryMethodActivitySubcomponent {
        private DeliveryMethodActivitySubcomponentImpl(DeliveryMethodActivitySubcomponentBuilder deliveryMethodActivitySubcomponentBuilder) {
        }

        public void inject(DeliveryMethodActivity deliveryMethodActivity) {
            injectDeliveryMethodActivity(deliveryMethodActivity);
        }

        @CanIgnoreReturnValue
        private DeliveryMethodActivity injectDeliveryMethodActivity(DeliveryMethodActivity deliveryMethodActivity) {
            DeliveryMethodActivity_MembersInjector.injectViewModelFactory(deliveryMethodActivity, (ViewModelProvider.Factory) DaggerAppComponent.this.appViewModelFactoryProvider.get());
            DeliveryMethodActivity_MembersInjector.injectSessionManager(deliveryMethodActivity, (SessionManager) DaggerAppComponent.this.sessionManagerProvider.get());
            return deliveryMethodActivity;
        }
    }

    private final class ManageBranchPrefActivitySubcomponentBuilder extends C2855xfefe3896.ManageBranchPrefActivitySubcomponent.Builder {
        private ManageBranchPrefActivity seedInstance;

        private ManageBranchPrefActivitySubcomponentBuilder() {
        }

        public C2855xfefe3896.ManageBranchPrefActivitySubcomponent build() {
            if (this.seedInstance != null) {
                return new ManageBranchPrefActivitySubcomponentImpl(this);
            }
            throw new IllegalStateException(ManageBranchPrefActivity.class.getCanonicalName() + " must be set");
        }

        public void seedInstance(ManageBranchPrefActivity manageBranchPrefActivity) {
            this.seedInstance = (ManageBranchPrefActivity) Preconditions.checkNotNull(manageBranchPrefActivity);
        }
    }

    private final class ManageBranchPrefActivitySubcomponentImpl implements C2855xfefe3896.ManageBranchPrefActivitySubcomponent {
        private ManageBranchPrefActivitySubcomponentImpl(ManageBranchPrefActivitySubcomponentBuilder manageBranchPrefActivitySubcomponentBuilder) {
        }

        public void inject(ManageBranchPrefActivity manageBranchPrefActivity) {
            injectManageBranchPrefActivity(manageBranchPrefActivity);
        }

        @CanIgnoreReturnValue
        private ManageBranchPrefActivity injectManageBranchPrefActivity(ManageBranchPrefActivity manageBranchPrefActivity) {
            ManageBranchPrefActivity_MembersInjector.injectViewModelFactory(manageBranchPrefActivity, (ViewModelProvider.Factory) DaggerAppComponent.this.appViewModelFactoryProvider.get());
            ManageBranchPrefActivity_MembersInjector.injectSessionManager(manageBranchPrefActivity, (SessionManager) DaggerAppComponent.this.sessionManagerProvider.get());
            return manageBranchPrefActivity;
        }
    }

    private final class FastSearchFilterActivitySubcomponentBuilder extends C2850xe66294a8.FastSearchFilterActivitySubcomponent.Builder {
        private FastSearchFilterActivity seedInstance;

        private FastSearchFilterActivitySubcomponentBuilder() {
        }

        public C2850xe66294a8.FastSearchFilterActivitySubcomponent build() {
            if (this.seedInstance != null) {
                return new FastSearchFilterActivitySubcomponentImpl(this);
            }
            throw new IllegalStateException(FastSearchFilterActivity.class.getCanonicalName() + " must be set");
        }

        public void seedInstance(FastSearchFilterActivity fastSearchFilterActivity) {
            this.seedInstance = (FastSearchFilterActivity) Preconditions.checkNotNull(fastSearchFilterActivity);
        }
    }

    private final class FastSearchFilterActivitySubcomponentImpl implements C2850xe66294a8.FastSearchFilterActivitySubcomponent {
        private FastSearchFilterActivitySubcomponentImpl(FastSearchFilterActivitySubcomponentBuilder fastSearchFilterActivitySubcomponentBuilder) {
        }

        public void inject(FastSearchFilterActivity fastSearchFilterActivity) {
            injectFastSearchFilterActivity(fastSearchFilterActivity);
        }

        @CanIgnoreReturnValue
        private FastSearchFilterActivity injectFastSearchFilterActivity(FastSearchFilterActivity fastSearchFilterActivity) {
            BaseActivity_MembersInjector.injectDispatchingAndroidInjector(fastSearchFilterActivity, DaggerAppComponent.this.getDispatchingAndroidInjectorOfFragment2());
            MVVMNavDrawerActivity_MembersInjector.injectSessionManager(fastSearchFilterActivity, (SessionManager) DaggerAppComponent.this.sessionManagerProvider.get());
            MVVMNavDrawerActivity_MembersInjector.injectSharedPrefsHelper(fastSearchFilterActivity, (SharedPrefsHelper) DaggerAppComponent.this.sharedPrefsHelperProvider.get());
            return fastSearchFilterActivity;
        }
    }

    private final class RefinerResultActivitySubcomponentBuilder extends C2859xf0fafcc.RefinerResultActivitySubcomponent.Builder {
        private RefinerResultActivity seedInstance;

        private RefinerResultActivitySubcomponentBuilder() {
        }

        public C2859xf0fafcc.RefinerResultActivitySubcomponent build() {
            if (this.seedInstance != null) {
                return new RefinerResultActivitySubcomponentImpl(this);
            }
            throw new IllegalStateException(RefinerResultActivity.class.getCanonicalName() + " must be set");
        }

        public void seedInstance(RefinerResultActivity refinerResultActivity) {
            this.seedInstance = (RefinerResultActivity) Preconditions.checkNotNull(refinerResultActivity);
        }
    }

    private final class RefinerResultActivitySubcomponentImpl implements C2859xf0fafcc.RefinerResultActivitySubcomponent {
        private RefinerResultActivitySubcomponentImpl(RefinerResultActivitySubcomponentBuilder refinerResultActivitySubcomponentBuilder) {
        }

        public void inject(RefinerResultActivity refinerResultActivity) {
            injectRefinerResultActivity(refinerResultActivity);
        }

        @CanIgnoreReturnValue
        private RefinerResultActivity injectRefinerResultActivity(RefinerResultActivity refinerResultActivity) {
            BaseActivity_MembersInjector.injectDispatchingAndroidInjector(refinerResultActivity, DaggerAppComponent.this.getDispatchingAndroidInjectorOfFragment2());
            RefinerResultActivity_MembersInjector.injectViewModelFactory(refinerResultActivity, (ViewModelProvider.Factory) DaggerAppComponent.this.appViewModelFactoryProvider.get());
            RefinerResultActivity_MembersInjector.injectSessionManager(refinerResultActivity, (SessionManager) DaggerAppComponent.this.sessionManagerProvider.get());
            return refinerResultActivity;
        }
    }

    private final class SearchByDistanceActivitySubcomponentBuilder extends C2864xbce57620.SearchByDistanceActivitySubcomponent.Builder {
        private SearchByDistanceActivity seedInstance;

        private SearchByDistanceActivitySubcomponentBuilder() {
        }

        public C2864xbce57620.SearchByDistanceActivitySubcomponent build() {
            if (this.seedInstance != null) {
                return new SearchByDistanceActivitySubcomponentImpl(this);
            }
            throw new IllegalStateException(SearchByDistanceActivity.class.getCanonicalName() + " must be set");
        }

        public void seedInstance(SearchByDistanceActivity searchByDistanceActivity) {
            this.seedInstance = (SearchByDistanceActivity) Preconditions.checkNotNull(searchByDistanceActivity);
        }
    }

    private final class SearchByDistanceActivitySubcomponentImpl implements C2864xbce57620.SearchByDistanceActivitySubcomponent {
        private SearchByDistanceActivitySubcomponentImpl(SearchByDistanceActivitySubcomponentBuilder searchByDistanceActivitySubcomponentBuilder) {
        }

        public void inject(SearchByDistanceActivity searchByDistanceActivity) {
            injectSearchByDistanceActivity(searchByDistanceActivity);
        }

        @CanIgnoreReturnValue
        private SearchByDistanceActivity injectSearchByDistanceActivity(SearchByDistanceActivity searchByDistanceActivity) {
            BaseActivity_MembersInjector.injectDispatchingAndroidInjector(searchByDistanceActivity, DaggerAppComponent.this.getDispatchingAndroidInjectorOfFragment2());
            return searchByDistanceActivity;
        }
    }

    private final class SavedSearchActivitySubcomponentBuilder extends C2862x7ad821b9.SavedSearchActivitySubcomponent.Builder {
        private SavedSearchActivity seedInstance;

        private SavedSearchActivitySubcomponentBuilder() {
        }

        public C2862x7ad821b9.SavedSearchActivitySubcomponent build() {
            if (this.seedInstance != null) {
                return new SavedSearchActivitySubcomponentImpl(this);
            }
            throw new IllegalStateException(SavedSearchActivity.class.getCanonicalName() + " must be set");
        }

        public void seedInstance(SavedSearchActivity savedSearchActivity) {
            this.seedInstance = (SavedSearchActivity) Preconditions.checkNotNull(savedSearchActivity);
        }
    }

    private final class SavedSearchActivitySubcomponentImpl implements C2862x7ad821b9.SavedSearchActivitySubcomponent {
        private SavedSearchActivitySubcomponentImpl(SavedSearchActivitySubcomponentBuilder savedSearchActivitySubcomponentBuilder) {
        }

        public void inject(SavedSearchActivity savedSearchActivity) {
            injectSavedSearchActivity(savedSearchActivity);
        }

        @CanIgnoreReturnValue
        private SavedSearchActivity injectSavedSearchActivity(SavedSearchActivity savedSearchActivity) {
            BaseActivity_MembersInjector.injectDispatchingAndroidInjector(savedSearchActivity, DaggerAppComponent.this.getDispatchingAndroidInjectorOfFragment2());
            SavedSearchActivity_MembersInjector.injectViewModelFactory(savedSearchActivity, (ViewModelProvider.Factory) DaggerAppComponent.this.appViewModelFactoryProvider.get());
            SavedSearchActivity_MembersInjector.injectSessionManager(savedSearchActivity, (SessionManager) DaggerAppComponent.this.sessionManagerProvider.get());
            return savedSearchActivity;
        }
    }

    private final class SearchByOdometerActivitySubcomponentBuilder extends C2865xf001133a.SearchByOdometerActivitySubcomponent.Builder {
        private SearchByOdometerActivity seedInstance;

        private SearchByOdometerActivitySubcomponentBuilder() {
        }

        public C2865xf001133a.SearchByOdometerActivitySubcomponent build() {
            if (this.seedInstance != null) {
                return new SearchByOdometerActivitySubcomponentImpl(this);
            }
            throw new IllegalStateException(SearchByOdometerActivity.class.getCanonicalName() + " must be set");
        }

        public void seedInstance(SearchByOdometerActivity searchByOdometerActivity) {
            this.seedInstance = (SearchByOdometerActivity) Preconditions.checkNotNull(searchByOdometerActivity);
        }
    }

    private final class SearchByOdometerActivitySubcomponentImpl implements C2865xf001133a.SearchByOdometerActivitySubcomponent {
        private SearchByOdometerActivitySubcomponentImpl(SearchByOdometerActivitySubcomponentBuilder searchByOdometerActivitySubcomponentBuilder) {
        }

        public void inject(SearchByOdometerActivity searchByOdometerActivity) {
            injectSearchByOdometerActivity(searchByOdometerActivity);
        }

        @CanIgnoreReturnValue
        private SearchByOdometerActivity injectSearchByOdometerActivity(SearchByOdometerActivity searchByOdometerActivity) {
            BaseActivity_MembersInjector.injectDispatchingAndroidInjector(searchByOdometerActivity, DaggerAppComponent.this.getDispatchingAndroidInjectorOfFragment2());
            return searchByOdometerActivity;
        }
    }

    private final class SearchByACVActivitySubcomponentBuilder extends C2863xd79c7c1f.SearchByACVActivitySubcomponent.Builder {
        private SearchByACVActivity seedInstance;

        private SearchByACVActivitySubcomponentBuilder() {
        }

        public C2863xd79c7c1f.SearchByACVActivitySubcomponent build() {
            if (this.seedInstance != null) {
                return new SearchByACVActivitySubcomponentImpl(this);
            }
            throw new IllegalStateException(SearchByACVActivity.class.getCanonicalName() + " must be set");
        }

        public void seedInstance(SearchByACVActivity searchByACVActivity) {
            this.seedInstance = (SearchByACVActivity) Preconditions.checkNotNull(searchByACVActivity);
        }
    }

    private final class SearchByACVActivitySubcomponentImpl implements C2863xd79c7c1f.SearchByACVActivitySubcomponent {
        private SearchByACVActivitySubcomponentImpl(SearchByACVActivitySubcomponentBuilder searchByACVActivitySubcomponentBuilder) {
        }

        public void inject(SearchByACVActivity searchByACVActivity) {
            injectSearchByACVActivity(searchByACVActivity);
        }

        @CanIgnoreReturnValue
        private SearchByACVActivity injectSearchByACVActivity(SearchByACVActivity searchByACVActivity) {
            BaseActivity_MembersInjector.injectDispatchingAndroidInjector(searchByACVActivity, DaggerAppComponent.this.getDispatchingAndroidInjectorOfFragment2());
            return searchByACVActivity;
        }
    }

    private final class ProductDetailFragmentSubcomponentBuilder extends FragmentModule_ContributeProductDetail$app_productionRelease.ProductDetailFragmentSubcomponent.Builder {
        private ProductDetailFragment seedInstance;

        private ProductDetailFragmentSubcomponentBuilder() {
        }

        public FragmentModule_ContributeProductDetail$app_productionRelease.ProductDetailFragmentSubcomponent build() {
            if (this.seedInstance != null) {
                return new ProductDetailFragmentSubcomponentImpl(this);
            }
            throw new IllegalStateException(ProductDetailFragment.class.getCanonicalName() + " must be set");
        }

        public void seedInstance(ProductDetailFragment productDetailFragment) {
            this.seedInstance = (ProductDetailFragment) Preconditions.checkNotNull(productDetailFragment);
        }
    }

    private final class ProductDetailFragmentSubcomponentImpl implements FragmentModule_ContributeProductDetail$app_productionRelease.ProductDetailFragmentSubcomponent {
        private ProductDetailFragmentSubcomponentImpl(ProductDetailFragmentSubcomponentBuilder productDetailFragmentSubcomponentBuilder) {
        }

        public void inject(ProductDetailFragment productDetailFragment) {
            injectProductDetailFragment(productDetailFragment);
        }

        @CanIgnoreReturnValue
        private ProductDetailFragment injectProductDetailFragment(ProductDetailFragment productDetailFragment) {
            ProductDetailFragment_MembersInjector.injectViewModelFactory(productDetailFragment, (ViewModelProvider.Factory) DaggerAppComponent.this.appViewModelFactoryProvider.get());
            ProductDetailFragment_MembersInjector.injectSessionManager(productDetailFragment, (SessionManager) DaggerAppComponent.this.sessionManagerProvider.get());
            return productDetailFragment;
        }
    }

    private final class AuctionSalesListFragmentSubcomponentBuilder extends FragmentModule_ContributeAuctionSalesList$app_productionRelease.AuctionSalesListFragmentSubcomponent.Builder {
        private AuctionSalesListFragment seedInstance;

        private AuctionSalesListFragmentSubcomponentBuilder() {
        }

        public FragmentModule_ContributeAuctionSalesList$app_productionRelease.AuctionSalesListFragmentSubcomponent build() {
            if (this.seedInstance != null) {
                return new AuctionSalesListFragmentSubcomponentImpl(this);
            }
            throw new IllegalStateException(AuctionSalesListFragment.class.getCanonicalName() + " must be set");
        }

        public void seedInstance(AuctionSalesListFragment auctionSalesListFragment) {
            this.seedInstance = (AuctionSalesListFragment) Preconditions.checkNotNull(auctionSalesListFragment);
        }
    }

    private final class AuctionSalesListFragmentSubcomponentImpl implements FragmentModule_ContributeAuctionSalesList$app_productionRelease.AuctionSalesListFragmentSubcomponent {
        private AuctionSalesListFragmentSubcomponentImpl(AuctionSalesListFragmentSubcomponentBuilder auctionSalesListFragmentSubcomponentBuilder) {
        }

        public void inject(AuctionSalesListFragment auctionSalesListFragment) {
            injectAuctionSalesListFragment(auctionSalesListFragment);
        }

        @CanIgnoreReturnValue
        private AuctionSalesListFragment injectAuctionSalesListFragment(AuctionSalesListFragment auctionSalesListFragment) {
            AuctionSalesListFragment_MembersInjector.injectSessionManager(auctionSalesListFragment, (SessionManager) DaggerAppComponent.this.sessionManagerProvider.get());
            return auctionSalesListFragment;
        }
    }

    private final class AuctionMainListFragmentSubcomponentBuilder extends FragmentModule_ContributeAuctionMainList$app_productionRelease.AuctionMainListFragmentSubcomponent.Builder {
        private AuctionMainListFragment seedInstance;

        private AuctionMainListFragmentSubcomponentBuilder() {
        }

        public FragmentModule_ContributeAuctionMainList$app_productionRelease.AuctionMainListFragmentSubcomponent build() {
            if (this.seedInstance != null) {
                return new AuctionMainListFragmentSubcomponentImpl(this);
            }
            throw new IllegalStateException(AuctionMainListFragment.class.getCanonicalName() + " must be set");
        }

        public void seedInstance(AuctionMainListFragment auctionMainListFragment) {
            this.seedInstance = (AuctionMainListFragment) Preconditions.checkNotNull(auctionMainListFragment);
        }
    }

    private final class AuctionMainListFragmentSubcomponentImpl implements FragmentModule_ContributeAuctionMainList$app_productionRelease.AuctionMainListFragmentSubcomponent {
        private AuctionMainListFragmentSubcomponentImpl(AuctionMainListFragmentSubcomponentBuilder auctionMainListFragmentSubcomponentBuilder) {
        }

        public void inject(AuctionMainListFragment auctionMainListFragment) {
            injectAuctionMainListFragment(auctionMainListFragment);
        }

        @CanIgnoreReturnValue
        private AuctionMainListFragment injectAuctionMainListFragment(AuctionMainListFragment auctionMainListFragment) {
            AuctionMainListFragment_MembersInjector.injectSessionManager(auctionMainListFragment, (SessionManager) DaggerAppComponent.this.sessionManagerProvider.get());
            return auctionMainListFragment;
        }
    }

    private final class PreBidFragmentSubcomponentBuilder extends FragmentModule_ContributePreBid$app_productionRelease.PreBidFragmentSubcomponent.Builder {
        private PreBidFragment seedInstance;

        private PreBidFragmentSubcomponentBuilder() {
        }

        public FragmentModule_ContributePreBid$app_productionRelease.PreBidFragmentSubcomponent build() {
            if (this.seedInstance != null) {
                return new PreBidFragmentSubcomponentImpl(this);
            }
            throw new IllegalStateException(PreBidFragment.class.getCanonicalName() + " must be set");
        }

        public void seedInstance(PreBidFragment preBidFragment) {
            this.seedInstance = (PreBidFragment) Preconditions.checkNotNull(preBidFragment);
        }
    }

    private final class PreBidFragmentSubcomponentImpl implements FragmentModule_ContributePreBid$app_productionRelease.PreBidFragmentSubcomponent {
        private PreBidFragmentSubcomponentImpl(PreBidFragmentSubcomponentBuilder preBidFragmentSubcomponentBuilder) {
        }

        public void inject(PreBidFragment preBidFragment) {
            injectPreBidFragment(preBidFragment);
        }

        @CanIgnoreReturnValue
        private PreBidFragment injectPreBidFragment(PreBidFragment preBidFragment) {
            PreBidFragment_MembersInjector.injectViewModelFactory(preBidFragment, (ViewModelProvider.Factory) DaggerAppComponent.this.appViewModelFactoryProvider.get());
            PreBidFragment_MembersInjector.injectSessionManager(preBidFragment, (SessionManager) DaggerAppComponent.this.sessionManagerProvider.get());
            return preBidFragment;
        }
    }

    private final class ViewPagerFragmentSubcomponentBuilder extends FragmentModule_ContributeViewPager$app_productionRelease.ViewPagerFragmentSubcomponent.Builder {
        private ViewPagerFragment seedInstance;

        private ViewPagerFragmentSubcomponentBuilder() {
        }

        public FragmentModule_ContributeViewPager$app_productionRelease.ViewPagerFragmentSubcomponent build() {
            if (this.seedInstance != null) {
                return new ViewPagerFragmentSubcomponentImpl(this);
            }
            throw new IllegalStateException(ViewPagerFragment.class.getCanonicalName() + " must be set");
        }

        public void seedInstance(ViewPagerFragment viewPagerFragment) {
            this.seedInstance = (ViewPagerFragment) Preconditions.checkNotNull(viewPagerFragment);
        }
    }

    private final class ViewPagerFragmentSubcomponentImpl implements FragmentModule_ContributeViewPager$app_productionRelease.ViewPagerFragmentSubcomponent {
        private ViewPagerFragmentSubcomponentImpl(ViewPagerFragmentSubcomponentBuilder viewPagerFragmentSubcomponentBuilder) {
        }

        public void inject(ViewPagerFragment viewPagerFragment) {
            injectViewPagerFragment(viewPagerFragment);
        }

        @CanIgnoreReturnValue
        private ViewPagerFragment injectViewPagerFragment(ViewPagerFragment viewPagerFragment) {
            ViewPagerFragment_MembersInjector.injectViewModelFactory(viewPagerFragment, (ViewModelProvider.Factory) DaggerAppComponent.this.appViewModelFactoryProvider.get());
            ViewPagerFragment_MembersInjector.injectSessionManager(viewPagerFragment, (SessionManager) DaggerAppComponent.this.sessionManagerProvider.get());
            return viewPagerFragment;
        }
    }

    private final class BuyNowFragmentSubcomponentBuilder extends FragmentModule_ContributeBuyNow$app_productionRelease.BuyNowFragmentSubcomponent.Builder {
        private BuyNowFragment seedInstance;

        private BuyNowFragmentSubcomponentBuilder() {
        }

        public FragmentModule_ContributeBuyNow$app_productionRelease.BuyNowFragmentSubcomponent build() {
            if (this.seedInstance != null) {
                return new BuyNowFragmentSubcomponentImpl(this);
            }
            throw new IllegalStateException(BuyNowFragment.class.getCanonicalName() + " must be set");
        }

        public void seedInstance(BuyNowFragment buyNowFragment) {
            this.seedInstance = (BuyNowFragment) Preconditions.checkNotNull(buyNowFragment);
        }
    }

    private final class BuyNowFragmentSubcomponentImpl implements FragmentModule_ContributeBuyNow$app_productionRelease.BuyNowFragmentSubcomponent {
        private BuyNowFragmentSubcomponentImpl(BuyNowFragmentSubcomponentBuilder buyNowFragmentSubcomponentBuilder) {
        }

        public void inject(BuyNowFragment buyNowFragment) {
            injectBuyNowFragment(buyNowFragment);
        }

        @CanIgnoreReturnValue
        private BuyNowFragment injectBuyNowFragment(BuyNowFragment buyNowFragment) {
            BuyNowFragment_MembersInjector.injectViewModelFactory(buyNowFragment, (ViewModelProvider.Factory) DaggerAppComponent.this.appViewModelFactoryProvider.get());
            BuyNowFragment_MembersInjector.injectSessionManager(buyNowFragment, (SessionManager) DaggerAppComponent.this.sessionManagerProvider.get());
            return buyNowFragment;
        }
    }

    private final class CostCalculatorFragmentSubcomponentBuilder extends FragmentModule_ContributeCostCalculator$app_productionRelease.CostCalculatorFragmentSubcomponent.Builder {
        private CostCalculatorFragment seedInstance;

        private CostCalculatorFragmentSubcomponentBuilder() {
        }

        public FragmentModule_ContributeCostCalculator$app_productionRelease.CostCalculatorFragmentSubcomponent build() {
            if (this.seedInstance != null) {
                return new CostCalculatorFragmentSubcomponentImpl(this);
            }
            throw new IllegalStateException(CostCalculatorFragment.class.getCanonicalName() + " must be set");
        }

        public void seedInstance(CostCalculatorFragment costCalculatorFragment) {
            this.seedInstance = (CostCalculatorFragment) Preconditions.checkNotNull(costCalculatorFragment);
        }
    }

    private final class CostCalculatorFragmentSubcomponentImpl implements FragmentModule_ContributeCostCalculator$app_productionRelease.CostCalculatorFragmentSubcomponent {
        private CostCalculatorFragmentSubcomponentImpl(CostCalculatorFragmentSubcomponentBuilder costCalculatorFragmentSubcomponentBuilder) {
        }

        public void inject(CostCalculatorFragment costCalculatorFragment) {
            injectCostCalculatorFragment(costCalculatorFragment);
        }

        @CanIgnoreReturnValue
        private CostCalculatorFragment injectCostCalculatorFragment(CostCalculatorFragment costCalculatorFragment) {
            CostCalculatorFragment_MembersInjector.injectViewModelFactory(costCalculatorFragment, (ViewModelProvider.Factory) DaggerAppComponent.this.appViewModelFactoryProvider.get());
            return costCalculatorFragment;
        }
    }

    private final class ChromeSectionFragmentSubcomponentBuilder extends FragmentModule_ContributeChromeSection$app_productionRelease.ChromeSectionFragmentSubcomponent.Builder {
        private ChromeSectionFragment seedInstance;

        private ChromeSectionFragmentSubcomponentBuilder() {
        }

        public FragmentModule_ContributeChromeSection$app_productionRelease.ChromeSectionFragmentSubcomponent build() {
            if (this.seedInstance != null) {
                return new ChromeSectionFragmentSubcomponentImpl(this);
            }
            throw new IllegalStateException(ChromeSectionFragment.class.getCanonicalName() + " must be set");
        }

        public void seedInstance(ChromeSectionFragment chromeSectionFragment) {
            this.seedInstance = (ChromeSectionFragment) Preconditions.checkNotNull(chromeSectionFragment);
        }
    }

    private final class ChromeSectionFragmentSubcomponentImpl implements FragmentModule_ContributeChromeSection$app_productionRelease.ChromeSectionFragmentSubcomponent {
        private ChromeSectionFragmentSubcomponentImpl(ChromeSectionFragmentSubcomponentBuilder chromeSectionFragmentSubcomponentBuilder) {
        }

        public void inject(ChromeSectionFragment chromeSectionFragment) {
            injectChromeSectionFragment(chromeSectionFragment);
        }

        @CanIgnoreReturnValue
        private ChromeSectionFragment injectChromeSectionFragment(ChromeSectionFragment chromeSectionFragment) {
            ChromeSectionFragment_MembersInjector.injectViewModelFactory(chromeSectionFragment, (ViewModelProvider.Factory) DaggerAppComponent.this.appViewModelFactoryProvider.get());
            return chromeSectionFragment;
        }
    }

    private final class QuickLinksFragmentSubcomponentBuilder extends FragmentModule_ContributeFindVehicle$app_productionRelease.QuickLinksFragmentSubcomponent.Builder {
        private QuickLinksFragment seedInstance;

        private QuickLinksFragmentSubcomponentBuilder() {
        }

        public FragmentModule_ContributeFindVehicle$app_productionRelease.QuickLinksFragmentSubcomponent build() {
            if (this.seedInstance != null) {
                return new QuickLinksFragmentSubcomponentImpl(this);
            }
            throw new IllegalStateException(QuickLinksFragment.class.getCanonicalName() + " must be set");
        }

        public void seedInstance(QuickLinksFragment quickLinksFragment) {
            this.seedInstance = (QuickLinksFragment) Preconditions.checkNotNull(quickLinksFragment);
        }
    }

    private final class QuickLinksFragmentSubcomponentImpl implements FragmentModule_ContributeFindVehicle$app_productionRelease.QuickLinksFragmentSubcomponent {
        private QuickLinksFragmentSubcomponentImpl(QuickLinksFragmentSubcomponentBuilder quickLinksFragmentSubcomponentBuilder) {
        }

        public void inject(QuickLinksFragment quickLinksFragment) {
            injectQuickLinksFragment(quickLinksFragment);
        }

        @CanIgnoreReturnValue
        private QuickLinksFragment injectQuickLinksFragment(QuickLinksFragment quickLinksFragment) {
            QuickLinksFragment_MembersInjector.injectViewModelFactory(quickLinksFragment, (ViewModelProvider.Factory) DaggerAppComponent.this.appViewModelFactoryProvider.get());
            return quickLinksFragment;
        }
    }

    private final class SearchByAuctionFragmentSubcomponentBuilder extends FragmentModule_ContributeSearchByAuction$app_productionRelease.SearchByAuctionFragmentSubcomponent.Builder {
        private SearchByAuctionFragment seedInstance;

        private SearchByAuctionFragmentSubcomponentBuilder() {
        }

        public FragmentModule_ContributeSearchByAuction$app_productionRelease.SearchByAuctionFragmentSubcomponent build() {
            if (this.seedInstance != null) {
                return new SearchByAuctionFragmentSubcomponentImpl(this);
            }
            throw new IllegalStateException(SearchByAuctionFragment.class.getCanonicalName() + " must be set");
        }

        public void seedInstance(SearchByAuctionFragment searchByAuctionFragment) {
            this.seedInstance = (SearchByAuctionFragment) Preconditions.checkNotNull(searchByAuctionFragment);
        }
    }

    private final class SearchByAuctionFragmentSubcomponentImpl implements FragmentModule_ContributeSearchByAuction$app_productionRelease.SearchByAuctionFragmentSubcomponent {
        public void inject(SearchByAuctionFragment searchByAuctionFragment) {
        }

        private SearchByAuctionFragmentSubcomponentImpl(SearchByAuctionFragmentSubcomponentBuilder searchByAuctionFragmentSubcomponentBuilder) {
        }
    }

    private final class SearchByVehicleFragmentSubcomponentBuilder extends FragmentModule_ContributeSearchByVehicle$app_productionRelease.SearchByVehicleFragmentSubcomponent.Builder {
        private SearchByVehicleFragment seedInstance;

        private SearchByVehicleFragmentSubcomponentBuilder() {
        }

        public FragmentModule_ContributeSearchByVehicle$app_productionRelease.SearchByVehicleFragmentSubcomponent build() {
            if (this.seedInstance != null) {
                return new SearchByVehicleFragmentSubcomponentImpl(this);
            }
            throw new IllegalStateException(SearchByVehicleFragment.class.getCanonicalName() + " must be set");
        }

        public void seedInstance(SearchByVehicleFragment searchByVehicleFragment) {
            this.seedInstance = (SearchByVehicleFragment) Preconditions.checkNotNull(searchByVehicleFragment);
        }
    }

    private final class SearchByVehicleFragmentSubcomponentImpl implements FragmentModule_ContributeSearchByVehicle$app_productionRelease.SearchByVehicleFragmentSubcomponent {
        private SearchByVehicleFragmentSubcomponentImpl(SearchByVehicleFragmentSubcomponentBuilder searchByVehicleFragmentSubcomponentBuilder) {
        }

        public void inject(SearchByVehicleFragment searchByVehicleFragment) {
            injectSearchByVehicleFragment(searchByVehicleFragment);
        }

        @CanIgnoreReturnValue
        private SearchByVehicleFragment injectSearchByVehicleFragment(SearchByVehicleFragment searchByVehicleFragment) {
            SearchByVehicleFragment_MembersInjector.injectViewModelFactory(searchByVehicleFragment, (ViewModelProvider.Factory) DaggerAppComponent.this.appViewModelFactoryProvider.get());
            SearchByVehicleFragment_MembersInjector.injectSessionManager(searchByVehicleFragment, (SessionManager) DaggerAppComponent.this.sessionManagerProvider.get());
            return searchByVehicleFragment;
        }
    }

    private final class SearchResultListFragmentSubcomponentBuilder extends C2882xf1800fef.SearchResultListFragmentSubcomponent.Builder {
        private SearchResultListFragment seedInstance;

        private SearchResultListFragmentSubcomponentBuilder() {
        }

        public C2882xf1800fef.SearchResultListFragmentSubcomponent build() {
            if (this.seedInstance != null) {
                return new SearchResultListFragmentSubcomponentImpl(this);
            }
            throw new IllegalStateException(SearchResultListFragment.class.getCanonicalName() + " must be set");
        }

        public void seedInstance(SearchResultListFragment searchResultListFragment) {
            this.seedInstance = (SearchResultListFragment) Preconditions.checkNotNull(searchResultListFragment);
        }
    }

    private final class SearchResultListFragmentSubcomponentImpl implements C2882xf1800fef.SearchResultListFragmentSubcomponent {
        private SearchResultListFragmentSubcomponentImpl(SearchResultListFragmentSubcomponentBuilder searchResultListFragmentSubcomponentBuilder) {
        }

        public void inject(SearchResultListFragment searchResultListFragment) {
            injectSearchResultListFragment(searchResultListFragment);
        }

        @CanIgnoreReturnValue
        private SearchResultListFragment injectSearchResultListFragment(SearchResultListFragment searchResultListFragment) {
            SearchResultListFragment_MembersInjector.injectViewModelFactory(searchResultListFragment, (ViewModelProvider.Factory) DaggerAppComponent.this.appViewModelFactoryProvider.get());
            SearchResultListFragment_MembersInjector.injectSessionManager(searchResultListFragment, (SessionManager) DaggerAppComponent.this.sessionManagerProvider.get());
            return searchResultListFragment;
        }
    }

    private final class FilterFragmentSubcomponentBuilder extends FragmentModule_ContributeFilterFragment$app_productionRelease.FilterFragmentSubcomponent.Builder {
        private FilterFragment seedInstance;

        private FilterFragmentSubcomponentBuilder() {
        }

        public FragmentModule_ContributeFilterFragment$app_productionRelease.FilterFragmentSubcomponent build() {
            if (this.seedInstance != null) {
                return new FilterFragmentSubcomponentImpl(this);
            }
            throw new IllegalStateException(FilterFragment.class.getCanonicalName() + " must be set");
        }

        public void seedInstance(FilterFragment filterFragment) {
            this.seedInstance = (FilterFragment) Preconditions.checkNotNull(filterFragment);
        }
    }

    private final class FilterFragmentSubcomponentImpl implements FragmentModule_ContributeFilterFragment$app_productionRelease.FilterFragmentSubcomponent {
        private FilterFragmentSubcomponentImpl(FilterFragmentSubcomponentBuilder filterFragmentSubcomponentBuilder) {
        }

        public void inject(FilterFragment filterFragment) {
            injectFilterFragment(filterFragment);
        }

        @CanIgnoreReturnValue
        private FilterFragment injectFilterFragment(FilterFragment filterFragment) {
            FilterFragment_MembersInjector.injectViewModelFactory(filterFragment, (ViewModelProvider.Factory) DaggerAppComponent.this.appViewModelFactoryProvider.get());
            FilterFragment_MembersInjector.injectSessionManager(filterFragment, (SessionManager) DaggerAppComponent.this.sessionManagerProvider.get());
            return filterFragment;
        }
    }

    private final class RecommendedVehiclesFragmentSubcomponentBuilder extends C2879x16e3ea2e.RecommendedVehiclesFragmentSubcomponent.Builder {
        private RecommendedVehiclesFragment seedInstance;

        private RecommendedVehiclesFragmentSubcomponentBuilder() {
        }

        public C2879x16e3ea2e.RecommendedVehiclesFragmentSubcomponent build() {
            if (this.seedInstance != null) {
                return new RecommendedVehiclesFragmentSubcomponentImpl(this);
            }
            throw new IllegalStateException(RecommendedVehiclesFragment.class.getCanonicalName() + " must be set");
        }

        public void seedInstance(RecommendedVehiclesFragment recommendedVehiclesFragment) {
            this.seedInstance = (RecommendedVehiclesFragment) Preconditions.checkNotNull(recommendedVehiclesFragment);
        }
    }

    private final class RecommendedVehiclesFragmentSubcomponentImpl implements C2879x16e3ea2e.RecommendedVehiclesFragmentSubcomponent {
        public void inject(RecommendedVehiclesFragment recommendedVehiclesFragment) {
        }

        private RecommendedVehiclesFragmentSubcomponentImpl(RecommendedVehiclesFragmentSubcomponentBuilder recommendedVehiclesFragmentSubcomponentBuilder) {
        }
    }

    private final class LandingViewPagerFragmentSubcomponentBuilder extends C2877x93a7a693.LandingViewPagerFragmentSubcomponent.Builder {
        private LandingViewPagerFragment seedInstance;

        private LandingViewPagerFragmentSubcomponentBuilder() {
        }

        public C2877x93a7a693.LandingViewPagerFragmentSubcomponent build() {
            if (this.seedInstance != null) {
                return new LandingViewPagerFragmentSubcomponentImpl(this);
            }
            throw new IllegalStateException(LandingViewPagerFragment.class.getCanonicalName() + " must be set");
        }

        public void seedInstance(LandingViewPagerFragment landingViewPagerFragment) {
            this.seedInstance = (LandingViewPagerFragment) Preconditions.checkNotNull(landingViewPagerFragment);
        }
    }

    private final class LandingViewPagerFragmentSubcomponentImpl implements C2877x93a7a693.LandingViewPagerFragmentSubcomponent {
        private LandingViewPagerFragmentSubcomponentImpl(LandingViewPagerFragmentSubcomponentBuilder landingViewPagerFragmentSubcomponentBuilder) {
        }

        public void inject(LandingViewPagerFragment landingViewPagerFragment) {
            injectLandingViewPagerFragment(landingViewPagerFragment);
        }

        @CanIgnoreReturnValue
        private LandingViewPagerFragment injectLandingViewPagerFragment(LandingViewPagerFragment landingViewPagerFragment) {
            LandingViewPagerFragment_MembersInjector.injectSessionManager(landingViewPagerFragment, (SessionManager) DaggerAppComponent.this.sessionManagerProvider.get());
            return landingViewPagerFragment;
        }
    }

    private final class SelectCreditCardFragmentSubcomponentBuilder extends C2883x76239e11.SelectCreditCardFragmentSubcomponent.Builder {
        private SelectCreditCardFragment seedInstance;

        private SelectCreditCardFragmentSubcomponentBuilder() {
        }

        public C2883x76239e11.SelectCreditCardFragmentSubcomponent build() {
            if (this.seedInstance != null) {
                return new SelectCreditCardFragmentSubcomponentImpl(this);
            }
            throw new IllegalStateException(SelectCreditCardFragment.class.getCanonicalName() + " must be set");
        }

        public void seedInstance(SelectCreditCardFragment selectCreditCardFragment) {
            this.seedInstance = (SelectCreditCardFragment) Preconditions.checkNotNull(selectCreditCardFragment);
        }
    }

    private final class SelectCreditCardFragmentSubcomponentImpl implements C2883x76239e11.SelectCreditCardFragmentSubcomponent {
        public void inject(SelectCreditCardFragment selectCreditCardFragment) {
        }

        private SelectCreditCardFragmentSubcomponentImpl(SelectCreditCardFragmentSubcomponentBuilder selectCreditCardFragmentSubcomponentBuilder) {
        }
    }

    private final class BDTToBePaidFragmentSubcomponentBuilder extends C2884xb2f399f8.BDTToBePaidFragmentSubcomponent.Builder {
        private BDTToBePaidFragment seedInstance;

        private BDTToBePaidFragmentSubcomponentBuilder() {
        }

        public C2884xb2f399f8.BDTToBePaidFragmentSubcomponent build() {
            if (this.seedInstance != null) {
                return new BDTToBePaidFragmentSubcomponentImpl(this);
            }
            throw new IllegalStateException(BDTToBePaidFragment.class.getCanonicalName() + " must be set");
        }

        public void seedInstance(BDTToBePaidFragment bDTToBePaidFragment) {
            this.seedInstance = (BDTToBePaidFragment) Preconditions.checkNotNull(bDTToBePaidFragment);
        }
    }

    private final class BDTToBePaidFragmentSubcomponentImpl implements C2884xb2f399f8.BDTToBePaidFragmentSubcomponent {
        private BDTToBePaidFragmentSubcomponentImpl(BDTToBePaidFragmentSubcomponentBuilder bDTToBePaidFragmentSubcomponentBuilder) {
        }

        public void inject(BDTToBePaidFragment bDTToBePaidFragment) {
            injectBDTToBePaidFragment(bDTToBePaidFragment);
        }

        @CanIgnoreReturnValue
        private BDTToBePaidFragment injectBDTToBePaidFragment(BDTToBePaidFragment bDTToBePaidFragment) {
            BDTToBePaidFragment_MembersInjector.injectViewModelFactory(bDTToBePaidFragment, (ViewModelProvider.Factory) DaggerAppComponent.this.appViewModelFactoryProvider.get());
            BDTToBePaidFragment_MembersInjector.injectSessionManager(bDTToBePaidFragment, (SessionManager) DaggerAppComponent.this.sessionManagerProvider.get());
            return bDTToBePaidFragment;
        }
    }

    private final class ManageOfferListFragmentSubcomponentBuilder extends C2878x2357de1.ManageOfferListFragmentSubcomponent.Builder {
        private ManageOfferListFragment seedInstance;

        private ManageOfferListFragmentSubcomponentBuilder() {
        }

        public C2878x2357de1.ManageOfferListFragmentSubcomponent build() {
            if (this.seedInstance != null) {
                return new ManageOfferListFragmentSubcomponentImpl(this);
            }
            throw new IllegalStateException(ManageOfferListFragment.class.getCanonicalName() + " must be set");
        }

        public void seedInstance(ManageOfferListFragment manageOfferListFragment) {
            this.seedInstance = (ManageOfferListFragment) Preconditions.checkNotNull(manageOfferListFragment);
        }
    }

    private final class ManageOfferListFragmentSubcomponentImpl implements C2878x2357de1.ManageOfferListFragmentSubcomponent {
        private ManageOfferListFragmentSubcomponentImpl(ManageOfferListFragmentSubcomponentBuilder manageOfferListFragmentSubcomponentBuilder) {
        }

        public void inject(ManageOfferListFragment manageOfferListFragment) {
            injectManageOfferListFragment(manageOfferListFragment);
        }

        @CanIgnoreReturnValue
        private ManageOfferListFragment injectManageOfferListFragment(ManageOfferListFragment manageOfferListFragment) {
            ManageOfferListFragment_MembersInjector.injectSessionManager(manageOfferListFragment, (SessionManager) DaggerAppComponent.this.sessionManagerProvider.get());
            return manageOfferListFragment;
        }
    }

    private final class PreSaleListFragmentSubcomponentBuilder extends FragmentModule_ContributeWatchListFragment$app_productionRelease.PreSaleListFragmentSubcomponent.Builder {
        private PreSaleListFragment seedInstance;

        private PreSaleListFragmentSubcomponentBuilder() {
        }

        public FragmentModule_ContributeWatchListFragment$app_productionRelease.PreSaleListFragmentSubcomponent build() {
            if (this.seedInstance != null) {
                return new PreSaleListFragmentSubcomponentImpl(this);
            }
            throw new IllegalStateException(PreSaleListFragment.class.getCanonicalName() + " must be set");
        }

        public void seedInstance(PreSaleListFragment preSaleListFragment) {
            this.seedInstance = (PreSaleListFragment) Preconditions.checkNotNull(preSaleListFragment);
        }
    }

    private final class PreSaleListFragmentSubcomponentImpl implements FragmentModule_ContributeWatchListFragment$app_productionRelease.PreSaleListFragmentSubcomponent {
        private PreSaleListFragmentSubcomponentImpl(PreSaleListFragmentSubcomponentBuilder preSaleListFragmentSubcomponentBuilder) {
        }

        public void inject(PreSaleListFragment preSaleListFragment) {
            injectPreSaleListFragment(preSaleListFragment);
        }

        @CanIgnoreReturnValue
        private PreSaleListFragment injectPreSaleListFragment(PreSaleListFragment preSaleListFragment) {
            PreSaleListFragment_MembersInjector.injectViewModelFactory(preSaleListFragment, (ViewModelProvider.Factory) DaggerAppComponent.this.appViewModelFactoryProvider.get());
            PreSaleListFragment_MembersInjector.injectSessionManager(preSaleListFragment, (SessionManager) DaggerAppComponent.this.sessionManagerProvider.get());
            return preSaleListFragment;
        }
    }

    private final class MyListFragmentSubcomponentBuilder extends FragmentModule_ContributeMyListFragment$app_productionRelease.MyListFragmentSubcomponent.Builder {
        private MyListFragment seedInstance;

        private MyListFragmentSubcomponentBuilder() {
        }

        public FragmentModule_ContributeMyListFragment$app_productionRelease.MyListFragmentSubcomponent build() {
            if (this.seedInstance != null) {
                return new MyListFragmentSubcomponentImpl(this);
            }
            throw new IllegalStateException(MyListFragment.class.getCanonicalName() + " must be set");
        }

        public void seedInstance(MyListFragment myListFragment) {
            this.seedInstance = (MyListFragment) Preconditions.checkNotNull(myListFragment);
        }
    }

    private final class MyListFragmentSubcomponentImpl implements FragmentModule_ContributeMyListFragment$app_productionRelease.MyListFragmentSubcomponent {
        private MyListFragmentSubcomponentImpl(MyListFragmentSubcomponentBuilder myListFragmentSubcomponentBuilder) {
        }

        public void inject(MyListFragment myListFragment) {
            injectMyListFragment(myListFragment);
        }

        @CanIgnoreReturnValue
        private MyListFragment injectMyListFragment(MyListFragment myListFragment) {
            MyListFragment_MembersInjector.injectSessionManager(myListFragment, (SessionManager) DaggerAppComponent.this.sessionManagerProvider.get());
            return myListFragment;
        }
    }

    private final class AccountSettingFragmentSubcomponentBuilder extends C2872x8eb16d2f.AccountSettingFragmentSubcomponent.Builder {
        private AccountSettingFragment seedInstance;

        private AccountSettingFragmentSubcomponentBuilder() {
        }

        public C2872x8eb16d2f.AccountSettingFragmentSubcomponent build() {
            if (this.seedInstance != null) {
                return new AccountSettingFragmentSubcomponentImpl(this);
            }
            throw new IllegalStateException(AccountSettingFragment.class.getCanonicalName() + " must be set");
        }

        public void seedInstance(AccountSettingFragment accountSettingFragment) {
            this.seedInstance = (AccountSettingFragment) Preconditions.checkNotNull(accountSettingFragment);
        }
    }

    private final class AccountSettingFragmentSubcomponentImpl implements C2872x8eb16d2f.AccountSettingFragmentSubcomponent {
        private AccountSettingFragmentSubcomponentImpl(AccountSettingFragmentSubcomponentBuilder accountSettingFragmentSubcomponentBuilder) {
        }

        public void inject(AccountSettingFragment accountSettingFragment) {
            injectAccountSettingFragment(accountSettingFragment);
        }

        @CanIgnoreReturnValue
        private AccountSettingFragment injectAccountSettingFragment(AccountSettingFragment accountSettingFragment) {
            AccountSettingFragment_MembersInjector.injectSessionManager(accountSettingFragment, (SessionManager) DaggerAppComponent.this.sessionManagerProvider.get());
            return accountSettingFragment;
        }
    }

    private final class ToBePaidReviewFragmentSubcomponentBuilder extends C2886xfdee3d8e.ToBePaidReviewFragmentSubcomponent.Builder {
        private ToBePaidReviewFragment seedInstance;

        private ToBePaidReviewFragmentSubcomponentBuilder() {
        }

        public C2886xfdee3d8e.ToBePaidReviewFragmentSubcomponent build() {
            if (this.seedInstance != null) {
                return new ToBePaidReviewFragmentSubcomponentImpl(this);
            }
            throw new IllegalStateException(ToBePaidReviewFragment.class.getCanonicalName() + " must be set");
        }

        public void seedInstance(ToBePaidReviewFragment toBePaidReviewFragment) {
            this.seedInstance = (ToBePaidReviewFragment) Preconditions.checkNotNull(toBePaidReviewFragment);
        }
    }

    private final class ToBePaidReviewFragmentSubcomponentImpl implements C2886xfdee3d8e.ToBePaidReviewFragmentSubcomponent {
        private ToBePaidReviewFragmentSubcomponentImpl(ToBePaidReviewFragmentSubcomponentBuilder toBePaidReviewFragmentSubcomponentBuilder) {
        }

        public void inject(ToBePaidReviewFragment toBePaidReviewFragment) {
            injectToBePaidReviewFragment(toBePaidReviewFragment);
        }

        @CanIgnoreReturnValue
        private ToBePaidReviewFragment injectToBePaidReviewFragment(ToBePaidReviewFragment toBePaidReviewFragment) {
            ToBePaidReviewFragment_MembersInjector.injectSessionManager(toBePaidReviewFragment, (SessionManager) DaggerAppComponent.this.sessionManagerProvider.get());
            ToBePaidReviewFragment_MembersInjector.injectViewModelFactory(toBePaidReviewFragment, (ViewModelProvider.Factory) DaggerAppComponent.this.appViewModelFactoryProvider.get());
            return toBePaidReviewFragment;
        }
    }

    private final class ToBePaidConfirmationFragmentSubcomponentBuilder extends C2885x2d128e2b.ToBePaidConfirmationFragmentSubcomponent.Builder {
        private ToBePaidConfirmationFragment seedInstance;

        private ToBePaidConfirmationFragmentSubcomponentBuilder() {
        }

        public C2885x2d128e2b.ToBePaidConfirmationFragmentSubcomponent build() {
            if (this.seedInstance != null) {
                return new ToBePaidConfirmationFragmentSubcomponentImpl(this);
            }
            throw new IllegalStateException(ToBePaidConfirmationFragment.class.getCanonicalName() + " must be set");
        }

        public void seedInstance(ToBePaidConfirmationFragment toBePaidConfirmationFragment) {
            this.seedInstance = (ToBePaidConfirmationFragment) Preconditions.checkNotNull(toBePaidConfirmationFragment);
        }
    }

    private final class ToBePaidConfirmationFragmentSubcomponentImpl implements C2885x2d128e2b.ToBePaidConfirmationFragmentSubcomponent {
        public void inject(ToBePaidConfirmationFragment toBePaidConfirmationFragment) {
        }

        private ToBePaidConfirmationFragmentSubcomponentImpl(ToBePaidConfirmationFragmentSubcomponentBuilder toBePaidConfirmationFragmentSubcomponentBuilder) {
        }
    }

    private final class BuyNowOfferListFragmentSubcomponentBuilder extends C2873x6a2e7676.BuyNowOfferListFragmentSubcomponent.Builder {
        private BuyNowOfferListFragment seedInstance;

        private BuyNowOfferListFragmentSubcomponentBuilder() {
        }

        public C2873x6a2e7676.BuyNowOfferListFragmentSubcomponent build() {
            if (this.seedInstance != null) {
                return new BuyNowOfferListFragmentSubcomponentImpl(this);
            }
            throw new IllegalStateException(BuyNowOfferListFragment.class.getCanonicalName() + " must be set");
        }

        public void seedInstance(BuyNowOfferListFragment buyNowOfferListFragment) {
            this.seedInstance = (BuyNowOfferListFragment) Preconditions.checkNotNull(buyNowOfferListFragment);
        }
    }

    private final class BuyNowOfferListFragmentSubcomponentImpl implements C2873x6a2e7676.BuyNowOfferListFragmentSubcomponent {
        private BuyNowOfferListFragmentSubcomponentImpl(BuyNowOfferListFragmentSubcomponentBuilder buyNowOfferListFragmentSubcomponentBuilder) {
        }

        public void inject(BuyNowOfferListFragment buyNowOfferListFragment) {
            injectBuyNowOfferListFragment(buyNowOfferListFragment);
        }

        @CanIgnoreReturnValue
        private BuyNowOfferListFragment injectBuyNowOfferListFragment(BuyNowOfferListFragment buyNowOfferListFragment) {
            BuyNowOfferListFragment_MembersInjector.injectViewModelFactory(buyNowOfferListFragment, (ViewModelProvider.Factory) DaggerAppComponent.this.appViewModelFactoryProvider.get());
            BuyNowOfferListFragment_MembersInjector.injectSessionManager(buyNowOfferListFragment, (SessionManager) DaggerAppComponent.this.sessionManagerProvider.get());
            return buyNowOfferListFragment;
        }
    }

    private final class ToBePickedUpListFragmentSubcomponentBuilder extends C2887x47b12c83.ToBePickedUpListFragmentSubcomponent.Builder {
        private ToBePickedUpListFragment seedInstance;

        private ToBePickedUpListFragmentSubcomponentBuilder() {
        }

        public C2887x47b12c83.ToBePickedUpListFragmentSubcomponent build() {
            if (this.seedInstance != null) {
                return new ToBePickedUpListFragmentSubcomponentImpl(this);
            }
            throw new IllegalStateException(ToBePickedUpListFragment.class.getCanonicalName() + " must be set");
        }

        public void seedInstance(ToBePickedUpListFragment toBePickedUpListFragment) {
            this.seedInstance = (ToBePickedUpListFragment) Preconditions.checkNotNull(toBePickedUpListFragment);
        }
    }

    private final class ToBePickedUpListFragmentSubcomponentImpl implements C2887x47b12c83.ToBePickedUpListFragmentSubcomponent {
        private ToBePickedUpListFragmentSubcomponentImpl(ToBePickedUpListFragmentSubcomponentBuilder toBePickedUpListFragmentSubcomponentBuilder) {
        }

        public void inject(ToBePickedUpListFragment toBePickedUpListFragment) {
            injectToBePickedUpListFragment(toBePickedUpListFragment);
        }

        @CanIgnoreReturnValue
        private ToBePickedUpListFragment injectToBePickedUpListFragment(ToBePickedUpListFragment toBePickedUpListFragment) {
            ToBePickedUpListFragment_MembersInjector.injectViewModelFactory(toBePickedUpListFragment, (ViewModelProvider.Factory) DaggerAppComponent.this.appViewModelFactoryProvider.get());
            ToBePickedUpListFragment_MembersInjector.injectSessionManager(toBePickedUpListFragment, (SessionManager) DaggerAppComponent.this.sessionManagerProvider.get());
            return toBePickedUpListFragment;
        }
    }

    private final class SalesDocumentFragmentSubcomponentBuilder extends C2881x8adf5b73.SalesDocumentFragmentSubcomponent.Builder {
        private SalesDocumentFragment seedInstance;

        private SalesDocumentFragmentSubcomponentBuilder() {
        }

        public C2881x8adf5b73.SalesDocumentFragmentSubcomponent build() {
            if (this.seedInstance != null) {
                return new SalesDocumentFragmentSubcomponentImpl(this);
            }
            throw new IllegalStateException(SalesDocumentFragment.class.getCanonicalName() + " must be set");
        }

        public void seedInstance(SalesDocumentFragment salesDocumentFragment) {
            this.seedInstance = (SalesDocumentFragment) Preconditions.checkNotNull(salesDocumentFragment);
        }
    }

    private final class SalesDocumentFragmentSubcomponentImpl implements C2881x8adf5b73.SalesDocumentFragmentSubcomponent {
        private SalesDocumentFragmentSubcomponentImpl(SalesDocumentFragmentSubcomponentBuilder salesDocumentFragmentSubcomponentBuilder) {
        }

        public void inject(SalesDocumentFragment salesDocumentFragment) {
            injectSalesDocumentFragment(salesDocumentFragment);
        }

        @CanIgnoreReturnValue
        private SalesDocumentFragment injectSalesDocumentFragment(SalesDocumentFragment salesDocumentFragment) {
            SalesDocumentFragment_MembersInjector.injectViewModelFactory(salesDocumentFragment, (ViewModelProvider.Factory) DaggerAppComponent.this.appViewModelFactoryProvider.get());
            SalesDocumentFragment_MembersInjector.injectSessionManager(salesDocumentFragment, (SessionManager) DaggerAppComponent.this.sessionManagerProvider.get());
            return salesDocumentFragment;
        }
    }

    private final class DeliveryInstructionFragmentSubcomponentBuilder extends C2874x9a4341e6.DeliveryInstructionFragmentSubcomponent.Builder {
        private DeliveryInstructionFragment seedInstance;

        private DeliveryInstructionFragmentSubcomponentBuilder() {
        }

        public C2874x9a4341e6.DeliveryInstructionFragmentSubcomponent build() {
            if (this.seedInstance != null) {
                return new DeliveryInstructionFragmentSubcomponentImpl(this);
            }
            throw new IllegalStateException(DeliveryInstructionFragment.class.getCanonicalName() + " must be set");
        }

        public void seedInstance(DeliveryInstructionFragment deliveryInstructionFragment) {
            this.seedInstance = (DeliveryInstructionFragment) Preconditions.checkNotNull(deliveryInstructionFragment);
        }
    }

    private final class DeliveryInstructionFragmentSubcomponentImpl implements C2874x9a4341e6.DeliveryInstructionFragmentSubcomponent {
        private DeliveryInstructionFragmentSubcomponentImpl(DeliveryInstructionFragmentSubcomponentBuilder deliveryInstructionFragmentSubcomponentBuilder) {
        }

        public void inject(DeliveryInstructionFragment deliveryInstructionFragment) {
            injectDeliveryInstructionFragment(deliveryInstructionFragment);
        }

        @CanIgnoreReturnValue
        private DeliveryInstructionFragment injectDeliveryInstructionFragment(DeliveryInstructionFragment deliveryInstructionFragment) {
            DeliveryInstructionFragment_MembersInjector.injectSessionManager(deliveryInstructionFragment, (SessionManager) DaggerAppComponent.this.sessionManagerProvider.get());
            DeliveryInstructionFragment_MembersInjector.injectViewModelFactory(deliveryInstructionFragment, (ViewModelProvider.Factory) DaggerAppComponent.this.appViewModelFactoryProvider.get());
            return deliveryInstructionFragment;
        }
    }

    private final class InsertRepOrAddFragmentSubcomponentBuilder extends C2876xa481e86.InsertRepOrAddFragmentSubcomponent.Builder {
        private InsertRepOrAddFragment seedInstance;

        private InsertRepOrAddFragmentSubcomponentBuilder() {
        }

        public C2876xa481e86.InsertRepOrAddFragmentSubcomponent build() {
            if (this.seedInstance != null) {
                return new InsertRepOrAddFragmentSubcomponentImpl(this);
            }
            throw new IllegalStateException(InsertRepOrAddFragment.class.getCanonicalName() + " must be set");
        }

        public void seedInstance(InsertRepOrAddFragment insertRepOrAddFragment) {
            this.seedInstance = (InsertRepOrAddFragment) Preconditions.checkNotNull(insertRepOrAddFragment);
        }
    }

    private final class InsertRepOrAddFragmentSubcomponentImpl implements C2876xa481e86.InsertRepOrAddFragmentSubcomponent {
        private InsertRepOrAddFragmentSubcomponentImpl(InsertRepOrAddFragmentSubcomponentBuilder insertRepOrAddFragmentSubcomponentBuilder) {
        }

        public void inject(InsertRepOrAddFragment insertRepOrAddFragment) {
            injectInsertRepOrAddFragment(insertRepOrAddFragment);
        }

        @CanIgnoreReturnValue
        private InsertRepOrAddFragment injectInsertRepOrAddFragment(InsertRepOrAddFragment insertRepOrAddFragment) {
            InsertRepOrAddFragment_MembersInjector.injectViewModelFactory(insertRepOrAddFragment, (ViewModelProvider.Factory) DaggerAppComponent.this.appViewModelFactoryProvider.get());
            InsertRepOrAddFragment_MembersInjector.injectSessionManager(insertRepOrAddFragment, (SessionManager) DaggerAppComponent.this.sessionManagerProvider.get());
            return insertRepOrAddFragment;
        }
    }

    private final class FastSearchFilterFragmentSubcomponentBuilder extends C2875x7d0d59c8.FastSearchFilterFragmentSubcomponent.Builder {
        private FastSearchFilterFragment seedInstance;

        private FastSearchFilterFragmentSubcomponentBuilder() {
        }

        public C2875x7d0d59c8.FastSearchFilterFragmentSubcomponent build() {
            if (this.seedInstance != null) {
                return new FastSearchFilterFragmentSubcomponentImpl(this);
            }
            throw new IllegalStateException(FastSearchFilterFragment.class.getCanonicalName() + " must be set");
        }

        public void seedInstance(FastSearchFilterFragment fastSearchFilterFragment) {
            this.seedInstance = (FastSearchFilterFragment) Preconditions.checkNotNull(fastSearchFilterFragment);
        }
    }

    private final class FastSearchFilterFragmentSubcomponentImpl implements C2875x7d0d59c8.FastSearchFilterFragmentSubcomponent {
        private FastSearchFilterFragmentSubcomponentImpl(FastSearchFilterFragmentSubcomponentBuilder fastSearchFilterFragmentSubcomponentBuilder) {
        }

        public void inject(FastSearchFilterFragment fastSearchFilterFragment) {
            injectFastSearchFilterFragment(fastSearchFilterFragment);
        }

        @CanIgnoreReturnValue
        private FastSearchFilterFragment injectFastSearchFilterFragment(FastSearchFilterFragment fastSearchFilterFragment) {
            FastSearchFilterFragment_MembersInjector.injectViewModelFactory(fastSearchFilterFragment, (ViewModelProvider.Factory) DaggerAppComponent.this.appViewModelFactoryProvider.get());
            FastSearchFilterFragment_MembersInjector.injectSessionManager(fastSearchFilterFragment, (SessionManager) DaggerAppComponent.this.sessionManagerProvider.get());
            return fastSearchFilterFragment;
        }
    }

    private final class RefinerResultFragmentSubcomponentBuilder extends C2880xc39d780e.RefinerResultFragmentSubcomponent.Builder {
        private RefinerResultFragment seedInstance;

        private RefinerResultFragmentSubcomponentBuilder() {
        }

        public C2880xc39d780e.RefinerResultFragmentSubcomponent build() {
            if (this.seedInstance != null) {
                return new RefinerResultFragmentSubcomponentImpl(this);
            }
            throw new IllegalStateException(RefinerResultFragment.class.getCanonicalName() + " must be set");
        }

        public void seedInstance(RefinerResultFragment refinerResultFragment) {
            this.seedInstance = (RefinerResultFragment) Preconditions.checkNotNull(refinerResultFragment);
        }
    }

    private final class RefinerResultFragmentSubcomponentImpl implements C2880xc39d780e.RefinerResultFragmentSubcomponent {
        private RefinerResultFragmentSubcomponentImpl(RefinerResultFragmentSubcomponentBuilder refinerResultFragmentSubcomponentBuilder) {
        }

        public void inject(RefinerResultFragment refinerResultFragment) {
            injectRefinerResultFragment(refinerResultFragment);
        }

        @CanIgnoreReturnValue
        private RefinerResultFragment injectRefinerResultFragment(RefinerResultFragment refinerResultFragment) {
            RefinerResultFragment_MembersInjector.injectSessionManager(refinerResultFragment, (SessionManager) DaggerAppComponent.this.sessionManagerProvider.get());
            RefinerResultFragment_MembersInjector.injectViewModelFactory(refinerResultFragment, (ViewModelProvider.Factory) DaggerAppComponent.this.appViewModelFactoryProvider.get());
            return refinerResultFragment;
        }
    }
}

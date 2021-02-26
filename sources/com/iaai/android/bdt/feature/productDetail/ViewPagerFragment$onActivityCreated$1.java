package com.iaai.android.bdt.feature.productDetail;

import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.core.view.GravityCompat;
import androidx.viewpager.widget.ViewPager;
import com.google.gson.Gson;
import com.iaai.android.C2723R;
import com.iaai.android.bdt.base.BaseActivity;
import com.iaai.android.bdt.feature.account.buyNowOfferList.BuyNowOfferListActivity;
import com.iaai.android.bdt.feature.account.salesdocument.SalesDocumentActivity;
import com.iaai.android.bdt.feature.account.tobepickedup.ToPickedUpAccountActivity;
import com.iaai.android.bdt.feature.account.watchlist.PreSaleListActivity;
import com.iaai.android.bdt.feature.auctionSalesList.AuctionSalesListActivity;
import com.iaai.android.bdt.feature.digitalNegotiation.ManageOfferListActivity;
import com.iaai.android.bdt.feature.fastSearchFilter.refinerResults.RefinerResultActivity;
import com.iaai.android.bdt.feature.findVehiclePage.searchResult.SearchResultActivity;
import com.iaai.android.bdt.feature.myAccount.toBePaid.BDTPaymentActivity;
import com.iaai.android.bdt.model.fastSearch.SearchInputV2;
import com.iaai.android.bdt.model.fastSearchFilter2.FastSearchRequestBody;
import com.iaai.android.bdt.utils.BDTUtils;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo66931bv = {1, 0, 3}, mo66932d1 = {"\u0000!\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J \u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u0005H\u0016J\u0010\u0010\u000b\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\u0005H\u0016¨\u0006\f"}, mo66933d2 = {"com/iaai/android/bdt/feature/productDetail/ViewPagerFragment$onActivityCreated$1", "Landroidx/viewpager/widget/ViewPager$OnPageChangeListener;", "onPageScrollStateChanged", "", "state", "", "onPageScrolled", "position", "positionOffset", "", "positionOffsetPixels", "onPageSelected", "app_productionRelease"}, mo66934k = 1, mo66935mv = {1, 1, 13})
/* compiled from: ViewPagerFragment.kt */
public final class ViewPagerFragment$onActivityCreated$1 implements ViewPager.OnPageChangeListener {
    final /* synthetic */ ArrayList $itemIdList;
    final /* synthetic */ int $totalCount;
    final /* synthetic */ ViewPagerFragment this$0;

    ViewPagerFragment$onActivityCreated$1(ViewPagerFragment viewPagerFragment, int i, ArrayList arrayList) {
        this.this$0 = viewPagerFragment;
        this.$totalCount = i;
        this.$itemIdList = arrayList;
    }

    public void onPageScrolled(int i, float f, int i2) {
        if (ViewPagerFragment.access$getBaseActivity$p(this.this$0) instanceof AuctionSalesListActivity) {
            BaseActivity access$getBaseActivity$p = ViewPagerFragment.access$getBaseActivity$p(this.this$0);
            if (access$getBaseActivity$p != null) {
                AuctionSalesListActivity auctionSalesListActivity = (AuctionSalesListActivity) access$getBaseActivity$p;
                if (this.$totalCount > 1) {
                    if (i == 0) {
                        ImageView imageView = (ImageView) auctionSalesListActivity._$_findCachedViewById(C2723R.C2726id.arrow_left);
                        Intrinsics.checkExpressionValueIsNotNull(imageView, "auctionSalesListActivity.arrow_left");
                        imageView.setVisibility(0);
                        ImageView imageView2 = (ImageView) auctionSalesListActivity._$_findCachedViewById(C2723R.C2726id.arrow_left);
                        Intrinsics.checkExpressionValueIsNotNull(imageView2, "auctionSalesListActivity.arrow_left");
                        imageView2.setEnabled(false);
                        ((ImageView) auctionSalesListActivity._$_findCachedViewById(C2723R.C2726id.arrow_left)).setImageResource(C2723R.C2725drawable.icon_left_arrow_disable);
                    } else {
                        ImageView imageView3 = (ImageView) auctionSalesListActivity._$_findCachedViewById(C2723R.C2726id.arrow_left);
                        Intrinsics.checkExpressionValueIsNotNull(imageView3, "auctionSalesListActivity.arrow_left");
                        imageView3.setVisibility(0);
                        ImageView imageView4 = (ImageView) auctionSalesListActivity._$_findCachedViewById(C2723R.C2726id.arrow_left);
                        Intrinsics.checkExpressionValueIsNotNull(imageView4, "auctionSalesListActivity.arrow_left");
                        imageView4.setEnabled(true);
                        ((ImageView) auctionSalesListActivity._$_findCachedViewById(C2723R.C2726id.arrow_left)).setImageResource(C2723R.C2725drawable.icon_left_arrow);
                    }
                    if (i == this.$itemIdList.size() - 1) {
                        ImageView imageView5 = (ImageView) auctionSalesListActivity._$_findCachedViewById(C2723R.C2726id.arrow_right);
                        Intrinsics.checkExpressionValueIsNotNull(imageView5, "auctionSalesListActivity.arrow_right");
                        imageView5.setVisibility(0);
                        ImageView imageView6 = (ImageView) auctionSalesListActivity._$_findCachedViewById(C2723R.C2726id.arrow_right);
                        Intrinsics.checkExpressionValueIsNotNull(imageView6, "auctionSalesListActivity.arrow_right");
                        imageView6.setEnabled(false);
                        ((ImageView) auctionSalesListActivity._$_findCachedViewById(C2723R.C2726id.arrow_right)).setImageResource(C2723R.C2725drawable.icon_right_arrow_disable);
                        return;
                    }
                    ImageView imageView7 = (ImageView) auctionSalesListActivity._$_findCachedViewById(C2723R.C2726id.arrow_right);
                    Intrinsics.checkExpressionValueIsNotNull(imageView7, "auctionSalesListActivity.arrow_right");
                    imageView7.setVisibility(0);
                    ImageView imageView8 = (ImageView) auctionSalesListActivity._$_findCachedViewById(C2723R.C2726id.arrow_right);
                    Intrinsics.checkExpressionValueIsNotNull(imageView8, "auctionSalesListActivity.arrow_right");
                    imageView8.setEnabled(true);
                    ((ImageView) auctionSalesListActivity._$_findCachedViewById(C2723R.C2726id.arrow_right)).setImageResource(C2723R.C2725drawable.icon_right_arrow);
                    return;
                }
                auctionSalesListActivity.getToolbar_sub_title().setVisibility(8);
                return;
            }
            throw new TypeCastException("null cannot be cast to non-null type com.iaai.android.bdt.feature.auctionSalesList.AuctionSalesListActivity");
        } else if (ViewPagerFragment.access$getBaseActivity$p(this.this$0) instanceof ProductDetailActivity) {
            BaseActivity access$getBaseActivity$p2 = ViewPagerFragment.access$getBaseActivity$p(this.this$0);
            if (access$getBaseActivity$p2 != null) {
                ProductDetailActivity productDetailActivity = (ProductDetailActivity) access$getBaseActivity$p2;
                if (this.$totalCount > 1) {
                    if (i == 0) {
                        ImageView imageView9 = (ImageView) productDetailActivity._$_findCachedViewById(C2723R.C2726id.arrow_left_fs);
                        Intrinsics.checkExpressionValueIsNotNull(imageView9, "productDetailActivity.arrow_left_fs");
                        imageView9.setVisibility(0);
                        ImageView imageView10 = (ImageView) productDetailActivity._$_findCachedViewById(C2723R.C2726id.arrow_left_fs);
                        Intrinsics.checkExpressionValueIsNotNull(imageView10, "productDetailActivity.arrow_left_fs");
                        imageView10.setEnabled(false);
                        ((ImageView) productDetailActivity._$_findCachedViewById(C2723R.C2726id.arrow_left_fs)).setImageResource(C2723R.C2725drawable.icon_left_arrow_disable);
                    } else {
                        ImageView imageView11 = (ImageView) productDetailActivity._$_findCachedViewById(C2723R.C2726id.arrow_left_fs);
                        Intrinsics.checkExpressionValueIsNotNull(imageView11, "productDetailActivity.arrow_left_fs");
                        imageView11.setVisibility(0);
                        ImageView imageView12 = (ImageView) productDetailActivity._$_findCachedViewById(C2723R.C2726id.arrow_left_fs);
                        Intrinsics.checkExpressionValueIsNotNull(imageView12, "productDetailActivity.arrow_left_fs");
                        imageView12.setEnabled(true);
                        ((ImageView) productDetailActivity._$_findCachedViewById(C2723R.C2726id.arrow_left_fs)).setImageResource(C2723R.C2725drawable.icon_left_arrow);
                    }
                    if (i == this.$itemIdList.size() - 1) {
                        ImageView imageView13 = (ImageView) productDetailActivity._$_findCachedViewById(C2723R.C2726id.arrow_right_fs);
                        Intrinsics.checkExpressionValueIsNotNull(imageView13, "productDetailActivity.arrow_right_fs");
                        imageView13.setVisibility(0);
                        ImageView imageView14 = (ImageView) productDetailActivity._$_findCachedViewById(C2723R.C2726id.arrow_right_fs);
                        Intrinsics.checkExpressionValueIsNotNull(imageView14, "productDetailActivity.arrow_right_fs");
                        imageView14.setEnabled(false);
                        ((ImageView) productDetailActivity._$_findCachedViewById(C2723R.C2726id.arrow_right_fs)).setImageResource(C2723R.C2725drawable.icon_right_arrow_disable);
                        return;
                    }
                    ImageView imageView15 = (ImageView) productDetailActivity._$_findCachedViewById(C2723R.C2726id.arrow_right_fs);
                    Intrinsics.checkExpressionValueIsNotNull(imageView15, "productDetailActivity.arrow_right_fs");
                    imageView15.setVisibility(0);
                    ImageView imageView16 = (ImageView) productDetailActivity._$_findCachedViewById(C2723R.C2726id.arrow_right_fs);
                    Intrinsics.checkExpressionValueIsNotNull(imageView16, "productDetailActivity.arrow_right_fs");
                    imageView16.setEnabled(true);
                    ((ImageView) productDetailActivity._$_findCachedViewById(C2723R.C2726id.arrow_right_fs)).setImageResource(C2723R.C2725drawable.icon_right_arrow);
                    return;
                }
                TextView textView = (TextView) productDetailActivity._$_findCachedViewById(C2723R.C2726id.toolbar_sub_title_fs);
                Intrinsics.checkExpressionValueIsNotNull(textView, "productDetailActivity.toolbar_sub_title_fs");
                textView.setVisibility(8);
                return;
            }
            throw new TypeCastException("null cannot be cast to non-null type com.iaai.android.bdt.feature.productDetail.ProductDetailActivity");
        } else if (ViewPagerFragment.access$getBaseActivity$p(this.this$0) instanceof SearchResultActivity) {
            BaseActivity access$getBaseActivity$p3 = ViewPagerFragment.access$getBaseActivity$p(this.this$0);
            if (access$getBaseActivity$p3 != null) {
                SearchResultActivity searchResultActivity = (SearchResultActivity) access$getBaseActivity$p3;
                if (this.$totalCount > 1) {
                    if (i == 0) {
                        ImageView imageView17 = (ImageView) searchResultActivity._$_findCachedViewById(C2723R.C2726id.arrow_left);
                        Intrinsics.checkExpressionValueIsNotNull(imageView17, "searchResultActivity.arrow_left");
                        imageView17.setVisibility(0);
                        ImageView imageView18 = (ImageView) searchResultActivity._$_findCachedViewById(C2723R.C2726id.arrow_left);
                        Intrinsics.checkExpressionValueIsNotNull(imageView18, "searchResultActivity.arrow_left");
                        imageView18.setEnabled(false);
                        ((ImageView) searchResultActivity._$_findCachedViewById(C2723R.C2726id.arrow_left)).setImageResource(C2723R.C2725drawable.icon_left_arrow_disable);
                    } else {
                        ImageView imageView19 = (ImageView) searchResultActivity._$_findCachedViewById(C2723R.C2726id.arrow_left);
                        Intrinsics.checkExpressionValueIsNotNull(imageView19, "searchResultActivity.arrow_left");
                        imageView19.setVisibility(0);
                        ImageView imageView20 = (ImageView) searchResultActivity._$_findCachedViewById(C2723R.C2726id.arrow_left);
                        Intrinsics.checkExpressionValueIsNotNull(imageView20, "searchResultActivity.arrow_left");
                        imageView20.setEnabled(true);
                        ((ImageView) searchResultActivity._$_findCachedViewById(C2723R.C2726id.arrow_left)).setImageResource(C2723R.C2725drawable.icon_left_arrow);
                    }
                    if (i == this.$itemIdList.size() - 1) {
                        ImageView imageView21 = (ImageView) searchResultActivity._$_findCachedViewById(C2723R.C2726id.arrow_right);
                        Intrinsics.checkExpressionValueIsNotNull(imageView21, "searchResultActivity.arrow_right");
                        imageView21.setVisibility(0);
                        ImageView imageView22 = (ImageView) searchResultActivity._$_findCachedViewById(C2723R.C2726id.arrow_right);
                        Intrinsics.checkExpressionValueIsNotNull(imageView22, "searchResultActivity.arrow_right");
                        imageView22.setEnabled(false);
                        ((ImageView) searchResultActivity._$_findCachedViewById(C2723R.C2726id.arrow_right)).setImageResource(C2723R.C2725drawable.icon_right_arrow_disable);
                        return;
                    }
                    ImageView imageView23 = (ImageView) searchResultActivity._$_findCachedViewById(C2723R.C2726id.arrow_right);
                    Intrinsics.checkExpressionValueIsNotNull(imageView23, "searchResultActivity.arrow_right");
                    imageView23.setVisibility(0);
                    ImageView imageView24 = (ImageView) searchResultActivity._$_findCachedViewById(C2723R.C2726id.arrow_right);
                    Intrinsics.checkExpressionValueIsNotNull(imageView24, "searchResultActivity.arrow_right");
                    imageView24.setEnabled(true);
                    ((ImageView) searchResultActivity._$_findCachedViewById(C2723R.C2726id.arrow_right)).setImageResource(C2723R.C2725drawable.icon_right_arrow);
                    return;
                }
                searchResultActivity.getToolbar_sub_title().setVisibility(8);
                return;
            }
            throw new TypeCastException("null cannot be cast to non-null type com.iaai.android.bdt.feature.findVehiclePage.searchResult.SearchResultActivity");
        } else if (ViewPagerFragment.access$getBaseActivity$p(this.this$0) instanceof RefinerResultActivity) {
            BaseActivity access$getBaseActivity$p4 = ViewPagerFragment.access$getBaseActivity$p(this.this$0);
            if (access$getBaseActivity$p4 != null) {
                RefinerResultActivity refinerResultActivity = (RefinerResultActivity) access$getBaseActivity$p4;
                if (this.$totalCount > 1) {
                    if (i == 0) {
                        ImageView imageView25 = (ImageView) refinerResultActivity._$_findCachedViewById(C2723R.C2726id.arrow_left);
                        Intrinsics.checkExpressionValueIsNotNull(imageView25, "refinerResultActivity.arrow_left");
                        imageView25.setVisibility(0);
                        ImageView imageView26 = (ImageView) refinerResultActivity._$_findCachedViewById(C2723R.C2726id.arrow_left);
                        Intrinsics.checkExpressionValueIsNotNull(imageView26, "refinerResultActivity.arrow_left");
                        imageView26.setEnabled(false);
                        ((ImageView) refinerResultActivity._$_findCachedViewById(C2723R.C2726id.arrow_left)).setImageResource(C2723R.C2725drawable.icon_left_arrow_disable);
                    } else {
                        ImageView imageView27 = (ImageView) refinerResultActivity._$_findCachedViewById(C2723R.C2726id.arrow_left);
                        Intrinsics.checkExpressionValueIsNotNull(imageView27, "refinerResultActivity.arrow_left");
                        imageView27.setVisibility(0);
                        ImageView imageView28 = (ImageView) refinerResultActivity._$_findCachedViewById(C2723R.C2726id.arrow_left);
                        Intrinsics.checkExpressionValueIsNotNull(imageView28, "refinerResultActivity.arrow_left");
                        imageView28.setEnabled(true);
                        ((ImageView) refinerResultActivity._$_findCachedViewById(C2723R.C2726id.arrow_left)).setImageResource(C2723R.C2725drawable.icon_left_arrow);
                    }
                    if (i == this.$itemIdList.size() - 1) {
                        ImageView imageView29 = (ImageView) refinerResultActivity._$_findCachedViewById(C2723R.C2726id.arrow_right);
                        Intrinsics.checkExpressionValueIsNotNull(imageView29, "refinerResultActivity.arrow_right");
                        imageView29.setVisibility(0);
                        ImageView imageView30 = (ImageView) refinerResultActivity._$_findCachedViewById(C2723R.C2726id.arrow_right);
                        Intrinsics.checkExpressionValueIsNotNull(imageView30, "refinerResultActivity.arrow_right");
                        imageView30.setEnabled(false);
                        ((ImageView) refinerResultActivity._$_findCachedViewById(C2723R.C2726id.arrow_right)).setImageResource(C2723R.C2725drawable.icon_right_arrow_disable);
                        return;
                    }
                    ImageView imageView31 = (ImageView) refinerResultActivity._$_findCachedViewById(C2723R.C2726id.arrow_right);
                    Intrinsics.checkExpressionValueIsNotNull(imageView31, "refinerResultActivity.arrow_right");
                    imageView31.setVisibility(0);
                    ImageView imageView32 = (ImageView) refinerResultActivity._$_findCachedViewById(C2723R.C2726id.arrow_right);
                    Intrinsics.checkExpressionValueIsNotNull(imageView32, "refinerResultActivity.arrow_right");
                    imageView32.setEnabled(true);
                    ((ImageView) refinerResultActivity._$_findCachedViewById(C2723R.C2726id.arrow_right)).setImageResource(C2723R.C2725drawable.icon_right_arrow);
                    return;
                }
                refinerResultActivity.getToolbarSubTitle().setVisibility(8);
                return;
            }
            throw new TypeCastException("null cannot be cast to non-null type com.iaai.android.bdt.feature.fastSearchFilter.refinerResults.RefinerResultActivity");
        } else if (ViewPagerFragment.access$getBaseActivity$p(this.this$0) instanceof ManageOfferListActivity) {
            BaseActivity access$getBaseActivity$p5 = ViewPagerFragment.access$getBaseActivity$p(this.this$0);
            if (access$getBaseActivity$p5 != null) {
                ManageOfferListActivity manageOfferListActivity = (ManageOfferListActivity) access$getBaseActivity$p5;
                if (this.$totalCount > 1) {
                    if (i == 0) {
                        ImageView imageView33 = (ImageView) manageOfferListActivity._$_findCachedViewById(C2723R.C2726id.arrow_left);
                        Intrinsics.checkExpressionValueIsNotNull(imageView33, "manageOfferListActivity.arrow_left");
                        imageView33.setVisibility(0);
                        ImageView imageView34 = (ImageView) manageOfferListActivity._$_findCachedViewById(C2723R.C2726id.arrow_left);
                        Intrinsics.checkExpressionValueIsNotNull(imageView34, "manageOfferListActivity.arrow_left");
                        imageView34.setEnabled(false);
                        ((ImageView) manageOfferListActivity._$_findCachedViewById(C2723R.C2726id.arrow_left)).setImageResource(C2723R.C2725drawable.icon_left_arrow_disable);
                    } else {
                        ImageView imageView35 = (ImageView) manageOfferListActivity._$_findCachedViewById(C2723R.C2726id.arrow_left);
                        Intrinsics.checkExpressionValueIsNotNull(imageView35, "manageOfferListActivity.arrow_left");
                        imageView35.setVisibility(0);
                        ImageView imageView36 = (ImageView) manageOfferListActivity._$_findCachedViewById(C2723R.C2726id.arrow_left);
                        Intrinsics.checkExpressionValueIsNotNull(imageView36, "manageOfferListActivity.arrow_left");
                        imageView36.setEnabled(true);
                        ((ImageView) manageOfferListActivity._$_findCachedViewById(C2723R.C2726id.arrow_left)).setImageResource(C2723R.C2725drawable.icon_left_arrow);
                    }
                    if (i == this.$itemIdList.size() - 1) {
                        ImageView imageView37 = (ImageView) manageOfferListActivity._$_findCachedViewById(C2723R.C2726id.arrow_right);
                        Intrinsics.checkExpressionValueIsNotNull(imageView37, "manageOfferListActivity.arrow_right");
                        imageView37.setVisibility(0);
                        ImageView imageView38 = (ImageView) manageOfferListActivity._$_findCachedViewById(C2723R.C2726id.arrow_right);
                        Intrinsics.checkExpressionValueIsNotNull(imageView38, "manageOfferListActivity.arrow_right");
                        imageView38.setEnabled(false);
                        ((ImageView) manageOfferListActivity._$_findCachedViewById(C2723R.C2726id.arrow_right)).setImageResource(C2723R.C2725drawable.icon_right_arrow_disable);
                        return;
                    }
                    ImageView imageView39 = (ImageView) manageOfferListActivity._$_findCachedViewById(C2723R.C2726id.arrow_right);
                    Intrinsics.checkExpressionValueIsNotNull(imageView39, "manageOfferListActivity.arrow_right");
                    imageView39.setVisibility(0);
                    ImageView imageView40 = (ImageView) manageOfferListActivity._$_findCachedViewById(C2723R.C2726id.arrow_right);
                    Intrinsics.checkExpressionValueIsNotNull(imageView40, "manageOfferListActivity.arrow_right");
                    imageView40.setEnabled(true);
                    ((ImageView) manageOfferListActivity._$_findCachedViewById(C2723R.C2726id.arrow_right)).setImageResource(C2723R.C2725drawable.icon_right_arrow);
                    return;
                }
                manageOfferListActivity.getToolbar_sub_title().setVisibility(8);
                return;
            }
            throw new TypeCastException("null cannot be cast to non-null type com.iaai.android.bdt.feature.digitalNegotiation.ManageOfferListActivity");
        } else if (ViewPagerFragment.access$getBaseActivity$p(this.this$0) instanceof PreSaleListActivity) {
            BaseActivity access$getBaseActivity$p6 = ViewPagerFragment.access$getBaseActivity$p(this.this$0);
            if (access$getBaseActivity$p6 != null) {
                PreSaleListActivity preSaleListActivity = (PreSaleListActivity) access$getBaseActivity$p6;
                if (this.$totalCount > 1) {
                    if (i == 0) {
                        ImageView imageView41 = (ImageView) preSaleListActivity._$_findCachedViewById(C2723R.C2726id.arrow_left_watch);
                        Intrinsics.checkExpressionValueIsNotNull(imageView41, "watchListActivity.arrow_left_watch");
                        imageView41.setVisibility(0);
                        ImageView imageView42 = (ImageView) preSaleListActivity._$_findCachedViewById(C2723R.C2726id.arrow_left_watch);
                        Intrinsics.checkExpressionValueIsNotNull(imageView42, "watchListActivity.arrow_left_watch");
                        imageView42.setEnabled(false);
                        ((ImageView) preSaleListActivity._$_findCachedViewById(C2723R.C2726id.arrow_left_watch)).setImageResource(C2723R.C2725drawable.icon_left_arrow_disable);
                    } else {
                        ImageView imageView43 = (ImageView) preSaleListActivity._$_findCachedViewById(C2723R.C2726id.arrow_left_watch);
                        Intrinsics.checkExpressionValueIsNotNull(imageView43, "watchListActivity.arrow_left_watch");
                        imageView43.setVisibility(0);
                        ImageView imageView44 = (ImageView) preSaleListActivity._$_findCachedViewById(C2723R.C2726id.arrow_left_watch);
                        Intrinsics.checkExpressionValueIsNotNull(imageView44, "watchListActivity.arrow_left_watch");
                        imageView44.setEnabled(true);
                        ((ImageView) preSaleListActivity._$_findCachedViewById(C2723R.C2726id.arrow_left_watch)).setImageResource(C2723R.C2725drawable.icon_left_arrow);
                    }
                    if (i == this.$itemIdList.size() - 1) {
                        ImageView imageView45 = (ImageView) preSaleListActivity._$_findCachedViewById(C2723R.C2726id.arrow_right_watch);
                        Intrinsics.checkExpressionValueIsNotNull(imageView45, "watchListActivity.arrow_right_watch");
                        imageView45.setVisibility(0);
                        ImageView imageView46 = (ImageView) preSaleListActivity._$_findCachedViewById(C2723R.C2726id.arrow_right_watch);
                        Intrinsics.checkExpressionValueIsNotNull(imageView46, "watchListActivity.arrow_right_watch");
                        imageView46.setEnabled(false);
                        ((ImageView) preSaleListActivity._$_findCachedViewById(C2723R.C2726id.arrow_right_watch)).setImageResource(C2723R.C2725drawable.icon_right_arrow_disable);
                        return;
                    }
                    ImageView imageView47 = (ImageView) preSaleListActivity._$_findCachedViewById(C2723R.C2726id.arrow_right_watch);
                    Intrinsics.checkExpressionValueIsNotNull(imageView47, "watchListActivity.arrow_right_watch");
                    imageView47.setVisibility(0);
                    ImageView imageView48 = (ImageView) preSaleListActivity._$_findCachedViewById(C2723R.C2726id.arrow_right_watch);
                    Intrinsics.checkExpressionValueIsNotNull(imageView48, "watchListActivity.arrow_right_watch");
                    imageView48.setEnabled(true);
                    ((ImageView) preSaleListActivity._$_findCachedViewById(C2723R.C2726id.arrow_right_watch)).setImageResource(C2723R.C2725drawable.icon_right_arrow);
                    return;
                }
                preSaleListActivity.getToolbar_sub_title().setVisibility(8);
                return;
            }
            throw new TypeCastException("null cannot be cast to non-null type com.iaai.android.bdt.feature.account.watchlist.PreSaleListActivity");
        } else if (ViewPagerFragment.access$getBaseActivity$p(this.this$0) instanceof BDTPaymentActivity) {
            BaseActivity access$getBaseActivity$p7 = ViewPagerFragment.access$getBaseActivity$p(this.this$0);
            if (access$getBaseActivity$p7 != null) {
                BDTPaymentActivity bDTPaymentActivity = (BDTPaymentActivity) access$getBaseActivity$p7;
                if (this.$totalCount > 1) {
                    if (i == 0) {
                        ImageView imageView49 = (ImageView) bDTPaymentActivity._$_findCachedViewById(C2723R.C2726id.arrow_left);
                        Intrinsics.checkExpressionValueIsNotNull(imageView49, "bdtPaymentActivity.arrow_left");
                        imageView49.setVisibility(0);
                        ImageView imageView50 = (ImageView) bDTPaymentActivity._$_findCachedViewById(C2723R.C2726id.arrow_left);
                        Intrinsics.checkExpressionValueIsNotNull(imageView50, "bdtPaymentActivity.arrow_left");
                        imageView50.setEnabled(false);
                        ((ImageView) bDTPaymentActivity._$_findCachedViewById(C2723R.C2726id.arrow_left)).setImageResource(C2723R.C2725drawable.icon_left_arrow_disable);
                    } else {
                        ImageView imageView51 = (ImageView) bDTPaymentActivity._$_findCachedViewById(C2723R.C2726id.arrow_left);
                        Intrinsics.checkExpressionValueIsNotNull(imageView51, "bdtPaymentActivity.arrow_left");
                        imageView51.setVisibility(0);
                        ImageView imageView52 = (ImageView) bDTPaymentActivity._$_findCachedViewById(C2723R.C2726id.arrow_left);
                        Intrinsics.checkExpressionValueIsNotNull(imageView52, "bdtPaymentActivity.arrow_left");
                        imageView52.setEnabled(true);
                        ((ImageView) bDTPaymentActivity._$_findCachedViewById(C2723R.C2726id.arrow_left)).setImageResource(C2723R.C2725drawable.icon_left_arrow);
                    }
                    if (i == this.$itemIdList.size() - 1) {
                        ImageView imageView53 = (ImageView) bDTPaymentActivity._$_findCachedViewById(C2723R.C2726id.arrow_right);
                        Intrinsics.checkExpressionValueIsNotNull(imageView53, "bdtPaymentActivity.arrow_right");
                        imageView53.setVisibility(0);
                        ImageView imageView54 = (ImageView) bDTPaymentActivity._$_findCachedViewById(C2723R.C2726id.arrow_right);
                        Intrinsics.checkExpressionValueIsNotNull(imageView54, "bdtPaymentActivity.arrow_right");
                        imageView54.setEnabled(false);
                        ((ImageView) bDTPaymentActivity._$_findCachedViewById(C2723R.C2726id.arrow_right)).setImageResource(C2723R.C2725drawable.icon_right_arrow_disable);
                        return;
                    }
                    ImageView imageView55 = (ImageView) bDTPaymentActivity._$_findCachedViewById(C2723R.C2726id.arrow_right);
                    Intrinsics.checkExpressionValueIsNotNull(imageView55, "bdtPaymentActivity.arrow_right");
                    imageView55.setVisibility(0);
                    ImageView imageView56 = (ImageView) bDTPaymentActivity._$_findCachedViewById(C2723R.C2726id.arrow_right);
                    Intrinsics.checkExpressionValueIsNotNull(imageView56, "bdtPaymentActivity.arrow_right");
                    imageView56.setEnabled(true);
                    ((ImageView) bDTPaymentActivity._$_findCachedViewById(C2723R.C2726id.arrow_right)).setImageResource(C2723R.C2725drawable.icon_right_arrow);
                    return;
                }
                bDTPaymentActivity.getToolbar_sub_title().setVisibility(8);
                return;
            }
            throw new TypeCastException("null cannot be cast to non-null type com.iaai.android.bdt.feature.myAccount.toBePaid.BDTPaymentActivity");
        } else if (ViewPagerFragment.access$getBaseActivity$p(this.this$0) instanceof ToPickedUpAccountActivity) {
            BaseActivity access$getBaseActivity$p8 = ViewPagerFragment.access$getBaseActivity$p(this.this$0);
            if (access$getBaseActivity$p8 != null) {
                ToPickedUpAccountActivity toPickedUpAccountActivity = (ToPickedUpAccountActivity) access$getBaseActivity$p8;
                if (this.$totalCount > 1) {
                    if (i == 0) {
                        ImageView imageView57 = (ImageView) toPickedUpAccountActivity._$_findCachedViewById(C2723R.C2726id.arrow_left_tobePickUp);
                        Intrinsics.checkExpressionValueIsNotNull(imageView57, "toPickedUpAccountActivity.arrow_left_tobePickUp");
                        imageView57.setVisibility(0);
                        ImageView imageView58 = (ImageView) toPickedUpAccountActivity._$_findCachedViewById(C2723R.C2726id.arrow_left_tobePickUp);
                        Intrinsics.checkExpressionValueIsNotNull(imageView58, "toPickedUpAccountActivity.arrow_left_tobePickUp");
                        imageView58.setEnabled(false);
                        ((ImageView) toPickedUpAccountActivity._$_findCachedViewById(C2723R.C2726id.arrow_left_tobePickUp)).setImageResource(C2723R.C2725drawable.icon_left_arrow_disable);
                    } else {
                        ImageView imageView59 = (ImageView) toPickedUpAccountActivity._$_findCachedViewById(C2723R.C2726id.arrow_left_tobePickUp);
                        Intrinsics.checkExpressionValueIsNotNull(imageView59, "toPickedUpAccountActivity.arrow_left_tobePickUp");
                        imageView59.setVisibility(0);
                        ImageView imageView60 = (ImageView) toPickedUpAccountActivity._$_findCachedViewById(C2723R.C2726id.arrow_left_tobePickUp);
                        Intrinsics.checkExpressionValueIsNotNull(imageView60, "toPickedUpAccountActivity.arrow_left_tobePickUp");
                        imageView60.setEnabled(true);
                        ((ImageView) toPickedUpAccountActivity._$_findCachedViewById(C2723R.C2726id.arrow_left_tobePickUp)).setImageResource(C2723R.C2725drawable.icon_left_arrow);
                    }
                    if (i == this.$itemIdList.size() - 1) {
                        ImageView imageView61 = (ImageView) toPickedUpAccountActivity._$_findCachedViewById(C2723R.C2726id.arrow_right_tobePickUp);
                        Intrinsics.checkExpressionValueIsNotNull(imageView61, "toPickedUpAccountActivity.arrow_right_tobePickUp");
                        imageView61.setVisibility(0);
                        ImageView imageView62 = (ImageView) toPickedUpAccountActivity._$_findCachedViewById(C2723R.C2726id.arrow_right_tobePickUp);
                        Intrinsics.checkExpressionValueIsNotNull(imageView62, "toPickedUpAccountActivity.arrow_right_tobePickUp");
                        imageView62.setEnabled(false);
                        ((ImageView) toPickedUpAccountActivity._$_findCachedViewById(C2723R.C2726id.arrow_right_tobePickUp)).setImageResource(C2723R.C2725drawable.icon_right_arrow_disable);
                        return;
                    }
                    ImageView imageView63 = (ImageView) toPickedUpAccountActivity._$_findCachedViewById(C2723R.C2726id.arrow_right_tobePickUp);
                    Intrinsics.checkExpressionValueIsNotNull(imageView63, "toPickedUpAccountActivity.arrow_right_tobePickUp");
                    imageView63.setVisibility(0);
                    ImageView imageView64 = (ImageView) toPickedUpAccountActivity._$_findCachedViewById(C2723R.C2726id.arrow_right_tobePickUp);
                    Intrinsics.checkExpressionValueIsNotNull(imageView64, "toPickedUpAccountActivity.arrow_right_tobePickUp");
                    imageView64.setEnabled(true);
                    ((ImageView) toPickedUpAccountActivity._$_findCachedViewById(C2723R.C2726id.arrow_right_tobePickUp)).setImageResource(C2723R.C2725drawable.icon_right_arrow);
                    return;
                }
                toPickedUpAccountActivity.getToolbar_sub_title().setVisibility(8);
                return;
            }
            throw new TypeCastException("null cannot be cast to non-null type com.iaai.android.bdt.feature.account.tobepickedup.ToPickedUpAccountActivity");
        } else if (ViewPagerFragment.access$getBaseActivity$p(this.this$0) instanceof BuyNowOfferListActivity) {
            BaseActivity access$getBaseActivity$p9 = ViewPagerFragment.access$getBaseActivity$p(this.this$0);
            if (access$getBaseActivity$p9 != null) {
                BuyNowOfferListActivity buyNowOfferListActivity = (BuyNowOfferListActivity) access$getBaseActivity$p9;
                if (this.$totalCount > 1) {
                    if (i == 0) {
                        ImageView imageView65 = (ImageView) buyNowOfferListActivity._$_findCachedViewById(C2723R.C2726id.arrow_left_buy_now);
                        Intrinsics.checkExpressionValueIsNotNull(imageView65, "buyNowOfferListActivity.arrow_left_buy_now");
                        imageView65.setVisibility(0);
                        ImageView imageView66 = (ImageView) buyNowOfferListActivity._$_findCachedViewById(C2723R.C2726id.arrow_left_buy_now);
                        Intrinsics.checkExpressionValueIsNotNull(imageView66, "buyNowOfferListActivity.arrow_left_buy_now");
                        imageView66.setEnabled(false);
                        ((ImageView) buyNowOfferListActivity._$_findCachedViewById(C2723R.C2726id.arrow_left_buy_now)).setImageResource(C2723R.C2725drawable.icon_left_arrow_disable);
                    } else {
                        ImageView imageView67 = (ImageView) buyNowOfferListActivity._$_findCachedViewById(C2723R.C2726id.arrow_left_buy_now);
                        Intrinsics.checkExpressionValueIsNotNull(imageView67, "buyNowOfferListActivity.arrow_left_buy_now");
                        imageView67.setVisibility(0);
                        ImageView imageView68 = (ImageView) buyNowOfferListActivity._$_findCachedViewById(C2723R.C2726id.arrow_left_buy_now);
                        Intrinsics.checkExpressionValueIsNotNull(imageView68, "buyNowOfferListActivity.arrow_left_buy_now");
                        imageView68.setEnabled(true);
                        ((ImageView) buyNowOfferListActivity._$_findCachedViewById(C2723R.C2726id.arrow_left_buy_now)).setImageResource(C2723R.C2725drawable.icon_left_arrow);
                    }
                    if (i == this.$itemIdList.size() - 1) {
                        ImageView imageView69 = (ImageView) buyNowOfferListActivity._$_findCachedViewById(C2723R.C2726id.arrow_right_buy_now);
                        Intrinsics.checkExpressionValueIsNotNull(imageView69, "buyNowOfferListActivity.arrow_right_buy_now");
                        imageView69.setVisibility(0);
                        ImageView imageView70 = (ImageView) buyNowOfferListActivity._$_findCachedViewById(C2723R.C2726id.arrow_right_buy_now);
                        Intrinsics.checkExpressionValueIsNotNull(imageView70, "buyNowOfferListActivity.arrow_right_buy_now");
                        imageView70.setEnabled(false);
                        ((ImageView) buyNowOfferListActivity._$_findCachedViewById(C2723R.C2726id.arrow_right_buy_now)).setImageResource(C2723R.C2725drawable.icon_right_arrow_disable);
                        return;
                    }
                    ImageView imageView71 = (ImageView) buyNowOfferListActivity._$_findCachedViewById(C2723R.C2726id.arrow_right_buy_now);
                    Intrinsics.checkExpressionValueIsNotNull(imageView71, "buyNowOfferListActivity.arrow_right_buy_now");
                    imageView71.setVisibility(0);
                    ImageView imageView72 = (ImageView) buyNowOfferListActivity._$_findCachedViewById(C2723R.C2726id.arrow_right_buy_now);
                    Intrinsics.checkExpressionValueIsNotNull(imageView72, "buyNowOfferListActivity.arrow_right_buy_now");
                    imageView72.setEnabled(true);
                    ((ImageView) buyNowOfferListActivity._$_findCachedViewById(C2723R.C2726id.arrow_right_buy_now)).setImageResource(C2723R.C2725drawable.icon_right_arrow);
                    return;
                }
                buyNowOfferListActivity.getToolbar_sub_title().setVisibility(8);
                return;
            }
            throw new TypeCastException("null cannot be cast to non-null type com.iaai.android.bdt.feature.account.buyNowOfferList.BuyNowOfferListActivity");
        } else if (ViewPagerFragment.access$getBaseActivity$p(this.this$0) instanceof SalesDocumentActivity) {
            BaseActivity access$getBaseActivity$p10 = ViewPagerFragment.access$getBaseActivity$p(this.this$0);
            if (access$getBaseActivity$p10 != null) {
                SalesDocumentActivity salesDocumentActivity = (SalesDocumentActivity) access$getBaseActivity$p10;
                if (this.$totalCount > 1) {
                    if (i == 0) {
                        ImageView imageView73 = (ImageView) salesDocumentActivity._$_findCachedViewById(C2723R.C2726id.arrow_left);
                        Intrinsics.checkExpressionValueIsNotNull(imageView73, "salesDocumentActivity.arrow_left");
                        imageView73.setVisibility(0);
                        ImageView imageView74 = (ImageView) salesDocumentActivity._$_findCachedViewById(C2723R.C2726id.arrow_left);
                        Intrinsics.checkExpressionValueIsNotNull(imageView74, "salesDocumentActivity.arrow_left");
                        imageView74.setEnabled(false);
                        ((ImageView) salesDocumentActivity._$_findCachedViewById(C2723R.C2726id.arrow_left)).setImageResource(C2723R.C2725drawable.icon_left_arrow_disable);
                    } else {
                        ImageView imageView75 = (ImageView) salesDocumentActivity._$_findCachedViewById(C2723R.C2726id.arrow_left);
                        Intrinsics.checkExpressionValueIsNotNull(imageView75, "salesDocumentActivity.arrow_left");
                        imageView75.setVisibility(0);
                        ImageView imageView76 = (ImageView) salesDocumentActivity._$_findCachedViewById(C2723R.C2726id.arrow_left);
                        Intrinsics.checkExpressionValueIsNotNull(imageView76, "salesDocumentActivity.arrow_left");
                        imageView76.setEnabled(true);
                        ((ImageView) salesDocumentActivity._$_findCachedViewById(C2723R.C2726id.arrow_left)).setImageResource(C2723R.C2725drawable.icon_left_arrow);
                    }
                    if (i == this.$itemIdList.size() - 1) {
                        ImageView imageView77 = (ImageView) salesDocumentActivity._$_findCachedViewById(C2723R.C2726id.arrow_right);
                        Intrinsics.checkExpressionValueIsNotNull(imageView77, "salesDocumentActivity.arrow_right");
                        imageView77.setVisibility(0);
                        ImageView imageView78 = (ImageView) salesDocumentActivity._$_findCachedViewById(C2723R.C2726id.arrow_right);
                        Intrinsics.checkExpressionValueIsNotNull(imageView78, "salesDocumentActivity.arrow_right");
                        imageView78.setEnabled(false);
                        ((ImageView) salesDocumentActivity._$_findCachedViewById(C2723R.C2726id.arrow_right)).setImageResource(C2723R.C2725drawable.icon_right_arrow_disable);
                        return;
                    }
                    ImageView imageView79 = (ImageView) salesDocumentActivity._$_findCachedViewById(C2723R.C2726id.arrow_right);
                    Intrinsics.checkExpressionValueIsNotNull(imageView79, "salesDocumentActivity.arrow_right");
                    imageView79.setVisibility(0);
                    ImageView imageView80 = (ImageView) salesDocumentActivity._$_findCachedViewById(C2723R.C2726id.arrow_right);
                    Intrinsics.checkExpressionValueIsNotNull(imageView80, "salesDocumentActivity.arrow_right");
                    imageView80.setEnabled(true);
                    ((ImageView) salesDocumentActivity._$_findCachedViewById(C2723R.C2726id.arrow_right)).setImageResource(C2723R.C2725drawable.icon_right_arrow);
                    return;
                }
                salesDocumentActivity.getToolbar_sub_title().setVisibility(8);
                return;
            }
            throw new TypeCastException("null cannot be cast to non-null type com.iaai.android.bdt.feature.account.salesdocument.SalesDocumentActivity");
        }
    }

    public void onPageSelected(int i) {
        int i2 = i;
        if (ViewPagerFragment.access$getBaseActivity$p(this.this$0) instanceof AuctionSalesListActivity) {
            BaseActivity access$getBaseActivity$p = ViewPagerFragment.access$getBaseActivity$p(this.this$0);
            if (access$getBaseActivity$p != null) {
                AuctionSalesListActivity auctionSalesListActivity = (AuctionSalesListActivity) access$getBaseActivity$p;
                auctionSalesListActivity.getIvStockShare().setVisibility(0);
                if (this.$totalCount > 1) {
                    TextView toolbar_title = auctionSalesListActivity.getToolbar_title();
                    toolbar_title.setText(String.valueOf(i2 + 1) + " of " + BDTUtils.INSTANCE.getCountDisplay(this.$totalCount));
                    auctionSalesListActivity.getToolbar_sub_title().setVisibility(8);
                } else {
                    auctionSalesListActivity.getToolbar_title().setText("Year Make Model");
                    auctionSalesListActivity.getToolbar_sub_title().setVisibility(8);
                }
            } else {
                throw new TypeCastException("null cannot be cast to non-null type com.iaai.android.bdt.feature.auctionSalesList.AuctionSalesListActivity");
            }
        } else if (ViewPagerFragment.access$getBaseActivity$p(this.this$0) instanceof ProductDetailActivity) {
            BaseActivity access$getBaseActivity$p2 = ViewPagerFragment.access$getBaseActivity$p(this.this$0);
            if (access$getBaseActivity$p2 != null) {
                ProductDetailActivity productDetailActivity = (ProductDetailActivity) access$getBaseActivity$p2;
                if (this.$totalCount > 1) {
                    RelativeLayout relativeLayout = (RelativeLayout) productDetailActivity._$_findCachedViewById(C2723R.C2726id.toolbar_relativelayout_fs);
                    Intrinsics.checkExpressionValueIsNotNull(relativeLayout, "productDetailActivity.toolbar_relativelayout_fs");
                    relativeLayout.setGravity(GravityCompat.END);
                    RelativeLayout relativeLayout2 = (RelativeLayout) productDetailActivity._$_findCachedViewById(C2723R.C2726id.toolbar_relativelayout_fs);
                    Intrinsics.checkExpressionValueIsNotNull(relativeLayout2, "productDetailActivity.toolbar_relativelayout_fs");
                    relativeLayout2.setGravity(5);
                    TextView textView = (TextView) productDetailActivity._$_findCachedViewById(C2723R.C2726id.toolbar_title_fs);
                    Intrinsics.checkExpressionValueIsNotNull(textView, "productDetailActivity.toolbar_title_fs");
                    textView.setText(String.valueOf(i2 + 1) + " of " + BDTUtils.INSTANCE.getCountDisplay(this.$totalCount));
                    TextView textView2 = (TextView) productDetailActivity._$_findCachedViewById(C2723R.C2726id.toolbar_sub_title_fs);
                    Intrinsics.checkExpressionValueIsNotNull(textView2, "productDetailActivity.toolbar_sub_title_fs");
                    textView2.setVisibility(8);
                } else {
                    TextView textView3 = (TextView) productDetailActivity._$_findCachedViewById(C2723R.C2726id.toolbar_title_fs);
                    Intrinsics.checkExpressionValueIsNotNull(textView3, "productDetailActivity.toolbar_title_fs");
                    textView3.setText("Year Make Model");
                    TextView textView4 = (TextView) productDetailActivity._$_findCachedViewById(C2723R.C2726id.toolbar_sub_title_fs);
                    Intrinsics.checkExpressionValueIsNotNull(textView4, "productDetailActivity.toolbar_sub_title_fs");
                    textView4.setVisibility(8);
                }
            } else {
                throw new TypeCastException("null cannot be cast to non-null type com.iaai.android.bdt.feature.productDetail.ProductDetailActivity");
            }
        } else if (ViewPagerFragment.access$getBaseActivity$p(this.this$0) instanceof SearchResultActivity) {
            BaseActivity access$getBaseActivity$p3 = ViewPagerFragment.access$getBaseActivity$p(this.this$0);
            if (access$getBaseActivity$p3 != null) {
                SearchResultActivity searchResultActivity = (SearchResultActivity) access$getBaseActivity$p3;
                searchResultActivity.getIvStockShare().setVisibility(0);
                if (this.$totalCount > 1) {
                    TextView toolbar_title2 = searchResultActivity.getToolbar_title();
                    toolbar_title2.setText(String.valueOf(i2 + 1) + " of " + BDTUtils.INSTANCE.getCountDisplay(this.$totalCount));
                    searchResultActivity.getToolbar_sub_title().setVisibility(8);
                } else {
                    searchResultActivity.getToolbar_title().setText("Year Make Model");
                    searchResultActivity.getToolbar_sub_title().setVisibility(8);
                }
            } else {
                throw new TypeCastException("null cannot be cast to non-null type com.iaai.android.bdt.feature.findVehiclePage.searchResult.SearchResultActivity");
            }
        } else if (ViewPagerFragment.access$getBaseActivity$p(this.this$0) instanceof RefinerResultActivity) {
            BaseActivity access$getBaseActivity$p4 = ViewPagerFragment.access$getBaseActivity$p(this.this$0);
            if (access$getBaseActivity$p4 != null) {
                RefinerResultActivity refinerResultActivity = (RefinerResultActivity) access$getBaseActivity$p4;
                refinerResultActivity.getIvStockShare().setVisibility(0);
                TextView textView5 = (TextView) refinerResultActivity._$_findCachedViewById(C2723R.C2726id.tvSavedSearch);
                Intrinsics.checkExpressionValueIsNotNull(textView5, "refinerResultActivity.tvSavedSearch");
                textView5.setVisibility(8);
                if (this.$totalCount > 1) {
                    TextView toolbarTitle = refinerResultActivity.getToolbarTitle();
                    toolbarTitle.setText(String.valueOf(i2 + 1) + " of " + BDTUtils.INSTANCE.getCountDisplay(this.$totalCount));
                    refinerResultActivity.getToolbarSubTitle().setVisibility(8);
                } else {
                    refinerResultActivity.getToolbarTitle().setText("Year Make Model");
                    refinerResultActivity.getToolbarSubTitle().setVisibility(8);
                }
            } else {
                throw new TypeCastException("null cannot be cast to non-null type com.iaai.android.bdt.feature.fastSearchFilter.refinerResults.RefinerResultActivity");
            }
        } else if (ViewPagerFragment.access$getBaseActivity$p(this.this$0) instanceof ManageOfferListActivity) {
            BaseActivity access$getBaseActivity$p5 = ViewPagerFragment.access$getBaseActivity$p(this.this$0);
            if (access$getBaseActivity$p5 != null) {
                ManageOfferListActivity manageOfferListActivity = (ManageOfferListActivity) access$getBaseActivity$p5;
                manageOfferListActivity.getIvStockShare().setVisibility(0);
                if (this.$totalCount > 1) {
                    TextView toolbar_title3 = manageOfferListActivity.getToolbar_title();
                    toolbar_title3.setText(String.valueOf(i2 + 1) + " of " + BDTUtils.INSTANCE.getCountDisplay(this.$totalCount));
                    manageOfferListActivity.getToolbar_sub_title().setVisibility(8);
                } else {
                    manageOfferListActivity.getToolbar_title().setText("Year Make Model");
                    manageOfferListActivity.getToolbar_sub_title().setVisibility(8);
                }
            } else {
                throw new TypeCastException("null cannot be cast to non-null type com.iaai.android.bdt.feature.digitalNegotiation.ManageOfferListActivity");
            }
        } else if (ViewPagerFragment.access$getBaseActivity$p(this.this$0) instanceof PreSaleListActivity) {
            BaseActivity access$getBaseActivity$p6 = ViewPagerFragment.access$getBaseActivity$p(this.this$0);
            if (access$getBaseActivity$p6 != null) {
                PreSaleListActivity preSaleListActivity = (PreSaleListActivity) access$getBaseActivity$p6;
                preSaleListActivity.getIvStockShare().setVisibility(0);
                if (this.$totalCount > 1) {
                    TextView toolbar_title4 = preSaleListActivity.getToolbar_title();
                    toolbar_title4.setText(String.valueOf(i2 + 1) + " of " + BDTUtils.INSTANCE.getCountDisplay(this.$totalCount));
                    preSaleListActivity.getToolbar_sub_title().setVisibility(8);
                } else {
                    preSaleListActivity.getToolbar_title().setText("Year Make Model");
                    preSaleListActivity.getToolbar_sub_title().setVisibility(8);
                }
            } else {
                throw new TypeCastException("null cannot be cast to non-null type com.iaai.android.bdt.feature.account.watchlist.PreSaleListActivity");
            }
        } else if (ViewPagerFragment.access$getBaseActivity$p(this.this$0) instanceof BDTPaymentActivity) {
            BaseActivity access$getBaseActivity$p7 = ViewPagerFragment.access$getBaseActivity$p(this.this$0);
            if (access$getBaseActivity$p7 != null) {
                BDTPaymentActivity bDTPaymentActivity = (BDTPaymentActivity) access$getBaseActivity$p7;
                bDTPaymentActivity.getIvStockShare().setVisibility(0);
                if (this.$totalCount > 1) {
                    TextView toolbar_title5 = bDTPaymentActivity.getToolbar_title();
                    toolbar_title5.setText(String.valueOf(i2 + 1) + " of " + BDTUtils.INSTANCE.getCountDisplay(this.$totalCount));
                    bDTPaymentActivity.getToolbar_sub_title().setVisibility(8);
                } else {
                    bDTPaymentActivity.getToolbar_title().setText("Year Make Model");
                    bDTPaymentActivity.getToolbar_sub_title().setVisibility(8);
                }
            } else {
                throw new TypeCastException("null cannot be cast to non-null type com.iaai.android.bdt.feature.myAccount.toBePaid.BDTPaymentActivity");
            }
        } else if (ViewPagerFragment.access$getBaseActivity$p(this.this$0) instanceof ToPickedUpAccountActivity) {
            BaseActivity access$getBaseActivity$p8 = ViewPagerFragment.access$getBaseActivity$p(this.this$0);
            if (access$getBaseActivity$p8 != null) {
                ToPickedUpAccountActivity toPickedUpAccountActivity = (ToPickedUpAccountActivity) access$getBaseActivity$p8;
                toPickedUpAccountActivity.getIvStockShare().setVisibility(0);
                if (this.$totalCount > 1) {
                    TextView toolbar_title6 = toPickedUpAccountActivity.getToolbar_title();
                    toolbar_title6.setText(String.valueOf(i2 + 1) + " of " + BDTUtils.INSTANCE.getCountDisplay(this.$totalCount));
                    toPickedUpAccountActivity.getToolbar_sub_title().setVisibility(8);
                } else {
                    toPickedUpAccountActivity.getToolbar_title().setText("Year Make Model");
                    toPickedUpAccountActivity.getToolbar_sub_title().setVisibility(8);
                }
            } else {
                throw new TypeCastException("null cannot be cast to non-null type com.iaai.android.bdt.feature.account.tobepickedup.ToPickedUpAccountActivity");
            }
        } else if (ViewPagerFragment.access$getBaseActivity$p(this.this$0) instanceof BuyNowOfferListActivity) {
            BaseActivity access$getBaseActivity$p9 = ViewPagerFragment.access$getBaseActivity$p(this.this$0);
            if (access$getBaseActivity$p9 != null) {
                BuyNowOfferListActivity buyNowOfferListActivity = (BuyNowOfferListActivity) access$getBaseActivity$p9;
                buyNowOfferListActivity.getIvStockShare().setVisibility(0);
                if (this.$totalCount > 1) {
                    TextView toolbar_title7 = buyNowOfferListActivity.getToolbar_title();
                    toolbar_title7.setText(String.valueOf(i2 + 1) + " of " + BDTUtils.INSTANCE.getCountDisplay(this.$totalCount));
                    buyNowOfferListActivity.getToolbar_sub_title().setVisibility(8);
                } else {
                    buyNowOfferListActivity.getToolbar_title().setText("Year Make Model");
                    buyNowOfferListActivity.getToolbar_sub_title().setVisibility(8);
                }
            } else {
                throw new TypeCastException("null cannot be cast to non-null type com.iaai.android.bdt.feature.account.buyNowOfferList.BuyNowOfferListActivity");
            }
        } else if (ViewPagerFragment.access$getBaseActivity$p(this.this$0) instanceof SalesDocumentActivity) {
            BaseActivity access$getBaseActivity$p10 = ViewPagerFragment.access$getBaseActivity$p(this.this$0);
            if (access$getBaseActivity$p10 != null) {
                SalesDocumentActivity salesDocumentActivity = (SalesDocumentActivity) access$getBaseActivity$p10;
                salesDocumentActivity.getIvStockShare().setVisibility(0);
                if (this.$totalCount > 1) {
                    TextView toolbar_title8 = salesDocumentActivity.getToolbar_title();
                    toolbar_title8.setText(String.valueOf(i2 + 1) + " of " + BDTUtils.INSTANCE.getCountDisplay(this.$totalCount));
                    salesDocumentActivity.getToolbar_sub_title().setVisibility(8);
                } else {
                    salesDocumentActivity.getToolbar_title().setText("Year Make Model");
                    salesDocumentActivity.getToolbar_sub_title().setVisibility(8);
                }
            } else {
                throw new TypeCastException("null cannot be cast to non-null type com.iaai.android.bdt.feature.account.salesdocument.SalesDocumentActivity");
            }
        }
        if (i2 == this.$itemIdList.size() - 1 && this.this$0.balance != 0) {
            int i3 = i2 + 2;
            int i4 = i2 + 31;
            if (ViewPagerFragment.access$getBaseActivity$p(this.this$0) instanceof AuctionSalesListActivity) {
                BaseActivity access$getBaseActivity$p11 = ViewPagerFragment.access$getBaseActivity$p(this.this$0);
                if (access$getBaseActivity$p11 != null) {
                    ((AuctionSalesListActivity) access$getBaseActivity$p11).loadSwipedProductList(i3, i4);
                    return;
                }
                throw new TypeCastException("null cannot be cast to non-null type com.iaai.android.bdt.feature.auctionSalesList.AuctionSalesListActivity");
            } else if ((ViewPagerFragment.access$getBaseActivity$p(this.this$0) instanceof ProductDetailActivity) || (ViewPagerFragment.access$getBaseActivity$p(this.this$0) instanceof SearchResultActivity)) {
                SearchInputV2 searchInputV2 = (SearchInputV2) new Gson().fromJson(this.this$0.fastSearchParam, SearchInputV2.class);
                searchInputV2.setStartIndex(i3);
                searchInputV2.setCountOfVehicles(100);
                ViewPagerFragment viewPagerFragment = this.this$0;
                Intrinsics.checkExpressionValueIsNotNull(searchInputV2, "searchInput");
                viewPagerFragment.loadFastSearchList(searchInputV2);
            } else if ((ViewPagerFragment.access$getBaseActivity$p(this.this$0) instanceof ProductDetailActivity) || (ViewPagerFragment.access$getBaseActivity$p(this.this$0) instanceof RefinerResultActivity)) {
                FastSearchRequestBody fastSearchRequestBody = (FastSearchRequestBody) new Gson().fromJson(this.this$0.fastSearchParam, FastSearchRequestBody.class);
                fastSearchRequestBody.setCurrentPage(fastSearchRequestBody.getCurrentPage() + 1);
                BaseActivity access$getBaseActivity$p12 = ViewPagerFragment.access$getBaseActivity$p(this.this$0);
                if (access$getBaseActivity$p12 != null) {
                    Intrinsics.checkExpressionValueIsNotNull(fastSearchRequestBody, "fastSearchRequestBody");
                    ((RefinerResultActivity) access$getBaseActivity$p12).loadSwipedProductList(fastSearchRequestBody);
                    return;
                }
                throw new TypeCastException("null cannot be cast to non-null type com.iaai.android.bdt.feature.fastSearchFilter.refinerResults.RefinerResultActivity");
            } else if (ViewPagerFragment.access$getBaseActivity$p(this.this$0) instanceof PreSaleListActivity) {
                BaseActivity access$getBaseActivity$p13 = ViewPagerFragment.access$getBaseActivity$p(this.this$0);
                if (access$getBaseActivity$p13 != null) {
                    ((PreSaleListActivity) access$getBaseActivity$p13).loadSwipedProductList(i3, i4);
                    return;
                }
                throw new TypeCastException("null cannot be cast to non-null type com.iaai.android.bdt.feature.account.watchlist.PreSaleListActivity");
            } else if (ViewPagerFragment.access$getBaseActivity$p(this.this$0) instanceof ToPickedUpAccountActivity) {
                BaseActivity access$getBaseActivity$p14 = ViewPagerFragment.access$getBaseActivity$p(this.this$0);
                if (access$getBaseActivity$p14 != null) {
                    ((ToPickedUpAccountActivity) access$getBaseActivity$p14).loadSwipedProductList(i3, i4);
                    return;
                }
                throw new TypeCastException("null cannot be cast to non-null type com.iaai.android.bdt.feature.account.tobepickedup.ToPickedUpAccountActivity");
            } else if (ViewPagerFragment.access$getBaseActivity$p(this.this$0) instanceof BuyNowOfferListActivity) {
                BaseActivity access$getBaseActivity$p15 = ViewPagerFragment.access$getBaseActivity$p(this.this$0);
                if (access$getBaseActivity$p15 != null) {
                    ((BuyNowOfferListActivity) access$getBaseActivity$p15).loadSwipedProductList(i3, i4);
                    return;
                }
                throw new TypeCastException("null cannot be cast to non-null type com.iaai.android.bdt.feature.account.buyNowOfferList.BuyNowOfferListActivity");
            } else if (ViewPagerFragment.access$getBaseActivity$p(this.this$0) instanceof SalesDocumentActivity) {
                BaseActivity access$getBaseActivity$p16 = ViewPagerFragment.access$getBaseActivity$p(this.this$0);
                if (access$getBaseActivity$p16 != null) {
                    ((SalesDocumentActivity) access$getBaseActivity$p16).loadSwipedProductList(i3, i4);
                    return;
                }
                throw new TypeCastException("null cannot be cast to non-null type com.iaai.android.bdt.feature.account.salesdocument.SalesDocumentActivity");
            }
        }
    }

    public void onPageScrollStateChanged(int i) {
        this.this$0.clearCostCalculatorSharedPreference();
    }
}

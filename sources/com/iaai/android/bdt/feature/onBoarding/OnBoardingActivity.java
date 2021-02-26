package com.iaai.android.bdt.feature.onBoarding;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentActivity;
import com.bumptech.glide.Glide;
import com.bumptech.glide.Priority;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.request.RequestOptions;
import com.iaai.android.C2723R;
import com.iaai.android.bdt.utils.Constants_MVVM;
import com.iaai.android.bdt.utils.Utils;
import com.synnapps.carouselview.CarouselView;
import com.synnapps.carouselview.ImageListener;
import java.io.Serializable;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.TypeCastException;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.Nullable;

@Metadata(mo66931bv = {1, 0, 3}, mo66932d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0015\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u0013\u001a\u00020\u0014H\u0002J\b\u0010\u0015\u001a\u00020\u0014H\u0002J\b\u0010\u0016\u001a\u00020\u0014H\u0002J\u0012\u0010\u0017\u001a\u00020\u00142\b\u0010\u0018\u001a\u0004\u0018\u00010\u0019H\u0014J\u0010\u0010\u001a\u001a\u00020\u00142\u0006\u0010\u001b\u001a\u00020\u0004H\u0002J\u0018\u0010\u001c\u001a\u00020\u00142\u0006\u0010\u001b\u001a\u00020\u00042\u0006\u0010\u001d\u001a\u00020\u001eH\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0006X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0006X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0006X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0006X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0004X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0006X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0006X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0006X\u0004¢\u0006\u0002\n\u0000¨\u0006\u001f"}, mo66933d2 = {"Lcom/iaai/android/bdt/feature/onBoarding/OnBoardingActivity;", "Landroidx/appcompat/app/AppCompatActivity;", "()V", "currentPosition", "", "fastSearch", "", "fastSearchSpanish", "findVehicleImages", "imageListener", "Lcom/synnapps/carouselview/ImageListener;", "manageOffersImages", "manageOffersImagesMyAccount", "origin", "Lcom/iaai/android/bdt/feature/onBoarding/OnBoardingEnum;", "pageSize", "paymentMthodPayPal", "productDetailEnginVedioOnlyImages", "productDetailImages", "initializeButtons", "", "initializeCarousel", "initializeUI", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "setHintHeaderAndMSG", "position", "vehicleImageUrl", "imageView", "Landroid/widget/ImageView;", "app_productionRelease"}, mo66934k = 1, mo66935mv = {1, 1, 13})
/* compiled from: OnBoardingActivity.kt */
public final class OnBoardingActivity extends AppCompatActivity {
    private HashMap _$_findViewCache;
    /* access modifiers changed from: private */
    public int currentPosition;
    private final int[] fastSearch = {C2723R.C2725drawable.img_hint_big_news, C2723R.C2725drawable.img_hint_vehicle_sale_filters, C2723R.C2725drawable.img_hint_new_fast_search_multiselect, C2723R.C2725drawable.img_hint_new_inventory, C2723R.C2725drawable.img_hint_series, C2723R.C2725drawable.img_hint_market, C2723R.C2725drawable.img_hint_saving_a_search, C2723R.C2725drawable.img_hint_saved_searches_landing, C2723R.C2725drawable.img_hint_conclusion};
    private final int[] fastSearchSpanish = {C2723R.C2725drawable.img_hint_big_news_spanish, C2723R.C2725drawable.img_hint_vehicle_sale_filters, C2723R.C2725drawable.img_hint_new_fast_search_multiselect, C2723R.C2725drawable.img_hint_new_inventory, C2723R.C2725drawable.img_hint_series, C2723R.C2725drawable.img_hint_market, C2723R.C2725drawable.img_hint_saving_a_search, C2723R.C2725drawable.img_hint_saved_searches_landing, C2723R.C2725drawable.img_hint_conclusion_spanish};
    private final int[] findVehicleImages = {C2723R.C2725drawable.img_hint_multiselect};
    private ImageListener imageListener = new OnBoardingActivity$imageListener$1(this);
    private final int[] manageOffersImages = {C2723R.C2725drawable.img_hint_manage_offers};
    private final int[] manageOffersImagesMyAccount = {C2723R.C2725drawable.image_hint_manage_offers_my_account};
    private OnBoardingEnum origin = OnBoardingEnum.PRODUCT_DETAIL;
    private int pageSize;
    private final int[] paymentMthodPayPal = {C2723R.C2725drawable.img_hint_payment_method_paypal};
    private final int[] productDetailEnginVedioOnlyImages = {C2723R.C2725drawable.img_hint_video};
    private final int[] productDetailImages = {C2723R.C2725drawable.img_hint_key, C2723R.C2725drawable.img_hint_share, C2723R.C2725drawable.img_hint_video};

    public void _$_clearFindViewByIdCache() {
        HashMap hashMap = this._$_findViewCache;
        if (hashMap != null) {
            hashMap.clear();
        }
    }

    public View _$_findCachedViewById(int i) {
        if (this._$_findViewCache == null) {
            this._$_findViewCache = new HashMap();
        }
        View view = (View) this._$_findViewCache.get(Integer.valueOf(i));
        if (view != null) {
            return view;
        }
        View findViewById = findViewById(i);
        this._$_findViewCache.put(Integer.valueOf(i), findViewById);
        return findViewById;
    }

    /* access modifiers changed from: protected */
    public void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        setContentView((int) C2723R.C2728layout.activity_on_boarding);
        Serializable serializableExtra = getIntent().getSerializableExtra(Constants_MVVM.ON_BOARDING_ENUM_VALUE);
        if (serializableExtra != null) {
            this.origin = (OnBoardingEnum) serializableExtra;
            int i = 1;
            switch (this.origin) {
                case PRODUCT_DETAIL:
                    i = getResources().getStringArray(C2723R.array.product_detail_hint_title).length;
                    break;
                case FIND_VEHICLES:
                case PAYMENT_METHOD_PAYPAL:
                    break;
                case ENGINE_VIDEO_ONLY:
                    i = getResources().getStringArray(C2723R.array.product_detail_engine_video_only_hint_title).length;
                    break;
                case ENGINE_VIDEO_WITH_ALL_SCREEN:
                    i = getResources().getStringArray(C2723R.array.product_detail_engine_video_hint_title).length;
                    break;
                case MANAGE_OFFER_HOME:
                    i = getResources().getStringArray(C2723R.array.manage_offers_hint_title).length;
                    break;
                case MANAGE_OFFER_MYACCOUNT:
                    i = getResources().getStringArray(C2723R.array.manage_offers_hint_title).length;
                    break;
                case FAST_SEARCH:
                    i = getResources().getStringArray(C2723R.array.vehicle_sale_filter_hint_title).length;
                    break;
                default:
                    throw new NoWhenBranchMatchedException();
            }
            this.pageSize = i;
            setHintHeaderAndMSG(0);
            initializeUI();
            initializeButtons();
            initializeCarousel();
            return;
        }
        throw new TypeCastException("null cannot be cast to non-null type com.iaai.android.bdt.feature.onBoarding.OnBoardingEnum");
    }

    /* access modifiers changed from: private */
    public final void initializeUI() {
        int i = this.pageSize;
        if (i == 1) {
            LinearLayout linearLayout = (LinearLayout) _$_findCachedViewById(C2723R.C2726id.llNext);
            Intrinsics.checkExpressionValueIsNotNull(linearLayout, "llNext");
            linearLayout.setVisibility(8);
            RelativeLayout relativeLayout = (RelativeLayout) _$_findCachedViewById(C2723R.C2726id.llPrevious);
            Intrinsics.checkExpressionValueIsNotNull(relativeLayout, "llPrevious");
            relativeLayout.setVisibility(8);
            return;
        }
        if (this.currentPosition == i - 1) {
            LinearLayout linearLayout2 = (LinearLayout) _$_findCachedViewById(C2723R.C2726id.llNext);
            Intrinsics.checkExpressionValueIsNotNull(linearLayout2, "llNext");
            linearLayout2.setVisibility(8);
        } else {
            LinearLayout linearLayout3 = (LinearLayout) _$_findCachedViewById(C2723R.C2726id.llNext);
            Intrinsics.checkExpressionValueIsNotNull(linearLayout3, "llNext");
            linearLayout3.setVisibility(0);
        }
        if (this.currentPosition == 0) {
            RelativeLayout relativeLayout2 = (RelativeLayout) _$_findCachedViewById(C2723R.C2726id.llPrevious);
            Intrinsics.checkExpressionValueIsNotNull(relativeLayout2, "llPrevious");
            relativeLayout2.setVisibility(8);
            return;
        }
        RelativeLayout relativeLayout3 = (RelativeLayout) _$_findCachedViewById(C2723R.C2726id.llPrevious);
        Intrinsics.checkExpressionValueIsNotNull(relativeLayout3, "llPrevious");
        relativeLayout3.setVisibility(0);
    }

    private final void initializeButtons() {
        ((TextView) _$_findCachedViewById(C2723R.C2726id.tvClose)).setOnClickListener(new OnBoardingActivity$initializeButtons$1(this));
        ((RelativeLayout) _$_findCachedViewById(C2723R.C2726id.llPrevious)).setOnClickListener(new OnBoardingActivity$initializeButtons$2(this));
        ((LinearLayout) _$_findCachedViewById(C2723R.C2726id.llNext)).setOnClickListener(new OnBoardingActivity$initializeButtons$3(this));
    }

    private final void initializeCarousel() {
        CarouselView carouselView = (CarouselView) _$_findCachedViewById(C2723R.C2726id.cvOnBoarding);
        Intrinsics.checkExpressionValueIsNotNull(carouselView, "cvOnBoarding");
        carouselView.setPageCount(this.pageSize);
        if (this.pageSize == 1) {
            ((CarouselView) _$_findCachedViewById(C2723R.C2726id.cvOnBoarding)).setIndicatorVisibility(8);
        } else {
            ((CarouselView) _$_findCachedViewById(C2723R.C2726id.cvOnBoarding)).setIndicatorVisibility(0);
        }
        ((CarouselView) _$_findCachedViewById(C2723R.C2726id.cvOnBoarding)).addOnPageChangeListener(new OnBoardingActivity$initializeCarousel$1(this));
        ((CarouselView) _$_findCachedViewById(C2723R.C2726id.cvOnBoarding)).setImageListener(this.imageListener);
    }

    /* access modifiers changed from: private */
    public final void setHintHeaderAndMSG(int i) {
        switch (this.origin) {
            case PRODUCT_DETAIL:
                TextView textView = (TextView) _$_findCachedViewById(C2723R.C2726id.tvHeader);
                Intrinsics.checkExpressionValueIsNotNull(textView, "tvHeader");
                textView.setText(getResources().getStringArray(C2723R.array.product_detail_hint_title)[i]);
                TextView textView2 = (TextView) _$_findCachedViewById(C2723R.C2726id.tvMessage);
                Intrinsics.checkExpressionValueIsNotNull(textView2, "tvMessage");
                textView2.setText(getResources().getStringArray(C2723R.array.product_detail_hint_message)[i]);
                return;
            case FIND_VEHICLES:
                TextView textView3 = (TextView) _$_findCachedViewById(C2723R.C2726id.tvHeader);
                Intrinsics.checkExpressionValueIsNotNull(textView3, "tvHeader");
                textView3.setText(getResources().getStringArray(C2723R.array.find_details_hint_title)[i]);
                TextView textView4 = (TextView) _$_findCachedViewById(C2723R.C2726id.tvMessage);
                Intrinsics.checkExpressionValueIsNotNull(textView4, "tvMessage");
                textView4.setText(getResources().getStringArray(C2723R.array.find_details_hint_message)[i]);
                return;
            case ENGINE_VIDEO_ONLY:
                TextView textView5 = (TextView) _$_findCachedViewById(C2723R.C2726id.tvHeader);
                Intrinsics.checkExpressionValueIsNotNull(textView5, "tvHeader");
                textView5.setText(getResources().getStringArray(C2723R.array.product_detail_engine_video_only_hint_title)[i]);
                TextView textView6 = (TextView) _$_findCachedViewById(C2723R.C2726id.tvMessage);
                Intrinsics.checkExpressionValueIsNotNull(textView6, "tvMessage");
                textView6.setText(getResources().getStringArray(C2723R.array.product_detail_engine_video_only_hint_message)[i]);
                return;
            case ENGINE_VIDEO_WITH_ALL_SCREEN:
                TextView textView7 = (TextView) _$_findCachedViewById(C2723R.C2726id.tvHeader);
                Intrinsics.checkExpressionValueIsNotNull(textView7, "tvHeader");
                textView7.setText(getResources().getStringArray(C2723R.array.product_detail_engine_video_hint_title)[i]);
                TextView textView8 = (TextView) _$_findCachedViewById(C2723R.C2726id.tvMessage);
                Intrinsics.checkExpressionValueIsNotNull(textView8, "tvMessage");
                textView8.setText(getResources().getStringArray(C2723R.array.product_detail_engine_video_hint_message)[i]);
                return;
            case MANAGE_OFFER_HOME:
                TextView textView9 = (TextView) _$_findCachedViewById(C2723R.C2726id.tvHeader);
                Intrinsics.checkExpressionValueIsNotNull(textView9, "tvHeader");
                textView9.setText(getResources().getStringArray(C2723R.array.manage_offers_hint_title)[i]);
                TextView textView10 = (TextView) _$_findCachedViewById(C2723R.C2726id.tvMessage);
                Intrinsics.checkExpressionValueIsNotNull(textView10, "tvMessage");
                textView10.setText(getResources().getStringArray(C2723R.array.manage_offers_hint_message)[i]);
                return;
            case MANAGE_OFFER_MYACCOUNT:
                TextView textView11 = (TextView) _$_findCachedViewById(C2723R.C2726id.tvHeader);
                Intrinsics.checkExpressionValueIsNotNull(textView11, "tvHeader");
                textView11.setText(getResources().getStringArray(C2723R.array.manage_offers_hint_title)[i]);
                TextView textView12 = (TextView) _$_findCachedViewById(C2723R.C2726id.tvMessage);
                Intrinsics.checkExpressionValueIsNotNull(textView12, "tvMessage");
                textView12.setText(getResources().getStringArray(C2723R.array.manage_offers_hint_message)[i]);
                return;
            case PAYMENT_METHOD_PAYPAL:
                TextView textView13 = (TextView) _$_findCachedViewById(C2723R.C2726id.tvHeader);
                Intrinsics.checkExpressionValueIsNotNull(textView13, "tvHeader");
                textView13.setText(getResources().getStringArray(C2723R.array.payment_method_payPal_hint_title)[i]);
                TextView textView14 = (TextView) _$_findCachedViewById(C2723R.C2726id.tvMessage);
                Intrinsics.checkExpressionValueIsNotNull(textView14, "tvMessage");
                textView14.setText(getResources().getStringArray(C2723R.array.payment_method_payPal_hint_message)[i]);
                return;
            case FAST_SEARCH:
                TextView textView15 = (TextView) _$_findCachedViewById(C2723R.C2726id.tvHeader);
                Intrinsics.checkExpressionValueIsNotNull(textView15, "tvHeader");
                textView15.setText(getResources().getStringArray(C2723R.array.vehicle_sale_filter_hint_title)[i]);
                TextView textView16 = (TextView) _$_findCachedViewById(C2723R.C2726id.tvMessage);
                Intrinsics.checkExpressionValueIsNotNull(textView16, "tvMessage");
                textView16.setText(getResources().getStringArray(C2723R.array.vehicle_sale_filter_hint_message)[i]);
                return;
            default:
                return;
        }
    }

    /* access modifiers changed from: private */
    public final void vehicleImageUrl(int i, ImageView imageView) {
        switch (this.origin) {
            case PRODUCT_DETAIL:
                Glide.with((FragmentActivity) this).load(Integer.valueOf(this.productDetailImages[i])).apply(new RequestOptions().error((int) C2723R.C2725drawable.img_hint_key).diskCacheStrategy(DiskCacheStrategy.ALL).priority(Priority.HIGH).placeholder((int) C2723R.C2725drawable.img_hint_key)).into(imageView);
                return;
            case FIND_VEHICLES:
                Glide.with((FragmentActivity) this).load(Integer.valueOf(this.findVehicleImages[i])).apply(new RequestOptions().error((int) C2723R.C2725drawable.img_hint_multiselect).diskCacheStrategy(DiskCacheStrategy.ALL).priority(Priority.HIGH).placeholder((int) C2723R.C2725drawable.img_hint_multiselect)).into(imageView);
                return;
            case ENGINE_VIDEO_ONLY:
                Glide.with((FragmentActivity) this).load(Integer.valueOf(this.productDetailEnginVedioOnlyImages[i])).apply(new RequestOptions().error((int) C2723R.C2725drawable.img_hint_video).diskCacheStrategy(DiskCacheStrategy.ALL).priority(Priority.HIGH).placeholder((int) C2723R.C2725drawable.img_hint_video)).into(imageView);
                return;
            case ENGINE_VIDEO_WITH_ALL_SCREEN:
                Glide.with((FragmentActivity) this).load(Integer.valueOf(this.productDetailImages[i])).apply(new RequestOptions().error((int) C2723R.C2725drawable.img_hint_key).diskCacheStrategy(DiskCacheStrategy.ALL).priority(Priority.HIGH).placeholder((int) C2723R.C2725drawable.img_hint_key)).into(imageView);
                return;
            case MANAGE_OFFER_HOME:
                Glide.with((FragmentActivity) this).load(Integer.valueOf(this.manageOffersImages[i])).apply(new RequestOptions().error((int) C2723R.C2725drawable.img_hint_manage_offers).diskCacheStrategy(DiskCacheStrategy.ALL).priority(Priority.HIGH).placeholder((int) C2723R.C2725drawable.img_hint_manage_offers)).into(imageView);
                return;
            case MANAGE_OFFER_MYACCOUNT:
                Glide.with((FragmentActivity) this).load(Integer.valueOf(this.manageOffersImagesMyAccount[i])).apply(new RequestOptions().error((int) C2723R.C2725drawable.image_hint_manage_offers_my_account).diskCacheStrategy(DiskCacheStrategy.ALL).priority(Priority.HIGH).placeholder((int) C2723R.C2725drawable.image_hint_manage_offers_my_account)).into(imageView);
                return;
            case PAYMENT_METHOD_PAYPAL:
                Glide.with((FragmentActivity) this).load(Integer.valueOf(this.paymentMthodPayPal[i])).apply(new RequestOptions().error((int) C2723R.C2725drawable.img_hint_payment_method_paypal).diskCacheStrategy(DiskCacheStrategy.ALL).priority(Priority.HIGH).placeholder((int) C2723R.C2725drawable.img_hint_payment_method_paypal)).into(imageView);
                return;
            case FAST_SEARCH:
                int i2 = this.fastSearch[i];
                if (Intrinsics.areEqual((Object) Utils.getLanguage(), (Object) Constants_MVVM.EXTRA_SPANISH_CODE)) {
                    i2 = this.fastSearchSpanish[i];
                }
                Glide.with((FragmentActivity) this).load(Integer.valueOf(i2)).apply(new RequestOptions().error((int) C2723R.C2725drawable.ic_hint_new_search_vehicle_sale_filter).diskCacheStrategy(DiskCacheStrategy.ALL).priority(Priority.HIGH).placeholder((int) C2723R.C2725drawable.ic_hint_new_search_vehicle_sale_filter)).into(imageView);
                return;
            default:
                return;
        }
    }
}

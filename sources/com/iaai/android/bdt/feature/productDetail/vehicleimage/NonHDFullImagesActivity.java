package com.iaai.android.bdt.feature.productDetail.vehicleimage;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.iaai.android.C2723R;
import com.iaai.android.bdt.analytics.IAAAnalytics;
import com.iaai.android.bdt.model.productDetail.biddingInfo.Image;
import com.iaai.android.bdt.utils.Constants_MVVM;
import com.iaai.android.bdt.utils.NonHDImagesMode;
import com.iaai.android.old.activities.ImageClickListener;
import com.iaai.android.old.utils.p016ui.CirclePageIndicator;
import com.iaai.android.old.utils.p016ui.touchgallery.GalleryViewPager;
import com.iaai.android.old.utils.p016ui.touchgallery.UrlPagerAdapter;
import com.synnapps.carouselview.ImageListener;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.Nullable;

@Metadata(mo66931bv = {1, 0, 3}, mo66932d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u00012\u00020\u0002B\u0005¢\u0006\u0002\u0010\u0003J\b\u0010\u000f\u001a\u00020\u0010H\u0002J\b\u0010\u0011\u001a\u00020\u0010H\u0002J\b\u0010\u0012\u001a\u00020\u0010H\u0002J\u0012\u0010\u0013\u001a\u00020\u00102\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015H\u0014J\b\u0010\u0016\u001a\u00020\u0010H\u0016J\b\u0010\u0017\u001a\u00020\u0010H\u0014J\b\u0010\u0018\u001a\u00020\u0010H\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000bX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX.¢\u0006\u0002\n\u0000¨\u0006\u0019"}, mo66933d2 = {"Lcom/iaai/android/bdt/feature/productDetail/vehicleimage/NonHDFullImagesActivity;", "Landroidx/appcompat/app/AppCompatActivity;", "Lcom/iaai/android/old/activities/ImageClickListener;", "()V", "imageListener", "Lcom/synnapps/carouselview/ImageListener;", "mode", "Lcom/iaai/android/bdt/utils/NonHDImagesMode;", "position", "", "vehicleImages", "", "Lcom/iaai/android/bdt/model/productDetail/biddingInfo/Image;", "vehicleImagesNonHDAdapter", "Lcom/iaai/android/bdt/feature/productDetail/vehicleimage/VehicleImagesNonHDAdapter;", "initializeBtnActions", "", "initializeCarouselView", "initializeRecycler", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onImageClick", "onResume", "updateUI", "app_productionRelease"}, mo66934k = 1, mo66935mv = {1, 1, 13})
/* compiled from: NonHDFullImagesActivity.kt */
public final class NonHDFullImagesActivity extends AppCompatActivity implements ImageClickListener {
    private HashMap _$_findViewCache;
    private ImageListener imageListener = new NonHDFullImagesActivity$imageListener$1(this);
    /* access modifiers changed from: private */
    public NonHDImagesMode mode = NonHDImagesMode.DEFAULT;
    /* access modifiers changed from: private */
    public int position;
    /* access modifiers changed from: private */
    public List<Image> vehicleImages = CollectionsKt.emptyList();
    private VehicleImagesNonHDAdapter vehicleImagesNonHDAdapter;

    @Metadata(mo66931bv = {1, 0, 3}, mo66934k = 3, mo66935mv = {1, 1, 13})
    public final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0 = new int[NonHDImagesMode.values().length];

        static {
            $EnumSwitchMapping$0[NonHDImagesMode.DEFAULT.ordinal()] = 1;
            $EnumSwitchMapping$0[NonHDImagesMode.GRID_VIEW.ordinal()] = 2;
            $EnumSwitchMapping$0[NonHDImagesMode.LIST_VIEW.ordinal()] = 3;
        }
    }

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

    public void onImageClick() {
    }

    /* access modifiers changed from: protected */
    public void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        setContentView((int) C2723R.C2728layout.activity_non_hdfull_images);
        this.position = getIntent().getIntExtra(Constants_MVVM.VEHICLE_IMAGE_CLICKED_POSITION, 0);
        Serializable serializableExtra = getIntent().getSerializableExtra(Constants_MVVM.VEHICLE_IMAGES_LAUNCH_MODE);
        if (serializableExtra != null) {
            this.mode = (NonHDImagesMode) serializableExtra;
            Serializable serializableExtra2 = getIntent().getSerializableExtra(Constants_MVVM.VEHICLE_IMAGES_INFO);
            if (serializableExtra2 != null) {
                this.vehicleImages = (List) serializableExtra2;
                updateUI();
                initializeBtnActions();
                return;
            }
            throw new TypeCastException("null cannot be cast to non-null type kotlin.collections.List<com.iaai.android.bdt.model.productDetail.biddingInfo.Image>");
        }
        throw new TypeCastException("null cannot be cast to non-null type com.iaai.android.bdt.utils.NonHDImagesMode");
    }

    /* access modifiers changed from: protected */
    public void onResume() {
        super.onResume();
        IAAAnalytics.INSTANCE.logScreenName(IAAAnalytics.IAAScreenName.IMAGE_VIEW.getValue(), this);
    }

    /* access modifiers changed from: private */
    public final void updateUI() {
        int i = WhenMappings.$EnumSwitchMapping$0[this.mode.ordinal()];
        if (i == 1) {
            RecyclerView recyclerView = (RecyclerView) _$_findCachedViewById(C2723R.C2726id.rvVehicleImages);
            Intrinsics.checkExpressionValueIsNotNull(recyclerView, "rvVehicleImages");
            recyclerView.setVisibility(8);
            LinearLayout linearLayout = (LinearLayout) _$_findCachedViewById(C2723R.C2726id.enlarge_image_view);
            Intrinsics.checkExpressionValueIsNotNull(linearLayout, "enlarge_image_view");
            linearLayout.setVisibility(0);
            initializeCarouselView();
        } else if (i == 2 || i == 3) {
            RecyclerView recyclerView2 = (RecyclerView) _$_findCachedViewById(C2723R.C2726id.rvVehicleImages);
            Intrinsics.checkExpressionValueIsNotNull(recyclerView2, "rvVehicleImages");
            recyclerView2.setVisibility(0);
            LinearLayout linearLayout2 = (LinearLayout) _$_findCachedViewById(C2723R.C2726id.enlarge_image_view);
            Intrinsics.checkExpressionValueIsNotNull(linearLayout2, "enlarge_image_view");
            linearLayout2.setVisibility(8);
            initializeRecycler();
        }
    }

    private final void initializeRecycler() {
        Context context = this;
        ((RecyclerView) _$_findCachedViewById(C2723R.C2726id.rvVehicleImages)).addItemDecoration(new DividerItemDecoration(context, 1));
        this.vehicleImagesNonHDAdapter = new VehicleImagesNonHDAdapter(context, this.mode, new NonHDFullImagesActivity$initializeRecycler$1(this));
        VehicleImagesNonHDAdapter vehicleImagesNonHDAdapter2 = this.vehicleImagesNonHDAdapter;
        if (vehicleImagesNonHDAdapter2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("vehicleImagesNonHDAdapter");
        }
        vehicleImagesNonHDAdapter2.setData(this.vehicleImages);
        RecyclerView recyclerView = (RecyclerView) _$_findCachedViewById(C2723R.C2726id.rvVehicleImages);
        Intrinsics.checkExpressionValueIsNotNull(recyclerView, "rvVehicleImages");
        VehicleImagesNonHDAdapter vehicleImagesNonHDAdapter3 = this.vehicleImagesNonHDAdapter;
        if (vehicleImagesNonHDAdapter3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("vehicleImagesNonHDAdapter");
        }
        recyclerView.setAdapter(vehicleImagesNonHDAdapter3);
        if (this.mode == NonHDImagesMode.LIST_VIEW) {
            RecyclerView recyclerView2 = (RecyclerView) _$_findCachedViewById(C2723R.C2726id.rvVehicleImages);
            Intrinsics.checkExpressionValueIsNotNull(recyclerView2, "rvVehicleImages");
            recyclerView2.setLayoutManager(new LinearLayoutManager(context));
            return;
        }
        RecyclerView recyclerView3 = (RecyclerView) _$_findCachedViewById(C2723R.C2726id.rvVehicleImages);
        Intrinsics.checkExpressionValueIsNotNull(recyclerView3, "rvVehicleImages");
        recyclerView3.setLayoutManager(new GridLayoutManager(context, 2));
    }

    private final void initializeBtnActions() {
        ((ImageView) _$_findCachedViewById(C2723R.C2726id.ivGridView)).setOnClickListener(new NonHDFullImagesActivity$initializeBtnActions$1(this));
        ((ImageView) _$_findCachedViewById(C2723R.C2726id.ivListView)).setOnClickListener(new NonHDFullImagesActivity$initializeBtnActions$2(this));
        ((ImageView) _$_findCachedViewById(C2723R.C2726id.ivBack)).setOnClickListener(new NonHDFullImagesActivity$initializeBtnActions$3(this));
    }

    private final void initializeCarouselView() {
        ArrayList arrayList = new ArrayList();
        for (Image url : this.vehicleImages) {
            arrayList.add(url.getUrl());
        }
        UrlPagerAdapter urlPagerAdapter = new UrlPagerAdapter(this, arrayList, this);
        GalleryViewPager galleryViewPager = (GalleryViewPager) _$_findCachedViewById(C2723R.C2726id.viewFullImage);
        Intrinsics.checkExpressionValueIsNotNull(galleryViewPager, "viewFullImage");
        galleryViewPager.setOffscreenPageLimit(5);
        GalleryViewPager galleryViewPager2 = (GalleryViewPager) _$_findCachedViewById(C2723R.C2726id.viewFullImage);
        Intrinsics.checkExpressionValueIsNotNull(galleryViewPager2, "viewFullImage");
        galleryViewPager2.setAdapter(urlPagerAdapter);
        ((CirclePageIndicator) _$_findCachedViewById(C2723R.C2726id.pageIndicator)).setViewPager((GalleryViewPager) _$_findCachedViewById(C2723R.C2726id.viewFullImage));
        CirclePageIndicator circlePageIndicator = (CirclePageIndicator) _$_findCachedViewById(C2723R.C2726id.pageIndicator);
        Intrinsics.checkExpressionValueIsNotNull(circlePageIndicator, "pageIndicator");
        circlePageIndicator.setFillColor(getResources().getColor(C2723R.C2724color.iaa_red));
        CirclePageIndicator circlePageIndicator2 = (CirclePageIndicator) _$_findCachedViewById(C2723R.C2726id.pageIndicator);
        Intrinsics.checkExpressionValueIsNotNull(circlePageIndicator2, "pageIndicator");
        circlePageIndicator2.setPageColor(getResources().getColor(C2723R.C2724color.iaa_circle_indicator_enlarge_page_dot_stroke_color));
        CirclePageIndicator circlePageIndicator3 = (CirclePageIndicator) _$_findCachedViewById(C2723R.C2726id.pageIndicator);
        Intrinsics.checkExpressionValueIsNotNull(circlePageIndicator3, "pageIndicator");
        circlePageIndicator3.setStrokeColor(getResources().getColor(C2723R.C2724color.iaa_circle_indicator_enlarge_page_dot_stroke_color));
        GalleryViewPager galleryViewPager3 = (GalleryViewPager) _$_findCachedViewById(C2723R.C2726id.viewFullImage);
        Intrinsics.checkExpressionValueIsNotNull(galleryViewPager3, "viewFullImage");
        galleryViewPager3.setCurrentItem(this.position);
    }
}

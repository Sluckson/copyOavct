package com.iaai.android.old.activities;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import androidx.viewpager.widget.ViewPager;
import com.iaai.android.C2723R;
import com.iaai.android.old.utils.constants.Constants;
import com.iaai.android.old.utils.p016ui.CirclePageIndicator;
import com.iaai.android.old.utils.p016ui.touchgallery.GalleryViewPager;
import com.iaai.android.old.utils.p016ui.touchgallery.UrlPagerAdapter;
import java.util.ArrayList;
import java.util.Collections;
import roboguice.inject.InjectView;

public class VehicleNonHDFullImages extends AbstractActivity implements ImageClickListener {
    @InjectView(2131296462)
    ImageView back_arrow;
    @InjectView(2131296466)
    RelativeLayout back_arrow_layout;
    @InjectView(2131296920)
    LinearLayout enlarge_image_view;
    @InjectView(2131297168)
    ImageView img_gridview;
    @InjectView(2131297173)
    ImageView img_listview;
    int index;
    @InjectView(2131297056)
    CirclePageIndicator pageIndicator;
    String[] urls;
    private int view_type;
    @InjectView(2131297055)
    ViewPager viewpager;

    public void onImageClick() {
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.urls = getIntent().getStringArrayExtra("url");
        this.index = getIntent().getIntExtra(Constants.EXTRA_IMAGE_INDEX, 0);
        this.view_type = getIntent().getIntExtra(Constants.EXTRA_VIEW_TYPE, 0);
        initNonHDImage();
    }

    private void initNonHDImage() {
        setContentView((int) C2723R.C2728layout.vehicle_details_full_non_hd_images);
        ArrayList arrayList = new ArrayList();
        String[] strArr = this.urls;
        if (strArr != null) {
            Collections.addAll(arrayList, strArr);
        }
        this.enlarge_image_view.setVisibility(0);
        UrlPagerAdapter urlPagerAdapter = new UrlPagerAdapter(this, arrayList, this);
        GalleryViewPager galleryViewPager = (GalleryViewPager) this.viewpager;
        galleryViewPager.setOffscreenPageLimit(5);
        galleryViewPager.setAdapter(urlPagerAdapter);
        this.pageIndicator.setViewPager(galleryViewPager);
        this.pageIndicator.setFillColor(getResources().getColor(C2723R.C2724color.iaa_circle_indicator_enlarge_page_dot_active_color));
        this.pageIndicator.setPageColor(getResources().getColor(C2723R.C2724color.iaa_circle_indicator_enlarge_page_dot_inactive_color));
        this.pageIndicator.setStrokeColor(getResources().getColor(C2723R.C2724color.iaa_circle_indicator_enlarge_page_dot_stroke_color));
        galleryViewPager.setCurrentItem(this.index);
        this.back_arrow.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                VehicleNonHDFullImages.this.finish();
            }
        });
        this.img_gridview.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                VehicleNonHDFullImages.this.navigateVehicleInteraction(Constants.VIEW_TYPE_GRID_IMAGE);
            }
        });
        this.img_listview.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                VehicleNonHDFullImages.this.navigateVehicleInteraction(Constants.VIEW_TYPE_LIST_IMAGE);
            }
        });
    }

    /* access modifiers changed from: private */
    public void navigateVehicleInteraction(int i) {
        Intent intent = new Intent(this, VehicleImageInteractionActivity.class);
        intent.putExtra("url", this.urls);
        intent.putExtra(Constants.EXTRA_IMAGE_INDEX, this.index);
        intent.putExtra(Constants.EXTRA_VIEW_TYPE, i);
        startActivity(intent);
    }

    /* access modifiers changed from: protected */
    public void onResume() {
        super.onResume();
        getWindow().getDecorView().setSystemUiVisibility(1);
    }
}

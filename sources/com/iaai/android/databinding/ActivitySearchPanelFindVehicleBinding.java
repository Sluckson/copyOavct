package com.iaai.android.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.Toolbar;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.iaai.android.C2723R;

public abstract class ActivitySearchPanelFindVehicleBinding extends ViewDataBinding {
    @NonNull
    public final ConstraintLayout clSearchContainer;
    @NonNull
    public final RelativeLayout flSearchContainer;
    @NonNull
    public final ImageButton imgBack;
    @NonNull
    public final ImageButton imgClearText;
    @NonNull
    public final ImageButton imgVoiceText;
    @NonNull
    public final LinearLayout llContainerSearchBy;
    @NonNull
    public final LinearLayout llMicClr;
    @NonNull
    public final EditText newKeywordSearch;
    @NonNull
    public final RelativeLayout rlTitlebarConatiner;
    @NonNull
    public final Toolbar toolbar;
    @NonNull
    public final TextView toolbarHeader;
    @NonNull
    public final TextView tvSearchByAuction;
    @NonNull
    public final TextView tvSearchByVehicle;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    protected ActivitySearchPanelFindVehicleBinding(Object obj, View view, int i, ConstraintLayout constraintLayout, RelativeLayout relativeLayout, ImageButton imageButton, ImageButton imageButton2, ImageButton imageButton3, LinearLayout linearLayout, LinearLayout linearLayout2, EditText editText, RelativeLayout relativeLayout2, Toolbar toolbar2, TextView textView, TextView textView2, TextView textView3) {
        super(obj, view, i);
        this.clSearchContainer = constraintLayout;
        this.flSearchContainer = relativeLayout;
        this.imgBack = imageButton;
        this.imgClearText = imageButton2;
        this.imgVoiceText = imageButton3;
        this.llContainerSearchBy = linearLayout;
        this.llMicClr = linearLayout2;
        this.newKeywordSearch = editText;
        this.rlTitlebarConatiner = relativeLayout2;
        this.toolbar = toolbar2;
        this.toolbarHeader = textView;
        this.tvSearchByAuction = textView2;
        this.tvSearchByVehicle = textView3;
    }

    @NonNull
    public static ActivitySearchPanelFindVehicleBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    @Deprecated
    public static ActivitySearchPanelFindVehicleBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z, @Nullable Object obj) {
        return (ActivitySearchPanelFindVehicleBinding) ViewDataBinding.inflateInternal(layoutInflater, C2723R.C2728layout.activity_search_panel_find_vehicle, viewGroup, z, obj);
    }

    @NonNull
    public static ActivitySearchPanelFindVehicleBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    @Deprecated
    public static ActivitySearchPanelFindVehicleBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable Object obj) {
        return (ActivitySearchPanelFindVehicleBinding) ViewDataBinding.inflateInternal(layoutInflater, C2723R.C2728layout.activity_search_panel_find_vehicle, (ViewGroup) null, false, obj);
    }

    public static ActivitySearchPanelFindVehicleBinding bind(@NonNull View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ActivitySearchPanelFindVehicleBinding bind(@NonNull View view, @Nullable Object obj) {
        return (ActivitySearchPanelFindVehicleBinding) bind(obj, view, C2723R.C2728layout.activity_search_panel_find_vehicle);
    }
}

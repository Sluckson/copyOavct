package com.iaai.android.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView;
import com.iaai.android.C2723R;

public abstract class ContentSearchPanelFindVehicleBinding extends ViewDataBinding {
    @NonNull
    public final LinearLayout clSuggestions;
    @NonNull
    public final View emptySuggestions;
    @NonNull
    public final RecyclerView rvSearchSuggestion;
    @NonNull
    public final View searchSeprator;
    @NonNull
    public final TextView tvSuggestionLabel;

    protected ContentSearchPanelFindVehicleBinding(Object obj, View view, int i, LinearLayout linearLayout, View view2, RecyclerView recyclerView, View view3, TextView textView) {
        super(obj, view, i);
        this.clSuggestions = linearLayout;
        this.emptySuggestions = view2;
        this.rvSearchSuggestion = recyclerView;
        this.searchSeprator = view3;
        this.tvSuggestionLabel = textView;
    }

    @NonNull
    public static ContentSearchPanelFindVehicleBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    @Deprecated
    public static ContentSearchPanelFindVehicleBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z, @Nullable Object obj) {
        return (ContentSearchPanelFindVehicleBinding) ViewDataBinding.inflateInternal(layoutInflater, C2723R.C2728layout.content_search_panel_find_vehicle, viewGroup, z, obj);
    }

    @NonNull
    public static ContentSearchPanelFindVehicleBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    @Deprecated
    public static ContentSearchPanelFindVehicleBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable Object obj) {
        return (ContentSearchPanelFindVehicleBinding) ViewDataBinding.inflateInternal(layoutInflater, C2723R.C2728layout.content_search_panel_find_vehicle, (ViewGroup) null, false, obj);
    }

    public static ContentSearchPanelFindVehicleBinding bind(@NonNull View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ContentSearchPanelFindVehicleBinding bind(@NonNull View view, @Nullable Object obj) {
        return (ContentSearchPanelFindVehicleBinding) bind(obj, view, C2723R.C2728layout.content_search_panel_find_vehicle);
    }
}

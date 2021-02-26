package com.iaai.android.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView;
import com.iaai.android.C2723R;

public abstract class FragmentSearchByVehicleBinding extends ViewDataBinding {
    @NonNull
    public final ConstraintLayout clSavedSearch;
    @NonNull
    public final ConstraintLayout clSearchContainer;
    @NonNull
    public final ImageButton clearText;
    @NonNull
    public final ImageView imgArrowRight;
    @NonNull
    public final EditText newKeywordSearch;
    @NonNull
    public final ProgressBar pbSearchByVF;
    @NonNull
    public final RecyclerView rvQuickFilterList;
    @NonNull
    public final TextView tvFilterTitle;
    @NonNull
    public final TextView tvQuckfilter;
    @NonNull
    public final View viewTabSeprator;

    protected FragmentSearchByVehicleBinding(Object obj, View view, int i, ConstraintLayout constraintLayout, ConstraintLayout constraintLayout2, ImageButton imageButton, ImageView imageView, EditText editText, ProgressBar progressBar, RecyclerView recyclerView, TextView textView, TextView textView2, View view2) {
        super(obj, view, i);
        this.clSavedSearch = constraintLayout;
        this.clSearchContainer = constraintLayout2;
        this.clearText = imageButton;
        this.imgArrowRight = imageView;
        this.newKeywordSearch = editText;
        this.pbSearchByVF = progressBar;
        this.rvQuickFilterList = recyclerView;
        this.tvFilterTitle = textView;
        this.tvQuckfilter = textView2;
        this.viewTabSeprator = view2;
    }

    @NonNull
    public static FragmentSearchByVehicleBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    @Deprecated
    public static FragmentSearchByVehicleBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z, @Nullable Object obj) {
        return (FragmentSearchByVehicleBinding) ViewDataBinding.inflateInternal(layoutInflater, C2723R.C2728layout.fragment_search_by_vehicle, viewGroup, z, obj);
    }

    @NonNull
    public static FragmentSearchByVehicleBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    @Deprecated
    public static FragmentSearchByVehicleBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable Object obj) {
        return (FragmentSearchByVehicleBinding) ViewDataBinding.inflateInternal(layoutInflater, C2723R.C2728layout.fragment_search_by_vehicle, (ViewGroup) null, false, obj);
    }

    public static FragmentSearchByVehicleBinding bind(@NonNull View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static FragmentSearchByVehicleBinding bind(@NonNull View view, @Nullable Object obj) {
        return (FragmentSearchByVehicleBinding) bind(obj, view, C2723R.C2728layout.fragment_search_by_vehicle);
    }
}

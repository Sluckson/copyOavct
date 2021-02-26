package com.iaai.android.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.iaai.android.C2723R;

public abstract class FragmentRefinerResultBinding extends ViewDataBinding {
    @NonNull
    public final RelativeLayout clSearchContainer;
    @NonNull
    public final TextView edSearchResult;
    @NonNull
    public final FloatingActionButton fab;
    @NonNull
    public final FrameLayout flContainer;
    @NonNull
    public final ImageButton imgClearText;
    @NonNull
    public final ImageButton imgVoiceText;
    @NonNull
    public final LinearLayout llMicClr;
    @NonNull
    public final ProgressBar pbRefinerResult;
    @NonNull
    public final RecyclerView rvResultList;
    @NonNull
    public final TextView tvEmptyMessage;
    @NonNull
    public final View vwSeparatorToolbar;

    protected FragmentRefinerResultBinding(Object obj, View view, int i, RelativeLayout relativeLayout, TextView textView, FloatingActionButton floatingActionButton, FrameLayout frameLayout, ImageButton imageButton, ImageButton imageButton2, LinearLayout linearLayout, ProgressBar progressBar, RecyclerView recyclerView, TextView textView2, View view2) {
        super(obj, view, i);
        this.clSearchContainer = relativeLayout;
        this.edSearchResult = textView;
        this.fab = floatingActionButton;
        this.flContainer = frameLayout;
        this.imgClearText = imageButton;
        this.imgVoiceText = imageButton2;
        this.llMicClr = linearLayout;
        this.pbRefinerResult = progressBar;
        this.rvResultList = recyclerView;
        this.tvEmptyMessage = textView2;
        this.vwSeparatorToolbar = view2;
    }

    @NonNull
    public static FragmentRefinerResultBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    @Deprecated
    public static FragmentRefinerResultBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z, @Nullable Object obj) {
        return (FragmentRefinerResultBinding) ViewDataBinding.inflateInternal(layoutInflater, C2723R.C2728layout.fragment_refiner_result, viewGroup, z, obj);
    }

    @NonNull
    public static FragmentRefinerResultBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    @Deprecated
    public static FragmentRefinerResultBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable Object obj) {
        return (FragmentRefinerResultBinding) ViewDataBinding.inflateInternal(layoutInflater, C2723R.C2728layout.fragment_refiner_result, (ViewGroup) null, false, obj);
    }

    public static FragmentRefinerResultBinding bind(@NonNull View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static FragmentRefinerResultBinding bind(@NonNull View view, @Nullable Object obj) {
        return (FragmentRefinerResultBinding) bind(obj, view, C2723R.C2728layout.fragment_refiner_result);
    }
}

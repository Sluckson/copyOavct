package com.iaai.android.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.iaai.android.C2723R;

public abstract class RowItemLaneLayoutBinding extends ViewDataBinding {
    @NonNull
    public final RelativeLayout layoutLaneContainer;
    @NonNull
    public final ImageView tvCollisionCheck;
    @NonNull
    public final TextView tvLane;

    protected RowItemLaneLayoutBinding(Object obj, View view, int i, RelativeLayout relativeLayout, ImageView imageView, TextView textView) {
        super(obj, view, i);
        this.layoutLaneContainer = relativeLayout;
        this.tvCollisionCheck = imageView;
        this.tvLane = textView;
    }

    @NonNull
    public static RowItemLaneLayoutBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    @Deprecated
    public static RowItemLaneLayoutBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z, @Nullable Object obj) {
        return (RowItemLaneLayoutBinding) ViewDataBinding.inflateInternal(layoutInflater, C2723R.C2728layout.row_item_lane_layout, viewGroup, z, obj);
    }

    @NonNull
    public static RowItemLaneLayoutBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    @Deprecated
    public static RowItemLaneLayoutBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable Object obj) {
        return (RowItemLaneLayoutBinding) ViewDataBinding.inflateInternal(layoutInflater, C2723R.C2728layout.row_item_lane_layout, (ViewGroup) null, false, obj);
    }

    public static RowItemLaneLayoutBinding bind(@NonNull View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static RowItemLaneLayoutBinding bind(@NonNull View view, @Nullable Object obj) {
        return (RowItemLaneLayoutBinding) bind(obj, view, C2723R.C2728layout.row_item_lane_layout);
    }
}

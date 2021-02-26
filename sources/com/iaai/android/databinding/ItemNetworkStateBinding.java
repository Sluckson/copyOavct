package com.iaai.android.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.iaai.android.C2723R;

public abstract class ItemNetworkStateBinding extends ViewDataBinding {
    @NonNull
    public final TextView errorMsg;
    @NonNull
    public final ProgressBar progressBar;

    protected ItemNetworkStateBinding(Object obj, View view, int i, TextView textView, ProgressBar progressBar2) {
        super(obj, view, i);
        this.errorMsg = textView;
        this.progressBar = progressBar2;
    }

    @NonNull
    public static ItemNetworkStateBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    @Deprecated
    public static ItemNetworkStateBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z, @Nullable Object obj) {
        return (ItemNetworkStateBinding) ViewDataBinding.inflateInternal(layoutInflater, C2723R.C2728layout.item_network_state, viewGroup, z, obj);
    }

    @NonNull
    public static ItemNetworkStateBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    @Deprecated
    public static ItemNetworkStateBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable Object obj) {
        return (ItemNetworkStateBinding) ViewDataBinding.inflateInternal(layoutInflater, C2723R.C2728layout.item_network_state, (ViewGroup) null, false, obj);
    }

    public static ItemNetworkStateBinding bind(@NonNull View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemNetworkStateBinding bind(@NonNull View view, @Nullable Object obj) {
        return (ItemNetworkStateBinding) bind(obj, view, C2723R.C2728layout.item_network_state);
    }
}

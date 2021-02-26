package com.iaai.android.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.iaai.android.C2723R;

public abstract class RowItemSearchSuggestionsBinding extends ViewDataBinding {
    @NonNull
    public final ImageView ivSuggestionsIcon;
    @NonNull
    public final TextView tvSuggestion;

    protected RowItemSearchSuggestionsBinding(Object obj, View view, int i, ImageView imageView, TextView textView) {
        super(obj, view, i);
        this.ivSuggestionsIcon = imageView;
        this.tvSuggestion = textView;
    }

    @NonNull
    public static RowItemSearchSuggestionsBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    @Deprecated
    public static RowItemSearchSuggestionsBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z, @Nullable Object obj) {
        return (RowItemSearchSuggestionsBinding) ViewDataBinding.inflateInternal(layoutInflater, C2723R.C2728layout.row_item_search_suggestions, viewGroup, z, obj);
    }

    @NonNull
    public static RowItemSearchSuggestionsBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    @Deprecated
    public static RowItemSearchSuggestionsBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable Object obj) {
        return (RowItemSearchSuggestionsBinding) ViewDataBinding.inflateInternal(layoutInflater, C2723R.C2728layout.row_item_search_suggestions, (ViewGroup) null, false, obj);
    }

    public static RowItemSearchSuggestionsBinding bind(@NonNull View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static RowItemSearchSuggestionsBinding bind(@NonNull View view, @Nullable Object obj) {
        return (RowItemSearchSuggestionsBinding) bind(obj, view, C2723R.C2728layout.row_item_search_suggestions);
    }
}

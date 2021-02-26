package com.iaai.android.bdt.feature.fastSearchFilter.savedSearch;

import kotlin.Metadata;
import kotlin.jvm.internal.MutablePropertyReference0;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KDeclarationContainer;
import org.jetbrains.annotations.Nullable;
import p011io.reactivex.observers.DisposableObserver;

@Metadata(mo66931bv = {1, 0, 3}, mo66934k = 3, mo66935mv = {1, 1, 13})
/* compiled from: SavedSearchListViewModel.kt */
final class SavedSearchListViewModel$disposeElements$1 extends MutablePropertyReference0 {
    SavedSearchListViewModel$disposeElements$1(SavedSearchListViewModel savedSearchListViewModel) {
        super(savedSearchListViewModel);
    }

    public String getName() {
        return "savedSearchListDisposableObserver";
    }

    public KDeclarationContainer getOwner() {
        return Reflection.getOrCreateKotlinClass(SavedSearchListViewModel.class);
    }

    public String getSignature() {
        return "getSavedSearchListDisposableObserver()Lio/reactivex/observers/DisposableObserver;";
    }

    @Nullable
    public Object get() {
        return ((SavedSearchListViewModel) this.receiver).getSavedSearchListDisposableObserver();
    }

    public void set(@Nullable Object obj) {
        ((SavedSearchListViewModel) this.receiver).setSavedSearchListDisposableObserver((DisposableObserver) obj);
    }
}

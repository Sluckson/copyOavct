package com.iaai.android.bdt.feature.fastSearchFilter.savedSearch;

import kotlin.Metadata;
import kotlin.jvm.internal.MutablePropertyReference0;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KDeclarationContainer;
import org.jetbrains.annotations.Nullable;
import p011io.reactivex.observers.DisposableObserver;

@Metadata(mo66931bv = {1, 0, 3}, mo66934k = 3, mo66935mv = {1, 1, 13})
/* compiled from: SavedSearchListViewModel.kt */
final class SavedSearchListViewModel$disposeElements$2 extends MutablePropertyReference0 {
    SavedSearchListViewModel$disposeElements$2(SavedSearchListViewModel savedSearchListViewModel) {
        super(savedSearchListViewModel);
    }

    public String getName() {
        return "deleteSavedSearchDisposableObserver";
    }

    public KDeclarationContainer getOwner() {
        return Reflection.getOrCreateKotlinClass(SavedSearchListViewModel.class);
    }

    public String getSignature() {
        return "getDeleteSavedSearchDisposableObserver()Lio/reactivex/observers/DisposableObserver;";
    }

    @Nullable
    public Object get() {
        return ((SavedSearchListViewModel) this.receiver).getDeleteSavedSearchDisposableObserver();
    }

    public void set(@Nullable Object obj) {
        ((SavedSearchListViewModel) this.receiver).setDeleteSavedSearchDisposableObserver((DisposableObserver) obj);
    }
}

package com.iaai.android.bdt.feature.myAccount.toBePaid.saleDocList;

import kotlin.Metadata;
import kotlin.jvm.internal.MutablePropertyReference0;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KDeclarationContainer;
import org.jetbrains.annotations.Nullable;
import p011io.reactivex.observers.DisposableObserver;

@Metadata(mo66931bv = {1, 0, 3}, mo66934k = 3, mo66935mv = {1, 1, 13})
/* compiled from: InsertRepOrAddViewModel.kt */
final class InsertRepOrAddViewModel$disposeElements$2 extends MutablePropertyReference0 {
    InsertRepOrAddViewModel$disposeElements$2(InsertRepOrAddViewModel insertRepOrAddViewModel) {
        super(insertRepOrAddViewModel);
    }

    public String getName() {
        return "disposableObserverInsert";
    }

    public KDeclarationContainer getOwner() {
        return Reflection.getOrCreateKotlinClass(InsertRepOrAddViewModel.class);
    }

    public String getSignature() {
        return "getDisposableObserverInsert()Lio/reactivex/observers/DisposableObserver;";
    }

    @Nullable
    public Object get() {
        return InsertRepOrAddViewModel.access$getDisposableObserverInsert$p((InsertRepOrAddViewModel) this.receiver);
    }

    public void set(@Nullable Object obj) {
        ((InsertRepOrAddViewModel) this.receiver).disposableObserverInsert = (DisposableObserver) obj;
    }
}

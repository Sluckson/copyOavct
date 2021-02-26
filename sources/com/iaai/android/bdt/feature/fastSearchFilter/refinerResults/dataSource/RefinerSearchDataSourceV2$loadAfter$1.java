package com.iaai.android.bdt.feature.fastSearchFilter.refinerResults.dataSource;

import com.iaai.android.bdt.utils.NetworkState;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.Nullable;
import p011io.reactivex.disposables.CompositeDisposable;
import p011io.reactivex.disposables.Disposable;
import p011io.reactivex.functions.Consumer;

@Metadata(mo66931bv = {1, 0, 3}, mo66932d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003H\n¢\u0006\u0002\b\u0004"}, mo66933d2 = {"<anonymous>", "", "disposable", "Lio/reactivex/disposables/Disposable;", "accept"}, mo66934k = 3, mo66935mv = {1, 1, 13})
/* compiled from: RefinerSearchDataSourceV2.kt */
final class RefinerSearchDataSourceV2$loadAfter$1<T> implements Consumer<Disposable> {
    final /* synthetic */ RefinerSearchDataSourceV2 this$0;

    RefinerSearchDataSourceV2$loadAfter$1(RefinerSearchDataSourceV2 refinerSearchDataSourceV2) {
        this.this$0 = refinerSearchDataSourceV2;
    }

    public final void accept(@Nullable Disposable disposable) {
        CompositeDisposable access$getCompositeDisposable$p = this.this$0.compositeDisposable;
        if (disposable == null) {
            Intrinsics.throwNpe();
        }
        access$getCompositeDisposable$p.add(disposable);
        this.this$0.getNetworkState().postValue(NetworkState.LOADING);
    }
}

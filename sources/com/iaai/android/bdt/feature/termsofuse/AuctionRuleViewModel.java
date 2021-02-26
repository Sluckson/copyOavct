package com.iaai.android.bdt.feature.termsofuse;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import com.iaai.android.bdt.model.termsofuse.AuctionRuleAcceptModel;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import p011io.reactivex.Observable;
import p011io.reactivex.Observer;
import p011io.reactivex.android.schedulers.AndroidSchedulers;
import p011io.reactivex.observers.DisposableObserver;
import p011io.reactivex.schedulers.Schedulers;

@Metadata(mo66931bv = {1, 0, 3}, mo66932d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u000f\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0016\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u00072\u0006\u0010\u0019\u001a\u00020\u0007J\u000e\u0010\u001a\u001a\u00020\u00172\u0006\u0010\u001b\u001a\u00020\u0013R \u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR \u0010\f\u001a\b\u0012\u0004\u0012\u00020\r0\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\t\"\u0004\b\u000f\u0010\u000bR\u0014\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\r0\u0011X.¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R \u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00130\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\t\"\u0004\b\u0015\u0010\u000b¨\u0006\u001c"}, mo66933d2 = {"Lcom/iaai/android/bdt/feature/termsofuse/AuctionRuleViewModel;", "Landroidx/lifecycle/ViewModel;", "repository", "Lcom/iaai/android/bdt/feature/termsofuse/AuctionRuleRepository;", "(Lcom/iaai/android/bdt/feature/termsofuse/AuctionRuleRepository;)V", "arAcceptError", "Landroidx/lifecycle/MutableLiveData;", "", "getArAcceptError", "()Landroidx/lifecycle/MutableLiveData;", "setArAcceptError", "(Landroidx/lifecycle/MutableLiveData;)V", "arAcceptResponse", "Lcom/iaai/android/bdt/model/termsofuse/AuctionRuleAcceptModel;", "getArAcceptResponse", "setArAcceptResponse", "disposableObserver", "Lio/reactivex/observers/DisposableObserver;", "showLoading", "", "getShowLoading", "setShowLoading", "insertAcceptAuctionRule", "", "ipAddress", "authHeader", "updateLoadingIndicator", "status", "app_productionRelease"}, mo66934k = 1, mo66935mv = {1, 1, 13})
/* compiled from: AuctionRuleViewModel.kt */
public final class AuctionRuleViewModel extends ViewModel {
    @NotNull
    private MutableLiveData<String> arAcceptError = new MutableLiveData<>();
    @NotNull
    private MutableLiveData<AuctionRuleAcceptModel> arAcceptResponse = new MutableLiveData<>();
    private DisposableObserver<AuctionRuleAcceptModel> disposableObserver;
    private final AuctionRuleRepository repository;
    @NotNull
    private MutableLiveData<Boolean> showLoading = new MutableLiveData<>();

    @Inject
    public AuctionRuleViewModel(@NotNull AuctionRuleRepository auctionRuleRepository) {
        Intrinsics.checkParameterIsNotNull(auctionRuleRepository, "repository");
        this.repository = auctionRuleRepository;
    }

    @NotNull
    public final MutableLiveData<AuctionRuleAcceptModel> getArAcceptResponse() {
        return this.arAcceptResponse;
    }

    public final void setArAcceptResponse(@NotNull MutableLiveData<AuctionRuleAcceptModel> mutableLiveData) {
        Intrinsics.checkParameterIsNotNull(mutableLiveData, "<set-?>");
        this.arAcceptResponse = mutableLiveData;
    }

    @NotNull
    public final MutableLiveData<String> getArAcceptError() {
        return this.arAcceptError;
    }

    public final void setArAcceptError(@NotNull MutableLiveData<String> mutableLiveData) {
        Intrinsics.checkParameterIsNotNull(mutableLiveData, "<set-?>");
        this.arAcceptError = mutableLiveData;
    }

    @NotNull
    public final MutableLiveData<Boolean> getShowLoading() {
        return this.showLoading;
    }

    public final void setShowLoading(@NotNull MutableLiveData<Boolean> mutableLiveData) {
        Intrinsics.checkParameterIsNotNull(mutableLiveData, "<set-?>");
        this.showLoading = mutableLiveData;
    }

    public final void insertAcceptAuctionRule(@NotNull String str, @NotNull String str2) {
        Intrinsics.checkParameterIsNotNull(str, "ipAddress");
        Intrinsics.checkParameterIsNotNull(str2, "authHeader");
        updateLoadingIndicator(true);
        this.disposableObserver = new AuctionRuleViewModel$insertAcceptAuctionRule$1(this);
        Observable<AuctionRuleAcceptModel> observeOn = this.repository.insertAcceptAuctionRule(str, str2).subscribeOn(Schedulers.newThread()).observeOn(AndroidSchedulers.mainThread());
        DisposableObserver<AuctionRuleAcceptModel> disposableObserver2 = this.disposableObserver;
        if (disposableObserver2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("disposableObserver");
        }
        observeOn.subscribe((Observer<? super AuctionRuleAcceptModel>) disposableObserver2);
    }

    public final void updateLoadingIndicator(boolean z) {
        this.showLoading.postValue(Boolean.valueOf(z));
    }
}

package com.iaai.android.bdt.feature.applaunch;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import com.iaai.android.bdt.model.fastSearch.MakeModelMaster;
import java.util.List;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import p011io.reactivex.Observable;
import p011io.reactivex.Observer;
import p011io.reactivex.android.schedulers.AndroidSchedulers;
import p011io.reactivex.observers.DisposableObserver;
import p011io.reactivex.schedulers.Schedulers;

@Metadata(mo66931bv = {1, 0, 3}, mo66932d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u000f\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0006\u0010\u0015\u001a\u00020\u0016J\u0006\u0010\u0017\u001a\u00020\u0016R\u0016\u0010\u0005\u001a\n \u0007*\u0004\u0018\u00010\u00060\u0006X\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\b\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000b0\n0\tX.¢\u0006\u0002\n\u0000R \u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00060\rX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R&\u0010\u0012\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000b0\n0\rX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u000f\"\u0004\b\u0014\u0010\u0011R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0018"}, mo66933d2 = {"Lcom/iaai/android/bdt/feature/applaunch/MakeModelViewModel;", "Landroidx/lifecycle/ViewModel;", "repository", "Lcom/iaai/android/bdt/feature/applaunch/MakeModelMasterRepository;", "(Lcom/iaai/android/bdt/feature/applaunch/MakeModelMasterRepository;)V", "TAG", "", "kotlin.jvm.PlatformType", "disposableObserver", "Lio/reactivex/observers/DisposableObserver;", "", "Lcom/iaai/android/bdt/model/fastSearch/MakeModelMaster;", "makeModelListError", "Landroidx/lifecycle/MutableLiveData;", "getMakeModelListError", "()Landroidx/lifecycle/MutableLiveData;", "setMakeModelListError", "(Landroidx/lifecycle/MutableLiveData;)V", "makeModelListResult", "getMakeModelListResult", "setMakeModelListResult", "disposeElements", "", "getMakeModelMasterData", "app_productionRelease"}, mo66934k = 1, mo66935mv = {1, 1, 13})
/* compiled from: MakeModelViewModel.kt */
public final class MakeModelViewModel extends ViewModel {
    /* access modifiers changed from: private */
    public final String TAG = MakeModelViewModel.class.getSimpleName();
    /* access modifiers changed from: private */
    public DisposableObserver<List<MakeModelMaster>> disposableObserver;
    @NotNull
    private MutableLiveData<String> makeModelListError = new MutableLiveData<>();
    @NotNull
    private MutableLiveData<List<MakeModelMaster>> makeModelListResult = new MutableLiveData<>();
    private final MakeModelMasterRepository repository;

    public static final /* synthetic */ DisposableObserver access$getDisposableObserver$p(MakeModelViewModel makeModelViewModel) {
        DisposableObserver<List<MakeModelMaster>> disposableObserver2 = makeModelViewModel.disposableObserver;
        if (disposableObserver2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("disposableObserver");
        }
        return disposableObserver2;
    }

    @Inject
    public MakeModelViewModel(@NotNull MakeModelMasterRepository makeModelMasterRepository) {
        Intrinsics.checkParameterIsNotNull(makeModelMasterRepository, "repository");
        this.repository = makeModelMasterRepository;
    }

    @NotNull
    public final MutableLiveData<List<MakeModelMaster>> getMakeModelListResult() {
        return this.makeModelListResult;
    }

    public final void setMakeModelListResult(@NotNull MutableLiveData<List<MakeModelMaster>> mutableLiveData) {
        Intrinsics.checkParameterIsNotNull(mutableLiveData, "<set-?>");
        this.makeModelListResult = mutableLiveData;
    }

    @NotNull
    public final MutableLiveData<String> getMakeModelListError() {
        return this.makeModelListError;
    }

    public final void setMakeModelListError(@NotNull MutableLiveData<String> mutableLiveData) {
        Intrinsics.checkParameterIsNotNull(mutableLiveData, "<set-?>");
        this.makeModelListError = mutableLiveData;
    }

    public final void getMakeModelMasterData() {
        this.disposableObserver = new MakeModelViewModel$getMakeModelMasterData$1(this);
        Observable<List<MakeModelMaster>> observeOn = this.repository.getMakeModelMasterData().subscribeOn(Schedulers.newThread()).observeOn(AndroidSchedulers.mainThread());
        DisposableObserver<List<MakeModelMaster>> disposableObserver2 = this.disposableObserver;
        if (disposableObserver2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("disposableObserver");
        }
        observeOn.subscribe((Observer<? super List<MakeModelMaster>>) disposableObserver2);
    }

    public final void disposeElements() {
        if (this.disposableObserver != null) {
            DisposableObserver<List<MakeModelMaster>> disposableObserver2 = this.disposableObserver;
            if (disposableObserver2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("disposableObserver");
            }
            if (!disposableObserver2.isDisposed()) {
                DisposableObserver<List<MakeModelMaster>> disposableObserver3 = this.disposableObserver;
                if (disposableObserver3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("disposableObserver");
                }
                disposableObserver3.dispose();
            }
        }
    }
}

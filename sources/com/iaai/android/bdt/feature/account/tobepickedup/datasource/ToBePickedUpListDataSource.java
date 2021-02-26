package com.iaai.android.bdt.feature.account.tobepickedup.datasource;

import android.annotation.SuppressLint;
import androidx.annotation.NonNull;
import androidx.lifecycle.MutableLiveData;
import androidx.paging.PageKeyedDataSource;
import com.iaai.android.bdt.feature.account.tobepickedup.ToBePickedUpRepository;
import com.iaai.android.bdt.model.MyAccount.ToBePickedUpResponse;
import com.iaai.android.bdt.model.MyAccount.ToBePickedUpVehiclesModel;
import com.iaai.android.bdt.utils.NetworkState;
import p011io.reactivex.disposables.CompositeDisposable;
import p011io.reactivex.disposables.Disposable;
import p011io.reactivex.functions.Consumer;

public class ToBePickedUpListDataSource extends PageKeyedDataSource<Long, ToBePickedUpVehiclesModel> {
    private static final String TAG = "ToBePickedUpListDataSource";
    private String authorizationHeader;
    private CompositeDisposable compositeDisposable;
    private int count = 30;
    private MutableLiveData<ToBePickedUpResponse> getPreSaleListResponse;
    private MutableLiveData<NetworkState> networkState;
    private Boolean onlymyitems;
    private ToBePickedUpRepository repository;
    private MutableLiveData<Integer> scrollSearchListToTop;
    private String sortBy;
    private int sortDirection;
    private int start;
    private int startIndex;
    private int totalCount = 0;
    private String userId;

    public void loadBefore(@NonNull PageKeyedDataSource.LoadParams<Long> loadParams, @NonNull PageKeyedDataSource.LoadCallback<Long, ToBePickedUpVehiclesModel> loadCallback) {
    }

    public MutableLiveData getNetworkState() {
        return this.networkState;
    }

    public MutableLiveData getScrollSearchListToTopCount() {
        return this.scrollSearchListToTop;
    }

    public MutableLiveData getPreSaleListResponse() {
        return this.getPreSaleListResponse;
    }

    ToBePickedUpListDataSource(ToBePickedUpRepository toBePickedUpRepository, CompositeDisposable compositeDisposable2, String str, String str2, Integer num, Boolean bool, String str3, Integer num2) {
        this.repository = toBePickedUpRepository;
        this.compositeDisposable = compositeDisposable2;
        this.networkState = new MutableLiveData<>();
        this.userId = str2;
        this.onlymyitems = bool;
        this.startIndex = num.intValue();
        this.sortBy = str3;
        this.sortDirection = num2.intValue();
        this.scrollSearchListToTop = new MutableLiveData<>();
        this.getPreSaleListResponse = new MutableLiveData<>();
        this.authorizationHeader = str;
    }

    @SuppressLint({"CheckResult"})
    public void loadInitial(@NonNull PageKeyedDataSource.LoadInitialParams<Long> loadInitialParams, @NonNull PageKeyedDataSource.LoadInitialCallback<Long, ToBePickedUpVehiclesModel> loadInitialCallback) {
        this.repository.getTopPickedUpList(this.authorizationHeader, this.userId, this.onlymyitems.booleanValue(), this.startIndex, this.sortBy, this.sortDirection).doOnSubscribe(new Consumer() {
            public final void accept(Object obj) {
                ToBePickedUpListDataSource.this.lambda$loadInitial$0$ToBePickedUpListDataSource((Disposable) obj);
            }
        }).subscribe(new Consumer(loadInitialCallback) {
            private final /* synthetic */ PageKeyedDataSource.LoadInitialCallback f$1;

            {
                this.f$1 = r2;
            }

            public final void accept(Object obj) {
                ToBePickedUpListDataSource.this.lambda$loadInitial$1$ToBePickedUpListDataSource(this.f$1, (ToBePickedUpResponse) obj);
            }
        }, new Consumer() {
            public final void accept(Object obj) {
                ToBePickedUpListDataSource.this.lambda$loadInitial$2$ToBePickedUpListDataSource((Throwable) obj);
            }
        });
    }

    public /* synthetic */ void lambda$loadInitial$0$ToBePickedUpListDataSource(Disposable disposable) throws Exception {
        this.compositeDisposable.add(disposable);
        this.networkState.postValue(NetworkState.LOADING);
    }

    public /* synthetic */ void lambda$loadInitial$1$ToBePickedUpListDataSource(PageKeyedDataSource.LoadInitialCallback loadInitialCallback, ToBePickedUpResponse toBePickedUpResponse) throws Exception {
        int size = toBePickedUpResponse.getVehicleArrayList().size();
        this.totalCount = toBePickedUpResponse.getTotalCount();
        this.getPreSaleListResponse.postValue(toBePickedUpResponse);
        if (size > 0) {
            loadInitialCallback.onResult(toBePickedUpResponse.getVehicleArrayList(), null, Long.valueOf((long) (toBePickedUpResponse.getTotalCount() - size)));
            this.networkState.postValue(NetworkState.LOADED);
        }
    }

    public /* synthetic */ void lambda$loadInitial$2$ToBePickedUpListDataSource(Throwable th) throws Exception {
        this.networkState.postValue(new NetworkState(NetworkState.Status.FAILED, th.getLocalizedMessage()));
    }

    @SuppressLint({"CheckResult"})
    public void loadAfter(@NonNull PageKeyedDataSource.LoadParams<Long> loadParams, @NonNull PageKeyedDataSource.LoadCallback<Long, ToBePickedUpVehiclesModel> loadCallback) {
        this.startIndex = this.count + this.startIndex;
        this.repository.getTopPickedUpList(this.authorizationHeader, this.userId, this.onlymyitems.booleanValue(), this.startIndex, this.sortBy, this.sortDirection).doOnSubscribe(new Consumer() {
            public final void accept(Object obj) {
                ToBePickedUpListDataSource.this.lambda$loadAfter$3$ToBePickedUpListDataSource((Disposable) obj);
            }
        }).subscribe(new Consumer(loadParams, loadCallback) {
            private final /* synthetic */ PageKeyedDataSource.LoadParams f$1;
            private final /* synthetic */ PageKeyedDataSource.LoadCallback f$2;

            {
                this.f$1 = r2;
                this.f$2 = r3;
            }

            public final void accept(Object obj) {
                ToBePickedUpListDataSource.this.lambda$loadAfter$4$ToBePickedUpListDataSource(this.f$1, this.f$2, (ToBePickedUpResponse) obj);
            }
        }, new Consumer() {
            public final void accept(Object obj) {
                ToBePickedUpListDataSource.this.lambda$loadAfter$5$ToBePickedUpListDataSource((Throwable) obj);
            }
        });
    }

    public /* synthetic */ void lambda$loadAfter$3$ToBePickedUpListDataSource(Disposable disposable) throws Exception {
        this.compositeDisposable.add(disposable);
        this.networkState.postValue(NetworkState.LOADING);
    }

    public /* synthetic */ void lambda$loadAfter$4$ToBePickedUpListDataSource(PageKeyedDataSource.LoadParams loadParams, PageKeyedDataSource.LoadCallback loadCallback, ToBePickedUpResponse toBePickedUpResponse) throws Exception {
        toBePickedUpResponse.setTotalCount(this.totalCount);
        this.getPreSaleListResponse.postValue(toBePickedUpResponse);
        long longValue = ((Long) loadParams.key).longValue() - ((long) toBePickedUpResponse.getVehicleArrayList().size());
        if (longValue == 0) {
            loadCallback.onResult(toBePickedUpResponse.getVehicleArrayList(), null);
        } else {
            loadCallback.onResult(toBePickedUpResponse.getVehicleArrayList(), Long.valueOf(longValue));
        }
        this.networkState.postValue(NetworkState.LOADED);
        if (!this.sortBy.equalsIgnoreCase("")) {
            this.scrollSearchListToTop.postValue(0);
        }
    }

    public /* synthetic */ void lambda$loadAfter$5$ToBePickedUpListDataSource(Throwable th) throws Exception {
        this.networkState.postValue(new NetworkState(NetworkState.Status.FAILED, th.getLocalizedMessage()));
    }
}

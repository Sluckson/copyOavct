package com.iaai.android.bdt.feature.findVehiclePage.searchResult.dataSource;

import android.annotation.SuppressLint;
import androidx.annotation.NonNull;
import androidx.lifecycle.MutableLiveData;
import androidx.paging.PageKeyedDataSource;
import com.iaai.android.bdt.feature.viewPager.FastSearchListRepository;
import com.iaai.android.bdt.model.fastSearch.FastSearchResponse;
import com.iaai.android.bdt.model.fastSearch.Refiner;
import com.iaai.android.bdt.model.fastSearch.SearchInputV2;
import com.iaai.android.bdt.model.fastSearch.Vehicle;
import com.iaai.android.bdt.utils.NetworkState;
import java.util.List;
import p011io.reactivex.disposables.CompositeDisposable;
import p011io.reactivex.disposables.Disposable;
import p011io.reactivex.functions.Consumer;

public class SearchDataSourceV2 extends PageKeyedDataSource<Long, Vehicle> {
    private static final String TAG = "SearchDataSourceV2";
    private String authorizationHeader;
    public SearchInputV2 body;
    private int branchId;
    private CompositeDisposable compositeDisposable;
    private String date;
    private String deviceID;
    private int end;
    private boolean isFilterApplied;
    private MutableLiveData<NetworkState> networkState = new MutableLiveData<>();
    private MutableLiveData<List<Refiner>> refinerData;
    private FastSearchListRepository repository;
    private MutableLiveData<Integer> scrollSearchListToTop = new MutableLiveData<>();
    private int start;
    private MutableLiveData<Integer> vehicleTotalCount = new MutableLiveData<>();

    public void loadBefore(@NonNull PageKeyedDataSource.LoadParams<Long> loadParams, @NonNull PageKeyedDataSource.LoadCallback<Long, Vehicle> loadCallback) {
    }

    public MutableLiveData getNetworkState() {
        return this.networkState;
    }

    public MutableLiveData getVehicleCount() {
        return this.vehicleTotalCount;
    }

    public MutableLiveData getScrollSearchListToTopCount() {
        return this.scrollSearchListToTop;
    }

    SearchDataSourceV2(FastSearchListRepository fastSearchListRepository, CompositeDisposable compositeDisposable2, SearchInputV2 searchInputV2, String str, String str2, boolean z) {
        this.repository = fastSearchListRepository;
        this.compositeDisposable = compositeDisposable2;
        this.body = searchInputV2;
        this.authorizationHeader = str;
        this.deviceID = str2;
        this.isFilterApplied = z;
        this.refinerData = new MutableLiveData<>();
    }

    @SuppressLint({"CheckResult"})
    public void loadInitial(@NonNull PageKeyedDataSource.LoadInitialParams<Long> loadInitialParams, @NonNull PageKeyedDataSource.LoadInitialCallback<Long, Vehicle> loadInitialCallback) {
        this.start = this.body.getStartIndex();
        this.repository.getFastSearchListV2(this.authorizationHeader, this.deviceID, this.body).doOnSubscribe(new Consumer() {
            public final void accept(Object obj) {
                SearchDataSourceV2.this.lambda$loadInitial$0$SearchDataSourceV2((Disposable) obj);
            }
        }).subscribe(new Consumer(loadInitialCallback) {
            private final /* synthetic */ PageKeyedDataSource.LoadInitialCallback f$1;

            {
                this.f$1 = r2;
            }

            public final void accept(Object obj) {
                SearchDataSourceV2.this.lambda$loadInitial$1$SearchDataSourceV2(this.f$1, (FastSearchResponse) obj);
            }
        }, new Consumer() {
            public final void accept(Object obj) {
                SearchDataSourceV2.this.lambda$loadInitial$2$SearchDataSourceV2((Throwable) obj);
            }
        });
    }

    public /* synthetic */ void lambda$loadInitial$0$SearchDataSourceV2(Disposable disposable) throws Exception {
        this.compositeDisposable.add(disposable);
        this.networkState.postValue(NetworkState.LOADING);
    }

    public /* synthetic */ void lambda$loadInitial$1$SearchDataSourceV2(PageKeyedDataSource.LoadInitialCallback loadInitialCallback, FastSearchResponse fastSearchResponse) throws Exception {
        if (fastSearchResponse.getVehicles().size() > 0) {
            loadInitialCallback.onResult(fastSearchResponse.getVehicles(), null, Long.valueOf((long) (fastSearchResponse.getTotalVehicleCount() - this.end)));
            this.vehicleTotalCount.postValue(Integer.valueOf(fastSearchResponse.getTotalVehicleCount()));
            this.networkState.postValue(NetworkState.LOADED);
        }
    }

    public /* synthetic */ void lambda$loadInitial$2$SearchDataSourceV2(Throwable th) throws Exception {
        this.networkState.postValue(new NetworkState(NetworkState.Status.FAILED, th.getLocalizedMessage()));
    }

    @SuppressLint({"CheckResult"})
    public void loadAfter(@NonNull PageKeyedDataSource.LoadParams<Long> loadParams, @NonNull PageKeyedDataSource.LoadCallback<Long, Vehicle> loadCallback) {
        this.start += 100;
        this.body = new SearchInputV2(this.body.getCountOfVehicles(), this.body.getKeyword(), this.body.getLatitude(), this.body.getLongitude(), this.body.getRefinerInd(), this.body.getSelectedRefiners(), this.body.getSortRule(), this.start);
        this.repository.getFastSearchListV2(this.authorizationHeader, this.deviceID, this.body).doOnSubscribe(new Consumer() {
            public final void accept(Object obj) {
                SearchDataSourceV2.this.lambda$loadAfter$3$SearchDataSourceV2((Disposable) obj);
            }
        }).subscribe(new Consumer(loadParams, loadCallback) {
            private final /* synthetic */ PageKeyedDataSource.LoadParams f$1;
            private final /* synthetic */ PageKeyedDataSource.LoadCallback f$2;

            {
                this.f$1 = r2;
                this.f$2 = r3;
            }

            public final void accept(Object obj) {
                SearchDataSourceV2.this.lambda$loadAfter$4$SearchDataSourceV2(this.f$1, this.f$2, (FastSearchResponse) obj);
            }
        }, new Consumer() {
            public final void accept(Object obj) {
                SearchDataSourceV2.this.lambda$loadAfter$5$SearchDataSourceV2((Throwable) obj);
            }
        });
    }

    public /* synthetic */ void lambda$loadAfter$3$SearchDataSourceV2(Disposable disposable) throws Exception {
        this.compositeDisposable.add(disposable);
        this.networkState.postValue(NetworkState.LOADING);
    }

    public /* synthetic */ void lambda$loadAfter$4$SearchDataSourceV2(PageKeyedDataSource.LoadParams loadParams, PageKeyedDataSource.LoadCallback loadCallback, FastSearchResponse fastSearchResponse) throws Exception {
        long longValue = ((Long) loadParams.key).longValue() - ((long) fastSearchResponse.getVehicles().size());
        if (longValue == 0) {
            loadCallback.onResult(fastSearchResponse.getVehicles(), null);
        } else {
            loadCallback.onResult(fastSearchResponse.getVehicles(), Long.valueOf(longValue));
        }
        this.vehicleTotalCount.postValue(Integer.valueOf(fastSearchResponse.getTotalVehicleCount()));
        this.networkState.postValue(NetworkState.LOADED);
        if (this.isFilterApplied) {
            this.scrollSearchListToTop.postValue(0);
            this.isFilterApplied = false;
        }
    }

    public /* synthetic */ void lambda$loadAfter$5$SearchDataSourceV2(Throwable th) throws Exception {
        this.networkState.postValue(new NetworkState(NetworkState.Status.FAILED, th.getLocalizedMessage()));
    }

    public MutableLiveData getRefinerData() {
        return this.refinerData;
    }
}

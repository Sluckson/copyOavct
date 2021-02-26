package com.iaai.android.bdt.feature.account.watchlist.datasource;

import android.annotation.SuppressLint;
import androidx.annotation.NonNull;
import androidx.lifecycle.MutableLiveData;
import androidx.paging.PageKeyedDataSource;
import com.iaai.android.bdt.feature.account.watchlist.PreSaleListRepository;
import com.iaai.android.bdt.model.MyAccount.WatchListModel;
import com.iaai.android.bdt.model.MyAccount.WatchListResponse;
import com.iaai.android.bdt.utils.NetworkState;
import java.util.Objects;
import p011io.reactivex.disposables.CompositeDisposable;
import p011io.reactivex.disposables.Disposable;
import p011io.reactivex.functions.Consumer;

public class PreSaleListDataSource extends PageKeyedDataSource<Long, WatchListModel> {
    private static final String TAG = "PreSaleListDataSource";
    private String authorizationHeader;
    private CompositeDisposable compositeDisposable;
    private int count = 30;
    private MutableLiveData<WatchListResponse> getPreSaleListResponse;
    private String keyword;
    private int lbsParentID;
    private MutableLiveData<NetworkState> networkState;
    private Boolean onlymyitems;
    private PreSaleListRepository repository;
    private MutableLiveData<Integer> scrollSearchListToTop;
    private String sortBy;
    private int sortDirection;
    private int start;
    private int startIndex;
    private String status;
    private int totalCount = 0;
    private String userId;

    public void loadBefore(@NonNull PageKeyedDataSource.LoadParams<Long> loadParams, @NonNull PageKeyedDataSource.LoadCallback<Long, WatchListModel> loadCallback) {
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

    PreSaleListDataSource(PreSaleListRepository preSaleListRepository, CompositeDisposable compositeDisposable2, String str, String str2, String str3, Integer num, Boolean bool, String str4, Integer num2, String str5) {
        this.repository = preSaleListRepository;
        this.compositeDisposable = compositeDisposable2;
        this.networkState = new MutableLiveData<>();
        this.userId = str2;
        this.status = str3;
        this.onlymyitems = bool;
        this.startIndex = num.intValue();
        this.sortBy = str4;
        this.sortDirection = num2.intValue();
        this.lbsParentID = 0;
        this.scrollSearchListToTop = new MutableLiveData<>();
        this.getPreSaleListResponse = new MutableLiveData<>();
        this.authorizationHeader = str;
        this.keyword = str5;
    }

    @SuppressLint({"CheckResult"})
    public void loadInitial(@NonNull PageKeyedDataSource.LoadInitialParams<Long> loadInitialParams, @NonNull PageKeyedDataSource.LoadInitialCallback<Long, WatchListModel> loadInitialCallback) {
        this.repository.getWatchList(this.authorizationHeader, this.userId, this.onlymyitems.booleanValue(), this.lbsParentID, this.startIndex, this.status, this.sortBy, this.sortDirection, this.keyword).doOnSubscribe(new Consumer() {
            public final void accept(Object obj) {
                PreSaleListDataSource.this.lambda$loadInitial$0$PreSaleListDataSource((Disposable) obj);
            }
        }).subscribe(new Consumer(loadInitialCallback) {
            private final /* synthetic */ PageKeyedDataSource.LoadInitialCallback f$1;

            {
                this.f$1 = r2;
            }

            public final void accept(Object obj) {
                PreSaleListDataSource.this.lambda$loadInitial$1$PreSaleListDataSource(this.f$1, (WatchListResponse) obj);
            }
        }, new Consumer() {
            public final void accept(Object obj) {
                PreSaleListDataSource.this.lambda$loadInitial$2$PreSaleListDataSource((Throwable) obj);
            }
        });
    }

    public /* synthetic */ void lambda$loadInitial$0$PreSaleListDataSource(Disposable disposable) throws Exception {
        this.compositeDisposable.add(disposable);
        this.networkState.postValue(NetworkState.LOADING);
    }

    public /* synthetic */ void lambda$loadInitial$1$PreSaleListDataSource(PageKeyedDataSource.LoadInitialCallback loadInitialCallback, WatchListResponse watchListResponse) throws Exception {
        long j;
        int size = watchListResponse.getListModel().size();
        this.totalCount = Integer.parseInt((String) Objects.requireNonNull(watchListResponse.getTotalcount()));
        this.getPreSaleListResponse.postValue(watchListResponse);
        if (size > 0) {
            if (!this.keyword.equalsIgnoreCase("")) {
                j = 0;
            } else {
                j = (long) (Integer.parseInt((String) Objects.requireNonNull(watchListResponse.getTotalcount())) - size);
            }
            loadInitialCallback.onResult(watchListResponse.getListModel(), null, Long.valueOf(j));
            this.networkState.postValue(NetworkState.LOADED);
        }
    }

    public /* synthetic */ void lambda$loadInitial$2$PreSaleListDataSource(Throwable th) throws Exception {
        this.networkState.postValue(new NetworkState(NetworkState.Status.FAILED, th.getLocalizedMessage()));
    }

    @SuppressLint({"CheckResult"})
    public void loadAfter(@NonNull PageKeyedDataSource.LoadParams<Long> loadParams, @NonNull PageKeyedDataSource.LoadCallback<Long, WatchListModel> loadCallback) {
        this.startIndex = this.count + this.startIndex;
        this.repository.getWatchList(this.authorizationHeader, this.userId, this.onlymyitems.booleanValue(), this.lbsParentID, this.startIndex, this.status, this.sortBy, this.sortDirection, this.keyword).doOnSubscribe(new Consumer() {
            public final void accept(Object obj) {
                PreSaleListDataSource.this.lambda$loadAfter$3$PreSaleListDataSource((Disposable) obj);
            }
        }).subscribe(new Consumer(loadParams, loadCallback) {
            private final /* synthetic */ PageKeyedDataSource.LoadParams f$1;
            private final /* synthetic */ PageKeyedDataSource.LoadCallback f$2;

            {
                this.f$1 = r2;
                this.f$2 = r3;
            }

            public final void accept(Object obj) {
                PreSaleListDataSource.this.lambda$loadAfter$4$PreSaleListDataSource(this.f$1, this.f$2, (WatchListResponse) obj);
            }
        }, new Consumer() {
            public final void accept(Object obj) {
                PreSaleListDataSource.this.lambda$loadAfter$5$PreSaleListDataSource((Throwable) obj);
            }
        });
    }

    public /* synthetic */ void lambda$loadAfter$3$PreSaleListDataSource(Disposable disposable) throws Exception {
        this.compositeDisposable.add(disposable);
        this.networkState.postValue(NetworkState.LOADING);
    }

    public /* synthetic */ void lambda$loadAfter$4$PreSaleListDataSource(PageKeyedDataSource.LoadParams loadParams, PageKeyedDataSource.LoadCallback loadCallback, WatchListResponse watchListResponse) throws Exception {
        if (this.keyword.equalsIgnoreCase("")) {
            watchListResponse.setTotalcount(String.valueOf(this.totalCount));
            this.getPreSaleListResponse.postValue(watchListResponse);
            long longValue = ((Long) loadParams.key).longValue() - ((long) watchListResponse.getListModel().size());
            if (longValue == 0) {
                loadCallback.onResult(watchListResponse.getListModel(), null);
            } else {
                loadCallback.onResult(watchListResponse.getListModel(), Long.valueOf(longValue));
            }
        }
        this.networkState.postValue(NetworkState.LOADED);
        if (!this.sortBy.equalsIgnoreCase("") && this.startIndex < 32) {
            this.scrollSearchListToTop.postValue(0);
        }
    }

    public /* synthetic */ void lambda$loadAfter$5$PreSaleListDataSource(Throwable th) throws Exception {
        this.networkState.postValue(new NetworkState(NetworkState.Status.FAILED, th.getLocalizedMessage()));
    }
}

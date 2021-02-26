package com.iaai.android.bdt.feature.account.buyNowOfferList.datasource;

import android.annotation.SuppressLint;
import androidx.annotation.NonNull;
import androidx.lifecycle.MutableLiveData;
import androidx.paging.PageKeyedDataSource;
import com.iaai.android.bdt.feature.account.buyNowOfferList.BuyNowOfferListRepository;
import com.iaai.android.bdt.model.MyAccount.BuyNowOfferListModel;
import com.iaai.android.bdt.model.MyAccount.BuyNowOfferListResponse;
import com.iaai.android.bdt.utils.NetworkState;
import java.util.Objects;
import p011io.reactivex.disposables.CompositeDisposable;
import p011io.reactivex.disposables.Disposable;
import p011io.reactivex.functions.Consumer;

public class BuyNowOfferListDataSource extends PageKeyedDataSource<Long, BuyNowOfferListModel> {
    private static final String TAG = "BuyNowOfferListDataSource";
    private CompositeDisposable compositeDisposable;
    private int count = 30;
    private MutableLiveData<BuyNowOfferListResponse> getBuyNowResponse;
    private int lbsParentID;
    private MutableLiveData<NetworkState> networkState;
    private BuyNowOfferListRepository repository;
    private MutableLiveData<Integer> scrollSearchListToTop;
    private int sortDirection;
    private int start;
    private int startIndex;
    private int totalCount = 0;
    private String userId;

    public void loadBefore(@NonNull PageKeyedDataSource.LoadParams<Long> loadParams, @NonNull PageKeyedDataSource.LoadCallback<Long, BuyNowOfferListModel> loadCallback) {
    }

    public MutableLiveData getNetworkState() {
        return this.networkState;
    }

    public MutableLiveData getScrollSearchListToTopCount() {
        return this.scrollSearchListToTop;
    }

    public MutableLiveData getBuyNowListResponse() {
        return this.getBuyNowResponse;
    }

    BuyNowOfferListDataSource(BuyNowOfferListRepository buyNowOfferListRepository, CompositeDisposable compositeDisposable2, String str, Integer num) {
        this.repository = buyNowOfferListRepository;
        this.compositeDisposable = compositeDisposable2;
        this.networkState = new MutableLiveData<>();
        this.userId = str;
        this.startIndex = num.intValue();
        this.scrollSearchListToTop = new MutableLiveData<>();
        this.getBuyNowResponse = new MutableLiveData<>();
    }

    @SuppressLint({"CheckResult"})
    public void loadInitial(@NonNull PageKeyedDataSource.LoadInitialParams<Long> loadInitialParams, @NonNull PageKeyedDataSource.LoadInitialCallback<Long, BuyNowOfferListModel> loadInitialCallback) {
        this.repository.getBuyNowOfferList(this.userId, this.startIndex).doOnSubscribe(new Consumer() {
            public final void accept(Object obj) {
                BuyNowOfferListDataSource.this.lambda$loadInitial$0$BuyNowOfferListDataSource((Disposable) obj);
            }
        }).subscribe(new Consumer(loadInitialCallback) {
            private final /* synthetic */ PageKeyedDataSource.LoadInitialCallback f$1;

            {
                this.f$1 = r2;
            }

            public final void accept(Object obj) {
                BuyNowOfferListDataSource.this.lambda$loadInitial$1$BuyNowOfferListDataSource(this.f$1, (BuyNowOfferListResponse) obj);
            }
        }, new Consumer() {
            public final void accept(Object obj) {
                BuyNowOfferListDataSource.this.lambda$loadInitial$2$BuyNowOfferListDataSource((Throwable) obj);
            }
        });
    }

    public /* synthetic */ void lambda$loadInitial$0$BuyNowOfferListDataSource(Disposable disposable) throws Exception {
        this.compositeDisposable.add(disposable);
        this.networkState.postValue(NetworkState.LOADING);
    }

    public /* synthetic */ void lambda$loadInitial$1$BuyNowOfferListDataSource(PageKeyedDataSource.LoadInitialCallback loadInitialCallback, BuyNowOfferListResponse buyNowOfferListResponse) throws Exception {
        int size = buyNowOfferListResponse.getBuyNowOfferList().size();
        this.totalCount = ((Integer) Objects.requireNonNull(Integer.valueOf(buyNowOfferListResponse.getBuyNowOfferCount()))).intValue();
        this.getBuyNowResponse.postValue(buyNowOfferListResponse);
        if (size > 0) {
            loadInitialCallback.onResult(buyNowOfferListResponse.getBuyNowOfferList(), null, Long.valueOf((long) (((Integer) Objects.requireNonNull(Integer.valueOf(buyNowOfferListResponse.getBuyNowOfferCount()))).intValue() - size)));
            this.networkState.postValue(NetworkState.LOADED);
        }
    }

    public /* synthetic */ void lambda$loadInitial$2$BuyNowOfferListDataSource(Throwable th) throws Exception {
        this.networkState.postValue(new NetworkState(NetworkState.Status.FAILED, th.getLocalizedMessage()));
    }

    @SuppressLint({"CheckResult"})
    public void loadAfter(@NonNull PageKeyedDataSource.LoadParams<Long> loadParams, @NonNull PageKeyedDataSource.LoadCallback<Long, BuyNowOfferListModel> loadCallback) {
        this.startIndex++;
        this.repository.getBuyNowOfferList(this.userId, this.startIndex).doOnSubscribe(new Consumer() {
            public final void accept(Object obj) {
                BuyNowOfferListDataSource.this.lambda$loadAfter$3$BuyNowOfferListDataSource((Disposable) obj);
            }
        }).subscribe(new Consumer(loadParams, loadCallback) {
            private final /* synthetic */ PageKeyedDataSource.LoadParams f$1;
            private final /* synthetic */ PageKeyedDataSource.LoadCallback f$2;

            {
                this.f$1 = r2;
                this.f$2 = r3;
            }

            public final void accept(Object obj) {
                BuyNowOfferListDataSource.this.lambda$loadAfter$4$BuyNowOfferListDataSource(this.f$1, this.f$2, (BuyNowOfferListResponse) obj);
            }
        }, new Consumer() {
            public final void accept(Object obj) {
                BuyNowOfferListDataSource.this.lambda$loadAfter$5$BuyNowOfferListDataSource((Throwable) obj);
            }
        });
    }

    public /* synthetic */ void lambda$loadAfter$3$BuyNowOfferListDataSource(Disposable disposable) throws Exception {
        this.compositeDisposable.add(disposable);
        this.networkState.postValue(NetworkState.LOADING);
    }

    public /* synthetic */ void lambda$loadAfter$4$BuyNowOfferListDataSource(PageKeyedDataSource.LoadParams loadParams, PageKeyedDataSource.LoadCallback loadCallback, BuyNowOfferListResponse buyNowOfferListResponse) throws Exception {
        buyNowOfferListResponse.setBuyNowOfferCount(this.totalCount);
        this.getBuyNowResponse.postValue(buyNowOfferListResponse);
        long longValue = ((Long) loadParams.key).longValue() - ((long) buyNowOfferListResponse.getBuyNowOfferList().size());
        if (longValue == 0) {
            loadCallback.onResult(buyNowOfferListResponse.getBuyNowOfferList(), null);
        } else {
            loadCallback.onResult(buyNowOfferListResponse.getBuyNowOfferList(), Long.valueOf(longValue));
        }
        this.networkState.postValue(NetworkState.LOADED);
    }

    public /* synthetic */ void lambda$loadAfter$5$BuyNowOfferListDataSource(Throwable th) throws Exception {
        this.networkState.postValue(new NetworkState(NetworkState.Status.FAILED, th.getLocalizedMessage()));
    }
}

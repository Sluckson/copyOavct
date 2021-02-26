package com.iaai.android.bdt.feature.digitalNegotiation.dataSource;

import android.annotation.SuppressLint;
import androidx.annotation.NonNull;
import androidx.lifecycle.MutableLiveData;
import androidx.paging.PageKeyedDataSource;
import com.iaai.android.bdt.feature.digitalNegotiation.ManageOfferListRepository;
import com.iaai.android.bdt.model.auctionSalesList.AuctionSaleList;
import com.iaai.android.bdt.model.auctionSalesList.AuctionSalesListResponse;
import com.iaai.android.bdt.model.auctionSalesList.RequestBody;
import com.iaai.android.bdt.model.auctionSalesList.ResultData;
import com.iaai.android.bdt.utils.NetworkState;
import java.util.Locale;
import p011io.reactivex.disposables.CompositeDisposable;
import p011io.reactivex.disposables.Disposable;
import p011io.reactivex.functions.Consumer;

public class ManageOfferSource extends PageKeyedDataSource<Long, ResultData> {
    private static final String TAG = "ManageOfferSource";
    private String authorizationHeader;
    public RequestBody body;
    private int branchId;
    private CompositeDisposable compositeDisposable;
    private String date;
    private int end;
    private MutableLiveData<NetworkState> networkState = new MutableLiveData<>();
    private ManageOfferListRepository repository;
    private int start;

    public void loadBefore(@NonNull PageKeyedDataSource.LoadParams<Long> loadParams, @NonNull PageKeyedDataSource.LoadCallback<Long, ResultData> loadCallback) {
    }

    public MutableLiveData getNetworkState() {
        return this.networkState;
    }

    ManageOfferSource(ManageOfferListRepository manageOfferListRepository, CompositeDisposable compositeDisposable2, RequestBody requestBody, String str) {
        this.repository = manageOfferListRepository;
        this.compositeDisposable = compositeDisposable2;
        this.body = requestBody;
        this.authorizationHeader = str;
    }

    @SuppressLint({"CheckResult"})
    public void loadInitial(@NonNull PageKeyedDataSource.LoadInitialParams<Long> loadInitialParams, @NonNull PageKeyedDataSource.LoadInitialCallback<Long, ResultData> loadInitialCallback) {
        this.start = this.body.getAuctionSaleList().getStart();
        this.end = this.body.getAuctionSaleList().getEnd();
        this.date = this.body.getAuctionSaleList().getAuctiondate();
        this.branchId = this.body.getAuctionSaleList().getBranchcode();
        this.repository.getList(this.body, this.authorizationHeader).doOnSubscribe(new Consumer() {
            public final void accept(Object obj) {
                ManageOfferSource.this.lambda$loadInitial$0$ManageOfferSource((Disposable) obj);
            }
        }).subscribe(new Consumer(loadInitialCallback) {
            private final /* synthetic */ PageKeyedDataSource.LoadInitialCallback f$1;

            {
                this.f$1 = r2;
            }

            public final void accept(Object obj) {
                ManageOfferSource.this.lambda$loadInitial$1$ManageOfferSource(this.f$1, (AuctionSalesListResponse) obj);
            }
        }, new Consumer() {
            public final void accept(Object obj) {
                ManageOfferSource.this.lambda$loadInitial$2$ManageOfferSource((Throwable) obj);
            }
        });
    }

    public /* synthetic */ void lambda$loadInitial$0$ManageOfferSource(Disposable disposable) throws Exception {
        this.compositeDisposable.add(disposable);
        this.networkState.postValue(NetworkState.LOADING);
    }

    public /* synthetic */ void lambda$loadInitial$1$ManageOfferSource(PageKeyedDataSource.LoadInitialCallback loadInitialCallback, AuctionSalesListResponse auctionSalesListResponse) throws Exception {
        if (auctionSalesListResponse.getResultData().size() > 0) {
            loadInitialCallback.onResult(auctionSalesListResponse.getResultData(), null, Long.valueOf((long) (auctionSalesListResponse.getListCount() - this.end)));
            this.networkState.postValue(NetworkState.LOADED);
        }
    }

    public /* synthetic */ void lambda$loadInitial$2$ManageOfferSource(Throwable th) throws Exception {
        this.networkState.postValue(new NetworkState(NetworkState.Status.FAILED, th.getLocalizedMessage()));
    }

    @SuppressLint({"CheckResult"})
    public void loadAfter(@NonNull PageKeyedDataSource.LoadParams<Long> loadParams, @NonNull PageKeyedDataSource.LoadCallback<Long, ResultData> loadCallback) {
        int i = this.end;
        this.start = i + 1;
        this.end = i + 30;
        this.repository.getList(getRequestBody(this.start, this.end), this.authorizationHeader).doOnSubscribe(new Consumer() {
            public final void accept(Object obj) {
                ManageOfferSource.this.lambda$loadAfter$3$ManageOfferSource((Disposable) obj);
            }
        }).subscribe(new Consumer(loadParams, loadCallback) {
            private final /* synthetic */ PageKeyedDataSource.LoadParams f$1;
            private final /* synthetic */ PageKeyedDataSource.LoadCallback f$2;

            {
                this.f$1 = r2;
                this.f$2 = r3;
            }

            public final void accept(Object obj) {
                ManageOfferSource.this.lambda$loadAfter$4$ManageOfferSource(this.f$1, this.f$2, (AuctionSalesListResponse) obj);
            }
        }, new Consumer() {
            public final void accept(Object obj) {
                ManageOfferSource.this.lambda$loadAfter$5$ManageOfferSource((Throwable) obj);
            }
        });
    }

    public /* synthetic */ void lambda$loadAfter$3$ManageOfferSource(Disposable disposable) throws Exception {
        this.compositeDisposable.add(disposable);
        this.networkState.postValue(NetworkState.LOADING);
    }

    public /* synthetic */ void lambda$loadAfter$4$ManageOfferSource(PageKeyedDataSource.LoadParams loadParams, PageKeyedDataSource.LoadCallback loadCallback, AuctionSalesListResponse auctionSalesListResponse) throws Exception {
        long longValue = ((Long) loadParams.key).longValue() - ((long) auctionSalesListResponse.getResultData().size());
        if (longValue == 0) {
            loadCallback.onResult(auctionSalesListResponse.getResultData(), null);
        } else {
            loadCallback.onResult(auctionSalesListResponse.getResultData(), Long.valueOf(longValue));
        }
        this.networkState.postValue(NetworkState.LOADED);
    }

    public /* synthetic */ void lambda$loadAfter$5$ManageOfferSource(Throwable th) throws Exception {
        this.networkState.postValue(new NetworkState(NetworkState.Status.FAILED, th.getLocalizedMessage()));
    }

    private RequestBody getRequestBody(int i, int i2) {
        String str = this.date;
        int i3 = this.branchId;
        String language = Locale.getDefault().getLanguage();
        String direction = this.body.getAuctionSaleList().getDirection();
        AuctionSaleList auctionSaleList = r1;
        AuctionSaleList auctionSaleList2 = new AuctionSaleList(str, i3, language, "android", "", direction, i2, this.body.getAuctionSaleList().getEndYear(), this.body.getAuctionSaleList().getLane(), 30, this.body.getAuctionSaleList().getSortcolumn(), i, this.body.getAuctionSaleList().getStartYear(), "", "", this.body.getAuctionSaleList().getLosstype());
        return new RequestBody(auctionSaleList);
    }
}
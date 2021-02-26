package com.iaai.android.bdt.feature.account.salesdocument.dataSource;

import android.annotation.SuppressLint;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.lifecycle.MutableLiveData;
import androidx.paging.PageKeyedDataSource;
import com.iaai.android.bdt.feature.account.salesdocument.SaleDocumentRepository;
import com.iaai.android.bdt.model.MyAccount.SaleDocumentListModel;
import com.iaai.android.bdt.model.MyAccount.SaleDocumentListResponse;
import com.iaai.android.bdt.model.MyAccount.SaleDocumentRequestBody;
import com.iaai.android.bdt.utils.NetworkState;
import p011io.reactivex.disposables.CompositeDisposable;
import p011io.reactivex.disposables.Disposable;
import p011io.reactivex.functions.Consumer;

public class SaleDocumentDataSource extends PageKeyedDataSource<Long, SaleDocumentListModel> {
    private static final String TAG = "SaleDocumentDataSource";
    private String authorizationHeader;
    public SaleDocumentRequestBody body;
    private CompositeDisposable compositeDisposable;
    private boolean isFilterApplied;
    private String mApikey;
    private String mAppversion;
    private String mContentType;
    private String mDeviceid;
    private String mDevicetype;
    private MutableLiveData<NetworkState> networkState = new MutableLiveData<>();
    private int pageNumber;
    private SaleDocumentRepository repository;
    private MutableLiveData<SaleDocumentListResponse> saleDocumentListResponse = new MutableLiveData<>();
    private MutableLiveData<Integer> scrollSearchListToTop;
    private int stepCount;

    public void loadBefore(@NonNull PageKeyedDataSource.LoadParams<Long> loadParams, @NonNull PageKeyedDataSource.LoadCallback<Long, SaleDocumentListModel> loadCallback) {
    }

    public MutableLiveData getScrollSearchListToTopCount() {
        return this.scrollSearchListToTop;
    }

    public MutableLiveData getNetworkState() {
        return this.networkState;
    }

    public MutableLiveData getSaleDocumentListResponse() {
        return this.saleDocumentListResponse;
    }

    SaleDocumentDataSource(SaleDocumentRepository saleDocumentRepository, CompositeDisposable compositeDisposable2, SaleDocumentRequestBody saleDocumentRequestBody, String str, String str2, String str3, String str4, String str5, String str6, boolean z) {
        this.repository = saleDocumentRepository;
        this.compositeDisposable = compositeDisposable2;
        this.body = saleDocumentRequestBody;
        this.authorizationHeader = str;
        this.mApikey = str6;
        this.mDeviceid = str5;
        this.mDevicetype = str4;
        this.mAppversion = str2;
        this.mContentType = str3;
        this.scrollSearchListToTop = new MutableLiveData<>();
        this.isFilterApplied = z;
    }

    @SuppressLint({"CheckResult"})
    public void loadInitial(@NonNull PageKeyedDataSource.LoadInitialParams<Long> loadInitialParams, @NonNull PageKeyedDataSource.LoadInitialCallback<Long, SaleDocumentListModel> loadInitialCallback) {
        this.pageNumber = this.body.getPageNumber();
        this.stepCount = this.body.getItemsPerPage();
        Log.e("TEST", "loadInitial: pageNumber: " + this.pageNumber);
        this.repository.getSaleDocumentList(this.authorizationHeader, this.mDeviceid, this.mDevicetype, this.mApikey, this.mContentType, this.mAppversion, this.body).doOnSubscribe(new Consumer() {
            public final void accept(Object obj) {
                SaleDocumentDataSource.this.lambda$loadInitial$0$SaleDocumentDataSource((Disposable) obj);
            }
        }).subscribe(new Consumer(loadInitialCallback) {
            private final /* synthetic */ PageKeyedDataSource.LoadInitialCallback f$1;

            {
                this.f$1 = r2;
            }

            public final void accept(Object obj) {
                SaleDocumentDataSource.this.lambda$loadInitial$1$SaleDocumentDataSource(this.f$1, (SaleDocumentListResponse) obj);
            }
        }, new Consumer() {
            public final void accept(Object obj) {
                SaleDocumentDataSource.this.lambda$loadInitial$2$SaleDocumentDataSource((Throwable) obj);
            }
        });
    }

    public /* synthetic */ void lambda$loadInitial$0$SaleDocumentDataSource(Disposable disposable) throws Exception {
        this.compositeDisposable.add(disposable);
        this.networkState.postValue(NetworkState.LOADING);
    }

    public /* synthetic */ void lambda$loadInitial$1$SaleDocumentDataSource(PageKeyedDataSource.LoadInitialCallback loadInitialCallback, SaleDocumentListResponse saleDocumentListResponse2) throws Exception {
        this.saleDocumentListResponse.postValue(saleDocumentListResponse2);
        if (saleDocumentListResponse2.getTitleInstructionItemList() != null && saleDocumentListResponse2.getTitleInstructionItemList().size() > 0) {
            loadInitialCallback.onResult(saleDocumentListResponse2.getTitleInstructionItemList(), null, Long.valueOf((long) (saleDocumentListResponse2.getItemCount() - (this.pageNumber * this.stepCount))));
            this.networkState.postValue(NetworkState.LOADED);
        }
    }

    public /* synthetic */ void lambda$loadInitial$2$SaleDocumentDataSource(Throwable th) throws Exception {
        this.networkState.postValue(new NetworkState(NetworkState.Status.FAILED, th.getLocalizedMessage()));
    }

    @SuppressLint({"CheckResult"})
    public void loadAfter(@NonNull PageKeyedDataSource.LoadParams<Long> loadParams, @NonNull PageKeyedDataSource.LoadCallback<Long, SaleDocumentListModel> loadCallback) {
        this.pageNumber++;
        Log.e("TEST", "loadAfter: pageNumber: " + this.pageNumber);
        this.repository.getSaleDocumentList(this.authorizationHeader, this.mDeviceid, this.mDevicetype, this.mApikey, this.mContentType, this.mAppversion, getRequestBody(this.pageNumber)).doOnSubscribe(new Consumer() {
            public final void accept(Object obj) {
                SaleDocumentDataSource.this.lambda$loadAfter$3$SaleDocumentDataSource((Disposable) obj);
            }
        }).subscribe(new Consumer(loadParams, loadCallback) {
            private final /* synthetic */ PageKeyedDataSource.LoadParams f$1;
            private final /* synthetic */ PageKeyedDataSource.LoadCallback f$2;

            {
                this.f$1 = r2;
                this.f$2 = r3;
            }

            public final void accept(Object obj) {
                SaleDocumentDataSource.this.lambda$loadAfter$4$SaleDocumentDataSource(this.f$1, this.f$2, (SaleDocumentListResponse) obj);
            }
        }, new Consumer() {
            public final void accept(Object obj) {
                SaleDocumentDataSource.this.lambda$loadAfter$5$SaleDocumentDataSource((Throwable) obj);
            }
        });
    }

    public /* synthetic */ void lambda$loadAfter$3$SaleDocumentDataSource(Disposable disposable) throws Exception {
        this.compositeDisposable.add(disposable);
        this.networkState.postValue(NetworkState.LOADING);
    }

    public /* synthetic */ void lambda$loadAfter$4$SaleDocumentDataSource(PageKeyedDataSource.LoadParams loadParams, PageKeyedDataSource.LoadCallback loadCallback, SaleDocumentListResponse saleDocumentListResponse2) throws Exception {
        this.saleDocumentListResponse.postValue(saleDocumentListResponse2);
        if (saleDocumentListResponse2.getTitleInstructionItemList() != null) {
            long longValue = ((Long) loadParams.key).longValue() - ((long) saleDocumentListResponse2.getTitleInstructionItemList().size());
            if (longValue == 0) {
                loadCallback.onResult(saleDocumentListResponse2.getTitleInstructionItemList(), null);
            } else {
                loadCallback.onResult(saleDocumentListResponse2.getTitleInstructionItemList(), Long.valueOf(longValue));
            }
            this.networkState.postValue(NetworkState.LOADED);
        }
        if (this.isFilterApplied) {
            this.scrollSearchListToTop.postValue(0);
            this.isFilterApplied = false;
        }
    }

    public /* synthetic */ void lambda$loadAfter$5$SaleDocumentDataSource(Throwable th) throws Exception {
        this.networkState.postValue(new NetworkState(NetworkState.Status.FAILED, th.getLocalizedMessage()));
    }

    private SaleDocumentRequestBody getRequestBody(int i) {
        return new SaleDocumentRequestBody(this.body.getSelectedSalvageSaleIds(), this.body.getTitleStatus(), i, this.body.getItemsPerPage(), this.body.getSortColumn(), this.body.getSortAscending(), this.body.getBranchcode());
    }
}

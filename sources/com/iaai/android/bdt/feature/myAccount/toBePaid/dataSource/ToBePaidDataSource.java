package com.iaai.android.bdt.feature.myAccount.toBePaid.dataSource;

import android.annotation.SuppressLint;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.lifecycle.MutableLiveData;
import androidx.paging.PageKeyedDataSource;
import com.iaai.android.bdt.feature.myAccount.MyAccountRepository;
import com.iaai.android.bdt.feature.myAccount.toBePaid.TempRequestBody;
import com.iaai.android.bdt.model.toBePaid.paymentDueList.PaymentDue;
import com.iaai.android.bdt.model.toBePaid.paymentDueList.PaymentDueListResponse;
import com.iaai.android.bdt.utils.NetworkState;
import p011io.reactivex.disposables.CompositeDisposable;
import p011io.reactivex.disposables.Disposable;
import p011io.reactivex.functions.Consumer;

public class ToBePaidDataSource extends PageKeyedDataSource<Long, PaymentDue> {
    private static final String TAG = "ToBePaidDataSource";
    private String authorizationHeader;
    public TempRequestBody body;
    private CompositeDisposable compositeDisposable;
    private MutableLiveData<NetworkState> networkState = new MutableLiveData<>();
    private int pageNumber;
    private MutableLiveData<PaymentDueListResponse> paymentDueListResponse = new MutableLiveData<>();
    private MyAccountRepository repository;
    private int stepCount;

    public void loadBefore(@NonNull PageKeyedDataSource.LoadParams<Long> loadParams, @NonNull PageKeyedDataSource.LoadCallback<Long, PaymentDue> loadCallback) {
    }

    public MutableLiveData getNetworkState() {
        return this.networkState;
    }

    public MutableLiveData getPaymentDueListResponse() {
        return this.paymentDueListResponse;
    }

    ToBePaidDataSource(MyAccountRepository myAccountRepository, CompositeDisposable compositeDisposable2, TempRequestBody tempRequestBody, String str) {
        this.repository = myAccountRepository;
        this.compositeDisposable = compositeDisposable2;
        this.body = tempRequestBody;
        this.authorizationHeader = str;
    }

    @SuppressLint({"CheckResult"})
    public void loadInitial(@NonNull PageKeyedDataSource.LoadInitialParams<Long> loadInitialParams, @NonNull PageKeyedDataSource.LoadInitialCallback<Long, PaymentDue> loadInitialCallback) {
        this.pageNumber = this.body.getPageNumber();
        this.stepCount = this.body.getCount();
        Log.e("TEST", "loadInitial: pageNumber: " + this.pageNumber);
        this.repository.getPaymentDueList(this.body, this.authorizationHeader).doOnSubscribe(new Consumer() {
            public final void accept(Object obj) {
                ToBePaidDataSource.this.lambda$loadInitial$0$ToBePaidDataSource((Disposable) obj);
            }
        }).subscribe(new Consumer(loadInitialCallback) {
            private final /* synthetic */ PageKeyedDataSource.LoadInitialCallback f$1;

            {
                this.f$1 = r2;
            }

            public final void accept(Object obj) {
                ToBePaidDataSource.this.lambda$loadInitial$1$ToBePaidDataSource(this.f$1, (PaymentDueListResponse) obj);
            }
        }, new Consumer() {
            public final void accept(Object obj) {
                ToBePaidDataSource.this.lambda$loadInitial$2$ToBePaidDataSource((Throwable) obj);
            }
        });
    }

    public /* synthetic */ void lambda$loadInitial$0$ToBePaidDataSource(Disposable disposable) throws Exception {
        this.compositeDisposable.add(disposable);
        this.networkState.postValue(NetworkState.LOADING);
    }

    public /* synthetic */ void lambda$loadInitial$1$ToBePaidDataSource(PageKeyedDataSource.LoadInitialCallback loadInitialCallback, PaymentDueListResponse paymentDueListResponse2) throws Exception {
        this.paymentDueListResponse.postValue(paymentDueListResponse2);
        if (paymentDueListResponse2.getPaymentDueModel().getPaymentDueList() != null && paymentDueListResponse2.getPaymentDueModel().getPaymentDueList().size() > 0) {
            loadInitialCallback.onResult(paymentDueListResponse2.getPaymentDueModel().getPaymentDueList(), null, Long.valueOf((long) (paymentDueListResponse2.getPaymentDueModel().getItemsCount().intValue() - (this.pageNumber * this.stepCount))));
            this.networkState.postValue(NetworkState.LOADED);
        }
    }

    public /* synthetic */ void lambda$loadInitial$2$ToBePaidDataSource(Throwable th) throws Exception {
        this.networkState.postValue(new NetworkState(NetworkState.Status.FAILED, th.getLocalizedMessage()));
    }

    @SuppressLint({"CheckResult"})
    public void loadAfter(@NonNull PageKeyedDataSource.LoadParams<Long> loadParams, @NonNull PageKeyedDataSource.LoadCallback<Long, PaymentDue> loadCallback) {
        this.pageNumber++;
        Log.e("TEST", "loadAfter: pageNumber: " + this.pageNumber);
        this.repository.getPaymentDueList(getRequestBody(this.pageNumber), this.authorizationHeader).doOnSubscribe(new Consumer() {
            public final void accept(Object obj) {
                ToBePaidDataSource.this.lambda$loadAfter$3$ToBePaidDataSource((Disposable) obj);
            }
        }).subscribe(new Consumer(loadParams, loadCallback) {
            private final /* synthetic */ PageKeyedDataSource.LoadParams f$1;
            private final /* synthetic */ PageKeyedDataSource.LoadCallback f$2;

            {
                this.f$1 = r2;
                this.f$2 = r3;
            }

            public final void accept(Object obj) {
                ToBePaidDataSource.this.lambda$loadAfter$4$ToBePaidDataSource(this.f$1, this.f$2, (PaymentDueListResponse) obj);
            }
        }, new Consumer() {
            public final void accept(Object obj) {
                ToBePaidDataSource.this.lambda$loadAfter$5$ToBePaidDataSource((Throwable) obj);
            }
        });
    }

    public /* synthetic */ void lambda$loadAfter$3$ToBePaidDataSource(Disposable disposable) throws Exception {
        this.compositeDisposable.add(disposable);
        this.networkState.postValue(NetworkState.LOADING);
    }

    public /* synthetic */ void lambda$loadAfter$4$ToBePaidDataSource(PageKeyedDataSource.LoadParams loadParams, PageKeyedDataSource.LoadCallback loadCallback, PaymentDueListResponse paymentDueListResponse2) throws Exception {
        this.paymentDueListResponse.postValue(paymentDueListResponse2);
        if (paymentDueListResponse2.getPaymentDueModel().getPaymentDueList() != null) {
            long longValue = ((Long) loadParams.key).longValue() - ((long) paymentDueListResponse2.getPaymentDueModel().getPaymentDueList().size());
            if (longValue == 0) {
                loadCallback.onResult(paymentDueListResponse2.getPaymentDueModel().getPaymentDueList(), null);
            } else {
                loadCallback.onResult(paymentDueListResponse2.getPaymentDueModel().getPaymentDueList(), Long.valueOf(longValue));
            }
            this.networkState.postValue(NetworkState.LOADED);
        }
    }

    public /* synthetic */ void lambda$loadAfter$5$ToBePaidDataSource(Throwable th) throws Exception {
        this.networkState.postValue(new NetworkState(NetworkState.Status.FAILED, th.getLocalizedMessage()));
    }

    private TempRequestBody getRequestBody(int i) {
        return new TempRequestBody(i, this.stepCount, this.body.getPaymentMethod(), this.body.getSortBy(), this.body.getSortAsc(), this.body.getOnlymyitems());
    }
}

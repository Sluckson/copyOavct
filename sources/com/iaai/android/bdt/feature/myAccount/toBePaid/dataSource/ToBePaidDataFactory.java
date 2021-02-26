package com.iaai.android.bdt.feature.myAccount.toBePaid.dataSource;

import androidx.lifecycle.MutableLiveData;
import androidx.paging.DataSource;
import com.iaai.android.bdt.feature.myAccount.MyAccountRepository;
import com.iaai.android.bdt.feature.myAccount.toBePaid.TempRequestBody;
import com.iaai.android.bdt.model.toBePaid.paymentDueList.PaymentDue;
import p011io.reactivex.disposables.CompositeDisposable;

public class ToBePaidDataFactory extends DataSource.Factory {
    private String authorizationHeader;
    private CompositeDisposable compositeDisposable;
    private MutableLiveData<ToBePaidDataSource> mutableLiveData = new MutableLiveData<>();
    private MyAccountRepository repository;
    private TempRequestBody requestBody;
    private ToBePaidDataSource toBePaidDataSource;

    public ToBePaidDataFactory(MyAccountRepository myAccountRepository, CompositeDisposable compositeDisposable2, TempRequestBody tempRequestBody, String str) {
        this.repository = myAccountRepository;
        this.compositeDisposable = compositeDisposable2;
        this.requestBody = tempRequestBody;
        this.authorizationHeader = str;
    }

    public DataSource<Long, PaymentDue> create() {
        this.toBePaidDataSource = new ToBePaidDataSource(this.repository, this.compositeDisposable, this.requestBody, this.authorizationHeader);
        this.mutableLiveData.postValue(this.toBePaidDataSource);
        return this.toBePaidDataSource;
    }

    public MutableLiveData<ToBePaidDataSource> getMutableLiveData() {
        return this.mutableLiveData;
    }
}

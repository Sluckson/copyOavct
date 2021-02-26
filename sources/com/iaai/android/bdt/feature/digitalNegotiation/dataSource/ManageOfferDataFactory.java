package com.iaai.android.bdt.feature.digitalNegotiation.dataSource;

import androidx.lifecycle.MutableLiveData;
import androidx.paging.DataSource;
import com.iaai.android.bdt.feature.digitalNegotiation.ManageOfferListRepository;
import com.iaai.android.bdt.model.auctionSalesList.RequestBody;
import com.iaai.android.bdt.model.auctionSalesList.ResultData;
import p011io.reactivex.disposables.CompositeDisposable;

public class ManageOfferDataFactory extends DataSource.Factory {
    private String authorizationHeader;
    private CompositeDisposable compositeDisposable;
    private ManageOfferSource manageOfferSource;
    private MutableLiveData<ManageOfferSource> mutableLiveData = new MutableLiveData<>();
    private ManageOfferListRepository repository;
    private RequestBody requestBody;

    public ManageOfferDataFactory(ManageOfferListRepository manageOfferListRepository, CompositeDisposable compositeDisposable2, RequestBody requestBody2, String str) {
        this.repository = manageOfferListRepository;
        this.compositeDisposable = compositeDisposable2;
        this.requestBody = requestBody2;
        this.authorizationHeader = str;
    }

    public DataSource<Long, ResultData> create() {
        this.manageOfferSource = new ManageOfferSource(this.repository, this.compositeDisposable, this.requestBody, this.authorizationHeader);
        this.mutableLiveData.postValue(this.manageOfferSource);
        return this.manageOfferSource;
    }

    public MutableLiveData<ManageOfferSource> getMutableLiveData() {
        return this.mutableLiveData;
    }
}

package com.iaai.android.bdt.feature.auctionSalesList.dataSource;

import androidx.lifecycle.MutableLiveData;
import androidx.paging.DataSource;
import com.iaai.android.bdt.feature.auctionSalesList.AuctionSalesListRepository;
import com.iaai.android.bdt.model.auctionSalesList.RequestBody;
import com.iaai.android.bdt.model.auctionSalesList.ResultData;
import p011io.reactivex.disposables.CompositeDisposable;

public class AuctionSaleDataFactory extends DataSource.Factory {
    private AuctionDataSource auctionDataSource;
    private String authorizationHeader;
    private CompositeDisposable compositeDisposable;
    private boolean isFilterApplied;
    private MutableLiveData<AuctionDataSource> mutableLiveData = new MutableLiveData<>();
    private AuctionSalesListRepository repository;
    private RequestBody requestBody;

    public AuctionSaleDataFactory(AuctionSalesListRepository auctionSalesListRepository, CompositeDisposable compositeDisposable2, RequestBody requestBody2, String str, boolean z) {
        this.repository = auctionSalesListRepository;
        this.compositeDisposable = compositeDisposable2;
        this.requestBody = requestBody2;
        this.authorizationHeader = str;
        this.isFilterApplied = z;
    }

    public DataSource<Long, ResultData> create() {
        this.auctionDataSource = new AuctionDataSource(this.repository, this.compositeDisposable, this.requestBody, this.authorizationHeader, this.isFilterApplied);
        this.mutableLiveData.postValue(this.auctionDataSource);
        return this.auctionDataSource;
    }

    public MutableLiveData<AuctionDataSource> getMutableLiveData() {
        return this.mutableLiveData;
    }
}

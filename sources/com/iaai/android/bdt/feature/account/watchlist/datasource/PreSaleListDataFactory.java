package com.iaai.android.bdt.feature.account.watchlist.datasource;

import androidx.lifecycle.MutableLiveData;
import androidx.paging.DataSource;
import com.iaai.android.bdt.feature.account.watchlist.PreSaleListRepository;
import com.iaai.android.bdt.model.MyAccount.WatchListModel;
import p011io.reactivex.disposables.CompositeDisposable;

public class PreSaleListDataFactory extends DataSource.Factory {
    private PreSaleListDataSource auctionDataSource;
    private String authorizationHeader;
    private CompositeDisposable compositeDisposable;
    private String keyword;
    private MutableLiveData<PreSaleListDataSource> mutableLiveData = new MutableLiveData<>();
    private Boolean onlymyitems;
    private PreSaleListRepository repository;
    private String sortBy;
    private int sortDirection;
    private int startIndex;
    private String status;
    private String userId;

    public PreSaleListDataFactory(PreSaleListRepository preSaleListRepository, CompositeDisposable compositeDisposable2, String str, String str2, String str3, Integer num, Boolean bool, String str4, Integer num2, String str5) {
        this.repository = preSaleListRepository;
        this.compositeDisposable = compositeDisposable2;
        this.userId = str2;
        this.status = str3;
        this.onlymyitems = bool;
        this.startIndex = num.intValue();
        this.sortBy = str4;
        this.sortDirection = num2.intValue();
        this.authorizationHeader = str;
        this.keyword = str5;
    }

    public DataSource<Long, WatchListModel> create() {
        this.auctionDataSource = new PreSaleListDataSource(this.repository, this.compositeDisposable, this.authorizationHeader, this.userId, this.status, Integer.valueOf(this.startIndex), this.onlymyitems, this.sortBy, Integer.valueOf(this.sortDirection), this.keyword);
        this.mutableLiveData.postValue(this.auctionDataSource);
        return this.auctionDataSource;
    }

    public MutableLiveData<PreSaleListDataSource> getMutableLiveData() {
        return this.mutableLiveData;
    }
}

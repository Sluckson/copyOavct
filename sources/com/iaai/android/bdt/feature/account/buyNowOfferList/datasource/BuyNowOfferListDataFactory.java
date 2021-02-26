package com.iaai.android.bdt.feature.account.buyNowOfferList.datasource;

import androidx.lifecycle.MutableLiveData;
import androidx.paging.DataSource;
import com.iaai.android.bdt.feature.account.buyNowOfferList.BuyNowOfferListRepository;
import com.iaai.android.bdt.model.MyAccount.BuyNowOfferListModel;
import p011io.reactivex.disposables.CompositeDisposable;

public class BuyNowOfferListDataFactory extends DataSource.Factory {
    private BuyNowOfferListDataSource auctionDataSource;
    private CompositeDisposable compositeDisposable;
    private MutableLiveData<BuyNowOfferListDataSource> mutableLiveData = new MutableLiveData<>();
    private BuyNowOfferListRepository repository;
    private int startIndex;
    private String userId;

    public BuyNowOfferListDataFactory(BuyNowOfferListRepository buyNowOfferListRepository, CompositeDisposable compositeDisposable2, String str, Integer num) {
        this.repository = buyNowOfferListRepository;
        this.compositeDisposable = compositeDisposable2;
        this.userId = str;
        this.startIndex = num.intValue();
    }

    public DataSource<Long, BuyNowOfferListModel> create() {
        this.auctionDataSource = new BuyNowOfferListDataSource(this.repository, this.compositeDisposable, this.userId, Integer.valueOf(this.startIndex));
        this.mutableLiveData.postValue(this.auctionDataSource);
        return this.auctionDataSource;
    }

    public MutableLiveData<BuyNowOfferListDataSource> getMutableLiveData() {
        return this.mutableLiveData;
    }
}

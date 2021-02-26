package com.iaai.android.bdt.feature.account.tobepickedup.datasource;

import androidx.lifecycle.MutableLiveData;
import androidx.paging.DataSource;
import com.iaai.android.bdt.feature.account.tobepickedup.ToBePickedUpRepository;
import com.iaai.android.bdt.model.MyAccount.ToBePickedUpVehiclesModel;
import p011io.reactivex.disposables.CompositeDisposable;

public class ToBePickedUpListDataFactory extends DataSource.Factory {
    private ToBePickedUpListDataSource auctionDataSource;
    private String authorizationHeader;
    private CompositeDisposable compositeDisposable;
    private MutableLiveData<ToBePickedUpListDataSource> mutableLiveData = new MutableLiveData<>();
    private Boolean onlymyitems;
    private ToBePickedUpRepository repository;
    private String sortBy;
    private int sortDirection;
    private int startIndex;
    private String userId;

    public ToBePickedUpListDataFactory(ToBePickedUpRepository toBePickedUpRepository, CompositeDisposable compositeDisposable2, String str, String str2, Integer num, Boolean bool, String str3, Integer num2) {
        this.repository = toBePickedUpRepository;
        this.compositeDisposable = compositeDisposable2;
        this.userId = str2;
        this.onlymyitems = bool;
        this.startIndex = num.intValue();
        this.sortBy = str3;
        this.sortDirection = num2.intValue();
        this.authorizationHeader = str;
    }

    public DataSource<Long, ToBePickedUpVehiclesModel> create() {
        this.auctionDataSource = new ToBePickedUpListDataSource(this.repository, this.compositeDisposable, this.authorizationHeader, this.userId, Integer.valueOf(this.startIndex), this.onlymyitems, this.sortBy, Integer.valueOf(this.sortDirection));
        this.mutableLiveData.postValue(this.auctionDataSource);
        return this.auctionDataSource;
    }

    public MutableLiveData<ToBePickedUpListDataSource> getMutableLiveData() {
        return this.mutableLiveData;
    }
}

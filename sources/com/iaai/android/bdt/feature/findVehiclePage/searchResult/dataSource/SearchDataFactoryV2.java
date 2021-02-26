package com.iaai.android.bdt.feature.findVehiclePage.searchResult.dataSource;

import androidx.lifecycle.MutableLiveData;
import androidx.paging.DataSource;
import com.iaai.android.bdt.feature.viewPager.FastSearchListRepository;
import com.iaai.android.bdt.model.fastSearch.SearchInputV2;
import com.iaai.android.bdt.model.fastSearch.Vehicle;
import p011io.reactivex.disposables.CompositeDisposable;

public class SearchDataFactoryV2 extends DataSource.Factory {
    private SearchDataSourceV2 auctionDataSourceSearch;
    private String authorizationHeader;
    private CompositeDisposable compositeDisposable;
    private String deviceID;
    private boolean isFilterApplied;
    private MutableLiveData<SearchDataSourceV2> mutableLiveData = new MutableLiveData<>();
    private FastSearchListRepository repository;
    private SearchInputV2 requestBody;

    public SearchDataFactoryV2(FastSearchListRepository fastSearchListRepository, CompositeDisposable compositeDisposable2, SearchInputV2 searchInputV2, String str, String str2, boolean z) {
        this.repository = fastSearchListRepository;
        this.compositeDisposable = compositeDisposable2;
        this.requestBody = searchInputV2;
        this.authorizationHeader = str;
        this.deviceID = str2;
        this.isFilterApplied = z;
    }

    public DataSource<Long, Vehicle> create() {
        this.auctionDataSourceSearch = new SearchDataSourceV2(this.repository, this.compositeDisposable, this.requestBody, this.authorizationHeader, this.deviceID, this.isFilterApplied);
        this.mutableLiveData.postValue(this.auctionDataSourceSearch);
        return this.auctionDataSourceSearch;
    }

    public MutableLiveData<SearchDataSourceV2> getMutableLiveData() {
        return this.mutableLiveData;
    }
}

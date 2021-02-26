package com.iaai.android.bdt.feature.account.salesdocument.dataSource;

import androidx.lifecycle.MutableLiveData;
import androidx.paging.DataSource;
import com.iaai.android.bdt.feature.account.salesdocument.SaleDocumentRepository;
import com.iaai.android.bdt.model.MyAccount.SaleDocumentListModel;
import com.iaai.android.bdt.model.MyAccount.SaleDocumentRequestBody;
import p011io.reactivex.disposables.CompositeDisposable;

public class SaleDocumentDataFactory extends DataSource.Factory {
    private String authorizationHeader;
    private CompositeDisposable compositeDisposable;
    private boolean isFilterApplied;
    private String mApikey;
    private String mAppversion;
    private String mContentType;
    private String mDeviceid;
    private String mDevicetype;
    private MutableLiveData<SaleDocumentDataSource> mutableLiveData = new MutableLiveData<>();
    private SaleDocumentRepository repository;
    private SaleDocumentRequestBody requestBody;
    private SaleDocumentDataSource saleDocumentDataSource;

    public SaleDocumentDataFactory(String str, String str2, String str3, String str4, String str5, String str6, SaleDocumentRepository saleDocumentRepository, CompositeDisposable compositeDisposable2, SaleDocumentRequestBody saleDocumentRequestBody, boolean z) {
        this.repository = saleDocumentRepository;
        this.compositeDisposable = compositeDisposable2;
        this.requestBody = saleDocumentRequestBody;
        this.authorizationHeader = str;
        this.mApikey = str4;
        this.mDeviceid = str2;
        this.mDevicetype = str3;
        this.mContentType = str5;
        this.mAppversion = str6;
        this.isFilterApplied = z;
    }

    public DataSource<Long, SaleDocumentListModel> create() {
        this.saleDocumentDataSource = new SaleDocumentDataSource(this.repository, this.compositeDisposable, this.requestBody, this.authorizationHeader, this.mAppversion, this.mContentType, this.mDevicetype, this.mDeviceid, this.mApikey, this.isFilterApplied);
        this.mutableLiveData.postValue(this.saleDocumentDataSource);
        return this.saleDocumentDataSource;
    }

    public MutableLiveData<SaleDocumentDataSource> getMutableLiveData() {
        return this.mutableLiveData;
    }
}

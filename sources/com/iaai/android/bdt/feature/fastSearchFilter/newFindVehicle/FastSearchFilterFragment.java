package com.iaai.android.bdt.feature.fastSearchFilter.newFindVehicle;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Application;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ExpandableListView;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.core.widget.NestedScrollView;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.exifinterface.media.ExifInterface;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.material.tabs.TabLayout;
import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import com.google.gson.Gson;
import com.google.zxing.integration.android.IntentIntegrator;
import com.iaai.android.C2723R;
import com.iaai.android.IaaiApplication;
import com.iaai.android.bdt.base.BaseFragment;
import com.iaai.android.bdt.extensions.Context_ExtensionKt;
import com.iaai.android.bdt.feature.fastSearchFilter.refinerResults.RefinerResultActivity;
import com.iaai.android.bdt.feature.fastSearchFilter.refinerResults.SelectedRefinerIndicesModel;
import com.iaai.android.bdt.feature.findVehiclePage.SearchPanelFindVehicleActivity;
import com.iaai.android.bdt.feature.findVehiclePage.filter.MakeModelFilterActivity;
import com.iaai.android.bdt.feature.login.SessionManager;
import com.iaai.android.bdt.feature.onBoarding.OnBoardingEnum;
import com.iaai.android.bdt.feature.productDetail.ProductDetailActivity;
import com.iaai.android.bdt.model.fastSearchFilter2.Facet;
import com.iaai.android.bdt.model.fastSearchFilter2.FacetX;
import com.iaai.android.bdt.model.fastSearchFilter2.FacetXX;
import com.iaai.android.bdt.model.fastSearchFilter2.FastSearchRequestBody;
import com.iaai.android.bdt.model.fastSearchFilter2.FastSearchResponse2;
import com.iaai.android.bdt.model.fastSearchFilter2.FormattedResult;
import com.iaai.android.bdt.model.fastSearchFilter2.LatLong;
import com.iaai.android.bdt.model.fastSearchFilter2.LongDiscretes;
import com.iaai.android.bdt.model.fastSearchFilter2.LongRangesData;
import com.iaai.android.bdt.model.fastSearchFilter2.SavedSearch;
import com.iaai.android.bdt.model.fastSearchFilter2.SearchMappingArray;
import com.iaai.android.bdt.model.fastSearchFilter2.SearchMappingGroup;
import com.iaai.android.bdt.model.fastSearchFilter2.Searche;
import com.iaai.android.bdt.model.fastSearchFilter2.Sort;
import com.iaai.android.bdt.model.filter.FilterData;
import com.iaai.android.bdt.model.filter.MakeModelValues;
import com.iaai.android.bdt.model.saveSearch.SaveSearchRequest;
import com.iaai.android.bdt.model.saveSearch.SaveSearchResponse;
import com.iaai.android.bdt.model.savedSearchList.SavedSearchListResponse;
import com.iaai.android.bdt.utils.AppPreferences;
import com.iaai.android.bdt.utils.BDTUtils;
import com.iaai.android.bdt.utils.Constants_MVVM;
import com.iaai.android.bdt.utils.InternetUtil;
import com.iaai.android.old.utils.AppUtils;
import com.iaai.android.old.utils.IAASharedPreference;
import com.iaai.android.old.utils.constants.Constants;
import dagger.android.support.AndroidSupportInjection;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Triple;
import kotlin.TypeCastException;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import kotlin.text.StringsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(mo66931bv = {1, 0, 3}, mo66932d1 = {"\u0000\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\b\u0007\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0012\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0000\n\u0002\u0010\u0015\n\u0002\b!\n\u0002\u0018\u0002\n\u0002\b\u000f*\u0003\f\u001a)\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J \u0010K\u001a\u00020L2\u0016\u0010M\u001a\u0012\u0012\u0004\u0012\u00020!0 j\b\u0012\u0004\u0012\u00020!`\"H\u0002J\b\u0010N\u001a\u00020LH\u0002J\b\u0010O\u001a\u00020LH\u0002J\b\u0010P\u001a\u00020LH\u0002J\u0010\u0010Q\u001a\u00020L2\u0006\u0010R\u001a\u00020\bH\u0002J\u0006\u0010S\u001a\u00020LJ\b\u0010T\u001a\u00020LH\u0002J\u0018\u0010U\u001a\u00020L2\u0006\u0010V\u001a\u00020\b2\u0006\u0010%\u001a\u00020\bH\u0002J\b\u0010W\u001a\u00020LH\u0002J\b\u0010X\u001a\u00020LH\u0002J\b\u0010Y\u001a\u00020LH\u0002J\u0010\u0010Z\u001a\u00020L2\u0006\u0010[\u001a\u00020\u001dH\u0002J\b\u0010\\\u001a\u00020LH\u0002J\u0012\u0010]\u001a\u00020L2\b\u0010^\u001a\u0004\u0018\u00010_H\u0002J\b\u0010`\u001a\u00020LH\u0002J\b\u0010a\u001a\u00020LH\u0002J\u0018\u0010b\u001a\u00020L2\u0006\u0010,\u001a\u00020\u00042\u0006\u0010c\u001a\u00020\u0004H\u0002J\b\u0010d\u001a\u00020\u001dH\u0002J\b\u0010e\u001a\u00020LH\u0002J\b\u0010f\u001a\u00020LH\u0002J \u0010g\u001a\u00020h2\u0016\u0010i\u001a\u0012\u0012\u0004\u0012\u00020<0 j\b\u0012\u0004\u0012\u00020<`\"H\u0002J\b\u0010j\u001a\u00020LH\u0002J\u0010\u0010k\u001a\u00020\u001d2\u0006\u0010R\u001a\u00020\bH\u0002J\u000e\u0010l\u001a\u00020L2\u0006\u0010m\u001a\u00020\u001dJ\u0010\u0010n\u001a\u00020L2\u0006\u0010R\u001a\u00020\bH\u0002J\b\u0010o\u001a\u00020LH\u0002J\u0012\u0010p\u001a\u00020L2\b\u0010^\u001a\u0004\u0018\u00010qH\u0002J\u0012\u0010r\u001a\u00020L2\b\u0010s\u001a\u0004\u0018\u00010tH\u0016J\"\u0010u\u001a\u00020L2\u0006\u0010v\u001a\u00020\b2\u0006\u0010w\u001a\u00020\b2\b\u0010^\u001a\u0004\u0018\u00010_H\u0016J\u0010\u0010x\u001a\u00020L2\u0006\u0010y\u001a\u00020zH\u0016J\u0012\u0010{\u001a\u00020L2\b\u0010s\u001a\u0004\u0018\u00010tH\u0016J(\u0010|\u001a\u0004\u0018\u00010}2\u0006\u0010~\u001a\u000202\n\u0010\u0001\u001a\u0005\u0018\u00010\u00012\b\u0010s\u001a\u0004\u0018\u00010tH\u0016J1\u0010\u0001\u001a\u00020L2\u0006\u0010v\u001a\u00020\b2\u000e\u0010\u0001\u001a\t\u0012\u0004\u0012\u00020\u00040\u00012\b\u0010\u0001\u001a\u00030\u0001H\u0016¢\u0006\u0003\u0010\u0001J\t\u0010\u0001\u001a\u00020LH\u0016J\t\u0010\u0001\u001a\u00020LH\u0002J\t\u0010\u0001\u001a\u00020LH\u0002J\t\u0010\u0001\u001a\u00020LH\u0002J\u001f\u0010\u0001\u001a\u00020L2\t\u0010\u0001\u001a\u0004\u0018\u00010\u00042\t\u0010\u0001\u001a\u0004\u0018\u00010\u0004H\u0002J\t\u0010\u0001\u001a\u00020LH\u0002J\u0007\u0010\u0001\u001a\u00020LJ\u0012\u0010\u0001\u001a\u00020L2\u0007\u0010\u0001\u001a\u00020hH\u0002J\t\u0010\u0001\u001a\u00020LH\u0002J\t\u0010\u0001\u001a\u00020LH\u0002J\u0012\u0010\u0001\u001a\u00020L2\u0007\u0010\u0001\u001a\u00020\u001dH\u0002J\t\u0010\u0001\u001a\u00020LH\u0002J\u0012\u0010\u0001\u001a\u00020L2\u0007\u0010\u0001\u001a\u00020\u001dH\u0002J\t\u0010\u0001\u001a\u00020LH\u0002J\t\u0010\u0001\u001a\u00020LH\u0002J\u0012\u0010\u0001\u001a\u00020L2\u0007\u0010\u0001\u001a\u00020\u0016H\u0002J/\u0010\u0001\u001a\u00020L2\u0007\u0010\u0001\u001a\u00020\b2\u0007\u0010 \u0001\u001a\u00020\b2\u0007\u0010¡\u0001\u001a\u00020\b2\t\u0010¢\u0001\u001a\u0004\u0018\u00010<H\u0002J\u0012\u0010£\u0001\u001a\u00020L2\u0007\u0010¤\u0001\u001a\u00020\u0016H\u0002J-\u0010¥\u0001\u001a\u00020L2\u0006\u0010%\u001a\u00020\b2\u0007\u0010¦\u0001\u001a\u00020\b2\b\u0010§\u0001\u001a\u00030¨\u00012\u0007\u0010©\u0001\u001a\u00020\u001dH\u0002J\u0011\u0010ª\u0001\u001a\u00020L2\u0006\u0010%\u001a\u00020\bH\u0002J\u0012\u0010«\u0001\u001a\u00020L2\u0007\u0010¬\u0001\u001a\u00020\u0004H\u0002J\"\u0010­\u0001\u001a\u00020L2\u0017\u0010®\u0001\u001a\u0012\u0012\u0004\u0012\u00020<0 j\b\u0012\u0004\u0012\u00020<`\"H\u0002J\u0012\u0010¯\u0001\u001a\u00020L2\u0007\u0010¤\u0001\u001a\u00020\u0016H\u0002J\t\u0010°\u0001\u001a\u00020LH\u0002J\u0012\u0010±\u0001\u001a\u00020L2\u0007\u0010²\u0001\u001a\u00020!H\u0002J\t\u0010³\u0001\u001a\u00020LH\u0002J\u0010\u0010´\u0001\u001a\u00020L2\u0007\u0010µ\u0001\u001a\u00020\u001dJ\t\u0010¶\u0001\u001a\u00020LH\u0002R\u0014\u0010\u0003\u001a\u00020\u0004XD¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u000e\u0010\u0007\u001a\u00020\bXD¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\bXD¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\bXD¢\u0006\u0002\n\u0000R\u0010\u0010\u000b\u001a\u00020\fX\u000e¢\u0006\u0004\n\u0002\u0010\rR\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u0011X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0014X.¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0016X.¢\u0006\u0002\n\u0000R\u0010\u0010\u0017\u001a\u0004\u0018\u00010\u0018X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0019\u001a\u00020\u001aX\u000e¢\u0006\u0004\n\u0002\u0010\u001bR\u000e\u0010\u001c\u001a\u00020\u001dX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001e\u001a\u00020\u001dX\u000e¢\u0006\u0002\n\u0000R\u001e\u0010\u001f\u001a\u0012\u0012\u0004\u0012\u00020!0 j\b\u0012\u0004\u0012\u00020!`\"X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010#\u001a\u00020$X.¢\u0006\u0002\n\u0000R\u000e\u0010%\u001a\u00020\bX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010&\u001a\u0004\u0018\u00010'X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010(\u001a\u00020)X\u000e¢\u0006\u0004\n\u0002\u0010*R\u001e\u0010+\u001a\u0012\u0012\u0004\u0012\u00020!0 j\b\u0012\u0004\u0012\u00020!`\"X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010,\u001a\u00020\u0004X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010-\u001a\u00020\bX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010.\u001a\u00020\u0004X\u000e¢\u0006\u0002\n\u0000R\u0016\u0010/\u001a\n\u0012\u0004\u0012\u000201\u0018\u000100X\u000e¢\u0006\u0002\n\u0000R\u001e\u00102\u001a\u0002038\u0006@\u0006X.¢\u0006\u000e\n\u0000\u001a\u0004\b4\u00105\"\u0004\b6\u00107R\u000e\u00108\u001a\u00020\bX\u000e¢\u0006\u0002\n\u0000RB\u00109\u001a6\u0012\u0016\u0012\u0014\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\b0:0 j\u001a\u0012\u0016\u0012\u0014\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\b0:`\"X\u000e¢\u0006\u0002\n\u0000R\"\u0010;\u001a\u0016\u0012\u0006\u0012\u0004\u0018\u00010<0 j\n\u0012\u0006\u0012\u0004\u0018\u00010<`\"X\u000e¢\u0006\u0002\n\u0000R\u001e\u0010=\u001a\u0012\u0012\u0004\u0012\u00020!0 j\b\u0012\u0004\u0012\u00020!`\"X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010>\u001a\u00020\bX\u000e¢\u0006\u0002\n\u0000R\u001e\u0010?\u001a\u0012\u0012\u0004\u0012\u00020!0 j\b\u0012\u0004\u0012\u00020!`\"X\u000e¢\u0006\u0002\n\u0000R\u001e\u0010@\u001a\u0012\u0012\u0004\u0012\u00020A0 j\b\u0012\u0004\u0012\u00020A`\"X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010B\u001a\u00020\bX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010C\u001a\u00020DX.¢\u0006\u0002\n\u0000R\u001e\u0010E\u001a\u00020F8\u0006@\u0006X.¢\u0006\u000e\n\u0000\u001a\u0004\bG\u0010H\"\u0004\bI\u0010J¨\u0006·\u0001"}, mo66933d2 = {"Lcom/iaai/android/bdt/feature/fastSearchFilter/newFindVehicle/FastSearchFilterFragment;", "Lcom/iaai/android/bdt/base/BaseFragment;", "()V", "CONTENT_TYPE", "", "getCONTENT_TYPE", "()Ljava/lang/String;", "REQUEST_CODE_MORE_REFINER", "", "REQUEST_CODE_SEARCH_BY_DISTANCE", "REQUEST_CODE_SEARCH_BY_RANGE", "clickListener", "com/iaai/android/bdt/feature/fastSearchFilter/newFindVehicle/FastSearchFilterFragment$clickListener$1", "Lcom/iaai/android/bdt/feature/fastSearchFilter/newFindVehicle/FastSearchFilterFragment$clickListener$1;", "dialog", "Landroid/app/Dialog;", "expandableListAdapterSF", "Lcom/iaai/android/bdt/feature/fastSearchFilter/newFindVehicle/FastSearchExpandableAdapter;", "expandableListAdapterVF", "fastSearchFilterActivity", "Lcom/iaai/android/bdt/feature/fastSearchFilter/newFindVehicle/FastSearchFilterActivity;", "fastSearchResponse", "Lcom/iaai/android/bdt/model/fastSearchFilter2/FastSearchResponse2;", "headerAdapter", "Lcom/iaai/android/bdt/feature/fastSearchFilter/newFindVehicle/RefinerHeaderAdapter;", "headerClickListener", "com/iaai/android/bdt/feature/fastSearchFilter/newFindVehicle/FastSearchFilterFragment$headerClickListener$1", "Lcom/iaai/android/bdt/feature/fastSearchFilter/newFindVehicle/FastSearchFilterFragment$headerClickListener$1;", "isFirstTime", "", "isSavedSearchPressed", "lastSelectedMakeModel", "Ljava/util/ArrayList;", "Lcom/iaai/android/bdt/model/filter/MakeModelValues;", "Lkotlin/collections/ArrayList;", "mBinding", "Landroidx/databinding/ViewDataBinding;", "parentPosition", "popularCategoriesAdapter", "Lcom/iaai/android/bdt/feature/fastSearchFilter/newFindVehicle/PopularCategoriesAdapter;", "popularCategoriesItemClickListener", "com/iaai/android/bdt/feature/fastSearchFilter/newFindVehicle/FastSearchFilterFragment$popularCategoriesItemClickListener$1", "Lcom/iaai/android/bdt/feature/fastSearchFilter/newFindVehicle/FastSearchFilterFragment$popularCategoriesItemClickListener$1;", "recentlyUsedModels", "saveText", "savedSearchCount", "scanValue", "searchList", "", "Lcom/iaai/android/bdt/model/savedSearchList/SavedSearchListResponse;", "sessionManager", "Lcom/iaai/android/bdt/feature/login/SessionManager;", "getSessionManager", "()Lcom/iaai/android/bdt/feature/login/SessionManager;", "setSessionManager", "(Lcom/iaai/android/bdt/feature/login/SessionManager;)V", "tabPos", "tempIndicesList", "Lkotlin/Triple;", "tempItemList", "Lcom/iaai/android/bdt/model/fastSearchFilter2/FacetXX;", "tempLastSelectedMakeModel", "tempParentPosition", "tempRecentlyUsedModels", "tempSearchMappingArray", "Lcom/iaai/android/bdt/model/fastSearchFilter2/SearchMappingArray;", "tempTabPos", "viewModel", "Lcom/iaai/android/bdt/feature/fastSearchFilter/newFindVehicle/FastSearchFilterViewModel;", "viewModelFactory", "Landroidx/lifecycle/ViewModelProvider$Factory;", "getViewModelFactory", "()Landroidx/lifecycle/ViewModelProvider$Factory;", "setViewModelFactory", "(Landroidx/lifecycle/ViewModelProvider$Factory;)V", "addRecentlyViewModel", "", "makeModelValuesArray", "checkCameraPermission", "checkNetworkConnection", "clearAllFilters", "collapseAllFilter", "groupPosition", "createTempCopy", "disableSavedSearch", "enableBuyNowPrice", "tabPostion", "enableSavedSearch", "fetchSavedSearchListCount", "getFastSearchFilterV2", "getFilterValueBasedSelectedRefiner", "isServiceCallRequire", "getSeriesDataBasedOnMakeModel", "handleMakeModelMultiSelectRequestCode", "data", "Landroid/content/Intent;", "init", "initializeHeader", "insertSaveSearch", "uri", "isCameraAvailable", "loadRecentlyUsedModels", "loadRefinerResult", "mapMasterMakeToRefiner", "Lcom/iaai/android/bdt/model/filter/FilterData;", "makeFacetArray", "navigateToCameraScreen", "navigateToCustomFacetValue", "navigateToFilterResultScreen", "isBackPressed", "navigateToFullScreenFacets", "navigateToKeyWordSearchPanel", "navigateToProductDetailPage", "Lcom/iaai/android/bdt/model/fastSearchFilter2/FormattedResult;", "onActivityCreated", "savedInstanceState", "Landroid/os/Bundle;", "onActivityResult", "requestCode", "resultCode", "onAttach", "context", "Landroid/content/Context;", "onCreate", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "onRequestPermissionsResult", "permissions", "", "grantResults", "", "(I[Ljava/lang/String;[I)V", "onResume", "popularCategoriesVisibility", "populatePopularCategories", "removeAllSeriesHeaderData", "removeLastSelectedMakeModel", "modelValue", "makeValue", "resetUIForSeriesAndMakeModel", "resetUIOnBackPressed", "saveFilterDataJSON", "filterData", "saveRecentlyUsedModels", "showEmptyHeader", "showEmptyState", "isShowEmptyState", "showGuestSaveSearchAlertDialog", "showLoadingIndicator", "loading", "showSaveSearchDialog", "subscribeToViewModel", "updateFacetUIBasedOnResponse", "fastsearchResponse", "updateFilterMapping", "tabPosition", "groupPos", "childPos", "facetXX", "updateFilterValueForAllFacets", "response2", "updateHeader", "childPosition", "mode", "Lcom/iaai/android/bdt/feature/fastSearchFilter/newFindVehicle/HeaderUpdate;", "isSelected", "updateIsEnabledMapping", "updateKeywordSearchFacet", "keyword", "updateLastSelectedMakeModelArray", "makeModelFaceXXArray", "updateMappingForSeries", "updateSearchMappingArray", "updateSelectedRefiner", "makeModelValue", "updateSelectedRefinerUIBasedOnGlobalArray", "updateUIForFilterPage", "isFilterPage", "vinScanClickListener", "app_productionRelease"}, mo66934k = 1, mo66935mv = {1, 1, 13})
/* compiled from: FastSearchFilterFragment.kt */
public final class FastSearchFilterFragment extends BaseFragment {
    @NotNull
    private final String CONTENT_TYPE = "application/json";
    private final int REQUEST_CODE_MORE_REFINER = 10;
    private final int REQUEST_CODE_SEARCH_BY_DISTANCE = 11;
    private final int REQUEST_CODE_SEARCH_BY_RANGE = 12;
    private HashMap _$_findViewCache;
    /* access modifiers changed from: private */
    public FastSearchFilterFragment$clickListener$1 clickListener = new FastSearchFilterFragment$clickListener$1(this);
    /* access modifiers changed from: private */
    public Dialog dialog;
    /* access modifiers changed from: private */
    public FastSearchExpandableAdapter expandableListAdapterSF;
    /* access modifiers changed from: private */
    public FastSearchExpandableAdapter expandableListAdapterVF;
    /* access modifiers changed from: private */
    public FastSearchFilterActivity fastSearchFilterActivity;
    private FastSearchResponse2 fastSearchResponse;
    /* access modifiers changed from: private */
    public RefinerHeaderAdapter headerAdapter;
    private FastSearchFilterFragment$headerClickListener$1 headerClickListener = new FastSearchFilterFragment$headerClickListener$1(this);
    private boolean isFirstTime;
    /* access modifiers changed from: private */
    public boolean isSavedSearchPressed;
    /* access modifiers changed from: private */
    public ArrayList<MakeModelValues> lastSelectedMakeModel = new ArrayList<>();
    private ViewDataBinding mBinding;
    /* access modifiers changed from: private */
    public int parentPosition;
    /* access modifiers changed from: private */
    public PopularCategoriesAdapter popularCategoriesAdapter;
    private FastSearchFilterFragment$popularCategoriesItemClickListener$1 popularCategoriesItemClickListener = new FastSearchFilterFragment$popularCategoriesItemClickListener$1(this);
    private ArrayList<MakeModelValues> recentlyUsedModels = new ArrayList<>();
    /* access modifiers changed from: private */
    public String saveText = "";
    private int savedSearchCount;
    /* access modifiers changed from: private */
    public String scanValue = "";
    /* access modifiers changed from: private */
    public List<SavedSearchListResponse> searchList;
    @Inject
    @NotNull
    public SessionManager sessionManager;
    /* access modifiers changed from: private */
    public int tabPos;
    private ArrayList<Triple<Integer, Integer, Integer>> tempIndicesList = new ArrayList<>();
    private ArrayList<FacetXX> tempItemList = new ArrayList<>();
    private ArrayList<MakeModelValues> tempLastSelectedMakeModel = new ArrayList<>();
    private int tempParentPosition;
    private ArrayList<MakeModelValues> tempRecentlyUsedModels = new ArrayList<>();
    private ArrayList<SearchMappingArray> tempSearchMappingArray = new ArrayList<>();
    private int tempTabPos;
    private FastSearchFilterViewModel viewModel;
    @Inject
    @NotNull
    public ViewModelProvider.Factory viewModelFactory;

    public void _$_clearFindViewByIdCache() {
        HashMap hashMap = this._$_findViewCache;
        if (hashMap != null) {
            hashMap.clear();
        }
    }

    public View _$_findCachedViewById(int i) {
        if (this._$_findViewCache == null) {
            this._$_findViewCache = new HashMap();
        }
        View view = (View) this._$_findViewCache.get(Integer.valueOf(i));
        if (view != null) {
            return view;
        }
        View view2 = getView();
        if (view2 == null) {
            return null;
        }
        View findViewById = view2.findViewById(i);
        this._$_findViewCache.put(Integer.valueOf(i), findViewById);
        return findViewById;
    }

    public /* synthetic */ void onDestroyView() {
        super.onDestroyView();
        _$_clearFindViewByIdCache();
    }

    public static final /* synthetic */ FastSearchFilterActivity access$getFastSearchFilterActivity$p(FastSearchFilterFragment fastSearchFilterFragment) {
        FastSearchFilterActivity fastSearchFilterActivity2 = fastSearchFilterFragment.fastSearchFilterActivity;
        if (fastSearchFilterActivity2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("fastSearchFilterActivity");
        }
        return fastSearchFilterActivity2;
    }

    @NotNull
    public final ViewModelProvider.Factory getViewModelFactory() {
        ViewModelProvider.Factory factory = this.viewModelFactory;
        if (factory == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModelFactory");
        }
        return factory;
    }

    public final void setViewModelFactory(@NotNull ViewModelProvider.Factory factory) {
        Intrinsics.checkParameterIsNotNull(factory, "<set-?>");
        this.viewModelFactory = factory;
    }

    @NotNull
    public final SessionManager getSessionManager() {
        SessionManager sessionManager2 = this.sessionManager;
        if (sessionManager2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("sessionManager");
        }
        return sessionManager2;
    }

    public final void setSessionManager(@NotNull SessionManager sessionManager2) {
        Intrinsics.checkParameterIsNotNull(sessionManager2, "<set-?>");
        this.sessionManager = sessionManager2;
    }

    @NotNull
    public final String getCONTENT_TYPE() {
        return this.CONTENT_TYPE;
    }

    public void onAttach(@NotNull Context context) {
        Intrinsics.checkParameterIsNotNull(context, "context");
        AndroidSupportInjection.inject(this);
        super.onAttach(context);
        FragmentActivity activity = getActivity();
        if (activity != null) {
            this.fastSearchFilterActivity = (FastSearchFilterActivity) activity;
            if (context instanceof FastSearchFilterActivity) {
                this.fastSearchFilterActivity = (FastSearchFilterActivity) context;
                return;
            }
            return;
        }
        throw new TypeCastException("null cannot be cast to non-null type com.iaai.android.bdt.feature.fastSearchFilter.newFindVehicle.FastSearchFilterActivity");
    }

    public void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        FastSearchFilterActivity fastSearchFilterActivity2 = this.fastSearchFilterActivity;
        if (fastSearchFilterActivity2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("fastSearchFilterActivity");
        }
        FragmentActivity fragmentActivity = fastSearchFilterActivity2;
        ViewModelProvider.Factory factory = this.viewModelFactory;
        if (factory == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModelFactory");
        }
        ViewModel viewModel2 = ViewModelProviders.m18of(fragmentActivity, factory).get(FastSearchFilterViewModel.class);
        Intrinsics.checkExpressionValueIsNotNull(viewModel2, "ViewModelProviders.of(fa…terViewModel::class.java)");
        this.viewModel = (FastSearchFilterViewModel) viewModel2;
        loadRecentlyUsedModels();
        this.isFirstTime = true;
    }

    @Nullable
    public View onCreateView(@NotNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        Intrinsics.checkParameterIsNotNull(layoutInflater, "inflater");
        ViewDataBinding inflate = DataBindingUtil.inflate(layoutInflater, C2723R.C2728layout.fragment_fast_search_filter, viewGroup, false);
        Intrinsics.checkExpressionValueIsNotNull(inflate, "DataBindingUtil.inflate(…        container, false)");
        this.mBinding = inflate;
        ViewDataBinding viewDataBinding = this.mBinding;
        if (viewDataBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBinding");
        }
        return viewDataBinding.getRoot();
    }

    public void onActivityCreated(@Nullable Bundle bundle) {
        Context context;
        super.onActivityCreated(bundle);
        FastSearchFilterActivity fastSearchFilterActivity2 = this.fastSearchFilterActivity;
        if (fastSearchFilterActivity2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("fastSearchFilterActivity");
        }
        String facetJson = IAASharedPreference.getFacetJson(fastSearchFilterActivity2);
        subscribeToViewModel();
        CharSequence charSequence = facetJson;
        if (charSequence == null || charSequence.length() == 0) {
            checkNetworkConnection();
        } else {
            Boolean isFirstLaunchForFastSearch = IAASharedPreference.getIsFirstLaunchForFastSearch(getContext());
            Intrinsics.checkExpressionValueIsNotNull(isFirstLaunchForFastSearch, "isFirstLaunch");
            if (isFirstLaunchForFastSearch.booleanValue() && (context = getContext()) != null) {
                Context_ExtensionKt.launchOnBoardingScreen(context, OnBoardingEnum.FAST_SEARCH);
            }
            FastSearchResponse2 fastSearchResponse2 = (FastSearchResponse2) new Gson().fromJson(facetJson, FastSearchResponse2.class);
            Intrinsics.checkExpressionValueIsNotNull(fastSearchResponse2, "fastsearchResponse");
            updateFacetUIBasedOnResponse(fastSearchResponse2);
        }
        init();
        FastSearchFilterActivity fastSearchFilterActivity3 = this.fastSearchFilterActivity;
        if (fastSearchFilterActivity3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("fastSearchFilterActivity");
        }
        if (fastSearchFilterActivity3.isFromLandingPageSearch()) {
            IaaiApplication.isBackPressedFromRefinerResult = true;
        } else {
            IaaiApplication.isBackPressedFromRefinerResult = false;
            BDTUtils.INSTANCE.getGlobalItemList().clear();
            BDTUtils.INSTANCE.getGlobalIndicesList().clear();
        }
        FastSearchFilterActivity fastSearchFilterActivity4 = this.fastSearchFilterActivity;
        if (fastSearchFilterActivity4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("fastSearchFilterActivity");
        }
        updateUIForFilterPage(fastSearchFilterActivity4.isFilterPage());
        FastSearchFilterActivity fastSearchFilterActivity5 = this.fastSearchFilterActivity;
        if (fastSearchFilterActivity5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("fastSearchFilterActivity");
        }
        if (fastSearchFilterActivity5.isFilterPage()) {
            createTempCopy();
        }
    }

    public final void updateUIForFilterPage(boolean z) {
        if (z) {
            FastSearchFilterActivity fastSearchFilterActivity2 = this.fastSearchFilterActivity;
            if (fastSearchFilterActivity2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("fastSearchFilterActivity");
            }
            TextView textView = (TextView) fastSearchFilterActivity2._$_findCachedViewById(C2723R.C2726id.tvTitleFilter);
            Intrinsics.checkExpressionValueIsNotNull(textView, "fastSearchFilterActivity.tvTitleFilter");
            textView.setText(getString(C2723R.string.title_filters));
            ConstraintLayout constraintLayout = (ConstraintLayout) _$_findCachedViewById(C2723R.C2726id.clSearchContainer);
            Intrinsics.checkExpressionValueIsNotNull(constraintLayout, "clSearchContainer");
            constraintLayout.setVisibility(8);
            LinearLayout linearLayout = (LinearLayout) _$_findCachedViewById(C2723R.C2726id.llMicClr);
            Intrinsics.checkExpressionValueIsNotNull(linearLayout, "llMicClr");
            linearLayout.setVisibility(8);
            FastSearchFilterActivity fastSearchFilterActivity3 = this.fastSearchFilterActivity;
            if (fastSearchFilterActivity3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("fastSearchFilterActivity");
            }
            fastSearchFilterActivity3.getTvClearFastSearch().setVisibility(8);
            return;
        }
        ConstraintLayout constraintLayout2 = (ConstraintLayout) _$_findCachedViewById(C2723R.C2726id.clSearchContainer);
        Intrinsics.checkExpressionValueIsNotNull(constraintLayout2, "clSearchContainer");
        constraintLayout2.setVisibility(0);
        LinearLayout linearLayout2 = (LinearLayout) _$_findCachedViewById(C2723R.C2726id.llMicClr);
        Intrinsics.checkExpressionValueIsNotNull(linearLayout2, "llMicClr");
        linearLayout2.setVisibility(0);
        FastSearchFilterActivity fastSearchFilterActivity4 = this.fastSearchFilterActivity;
        if (fastSearchFilterActivity4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("fastSearchFilterActivity");
        }
        TextView textView2 = (TextView) fastSearchFilterActivity4._$_findCachedViewById(C2723R.C2726id.tvTitleFilter);
        Intrinsics.checkExpressionValueIsNotNull(textView2, "fastSearchFilterActivity.tvTitleFilter");
        textView2.setText(getString(C2723R.string.lbl_search));
        RefinerHeaderAdapter refinerHeaderAdapter = this.headerAdapter;
        ArrayList<FacetXX> headerItem = refinerHeaderAdapter != null ? refinerHeaderAdapter.getHeaderItem() : null;
        if (headerItem == null || headerItem.size() != 0) {
            FastSearchFilterActivity fastSearchFilterActivity5 = this.fastSearchFilterActivity;
            if (fastSearchFilterActivity5 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("fastSearchFilterActivity");
            }
            fastSearchFilterActivity5.getTvClearFastSearch().setVisibility(0);
            return;
        }
        FastSearchFilterActivity fastSearchFilterActivity6 = this.fastSearchFilterActivity;
        if (fastSearchFilterActivity6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("fastSearchFilterActivity");
        }
        fastSearchFilterActivity6.getTvClearFastSearch().setVisibility(8);
    }

    private final void checkNetworkConnection() {
        if (InternetUtil.INSTANCE.isInternetOn()) {
            showEmptyState(false);
            getFastSearchFilterV2();
            return;
        }
        showEmptyState(true);
        displayError(BaseFragment.ErrorType.NO_INTERNET, "");
        InternetUtil internetUtil = InternetUtil.INSTANCE;
        FastSearchFilterActivity fastSearchFilterActivity2 = this.fastSearchFilterActivity;
        if (fastSearchFilterActivity2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("fastSearchFilterActivity");
        }
        internetUtil.observe(fastSearchFilterActivity2, new FastSearchFilterFragment$checkNetworkConnection$1(this));
    }

    private final void vinScanClickListener() {
        ((ImageButton) _$_findCachedViewById(C2723R.C2726id.ibScan)).setOnClickListener(new FastSearchFilterFragment$vinScanClickListener$1(this));
    }

    /* access modifiers changed from: private */
    public final void checkCameraPermission() {
        FastSearchFilterActivity fastSearchFilterActivity2 = this.fastSearchFilterActivity;
        if (fastSearchFilterActivity2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("fastSearchFilterActivity");
        }
        if (ContextCompat.checkSelfPermission(fastSearchFilterActivity2, "android.permission.CAMERA") != 0) {
            FastSearchFilterActivity fastSearchFilterActivity3 = this.fastSearchFilterActivity;
            if (fastSearchFilterActivity3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("fastSearchFilterActivity");
            }
            ActivityCompat.requestPermissions(fastSearchFilterActivity3, new String[]{"android.permission.CAMERA"}, 1);
            return;
        }
        navigateToCameraScreen();
    }

    private final void navigateToCameraScreen() {
        if (isCameraAvailable()) {
            IntentIntegrator.forSupportFragment(this).initiateScan();
            return;
        }
        FastSearchFilterActivity fastSearchFilterActivity2 = this.fastSearchFilterActivity;
        if (fastSearchFilterActivity2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("fastSearchFilterActivity");
        }
        Toast.makeText(fastSearchFilterActivity2, "Rear Facing Camera Unavailable", 0).show();
    }

    public void onRequestPermissionsResult(int i, @NotNull String[] strArr, @NotNull int[] iArr) {
        Intrinsics.checkParameterIsNotNull(strArr, "permissions");
        Intrinsics.checkParameterIsNotNull(iArr, "grantResults");
        if (i == 1) {
            if (!(!(iArr.length == 0)) || iArr[0] != 0) {
                FastSearchFilterActivity fastSearchFilterActivity2 = this.fastSearchFilterActivity;
                if (fastSearchFilterActivity2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("fastSearchFilterActivity");
                }
                AppUtils.showEnablePermissionMessage(true, fastSearchFilterActivity2, (Fragment) null, "android.permission.CAMERA", 1);
                return;
            }
            navigateToCameraScreen();
        }
    }

    private final boolean isCameraAvailable() {
        FastSearchFilterActivity fastSearchFilterActivity2 = this.fastSearchFilterActivity;
        if (fastSearchFilterActivity2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("fastSearchFilterActivity");
        }
        Application application = fastSearchFilterActivity2.getApplication();
        Intrinsics.checkExpressionValueIsNotNull(application, "fastSearchFilterActivity.application");
        PackageManager packageManager = application.getPackageManager();
        return packageManager.hasSystemFeature("android.hardware.camera") && packageManager.hasSystemFeature("android.hardware.camera.autofocus");
    }

    /* access modifiers changed from: private */
    public final void navigateToProductDetailPage(FormattedResult formattedResult) {
        Integer num = null;
        new Bundle().putString(Constants.EXTRA_ITEM_ID, String.valueOf(formattedResult != null ? formattedResult.getItemId() : null));
        StringBuilder sb = new StringBuilder();
        sb.append(formattedResult != null ? formattedResult.getYear() : null);
        sb.append(' ');
        sb.append(formattedResult != null ? formattedResult.getMake() : null);
        sb.append(' ');
        sb.append(formattedResult != null ? formattedResult.getModel() : null);
        sb.append(' ');
        String sb2 = sb.toString();
        FastSearchFilterActivity fastSearchFilterActivity2 = this.fastSearchFilterActivity;
        if (fastSearchFilterActivity2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("fastSearchFilterActivity");
        }
        Intent intent = new Intent(fastSearchFilterActivity2, ProductDetailActivity.class);
        intent.addCategory("android.intent.category.DEFAULT");
        if (formattedResult != null) {
            num = formattedResult.getItemId();
        }
        intent.putExtra(Constants.EXTRA_ITEM_ID, String.valueOf(num));
        intent.putExtra("isFromSearchVehicle", false);
        intent.putExtra(Constants.EXTRA_YEAR_MAKE_MODEL, sb2);
        startActivity(intent);
    }

    /* access modifiers changed from: private */
    public final void getFastSearchFilterV2() {
        Searche searche;
        showLoadingIndicator(true);
        Searche searche2 = new Searche("", CollectionsKt.arrayListOf(new Facet("Default", "True")), "", (ArrayList<LongDiscretes>) null, (ArrayList<LongRangesData>) null);
        if (!StringsKt.isBlank(this.scanValue)) {
            searche = new Searche("", CollectionsKt.arrayListOf(new Facet("Default", "True")), this.scanValue, (ArrayList<LongDiscretes>) null, (ArrayList<LongRangesData>) null);
        } else {
            searche = searche2;
        }
        FastSearchRequestBody fastSearchRequestBody = new FastSearchRequestBody("", 1, true, true, false, (List<String>) null, 0, 1, (LatLong) null, CollectionsKt.arrayListOf(searche), CollectionsKt.arrayListOf(new Sort(false, false, "LiveDateTime")), new ArrayList(), false, false, false, 0, "", (SavedSearch) null);
        StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
        Object[] objArr = new Object[2];
        FastSearchFilterActivity fastSearchFilterActivity2 = this.fastSearchFilterActivity;
        if (fastSearchFilterActivity2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("fastSearchFilterActivity");
        }
        objArr[0] = fastSearchFilterActivity2.getSessionManager().getCurrentSessionUsername();
        FastSearchFilterActivity fastSearchFilterActivity3 = this.fastSearchFilterActivity;
        if (fastSearchFilterActivity3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("fastSearchFilterActivity");
        }
        objArr[1] = fastSearchFilterActivity3.getSessionManager().getCurrentSessionPassword();
        String format = String.format("%s:%s", Arrays.copyOf(objArr, objArr.length));
        Intrinsics.checkExpressionValueIsNotNull(format, "java.lang.String.format(format, *args)");
        FastSearchFilterViewModel fastSearchFilterViewModel = this.viewModel;
        if (fastSearchFilterViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        }
        fastSearchFilterViewModel.getFastSearchFilterV2(fastSearchRequestBody, format);
    }

    private final void subscribeToViewModel() {
        FastSearchFilterViewModel fastSearchFilterViewModel = this.viewModel;
        if (fastSearchFilterViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        }
        MutableLiveData<FastSearchResponse2> fastSearchResult = fastSearchFilterViewModel.getFastSearchResult();
        FastSearchFilterActivity fastSearchFilterActivity2 = this.fastSearchFilterActivity;
        if (fastSearchFilterActivity2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("fastSearchFilterActivity");
        }
        fastSearchResult.observe(fastSearchFilterActivity2, new FastSearchFilterFragment$subscribeToViewModel$1(this));
        FastSearchFilterViewModel fastSearchFilterViewModel2 = this.viewModel;
        if (fastSearchFilterViewModel2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        }
        MutableLiveData<FastSearchResponse2> seriesResult = fastSearchFilterViewModel2.getSeriesResult();
        FastSearchFilterActivity fastSearchFilterActivity3 = this.fastSearchFilterActivity;
        if (fastSearchFilterActivity3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("fastSearchFilterActivity");
        }
        seriesResult.observe(fastSearchFilterActivity3, new FastSearchFilterFragment$subscribeToViewModel$2(this));
        FastSearchFilterViewModel fastSearchFilterViewModel3 = this.viewModel;
        if (fastSearchFilterViewModel3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        }
        MutableLiveData<FastSearchResponse2> facetResult = fastSearchFilterViewModel3.getFacetResult();
        FastSearchFilterActivity fastSearchFilterActivity4 = this.fastSearchFilterActivity;
        if (fastSearchFilterActivity4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("fastSearchFilterActivity");
        }
        facetResult.observe(fastSearchFilterActivity4, new FastSearchFilterFragment$subscribeToViewModel$3(this));
        FastSearchFilterViewModel fastSearchFilterViewModel4 = this.viewModel;
        if (fastSearchFilterViewModel4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        }
        MutableLiveData<String> facetError = fastSearchFilterViewModel4.getFacetError();
        FastSearchFilterActivity fastSearchFilterActivity5 = this.fastSearchFilterActivity;
        if (fastSearchFilterActivity5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("fastSearchFilterActivity");
        }
        facetError.observe(fastSearchFilterActivity5, new FastSearchFilterFragment$subscribeToViewModel$4(this));
        FastSearchFilterViewModel fastSearchFilterViewModel5 = this.viewModel;
        if (fastSearchFilterViewModel5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        }
        MutableLiveData<String> searchMappingError = fastSearchFilterViewModel5.getSearchMappingError();
        FastSearchFilterActivity fastSearchFilterActivity6 = this.fastSearchFilterActivity;
        if (fastSearchFilterActivity6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("fastSearchFilterActivity");
        }
        searchMappingError.observe(fastSearchFilterActivity6, new FastSearchFilterFragment$subscribeToViewModel$5(this));
        FastSearchFilterViewModel fastSearchFilterViewModel6 = this.viewModel;
        if (fastSearchFilterViewModel6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        }
        MutableLiveData<SaveSearchResponse> savedSearchSuccess = fastSearchFilterViewModel6.getSavedSearchSuccess();
        FastSearchFilterActivity fastSearchFilterActivity7 = this.fastSearchFilterActivity;
        if (fastSearchFilterActivity7 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("fastSearchFilterActivity");
        }
        savedSearchSuccess.observe(fastSearchFilterActivity7, new FastSearchFilterFragment$subscribeToViewModel$6(this));
        FastSearchFilterViewModel fastSearchFilterViewModel7 = this.viewModel;
        if (fastSearchFilterViewModel7 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        }
        MutableLiveData<String> savedSearchError = fastSearchFilterViewModel7.getSavedSearchError();
        FastSearchFilterActivity fastSearchFilterActivity8 = this.fastSearchFilterActivity;
        if (fastSearchFilterActivity8 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("fastSearchFilterActivity");
        }
        savedSearchError.observe(fastSearchFilterActivity8, new FastSearchFilterFragment$subscribeToViewModel$7(this));
        FastSearchFilterViewModel fastSearchFilterViewModel8 = this.viewModel;
        if (fastSearchFilterViewModel8 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        }
        MutableLiveData<ArrayList<SavedSearchListResponse>> savedSearchListResponse = fastSearchFilterViewModel8.getSavedSearchListResponse();
        FastSearchFilterActivity fastSearchFilterActivity9 = this.fastSearchFilterActivity;
        if (fastSearchFilterActivity9 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("fastSearchFilterActivity");
        }
        savedSearchListResponse.observe(fastSearchFilterActivity9, new FastSearchFilterFragment$subscribeToViewModel$8(this));
        FastSearchFilterViewModel fastSearchFilterViewModel9 = this.viewModel;
        if (fastSearchFilterViewModel9 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        }
        MutableLiveData<String> savedSearchListError = fastSearchFilterViewModel9.getSavedSearchListError();
        FastSearchFilterActivity fastSearchFilterActivity10 = this.fastSearchFilterActivity;
        if (fastSearchFilterActivity10 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("fastSearchFilterActivity");
        }
        savedSearchListError.observe(fastSearchFilterActivity10, new FastSearchFilterFragment$subscribeToViewModel$9(this));
    }

    /* access modifiers changed from: private */
    public final void disableSavedSearch() {
        TextView textView = (TextView) _$_findCachedViewById(C2723R.C2726id.tvSaveSearch);
        Intrinsics.checkExpressionValueIsNotNull(textView, "tvSaveSearch");
        textView.setClickable(false);
        TextView textView2 = (TextView) _$_findCachedViewById(C2723R.C2726id.tvSaveSearch);
        Intrinsics.checkExpressionValueIsNotNull(textView2, "tvSaveSearch");
        textView2.setAlpha(0.5f);
        TextView textView3 = (TextView) _$_findCachedViewById(C2723R.C2726id.tvSaveSearch);
        Intrinsics.checkExpressionValueIsNotNull(textView3, "tvSaveSearch");
        textView3.setEnabled(false);
    }

    private final void enableSavedSearch() {
        TextView textView = (TextView) _$_findCachedViewById(C2723R.C2726id.tvSaveSearch);
        Intrinsics.checkExpressionValueIsNotNull(textView, "tvSaveSearch");
        textView.setClickable(true);
        TextView textView2 = (TextView) _$_findCachedViewById(C2723R.C2726id.tvSaveSearch);
        Intrinsics.checkExpressionValueIsNotNull(textView2, "tvSaveSearch");
        textView2.setEnabled(true);
        TextView textView3 = (TextView) _$_findCachedViewById(C2723R.C2726id.tvSaveSearch);
        Intrinsics.checkExpressionValueIsNotNull(textView3, "tvSaveSearch");
        textView3.setAlpha(1.0f);
    }

    /* access modifiers changed from: private */
    public final void updateFacetUIBasedOnResponse(FastSearchResponse2 fastSearchResponse2) {
        showEmptyState(false);
        NestedScrollView nestedScrollView = (NestedScrollView) _$_findCachedViewById(C2723R.C2726id.nsvContainer);
        Intrinsics.checkExpressionValueIsNotNull(nestedScrollView, "nsvContainer");
        nestedScrollView.setVisibility(0);
        this.fastSearchResponse = fastSearchResponse2;
        BDTUtils bDTUtils = BDTUtils.INSTANCE;
        FastSearchFilterActivity fastSearchFilterActivity2 = this.fastSearchFilterActivity;
        if (fastSearchFilterActivity2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("fastSearchFilterActivity");
        }
        Activity activity = fastSearchFilterActivity2;
        FastSearchResponse2 fastSearchResponse22 = this.fastSearchResponse;
        if (fastSearchResponse22 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("fastSearchResponse");
        }
        bDTUtils.getFilterMapping(activity, fastSearchResponse22);
        FastSearchFilterActivity fastSearchFilterActivity3 = this.fastSearchFilterActivity;
        if (fastSearchFilterActivity3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("fastSearchFilterActivity");
        }
        this.expandableListAdapterVF = new FastSearchExpandableAdapter(fastSearchFilterActivity3);
        FastSearchExpandableAdapter fastSearchExpandableAdapter = this.expandableListAdapterVF;
        if (fastSearchExpandableAdapter != null) {
            fastSearchExpandableAdapter.setTabPosition(0);
        }
        this.tabPos = 0;
        FastSearchExpandableAdapter fastSearchExpandableAdapter2 = this.expandableListAdapterVF;
        if (fastSearchExpandableAdapter2 != null) {
            fastSearchExpandableAdapter2.setClickListener(this.clickListener);
        }
        ((ExpandableListView) _$_findCachedViewById(C2723R.C2726id.expandableFilter)).setAdapter(this.expandableListAdapterVF);
        populatePopularCategories();
    }

    /* access modifiers changed from: private */
    public final void showLoadingIndicator(boolean z) {
        if (z) {
            ProgressBar progressBar = (ProgressBar) _$_findCachedViewById(C2723R.C2726id.pbFilter);
            Intrinsics.checkExpressionValueIsNotNull(progressBar, "pbFilter");
            progressBar.setVisibility(0);
            return;
        }
        ProgressBar progressBar2 = (ProgressBar) _$_findCachedViewById(C2723R.C2726id.pbFilter);
        Intrinsics.checkExpressionValueIsNotNull(progressBar2, "pbFilter");
        progressBar2.setVisibility(8);
    }

    public final void createTempCopy() {
        FastSearchFilterActivity fastSearchFilterActivity2 = this.fastSearchFilterActivity;
        if (fastSearchFilterActivity2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("fastSearchFilterActivity");
        }
        if (fastSearchFilterActivity2.isFilterPage()) {
            this.tempSearchMappingArray.clear();
            Iterator it = BDTUtils.INSTANCE.getSearchMappingArray().iterator();
            while (it.hasNext()) {
                SearchMappingArray searchMappingArray = (SearchMappingArray) it.next();
                ArrayList arrayList = new ArrayList();
                for (SearchMappingGroup searchMappingGroup : searchMappingArray.getGroups()) {
                    ArrayList arrayList2 = new ArrayList();
                    for (FacetXX facetXX : searchMappingGroup.getListFacet()) {
                        arrayList2.add(new FacetXX(facetXX.getCount(), facetXX.getValue(), facetXX.getRefinerValue(), facetXX.isSelected()));
                    }
                    Iterator it2 = it;
                    SearchMappingGroup searchMappingGroup2 = r6;
                    SearchMappingGroup searchMappingGroup3 = new SearchMappingGroup(searchMappingGroup.getDisplayname(), searchMappingGroup.getGroup(), searchMappingGroup.getMultiselect(), searchMappingGroup.getFiltertype(), searchMappingGroup.getMinvalue(), searchMappingGroup.getMaxvalue(), searchMappingGroup.getSortorder(), arrayList2, searchMappingGroup.isEnabled(), searchMappingGroup.getCustom());
                    arrayList.add(searchMappingGroup2);
                    it = it2;
                }
                Iterator it3 = it;
                this.tempSearchMappingArray.add(new SearchMappingArray(searchMappingArray.getFilterName(), arrayList));
                it = it3;
            }
            this.tempItemList = BDTUtils.INSTANCE.getGlobalItemList();
            this.tempIndicesList = BDTUtils.INSTANCE.getGlobalIndicesList();
            this.tempLastSelectedMakeModel = this.lastSelectedMakeModel;
            this.tempRecentlyUsedModels = this.recentlyUsedModels;
        }
    }

    public final void resetUIOnBackPressed() {
        BDTUtils.INSTANCE.getSearchMappingArray().clear();
        BDTUtils.INSTANCE.getSearchMappingArray().addAll(this.tempSearchMappingArray);
        RefinerHeaderAdapter refinerHeaderAdapter = this.headerAdapter;
        if (refinerHeaderAdapter != null) {
            refinerHeaderAdapter.removeAllHeaderData(this.tempItemList, this.tempIndicesList);
        }
        this.recentlyUsedModels = this.tempRecentlyUsedModels;
        this.lastSelectedMakeModel = this.tempLastSelectedMakeModel;
        int i = this.tabPos;
        if (i == 0) {
            FastSearchExpandableAdapter fastSearchExpandableAdapter = this.expandableListAdapterVF;
            if (fastSearchExpandableAdapter != null) {
                fastSearchExpandableAdapter.setTabPosition(0);
            }
            FastSearchExpandableAdapter fastSearchExpandableAdapter2 = this.expandableListAdapterVF;
            if (fastSearchExpandableAdapter2 != null) {
                fastSearchExpandableAdapter2.notifyDataSetChanged();
            }
        } else if (i == 1) {
            FastSearchExpandableAdapter fastSearchExpandableAdapter3 = this.expandableListAdapterVF;
            if (fastSearchExpandableAdapter3 != null) {
                fastSearchExpandableAdapter3.setTabPosition(1);
            }
            FastSearchExpandableAdapter fastSearchExpandableAdapter4 = this.expandableListAdapterSF;
            if (fastSearchExpandableAdapter4 != null) {
                fastSearchExpandableAdapter4.notifyDataSetChanged();
            }
        }
        PopularCategoriesAdapter popularCategoriesAdapter2 = this.popularCategoriesAdapter;
        if (popularCategoriesAdapter2 != null) {
            popularCategoriesAdapter2.setQuickLinksData();
        }
        PopularCategoriesAdapter popularCategoriesAdapter3 = this.popularCategoriesAdapter;
        if (popularCategoriesAdapter3 != null) {
            popularCategoriesAdapter3.notifyDataSetChanged();
        }
    }

    public final void navigateToFilterResultScreen(boolean z) {
        ArrayList<Triple> second;
        Intent intent = new Intent(getContext(), RefinerResultActivity.class);
        if (z) {
            ArrayList arrayList = new ArrayList();
            for (Triple triple : this.tempIndicesList) {
                arrayList.add(new SelectedRefinerIndicesModel(((Number) triple.getFirst()).intValue(), ((Number) triple.getSecond()).intValue(), ((Number) triple.getThird()).intValue()));
            }
            intent.putParcelableArrayListExtra(Constants_MVVM.EXTRA_SELECTED_FACETS, this.tempItemList);
            intent.putParcelableArrayListExtra(Constants_MVVM.EXTRA_SELECTED_INDICES, arrayList);
            resetUIOnBackPressed();
        } else {
            RefinerHeaderAdapter refinerHeaderAdapter = this.headerAdapter;
            ArrayList arrayList2 = null;
            Pair<ArrayList<FacetXX>, ArrayList<Triple<Integer, Integer, Integer>>> headerItemData = refinerHeaderAdapter != null ? refinerHeaderAdapter.getHeaderItemData() : null;
            ArrayList arrayList3 = new ArrayList();
            if (!(headerItemData == null || (second = headerItemData.getSecond()) == null)) {
                for (Triple triple2 : second) {
                    arrayList3.add(new SelectedRefinerIndicesModel(((Number) triple2.getFirst()).intValue(), ((Number) triple2.getSecond()).intValue(), ((Number) triple2.getThird()).intValue()));
                }
            }
            if (headerItemData != null) {
                arrayList2 = headerItemData.getFirst();
            }
            intent.putParcelableArrayListExtra(Constants_MVVM.EXTRA_SELECTED_FACETS, arrayList2);
            intent.putParcelableArrayListExtra(Constants_MVVM.EXTRA_SELECTED_INDICES, arrayList3);
            addRecentlyViewModel(this.lastSelectedMakeModel);
        }
        startActivity(intent);
        FastSearchFilterActivity fastSearchFilterActivity2 = this.fastSearchFilterActivity;
        if (fastSearchFilterActivity2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("fastSearchFilterActivity");
        }
        fastSearchFilterActivity2.setFilterPage(false);
    }

    private final void init() {
        FastSearchFilterActivity fastSearchFilterActivity2 = this.fastSearchFilterActivity;
        if (fastSearchFilterActivity2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("fastSearchFilterActivity");
        }
        fastSearchFilterActivity2.getTvClearFastSearch().setVisibility(8);
        TextView textView = (TextView) _$_findCachedViewById(C2723R.C2726id.tvSeeResult);
        Intrinsics.checkExpressionValueIsNotNull(textView, "tvSeeResult");
        textView.setSelected(true);
        TextView textView2 = (TextView) _$_findCachedViewById(C2723R.C2726id.tvSeeResult);
        Intrinsics.checkExpressionValueIsNotNull(textView2, "tvSeeResult");
        textView2.setEnabled(true);
        TextView textView3 = (TextView) _$_findCachedViewById(C2723R.C2726id.tvSeeResult);
        Intrinsics.checkExpressionValueIsNotNull(textView3, "tvSeeResult");
        textView3.setClickable(true);
        vinScanClickListener();
        ((TextView) _$_findCachedViewById(C2723R.C2726id.tvSeeResult)).setOnClickListener(new FastSearchFilterFragment$init$1(this));
        ((TabLayout) _$_findCachedViewById(C2723R.C2726id.tlFilter)).addOnTabSelectedListener((TabLayout.OnTabSelectedListener) new FastSearchFilterFragment$init$2(this));
        ((ExpandableListView) _$_findCachedViewById(C2723R.C2726id.expandableFilter)).setOnGroupClickListener(new FastSearchFilterFragment$init$3(this));
        FastSearchFilterActivity fastSearchFilterActivity3 = this.fastSearchFilterActivity;
        if (fastSearchFilterActivity3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("fastSearchFilterActivity");
        }
        fastSearchFilterActivity3.getTvClearFastSearch().setOnClickListener(new FastSearchFilterFragment$init$4(this));
        ((TextView) _$_findCachedViewById(C2723R.C2726id.tvSaveSearch)).setOnClickListener(new FastSearchFilterFragment$init$5(this));
        initializeHeader();
    }

    /* access modifiers changed from: private */
    public final void navigateToFullScreenFacets(int i) {
        this.parentPosition = i;
        if (BDTUtils.INSTANCE.getSearchMappingArray().get(this.tabPos).getGroups().get(i).isEnabled()) {
            ArrayList<FacetXX> listFacet = BDTUtils.INSTANCE.getSearchMappingArray().get(this.tabPos).getGroups().get(i).getListFacet();
            BDTUtils.INSTANCE.getSearchMappingArray().get(this.tabPos).getGroups().get(i).getGroup();
            BDTUtils.INSTANCE.getSearchMappingArray().get(this.tabPos).getGroups().get(i).getFiltertype();
            if (listFacet.size() > 10) {
                String displayname = BDTUtils.INSTANCE.getSearchMappingArray().get(this.tabPos).getGroups().get(i).getDisplayname();
                String filtertype = BDTUtils.INSTANCE.getSearchMappingArray().get(this.tabPos).getGroups().get(i).getFiltertype();
                if (listFacet.size() > 10) {
                    this.parentPosition = i;
                    FastSearchFilterActivity fastSearchFilterActivity2 = this.fastSearchFilterActivity;
                    if (fastSearchFilterActivity2 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("fastSearchFilterActivity");
                    }
                    Intent intent = new Intent(fastSearchFilterActivity2, FastSearchMoreFilterActivity.class);
                    intent.putParcelableArrayListExtra(Constants_MVVM.EXTRA_FACETS_ARRAY, listFacet);
                    intent.putExtra(Constants_MVVM.EXTRA_FACETS_PARENT_POSITION, i);
                    intent.putExtra(Constants_MVVM.EXTRA_FACETS_TAB_POSITION, this.tabPos);
                    intent.putExtra(Constants_MVVM.EXTRA_FACETS_TITLE, displayname);
                    intent.putExtra(Constants_MVVM.EXTRA_FACETS_TYPE, filtertype);
                    startActivityForResult(intent, this.REQUEST_CODE_MORE_REFINER);
                    return;
                }
                return;
            }
            ((ExpandableListView) _$_findCachedViewById(C2723R.C2726id.expandableFilter)).expandGroup(this.parentPosition);
        }
    }

    /* access modifiers changed from: private */
    public final boolean navigateToCustomFacetValue(int i) {
        String str;
        int i2 = i;
        this.parentPosition = i2;
        if (BDTUtils.INSTANCE.getSearchMappingArray().get(this.tabPos).getGroups().get(i2).isEnabled()) {
            ArrayList<FacetXX> listFacet = BDTUtils.INSTANCE.getSearchMappingArray().get(this.tabPos).getGroups().get(i2).getListFacet();
            String group = BDTUtils.INSTANCE.getSearchMappingArray().get(this.tabPos).getGroups().get(i2).getGroup();
            BDTUtils.INSTANCE.getSearchMappingArray().get(this.tabPos).getGroups().get(i2).getFiltertype();
            if (Intrinsics.areEqual((Object) group, (Object) ExifInterface.TAG_MAKE)) {
                this.parentPosition = i2;
                FastSearchFilterActivity fastSearchFilterActivity2 = this.fastSearchFilterActivity;
                if (fastSearchFilterActivity2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("fastSearchFilterActivity");
                }
                Intent intent = new Intent(fastSearchFilterActivity2, MakeModelFilterActivity.class);
                FilterData mapMasterMakeToRefiner = mapMasterMakeToRefiner(listFacet);
                Log.d("MAKE MODEL DATA", String.valueOf(mapMasterMakeToRefiner));
                saveFilterDataJSON(mapMasterMakeToRefiner);
                intent.putParcelableArrayListExtra(Constants_MVVM.EXTRA_RECENTALY_USED_MAKE_MODEL_FILTER_DATA, this.recentlyUsedModels);
                intent.putExtra(Constants_MVVM.EXTRA_DISPLAY_FILTER_TITLE, "Make & Model");
                intent.putParcelableArrayListExtra(Constants_MVVM.EXTRA_LAST_SELECTED_MAKE_MODEL, this.lastSelectedMakeModel);
                startActivityForResult(intent, 102);
                return true;
            } else if (StringsKt.equals(group, "Zip_Miles", true)) {
                String displayname = BDTUtils.INSTANCE.getSearchMappingArray().get(this.tabPos).getGroups().get(i2).getDisplayname();
                this.parentPosition = i2;
                loop0:
                while (true) {
                    str = "";
                    for (FacetXX facetXX : listFacet) {
                        if (facetXX.isSelected()) {
                            String refinerValue = facetXX.getRefinerValue();
                            List split$default = refinerValue != null ? StringsKt.split$default((CharSequence) refinerValue, new String[]{"~"}, false, 0, 6, (Object) null) : null;
                            if (split$default == null || (str = (String) split$default.get(1)) == null) {
                            }
                        }
                    }
                    break loop0;
                }
                FastSearchFilterActivity fastSearchFilterActivity3 = this.fastSearchFilterActivity;
                if (fastSearchFilterActivity3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("fastSearchFilterActivity");
                }
                Intent intent2 = new Intent(fastSearchFilterActivity3, SearchByDistanceActivity.class);
                intent2.putExtra(Constants_MVVM.EXTRA_FACETS_PARENT_POSITION, i2);
                intent2.putExtra(Constants_MVVM.EXTRA_FACETS_TAB_POSITION, this.tabPos);
                intent2.putExtra(Constants_MVVM.EXTRA_FACETS_TITLE, displayname);
                intent2.putExtra(Constants_MVVM.EXTRA_POSTAL_CODE, str);
                startActivityForResult(intent2, this.REQUEST_CODE_SEARCH_BY_DISTANCE);
                return true;
            } else if (StringsKt.equals(group, "Odometer", true)) {
                String displayname2 = BDTUtils.INSTANCE.getSearchMappingArray().get(this.tabPos).getGroups().get(i2).getDisplayname();
                FacetXX facetXX2 = listFacet.get(0);
                Intrinsics.checkExpressionValueIsNotNull(facetXX2, "facetxxArrayList[0]");
                FacetXX facetXX3 = facetXX2;
                this.parentPosition = i2;
                FastSearchFilterActivity fastSearchFilterActivity4 = this.fastSearchFilterActivity;
                if (fastSearchFilterActivity4 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("fastSearchFilterActivity");
                }
                Intent intent3 = new Intent(fastSearchFilterActivity4, SearchByOdometerActivity.class);
                intent3.putExtra(Constants_MVVM.EXTRA_FACETS_PARENT_POSITION, i2);
                intent3.putExtra(Constants_MVVM.EXTRA_FACETS_TAB_POSITION, this.tabPos);
                intent3.putExtra(Constants_MVVM.EXTRA_FACETS_TITLE, displayname2);
                intent3.putExtra(Constants_MVVM.EXTRA_SLIDER_VALUE, facetXX3);
                startActivityForResult(intent3, this.REQUEST_CODE_SEARCH_BY_RANGE);
                return true;
            } else if (StringsKt.equals(group, "ACV", true)) {
                String displayname3 = BDTUtils.INSTANCE.getSearchMappingArray().get(this.tabPos).getGroups().get(i2).getDisplayname();
                this.parentPosition = i2;
                FastSearchFilterActivity fastSearchFilterActivity5 = this.fastSearchFilterActivity;
                if (fastSearchFilterActivity5 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("fastSearchFilterActivity");
                }
                Intent intent4 = new Intent(fastSearchFilterActivity5, SearchByACVActivity.class);
                intent4.putExtra(Constants_MVVM.EXTRA_FACETS_PARENT_POSITION, i2);
                intent4.putExtra(Constants_MVVM.EXTRA_FACETS_TAB_POSITION, this.tabPos);
                intent4.putExtra(Constants_MVVM.EXTRA_FACETS_TITLE, displayname3);
                startActivityForResult(intent4, this.REQUEST_CODE_SEARCH_BY_RANGE);
                return true;
            }
        }
        return false;
    }

    /* access modifiers changed from: private */
    public final void clearAllFilters() {
        Log.e("TEST", "CLEAR ALL FILTERS");
        int size = BDTUtils.INSTANCE.getSearchMappingArray().size();
        for (int i = 0; i < size; i++) {
            SearchMappingArray searchMappingArray = BDTUtils.INSTANCE.getSearchMappingArray().get(i);
            Intrinsics.checkExpressionValueIsNotNull(searchMappingArray, "BDTUtils.searchMappingArray[index]");
            for (SearchMappingGroup listFacet : searchMappingArray.getGroups()) {
                for (FacetXX selected : listFacet.getListFacet()) {
                    selected.setSelected(false);
                }
            }
        }
        updateHeader(0, 0, HeaderUpdate.CLEAR_ALL_FILTERS, false);
        this.lastSelectedMakeModel.clear();
        PopularCategoriesAdapter popularCategoriesAdapter2 = this.popularCategoriesAdapter;
        if (popularCategoriesAdapter2 != null) {
            popularCategoriesAdapter2.setQuickLinksData();
        }
        PopularCategoriesAdapter popularCategoriesAdapter3 = this.popularCategoriesAdapter;
        if (popularCategoriesAdapter3 != null) {
            popularCategoriesAdapter3.notifyDataSetChanged();
        }
        resetUIForSeriesAndMakeModel();
        this.parentPosition = -1;
        getFilterValueBasedSelectedRefiner(true);
    }

    /* access modifiers changed from: private */
    public final void showSaveSearchDialog() {
        Context context = getContext();
        AlertDialog alertDialog = null;
        AlertDialog.Builder builder = context != null ? new AlertDialog.Builder(context, C2723R.C2731style.CustomAlertDialog) : null;
        View inflate = LayoutInflater.from(getContext()).inflate(C2723R.C2728layout.layout_save_search_popup, (ViewGroup) getView(), false);
        Intrinsics.checkExpressionValueIsNotNull(inflate, "LayoutInflater.from(cont…iew as ViewGroup?, false)");
        if (builder != null) {
            builder.setView(inflate);
        }
        if (builder != null) {
            alertDialog = builder.create();
        }
        this.dialog = alertDialog;
        inflate.findViewById(C2723R.C2726id.tvSave).setOnClickListener(new FastSearchFilterFragment$showSaveSearchDialog$1(this, inflate));
        inflate.findViewById(C2723R.C2726id.tvCancel).setOnClickListener(new FastSearchFilterFragment$showSaveSearchDialog$2(this));
        Dialog dialog2 = this.dialog;
        if (dialog2 != null) {
            dialog2.show();
        }
    }

    /* access modifiers changed from: private */
    public final void showGuestSaveSearchAlertDialog() {
        Context context = getContext();
        AlertDialog alertDialog = null;
        AlertDialog.Builder builder = context != null ? new AlertDialog.Builder(context, C2723R.C2731style.CustomAlertDialog) : null;
        View inflate = LayoutInflater.from(getContext()).inflate(C2723R.C2728layout.layout_save_search_alert_popup, (ViewGroup) getView(), false);
        Intrinsics.checkExpressionValueIsNotNull(inflate, "LayoutInflater.from(cont…iew as ViewGroup?, false)");
        if (builder != null) {
            builder.setView(inflate);
        }
        if (builder != null) {
            alertDialog = builder.create();
        }
        this.dialog = alertDialog;
        View findViewById = inflate.findViewById(C2723R.C2726id.tvRegister);
        if (findViewById != null) {
            ((TextView) findViewById).setPaintFlags(8);
            inflate.findViewById(C2723R.C2726id.tvRegister).setOnClickListener(new FastSearchFilterFragment$showGuestSaveSearchAlertDialog$1(this));
            inflate.findViewById(C2723R.C2726id.tvOK).setOnClickListener(new FastSearchFilterFragment$showGuestSaveSearchAlertDialog$2(this));
            Dialog dialog2 = this.dialog;
            if (dialog2 != null) {
                dialog2.show();
                return;
            }
            return;
        }
        throw new TypeCastException("null cannot be cast to non-null type android.widget.TextView");
    }

    private final void saveFilterDataJSON(FilterData filterData) {
        String json = new Gson().toJson((Object) filterData);
        Log.d("MAKE MODEL DATA", String.valueOf(json));
        FastSearchFilterActivity fastSearchFilterActivity2 = this.fastSearchFilterActivity;
        if (fastSearchFilterActivity2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("fastSearchFilterActivity");
        }
        AppPreferences appPreferences = new AppPreferences(fastSearchFilterActivity2);
        Intrinsics.checkExpressionValueIsNotNull(json, "makeModelString");
        appPreferences.save(Constants_MVVM.EXTRA_MAKE_MODEL_FILTER_DATA, json);
    }

    /* access modifiers changed from: private */
    public final void fetchSavedSearchListCount() {
        StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
        Object[] objArr = new Object[2];
        SessionManager sessionManager2 = this.sessionManager;
        if (sessionManager2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("sessionManager");
        }
        objArr[0] = sessionManager2.getCurrentSessionUsername();
        SessionManager sessionManager3 = this.sessionManager;
        if (sessionManager3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("sessionManager");
        }
        objArr[1] = sessionManager3.getCurrentSessionPassword();
        String format = String.format("%s:%s", Arrays.copyOf(objArr, objArr.length));
        Intrinsics.checkExpressionValueIsNotNull(format, "java.lang.String.format(format, *args)");
        FastSearchFilterViewModel fastSearchFilterViewModel = this.viewModel;
        if (fastSearchFilterViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        }
        FastSearchFilterActivity fastSearchFilterActivity2 = this.fastSearchFilterActivity;
        if (fastSearchFilterActivity2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("fastSearchFilterActivity");
        }
        String deviceId = AppUtils.getDeviceId(fastSearchFilterActivity2);
        if (deviceId == null) {
            deviceId = "";
        }
        fastSearchFilterViewModel.getSavedSearchList(format, deviceId, "android", Constants_MVVM.SEARCH_API_KEY, this.CONTENT_TYPE, String.valueOf(1));
    }

    /* access modifiers changed from: private */
    public final void loadRefinerResult() {
        int i;
        String str;
        Integer first;
        showLoadingIndicator(true);
        RefinerHeaderAdapter refinerHeaderAdapter = this.headerAdapter;
        Integer num = null;
        ArrayList<FacetXX> headerItem = refinerHeaderAdapter != null ? refinerHeaderAdapter.getHeaderItem() : null;
        Sort sort = new Sort(false, false, "LiveDateTime");
        LatLong latLong = new LatLong(FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE, FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE);
        ArrayList arrayList = new ArrayList();
        Pair<Integer, Integer> pair = null;
        if (headerItem != null) {
            loop0:
            while (true) {
                i = 0;
                for (FacetXX facetXX : headerItem) {
                    if (facetXX == null || (str = facetXX.getRefinerValue()) == null) {
                        str = "";
                    }
                    CharSequence charSequence = str;
                    if (!StringsKt.isBlank(charSequence)) {
                        if (StringsKt.startsWith(str, "Distance", true)) {
                            pair = BDTUtils.INSTANCE.getDistance(facetXX);
                            if (pair != null && (first = pair.getFirst()) != null) {
                                i = first.intValue();
                            }
                        } else if (StringsKt.startsWith(str, "Make & Model", true)) {
                            ArrayList arrayList2 = new ArrayList();
                            String str2 = (String) StringsKt.split$default(charSequence, new String[]{"~"}, false, 0, 6, (Object) null).get(1);
                            if (str2 != null) {
                                String obj = StringsKt.trim((CharSequence) str2).toString();
                                String str3 = "null cannot be cast to non-null type kotlin.CharSequence";
                                String str4 = (String) StringsKt.split$default(charSequence, new String[]{"~"}, false, 0, 6, (Object) null).get(2);
                                if (str4 != null) {
                                    String obj2 = StringsKt.trim((CharSequence) str4).toString();
                                    arrayList2.add(new Facet(ExifInterface.TAG_MAKE, obj));
                                    arrayList.add(new Searche("", arrayList2, "", (ArrayList<LongDiscretes>) null, (ArrayList<LongRangesData>) null));
                                    if (!StringsKt.startsWith$default(obj2, "All", false, 2, (Object) null)) {
                                        ArrayList arrayList3 = new ArrayList();
                                        arrayList3.add(new Facet(ExifInterface.TAG_MODEL, obj2));
                                        arrayList.add(new Searche("", arrayList3, "", (ArrayList<LongDiscretes>) null, (ArrayList<LongRangesData>) null));
                                    }
                                } else {
                                    throw new TypeCastException(str3);
                                }
                            } else {
                                throw new TypeCastException("null cannot be cast to non-null type kotlin.CharSequence");
                            }
                        } else {
                            arrayList.add(BDTUtils.INSTANCE.getSearchesObj(facetXX));
                        }
                    }
                }
                break loop0;
            }
        } else {
            i = 0;
        }
        if (pair != null) {
            num = pair.getSecond();
        }
        FastSearchRequestBody fastSearchRequestBody = new FastSearchRequestBody("", 1, true, true, false, (List<String>) null, num, 100, latLong, arrayList, CollectionsKt.arrayListOf(sort), new ArrayList(), false, false, false, 0, String.valueOf(i), (SavedSearch) null);
        this.isSavedSearchPressed = true;
        StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
        Object[] objArr = new Object[2];
        FastSearchFilterActivity fastSearchFilterActivity2 = this.fastSearchFilterActivity;
        if (fastSearchFilterActivity2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("fastSearchFilterActivity");
        }
        objArr[0] = fastSearchFilterActivity2.getSessionManager().getCurrentSessionUsername();
        FastSearchFilterActivity fastSearchFilterActivity3 = this.fastSearchFilterActivity;
        if (fastSearchFilterActivity3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("fastSearchFilterActivity");
        }
        objArr[1] = fastSearchFilterActivity3.getSessionManager().getCurrentSessionPassword();
        String format = String.format("%s:%s", Arrays.copyOf(objArr, objArr.length));
        Intrinsics.checkExpressionValueIsNotNull(format, "java.lang.String.format(format, *args)");
        FastSearchFilterViewModel fastSearchFilterViewModel = this.viewModel;
        if (fastSearchFilterViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        }
        fastSearchFilterViewModel.getFastSearchFilterV2(fastSearchRequestBody, format);
    }

    /* access modifiers changed from: private */
    public final void insertSaveSearch(String str, String str2) {
        int i;
        String str3;
        Integer first;
        ArrayList arrayList = new ArrayList();
        RefinerHeaderAdapter refinerHeaderAdapter = this.headerAdapter;
        Integer num = null;
        ArrayList<FacetXX> headerItem = refinerHeaderAdapter != null ? refinerHeaderAdapter.getHeaderItem() : null;
        Pair<Integer, Integer> pair = null;
        if (headerItem != null) {
            loop0:
            while (true) {
                i = 0;
                for (FacetXX facetXX : headerItem) {
                    if (facetXX == null || (str3 = facetXX.getRefinerValue()) == null) {
                        str3 = "";
                    }
                    if (facetXX != null) {
                        String value = facetXX.getValue();
                    }
                    CharSequence charSequence = str3;
                    if (!StringsKt.isBlank(charSequence)) {
                        if (StringsKt.startsWith(str3, "Distance", true)) {
                            pair = BDTUtils.INSTANCE.getDistance(facetXX);
                            if (pair != null && (first = pair.getFirst()) != null) {
                                i = first.intValue();
                            }
                        } else if (StringsKt.startsWith(str3, "Make & Model", true)) {
                            ArrayList arrayList2 = new ArrayList();
                            String str4 = (String) StringsKt.split$default(charSequence, new String[]{"~"}, false, 0, 6, (Object) null).get(1);
                            if (str4 != null) {
                                String obj = StringsKt.trim((CharSequence) str4).toString();
                                CharSequence charSequence2 = charSequence;
                                String str5 = obj;
                                String str6 = "null cannot be cast to non-null type kotlin.CharSequence";
                                String str7 = (String) StringsKt.split$default(charSequence2, new String[]{"~"}, false, 0, 6, (Object) null).get(2);
                                if (str7 != null) {
                                    String obj2 = StringsKt.trim((CharSequence) str7).toString();
                                    arrayList2.add(new Facet(ExifInterface.TAG_MAKE, str5));
                                    arrayList.add(new Searche("", arrayList2, "", (ArrayList<LongDiscretes>) null, (ArrayList<LongRangesData>) null));
                                    if (!StringsKt.startsWith$default(obj2, "All", false, 2, (Object) null)) {
                                        ArrayList arrayList3 = new ArrayList();
                                        arrayList3.add(new Facet(ExifInterface.TAG_MODEL, obj2));
                                        arrayList.add(new Searche("", arrayList3, "", (ArrayList<LongDiscretes>) null, (ArrayList<LongRangesData>) null));
                                    }
                                } else {
                                    throw new TypeCastException(str6);
                                }
                            } else {
                                throw new TypeCastException("null cannot be cast to non-null type kotlin.CharSequence");
                            }
                        } else {
                            arrayList.add(BDTUtils.INSTANCE.getSearchesObj(facetXX));
                        }
                    }
                }
                break loop0;
            }
        } else {
            i = 0;
        }
        ArrayList arrayList4 = new ArrayList();
        arrayList4.add(new Sort(false, false, "LiveDateTime"));
        ArrayList arrayList5 = new ArrayList();
        arrayList5.add("");
        LatLong latLong = new LatLong(FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE, FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE);
        if (pair != null) {
            num = pair.getSecond();
        }
        FastSearchRequestBody fastSearchRequestBody = r11;
        FastSearchRequestBody fastSearchRequestBody2 = new FastSearchRequestBody("", 1, true, true, false, (List<String>) null, num, 100, latLong, arrayList, arrayList4, arrayList5, false, false, false, 0, String.valueOf(i), (SavedSearch) null);
        SaveSearchRequest saveSearchRequest = new SaveSearchRequest(fastSearchRequestBody, str, "url=" + str2, "");
        StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
        Object[] objArr = new Object[2];
        SessionManager sessionManager2 = this.sessionManager;
        if (sessionManager2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("sessionManager");
        }
        objArr[0] = sessionManager2.getCurrentSessionUsername();
        SessionManager sessionManager3 = this.sessionManager;
        if (sessionManager3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("sessionManager");
        }
        objArr[1] = sessionManager3.getCurrentSessionPassword();
        String format = String.format("%s:%s", Arrays.copyOf(objArr, objArr.length));
        Intrinsics.checkExpressionValueIsNotNull(format, "java.lang.String.format(format, *args)");
        FastSearchFilterViewModel fastSearchFilterViewModel = this.viewModel;
        if (fastSearchFilterViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        }
        String str8 = this.CONTENT_TYPE;
        FastSearchFilterActivity fastSearchFilterActivity2 = this.fastSearchFilterActivity;
        if (fastSearchFilterActivity2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("fastSearchFilterActivity");
        }
        String deviceId = AppUtils.getDeviceId(fastSearchFilterActivity2);
        Intrinsics.checkExpressionValueIsNotNull(deviceId, "AppUtils.getDeviceId(fastSearchFilterActivity)");
        fastSearchFilterViewModel.saveSearch(str8, format, deviceId, saveSearchRequest);
    }

    /* access modifiers changed from: private */
    public final void showEmptyState(boolean z) {
        if (!isAdded()) {
            return;
        }
        if (z) {
            View _$_findCachedViewById = _$_findCachedViewById(C2723R.C2726id.emptyRecyclerView);
            Intrinsics.checkExpressionValueIsNotNull(_$_findCachedViewById, "emptyRecyclerView");
            _$_findCachedViewById.setVisibility(0);
            displayError(BaseFragment.ErrorType.NO_INTERNET, "");
            return;
        }
        View _$_findCachedViewById2 = _$_findCachedViewById(C2723R.C2726id.emptyRecyclerView);
        Intrinsics.checkExpressionValueIsNotNull(_$_findCachedViewById2, "emptyRecyclerView");
        _$_findCachedViewById2.setVisibility(8);
    }

    /* JADX WARNING: Removed duplicated region for block: B:85:0x019a  */
    /* JADX WARNING: Removed duplicated region for block: B:86:0x01a1  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onActivityResult(int r7, int r8, @org.jetbrains.annotations.Nullable android.content.Intent r9) {
        /*
            r6 = this;
            super.onActivityResult(r7, r8, r9)
            r0 = 0
            r1 = -1
            r2 = 1
            if (r8 != r1) goto L_0x01b5
            int r3 = r6.REQUEST_CODE_MORE_REFINER
            r4 = 0
            if (r7 != r3) goto L_0x006c
            int r7 = r6.tabPos
            if (r7 != 0) goto L_0x0019
            com.iaai.android.bdt.feature.fastSearchFilter.newFindVehicle.FastSearchExpandableAdapter r7 = r6.expandableListAdapterVF
            if (r7 == 0) goto L_0x0020
            r7.notifyDataSetChanged()
            goto L_0x0020
        L_0x0019:
            com.iaai.android.bdt.feature.fastSearchFilter.newFindVehicle.FastSearchExpandableAdapter r7 = r6.expandableListAdapterSF
            if (r7 == 0) goto L_0x0020
            r7.notifyDataSetChanged()
        L_0x0020:
            com.iaai.android.bdt.utils.BDTUtils r7 = com.iaai.android.bdt.utils.BDTUtils.INSTANCE
            java.util.LinkedHashMap r7 = r7.getExpandableListDetail()
            com.iaai.android.bdt.utils.BDTUtils r8 = com.iaai.android.bdt.utils.BDTUtils.INSTANCE
            java.util.ArrayList r8 = r8.getSearchMappingArray()
            int r9 = r6.tabPos
            java.lang.Object r8 = r8.get(r9)
            com.iaai.android.bdt.model.fastSearchFilter2.SearchMappingArray r8 = (com.iaai.android.bdt.model.fastSearchFilter2.SearchMappingArray) r8
            java.util.ArrayList r8 = r8.getGroups()
            int r9 = r6.parentPosition
            java.lang.Object r8 = r8.get(r9)
            java.lang.Object r7 = r7.get(r8)
            java.util.List r7 = (java.util.List) r7
            if (r7 == 0) goto L_0x0215
            java.lang.Iterable r7 = (java.lang.Iterable) r7
            java.util.Iterator r7 = r7.iterator()
        L_0x004c:
            boolean r8 = r7.hasNext()
            if (r8 == 0) goto L_0x0215
            java.lang.Object r8 = r7.next()
            int r9 = r4 + 1
            if (r4 >= 0) goto L_0x005d
            kotlin.collections.CollectionsKt.throwIndexOverflow()
        L_0x005d:
            com.iaai.android.bdt.model.fastSearchFilter2.FacetXX r8 = (com.iaai.android.bdt.model.fastSearchFilter2.FacetXX) r8
            int r0 = r6.parentPosition
            com.iaai.android.bdt.feature.fastSearchFilter.newFindVehicle.HeaderUpdate r1 = com.iaai.android.bdt.feature.fastSearchFilter.newFindVehicle.HeaderUpdate.MULTI_SELECT
            boolean r8 = r8.isSelected()
            r6.updateHeader(r0, r4, r1, r8)
            r4 = r9
            goto L_0x004c
        L_0x006c:
            r3 = 43
            if (r7 != r3) goto L_0x0075
            r6.fetchSavedSearchListCount()
            goto L_0x0215
        L_0x0075:
            int r3 = r6.REQUEST_CODE_SEARCH_BY_DISTANCE
            if (r7 != r3) goto L_0x00ba
            int r7 = r6.tabPos
            if (r7 != 0) goto L_0x0085
            com.iaai.android.bdt.feature.fastSearchFilter.newFindVehicle.FastSearchExpandableAdapter r7 = r6.expandableListAdapterVF
            if (r7 == 0) goto L_0x008c
            r7.notifyDataSetChanged()
            goto L_0x008c
        L_0x0085:
            com.iaai.android.bdt.feature.fastSearchFilter.newFindVehicle.FastSearchExpandableAdapter r7 = r6.expandableListAdapterSF
            if (r7 == 0) goto L_0x008c
            r7.notifyDataSetChanged()
        L_0x008c:
            if (r9 == 0) goto L_0x0095
            java.lang.String r7 = "CHECKED_ID"
            int r7 = r9.getIntExtra(r7, r4)
            goto L_0x0096
        L_0x0095:
            r7 = 0
        L_0x0096:
            java.lang.StringBuilder r8 = new java.lang.StringBuilder
            r8.<init>()
            java.lang.String r9 = "ACTIVITY RESUKT: "
            r8.append(r9)
            r8.append(r7)
            java.lang.String r8 = r8.toString()
            java.lang.String r9 = "TEST"
            android.util.Log.e(r9, r8)
            int r8 = r6.parentPosition
            com.iaai.android.bdt.feature.fastSearchFilter.newFindVehicle.HeaderUpdate r9 = com.iaai.android.bdt.feature.fastSearchFilter.newFindVehicle.HeaderUpdate.SINGLE_SELECT
            r6.updateHeader(r8, r7, r9, r4)
            r6.parentPosition = r1
            r6.getFilterValueBasedSelectedRefiner(r2)
            goto L_0x0215
        L_0x00ba:
            int r3 = r6.REQUEST_CODE_SEARCH_BY_RANGE
            if (r7 != r3) goto L_0x00df
            int r7 = r6.tabPos
            if (r7 != 0) goto L_0x00ca
            com.iaai.android.bdt.feature.fastSearchFilter.newFindVehicle.FastSearchExpandableAdapter r7 = r6.expandableListAdapterVF
            if (r7 == 0) goto L_0x00d1
            r7.notifyDataSetChanged()
            goto L_0x00d1
        L_0x00ca:
            com.iaai.android.bdt.feature.fastSearchFilter.newFindVehicle.FastSearchExpandableAdapter r7 = r6.expandableListAdapterSF
            if (r7 == 0) goto L_0x00d1
            r7.notifyDataSetChanged()
        L_0x00d1:
            int r7 = r6.parentPosition
            com.iaai.android.bdt.feature.fastSearchFilter.newFindVehicle.HeaderUpdate r8 = com.iaai.android.bdt.feature.fastSearchFilter.newFindVehicle.HeaderUpdate.SLIDER
            r6.updateHeader(r7, r4, r8, r4)
            r6.parentPosition = r1
            r6.getFilterValueBasedSelectedRefiner(r2)
            goto L_0x0215
        L_0x00df:
            int r1 = com.google.zxing.integration.android.IntentIntegrator.REQUEST_CODE
            if (r7 != r1) goto L_0x0215
            if (r9 == 0) goto L_0x0215
            com.google.zxing.integration.android.IntentResult r7 = com.google.zxing.integration.android.IntentIntegrator.parseActivityResult(r7, r8, r9)
            java.lang.String r8 = "result"
            kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r7, r8)
            java.lang.String r7 = r7.getContents()
            java.lang.String r8 = "result.contents"
            kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r7, r8)
            r6.scanValue = r7
            java.lang.String r7 = r6.scanValue
            if (r7 == 0) goto L_0x01ad
            java.lang.String r7 = r7.toUpperCase()
            java.lang.String r8 = "(this as java.lang.String).toUpperCase()"
            kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r7, r8)
            java.lang.CharSequence r7 = (java.lang.CharSequence) r7
            int r8 = r7.length()
            int r8 = r8 - r2
            r9 = r8
            r8 = 0
            r1 = 0
        L_0x0110:
            if (r8 > r9) goto L_0x0131
            if (r1 != 0) goto L_0x0116
            r3 = r8
            goto L_0x0117
        L_0x0116:
            r3 = r9
        L_0x0117:
            char r3 = r7.charAt(r3)
            r5 = 32
            if (r3 > r5) goto L_0x0121
            r3 = 1
            goto L_0x0122
        L_0x0121:
            r3 = 0
        L_0x0122:
            if (r1 != 0) goto L_0x012b
            if (r3 != 0) goto L_0x0128
            r1 = 1
            goto L_0x0110
        L_0x0128:
            int r8 = r8 + 1
            goto L_0x0110
        L_0x012b:
            if (r3 != 0) goto L_0x012e
            goto L_0x0131
        L_0x012e:
            int r9 = r9 + -1
            goto L_0x0110
        L_0x0131:
            int r9 = r9 + r2
            java.lang.CharSequence r7 = r7.subSequence(r8, r9)
            java.lang.String r7 = r7.toString()
            r6.scanValue = r7
            java.lang.String r7 = r6.scanValue
            java.lang.CharSequence r7 = (java.lang.CharSequence) r7
            java.lang.String r8 = "-"
            r9 = r8
            java.lang.CharSequence r9 = (java.lang.CharSequence) r9
            r1 = 2
            boolean r7 = kotlin.text.StringsKt.contains$default((java.lang.CharSequence) r7, (java.lang.CharSequence) r9, (boolean) r4, (int) r1, (java.lang.Object) r0)
            if (r7 == 0) goto L_0x01a9
            java.lang.String r7 = r6.scanValue
            java.lang.CharSequence r7 = (java.lang.CharSequence) r7
            kotlin.text.Regex r9 = new kotlin.text.Regex
            r9.<init>((java.lang.String) r8)
            java.util.List r7 = r9.split(r7, r4)
            boolean r8 = r7.isEmpty()
            if (r8 != 0) goto L_0x018c
            int r8 = r7.size()
            java.util.ListIterator r8 = r7.listIterator(r8)
        L_0x0167:
            boolean r9 = r8.hasPrevious()
            if (r9 == 0) goto L_0x018c
            java.lang.Object r9 = r8.previous()
            java.lang.String r9 = (java.lang.String) r9
            java.lang.CharSequence r9 = (java.lang.CharSequence) r9
            int r9 = r9.length()
            if (r9 != 0) goto L_0x017d
            r9 = 1
            goto L_0x017e
        L_0x017d:
            r9 = 0
        L_0x017e:
            if (r9 != 0) goto L_0x0167
            java.lang.Iterable r7 = (java.lang.Iterable) r7
            int r8 = r8.nextIndex()
            int r8 = r8 + r2
            java.util.List r7 = kotlin.collections.CollectionsKt.take(r7, r8)
            goto L_0x0190
        L_0x018c:
            java.util.List r7 = kotlin.collections.CollectionsKt.emptyList()
        L_0x0190:
            java.util.Collection r7 = (java.util.Collection) r7
            java.lang.String[] r8 = new java.lang.String[r4]
            java.lang.Object[] r7 = r7.toArray(r8)
            if (r7 == 0) goto L_0x01a1
            java.lang.String[] r7 = (java.lang.String[]) r7
            r7 = r7[r2]
            r6.scanValue = r7
            goto L_0x01a9
        L_0x01a1:
            kotlin.TypeCastException r7 = new kotlin.TypeCastException
            java.lang.String r8 = "null cannot be cast to non-null type kotlin.Array<T>"
            r7.<init>(r8)
            throw r7
        L_0x01a9:
            r6.getFastSearchFilterV2()
            goto L_0x0215
        L_0x01ad:
            kotlin.TypeCastException r7 = new kotlin.TypeCastException
            java.lang.String r8 = "null cannot be cast to non-null type java.lang.String"
            r7.<init>(r8)
            throw r7
        L_0x01b5:
            r8 = 102(0x66, float:1.43E-43)
            if (r7 != r8) goto L_0x01c0
            r6.handleMakeModelMultiSelectRequestCode(r9)
            r6.getSeriesDataBasedOnMakeModel()
            goto L_0x0215
        L_0x01c0:
            r8 = 104(0x68, float:1.46E-43)
            if (r7 != r8) goto L_0x0215
            if (r9 == 0) goto L_0x0215
            android.os.Bundle r7 = r9.getExtras()
            java.lang.String r8 = ""
            if (r7 == 0) goto L_0x01d7
            java.lang.String r9 = "searchinput"
            java.lang.String r7 = r7.getString(r9, r8)
            if (r7 == 0) goto L_0x01d7
            goto L_0x01d8
        L_0x01d7:
            r7 = r8
        L_0x01d8:
            java.lang.StringBuilder r8 = new java.lang.StringBuilder
            r8.<init>()
            java.lang.String r9 = "Sending Event: "
            r8.append(r9)
            com.iaai.android.bdt.analytics.IAAAnalytics$IAAEvents r9 = com.iaai.android.bdt.analytics.IAAAnalytics.IAAEvents.FIND_VEHICLE_KEYWORD_USAGE
            java.lang.String r9 = r9.getId()
            r8.append(r9)
            java.lang.String r9 = " :"
            r8.append(r9)
            r8.append(r7)
            java.lang.String r8 = r8.toString()
            java.lang.String r9 = "FIRE_BASE_ANALYTICS"
            android.util.Log.e(r9, r8)
            com.iaai.android.bdt.analytics.IAAAnalytics r8 = com.iaai.android.bdt.analytics.IAAAnalytics.INSTANCE
            com.iaai.android.bdt.analytics.IAAAnalytics$IAAEvents r9 = com.iaai.android.bdt.analytics.IAAAnalytics.IAAEvents.FIND_VEHICLE_KEYWORD_USAGE
            r8.logIAAEvent(r9, r0)
            r8 = r7
            java.lang.CharSequence r8 = (java.lang.CharSequence) r8
            boolean r8 = kotlin.text.StringsKt.isBlank(r8)
            r8 = r8 ^ r2
            if (r8 == 0) goto L_0x0210
            r6.updateKeywordSearchFacet(r7)
        L_0x0210:
            r6.parentPosition = r1
            r6.getFilterValueBasedSelectedRefiner(r2)
        L_0x0215:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.iaai.android.bdt.feature.fastSearchFilter.newFindVehicle.FastSearchFilterFragment.onActivityResult(int, int, android.content.Intent):void");
    }

    private final void initializeHeader() {
        RecyclerView recyclerView = (RecyclerView) _$_findCachedViewById(C2723R.C2726id.rvClearFilter);
        Intrinsics.checkExpressionValueIsNotNull(recyclerView, "rvClearFilter");
        FastSearchFilterActivity fastSearchFilterActivity2 = this.fastSearchFilterActivity;
        if (fastSearchFilterActivity2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("fastSearchFilterActivity");
        }
        recyclerView.setLayoutManager(new LinearLayoutManager(fastSearchFilterActivity2, 0, false));
        FastSearchFilterActivity fastSearchFilterActivity3 = this.fastSearchFilterActivity;
        if (fastSearchFilterActivity3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("fastSearchFilterActivity");
        }
        this.headerAdapter = new RefinerHeaderAdapter(fastSearchFilterActivity3);
        RefinerHeaderAdapter refinerHeaderAdapter = this.headerAdapter;
        if (refinerHeaderAdapter != null) {
            refinerHeaderAdapter.setClickListener(this.headerClickListener);
        }
        RecyclerView recyclerView2 = (RecyclerView) _$_findCachedViewById(C2723R.C2726id.rvClearFilter);
        Intrinsics.checkExpressionValueIsNotNull(recyclerView2, "rvClearFilter");
        recyclerView2.setAdapter(this.headerAdapter);
        ((RelativeLayout) _$_findCachedViewById(C2723R.C2726id.fl_search_container)).setOnClickListener(new FastSearchFilterFragment$initializeHeader$1(this));
        ((ImageButton) _$_findCachedViewById(C2723R.C2726id.img_voice_text)).setOnClickListener(new FastSearchFilterFragment$initializeHeader$2(this));
    }

    /* access modifiers changed from: private */
    public final void navigateToKeyWordSearchPanel() {
        Intent intent = new Intent(getActivity(), SearchPanelFindVehicleActivity.class);
        intent.putExtra(Constants_MVVM.EXTRA_SEARCH_BY_VEHICLE, true);
        intent.putExtra(Constants_MVVM.EXTRA_IS_FILTERPAGE, true);
        intent.putExtra(Constants_MVVM.EXTRA_IS_FROM_FIND_VEHICLE_PAGE, true);
        startActivityForResult(intent, 104);
    }

    /* access modifiers changed from: private */
    public final void updateHeader(int i, int i2, HeaderUpdate headerUpdate, boolean z) {
        RefinerHeaderAdapter refinerHeaderAdapter;
        Pair<ArrayList<FacetXX>, ArrayList<Triple<Integer, Integer, Integer>>> headerItemData;
        ArrayList second;
        updateIsEnabledMapping(i);
        IaaiApplication.isSavedSearch = false;
        switch (headerUpdate) {
            case MULTI_SELECT:
                if (z) {
                    Triple triple = new Triple(Integer.valueOf(this.tabPos), Integer.valueOf(i), Integer.valueOf(i2));
                    RefinerHeaderAdapter refinerHeaderAdapter2 = this.headerAdapter;
                    if ((refinerHeaderAdapter2 == null || (headerItemData = refinerHeaderAdapter2.getHeaderItemData()) == null || (second = headerItemData.getSecond()) == null || !second.contains(triple)) && (refinerHeaderAdapter = this.headerAdapter) != null) {
                        refinerHeaderAdapter.addToHeaderListData(triple);
                    }
                } else {
                    RefinerHeaderAdapter refinerHeaderAdapter3 = this.headerAdapter;
                    if (refinerHeaderAdapter3 != null) {
                        refinerHeaderAdapter3.removeSingleGroupRefinerFromHeader(i, i2, this.tabPos);
                    }
                }
                RefinerHeaderAdapter refinerHeaderAdapter4 = this.headerAdapter;
                if (refinerHeaderAdapter4 != null) {
                    refinerHeaderAdapter4.notifyDataSetChanged();
                    break;
                }
                break;
            case SINGLE_SELECT:
                RefinerHeaderAdapter refinerHeaderAdapter5 = this.headerAdapter;
                if (refinerHeaderAdapter5 != null) {
                    refinerHeaderAdapter5.removeGroupFromHeaderData(i, this.tabPos);
                }
                RefinerHeaderAdapter refinerHeaderAdapter6 = this.headerAdapter;
                if (refinerHeaderAdapter6 != null) {
                    refinerHeaderAdapter6.addToHeaderListData(new Triple(Integer.valueOf(this.tabPos), Integer.valueOf(i), Integer.valueOf(i2)));
                }
                RefinerHeaderAdapter refinerHeaderAdapter7 = this.headerAdapter;
                if (refinerHeaderAdapter7 != null) {
                    refinerHeaderAdapter7.notifyDataSetChanged();
                    break;
                }
                break;
            case CLEAR_GROUP_VIEW:
                RefinerHeaderAdapter refinerHeaderAdapter8 = this.headerAdapter;
                if (refinerHeaderAdapter8 != null) {
                    refinerHeaderAdapter8.removeGroupFromHeaderData(i, this.tabPos);
                    break;
                }
                break;
            case CLEAR_ALL_FILTERS:
                RefinerHeaderAdapter refinerHeaderAdapter9 = this.headerAdapter;
                if (refinerHeaderAdapter9 != null) {
                    refinerHeaderAdapter9.removeAllRefinerFromHeader();
                    break;
                }
                break;
            case SLIDER:
                RefinerHeaderAdapter refinerHeaderAdapter10 = this.headerAdapter;
                if (refinerHeaderAdapter10 != null) {
                    refinerHeaderAdapter10.removeGroupFromHeaderData(i, this.tabPos);
                }
                RefinerHeaderAdapter refinerHeaderAdapter11 = this.headerAdapter;
                if (refinerHeaderAdapter11 != null) {
                    refinerHeaderAdapter11.addToHeaderListData(new Triple(Integer.valueOf(this.tabPos), Integer.valueOf(i), Integer.valueOf(i2)));
                }
                RefinerHeaderAdapter refinerHeaderAdapter12 = this.headerAdapter;
                if (refinerHeaderAdapter12 != null) {
                    refinerHeaderAdapter12.notifyDataSetChanged();
                    break;
                }
                break;
            case POPULAR_CATEGORIES:
                if (z) {
                    RefinerHeaderAdapter refinerHeaderAdapter13 = this.headerAdapter;
                    if (refinerHeaderAdapter13 != null) {
                        refinerHeaderAdapter13.addPopularCategoryToHeaderList(i2);
                    }
                } else {
                    RefinerHeaderAdapter refinerHeaderAdapter14 = this.headerAdapter;
                    if (refinerHeaderAdapter14 != null) {
                        refinerHeaderAdapter14.removeSingleGroupRefinerFromHeader(0, i2, 2);
                    }
                }
                RefinerHeaderAdapter refinerHeaderAdapter15 = this.headerAdapter;
                if (refinerHeaderAdapter15 != null) {
                    refinerHeaderAdapter15.notifyDataSetChanged();
                    break;
                }
                break;
        }
        showEmptyHeader();
    }

    private final void removeAllSeriesHeaderData() {
        RefinerHeaderAdapter refinerHeaderAdapter;
        int size = BDTUtils.INSTANCE.getSearchMappingArray().get(this.tabPos).getGroups().size();
        int i = 0;
        while (true) {
            if (i >= size) {
                i = -1;
                break;
            }
            SearchMappingGroup searchMappingGroup = BDTUtils.INSTANCE.getSearchMappingArray().get(this.tabPos).getGroups().get(i);
            Intrinsics.checkExpressionValueIsNotNull(searchMappingGroup, "BDTUtils.searchMappingArray[tabPos].groups[index]");
            if (Intrinsics.areEqual((Object) searchMappingGroup.getGroup(), (Object) "Series")) {
                break;
            }
            i++;
        }
        if (i != -1 && (refinerHeaderAdapter = this.headerAdapter) != null) {
            refinerHeaderAdapter.removeGroupFromHeaderData(i, this.tabPos);
        }
    }

    /* access modifiers changed from: private */
    public final void updateFilterMapping(int i, int i2, int i3, FacetXX facetXX) {
        if (i == 0) {
            BDTUtils.INSTANCE.updateGlobalFilterMapping(i, i2, i3, facetXX);
            FastSearchExpandableAdapter fastSearchExpandableAdapter = this.expandableListAdapterVF;
            if (fastSearchExpandableAdapter != null) {
                fastSearchExpandableAdapter.notifyDataSetChanged();
            }
        } else if (i == 1) {
            BDTUtils.INSTANCE.updateGlobalFilterMapping(i, i2, i3, facetXX);
            FastSearchExpandableAdapter fastSearchExpandableAdapter2 = this.expandableListAdapterSF;
            if (fastSearchExpandableAdapter2 != null) {
                fastSearchExpandableAdapter2.notifyDataSetChanged();
            }
        } else if (i == 2) {
            BDTUtils bDTUtils = BDTUtils.INSTANCE;
            List list = BDTUtils.INSTANCE.getExpandableListDetailPC().get(BDTUtils.INSTANCE.getSearchMappingArray().get(i).getGroups().get(0));
            bDTUtils.updateGlobalPopularCategoryMapping(list != null ? (FacetXX) list.get(i3) : null);
            PopularCategoriesAdapter popularCategoriesAdapter2 = this.popularCategoriesAdapter;
            if (popularCategoriesAdapter2 != null) {
                popularCategoriesAdapter2.setQuickLinksData();
            }
            PopularCategoriesAdapter popularCategoriesAdapter3 = this.popularCategoriesAdapter;
            if (popularCategoriesAdapter3 != null) {
                popularCategoriesAdapter3.notifyDataSetChanged();
            }
        }
    }

    public void onResume() {
        FastSearchExpandableAdapter fastSearchExpandableAdapter;
        super.onResume();
        if (IaaiApplication.isBackPressedFromRefinerResult) {
            updateSelectedRefinerUIBasedOnGlobalArray();
            IaaiApplication.isBackPressedFromRefinerResult = false;
        }
        int i = this.tabPos;
        if (i == 0) {
            FastSearchExpandableAdapter fastSearchExpandableAdapter2 = this.expandableListAdapterVF;
            if (fastSearchExpandableAdapter2 != null) {
                fastSearchExpandableAdapter2.notifyDataSetChanged();
            }
        } else if (i == 1 && (fastSearchExpandableAdapter = this.expandableListAdapterSF) != null) {
            fastSearchExpandableAdapter.notifyDataSetChanged();
        }
        PopularCategoriesAdapter popularCategoriesAdapter2 = this.popularCategoriesAdapter;
        if (popularCategoriesAdapter2 != null) {
            popularCategoriesAdapter2.notifyDataSetChanged();
        }
        this.isFirstTime = false;
    }

    private final void updateSelectedRefinerUIBasedOnGlobalArray() {
        String refinerValue;
        RefinerHeaderAdapter refinerHeaderAdapter;
        RefinerHeaderAdapter refinerHeaderAdapter2 = this.headerAdapter;
        if (refinerHeaderAdapter2 != null) {
            refinerHeaderAdapter2.removeAllHeaderData(BDTUtils.INSTANCE.getGlobalItemList(), BDTUtils.INSTANCE.getGlobalIndicesList());
        }
        if (BDTUtils.INSTANCE.getGlobalItemList().size() == 0 && (refinerHeaderAdapter = this.headerAdapter) != null) {
            refinerHeaderAdapter.setSelectedIndicesCount(0);
        }
        ArrayList arrayList = new ArrayList();
        int i = 0;
        for (Object next : BDTUtils.INSTANCE.getGlobalItemList()) {
            int i2 = i + 1;
            if (i < 0) {
                CollectionsKt.throwIndexOverflow();
            }
            FacetXX facetXX = (FacetXX) next;
            if (!(facetXX == null || (refinerValue = facetXX.getRefinerValue()) == null || !StringsKt.startsWith$default(refinerValue, "Make & Model~", false, 2, (Object) null))) {
                arrayList.add(facetXX);
            }
            i = i2;
        }
        if (arrayList.isEmpty()) {
            this.lastSelectedMakeModel.clear();
            resetUIForSeriesAndMakeModel();
        } else {
            updateLastSelectedMakeModelArray(arrayList);
        }
        showEmptyHeader();
        FastSearchFilterActivity fastSearchFilterActivity2 = this.fastSearchFilterActivity;
        if (fastSearchFilterActivity2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("fastSearchFilterActivity");
        }
        if (fastSearchFilterActivity2.isFilterPage() && this.isFirstTime) {
            updateSearchMappingArray();
        }
    }

    /* access modifiers changed from: private */
    public final void showEmptyHeader() {
        RefinerHeaderAdapter refinerHeaderAdapter = this.headerAdapter;
        if (refinerHeaderAdapter == null || refinerHeaderAdapter.getSelectedIndicesCount() != 0) {
            RecyclerView recyclerView = (RecyclerView) _$_findCachedViewById(C2723R.C2726id.rvClearFilter);
            Intrinsics.checkExpressionValueIsNotNull(recyclerView, "rvClearFilter");
            recyclerView.setVisibility(0);
            FastSearchFilterActivity fastSearchFilterActivity2 = this.fastSearchFilterActivity;
            if (fastSearchFilterActivity2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("fastSearchFilterActivity");
            }
            fastSearchFilterActivity2.getTvClearFastSearch().setVisibility(0);
            if (IaaiApplication.isSavedSearch) {
                TextView textView = (TextView) _$_findCachedViewById(C2723R.C2726id.tvSaveSearch);
                Intrinsics.checkExpressionValueIsNotNull(textView, "tvSaveSearch");
                textView.setText(getResources().getString(C2723R.string.lbl_search_saved));
                disableSavedSearch();
                return;
            }
            TextView textView2 = (TextView) _$_findCachedViewById(C2723R.C2726id.tvSaveSearch);
            Intrinsics.checkExpressionValueIsNotNull(textView2, "tvSaveSearch");
            textView2.setText(getResources().getString(C2723R.string.lbl_save_search));
            enableSavedSearch();
            return;
        }
        RecyclerView recyclerView2 = (RecyclerView) _$_findCachedViewById(C2723R.C2726id.rvClearFilter);
        Intrinsics.checkExpressionValueIsNotNull(recyclerView2, "rvClearFilter");
        recyclerView2.setVisibility(8);
        FastSearchFilterActivity fastSearchFilterActivity3 = this.fastSearchFilterActivity;
        if (fastSearchFilterActivity3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("fastSearchFilterActivity");
        }
        fastSearchFilterActivity3.getTvClearFastSearch().setVisibility(8);
        TextView textView3 = (TextView) _$_findCachedViewById(C2723R.C2726id.tvSaveSearch);
        Intrinsics.checkExpressionValueIsNotNull(textView3, "tvSaveSearch");
        textView3.setText(getResources().getString(C2723R.string.lbl_save_search));
        disableSavedSearch();
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v5, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v4, resolved type: java.util.ArrayList} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final com.iaai.android.bdt.model.filter.FilterData mapMasterMakeToRefiner(java.util.ArrayList<com.iaai.android.bdt.model.fastSearchFilter2.FacetXX> r20) {
        /*
            r19 = this;
            com.google.gson.Gson r0 = new com.google.gson.Gson
            r0.<init>()
            r1 = r19
            com.iaai.android.bdt.feature.fastSearchFilter.newFindVehicle.FastSearchFilterActivity r2 = r1.fastSearchFilterActivity
            if (r2 != 0) goto L_0x0010
            java.lang.String r3 = "fastSearchFilterActivity"
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r3)
        L_0x0010:
            android.content.Context r2 = (android.content.Context) r2
            java.lang.String r2 = com.iaai.android.old.utils.IAASharedPreference.getMakeModelMasterData(r2)
            java.util.ArrayList r3 = new java.util.ArrayList
            r3.<init>()
            java.lang.String r4 = "json"
            kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r2, r4)
            r4 = r2
            java.lang.CharSequence r4 = (java.lang.CharSequence) r4
            int r4 = r4.length()
            r5 = 1
            r6 = 0
            if (r4 <= 0) goto L_0x002d
            r4 = 1
            goto L_0x002e
        L_0x002d:
            r4 = 0
        L_0x002e:
            if (r4 == 0) goto L_0x0045
            com.iaai.android.bdt.feature.fastSearchFilter.newFindVehicle.FastSearchFilterFragment$mapMasterMakeToRefiner$1 r3 = new com.iaai.android.bdt.feature.fastSearchFilter.newFindVehicle.FastSearchFilterFragment$mapMasterMakeToRefiner$1
            r3.<init>()
            java.lang.reflect.Type r3 = r3.getType()
            java.lang.Object r0 = r0.fromJson((java.lang.String) r2, (java.lang.reflect.Type) r3)
            java.lang.String r2 = "gson.fromJson(json, obje…eModelMaster>>() {}.type)"
            kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r0, r2)
            r3 = r0
            java.util.ArrayList r3 = (java.util.ArrayList) r3
        L_0x0045:
            java.util.ArrayList r0 = new java.util.ArrayList
            r0.<init>()
            r2 = r20
            java.lang.Iterable r2 = (java.lang.Iterable) r2
            java.util.Iterator r2 = r2.iterator()
        L_0x0052:
            boolean r4 = r2.hasNext()
            if (r4 == 0) goto L_0x0122
            java.lang.Object r4 = r2.next()
            com.iaai.android.bdt.model.fastSearchFilter2.FacetXX r4 = (com.iaai.android.bdt.model.fastSearchFilter2.FacetXX) r4
            java.util.Iterator r7 = r3.iterator()
        L_0x0062:
            boolean r8 = r7.hasNext()
            if (r8 == 0) goto L_0x0052
            java.lang.Object r8 = r7.next()
            com.iaai.android.bdt.model.fastSearch.MakeModelMaster r8 = (com.iaai.android.bdt.model.fastSearch.MakeModelMaster) r8
            java.lang.String r9 = r8.getMake()
            java.lang.String r10 = r4.getValue()
            if (r10 == 0) goto L_0x011a
            java.lang.CharSequence r10 = (java.lang.CharSequence) r10
            java.lang.CharSequence r10 = kotlin.text.StringsKt.trim((java.lang.CharSequence) r10)
            java.lang.String r10 = r10.toString()
            boolean r9 = kotlin.text.StringsKt.equals(r9, r10, r5)
            if (r9 == 0) goto L_0x0062
            java.util.ArrayList r7 = new java.util.ArrayList
            r7.<init>()
            java.util.List r9 = r8.getModels()
            if (r9 != 0) goto L_0x0096
            kotlin.jvm.internal.Intrinsics.throwNpe()
        L_0x0096:
            java.util.Iterator r9 = r9.iterator()
        L_0x009a:
            boolean r10 = r9.hasNext()
            java.lang.String r11 = ""
            if (r10 == 0) goto L_0x00c3
            java.lang.Object r10 = r9.next()
            java.lang.String r10 = (java.lang.String) r10
            r12 = r10
            java.lang.CharSequence r12 = (java.lang.CharSequence) r12
            int r12 = r12.length()
            if (r12 <= 0) goto L_0x00b3
            r12 = 1
            goto L_0x00b4
        L_0x00b3:
            r12 = 0
        L_0x00b4:
            if (r12 == 0) goto L_0x009a
            com.iaai.android.bdt.model.filter.FilterSubValues r12 = new com.iaai.android.bdt.model.filter.FilterSubValues
            java.lang.Integer r13 = java.lang.Integer.valueOf(r6)
            r12.<init>(r10, r11, r13)
            r7.add(r12)
            goto L_0x009a
        L_0x00c3:
            java.lang.Iterable r7 = (java.lang.Iterable) r7
            com.iaai.android.bdt.feature.fastSearchFilter.newFindVehicle.FastSearchFilterFragment$$special$$inlined$compareBy$1 r9 = new com.iaai.android.bdt.feature.fastSearchFilter.newFindVehicle.FastSearchFilterFragment$$special$$inlined$compareBy$1
            r9.<init>()
            java.util.Comparator r9 = (java.util.Comparator) r9
            java.util.List r7 = kotlin.collections.CollectionsKt.sortedWith(r7, r9)
            java.util.ArrayList r9 = new java.util.ArrayList
            r9.<init>()
            java.util.Collection r7 = (java.util.Collection) r7
            r9.addAll(r7)
            com.iaai.android.bdt.model.filter.FilterSubValues r7 = new com.iaai.android.bdt.model.filter.FilterSubValues
            java.lang.StringBuilder r10 = new java.lang.StringBuilder
            r10.<init>()
            java.lang.String r12 = "All "
            r10.append(r12)
            java.lang.String r12 = r8.getMake()
            r10.append(r12)
            java.lang.String r10 = r10.toString()
            java.lang.Integer r12 = java.lang.Integer.valueOf(r6)
            r7.<init>(r10, r11, r12)
            r9.add(r6, r7)
            com.iaai.android.bdt.model.filter.FilterValues r7 = new com.iaai.android.bdt.model.filter.FilterValues
            java.lang.String r14 = r8.getMake()
            int r4 = r4.getCount()
            java.lang.Integer r15 = java.lang.Integer.valueOf(r4)
            r16 = r9
            java.util.List r16 = (java.util.List) r16
            r18 = 0
            java.lang.String r17 = ""
            r13 = r7
            r13.<init>(r14, r15, r16, r17, r18)
            r0.add(r7)
            goto L_0x0052
        L_0x011a:
            kotlin.TypeCastException r0 = new kotlin.TypeCastException
            java.lang.String r2 = "null cannot be cast to non-null type kotlin.CharSequence"
            r0.<init>(r2)
            throw r0
        L_0x0122:
            java.lang.Iterable r0 = (java.lang.Iterable) r0
            com.iaai.android.bdt.feature.fastSearchFilter.newFindVehicle.FastSearchFilterFragment$mapMasterMakeToRefiner$$inlined$compareBy$1 r2 = new com.iaai.android.bdt.feature.fastSearchFilter.newFindVehicle.FastSearchFilterFragment$mapMasterMakeToRefiner$$inlined$compareBy$1
            r2.<init>()
            java.util.Comparator r2 = (java.util.Comparator) r2
            java.util.List r11 = kotlin.collections.CollectionsKt.sortedWith(r0, r2)
            com.iaai.android.bdt.model.filter.FilterData r0 = new com.iaai.android.bdt.model.filter.FilterData
            java.lang.Integer r8 = java.lang.Integer.valueOf(r6)
            java.lang.Integer r10 = java.lang.Integer.valueOf(r6)
            java.lang.String r9 = "Make & Model"
            java.lang.String r12 = ""
            r7 = r0
            r7.<init>(r8, r9, r10, r11, r12)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.iaai.android.bdt.feature.fastSearchFilter.newFindVehicle.FastSearchFilterFragment.mapMasterMakeToRefiner(java.util.ArrayList):com.iaai.android.bdt.model.filter.FilterData");
    }

    private final void addRecentlyViewModel(ArrayList<MakeModelValues> arrayList) {
        for (MakeModelValues makeModelValues : arrayList) {
            if (Intrinsics.areEqual((Object) makeModelValues.getDisplayText(), (Object) "")) {
                StringBuilder sb = new StringBuilder();
                sb.append("All ");
                MakeModelValues makeInfo = makeModelValues.getMakeInfo();
                sb.append(makeInfo != null ? makeInfo.getDisplayText() : null);
                makeModelValues.setDisplayText(sb.toString());
            }
            if (this.recentlyUsedModels.size() == 0) {
                this.recentlyUsedModels.add(new MakeModelValues("Recently used filters", "Recently used filters", true, (MakeModelValues) null, 0, false));
            }
            if (this.recentlyUsedModels.contains(makeModelValues)) {
                int indexOf = this.recentlyUsedModels.indexOf(makeModelValues);
                if (indexOf != -1) {
                    this.recentlyUsedModels.remove(indexOf);
                }
                this.recentlyUsedModels.add(1, makeModelValues);
            } else if (this.recentlyUsedModels.size() < 6) {
                this.recentlyUsedModels.add(1, makeModelValues);
            } else {
                this.recentlyUsedModels.remove(5);
                this.recentlyUsedModels.add(1, makeModelValues);
            }
            saveRecentlyUsedModels();
        }
    }

    private final void saveRecentlyUsedModels() {
        String json = new Gson().toJson((Object) this.recentlyUsedModels);
        FastSearchFilterActivity fastSearchFilterActivity2 = this.fastSearchFilterActivity;
        if (fastSearchFilterActivity2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("fastSearchFilterActivity");
        }
        IAASharedPreference.setRecentlyUsedFacetModel(fastSearchFilterActivity2, json);
    }

    private final void loadRecentlyUsedModels() {
        Gson gson = new Gson();
        FastSearchFilterActivity fastSearchFilterActivity2 = this.fastSearchFilterActivity;
        if (fastSearchFilterActivity2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("fastSearchFilterActivity");
        }
        String recentlyUsedFacetModel = IAASharedPreference.getRecentlyUsedFacetModel(fastSearchFilterActivity2);
        Intrinsics.checkExpressionValueIsNotNull(recentlyUsedFacetModel, "json");
        if (recentlyUsedFacetModel.length() > 0) {
            Object fromJson = gson.fromJson(recentlyUsedFacetModel, new FastSearchFilterFragment$loadRecentlyUsedModels$1().getType());
            Intrinsics.checkExpressionValueIsNotNull(fromJson, "gson.fromJson(json, obje…eModelValues>>() {}.type)");
            this.recentlyUsedModels = (ArrayList) fromJson;
        }
    }

    private final void handleMakeModelMultiSelectRequestCode(Intent intent) {
        ArrayList arrayList;
        ArrayList<MakeModelValues> arrayList2;
        if (intent != null) {
            Bundle extras = intent.getExtras();
            if (extras == null || (arrayList = extras.getParcelableArrayList(Constants_MVVM.EXTRA_LAST_SELECTED_MAKE_MODEL)) == null) {
                arrayList = new ArrayList();
            }
            Bundle extras2 = intent.getExtras();
            if (extras2 == null || (arrayList2 = extras2.getParcelableArrayList(Constants_MVVM.EXTRA_SELECTED_FILTER_DATA)) == null) {
                arrayList2 = new ArrayList<>();
            }
            arrayList2.addAll(arrayList);
            for (MakeModelValues makeModelValues : arrayList2) {
                Intrinsics.checkExpressionValueIsNotNull(makeModelValues, "makeModelValue");
                updateSelectedRefiner(makeModelValues);
            }
        }
    }

    private final void updateSelectedRefiner(MakeModelValues makeModelValues) {
        String str;
        String str2;
        MakeModelValues makeInfo;
        MakeModelValues makeInfo2;
        MakeModelValues makeInfo3;
        String str3 = "";
        if (makeModelValues == null || (str = makeModelValues.getDisplayText()) == null) {
            str = str3;
        }
        String str4 = null;
        if (str.length() == 0) {
            StringBuilder sb = new StringBuilder();
            sb.append("Make & Model~");
            sb.append((makeModelValues == null || (makeInfo3 = makeModelValues.getMakeInfo()) == null) ? null : makeInfo3.getDisplayText());
            str2 = sb.toString();
        } else {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("Make & Model~");
            sb2.append((makeModelValues == null || (makeInfo2 = makeModelValues.getMakeInfo()) == null) ? null : makeInfo2.getDisplayText());
            sb2.append('~');
            sb2.append(makeModelValues != null ? makeModelValues.getDisplayText() : null);
            str2 = sb2.toString();
        }
        StringBuilder sb3 = new StringBuilder();
        sb3.append("All ");
        MakeModelValues makeInfo4 = makeModelValues.getMakeInfo();
        sb3.append(makeInfo4 != null ? makeInfo4.getDisplayText() : null);
        if (!StringsKt.startsWith(str, sb3.toString(), true)) {
            str3 = str;
        }
        StringBuilder sb4 = new StringBuilder();
        sb4.append((makeModelValues == null || (makeInfo = makeModelValues.getMakeInfo()) == null) ? null : makeInfo.getDisplayText());
        sb4.append(' ');
        sb4.append(str3);
        FacetXX facetXX = new FacetXX(0, sb4.toString(), str2, true);
        Triple triple = new Triple(Integer.valueOf(this.tabPos), Integer.valueOf(this.parentPosition), Integer.valueOf(str2.hashCode()));
        RefinerHeaderAdapter refinerHeaderAdapter = this.headerAdapter;
        if (refinerHeaderAdapter != null) {
            refinerHeaderAdapter.removeSingleGroupRefinerFromHeader(this.parentPosition, str2.hashCode(), this.tabPos);
        }
        if (makeModelValues.isSelected()) {
            RefinerHeaderAdapter refinerHeaderAdapter2 = this.headerAdapter;
            if (refinerHeaderAdapter2 != null) {
                refinerHeaderAdapter2.addMakeModelToHeaderListData(facetXX, triple);
            }
            RefinerHeaderAdapter refinerHeaderAdapter3 = this.headerAdapter;
            if (refinerHeaderAdapter3 != null) {
                refinerHeaderAdapter3.notifyDataSetChanged();
            }
            showEmptyHeader();
            FastSearchExpandableAdapter fastSearchExpandableAdapter = this.expandableListAdapterVF;
            if (fastSearchExpandableAdapter != null) {
                fastSearchExpandableAdapter.updateListOnSelectItem(this.parentPosition, 0, true);
            }
            if (!this.lastSelectedMakeModel.contains(makeModelValues)) {
                this.lastSelectedMakeModel.add(makeModelValues);
                return;
            }
            return;
        }
        String displayText = makeModelValues.getDisplayText();
        MakeModelValues makeInfo5 = makeModelValues.getMakeInfo();
        if (makeInfo5 != null) {
            str4 = makeInfo5.getDisplayText();
        }
        removeLastSelectedMakeModel(displayText, str4);
    }

    private final void updateKeywordSearchFacet(String str) {
        FacetXX facetXX = new FacetXX(0, str, "keyword", true);
        Triple triple = new Triple(4, 0, Integer.valueOf("keyword".hashCode()));
        RefinerHeaderAdapter refinerHeaderAdapter = this.headerAdapter;
        if (refinerHeaderAdapter != null) {
            refinerHeaderAdapter.removeSingleGroupRefinerFromHeader(0, "keyword".hashCode(), 4);
        }
        RefinerHeaderAdapter refinerHeaderAdapter2 = this.headerAdapter;
        if (refinerHeaderAdapter2 != null) {
            refinerHeaderAdapter2.addMakeModelToHeaderListData(facetXX, triple);
        }
        RefinerHeaderAdapter refinerHeaderAdapter3 = this.headerAdapter;
        if (refinerHeaderAdapter3 != null) {
            refinerHeaderAdapter3.notifyDataSetChanged();
        }
        showEmptyHeader();
    }

    /* access modifiers changed from: private */
    public final void removeLastSelectedMakeModel(String str, String str2) {
        int size = this.lastSelectedMakeModel.size();
        int i = 0;
        while (true) {
            if (i >= size) {
                i = -1;
                break;
            }
            MakeModelValues makeModelValues = this.lastSelectedMakeModel.get(i);
            Intrinsics.checkExpressionValueIsNotNull(makeModelValues, "lastSelectedMakeModel[index]");
            MakeModelValues makeModelValues2 = makeModelValues;
            if (StringsKt.equals$default(makeModelValues2.getDisplayText(), str, false, 2, (Object) null)) {
                MakeModelValues makeInfo = makeModelValues2.getMakeInfo();
                if (StringsKt.equals$default(makeInfo != null ? makeInfo.getDisplayText() : null, str2, false, 2, (Object) null)) {
                    break;
                }
            }
            i++;
        }
        this.lastSelectedMakeModel.remove(i);
        if (this.lastSelectedMakeModel.isEmpty()) {
            resetUIForSeriesAndMakeModel();
        }
    }

    private final void updateLastSelectedMakeModelArray(ArrayList<FacetXX> arrayList) {
        ArrayList arrayList2 = new ArrayList();
        for (FacetXX makeModel : arrayList) {
            Pair<String, String> makeModel2 = BDTUtils.INSTANCE.getMakeModel(makeModel);
            for (MakeModelValues makeModelValues : this.lastSelectedMakeModel) {
                MakeModelValues makeInfo = makeModelValues.getMakeInfo();
                if (StringsKt.equals$default(makeInfo != null ? makeInfo.getDisplayText() : null, makeModel2.getFirst(), false, 2, (Object) null) && StringsKt.equals$default(makeModelValues.getDisplayText(), makeModel2.getSecond(), false, 2, (Object) null)) {
                    arrayList2.add(makeModelValues);
                }
            }
        }
        this.lastSelectedMakeModel.clear();
        this.lastSelectedMakeModel.addAll(arrayList2);
        if (this.lastSelectedMakeModel.isEmpty()) {
            resetUIForSeriesAndMakeModel();
        }
    }

    /* access modifiers changed from: private */
    public final void updateIsEnabledMapping(int i) {
        int i2;
        boolean z;
        FastSearchExpandableAdapter fastSearchExpandableAdapter;
        if (StringsKt.equals(BDTUtils.INSTANCE.getSearchMappingArray().get(this.tabPos).getGroups().get(i).getGroup(), "AuctionType", true)) {
            List<FacetXX> list = BDTUtils.INSTANCE.getExpandableListDetail().get(BDTUtils.INSTANCE.getSearchMappingArray().get(this.tabPos).getGroups().get(i));
            if (list != null) {
                z = false;
                for (FacetXX facetXX : list) {
                    if (StringsKt.equals(facetXX.getValue(), "Buy Now", true) && facetXX.isSelected()) {
                        z = true;
                    }
                }
            } else {
                z = false;
            }
            i2 = -1;
            int i3 = 0;
            for (Object next : BDTUtils.INSTANCE.getSearchMappingArray().get(this.tabPos).getGroups()) {
                int i4 = i3 + 1;
                if (i3 < 0) {
                    CollectionsKt.throwIndexOverflow();
                }
                SearchMappingGroup searchMappingGroup = (SearchMappingGroup) next;
                if (StringsKt.equals(searchMappingGroup.getGroup(), "BuynowRange", true)) {
                    searchMappingGroup.setEnabled(z);
                    i2 = i3;
                }
                i3 = i4;
            }
        } else {
            z = false;
            i2 = -1;
        }
        if (!z && i2 != -1) {
            for (FacetXX selected : BDTUtils.INSTANCE.getSearchMappingArray().get(this.tabPos).getGroups().get(i2).getListFacet()) {
                selected.setSelected(false);
            }
            RefinerHeaderAdapter refinerHeaderAdapter = this.headerAdapter;
            if (refinerHeaderAdapter != null) {
                refinerHeaderAdapter.removeGroupFromHeaderData(i2, this.tabPos);
            }
        }
        BDTUtils.INSTANCE.getFilterData(this.tabPos);
        int i5 = this.tabPos;
        if (i5 == 0) {
            FastSearchExpandableAdapter fastSearchExpandableAdapter2 = this.expandableListAdapterVF;
            if (fastSearchExpandableAdapter2 != null) {
                fastSearchExpandableAdapter2.notifyDataSetChanged();
            }
        } else if (i5 == 1 && (fastSearchExpandableAdapter = this.expandableListAdapterSF) != null) {
            fastSearchExpandableAdapter.notifyDataSetChanged();
        }
    }

    /* access modifiers changed from: private */
    public final void getSeriesDataBasedOnMakeModel() {
        String str;
        Sort sort = new Sort(true, false, "Year");
        ArrayList arrayList = new ArrayList();
        if (this.lastSelectedMakeModel.isEmpty()) {
            resetUIForSeriesAndMakeModel();
            return;
        }
        for (MakeModelValues makeModelValues : this.lastSelectedMakeModel) {
            MakeModelValues makeInfo = makeModelValues.getMakeInfo();
            if (makeInfo == null || (str = makeInfo.getDisplayText()) == null) {
                str = "";
            }
            if (!StringsKt.isBlank(str)) {
                arrayList.add(new Searche("", CollectionsKt.arrayListOf(new Facet(ExifInterface.TAG_MAKE, str)), "", (ArrayList<LongDiscretes>) null, (ArrayList<LongRangesData>) null));
            }
            String displayText = makeModelValues.getDisplayText();
            if (displayText == null) {
                displayText = "";
            }
            if ((!StringsKt.isBlank(displayText)) && !StringsKt.startsWith$default(displayText, "All", false, 2, (Object) null)) {
                arrayList.add(new Searche("", CollectionsKt.arrayListOf(new Facet(ExifInterface.TAG_MODEL, displayText)), "", (ArrayList<LongDiscretes>) null, (ArrayList<LongRangesData>) null));
            }
        }
        FastSearchRequestBody fastSearchRequestBody = new FastSearchRequestBody("", 1, true, true, false, (List<String>) null, 0, 1, (LatLong) null, arrayList, CollectionsKt.arrayListOf(sort), new ArrayList(), false, false, false, 0, "", (SavedSearch) null);
        StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
        Object[] objArr = new Object[2];
        FastSearchFilterActivity fastSearchFilterActivity2 = this.fastSearchFilterActivity;
        if (fastSearchFilterActivity2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("fastSearchFilterActivity");
        }
        objArr[0] = fastSearchFilterActivity2.getSessionManager().getCurrentSessionUsername();
        FastSearchFilterActivity fastSearchFilterActivity3 = this.fastSearchFilterActivity;
        if (fastSearchFilterActivity3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("fastSearchFilterActivity");
        }
        objArr[1] = fastSearchFilterActivity3.getSessionManager().getCurrentSessionPassword();
        String format = String.format("%s:%s", Arrays.copyOf(objArr, objArr.length));
        Intrinsics.checkExpressionValueIsNotNull(format, "java.lang.String.format(format, *args)");
        FastSearchFilterViewModel fastSearchFilterViewModel = this.viewModel;
        if (fastSearchFilterViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        }
        fastSearchFilterViewModel.getSeriesData(fastSearchRequestBody, format);
    }

    /* access modifiers changed from: private */
    public final void getFilterValueBasedSelectedRefiner(boolean z) {
        String str;
        Integer first;
        if (z) {
            showLoadingIndicator(true);
            Sort sort = new Sort(true, false, "Year");
            ArrayList arrayList = new ArrayList();
            RefinerHeaderAdapter refinerHeaderAdapter = this.headerAdapter;
            ArrayList<FacetXX> headerItem = refinerHeaderAdapter != null ? refinerHeaderAdapter.getHeaderItem() : null;
            Pair pair = null;
            if (headerItem != null) {
                for (FacetXX facetXX : headerItem) {
                    if (facetXX == null || (str = facetXX.getRefinerValue()) == null) {
                        str = "";
                    }
                    if (facetXX != null) {
                        String value = facetXX.getValue();
                    }
                    CharSequence charSequence = str;
                    if (!StringsKt.isBlank(charSequence)) {
                        if (StringsKt.startsWith(str, "Distance", true)) {
                            Pair<Integer, Integer> distance = BDTUtils.INSTANCE.getDistance(facetXX);
                            if (!(distance == null || (first = distance.getFirst()) == null)) {
                                first.intValue();
                            }
                        } else if (StringsKt.startsWith(str, "Make & Model", true)) {
                            ArrayList arrayList2 = new ArrayList();
                            String str2 = (String) StringsKt.split$default(charSequence, new String[]{"~"}, false, 0, 6, (Object) null).get(1);
                            if (str2 != null) {
                                String obj = StringsKt.trim((CharSequence) str2).toString();
                                CharSequence charSequence2 = charSequence;
                                String str3 = obj;
                                String str4 = "null cannot be cast to non-null type kotlin.CharSequence";
                                String str5 = (String) StringsKt.split$default(charSequence2, new String[]{"~"}, false, 0, 6, (Object) null).get(2);
                                if (str5 != null) {
                                    String obj2 = StringsKt.trim((CharSequence) str5).toString();
                                    arrayList2.add(new Facet(ExifInterface.TAG_MAKE, str3));
                                    arrayList.add(new Searche("", arrayList2, "", (ArrayList<LongDiscretes>) null, (ArrayList<LongRangesData>) null));
                                    if (!StringsKt.startsWith$default(obj2, "All", false, 2, (Object) null)) {
                                        ArrayList arrayList3 = new ArrayList();
                                        arrayList3.add(new Facet(ExifInterface.TAG_MODEL, obj2));
                                        arrayList.add(new Searche("", arrayList3, "", (ArrayList<LongDiscretes>) null, (ArrayList<LongRangesData>) null));
                                    }
                                } else {
                                    throw new TypeCastException(str4);
                                }
                            } else {
                                throw new TypeCastException("null cannot be cast to non-null type kotlin.CharSequence");
                            }
                        } else {
                            arrayList.add(BDTUtils.INSTANCE.getSearchesObj(facetXX));
                        }
                    }
                }
            }
            if (arrayList.isEmpty()) {
                arrayList.add(new Searche("", CollectionsKt.arrayListOf(new Facet("Default", "True")), "", (ArrayList<LongDiscretes>) null, (ArrayList<LongRangesData>) null));
            }
            FastSearchRequestBody fastSearchRequestBody = new FastSearchRequestBody("", 1, true, true, false, (List<String>) null, 0, 1, (LatLong) null, arrayList, CollectionsKt.arrayListOf(sort), new ArrayList(), false, false, false, 0, "", (SavedSearch) null);
            StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
            Object[] objArr = new Object[2];
            FastSearchFilterActivity fastSearchFilterActivity2 = this.fastSearchFilterActivity;
            if (fastSearchFilterActivity2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("fastSearchFilterActivity");
            }
            objArr[0] = fastSearchFilterActivity2.getSessionManager().getCurrentSessionUsername();
            FastSearchFilterActivity fastSearchFilterActivity3 = this.fastSearchFilterActivity;
            if (fastSearchFilterActivity3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("fastSearchFilterActivity");
            }
            objArr[1] = fastSearchFilterActivity3.getSessionManager().getCurrentSessionPassword();
            String format = String.format("%s:%s", Arrays.copyOf(objArr, objArr.length));
            Intrinsics.checkExpressionValueIsNotNull(format, "java.lang.String.format(format, *args)");
            FastSearchFilterViewModel fastSearchFilterViewModel = this.viewModel;
            if (fastSearchFilterViewModel == null) {
                Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            }
            fastSearchFilterViewModel.getUpdatedFacetValues(fastSearchRequestBody, format);
            RefinerHeaderAdapter refinerHeaderAdapter2 = this.headerAdapter;
            if (refinerHeaderAdapter2 != null) {
                refinerHeaderAdapter2.setNewHeaderItemAdded(false);
            }
        }
    }

    /* access modifiers changed from: private */
    public final void resetUIForSeriesAndMakeModel() {
        FastSearchExpandableAdapter fastSearchExpandableAdapter;
        removeAllSeriesHeaderData();
        int i = 0;
        for (Object next : BDTUtils.INSTANCE.getSearchMappingArray().get(this.tabPos).getGroups()) {
            int i2 = i + 1;
            if (i < 0) {
                CollectionsKt.throwIndexOverflow();
            }
            SearchMappingGroup searchMappingGroup = (SearchMappingGroup) next;
            if (Intrinsics.areEqual((Object) searchMappingGroup.getGroup(), (Object) "Series")) {
                searchMappingGroup.setEnabled(false);
            }
            if (Intrinsics.areEqual((Object) searchMappingGroup.getGroup(), (Object) ExifInterface.TAG_MAKE)) {
                for (FacetXX selected : searchMappingGroup.getListFacet()) {
                    selected.setSelected(false);
                }
            }
            i = i2;
        }
        BDTUtils.INSTANCE.getFilterData(this.tabPos);
        int i3 = this.tabPos;
        if (i3 == 0) {
            FastSearchExpandableAdapter fastSearchExpandableAdapter2 = this.expandableListAdapterVF;
            if (fastSearchExpandableAdapter2 != null) {
                fastSearchExpandableAdapter2.notifyDataSetChanged();
            }
        } else if (i3 == 1 && (fastSearchExpandableAdapter = this.expandableListAdapterSF) != null) {
            fastSearchExpandableAdapter.notifyDataSetChanged();
        }
    }

    /* access modifiers changed from: private */
    public final void updateMappingForSeries(FastSearchResponse2 fastSearchResponse2) {
        FastSearchExpandableAdapter fastSearchExpandableAdapter;
        int i = 0;
        int i2 = -1;
        for (Object next : BDTUtils.INSTANCE.getSearchMappingArray().get(this.tabPos).getGroups()) {
            int i3 = i + 1;
            if (i < 0) {
                CollectionsKt.throwIndexOverflow();
            }
            SearchMappingGroup searchMappingGroup = (SearchMappingGroup) next;
            if (Intrinsics.areEqual((Object) searchMappingGroup.getGroup(), (Object) "Series")) {
                searchMappingGroup.getListFacet().clear();
                int i4 = 0;
                for (Object next2 : fastSearchResponse2.getSearch().getResult().getFacets()) {
                    int i5 = i4 + 1;
                    if (i4 < 0) {
                        CollectionsKt.throwIndexOverflow();
                    }
                    FacetX facetX = (FacetX) next2;
                    if (StringsKt.equals(facetX.getGroup(), searchMappingGroup.getGroup(), true) && (!facetX.getFacets().isEmpty())) {
                        searchMappingGroup.setEnabled(true);
                        searchMappingGroup.getListFacet().addAll(facetX.getFacets());
                    }
                    i4 = i5;
                }
                i2 = i;
            }
            i = i3;
        }
        BDTUtils.INSTANCE.getFilterData(this.tabPos);
        int i6 = this.tabPos;
        if (i6 == 0) {
            FastSearchExpandableAdapter fastSearchExpandableAdapter2 = this.expandableListAdapterVF;
            if (fastSearchExpandableAdapter2 != null) {
                fastSearchExpandableAdapter2.notifyDataSetChanged();
            }
            ((ExpandableListView) _$_findCachedViewById(C2723R.C2726id.expandableFilter)).collapseGroup(i2);
        } else if (i6 == 1 && (fastSearchExpandableAdapter = this.expandableListAdapterSF) != null) {
            fastSearchExpandableAdapter.notifyDataSetChanged();
        }
    }

    /* access modifiers changed from: private */
    public final void updateFilterValueForAllFacets(FastSearchResponse2 fastSearchResponse2) {
        FastSearchExpandableAdapter fastSearchExpandableAdapter;
        ArrayList<FacetXX> headerItem;
        Iterator it = BDTUtils.INSTANCE.getSearchMappingArray().iterator();
        int i = 0;
        while (true) {
            boolean z = true;
            if (!it.hasNext()) {
                break;
            }
            Object next = it.next();
            int i2 = i + 1;
            if (i < 0) {
                CollectionsKt.throwIndexOverflow();
            }
            SearchMappingArray searchMappingArray = (SearchMappingArray) next;
            if (i < 2) {
                int i3 = 0;
                for (Object next2 : searchMappingArray.getGroups()) {
                    int i4 = i3 + 1;
                    if (i3 < 0) {
                        CollectionsKt.throwIndexOverflow();
                    }
                    SearchMappingGroup searchMappingGroup = (SearchMappingGroup) next2;
                    if (!searchMappingGroup.getCustom() && !StringsKt.equals(searchMappingGroup.getGroup(), "TBOIndicator", z)) {
                        int i5 = 0;
                        for (Object next3 : fastSearchResponse2.getSearch().getResult().getFacets()) {
                            int i6 = i5 + 1;
                            if (i5 < 0) {
                                CollectionsKt.throwIndexOverflow();
                            }
                            FacetX facetX = (FacetX) next3;
                            if (StringsKt.equals(facetX.getGroup(), searchMappingGroup.getGroup(), z)) {
                                if (facetX.getFacets().isEmpty() ^ z) {
                                    if (!Intrinsics.areEqual((Object) searchMappingGroup.getGroup(), (Object) "Series") && !StringsKt.equals(searchMappingGroup.getGroup(), "BuynowRange", z)) {
                                        searchMappingGroup.setEnabled(z);
                                    }
                                    ArrayList arrayList = new ArrayList();
                                    if (!StringsKt.equals(searchMappingGroup.getGroup(), ExifInterface.TAG_MAKE, z)) {
                                        for (FacetXX facetXX : facetX.getFacets()) {
                                            facetXX.setRefinerValue(searchMappingGroup.getGroup());
                                            for (FacetXX facetXX2 : searchMappingGroup.getListFacet()) {
                                                if (Intrinsics.areEqual((Object) facetXX.getValue(), (Object) facetXX2.getValue())) {
                                                    facetXX.setSelected(facetXX2.isSelected());
                                                } else {
                                                    RefinerHeaderAdapter refinerHeaderAdapter = this.headerAdapter;
                                                    if (!(refinerHeaderAdapter == null || (headerItem = refinerHeaderAdapter.getHeaderItem()) == null)) {
                                                        for (FacetXX facetXX3 : headerItem) {
                                                            if (Intrinsics.areEqual((Object) facetXX3 != null ? facetXX3.getRefinerValue() : null, (Object) searchMappingGroup.getGroup())) {
                                                                if (Intrinsics.areEqual((Object) facetXX3 != null ? facetXX3.getValue() : null, (Object) facetXX.getValue())) {
                                                                    facetXX.setSelected(true);
                                                                }
                                                            }
                                                        }
                                                    }
                                                }
                                            }
                                            arrayList.add(facetXX);
                                        }
                                        searchMappingGroup.getListFacet().clear();
                                        searchMappingGroup.getListFacet().addAll(arrayList);
                                    }
                                } else {
                                    searchMappingGroup.setEnabled(false);
                                    i5 = i6;
                                    z = true;
                                }
                            }
                            i5 = i6;
                            z = true;
                        }
                    }
                    i3 = i4;
                    z = true;
                }
            }
            i = i2;
        }
        BDTUtils.INSTANCE.getFilterData(this.tabPos);
        int i7 = this.tabPos;
        if (i7 == 0) {
            FastSearchExpandableAdapter fastSearchExpandableAdapter2 = this.expandableListAdapterVF;
            if (fastSearchExpandableAdapter2 != null) {
                fastSearchExpandableAdapter2.notifyDataSetChanged();
            }
        } else if (i7 == 1 && (fastSearchExpandableAdapter = this.expandableListAdapterSF) != null) {
            fastSearchExpandableAdapter.notifyDataSetChanged();
        }
    }

    private final void populatePopularCategories() {
        FastSearchFilterActivity fastSearchFilterActivity2 = this.fastSearchFilterActivity;
        if (fastSearchFilterActivity2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("fastSearchFilterActivity");
        }
        this.popularCategoriesAdapter = new PopularCategoriesAdapter(fastSearchFilterActivity2);
        PopularCategoriesAdapter popularCategoriesAdapter2 = this.popularCategoriesAdapter;
        if (popularCategoriesAdapter2 != null) {
            popularCategoriesAdapter2.setQuickLinksData();
        }
        PopularCategoriesAdapter popularCategoriesAdapter3 = this.popularCategoriesAdapter;
        if (popularCategoriesAdapter3 != null) {
            popularCategoriesAdapter3.setClickListener(this.popularCategoriesItemClickListener);
        }
        RecyclerView recyclerView = (RecyclerView) _$_findCachedViewById(C2723R.C2726id.rvPopularCategories);
        Intrinsics.checkExpressionValueIsNotNull(recyclerView, "rvPopularCategories");
        FastSearchFilterActivity fastSearchFilterActivity3 = this.fastSearchFilterActivity;
        if (fastSearchFilterActivity3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("fastSearchFilterActivity");
        }
        recyclerView.setLayoutManager(new LinearLayoutManager(fastSearchFilterActivity3, 0, false));
        RecyclerView recyclerView2 = (RecyclerView) _$_findCachedViewById(C2723R.C2726id.rvPopularCategories);
        Intrinsics.checkExpressionValueIsNotNull(recyclerView2, "rvPopularCategories");
        recyclerView2.setAdapter(this.popularCategoriesAdapter);
        popularCategoriesVisibility();
        PopularCategoriesAdapter popularCategoriesAdapter4 = this.popularCategoriesAdapter;
        if (popularCategoriesAdapter4 != null) {
            popularCategoriesAdapter4.notifyDataSetChanged();
        }
    }

    private final void popularCategoriesVisibility() {
        List list = BDTUtils.INSTANCE.getExpandableListDetailPC().get(BDTUtils.INSTANCE.getSearchMappingArray().get(2).getGroups().get(0));
        if (list == null || !(!list.isEmpty())) {
            RecyclerView recyclerView = (RecyclerView) _$_findCachedViewById(C2723R.C2726id.rvPopularCategories);
            Intrinsics.checkExpressionValueIsNotNull(recyclerView, "rvPopularCategories");
            recyclerView.setVisibility(8);
            View _$_findCachedViewById = _$_findCachedViewById(C2723R.C2726id.border_popular_category);
            Intrinsics.checkExpressionValueIsNotNull(_$_findCachedViewById, "border_popular_category");
            _$_findCachedViewById.setVisibility(8);
            return;
        }
        RecyclerView recyclerView2 = (RecyclerView) _$_findCachedViewById(C2723R.C2726id.rvPopularCategories);
        Intrinsics.checkExpressionValueIsNotNull(recyclerView2, "rvPopularCategories");
        recyclerView2.setVisibility(0);
        View _$_findCachedViewById2 = _$_findCachedViewById(C2723R.C2726id.border_popular_category);
        Intrinsics.checkExpressionValueIsNotNull(_$_findCachedViewById2, "border_popular_category");
        _$_findCachedViewById2.setVisibility(0);
    }

    /* access modifiers changed from: private */
    public final void collapseAllFilter(int i) {
        int i2 = 0;
        for (Object next : BDTUtils.INSTANCE.getSearchMappingArray()) {
            int i3 = i2 + 1;
            if (i2 < 0) {
                CollectionsKt.throwIndexOverflow();
            }
            SearchMappingArray searchMappingArray = (SearchMappingArray) next;
            if (i2 < 2) {
                int i4 = 0;
                for (Object next2 : searchMappingArray.getGroups()) {
                    int i5 = i4 + 1;
                    if (i4 < 0) {
                        CollectionsKt.throwIndexOverflow();
                    }
                    SearchMappingGroup searchMappingGroup = (SearchMappingGroup) next2;
                    if (i4 != i) {
                        ((ExpandableListView) _$_findCachedViewById(C2723R.C2726id.expandableFilter)).collapseGroup(i4);
                    }
                    i4 = i5;
                }
            }
            i2 = i3;
        }
    }

    private final void updateSearchMappingArray() {
        ArrayList second;
        String refinerValue;
        if (!BDTUtils.INSTANCE.getSearchMappingArray().isEmpty()) {
            RefinerHeaderAdapter refinerHeaderAdapter = this.headerAdapter;
            Pair<ArrayList<FacetXX>, ArrayList<Triple<Integer, Integer, Integer>>> headerItemData = refinerHeaderAdapter != null ? refinerHeaderAdapter.getHeaderItemData() : null;
            if (headerItemData != null && (second = headerItemData.getSecond()) != null) {
                int i = 0;
                for (Object next : second) {
                    int i2 = i + 1;
                    if (i < 0) {
                        CollectionsKt.throwIndexOverflow();
                    }
                    Triple triple = (Triple) next;
                    FacetXX facetXX = (FacetXX) (headerItemData != null ? headerItemData.getFirst() : null).get(i);
                    int intValue = ((Number) triple.getFirst()).intValue();
                    if (!(intValue == 0 || intValue == 1)) {
                        if (intValue == 2) {
                            BDTUtils.INSTANCE.updateGlobalPopularCategoryMapping(facetXX);
                        } else if (intValue != 4) {
                        }
                        i = i2;
                    }
                    if (!(facetXX == null || (refinerValue = facetXX.getRefinerValue()) == null || StringsKt.startsWith$default(refinerValue, "keyword", false, 2, (Object) null))) {
                        String refinerValue2 = facetXX.getRefinerValue();
                        if (refinerValue2 == null || !StringsKt.startsWith(refinerValue2, "Odometer", true)) {
                            String refinerValue3 = facetXX.getRefinerValue();
                            if (refinerValue3 == null || !StringsKt.startsWith(refinerValue3, "ACV", true)) {
                                String refinerValue4 = facetXX.getRefinerValue();
                                if (refinerValue4 == null || !StringsKt.startsWith(refinerValue4, "Year", true)) {
                                    String refinerValue5 = facetXX.getRefinerValue();
                                    if (refinerValue5 == null || !StringsKt.startsWith(refinerValue5, "Distance", true)) {
                                        String refinerValue6 = facetXX.getRefinerValue();
                                        if (refinerValue6 == null || !StringsKt.startsWith(refinerValue6, "Make & Model~", true)) {
                                            BDTUtils.INSTANCE.updateGlobalFilterMapping(((Number) triple.getFirst()).intValue(), ((Number) triple.getSecond()).intValue(), ((Number) triple.getThird()).intValue(), facetXX);
                                        } else {
                                            this.lastSelectedMakeModel.add(BDTUtils.INSTANCE.updateMappingForMakeModel(((Number) triple.getFirst()).intValue(), ((Number) triple.getSecond()).intValue(), ((Number) triple.getThird()).intValue(), facetXX));
                                        }
                                    } else {
                                        BDTUtils.INSTANCE.updateGlobalFilterMappingForDistance(((Number) triple.getFirst()).intValue(), ((Number) triple.getSecond()).intValue(), ((Number) triple.getThird()).intValue(), facetXX);
                                    }
                                } else {
                                    BDTUtils.INSTANCE.updateGlobalFilterFromSS(((Number) triple.getFirst()).intValue(), ((Number) triple.getSecond()).intValue(), ((Number) triple.getThird()).intValue(), facetXX);
                                }
                            } else {
                                BDTUtils.INSTANCE.updateGlobalFilterFromSS(((Number) triple.getFirst()).intValue(), ((Number) triple.getSecond()).intValue(), ((Number) triple.getThird()).intValue(), facetXX);
                            }
                        } else {
                            BDTUtils.INSTANCE.updateGlobalFilterFromSS(((Number) triple.getFirst()).intValue(), ((Number) triple.getSecond()).intValue(), ((Number) triple.getThird()).intValue(), facetXX);
                        }
                        if (StringsKt.equals$default(facetXX.getRefinerValue(), "AuctionType", false, 2, (Object) null) && Intrinsics.areEqual((Object) facetXX.getValue(), (Object) "Buy Now")) {
                            enableBuyNowPrice(((Number) triple.getFirst()).intValue(), ((Number) triple.getSecond()).intValue());
                        }
                    }
                    i = i2;
                }
            }
        }
    }

    private final void enableBuyNowPrice(int i, int i2) {
        int i3;
        boolean z;
        FastSearchExpandableAdapter fastSearchExpandableAdapter;
        if (StringsKt.equals(BDTUtils.INSTANCE.getSearchMappingArray().get(i).getGroups().get(i2).getGroup(), "AuctionType", true)) {
            List<FacetXX> list = BDTUtils.INSTANCE.getExpandableListDetail().get(BDTUtils.INSTANCE.getSearchMappingArray().get(i).getGroups().get(i2));
            if (list != null) {
                z = false;
                for (FacetXX facetXX : list) {
                    if (StringsKt.equals(facetXX.getValue(), "Buy Now", true) && facetXX.isSelected()) {
                        z = true;
                    }
                }
            } else {
                z = false;
            }
            i3 = -1;
            int i4 = 0;
            for (Object next : BDTUtils.INSTANCE.getSearchMappingArray().get(i).getGroups()) {
                int i5 = i4 + 1;
                if (i4 < 0) {
                    CollectionsKt.throwIndexOverflow();
                }
                SearchMappingGroup searchMappingGroup = (SearchMappingGroup) next;
                if (StringsKt.equals(searchMappingGroup.getGroup(), "BuynowRange", true)) {
                    searchMappingGroup.setEnabled(z);
                    i3 = i4;
                }
                i4 = i5;
            }
        } else {
            z = false;
            i3 = -1;
        }
        if (!z && i3 != -1) {
            for (FacetXX selected : BDTUtils.INSTANCE.getSearchMappingArray().get(i).getGroups().get(i3).getListFacet()) {
                selected.setSelected(false);
            }
        }
        BDTUtils.INSTANCE.getFilterData(i);
        if (i == 0) {
            FastSearchExpandableAdapter fastSearchExpandableAdapter2 = this.expandableListAdapterVF;
            if (fastSearchExpandableAdapter2 != null) {
                fastSearchExpandableAdapter2.notifyDataSetChanged();
            }
        } else if (i == 1 && (fastSearchExpandableAdapter = this.expandableListAdapterSF) != null) {
            fastSearchExpandableAdapter.notifyDataSetChanged();
        }
    }
}

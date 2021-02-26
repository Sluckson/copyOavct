package com.iaai.android.bdt.feature.findVehiclePage.filter;

import android.app.Application;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.ExpandableListView;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.widget.Toolbar;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.exifinterface.media.ExifInterface;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.flexbox.FlexboxLayoutManager;
import com.google.gson.Gson;
import com.google.zxing.integration.android.IntentIntegrator;
import com.iaai.android.C2723R;
import com.iaai.android.IaaiApplication;
import com.iaai.android.bdt.base.BaseActivity;
import com.iaai.android.bdt.base.BaseFragment;
import com.iaai.android.bdt.extensions.Activity_ExtensionKt;
import com.iaai.android.bdt.extensions.Context_ExtensionKt;
import com.iaai.android.bdt.extensions.String_ExtensionKt;
import com.iaai.android.bdt.feature.findVehiclePage.PopularCategoryListAdapter;
import com.iaai.android.bdt.feature.findVehiclePage.filter.HeaderListAdapter;
import com.iaai.android.bdt.feature.login.SessionManager;
import com.iaai.android.bdt.feature.onBoarding.OnBoardingEnum;
import com.iaai.android.bdt.feature.productDetail.ProductDetailActivity;
import com.iaai.android.bdt.feature.viewPager.FastSearchViewModel;
import com.iaai.android.bdt.model.auctionSalesList.ClearFilter;
import com.iaai.android.bdt.model.fastSearch.MakeModelMaster;
import com.iaai.android.bdt.model.fastSearch.Refiner;
import com.iaai.android.bdt.model.fastSearch.RefinerX;
import com.iaai.android.bdt.model.fastSearch.SearchInputV2;
import com.iaai.android.bdt.model.fastSearch.SelectedRefinerV2;
import com.iaai.android.bdt.model.fastSearch.Vehicle;
import com.iaai.android.bdt.model.filter.FilterData;
import com.iaai.android.bdt.model.filter.FilterResponse;
import com.iaai.android.bdt.model.filter.FilterSubValues;
import com.iaai.android.bdt.model.filter.FilterValues;
import com.iaai.android.bdt.model.filter.MakeModelValues;
import com.iaai.android.bdt.utils.Constants_MVVM;
import com.iaai.android.bdt.utils.InternetUtil;
import com.iaai.android.old.utils.AppUtils;
import com.iaai.android.old.utils.IAASharedPreference;
import com.iaai.android.old.utils.constants.Constants;
import dagger.android.support.AndroidSupportInjection;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import kotlin.jvm.internal.TypeIntrinsics;
import kotlin.text.StringsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(mo66931bv = {1, 0, 3}, mo66932d1 = {"\u0000\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0011\n\u0000\n\u0002\u0010\u0015\n\u0002\b\u001e\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003B\u0005¢\u0006\u0002\u0010\u0004J\b\u0010`\u001a\u00020aH\u0002J \u0010b\u001a\u00020a2\u0016\u0010c\u001a\u0012\u0012\u0004\u0012\u00020;0\bj\b\u0012\u0004\u0012\u00020;`\nH\u0002J\b\u0010d\u001a\u00020aH\u0002J\b\u0010e\u001a\u00020aH\u0002J\u0010\u0010f\u001a\u00020a2\u0006\u0010g\u001a\u000205H\u0002J\b\u0010h\u001a\u00020aH\u0002J\u0016\u0010i\u001a\u0012\u0012\u0004\u0012\u00020-0jj\b\u0012\u0004\u0012\u00020-`kJ\b\u0010l\u001a\u00020aH\u0002J\u0010\u0010m\u001a\u00020\u000e2\u0006\u0010n\u001a\u00020\u000eH\u0002J\b\u0010o\u001a\u00020aH\u0002J\u000e\u0010p\u001a\u0002052\u0006\u0010q\u001a\u00020\u000eJ\u0012\u0010r\u001a\u00020a2\b\u0010s\u001a\u0004\u0018\u00010tH\u0002J\b\u0010u\u001a\u00020aH\u0002J\u0012\u0010v\u001a\u00020a2\b\u0010s\u001a\u0004\u0018\u00010tH\u0002J\b\u0010w\u001a\u00020aH\u0002J\b\u0010x\u001a\u00020aH\u0002J\b\u0010y\u001a\u000205H\u0002J\b\u0010z\u001a\u00020aH\u0002J\u0010\u0010{\u001a\u00020a2\u0006\u0010g\u001a\u000205H\u0002J\b\u0010|\u001a\u00020aH\u0002J\u0010\u0010}\u001a\u00020a2\u0006\u0010g\u001a\u000205H\u0002J\u0010\u0010~\u001a\u000202\u0006\u0010g\u001a\u000205H\u0002J\u0007\u0010\u0001\u001a\u00020J\"\u0010\u0001\u001a\u00020a2\u0017\u0010\u0001\u001a\u0012\u0012\u0004\u0012\u00020I0\bj\b\u0012\u0004\u0012\u00020I`\nH\u0002J\t\u0010\u0001\u001a\u00020aH\u0002J\u0014\u0010\u0001\u001a\u00020a2\t\u0010s\u001a\u0005\u0018\u00010\u0001H\u0002J\u0015\u0010\u0001\u001a\u00020a2\n\u0010\u0001\u001a\u0005\u0018\u00010\u0001H\u0016J%\u0010\u0001\u001a\u00020a2\u0007\u0010\u0001\u001a\u00020\u00062\u0007\u0010\u0001\u001a\u00020\u00062\b\u0010s\u001a\u0004\u0018\u00010tH\u0016J\u0013\u0010\u0001\u001a\u00020a2\b\u0010\u0001\u001a\u00030\u0001H\u0016J\u0015\u0010\u0001\u001a\u00020a2\n\u0010\u0001\u001a\u0005\u0018\u00010\u0001H\u0016J-\u0010\u0001\u001a\u0004\u0018\u0001012\b\u0010\u0001\u001a\u00030\u00012\n\u0010\u0001\u001a\u0005\u0018\u00010\u00012\n\u0010\u0001\u001a\u0005\u0018\u00010\u0001H\u0016J\u001b\u0010\u0001\u001a\u00020a2\u0007\u0010\u0001\u001a\u00020-2\u0007\u0010\u0001\u001a\u00020\u0006H\u0016J\u001b\u0010\u0001\u001a\u00020a2\u0007\u0010\u0001\u001a\u00020E2\u0007\u0010\u0001\u001a\u000205H\u0016J2\u0010\u0001\u001a\u00020a2\u0007\u0010\u0001\u001a\u00020\u00062\u000e\u0010\u0001\u001a\t\u0012\u0004\u0012\u00020\u000e0\u00012\b\u0010\u0001\u001a\u00030\u0001H\u0016¢\u0006\u0003\u0010\u0001J\t\u0010 \u0001\u001a\u00020aH\u0016J\t\u0010¡\u0001\u001a\u00020aH\u0002J\u0012\u0010¢\u0001\u001a\u00020a2\u0007\u0010£\u0001\u001a\u00020\u000eH\u0002J\u0012\u0010¤\u0001\u001a\u00020a2\u0007\u0010£\u0001\u001a\u00020\u000eH\u0002J\t\u0010¥\u0001\u001a\u00020aH\u0002J\t\u0010¦\u0001\u001a\u00020aH\u0002J\u0012\u0010§\u0001\u001a\u00020a2\u0007\u0010¨\u0001\u001a\u000205H\u0002J\t\u0010©\u0001\u001a\u00020aH\u0002J\t\u0010ª\u0001\u001a\u00020aH\u0002J\t\u0010«\u0001\u001a\u00020aH\u0002J\u0007\u0010¬\u0001\u001a\u00020aJ\u0012\u0010­\u0001\u001a\u00020\u000e2\u0007\u0010®\u0001\u001a\u00020\u000eH\u0002J\u0012\u0010¯\u0001\u001a\u00020a2\u0007\u0010°\u0001\u001a\u000205H\u0002J\u0012\u0010±\u0001\u001a\u00020a2\u0007\u0010²\u0001\u001a\u00020\u000eH\u0002J\u0012\u0010³\u0001\u001a\u00020a2\u0007\u0010´\u0001\u001a\u000205H\u0002J\u0007\u0010µ\u0001\u001a\u00020aJ\t\u0010¶\u0001\u001a\u00020aH\u0002J\t\u0010·\u0001\u001a\u00020aH\u0002J\t\u0010¸\u0001\u001a\u00020aH\u0002J\t\u0010¹\u0001\u001a\u00020aH\u0002J\b\u0010g\u001a\u00020aH\u0002J\t\u0010º\u0001\u001a\u00020aH\u0002J\t\u0010»\u0001\u001a\u00020aH\u0002R\u000e\u0010\u0005\u001a\u00020\u0006XD¢\u0006\u0002\n\u0000R\u001e\u0010\u0007\u001a\u0012\u0012\u0004\u0012\u00020\t0\bj\b\u0012\u0004\u0012\u00020\t`\nX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX.¢\u0006\u0002\n\u0000R*\u0010\r\u001a\u0012\u0012\u0004\u0012\u00020\u000e0\bj\b\u0012\u0004\u0012\u00020\u000e`\nX.¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u000e\u0010\u0013\u001a\u00020\u0014X.¢\u0006\u0002\n\u0000R*\u0010\u0015\u001a\u0012\u0012\u0004\u0012\u00020\u00160\bj\b\u0012\u0004\u0012\u00020\u0016`\nX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0010\"\u0004\b\u0018\u0010\u0012R\u000e\u0010\u0019\u001a\u00020\u0016X.¢\u0006\u0002\n\u0000RB\u0010\u001a\u001a*\u0012\u0004\u0012\u00020\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001d0\u001c0\u001bj\u0014\u0012\u0004\u0012\u00020\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001d0\u001c`\u001eX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010 \"\u0004\b!\u0010\"R\u000e\u0010#\u001a\u00020$X.¢\u0006\u0002\n\u0000R\u001a\u0010%\u001a\u00020\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b&\u0010'\"\u0004\b(\u0010)R\u000e\u0010*\u001a\u00020+X.¢\u0006\u0002\n\u0000R*\u0010,\u001a\u0012\u0012\u0004\u0012\u00020-0\bj\b\u0012\u0004\u0012\u00020-`\nX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b.\u0010\u0010\"\u0004\b/\u0010\u0012R\u000e\u00100\u001a\u000201X.¢\u0006\u0002\n\u0000R\u000e\u00102\u001a\u000203X.¢\u0006\u0002\n\u0000R\u000e\u00104\u001a\u000205X\u000e¢\u0006\u0002\n\u0000R\u000e\u00106\u001a\u000205X\u000e¢\u0006\u0002\n\u0000R\u000e\u00107\u001a\u000205X\u000e¢\u0006\u0002\n\u0000R\u000e\u00108\u001a\u000205X\u000e¢\u0006\u0002\n\u0000R\u000e\u00109\u001a\u00020\u000eX\u000e¢\u0006\u0002\n\u0000R\u001e\u0010:\u001a\u0012\u0012\u0004\u0012\u00020;0\bj\b\u0012\u0004\u0012\u00020;`\nX\u000e¢\u0006\u0002\n\u0000R\u001a\u0010<\u001a\u00020\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b=\u0010'\"\u0004\b>\u0010)R\u001e\u0010?\u001a\u0012\u0012\u0004\u0012\u00020@0\bj\b\u0012\u0004\u0012\u00020@`\nX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010A\u001a\u00020\u000eX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010B\u001a\u00020CX.¢\u0006\u0002\n\u0000R\u001e\u0010D\u001a\u0012\u0012\u0004\u0012\u00020E0\bj\b\u0012\u0004\u0012\u00020E`\nX\u000e¢\u0006\u0002\n\u0000R\u001e\u0010F\u001a\u0012\u0012\u0004\u0012\u00020;0\bj\b\u0012\u0004\u0012\u00020;`\nX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010G\u001a\u00020\u000eX\u000e¢\u0006\u0002\n\u0000R\u001e\u0010H\u001a\u0012\u0012\u0004\u0012\u00020I0\bj\b\u0012\u0004\u0012\u00020I`\nX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010J\u001a\u00020\u000eX.¢\u0006\u0002\n\u0000R6\u0010K\u001a\u001e\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020-0\u001bj\u000e\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020-`\u001eX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bL\u0010 \"\u0004\bM\u0010\"R*\u0010N\u001a\u0012\u0012\u0004\u0012\u00020-0\bj\b\u0012\u0004\u0012\u00020-`\nX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bO\u0010\u0010\"\u0004\bP\u0010\u0012R\u001e\u0010Q\u001a\u00020R8\u0006@\u0006X.¢\u0006\u000e\n\u0000\u001a\u0004\bS\u0010T\"\u0004\bU\u0010VR\u000e\u0010W\u001a\u00020\u000eX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010X\u001a\u00020YX.¢\u0006\u0002\n\u0000R\u001e\u0010Z\u001a\u00020[8\u0006@\u0006X.¢\u0006\u000e\n\u0000\u001a\u0004\b\\\u0010]\"\u0004\b^\u0010_¨\u0006¼\u0001"}, mo66933d2 = {"Lcom/iaai/android/bdt/feature/findVehiclePage/filter/FilterFragment;", "Lcom/iaai/android/bdt/base/BaseFragment;", "Lcom/iaai/android/bdt/feature/findVehiclePage/filter/HeaderListAdapter$OnHeaderItemClickListener;", "Lcom/iaai/android/bdt/feature/findVehiclePage/PopularCategoryListAdapter$OnPopularCategoryItemClickListener;", "()V", "REQ_CODE_SPEECH_INPUT", "", "clearFilterList", "Ljava/util/ArrayList;", "Lcom/iaai/android/bdt/model/auctionSalesList/ClearFilter;", "Lkotlin/collections/ArrayList;", "expandableListAdapter", "Lcom/iaai/android/bdt/feature/findVehiclePage/filter/FilterListExpandableListAdapter;", "expandableListTitle", "", "getExpandableListTitle$app_productionRelease", "()Ljava/util/ArrayList;", "setExpandableListTitle$app_productionRelease", "(Ljava/util/ArrayList;)V", "filterActivity", "Lcom/iaai/android/bdt/base/BaseActivity;", "filterDataList", "Lcom/iaai/android/bdt/model/filter/FilterData;", "getFilterDataList", "setFilterDataList", "filterDataMakeModel", "filterExpandableList", "Ljava/util/LinkedHashMap;", "", "Lcom/iaai/android/bdt/model/filter/FilterValues;", "Lkotlin/collections/LinkedHashMap;", "getFilterExpandableList$app_productionRelease", "()Ljava/util/LinkedHashMap;", "setFilterExpandableList$app_productionRelease", "(Ljava/util/LinkedHashMap;)V", "filterResponseList", "Lcom/iaai/android/bdt/model/filter/FilterResponse;", "groupPosition", "getGroupPosition", "()I", "setGroupPosition", "(I)V", "gson", "Lcom/google/gson/Gson;", "hashMapMakeModelArray", "Lcom/iaai/android/bdt/model/fastSearch/SelectedRefinerV2;", "getHashMapMakeModelArray", "setHashMapMakeModelArray", "header", "Landroid/view/View;", "headerListAdapter", "Lcom/iaai/android/bdt/feature/findVehiclePage/filter/HeaderListAdapter;", "isFromFilterPage", "", "isFromFindVehiclePage", "isFromVinScan", "isHeaderVisible", "keywordSearch", "lastSelectedMakeModel", "Lcom/iaai/android/bdt/model/filter/MakeModelValues;", "makeModelGroupPosition", "getMakeModelGroupPosition", "setMakeModelGroupPosition", "masterMakeModel", "Lcom/iaai/android/bdt/model/fastSearch/MakeModelMaster;", "nextWeek", "popularCategoryListAdapter", "Lcom/iaai/android/bdt/feature/findVehiclePage/PopularCategoryListAdapter;", "popularRefinerCategories", "Lcom/iaai/android/bdt/model/fastSearch/RefinerX;", "recentlyUsedModels", "refinerJSON", "refinerList", "Lcom/iaai/android/bdt/model/fastSearch/Refiner;", "scanValue", "selectedRefinerHashMap", "getSelectedRefinerHashMap", "setSelectedRefinerHashMap", "selectedRefinerList", "getSelectedRefinerList", "setSelectedRefinerList", "sessionManager", "Lcom/iaai/android/bdt/feature/login/SessionManager;", "getSessionManager", "()Lcom/iaai/android/bdt/feature/login/SessionManager;", "setSessionManager", "(Lcom/iaai/android/bdt/feature/login/SessionManager;)V", "thisWeek", "viewModel", "Lcom/iaai/android/bdt/feature/viewPager/FastSearchViewModel;", "viewModelFactory", "Landroidx/lifecycle/ViewModelProvider$Factory;", "getViewModelFactory", "()Landroidx/lifecycle/ViewModelProvider$Factory;", "setViewModelFactory", "(Landroidx/lifecycle/ViewModelProvider$Factory;)V", "addHeaderView", "", "addRecentlyViewModel", "makeModelValuesArray", "addSearchRefiner", "checkCameraPermission", "checkNetworkConnection", "updateSearchButtonCount", "clearAllFilters", "createSetFromHashMap", "Ljava/util/HashSet;", "Lkotlin/collections/HashSet;", "fillPopularCategory", "getDisplayName", "parent_displayName", "getMasterDataForMakeModel", "getPopularCategoriesIsSelected", "popularCategoryValue", "handleMakeModelMultiSelectRequestCode", "data", "Landroid/content/Intent;", "handlePopularCategoryVisiblty", "handleSubFilterRequestCode", "hideFilterHeader", "initFilterList", "isCameraAvailable", "loadRecentlyUsedModels", "loadRefinerData", "loadRefinerDataFromService", "loadRefinerDataIfInternetAvaliable", "makeRefinerRequestBody", "Lcom/iaai/android/bdt/model/fastSearch/SearchInputV2;", "makeVINScanRequestBody", "mapMasterMakeToRefiner", "refiners", "navigateToCameraScreen", "navigateToProductDetailPage", "Lcom/iaai/android/bdt/model/fastSearch/Vehicle;", "onActivityCreated", "savedInstanceState", "Landroid/os/Bundle;", "onActivityResult", "requestCode", "resultCode", "onAttach", "context", "Landroid/content/Context;", "onCreate", "onCreateView", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "onItemClick", "clickedItem", "position", "onPopularCategoryItemClick", "isSelect", "onRequestPermissionsResult", "permissions", "", "grantResults", "", "(I[Ljava/lang/String;[I)V", "onResume", "promptSpeechInput", "removeLastSelectItem", "makeAll", "removeMakeModelSelected", "removeRefinerSearch", "saveRecentlyUsedModels", "setApplyFilterBtn", "isClickable", "setFilterRefinersValues", "setFilterUI", "setOnClick", "setPopularCategorySelect", "showDisplayNameForPopularRefiner", "displayValue", "showEmptyState", "isShowEmptyState", "showErrorMSGPopUp", "msg", "showLoadingIndicator", "loading", "showSoftKeyboard", "splitMakeModelArrayAndUpdateMainRefinerList", "subscribeToViewModel", "subscribeToViewModelToCount", "updateLastSelectedModel", "updateSelectedRefinerHashMap", "vinScanClickListener", "app_productionRelease"}, mo66934k = 1, mo66935mv = {1, 1, 13})
/* compiled from: FilterFragment.kt */
public final class FilterFragment extends BaseFragment implements HeaderListAdapter.OnHeaderItemClickListener, PopularCategoryListAdapter.OnPopularCategoryItemClickListener {
    private final int REQ_CODE_SPEECH_INPUT = 100;
    private HashMap _$_findViewCache;
    private ArrayList<ClearFilter> clearFilterList = new ArrayList<>();
    /* access modifiers changed from: private */
    public FilterListExpandableListAdapter expandableListAdapter;
    @NotNull
    public ArrayList<String> expandableListTitle;
    /* access modifiers changed from: private */
    public BaseActivity filterActivity;
    @NotNull
    private ArrayList<FilterData> filterDataList = new ArrayList<>();
    /* access modifiers changed from: private */
    public FilterData filterDataMakeModel;
    @NotNull
    private LinkedHashMap<String, List<FilterValues>> filterExpandableList = new LinkedHashMap<>();
    private FilterResponse filterResponseList;
    private int groupPosition = -1;
    private Gson gson;
    @NotNull
    private ArrayList<SelectedRefinerV2> hashMapMakeModelArray = new ArrayList<>();
    private View header;
    /* access modifiers changed from: private */
    public HeaderListAdapter headerListAdapter;
    /* access modifiers changed from: private */
    public boolean isFromFilterPage;
    /* access modifiers changed from: private */
    public boolean isFromFindVehiclePage;
    /* access modifiers changed from: private */
    public boolean isFromVinScan;
    /* access modifiers changed from: private */
    public boolean isHeaderVisible;
    /* access modifiers changed from: private */
    public String keywordSearch = "";
    /* access modifiers changed from: private */
    public ArrayList<MakeModelValues> lastSelectedMakeModel = new ArrayList<>();
    private int makeModelGroupPosition = -1;
    private ArrayList<MakeModelMaster> masterMakeModel = new ArrayList<>();
    /* access modifiers changed from: private */
    public String nextWeek = "";
    /* access modifiers changed from: private */
    public PopularCategoryListAdapter popularCategoryListAdapter;
    private ArrayList<RefinerX> popularRefinerCategories = new ArrayList<>();
    /* access modifiers changed from: private */
    public ArrayList<MakeModelValues> recentlyUsedModels = new ArrayList<>();
    /* access modifiers changed from: private */
    public String refinerJSON = "";
    private ArrayList<Refiner> refinerList = new ArrayList<>();
    /* access modifiers changed from: private */
    public String scanValue;
    @NotNull
    private LinkedHashMap<String, SelectedRefinerV2> selectedRefinerHashMap = new LinkedHashMap<>();
    @NotNull
    private ArrayList<SelectedRefinerV2> selectedRefinerList = new ArrayList<>();
    @Inject
    @NotNull
    public SessionManager sessionManager;
    /* access modifiers changed from: private */
    public String thisWeek = "";
    private FastSearchViewModel viewModel;
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

    public static final /* synthetic */ FilterListExpandableListAdapter access$getExpandableListAdapter$p(FilterFragment filterFragment) {
        FilterListExpandableListAdapter filterListExpandableListAdapter = filterFragment.expandableListAdapter;
        if (filterListExpandableListAdapter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("expandableListAdapter");
        }
        return filterListExpandableListAdapter;
    }

    public static final /* synthetic */ BaseActivity access$getFilterActivity$p(FilterFragment filterFragment) {
        BaseActivity baseActivity = filterFragment.filterActivity;
        if (baseActivity == null) {
            Intrinsics.throwUninitializedPropertyAccessException("filterActivity");
        }
        return baseActivity;
    }

    public static final /* synthetic */ FilterData access$getFilterDataMakeModel$p(FilterFragment filterFragment) {
        FilterData filterData = filterFragment.filterDataMakeModel;
        if (filterData == null) {
            Intrinsics.throwUninitializedPropertyAccessException("filterDataMakeModel");
        }
        return filterData;
    }

    public static final /* synthetic */ HeaderListAdapter access$getHeaderListAdapter$p(FilterFragment filterFragment) {
        HeaderListAdapter headerListAdapter2 = filterFragment.headerListAdapter;
        if (headerListAdapter2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("headerListAdapter");
        }
        return headerListAdapter2;
    }

    public static final /* synthetic */ PopularCategoryListAdapter access$getPopularCategoryListAdapter$p(FilterFragment filterFragment) {
        PopularCategoryListAdapter popularCategoryListAdapter2 = filterFragment.popularCategoryListAdapter;
        if (popularCategoryListAdapter2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("popularCategoryListAdapter");
        }
        return popularCategoryListAdapter2;
    }

    public static final /* synthetic */ String access$getScanValue$p(FilterFragment filterFragment) {
        String str = filterFragment.scanValue;
        if (str == null) {
            Intrinsics.throwUninitializedPropertyAccessException("scanValue");
        }
        return str;
    }

    @NotNull
    public final ArrayList<String> getExpandableListTitle$app_productionRelease() {
        ArrayList<String> arrayList = this.expandableListTitle;
        if (arrayList == null) {
            Intrinsics.throwUninitializedPropertyAccessException("expandableListTitle");
        }
        return arrayList;
    }

    public final void setExpandableListTitle$app_productionRelease(@NotNull ArrayList<String> arrayList) {
        Intrinsics.checkParameterIsNotNull(arrayList, "<set-?>");
        this.expandableListTitle = arrayList;
    }

    @NotNull
    public final LinkedHashMap<String, List<FilterValues>> getFilterExpandableList$app_productionRelease() {
        return this.filterExpandableList;
    }

    public final void setFilterExpandableList$app_productionRelease(@NotNull LinkedHashMap<String, List<FilterValues>> linkedHashMap) {
        Intrinsics.checkParameterIsNotNull(linkedHashMap, "<set-?>");
        this.filterExpandableList = linkedHashMap;
    }

    @NotNull
    public final ArrayList<FilterData> getFilterDataList() {
        return this.filterDataList;
    }

    public final void setFilterDataList(@NotNull ArrayList<FilterData> arrayList) {
        Intrinsics.checkParameterIsNotNull(arrayList, "<set-?>");
        this.filterDataList = arrayList;
    }

    @NotNull
    public final ArrayList<SelectedRefinerV2> getSelectedRefinerList() {
        return this.selectedRefinerList;
    }

    public final void setSelectedRefinerList(@NotNull ArrayList<SelectedRefinerV2> arrayList) {
        Intrinsics.checkParameterIsNotNull(arrayList, "<set-?>");
        this.selectedRefinerList = arrayList;
    }

    @NotNull
    public final LinkedHashMap<String, SelectedRefinerV2> getSelectedRefinerHashMap() {
        return this.selectedRefinerHashMap;
    }

    public final void setSelectedRefinerHashMap(@NotNull LinkedHashMap<String, SelectedRefinerV2> linkedHashMap) {
        Intrinsics.checkParameterIsNotNull(linkedHashMap, "<set-?>");
        this.selectedRefinerHashMap = linkedHashMap;
    }

    public final int getGroupPosition() {
        return this.groupPosition;
    }

    public final void setGroupPosition(int i) {
        this.groupPosition = i;
    }

    public final int getMakeModelGroupPosition() {
        return this.makeModelGroupPosition;
    }

    public final void setMakeModelGroupPosition(int i) {
        this.makeModelGroupPosition = i;
    }

    @NotNull
    public final ArrayList<SelectedRefinerV2> getHashMapMakeModelArray() {
        return this.hashMapMakeModelArray;
    }

    public final void setHashMapMakeModelArray(@NotNull ArrayList<SelectedRefinerV2> arrayList) {
        Intrinsics.checkParameterIsNotNull(arrayList, "<set-?>");
        this.hashMapMakeModelArray = arrayList;
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

    public void onAttach(@NotNull Context context) {
        Intrinsics.checkParameterIsNotNull(context, "context");
        AndroidSupportInjection.inject(this);
        super.onAttach(context);
        FragmentActivity activity = getActivity();
        if (activity != null) {
            this.filterActivity = (BaseActivity) activity;
            if (context instanceof BaseActivity) {
                this.filterActivity = (BaseActivity) context;
                return;
            }
            return;
        }
        throw new TypeCastException("null cannot be cast to non-null type com.iaai.android.bdt.base.BaseActivity");
    }

    public void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        this.gson = new Gson();
        BaseActivity baseActivity = this.filterActivity;
        if (baseActivity == null) {
            Intrinsics.throwUninitializedPropertyAccessException("filterActivity");
        }
        FragmentActivity fragmentActivity = baseActivity;
        ViewModelProvider.Factory factory = this.viewModelFactory;
        if (factory == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModelFactory");
        }
        ViewModel viewModel2 = ViewModelProviders.m18of(fragmentActivity, factory).get(FastSearchViewModel.class);
        Intrinsics.checkExpressionValueIsNotNull(viewModel2, "ViewModelProviders.of(fi…rchViewModel::class.java)");
        this.viewModel = (FastSearchViewModel) viewModel2;
        loadRecentlyUsedModels();
    }

    public final void setPopularCategorySelect() {
        for (SelectedRefinerV2 selectedRefinerV2 : this.selectedRefinerList) {
            if (selectedRefinerV2.getQuickLink()) {
                PopularCategoryListAdapter popularCategoryListAdapter2 = this.popularCategoryListAdapter;
                if (popularCategoryListAdapter2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("popularCategoryListAdapter");
                }
                popularCategoryListAdapter2.popularCategorySelect(selectedRefinerV2.getRefinerTypeValue(), true);
            }
        }
    }

    @Nullable
    public View onCreateView(@NotNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        Intrinsics.checkParameterIsNotNull(layoutInflater, "inflater");
        ViewDataBinding inflate = DataBindingUtil.inflate(layoutInflater, C2723R.C2728layout.fragment_filter, viewGroup, false);
        Intrinsics.checkExpressionValueIsNotNull(inflate, "mBinding");
        return inflate.getRoot();
    }

    public void onActivityCreated(@Nullable Bundle bundle) {
        String str;
        super.onActivityCreated(bundle);
        int i = 0;
        setApplyFilterBtn(false);
        BaseActivity baseActivity = this.filterActivity;
        if (baseActivity == null) {
            Intrinsics.throwUninitializedPropertyAccessException("filterActivity");
        }
        String refinerJson = IAASharedPreference.getRefinerJson(baseActivity);
        Intrinsics.checkExpressionValueIsNotNull(refinerJson, "IAASharedPreference.getRefinerJson(filterActivity)");
        this.refinerJSON = refinerJson;
        Bundle arguments = getArguments();
        this.isFromFilterPage = arguments != null ? arguments.getBoolean(Constants_MVVM.EXTRA_IS_FILTERPAGE, false) : false;
        Bundle arguments2 = getArguments();
        this.isFromFindVehiclePage = arguments2 != null ? arguments2.getBoolean(Constants_MVVM.EXTRA_IS_FROM_FIND_VEHICLE_PAGE, false) : false;
        Bundle arguments3 = getArguments();
        if (arguments3 == null || (str = arguments3.getString(Constants_MVVM.EXTRA_SEARCH_INPUT_KEY, "")) == null) {
            str = "";
        }
        this.keywordSearch = str;
        Bundle arguments4 = getArguments();
        if (arguments4 != null) {
            i = arguments4.getInt(Constants_MVVM.EXTRA_MAKE_MODEL_GROUP_POSITION, 0);
        }
        this.makeModelGroupPosition = i;
        BaseActivity baseActivity2 = this.filterActivity;
        if (baseActivity2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("filterActivity");
        }
        IAASharedPreference.setRefinerSearch(baseActivity2, this.keywordSearch);
        Bundle arguments5 = getArguments();
        ArrayList<SelectedRefinerV2> arrayList = null;
        ArrayList<SelectedRefinerV2> parcelableArrayList = arguments5 != null ? arguments5.getParcelableArrayList(Constants_MVVM.EXTRA_SELECTED_FILTER_DATA) : null;
        Bundle arguments6 = getArguments();
        if (arguments6 != null) {
            arrayList = arguments6.getParcelableArrayList(Constants_MVVM.EXTRA_SELECTED_MAKE_MODEL_DATA);
        }
        if (parcelableArrayList != null) {
            this.selectedRefinerList = parcelableArrayList;
        }
        if (arrayList != null) {
            this.hashMapMakeModelArray = arrayList;
        }
        addSearchRefiner();
        if (!this.hashMapMakeModelArray.isEmpty()) {
            updateLastSelectedModel();
        }
        if (!this.isFromFilterPage) {
            setApplyFilterBtn(true);
        }
        updateSelectedRefinerHashMap();
        hideFilterHeader();
        loadRefinerDataFromService();
        vinScanClickListener();
        setOnClick();
    }

    private final void updateLastSelectedModel() {
        this.lastSelectedMakeModel.clear();
        for (SelectedRefinerV2 refinerTypeValue : this.hashMapMakeModelArray) {
            List split$default = StringsKt.split$default((CharSequence) refinerTypeValue.getRefinerTypeValue(), new char[]{'~'}, false, 0, 6, (Object) null);
            if (split$default.size() == 3) {
                this.lastSelectedMakeModel.add(new MakeModelValues((String) split$default.get(2), "", false, new MakeModelValues((String) split$default.get(1), "", true, (MakeModelValues) null, 0, false), 0, true));
            } else if (split$default.size() == 2) {
                String str = (String) split$default.get(1);
                MakeModelValues makeModelValues = new MakeModelValues(str, "", true, (MakeModelValues) null, 0, false);
                this.lastSelectedMakeModel.add(new MakeModelValues("All " + str, "", true, makeModelValues, 0, true));
            }
        }
    }

    private final void addSearchRefiner() {
        if (!StringsKt.isBlank(this.keywordSearch)) {
            ArrayList arrayList = new ArrayList();
            arrayList.add(this.keywordSearch);
            this.selectedRefinerList.add(new SelectedRefinerV2("RefinerSearch", arrayList, false, 4, (DefaultConstructorMarker) null));
        }
    }

    private final void updateSelectedRefinerHashMap() {
        this.selectedRefinerHashMap.clear();
        for (SelectedRefinerV2 selectedRefinerV2 : this.selectedRefinerList) {
            if (!StringsKt.equals(selectedRefinerV2.getRefinerTypeValue(), "make", true) && !StringsKt.equals(selectedRefinerV2.getRefinerTypeValue(), "model", true)) {
                this.selectedRefinerHashMap.put(selectedRefinerV2.getRefinerTypeValue(), selectedRefinerV2);
            }
        }
        if (!this.hashMapMakeModelArray.isEmpty()) {
            for (SelectedRefinerV2 selectedRefinerV22 : this.hashMapMakeModelArray) {
                this.selectedRefinerHashMap.put(selectedRefinerV22.getRefinerTypeValue(), selectedRefinerV22);
            }
        }
    }

    private final void fillPopularCategory() {
        BaseActivity baseActivity = this.filterActivity;
        if (baseActivity == null) {
            Intrinsics.throwUninitializedPropertyAccessException("filterActivity");
        }
        this.popularCategoryListAdapter = new PopularCategoryListAdapter(baseActivity);
        PopularCategoryListAdapter popularCategoryListAdapter2 = this.popularCategoryListAdapter;
        if (popularCategoryListAdapter2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("popularCategoryListAdapter");
        }
        popularCategoryListAdapter2.setPopularCategoryListData(this.popularRefinerCategories);
        PopularCategoryListAdapter popularCategoryListAdapter3 = this.popularCategoryListAdapter;
        if (popularCategoryListAdapter3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("popularCategoryListAdapter");
        }
        popularCategoryListAdapter3.setClickListener(this);
        RecyclerView recyclerView = (RecyclerView) _$_findCachedViewById(C2723R.C2726id.rvPopularCategories);
        Intrinsics.checkExpressionValueIsNotNull(recyclerView, "rvPopularCategories");
        BaseActivity baseActivity2 = this.filterActivity;
        if (baseActivity2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("filterActivity");
        }
        recyclerView.setLayoutManager(new LinearLayoutManager(baseActivity2, 0, false));
        RecyclerView recyclerView2 = (RecyclerView) _$_findCachedViewById(C2723R.C2726id.rvPopularCategories);
        Intrinsics.checkExpressionValueIsNotNull(recyclerView2, "rvPopularCategories");
        PopularCategoryListAdapter popularCategoryListAdapter4 = this.popularCategoryListAdapter;
        if (popularCategoryListAdapter4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("popularCategoryListAdapter");
        }
        recyclerView2.setAdapter(popularCategoryListAdapter4);
        handlePopularCategoryVisiblty();
        PopularCategoryListAdapter popularCategoryListAdapter5 = this.popularCategoryListAdapter;
        if (popularCategoryListAdapter5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("popularCategoryListAdapter");
        }
        popularCategoryListAdapter5.notifyDataSetChanged();
        setPopularCategorySelect();
    }

    private final void handlePopularCategoryVisiblty() {
        if (this.popularRefinerCategories.size() > 0) {
            RecyclerView recyclerView = (RecyclerView) _$_findCachedViewById(C2723R.C2726id.rvPopularCategories);
            Intrinsics.checkExpressionValueIsNotNull(recyclerView, "rvPopularCategories");
            recyclerView.setVisibility(0);
            View _$_findCachedViewById = _$_findCachedViewById(C2723R.C2726id.border_popular_category);
            Intrinsics.checkExpressionValueIsNotNull(_$_findCachedViewById, "border_popular_category");
            _$_findCachedViewById.setVisibility(0);
            return;
        }
        RecyclerView recyclerView2 = (RecyclerView) _$_findCachedViewById(C2723R.C2726id.rvPopularCategories);
        Intrinsics.checkExpressionValueIsNotNull(recyclerView2, "rvPopularCategories");
        recyclerView2.setVisibility(8);
        View _$_findCachedViewById2 = _$_findCachedViewById(C2723R.C2726id.border_popular_category);
        Intrinsics.checkExpressionValueIsNotNull(_$_findCachedViewById2, "border_popular_category");
        _$_findCachedViewById2.setVisibility(8);
    }

    private final void hideFilterHeader() {
        if (this.isFromFilterPage) {
            ConstraintLayout constraintLayout = (ConstraintLayout) _$_findCachedViewById(C2723R.C2726id.clSearchContainer);
            Intrinsics.checkExpressionValueIsNotNull(constraintLayout, "clSearchContainer");
            constraintLayout.setVisibility(8);
            View _$_findCachedViewById = _$_findCachedViewById(C2723R.C2726id.borderBottomClearFilter);
            Intrinsics.checkExpressionValueIsNotNull(_$_findCachedViewById, "borderBottomClearFilter");
            _$_findCachedViewById.setVisibility(8);
            TextView textView = (TextView) _$_findCachedViewById(C2723R.C2726id.tv_applyfilter);
            Intrinsics.checkExpressionValueIsNotNull(textView, "tv_applyfilter");
            textView.setText(getResources().getString(C2723R.string.lbl_bdt_apply_filter));
            return;
        }
        Toolbar toolbar = (Toolbar) _$_findCachedViewById(C2723R.C2726id.toolbar);
        Intrinsics.checkExpressionValueIsNotNull(toolbar, "toolbar");
        toolbar.setVisibility(8);
        ConstraintLayout constraintLayout2 = (ConstraintLayout) _$_findCachedViewById(C2723R.C2726id.clSearchContainer);
        Intrinsics.checkExpressionValueIsNotNull(constraintLayout2, "clSearchContainer");
        constraintLayout2.setVisibility(0);
        View _$_findCachedViewById2 = _$_findCachedViewById(C2723R.C2726id.borderBottomClearFilter);
        Intrinsics.checkExpressionValueIsNotNull(_$_findCachedViewById2, "borderBottomClearFilter");
        _$_findCachedViewById2.setVisibility(0);
    }

    private final void vinScanClickListener() {
        BaseActivity baseActivity = this.filterActivity;
        if (baseActivity == null) {
            Intrinsics.throwUninitializedPropertyAccessException("filterActivity");
        }
        ((TextView) baseActivity._$_findCachedViewById(C2723R.C2726id.tvScanLabel)).setOnClickListener(new FilterFragment$vinScanClickListener$1(this));
        BaseActivity baseActivity2 = this.filterActivity;
        if (baseActivity2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("filterActivity");
        }
        ((ImageView) baseActivity2._$_findCachedViewById(C2723R.C2726id.imgScan)).setOnClickListener(new FilterFragment$vinScanClickListener$2(this));
    }

    private final void loadRefinerDataFromService() {
        LinearLayout linearLayout = (LinearLayout) _$_findCachedViewById(C2723R.C2726id.emptyRecyclerView);
        Intrinsics.checkExpressionValueIsNotNull(linearLayout, "emptyRecyclerView");
        linearLayout.setVisibility(8);
        showLoadingIndicator(true);
        if (!this.isFromFilterPage) {
            TextView textView = (TextView) _$_findCachedViewById(C2723R.C2726id.tv_applyfilter);
            Intrinsics.checkExpressionValueIsNotNull(textView, "tv_applyfilter");
            textView.setText(getResources().getString(C2723R.string.see_results, new Object[]{"#"}));
        }
        subscribeToViewModel();
        if (!IaaiApplication.loadRefinerFirstTime) {
            BaseActivity baseActivity = this.filterActivity;
            if (baseActivity == null) {
                Intrinsics.throwUninitializedPropertyAccessException("filterActivity");
            }
            if (!Activity_ExtensionKt.isHourOverForRefiner(baseActivity)) {
                setFilterUI();
                showLoadingIndicator(false);
                if (!this.isFromFilterPage) {
                    loadRefinerData(true);
                }
                subscribeToViewModelToCount();
            }
        }
        loadRefinerData(false);
        subscribeToViewModelToCount();
    }

    private final void loadRefinerData(boolean z) {
        checkNetworkConnection(z);
    }

    /* access modifiers changed from: private */
    public final void loadRefinerDataIfInternetAvaliable(boolean z) {
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
        if (this.isFromVinScan) {
            FastSearchViewModel fastSearchViewModel = this.viewModel;
            if (fastSearchViewModel == null) {
                Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            }
            BaseActivity baseActivity = this.filterActivity;
            if (baseActivity == null) {
                Intrinsics.throwUninitializedPropertyAccessException("filterActivity");
            }
            String deviceId = AppUtils.getDeviceId(baseActivity);
            Intrinsics.checkExpressionValueIsNotNull(deviceId, "AppUtils.getDeviceId(filterActivity)");
            fastSearchViewModel.loadFastSearchListV2(format, deviceId, makeVINScanRequestBody(), z);
            return;
        }
        FastSearchViewModel fastSearchViewModel2 = this.viewModel;
        if (fastSearchViewModel2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        }
        BaseActivity baseActivity2 = this.filterActivity;
        if (baseActivity2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("filterActivity");
        }
        String deviceId2 = AppUtils.getDeviceId(baseActivity2);
        Intrinsics.checkExpressionValueIsNotNull(deviceId2, "AppUtils.getDeviceId(filterActivity)");
        fastSearchViewModel2.loadFastSearchListV2(format, deviceId2, makeRefinerRequestBody(z), z);
    }

    private final void checkNetworkConnection(boolean z) {
        if (InternetUtil.INSTANCE.isInternetOn()) {
            loadRefinerDataIfInternetAvaliable(z);
            return;
        }
        showLoadingIndicator(false);
        if (!z) {
            showEmptyState(true);
        }
        InternetUtil.INSTANCE.observe(this, new FilterFragment$checkNetworkConnection$1(this, z));
    }

    private final void showEmptyState(boolean z) {
        if (z) {
            LinearLayout linearLayout = (LinearLayout) _$_findCachedViewById(C2723R.C2726id.emptyRecyclerView);
            Intrinsics.checkExpressionValueIsNotNull(linearLayout, "emptyRecyclerView");
            linearLayout.setVisibility(0);
            displayError(BaseFragment.ErrorType.NO_INTERNET, "");
            return;
        }
        LinearLayout linearLayout2 = (LinearLayout) _$_findCachedViewById(C2723R.C2726id.emptyRecyclerView);
        Intrinsics.checkExpressionValueIsNotNull(linearLayout2, "emptyRecyclerView");
        linearLayout2.setVisibility(8);
    }

    private final void subscribeToViewModel() {
        FastSearchViewModel fastSearchViewModel = this.viewModel;
        if (fastSearchViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        }
        LifecycleOwner lifecycleOwner = this;
        fastSearchViewModel.getFastSearchListResult().observe(lifecycleOwner, new FilterFragment$subscribeToViewModel$1(this));
        FastSearchViewModel fastSearchViewModel2 = this.viewModel;
        if (fastSearchViewModel2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        }
        fastSearchViewModel2.getFastSearchListError().observe(lifecycleOwner, new FilterFragment$subscribeToViewModel$2(this));
    }

    /* access modifiers changed from: private */
    public final void showErrorMSGPopUp(String str) {
        BaseActivity baseActivity = this.filterActivity;
        if (baseActivity == null) {
            Intrinsics.throwUninitializedPropertyAccessException("filterActivity");
        }
        AlertDialog.Builder builder = new AlertDialog.Builder(baseActivity);
        builder.setMessage((CharSequence) str);
        builder.setPositiveButton((CharSequence) "Ok", (DialogInterface.OnClickListener) FilterFragment$showErrorMSGPopUp$1.INSTANCE);
        builder.show();
    }

    private final void subscribeToViewModelToCount() {
        FastSearchViewModel fastSearchViewModel = this.viewModel;
        if (fastSearchViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        }
        fastSearchViewModel.getFastSearchResultCount().observe(this, new FilterFragment$subscribeToViewModelToCount$1(this));
    }

    /* access modifiers changed from: private */
    public final void setFilterUI() {
        Context context;
        fillPopularCategory();
        if (this.refinerJSON.length() > 0) {
            Gson gson2 = this.gson;
            if (gson2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("gson");
            }
            Object fromJson = gson2.fromJson(this.refinerJSON, new FilterFragment$setFilterUI$1().getType());
            Intrinsics.checkExpressionValueIsNotNull(fromJson, "gson.fromJson(refinerJSO…List<Refiner>>() {}.type)");
            this.refinerList = (ArrayList) fromJson;
        }
        mapMasterMakeToRefiner(this.refinerList);
        setFilterRefinersValues();
        initFilterList();
        Boolean isFirstLaunchFindVehicles = IAASharedPreference.getIsFirstLaunchFindVehicles(getContext());
        Intrinsics.checkExpressionValueIsNotNull(isFirstLaunchFindVehicles, "isFirstLaunch");
        if (isFirstLaunchFindVehicles.booleanValue() && (context = getContext()) != null) {
            Context_ExtensionKt.launchOnBoardingScreen(context, OnBoardingEnum.FIND_VEHICLES);
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:73:0x023c, code lost:
        if (com.iaai.android.bdt.extensions.Activity_ExtensionKt.isHourOverForRefiner(r3) != false) goto L_0x023e;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final com.iaai.android.bdt.model.fastSearch.SearchInputV2 makeRefinerRequestBody(boolean r17) {
        /*
            r16 = this;
            r0 = r16
            java.util.ArrayList r1 = new java.util.ArrayList
            r1.<init>()
            java.util.ArrayList r2 = new java.util.ArrayList
            r2.<init>()
            java.util.ArrayList r3 = new java.util.ArrayList
            r3.<init>()
            java.util.ArrayList r4 = new java.util.ArrayList
            r4.<init>()
            r5 = 0
            r6 = 1
            if (r17 == 0) goto L_0x001f
            r16.splitMakeModelArrayAndUpdateMainRefinerList()
            r12 = 0
            goto L_0x0020
        L_0x001f:
            r12 = 1
        L_0x0020:
            java.util.ArrayList<com.iaai.android.bdt.model.fastSearch.SelectedRefinerV2> r7 = r0.selectedRefinerList
            java.lang.Iterable r7 = (java.lang.Iterable) r7
            java.util.Iterator r7 = r7.iterator()
        L_0x0028:
            boolean r8 = r7.hasNext()
            java.lang.String r9 = "model"
            java.lang.String r10 = "make"
            java.lang.String r11 = ""
            java.lang.String r13 = "readyforbid"
            if (r8 == 0) goto L_0x01cf
            java.lang.Object r8 = r7.next()
            com.iaai.android.bdt.model.fastSearch.SelectedRefinerV2 r8 = (com.iaai.android.bdt.model.fastSearch.SelectedRefinerV2) r8
            java.lang.String r14 = r8.getRefinerTypeValue()
            java.lang.String r15 = "Assigned Vehicles"
            boolean r14 = kotlin.text.StringsKt.equals(r14, r15, r6)
            java.lang.String r6 = "false"
            if (r14 == 0) goto L_0x0087
            java.util.ArrayList r9 = new java.util.ArrayList
            r9.<init>()
            java.util.List r10 = r8.getRefinerValue()
            java.lang.Object r10 = r10.get(r5)
            java.lang.String r10 = (java.lang.String) r10
            java.lang.String r14 = "All Vehicles"
            r15 = 1
            boolean r10 = kotlin.text.StringsKt.equals(r10, r14, r15)
            if (r10 == 0) goto L_0x0065
            r9.add(r11)
        L_0x0065:
            java.util.List r8 = r8.getRefinerValue()
            java.lang.Object r8 = r8.get(r5)
            java.lang.String r8 = (java.lang.String) r8
            java.lang.String r10 = "All Unassigned Vehicles"
            boolean r8 = kotlin.text.StringsKt.equals(r8, r10, r15)
            if (r8 == 0) goto L_0x007a
            r9.add(r6)
        L_0x007a:
            com.iaai.android.bdt.model.fastSearch.RequestSelectedRefiner r6 = new com.iaai.android.bdt.model.fastSearch.RequestSelectedRefiner
            java.util.List r9 = (java.util.List) r9
            r6.<init>(r13, r9)
            r1.add(r6)
        L_0x0084:
            r6 = 0
            goto L_0x01cb
        L_0x0087:
            java.lang.String r11 = r8.getRefinerTypeValue()
            java.lang.String r14 = "Vehicle Assignment"
            r5 = 1
            boolean r11 = kotlin.text.StringsKt.equals(r11, r14, r5)
            java.lang.String r5 = "true"
            if (r11 == 0) goto L_0x00be
            java.util.ArrayList r9 = new java.util.ArrayList
            r9.<init>()
            java.util.List r8 = r8.getRefinerValue()
            r10 = 0
            java.lang.Object r8 = r8.get(r10)
            java.lang.String r8 = (java.lang.String) r8
            boolean r8 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r8, (java.lang.Object) r15)
            if (r8 == 0) goto L_0x00b0
            r9.add(r5)
            goto L_0x00b3
        L_0x00b0:
            r9.add(r6)
        L_0x00b3:
            com.iaai.android.bdt.model.fastSearch.RequestSelectedRefiner r5 = new com.iaai.android.bdt.model.fastSearch.RequestSelectedRefiner
            java.util.List r9 = (java.util.List) r9
            r5.<init>(r13, r9)
            r1.add(r5)
            goto L_0x0084
        L_0x00be:
            java.lang.String r6 = r8.getRefinerTypeValue()
            java.lang.String r11 = "Auction Week"
            r13 = 1
            boolean r6 = kotlin.text.StringsKt.equals(r6, r11, r13)
            if (r6 == 0) goto L_0x011c
            java.util.ArrayList r5 = new java.util.ArrayList
            r5.<init>()
            java.util.List r6 = r8.getRefinerValue()
            r9 = 0
            java.lang.Object r6 = r6.get(r9)
            java.lang.String r6 = (java.lang.String) r6
            java.lang.String r10 = "This Week"
            boolean r6 = kotlin.text.StringsKt.equals(r6, r10, r13)
            if (r6 == 0) goto L_0x00e9
            java.lang.String r6 = r0.thisWeek
            r5.add(r6)
            goto L_0x010c
        L_0x00e9:
            java.util.List r6 = r8.getRefinerValue()
            java.lang.Object r6 = r6.get(r9)
            java.lang.String r6 = (java.lang.String) r6
            java.lang.String r10 = "Next Week"
            boolean r6 = kotlin.text.StringsKt.equals(r6, r10, r13)
            if (r6 == 0) goto L_0x0101
            java.lang.String r6 = r0.nextWeek
            r5.add(r6)
            goto L_0x010c
        L_0x0101:
            java.util.List r6 = r8.getRefinerValue()
            java.lang.Object r6 = r6.get(r9)
            r5.add(r6)
        L_0x010c:
            com.iaai.android.bdt.model.fastSearch.RequestSelectedRefiner r6 = new com.iaai.android.bdt.model.fastSearch.RequestSelectedRefiner
            java.lang.String r8 = r8.getRefinerTypeValue()
            java.util.List r5 = (java.util.List) r5
            r6.<init>(r8, r5)
            r1.add(r6)
            goto L_0x0084
        L_0x011c:
            java.lang.String r6 = r8.getRefinerTypeValue()
            java.lang.String r11 = "Remarketing Seller"
            r13 = 1
            boolean r6 = kotlin.text.StringsKt.equals(r6, r11, r13)
            if (r6 == 0) goto L_0x0139
            com.iaai.android.bdt.model.fastSearch.RequestSelectedRefiner r5 = new com.iaai.android.bdt.model.fastSearch.RequestSelectedRefiner
            java.util.List r6 = r8.getRefinerValue()
            java.lang.String r8 = "vrdprovider"
            r5.<init>(r8, r6)
            r1.add(r5)
            goto L_0x0084
        L_0x0139:
            java.lang.String r6 = r8.getRefinerTypeValue()
            java.lang.String r11 = "Title Status"
            boolean r6 = kotlin.text.StringsKt.equals(r6, r11, r13)
            if (r6 == 0) goto L_0x016e
            java.util.ArrayList r6 = new java.util.ArrayList
            r6.<init>()
            java.util.List r8 = r8.getRefinerValue()
            r9 = 0
            java.lang.Object r8 = r8.get(r9)
            java.lang.String r8 = (java.lang.String) r8
            java.lang.String r9 = "Title Available"
            boolean r8 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r8, (java.lang.Object) r9)
            if (r8 == 0) goto L_0x0160
            r6.add(r5)
        L_0x0160:
            com.iaai.android.bdt.model.fastSearch.RequestSelectedRefiner r5 = new com.iaai.android.bdt.model.fastSearch.RequestSelectedRefiner
            java.util.List r6 = (java.util.List) r6
            java.lang.String r8 = "tboindicator"
            r5.<init>(r8, r6)
            r1.add(r5)
            goto L_0x0084
        L_0x016e:
            boolean r5 = r8.getQuickLink()
            if (r5 == 0) goto L_0x0181
            java.util.List r5 = r8.getRefinerValue()
            r6 = 0
            java.lang.Object r5 = r5.get(r6)
            r2.add(r5)
            goto L_0x01cb
        L_0x0181:
            r6 = 0
            java.lang.String r5 = r8.getRefinerTypeValue()
            r11 = 1
            boolean r5 = kotlin.text.StringsKt.startsWith(r5, r10, r11)
            if (r5 == 0) goto L_0x0199
            java.util.List r5 = r8.getRefinerValue()
            java.lang.Object r5 = r5.get(r6)
            r3.add(r5)
            goto L_0x01cb
        L_0x0199:
            java.lang.String r5 = r8.getRefinerTypeValue()
            boolean r5 = kotlin.text.StringsKt.startsWith(r5, r9, r11)
            if (r5 == 0) goto L_0x01af
            java.util.List r5 = r8.getRefinerValue()
            java.lang.Object r5 = r5.get(r6)
            r4.add(r5)
            goto L_0x01cb
        L_0x01af:
            java.lang.String r5 = r8.getRefinerTypeValue()
            java.lang.String r9 = "RefinerSearch"
            boolean r5 = kotlin.text.StringsKt.equals(r5, r9, r11)
            if (r5 != 0) goto L_0x01cb
            com.iaai.android.bdt.model.fastSearch.RequestSelectedRefiner r5 = new com.iaai.android.bdt.model.fastSearch.RequestSelectedRefiner
            java.lang.String r9 = r8.getRefinerTypeValue()
            java.util.List r8 = r8.getRefinerValue()
            r5.<init>(r9, r8)
            r1.add(r5)
        L_0x01cb:
            r5 = 0
            r6 = 1
            goto L_0x0028
        L_0x01cf:
            if (r12 == 0) goto L_0x01e3
            com.iaai.android.bdt.model.fastSearch.RequestSelectedRefiner r5 = new com.iaai.android.bdt.model.fastSearch.RequestSelectedRefiner
            java.lang.String[] r6 = new java.lang.String[]{r11}
            java.util.ArrayList r6 = kotlin.collections.CollectionsKt.arrayListOf(r6)
            java.util.List r6 = (java.util.List) r6
            r5.<init>(r13, r6)
            r1.add(r5)
        L_0x01e3:
            r5 = r2
            java.util.Collection r5 = (java.util.Collection) r5
            boolean r5 = r5.isEmpty()
            r6 = 1
            r5 = r5 ^ r6
            if (r5 == 0) goto L_0x01fa
            com.iaai.android.bdt.model.fastSearch.RequestSelectedRefiner r5 = new com.iaai.android.bdt.model.fastSearch.RequestSelectedRefiner
            java.util.List r2 = (java.util.List) r2
            java.lang.String r6 = "quicklinks"
            r5.<init>(r6, r2)
            r1.add(r5)
        L_0x01fa:
            r2 = r3
            java.util.Collection r2 = (java.util.Collection) r2
            boolean r2 = r2.isEmpty()
            r5 = 1
            r2 = r2 ^ r5
            if (r2 == 0) goto L_0x020f
            com.iaai.android.bdt.model.fastSearch.RequestSelectedRefiner r2 = new com.iaai.android.bdt.model.fastSearch.RequestSelectedRefiner
            java.util.List r3 = (java.util.List) r3
            r2.<init>(r10, r3)
            r1.add(r2)
        L_0x020f:
            r2 = r4
            java.util.Collection r2 = (java.util.Collection) r2
            boolean r2 = r2.isEmpty()
            r3 = 1
            r2 = r2 ^ r3
            if (r2 == 0) goto L_0x0224
            com.iaai.android.bdt.model.fastSearch.RequestSelectedRefiner r2 = new com.iaai.android.bdt.model.fastSearch.RequestSelectedRefiner
            java.util.List r4 = (java.util.List) r4
            r2.<init>(r9, r4)
            r1.add(r2)
        L_0x0224:
            java.util.ArrayList r2 = new java.util.ArrayList
            r2.<init>()
            boolean r3 = com.iaai.android.IaaiApplication.loadRefinerFirstTime
            if (r3 != 0) goto L_0x023e
            com.iaai.android.bdt.base.BaseActivity r3 = r0.filterActivity
            if (r3 != 0) goto L_0x0236
            java.lang.String r4 = "filterActivity"
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r4)
        L_0x0236:
            androidx.appcompat.app.AppCompatActivity r3 = (androidx.appcompat.app.AppCompatActivity) r3
            boolean r3 = com.iaai.android.bdt.extensions.Activity_ExtensionKt.isHourOverForRefiner(r3)
            if (r3 == 0) goto L_0x0255
        L_0x023e:
            if (r12 == 0) goto L_0x0255
            com.iaai.android.bdt.model.fastSearch.SearchInputV2 r3 = new com.iaai.android.bdt.model.fastSearch.SearchInputV2
            r8 = 1
            r13 = r1
            java.util.List r13 = (java.util.List) r13
            r14 = r2
            java.util.List r14 = (java.util.List) r14
            r15 = 1
            java.lang.String r9 = ""
            java.lang.String r10 = ""
            java.lang.String r11 = ""
            r7 = r3
            r7.<init>(r8, r9, r10, r11, r12, r13, r14, r15)
            return r3
        L_0x0255:
            com.iaai.android.bdt.model.fastSearch.SearchInputV2 r3 = new com.iaai.android.bdt.model.fastSearch.SearchInputV2
            r8 = 1
            java.lang.String r9 = r0.keywordSearch
            r13 = r1
            java.util.List r13 = (java.util.List) r13
            r14 = r2
            java.util.List r14 = (java.util.List) r14
            r15 = 1
            java.lang.String r10 = ""
            java.lang.String r11 = ""
            r7 = r3
            r7.<init>(r8, r9, r10, r11, r12, r13, r14, r15)
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.iaai.android.bdt.feature.findVehiclePage.filter.FilterFragment.makeRefinerRequestBody(boolean):com.iaai.android.bdt.model.fastSearch.SearchInputV2");
    }

    @NotNull
    public final SearchInputV2 makeVINScanRequestBody() {
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        String str = this.scanValue;
        if (str == null) {
            Intrinsics.throwUninitializedPropertyAccessException("scanValue");
        }
        return new SearchInputV2(1, str, "", "", true, arrayList, arrayList2, 1);
    }

    /* access modifiers changed from: private */
    public final void showLoadingIndicator(boolean z) {
        if (z) {
            ProgressBar progressBar = (ProgressBar) _$_findCachedViewById(C2723R.C2726id.pbLoadingFilterList);
            Intrinsics.checkExpressionValueIsNotNull(progressBar, "pbLoadingFilterList");
            progressBar.setVisibility(0);
            return;
        }
        ProgressBar progressBar2 = (ProgressBar) _$_findCachedViewById(C2723R.C2726id.pbLoadingFilterList);
        Intrinsics.checkExpressionValueIsNotNull(progressBar2, "pbLoadingFilterList");
        progressBar2.setVisibility(8);
    }

    private final void setOnClick() {
        ((ImageButton) _$_findCachedViewById(C2723R.C2726id.img_back)).setOnClickListener(new FilterFragment$setOnClick$1(this));
        ((LinearLayout) _$_findCachedViewById(C2723R.C2726id.ll_applyFilter_container)).setOnClickListener(new FilterFragment$setOnClick$2(this));
        ((TextView) _$_findCachedViewById(C2723R.C2726id.tvClearFilter)).setOnClickListener(new FilterFragment$setOnClick$3(this));
        ((TextView) _$_findCachedViewById(C2723R.C2726id.tvClearFilterFindVehicle)).setOnClickListener(new FilterFragment$setOnClick$4(this));
        ((TextView) _$_findCachedViewById(C2723R.C2726id.filterFragmentSearch)).addTextChangedListener(new FilterFragment$setOnClick$5(this));
        ((ImageButton) _$_findCachedViewById(C2723R.C2726id.img_voice_text)).setOnClickListener(new FilterFragment$setOnClick$6(this));
        ((ImageButton) _$_findCachedViewById(C2723R.C2726id.img_clear_text)).setOnClickListener(new FilterFragment$setOnClick$7(this));
        ((ConstraintLayout) _$_findCachedViewById(C2723R.C2726id.clSearchContainer)).setOnClickListener(new FilterFragment$setOnClick$8(this));
    }

    /* access modifiers changed from: private */
    public final void splitMakeModelArrayAndUpdateMainRefinerList() {
        this.selectedRefinerList.clear();
        boolean z = false;
        for (Map.Entry entry : this.selectedRefinerHashMap.entrySet()) {
            String str = (String) entry.getKey();
            SelectedRefinerV2 selectedRefinerV2 = (SelectedRefinerV2) entry.getValue();
            System.out.println(str + " = " + selectedRefinerV2);
            if (!StringsKt.startsWith(str, "Make & Model", true)) {
                this.selectedRefinerList.add(selectedRefinerV2);
            } else if (!z) {
                for (SelectedRefinerV2 refinerTypeValue : this.hashMapMakeModelArray) {
                    List split$default = StringsKt.split$default((CharSequence) refinerTypeValue.getRefinerTypeValue(), new char[]{'~'}, false, 0, 6, (Object) null);
                    if (split$default.size() == 3) {
                        ArrayList arrayList = new ArrayList();
                        arrayList.add((String) split$default.get(1));
                        this.selectedRefinerList.add(new SelectedRefinerV2("make", arrayList, false, 4, (DefaultConstructorMarker) null));
                        ArrayList arrayList2 = new ArrayList();
                        arrayList2.add((String) split$default.get(2));
                        this.selectedRefinerList.add(new SelectedRefinerV2("model", arrayList2, false, 4, (DefaultConstructorMarker) null));
                    } else if (split$default.size() == 2) {
                        ArrayList arrayList3 = new ArrayList();
                        arrayList3.add((String) split$default.get(1));
                        this.selectedRefinerList.add(new SelectedRefinerV2("make", arrayList3, false, 4, (DefaultConstructorMarker) null));
                    }
                }
                ArrayList<MakeModelValues> arrayList4 = this.lastSelectedMakeModel;
                if (arrayList4 != null) {
                    addRecentlyViewModel(arrayList4);
                }
                z = true;
            }
        }
    }

    /* access modifiers changed from: private */
    public final void clearAllFilters() {
        this.hashMapMakeModelArray.clear();
        BaseActivity baseActivity = this.filterActivity;
        if (baseActivity == null) {
            Intrinsics.throwUninitializedPropertyAccessException("filterActivity");
        }
        IAASharedPreference.setSelectedFilter(baseActivity, "");
        BaseActivity baseActivity2 = this.filterActivity;
        if (baseActivity2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("filterActivity");
        }
        IAASharedPreference.setSelectedMakeModelFilter(baseActivity2, "");
        this.selectedRefinerHashMap = new LinkedHashMap<>();
        this.selectedRefinerList.clear();
        this.popularRefinerCategories.clear();
        ArrayList<String> arrayList = this.expandableListTitle;
        if (arrayList == null) {
            Intrinsics.throwUninitializedPropertyAccessException("expandableListTitle");
        }
        arrayList.clear();
        setApplyFilterBtn(true);
        this.lastSelectedMakeModel.clear();
        if (this.popularCategoryListAdapter != null) {
            PopularCategoryListAdapter popularCategoryListAdapter2 = this.popularCategoryListAdapter;
            if (popularCategoryListAdapter2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("popularCategoryListAdapter");
            }
            popularCategoryListAdapter2.popularCategorySelect("Popular Category", false);
        }
        handlePopularCategoryVisiblty();
        setFilterRefinersValues();
        initFilterList();
        updateSearchButtonCount();
    }

    /* access modifiers changed from: private */
    public final void addHeaderView() {
        if (!this.isFromFilterPage) {
            TextView textView = (TextView) _$_findCachedViewById(C2723R.C2726id.tvClearFilterFindVehicle);
            Intrinsics.checkExpressionValueIsNotNull(textView, "tvClearFilterFindVehicle");
            textView.setVisibility(0);
        } else {
            TextView textView2 = (TextView) _$_findCachedViewById(C2723R.C2726id.tvClearFilter);
            Intrinsics.checkExpressionValueIsNotNull(textView2, "tvClearFilter");
            textView2.setVisibility(0);
        }
        RecyclerView recyclerView = (RecyclerView) _$_findCachedViewById(C2723R.C2726id.rvClearFilter);
        Intrinsics.checkExpressionValueIsNotNull(recyclerView, "rvClearFilter");
        recyclerView.setVisibility(0);
        View _$_findCachedViewById = _$_findCachedViewById(C2723R.C2726id.borderBottomClearFilter);
        Intrinsics.checkExpressionValueIsNotNull(_$_findCachedViewById, "borderBottomClearFilter");
        _$_findCachedViewById.setVisibility(0);
        HeaderListAdapter headerListAdapter2 = this.headerListAdapter;
        if (headerListAdapter2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("headerListAdapter");
        }
        headerListAdapter2.setHeaderListData(createSetFromHashMap());
        HeaderListAdapter headerListAdapter3 = this.headerListAdapter;
        if (headerListAdapter3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("headerListAdapter");
        }
        headerListAdapter3.notifyDataSetChanged();
        FlexboxLayoutManager flexboxLayoutManager = new FlexboxLayoutManager(getContext());
        flexboxLayoutManager.setFlexWrap(1);
        RecyclerView recyclerView2 = (RecyclerView) _$_findCachedViewById(C2723R.C2726id.rvClearFilter);
        Intrinsics.checkExpressionValueIsNotNull(recyclerView2, "rvClearFilter");
        recyclerView2.setLayoutManager(flexboxLayoutManager);
        HeaderListAdapter headerListAdapter4 = this.headerListAdapter;
        if (headerListAdapter4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("headerListAdapter");
        }
        headerListAdapter4.setClickListener(this);
    }

    private final void initFilterList() {
        this.expandableListTitle = new ArrayList<>(this.filterExpandableList.keySet());
        BaseActivity baseActivity = this.filterActivity;
        if (baseActivity == null) {
            Intrinsics.throwUninitializedPropertyAccessException("filterActivity");
        }
        Context context = baseActivity;
        ArrayList<String> arrayList = this.expandableListTitle;
        if (arrayList == null) {
            Intrinsics.throwUninitializedPropertyAccessException("expandableListTitle");
        }
        this.expandableListAdapter = new FilterListExpandableListAdapter(context, arrayList, this.filterExpandableList);
        ExpandableListView expandableListView = (ExpandableListView) _$_findCachedViewById(C2723R.C2726id.expandableListView);
        FilterListExpandableListAdapter filterListExpandableListAdapter = this.expandableListAdapter;
        if (filterListExpandableListAdapter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("expandableListAdapter");
        }
        expandableListView.setAdapter(filterListExpandableListAdapter);
        View inflate = getLayoutInflater().inflate(C2723R.C2728layout.expandable_list_view_header, (ViewGroup) null);
        Intrinsics.checkExpressionValueIsNotNull(inflate, "layoutInflater.inflate(R…e_list_view_header, null)");
        this.header = inflate;
        BaseActivity baseActivity2 = this.filterActivity;
        if (baseActivity2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("filterActivity");
        }
        this.headerListAdapter = new HeaderListAdapter(baseActivity2);
        RecyclerView recyclerView = (RecyclerView) _$_findCachedViewById(C2723R.C2726id.rvClearFilter);
        Intrinsics.checkExpressionValueIsNotNull(recyclerView, "rvClearFilter");
        HeaderListAdapter headerListAdapter2 = this.headerListAdapter;
        if (headerListAdapter2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("headerListAdapter");
        }
        recyclerView.setAdapter(headerListAdapter2);
        if (createSetFromHashMap().size() > 0) {
            addHeaderView();
        } else {
            TextView textView = (TextView) _$_findCachedViewById(C2723R.C2726id.tvClearFilter);
            Intrinsics.checkExpressionValueIsNotNull(textView, "tvClearFilter");
            textView.setVisibility(8);
            TextView textView2 = (TextView) _$_findCachedViewById(C2723R.C2726id.tvClearFilterFindVehicle);
            Intrinsics.checkExpressionValueIsNotNull(textView2, "tvClearFilterFindVehicle");
            textView2.setVisibility(8);
            RecyclerView recyclerView2 = (RecyclerView) _$_findCachedViewById(C2723R.C2726id.rvClearFilter);
            Intrinsics.checkExpressionValueIsNotNull(recyclerView2, "rvClearFilter");
            recyclerView2.setVisibility(8);
        }
        ((ExpandableListView) _$_findCachedViewById(C2723R.C2726id.expandableListView)).setOnGroupExpandListener(new FilterFragment$initFilterList$1(this));
        ((ExpandableListView) _$_findCachedViewById(C2723R.C2726id.expandableListView)).setOnGroupCollapseListener(new FilterFragment$initFilterList$2(this));
        FilterListExpandableListAdapter filterListExpandableListAdapter2 = this.expandableListAdapter;
        if (filterListExpandableListAdapter2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("expandableListAdapter");
        }
        if (filterListExpandableListAdapter2 != null) {
            filterListExpandableListAdapter2.setClickListenter(new FilterFragment$initFilterList$3(this));
            return;
        }
        throw new TypeCastException("null cannot be cast to non-null type com.iaai.android.bdt.feature.findVehiclePage.filter.FilterListExpandableListAdapter");
    }

    /* access modifiers changed from: private */
    public final void updateSearchButtonCount() {
        if (!this.isFromFilterPage) {
            loadRefinerData(true);
        }
    }

    /* access modifiers changed from: private */
    public final void setApplyFilterBtn(boolean z) {
        LinearLayout linearLayout = (LinearLayout) _$_findCachedViewById(C2723R.C2726id.ll_applyFilter_container);
        Intrinsics.checkExpressionValueIsNotNull(linearLayout, "ll_applyFilter_container");
        linearLayout.setClickable(z);
        LinearLayout linearLayout2 = (LinearLayout) _$_findCachedViewById(C2723R.C2726id.ll_applyFilter_container);
        Intrinsics.checkExpressionValueIsNotNull(linearLayout2, "ll_applyFilter_container");
        linearLayout2.setEnabled(z);
        LinearLayout linearLayout3 = (LinearLayout) _$_findCachedViewById(C2723R.C2726id.ll_applyFilter_container);
        Intrinsics.checkExpressionValueIsNotNull(linearLayout3, "ll_applyFilter_container");
        linearLayout3.setSelected(z);
    }

    /* JADX WARNING: Removed duplicated region for block: B:132:0x016a A[SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:55:0x0159  */
    /* JADX WARNING: Removed duplicated region for block: B:56:0x015c  */
    /* JADX WARNING: Removed duplicated region for block: B:59:0x016f A[LOOP:2: B:16:0x006e->B:59:0x016f, LOOP_END] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final void setFilterRefinersValues() {
        /*
            r37 = this;
            r0 = r37
            java.util.ArrayList<com.iaai.android.bdt.model.fastSearch.Refiner> r1 = r0.refinerList
            java.lang.Iterable r1 = (java.lang.Iterable) r1
            java.util.Iterator r1 = r1.iterator()
        L_0x000a:
            boolean r2 = r1.hasNext()
            if (r2 == 0) goto L_0x0387
            java.lang.Object r2 = r1.next()
            com.iaai.android.bdt.model.fastSearch.Refiner r2 = (com.iaai.android.bdt.model.fastSearch.Refiner) r2
            java.lang.String r3 = r2.getDisplayName()
            java.lang.String r4 = "Popular Categories"
            r5 = 1
            boolean r3 = kotlin.text.StringsKt.equals(r3, r4, r5)
            if (r3 != 0) goto L_0x032d
            java.lang.String r3 = r2.getDisplayName()
            java.lang.String r6 = "QuickLinks"
            boolean r3 = kotlin.text.StringsKt.equals(r3, r6, r5)
            if (r3 != 0) goto L_0x032d
            java.lang.String r3 = r2.getDisplayName()
            java.lang.String r6 = "Model"
            boolean r3 = kotlin.text.StringsKt.equals(r3, r6, r5)
            if (r3 != 0) goto L_0x032d
            java.util.ArrayList r3 = new java.util.ArrayList
            r3.<init>()
            java.util.List r4 = r2.getRefiners()
            java.lang.Iterable r4 = (java.lang.Iterable) r4
            java.util.Iterator r4 = r4.iterator()
            r7 = 0
            r8 = 0
        L_0x004c:
            boolean r9 = r4.hasNext()
            java.lang.String r10 = "Auction Week"
            java.lang.String r11 = "Make & Model"
            java.lang.String r12 = "make"
            if (r9 == 0) goto L_0x0268
            java.lang.Object r9 = r4.next()
            int r13 = r7 + 1
            if (r7 >= 0) goto L_0x0063
            kotlin.collections.CollectionsKt.throwIndexOverflow()
        L_0x0063:
            com.iaai.android.bdt.model.fastSearch.RefinerX r9 = (com.iaai.android.bdt.model.fastSearch.RefinerX) r9
            java.util.ArrayList<com.iaai.android.bdt.model.fastSearch.SelectedRefinerV2> r7 = r0.selectedRefinerList
            java.util.Iterator r7 = r7.iterator()
            java.lang.String r14 = ""
            r15 = 0
        L_0x006e:
            boolean r16 = r7.hasNext()
            java.lang.String r6 = "Year"
            java.lang.String r5 = "Make"
            r17 = r1
            java.lang.String r1 = "year"
            if (r16 == 0) goto L_0x017b
            java.lang.Object r15 = r7.next()
            com.iaai.android.bdt.model.fastSearch.SelectedRefinerV2 r15 = (com.iaai.android.bdt.model.fastSearch.SelectedRefinerV2) r15
            r16 = r4
            java.lang.String r4 = r15.getRefinerTypeValue()
            r18 = r7
            java.lang.String r7 = "yearfilter"
            r19 = r13
            r13 = 1
            boolean r4 = kotlin.text.StringsKt.equals(r4, r7, r13)
            if (r4 == 0) goto L_0x00a4
            java.lang.String r4 = r2.getDisplayName()
            boolean r4 = r4.equals(r6)
            if (r4 == 0) goto L_0x00a4
            r20 = r14
        L_0x00a1:
            r4 = 1
            goto L_0x0144
        L_0x00a4:
            java.lang.String r4 = r15.getRefinerTypeValue()
            boolean r4 = kotlin.text.StringsKt.equals(r4, r10, r13)
            if (r4 != 0) goto L_0x0111
            java.lang.String r4 = r15.getRefinerTypeValue()
            r20 = r14
            java.lang.String r14 = "Assigned Vehicles"
            boolean r4 = kotlin.text.StringsKt.equals(r4, r14, r13)
            if (r4 != 0) goto L_0x0113
            java.lang.String r4 = r15.getRefinerTypeValue()
            java.lang.String r14 = "Title Status"
            boolean r4 = kotlin.text.StringsKt.equals(r4, r14, r13)
            if (r4 == 0) goto L_0x00c9
            goto L_0x0113
        L_0x00c9:
            java.lang.String r4 = r15.getRefinerTypeValue()
            boolean r4 = kotlin.text.StringsKt.equals(r4, r11, r13)
            if (r4 == 0) goto L_0x00de
            java.lang.String r4 = r2.getDisplayName()
            boolean r4 = kotlin.text.StringsKt.equals(r4, r5, r13)
            if (r4 == 0) goto L_0x00de
        L_0x00dd:
            goto L_0x00a1
        L_0x00de:
            java.util.ArrayList<com.iaai.android.bdt.model.fastSearch.SelectedRefinerV2> r4 = r0.selectedRefinerList
            java.util.Collection r4 = (java.util.Collection) r4
            boolean r4 = r4.isEmpty()
            r4 = r4 ^ r13
            if (r4 == 0) goto L_0x010e
            java.lang.String r4 = r15.getRefinerTypeValue()
            java.lang.String r14 = r2.getDisplayName()
            boolean r4 = kotlin.text.StringsKt.equals(r4, r14, r13)
            if (r4 == 0) goto L_0x010e
            java.util.List r4 = r15.getRefinerValue()
            r14 = 0
            java.lang.Object r4 = r4.get(r14)
            java.lang.String r4 = (java.lang.String) r4
            java.lang.String r14 = r9.getRefinerValue()
            boolean r4 = kotlin.text.StringsKt.equals(r4, r14, r13)
            if (r4 == 0) goto L_0x010e
            r4 = 1
            goto L_0x010f
        L_0x010e:
            r4 = 0
        L_0x010f:
            r13 = 1
            goto L_0x0144
        L_0x0111:
            r20 = r14
        L_0x0113:
            java.util.ArrayList<com.iaai.android.bdt.model.fastSearch.SelectedRefinerV2> r4 = r0.selectedRefinerList
            java.util.Collection r4 = (java.util.Collection) r4
            boolean r4 = r4.isEmpty()
            r13 = 1
            r4 = r4 ^ r13
            if (r4 == 0) goto L_0x0143
            java.lang.String r4 = r15.getRefinerTypeValue()
            java.lang.String r14 = r2.getDisplayName()
            boolean r4 = kotlin.text.StringsKt.equals(r4, r14, r13)
            if (r4 == 0) goto L_0x0143
            java.util.List r4 = r15.getRefinerValue()
            r14 = 0
            java.lang.Object r4 = r4.get(r14)
            java.lang.String r4 = (java.lang.String) r4
            java.lang.String r14 = r9.getDisplayName()
            boolean r4 = kotlin.text.StringsKt.equals(r4, r14, r13)
            if (r4 == 0) goto L_0x0143
            goto L_0x00dd
        L_0x0143:
            r4 = 0
        L_0x0144:
            java.lang.String r14 = r15.getRefinerTypeValue()
            boolean r14 = kotlin.text.StringsKt.equals(r14, r1, r13)
            if (r14 != 0) goto L_0x015c
            java.lang.String r14 = r15.getRefinerTypeValue()
            boolean r7 = kotlin.text.StringsKt.equals(r14, r7, r13)
            if (r7 == 0) goto L_0x0159
            goto L_0x015c
        L_0x0159:
            r14 = r20
            goto L_0x0168
        L_0x015c:
            java.util.List r7 = r15.getRefinerValue()
            r13 = 0
            java.lang.Object r7 = r7.get(r13)
            java.lang.String r7 = (java.lang.String) r7
            r14 = r7
        L_0x0168:
            if (r4 == 0) goto L_0x016f
            r30 = r4
            r24 = r14
            goto L_0x0185
        L_0x016f:
            r15 = r4
            r4 = r16
            r1 = r17
            r7 = r18
            r13 = r19
            r5 = 1
            goto L_0x006e
        L_0x017b:
            r16 = r4
            r19 = r13
            r20 = r14
            r30 = r15
            r24 = r20
        L_0x0185:
            if (r8 != 0) goto L_0x01ea
            java.lang.String r4 = r2.getDisplayName()
            r7 = 1
            boolean r4 = kotlin.text.StringsKt.equals(r4, r5, r7)
            if (r4 == 0) goto L_0x0195
            java.lang.String r4 = "All Make & Model"
            goto L_0x01ae
        L_0x0195:
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>()
            java.lang.String r5 = "All "
            r4.append(r5)
            java.lang.String r5 = r2.getDisplayName()
            java.lang.String r5 = r0.getDisplayName(r5)
            r4.append(r5)
            java.lang.String r4 = r4.toString()
        L_0x01ae:
            r35 = r4
            java.lang.String r4 = r2.getDisplayName()
            r5 = 1
            boolean r4 = kotlin.text.StringsKt.equals(r4, r6, r5)
            if (r4 != 0) goto L_0x01e8
            if (r30 == 0) goto L_0x01d3
            com.iaai.android.bdt.model.filter.FilterValues r4 = new com.iaai.android.bdt.model.filter.FilterValues
            r5 = 0
            java.lang.Integer r33 = java.lang.Integer.valueOf(r5)
            r34 = 0
            r36 = 0
            r31 = r4
            r32 = r35
            r31.<init>(r32, r33, r34, r35, r36)
            r3.add(r4)
            goto L_0x01e8
        L_0x01d3:
            com.iaai.android.bdt.model.filter.FilterValues r4 = new com.iaai.android.bdt.model.filter.FilterValues
            r5 = 0
            java.lang.Integer r33 = java.lang.Integer.valueOf(r5)
            r34 = 0
            r36 = 1
            r31 = r4
            r32 = r35
            r31.<init>(r32, r33, r34, r35, r36)
            r3.add(r4)
        L_0x01e8:
            int r8 = r8 + 1
        L_0x01ea:
            java.lang.String r4 = r2.getDisplayName()
            r5 = 1
            boolean r1 = kotlin.text.StringsKt.equals(r4, r1, r5)
            if (r1 == 0) goto L_0x0210
            com.iaai.android.bdt.model.filter.FilterValues r1 = new com.iaai.android.bdt.model.filter.FilterValues
            java.lang.String r21 = r2.getDisplayName()
            int r4 = r9.getRefinerCount()
            java.lang.Integer r22 = java.lang.Integer.valueOf(r4)
            r23 = 0
            r20 = r1
            r25 = r30
            r20.<init>(r21, r22, r23, r24, r25)
            r3.add(r1)
            goto L_0x025f
        L_0x0210:
            java.lang.String r1 = r2.getDisplayName()
            r4 = 1
            boolean r1 = kotlin.text.StringsKt.equals(r1, r12, r4)
            if (r1 == 0) goto L_0x0243
            java.util.ArrayList<com.iaai.android.bdt.model.fastSearch.SelectedRefinerV2> r1 = r0.hashMapMakeModelArray
            java.util.Collection r1 = (java.util.Collection) r1
            boolean r1 = r1.isEmpty()
            r1 = r1 ^ r4
            if (r1 == 0) goto L_0x0243
            com.iaai.android.bdt.model.filter.FilterValues r1 = new com.iaai.android.bdt.model.filter.FilterValues
            java.lang.String r21 = r2.getDisplayName()
            java.util.ArrayList<com.iaai.android.bdt.model.fastSearch.SelectedRefinerV2> r4 = r0.hashMapMakeModelArray
            int r4 = r4.size()
            java.lang.Integer r22 = java.lang.Integer.valueOf(r4)
            r23 = 0
            r20 = r1
            r25 = r30
            r20.<init>(r21, r22, r23, r24, r25)
            r3.add(r1)
            goto L_0x025f
        L_0x0243:
            com.iaai.android.bdt.model.filter.FilterValues r1 = new com.iaai.android.bdt.model.filter.FilterValues
            java.lang.String r26 = r2.getDisplayName()
            int r4 = r9.getRefinerCount()
            java.lang.Integer r27 = java.lang.Integer.valueOf(r4)
            r28 = 0
            java.lang.String r29 = r9.getDisplayName()
            r25 = r1
            r25.<init>(r26, r27, r28, r29, r30)
            r3.add(r1)
        L_0x025f:
            r4 = r16
            r1 = r17
            r7 = r19
            r5 = 1
            goto L_0x004c
        L_0x0268:
            r17 = r1
            java.lang.String r1 = r2.getDisplayName()
            r4 = 1
            boolean r1 = kotlin.text.StringsKt.equals(r1, r12, r4)
            if (r1 == 0) goto L_0x029d
            com.iaai.android.bdt.model.filter.FilterData r1 = new com.iaai.android.bdt.model.filter.FilterData
            r4 = 0
            java.lang.Integer r19 = java.lang.Integer.valueOf(r4)
            java.util.List r4 = r2.getRefiners()
            int r4 = r4.size()
            java.lang.Integer r21 = java.lang.Integer.valueOf(r4)
            r22 = r3
            java.util.List r22 = (java.util.List) r22
            java.lang.String r23 = r2.getRefinerTypeValue()
            java.lang.String r20 = "Make & Model"
            r18 = r1
            r18.<init>(r19, r20, r21, r22, r23)
            java.util.ArrayList<com.iaai.android.bdt.model.filter.FilterData> r4 = r0.filterDataList
            r4.add(r1)
            goto L_0x02c6
        L_0x029d:
            com.iaai.android.bdt.model.filter.FilterData r1 = new com.iaai.android.bdt.model.filter.FilterData
            r4 = 0
            java.lang.Integer r19 = java.lang.Integer.valueOf(r4)
            java.lang.String r20 = r2.getDisplayName()
            java.util.List r4 = r2.getRefiners()
            int r4 = r4.size()
            java.lang.Integer r21 = java.lang.Integer.valueOf(r4)
            r22 = r3
            java.util.List r22 = (java.util.List) r22
            java.lang.String r23 = r2.getRefinerTypeValue()
            r18 = r1
            r18.<init>(r19, r20, r21, r22, r23)
            java.util.ArrayList<com.iaai.android.bdt.model.filter.FilterData> r4 = r0.filterDataList
            r4.add(r1)
        L_0x02c6:
            java.lang.String r1 = r2.getDisplayName()
            r4 = 1
            boolean r1 = kotlin.text.StringsKt.equals(r1, r12, r4)
            if (r1 == 0) goto L_0x02db
            java.util.LinkedHashMap<java.lang.String, java.util.List<com.iaai.android.bdt.model.filter.FilterValues>> r1 = r0.filterExpandableList
            java.lang.String r4 = r0.getDisplayName(r11)
            r1.put(r4, r3)
            goto L_0x02e8
        L_0x02db:
            java.util.LinkedHashMap<java.lang.String, java.util.List<com.iaai.android.bdt.model.filter.FilterValues>> r1 = r0.filterExpandableList
            java.lang.String r4 = r2.getDisplayName()
            java.lang.String r4 = r0.getDisplayName(r4)
            r1.put(r4, r3)
        L_0x02e8:
            java.lang.String r1 = r2.getDisplayName()
            r3 = 1
            boolean r1 = kotlin.text.StringsKt.equals(r1, r10, r3)
            if (r1 == 0) goto L_0x0383
            java.util.List r1 = r2.getRefiners()
            java.util.Iterator r1 = r1.iterator()
        L_0x02fb:
            boolean r2 = r1.hasNext()
            if (r2 == 0) goto L_0x0383
            java.lang.Object r2 = r1.next()
            com.iaai.android.bdt.model.fastSearch.RefinerX r2 = (com.iaai.android.bdt.model.fastSearch.RefinerX) r2
            java.lang.String r4 = r2.getDisplayName()
            java.lang.String r5 = "This Week"
            boolean r4 = kotlin.text.StringsKt.equals(r4, r5, r3)
            if (r4 == 0) goto L_0x0319
            java.lang.String r4 = r2.getRefinerValue()
            r0.thisWeek = r4
        L_0x0319:
            java.lang.String r4 = r2.getDisplayName()
            java.lang.String r5 = "Next Week"
            boolean r4 = kotlin.text.StringsKt.equals(r4, r5, r3)
            if (r4 == 0) goto L_0x032b
            java.lang.String r2 = r2.getRefinerValue()
            r0.nextWeek = r2
        L_0x032b:
            r3 = 1
            goto L_0x02fb
        L_0x032d:
            r17 = r1
            java.lang.String r1 = r2.getDisplayName()
            r3 = 1
            boolean r1 = kotlin.text.StringsKt.equals(r1, r4, r3)
            if (r1 == 0) goto L_0x0383
            java.util.List r1 = r2.getRefiners()
            java.lang.Iterable r1 = (java.lang.Iterable) r1
            java.util.Iterator r1 = r1.iterator()
        L_0x0344:
            boolean r2 = r1.hasNext()
            if (r2 == 0) goto L_0x0383
            java.lang.Object r2 = r1.next()
            com.iaai.android.bdt.model.fastSearch.RefinerX r2 = (com.iaai.android.bdt.model.fastSearch.RefinerX) r2
            java.lang.String r3 = r2.getRefinerValue()
            java.lang.String r4 = "Vrd"
            boolean r3 = r3.equals(r4)
            if (r3 != 0) goto L_0x0344
            com.iaai.android.bdt.model.fastSearch.RefinerX r3 = new com.iaai.android.bdt.model.fastSearch.RefinerX
            java.lang.String r4 = r2.getDisplayName()
            java.lang.String r4 = r0.showDisplayNameForPopularRefiner(r4)
            int r5 = r2.getRefinerCount()
            java.lang.String r6 = r2.getRefinerValue()
            java.lang.String r2 = r2.getDisplayName()
            java.lang.String r2 = r0.showDisplayNameForPopularRefiner(r2)
            boolean r2 = r0.getPopularCategoriesIsSelected(r2)
            r3.<init>(r4, r5, r6, r2)
            java.util.ArrayList<com.iaai.android.bdt.model.fastSearch.RefinerX> r2 = r0.popularRefinerCategories
            r2.add(r3)
            goto L_0x0344
        L_0x0383:
            r1 = r17
            goto L_0x000a
        L_0x0387:
            com.iaai.android.bdt.model.filter.FilterResponse r1 = new com.iaai.android.bdt.model.filter.FilterResponse
            java.util.ArrayList<com.iaai.android.bdt.model.filter.FilterData> r2 = r0.filterDataList
            java.util.List r2 = (java.util.List) r2
            r1.<init>(r2)
            r0.filterResponseList = r1
            com.iaai.android.bdt.model.filter.FilterResponse r1 = r0.filterResponseList
            if (r1 != 0) goto L_0x039b
            java.lang.String r2 = "filterResponseList"
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r2)
        L_0x039b:
            java.util.ArrayList<com.iaai.android.bdt.model.filter.FilterData> r2 = r0.filterDataList
            java.util.List r2 = (java.util.List) r2
            r1.setFilterData(r2)
            r1 = r0
            com.iaai.android.bdt.feature.findVehiclePage.filter.FilterFragment r1 = (com.iaai.android.bdt.feature.findVehiclePage.filter.FilterFragment) r1
            com.iaai.android.bdt.feature.findVehiclePage.PopularCategoryListAdapter r1 = r1.popularCategoryListAdapter
            if (r1 == 0) goto L_0x03c4
            com.iaai.android.bdt.feature.findVehiclePage.PopularCategoryListAdapter r1 = r0.popularCategoryListAdapter
            java.lang.String r2 = "popularCategoryListAdapter"
            if (r1 != 0) goto L_0x03b2
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r2)
        L_0x03b2:
            java.util.ArrayList<com.iaai.android.bdt.model.fastSearch.RefinerX> r3 = r0.popularRefinerCategories
            r1.setPopularCategoryListData(r3)
            com.iaai.android.bdt.feature.findVehiclePage.PopularCategoryListAdapter r1 = r0.popularCategoryListAdapter
            if (r1 != 0) goto L_0x03be
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r2)
        L_0x03be:
            r1.notifyDataSetChanged()
            r37.handlePopularCategoryVisiblty()
        L_0x03c4:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.iaai.android.bdt.feature.findVehiclePage.filter.FilterFragment.setFilterRefinersValues():void");
    }

    public final boolean getPopularCategoriesIsSelected(@NotNull String str) {
        Intrinsics.checkParameterIsNotNull(str, "popularCategoryValue");
        Iterator<SelectedRefinerV2> it = this.selectedRefinerList.iterator();
        while (it.hasNext()) {
            if (StringsKt.equals(it.next().getRefinerTypeValue(), str, true)) {
                return true;
            }
        }
        return false;
    }

    /* access modifiers changed from: private */
    public final String getDisplayName(String str) {
        if (StringsKt.equals(str, "Vehicle Type", true)) {
            String string = getResources().getString(C2723R.string.lbl_vehicle_type);
            Intrinsics.checkExpressionValueIsNotNull(string, "resources.getString(R.string.lbl_vehicle_type)");
            return string;
        } else if (StringsKt.equals(str, "Transmission", true)) {
            String string2 = getResources().getString(C2723R.string.lbl_tranmission);
            Intrinsics.checkExpressionValueIsNotNull(string2, "resources.getString(R.string.lbl_tranmission)");
            return string2;
        } else if (StringsKt.equals(str, "Loss Type", true)) {
            String string3 = getResources().getString(C2723R.string.lbl_loss_type);
            Intrinsics.checkExpressionValueIsNotNull(string3, "resources.getString(R.string.lbl_loss_type)");
            return string3;
        } else if (StringsKt.equals(str, "Odometer", true)) {
            String string4 = getResources().getString(C2723R.string.odo_meter);
            Intrinsics.checkExpressionValueIsNotNull(string4, "resources.getString(R.string.odo_meter)");
            return string4;
        } else if (StringsKt.equals(str, "State", true)) {
            String string5 = getResources().getString(C2723R.string.lbl_state);
            Intrinsics.checkExpressionValueIsNotNull(string5, "resources.getString(R.string.lbl_state)");
            return string5;
        } else if (StringsKt.equals(str, "Buyer Type", true)) {
            String string6 = getResources().getString(C2723R.string.lbl_buyer_type);
            Intrinsics.checkExpressionValueIsNotNull(string6, "resources.getString(R.string.lbl_buyer_type)");
            return string6;
        } else if (StringsKt.equals(str, "Automobile Type", true)) {
            String string7 = getResources().getString(C2723R.string.lbl_automobile_types);
            Intrinsics.checkExpressionValueIsNotNull(string7, "resources.getString(R.string.lbl_automobile_types)");
            return string7;
        } else if (StringsKt.equals(str, "Sale Document", true)) {
            String string8 = getResources().getString(C2723R.string.lbl_sale_document);
            Intrinsics.checkExpressionValueIsNotNull(string8, "resources.getString(R.string.lbl_sale_document)");
            return string8;
        } else if (StringsKt.equals(str, "Primary Damage", true)) {
            String string9 = getResources().getString(C2723R.string.lbl_primary_damage);
            Intrinsics.checkExpressionValueIsNotNull(string9, "resources.getString(R.string.lbl_primary_damage)");
            return string9;
        } else if (StringsKt.equals(str, "Start Code", true)) {
            String string10 = getResources().getString(C2723R.string.lbl_start_code);
            Intrinsics.checkExpressionValueIsNotNull(string10, "resources.getString(R.string.lbl_start_code)");
            return string10;
        } else if (StringsKt.equals(str, "Equipment Type", true)) {
            String string11 = getResources().getString(C2723R.string.lbl_equipment_types);
            Intrinsics.checkExpressionValueIsNotNull(string11, "resources.getString(R.string.lbl_equipment_types)");
            return string11;
        } else if (StringsKt.equals(str, ExifInterface.TAG_MAKE, true)) {
            String string12 = getResources().getString(C2723R.string.lbl_make);
            Intrinsics.checkExpressionValueIsNotNull(string12, "resources.getString(R.string.lbl_make)");
            return string12;
        } else if (StringsKt.equals(str, ExifInterface.TAG_MODEL, true)) {
            String string13 = getResources().getString(C2723R.string.lbl_model);
            Intrinsics.checkExpressionValueIsNotNull(string13, "resources.getString(R.string.lbl_model)");
            return string13;
        } else if (StringsKt.equals(str, "Interior Color", true)) {
            String string14 = getResources().getString(C2723R.string.lbl_interior_color);
            Intrinsics.checkExpressionValueIsNotNull(string14, "resources.getString(R.string.lbl_interior_color)");
            return string14;
        } else if (StringsKt.equals(str, "Fuel Type", true)) {
            String string15 = getResources().getString(C2723R.string.lbl_fuel_type);
            Intrinsics.checkExpressionValueIsNotNull(string15, "resources.getString(R.string.lbl_fuel_type)");
            return string15;
        } else if (StringsKt.equals(str, "Cylinders", true)) {
            String string16 = getResources().getString(C2723R.string.cylinders);
            Intrinsics.checkExpressionValueIsNotNull(string16, "resources.getString(R.string.cylinders)");
            return string16;
        } else if (StringsKt.equals(str, "Exterior Color", true)) {
            String string17 = getResources().getString(C2723R.string.lbl_exterior_color);
            Intrinsics.checkExpressionValueIsNotNull(string17, "resources.getString(R.string.lbl_exterior_color)");
            return string17;
        } else if (StringsKt.equals(str, "Drive Line Type", true)) {
            String string18 = getResources().getString(C2723R.string.lbl_drive_line_type);
            Intrinsics.checkExpressionValueIsNotNull(string18, "resources.getString(R.string.lbl_drive_line_type)");
            return string18;
        } else if (StringsKt.equals(str, "Country of Origin", true)) {
            String string19 = getResources().getString(C2723R.string.lbl_country_of_orign);
            Intrinsics.checkExpressionValueIsNotNull(string19, "resources.getString(R.string.lbl_country_of_orign)");
            return string19;
        } else if (StringsKt.equals(str, "Air Bags", true)) {
            String string20 = getResources().getString(C2723R.string.lbl_air_bags);
            Intrinsics.checkExpressionValueIsNotNull(string20, "resources.getString(R.string.lbl_air_bags)");
            return string20;
        } else if (StringsKt.equals(str, "Key", true)) {
            String string21 = getResources().getString(C2723R.string.lbl_key);
            Intrinsics.checkExpressionValueIsNotNull(string21, "resources.getString(R.string.lbl_key)");
            return string21;
        } else if (StringsKt.equals(str, Constants.TO_BE_PAID_SRT_BRANCH, true)) {
            String string22 = getResources().getString(C2723R.string.lbl_branch_name);
            Intrinsics.checkExpressionValueIsNotNull(string22, "resources.getString(R.string.lbl_branch_name)");
            return string22;
        } else if (StringsKt.equals(str, "Body Style", true)) {
            String string23 = getResources().getString(C2723R.string.lbl_body_style);
            Intrinsics.checkExpressionValueIsNotNull(string23, "resources.getString(R.string.lbl_body_style)");
            return string23;
        } else if (StringsKt.equals(str, "Actual Cash Value", true)) {
            String string24 = getResources().getString(C2723R.string.lbl_actual_cash);
            Intrinsics.checkExpressionValueIsNotNull(string24, "resources.getString(R.string.lbl_actual_cash)");
            return string24;
        } else if (StringsKt.equals(str, "Price", true)) {
            String string25 = getResources().getString(C2723R.string.lbl_srt_price);
            Intrinsics.checkExpressionValueIsNotNull(string25, "resources.getString(R.string.lbl_srt_price)");
            return string25;
        } else if (StringsKt.equals(str, "Auction Week", true)) {
            String string26 = getResources().getString(C2723R.string.lbl_auction_week);
            Intrinsics.checkExpressionValueIsNotNull(string26, "resources.getString(R.string.lbl_auction_week)");
            return string26;
        } else if (StringsKt.equals(str, "Auction Day", true)) {
            String string27 = getResources().getString(C2723R.string.lbl_auctiona_day);
            Intrinsics.checkExpressionValueIsNotNull(string27, "resources.getString(R.string.lbl_auctiona_day)");
            return string27;
        } else if (StringsKt.equals(str, "Region", true)) {
            String string28 = getResources().getString(C2723R.string.lbl_region);
            Intrinsics.checkExpressionValueIsNotNull(string28, "resources.getString(R.string.lbl_region)");
            return string28;
        } else if (StringsKt.equals(str, "Remarketing Seller", true)) {
            String string29 = getResources().getString(C2723R.string.lbl_remarketing);
            Intrinsics.checkExpressionValueIsNotNull(string29, "resources.getString(R.string.lbl_remarketing)");
            return string29;
        } else if (StringsKt.equals(str, "Year", true)) {
            String string30 = getResources().getString(C2723R.string.bdt_lbl_year);
            Intrinsics.checkExpressionValueIsNotNull(string30, "resources.getString(R.string.bdt_lbl_year)");
            return string30;
        } else if (StringsKt.equals(str, "Make & Model", true)) {
            String string31 = getResources().getString(C2723R.string.lbl_bdt_filter_make_model_title);
            Intrinsics.checkExpressionValueIsNotNull(string31, "resources.getString(R.st…_filter_make_model_title)");
            return string31;
        } else if (StringsKt.equals(str, "Seller Type", true)) {
            String string32 = getResources().getString(C2723R.string.bdt_lbl_filter_seller_type);
            Intrinsics.checkExpressionValueIsNotNull(string32, "resources.getString(R.st…t_lbl_filter_seller_type)");
            return string32;
        } else if (StringsKt.equals(str, "Vehicle Assignment", true)) {
            String string33 = getResources().getString(C2723R.string.bdt_lbl_filter_vehicle_assigment);
            Intrinsics.checkExpressionValueIsNotNull(string33, "resources.getString(R.st…filter_vehicle_assigment)");
            return string33;
        } else if (!StringsKt.equals(str, "Assigned Vehicles", true)) {
            return str;
        } else {
            String string34 = getResources().getString(C2723R.string.lbl_assigned_vehicles);
            Intrinsics.checkExpressionValueIsNotNull(string34, "resources.getString(R.st…ng.lbl_assigned_vehicles)");
            return string34;
        }
    }

    private final String showDisplayNameForPopularRefiner(String str) {
        if (StringsKt.equals(str, "Buy Now", true)) {
            String string = getResources().getString(C2723R.string.bdt_lbl_buy_now);
            Intrinsics.checkExpressionValueIsNotNull(string, "resources.getString(R.string.bdt_lbl_buy_now)");
            return string;
        } else if (StringsKt.equals(str, "Run & Drive", true)) {
            String string2 = getResources().getString(C2723R.string.bdt_product_dtl_run_drive);
            Intrinsics.checkExpressionValueIsNotNull(string2, "resources.getString(R.st…dt_product_dtl_run_drive)");
            return string2;
        } else if (StringsKt.equals(str, "Clear Title", true)) {
            String string3 = getResources().getString(C2723R.string.bdt_refiner_clean_title);
            Intrinsics.checkExpressionValueIsNotNull(string3, "resources.getString(R.st….bdt_refiner_clean_title)");
            return string3;
        } else if (StringsKt.equals(str, "Available to the Public", true)) {
            String string4 = getResources().getString(C2723R.string.bdt_lbl_available_for_public);
            Intrinsics.checkExpressionValueIsNotNull(string4, "resources.getString(R.st…lbl_available_for_public)");
            return string4;
        } else if (StringsKt.equals(str, "Flood/Water", true)) {
            String string5 = getResources().getString(C2723R.string.bdt_lbl_flood_water);
            Intrinsics.checkExpressionValueIsNotNull(string5, "resources.getString(R.string.bdt_lbl_flood_water)");
            return string5;
        } else if (StringsKt.equals(str, "Repossession", true)) {
            String string6 = getResources().getString(C2723R.string.bdt_lbl_repossession);
            Intrinsics.checkExpressionValueIsNotNull(string6, "resources.getString(R.string.bdt_lbl_repossession)");
            return string6;
        } else if (StringsKt.equals(str, "Recovered Theft", true)) {
            String string7 = getResources().getString(C2723R.string.bdt_lbl_recovered_theft);
            Intrinsics.checkExpressionValueIsNotNull(string7, "resources.getString(R.st….bdt_lbl_recovered_theft)");
            return string7;
        } else if (StringsKt.equals(str, "Remarketing", true)) {
            String string8 = getResources().getString(C2723R.string.bdt_lbl_marketing);
            Intrinsics.checkExpressionValueIsNotNull(string8, "resources.getString(R.string.bdt_lbl_marketing)");
            return string8;
        } else if (StringsKt.equals(str, "Today", true)) {
            String string9 = getResources().getString(C2723R.string.bdt_lbl_today);
            Intrinsics.checkExpressionValueIsNotNull(string9, "resources.getString(R.string.bdt_lbl_today)");
            return string9;
        } else if (StringsKt.equals(str, "Monday", true)) {
            String string10 = getResources().getString(C2723R.string.bdt_lbl_monday);
            Intrinsics.checkExpressionValueIsNotNull(string10, "resources.getString(R.string.bdt_lbl_monday)");
            return string10;
        } else if (StringsKt.equals(str, "Specialty", true)) {
            String string11 = getResources().getString(C2723R.string.bdt_lbl_speciality);
            Intrinsics.checkExpressionValueIsNotNull(string11, "resources.getString(R.string.bdt_lbl_speciality)");
            return string11;
        } else if (StringsKt.equals(str, "Tomorrow", true)) {
            String string12 = getResources().getString(C2723R.string.bdt_lbl_tomorrow);
            Intrinsics.checkExpressionValueIsNotNull(string12, "resources.getString(R.string.bdt_lbl_tomorrow)");
            return string12;
        } else if (StringsKt.equals(str, "This Week", true)) {
            String string13 = getResources().getString(C2723R.string.bdt_lbl_this_week);
            Intrinsics.checkExpressionValueIsNotNull(string13, "resources.getString(R.string.bdt_lbl_this_week)");
            return string13;
        } else if (StringsKt.equals(str, "Next Week", true)) {
            String string14 = getResources().getString(C2723R.string.bdt_lbl_next_week);
            Intrinsics.checkExpressionValueIsNotNull(string14, "resources.getString(R.string.bdt_lbl_next_week)");
            return string14;
        } else if (StringsKt.equals(str, "Timed Auctions", true)) {
            String string15 = getResources().getString(C2723R.string.bdt_lbl_timed_auction);
            Intrinsics.checkExpressionValueIsNotNull(string15, "resources.getString(R.st…ng.bdt_lbl_timed_auction)");
            return string15;
        } else if (!StringsKt.equals(str, "ACE CA Vehicles", true)) {
            return str;
        } else {
            String string16 = getResources().getString(C2723R.string.bdt_lbl_ace_ca_vehicles);
            Intrinsics.checkExpressionValueIsNotNull(string16, "resources.getString(R.st….bdt_lbl_ace_ca_vehicles)");
            return string16;
        }
    }

    public void onResume() {
        super.onResume();
        if (!this.isFromFilterPage) {
            BaseActivity baseActivity = this.filterActivity;
            if (baseActivity == null) {
                Intrinsics.throwUninitializedPropertyAccessException("filterActivity");
            }
            String selectedFilter = IAASharedPreference.getSelectedFilter(baseActivity);
            BaseActivity baseActivity2 = this.filterActivity;
            if (baseActivity2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("filterActivity");
            }
            String selectedMakeModelFilter = IAASharedPreference.getSelectedMakeModelFilter(baseActivity2);
            Intrinsics.checkExpressionValueIsNotNull(selectedFilter, "selectedFilterJson");
            if (selectedFilter.length() > 0) {
                this.selectedRefinerList.clear();
                this.hashMapMakeModelArray.clear();
                Gson gson2 = this.gson;
                if (gson2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("gson");
                }
                Object fromJson = gson2.fromJson(selectedFilter, new FilterFragment$onResume$1().getType());
                Intrinsics.checkExpressionValueIsNotNull(fromJson, "gson.fromJson(selectedFi…tedRefinerV2>>() {}.type)");
                this.selectedRefinerList = (ArrayList) fromJson;
                Intrinsics.checkExpressionValueIsNotNull(selectedMakeModelFilter, "makeModelSelectedFilterJson");
                if (selectedMakeModelFilter.length() > 0) {
                    Gson gson3 = this.gson;
                    if (gson3 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("gson");
                    }
                    Object fromJson2 = gson3.fromJson(selectedMakeModelFilter, new FilterFragment$onResume$2().getType());
                    Intrinsics.checkExpressionValueIsNotNull(fromJson2, "gson.fromJson(makeModelS…tedRefinerV2>>() {}.type)");
                    this.hashMapMakeModelArray = (ArrayList) fromJson2;
                    BaseActivity baseActivity3 = this.filterActivity;
                    if (baseActivity3 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("filterActivity");
                    }
                    IAASharedPreference.setSelectedMakeModelFilter(baseActivity3, "");
                }
                BaseActivity baseActivity4 = this.filterActivity;
                if (baseActivity4 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("filterActivity");
                }
                String refinerSearch = IAASharedPreference.getRefinerSearch(baseActivity4);
                Intrinsics.checkExpressionValueIsNotNull(refinerSearch, "IAASharedPreference.getR…nerSearch(filterActivity)");
                this.keywordSearch = refinerSearch;
                BaseActivity baseActivity5 = this.filterActivity;
                if (baseActivity5 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("filterActivity");
                }
                IAASharedPreference.setRefinerSearch(baseActivity5, "");
                CharSequence charSequence = this.keywordSearch;
                if (charSequence == null || charSequence.length() == 0) {
                    TextView textView = (TextView) _$_findCachedViewById(C2723R.C2726id.filterFragmentSearch);
                    Intrinsics.checkExpressionValueIsNotNull(textView, "filterFragmentSearch");
                    textView.setText("");
                    TextView textView2 = (TextView) _$_findCachedViewById(C2723R.C2726id.filterFragmentSearch);
                    Intrinsics.checkExpressionValueIsNotNull(textView2, "filterFragmentSearch");
                    textView2.setHint(getString(C2723R.string.hint_search_vehicle));
                } else {
                    TextView textView3 = (TextView) _$_findCachedViewById(C2723R.C2726id.filterFragmentSearch);
                    Intrinsics.checkExpressionValueIsNotNull(textView3, "filterFragmentSearch");
                    textView3.setText(this.keywordSearch);
                }
                BaseActivity baseActivity6 = this.filterActivity;
                if (baseActivity6 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("filterActivity");
                }
                IAASharedPreference.setSelectedFilter(baseActivity6, "");
                updateSelectedRefinerHashMap();
                this.lastSelectedMakeModel.clear();
                updateLastSelectedModel();
                this.popularRefinerCategories.clear();
                loadRecentlyUsedModels();
                setFilterRefinersValues();
                initFilterList();
                ((ExpandableListView) _$_findCachedViewById(C2723R.C2726id.expandableListView)).scrollTo(0, 0);
                updateSearchButtonCount();
            }
            setApplyFilterBtn(true);
        }
    }

    private final void promptSpeechInput() {
        Intent intent = new Intent("android.speech.action.RECOGNIZE_SPEECH");
        intent.putExtra("android.speech.extra.LANGUAGE_MODEL", "free_form");
        intent.putExtra("android.speech.extra.LANGUAGE", Locale.getDefault());
        intent.putExtra("android.speech.extra.PROMPT", getString(C2723R.string.hint_search_vehicle));
        try {
            startActivityForResult(intent, this.REQ_CODE_SPEECH_INPUT);
        } catch (ActivityNotFoundException unused) {
            BaseActivity baseActivity = this.filterActivity;
            if (baseActivity == null) {
                Intrinsics.throwUninitializedPropertyAccessException("filterActivity");
            }
            Toast.makeText(baseActivity, getString(C2723R.string.speech_not_supported), 0).show();
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:69:0x01f4  */
    /* JADX WARNING: Removed duplicated region for block: B:70:0x01fb  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onActivityResult(int r8, int r9, @org.jetbrains.annotations.Nullable android.content.Intent r10) {
        /*
            r7 = this;
            super.onActivityResult(r8, r9, r10)
            r0 = 101(0x65, float:1.42E-43)
            if (r8 != r0) goto L_0x000c
            r7.handleSubFilterRequestCode(r10)
            goto L_0x020f
        L_0x000c:
            r0 = 102(0x66, float:1.43E-43)
            if (r8 != r0) goto L_0x0015
            r7.handleMakeModelMultiSelectRequestCode(r10)
            goto L_0x020f
        L_0x0015:
            int r0 = r7.REQ_CODE_SPEECH_INPUT
            r1 = 0
            r2 = 1
            if (r8 != r0) goto L_0x004d
            r8 = -1
            if (r9 != r8) goto L_0x020f
            if (r10 == 0) goto L_0x020f
            java.lang.String r8 = "android.speech.extra.RESULTS"
            java.util.ArrayList r8 = r10.getStringArrayListExtra(r8)
            int r9 = com.iaai.android.C2723R.C2726id.filterFragmentSearch
            android.view.View r9 = r7._$_findCachedViewById(r9)
            android.widget.TextView r9 = (android.widget.TextView) r9
            java.lang.Object r8 = r8.get(r1)
            java.lang.CharSequence r8 = (java.lang.CharSequence) r8
            r9.setText(r8)
            int r8 = com.iaai.android.C2723R.C2726id.filterFragmentSearch
            android.view.View r8 = r7._$_findCachedViewById(r8)
            android.widget.TextView r8 = (android.widget.TextView) r8
            r8.requestFocus()
            r7.setApplyFilterBtn(r2)
            r7.showSoftKeyboard()
            r7.updateSearchButtonCount()
            goto L_0x020f
        L_0x004d:
            r0 = 104(0x68, float:1.46E-43)
            r3 = 0
            java.lang.String r4 = ""
            if (r8 != r0) goto L_0x0124
            if (r10 == 0) goto L_0x020f
            android.os.Bundle r8 = r10.getExtras()
            if (r8 == 0) goto L_0x0065
            java.lang.String r9 = "searchinput"
            java.lang.String r8 = r8.getString(r9, r4)
            if (r8 == 0) goto L_0x0065
            goto L_0x0066
        L_0x0065:
            r8 = r4
        L_0x0066:
            r7.keywordSearch = r8
            java.lang.StringBuilder r8 = new java.lang.StringBuilder
            r8.<init>()
            java.lang.String r9 = "Sending Event: "
            r8.append(r9)
            com.iaai.android.bdt.analytics.IAAAnalytics$IAAEvents r9 = com.iaai.android.bdt.analytics.IAAAnalytics.IAAEvents.FIND_VEHICLE_KEYWORD_USAGE
            java.lang.String r9 = r9.getId()
            r8.append(r9)
            java.lang.String r9 = " :"
            r8.append(r9)
            java.lang.String r9 = r7.keywordSearch
            r8.append(r9)
            java.lang.String r8 = r8.toString()
            java.lang.String r9 = "FIRE_BASE_ANALYTICS"
            android.util.Log.e(r9, r8)
            com.iaai.android.bdt.analytics.IAAAnalytics r8 = com.iaai.android.bdt.analytics.IAAAnalytics.INSTANCE
            com.iaai.android.bdt.analytics.IAAAnalytics$IAAEvents r9 = com.iaai.android.bdt.analytics.IAAAnalytics.IAAEvents.FIND_VEHICLE_KEYWORD_USAGE
            r8.logIAAEvent(r9, r3)
            java.lang.String r8 = r7.keywordSearch
            java.lang.CharSequence r8 = (java.lang.CharSequence) r8
            boolean r8 = kotlin.text.StringsKt.isBlank(r8)
            r8 = r8 ^ r2
            java.lang.String r9 = "filterFragmentSearch"
            if (r8 == 0) goto L_0x00e4
            r7.addSearchRefiner()
            r7.updateSelectedRefinerHashMap()
            java.util.ArrayList<com.iaai.android.bdt.model.fastSearch.RefinerX> r8 = r7.popularRefinerCategories
            r8.clear()
            r7.setFilterRefinersValues()
            r7.initFilterList()
            int r8 = com.iaai.android.C2723R.C2726id.filterFragmentSearch
            android.view.View r8 = r7._$_findCachedViewById(r8)
            android.widget.TextView r8 = (android.widget.TextView) r8
            kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r8, r9)
            java.lang.String r9 = r7.keywordSearch
            java.lang.CharSequence r9 = (java.lang.CharSequence) r9
            r8.setText(r9)
            int r8 = com.iaai.android.C2723R.C2726id.rvClearFilter
            android.view.View r8 = r7._$_findCachedViewById(r8)
            androidx.recyclerview.widget.RecyclerView r8 = (androidx.recyclerview.widget.RecyclerView) r8
            java.lang.String r9 = "rvClearFilter"
            kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r8, r9)
            r8.setVisibility(r1)
            int r8 = com.iaai.android.C2723R.C2726id.borderBottomClearFilter
            android.view.View r8 = r7._$_findCachedViewById(r8)
            java.lang.String r9 = "borderBottomClearFilter"
            kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r8, r9)
            r8.setVisibility(r1)
            goto L_0x011c
        L_0x00e4:
            int r8 = com.iaai.android.C2723R.C2726id.filterFragmentSearch
            android.view.View r8 = r7._$_findCachedViewById(r8)
            android.widget.TextView r8 = (android.widget.TextView) r8
            kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r8, r9)
            java.lang.CharSequence r4 = (java.lang.CharSequence) r4
            r8.setText(r4)
            int r8 = com.iaai.android.C2723R.C2726id.filterFragmentSearch
            android.view.View r8 = r7._$_findCachedViewById(r8)
            android.widget.TextView r8 = (android.widget.TextView) r8
            kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r8, r9)
            r9 = 2131821012(0x7f1101d4, float:1.9274755E38)
            java.lang.String r9 = r7.getString(r9)
            java.lang.CharSequence r9 = (java.lang.CharSequence) r9
            r8.setHint(r9)
            r7.removeRefinerSearch()
            r7.updateSelectedRefinerHashMap()
            java.util.ArrayList<com.iaai.android.bdt.model.fastSearch.RefinerX> r8 = r7.popularRefinerCategories
            r8.clear()
            r7.setFilterRefinersValues()
            r7.initFilterList()
        L_0x011c:
            r7.setApplyFilterBtn(r2)
            r7.updateSearchButtonCount()
            goto L_0x020f
        L_0x0124:
            int r0 = com.google.zxing.integration.android.IntentIntegrator.REQUEST_CODE
            if (r8 != r0) goto L_0x020f
            if (r10 == 0) goto L_0x020f
            r7.scanValue = r4
            com.google.zxing.integration.android.IntentResult r8 = com.google.zxing.integration.android.IntentIntegrator.parseActivityResult(r8, r9, r10)
            java.lang.String r9 = "result"
            kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r8, r9)
            java.lang.String r8 = r8.getContents()
            java.lang.String r9 = "result.contents"
            kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r8, r9)
            r7.scanValue = r8
            r7.isFromVinScan = r2
            java.lang.String r8 = r7.scanValue
            java.lang.String r9 = "scanValue"
            if (r8 != 0) goto L_0x014b
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r9)
        L_0x014b:
            if (r8 == 0) goto L_0x0207
            java.lang.String r8 = r8.toUpperCase()
            java.lang.String r10 = "(this as java.lang.String).toUpperCase()"
            kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r8, r10)
            java.lang.CharSequence r8 = (java.lang.CharSequence) r8
            int r10 = r8.length()
            int r10 = r10 - r2
            r0 = r10
            r10 = 0
            r4 = 0
        L_0x0160:
            if (r10 > r0) goto L_0x0181
            if (r4 != 0) goto L_0x0166
            r5 = r10
            goto L_0x0167
        L_0x0166:
            r5 = r0
        L_0x0167:
            char r5 = r8.charAt(r5)
            r6 = 32
            if (r5 > r6) goto L_0x0171
            r5 = 1
            goto L_0x0172
        L_0x0171:
            r5 = 0
        L_0x0172:
            if (r4 != 0) goto L_0x017b
            if (r5 != 0) goto L_0x0178
            r4 = 1
            goto L_0x0160
        L_0x0178:
            int r10 = r10 + 1
            goto L_0x0160
        L_0x017b:
            if (r5 != 0) goto L_0x017e
            goto L_0x0181
        L_0x017e:
            int r0 = r0 + -1
            goto L_0x0160
        L_0x0181:
            int r0 = r0 + r2
            java.lang.CharSequence r8 = r8.subSequence(r10, r0)
            java.lang.String r8 = r8.toString()
            r7.scanValue = r8
            java.lang.String r8 = r7.scanValue
            if (r8 != 0) goto L_0x0193
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r9)
        L_0x0193:
            java.lang.CharSequence r8 = (java.lang.CharSequence) r8
            java.lang.String r10 = "-"
            r0 = r10
            java.lang.CharSequence r0 = (java.lang.CharSequence) r0
            r4 = 2
            boolean r8 = kotlin.text.StringsKt.contains$default((java.lang.CharSequence) r8, (java.lang.CharSequence) r0, (boolean) r1, (int) r4, (java.lang.Object) r3)
            if (r8 == 0) goto L_0x0203
            java.lang.String r8 = r7.scanValue
            if (r8 != 0) goto L_0x01a8
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r9)
        L_0x01a8:
            java.lang.CharSequence r8 = (java.lang.CharSequence) r8
            kotlin.text.Regex r9 = new kotlin.text.Regex
            r9.<init>((java.lang.String) r10)
            java.util.List r8 = r9.split(r8, r1)
            boolean r9 = r8.isEmpty()
            if (r9 != 0) goto L_0x01e6
            int r9 = r8.size()
            java.util.ListIterator r9 = r8.listIterator(r9)
        L_0x01c1:
            boolean r10 = r9.hasPrevious()
            if (r10 == 0) goto L_0x01e6
            java.lang.Object r10 = r9.previous()
            java.lang.String r10 = (java.lang.String) r10
            java.lang.CharSequence r10 = (java.lang.CharSequence) r10
            int r10 = r10.length()
            if (r10 != 0) goto L_0x01d7
            r10 = 1
            goto L_0x01d8
        L_0x01d7:
            r10 = 0
        L_0x01d8:
            if (r10 != 0) goto L_0x01c1
            java.lang.Iterable r8 = (java.lang.Iterable) r8
            int r9 = r9.nextIndex()
            int r9 = r9 + r2
            java.util.List r8 = kotlin.collections.CollectionsKt.take(r8, r9)
            goto L_0x01ea
        L_0x01e6:
            java.util.List r8 = kotlin.collections.CollectionsKt.emptyList()
        L_0x01ea:
            java.util.Collection r8 = (java.util.Collection) r8
            java.lang.String[] r9 = new java.lang.String[r1]
            java.lang.Object[] r8 = r8.toArray(r9)
            if (r8 == 0) goto L_0x01fb
            java.lang.String[] r8 = (java.lang.String[]) r8
            r8 = r8[r2]
            r7.scanValue = r8
            goto L_0x0203
        L_0x01fb:
            kotlin.TypeCastException r8 = new kotlin.TypeCastException
            java.lang.String r9 = "null cannot be cast to non-null type kotlin.Array<T>"
            r8.<init>(r9)
            throw r8
        L_0x0203:
            r7.loadRefinerData(r1)
            goto L_0x020f
        L_0x0207:
            kotlin.TypeCastException r8 = new kotlin.TypeCastException
            java.lang.String r9 = "null cannot be cast to non-null type java.lang.String"
            r8.<init>(r9)
            throw r8
        L_0x020f:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.iaai.android.bdt.feature.findVehiclePage.filter.FilterFragment.onActivityResult(int, int, android.content.Intent):void");
    }

    private final void handleSubFilterRequestCode(Intent intent) {
        String str;
        String str2;
        String str3;
        String str4;
        String displayText;
        if (intent != null) {
            RecyclerView recyclerView = (RecyclerView) _$_findCachedViewById(C2723R.C2726id.rvClearFilter);
            Intrinsics.checkExpressionValueIsNotNull(recyclerView, "rvClearFilter");
            recyclerView.setVisibility(0);
            View _$_findCachedViewById = _$_findCachedViewById(C2723R.C2726id.borderBottomClearFilter);
            Intrinsics.checkExpressionValueIsNotNull(_$_findCachedViewById, "borderBottomClearFilter");
            _$_findCachedViewById.setVisibility(0);
            Bundle extras = intent.getExtras();
            String str5 = null;
            FilterValues filterValues = extras != null ? (FilterValues) extras.getParcelable(Constants_MVVM.EXTRA_SELECTED_FILTER_DATA) : null;
            Bundle extras2 = intent.getExtras();
            if (extras2 == null || (str = extras2.getString(Constants_MVVM.EXTRA_FILTER_TITLE)) == null) {
                str = "";
            }
            Bundle extras3 = intent.getExtras();
            Integer valueOf = extras3 != null ? Integer.valueOf(extras3.getInt(Constants_MVVM.EXTRA_SELECTED_FILTER_VALUE_POS, 0)) : null;
            String str6 = "All " + getDisplayName(str);
            if (filterValues != null) {
                str5 = filterValues.getDisplayText();
            }
            if (StringsKt.equals(str6, str5, true)) {
                this.selectedRefinerHashMap.remove(str);
                FilterListExpandableListAdapter filterListExpandableListAdapter = this.expandableListAdapter;
                if (filterListExpandableListAdapter == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("expandableListAdapter");
                }
                FilterListExpandableListAdapter.updateListOnSelectItem$default(filterListExpandableListAdapter, this.groupPosition, valueOf != null ? valueOf.intValue() : 0, "", 0, 8, (Object) null);
                FilterListExpandableListAdapter filterListExpandableListAdapter2 = this.expandableListAdapter;
                if (filterListExpandableListAdapter2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("expandableListAdapter");
                }
                filterListExpandableListAdapter2.notifyDataSetChanged();
            } else {
                ArrayList arrayList = new ArrayList();
                if (filterValues == null || (str2 = filterValues.getValuesId()) == null) {
                    str2 = "";
                }
                arrayList.add(str2);
                if (filterValues == null || (displayText = filterValues.getDisplayText()) == null) {
                    str3 = "";
                } else {
                    str3 = displayText;
                }
                SelectedRefinerV2 selectedRefinerV2 = new SelectedRefinerV2(str3, arrayList, false, 4, (DefaultConstructorMarker) null);
                LinkedHashMap<String, SelectedRefinerV2> linkedHashMap = this.selectedRefinerHashMap;
                if (filterValues == null || (str4 = filterValues.getDisplayText()) == null) {
                    str4 = "";
                }
                linkedHashMap.put(str4, selectedRefinerV2);
                this.selectedRefinerList.add(selectedRefinerV2);
                FilterListExpandableListAdapter filterListExpandableListAdapter3 = this.expandableListAdapter;
                if (filterListExpandableListAdapter3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("expandableListAdapter");
                }
                FilterListExpandableListAdapter.updateListOnSelectItem$default(filterListExpandableListAdapter3, this.groupPosition, valueOf != null ? valueOf.intValue() : 0, "", 0, 8, (Object) null);
                FilterListExpandableListAdapter filterListExpandableListAdapter4 = this.expandableListAdapter;
                if (filterListExpandableListAdapter4 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("expandableListAdapter");
                }
                filterListExpandableListAdapter4.notifyDataSetChanged();
            }
            if (createSetFromHashMap().size() > 0) {
                if (!this.isHeaderVisible) {
                    addHeaderView();
                }
                HeaderListAdapter headerListAdapter2 = this.headerListAdapter;
                if (headerListAdapter2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("headerListAdapter");
                }
                headerListAdapter2.setHeaderListData(createSetFromHashMap());
                HeaderListAdapter headerListAdapter3 = this.headerListAdapter;
                if (headerListAdapter3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("headerListAdapter");
                }
                headerListAdapter3.notifyDataSetChanged();
            } else {
                HeaderListAdapter headerListAdapter4 = this.headerListAdapter;
                if (headerListAdapter4 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("headerListAdapter");
                }
                headerListAdapter4.setHeaderListData(createSetFromHashMap());
                HeaderListAdapter headerListAdapter5 = this.headerListAdapter;
                if (headerListAdapter5 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("headerListAdapter");
                }
                headerListAdapter5.notifyDataSetChanged();
                ExpandableListView expandableListView = (ExpandableListView) _$_findCachedViewById(C2723R.C2726id.expandableListView);
                View view = this.header;
                if (view == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("header");
                }
                expandableListView.removeHeaderView(view);
                if (!this.isFromFilterPage) {
                    TextView textView = (TextView) _$_findCachedViewById(C2723R.C2726id.tvClearFilterFindVehicle);
                    Intrinsics.checkExpressionValueIsNotNull(textView, "tvClearFilterFindVehicle");
                    textView.setVisibility(8);
                } else {
                    TextView textView2 = (TextView) _$_findCachedViewById(C2723R.C2726id.tvClearFilter);
                    Intrinsics.checkExpressionValueIsNotNull(textView2, "tvClearFilter");
                    textView2.setVisibility(8);
                    View _$_findCachedViewById2 = _$_findCachedViewById(C2723R.C2726id.borderBottomClearFilter);
                    Intrinsics.checkExpressionValueIsNotNull(_$_findCachedViewById2, "borderBottomClearFilter");
                    _$_findCachedViewById2.setVisibility(8);
                }
                RecyclerView recyclerView2 = (RecyclerView) _$_findCachedViewById(C2723R.C2726id.rvClearFilter);
                Intrinsics.checkExpressionValueIsNotNull(recyclerView2, "rvClearFilter");
                recyclerView2.setVisibility(8);
            }
            setApplyFilterBtn(true);
            updateSearchButtonCount();
        }
    }

    private final void removeMakeModelSelected(String str) {
        String str2;
        Iterator it = this.selectedRefinerHashMap.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry entry = (Map.Entry) it.next();
            String str3 = (String) entry.getKey();
            SelectedRefinerV2 selectedRefinerV2 = (SelectedRefinerV2) entry.getValue();
            if (StringsKt.startsWith$default(str3, "Make & Model", false, 2, (Object) null)) {
                List split$default = StringsKt.split$default((CharSequence) str3, new char[]{'~'}, false, 0, 6, (Object) null);
                if (StringsKt.equals(str, "Make & Model", true)) {
                    str2 = (String) split$default.get(0);
                } else {
                    str2 = (String) split$default.get(1);
                }
                if (StringsKt.contains((CharSequence) str2, (CharSequence) str, true)) {
                    it.remove();
                }
            }
        }
        Iterator<SelectedRefinerV2> it2 = this.hashMapMakeModelArray.iterator();
        Intrinsics.checkExpressionValueIsNotNull(it2, "hashMapMakeModelArray.iterator()");
        while (it2.hasNext()) {
            if (StringsKt.contains((CharSequence) (String) StringsKt.split$default((CharSequence) it2.next().getRefinerTypeValue(), new char[]{'~'}, false, 0, 6, (Object) null).get(1), (CharSequence) str, true)) {
                it2.remove();
            }
        }
        removeLastSelectItem(str);
    }

    private final void removeLastSelectItem(String str) {
        Iterator<MakeModelValues> it = this.lastSelectedMakeModel.iterator();
        Intrinsics.checkExpressionValueIsNotNull(it, "lastSelectedMakeModel.iterator()");
        while (it.hasNext()) {
            MakeModelValues makeInfo = it.next().getMakeInfo();
            if (StringsKt.equals(makeInfo != null ? makeInfo.getDisplayText() : null, str, true)) {
                it.remove();
            }
        }
    }

    private final void handleMakeModelMultiSelectRequestCode(Intent intent) {
        ArrayList<MakeModelValues> arrayList;
        ArrayList<MakeModelValues> arrayList2;
        String str;
        String str2;
        String str3;
        MakeModelValues makeInfo;
        MakeModelValues makeInfo2;
        MakeModelValues makeInfo3;
        String displayText;
        String str4;
        if (intent != null) {
            RecyclerView recyclerView = (RecyclerView) _$_findCachedViewById(C2723R.C2726id.rvClearFilter);
            Intrinsics.checkExpressionValueIsNotNull(recyclerView, "rvClearFilter");
            int i = 0;
            recyclerView.setVisibility(0);
            View _$_findCachedViewById = _$_findCachedViewById(C2723R.C2726id.borderBottomClearFilter);
            Intrinsics.checkExpressionValueIsNotNull(_$_findCachedViewById, "borderBottomClearFilter");
            _$_findCachedViewById.setVisibility(0);
            Bundle extras = intent.getExtras();
            Integer num = null;
            Integer valueOf = extras != null ? Integer.valueOf(extras.getInt(Constants_MVVM.EXTRA_SELECTED_FILTER_VALUE_POS, 0)) : null;
            Bundle extras2 = intent.getExtras();
            if (extras2 == null || (arrayList = extras2.getParcelableArrayList(Constants_MVVM.EXTRA_SELECTED_FILTER_DATA)) == null) {
                arrayList = new ArrayList<>();
            }
            Bundle extras3 = intent.getExtras();
            if (extras3 == null || (arrayList2 = extras3.getParcelableArrayList(Constants_MVVM.EXTRA_LAST_SELECTED_MAKE_MODEL)) == null) {
                arrayList2 = new ArrayList<>();
            }
            if (arrayList != null) {
                for (MakeModelValues makeModelValues : arrayList) {
                    if (!(makeModelValues == null || (displayText = makeModelValues.getDisplayText()) == null)) {
                        StringBuilder sb = new StringBuilder();
                        sb.append("All ");
                        MakeModelValues makeInfo4 = makeModelValues.getMakeInfo();
                        sb.append(makeInfo4 != null ? makeInfo4.getDisplayText() : null);
                        if (StringsKt.startsWith(displayText, sb.toString(), true)) {
                            makeModelValues.setDisplayText("");
                            MakeModelValues makeInfo5 = makeModelValues.getMakeInfo();
                            if (makeInfo5 == null || (str4 = makeInfo5.getDisplayText()) == null) {
                                str4 = "";
                            }
                            removeMakeModelSelected(str4);
                        }
                    }
                    makeModelValues.setFilterCount(0);
                    MakeModelValues makeInfo6 = makeModelValues.getMakeInfo();
                    if (makeInfo6 != null) {
                        makeInfo6.setFilterCount(0);
                    }
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append("All ");
                    BaseActivity baseActivity = this.filterActivity;
                    if (baseActivity == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("filterActivity");
                    }
                    sb2.append(baseActivity.getTitle());
                    if (StringsKt.equals(sb2.toString(), makeModelValues != null ? makeModelValues.getDisplayText() : null, true)) {
                        Map map = this.selectedRefinerHashMap;
                        BaseActivity baseActivity2 = this.filterActivity;
                        if (baseActivity2 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("filterActivity");
                        }
                        CharSequence title = baseActivity2.getTitle();
                        if (map != null) {
                            TypeIntrinsics.asMutableMap(map).remove(title);
                        } else {
                            throw new TypeCastException("null cannot be cast to non-null type kotlin.collections.MutableMap<K, V>");
                        }
                    } else {
                        StringBuilder sb3 = new StringBuilder();
                        sb3.append((makeModelValues == null || (makeInfo3 = makeModelValues.getMakeInfo()) == null) ? null : makeInfo3.getDisplayText());
                        sb3.append(' ');
                        sb3.append(makeModelValues != null ? makeModelValues.getDisplayText() : null);
                        String sb4 = sb3.toString();
                        if (makeModelValues == null || (str2 = makeModelValues.getDisplayText()) == null) {
                            str2 = "";
                        }
                        if (str2.length() == 0) {
                            StringBuilder sb5 = new StringBuilder();
                            sb5.append("Make & Model~");
                            sb5.append((makeModelValues == null || (makeInfo2 = makeModelValues.getMakeInfo()) == null) ? null : makeInfo2.getDisplayText());
                            str3 = sb5.toString();
                        } else {
                            StringBuilder sb6 = new StringBuilder();
                            sb6.append("Make & Model~");
                            sb6.append((makeModelValues == null || (makeInfo = makeModelValues.getMakeInfo()) == null) ? null : makeInfo.getDisplayText());
                            sb6.append('~');
                            sb6.append(makeModelValues != null ? makeModelValues.getDisplayText() : null);
                            str3 = sb6.toString();
                        }
                        ArrayList arrayList3 = new ArrayList();
                        arrayList3.add(String_ExtensionKt.toCamelCase(sb4));
                        SelectedRefinerV2 selectedRefinerV2 = new SelectedRefinerV2(str3, arrayList3, false, 4, (DefaultConstructorMarker) null);
                        if (!this.hashMapMakeModelArray.contains(selectedRefinerV2)) {
                            this.hashMapMakeModelArray.add(selectedRefinerV2);
                        }
                        if (!this.lastSelectedMakeModel.contains(makeModelValues)) {
                            this.lastSelectedMakeModel.add(makeModelValues);
                        }
                        this.selectedRefinerHashMap.put(String.valueOf(str3), selectedRefinerV2);
                        this.selectedRefinerList.add(selectedRefinerV2);
                    }
                }
            }
            for (MakeModelValues makeModelValues2 : arrayList2) {
                if (!makeModelValues2.isSelected()) {
                    MakeModelValues makeInfo7 = makeModelValues2.getMakeInfo();
                    if (makeInfo7 == null || (str = makeInfo7.getDisplayText()) == null) {
                        str = "";
                    }
                    removeMakeModelSelected(str);
                }
            }
            if (this.expandableListAdapter != null) {
                FilterListExpandableListAdapter filterListExpandableListAdapter = this.expandableListAdapter;
                if (filterListExpandableListAdapter == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("expandableListAdapter");
                }
                int i2 = this.groupPosition;
                if (valueOf != null) {
                    i = valueOf.intValue();
                }
                ArrayList<SelectedRefinerV2> arrayList4 = this.hashMapMakeModelArray;
                if (arrayList4 != null) {
                    num = Integer.valueOf(arrayList4.size());
                }
                filterListExpandableListAdapter.updateListOnSelectItem(i2, i, "", num.intValue());
                FilterListExpandableListAdapter filterListExpandableListAdapter2 = this.expandableListAdapter;
                if (filterListExpandableListAdapter2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("expandableListAdapter");
                }
                filterListExpandableListAdapter2.notifyDataSetChanged();
            }
            if (createSetFromHashMap().size() > 0) {
                if (!this.isHeaderVisible) {
                    addHeaderView();
                }
                HeaderListAdapter headerListAdapter2 = this.headerListAdapter;
                if (headerListAdapter2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("headerListAdapter");
                }
                headerListAdapter2.setHeaderListData(createSetFromHashMap());
                HeaderListAdapter headerListAdapter3 = this.headerListAdapter;
                if (headerListAdapter3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("headerListAdapter");
                }
                headerListAdapter3.notifyDataSetChanged();
            } else {
                HeaderListAdapter headerListAdapter4 = this.headerListAdapter;
                if (headerListAdapter4 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("headerListAdapter");
                }
                headerListAdapter4.setHeaderListData(createSetFromHashMap());
                HeaderListAdapter headerListAdapter5 = this.headerListAdapter;
                if (headerListAdapter5 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("headerListAdapter");
                }
                headerListAdapter5.notifyDataSetChanged();
                ExpandableListView expandableListView = (ExpandableListView) _$_findCachedViewById(C2723R.C2726id.expandableListView);
                View view = this.header;
                if (view == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("header");
                }
                expandableListView.removeHeaderView(view);
                if (!this.isFromFilterPage) {
                    TextView textView = (TextView) _$_findCachedViewById(C2723R.C2726id.tvClearFilterFindVehicle);
                    Intrinsics.checkExpressionValueIsNotNull(textView, "tvClearFilterFindVehicle");
                    textView.setVisibility(8);
                } else {
                    TextView textView2 = (TextView) _$_findCachedViewById(C2723R.C2726id.tvClearFilter);
                    Intrinsics.checkExpressionValueIsNotNull(textView2, "tvClearFilter");
                    textView2.setVisibility(8);
                }
                RecyclerView recyclerView2 = (RecyclerView) _$_findCachedViewById(C2723R.C2726id.rvClearFilter);
                Intrinsics.checkExpressionValueIsNotNull(recyclerView2, "rvClearFilter");
                recyclerView2.setVisibility(8);
            }
            setApplyFilterBtn(true);
            updateSearchButtonCount();
        }
    }

    private final void removeRefinerSearch() {
        Iterator it = this.selectedRefinerList.iterator();
        int i = 0;
        while (true) {
            if (!it.hasNext()) {
                i = -1;
                break;
            } else if (StringsKt.equals(((SelectedRefinerV2) it.next()).getRefinerTypeValue(), "RefinerSearch", true)) {
                break;
            } else {
                i++;
            }
        }
        if (i != -1) {
            this.selectedRefinerList.remove(i);
        }
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
        BaseActivity baseActivity = this.filterActivity;
        if (baseActivity == null) {
            Intrinsics.throwUninitializedPropertyAccessException("filterActivity");
        }
        IAASharedPreference.setRecentalyUsedModel(baseActivity, json);
    }

    private final void loadRecentlyUsedModels() {
        Gson gson2 = new Gson();
        BaseActivity baseActivity = this.filterActivity;
        if (baseActivity == null) {
            Intrinsics.throwUninitializedPropertyAccessException("filterActivity");
        }
        String recentalyUsedModel = IAASharedPreference.getRecentalyUsedModel(baseActivity);
        Intrinsics.checkExpressionValueIsNotNull(recentalyUsedModel, "json");
        if (recentalyUsedModel.length() > 0) {
            Object fromJson = gson2.fromJson(recentalyUsedModel, new FilterFragment$loadRecentlyUsedModels$1().getType());
            Intrinsics.checkExpressionValueIsNotNull(fromJson, "gson.fromJson(json, obje…eModelValues>>() {}.type)");
            this.recentlyUsedModels = (ArrayList) fromJson;
        }
    }

    public void onItemClick(@NotNull SelectedRefinerV2 selectedRefinerV2, int i) {
        SelectedRefinerV2 selectedRefinerV22 = selectedRefinerV2;
        Intrinsics.checkParameterIsNotNull(selectedRefinerV22, "clickedItem");
        if (this.selectedRefinerList.size() > 0) {
            this.selectedRefinerList.remove(i);
        }
        if (Intrinsics.areEqual((Object) selectedRefinerV2.getRefinerTypeValue(), (Object) "yearfilter")) {
            FilterListExpandableListAdapter filterListExpandableListAdapter = this.expandableListAdapter;
            if (filterListExpandableListAdapter == null) {
                Intrinsics.throwUninitializedPropertyAccessException("expandableListAdapter");
            }
            filterListExpandableListAdapter.onClickRemoveFilter("Year", "");
            this.selectedRefinerHashMap.remove("Year");
            this.selectedRefinerHashMap.remove("yearfilter");
        } else if (StringsKt.startsWith(selectedRefinerV2.getRefinerTypeValue(), "Make & Model", true)) {
            if (selectedRefinerV2.getQuickLink()) {
                PopularCategoryListAdapter popularCategoryListAdapter2 = this.popularCategoryListAdapter;
                if (popularCategoryListAdapter2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("popularCategoryListAdapter");
                }
                popularCategoryListAdapter2.popularCategorySelect(selectedRefinerV2.getRefinerTypeValue(), false);
            }
            String refinerTypeValue = selectedRefinerV2.getRefinerTypeValue();
            this.hashMapMakeModelArray.remove(selectedRefinerV22);
            this.selectedRefinerHashMap.remove(refinerTypeValue);
            FilterListExpandableListAdapter filterListExpandableListAdapter2 = this.expandableListAdapter;
            if (filterListExpandableListAdapter2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("expandableListAdapter");
            }
            int i2 = this.makeModelGroupPosition;
            ArrayList<SelectedRefinerV2> arrayList = this.hashMapMakeModelArray;
            filterListExpandableListAdapter2.updateListOnSelectItem(i2, 0, "", (arrayList != null ? Integer.valueOf(arrayList.size()) : null).intValue());
            FilterListExpandableListAdapter filterListExpandableListAdapter3 = this.expandableListAdapter;
            if (filterListExpandableListAdapter3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("expandableListAdapter");
            }
            filterListExpandableListAdapter3.onClickRemoveFilter(selectedRefinerV2.getRefinerTypeValue(), selectedRefinerV2.getRefinerValue().get(0));
            List split$default = StringsKt.split$default((CharSequence) refinerTypeValue, new char[]{'~'}, false, 0, 6, (Object) null);
            MakeModelValues makeModelValues = new MakeModelValues("", "", false, new MakeModelValues("", "", true, (MakeModelValues) null, 0, false), 0, true);
            Log.d("Split Size", String.valueOf(split$default.size()));
            if (split$default.size() == 2) {
                String str = (String) split$default.get(1);
                MakeModelValues makeModelValues2 = new MakeModelValues(str, "", true, (MakeModelValues) null, 0, false);
                makeModelValues = new MakeModelValues("All " + str, "", false, makeModelValues2, 0, true);
            } else if (split$default.size() == 3) {
                makeModelValues = new MakeModelValues((String) split$default.get(2), "", false, new MakeModelValues((String) split$default.get(1), "", true, (MakeModelValues) null, 0, false), 0, true);
            }
            if (this.lastSelectedMakeModel.contains(makeModelValues)) {
                this.lastSelectedMakeModel.remove(makeModelValues);
            }
        } else {
            FilterListExpandableListAdapter filterListExpandableListAdapter4 = this.expandableListAdapter;
            if (filterListExpandableListAdapter4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("expandableListAdapter");
            }
            filterListExpandableListAdapter4.onClickRemoveFilter(selectedRefinerV2.getRefinerTypeValue(), selectedRefinerV2.getRefinerValue().get(0));
            if (selectedRefinerV2.getQuickLink()) {
                PopularCategoryListAdapter popularCategoryListAdapter3 = this.popularCategoryListAdapter;
                if (popularCategoryListAdapter3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("popularCategoryListAdapter");
                }
                popularCategoryListAdapter3.popularCategorySelect(selectedRefinerV2.getRefinerTypeValue(), false);
            }
            this.selectedRefinerHashMap.remove(selectedRefinerV2.getRefinerTypeValue());
        }
        if (StringsKt.equals(selectedRefinerV2.getRefinerTypeValue(), "RefinerSearch", true)) {
            TextView textView = (TextView) _$_findCachedViewById(C2723R.C2726id.filterFragmentSearch);
            Intrinsics.checkExpressionValueIsNotNull(textView, "filterFragmentSearch");
            textView.setText(getResources().getString(C2723R.string.hint_search_vehicle));
            TextView textView2 = (TextView) _$_findCachedViewById(C2723R.C2726id.tvClearFilter);
            Intrinsics.checkExpressionValueIsNotNull(textView2, "tvClearFilter");
            textView2.setVisibility(8);
            this.keywordSearch = "";
            BaseActivity baseActivity = this.filterActivity;
            if (baseActivity == null) {
                Intrinsics.throwUninitializedPropertyAccessException("filterActivity");
            }
            IAASharedPreference.setRefinerSearch(baseActivity, "");
            removeRefinerSearch();
        }
        setApplyFilterBtn(true);
        if (createSetFromHashMap().size() > 0) {
            HeaderListAdapter headerListAdapter2 = this.headerListAdapter;
            if (headerListAdapter2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("headerListAdapter");
            }
            headerListAdapter2.setHeaderListData(createSetFromHashMap());
            HeaderListAdapter headerListAdapter3 = this.headerListAdapter;
            if (headerListAdapter3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("headerListAdapter");
            }
            headerListAdapter3.notifyDataSetChanged();
        } else {
            TextView textView3 = (TextView) _$_findCachedViewById(C2723R.C2726id.tvClearFilter);
            Intrinsics.checkExpressionValueIsNotNull(textView3, "tvClearFilter");
            textView3.setVisibility(8);
            TextView textView4 = (TextView) _$_findCachedViewById(C2723R.C2726id.tvClearFilterFindVehicle);
            Intrinsics.checkExpressionValueIsNotNull(textView4, "tvClearFilterFindVehicle");
            textView4.setVisibility(8);
            RecyclerView recyclerView = (RecyclerView) _$_findCachedViewById(C2723R.C2726id.rvClearFilter);
            Intrinsics.checkExpressionValueIsNotNull(recyclerView, "rvClearFilter");
            recyclerView.setVisibility(8);
            if (this.isFromFilterPage) {
                View _$_findCachedViewById = _$_findCachedViewById(C2723R.C2726id.borderBottomClearFilter);
                Intrinsics.checkExpressionValueIsNotNull(_$_findCachedViewById, "borderBottomClearFilter");
                _$_findCachedViewById.setVisibility(8);
            }
        }
        updateSearchButtonCount();
    }

    public void onPopularCategoryItemClick(@NotNull RefinerX refinerX, boolean z) {
        Intrinsics.checkParameterIsNotNull(refinerX, "clickedItem");
        ArrayList arrayList = new ArrayList();
        arrayList.add(refinerX.getRefinerValue());
        SelectedRefinerV2 selectedRefinerV2 = new SelectedRefinerV2(refinerX.getDisplayName(), arrayList, true);
        if (z) {
            this.selectedRefinerList.add(selectedRefinerV2);
            this.selectedRefinerHashMap.put(refinerX.getDisplayName(), selectedRefinerV2);
        } else {
            this.selectedRefinerList.remove(selectedRefinerV2);
            this.selectedRefinerHashMap.remove(refinerX.getDisplayName());
            setApplyFilterBtn(true);
        }
        if (createSetFromHashMap().size() >= 1) {
            addHeaderView();
            setApplyFilterBtn(true);
        } else {
            TextView textView = (TextView) _$_findCachedViewById(C2723R.C2726id.tvClearFilter);
            Intrinsics.checkExpressionValueIsNotNull(textView, "tvClearFilter");
            textView.setVisibility(8);
            TextView textView2 = (TextView) _$_findCachedViewById(C2723R.C2726id.tvClearFilterFindVehicle);
            Intrinsics.checkExpressionValueIsNotNull(textView2, "tvClearFilterFindVehicle");
            textView2.setVisibility(8);
            RecyclerView recyclerView = (RecyclerView) _$_findCachedViewById(C2723R.C2726id.rvClearFilter);
            Intrinsics.checkExpressionValueIsNotNull(recyclerView, "rvClearFilter");
            recyclerView.setVisibility(8);
            if (this.isFromFilterPage) {
                View _$_findCachedViewById = _$_findCachedViewById(C2723R.C2726id.borderBottomClearFilter);
                Intrinsics.checkExpressionValueIsNotNull(_$_findCachedViewById, "borderBottomClearFilter");
                _$_findCachedViewById.setVisibility(8);
            }
        }
        updateSearchButtonCount();
    }

    private final void mapMasterMakeToRefiner(ArrayList<Refiner> arrayList) {
        getMasterDataForMakeModel();
        ArrayList arrayList2 = new ArrayList();
        Iterator<Refiner> it = arrayList.iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            Refiner next = it.next();
            if (StringsKt.equals(next.getDisplayName(), ExifInterface.TAG_MODEL, true)) {
                for (RefinerX add : next.getRefiners()) {
                    arrayList2.add(add);
                }
            }
        }
        Iterator<Refiner> it2 = arrayList.iterator();
        while (it2.hasNext()) {
            Refiner next2 = it2.next();
            ArrayList arrayList3 = new ArrayList();
            if (StringsKt.equals(next2.getDisplayName(), ExifInterface.TAG_MAKE, true)) {
                for (RefinerX refinerX : next2.getRefiners()) {
                    Iterator<MakeModelMaster> it3 = this.masterMakeModel.iterator();
                    while (true) {
                        if (!it3.hasNext()) {
                            break;
                        }
                        MakeModelMaster next3 = it3.next();
                        String make = next3.getMake();
                        String displayName = refinerX.getDisplayName();
                        if (displayName == null) {
                            throw new TypeCastException("null cannot be cast to non-null type kotlin.CharSequence");
                        } else if (StringsKt.equals(make, StringsKt.trim((CharSequence) displayName).toString(), true)) {
                            ArrayList arrayList4 = new ArrayList();
                            List<String> models = next3.getModels();
                            if (models == null) {
                                Intrinsics.throwNpe();
                            }
                            for (String next4 : models) {
                                if (next4.length() > 0) {
                                    arrayList4.add(new FilterSubValues(next4, "", 0));
                                }
                            }
                            List sortedWith = CollectionsKt.sortedWith(arrayList4, new FilterFragment$$special$$inlined$compareBy$1());
                            ArrayList arrayList5 = new ArrayList();
                            arrayList5.addAll(sortedWith);
                            arrayList5.add(0, new FilterSubValues("All " + next3.getMake(), "", 0));
                            arrayList3.add(new FilterValues(next3.getMake(), Integer.valueOf(refinerX.getRefinerCount()), arrayList5, "", false));
                        }
                    }
                }
                this.filterDataMakeModel = new FilterData(0, "Make & Model", 0, CollectionsKt.sortedWith(arrayList3, new FilterFragment$mapMasterMakeToRefiner$$inlined$compareBy$1()), "");
                return;
            }
        }
    }

    public final void showSoftKeyboard() {
        BaseActivity baseActivity = this.filterActivity;
        if (baseActivity == null) {
            Intrinsics.throwUninitializedPropertyAccessException("filterActivity");
        }
        if (baseActivity.getCurrentFocus() != null) {
            BaseActivity baseActivity2 = this.filterActivity;
            if (baseActivity2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("filterActivity");
            }
            Object systemService = baseActivity2.getSystemService("input_method");
            if (systemService != null) {
                InputMethodManager inputMethodManager = (InputMethodManager) systemService;
                BaseActivity baseActivity3 = this.filterActivity;
                if (baseActivity3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("filterActivity");
                }
                inputMethodManager.showSoftInput(baseActivity3.getCurrentFocus(), 1);
                return;
            }
            throw new TypeCastException("null cannot be cast to non-null type android.view.inputmethod.InputMethodManager");
        }
    }

    private final void getMasterDataForMakeModel() {
        Gson gson2 = new Gson();
        BaseActivity baseActivity = this.filterActivity;
        if (baseActivity == null) {
            Intrinsics.throwUninitializedPropertyAccessException("filterActivity");
        }
        String makeModelMasterData = IAASharedPreference.getMakeModelMasterData(baseActivity);
        Intrinsics.checkExpressionValueIsNotNull(makeModelMasterData, "json");
        if (makeModelMasterData.length() > 0) {
            Object fromJson = gson2.fromJson(makeModelMasterData, new FilterFragment$getMasterDataForMakeModel$1().getType());
            Intrinsics.checkExpressionValueIsNotNull(fromJson, "gson.fromJson(json, obje…eModelMaster>>() {}.type)");
            this.masterMakeModel = (ArrayList) fromJson;
        }
    }

    @NotNull
    public final HashSet<SelectedRefinerV2> createSetFromHashMap() {
        HashSet<SelectedRefinerV2> hashSet = new HashSet<>();
        Set<Map.Entry<String, SelectedRefinerV2>> entrySet = this.selectedRefinerHashMap.entrySet();
        Intrinsics.checkExpressionValueIsNotNull(entrySet, "selectedRefinerHashMap.entries");
        for (Map.Entry entry : entrySet) {
            if (!StringsKt.equals((String) entry.getKey(), "readyforbid", true)) {
                hashSet.add(entry.getValue());
            }
        }
        return hashSet;
    }

    /* access modifiers changed from: private */
    public final void checkCameraPermission() {
        BaseActivity baseActivity = this.filterActivity;
        if (baseActivity == null) {
            Intrinsics.throwUninitializedPropertyAccessException("filterActivity");
        }
        if (ContextCompat.checkSelfPermission(baseActivity, "android.permission.CAMERA") != 0) {
            BaseActivity baseActivity2 = this.filterActivity;
            if (baseActivity2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("filterActivity");
            }
            ActivityCompat.requestPermissions(baseActivity2, new String[]{"android.permission.CAMERA"}, 1);
            return;
        }
        navigateToCameraScreen();
    }

    private final void navigateToCameraScreen() {
        if (isCameraAvailable()) {
            IntentIntegrator.forSupportFragment(this).initiateScan();
            return;
        }
        BaseActivity baseActivity = this.filterActivity;
        if (baseActivity == null) {
            Intrinsics.throwUninitializedPropertyAccessException("filterActivity");
        }
        Toast.makeText(baseActivity, "Rear Facing Camera Unavailable", 0).show();
    }

    public void onRequestPermissionsResult(int i, @NotNull String[] strArr, @NotNull int[] iArr) {
        Intrinsics.checkParameterIsNotNull(strArr, "permissions");
        Intrinsics.checkParameterIsNotNull(iArr, "grantResults");
        if (i != 1) {
            return;
        }
        if (iArr.length <= 0 || iArr[0] != 0) {
            BaseActivity baseActivity = this.filterActivity;
            if (baseActivity == null) {
                Intrinsics.throwUninitializedPropertyAccessException("filterActivity");
            }
            AppUtils.showEnablePermissionMessage(true, baseActivity, (Fragment) null, "android.permission.CAMERA", 1);
            return;
        }
        navigateToCameraScreen();
    }

    private final boolean isCameraAvailable() {
        BaseActivity baseActivity = this.filterActivity;
        if (baseActivity == null) {
            Intrinsics.throwUninitializedPropertyAccessException("filterActivity");
        }
        Application application = baseActivity.getApplication();
        Intrinsics.checkExpressionValueIsNotNull(application, "filterActivity.application");
        PackageManager packageManager = application.getPackageManager();
        return packageManager.hasSystemFeature("android.hardware.camera") && packageManager.hasSystemFeature("android.hardware.camera.autofocus");
    }

    /* access modifiers changed from: private */
    public final void navigateToProductDetailPage(Vehicle vehicle) {
        Integer num = null;
        new Bundle().putString(Constants.EXTRA_ITEM_ID, String.valueOf(vehicle != null ? Integer.valueOf(vehicle.getItemId()) : null));
        StringBuilder sb = new StringBuilder();
        sb.append(vehicle != null ? vehicle.getYear() : null);
        sb.append(' ');
        sb.append(vehicle != null ? vehicle.getMake() : null);
        sb.append(' ');
        sb.append(vehicle != null ? vehicle.getModel() : null);
        sb.append(' ');
        String sb2 = sb.toString();
        BaseActivity baseActivity = this.filterActivity;
        if (baseActivity == null) {
            Intrinsics.throwUninitializedPropertyAccessException("filterActivity");
        }
        Intent intent = new Intent(baseActivity, ProductDetailActivity.class);
        intent.addCategory("android.intent.category.DEFAULT");
        if (vehicle != null) {
            num = Integer.valueOf(vehicle.getItemId());
        }
        intent.putExtra(Constants.EXTRA_ITEM_ID, String.valueOf(num));
        intent.putExtra("isFromSearchVehicle", false);
        intent.putExtra(Constants.EXTRA_YEAR_MAKE_MODEL, sb2);
        startActivity(intent);
    }
}

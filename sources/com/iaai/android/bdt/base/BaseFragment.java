package com.iaai.android.bdt.base;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import com.iaai.android.C2723R;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(mo66931bv = {1, 0, 3}, mo66932d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0016\u0018\u00002\u00020\u0001:\u0001\tB\u0005¢\u0006\u0002\u0010\u0002J\u0018\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0004¨\u0006\n"}, mo66933d2 = {"Lcom/iaai/android/bdt/base/BaseFragment;", "Landroidx/fragment/app/Fragment;", "()V", "displayError", "", "errorType", "Lcom/iaai/android/bdt/base/BaseFragment$ErrorType;", "message", "", "ErrorType", "app_productionRelease"}, mo66934k = 1, mo66935mv = {1, 1, 13})
/* compiled from: BaseFragment.kt */
public class BaseFragment extends Fragment {
    private HashMap _$_findViewCache;

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

    /* access modifiers changed from: protected */
    public final void displayError(@NotNull ErrorType errorType, @NotNull String str) {
        String str2;
        Intrinsics.checkParameterIsNotNull(errorType, "errorType");
        Intrinsics.checkParameterIsNotNull(str, "message");
        switch (errorType) {
            case NO_INTERNET:
                str = getString(C2723R.string.lbl_msg_no_internet_connection);
                Intrinsics.checkExpressionValueIsNotNull(str, "getString(R.string.lbl_msg_no_internet_connection)");
                break;
            case NETWORK_ERROR:
                str = getString(C2723R.string.bdt_lbl_msg_prd_network_error);
                Intrinsics.checkExpressionValueIsNotNull(str, "getString(R.string.bdt_lbl_msg_prd_network_error)");
                break;
            case NO_STOCKS:
                str = getString(C2723R.string.bdt_auction_error_type_no_stock);
                Intrinsics.checkExpressionValueIsNotNull(str, "getString(R.string.bdt_a…tion_error_type_no_stock)");
                break;
            case NO_AUCTION:
                str = getString(C2723R.string.bdt_auction_error_type_no_auction);
                Intrinsics.checkExpressionValueIsNotNull(str, "getString(R.string.bdt_a…on_error_type_no_auction)");
                break;
            case NO_VEHICLE_INFO:
                str = getString(C2723R.string.bdt_lbl_error_no_vehicle_info_title);
                Intrinsics.checkExpressionValueIsNotNull(str, "getString(R.string.bdt_l…or_no_vehicle_info_title)");
                break;
            case NO_SEARCH_RESULT:
                str = getString(C2723R.string.bdt_lbl_error_msg_no_item_found);
                Intrinsics.checkExpressionValueIsNotNull(str, "getString(R.string.bdt_l…_error_msg_no_item_found)");
                break;
            case NO_QUICK_FILTER:
                break;
            default:
                throw new NoWhenBranchMatchedException();
        }
        switch (errorType) {
            case NO_INTERNET:
                str2 = getString(C2723R.string.bdt_lbl_error_no_internet_title);
                break;
            case NETWORK_ERROR:
                str2 = getString(C2723R.string.bdt_lbl_error_network_error_title);
                break;
            case NO_STOCKS:
                str2 = getString(C2723R.string.bdt_lbl_error_no_stock_title);
                break;
            case NO_AUCTION:
                str2 = getString(C2723R.string.bdt_lbl_error_no_auction_title);
                break;
            case NO_VEHICLE_INFO:
                str2 = getString(C2723R.string.bdt_lbl_error_no_vehicle_info_title);
                break;
            case NO_SEARCH_RESULT:
                str2 = getString(C2723R.string.bdt_lbl_error_no_search_result_title);
                break;
            case NO_QUICK_FILTER:
                str2 = getString(C2723R.string.bdt_lbl_error_no_qucik_filter_title);
                break;
            default:
                throw new NoWhenBranchMatchedException();
        }
        Intrinsics.checkExpressionValueIsNotNull(str2, "when(errorType){\n\n      …\n\n            }\n        }");
        LinearLayout linearLayout = (LinearLayout) _$_findCachedViewById(C2723R.C2726id.emptyRecyclerView);
        Intrinsics.checkExpressionValueIsNotNull(linearLayout, "emptyRecyclerView");
        TextView textView = (TextView) linearLayout.findViewById(C2723R.C2726id.errorTitle);
        Intrinsics.checkExpressionValueIsNotNull(textView, "emptyRecyclerView.errorTitle");
        textView.setText(str2);
        LinearLayout linearLayout2 = (LinearLayout) _$_findCachedViewById(C2723R.C2726id.emptyRecyclerView);
        Intrinsics.checkExpressionValueIsNotNull(linearLayout2, "emptyRecyclerView");
        TextView textView2 = (TextView) linearLayout2.findViewById(C2723R.C2726id.errorBody);
        Intrinsics.checkExpressionValueIsNotNull(textView2, "emptyRecyclerView.errorBody");
        textView2.setText(str);
    }

    @Metadata(mo66931bv = {1, 0, 3}, mo66932d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000b\b\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\r¨\u0006\u000e"}, mo66933d2 = {"Lcom/iaai/android/bdt/base/BaseFragment$ErrorType;", "", "value", "", "(Ljava/lang/String;ILjava/lang/String;)V", "getValue", "()Ljava/lang/String;", "NO_INTERNET", "NETWORK_ERROR", "NO_STOCKS", "NO_AUCTION", "NO_VEHICLE_INFO", "NO_SEARCH_RESULT", "NO_QUICK_FILTER", "app_productionRelease"}, mo66934k = 1, mo66935mv = {1, 1, 13})
    /* compiled from: BaseFragment.kt */
    public enum ErrorType {
        NO_INTERNET("No Internet"),
        NETWORK_ERROR("Network Error"),
        NO_STOCKS("No Stocks"),
        NO_AUCTION("No auctions found"),
        NO_VEHICLE_INFO("No Vehicle found"),
        NO_SEARCH_RESULT("No items found for the search criteria specified."),
        NO_QUICK_FILTER("No quick filter found. Please try again later");
        
        @NotNull
        private final String value;

        private ErrorType(String str) {
            this.value = str;
        }

        @NotNull
        public final String getValue() {
            return this.value;
        }
    }
}

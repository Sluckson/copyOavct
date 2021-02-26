package com.iaai.android.bdt.feature.productDetail.prebid;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.iaai.android.C2723R;
import com.iaai.android.bdt.model.productDetail.prebid.PreBidBidHistory;
import com.iaai.android.bdt.utils.NewDateHelper;
import com.iaai.android.old.utils.constants.Constants;
import java.text.NumberFormat;
import java.util.List;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(mo66931bv = {1, 0, 3}, mo66932d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\b\u0018\u00002\u00020\u0001:\u0001 B\u001b\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\u0002\u0010\u0007J\u0018\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u000bH\u0016J\u0018\u0010\r\u001a\u00020\u000e2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\u000f\u001a\u00020\u000bH\u0016J2\u0010\u0010\u001a\u00020\u00112\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\u000f\u001a\u00020\u000b2\u0006\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u00112\u0006\u0010\u0015\u001a\u00020\u0016H\u0016J\u0010\u0010\u0017\u001a\u00020\u000b2\u0006\u0010\n\u001a\u00020\u000bH\u0016J\u0010\u0010\u0018\u001a\u00020\u00192\u0006\u0010\n\u001a\u00020\u000bH\u0016J\b\u0010\u001a\u001a\u00020\u000bH\u0016J\u0010\u0010\u001b\u001a\u00020\u000e2\u0006\u0010\n\u001a\u00020\u000bH\u0016J*\u0010\u001c\u001a\u00020\u00112\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\u001d\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u00112\u0006\u0010\u0015\u001a\u00020\u0016H\u0016J\b\u0010\u001e\u001a\u00020\u0013H\u0016J\u0018\u0010\u001f\u001a\u00020\u00132\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\u000f\u001a\u00020\u000bH\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0004¢\u0006\u0002\n\u0000¨\u0006!"}, mo66933d2 = {"Lcom/iaai/android/bdt/feature/productDetail/prebid/PreBidHistoryAdapter;", "Landroid/widget/BaseExpandableListAdapter;", "_context", "Landroid/content/Context;", "bidHistoryList", "", "Lcom/iaai/android/bdt/model/productDetail/prebid/PreBidBidHistory;", "(Landroid/content/Context;Ljava/util/List;)V", "getChild", "", "groupPosition", "", "childPosititon", "getChildId", "", "childPosition", "getChildView", "Landroid/view/View;", "isLastChild", "", "convertView", "parent", "Landroid/view/ViewGroup;", "getChildrenCount", "getGroup", "", "getGroupCount", "getGroupId", "getGroupView", "isExpanded", "hasStableIds", "isChildSelectable", "ViewHolder", "app_productionRelease"}, mo66934k = 1, mo66935mv = {1, 1, 13})
/* compiled from: PreBidHistoryAdapter.kt */
public final class PreBidHistoryAdapter extends BaseExpandableListAdapter {
    private final Context _context;
    private final List<PreBidBidHistory> bidHistoryList;

    public long getChildId(int i, int i2) {
        return (long) i2;
    }

    public int getGroupCount() {
        return 1;
    }

    public long getGroupId(int i) {
        return (long) i;
    }

    public boolean hasStableIds() {
        return false;
    }

    public boolean isChildSelectable(int i, int i2) {
        return true;
    }

    public PreBidHistoryAdapter(@NotNull Context context, @NotNull List<PreBidBidHistory> list) {
        Intrinsics.checkParameterIsNotNull(context, "_context");
        Intrinsics.checkParameterIsNotNull(list, "bidHistoryList");
        this._context = context;
        this.bidHistoryList = list;
    }

    @NotNull
    public Object getChild(int i, int i2) {
        return this.bidHistoryList.get(i2);
    }

    @NotNull
    public View getChildView(int i, int i2, boolean z, @Nullable View view, @NotNull ViewGroup viewGroup) {
        ViewHolder viewHolder;
        Intrinsics.checkParameterIsNotNull(viewGroup, "parent");
        Object child = getChild(i, i2);
        if (child != null) {
            PreBidBidHistory preBidBidHistory = (PreBidBidHistory) child;
            if (view == null) {
                Object systemService = this._context.getSystemService("layout_inflater");
                if (systemService != null) {
                    view = ((LayoutInflater) systemService).inflate(C2723R.C2728layout.item_prebidhistory_list, (ViewGroup) null);
                    if (view == null) {
                        Intrinsics.throwNpe();
                    }
                    viewHolder = new ViewHolder(view);
                    view.setTag(viewHolder);
                } else {
                    throw new TypeCastException("null cannot be cast to non-null type android.view.LayoutInflater");
                }
            } else {
                Object tag = view.getTag();
                if (tag != null) {
                    viewHolder = (ViewHolder) tag;
                } else {
                    throw new TypeCastException("null cannot be cast to non-null type com.iaai.android.bdt.feature.productDetail.prebid.PreBidHistoryAdapter.ViewHolder");
                }
            }
            viewHolder.getTxtAmount().setText(NumberFormat.getCurrencyInstance().format((long) preBidBidHistory.get_amount()));
            viewHolder.getTxtUser().setText(preBidBidHistory.get_UserName());
            if (Intrinsics.areEqual((Object) preBidBidHistory.get_UserName(), (Object) "You")) {
                viewHolder.getTxtUser().setText(C2723R.string.txt_you);
            } else {
                viewHolder.getTxtUser().setText(C2723R.string.txt_not_you);
            }
            viewHolder.getTxtDate().setText(StringsKt.replace$default(NewDateHelper.INSTANCE.format(NewDateHelper.INSTANCE.parseDateInServerTimezone(preBidBidHistory.get_date()), Constants.DATE_PATTERN_MD_BID_HISTORY), ",", "at", false, 4, (Object) null));
            return view;
        }
        throw new TypeCastException("null cannot be cast to non-null type com.iaai.android.bdt.model.productDetail.prebid.PreBidBidHistory");
    }

    @Metadata(mo66931bv = {1, 0, 3}, mo66932d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0002\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\t\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\bR\u0011\u0010\u000b\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\b¨\u0006\r"}, mo66933d2 = {"Lcom/iaai/android/bdt/feature/productDetail/prebid/PreBidHistoryAdapter$ViewHolder;", "", "parent", "Landroid/view/View;", "(Landroid/view/View;)V", "txtAmount", "Landroid/widget/TextView;", "getTxtAmount", "()Landroid/widget/TextView;", "txtDate", "getTxtDate", "txtUser", "getTxtUser", "app_productionRelease"}, mo66934k = 1, mo66935mv = {1, 1, 13})
    /* compiled from: PreBidHistoryAdapter.kt */
    private static final class ViewHolder {
        @NotNull
        private final TextView txtAmount;
        @NotNull
        private final TextView txtDate;
        @NotNull
        private final TextView txtUser;

        public ViewHolder(@NotNull View view) {
            Intrinsics.checkParameterIsNotNull(view, "parent");
            View findViewById = view.findViewById(C2723R.C2726id.txt_amount);
            if (findViewById != null) {
                this.txtAmount = (TextView) findViewById;
                View findViewById2 = view.findViewById(C2723R.C2726id.txt_user);
                if (findViewById2 != null) {
                    this.txtUser = (TextView) findViewById2;
                    View findViewById3 = view.findViewById(C2723R.C2726id.txt_date);
                    if (findViewById3 != null) {
                        this.txtDate = (TextView) findViewById3;
                        return;
                    }
                    throw new TypeCastException("null cannot be cast to non-null type android.widget.TextView");
                }
                throw new TypeCastException("null cannot be cast to non-null type android.widget.TextView");
            }
            throw new TypeCastException("null cannot be cast to non-null type android.widget.TextView");
        }

        @NotNull
        public final TextView getTxtAmount() {
            return this.txtAmount;
        }

        @NotNull
        public final TextView getTxtUser() {
            return this.txtUser;
        }

        @NotNull
        public final TextView getTxtDate() {
            return this.txtDate;
        }
    }

    public int getChildrenCount(int i) {
        return this.bidHistoryList.size();
    }

    @NotNull
    public String getGroup(int i) {
        String string = this._context.getString(C2723R.string.lbl_bid_history);
        Intrinsics.checkExpressionValueIsNotNull(string, "_context.getString(R.string.lbl_bid_history)");
        return string;
    }

    @NotNull
    public View getGroupView(int i, boolean z, @Nullable View view, @NotNull ViewGroup viewGroup) {
        Intrinsics.checkParameterIsNotNull(viewGroup, "parent");
        String group = getGroup(i);
        if (group != null) {
            if (view == null) {
                Object systemService = this._context.getSystemService("layout_inflater");
                if (systemService != null) {
                    view = ((LayoutInflater) systemService).inflate(C2723R.C2728layout.bid_history_group, (ViewGroup) null);
                } else {
                    throw new TypeCastException("null cannot be cast to non-null type android.view.LayoutInflater");
                }
            }
            if (view == null) {
                Intrinsics.throwNpe();
            }
            View findViewById = view.findViewById(C2723R.C2726id.img_header_arrow);
            if (findViewById != null) {
                ImageView imageView = (ImageView) findViewById;
                if (z) {
                    imageView.setImageResource(C2723R.C2725drawable.arrow_up);
                } else {
                    imageView.setImageResource(C2723R.C2725drawable.arrow_down);
                }
                View findViewById2 = view.findViewById(C2723R.C2726id.lbl_bid_history_header);
                if (findViewById2 != null) {
                    ((TextView) findViewById2).setText(group);
                    return view;
                }
                throw new TypeCastException("null cannot be cast to non-null type android.widget.TextView");
            }
            throw new TypeCastException("null cannot be cast to non-null type android.widget.ImageView");
        }
        throw new TypeCastException("null cannot be cast to non-null type kotlin.String");
    }
}

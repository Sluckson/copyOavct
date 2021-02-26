package com.iaai.android.old.adapter;

import android.app.Activity;
import android.database.DataSetObserver;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.iaai.android.C2723R;
import com.iaai.android.old.fragments.ToBePaidFragment;
import com.iaai.android.old.models.GetFeesResult;
import com.iaai.android.old.models.ToBePaidInfo;
import com.iaai.android.old.models.ToBePaidVehicle;
import com.iaai.android.old.utils.ICommand;
import java.util.ArrayList;
import java.util.List;

public class ToBePaidListAdapter extends BaseAdapter {
    private static LayoutInflater inflater;
    /* access modifiers changed from: private */
    public Activity activity;
    private boolean checkAll;
    private ToBePaidInfo data;
    final String guid;
    String isMyItemOnlyString;
    String lblBalanceDue = this.activity.getString(C2723R.string.lbl_balance_due);
    String lblBid = this.activity.getString(C2723R.string.lbl_bid);
    String lblConfirmation = this.activity.getString(C2723R.string.lbl_confirmation);
    String lblDueBy = this.activity.getString(C2723R.string.lbl_due_by);
    String lblFees = this.activity.getString(C2723R.string.lbl_fees);
    String lblPaid = this.activity.getString(C2723R.string.lbl_paid);
    String lblRefNumber = this.activity.getString(C2723R.string.lbl_ref_number);
    String lblTotalDue = this.activity.getString(C2723R.string.lbl_total_due);
    ToBePaidFragment mFragment;
    /* access modifiers changed from: private */
    public final ICommand<GetFeesResult> onFeesClicked;
    ArrayList<Integer> selectedPositions;
    private boolean showpaymentSelection;

    private void showFees(String[] strArr) {
    }

    public Object getItem(int i) {
        return null;
    }

    public long getItemId(int i) {
        return 0;
    }

    public ToBePaidListAdapter(ToBePaidInfo toBePaidInfo, String str, ICommand<GetFeesResult> iCommand, Activity activity2, boolean z, ToBePaidFragment toBePaidFragment) {
        this.activity = activity2;
        this.mFragment = toBePaidFragment;
        inflater = (LayoutInflater) this.activity.getSystemService("layout_inflater");
        this.data = toBePaidInfo;
        this.guid = this.data.getGuidIdentifier();
        this.isMyItemOnlyString = str;
        this.onFeesClicked = iCommand;
        this.showpaymentSelection = z;
        this.selectedPositions = new ArrayList<>();
    }

    public int getCount() {
        return this.data.tobePaidList.size();
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v1, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v1, resolved type: com.iaai.android.old.adapter.ToBePaidListAdapter$ToBePaidHolder} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public android.view.View getView(int r17, android.view.View r18, android.view.ViewGroup r19) {
        /*
            r16 = this;
            r1 = r16
            r0 = r17
            java.lang.String r2 = " "
            r3 = 0
            if (r18 != 0) goto L_0x0110
            android.view.LayoutInflater r4 = inflater
            r5 = 2131493388(0x7f0c020c, float:1.8610255E38)
            android.view.View r4 = r4.inflate(r5, r3)
            com.iaai.android.old.adapter.ToBePaidListAdapter$ToBePaidHolder r5 = new com.iaai.android.old.adapter.ToBePaidListAdapter$ToBePaidHolder
            r5.<init>()
            r6 = 2131299039(0x7f090adf, float:1.8216068E38)
            android.view.View r6 = r4.findViewById(r6)
            android.widget.TextView r6 = (android.widget.TextView) r6
            r5.ymm = r6
            r6 = 2131299013(0x7f090ac5, float:1.8216015E38)
            android.view.View r6 = r4.findViewById(r6)
            android.widget.TextView r6 = (android.widget.TextView) r6
            r5.stockno = r6
            r6 = 2131299035(0x7f090adb, float:1.821606E38)
            android.view.View r6 = r4.findViewById(r6)
            android.widget.TextView r6 = (android.widget.TextView) r6
            r5.vin = r6
            r6 = 2131298884(0x7f090a44, float:1.8215754E38)
            android.view.View r6 = r4.findViewById(r6)
            android.widget.TextView r6 = (android.widget.TextView) r6
            r5.branch = r6
            r6 = 2131298868(0x7f090a34, float:1.8215721E38)
            android.view.View r6 = r4.findViewById(r6)
            android.widget.TextView r6 = (android.widget.TextView) r6
            r5.auctiondate = r6
            r6 = 2131298882(0x7f090a42, float:1.821575E38)
            android.view.View r6 = r4.findViewById(r6)
            android.widget.TextView r6 = (android.widget.TextView) r6
            r5.bidderName = r6
            r6 = 2131299023(0x7f090acf, float:1.8216036E38)
            android.view.View r6 = r4.findViewById(r6)
            android.widget.TextView r6 = (android.widget.TextView) r6
            r5.totaldue = r6
            r6 = 2131298863(0x7f090a2f, float:1.8215711E38)
            android.view.View r6 = r4.findViewById(r6)
            android.widget.TextView r6 = (android.widget.TextView) r6
            r5.bid = r6
            r6 = 2131298914(0x7f090a62, float:1.8215815E38)
            android.view.View r6 = r4.findViewById(r6)
            android.widget.TextView r6 = (android.widget.TextView) r6
            r5.fees = r6
            r6 = 2131298905(0x7f090a59, float:1.8215796E38)
            android.view.View r6 = r4.findViewById(r6)
            android.widget.TextView r6 = (android.widget.TextView) r6
            r5.dueBy = r6
            r6 = 2131298978(0x7f090aa2, float:1.8215944E38)
            android.view.View r6 = r4.findViewById(r6)
            android.widget.TextView r6 = (android.widget.TextView) r6
            r5.paid = r6
            r6 = 2131298890(0x7f090a4a, float:1.8215766E38)
            android.view.View r6 = r4.findViewById(r6)
            android.widget.TextView r6 = (android.widget.TextView) r6
            r5.confirmation = r6
            r6 = 2131297594(0x7f09053a, float:1.8213137E38)
            android.view.View r6 = r4.findViewById(r6)
            r5.partialPaymentSection = r6
            r6 = 2131297419(0x7f09048b, float:1.8212782E38)
            android.view.View r6 = r4.findViewById(r6)
            r5.lineUnderFees = r6
            r6 = 2131297062(0x7f090326, float:1.8212058E38)
            android.view.View r6 = r4.findViewById(r6)
            r5.feesGrid = r6
            r6 = 2131297063(0x7f090327, float:1.821206E38)
            android.view.View r6 = r4.findViewById(r6)
            android.widget.GridView r6 = (android.widget.GridView) r6
            r5.gridView = r6
            r6 = 2131296735(0x7f0901df, float:1.8211395E38)
            android.view.View r6 = r4.findViewById(r6)
            android.widget.CheckBox r6 = (android.widget.CheckBox) r6
            r5.chkPaymentSelection = r6
            r6 = 2131298911(0x7f090a5f, float:1.8215809E38)
            android.view.View r6 = r4.findViewById(r6)
            android.widget.TextView r6 = (android.widget.TextView) r6
            r5.error = r6
            r6 = 2131297370(0x7f09045a, float:1.8212683E38)
            android.view.View r6 = r4.findViewById(r6)
            android.widget.TextView r6 = (android.widget.TextView) r6
            r5.lblForStock = r6
            r6 = 2131298995(0x7f090ab3, float:1.8215979E38)
            android.view.View r6 = r4.findViewById(r6)
            android.widget.TextView r6 = (android.widget.TextView) r6
            r5.lblRefNumber = r6
            r6 = 2131297597(0x7f09053d, float:1.8213143E38)
            android.view.View r6 = r4.findViewById(r6)
            r5.paymentSection = r6
            r6 = 2131297842(0x7f090632, float:1.821364E38)
            android.view.View r6 = r4.findViewById(r6)
            android.widget.ImageView r6 = (android.widget.ImageView) r6
            r5.paymentDisable = r6
            r6 = 2131296804(0x7f090224, float:1.8211535E38)
            android.view.View r6 = r4.findViewById(r6)
            android.widget.LinearLayout r6 = (android.widget.LinearLayout) r6
            r5.contextualText = r6
            r4.setTag(r5)
            goto L_0x0119
        L_0x0110:
            java.lang.Object r4 = r18.getTag()
            r5 = r4
            com.iaai.android.old.adapter.ToBePaidListAdapter$ToBePaidHolder r5 = (com.iaai.android.old.adapter.ToBePaidListAdapter.ToBePaidHolder) r5
            r4 = r18
        L_0x0119:
            com.iaai.android.old.models.ToBePaidInfo r6 = r1.data     // Catch:{ Exception -> 0x0601 }
            java.util.List r6 = r6.getTobePaidList()     // Catch:{ Exception -> 0x0601 }
            java.lang.Object r6 = r6.get(r0)     // Catch:{ Exception -> 0x0601 }
            com.iaai.android.old.models.ToBePaidVehicle r6 = (com.iaai.android.old.models.ToBePaidVehicle) r6     // Catch:{ Exception -> 0x0601 }
            android.view.View r7 = r5.lineUnderFees     // Catch:{ Exception -> 0x0601 }
            r8 = 8
            r7.setVisibility(r8)     // Catch:{ Exception -> 0x0601 }
            android.widget.TextView r7 = r5.fees     // Catch:{ Exception -> 0x0601 }
            r9 = 2131231692(0x7f0803cc, float:1.8079472E38)
            r10 = 0
            r7.setCompoundDrawablesWithIntrinsicBounds(r10, r10, r9, r10)     // Catch:{ Exception -> 0x0601 }
            android.widget.TextView r7 = r5.ymm     // Catch:{ Exception -> 0x0601 }
            java.lang.String r9 = r6.getMake()     // Catch:{ Exception -> 0x0601 }
            r7.setText(r9)     // Catch:{ Exception -> 0x0601 }
            android.widget.TextView r7 = r5.stockno     // Catch:{ Exception -> 0x0601 }
            java.lang.String r9 = r6.getStockNumber()     // Catch:{ Exception -> 0x0601 }
            r7.setText(r9)     // Catch:{ Exception -> 0x0601 }
            android.widget.TextView r7 = r5.vin     // Catch:{ Exception -> 0x0601 }
            java.lang.String r9 = r6.getVIN()     // Catch:{ Exception -> 0x0601 }
            r7.setText(r9)     // Catch:{ Exception -> 0x0601 }
            android.widget.TextView r7 = r5.branch     // Catch:{ Exception -> 0x0601 }
            java.lang.String r9 = r6.getBranchname()     // Catch:{ Exception -> 0x0601 }
            r7.setText(r9)     // Catch:{ Exception -> 0x0601 }
            android.widget.TextView r7 = r5.auctiondate     // Catch:{ Exception -> 0x0601 }
            java.lang.String r9 = r6.getAuctionDate()     // Catch:{ Exception -> 0x0601 }
            r7.setText(r9)     // Catch:{ Exception -> 0x0601 }
            android.widget.TextView r7 = r5.bidderName     // Catch:{ Exception -> 0x0601 }
            java.lang.String r9 = r6.getBidderName()     // Catch:{ Exception -> 0x0601 }
            r7.setText(r9)     // Catch:{ Exception -> 0x0601 }
            android.widget.TextView r7 = r5.bid     // Catch:{ Exception -> 0x0601 }
            java.lang.StringBuilder r9 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0601 }
            r9.<init>()     // Catch:{ Exception -> 0x0601 }
            java.lang.String r11 = r1.lblBid     // Catch:{ Exception -> 0x0601 }
            r9.append(r11)     // Catch:{ Exception -> 0x0601 }
            r9.append(r2)     // Catch:{ Exception -> 0x0601 }
            java.lang.String r11 = r6.getBidAmountString()     // Catch:{ Exception -> 0x0601 }
            r9.append(r11)     // Catch:{ Exception -> 0x0601 }
            java.lang.String r9 = r9.toString()     // Catch:{ Exception -> 0x0601 }
            r7.setText(r9)     // Catch:{ Exception -> 0x0601 }
            android.widget.TextView r7 = r5.fees     // Catch:{ Exception -> 0x0601 }
            java.lang.StringBuilder r9 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0601 }
            r9.<init>()     // Catch:{ Exception -> 0x0601 }
            java.lang.String r11 = r1.lblFees     // Catch:{ Exception -> 0x0601 }
            r9.append(r11)     // Catch:{ Exception -> 0x0601 }
            r9.append(r2)     // Catch:{ Exception -> 0x0601 }
            java.lang.String r11 = r6.getFeesString()     // Catch:{ Exception -> 0x0601 }
            r9.append(r11)     // Catch:{ Exception -> 0x0601 }
            java.lang.String r9 = r9.toString()     // Catch:{ Exception -> 0x0601 }
            r7.setText(r9)     // Catch:{ Exception -> 0x0601 }
            android.widget.TextView r7 = r5.dueBy     // Catch:{ Exception -> 0x0601 }
            java.lang.String r9 = r1.lblDueBy     // Catch:{ Exception -> 0x0601 }
            java.lang.String r9 = r6.getPaymentDueDate(r9)     // Catch:{ Exception -> 0x0601 }
            r7.setText(r9)     // Catch:{ Exception -> 0x0601 }
            boolean r7 = r6.isPartialPaymentInd()     // Catch:{ Exception -> 0x0601 }
            if (r7 == 0) goto L_0x0201
            android.view.View r7 = r5.partialPaymentSection     // Catch:{ Exception -> 0x0601 }
            r7.setVisibility(r10)     // Catch:{ Exception -> 0x0601 }
            android.widget.TextView r7 = r5.paid     // Catch:{ Exception -> 0x0601 }
            java.lang.StringBuilder r9 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0601 }
            r9.<init>()     // Catch:{ Exception -> 0x0601 }
            java.lang.String r11 = r1.lblPaid     // Catch:{ Exception -> 0x0601 }
            r9.append(r11)     // Catch:{ Exception -> 0x0601 }
            r9.append(r2)     // Catch:{ Exception -> 0x0601 }
            java.lang.String r11 = r6.getPartiallyPaidString()     // Catch:{ Exception -> 0x0601 }
            r9.append(r11)     // Catch:{ Exception -> 0x0601 }
            java.lang.String r9 = r9.toString()     // Catch:{ Exception -> 0x0601 }
            r7.setText(r9)     // Catch:{ Exception -> 0x0601 }
            android.widget.TextView r7 = r5.confirmation     // Catch:{ Exception -> 0x0601 }
            java.lang.String r9 = r1.lblConfirmation     // Catch:{ Exception -> 0x0601 }
            java.lang.String r9 = r6.getReferenceNumber(r9)     // Catch:{ Exception -> 0x0601 }
            r7.setText(r9)     // Catch:{ Exception -> 0x0601 }
            android.widget.TextView r7 = r5.totaldue     // Catch:{ Exception -> 0x0601 }
            java.lang.StringBuilder r9 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0601 }
            r9.<init>()     // Catch:{ Exception -> 0x0601 }
            java.lang.String r11 = r1.lblBalanceDue     // Catch:{ Exception -> 0x0601 }
            r9.append(r11)     // Catch:{ Exception -> 0x0601 }
            r9.append(r2)     // Catch:{ Exception -> 0x0601 }
            java.lang.String r2 = r6.getTotalDueString()     // Catch:{ Exception -> 0x0601 }
            r9.append(r2)     // Catch:{ Exception -> 0x0601 }
            java.lang.String r2 = r9.toString()     // Catch:{ Exception -> 0x0601 }
            r7.setText(r2)     // Catch:{ Exception -> 0x0601 }
            goto L_0x0249
        L_0x0201:
            android.view.View r7 = r5.partialPaymentSection     // Catch:{ Exception -> 0x0601 }
            r7.setVisibility(r8)     // Catch:{ Exception -> 0x0601 }
            android.widget.TextView r7 = r5.totaldue     // Catch:{ Exception -> 0x0601 }
            java.lang.StringBuilder r9 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0601 }
            r9.<init>()     // Catch:{ Exception -> 0x0601 }
            java.lang.String r11 = r1.lblTotalDue     // Catch:{ Exception -> 0x0601 }
            r9.append(r11)     // Catch:{ Exception -> 0x0601 }
            r9.append(r2)     // Catch:{ Exception -> 0x0601 }
            java.lang.String r2 = r6.getTotalDueString()     // Catch:{ Exception -> 0x0601 }
            r9.append(r2)     // Catch:{ Exception -> 0x0601 }
            java.lang.String r2 = r9.toString()     // Catch:{ Exception -> 0x0601 }
            r7.setText(r2)     // Catch:{ Exception -> 0x0601 }
            java.lang.String r2 = r6.ReferenceNumber     // Catch:{ Exception -> 0x0601 }
            if (r2 == 0) goto L_0x0244
            java.lang.String r2 = r6.ReferenceNumber     // Catch:{ Exception -> 0x0601 }
            java.lang.String r2 = r2.trim()     // Catch:{ Exception -> 0x0601 }
            boolean r2 = android.text.TextUtils.isEmpty(r2)     // Catch:{ Exception -> 0x0601 }
            if (r2 != 0) goto L_0x0244
            android.widget.TextView r2 = r5.lblRefNumber     // Catch:{ Exception -> 0x0601 }
            r2.setVisibility(r10)     // Catch:{ Exception -> 0x0601 }
            android.widget.TextView r2 = r5.lblRefNumber     // Catch:{ Exception -> 0x0601 }
            java.lang.String r7 = r1.lblRefNumber     // Catch:{ Exception -> 0x0601 }
            java.lang.String r7 = r6.getReferenceNumber(r7)     // Catch:{ Exception -> 0x0601 }
            r2.setText(r7)     // Catch:{ Exception -> 0x0601 }
            goto L_0x0249
        L_0x0244:
            android.widget.TextView r2 = r5.lblRefNumber     // Catch:{ Exception -> 0x0601 }
            r2.setVisibility(r8)     // Catch:{ Exception -> 0x0601 }
        L_0x0249:
            android.view.View r2 = r5.feesGrid     // Catch:{ Exception -> 0x0601 }
            r2.setVisibility(r8)     // Catch:{ Exception -> 0x0601 }
            android.view.View r2 = r5.paymentSection     // Catch:{ Exception -> 0x0601 }
            com.iaai.android.old.adapter.ToBePaidListAdapter$1 r7 = new com.iaai.android.old.adapter.ToBePaidListAdapter$1     // Catch:{ Exception -> 0x0601 }
            r7.<init>(r5, r6)     // Catch:{ Exception -> 0x0601 }
            r2.setOnClickListener(r7)     // Catch:{ Exception -> 0x0601 }
            boolean r2 = r1.showpaymentSelection     // Catch:{ Exception -> 0x0601 }
            r7 = 2131099911(0x7f060107, float:1.7812189E38)
            r9 = 2131822304(0x7f1106e0, float:1.9277376E38)
            r11 = 2131822298(0x7f1106da, float:1.9277363E38)
            r12 = 2131822300(0x7f1106dc, float:1.9277368E38)
            java.lang.String r13 = "0"
            r14 = 2131099903(0x7f0600ff, float:1.7812172E38)
            if (r2 == 0) goto L_0x0562
            android.widget.CheckBox r2 = r5.chkPaymentSelection     // Catch:{ Exception -> 0x0601 }
            r2.setVisibility(r10)     // Catch:{ Exception -> 0x0601 }
            android.widget.TextView r2 = r5.error     // Catch:{ Exception -> 0x0601 }
            r2.setVisibility(r8)     // Catch:{ Exception -> 0x0601 }
            android.widget.CheckBox r2 = r5.chkPaymentSelection     // Catch:{ Exception -> 0x0601 }
            r15 = 1
            r2.setEnabled(r15)     // Catch:{ Exception -> 0x0601 }
            java.lang.String r2 = r6.AFCResponseErrorType     // Catch:{ Exception -> 0x0601 }
            if (r2 == 0) goto L_0x02b5
            java.lang.String r2 = r6.AFCResponseErrorType     // Catch:{ Exception -> 0x0601 }
            boolean r2 = android.text.TextUtils.equals(r2, r13)     // Catch:{ Exception -> 0x0601 }
            if (r2 != 0) goto L_0x02b5
            java.lang.String r2 = r6.AFCResponseErrorType     // Catch:{ Exception -> 0x0601 }
            java.lang.String r2 = r2.trim()     // Catch:{ Exception -> 0x0601 }
            boolean r2 = android.text.TextUtils.isEmpty(r2)     // Catch:{ Exception -> 0x0601 }
            if (r2 != 0) goto L_0x02b5
            android.widget.TextView r2 = r5.error     // Catch:{ Exception -> 0x0601 }
            r2.setVisibility(r10)     // Catch:{ Exception -> 0x0601 }
            android.widget.TextView r2 = r5.error     // Catch:{ Exception -> 0x0601 }
            android.app.Activity r13 = r1.activity     // Catch:{ Exception -> 0x0601 }
            java.lang.String r11 = r13.getString(r11)     // Catch:{ Exception -> 0x0601 }
            r2.setText(r11)     // Catch:{ Exception -> 0x0601 }
            android.widget.TextView r2 = r5.error     // Catch:{ Exception -> 0x0601 }
            android.app.Activity r11 = r1.activity     // Catch:{ Exception -> 0x0601 }
            android.content.res.Resources r11 = r11.getResources()     // Catch:{ Exception -> 0x0601 }
            int r7 = r11.getColor(r7)     // Catch:{ Exception -> 0x0601 }
            r2.setTextColor(r7)     // Catch:{ Exception -> 0x0601 }
            goto L_0x02ba
        L_0x02b5:
            android.widget.TextView r2 = r5.error     // Catch:{ Exception -> 0x0601 }
            r2.setVisibility(r8)     // Catch:{ Exception -> 0x0601 }
        L_0x02ba:
            boolean r2 = r6.isEnabledRow()     // Catch:{ Exception -> 0x0601 }
            if (r2 != 0) goto L_0x02c5
            android.widget.CheckBox r2 = r5.chkPaymentSelection     // Catch:{ Exception -> 0x0601 }
            r2.setEnabled(r10)     // Catch:{ Exception -> 0x0601 }
        L_0x02c5:
            com.iaai.android.old.models.ToBePaidInfo r2 = r1.data     // Catch:{ Exception -> 0x0601 }
            boolean r2 = r2.isAFC()     // Catch:{ Exception -> 0x0601 }
            r7 = 2131099886(0x7f0600ee, float:1.7812138E38)
            if (r2 == 0) goto L_0x0305
            java.math.BigDecimal r2 = r6.getTowFee()     // Catch:{ Exception -> 0x0601 }
            float r2 = r2.floatValue()     // Catch:{ Exception -> 0x0601 }
            r11 = 1132068864(0x437a0000, float:250.0)
            int r2 = (r2 > r11 ? 1 : (r2 == r11 ? 0 : -1))
            if (r2 <= 0) goto L_0x0305
            android.widget.CheckBox r2 = r5.chkPaymentSelection     // Catch:{ Exception -> 0x0601 }
            r2.setEnabled(r10)     // Catch:{ Exception -> 0x0601 }
            android.widget.TextView r2 = r5.error     // Catch:{ Exception -> 0x0601 }
            r2.setVisibility(r10)     // Catch:{ Exception -> 0x0601 }
            android.widget.TextView r2 = r5.error     // Catch:{ Exception -> 0x0601 }
            android.app.Activity r11 = r1.activity     // Catch:{ Exception -> 0x0601 }
            r13 = 2131822305(0x7f1106e1, float:1.9277378E38)
            java.lang.String r11 = r11.getString(r13)     // Catch:{ Exception -> 0x0601 }
            r2.setText(r11)     // Catch:{ Exception -> 0x0601 }
            android.widget.TextView r2 = r5.error     // Catch:{ Exception -> 0x0601 }
            android.app.Activity r11 = r1.activity     // Catch:{ Exception -> 0x0601 }
            android.content.res.Resources r11 = r11.getResources()     // Catch:{ Exception -> 0x0601 }
            int r11 = r11.getColor(r7)     // Catch:{ Exception -> 0x0601 }
            r2.setTextColor(r11)     // Catch:{ Exception -> 0x0601 }
        L_0x0305:
            com.iaai.android.old.models.ToBePaidInfo r2 = r1.data     // Catch:{ Exception -> 0x0601 }
            boolean r2 = r2.isAFC()     // Catch:{ Exception -> 0x0601 }
            r11 = 0
            if (r2 == 0) goto L_0x0341
            java.math.BigDecimal r2 = r6.getBidAmount()     // Catch:{ Exception -> 0x0601 }
            float r2 = r2.floatValue()     // Catch:{ Exception -> 0x0601 }
            int r2 = (r2 > r11 ? 1 : (r2 == r11 ? 0 : -1))
            if (r2 > 0) goto L_0x0341
            android.widget.CheckBox r2 = r5.chkPaymentSelection     // Catch:{ Exception -> 0x0601 }
            r2.setEnabled(r10)     // Catch:{ Exception -> 0x0601 }
            android.widget.TextView r2 = r5.error     // Catch:{ Exception -> 0x0601 }
            r2.setVisibility(r10)     // Catch:{ Exception -> 0x0601 }
            android.widget.TextView r2 = r5.error     // Catch:{ Exception -> 0x0601 }
            android.app.Activity r13 = r1.activity     // Catch:{ Exception -> 0x0601 }
            r15 = 2131822301(0x7f1106dd, float:1.927737E38)
            java.lang.String r13 = r13.getString(r15)     // Catch:{ Exception -> 0x0601 }
            r2.setText(r13)     // Catch:{ Exception -> 0x0601 }
            android.widget.TextView r2 = r5.error     // Catch:{ Exception -> 0x0601 }
            android.app.Activity r13 = r1.activity     // Catch:{ Exception -> 0x0601 }
            android.content.res.Resources r13 = r13.getResources()     // Catch:{ Exception -> 0x0601 }
            int r13 = r13.getColor(r7)     // Catch:{ Exception -> 0x0601 }
            r2.setTextColor(r13)     // Catch:{ Exception -> 0x0601 }
        L_0x0341:
            boolean r2 = r6.isAlaskaInd()     // Catch:{ Exception -> 0x0601 }
            if (r2 == 0) goto L_0x036e
            android.widget.CheckBox r2 = r5.chkPaymentSelection     // Catch:{ Exception -> 0x0601 }
            r2.setEnabled(r10)     // Catch:{ Exception -> 0x0601 }
            android.widget.TextView r2 = r5.error     // Catch:{ Exception -> 0x0601 }
            r2.setVisibility(r10)     // Catch:{ Exception -> 0x0601 }
            android.widget.TextView r2 = r5.error     // Catch:{ Exception -> 0x0601 }
            android.app.Activity r13 = r1.activity     // Catch:{ Exception -> 0x0601 }
            r15 = 2131822299(0x7f1106db, float:1.9277366E38)
            java.lang.String r13 = r13.getString(r15)     // Catch:{ Exception -> 0x0601 }
            r2.setText(r13)     // Catch:{ Exception -> 0x0601 }
            android.widget.TextView r2 = r5.error     // Catch:{ Exception -> 0x0601 }
            android.app.Activity r13 = r1.activity     // Catch:{ Exception -> 0x0601 }
            android.content.res.Resources r13 = r13.getResources()     // Catch:{ Exception -> 0x0601 }
            int r13 = r13.getColor(r7)     // Catch:{ Exception -> 0x0601 }
            r2.setTextColor(r13)     // Catch:{ Exception -> 0x0601 }
        L_0x036e:
            com.iaai.android.old.models.ToBePaidInfo r2 = r1.data     // Catch:{ Exception -> 0x0601 }
            boolean r2 = r2.isAFC()     // Catch:{ Exception -> 0x0601 }
            if (r2 == 0) goto L_0x03af
            boolean r2 = r6.isAFCEligibleOnSoldDate()     // Catch:{ Exception -> 0x0601 }
            if (r2 != 0) goto L_0x03af
            java.math.BigDecimal r2 = r6.getBidAmount()     // Catch:{ Exception -> 0x0601 }
            float r2 = r2.floatValue()     // Catch:{ Exception -> 0x0601 }
            int r2 = (r2 > r11 ? 1 : (r2 == r11 ? 0 : -1))
            if (r2 <= 0) goto L_0x03af
            android.widget.CheckBox r2 = r5.chkPaymentSelection     // Catch:{ Exception -> 0x0601 }
            r2.setEnabled(r10)     // Catch:{ Exception -> 0x0601 }
            android.widget.TextView r2 = r5.error     // Catch:{ Exception -> 0x0601 }
            r2.setVisibility(r10)     // Catch:{ Exception -> 0x0601 }
            android.widget.TextView r2 = r5.error     // Catch:{ Exception -> 0x0601 }
            android.app.Activity r11 = r1.activity     // Catch:{ Exception -> 0x0601 }
            r13 = 2131822302(0x7f1106de, float:1.9277372E38)
            java.lang.String r11 = r11.getString(r13)     // Catch:{ Exception -> 0x0601 }
            r2.setText(r11)     // Catch:{ Exception -> 0x0601 }
            android.widget.TextView r2 = r5.error     // Catch:{ Exception -> 0x0601 }
            android.app.Activity r11 = r1.activity     // Catch:{ Exception -> 0x0601 }
            android.content.res.Resources r11 = r11.getResources()     // Catch:{ Exception -> 0x0601 }
            int r11 = r11.getColor(r7)     // Catch:{ Exception -> 0x0601 }
            r2.setTextColor(r11)     // Catch:{ Exception -> 0x0601 }
        L_0x03af:
            com.iaai.android.old.models.ToBePaidInfo r2 = r1.data     // Catch:{ Exception -> 0x0601 }
            boolean r2 = r2.isAFC()     // Catch:{ Exception -> 0x0601 }
            if (r2 == 0) goto L_0x03e4
            boolean r2 = r6.isPartialPaymentInd()     // Catch:{ Exception -> 0x0601 }
            if (r2 == 0) goto L_0x03e4
            android.widget.CheckBox r2 = r5.chkPaymentSelection     // Catch:{ Exception -> 0x0601 }
            r2.setEnabled(r10)     // Catch:{ Exception -> 0x0601 }
            android.widget.TextView r2 = r5.error     // Catch:{ Exception -> 0x0601 }
            r2.setVisibility(r10)     // Catch:{ Exception -> 0x0601 }
            android.widget.TextView r2 = r5.error     // Catch:{ Exception -> 0x0601 }
            android.app.Activity r11 = r1.activity     // Catch:{ Exception -> 0x0601 }
            r13 = 2131822303(0x7f1106df, float:1.9277374E38)
            java.lang.String r11 = r11.getString(r13)     // Catch:{ Exception -> 0x0601 }
            r2.setText(r11)     // Catch:{ Exception -> 0x0601 }
            android.widget.TextView r2 = r5.error     // Catch:{ Exception -> 0x0601 }
            android.app.Activity r11 = r1.activity     // Catch:{ Exception -> 0x0601 }
            android.content.res.Resources r11 = r11.getResources()     // Catch:{ Exception -> 0x0601 }
            int r7 = r11.getColor(r7)     // Catch:{ Exception -> 0x0601 }
            r2.setTextColor(r7)     // Catch:{ Exception -> 0x0601 }
        L_0x03e4:
            java.lang.String r2 = r6.DiscloserMessage     // Catch:{ Exception -> 0x0601 }
            if (r2 == 0) goto L_0x03fe
            boolean r2 = r6.isEnabledRow()     // Catch:{ Exception -> 0x0601 }
            if (r2 != 0) goto L_0x03fe
            android.widget.LinearLayout r2 = r5.contextualText     // Catch:{ Exception -> 0x0601 }
            r2.setVisibility(r10)     // Catch:{ Exception -> 0x0601 }
            android.widget.LinearLayout r2 = r5.contextualText     // Catch:{ Exception -> 0x0601 }
            com.iaai.android.old.adapter.ToBePaidListAdapter$2 r7 = new com.iaai.android.old.adapter.ToBePaidListAdapter$2     // Catch:{ Exception -> 0x0601 }
            r7.<init>(r6)     // Catch:{ Exception -> 0x0601 }
            r2.setOnClickListener(r7)     // Catch:{ Exception -> 0x0601 }
            goto L_0x0403
        L_0x03fe:
            android.widget.LinearLayout r2 = r5.contextualText     // Catch:{ Exception -> 0x0601 }
            r2.setVisibility(r8)     // Catch:{ Exception -> 0x0601 }
        L_0x0403:
            boolean r2 = r6.isFinancedItem()     // Catch:{ Exception -> 0x0601 }
            if (r2 == 0) goto L_0x042e
            android.widget.CheckBox r2 = r5.chkPaymentSelection     // Catch:{ Exception -> 0x0601 }
            r2.setEnabled(r10)     // Catch:{ Exception -> 0x0601 }
            android.widget.TextView r2 = r5.error     // Catch:{ Exception -> 0x0601 }
            r2.setVisibility(r10)     // Catch:{ Exception -> 0x0601 }
            android.widget.TextView r2 = r5.error     // Catch:{ Exception -> 0x0601 }
            android.app.Activity r7 = r1.activity     // Catch:{ Exception -> 0x0601 }
            java.lang.String r7 = r7.getString(r12)     // Catch:{ Exception -> 0x0601 }
            r2.setText(r7)     // Catch:{ Exception -> 0x0601 }
            android.widget.TextView r2 = r5.error     // Catch:{ Exception -> 0x0601 }
            android.app.Activity r7 = r1.activity     // Catch:{ Exception -> 0x0601 }
            android.content.res.Resources r7 = r7.getResources()     // Catch:{ Exception -> 0x0601 }
            int r7 = r7.getColor(r14)     // Catch:{ Exception -> 0x0601 }
            r2.setTextColor(r7)     // Catch:{ Exception -> 0x0601 }
            goto L_0x045f
        L_0x042e:
            java.lang.String r2 = r6.ReferenceNumber     // Catch:{ Exception -> 0x0601 }
            java.lang.String r2 = r2.trim()     // Catch:{ Exception -> 0x0601 }
            boolean r2 = android.text.TextUtils.isEmpty(r2)     // Catch:{ Exception -> 0x0601 }
            if (r2 != 0) goto L_0x045f
            boolean r2 = r6.isEnabledRow()     // Catch:{ Exception -> 0x0601 }
            if (r2 != 0) goto L_0x045f
            android.widget.TextView r2 = r5.error     // Catch:{ Exception -> 0x0601 }
            r2.setVisibility(r10)     // Catch:{ Exception -> 0x0601 }
            android.widget.TextView r2 = r5.error     // Catch:{ Exception -> 0x0601 }
            android.app.Activity r7 = r1.activity     // Catch:{ Exception -> 0x0601 }
            java.lang.String r7 = r7.getString(r9)     // Catch:{ Exception -> 0x0601 }
            r2.setText(r7)     // Catch:{ Exception -> 0x0601 }
            android.widget.TextView r2 = r5.error     // Catch:{ Exception -> 0x0601 }
            android.app.Activity r7 = r1.activity     // Catch:{ Exception -> 0x0601 }
            android.content.res.Resources r7 = r7.getResources()     // Catch:{ Exception -> 0x0601 }
            int r7 = r7.getColor(r14)     // Catch:{ Exception -> 0x0601 }
            r2.setTextColor(r7)     // Catch:{ Exception -> 0x0601 }
        L_0x045f:
            android.widget.CheckBox r2 = r5.chkPaymentSelection     // Catch:{ Exception -> 0x0601 }
            r2.setOnCheckedChangeListener(r3)     // Catch:{ Exception -> 0x0601 }
            boolean r2 = r1.checkAll     // Catch:{ Exception -> 0x0601 }
            if (r2 == 0) goto L_0x0492
            java.util.ArrayList<java.lang.Integer> r2 = r1.selectedPositions     // Catch:{ Exception -> 0x0601 }
            java.lang.Integer r3 = java.lang.Integer.valueOf(r17)     // Catch:{ Exception -> 0x0601 }
            boolean r2 = r2.contains(r3)     // Catch:{ Exception -> 0x0601 }
            if (r2 == 0) goto L_0x0492
            android.widget.CheckBox r2 = r5.chkPaymentSelection     // Catch:{ Exception -> 0x0601 }
            boolean r2 = r2.isEnabled()     // Catch:{ Exception -> 0x0601 }
            if (r2 == 0) goto L_0x0483
            android.widget.CheckBox r2 = r5.chkPaymentSelection     // Catch:{ Exception -> 0x0601 }
            r3 = 1
            r2.setChecked(r3)     // Catch:{ Exception -> 0x0601 }
            goto L_0x04aa
        L_0x0483:
            android.widget.CheckBox r2 = r5.chkPaymentSelection     // Catch:{ Exception -> 0x0601 }
            r2.setChecked(r10)     // Catch:{ Exception -> 0x0601 }
            java.util.ArrayList<java.lang.Integer> r2 = r1.selectedPositions     // Catch:{ Exception -> 0x0601 }
            java.lang.Integer r3 = java.lang.Integer.valueOf(r17)     // Catch:{ Exception -> 0x0601 }
            r2.remove(r3)     // Catch:{ Exception -> 0x0601 }
            goto L_0x04aa
        L_0x0492:
            java.util.ArrayList<java.lang.Integer> r2 = r1.selectedPositions     // Catch:{ Exception -> 0x0601 }
            java.lang.Integer r3 = java.lang.Integer.valueOf(r17)     // Catch:{ Exception -> 0x0601 }
            boolean r2 = r2.contains(r3)     // Catch:{ Exception -> 0x0601 }
            if (r2 == 0) goto L_0x04a5
            android.widget.CheckBox r2 = r5.chkPaymentSelection     // Catch:{ Exception -> 0x0601 }
            r3 = 1
            r2.setChecked(r3)     // Catch:{ Exception -> 0x0601 }
            goto L_0x04aa
        L_0x04a5:
            android.widget.CheckBox r2 = r5.chkPaymentSelection     // Catch:{ Exception -> 0x0601 }
            r2.setChecked(r10)     // Catch:{ Exception -> 0x0601 }
        L_0x04aa:
            android.widget.CheckBox r2 = r5.chkPaymentSelection     // Catch:{ Exception -> 0x0601 }
            com.iaai.android.old.adapter.ToBePaidListAdapter$3 r3 = new com.iaai.android.old.adapter.ToBePaidListAdapter$3     // Catch:{ Exception -> 0x0601 }
            r3.<init>(r0)     // Catch:{ Exception -> 0x0601 }
            r2.setOnCheckedChangeListener(r3)     // Catch:{ Exception -> 0x0601 }
            android.widget.CheckBox r0 = r5.chkPaymentSelection     // Catch:{ Exception -> 0x0601 }
            boolean r0 = r0.isEnabled()     // Catch:{ Exception -> 0x0601 }
            if (r0 != 0) goto L_0x0510
            r0 = 2131230998(0x7f080116, float:1.8078065E38)
            r4.setBackgroundResource(r0)     // Catch:{ Exception -> 0x0601 }
            android.widget.TextView r0 = r5.ymm     // Catch:{ Exception -> 0x0601 }
            r0.setEnabled(r10)     // Catch:{ Exception -> 0x0601 }
            android.widget.TextView r0 = r5.stockno     // Catch:{ Exception -> 0x0601 }
            r0.setEnabled(r10)     // Catch:{ Exception -> 0x0601 }
            android.widget.TextView r0 = r5.lblForStock     // Catch:{ Exception -> 0x0601 }
            r0.setEnabled(r10)     // Catch:{ Exception -> 0x0601 }
            android.widget.TextView r0 = r5.vin     // Catch:{ Exception -> 0x0601 }
            r0.setEnabled(r10)     // Catch:{ Exception -> 0x0601 }
            android.widget.TextView r0 = r5.branch     // Catch:{ Exception -> 0x0601 }
            r0.setEnabled(r10)     // Catch:{ Exception -> 0x0601 }
            android.widget.TextView r0 = r5.auctiondate     // Catch:{ Exception -> 0x0601 }
            r0.setEnabled(r10)     // Catch:{ Exception -> 0x0601 }
            android.widget.TextView r0 = r5.bidderName     // Catch:{ Exception -> 0x0601 }
            r0.setEnabled(r10)     // Catch:{ Exception -> 0x0601 }
            android.widget.TextView r0 = r5.bid     // Catch:{ Exception -> 0x0601 }
            r0.setEnabled(r10)     // Catch:{ Exception -> 0x0601 }
            android.widget.TextView r0 = r5.dueBy     // Catch:{ Exception -> 0x0601 }
            r0.setEnabled(r10)     // Catch:{ Exception -> 0x0601 }
            android.widget.TextView r0 = r5.totaldue     // Catch:{ Exception -> 0x0601 }
            r0.setEnabled(r10)     // Catch:{ Exception -> 0x0601 }
            android.widget.TextView r0 = r5.fees     // Catch:{ Exception -> 0x0601 }
            r0.setEnabled(r10)     // Catch:{ Exception -> 0x0601 }
            boolean r0 = r6.isPartialPaymentInd()     // Catch:{ Exception -> 0x0601 }
            if (r0 == 0) goto L_0x0605
            android.view.View r0 = r5.partialPaymentSection     // Catch:{ Exception -> 0x0601 }
            r0.setEnabled(r10)     // Catch:{ Exception -> 0x0601 }
            android.widget.TextView r0 = r5.paid     // Catch:{ Exception -> 0x0601 }
            r0.setEnabled(r10)     // Catch:{ Exception -> 0x0601 }
            android.widget.TextView r0 = r5.confirmation     // Catch:{ Exception -> 0x0601 }
            r0.setEnabled(r10)     // Catch:{ Exception -> 0x0601 }
            goto L_0x0605
        L_0x0510:
            r4.setBackgroundResource(r10)     // Catch:{ Exception -> 0x0601 }
            android.widget.TextView r0 = r5.ymm     // Catch:{ Exception -> 0x0601 }
            r2 = 1
            r0.setEnabled(r2)     // Catch:{ Exception -> 0x0601 }
            android.widget.TextView r0 = r5.stockno     // Catch:{ Exception -> 0x0601 }
            r0.setEnabled(r2)     // Catch:{ Exception -> 0x0601 }
            android.widget.TextView r0 = r5.lblForStock     // Catch:{ Exception -> 0x0601 }
            r0.setEnabled(r2)     // Catch:{ Exception -> 0x0601 }
            android.widget.TextView r0 = r5.vin     // Catch:{ Exception -> 0x0601 }
            r0.setEnabled(r2)     // Catch:{ Exception -> 0x0601 }
            android.widget.TextView r0 = r5.branch     // Catch:{ Exception -> 0x0601 }
            r0.setEnabled(r2)     // Catch:{ Exception -> 0x0601 }
            android.widget.TextView r0 = r5.auctiondate     // Catch:{ Exception -> 0x0601 }
            r0.setEnabled(r2)     // Catch:{ Exception -> 0x0601 }
            android.widget.TextView r0 = r5.bidderName     // Catch:{ Exception -> 0x0601 }
            r0.setEnabled(r2)     // Catch:{ Exception -> 0x0601 }
            android.widget.TextView r0 = r5.bid     // Catch:{ Exception -> 0x0601 }
            r0.setEnabled(r2)     // Catch:{ Exception -> 0x0601 }
            android.widget.TextView r0 = r5.dueBy     // Catch:{ Exception -> 0x0601 }
            r0.setEnabled(r2)     // Catch:{ Exception -> 0x0601 }
            android.widget.TextView r0 = r5.totaldue     // Catch:{ Exception -> 0x0601 }
            r0.setEnabled(r2)     // Catch:{ Exception -> 0x0601 }
            android.widget.TextView r0 = r5.fees     // Catch:{ Exception -> 0x0601 }
            r0.setEnabled(r2)     // Catch:{ Exception -> 0x0601 }
            boolean r0 = r6.isPartialPaymentInd()     // Catch:{ Exception -> 0x0601 }
            if (r0 == 0) goto L_0x0605
            android.view.View r0 = r5.partialPaymentSection     // Catch:{ Exception -> 0x0601 }
            r0.setEnabled(r2)     // Catch:{ Exception -> 0x0601 }
            android.widget.TextView r0 = r5.paid     // Catch:{ Exception -> 0x0601 }
            r0.setEnabled(r2)     // Catch:{ Exception -> 0x0601 }
            android.widget.TextView r0 = r5.confirmation     // Catch:{ Exception -> 0x0601 }
            r0.setEnabled(r2)     // Catch:{ Exception -> 0x0601 }
            goto L_0x0605
        L_0x0562:
            android.widget.CheckBox r0 = r5.chkPaymentSelection     // Catch:{ Exception -> 0x0601 }
            r0.setVisibility(r8)     // Catch:{ Exception -> 0x0601 }
            java.lang.String r0 = r6.AFCResponseErrorType     // Catch:{ Exception -> 0x0601 }
            if (r0 == 0) goto L_0x059f
            java.lang.String r0 = r6.AFCResponseErrorType     // Catch:{ Exception -> 0x0601 }
            boolean r0 = android.text.TextUtils.equals(r0, r13)     // Catch:{ Exception -> 0x0601 }
            if (r0 != 0) goto L_0x059f
            java.lang.String r0 = r6.AFCResponseErrorType     // Catch:{ Exception -> 0x0601 }
            java.lang.String r0 = r0.trim()     // Catch:{ Exception -> 0x0601 }
            boolean r0 = android.text.TextUtils.isEmpty(r0)     // Catch:{ Exception -> 0x0601 }
            if (r0 != 0) goto L_0x059f
            android.widget.TextView r0 = r5.error     // Catch:{ Exception -> 0x0601 }
            r0.setVisibility(r10)     // Catch:{ Exception -> 0x0601 }
            android.widget.TextView r0 = r5.error     // Catch:{ Exception -> 0x0601 }
            android.app.Activity r2 = r1.activity     // Catch:{ Exception -> 0x0601 }
            java.lang.String r2 = r2.getString(r11)     // Catch:{ Exception -> 0x0601 }
            r0.setText(r2)     // Catch:{ Exception -> 0x0601 }
            android.widget.TextView r0 = r5.error     // Catch:{ Exception -> 0x0601 }
            android.app.Activity r2 = r1.activity     // Catch:{ Exception -> 0x0601 }
            android.content.res.Resources r2 = r2.getResources()     // Catch:{ Exception -> 0x0601 }
            int r2 = r2.getColor(r7)     // Catch:{ Exception -> 0x0601 }
            r0.setTextColor(r2)     // Catch:{ Exception -> 0x0601 }
            goto L_0x05a4
        L_0x059f:
            android.widget.TextView r0 = r5.error     // Catch:{ Exception -> 0x0601 }
            r0.setVisibility(r8)     // Catch:{ Exception -> 0x0601 }
        L_0x05a4:
            boolean r0 = r6.isFinancedItem()     // Catch:{ Exception -> 0x0601 }
            if (r0 == 0) goto L_0x05cf
            android.widget.CheckBox r0 = r5.chkPaymentSelection     // Catch:{ Exception -> 0x0601 }
            r0.setEnabled(r10)     // Catch:{ Exception -> 0x0601 }
            android.widget.TextView r0 = r5.error     // Catch:{ Exception -> 0x0601 }
            r0.setVisibility(r10)     // Catch:{ Exception -> 0x0601 }
            android.widget.TextView r0 = r5.error     // Catch:{ Exception -> 0x0601 }
            android.app.Activity r2 = r1.activity     // Catch:{ Exception -> 0x0601 }
            java.lang.String r2 = r2.getString(r12)     // Catch:{ Exception -> 0x0601 }
            r0.setText(r2)     // Catch:{ Exception -> 0x0601 }
            android.widget.TextView r0 = r5.error     // Catch:{ Exception -> 0x0601 }
            android.app.Activity r2 = r1.activity     // Catch:{ Exception -> 0x0601 }
            android.content.res.Resources r2 = r2.getResources()     // Catch:{ Exception -> 0x0601 }
            int r2 = r2.getColor(r14)     // Catch:{ Exception -> 0x0601 }
            r0.setTextColor(r2)     // Catch:{ Exception -> 0x0601 }
            goto L_0x0605
        L_0x05cf:
            java.lang.String r0 = r6.ReferenceNumber     // Catch:{ Exception -> 0x0601 }
            java.lang.String r0 = r0.trim()     // Catch:{ Exception -> 0x0601 }
            boolean r0 = android.text.TextUtils.isEmpty(r0)     // Catch:{ Exception -> 0x0601 }
            if (r0 != 0) goto L_0x0605
            boolean r0 = r6.isEnabledRow()     // Catch:{ Exception -> 0x0601 }
            if (r0 != 0) goto L_0x0605
            android.widget.TextView r0 = r5.error     // Catch:{ Exception -> 0x0601 }
            r0.setVisibility(r10)     // Catch:{ Exception -> 0x0601 }
            android.widget.TextView r0 = r5.error     // Catch:{ Exception -> 0x0601 }
            android.app.Activity r2 = r1.activity     // Catch:{ Exception -> 0x0601 }
            java.lang.String r2 = r2.getString(r9)     // Catch:{ Exception -> 0x0601 }
            r0.setText(r2)     // Catch:{ Exception -> 0x0601 }
            android.widget.TextView r0 = r5.error     // Catch:{ Exception -> 0x0601 }
            android.app.Activity r2 = r1.activity     // Catch:{ Exception -> 0x0601 }
            android.content.res.Resources r2 = r2.getResources()     // Catch:{ Exception -> 0x0601 }
            int r2 = r2.getColor(r14)     // Catch:{ Exception -> 0x0601 }
            r0.setTextColor(r2)     // Catch:{ Exception -> 0x0601 }
            goto L_0x0605
        L_0x0601:
            r0 = move-exception
            r0.printStackTrace()
        L_0x0605:
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.iaai.android.old.adapter.ToBePaidListAdapter.getView(int, android.view.View, android.view.ViewGroup):android.view.View");
    }

    public void addAllVehicleListTo(List<ToBePaidVehicle> list) {
        for (int i = 0; i < list.size(); i++) {
            this.selectedPositions.add(Integer.valueOf(i));
        }
    }

    public void registerDataSetObserver(DataSetObserver dataSetObserver) {
        super.registerDataSetObserver(dataSetObserver);
    }

    static class ToBePaidHolder {
        TextView auctiondate;
        TextView bid;
        TextView bidderName;
        TextView branch;
        CheckBox chkPaymentSelection;
        TextView confirmation;
        LinearLayout contextualText;
        TextView dueBy;
        TextView error;
        TextView fees;
        View feesGrid;
        GridView gridView;
        TextView lblForStock;
        TextView lblRefNumber;
        View lineUnderFees;
        TextView paid;
        View partialPaymentSection;
        ImageView paymentDisable;
        View paymentSection;
        TextView stockno;
        TextView totaldue;
        TextView vin;
        TextView ymm;

        ToBePaidHolder() {
        }
    }

    public void notifyDataSetChanged() {
        super.notifyDataSetChanged();
    }

    public void notifyDataSetChanged(ToBePaidInfo toBePaidInfo) {
        this.data = toBePaidInfo;
        notifyDataSetChanged();
    }

    public void isCheckedAll(boolean z) {
        this.checkAll = z;
        if (z) {
            addAllVehicleListTo(this.data.getTobePaidList());
        } else {
            this.selectedPositions.clear();
        }
    }
}

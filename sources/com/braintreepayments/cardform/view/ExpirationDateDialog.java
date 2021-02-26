package com.braintreepayments.cardform.view;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.Rect;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.os.Handler;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.GridView;
import com.braintreepayments.cardform.C1011R;
import com.braintreepayments.cardform.utils.ExpirationDateDialogTheme;
import com.braintreepayments.cardform.utils.ExpirationDateItemAdapter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Collections;
import java.util.List;

public class ExpirationDateDialog extends Dialog implements DialogInterface.OnShowListener {
    /* access modifiers changed from: private */
    public static final List<String> MONTHS = Arrays.asList(new String[]{"01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12"});
    /* access modifiers changed from: private */
    public final int CURRENT_MONTH = (Calendar.getInstance().get(2) + 1);
    /* access modifiers changed from: private */
    public final int CURRENT_YEAR = Calendar.getInstance().get(1);
    private int mAnimationDelay;
    /* access modifiers changed from: private */
    public ExpirationDateEditText mEditText;
    /* access modifiers changed from: private */
    public boolean mHasSelectedMonth;
    /* access modifiers changed from: private */
    public boolean mHasSelectedYear;
    /* access modifiers changed from: private */
    public int mSelectedMonth = -1;
    /* access modifiers changed from: private */
    public int mSelectedYear = -1;
    private ExpirationDateDialogTheme mTheme;
    private GridView mYearGridView;
    /* access modifiers changed from: private */
    public final List<String> mYears = new ArrayList();

    protected ExpirationDateDialog(Context context) {
        super(context);
    }

    protected ExpirationDateDialog(Context context, int i) {
        super(context, i);
    }

    protected ExpirationDateDialog(Context context, boolean z, DialogInterface.OnCancelListener onCancelListener) {
        super(context, z, onCancelListener);
    }

    public static ExpirationDateDialog create(Activity activity, ExpirationDateEditText expirationDateEditText) {
        ExpirationDateDialog expirationDateDialog;
        ExpirationDateDialogTheme detectTheme = ExpirationDateDialogTheme.detectTheme(activity);
        if (detectTheme == ExpirationDateDialogTheme.LIGHT) {
            expirationDateDialog = new ExpirationDateDialog(activity, C1011R.C1017style.bt_expiration_date_dialog_light);
        } else {
            expirationDateDialog = new ExpirationDateDialog(activity, C1011R.C1017style.bt_expiration_date_dialog_dark);
        }
        expirationDateDialog.setOwnerActivity(activity);
        expirationDateDialog.mTheme = detectTheme;
        expirationDateDialog.mEditText = expirationDateEditText;
        return expirationDateDialog;
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(C1011R.C1016layout.bt_expiration_date_sheet);
        this.mAnimationDelay = getContext().getResources().getInteger(17694720);
        getWindow().setLayout(-1, -2);
        getWindow().setGravity(80);
        getWindow().setBackgroundDrawable(new ColorDrawable(0));
        setOnShowListener(this);
        for (int i = 0; i < 20; i++) {
            this.mYears.add(Integer.toString(this.CURRENT_YEAR + i));
        }
        final ExpirationDateItemAdapter expirationDateItemAdapter = new ExpirationDateItemAdapter(getContext(), this.mTheme, MONTHS);
        final ExpirationDateItemAdapter expirationDateItemAdapter2 = new ExpirationDateItemAdapter(getContext(), this.mTheme, this.mYears);
        ((GridView) findViewById(C1011R.C1014id.bt_expiration_month_grid_view)).setAdapter(expirationDateItemAdapter);
        expirationDateItemAdapter.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                boolean unused = ExpirationDateDialog.this.mHasSelectedMonth = true;
                int unused2 = ExpirationDateDialog.this.mSelectedMonth = i;
                ExpirationDateDialog.this.setExpirationDate();
                if (Integer.parseInt((String) ExpirationDateDialog.MONTHS.get(i)) < ExpirationDateDialog.this.CURRENT_MONTH) {
                    expirationDateItemAdapter2.setDisabled(Collections.singletonList(0));
                } else {
                    expirationDateItemAdapter2.setDisabled(new ArrayList());
                }
            }
        });
        this.mYearGridView = (GridView) findViewById(C1011R.C1014id.bt_expiration_year_grid_view);
        this.mYearGridView.setAdapter(expirationDateItemAdapter2);
        expirationDateItemAdapter2.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                boolean unused = ExpirationDateDialog.this.mHasSelectedYear = true;
                int unused2 = ExpirationDateDialog.this.mSelectedYear = i;
                ExpirationDateDialog.this.setExpirationDate();
                if (Integer.parseInt((String) ExpirationDateDialog.this.mYears.get(i)) == ExpirationDateDialog.this.CURRENT_YEAR) {
                    ArrayList arrayList = new ArrayList();
                    for (int i2 = 0; i2 < ExpirationDateDialog.MONTHS.size(); i2++) {
                        if (Integer.parseInt((String) ExpirationDateDialog.MONTHS.get(i2)) < ExpirationDateDialog.this.CURRENT_MONTH) {
                            arrayList.add(Integer.valueOf(i2));
                        }
                    }
                    expirationDateItemAdapter.setDisabled(arrayList);
                    return;
                }
                expirationDateItemAdapter.setDisabled(new ArrayList());
            }
        });
        this.mSelectedMonth = MONTHS.indexOf(this.mEditText.getMonth());
        int i2 = this.mSelectedMonth;
        if (i2 >= 0) {
            expirationDateItemAdapter.setSelected(i2);
        }
        this.mSelectedYear = this.mYears.indexOf(this.mEditText.getYear());
        int i3 = this.mSelectedYear;
        if (i3 >= 0) {
            expirationDateItemAdapter2.setSelected(i3);
        }
    }

    public void show() {
        new Handler().postDelayed(new Runnable() {
            public void run() {
                Activity ownerActivity = ExpirationDateDialog.this.getOwnerActivity();
                if (ExpirationDateDialog.this.mEditText.isFocused() && ownerActivity != null && !ownerActivity.isFinishing()) {
                    ExpirationDateDialog.super.show();
                }
            }
        }, (long) this.mAnimationDelay);
    }

    public void onShow(DialogInterface dialogInterface) {
        int i = this.mSelectedYear;
        if (i > 0) {
            this.mYearGridView.smoothScrollToPosition(i);
        }
        this.mHasSelectedMonth = false;
        this.mHasSelectedYear = false;
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Code restructure failed: missing block: B:12:0x004c, code lost:
        r0 = r5.mEditText.focusNextView();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void setExpirationDate() {
        /*
            r5 = this;
            int r0 = r5.mSelectedMonth
            r1 = -1
            if (r0 != r1) goto L_0x0008
            java.lang.String r0 = "  "
            goto L_0x0010
        L_0x0008:
            java.util.List<java.lang.String> r2 = MONTHS
            java.lang.Object r0 = r2.get(r0)
            java.lang.String r0 = (java.lang.String) r0
        L_0x0010:
            int r2 = r5.mSelectedYear
            if (r2 != r1) goto L_0x0026
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            r1.append(r0)
            java.lang.String r0 = "    "
            r1.append(r0)
            java.lang.String r0 = r1.toString()
            goto L_0x003f
        L_0x0026:
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            r1.append(r0)
            java.util.List<java.lang.String> r0 = r5.mYears
            int r2 = r5.mSelectedYear
            java.lang.Object r0 = r0.get(r2)
            java.lang.String r0 = (java.lang.String) r0
            r1.append(r0)
            java.lang.String r0 = r1.toString()
        L_0x003f:
            com.braintreepayments.cardform.view.ExpirationDateEditText r1 = r5.mEditText
            r1.setText(r0)
            boolean r0 = r5.mHasSelectedMonth
            if (r0 == 0) goto L_0x0064
            boolean r0 = r5.mHasSelectedYear
            if (r0 == 0) goto L_0x0064
            com.braintreepayments.cardform.view.ExpirationDateEditText r0 = r5.mEditText
            android.view.View r0 = r0.focusNextView()
            if (r0 == 0) goto L_0x0064
            android.os.Handler r1 = new android.os.Handler
            r1.<init>()
            com.braintreepayments.cardform.view.ExpirationDateDialog$4 r2 = new com.braintreepayments.cardform.view.ExpirationDateDialog$4
            r2.<init>(r0)
            int r0 = r5.mAnimationDelay
            long r3 = (long) r0
            r1.postDelayed(r2, r3)
        L_0x0064:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.braintreepayments.cardform.view.ExpirationDateDialog.setExpirationDate():void");
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        boolean z = motionEvent.getAction() == 0 && isOutOfBounds(motionEvent) && getWindow().peekDecorView() != null;
        if (!isShowing() || !z) {
            return false;
        }
        View rootView = getOwnerActivity().getWindow().getDecorView().getRootView();
        final View findViewAt = rootView instanceof ViewGroup ? findViewAt((ViewGroup) rootView, (int) motionEvent.getRawX(), (int) motionEvent.getRawY()) : null;
        if (findViewAt != null && findViewAt != this.mEditText) {
            dismiss();
            if (findViewAt instanceof EditText) {
                findViewAt.requestFocus();
                new Handler().postDelayed(new Runnable() {
                    public void run() {
                        ((InputMethodManager) ExpirationDateDialog.this.getContext().getSystemService("input_method")).showSoftInput(findViewAt, 0);
                    }
                }, (long) this.mAnimationDelay);
            } else if (findViewAt instanceof Button) {
                findViewAt.callOnClick();
            }
        } else if (findViewAt == null) {
            dismiss();
        }
        return true;
    }

    private View findViewAt(ViewGroup viewGroup, int i, int i2) {
        for (int i3 = 0; i3 < viewGroup.getChildCount(); i3++) {
            View childAt = viewGroup.getChildAt(i3);
            if (childAt instanceof ViewGroup) {
                View findViewAt = findViewAt((ViewGroup) childAt, i, i2);
                if (findViewAt != null && findViewAt.isShown()) {
                    return findViewAt;
                }
            } else {
                int[] iArr = new int[2];
                childAt.getLocationOnScreen(iArr);
                if (new Rect(iArr[0], iArr[1], iArr[0] + childAt.getWidth(), iArr[1] + childAt.getHeight()).contains(i, i2)) {
                    return childAt;
                }
            }
        }
        return null;
    }

    private boolean isOutOfBounds(MotionEvent motionEvent) {
        int x = (int) motionEvent.getX();
        int y = (int) motionEvent.getY();
        int scaledWindowTouchSlop = ViewConfiguration.get(getContext()).getScaledWindowTouchSlop();
        View decorView = getWindow().getDecorView();
        int i = -scaledWindowTouchSlop;
        return x < i || y < i || x > decorView.getWidth() + scaledWindowTouchSlop || y > decorView.getHeight() + scaledWindowTouchSlop;
    }
}

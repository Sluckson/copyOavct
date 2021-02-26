package com.iaai.android.old.widgets;

import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.ScrollView;
import android.widget.TextView;
import com.iaai.android.C2723R;
import com.iaai.android.bdt.utils.Constants_MVVM;
import java.util.Locale;

public class CustomPopupWindow {
    private LinearLayout mContainer;
    private ScrollView mContainerScroll;
    private Context mContext;
    private LayoutInflater mInflater;
    /* access modifiers changed from: private */
    public OnPopupItemClickListener mItemListenr;
    private PopupType mPopupType;
    /* access modifiers changed from: private */
    public PopupWindow mPopupWindow;

    public interface OnPopupItemClickListener {
        void onItemClick(String str, int i);
    }

    public enum PopupType {
        TEXT_ITEM_ONLY,
        TEXT_WITH_IMAGE_ITEM
    }

    public CustomPopupWindow(Context context) {
        this.mContext = context;
        this.mPopupWindow = new PopupWindow(context);
        this.mInflater = LayoutInflater.from(context);
        this.mContainerScroll = (ScrollView) this.mInflater.inflate(C2723R.C2728layout.popup_container, (ViewGroup) null, false);
        this.mContainer = (LinearLayout) this.mContainerScroll.findViewById(C2723R.C2726id.popup_container);
    }

    public CustomPopupWindow(Context context, PopupType popupType) {
        this(context);
        this.mPopupType = popupType;
    }

    public void addPopupItem(int i, int i2) {
        View inflate = this.mInflater.inflate(C2723R.C2728layout.popup_item_one_textview, this.mContainer, false);
        final TextView textView = (TextView) inflate.findViewById(C2723R.C2726id.tv_popup_item);
        textView.setText(i);
        textView.setId(i2);
        textView.setSingleLine(true);
        textView.setEllipsize(TextUtils.TruncateAt.END);
        inflate.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                CustomPopupWindow.this.mItemListenr.onItemClick(textView.getText().toString(), textView.getId());
                CustomPopupWindow.this.mPopupWindow.dismiss();
            }
        });
        this.mContainer.addView(inflate);
    }

    public void addPopupItemUsingString(String str, int i) {
        View inflate = this.mInflater.inflate(C2723R.C2728layout.popup_item_one_textview, this.mContainer, false);
        final TextView textView = (TextView) inflate.findViewById(C2723R.C2726id.tv_popup_item);
        textView.setText(str);
        textView.setId(i);
        textView.setSingleLine(true);
        textView.setEllipsize(TextUtils.TruncateAt.MIDDLE);
        inflate.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                CustomPopupWindow.this.mItemListenr.onItemClick(textView.getText().toString(), textView.getId());
                CustomPopupWindow.this.mPopupWindow.dismiss();
            }
        });
        this.mContainer.addView(inflate);
    }

    public void addPopupItemWithDisableState(String str, int i) {
        View inflate = this.mInflater.inflate(C2723R.C2728layout.popup_item_one_textview, this.mContainer, false);
        final TextView textView = (TextView) inflate.findViewById(C2723R.C2726id.tv_popup_item);
        textView.setText(str);
        textView.setId(i);
        textView.setEnabled(false);
        textView.setSingleLine(true);
        textView.setEllipsize(TextUtils.TruncateAt.MIDDLE);
        inflate.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                CustomPopupWindow.this.mItemListenr.onItemClick(textView.getText().toString(), textView.getId());
                CustomPopupWindow.this.mPopupWindow.dismiss();
            }
        });
        this.mContainer.addView(inflate);
    }

    public void addPopupItem(int i) {
        addPopupItem(i, 0);
    }

    public void addPopupItemForShrink(int i, int i2) {
        View inflate = this.mInflater.inflate(C2723R.C2728layout.popup_item_shrink_textview, this.mContainer, false);
        final TextView textView = (TextView) inflate.findViewById(C2723R.C2726id.tv_popup_item);
        textView.setText(i);
        textView.setId(i2);
        inflate.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                if (CustomPopupWindow.this.mItemListenr != null) {
                    CustomPopupWindow.this.mItemListenr.onItemClick(textView.getText().toString(), textView.getId());
                }
                CustomPopupWindow.this.mPopupWindow.dismiss();
            }
        });
        this.mContainer.addView(inflate);
    }

    public void show(View view) {
        if (Locale.getDefault().getLanguage().equals(Constants_MVVM.EXTRA_SPANISH_CODE)) {
            this.mPopupWindow.setWidth(dpToPx(225));
        } else {
            this.mPopupWindow.setWidth(this.mContext.getResources().getDisplayMetrics().widthPixels / 2);
        }
        this.mPopupWindow.setHeight(-2);
        this.mPopupWindow.setOutsideTouchable(true);
        this.mPopupWindow.setContentView(this.mContainerScroll);
        view.getLocationOnScreen(new int[2]);
        this.mContainerScroll.measure(-2, -2);
        this.mPopupWindow.showAsDropDown(view);
    }

    public void showBiggerTextPopUp(View view) {
        if (Locale.getDefault().getLanguage().equals(Constants_MVVM.EXTRA_SPANISH_CODE)) {
            this.mPopupWindow.setWidth(this.mContext.getResources().getDisplayMetrics().widthPixels);
        } else {
            this.mPopupWindow.setWidth((this.mContext.getResources().getDisplayMetrics().widthPixels * 3) / 4);
        }
        this.mPopupWindow.setHeight(-2);
        this.mPopupWindow.setOutsideTouchable(true);
        this.mPopupWindow.setContentView(this.mContainerScroll);
        view.getLocationOnScreen(new int[2]);
        this.mContainerScroll.measure(-2, -2);
        this.mPopupWindow.showAsDropDown(view);
    }

    public void showBiggerTextForToBePickedUp(View view) {
        if (Locale.getDefault().getLanguage().equals(Constants_MVVM.EXTRA_SPANISH_CODE)) {
            this.mPopupWindow.setWidth((this.mContext.getResources().getDisplayMetrics().widthPixels * 3) / 4);
        } else {
            this.mPopupWindow.setWidth(this.mContext.getResources().getDisplayMetrics().widthPixels / 2);
        }
        this.mPopupWindow.setHeight(-2);
        this.mPopupWindow.setOutsideTouchable(true);
        this.mPopupWindow.setContentView(this.mContainerScroll);
        view.getLocationOnScreen(new int[2]);
        this.mContainerScroll.measure(-2, -2);
        this.mPopupWindow.showAsDropDown(view);
    }

    public void showForIbidLive(View view, int i) {
        if (Locale.getDefault().getLanguage().equals(Constants_MVVM.EXTRA_SPANISH_CODE)) {
            this.mPopupWindow.setWidth(dpToPx(225));
        } else {
            this.mPopupWindow.setWidth((this.mContext.getResources().getDisplayMetrics().widthPixels * 3) / 4);
        }
        if (this.mContainer.getChildCount() > i) {
            this.mPopupWindow.setHeight(this.mContainer.getChildAt(0).getHeight() * i);
        } else {
            this.mPopupWindow.setHeight(-2);
        }
        this.mPopupWindow.setOutsideTouchable(true);
        this.mPopupWindow.setContentView(this.mContainerScroll);
        view.getLocationOnScreen(new int[2]);
        this.mContainerScroll.measure(-2, -2);
        this.mPopupWindow.showAsDropDown(view);
    }

    public int dpToPx(int i) {
        return Math.round(((float) i) * (this.mContext.getResources().getDisplayMetrics().xdpi / 160.0f));
    }

    public void dismiss() {
        if (this.mPopupWindow != null && isShowing()) {
            this.mPopupWindow.dismiss();
        }
    }

    public boolean isShowing() {
        return this.mPopupWindow.isShowing();
    }

    public void setOnPopupItemClickListener(OnPopupItemClickListener onPopupItemClickListener) {
        this.mItemListenr = onPopupItemClickListener;
    }

    public void setOnDismissListener(PopupWindow.OnDismissListener onDismissListener) {
        this.mPopupWindow.setOnDismissListener(onDismissListener);
    }
}

package com.braintreepayments.cardform.utils;

import android.content.Context;
import android.graphics.RectF;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.RoundRectShape;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import com.braintreepayments.cardform.C1011R;
import java.util.ArrayList;
import java.util.List;

public class ExpirationDateItemAdapter extends ArrayAdapter<String> {
    private List<Integer> mDisabledPositions = new ArrayList();
    /* access modifiers changed from: private */
    public AdapterView.OnItemClickListener mOnItemClickListener;
    private ShapeDrawable mSelectedItemBackground;
    /* access modifiers changed from: private */
    public int mSelectedPosition = -1;
    private ExpirationDateDialogTheme mTheme;

    public ExpirationDateItemAdapter(Context context, int i) {
        super(context, i);
    }

    public ExpirationDateItemAdapter(Context context, int i, int i2) {
        super(context, i, i2);
    }

    public ExpirationDateItemAdapter(Context context, int i, String[] strArr) {
        super(context, i, strArr);
    }

    public ExpirationDateItemAdapter(Context context, int i, int i2, String[] strArr) {
        super(context, i, i2, strArr);
    }

    public ExpirationDateItemAdapter(Context context, int i, List<String> list) {
        super(context, i, list);
    }

    public ExpirationDateItemAdapter(Context context, int i, int i2, List<String> list) {
        super(context, i, i2, list);
    }

    public ExpirationDateItemAdapter(Context context, ExpirationDateDialogTheme expirationDateDialogTheme, List<String> list) {
        super(context, C1011R.C1016layout.bt_expiration_date_item, list);
        this.mTheme = expirationDateDialogTheme;
        float dimension = context.getResources().getDimension(C1011R.dimen.bt_expiration_date_item_selected_background_radius);
        this.mSelectedItemBackground = new ShapeDrawable(new RoundRectShape(new float[]{dimension, dimension, dimension, dimension, dimension, dimension, dimension, dimension}, (RectF) null, (float[]) null));
        this.mSelectedItemBackground.getPaint().setColor(this.mTheme.getSelectedItemBackground());
    }

    public void setOnItemClickListener(AdapterView.OnItemClickListener onItemClickListener) {
        this.mOnItemClickListener = onItemClickListener;
    }

    public void setSelected(int i) {
        this.mSelectedPosition = i;
        notifyDataSetChanged();
    }

    public void setDisabled(List<Integer> list) {
        this.mDisabledPositions = list;
        notifyDataSetChanged();
    }

    public View getView(final int i, View view, ViewGroup viewGroup) {
        TextView textView = (TextView) super.getView(i, view, viewGroup);
        textView.setEnabled(true);
        if (this.mSelectedPosition == i) {
            textView.setBackgroundDrawable(this.mSelectedItemBackground);
            textView.setTextColor(this.mTheme.getItemInvertedTextColor());
        } else {
            textView.setBackgroundResource(17170445);
            if (this.mDisabledPositions.contains(Integer.valueOf(i))) {
                textView.setTextColor(this.mTheme.getItemDisabledTextColor());
                textView.setEnabled(false);
            } else {
                textView.setTextColor(this.mTheme.getItemTextColor());
            }
        }
        textView.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                int unused = ExpirationDateItemAdapter.this.mSelectedPosition = i;
                ExpirationDateItemAdapter.this.notifyDataSetChanged();
                VibrationHelper.vibrate(ExpirationDateItemAdapter.this.getContext(), 10);
                if (ExpirationDateItemAdapter.this.mOnItemClickListener != null) {
                    AdapterView.OnItemClickListener access$100 = ExpirationDateItemAdapter.this.mOnItemClickListener;
                    int i = i;
                    access$100.onItemClick((AdapterView) null, view, i, (long) i);
                }
            }
        });
        return textView;
    }
}

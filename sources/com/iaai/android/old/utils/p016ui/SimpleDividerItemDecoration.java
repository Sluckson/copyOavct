package com.iaai.android.old.utils.p016ui;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.view.View;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;
import com.iaai.android.C2723R;

/* renamed from: com.iaai.android.old.utils.ui.SimpleDividerItemDecoration */
public class SimpleDividerItemDecoration extends RecyclerView.ItemDecoration {
    private Drawable mDivider;

    public SimpleDividerItemDecoration(Context context) {
        this.mDivider = ContextCompat.getDrawable(context, C2723R.C2725drawable.line_divider);
    }

    public void onDrawOver(Canvas canvas, RecyclerView recyclerView, RecyclerView.State state) {
        int paddingLeft = recyclerView.getPaddingLeft();
        int width = recyclerView.getWidth() - recyclerView.getPaddingRight();
        int childCount = recyclerView.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = recyclerView.getChildAt(i);
            int bottom = childAt.getBottom() + ((RecyclerView.LayoutParams) childAt.getLayoutParams()).bottomMargin;
            this.mDivider.setBounds(paddingLeft, bottom, width, this.mDivider.getIntrinsicHeight() + bottom);
            this.mDivider.draw(canvas);
        }
    }
}

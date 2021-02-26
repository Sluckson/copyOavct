package com.iaai.android.old.utils.p016ui;

import androidx.viewpager.widget.ViewPager;

/* renamed from: com.iaai.android.old.utils.ui.PageIndicator */
public interface PageIndicator extends ViewPager.OnPageChangeListener {
    void notifyDataSetChanged();

    void setCurrentItem(int i);

    void setOnPageChangeListener(ViewPager.OnPageChangeListener onPageChangeListener);

    void setViewPager(ViewPager viewPager);

    void setViewPager(ViewPager viewPager, int i);
}

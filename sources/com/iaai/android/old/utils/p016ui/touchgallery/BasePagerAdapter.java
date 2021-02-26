package com.iaai.android.old.utils.p016ui.touchgallery;

import android.content.Context;
import android.os.Parcelable;
import android.view.View;
import android.view.ViewGroup;
import androidx.viewpager.widget.PagerAdapter;
import java.util.List;

/* renamed from: com.iaai.android.old.utils.ui.touchgallery.BasePagerAdapter */
public class BasePagerAdapter extends PagerAdapter {
    protected final Context mContext;
    protected int mCurrentPosition;
    protected OnItemChangeListener mOnItemChangeListener;
    protected final List<String> mResources;

    /* renamed from: com.iaai.android.old.utils.ui.touchgallery.BasePagerAdapter$OnItemChangeListener */
    public interface OnItemChangeListener {
        void onItemChange(int i);
    }

    public void finishUpdate(ViewGroup viewGroup) {
    }

    public void restoreState(Parcelable parcelable, ClassLoader classLoader) {
    }

    public Parcelable saveState() {
        return null;
    }

    public void startUpdate(ViewGroup viewGroup) {
    }

    public BasePagerAdapter() {
        this.mCurrentPosition = -1;
        this.mResources = null;
        this.mContext = null;
    }

    public BasePagerAdapter(Context context, List<String> list) {
        this.mCurrentPosition = -1;
        this.mResources = list;
        this.mContext = context;
    }

    public void setPrimaryItem(ViewGroup viewGroup, int i, Object obj) {
        super.setPrimaryItem(viewGroup, i, obj);
        if (this.mCurrentPosition != i) {
            GalleryViewPager galleryViewPager = (GalleryViewPager) viewGroup;
            if (galleryViewPager.mCurrentView != null) {
                galleryViewPager.mCurrentView.resetScale();
            }
            this.mCurrentPosition = i;
            OnItemChangeListener onItemChangeListener = this.mOnItemChangeListener;
            if (onItemChangeListener != null) {
                onItemChangeListener.onItemChange(this.mCurrentPosition);
            }
        }
    }

    public void destroyItem(ViewGroup viewGroup, int i, Object obj) {
        viewGroup.removeView((View) obj);
    }

    public int getCount() {
        return this.mResources.size();
    }

    public boolean isViewFromObject(View view, Object obj) {
        return view.equals(obj);
    }

    public int getCurrentPosition() {
        return this.mCurrentPosition;
    }

    public void setOnItemChangeListener(OnItemChangeListener onItemChangeListener) {
        this.mOnItemChangeListener = onItemChangeListener;
    }
}

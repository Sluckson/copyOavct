package com.iaai.android.old.utils.p016ui.touchgallery;

import android.content.Context;
import android.view.ViewGroup;
import com.iaai.android.old.activities.ImageClickListener;
import java.util.List;

/* renamed from: com.iaai.android.old.utils.ui.touchgallery.UrlPagerAdapter */
public class UrlPagerAdapter extends BasePagerAdapter {
    ImageClickListener imageClickListener;
    Context mContext;

    public UrlPagerAdapter(Context context, List<String> list, ImageClickListener imageClickListener2) {
        super(context, list);
        this.mContext = context;
        this.imageClickListener = imageClickListener2;
    }

    public void setPrimaryItem(ViewGroup viewGroup, int i, Object obj) {
        super.setPrimaryItem(viewGroup, i, obj);
        ((GalleryViewPager) viewGroup).mCurrentView = ((UrlTouchImageView) obj).getImageView();
    }

    public Object instantiateItem(ViewGroup viewGroup, int i) {
        UrlTouchImageView urlTouchImageView = new UrlTouchImageView(this.mContext, this.imageClickListener);
        urlTouchImageView.setUrl((String) this.mResources.get(i));
        urlTouchImageView.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        viewGroup.addView(urlTouchImageView, 0);
        return urlTouchImageView;
    }
}

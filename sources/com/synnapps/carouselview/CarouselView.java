package com.synnapps.carouselview;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RemoteViews;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;
import java.util.Timer;
import java.util.TimerTask;

@RemoteViews.RemoteView
public class CarouselView extends FrameLayout {
    public static final int DEFAULT_INDICATOR_VISIBILITY = 0;
    private static final int DEFAULT_SLIDE_INTERVAL = 3500;
    private static final int DEFAULT_SLIDE_VELOCITY = 400;
    private final int DEFAULT_GRAVITY = 81;
    /* access modifiers changed from: private */
    public boolean animateOnBoundary = true;
    private boolean autoPlay;
    ViewPager.OnPageChangeListener carouselOnPageChangeListener = new ViewPager.OnPageChangeListener() {
        public void onPageScrolled(int i, float f, int i2) {
        }

        public void onPageSelected(int i) {
        }

        public void onPageScrollStateChanged(int i) {
            if (CarouselView.this.previousState != 1 || i != 2) {
                int access$300 = CarouselView.this.previousState;
            } else if (CarouselView.this.disableAutoPlayOnUserInteraction) {
                CarouselView.this.pauseCarousel();
            } else {
                CarouselView.this.playCarousel();
            }
            int unused = CarouselView.this.previousState = i;
        }
    };
    /* access modifiers changed from: private */
    public CarouselViewPager containerViewPager;
    /* access modifiers changed from: private */
    public boolean disableAutoPlayOnUserInteraction;
    private ImageClickListener imageClickListener = null;
    private int indicatorMarginHorizontal;
    private int indicatorMarginVertical;
    private int indicatorVisibility = 0;
    /* access modifiers changed from: private */
    public ImageListener mImageListener = null;
    private CirclePageIndicator mIndicator;
    private int mIndicatorGravity = 81;
    private int mPageCount;
    /* access modifiers changed from: private */
    public ViewListener mViewListener = null;
    private int pageTransformInterval = 400;
    private ViewPager.PageTransformer pageTransformer;
    /* access modifiers changed from: private */
    public int previousState;
    private int slideInterval = DEFAULT_SLIDE_INTERVAL;
    private SwipeTask swipeTask;
    private Timer swipeTimer;

    public CarouselView(Context context) {
        super(context);
    }

    public CarouselView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        initView(context, attributeSet, 0, 0);
    }

    public CarouselView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        initView(context, attributeSet, i, 0);
    }

    @TargetApi(21)
    public CarouselView(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        initView(context, attributeSet, i, i2);
    }

    private void initView(Context context, AttributeSet attributeSet, int i, int i2) {
        if (!isInEditMode()) {
            View inflate = LayoutInflater.from(context).inflate(C4210R.C4214layout.view_carousel, this, true);
            this.containerViewPager = (CarouselViewPager) inflate.findViewById(C4210R.C4213id.containerViewPager);
            this.mIndicator = (CirclePageIndicator) inflate.findViewById(C4210R.C4213id.indicator);
            this.containerViewPager.addOnPageChangeListener(this.carouselOnPageChangeListener);
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, C4210R.styleable.CarouselView, i, 0);
            try {
                this.indicatorMarginVertical = obtainStyledAttributes.getDimensionPixelSize(C4210R.styleable.CarouselView_indicatorMarginVertical, getResources().getDimensionPixelSize(C4210R.dimen.default_indicator_margin_vertical));
                this.indicatorMarginHorizontal = obtainStyledAttributes.getDimensionPixelSize(C4210R.styleable.CarouselView_indicatorMarginHorizontal, getResources().getDimensionPixelSize(C4210R.dimen.default_indicator_margin_horizontal));
                setPageTransformInterval(obtainStyledAttributes.getInt(C4210R.styleable.CarouselView_pageTransformInterval, 400));
                setSlideInterval(obtainStyledAttributes.getInt(C4210R.styleable.CarouselView_slideInterval, DEFAULT_SLIDE_INTERVAL));
                setOrientation(obtainStyledAttributes.getInt(C4210R.styleable.CarouselView_indicatorOrientation, 0));
                setIndicatorGravity(obtainStyledAttributes.getInt(C4210R.styleable.CarouselView_indicatorGravity, 81));
                setAutoPlay(obtainStyledAttributes.getBoolean(C4210R.styleable.CarouselView_autoPlay, true));
                setDisableAutoPlayOnUserInteraction(obtainStyledAttributes.getBoolean(C4210R.styleable.CarouselView_disableAutoPlayOnUserInteraction, false));
                setAnimateOnBoundary(obtainStyledAttributes.getBoolean(C4210R.styleable.CarouselView_animateOnBoundary, true));
                setPageTransformer(obtainStyledAttributes.getInt(C4210R.styleable.CarouselView_pageTransformer, -1));
                this.indicatorVisibility = obtainStyledAttributes.getInt(C4210R.styleable.CarouselView_indicatorVisibility, 0);
                setIndicatorVisibility(this.indicatorVisibility);
                if (this.indicatorVisibility == 0) {
                    int color = obtainStyledAttributes.getColor(C4210R.styleable.CarouselView_fillColor, 0);
                    if (color != 0) {
                        setFillColor(color);
                    }
                    int color2 = obtainStyledAttributes.getColor(C4210R.styleable.CarouselView_pageColor, 0);
                    if (color2 != 0) {
                        setPageColor(color2);
                    }
                    float dimensionPixelSize = (float) obtainStyledAttributes.getDimensionPixelSize(C4210R.styleable.CarouselView_radius, 0);
                    if (dimensionPixelSize != 0.0f) {
                        setRadius(dimensionPixelSize);
                    }
                    setSnap(obtainStyledAttributes.getBoolean(C4210R.styleable.CarouselView_snap, getResources().getBoolean(C4210R.bool.default_circle_indicator_snap)));
                    int color3 = obtainStyledAttributes.getColor(C4210R.styleable.CarouselView_strokeColor, 0);
                    if (color3 != 0) {
                        setStrokeColor(color3);
                    }
                    float dimensionPixelSize2 = (float) obtainStyledAttributes.getDimensionPixelSize(C4210R.styleable.CarouselView_strokeWidth, 0);
                    if (dimensionPixelSize2 != 0.0f) {
                        setStrokeWidth(dimensionPixelSize2);
                    }
                }
            } finally {
                obtainStyledAttributes.recycle();
            }
        }
    }

    /* access modifiers changed from: protected */
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.swipeTimer.cancel();
    }

    public int getSlideInterval() {
        return this.slideInterval;
    }

    public void setSlideInterval(int i) {
        this.slideInterval = i;
        if (this.containerViewPager != null) {
            playCarousel();
        }
    }

    public void reSetSlideInterval(int i) {
        setSlideInterval(i);
        if (this.containerViewPager != null) {
            playCarousel();
        }
    }

    public void setPageTransformInterval(int i) {
        if (i > 0) {
            this.pageTransformInterval = i;
        } else {
            this.pageTransformInterval = 400;
        }
        this.containerViewPager.setTransitionVelocity(i);
    }

    public ViewPager.PageTransformer getPageTransformer() {
        return this.pageTransformer;
    }

    public void setPageTransformer(ViewPager.PageTransformer pageTransformer2) {
        this.pageTransformer = pageTransformer2;
        this.containerViewPager.setPageTransformer(true, pageTransformer2);
    }

    public void setPageTransformer(int i) {
        setPageTransformer((ViewPager.PageTransformer) new CarouselViewPagerTransformer(i));
    }

    public void setAnimateOnBoundary(boolean z) {
        this.animateOnBoundary = z;
    }

    public boolean isAutoPlay() {
        return this.autoPlay;
    }

    private void setAutoPlay(boolean z) {
        this.autoPlay = z;
    }

    public boolean isDisableAutoPlayOnUserInteraction() {
        return this.disableAutoPlayOnUserInteraction;
    }

    private void setDisableAutoPlayOnUserInteraction(boolean z) {
        this.disableAutoPlayOnUserInteraction = z;
    }

    private void setData() {
        this.containerViewPager.setAdapter(new CarouselPagerAdapter(getContext()));
        this.mIndicator.setViewPager(this.containerViewPager);
        this.mIndicator.requestLayout();
        this.mIndicator.invalidate();
        this.containerViewPager.setOffscreenPageLimit(getPageCount());
        playCarousel();
    }

    private void stopScrollTimer() {
        Timer timer = this.swipeTimer;
        if (timer != null) {
            timer.cancel();
        }
        SwipeTask swipeTask2 = this.swipeTask;
        if (swipeTask2 != null) {
            swipeTask2.cancel();
        }
    }

    private void resetScrollTimer() {
        stopScrollTimer();
        this.swipeTask = new SwipeTask();
        this.swipeTimer = new Timer();
    }

    public void playCarousel() {
        resetScrollTimer();
        if (this.autoPlay && this.slideInterval > 0 && this.containerViewPager.getAdapter() != null && this.containerViewPager.getAdapter().getCount() > 1) {
            Timer timer = this.swipeTimer;
            SwipeTask swipeTask2 = this.swipeTask;
            int i = this.slideInterval;
            timer.schedule(swipeTask2, (long) i, (long) i);
        }
    }

    public void pauseCarousel() {
        resetScrollTimer();
    }

    public void stopCarousel() {
        this.autoPlay = false;
    }

    private class CarouselPagerAdapter extends PagerAdapter {
        private Context mContext;

        public boolean isViewFromObject(View view, Object obj) {
            return view == obj;
        }

        public CarouselPagerAdapter(Context context) {
            this.mContext = context;
        }

        public Object instantiateItem(ViewGroup viewGroup, int i) {
            if (CarouselView.this.mImageListener != null) {
                ImageView imageView = new ImageView(this.mContext);
                imageView.setLayoutParams(new FrameLayout.LayoutParams(-1, -2));
                imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
                CarouselView.this.mImageListener.setImageForPosition(i, imageView);
                viewGroup.addView(imageView);
                return imageView;
            } else if (CarouselView.this.mViewListener != null) {
                View viewForPosition = CarouselView.this.mViewListener.setViewForPosition(i);
                if (viewForPosition != null) {
                    viewGroup.addView(viewForPosition);
                    return viewForPosition;
                }
                throw new RuntimeException("View can not be null for position " + i);
            } else {
                throw new RuntimeException("View must set " + ImageListener.class.getSimpleName() + " or " + ViewListener.class.getSimpleName() + ".");
            }
        }

        public void destroyItem(ViewGroup viewGroup, int i, Object obj) {
            viewGroup.removeView((View) obj);
        }

        public int getCount() {
            return CarouselView.this.getPageCount();
        }
    }

    private class SwipeTask extends TimerTask {
        private SwipeTask() {
        }

        public void run() {
            CarouselView.this.containerViewPager.post(new Runnable() {
                public void run() {
                    boolean z = true;
                    int currentItem = (CarouselView.this.containerViewPager.getCurrentItem() + 1) % CarouselView.this.getPageCount();
                    CarouselViewPager access$500 = CarouselView.this.containerViewPager;
                    if (currentItem == 0 && !CarouselView.this.animateOnBoundary) {
                        z = false;
                    }
                    access$500.setCurrentItem(currentItem, z);
                }
            });
        }
    }

    public void setImageListener(ImageListener imageListener) {
        this.mImageListener = imageListener;
    }

    public void setViewListener(ViewListener viewListener) {
        this.mViewListener = viewListener;
    }

    public void setImageClickListener(ImageClickListener imageClickListener2) {
        this.imageClickListener = imageClickListener2;
        this.containerViewPager.setImageClickListener(imageClickListener2);
    }

    public int getPageCount() {
        return this.mPageCount;
    }

    public void setPageCount(int i) {
        this.mPageCount = i;
        setData();
    }

    public void addOnPageChangeListener(ViewPager.OnPageChangeListener onPageChangeListener) {
        this.containerViewPager.addOnPageChangeListener(onPageChangeListener);
    }

    public void clearOnPageChangeListeners() {
        this.containerViewPager.clearOnPageChangeListeners();
    }

    public void setCurrentItem(int i) {
        this.containerViewPager.setCurrentItem(i);
    }

    public int getCurrentItem() {
        return this.containerViewPager.getCurrentItem();
    }

    public int getIndicatorMarginVertical() {
        return this.indicatorMarginVertical;
    }

    public void setIndicatorMarginVertical(int i) {
        this.indicatorMarginVertical = i;
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) getLayoutParams();
        int i2 = this.indicatorMarginVertical;
        layoutParams.topMargin = i2;
        layoutParams.bottomMargin = i2;
    }

    public int getIndicatorMarginHorizontal() {
        return this.indicatorMarginHorizontal;
    }

    public void setIndicatorMarginHorizontal(int i) {
        this.indicatorMarginHorizontal = i;
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) getLayoutParams();
        int i2 = this.indicatorMarginHorizontal;
        layoutParams.leftMargin = i2;
        layoutParams.rightMargin = i2;
    }

    public int getIndicatorGravity() {
        return this.mIndicatorGravity;
    }

    public void setIndicatorGravity(int i) {
        this.mIndicatorGravity = i;
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
        layoutParams.gravity = this.mIndicatorGravity;
        int i2 = this.indicatorMarginHorizontal;
        int i3 = this.indicatorMarginVertical;
        layoutParams.setMargins(i2, i3, i2, i3);
        this.mIndicator.setLayoutParams(layoutParams);
    }

    public void setIndicatorVisibility(int i) {
        this.mIndicator.setVisibility(i);
    }

    public int getOrientation() {
        return this.mIndicator.getOrientation();
    }

    public int getFillColor() {
        return this.mIndicator.getFillColor();
    }

    public int getStrokeColor() {
        return this.mIndicator.getStrokeColor();
    }

    public void setSnap(boolean z) {
        this.mIndicator.setSnap(z);
    }

    public void setRadius(float f) {
        this.mIndicator.setRadius(f);
    }

    public float getStrokeWidth() {
        return this.mIndicator.getStrokeWidth();
    }

    public void setBackground(Drawable drawable) {
        super.setBackground(drawable);
    }

    public Drawable getIndicatorBackground() {
        return this.mIndicator.getBackground();
    }

    public void setFillColor(int i) {
        this.mIndicator.setFillColor(i);
    }

    public int getPageColor() {
        return this.mIndicator.getPageColor();
    }

    public void setOrientation(int i) {
        this.mIndicator.setOrientation(i);
    }

    public boolean isSnap() {
        return this.mIndicator.isSnap();
    }

    public void setStrokeColor(int i) {
        this.mIndicator.setStrokeColor(i);
    }

    public float getRadius() {
        return this.mIndicator.getRadius();
    }

    public void setPageColor(int i) {
        this.mIndicator.setPageColor(i);
    }

    public void setStrokeWidth(float f) {
        this.mIndicator.setStrokeWidth(f);
        int i = (int) f;
        this.mIndicator.setPadding(i, i, i, i);
    }
}

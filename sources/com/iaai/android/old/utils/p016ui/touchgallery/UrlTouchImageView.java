package com.iaai.android.old.utils.p016ui.touchgallery;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.os.AsyncTask;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.ImageLoader;
import com.google.firebase.perf.network.FirebasePerfUrlConnection;
import com.iaai.android.C2723R;
import com.iaai.android.IaaiApplication;
import com.iaai.android.old.activities.ImageClickListener;
import com.iaai.android.old.utils.p016ui.touchgallery.InputStreamWrapper;
import java.io.InputStream;
import java.lang.ref.WeakReference;
import java.net.URL;
import java.net.URLConnection;

/* renamed from: com.iaai.android.old.utils.ui.touchgallery.UrlTouchImageView */
public class UrlTouchImageView extends RelativeLayout {
    ImageClickListener imageClickListener;
    protected Context mContext;
    protected TouchImageView mImageView;
    protected ProgressBar mProgressBar;

    public UrlTouchImageView(Context context, ImageClickListener imageClickListener2) {
        super(context);
        this.mContext = context;
        this.imageClickListener = imageClickListener2;
        init();
    }

    public UrlTouchImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mContext = context;
        init();
    }

    public TouchImageView getImageView() {
        return this.mImageView;
    }

    /* access modifiers changed from: protected */
    public void init() {
        this.mImageView = new TouchImageView(this.mContext);
        this.mImageView.setLayoutParams(new RelativeLayout.LayoutParams(-1, -1));
        addView(this.mImageView);
        this.mImageView.setVisibility(8);
        this.mImageView.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                UrlTouchImageView.this.imageClickListener.onImageClick();
            }
        });
        this.mProgressBar = new ProgressBar(this.mContext, (AttributeSet) null, 16842871);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
        layoutParams.addRule(15);
        layoutParams.setMargins(30, 0, 30, 0);
        this.mProgressBar.setLayoutParams(layoutParams);
        this.mProgressBar.setIndeterminate(false);
        this.mProgressBar.setMax(100);
        addView(this.mProgressBar);
    }

    public void setUrl(String str) {
        IaaiApplication.getInstance().getImageLoader().get(str, new ImageLoader.ImageListener() {
            public void onErrorResponse(VolleyError volleyError) {
                UrlTouchImageView.this.mImageView.setImageBitmap(((BitmapDrawable) UrlTouchImageView.this.getResources().getDrawable(C2723R.C2725drawable.ic_image_na)).getBitmap());
                UrlTouchImageView.this.mProgressBar.setVisibility(8);
                UrlTouchImageView.this.mImageView.setVisibility(0);
            }

            public void onResponse(ImageLoader.ImageContainer imageContainer, boolean z) {
                if (imageContainer.getBitmap() != null) {
                    UrlTouchImageView.this.mImageView.setImageBitmap(imageContainer.getBitmap());
                    UrlTouchImageView.this.mProgressBar.setVisibility(8);
                    UrlTouchImageView.this.mImageView.setVisibility(0);
                }
            }
        });
    }

    public void setScaleType(ImageView.ScaleType scaleType) {
        this.mImageView.setScaleType(scaleType);
    }

    /* renamed from: com.iaai.android.old.utils.ui.touchgallery.UrlTouchImageView$ImageLoadTask */
    public class ImageLoadTask extends AsyncTask<String, Integer, Bitmap> {
        private final WeakReference<ImageView> imageViewReference;

        public ImageLoadTask(ImageView imageView) {
            this.imageViewReference = new WeakReference<>(imageView);
        }

        /* access modifiers changed from: protected */
        public Bitmap doInBackground(String... strArr) {
            Bitmap bitmap = null;
            try {
                URLConnection uRLConnection = (URLConnection) FirebasePerfUrlConnection.instrument(new URL(strArr[0]).openConnection());
                uRLConnection.connect();
                InputStream inputStream = uRLConnection.getInputStream();
                InputStreamWrapper inputStreamWrapper = new InputStreamWrapper(inputStream, 8192, (long) uRLConnection.getContentLength());
                inputStreamWrapper.setProgressListener(new InputStreamWrapper.InputStreamProgressListener() {
                    public void onProgress(float f, long j, long j2) {
                        ImageLoadTask.this.publishProgress(new Integer[]{Integer.valueOf((int) (f * 100.0f))});
                    }
                });
                bitmap = BitmapFactory.decodeStream(inputStreamWrapper);
                inputStreamWrapper.close();
                inputStream.close();
                return bitmap;
            } catch (Exception e) {
                e.printStackTrace();
                return bitmap;
            }
        }

        /* access modifiers changed from: protected */
        public void onPostExecute(Bitmap bitmap) {
            WeakReference<ImageView> weakReference;
            ImageView imageView;
            WeakReference<ImageView> weakReference2 = this.imageViewReference;
            if (!(weakReference2 == null || bitmap == null || (imageView = (ImageView) weakReference2.get()) == null)) {
                imageView.setImageBitmap(bitmap);
                imageView.setVisibility(0);
            }
            if (bitmap == null && (weakReference = this.imageViewReference) != null) {
                ImageView imageView2 = (ImageView) weakReference.get();
                imageView2.setScaleType(ImageView.ScaleType.CENTER);
                imageView2.setImageBitmap(BitmapFactory.decodeResource(UrlTouchImageView.this.getResources(), C2723R.C2725drawable.ic_image_na));
                imageView2.setVisibility(0);
            }
            UrlTouchImageView.this.mProgressBar.setVisibility(8);
        }

        /* access modifiers changed from: protected */
        public void onProgressUpdate(Integer... numArr) {
            UrlTouchImageView.this.mProgressBar.setProgress(numArr[0].intValue());
        }
    }
}

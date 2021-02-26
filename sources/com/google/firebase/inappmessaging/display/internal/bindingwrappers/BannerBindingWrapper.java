package com.google.firebase.inappmessaging.display.internal.bindingwrappers;

import android.graphics.Color;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import com.google.firebase.inappmessaging.display.C2314R;
import com.google.firebase.inappmessaging.display.internal.InAppMessageLayoutConfig;
import com.google.firebase.inappmessaging.display.internal.ResizableImageView;
import com.google.firebase.inappmessaging.display.internal.injection.scopes.InAppMessageScope;
import com.google.firebase.inappmessaging.display.internal.layout.FiamFrameLayout;
import com.google.firebase.inappmessaging.model.Action;
import com.google.firebase.inappmessaging.model.BannerMessage;
import com.google.firebase.inappmessaging.model.InAppMessage;
import com.google.firebase.inappmessaging.model.MessageType;
import java.util.Map;
import javax.inject.Inject;

@InAppMessageScope
public class BannerBindingWrapper extends BindingWrapper {
    private TextView bannerBody;
    private ViewGroup bannerContentRoot;
    private ResizableImageView bannerImage;
    private FiamFrameLayout bannerRoot;
    private TextView bannerTitle;
    private View.OnClickListener mDismissListener;

    public boolean canSwipeToDismiss() {
        return true;
    }

    @Inject
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public BannerBindingWrapper(InAppMessageLayoutConfig inAppMessageLayoutConfig, LayoutInflater layoutInflater, InAppMessage inAppMessage) {
        super(inAppMessageLayoutConfig, layoutInflater, inAppMessage);
    }

    @Nullable
    public ViewTreeObserver.OnGlobalLayoutListener inflate(Map<Action, View.OnClickListener> map, View.OnClickListener onClickListener) {
        View inflate = this.inflater.inflate(C2314R.C2319layout.banner, (ViewGroup) null);
        this.bannerRoot = (FiamFrameLayout) inflate.findViewById(C2314R.C2317id.banner_root);
        this.bannerContentRoot = (ViewGroup) inflate.findViewById(C2314R.C2317id.banner_content_root);
        this.bannerBody = (TextView) inflate.findViewById(C2314R.C2317id.banner_body);
        this.bannerImage = (ResizableImageView) inflate.findViewById(C2314R.C2317id.banner_image);
        this.bannerTitle = (TextView) inflate.findViewById(C2314R.C2317id.banner_title);
        if (this.message.getMessageType().equals(MessageType.BANNER)) {
            BannerMessage bannerMessage = (BannerMessage) this.message;
            setMessage(bannerMessage);
            setLayoutConfig(this.config);
            setSwipeDismissListener(onClickListener);
            setActionListener(map.get(bannerMessage.getAction()));
        }
        return null;
    }

    private void setMessage(@NonNull BannerMessage bannerMessage) {
        if (!TextUtils.isEmpty(bannerMessage.getBackgroundHexColor())) {
            setViewBgColorFromHex(this.bannerContentRoot, bannerMessage.getBackgroundHexColor());
        }
        this.bannerImage.setVisibility((bannerMessage.getImageData() == null || TextUtils.isEmpty(bannerMessage.getImageData().getImageUrl())) ? 8 : 0);
        if (bannerMessage.getTitle() != null) {
            if (!TextUtils.isEmpty(bannerMessage.getTitle().getText())) {
                this.bannerTitle.setText(bannerMessage.getTitle().getText());
            }
            if (!TextUtils.isEmpty(bannerMessage.getTitle().getHexColor())) {
                this.bannerTitle.setTextColor(Color.parseColor(bannerMessage.getTitle().getHexColor()));
            }
        }
        if (bannerMessage.getBody() != null) {
            if (!TextUtils.isEmpty(bannerMessage.getBody().getText())) {
                this.bannerBody.setText(bannerMessage.getBody().getText());
            }
            if (!TextUtils.isEmpty(bannerMessage.getBody().getHexColor())) {
                this.bannerBody.setTextColor(Color.parseColor(bannerMessage.getBody().getHexColor()));
            }
        }
    }

    private void setLayoutConfig(InAppMessageLayoutConfig inAppMessageLayoutConfig) {
        int min = Math.min(inAppMessageLayoutConfig.maxDialogWidthPx().intValue(), inAppMessageLayoutConfig.maxDialogHeightPx().intValue());
        ViewGroup.LayoutParams layoutParams = this.bannerRoot.getLayoutParams();
        if (layoutParams == null) {
            layoutParams = new ViewGroup.LayoutParams(-1, -2);
        }
        layoutParams.width = min;
        this.bannerRoot.setLayoutParams(layoutParams);
        this.bannerImage.setMaxHeight(inAppMessageLayoutConfig.getMaxImageHeight());
        this.bannerImage.setMaxWidth(inAppMessageLayoutConfig.getMaxImageWidth());
    }

    private void setSwipeDismissListener(View.OnClickListener onClickListener) {
        this.mDismissListener = onClickListener;
        this.bannerRoot.setDismissListener(this.mDismissListener);
    }

    private void setActionListener(View.OnClickListener onClickListener) {
        this.bannerContentRoot.setOnClickListener(onClickListener);
    }

    @NonNull
    public InAppMessageLayoutConfig getConfig() {
        return this.config;
    }

    @NonNull
    public ImageView getImageView() {
        return this.bannerImage;
    }

    @NonNull
    public ViewGroup getRootView() {
        return this.bannerRoot;
    }

    @NonNull
    public View getDialogView() {
        return this.bannerContentRoot;
    }

    @Nullable
    public View.OnClickListener getDismissListener() {
        return this.mDismissListener;
    }
}

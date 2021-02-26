package com.google.firebase.inappmessaging.display.internal.bindingwrappers;

import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.Button;
import android.widget.ImageView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import com.google.firebase.inappmessaging.display.C2314R;
import com.google.firebase.inappmessaging.display.internal.InAppMessageLayoutConfig;
import com.google.firebase.inappmessaging.display.internal.injection.scopes.InAppMessageScope;
import com.google.firebase.inappmessaging.display.internal.layout.FiamFrameLayout;
import com.google.firebase.inappmessaging.model.Action;
import com.google.firebase.inappmessaging.model.ImageOnlyMessage;
import com.google.firebase.inappmessaging.model.InAppMessage;
import com.google.firebase.inappmessaging.model.MessageType;
import java.util.Map;
import javax.inject.Inject;

@InAppMessageScope
public class ImageBindingWrapper extends BindingWrapper {
    private Button collapseButton;
    private ViewGroup imageContentRoot;
    private FiamFrameLayout imageRoot;
    private ImageView imageView;

    @Inject
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public ImageBindingWrapper(InAppMessageLayoutConfig inAppMessageLayoutConfig, LayoutInflater layoutInflater, InAppMessage inAppMessage) {
        super(inAppMessageLayoutConfig, layoutInflater, inAppMessage);
    }

    @Nullable
    public ViewTreeObserver.OnGlobalLayoutListener inflate(Map<Action, View.OnClickListener> map, View.OnClickListener onClickListener) {
        View inflate = this.inflater.inflate(C2314R.C2319layout.image, (ViewGroup) null);
        this.imageRoot = (FiamFrameLayout) inflate.findViewById(C2314R.C2317id.image_root);
        this.imageContentRoot = (ViewGroup) inflate.findViewById(C2314R.C2317id.image_content_root);
        this.imageView = (ImageView) inflate.findViewById(C2314R.C2317id.image_view);
        this.collapseButton = (Button) inflate.findViewById(C2314R.C2317id.collapse_button);
        this.imageView.setMaxHeight(this.config.getMaxImageHeight());
        this.imageView.setMaxWidth(this.config.getMaxImageWidth());
        if (this.message.getMessageType().equals(MessageType.IMAGE_ONLY)) {
            ImageOnlyMessage imageOnlyMessage = (ImageOnlyMessage) this.message;
            this.imageView.setVisibility((imageOnlyMessage.getImageData() == null || TextUtils.isEmpty(imageOnlyMessage.getImageData().getImageUrl())) ? 8 : 0);
            this.imageView.setOnClickListener(map.get(imageOnlyMessage.getAction()));
        }
        this.imageRoot.setDismissListener(onClickListener);
        this.collapseButton.setOnClickListener(onClickListener);
        return null;
    }

    @NonNull
    public ImageView getImageView() {
        return this.imageView;
    }

    @NonNull
    public ViewGroup getRootView() {
        return this.imageRoot;
    }

    @NonNull
    public View getDialogView() {
        return this.imageContentRoot;
    }

    @NonNull
    public View getCollapseButton() {
        return this.collapseButton;
    }
}

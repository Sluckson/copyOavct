package com.google.firebase.inappmessaging.display.internal.bindingwrappers;

import android.graphics.Color;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ScrollView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.RestrictTo;
import androidx.annotation.VisibleForTesting;
import com.google.firebase.inappmessaging.display.C2314R;
import com.google.firebase.inappmessaging.display.internal.InAppMessageLayoutConfig;
import com.google.firebase.inappmessaging.display.internal.injection.scopes.InAppMessageScope;
import com.google.firebase.inappmessaging.display.internal.layout.FiamRelativeLayout;
import com.google.firebase.inappmessaging.model.Action;
import com.google.firebase.inappmessaging.model.InAppMessage;
import com.google.firebase.inappmessaging.model.MessageType;
import com.google.firebase.inappmessaging.model.ModalMessage;
import java.util.Map;
import javax.inject.Inject;

@InAppMessageScope
public class ModalBindingWrapper extends BindingWrapper {
    private ScrollView bodyScroll;
    private Button button;
    private View collapseImage;
    /* access modifiers changed from: private */
    public ImageView imageView;
    private ViewTreeObserver.OnGlobalLayoutListener layoutListener = new ScrollViewAdjustableListener();
    private TextView messageBody;
    private TextView messageTitle;
    private ViewGroup modalContentRoot;
    private ModalMessage modalMessage;
    private FiamRelativeLayout modalRoot;

    @Inject
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public ModalBindingWrapper(InAppMessageLayoutConfig inAppMessageLayoutConfig, LayoutInflater layoutInflater, InAppMessage inAppMessage) {
        super(inAppMessageLayoutConfig, layoutInflater, inAppMessage);
    }

    @NonNull
    public ViewTreeObserver.OnGlobalLayoutListener inflate(Map<Action, View.OnClickListener> map, View.OnClickListener onClickListener) {
        View inflate = this.inflater.inflate(C2314R.C2319layout.modal, (ViewGroup) null);
        this.bodyScroll = (ScrollView) inflate.findViewById(C2314R.C2317id.body_scroll);
        this.button = (Button) inflate.findViewById(C2314R.C2317id.button);
        this.collapseImage = inflate.findViewById(C2314R.C2317id.collapse_button);
        this.imageView = (ImageView) inflate.findViewById(C2314R.C2317id.image_view);
        this.messageBody = (TextView) inflate.findViewById(C2314R.C2317id.message_body);
        this.messageTitle = (TextView) inflate.findViewById(C2314R.C2317id.message_title);
        this.modalRoot = (FiamRelativeLayout) inflate.findViewById(C2314R.C2317id.modal_root);
        this.modalContentRoot = (ViewGroup) inflate.findViewById(C2314R.C2317id.modal_content_root);
        if (this.message.getMessageType().equals(MessageType.MODAL)) {
            this.modalMessage = (ModalMessage) this.message;
            setMessage(this.modalMessage);
            setButton(map);
            setLayoutConfig(this.config);
            setDismissListener(onClickListener);
            setViewBgColorFromHex(this.modalContentRoot, this.modalMessage.getBackgroundHexColor());
        }
        return this.layoutListener;
    }

    @NonNull
    public ImageView getImageView() {
        return this.imageView;
    }

    @NonNull
    public ViewGroup getRootView() {
        return this.modalRoot;
    }

    @NonNull
    public View getDialogView() {
        return this.modalContentRoot;
    }

    @NonNull
    public View getScrollView() {
        return this.bodyScroll;
    }

    @NonNull
    public View getTitleView() {
        return this.messageTitle;
    }

    @NonNull
    public InAppMessageLayoutConfig getConfig() {
        return this.config;
    }

    @NonNull
    public Button getActionButton() {
        return this.button;
    }

    @NonNull
    public View getCollapseButton() {
        return this.collapseImage;
    }

    private void setMessage(ModalMessage modalMessage2) {
        if (modalMessage2.getImageData() == null || TextUtils.isEmpty(modalMessage2.getImageData().getImageUrl())) {
            this.imageView.setVisibility(8);
        } else {
            this.imageView.setVisibility(0);
        }
        if (modalMessage2.getTitle() != null) {
            if (!TextUtils.isEmpty(modalMessage2.getTitle().getText())) {
                this.messageTitle.setVisibility(0);
                this.messageTitle.setText(modalMessage2.getTitle().getText());
            } else {
                this.messageTitle.setVisibility(8);
            }
            if (!TextUtils.isEmpty(modalMessage2.getTitle().getHexColor())) {
                this.messageTitle.setTextColor(Color.parseColor(modalMessage2.getTitle().getHexColor()));
            }
        }
        if (modalMessage2.getBody() == null || TextUtils.isEmpty(modalMessage2.getBody().getText())) {
            this.bodyScroll.setVisibility(8);
            this.messageBody.setVisibility(8);
            return;
        }
        this.bodyScroll.setVisibility(0);
        this.messageBody.setVisibility(0);
        this.messageBody.setTextColor(Color.parseColor(modalMessage2.getBody().getHexColor()));
        this.messageBody.setText(modalMessage2.getBody().getText());
    }

    private void setButton(Map<Action, View.OnClickListener> map) {
        Action action = this.modalMessage.getAction();
        if (action == null || action.getButton() == null || TextUtils.isEmpty(action.getButton().getText().getText())) {
            this.button.setVisibility(8);
            return;
        }
        setupViewButtonFromModel(this.button, action.getButton());
        setButtonActionListener(this.button, map.get(this.modalMessage.getAction()));
        this.button.setVisibility(0);
    }

    private void setLayoutConfig(InAppMessageLayoutConfig inAppMessageLayoutConfig) {
        this.imageView.setMaxHeight(inAppMessageLayoutConfig.getMaxImageHeight());
        this.imageView.setMaxWidth(inAppMessageLayoutConfig.getMaxImageWidth());
    }

    private void setDismissListener(View.OnClickListener onClickListener) {
        this.collapseImage.setOnClickListener(onClickListener);
        this.modalRoot.setDismissListener(onClickListener);
    }

    @VisibleForTesting
    public void setLayoutListener(ViewTreeObserver.OnGlobalLayoutListener onGlobalLayoutListener) {
        this.layoutListener = onGlobalLayoutListener;
    }

    public class ScrollViewAdjustableListener implements ViewTreeObserver.OnGlobalLayoutListener {
        public ScrollViewAdjustableListener() {
        }

        public void onGlobalLayout() {
            ModalBindingWrapper.this.imageView.getViewTreeObserver().removeGlobalOnLayoutListener(this);
        }
    }
}

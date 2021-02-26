package com.google.firebase.inappmessaging.display.internal.bindingwrappers;

import android.graphics.Color;
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
import com.google.firebase.inappmessaging.display.internal.layout.BaseModalLayout;
import com.google.firebase.inappmessaging.display.internal.layout.FiamCardView;
import com.google.firebase.inappmessaging.model.Action;
import com.google.firebase.inappmessaging.model.CardMessage;
import com.google.firebase.inappmessaging.model.InAppMessage;
import com.google.firebase.inappmessaging.model.MessageType;
import java.util.Map;
import javax.inject.Inject;

@InAppMessageScope
public class CardBindingWrapper extends BindingWrapper {
    private ScrollView bodyScroll;
    private BaseModalLayout cardContentRoot;
    private CardMessage cardMessage;
    private FiamCardView cardRoot;
    private View.OnClickListener dismissListener;
    /* access modifiers changed from: private */
    public ImageView imageView;
    private ViewTreeObserver.OnGlobalLayoutListener layoutListener = new ScrollViewAdjustableListener();
    private TextView messageBody;
    private TextView messageTitle;
    private Button primaryButton;
    private Button secondaryButton;

    @Inject
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public CardBindingWrapper(InAppMessageLayoutConfig inAppMessageLayoutConfig, LayoutInflater layoutInflater, InAppMessage inAppMessage) {
        super(inAppMessageLayoutConfig, layoutInflater, inAppMessage);
    }

    @NonNull
    public ViewTreeObserver.OnGlobalLayoutListener inflate(Map<Action, View.OnClickListener> map, View.OnClickListener onClickListener) {
        View inflate = this.inflater.inflate(C2314R.C2319layout.card, (ViewGroup) null);
        this.bodyScroll = (ScrollView) inflate.findViewById(C2314R.C2317id.body_scroll);
        this.primaryButton = (Button) inflate.findViewById(C2314R.C2317id.primary_button);
        this.secondaryButton = (Button) inflate.findViewById(C2314R.C2317id.secondary_button);
        this.imageView = (ImageView) inflate.findViewById(C2314R.C2317id.image_view);
        this.messageBody = (TextView) inflate.findViewById(C2314R.C2317id.message_body);
        this.messageTitle = (TextView) inflate.findViewById(C2314R.C2317id.message_title);
        this.cardRoot = (FiamCardView) inflate.findViewById(C2314R.C2317id.card_root);
        this.cardContentRoot = (BaseModalLayout) inflate.findViewById(C2314R.C2317id.card_content_root);
        if (this.message.getMessageType().equals(MessageType.CARD)) {
            this.cardMessage = (CardMessage) this.message;
            setMessage(this.cardMessage);
            setImage(this.cardMessage);
            setButtons(map);
            setLayoutConfig(this.config);
            setDismissListener(onClickListener);
            setViewBgColorFromHex(this.cardContentRoot, this.cardMessage.getBackgroundHexColor());
        }
        return this.layoutListener;
    }

    @NonNull
    public ImageView getImageView() {
        return this.imageView;
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
    public ViewGroup getRootView() {
        return this.cardRoot;
    }

    @NonNull
    public View getDialogView() {
        return this.cardContentRoot;
    }

    @NonNull
    public InAppMessageLayoutConfig getConfig() {
        return this.config;
    }

    @NonNull
    public View.OnClickListener getDismissListener() {
        return this.dismissListener;
    }

    @NonNull
    public Button getPrimaryButton() {
        return this.primaryButton;
    }

    @NonNull
    public Button getSecondaryButton() {
        return this.secondaryButton;
    }

    private void setMessage(CardMessage cardMessage2) {
        this.messageTitle.setText(cardMessage2.getTitle().getText());
        this.messageTitle.setTextColor(Color.parseColor(cardMessage2.getTitle().getHexColor()));
        if (cardMessage2.getBody() == null || cardMessage2.getBody().getText() == null) {
            this.bodyScroll.setVisibility(8);
            this.messageBody.setVisibility(8);
            return;
        }
        this.bodyScroll.setVisibility(0);
        this.messageBody.setVisibility(0);
        this.messageBody.setText(cardMessage2.getBody().getText());
        this.messageBody.setTextColor(Color.parseColor(cardMessage2.getBody().getHexColor()));
    }

    private void setButtons(Map<Action, View.OnClickListener> map) {
        Action primaryAction = this.cardMessage.getPrimaryAction();
        Action secondaryAction = this.cardMessage.getSecondaryAction();
        setupViewButtonFromModel(this.primaryButton, primaryAction.getButton());
        setButtonActionListener(this.primaryButton, map.get(primaryAction));
        this.primaryButton.setVisibility(0);
        if (secondaryAction == null || secondaryAction.getButton() == null) {
            this.secondaryButton.setVisibility(8);
            return;
        }
        setupViewButtonFromModel(this.secondaryButton, secondaryAction.getButton());
        setButtonActionListener(this.secondaryButton, map.get(secondaryAction));
        this.secondaryButton.setVisibility(0);
    }

    private void setImage(CardMessage cardMessage2) {
        if (cardMessage2.getPortraitImageData() == null && cardMessage2.getLandscapeImageData() == null) {
            this.imageView.setVisibility(8);
        } else {
            this.imageView.setVisibility(0);
        }
    }

    private void setLayoutConfig(InAppMessageLayoutConfig inAppMessageLayoutConfig) {
        this.imageView.setMaxHeight(inAppMessageLayoutConfig.getMaxImageHeight());
        this.imageView.setMaxWidth(inAppMessageLayoutConfig.getMaxImageWidth());
    }

    private void setDismissListener(View.OnClickListener onClickListener) {
        this.dismissListener = onClickListener;
        this.cardRoot.setDismissListener(onClickListener);
    }

    @VisibleForTesting
    public void setLayoutListener(ViewTreeObserver.OnGlobalLayoutListener onGlobalLayoutListener) {
        this.layoutListener = onGlobalLayoutListener;
    }

    public class ScrollViewAdjustableListener implements ViewTreeObserver.OnGlobalLayoutListener {
        public ScrollViewAdjustableListener() {
        }

        public void onGlobalLayout() {
            CardBindingWrapper.this.imageView.getViewTreeObserver().removeGlobalOnLayoutListener(this);
        }
    }
}

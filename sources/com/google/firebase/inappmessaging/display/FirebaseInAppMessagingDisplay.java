package com.google.firebase.inappmessaging.display;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.Application;
import android.net.Uri;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewTreeObserver;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import androidx.browser.customtabs.CustomTabsIntent;
import com.google.firebase.FirebaseApp;
import com.google.firebase.inappmessaging.FirebaseInAppMessaging;
import com.google.firebase.inappmessaging.FirebaseInAppMessagingDisplayCallbacks;
import com.google.firebase.inappmessaging.display.internal.BindingWrapperFactory;
import com.google.firebase.inappmessaging.display.internal.FiamAnimator;
import com.google.firebase.inappmessaging.display.internal.FiamImageLoader;
import com.google.firebase.inappmessaging.display.internal.FiamWindowManager;
import com.google.firebase.inappmessaging.display.internal.FirebaseInAppMessagingDisplayImpl;
import com.google.firebase.inappmessaging.display.internal.InAppMessageLayoutConfig;
import com.google.firebase.inappmessaging.display.internal.Logging;
import com.google.firebase.inappmessaging.display.internal.RenewableTimer;
import com.google.firebase.inappmessaging.display.internal.bindingwrappers.BindingWrapper;
import com.google.firebase.inappmessaging.display.internal.injection.modules.InflaterConfigModule;
import com.google.firebase.inappmessaging.display.internal.injection.scopes.FirebaseAppScope;
import com.google.firebase.inappmessaging.model.Action;
import com.google.firebase.inappmessaging.model.BannerMessage;
import com.google.firebase.inappmessaging.model.CardMessage;
import com.google.firebase.inappmessaging.model.ImageData;
import com.google.firebase.inappmessaging.model.ImageOnlyMessage;
import com.google.firebase.inappmessaging.model.InAppMessage;
import com.google.firebase.inappmessaging.model.MessageType;
import com.google.firebase.inappmessaging.model.ModalMessage;
import com.squareup.picasso.Callback;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.inject.Inject;
import javax.inject.Provider;

@FirebaseAppScope
public class FirebaseInAppMessagingDisplay extends FirebaseInAppMessagingDisplayImpl {
    static final long DISMISS_THRESHOLD_MILLIS = 20000;
    static final long IMPRESSION_THRESHOLD_MILLIS = 5000;
    static final long INTERVAL_MILLIS = 1000;
    /* access modifiers changed from: private */
    public final FiamAnimator animator;
    /* access modifiers changed from: private */
    public final Application application;
    /* access modifiers changed from: private */
    public final RenewableTimer autoDismissTimer;
    private final BindingWrapperFactory bindingWrapperFactory;
    /* access modifiers changed from: private */
    public FirebaseInAppMessagingDisplayCallbacks callbacks;
    @VisibleForTesting
    @Nullable
    String currentlyBoundActivityName;
    private FiamListener fiamListener;
    private final FirebaseInAppMessaging headlessInAppMessaging;
    private final FiamImageLoader imageLoader;
    /* access modifiers changed from: private */
    public final RenewableTimer impressionTimer;
    /* access modifiers changed from: private */
    public InAppMessage inAppMessage;
    private final Map<String, Provider<InAppMessageLayoutConfig>> layoutConfigs;
    /* access modifiers changed from: private */
    public final FiamWindowManager windowManager;

    @Inject
    FirebaseInAppMessagingDisplay(FirebaseInAppMessaging firebaseInAppMessaging, Map<String, Provider<InAppMessageLayoutConfig>> map, FiamImageLoader fiamImageLoader, RenewableTimer renewableTimer, RenewableTimer renewableTimer2, FiamWindowManager fiamWindowManager, Application application2, BindingWrapperFactory bindingWrapperFactory2, FiamAnimator fiamAnimator) {
        this.headlessInAppMessaging = firebaseInAppMessaging;
        this.layoutConfigs = map;
        this.imageLoader = fiamImageLoader;
        this.impressionTimer = renewableTimer;
        this.autoDismissTimer = renewableTimer2;
        this.windowManager = fiamWindowManager;
        this.application = application2;
        this.bindingWrapperFactory = bindingWrapperFactory2;
        this.animator = fiamAnimator;
    }

    @NonNull
    public static FirebaseInAppMessagingDisplay getInstance() {
        return (FirebaseInAppMessagingDisplay) FirebaseApp.getInstance().get(FirebaseInAppMessagingDisplay.class);
    }

    private static int getScreenOrientation(Application application2) {
        return application2.getResources().getConfiguration().orientation;
    }

    public void testMessage(Activity activity, InAppMessage inAppMessage2, FirebaseInAppMessagingDisplayCallbacks firebaseInAppMessagingDisplayCallbacks) {
        this.inAppMessage = inAppMessage2;
        this.callbacks = firebaseInAppMessagingDisplayCallbacks;
        showActiveFiam(activity);
    }

    public void setFiamListener(FiamListener fiamListener2) {
        this.fiamListener = fiamListener2;
    }

    public void clearFiamListener() {
        this.fiamListener = null;
    }

    public void onActivityResumed(Activity activity) {
        super.onActivityResumed(activity);
        bindFiamToActivity(activity);
    }

    public void onActivityPaused(Activity activity) {
        unbindFiamFromActivity(activity);
        this.headlessInAppMessaging.removeAllListeners();
        super.onActivityPaused(activity);
    }

    private void bindFiamToActivity(Activity activity) {
        String str = this.currentlyBoundActivityName;
        if (str == null || !str.equals(activity.getLocalClassName())) {
            Logging.logi("Binding to activity: " + activity.getLocalClassName());
            this.headlessInAppMessaging.setMessageDisplayComponent(FirebaseInAppMessagingDisplay$$Lambda$1.lambdaFactory$(this, activity));
            this.currentlyBoundActivityName = activity.getLocalClassName();
        }
        if (this.inAppMessage != null) {
            showActiveFiam(activity);
        }
    }

    static /* synthetic */ void lambda$bindFiamToActivity$0(FirebaseInAppMessagingDisplay firebaseInAppMessagingDisplay, Activity activity, InAppMessage inAppMessage2, FirebaseInAppMessagingDisplayCallbacks firebaseInAppMessagingDisplayCallbacks) {
        if (firebaseInAppMessagingDisplay.inAppMessage != null || firebaseInAppMessagingDisplay.headlessInAppMessaging.areMessagesSuppressed()) {
            Logging.logd("Active FIAM exists. Skipping trigger");
            return;
        }
        firebaseInAppMessagingDisplay.inAppMessage = inAppMessage2;
        firebaseInAppMessagingDisplay.callbacks = firebaseInAppMessagingDisplayCallbacks;
        firebaseInAppMessagingDisplay.showActiveFiam(activity);
    }

    private void unbindFiamFromActivity(Activity activity) {
        String str = this.currentlyBoundActivityName;
        if (str != null && str.equals(activity.getLocalClassName())) {
            Logging.logi("Unbinding from activity: " + activity.getLocalClassName());
            this.headlessInAppMessaging.clearDisplayListener();
            this.imageLoader.cancelTag(activity.getClass());
            removeDisplayedFiam(activity);
            this.currentlyBoundActivityName = null;
        }
    }

    /* access modifiers changed from: package-private */
    @VisibleForTesting
    public InAppMessage getCurrentInAppMessage() {
        return this.inAppMessage;
    }

    private void showActiveFiam(@NonNull final Activity activity) {
        final BindingWrapper bindingWrapper;
        if (this.inAppMessage == null || this.headlessInAppMessaging.areMessagesSuppressed()) {
            Logging.loge("No active message found to render");
        } else if (this.inAppMessage.getMessageType().equals(MessageType.UNSUPPORTED)) {
            Logging.loge("The message being triggered is not supported by this version of the sdk.");
        } else {
            notifyFiamTrigger();
            InAppMessageLayoutConfig inAppMessageLayoutConfig = (InAppMessageLayoutConfig) this.layoutConfigs.get(InflaterConfigModule.configFor(this.inAppMessage.getMessageType(), getScreenOrientation(this.application))).get();
            int i = C23135.$SwitchMap$com$google$firebase$inappmessaging$model$MessageType[this.inAppMessage.getMessageType().ordinal()];
            if (i == 1) {
                bindingWrapper = this.bindingWrapperFactory.createBannerBindingWrapper(inAppMessageLayoutConfig, this.inAppMessage);
            } else if (i == 2) {
                bindingWrapper = this.bindingWrapperFactory.createModalBindingWrapper(inAppMessageLayoutConfig, this.inAppMessage);
            } else if (i == 3) {
                bindingWrapper = this.bindingWrapperFactory.createImageBindingWrapper(inAppMessageLayoutConfig, this.inAppMessage);
            } else if (i != 4) {
                Logging.loge("No bindings found for this message type");
                return;
            } else {
                bindingWrapper = this.bindingWrapperFactory.createCardBindingWrapper(inAppMessageLayoutConfig, this.inAppMessage);
            }
            activity.findViewById(16908290).post(new Runnable() {
                public void run() {
                    FirebaseInAppMessagingDisplay.this.inflateBinding(activity, bindingWrapper);
                }
            });
        }
    }

    /* renamed from: com.google.firebase.inappmessaging.display.FirebaseInAppMessagingDisplay$5 */
    static /* synthetic */ class C23135 {
        static final /* synthetic */ int[] $SwitchMap$com$google$firebase$inappmessaging$model$MessageType = new int[MessageType.values().length];

        /* JADX WARNING: Can't wrap try/catch for region: R(10:0|1|2|3|4|5|6|7|8|10) */
        /* JADX WARNING: Can't wrap try/catch for region: R(8:0|1|2|3|4|5|6|(3:7|8|10)) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0014 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001f */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x002a */
        static {
            /*
                com.google.firebase.inappmessaging.model.MessageType[] r0 = com.google.firebase.inappmessaging.model.MessageType.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                $SwitchMap$com$google$firebase$inappmessaging$model$MessageType = r0
                int[] r0 = $SwitchMap$com$google$firebase$inappmessaging$model$MessageType     // Catch:{ NoSuchFieldError -> 0x0014 }
                com.google.firebase.inappmessaging.model.MessageType r1 = com.google.firebase.inappmessaging.model.MessageType.BANNER     // Catch:{ NoSuchFieldError -> 0x0014 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0014 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0014 }
            L_0x0014:
                int[] r0 = $SwitchMap$com$google$firebase$inappmessaging$model$MessageType     // Catch:{ NoSuchFieldError -> 0x001f }
                com.google.firebase.inappmessaging.model.MessageType r1 = com.google.firebase.inappmessaging.model.MessageType.MODAL     // Catch:{ NoSuchFieldError -> 0x001f }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001f }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001f }
            L_0x001f:
                int[] r0 = $SwitchMap$com$google$firebase$inappmessaging$model$MessageType     // Catch:{ NoSuchFieldError -> 0x002a }
                com.google.firebase.inappmessaging.model.MessageType r1 = com.google.firebase.inappmessaging.model.MessageType.IMAGE_ONLY     // Catch:{ NoSuchFieldError -> 0x002a }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x002a }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x002a }
            L_0x002a:
                int[] r0 = $SwitchMap$com$google$firebase$inappmessaging$model$MessageType     // Catch:{ NoSuchFieldError -> 0x0035 }
                com.google.firebase.inappmessaging.model.MessageType r1 = com.google.firebase.inappmessaging.model.MessageType.CARD     // Catch:{ NoSuchFieldError -> 0x0035 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0035 }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0035 }
            L_0x0035:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.firebase.inappmessaging.display.FirebaseInAppMessagingDisplay.C23135.<clinit>():void");
        }
    }

    /* access modifiers changed from: private */
    @SuppressLint({"ClickableViewAccessibility"})
    public void inflateBinding(final Activity activity, final BindingWrapper bindingWrapper) {
        Object obj;
        C23062 r0 = new View.OnClickListener() {
            public void onClick(View view) {
                if (FirebaseInAppMessagingDisplay.this.callbacks != null) {
                    FirebaseInAppMessagingDisplay.this.callbacks.messageDismissed(FirebaseInAppMessagingDisplayCallbacks.InAppMessagingDismissType.CLICK);
                }
                FirebaseInAppMessagingDisplay.this.dismissFiam(activity);
            }
        };
        HashMap hashMap = new HashMap();
        for (final Action next : extractActions(this.inAppMessage)) {
            if (next == null || TextUtils.isEmpty(next.getActionUrl())) {
                Logging.loge("No action url found for action.");
                obj = r0;
            } else {
                obj = new View.OnClickListener() {
                    public void onClick(View view) {
                        if (FirebaseInAppMessagingDisplay.this.callbacks != null) {
                            FirebaseInAppMessagingDisplay.this.callbacks.messageClicked(next);
                        }
                        new CustomTabsIntent.Builder().setShowTitle(true).build().launchUrl(activity, Uri.parse(next.getActionUrl()));
                        FirebaseInAppMessagingDisplay.this.notifyFiamClick();
                        FirebaseInAppMessagingDisplay.this.removeDisplayedFiam(activity);
                        InAppMessage unused = FirebaseInAppMessagingDisplay.this.inAppMessage = null;
                        FirebaseInAppMessagingDisplayCallbacks unused2 = FirebaseInAppMessagingDisplay.this.callbacks = null;
                    }
                };
            }
            hashMap.put(next, obj);
        }
        final ViewTreeObserver.OnGlobalLayoutListener inflate = bindingWrapper.inflate(hashMap, r0);
        if (inflate != null) {
            bindingWrapper.getImageView().getViewTreeObserver().addOnGlobalLayoutListener(inflate);
        }
        loadNullableImage(activity, bindingWrapper, extractImageData(this.inAppMessage), new Callback() {
            public void onSuccess() {
                if (!bindingWrapper.getConfig().backgroundEnabled().booleanValue()) {
                    bindingWrapper.getRootView().setOnTouchListener(new View.OnTouchListener() {
                        public boolean onTouch(View view, MotionEvent motionEvent) {
                            if (motionEvent.getAction() != 4) {
                                return false;
                            }
                            if (FirebaseInAppMessagingDisplay.this.callbacks != null) {
                                FirebaseInAppMessagingDisplay.this.callbacks.messageDismissed(FirebaseInAppMessagingDisplayCallbacks.InAppMessagingDismissType.UNKNOWN_DISMISS_TYPE);
                            }
                            FirebaseInAppMessagingDisplay.this.dismissFiam(activity);
                            return true;
                        }
                    });
                }
                FirebaseInAppMessagingDisplay.this.impressionTimer.start(new RenewableTimer.Callback() {
                    public void onFinish() {
                        if (FirebaseInAppMessagingDisplay.this.inAppMessage != null && FirebaseInAppMessagingDisplay.this.callbacks != null) {
                            Logging.logi("Impression timer onFinish for: " + FirebaseInAppMessagingDisplay.this.inAppMessage.getCampaignMetadata().getCampaignId());
                            FirebaseInAppMessagingDisplay.this.callbacks.impressionDetected();
                        }
                    }
                }, 5000, 1000);
                if (bindingWrapper.getConfig().autoDismiss().booleanValue()) {
                    FirebaseInAppMessagingDisplay.this.autoDismissTimer.start(new RenewableTimer.Callback() {
                        public void onFinish() {
                            if (!(FirebaseInAppMessagingDisplay.this.inAppMessage == null || FirebaseInAppMessagingDisplay.this.callbacks == null)) {
                                FirebaseInAppMessagingDisplay.this.callbacks.messageDismissed(FirebaseInAppMessagingDisplayCallbacks.InAppMessagingDismissType.AUTO);
                            }
                            FirebaseInAppMessagingDisplay.this.dismissFiam(activity);
                        }
                    }, FirebaseInAppMessagingDisplay.DISMISS_THRESHOLD_MILLIS, 1000);
                }
                activity.runOnUiThread(new Runnable() {
                    public void run() {
                        FirebaseInAppMessagingDisplay.this.windowManager.show(bindingWrapper, activity);
                        if (bindingWrapper.getConfig().animate().booleanValue()) {
                            FirebaseInAppMessagingDisplay.this.animator.slideIntoView(FirebaseInAppMessagingDisplay.this.application, bindingWrapper.getRootView(), FiamAnimator.Position.TOP);
                        }
                    }
                });
            }

            public void onError(Exception exc) {
                Logging.loge("Image download failure ");
                if (inflate != null) {
                    bindingWrapper.getImageView().getViewTreeObserver().removeGlobalOnLayoutListener(inflate);
                }
                FirebaseInAppMessagingDisplay.this.cancelTimers();
                InAppMessage unused = FirebaseInAppMessagingDisplay.this.inAppMessage = null;
                FirebaseInAppMessagingDisplayCallbacks unused2 = FirebaseInAppMessagingDisplay.this.callbacks = null;
            }
        });
    }

    private List<Action> extractActions(InAppMessage inAppMessage2) {
        ArrayList arrayList = new ArrayList();
        int i = C23135.$SwitchMap$com$google$firebase$inappmessaging$model$MessageType[inAppMessage2.getMessageType().ordinal()];
        if (i == 1) {
            arrayList.add(((BannerMessage) inAppMessage2).getAction());
        } else if (i == 2) {
            arrayList.add(((ModalMessage) inAppMessage2).getAction());
        } else if (i == 3) {
            arrayList.add(((ImageOnlyMessage) inAppMessage2).getAction());
        } else if (i != 4) {
            arrayList.add(Action.builder().build());
        } else {
            CardMessage cardMessage = (CardMessage) inAppMessage2;
            arrayList.add(cardMessage.getPrimaryAction());
            arrayList.add(cardMessage.getSecondaryAction());
        }
        return arrayList;
    }

    private ImageData extractImageData(InAppMessage inAppMessage2) {
        if (inAppMessage2.getMessageType() != MessageType.CARD) {
            return inAppMessage2.getImageData();
        }
        CardMessage cardMessage = (CardMessage) inAppMessage2;
        ImageData portraitImageData = cardMessage.getPortraitImageData();
        ImageData landscapeImageData = cardMessage.getLandscapeImageData();
        return getScreenOrientation(this.application) == 1 ? isValidImageData(portraitImageData) ? portraitImageData : landscapeImageData : isValidImageData(landscapeImageData) ? landscapeImageData : portraitImageData;
    }

    private boolean isValidImageData(@Nullable ImageData imageData) {
        return imageData != null && !TextUtils.isEmpty(imageData.getImageUrl());
    }

    private void loadNullableImage(Activity activity, BindingWrapper bindingWrapper, ImageData imageData, Callback callback) {
        if (isValidImageData(imageData)) {
            this.imageLoader.load(imageData.getImageUrl()).tag(activity.getClass()).placeholder(C2314R.C2316drawable.image_placeholder).into(bindingWrapper.getImageView(), callback);
        } else {
            callback.onSuccess();
        }
    }

    /* access modifiers changed from: private */
    public void dismissFiam(Activity activity) {
        Logging.logd("Dismissing fiam");
        notifyFiamDismiss();
        removeDisplayedFiam(activity);
        this.inAppMessage = null;
        this.callbacks = null;
    }

    /* access modifiers changed from: private */
    public void removeDisplayedFiam(Activity activity) {
        if (this.windowManager.isFiamDisplayed()) {
            this.windowManager.destroy(activity);
            cancelTimers();
        }
    }

    /* access modifiers changed from: private */
    public void cancelTimers() {
        this.impressionTimer.cancel();
        this.autoDismissTimer.cancel();
    }

    private void notifyFiamTrigger() {
        FiamListener fiamListener2 = this.fiamListener;
        if (fiamListener2 != null) {
            fiamListener2.onFiamTrigger();
        }
    }

    /* access modifiers changed from: private */
    public void notifyFiamClick() {
        FiamListener fiamListener2 = this.fiamListener;
        if (fiamListener2 != null) {
            fiamListener2.onFiamClick();
        }
    }

    private void notifyFiamDismiss() {
        FiamListener fiamListener2 = this.fiamListener;
        if (fiamListener2 != null) {
            fiamListener2.onFiamDismiss();
        }
    }
}

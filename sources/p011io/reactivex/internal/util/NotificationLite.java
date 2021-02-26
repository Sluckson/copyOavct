package p011io.reactivex.internal.util;

import java.io.Serializable;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;
import p011io.reactivex.Observer;
import p011io.reactivex.disposables.Disposable;
import p011io.reactivex.internal.functions.ObjectHelper;

/* renamed from: io.reactivex.internal.util.NotificationLite */
public enum NotificationLite {
    COMPLETE;

    public static <T> T getValue(Object obj) {
        return obj;
    }

    public static <T> Object next(T t) {
        return t;
    }

    public String toString() {
        return "NotificationLite.Complete";
    }

    /* renamed from: io.reactivex.internal.util.NotificationLite$ErrorNotification */
    static final class ErrorNotification implements Serializable {
        private static final long serialVersionUID = -8759979445933046293L;

        /* renamed from: e */
        final Throwable f5379e;

        ErrorNotification(Throwable th) {
            this.f5379e = th;
        }

        public String toString() {
            return "NotificationLite.Error[" + this.f5379e + "]";
        }

        public int hashCode() {
            return this.f5379e.hashCode();
        }

        public boolean equals(Object obj) {
            if (obj instanceof ErrorNotification) {
                return ObjectHelper.equals(this.f5379e, ((ErrorNotification) obj).f5379e);
            }
            return false;
        }
    }

    /* renamed from: io.reactivex.internal.util.NotificationLite$SubscriptionNotification */
    static final class SubscriptionNotification implements Serializable {
        private static final long serialVersionUID = -1322257508628817540L;

        /* renamed from: s */
        final Subscription f5380s;

        SubscriptionNotification(Subscription subscription) {
            this.f5380s = subscription;
        }

        public String toString() {
            return "NotificationLite.Subscription[" + this.f5380s + "]";
        }
    }

    /* renamed from: io.reactivex.internal.util.NotificationLite$DisposableNotification */
    static final class DisposableNotification implements Serializable {
        private static final long serialVersionUID = -7482590109178395495L;

        /* renamed from: d */
        final Disposable f5378d;

        DisposableNotification(Disposable disposable) {
            this.f5378d = disposable;
        }

        public String toString() {
            return "NotificationLite.Disposable[" + this.f5378d + "]";
        }
    }

    public static Object complete() {
        return COMPLETE;
    }

    public static Object error(Throwable th) {
        return new ErrorNotification(th);
    }

    public static Object subscription(Subscription subscription) {
        return new SubscriptionNotification(subscription);
    }

    public static Object disposable(Disposable disposable) {
        return new DisposableNotification(disposable);
    }

    public static boolean isComplete(Object obj) {
        return obj == COMPLETE;
    }

    public static boolean isError(Object obj) {
        return obj instanceof ErrorNotification;
    }

    public static boolean isSubscription(Object obj) {
        return obj instanceof SubscriptionNotification;
    }

    public static boolean isDisposable(Object obj) {
        return obj instanceof DisposableNotification;
    }

    public static Throwable getError(Object obj) {
        return ((ErrorNotification) obj).f5379e;
    }

    public static Subscription getSubscription(Object obj) {
        return ((SubscriptionNotification) obj).f5380s;
    }

    public static Disposable getDisposable(Object obj) {
        return ((DisposableNotification) obj).f5378d;
    }

    public static <T> boolean accept(Object obj, Subscriber<? super T> subscriber) {
        if (obj == COMPLETE) {
            subscriber.onComplete();
            return true;
        } else if (obj instanceof ErrorNotification) {
            subscriber.onError(((ErrorNotification) obj).f5379e);
            return true;
        } else {
            subscriber.onNext(obj);
            return false;
        }
    }

    public static <T> boolean accept(Object obj, Observer<? super T> observer) {
        if (obj == COMPLETE) {
            observer.onComplete();
            return true;
        } else if (obj instanceof ErrorNotification) {
            observer.onError(((ErrorNotification) obj).f5379e);
            return true;
        } else {
            observer.onNext(obj);
            return false;
        }
    }

    public static <T> boolean acceptFull(Object obj, Subscriber<? super T> subscriber) {
        if (obj == COMPLETE) {
            subscriber.onComplete();
            return true;
        } else if (obj instanceof ErrorNotification) {
            subscriber.onError(((ErrorNotification) obj).f5379e);
            return true;
        } else if (obj instanceof SubscriptionNotification) {
            subscriber.onSubscribe(((SubscriptionNotification) obj).f5380s);
            return false;
        } else {
            subscriber.onNext(obj);
            return false;
        }
    }

    public static <T> boolean acceptFull(Object obj, Observer<? super T> observer) {
        if (obj == COMPLETE) {
            observer.onComplete();
            return true;
        } else if (obj instanceof ErrorNotification) {
            observer.onError(((ErrorNotification) obj).f5379e);
            return true;
        } else if (obj instanceof DisposableNotification) {
            observer.onSubscribe(((DisposableNotification) obj).f5378d);
            return false;
        } else {
            observer.onNext(obj);
            return false;
        }
    }
}

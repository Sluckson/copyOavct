package kotlinx.coroutines.channels;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.DebugKt;
import kotlinx.coroutines.channels.AbstractSendChannel;
import kotlinx.coroutines.selects.SelectInstance;
import kotlinx.coroutines.selects.SelectKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(mo66931bv = {1, 0, 3}, mo66932d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0010\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u0002H\u00010\u0002B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\b\u0010\u001b\u001a\u00020\u001cH\u0014J\u0010\u0010\u001d\u001a\u00020\u001c2\u0006\u0010\u001e\u001a\u00020\u0004H\u0002J\u0015\u0010\u001f\u001a\u00020\b2\u0006\u0010 \u001a\u00028\u0000H\u0014¢\u0006\u0002\u0010!J!\u0010\"\u001a\u00020\b2\u0006\u0010 \u001a\u00028\u00002\n\u0010#\u001a\u0006\u0012\u0002\b\u00030$H\u0014¢\u0006\u0002\u0010%J\n\u0010&\u001a\u0004\u0018\u00010\bH\u0014J\u0016\u0010'\u001a\u0004\u0018\u00010\b2\n\u0010#\u001a\u0006\u0012\u0002\b\u00030$H\u0014R\u0018\u0010\u0006\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\b0\u0007X\u000e¢\u0006\u0004\n\u0002\u0010\tR\u0014\u0010\n\u001a\u00020\u000b8TX\u0004¢\u0006\u0006\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u000e\u0010\u0010\u001a\u00020\u0004X\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0011\u001a\u00020\u00128DX\u0004¢\u0006\u0006\u001a\u0004\b\u0011\u0010\u0013R\u0014\u0010\u0014\u001a\u00020\u00128DX\u0004¢\u0006\u0006\u001a\u0004\b\u0014\u0010\u0013R\u0014\u0010\u0015\u001a\u00020\u00128DX\u0004¢\u0006\u0006\u001a\u0004\b\u0015\u0010\u0013R\u0014\u0010\u0016\u001a\u00020\u00128DX\u0004¢\u0006\u0006\u001a\u0004\b\u0016\u0010\u0013R\u0012\u0010\u0017\u001a\u00060\u0018j\u0002`\u0019X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u0004X\u000e¢\u0006\u0002\n\u0000¨\u0006("}, mo66933d2 = {"Lkotlinx/coroutines/channels/ArrayChannel;", "E", "Lkotlinx/coroutines/channels/AbstractChannel;", "capacity", "", "(I)V", "buffer", "", "", "[Ljava/lang/Object;", "bufferDebugString", "", "getBufferDebugString", "()Ljava/lang/String;", "getCapacity", "()I", "head", "isBufferAlwaysEmpty", "", "()Z", "isBufferAlwaysFull", "isBufferEmpty", "isBufferFull", "lock", "Ljava/util/concurrent/locks/ReentrantLock;", "Lkotlinx/coroutines/internal/ReentrantLock;", "size", "cleanupSendQueueOnCancel", "", "ensureCapacity", "currentSize", "offerInternal", "element", "(Ljava/lang/Object;)Ljava/lang/Object;", "offerSelectInternal", "select", "Lkotlinx/coroutines/selects/SelectInstance;", "(Ljava/lang/Object;Lkotlinx/coroutines/selects/SelectInstance;)Ljava/lang/Object;", "pollInternal", "pollSelectInternal", "kotlinx-coroutines-core"}, mo66934k = 1, mo66935mv = {1, 1, 15})
/* compiled from: ArrayChannel.kt */
public class ArrayChannel<E> extends AbstractChannel<E> {
    private Object[] buffer;
    private final int capacity;
    private int head;
    private final ReentrantLock lock;
    private volatile int size;

    /* access modifiers changed from: protected */
    public final boolean isBufferAlwaysEmpty() {
        return false;
    }

    /* access modifiers changed from: protected */
    public final boolean isBufferAlwaysFull() {
        return false;
    }

    public final int getCapacity() {
        return this.capacity;
    }

    public ArrayChannel(int i) {
        this.capacity = i;
        if (this.capacity < 1 ? false : true) {
            this.lock = new ReentrantLock();
            this.buffer = new Object[Math.min(this.capacity, 8)];
            return;
        }
        throw new IllegalArgumentException(("ArrayChannel capacity must be at least 1, but " + this.capacity + " was specified").toString());
    }

    /* access modifiers changed from: protected */
    public final boolean isBufferEmpty() {
        return this.size == 0;
    }

    /* access modifiers changed from: protected */
    public final boolean isBufferFull() {
        return this.size == this.capacity;
    }

    /* access modifiers changed from: protected */
    @NotNull
    public Object offerInternal(E e) {
        ReceiveOrClosed takeFirstReceiveOrPeekClosed;
        Object tryResumeReceive;
        ReceiveOrClosed receiveOrClosed = null;
        Lock lock2 = this.lock;
        lock2.lock();
        try {
            int i = this.size;
            Closed<?> closedForSend = getClosedForSend();
            if (closedForSend != null) {
                return closedForSend;
            }
            if (i < this.capacity) {
                this.size = i + 1;
                if (i == 0) {
                    do {
                        takeFirstReceiveOrPeekClosed = takeFirstReceiveOrPeekClosed();
                        if (takeFirstReceiveOrPeekClosed != null) {
                            if (takeFirstReceiveOrPeekClosed instanceof Closed) {
                                this.size = i;
                                if (takeFirstReceiveOrPeekClosed == null) {
                                    Intrinsics.throwNpe();
                                }
                                lock2.unlock();
                                return takeFirstReceiveOrPeekClosed;
                            }
                            if (takeFirstReceiveOrPeekClosed == null) {
                                Intrinsics.throwNpe();
                            }
                            tryResumeReceive = takeFirstReceiveOrPeekClosed.tryResumeReceive(e, (Object) null);
                        }
                    } while (tryResumeReceive == null);
                    this.size = i;
                    Unit unit = Unit.INSTANCE;
                    lock2.unlock();
                    if (takeFirstReceiveOrPeekClosed == null) {
                        Intrinsics.throwNpe();
                    }
                    takeFirstReceiveOrPeekClosed.completeResumeReceive(tryResumeReceive);
                    if (takeFirstReceiveOrPeekClosed == null) {
                        Intrinsics.throwNpe();
                    }
                    return takeFirstReceiveOrPeekClosed.getOfferResult();
                }
                ensureCapacity(i);
                this.buffer[(this.head + i) % this.buffer.length] = e;
                Object obj = AbstractChannelKt.OFFER_SUCCESS;
                lock2.unlock();
                return obj;
            }
            Object obj2 = AbstractChannelKt.OFFER_FAILED;
            lock2.unlock();
            return obj2;
        } finally {
            lock2.unlock();
        }
    }

    /* access modifiers changed from: protected */
    @NotNull
    public Object offerSelectInternal(E e, @NotNull SelectInstance<?> selectInstance) {
        Intrinsics.checkParameterIsNotNull(selectInstance, "select");
        ReceiveOrClosed receiveOrClosed = null;
        Lock lock2 = this.lock;
        lock2.lock();
        try {
            int i = this.size;
            Closed<?> closedForSend = getClosedForSend();
            if (closedForSend != null) {
                return closedForSend;
            }
            if (i < this.capacity) {
                this.size = i + 1;
                if (i == 0) {
                    AbstractSendChannel.TryOfferDesc describeTryOffer = describeTryOffer(e);
                    Object performAtomicTrySelect = selectInstance.performAtomicTrySelect(describeTryOffer);
                    if (performAtomicTrySelect == null) {
                        this.size = i;
                        ReceiveOrClosed receiveOrClosed2 = (ReceiveOrClosed) describeTryOffer.getResult();
                        Object obj = describeTryOffer.resumeToken;
                        if (DebugKt.getASSERTIONS_ENABLED()) {
                            if (!(obj != null)) {
                                throw new AssertionError();
                            }
                        }
                        Unit unit = Unit.INSTANCE;
                        lock2.unlock();
                        if (receiveOrClosed2 == null) {
                            Intrinsics.throwNpe();
                        }
                        if (obj == null) {
                            Intrinsics.throwNpe();
                        }
                        receiveOrClosed2.completeResumeReceive(obj);
                        if (receiveOrClosed2 == null) {
                            Intrinsics.throwNpe();
                        }
                        return receiveOrClosed2.getOfferResult();
                    } else if (performAtomicTrySelect != AbstractChannelKt.OFFER_FAILED) {
                        if (performAtomicTrySelect != SelectKt.getALREADY_SELECTED()) {
                            if (!(performAtomicTrySelect instanceof Closed)) {
                                throw new IllegalStateException(("performAtomicTrySelect(describeTryOffer) returned " + performAtomicTrySelect).toString());
                            }
                        }
                        this.size = i;
                        lock2.unlock();
                        return performAtomicTrySelect;
                    }
                }
                if (!selectInstance.trySelect((Object) null)) {
                    this.size = i;
                    Object already_selected = SelectKt.getALREADY_SELECTED();
                    lock2.unlock();
                    return already_selected;
                }
                ensureCapacity(i);
                this.buffer[(this.head + i) % this.buffer.length] = e;
                Object obj2 = AbstractChannelKt.OFFER_SUCCESS;
                lock2.unlock();
                return obj2;
            }
            Object obj3 = AbstractChannelKt.OFFER_FAILED;
            lock2.unlock();
            return obj3;
        } finally {
            lock2.unlock();
        }
    }

    private final void ensureCapacity(int i) {
        Object[] objArr = this.buffer;
        if (i >= objArr.length) {
            Object[] objArr2 = new Object[Math.min(objArr.length * 2, this.capacity)];
            for (int i2 = 0; i2 < i; i2++) {
                Object[] objArr3 = this.buffer;
                objArr2[i2] = objArr3[(this.head + i2) % objArr3.length];
            }
            this.buffer = objArr2;
            this.head = 0;
        }
    }

    /* access modifiers changed from: protected */
    @Nullable
    public Object pollInternal() {
        Object obj;
        Send send = null;
        Lock lock2 = this.lock;
        lock2.lock();
        try {
            int i = this.size;
            if (i == 0) {
                Object closedForSend = getClosedForSend();
                if (closedForSend == null) {
                    closedForSend = AbstractChannelKt.POLL_FAILED;
                }
                return closedForSend;
            }
            Object obj2 = this.buffer[this.head];
            this.buffer[this.head] = null;
            this.size = i - 1;
            Object obj3 = AbstractChannelKt.POLL_FAILED;
            if (i == this.capacity) {
                obj = null;
                while (true) {
                    Send takeFirstSendOrPeekClosed = takeFirstSendOrPeekClosed();
                    if (takeFirstSendOrPeekClosed == null) {
                        break;
                    }
                    if (takeFirstSendOrPeekClosed == null) {
                        Intrinsics.throwNpe();
                    }
                    obj = takeFirstSendOrPeekClosed.tryResumeSend((Object) null);
                    if (obj != null) {
                        if (takeFirstSendOrPeekClosed == null) {
                            Intrinsics.throwNpe();
                        }
                        obj3 = takeFirstSendOrPeekClosed.getPollResult();
                        send = takeFirstSendOrPeekClosed;
                    } else {
                        send = takeFirstSendOrPeekClosed;
                    }
                }
            } else {
                obj = null;
            }
            if (obj3 != AbstractChannelKt.POLL_FAILED && !(obj3 instanceof Closed)) {
                this.size = i;
                this.buffer[(this.head + i) % this.buffer.length] = obj3;
            }
            this.head = (this.head + 1) % this.buffer.length;
            Unit unit = Unit.INSTANCE;
            lock2.unlock();
            if (obj != null) {
                if (send == null) {
                    Intrinsics.throwNpe();
                }
                send.completeResumeSend(obj);
            }
            return obj2;
        } finally {
            lock2.unlock();
        }
    }

    /* access modifiers changed from: protected */
    /* JADX WARNING: Removed duplicated region for block: B:46:0x00c1 A[Catch:{ all -> 0x00fe }] */
    /* JADX WARNING: Removed duplicated region for block: B:47:0x00cf A[Catch:{ all -> 0x00fe }] */
    /* JADX WARNING: Removed duplicated region for block: B:56:0x00f5  */
    @org.jetbrains.annotations.Nullable
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.Object pollSelectInternal(@org.jetbrains.annotations.NotNull kotlinx.coroutines.selects.SelectInstance<?> r11) {
        /*
            r10 = this;
            java.lang.String r0 = "select"
            kotlin.jvm.internal.Intrinsics.checkParameterIsNotNull(r11, r0)
            r0 = 0
            r1 = r0
            kotlinx.coroutines.channels.Send r1 = (kotlinx.coroutines.channels.Send) r1
            java.util.concurrent.locks.ReentrantLock r2 = r10.lock
            java.util.concurrent.locks.Lock r2 = (java.util.concurrent.locks.Lock) r2
            r2.lock()
            int r3 = r10.size     // Catch:{ all -> 0x00fe }
            if (r3 != 0) goto L_0x0021
            kotlinx.coroutines.channels.Closed r11 = r10.getClosedForSend()     // Catch:{ all -> 0x00fe }
            if (r11 == 0) goto L_0x001b
            goto L_0x001d
        L_0x001b:
            java.lang.Object r11 = kotlinx.coroutines.channels.AbstractChannelKt.POLL_FAILED     // Catch:{ all -> 0x00fe }
        L_0x001d:
            r2.unlock()
            return r11
        L_0x0021:
            java.lang.Object[] r4 = r10.buffer     // Catch:{ all -> 0x00fe }
            int r5 = r10.head     // Catch:{ all -> 0x00fe }
            r4 = r4[r5]     // Catch:{ all -> 0x00fe }
            java.lang.Object[] r5 = r10.buffer     // Catch:{ all -> 0x00fe }
            int r6 = r10.head     // Catch:{ all -> 0x00fe }
            r5[r6] = r0     // Catch:{ all -> 0x00fe }
            int r5 = r3 + -1
            r10.size = r5     // Catch:{ all -> 0x00fe }
            java.lang.Object r5 = kotlinx.coroutines.channels.AbstractChannelKt.POLL_FAILED     // Catch:{ all -> 0x00fe }
            int r6 = r10.capacity     // Catch:{ all -> 0x00fe }
            r7 = 1
            if (r3 != r6) goto L_0x00b7
            kotlinx.coroutines.channels.AbstractChannel$TryPollDesc r6 = r10.describeTryPoll()     // Catch:{ all -> 0x00fe }
            r8 = r6
            kotlinx.coroutines.internal.AtomicDesc r8 = (kotlinx.coroutines.internal.AtomicDesc) r8     // Catch:{ all -> 0x00fe }
            java.lang.Object r8 = r11.performAtomicTrySelect(r8)     // Catch:{ all -> 0x00fe }
            if (r8 != 0) goto L_0x0071
            java.lang.Object r1 = r6.getResult()     // Catch:{ all -> 0x00fe }
            kotlinx.coroutines.channels.Send r1 = (kotlinx.coroutines.channels.Send) r1     // Catch:{ all -> 0x00fe }
            java.lang.Object r5 = r6.resumeToken     // Catch:{ all -> 0x00fe }
            boolean r6 = kotlinx.coroutines.DebugKt.getASSERTIONS_ENABLED()     // Catch:{ all -> 0x00fe }
            if (r6 == 0) goto L_0x0063
            if (r5 == 0) goto L_0x0057
            r6 = 1
            goto L_0x0058
        L_0x0057:
            r6 = 0
        L_0x0058:
            if (r6 == 0) goto L_0x005b
            goto L_0x0063
        L_0x005b:
            java.lang.AssertionError r11 = new java.lang.AssertionError     // Catch:{ all -> 0x00fe }
            r11.<init>()     // Catch:{ all -> 0x00fe }
            java.lang.Throwable r11 = (java.lang.Throwable) r11     // Catch:{ all -> 0x00fe }
            throw r11     // Catch:{ all -> 0x00fe }
        L_0x0063:
            if (r1 != 0) goto L_0x0068
            kotlin.jvm.internal.Intrinsics.throwNpe()     // Catch:{ all -> 0x00fe }
        L_0x0068:
            java.lang.Object r6 = r1.getPollResult()     // Catch:{ all -> 0x00fe }
            r9 = r6
            r6 = r1
            r1 = r5
            r5 = r9
            goto L_0x00b9
        L_0x0071:
            java.lang.Object r6 = kotlinx.coroutines.channels.AbstractChannelKt.POLL_FAILED     // Catch:{ all -> 0x00fe }
            if (r8 != r6) goto L_0x0076
            goto L_0x00b7
        L_0x0076:
            java.lang.Object r1 = kotlinx.coroutines.selects.SelectKt.getALREADY_SELECTED()     // Catch:{ all -> 0x00fe }
            if (r8 != r1) goto L_0x0088
            r10.size = r3     // Catch:{ all -> 0x00fe }
            java.lang.Object[] r11 = r10.buffer     // Catch:{ all -> 0x00fe }
            int r0 = r10.head     // Catch:{ all -> 0x00fe }
            r11[r0] = r4     // Catch:{ all -> 0x00fe }
            r2.unlock()
            return r8
        L_0x0088:
            boolean r1 = r8 instanceof kotlinx.coroutines.channels.Closed     // Catch:{ all -> 0x00fe }
            if (r1 == 0) goto L_0x009a
            r1 = r8
            kotlinx.coroutines.channels.Send r1 = (kotlinx.coroutines.channels.Send) r1     // Catch:{ all -> 0x00fe }
            r5 = r8
            kotlinx.coroutines.channels.Closed r5 = (kotlinx.coroutines.channels.Closed) r5     // Catch:{ all -> 0x00fe }
            java.lang.Object r5 = r5.tryResumeSend(r0)     // Catch:{ all -> 0x00fe }
            r6 = r1
            r1 = r5
            r5 = r8
            goto L_0x00b9
        L_0x009a:
            java.lang.StringBuilder r11 = new java.lang.StringBuilder     // Catch:{ all -> 0x00fe }
            r11.<init>()     // Catch:{ all -> 0x00fe }
            java.lang.String r0 = "performAtomicTrySelect(describeTryOffer) returned "
            r11.append(r0)     // Catch:{ all -> 0x00fe }
            r11.append(r8)     // Catch:{ all -> 0x00fe }
            java.lang.String r11 = r11.toString()     // Catch:{ all -> 0x00fe }
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException     // Catch:{ all -> 0x00fe }
            java.lang.String r11 = r11.toString()     // Catch:{ all -> 0x00fe }
            r0.<init>(r11)     // Catch:{ all -> 0x00fe }
            java.lang.Throwable r0 = (java.lang.Throwable) r0     // Catch:{ all -> 0x00fe }
            throw r0     // Catch:{ all -> 0x00fe }
        L_0x00b7:
            r6 = r1
            r1 = r0
        L_0x00b9:
            java.lang.Object r8 = kotlinx.coroutines.channels.AbstractChannelKt.POLL_FAILED     // Catch:{ all -> 0x00fe }
            if (r5 == r8) goto L_0x00cf
            boolean r8 = r5 instanceof kotlinx.coroutines.channels.Closed     // Catch:{ all -> 0x00fe }
            if (r8 != 0) goto L_0x00cf
            r10.size = r3     // Catch:{ all -> 0x00fe }
            java.lang.Object[] r11 = r10.buffer     // Catch:{ all -> 0x00fe }
            int r0 = r10.head     // Catch:{ all -> 0x00fe }
            int r0 = r0 + r3
            java.lang.Object[] r3 = r10.buffer     // Catch:{ all -> 0x00fe }
            int r3 = r3.length     // Catch:{ all -> 0x00fe }
            int r0 = r0 % r3
            r11[r0] = r5     // Catch:{ all -> 0x00fe }
            goto L_0x00e5
        L_0x00cf:
            boolean r11 = r11.trySelect(r0)     // Catch:{ all -> 0x00fe }
            if (r11 != 0) goto L_0x00e5
            r10.size = r3     // Catch:{ all -> 0x00fe }
            java.lang.Object[] r11 = r10.buffer     // Catch:{ all -> 0x00fe }
            int r0 = r10.head     // Catch:{ all -> 0x00fe }
            r11[r0] = r4     // Catch:{ all -> 0x00fe }
            java.lang.Object r11 = kotlinx.coroutines.selects.SelectKt.getALREADY_SELECTED()     // Catch:{ all -> 0x00fe }
            r2.unlock()
            return r11
        L_0x00e5:
            int r11 = r10.head     // Catch:{ all -> 0x00fe }
            int r11 = r11 + r7
            java.lang.Object[] r0 = r10.buffer     // Catch:{ all -> 0x00fe }
            int r0 = r0.length     // Catch:{ all -> 0x00fe }
            int r11 = r11 % r0
            r10.head = r11     // Catch:{ all -> 0x00fe }
            kotlin.Unit r11 = kotlin.Unit.INSTANCE     // Catch:{ all -> 0x00fe }
            r2.unlock()
            if (r1 == 0) goto L_0x00fd
            if (r6 != 0) goto L_0x00fa
            kotlin.jvm.internal.Intrinsics.throwNpe()
        L_0x00fa:
            r6.completeResumeSend(r1)
        L_0x00fd:
            return r4
        L_0x00fe:
            r11 = move-exception
            r2.unlock()
            throw r11
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.channels.ArrayChannel.pollSelectInternal(kotlinx.coroutines.selects.SelectInstance):java.lang.Object");
    }

    /* JADX INFO: finally extract failed */
    /* access modifiers changed from: protected */
    public void cleanupSendQueueOnCancel() {
        Lock lock2 = this.lock;
        lock2.lock();
        try {
            int i = this.size;
            for (int i2 = 0; i2 < i; i2++) {
                this.buffer[this.head] = 0;
                this.head = (this.head + 1) % this.buffer.length;
            }
            this.size = 0;
            Unit unit = Unit.INSTANCE;
            lock2.unlock();
            super.cleanupSendQueueOnCancel();
        } catch (Throwable th) {
            lock2.unlock();
            throw th;
        }
    }

    /* access modifiers changed from: protected */
    @NotNull
    public String getBufferDebugString() {
        return "(buffer:capacity=" + this.capacity + ",size=" + this.size + ')';
    }
}

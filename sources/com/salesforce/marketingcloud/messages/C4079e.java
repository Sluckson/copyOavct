package com.salesforce.marketingcloud.messages;

import android.annotation.SuppressLint;
import android.text.TextUtils;
import androidx.annotation.RestrictTo;
import com.salesforce.marketingcloud.C4039h;
import com.salesforce.marketingcloud.p022d.C4016h;
import com.salesforce.marketingcloud.p022d.C4017i;
import com.salesforce.marketingcloud.p027e.C4022a;
import java.util.Date;

@SuppressLint({"UnknownNullness"})
/* renamed from: com.salesforce.marketingcloud.messages.e */
public final class C4079e {

    /* renamed from: a */
    private static final String f3101a = C4086h.f3118d;

    private C4079e() {
    }

    /* renamed from: a */
    private static int m3042a(Message message) {
        int messagesPerPeriod = message.messagesPerPeriod();
        if (messagesPerPeriod > 0 || message.numberOfPeriods() <= 0 || message.periodType() == 0) {
            return messagesPerPeriod;
        }
        return 1;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    /* renamed from: a */
    public static void m3043a(Message message, C4017i iVar, C4022a aVar) {
        Message a = iVar.mo56489a(message.mo56608id(), aVar);
        if (a != null) {
            message.mo56670b(a.getLastShownDate());
            message.mo56669b(a.getShowCount());
            if (message.periodType() == a.periodType()) {
                message.mo56671c(a.getPeriodShowCount());
                message.mo56668a(a.getNextAllowedShow());
            }
        }
    }

    /* renamed from: a */
    static boolean m3044a(Message message, C4016h hVar) {
        try {
            if (TextUtils.isEmpty(message.alert().trim())) {
                C4039h.m2820b(f3101a, "Message (%s) was tripped, but does not have an alert message", message.mo56608id());
                return false;
            }
            Date date = new Date();
            C4017i i = hVar.mo56537i();
            if (message.endDateUtc() != null && message.endDateUtc().before(date)) {
                C4039h.m2820b(f3101a, "Message (%s) was tripped, but has expired.", message.mo56608id());
                i.mo56487a(message.mo56608id());
                hVar.mo56539k().mo56506b(message.mo56608id());
                return false;
            } else if (message.startDateUtc() != null && message.startDateUtc().after(date)) {
                C4039h.m2820b(f3101a, "Message (%s) was tripped, but has not started", message.mo56608id());
                return false;
            } else if (message.messageLimit() <= -1 || message.getShowCount() < message.messageLimit()) {
                int a = m3042a(message);
                if (a > -1 && message.getPeriodShowCount() >= a && message.getNextAllowedShow() != null && date.before(message.getNextAllowedShow())) {
                    C4039h.m2820b(f3101a, "Message (%s) was tripped, but has met its message per period limit", message.mo56608id());
                    return false;
                } else if (message.getNextAllowedShow() == null || !date.before(message.getNextAllowedShow())) {
                    return true;
                } else {
                    C4039h.m2820b(f3101a, "Message (%s) was tripped, but was before its next allowed show time.", message.mo56608id());
                    return false;
                }
            } else {
                C4039h.m2820b(f3101a, "Message (%s) was tripped, but has met its message limit.", message.mo56608id());
                return false;
            }
        } catch (Exception e) {
            C4039h.m2830e(f3101a, e, "Failed to determine is message should be shown.", new Object[0]);
            return false;
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:32:0x00be, code lost:
        if (r6 != 5) goto L_0x00d2;
     */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x0093  */
    /* renamed from: b */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    static void m3045b(com.salesforce.marketingcloud.messages.Message r15, com.salesforce.marketingcloud.p022d.C4016h r16) {
        /*
            r0 = r15
            java.util.Date r1 = new java.util.Date
            r1.<init>()
            r15.mo56670b((java.util.Date) r1)
            int r2 = r15.getShowCount()
            r3 = 1
            int r2 = r2 + r3
            r15.mo56669b((int) r2)
            int r2 = m3042a(r15)
            r4 = -1
            r5 = 0
            if (r2 <= r4) goto L_0x00d9
            int r6 = r15.numberOfPeriods()
            if (r6 <= r4) goto L_0x00d9
            int r6 = r15.periodType()
            if (r6 == 0) goto L_0x00d9
            int r6 = r15.getPeriodShowCount()
            int r6 = r6 + r3
            r15.mo56671c(r6)
            int r6 = r15.getPeriodShowCount()
            int r7 = r15.messagesPerPeriod()
            if (r6 < r7) goto L_0x00d9
            r6 = 0
            int r8 = r15.periodType()
            r9 = 4
            r10 = 3
            r11 = 2
            r12 = 5
            if (r8 == r3) goto L_0x0069
            if (r8 == r11) goto L_0x005e
            if (r8 == r10) goto L_0x0059
            r13 = 1
            if (r8 == r9) goto L_0x0052
            if (r8 == r12) goto L_0x004f
            goto L_0x0079
        L_0x004f:
            java.util.concurrent.TimeUnit r6 = java.util.concurrent.TimeUnit.HOURS
            goto L_0x0054
        L_0x0052:
            java.util.concurrent.TimeUnit r6 = java.util.concurrent.TimeUnit.DAYS
        L_0x0054:
            long r6 = r6.toMillis(r13)
            goto L_0x0079
        L_0x0059:
            java.util.concurrent.TimeUnit r6 = java.util.concurrent.TimeUnit.DAYS
            r7 = 7
            goto L_0x0075
        L_0x005e:
            java.util.concurrent.TimeUnit r6 = java.util.concurrent.TimeUnit.DAYS
            java.util.Calendar r7 = java.util.Calendar.getInstance()
            int r7 = r7.getActualMaximum(r12)
            goto L_0x0074
        L_0x0069:
            java.util.concurrent.TimeUnit r6 = java.util.concurrent.TimeUnit.DAYS
            java.util.Calendar r7 = java.util.Calendar.getInstance()
            r8 = 6
            int r7 = r7.getActualMaximum(r8)
        L_0x0074:
            long r7 = (long) r7
        L_0x0075:
            long r6 = r6.toMillis(r7)
        L_0x0079:
            java.util.Date r8 = new java.util.Date
            long r13 = r1.getTime()
            int r1 = r15.numberOfPeriods()
            long r9 = (long) r1
            long r9 = r9 * r6
            long r13 = r13 + r9
            r8.<init>(r13)
            r15.mo56668a((java.util.Date) r8)
            boolean r1 = r15.isRollingPeriod()
            if (r1 != 0) goto L_0x00d9
            java.util.Calendar r1 = java.util.Calendar.getInstance()
            java.util.Date r6 = r15.getNextAllowedShow()
            long r6 = r6.getTime()
            r1.setTimeInMillis(r6)
            r6 = 14
            r1.set(r6, r5)
            r6 = 13
            r1.set(r6, r5)
            int r6 = r15.periodType()
            r7 = 10
            r8 = 12
            if (r6 == r3) goto L_0x00c6
            if (r6 == r11) goto L_0x00c9
            r9 = 3
            if (r6 == r9) goto L_0x00c1
            r9 = 4
            if (r6 == r9) goto L_0x00cc
            if (r6 == r12) goto L_0x00cf
            goto L_0x00d2
        L_0x00c1:
            r6 = 7
            r1.set(r6, r3)
            goto L_0x00cc
        L_0x00c6:
            r1.set(r11, r5)
        L_0x00c9:
            r1.set(r12, r3)
        L_0x00cc:
            r1.set(r7, r5)
        L_0x00cf:
            r1.set(r8, r5)
        L_0x00d2:
            java.util.Date r1 = r1.getTime()
            r15.mo56668a((java.util.Date) r1)
        L_0x00d9:
            int r1 = r15.getPeriodShowCount()
            if (r1 <= r4) goto L_0x00ea
            if (r2 <= r4) goto L_0x00ea
            int r1 = r15.getPeriodShowCount()
            if (r1 <= r2) goto L_0x00ea
            r15.mo56671c(r5)
        L_0x00ea:
            com.salesforce.marketingcloud.d.i r1 = r16.mo56537i()
            com.salesforce.marketingcloud.e.a r2 = r16.mo56524a()
            r1.mo56490a((com.salesforce.marketingcloud.messages.Message) r15, (com.salesforce.marketingcloud.p027e.C4022a) r2)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.salesforce.marketingcloud.messages.C4079e.m3045b(com.salesforce.marketingcloud.messages.Message, com.salesforce.marketingcloud.d.h):void");
    }
}

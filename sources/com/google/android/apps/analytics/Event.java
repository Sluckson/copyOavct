package com.google.android.apps.analytics;

import org.codehaus.jackson.util.MinimalPrettyPrinter;

class Event {
    static final String INSTALL_EVENT_CATEGORY = "__##GOOGLEINSTALL##__";
    static final String ITEM_CATEGORY = "__##GOOGLEITEM##__";
    static final String PAGEVIEW_EVENT_CATEGORY = "__##GOOGLEPAGEVIEW##__";
    static final String TRANSACTION_CATEGORY = "__##GOOGLETRANSACTION##__";
    final String accountId;
    final String action;
    private int adHitId;
    private boolean anonymizeIp;
    final String category;
    CustomVariableBuffer customVariableBuffer;
    final long eventId;
    private Item item;
    final String label;
    private int randomVal;
    final int screenHeight;
    final int screenWidth;
    private int timestampCurrent;
    private int timestampFirst;
    private int timestampPrevious;
    private Transaction transaction;
    private boolean useServerTime;
    private int userId;
    final int value;
    private int visits;

    Event(long j, String str, int i, int i2, int i3, int i4, int i5, String str2, String str3, String str4, int i6, int i7, int i8) {
        this.eventId = j;
        this.accountId = str;
        this.randomVal = i;
        this.timestampFirst = i2;
        this.timestampPrevious = i3;
        this.timestampCurrent = i4;
        this.visits = i5;
        this.category = str2;
        this.action = str3;
        this.label = str4;
        this.value = i6;
        this.screenHeight = i8;
        this.screenWidth = i7;
        this.userId = -1;
        this.useServerTime = false;
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    Event(com.google.android.apps.analytics.Event r18, java.lang.String r19) {
        /*
            r17 = this;
            r15 = r17
            r14 = r18
            long r1 = r14.eventId
            int r4 = r14.randomVal
            int r5 = r14.timestampFirst
            int r6 = r14.timestampPrevious
            int r7 = r14.timestampCurrent
            int r8 = r14.visits
            java.lang.String r9 = r14.category
            java.lang.String r10 = r14.action
            java.lang.String r11 = r14.label
            int r12 = r14.value
            int r13 = r14.screenWidth
            int r3 = r14.screenHeight
            r0 = r17
            r16 = r3
            r3 = r19
            r15 = r14
            r14 = r16
            r0.<init>(r1, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14)
            int r0 = r15.adHitId
            r1 = r17
            r2 = r15
            r1.adHitId = r0
            int r0 = r2.userId
            r1.userId = r0
            boolean r0 = r2.anonymizeIp
            r1.anonymizeIp = r0
            boolean r0 = r2.useServerTime
            r1.useServerTime = r0
            com.google.android.apps.analytics.CustomVariableBuffer r0 = r2.customVariableBuffer
            r1.customVariableBuffer = r0
            com.google.android.apps.analytics.Transaction r0 = r2.transaction
            r1.transaction = r0
            com.google.android.apps.analytics.Item r0 = r2.item
            r1.item = r0
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.apps.analytics.Event.<init>(com.google.android.apps.analytics.Event, java.lang.String):void");
    }

    Event(String str, String str2, String str3, String str4, int i, int i2, int i3) {
        this(-1, str, -1, -1, -1, -1, -1, str2, str3, str4, i, i2, i3);
    }

    /* access modifiers changed from: package-private */
    public int getAdHitId() {
        return this.adHitId;
    }

    /* access modifiers changed from: package-private */
    public boolean getAnonymizeIp() {
        return this.anonymizeIp;
    }

    public CustomVariableBuffer getCustomVariableBuffer() {
        return this.customVariableBuffer;
    }

    public Item getItem() {
        return this.item;
    }

    /* access modifiers changed from: package-private */
    public int getRandomVal() {
        return this.randomVal;
    }

    /* access modifiers changed from: package-private */
    public int getTimestampCurrent() {
        return this.timestampCurrent;
    }

    /* access modifiers changed from: package-private */
    public int getTimestampFirst() {
        return this.timestampFirst;
    }

    /* access modifiers changed from: package-private */
    public int getTimestampPrevious() {
        return this.timestampPrevious;
    }

    public Transaction getTransaction() {
        return this.transaction;
    }

    /* access modifiers changed from: package-private */
    public boolean getUseServerTime() {
        return this.useServerTime;
    }

    /* access modifiers changed from: package-private */
    public int getUserId() {
        return this.userId;
    }

    /* access modifiers changed from: package-private */
    public int getVisits() {
        return this.visits;
    }

    public boolean isSessionInitialized() {
        return this.timestampFirst != -1;
    }

    /* access modifiers changed from: package-private */
    public void setAdHitId(int i) {
        this.adHitId = i;
    }

    /* access modifiers changed from: package-private */
    public void setAnonymizeIp(boolean z) {
        this.anonymizeIp = z;
    }

    public void setCustomVariableBuffer(CustomVariableBuffer customVariableBuffer2) {
        this.customVariableBuffer = customVariableBuffer2;
    }

    public void setItem(Item item2) {
        if (this.category.equals(ITEM_CATEGORY)) {
            this.item = item2;
            return;
        }
        throw new IllegalStateException("Attempted to add an item to an event of type " + this.category);
    }

    /* access modifiers changed from: package-private */
    public void setRandomVal(int i) {
        this.randomVal = i;
    }

    /* access modifiers changed from: package-private */
    public void setTimestampCurrent(int i) {
        this.timestampCurrent = i;
    }

    /* access modifiers changed from: package-private */
    public void setTimestampFirst(int i) {
        this.timestampFirst = i;
    }

    /* access modifiers changed from: package-private */
    public void setTimestampPrevious(int i) {
        this.timestampPrevious = i;
    }

    public void setTransaction(Transaction transaction2) {
        if (this.category.equals(TRANSACTION_CATEGORY)) {
            this.transaction = transaction2;
            return;
        }
        throw new IllegalStateException("Attempted to add a transction to an event of type " + this.category);
    }

    /* access modifiers changed from: package-private */
    public void setUseServerTime(boolean z) {
        this.useServerTime = z;
    }

    /* access modifiers changed from: package-private */
    public void setUserId(int i) {
        this.userId = i;
    }

    /* access modifiers changed from: package-private */
    public void setVisits(int i) {
        this.visits = i;
    }

    public String toString() {
        return "id:" + this.eventId + MinimalPrettyPrinter.DEFAULT_ROOT_VALUE_SEPARATOR + "random:" + this.randomVal + MinimalPrettyPrinter.DEFAULT_ROOT_VALUE_SEPARATOR + "timestampCurrent:" + this.timestampCurrent + MinimalPrettyPrinter.DEFAULT_ROOT_VALUE_SEPARATOR + "timestampPrevious:" + this.timestampPrevious + MinimalPrettyPrinter.DEFAULT_ROOT_VALUE_SEPARATOR + "timestampFirst:" + this.timestampFirst + MinimalPrettyPrinter.DEFAULT_ROOT_VALUE_SEPARATOR + "visits:" + this.visits + MinimalPrettyPrinter.DEFAULT_ROOT_VALUE_SEPARATOR + "value:" + this.value + MinimalPrettyPrinter.DEFAULT_ROOT_VALUE_SEPARATOR + "category:" + this.category + MinimalPrettyPrinter.DEFAULT_ROOT_VALUE_SEPARATOR + "action:" + this.action + MinimalPrettyPrinter.DEFAULT_ROOT_VALUE_SEPARATOR + "label:" + this.label + MinimalPrettyPrinter.DEFAULT_ROOT_VALUE_SEPARATOR + "width:" + this.screenWidth + MinimalPrettyPrinter.DEFAULT_ROOT_VALUE_SEPARATOR + "height:" + this.screenHeight;
    }
}

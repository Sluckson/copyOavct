package com.medallia.digital.mobilesdk;

import java.util.ArrayList;

class FeedbackPayload {
    private ArrayList<Component> components = new ArrayList<>();
    private String uuid;

    FeedbackPayload() {
    }

    /* access modifiers changed from: protected */
    public ArrayList<Component> getComponents() {
        return this.components;
    }

    /* access modifiers changed from: protected */
    public String getUuid() {
        return this.uuid;
    }

    /* access modifiers changed from: protected */
    public void setComponents(ArrayList<Component> arrayList) {
        this.components = arrayList;
    }

    /* access modifiers changed from: protected */
    public void setUuid(String str) {
        this.uuid = str;
    }
}

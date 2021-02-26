package com.google.firebase.inappmessaging.model;

import androidx.annotation.NonNull;

public class CampaignMetadata {
    private final String campaignId;
    private final String campaignName;
    private final boolean isTestMessage;

    public CampaignMetadata(String str, String str2, boolean z) {
        this.campaignId = str;
        this.campaignName = str2;
        this.isTestMessage = z;
    }

    @NonNull
    public String getCampaignId() {
        return this.campaignId;
    }

    @NonNull
    public String getCampaignName() {
        return this.campaignName;
    }

    public boolean getIsTestMessage() {
        return this.isTestMessage;
    }
}

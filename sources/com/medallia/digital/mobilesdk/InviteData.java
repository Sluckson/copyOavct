package com.medallia.digital.mobilesdk;

import java.io.Serializable;
import org.json.JSONObject;

class InviteData implements Serializable {
    private static final int HASH_CODE_MULT = 31;
    private BannerData bannerData;
    private String declineButtonText;
    private String doSkipInvitation;
    private String invitationHeadline;
    private String invitationText;
    private String laterButtonText;
    private String mobileInvitationType;
    private String provideButtonText;

    /* renamed from: com.medallia.digital.mobilesdk.InviteData$a */
    enum C3415a {
        ALERT,
        BANNER,
        PUSH_NOTIFICATION;

        /* renamed from: a */
        static C3415a m402a(String str) {
            if (str != null) {
                if (str.equals(BANNER.toString())) {
                    return BANNER;
                }
                if (str.equals(PUSH_NOTIFICATION.toString())) {
                    return PUSH_NOTIFICATION;
                }
            }
            return ALERT;
        }
    }

    protected InviteData() {
    }

    protected InviteData(String str, String str2, String str3, String str4, String str5, String str6, String str7, BannerData bannerData2) {
        this.invitationHeadline = str;
        this.invitationText = str2;
        this.provideButtonText = str3;
        this.laterButtonText = str4;
        this.declineButtonText = str5;
        this.doSkipInvitation = str6;
        this.mobileInvitationType = str7;
        this.bannerData = bannerData2;
    }

    InviteData(JSONObject jSONObject) {
        try {
            if (jSONObject.has("invitationHeadline") && !jSONObject.isNull("invitationHeadline")) {
                this.invitationHeadline = jSONObject.getString("invitationHeadline");
            }
            if (jSONObject.has("invitationText") && !jSONObject.isNull("invitationText")) {
                this.invitationText = jSONObject.getString("invitationText");
            }
            if (jSONObject.has("provideButtonText") && !jSONObject.isNull("provideButtonText")) {
                this.provideButtonText = jSONObject.getString("provideButtonText");
            }
            if (jSONObject.has("laterButtonText") && !jSONObject.isNull("laterButtonText")) {
                this.laterButtonText = jSONObject.getString("laterButtonText");
            }
            if (jSONObject.has("declineButtonText") && !jSONObject.isNull("declineButtonText")) {
                this.declineButtonText = jSONObject.getString("declineButtonText");
            }
            if (jSONObject.has("doSkipInvitation") && !jSONObject.isNull("doSkipInvitation")) {
                this.doSkipInvitation = jSONObject.getString("doSkipInvitation");
            }
            if (jSONObject.has("mobileInvitationType") && !jSONObject.isNull("mobileInvitationType")) {
                this.mobileInvitationType = jSONObject.getString("mobileInvitationType");
            }
            if (jSONObject.has("customBanner") && !jSONObject.isNull("customBanner")) {
                this.bannerData = new BannerData(jSONObject.getJSONObject("customBanner"));
            }
        } catch (Exception e) {
            C3490e3.m663c(e.getMessage());
        }
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || InviteData.class != obj.getClass()) {
            return false;
        }
        InviteData inviteData = (InviteData) obj;
        String str = this.invitationHeadline;
        if (str == null ? inviteData.invitationHeadline != null : !str.equals(inviteData.invitationHeadline)) {
            return false;
        }
        String str2 = this.invitationText;
        if (str2 == null ? inviteData.invitationText != null : !str2.equals(inviteData.invitationText)) {
            return false;
        }
        String str3 = this.provideButtonText;
        if (str3 == null ? inviteData.provideButtonText != null : !str3.equals(inviteData.provideButtonText)) {
            return false;
        }
        String str4 = this.laterButtonText;
        if (str4 == null ? inviteData.laterButtonText != null : !str4.equals(inviteData.laterButtonText)) {
            return false;
        }
        String str5 = this.declineButtonText;
        if (str5 == null ? inviteData.declineButtonText != null : !str5.equals(inviteData.declineButtonText)) {
            return false;
        }
        String str6 = this.doSkipInvitation;
        if (str6 == null ? inviteData.doSkipInvitation != null : !str6.equals(inviteData.doSkipInvitation)) {
            return false;
        }
        String str7 = this.mobileInvitationType;
        if (str7 == null ? inviteData.mobileInvitationType != null : !str7.equals(inviteData.mobileInvitationType)) {
            return false;
        }
        BannerData bannerData2 = this.bannerData;
        return bannerData2 != null ? bannerData2.equals(inviteData.bannerData) : inviteData.bannerData == null;
    }

    /* access modifiers changed from: protected */
    public BannerData getBannerData() {
        return this.bannerData;
    }

    /* access modifiers changed from: protected */
    public String getDeclineButtonText() {
        return this.declineButtonText;
    }

    /* access modifiers changed from: protected */
    public String getDoSkipInvitation() {
        return this.doSkipInvitation;
    }

    /* access modifiers changed from: protected */
    public String getInvitationHeadline() {
        return this.invitationHeadline;
    }

    /* access modifiers changed from: protected */
    public String getInvitationText() {
        return this.invitationText;
    }

    /* access modifiers changed from: protected */
    public String getLaterButtonText() {
        return this.laterButtonText;
    }

    /* access modifiers changed from: protected */
    public String getProvideButtonText() {
        return this.provideButtonText;
    }

    /* access modifiers changed from: protected */
    public C3415a getType() {
        return C3415a.m402a(this.mobileInvitationType);
    }

    public int hashCode() {
        String str = this.invitationHeadline;
        int i = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.invitationText;
        int hashCode2 = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        String str3 = this.provideButtonText;
        int hashCode3 = (hashCode2 + (str3 != null ? str3.hashCode() : 0)) * 31;
        String str4 = this.laterButtonText;
        int hashCode4 = (hashCode3 + (str4 != null ? str4.hashCode() : 0)) * 31;
        String str5 = this.declineButtonText;
        int hashCode5 = (hashCode4 + (str5 != null ? str5.hashCode() : 0)) * 31;
        String str6 = this.doSkipInvitation;
        int hashCode6 = (hashCode5 + (str6 != null ? str6.hashCode() : 0)) * 31;
        String str7 = this.mobileInvitationType;
        int hashCode7 = (hashCode6 + (str7 != null ? str7.hashCode() : 0)) * 31;
        BannerData bannerData2 = this.bannerData;
        if (bannerData2 != null) {
            i = bannerData2.hashCode();
        }
        return hashCode7 + i;
    }

    /* access modifiers changed from: protected */
    public String toJsonString() {
        try {
            StringBuilder sb = new StringBuilder();
            sb.append("{\"invitationHeadline\":");
            sb.append(C3770w2.m1831c(this.invitationHeadline));
            sb.append(",\"invitationText\":");
            sb.append(C3770w2.m1831c(this.invitationText));
            sb.append(",\"provideButtonText\":");
            sb.append(C3770w2.m1830b(this.provideButtonText));
            sb.append(",\"laterButtonText\":");
            sb.append(C3770w2.m1830b(this.laterButtonText));
            sb.append(",\"declineButtonText\":");
            sb.append(C3770w2.m1830b(this.declineButtonText));
            sb.append(",\"doSkipInvitation\":");
            sb.append(C3770w2.m1830b(this.doSkipInvitation));
            sb.append(",\"mobileInvitationType\":");
            sb.append(C3770w2.m1830b(this.mobileInvitationType));
            sb.append(",\"customBanner\":");
            sb.append(this.bannerData == null ? null : this.bannerData.toJsonString());
            sb.append("}");
            return sb.toString();
        } catch (Exception e) {
            C3490e3.m663c(e.getMessage());
            return "";
        }
    }
}

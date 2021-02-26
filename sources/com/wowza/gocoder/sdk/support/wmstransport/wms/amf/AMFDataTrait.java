package com.wowza.gocoder.sdk.support.wmstransport.wms.amf;

import java.util.ArrayList;
import java.util.List;

/* compiled from: GoCoderSDK */
public class AMFDataTrait {
    public static final String TAG = "AMFDataTrait";
    private String className = "";
    private AMFData innerObj = null;
    private boolean isDynamic = false;
    private List<String> members = new ArrayList();

    public AMFDataTrait clone() {
        AMFDataTrait aMFDataTrait = new AMFDataTrait();
        aMFDataTrait.members = new ArrayList();
        aMFDataTrait.members.addAll(this.members);
        aMFDataTrait.className = this.className;
        aMFDataTrait.isDynamic = this.isDynamic;
        aMFDataTrait.innerObj = this.innerObj;
        return aMFDataTrait;
    }

    public void addMember(String str) {
        this.members.add(str);
    }

    public boolean isMember(String str) {
        return this.members.contains(str);
    }

    public List<String> getMembers() {
        return new ArrayList(this.members);
    }

    public int getMemberCount() {
        return this.members.size();
    }

    public String getMember(int i) {
        if (i < this.members.size()) {
            return this.members.get(i);
        }
        return null;
    }

    public String getClassName() {
        return this.className;
    }

    public void setClassName(String str) {
        this.className = str;
    }

    public boolean isDynamic() {
        return this.isDynamic;
    }

    public void setDynamic(boolean z) {
        this.isDynamic = z;
    }

    public AMFData getInnerObj() {
        return this.innerObj;
    }

    public void setInnerObj(AMFData aMFData) {
        this.innerObj = aMFData;
    }
}

package com.wowza.gocoder.sdk.support.wmstransport.wms.amf;

import java.io.DataOutputStream;
import java.util.HashMap;
import java.util.Map;

/* compiled from: GoCoderSDK */
public class AMFDataContextSerialize {
    public static final String TAG = "AMFDataContextSerialize";
    private int objectEncoding = 0;
    private Map<Object, Integer> refObjects;
    private int refObjectsIndex = 0;
    private Map<String, Integer> refStrings;
    private int refStringsIndex = 0;
    private Map<AMFDataTrait, Integer> refTraits;
    private int refTraitsIndex = 0;
    private int targetEncoding = 0;

    public AMFDataContextSerialize() {
    }

    public AMFDataContextSerialize(int i) {
        this.objectEncoding = i;
    }

    public int getObjectEncoding() {
        return this.objectEncoding;
    }

    public void setObjectEncoding(int i) {
        this.objectEncoding = i;
    }

    public int getTargetEncoding() {
        return this.targetEncoding;
    }

    public void setTargetEncoding(int i) {
        this.targetEncoding = i;
    }

    public boolean isAMF3() {
        return this.objectEncoding != 0;
    }

    public boolean isAMF0() {
        return this.objectEncoding == 0;
    }

    public int getStringReference(String str) {
        if (this.refStrings == null) {
            this.refStrings = new HashMap();
        }
        Integer num = this.refStrings.get(str);
        if (num != null) {
            return num.intValue();
        }
        this.refStrings.put(str, new Integer(this.refStringsIndex));
        this.refStringsIndex++;
        return -1;
    }

    public int getObjectReference(Object obj) {
        if (this.refObjects == null) {
            this.refObjects = new HashMap();
        }
        Integer num = this.refObjects.get(obj);
        if (num != null) {
            return num.intValue();
        }
        this.refObjects.put(obj, new Integer(this.refObjectsIndex));
        this.refObjectsIndex++;
        return -1;
    }

    public int getTraitReference(AMFDataTrait aMFDataTrait) {
        if (this.refTraits == null) {
            this.refTraits = new HashMap();
        }
        Integer num = this.refTraits.get(aMFDataTrait);
        if (num != null) {
            return num.intValue();
        }
        this.refTraits.put(aMFDataTrait, new Integer(this.refTraitsIndex));
        this.refTraitsIndex++;
        return -1;
    }

    public void writeString(DataOutputStream dataOutputStream, String str) {
        try {
            if (str.length() > 0) {
                int stringReference = getStringReference(str);
                if (stringReference >= 0) {
                    AMF3Utils.serializeInt(dataOutputStream, stringReference << 1);
                } else {
                    AMF3Utils.serializeString(dataOutputStream, str);
                }
            } else {
                AMF3Utils.serializeZeroLengthString(dataOutputStream);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

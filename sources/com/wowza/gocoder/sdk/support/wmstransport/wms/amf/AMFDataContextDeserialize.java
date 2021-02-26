package com.wowza.gocoder.sdk.support.wmstransport.wms.amf;

import java.util.ArrayList;
import java.util.List;

/* compiled from: GoCoderSDK */
public class AMFDataContextDeserialize {
    public static final String TAG = "AMFDataContextDeserialize";
    private int intData = 0;
    private boolean isIntData = false;
    private int objectEncoding = 0;
    private List<Object> refObjects;
    private List<String> refStrings;
    private List<AMFDataTrait> refTraits;

    public AMFDataContextDeserialize() {
    }

    public AMFDataContextDeserialize(int i) {
        this.objectEncoding = i;
    }

    public boolean isIntData() {
        return this.isIntData;
    }

    public void setIntData(int i) {
        this.intData = i;
        this.isIntData = true;
    }

    public int getIntData() {
        return this.intData;
    }

    public int clearIntData() {
        int i = this.intData;
        this.intData = 0;
        this.isIntData = false;
        return i;
    }

    public int getObjectEncoding() {
        return this.objectEncoding;
    }

    public void setObjectEncoding(int i) {
        this.objectEncoding = i;
    }

    public boolean isAMF3() {
        return this.objectEncoding != 0;
    }

    public boolean isAMF0() {
        return this.objectEncoding == 0;
    }

    public void addString(String str) {
        if (this.refStrings == null) {
            this.refStrings = new ArrayList();
        }
        this.refStrings.add(str);
    }

    public String getString(int i) throws IndexOutOfBoundsException {
        if (this.refStrings == null) {
            this.refStrings = new ArrayList();
        }
        return this.refStrings.get(i);
    }

    public void addObject(Object obj) {
        if (this.refObjects == null) {
            this.refObjects = new ArrayList();
        }
        this.refObjects.add(obj);
    }

    public Object getObject(int i) throws IndexOutOfBoundsException {
        if (this.refObjects == null) {
            this.refObjects = new ArrayList();
        }
        return this.refObjects.get(i);
    }

    public void addTrait(AMFDataTrait aMFDataTrait) {
        if (this.refTraits == null) {
            this.refTraits = new ArrayList();
        }
        this.refTraits.add(aMFDataTrait);
    }

    public AMFDataTrait getTrait(int i) throws IndexOutOfBoundsException {
        if (this.refTraits == null) {
            this.refTraits = new ArrayList();
        }
        return this.refTraits.get(i);
    }
}

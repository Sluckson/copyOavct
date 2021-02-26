package com.wowza.gocoder.sdk.support.wmstransport.wms.amf;

import java.util.ArrayList;
import java.util.List;

/* compiled from: GoCoderSDK */
public class AMFObj {
    public static final boolean AMFDEBUGHEADERSIZE = false;
    public static final String TAG = "AMFObj";
    public static final boolean WOWZDEBUGHEADERSIZE = false;
    private long absTimecode = 0;
    private int byteContainerLevel = 0;
    private long chunkCounter = -1;
    private List<AMFObjChunk> chunks = new ArrayList();

    /* renamed from: id */
    private int f4613id;
    private boolean isLastSentAbsTimecode = false;
    private boolean isLongTimecode = false;
    private boolean isNew = true;
    private int objectEncoding = 0;
    private int size = 0;
    private int src = 0;
    private long timecode = 0;
    private int type = 20;

    public AMFObj(int i) {
        this.f4613id = i;
        this.size = 0;
        this.src = 0;
        this.type = 20;
        this.isNew = true;
    }

    public AMFObj(int i, int i2) {
        this.f4613id = i;
        this.size = 0;
        this.src = 0;
        this.type = 20;
        this.objectEncoding = i2;
        this.isNew = true;
    }

    public List<AMFObjChunk> getChunks() {
        ArrayList arrayList = new ArrayList();
        arrayList.addAll(this.chunks);
        return arrayList;
    }

    public void addChunk(byte[] bArr, int i, int i2) {
        this.chunks.add(new AMFObjChunk(bArr, i, i2));
    }

    public int getId() {
        return this.f4613id;
    }

    public void setId(int i) {
        this.f4613id = i;
    }

    public int getSize() {
        return this.size;
    }

    public void setSize(int i) {
        this.size = i;
    }

    public int getType() {
        return this.type;
    }

    public void setType(int i) {
        this.type = i;
    }

    public int getSrc() {
        return this.src;
    }

    public void setSrc(int i) {
        this.src = i;
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("**** amfObj:" + this.f4613id + " ****\n");
        stringBuffer.append("size = " + this.size + "\n");
        stringBuffer.append("type = " + this.type + "\n");
        stringBuffer.append("src = " + this.src + "\n");
        stringBuffer.append("timecode = " + this.timecode + "\n");
        return stringBuffer.toString();
    }

    public long getTimecode() {
        return this.timecode;
    }

    public void setTimecode(long j) {
        this.timecode = j;
    }

    public boolean isNew() {
        return this.isNew;
    }

    public void setNew(boolean z) {
        this.isNew = z;
    }

    public long getAbsTimecode() {
        return this.absTimecode;
    }

    public long setAbsTimecodeLong(long j) {
        this.absTimecode = j;
        return this.absTimecode;
    }

    public long setAbsTimecodeShort(long j) {
        this.absTimecode = (j & 16777215) | (this.absTimecode & -16777216);
        return this.absTimecode;
    }

    public long incAbsTimecode(long j) {
        this.absTimecode += j;
        return this.absTimecode;
    }

    public int getByteContainerLevel() {
        return this.byteContainerLevel;
    }

    public void clearByteContainer() {
        this.chunks.clear();
        this.byteContainerLevel = 0;
    }

    public void setByteContainerLevel(int i) {
        this.byteContainerLevel = i;
    }

    public void incByteContainerLevel(int i) {
        this.byteContainerLevel += i;
    }

    public boolean isByteContainerEmpty() {
        return this.byteContainerLevel == 0;
    }

    public boolean isByteContainerFull() {
        return this.byteContainerLevel == this.size;
    }

    public boolean isLongTimecode() {
        return this.isLongTimecode;
    }

    public void setLongTimecode(boolean z) {
        this.isLongTimecode = z;
    }

    public boolean isLastSentAbsTimecode() {
        return this.isLastSentAbsTimecode;
    }

    public void setLastSentAbsTimecode(boolean z) {
        this.isLastSentAbsTimecode = z;
    }

    public boolean isObjectEncodingAMF3() {
        return this.objectEncoding != 0;
    }

    public boolean isObjectEncodingAMF0() {
        return this.objectEncoding == 0;
    }

    public void setObjectEncoding(int i) {
        this.objectEncoding = i;
    }

    public int getObjectEncoding() {
        return this.objectEncoding;
    }

    public long getChunkCounter() {
        return this.chunkCounter;
    }

    public void setChunkCounter(long j) {
        this.chunkCounter = j;
    }
}

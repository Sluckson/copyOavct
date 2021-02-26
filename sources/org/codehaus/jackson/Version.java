package org.codehaus.jackson;

public class Version implements Comparable<Version> {
    private static final Version UNKNOWN_VERSION = new Version(0, 0, 0, (String) null);
    protected final int _majorVersion;
    protected final int _minorVersion;
    protected final int _patchLevel;
    protected final String _snapshotInfo;

    public Version(int i, int i2, int i3, String str) {
        this._majorVersion = i;
        this._minorVersion = i2;
        this._patchLevel = i3;
        this._snapshotInfo = str;
    }

    public static Version unknownVersion() {
        return UNKNOWN_VERSION;
    }

    public boolean isUknownVersion() {
        return this == UNKNOWN_VERSION;
    }

    public boolean isSnapshot() {
        String str = this._snapshotInfo;
        return str != null && str.length() > 0;
    }

    public int getMajorVersion() {
        return this._majorVersion;
    }

    public int getMinorVersion() {
        return this._minorVersion;
    }

    public int getPatchLevel() {
        return this._patchLevel;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(this._majorVersion);
        sb.append('.');
        sb.append(this._minorVersion);
        sb.append('.');
        sb.append(this._patchLevel);
        if (isSnapshot()) {
            sb.append('-');
            sb.append(this._snapshotInfo);
        }
        return sb.toString();
    }

    public int hashCode() {
        return this._majorVersion + this._minorVersion + this._patchLevel;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj == null || obj.getClass() != getClass()) {
            return false;
        }
        Version version = (Version) obj;
        if (version._majorVersion == this._majorVersion && version._minorVersion == this._minorVersion && version._patchLevel == this._patchLevel) {
            return true;
        }
        return false;
    }

    public int compareTo(Version version) {
        int i = this._majorVersion - version._majorVersion;
        if (i != 0) {
            return i;
        }
        int i2 = this._minorVersion - version._minorVersion;
        return i2 == 0 ? this._patchLevel - version._patchLevel : i2;
    }
}

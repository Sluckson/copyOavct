package com.google.android.exoplayer2.upstream.cache;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.util.SparseArray;
import android.util.SparseBooleanArray;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import com.google.android.exoplayer2.database.DatabaseIOException;
import com.google.android.exoplayer2.database.DatabaseProvider;
import com.google.android.exoplayer2.database.VersionTable;
import com.google.android.exoplayer2.upstream.cache.ContentMetadata;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.AtomicFile;
import com.google.android.exoplayer2.util.ReusableBufferedOutputStream;
import com.google.android.exoplayer2.util.Util;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.Set;
import javax.crypto.Cipher;
import javax.crypto.CipherOutputStream;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import org.codehaus.jackson.util.MinimalPrettyPrinter;

class CachedContentIndex {
    static final String FILE_NAME_ATOMIC = "cached_content_index.exi";
    private static final int INCREMENTAL_METADATA_READ_LENGTH = 10485760;
    private final SparseArray<String> idToKey;
    private final HashMap<String, CachedContent> keyToContent;
    private final SparseBooleanArray newIds;
    @Nullable
    private Storage previousStorage;
    private final SparseBooleanArray removedIds;
    private Storage storage;

    private interface Storage {
        void delete() throws IOException;

        boolean exists() throws IOException;

        void initialize(long j);

        void load(HashMap<String, CachedContent> hashMap, SparseArray<String> sparseArray) throws IOException;

        void onRemove(CachedContent cachedContent, boolean z);

        void onUpdate(CachedContent cachedContent);

        void storeFully(HashMap<String, CachedContent> hashMap) throws IOException;

        void storeIncremental(HashMap<String, CachedContent> hashMap) throws IOException;
    }

    public static final boolean isIndexFile(String str) {
        return str.startsWith(FILE_NAME_ATOMIC);
    }

    public static void delete(DatabaseProvider databaseProvider, long j) throws DatabaseIOException {
        DatabaseStorage.delete(databaseProvider, j);
    }

    public CachedContentIndex(DatabaseProvider databaseProvider) {
        this(databaseProvider, (File) null, (byte[]) null, false, false);
    }

    public CachedContentIndex(@Nullable DatabaseProvider databaseProvider, @Nullable File file, @Nullable byte[] bArr, boolean z, boolean z2) {
        Assertions.checkState((databaseProvider == null && file == null) ? false : true);
        this.keyToContent = new HashMap<>();
        this.idToKey = new SparseArray<>();
        this.removedIds = new SparseBooleanArray();
        this.newIds = new SparseBooleanArray();
        LegacyStorage legacyStorage = null;
        DatabaseStorage databaseStorage = databaseProvider != null ? new DatabaseStorage(databaseProvider) : null;
        legacyStorage = file != null ? new LegacyStorage(new File(file, FILE_NAME_ATOMIC), bArr, z) : legacyStorage;
        if (databaseStorage == null || (legacyStorage != null && z2)) {
            this.storage = legacyStorage;
            this.previousStorage = databaseStorage;
            return;
        }
        this.storage = databaseStorage;
        this.previousStorage = legacyStorage;
    }

    public void initialize(long j) throws IOException {
        Storage storage2;
        this.storage.initialize(j);
        Storage storage3 = this.previousStorage;
        if (storage3 != null) {
            storage3.initialize(j);
        }
        if (this.storage.exists() || (storage2 = this.previousStorage) == null || !storage2.exists()) {
            this.storage.load(this.keyToContent, this.idToKey);
        } else {
            this.previousStorage.load(this.keyToContent, this.idToKey);
            this.storage.storeFully(this.keyToContent);
        }
        Storage storage4 = this.previousStorage;
        if (storage4 != null) {
            storage4.delete();
            this.previousStorage = null;
        }
    }

    public void store() throws IOException {
        this.storage.storeIncremental(this.keyToContent);
        int size = this.removedIds.size();
        for (int i = 0; i < size; i++) {
            this.idToKey.remove(this.removedIds.keyAt(i));
        }
        this.removedIds.clear();
        this.newIds.clear();
    }

    public CachedContent getOrAdd(String str) {
        CachedContent cachedContent = this.keyToContent.get(str);
        return cachedContent == null ? addNew(str) : cachedContent;
    }

    public CachedContent get(String str) {
        return this.keyToContent.get(str);
    }

    public Collection<CachedContent> getAll() {
        return this.keyToContent.values();
    }

    public int assignIdForKey(String str) {
        return getOrAdd(str).f153id;
    }

    public String getKeyForId(int i) {
        return this.idToKey.get(i);
    }

    public void maybeRemove(String str) {
        CachedContent cachedContent = this.keyToContent.get(str);
        if (cachedContent != null && cachedContent.isEmpty() && !cachedContent.isLocked()) {
            this.keyToContent.remove(str);
            int i = cachedContent.f153id;
            boolean z = this.newIds.get(i);
            this.storage.onRemove(cachedContent, z);
            if (z) {
                this.idToKey.remove(i);
                this.newIds.delete(i);
                return;
            }
            this.idToKey.put(i, (Object) null);
            this.removedIds.put(i, true);
        }
    }

    public void removeEmpty() {
        String[] strArr = new String[this.keyToContent.size()];
        this.keyToContent.keySet().toArray(strArr);
        for (String maybeRemove : strArr) {
            maybeRemove(maybeRemove);
        }
    }

    public Set<String> getKeys() {
        return this.keyToContent.keySet();
    }

    public void applyContentMetadataMutations(String str, ContentMetadataMutations contentMetadataMutations) {
        CachedContent orAdd = getOrAdd(str);
        if (orAdd.applyMetadataMutations(contentMetadataMutations)) {
            this.storage.onUpdate(orAdd);
        }
    }

    public ContentMetadata getContentMetadata(String str) {
        CachedContent cachedContent = get(str);
        return cachedContent != null ? cachedContent.getMetadata() : DefaultContentMetadata.EMPTY;
    }

    private CachedContent addNew(String str) {
        int newId = getNewId(this.idToKey);
        CachedContent cachedContent = new CachedContent(newId, str);
        this.keyToContent.put(str, cachedContent);
        this.idToKey.put(newId, str);
        this.newIds.put(newId, true);
        this.storage.onUpdate(cachedContent);
        return cachedContent;
    }

    /* access modifiers changed from: private */
    @SuppressLint({"GetInstance"})
    public static Cipher getCipher() throws NoSuchPaddingException, NoSuchAlgorithmException {
        if (Util.SDK_INT == 18) {
            try {
                return Cipher.getInstance("AES/CBC/PKCS5PADDING", "BC");
            } catch (Throwable unused) {
            }
        }
        return Cipher.getInstance("AES/CBC/PKCS5PADDING");
    }

    @VisibleForTesting
    static int getNewId(SparseArray<String> sparseArray) {
        int i;
        int size = sparseArray.size();
        if (size == 0) {
            i = 0;
        } else {
            i = sparseArray.keyAt(size - 1) + 1;
        }
        if (i < 0) {
            int i2 = 0;
            while (i < size && i == sparseArray.keyAt(i)) {
                i2 = i + 1;
            }
        }
        return i;
    }

    /* access modifiers changed from: private */
    public static DefaultContentMetadata readContentMetadata(DataInputStream dataInputStream) throws IOException {
        int readInt = dataInputStream.readInt();
        HashMap hashMap = new HashMap();
        int i = 0;
        while (i < readInt) {
            String readUTF = dataInputStream.readUTF();
            int readInt2 = dataInputStream.readInt();
            if (readInt2 >= 0) {
                int min = Math.min(readInt2, INCREMENTAL_METADATA_READ_LENGTH);
                byte[] bArr = Util.EMPTY_BYTE_ARRAY;
                int i2 = min;
                int i3 = 0;
                while (i3 != readInt2) {
                    int i4 = i3 + i2;
                    bArr = Arrays.copyOf(bArr, i4);
                    dataInputStream.readFully(bArr, i3, i2);
                    i2 = Math.min(readInt2 - i4, INCREMENTAL_METADATA_READ_LENGTH);
                    i3 = i4;
                }
                hashMap.put(readUTF, bArr);
                i++;
            } else {
                throw new IOException("Invalid value size: " + readInt2);
            }
        }
        return new DefaultContentMetadata(hashMap);
    }

    /* access modifiers changed from: private */
    public static void writeContentMetadata(DefaultContentMetadata defaultContentMetadata, DataOutputStream dataOutputStream) throws IOException {
        Set<Map.Entry<String, byte[]>> entrySet = defaultContentMetadata.entrySet();
        dataOutputStream.writeInt(entrySet.size());
        for (Map.Entry next : entrySet) {
            dataOutputStream.writeUTF((String) next.getKey());
            byte[] bArr = (byte[]) next.getValue();
            dataOutputStream.writeInt(bArr.length);
            dataOutputStream.write(bArr);
        }
    }

    private static class LegacyStorage implements Storage {
        private static final int FLAG_ENCRYPTED_INDEX = 1;
        private static final int VERSION = 2;
        private static final int VERSION_METADATA_INTRODUCED = 2;
        private final AtomicFile atomicFile;
        @Nullable
        private ReusableBufferedOutputStream bufferedOutputStream;
        private boolean changed;
        @Nullable
        private final Cipher cipher;
        private final boolean encrypt;
        @Nullable
        private final Random random;
        @Nullable
        private final SecretKeySpec secretKeySpec;

        public void initialize(long j) {
        }

        public LegacyStorage(File file, @Nullable byte[] bArr, boolean z) {
            SecretKeySpec secretKeySpec2;
            Cipher cipher2;
            Random random2 = null;
            if (bArr != null) {
                Assertions.checkArgument(bArr.length == 16);
                try {
                    cipher2 = CachedContentIndex.getCipher();
                    secretKeySpec2 = new SecretKeySpec(bArr, "AES");
                } catch (NoSuchAlgorithmException | NoSuchPaddingException e) {
                    throw new IllegalStateException(e);
                }
            } else {
                Assertions.checkArgument(!z);
                cipher2 = null;
                secretKeySpec2 = null;
            }
            this.encrypt = z;
            this.cipher = cipher2;
            this.secretKeySpec = secretKeySpec2;
            this.random = z ? new Random() : random2;
            this.atomicFile = new AtomicFile(file);
        }

        public boolean exists() {
            return this.atomicFile.exists();
        }

        public void delete() {
            this.atomicFile.delete();
        }

        public void load(HashMap<String, CachedContent> hashMap, SparseArray<String> sparseArray) {
            Assertions.checkState(!this.changed);
            if (!readFile(hashMap, sparseArray)) {
                hashMap.clear();
                sparseArray.clear();
                this.atomicFile.delete();
            }
        }

        public void storeFully(HashMap<String, CachedContent> hashMap) throws IOException {
            writeFile(hashMap);
            this.changed = false;
        }

        public void storeIncremental(HashMap<String, CachedContent> hashMap) throws IOException {
            if (this.changed) {
                storeFully(hashMap);
            }
        }

        public void onUpdate(CachedContent cachedContent) {
            this.changed = true;
        }

        public void onRemove(CachedContent cachedContent, boolean z) {
            this.changed = true;
        }

        /* JADX WARNING: Removed duplicated region for block: B:54:0x00ad  */
        /* JADX WARNING: Removed duplicated region for block: B:59:0x00b4  */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        private boolean readFile(java.util.HashMap<java.lang.String, com.google.android.exoplayer2.upstream.cache.CachedContent> r11, android.util.SparseArray<java.lang.String> r12) {
            /*
                r10 = this;
                com.google.android.exoplayer2.util.AtomicFile r0 = r10.atomicFile
                boolean r0 = r0.exists()
                r1 = 1
                if (r0 != 0) goto L_0x000a
                return r1
            L_0x000a:
                r0 = 0
                r2 = 0
                java.io.BufferedInputStream r3 = new java.io.BufferedInputStream     // Catch:{ IOException -> 0x00b1, all -> 0x00a9 }
                com.google.android.exoplayer2.util.AtomicFile r4 = r10.atomicFile     // Catch:{ IOException -> 0x00b1, all -> 0x00a9 }
                java.io.InputStream r4 = r4.openRead()     // Catch:{ IOException -> 0x00b1, all -> 0x00a9 }
                r3.<init>(r4)     // Catch:{ IOException -> 0x00b1, all -> 0x00a9 }
                java.io.DataInputStream r4 = new java.io.DataInputStream     // Catch:{ IOException -> 0x00b1, all -> 0x00a9 }
                r4.<init>(r3)     // Catch:{ IOException -> 0x00b1, all -> 0x00a9 }
                int r0 = r4.readInt()     // Catch:{ IOException -> 0x00a7, all -> 0x00a5 }
                if (r0 < 0) goto L_0x00a1
                r5 = 2
                if (r0 <= r5) goto L_0x0027
                goto L_0x00a1
            L_0x0027:
                int r6 = r4.readInt()     // Catch:{ IOException -> 0x00a7, all -> 0x00a5 }
                r6 = r6 & r1
                if (r6 == 0) goto L_0x0060
                javax.crypto.Cipher r6 = r10.cipher     // Catch:{ IOException -> 0x00a7, all -> 0x00a5 }
                if (r6 != 0) goto L_0x0036
                com.google.android.exoplayer2.util.Util.closeQuietly((java.io.Closeable) r4)
                return r2
            L_0x0036:
                r6 = 16
                byte[] r6 = new byte[r6]     // Catch:{ IOException -> 0x00a7, all -> 0x00a5 }
                r4.readFully(r6)     // Catch:{ IOException -> 0x00a7, all -> 0x00a5 }
                javax.crypto.spec.IvParameterSpec r7 = new javax.crypto.spec.IvParameterSpec     // Catch:{ IOException -> 0x00a7, all -> 0x00a5 }
                r7.<init>(r6)     // Catch:{ IOException -> 0x00a7, all -> 0x00a5 }
                javax.crypto.Cipher r6 = r10.cipher     // Catch:{ InvalidKeyException -> 0x0059, InvalidAlgorithmParameterException -> 0x0057 }
                javax.crypto.spec.SecretKeySpec r8 = r10.secretKeySpec     // Catch:{ InvalidKeyException -> 0x0059, InvalidAlgorithmParameterException -> 0x0057 }
                r6.init(r5, r8, r7)     // Catch:{ InvalidKeyException -> 0x0059, InvalidAlgorithmParameterException -> 0x0057 }
                java.io.DataInputStream r5 = new java.io.DataInputStream     // Catch:{ IOException -> 0x00a7, all -> 0x00a5 }
                javax.crypto.CipherInputStream r6 = new javax.crypto.CipherInputStream     // Catch:{ IOException -> 0x00a7, all -> 0x00a5 }
                javax.crypto.Cipher r7 = r10.cipher     // Catch:{ IOException -> 0x00a7, all -> 0x00a5 }
                r6.<init>(r3, r7)     // Catch:{ IOException -> 0x00a7, all -> 0x00a5 }
                r5.<init>(r6)     // Catch:{ IOException -> 0x00a7, all -> 0x00a5 }
                r4 = r5
                goto L_0x0066
            L_0x0057:
                r11 = move-exception
                goto L_0x005a
            L_0x0059:
                r11 = move-exception
            L_0x005a:
                java.lang.IllegalStateException r12 = new java.lang.IllegalStateException     // Catch:{ IOException -> 0x00a7, all -> 0x00a5 }
                r12.<init>(r11)     // Catch:{ IOException -> 0x00a7, all -> 0x00a5 }
                throw r12     // Catch:{ IOException -> 0x00a7, all -> 0x00a5 }
            L_0x0060:
                boolean r3 = r10.encrypt     // Catch:{ IOException -> 0x00a7, all -> 0x00a5 }
                if (r3 == 0) goto L_0x0066
                r10.changed = r1     // Catch:{ IOException -> 0x00a7, all -> 0x00a5 }
            L_0x0066:
                int r3 = r4.readInt()     // Catch:{ IOException -> 0x00a7, all -> 0x00a5 }
                r5 = 0
                r6 = 0
            L_0x006c:
                if (r5 >= r3) goto L_0x0086
                com.google.android.exoplayer2.upstream.cache.CachedContent r7 = r10.readCachedContent(r0, r4)     // Catch:{ IOException -> 0x00a7, all -> 0x00a5 }
                java.lang.String r8 = r7.key     // Catch:{ IOException -> 0x00a7, all -> 0x00a5 }
                r11.put(r8, r7)     // Catch:{ IOException -> 0x00a7, all -> 0x00a5 }
                int r8 = r7.f153id     // Catch:{ IOException -> 0x00a7, all -> 0x00a5 }
                java.lang.String r9 = r7.key     // Catch:{ IOException -> 0x00a7, all -> 0x00a5 }
                r12.put(r8, r9)     // Catch:{ IOException -> 0x00a7, all -> 0x00a5 }
                int r7 = r10.hashCachedContent(r7, r0)     // Catch:{ IOException -> 0x00a7, all -> 0x00a5 }
                int r6 = r6 + r7
                int r5 = r5 + 1
                goto L_0x006c
            L_0x0086:
                int r11 = r4.readInt()     // Catch:{ IOException -> 0x00a7, all -> 0x00a5 }
                int r12 = r4.read()     // Catch:{ IOException -> 0x00a7, all -> 0x00a5 }
                r0 = -1
                if (r12 != r0) goto L_0x0093
                r12 = 1
                goto L_0x0094
            L_0x0093:
                r12 = 0
            L_0x0094:
                if (r11 != r6) goto L_0x009d
                if (r12 != 0) goto L_0x0099
                goto L_0x009d
            L_0x0099:
                com.google.android.exoplayer2.util.Util.closeQuietly((java.io.Closeable) r4)
                return r1
            L_0x009d:
                com.google.android.exoplayer2.util.Util.closeQuietly((java.io.Closeable) r4)
                return r2
            L_0x00a1:
                com.google.android.exoplayer2.util.Util.closeQuietly((java.io.Closeable) r4)
                return r2
            L_0x00a5:
                r11 = move-exception
                goto L_0x00ab
            L_0x00a7:
                goto L_0x00b2
            L_0x00a9:
                r11 = move-exception
                r4 = r0
            L_0x00ab:
                if (r4 == 0) goto L_0x00b0
                com.google.android.exoplayer2.util.Util.closeQuietly((java.io.Closeable) r4)
            L_0x00b0:
                throw r11
            L_0x00b1:
                r4 = r0
            L_0x00b2:
                if (r4 == 0) goto L_0x00b7
                com.google.android.exoplayer2.util.Util.closeQuietly((java.io.Closeable) r4)
            L_0x00b7:
                return r2
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.upstream.cache.CachedContentIndex.LegacyStorage.readFile(java.util.HashMap, android.util.SparseArray):boolean");
        }

        private void writeFile(HashMap<String, CachedContent> hashMap) throws IOException {
            DataOutputStream dataOutputStream;
            try {
                OutputStream startWrite = this.atomicFile.startWrite();
                if (this.bufferedOutputStream == null) {
                    this.bufferedOutputStream = new ReusableBufferedOutputStream(startWrite);
                } else {
                    this.bufferedOutputStream.reset(startWrite);
                }
                dataOutputStream = new DataOutputStream(this.bufferedOutputStream);
                try {
                    dataOutputStream.writeInt(2);
                    int i = 0;
                    dataOutputStream.writeInt(this.encrypt ? 1 : 0);
                    if (this.encrypt) {
                        byte[] bArr = new byte[16];
                        this.random.nextBytes(bArr);
                        dataOutputStream.write(bArr);
                        this.cipher.init(1, this.secretKeySpec, new IvParameterSpec(bArr));
                        dataOutputStream.flush();
                        dataOutputStream = new DataOutputStream(new CipherOutputStream(this.bufferedOutputStream, this.cipher));
                    }
                    dataOutputStream.writeInt(hashMap.size());
                    for (CachedContent next : hashMap.values()) {
                        writeCachedContent(next, dataOutputStream);
                        i += hashCachedContent(next, 2);
                    }
                    dataOutputStream.writeInt(i);
                    this.atomicFile.endWrite(dataOutputStream);
                    Util.closeQuietly((Closeable) null);
                } catch (InvalidKeyException e) {
                    e = e;
                    throw new IllegalStateException(e);
                } catch (InvalidAlgorithmParameterException e2) {
                    e = e2;
                    throw new IllegalStateException(e);
                } catch (Throwable th) {
                    th = th;
                    Util.closeQuietly((Closeable) dataOutputStream);
                    throw th;
                }
            } catch (Throwable th2) {
                th = th2;
                dataOutputStream = null;
                Util.closeQuietly((Closeable) dataOutputStream);
                throw th;
            }
        }

        private int hashCachedContent(CachedContent cachedContent, int i) {
            int hashCode = (cachedContent.f153id * 31) + cachedContent.key.hashCode();
            if (i >= 2) {
                return (hashCode * 31) + cachedContent.getMetadata().hashCode();
            }
            long contentLength = ContentMetadata.CC.getContentLength(cachedContent.getMetadata());
            return (hashCode * 31) + ((int) (contentLength ^ (contentLength >>> 32)));
        }

        private CachedContent readCachedContent(int i, DataInputStream dataInputStream) throws IOException {
            DefaultContentMetadata defaultContentMetadata;
            int readInt = dataInputStream.readInt();
            String readUTF = dataInputStream.readUTF();
            if (i < 2) {
                long readLong = dataInputStream.readLong();
                ContentMetadataMutations contentMetadataMutations = new ContentMetadataMutations();
                ContentMetadataMutations.setContentLength(contentMetadataMutations, readLong);
                defaultContentMetadata = DefaultContentMetadata.EMPTY.copyWithMutationsApplied(contentMetadataMutations);
            } else {
                defaultContentMetadata = CachedContentIndex.readContentMetadata(dataInputStream);
            }
            return new CachedContent(readInt, readUTF, defaultContentMetadata);
        }

        private void writeCachedContent(CachedContent cachedContent, DataOutputStream dataOutputStream) throws IOException {
            dataOutputStream.writeInt(cachedContent.f153id);
            dataOutputStream.writeUTF(cachedContent.key);
            CachedContentIndex.writeContentMetadata(cachedContent.getMetadata(), dataOutputStream);
        }
    }

    private static final class DatabaseStorage implements Storage {
        private static final String[] COLUMNS = {"id", COLUMN_KEY, "metadata"};
        private static final String COLUMN_ID = "id";
        private static final int COLUMN_INDEX_ID = 0;
        private static final int COLUMN_INDEX_KEY = 1;
        private static final int COLUMN_INDEX_METADATA = 2;
        private static final String COLUMN_KEY = "key";
        private static final String COLUMN_METADATA = "metadata";
        private static final String TABLE_PREFIX = "ExoPlayerCacheIndex";
        private static final String TABLE_SCHEMA = "(id INTEGER PRIMARY KEY NOT NULL,key TEXT NOT NULL,metadata BLOB NOT NULL)";
        private static final int TABLE_VERSION = 1;
        private static final String WHERE_ID_EQUALS = "id = ?";
        private final DatabaseProvider databaseProvider;
        private String hexUid;
        private final SparseArray<CachedContent> pendingUpdates = new SparseArray<>();
        private String tableName;

        public static void delete(DatabaseProvider databaseProvider2, long j) throws DatabaseIOException {
            delete(databaseProvider2, Long.toHexString(j));
        }

        public DatabaseStorage(DatabaseProvider databaseProvider2) {
            this.databaseProvider = databaseProvider2;
        }

        public void initialize(long j) {
            this.hexUid = Long.toHexString(j);
            this.tableName = getTableName(this.hexUid);
        }

        public boolean exists() throws DatabaseIOException {
            if (VersionTable.getVersion(this.databaseProvider.getReadableDatabase(), 1, this.hexUid) != -1) {
                return true;
            }
            return false;
        }

        public void delete() throws DatabaseIOException {
            delete(this.databaseProvider, this.hexUid);
        }

        public void load(HashMap<String, CachedContent> hashMap, SparseArray<String> sparseArray) throws IOException {
            Cursor cursor;
            Throwable th;
            SQLiteDatabase writableDatabase;
            Assertions.checkState(this.pendingUpdates.size() == 0);
            try {
                if (VersionTable.getVersion(this.databaseProvider.getReadableDatabase(), 1, this.hexUid) != 1) {
                    writableDatabase = this.databaseProvider.getWritableDatabase();
                    writableDatabase.beginTransaction();
                    initializeTable(writableDatabase);
                    writableDatabase.setTransactionSuccessful();
                    writableDatabase.endTransaction();
                }
                cursor = getCursor();
                while (cursor.moveToNext()) {
                    CachedContent cachedContent = new CachedContent(cursor.getInt(0), cursor.getString(1), CachedContentIndex.readContentMetadata(new DataInputStream(new ByteArrayInputStream(cursor.getBlob(2)))));
                    hashMap.put(cachedContent.key, cachedContent);
                    sparseArray.put(cachedContent.f153id, cachedContent.key);
                }
                if (cursor != null) {
                    cursor.close();
                    return;
                }
                return;
            } catch (SQLiteException e) {
                hashMap.clear();
                sparseArray.clear();
                throw new DatabaseIOException(e);
            } catch (Throwable th2) {
                writableDatabase.endTransaction();
                throw th2;
            }
            throw th;
        }

        public void storeFully(HashMap<String, CachedContent> hashMap) throws IOException {
            SQLiteDatabase writableDatabase;
            try {
                writableDatabase = this.databaseProvider.getWritableDatabase();
                writableDatabase.beginTransaction();
                initializeTable(writableDatabase);
                for (CachedContent addOrUpdateRow : hashMap.values()) {
                    addOrUpdateRow(writableDatabase, addOrUpdateRow);
                }
                writableDatabase.setTransactionSuccessful();
                this.pendingUpdates.clear();
                writableDatabase.endTransaction();
            } catch (SQLException e) {
                throw new DatabaseIOException(e);
            } catch (Throwable th) {
                writableDatabase.endTransaction();
                throw th;
            }
        }

        public void storeIncremental(HashMap<String, CachedContent> hashMap) throws IOException {
            SQLiteDatabase writableDatabase;
            if (this.pendingUpdates.size() != 0) {
                try {
                    writableDatabase = this.databaseProvider.getWritableDatabase();
                    writableDatabase.beginTransaction();
                    for (int i = 0; i < this.pendingUpdates.size(); i++) {
                        CachedContent valueAt = this.pendingUpdates.valueAt(i);
                        if (valueAt == null) {
                            deleteRow(writableDatabase, this.pendingUpdates.keyAt(i));
                        } else {
                            addOrUpdateRow(writableDatabase, valueAt);
                        }
                    }
                    writableDatabase.setTransactionSuccessful();
                    this.pendingUpdates.clear();
                    writableDatabase.endTransaction();
                } catch (SQLException e) {
                    throw new DatabaseIOException(e);
                } catch (Throwable th) {
                    writableDatabase.endTransaction();
                    throw th;
                }
            }
        }

        public void onUpdate(CachedContent cachedContent) {
            this.pendingUpdates.put(cachedContent.f153id, cachedContent);
        }

        public void onRemove(CachedContent cachedContent, boolean z) {
            if (z) {
                this.pendingUpdates.delete(cachedContent.f153id);
            } else {
                this.pendingUpdates.put(cachedContent.f153id, (Object) null);
            }
        }

        private Cursor getCursor() {
            return this.databaseProvider.getReadableDatabase().query(this.tableName, COLUMNS, (String) null, (String[]) null, (String) null, (String) null, (String) null);
        }

        private void initializeTable(SQLiteDatabase sQLiteDatabase) throws DatabaseIOException {
            VersionTable.setVersion(sQLiteDatabase, 1, this.hexUid, 1);
            dropTable(sQLiteDatabase, this.tableName);
            sQLiteDatabase.execSQL("CREATE TABLE " + this.tableName + MinimalPrettyPrinter.DEFAULT_ROOT_VALUE_SEPARATOR + TABLE_SCHEMA);
        }

        private void deleteRow(SQLiteDatabase sQLiteDatabase, int i) {
            sQLiteDatabase.delete(this.tableName, WHERE_ID_EQUALS, new String[]{Integer.toString(i)});
        }

        private void addOrUpdateRow(SQLiteDatabase sQLiteDatabase, CachedContent cachedContent) throws IOException {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            CachedContentIndex.writeContentMetadata(cachedContent.getMetadata(), new DataOutputStream(byteArrayOutputStream));
            byte[] byteArray = byteArrayOutputStream.toByteArray();
            ContentValues contentValues = new ContentValues();
            contentValues.put("id", Integer.valueOf(cachedContent.f153id));
            contentValues.put(COLUMN_KEY, cachedContent.key);
            contentValues.put("metadata", byteArray);
            sQLiteDatabase.replaceOrThrow(this.tableName, (String) null, contentValues);
        }

        private static void delete(DatabaseProvider databaseProvider2, String str) throws DatabaseIOException {
            SQLiteDatabase writableDatabase;
            try {
                String tableName2 = getTableName(str);
                writableDatabase = databaseProvider2.getWritableDatabase();
                writableDatabase.beginTransaction();
                VersionTable.removeVersion(writableDatabase, 1, str);
                dropTable(writableDatabase, tableName2);
                writableDatabase.setTransactionSuccessful();
                writableDatabase.endTransaction();
            } catch (SQLException e) {
                throw new DatabaseIOException(e);
            } catch (Throwable th) {
                writableDatabase.endTransaction();
                throw th;
            }
        }

        private static void dropTable(SQLiteDatabase sQLiteDatabase, String str) {
            sQLiteDatabase.execSQL("DROP TABLE IF EXISTS " + str);
        }

        private static String getTableName(String str) {
            return TABLE_PREFIX + str;
        }
    }
}

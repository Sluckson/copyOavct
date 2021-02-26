package com.google.firebase.installations.local;

import androidx.annotation.NonNull;
import com.google.firebase.FirebaseApp;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import org.json.JSONException;
import org.json.JSONObject;

public class PersistedInstallation {
    private static final String AUTH_TOKEN_KEY = "AuthToken";
    private static final String EXPIRES_IN_SECONDS_KEY = "ExpiresInSecs";
    private static final String FIREBASE_INSTALLATION_ID_KEY = "Fid";
    private static final String FIS_ERROR_KEY = "FisError";
    private static final String PERSISTED_STATUS_KEY = "Status";
    private static final String REFRESH_TOKEN_KEY = "RefreshToken";
    private static final String SETTINGS_FILE_NAME_PREFIX = "PersistedInstallation";
    private static final String TOKEN_CREATION_TIME_IN_SECONDS_KEY = "TokenCreationEpochInSecs";
    private final File dataFile;
    @NonNull
    private final FirebaseApp firebaseApp;

    public enum RegistrationStatus {
        ATTEMPT_MIGRATION,
        NOT_GENERATED,
        UNREGISTERED,
        REGISTERED,
        REGISTER_ERROR
    }

    public PersistedInstallation(@NonNull FirebaseApp firebaseApp2) {
        File filesDir = firebaseApp2.getApplicationContext().getFilesDir();
        this.dataFile = new File(filesDir, "PersistedInstallation." + firebaseApp2.getPersistenceKey() + ".json");
        this.firebaseApp = firebaseApp2;
    }

    @NonNull
    public PersistedInstallationEntry readPersistedInstallationEntryValue() {
        JSONObject readJSONFromFile = readJSONFromFile();
        String optString = readJSONFromFile.optString(FIREBASE_INSTALLATION_ID_KEY, (String) null);
        int optInt = readJSONFromFile.optInt(PERSISTED_STATUS_KEY, RegistrationStatus.ATTEMPT_MIGRATION.ordinal());
        String optString2 = readJSONFromFile.optString(AUTH_TOKEN_KEY, (String) null);
        String optString3 = readJSONFromFile.optString(REFRESH_TOKEN_KEY, (String) null);
        long optLong = readJSONFromFile.optLong(TOKEN_CREATION_TIME_IN_SECONDS_KEY, 0);
        long optLong2 = readJSONFromFile.optLong(EXPIRES_IN_SECONDS_KEY, 0);
        return PersistedInstallationEntry.builder().setFirebaseInstallationId(optString).setRegistrationStatus(RegistrationStatus.values()[optInt]).setAuthToken(optString2).setRefreshToken(optString3).setTokenCreationEpochInSecs(optLong).setExpiresInSecs(optLong2).setFisError(readJSONFromFile.optString(FIS_ERROR_KEY, (String) null)).build();
    }

    /* JADX WARNING: Code restructure failed: missing block: B:12:0x0029, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:14:?, code lost:
        r2.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:19:0x0033, code lost:
        return new org.json.JSONObject();
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:15:0x002d */
    /* JADX WARNING: Removed duplicated region for block: B:18:? A[ExcHandler: IOException | JSONException (unused java.lang.Throwable), SYNTHETIC, Splitter:B:3:0x0010] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private org.json.JSONObject readJSONFromFile() {
        /*
            r5 = this;
            java.io.ByteArrayOutputStream r0 = new java.io.ByteArrayOutputStream
            r0.<init>()
            r1 = 16384(0x4000, float:2.2959E-41)
            byte[] r1 = new byte[r1]
            java.io.FileInputStream r2 = new java.io.FileInputStream     // Catch:{ IOException | JSONException -> 0x002e }
            java.io.File r3 = r5.dataFile     // Catch:{ IOException | JSONException -> 0x002e }
            r2.<init>(r3)     // Catch:{ IOException | JSONException -> 0x002e }
        L_0x0010:
            int r3 = r1.length     // Catch:{ Throwable -> 0x0029, IOException | JSONException -> 0x002e }
            r4 = 0
            int r3 = r2.read(r1, r4, r3)     // Catch:{ Throwable -> 0x0029, IOException | JSONException -> 0x002e }
            if (r3 >= 0) goto L_0x0025
            org.json.JSONObject r1 = new org.json.JSONObject     // Catch:{ Throwable -> 0x0029, IOException | JSONException -> 0x002e }
            java.lang.String r0 = r0.toString()     // Catch:{ Throwable -> 0x0029, IOException | JSONException -> 0x002e }
            r1.<init>(r0)     // Catch:{ Throwable -> 0x0029, IOException | JSONException -> 0x002e }
            r2.close()     // Catch:{ IOException | JSONException -> 0x002e }
            return r1
        L_0x0025:
            r0.write(r1, r4, r3)     // Catch:{ Throwable -> 0x0029, IOException | JSONException -> 0x002e }
            goto L_0x0010
        L_0x0029:
            r0 = move-exception
            r2.close()     // Catch:{ Throwable -> 0x002d, IOException | JSONException -> 0x002e }
        L_0x002d:
            throw r0     // Catch:{ IOException | JSONException -> 0x002e }
        L_0x002e:
            org.json.JSONObject r0 = new org.json.JSONObject
            r0.<init>()
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.firebase.installations.local.PersistedInstallation.readJSONFromFile():org.json.JSONObject");
    }

    @NonNull
    public PersistedInstallationEntry insertOrUpdatePersistedInstallationEntry(@NonNull PersistedInstallationEntry persistedInstallationEntry) {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put(FIREBASE_INSTALLATION_ID_KEY, persistedInstallationEntry.getFirebaseInstallationId());
            jSONObject.put(PERSISTED_STATUS_KEY, persistedInstallationEntry.getRegistrationStatus().ordinal());
            jSONObject.put(AUTH_TOKEN_KEY, persistedInstallationEntry.getAuthToken());
            jSONObject.put(REFRESH_TOKEN_KEY, persistedInstallationEntry.getRefreshToken());
            jSONObject.put(TOKEN_CREATION_TIME_IN_SECONDS_KEY, persistedInstallationEntry.getTokenCreationEpochInSecs());
            jSONObject.put(EXPIRES_IN_SECONDS_KEY, persistedInstallationEntry.getExpiresInSecs());
            jSONObject.put(FIS_ERROR_KEY, persistedInstallationEntry.getFisError());
            File createTempFile = File.createTempFile(SETTINGS_FILE_NAME_PREFIX, "tmp", this.firebaseApp.getApplicationContext().getFilesDir());
            FileOutputStream fileOutputStream = new FileOutputStream(createTempFile);
            fileOutputStream.write(jSONObject.toString().getBytes("UTF-8"));
            fileOutputStream.close();
            if (createTempFile.renameTo(this.dataFile)) {
                return persistedInstallationEntry;
            }
            throw new IOException("unable to rename the tmpfile to PersistedInstallation");
        } catch (IOException | JSONException unused) {
        }
    }

    public void clearForTesting() {
        this.dataFile.delete();
    }
}

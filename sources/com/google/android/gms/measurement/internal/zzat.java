package com.google.android.gms.measurement.internal;

import android.content.Context;
import androidx.annotation.Nullable;
import com.google.android.exoplayer2.DefaultRenderersFactory;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.internal.measurement.zzco;
import com.google.android.gms.internal.measurement.zzdd;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

@VisibleForTesting
/* compiled from: com.google.android.gms:play-services-measurement-impl@@17.5.0 */
public final class zzat {
    public static zzem<Long> zza = zza("measurement.ad_id_cache_time", 10000L, 10000L, zzas.zza);
    public static zzem<Long> zzaa = zza("measurement.upload.retry_time", 1800000L, 1800000L, zzbn.zza);
    public static zzem<Integer> zzab = zza("measurement.upload.retry_count", 6, 6, zzbm.zza);
    public static zzem<Long> zzac = zza("measurement.upload.max_queue_time", 2419200000L, 2419200000L, zzbp.zza);
    public static zzem<Integer> zzad = zza("measurement.lifetimevalue.max_currency_tracked", 4, 4, zzbo.zza);
    public static zzem<Integer> zzae = zza("measurement.audience.filter_result_max_count", 200, 200, zzbq.zza);
    public static zzem<Integer> zzaf = zza("measurement.upload.max_public_user_properties", 25, 25, (zzek) null);
    public static zzem<Integer> zzag = zza("measurement.upload.max_event_name_cardinality", 500, 500, (zzek) null);
    public static zzem<Integer> zzah = zza("measurement.upload.max_public_event_params", 25, 25, (zzek) null);
    public static zzem<Long> zzai;
    public static zzem<Boolean> zzaj = zza("measurement.test.boolean_flag", false, false, zzbs.zza);
    public static zzem<String> zzak = zza("measurement.test.string_flag", "---", "---", zzbv.zza);
    public static zzem<Long> zzal = zza("measurement.test.long_flag", -1L, -1L, zzbu.zza);
    public static zzem<Integer> zzam = zza("measurement.test.int_flag", -2, -2, zzbx.zza);
    public static zzem<Double> zzan;
    public static zzem<Integer> zzao = zza("measurement.experiment.max_ids", 50, 50, zzbz.zza);
    public static zzem<Integer> zzap = zza("measurement.max_bundles_per_iteration", 100, 100, zzby.zza);
    public static zzem<Boolean> zzaq = zza("measurement.validation.internal_limits_internal_event_params", false, false, zzcb.zza);
    public static zzem<Boolean> zzar = zza("measurement.referrer.enable_logging_install_referrer_cmp_from_apk", true, true, zzcd.zza);
    public static zzem<Boolean> zzas = zza("measurement.collection.firebase_global_collection_flag_enabled", true, true, zzcc.zza);
    public static zzem<Boolean> zzat = zza("measurement.collection.efficient_engagement_reporting_enabled_2", true, true, zzcf.zza);
    public static zzem<Boolean> zzau = zza("measurement.collection.redundant_engagement_removal_enabled", false, false, zzce.zza);
    public static zzem<Boolean> zzav = zza("measurement.client.freeride_engagement_fix", true, true, zzch.zza);
    public static zzem<Boolean> zzaw = zza("measurement.collection.log_event_and_bundle_v2", true, true, zzcg.zza);
    public static zzem<Boolean> zzax = zza("measurement.quality.checksum", false, false, (zzek) null);
    public static zzem<Boolean> zzay = zza("measurement.sdk.dynamite.allow_remote_dynamite2", false, false, zzcj.zza);
    public static zzem<Boolean> zzaz = zza("measurement.sdk.collection.validate_param_names_alphabetical", true, true, zzci.zza);
    public static zzem<Long> zzb = zza("measurement.monitoring.sample_period_millis", 86400000L, 86400000L, zzav.zza);
    public static zzem<Boolean> zzba = zza("measurement.audience.use_bundle_end_timestamp_for_non_sequence_property_filters", false, false, zzcl.zza);
    public static zzem<Boolean> zzbb = zza("measurement.audience.refresh_event_count_filters_timestamp", false, false, zzck.zza);
    public static zzem<Boolean> zzbc = zza("measurement.audience.use_bundle_timestamp_for_event_count_filters", false, false, zzcm.zza);
    public static zzem<Boolean> zzbd = zza("measurement.sdk.collection.retrieve_deeplink_from_bow_2", true, true, zzcp.zza);
    public static zzem<Boolean> zzbe = zza("measurement.sdk.collection.last_deep_link_referrer2", true, true, zzco.zza);
    public static zzem<Boolean> zzbf = zza("measurement.sdk.collection.last_deep_link_referrer_campaign2", false, false, zzcr.zza);
    public static zzem<Boolean> zzbg = zza("measurement.sdk.collection.last_gclid_from_referrer2", false, false, zzcq.zza);
    public static zzem<Boolean> zzbh = zza("measurement.sdk.collection.enable_extend_user_property_size", true, true, zzct.zza);
    public static zzem<Boolean> zzbi = zza("measurement.upload.file_lock_state_check", false, false, zzcs.zza);
    public static zzem<Boolean> zzbj = zza("measurement.ga.ga_app_id", false, false, zzcv.zza);
    public static zzem<Boolean> zzbk = zza("measurement.lifecycle.app_backgrounded_tracking", true, true, zzcu.zza);
    public static zzem<Boolean> zzbl = zza("measurement.lifecycle.app_in_background_parameter", false, false, zzcx.zza);
    public static zzem<Boolean> zzbm = zza("measurement.integration.disable_firebase_instance_id", false, false, zzcz.zza);
    public static zzem<Boolean> zzbn = zza("measurement.lifecycle.app_backgrounded_engagement", false, false, zzcy.zza);
    public static zzem<Boolean> zzbo = zza("measurement.collection.service.update_with_analytics_fix", false, false, zzdb.zza);
    public static zzem<Boolean> zzbp = zza("measurement.service.use_appinfo_modified", false, false, zzda.zza);
    public static zzem<Boolean> zzbq = zza("measurement.client.firebase_feature_rollout.v1.enable", true, true, zzdd.zza);
    public static zzem<Boolean> zzbr = zza("measurement.client.sessions.check_on_reset_and_enable2", true, true, zzdc.zza);
    public static zzem<Boolean> zzbs = zza("measurement.scheduler.task_thread.cleanup_on_exit", false, false, zzdf.zza);
    public static zzem<Boolean> zzbt = zza("measurement.upload.file_truncate_fix", false, false, zzde.zza);
    public static zzem<Boolean> zzbu = zza("measurement.sdk.referrer.delayed_install_referrer_api", false, false, zzdh.zza);
    public static zzem<Boolean> zzbv = zza("measurement.sdk.screen.disabling_automatic_reporting", true, true, zzdg.zza);
    public static zzem<Boolean> zzbw = zza("measurement.sdk.screen.manual_screen_view_logging", true, true, zzdi.zza);
    public static zzem<Boolean> zzbx = zza("measurement.gold.enhanced_ecommerce.format_logs", true, true, zzdl.zza);
    public static zzem<Boolean> zzby = zza("measurement.gold.enhanced_ecommerce.nested_param_daily_event_count", true, true, zzdk.zza);
    public static zzem<Boolean> zzbz = zza("measurement.gold.enhanced_ecommerce.upload_nested_complex_events", true, true, zzdn.zza);
    public static zzem<Long> zzc = zza("measurement.config.cache_time", 86400000L, 3600000L, zzbe.zza);
    public static zzem<Boolean> zzca = zza("measurement.gold.enhanced_ecommerce.log_nested_complex_events", true, true, zzdm.zza);
    public static zzem<Boolean> zzcb = zza("measurement.gold.enhanced_ecommerce.updated_schema.client", true, true, zzdp.zza);
    public static zzem<Boolean> zzcc = zza("measurement.gold.enhanced_ecommerce.updated_schema.service", true, true, zzdo.zza);
    public static zzem<Boolean> zzcd = zza("measurement.service.configurable_service_limits", true, true, zzdq.zza);
    public static zzem<Boolean> zzce = zza("measurement.client.configurable_service_limits", true, true, zzdt.zza);
    public static zzem<Boolean> zzcf = zza("measurement.androidId.delete_feature", true, true, zzdv.zza);
    public static zzem<Boolean> zzcg = zza("measurement.client.global_params", true, true, zzdu.zza);
    public static zzem<Boolean> zzch = zza("measurement.service.global_params", true, true, zzdx.zza);
    public static zzem<Boolean> zzci = zza("measurement.service.global_params_in_payload", true, true, zzdw.zza);
    public static zzem<Boolean> zzcj = zza("measurement.client.string_reader", true, true, zzdz.zza);
    public static zzem<Boolean> zzck = zza("measurement.sdk.attribution.cache", true, true, zzdy.zza);
    public static zzem<Long> zzcl = zza("measurement.sdk.attribution.cache.ttl", 604800000L, 604800000L, zzeb.zza);
    public static zzem<Boolean> zzcm = zza("measurement.service.database_return_empty_collection", true, true, zzea.zza);
    public static zzem<Boolean> zzcn = zza("measurement.service.ssaid_removal", true, true, zzed.zza);
    public static zzem<Boolean> zzco = zza("measurement.client.consent_state_v1", false, false, zzec.zza);
    public static zzem<Boolean> zzcp = zza("measurement.service.consent_state_v1_W33", false, false, zzee.zza);
    public static zzem<Integer> zzcq = zza("measurement.service.storage_consent_support_version", 203290, 203290, zzeh.zza);
    public static zzem<Boolean> zzcr = zza("measurement.client.ad_impression.dev", false, false, zzeg.zza);
    public static zzem<Boolean> zzcs = zza("measurement.service.ad_impression", false, false, zzej.zza);
    public static zzem<Boolean> zzct = zza("measurement.service.separate_public_internal_event_blacklisting", false, false, zzei.zza);
    /* access modifiers changed from: private */
    public static List<zzem<?>> zzcu = Collections.synchronizedList(new ArrayList());
    private static Set<zzem<?>> zzcv = Collections.synchronizedSet(new HashSet());
    private static zzem<Boolean> zzcw = zza("measurement.collection.synthetic_data_mitigation", false, false, zzdr.zza);
    public static zzem<String> zzd = zza("measurement.config.url_scheme", "https", "https", zzbr.zza);
    public static zzem<String> zze = zza("measurement.config.url_authority", "app-measurement.com", "app-measurement.com", zzca.zza);
    public static zzem<Integer> zzf = zza("measurement.upload.max_bundles", 100, 100, zzcn.zza);
    public static zzem<Integer> zzg = zza("measurement.upload.max_batch_size", 65536, 65536, zzcw.zza);
    public static zzem<Integer> zzh = zza("measurement.upload.max_bundle_size", 65536, 65536, zzdj.zza);
    public static zzem<Integer> zzi = zza("measurement.upload.max_events_per_bundle", 1000, 1000, zzds.zza);
    public static zzem<Integer> zzj = zza("measurement.upload.max_events_per_day", 100000, 100000, zzef.zza);
    public static zzem<Integer> zzk = zza("measurement.upload.max_error_events_per_day", 1000, 1000, zzau.zza);
    public static zzem<Integer> zzl = zza("measurement.upload.max_public_events_per_day", 50000, 50000, zzax.zza);
    public static zzem<Integer> zzm = zza("measurement.upload.max_conversions_per_day", 10000, 10000, zzaw.zza);
    public static zzem<Integer> zzn = zza("measurement.upload.max_realtime_events_per_day", 10, 10, zzaz.zza);
    public static zzem<Integer> zzo = zza("measurement.store.max_stored_events_per_app", 100000, 100000, zzay.zza);
    public static zzem<String> zzp = zza("measurement.upload.url", "https://app-measurement.com/a", "https://app-measurement.com/a", zzbb.zza);
    public static zzem<Long> zzq = zza("measurement.upload.backoff_period", 43200000L, 43200000L, zzba.zza);
    public static zzem<Long> zzr = zza("measurement.upload.window_interval", 3600000L, 3600000L, zzbd.zza);
    public static zzem<Long> zzs = zza("measurement.upload.interval", 3600000L, 3600000L, zzbc.zza);
    public static zzem<Long> zzt = zza("measurement.upload.realtime_upload_interval", 10000L, 10000L, zzbf.zza);
    public static zzem<Long> zzu = zza("measurement.upload.debug_upload_interval", 1000L, 1000L, zzbh.zza);
    public static zzem<Long> zzv = zza("measurement.upload.minimum_delay", 500L, 500L, zzbg.zza);
    public static zzem<Long> zzw = zza("measurement.alarm_manager.minimum_interval", 60000L, 60000L, zzbj.zza);
    public static zzem<Long> zzx = zza("measurement.upload.stale_data_deletion_interval", 86400000L, 86400000L, zzbi.zza);
    public static zzem<Long> zzy = zza("measurement.upload.refresh_blacklisted_config_interval", 604800000L, 604800000L, zzbl.zza);
    public static zzem<Long> zzz = zza("measurement.upload.initial_upload_delay_time", 15000L, 15000L, zzbk.zza);

    public static Map<String, String> zza(Context context) {
        zzco zza2 = zzco.zza(context.getContentResolver(), zzdd.zza("com.google.android.gms.measurement"));
        return zza2 == null ? Collections.emptyMap() : zza2.zza();
    }

    @VisibleForTesting
    private static <V> zzem<V> zza(@Nullable String str, @Nullable V v, @Nullable V v2, @Nullable zzek<V> zzek) {
        zzem zzem = new zzem(str, v, v2, zzek);
        zzcu.add(zzem);
        return zzem;
    }

    static {
        Long valueOf = Long.valueOf(DefaultRenderersFactory.DEFAULT_ALLOWED_VIDEO_JOINING_TIME_MS);
        zzai = zza("measurement.service_client.idle_disconnect_millis", valueOf, valueOf, zzbt.zza);
        Double valueOf2 = Double.valueOf(-3.0d);
        zzan = zza("measurement.test.double_flag", valueOf2, valueOf2, zzbw.zza);
    }
}

package com.google.android.gms.internal.measurement;

import android.support.p000v4.media.session.PlaybackStateCompat;
import com.google.android.exoplayer2.DefaultRenderersFactory;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@17.5.0 */
public final class zzlx implements zzly {
    private static final zzdc<Long> zza;
    private static final zzdc<Long> zzaa;
    private static final zzdc<Long> zzab;
    private static final zzdc<Long> zzac;
    private static final zzdc<Long> zzad;
    private static final zzdc<Long> zzae;
    private static final zzdc<Long> zzaf;
    private static final zzdc<Long> zzag;
    private static final zzdc<Long> zzah;
    private static final zzdc<String> zzai;
    private static final zzdc<Long> zzaj;
    private static final zzdc<Long> zzb;
    private static final zzdc<String> zzc;
    private static final zzdc<String> zzd;
    private static final zzdc<String> zze;
    private static final zzdc<Long> zzf;
    private static final zzdc<Long> zzg;
    private static final zzdc<Long> zzh;
    private static final zzdc<Long> zzi;
    private static final zzdc<Long> zzj;
    private static final zzdc<Long> zzk;
    private static final zzdc<Long> zzl;
    private static final zzdc<Long> zzm;
    private static final zzdc<Long> zzn;
    private static final zzdc<Long> zzo;
    private static final zzdc<Long> zzp;
    private static final zzdc<Long> zzq;
    private static final zzdc<String> zzr;
    private static final zzdc<Long> zzs;
    private static final zzdc<Long> zzt;
    private static final zzdc<Long> zzu;
    private static final zzdc<Long> zzv;
    private static final zzdc<Long> zzw;
    private static final zzdc<Long> zzx;
    private static final zzdc<Long> zzy;
    private static final zzdc<Long> zzz;

    public final long zza() {
        return zza.zzc().longValue();
    }

    public final long zzb() {
        return zzb.zzc().longValue();
    }

    public final String zzc() {
        return zzd.zzc();
    }

    public final String zzd() {
        return zze.zzc();
    }

    public final long zze() {
        return zzf.zzc().longValue();
    }

    public final long zzf() {
        return zzg.zzc().longValue();
    }

    public final long zzg() {
        return zzh.zzc().longValue();
    }

    public final long zzh() {
        return zzi.zzc().longValue();
    }

    public final long zzi() {
        return zzj.zzc().longValue();
    }

    public final long zzj() {
        return zzk.zzc().longValue();
    }

    public final long zzk() {
        return zzl.zzc().longValue();
    }

    public final long zzl() {
        return zzm.zzc().longValue();
    }

    public final long zzm() {
        return zzn.zzc().longValue();
    }

    public final long zzn() {
        return zzo.zzc().longValue();
    }

    public final long zzo() {
        return zzq.zzc().longValue();
    }

    public final long zzp() {
        return zzs.zzc().longValue();
    }

    public final long zzq() {
        return zzt.zzc().longValue();
    }

    public final long zzr() {
        return zzu.zzc().longValue();
    }

    public final long zzs() {
        return zzv.zzc().longValue();
    }

    public final long zzt() {
        return zzw.zzc().longValue();
    }

    public final long zzu() {
        return zzx.zzc().longValue();
    }

    public final long zzv() {
        return zzy.zzc().longValue();
    }

    public final long zzw() {
        return zzz.zzc().longValue();
    }

    public final long zzx() {
        return zzaa.zzc().longValue();
    }

    public final long zzy() {
        return zzab.zzc().longValue();
    }

    public final long zzz() {
        return zzac.zzc().longValue();
    }

    public final long zzaa() {
        return zzad.zzc().longValue();
    }

    public final long zzab() {
        return zzae.zzc().longValue();
    }

    public final long zzac() {
        return zzaf.zzc().longValue();
    }

    public final long zzad() {
        return zzag.zzc().longValue();
    }

    public final long zzae() {
        return zzah.zzc().longValue();
    }

    public final String zzaf() {
        return zzai.zzc();
    }

    public final long zzag() {
        return zzaj.zzc().longValue();
    }

    static {
        zzdl zzdl = new zzdl(zzdd.zza("com.google.android.gms.measurement"));
        zza = zzdl.zza("measurement.ad_id_cache_time", 10000);
        zzb = zzdl.zza("measurement.config.cache_time", 86400000);
        zzc = zzdl.zza("measurement.log_tag", "FA");
        zzd = zzdl.zza("measurement.config.url_authority", "app-measurement.com");
        zze = zzdl.zza("measurement.config.url_scheme", "https");
        zzf = zzdl.zza("measurement.upload.debug_upload_interval", 1000);
        zzg = zzdl.zza("measurement.lifetimevalue.max_currency_tracked", 4);
        zzh = zzdl.zza("measurement.store.max_stored_events_per_app", 100000);
        zzi = zzdl.zza("measurement.experiment.max_ids", 50);
        zzj = zzdl.zza("measurement.audience.filter_result_max_count", 200);
        zzk = zzdl.zza("measurement.alarm_manager.minimum_interval", 60000);
        zzl = zzdl.zza("measurement.upload.minimum_delay", 500);
        zzm = zzdl.zza("measurement.monitoring.sample_period_millis", 86400000);
        zzn = zzdl.zza("measurement.upload.realtime_upload_interval", 10000);
        zzo = zzdl.zza("measurement.upload.refresh_blacklisted_config_interval", 604800000);
        zzp = zzdl.zza("measurement.config.cache_time.service", 3600000);
        zzq = zzdl.zza("measurement.service_client.idle_disconnect_millis", (long) DefaultRenderersFactory.DEFAULT_ALLOWED_VIDEO_JOINING_TIME_MS);
        zzr = zzdl.zza("measurement.log_tag.service", "FA-SVC");
        zzs = zzdl.zza("measurement.upload.stale_data_deletion_interval", 86400000);
        zzt = zzdl.zza("measurement.upload.backoff_period", 43200000);
        zzu = zzdl.zza("measurement.upload.initial_upload_delay_time", 15000);
        zzv = zzdl.zza("measurement.upload.interval", 3600000);
        zzw = zzdl.zza("measurement.upload.max_bundle_size", (long) PlaybackStateCompat.ACTION_PREPARE_FROM_SEARCH);
        zzx = zzdl.zza("measurement.upload.max_bundles", 100);
        zzy = zzdl.zza("measurement.upload.max_conversions_per_day", 500);
        zzz = zzdl.zza("measurement.upload.max_error_events_per_day", 1000);
        zzaa = zzdl.zza("measurement.upload.max_events_per_bundle", 1000);
        zzab = zzdl.zza("measurement.upload.max_events_per_day", 100000);
        zzac = zzdl.zza("measurement.upload.max_public_events_per_day", 50000);
        zzad = zzdl.zza("measurement.upload.max_queue_time", 2419200000L);
        zzae = zzdl.zza("measurement.upload.max_realtime_events_per_day", 10);
        zzaf = zzdl.zza("measurement.upload.max_batch_size", (long) PlaybackStateCompat.ACTION_PREPARE_FROM_SEARCH);
        zzag = zzdl.zza("measurement.upload.retry_count", 6);
        zzah = zzdl.zza("measurement.upload.retry_time", 1800000);
        zzai = zzdl.zza("measurement.upload.url", "https://app-measurement.com/a");
        zzaj = zzdl.zza("measurement.upload.window_interval", 3600000);
    }
}

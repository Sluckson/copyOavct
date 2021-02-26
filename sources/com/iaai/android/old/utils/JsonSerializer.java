package com.iaai.android.old.utils;

import android.text.TextUtils;
import com.iaai.android.IaaiApplication;
import com.iaai.android.bdt.utils.Constants_MVVM;
import com.iaai.android.old.utils.constants.Constants;
import java.io.IOException;
import java.io.InputStream;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.TimeZone;
import org.codehaus.jackson.JsonParser;
import org.codehaus.jackson.JsonToken;
import org.codehaus.jackson.map.DeserializationContext;
import org.codehaus.jackson.map.DeserializationProblemHandler;
import org.codehaus.jackson.map.JsonDeserializer;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.type.TypeReference;
import roboguice.util.C5058Ln;

public class JsonSerializer {
    private static final String CONTENT_TYPE = "application/json";
    private static final ObjectMapper jsonObjectMapper = new ObjectMapper();

    public static String getContentType() {
        return "application/json";
    }

    static {
        jsonObjectMapper.getDeserializationConfig().addHandler(new JsonDeserializationProblemHandler());
    }

    public static String serialize(Object obj) throws IOException {
        C5058Ln.m4829d("Before serializing json object ", new Object[0]);
        String writeValueAsString = jsonObjectMapper.writeValueAsString(obj);
        C5058Ln.m4829d("After serializing json object - %s", writeValueAsString);
        return writeValueAsString;
    }

    public static <TResult> TResult deserialize(String str, Class<? extends TResult> cls) throws IOException {
        C5058Ln.m4829d("Before deserializing json string - %s", str);
        TResult readValue = jsonObjectMapper.readValue(str, cls);
        C5058Ln.m4829d("After deserializing json string", new Object[0]);
        return readValue;
    }

    public static <TResult> TResult deserialize(InputStream inputStream, Class<? extends TResult> cls) throws IOException {
        C5058Ln.m4829d("Before deserializing json string", new Object[0]);
        TResult readValue = jsonObjectMapper.readValue(inputStream, cls);
        C5058Ln.m4829d("After deserializing json string", new Object[0]);
        return readValue;
    }

    public static <TResult> List<TResult> deserializeList(InputStream inputStream, TypeReference typeReference) throws IOException {
        C5058Ln.m4829d("Before deserializeList json string", new Object[0]);
        List<TResult> list = (List) jsonObjectMapper.readValue(inputStream, typeReference);
        C5058Ln.m4829d("After deserializeList json string", new Object[0]);
        return list;
    }

    public static String slurp(InputStream inputStream) throws IOException {
        StringBuilder sb = new StringBuilder();
        byte[] bArr = new byte[4096];
        while (true) {
            int read = inputStream.read(bArr);
            if (read == -1) {
                return sb.toString();
            }
            sb.append(new String(bArr, 0, read));
        }
    }

    public static abstract class PatternDrivenDateDeserializer extends JsonDeserializer<Date> {
        private String datePattern;

        /* renamed from: df */
        private final ThreadLocal<DateFormat> f513df;
        private final TimeZone timeZone;

        public PatternDrivenDateDeserializer(String str) {
            this(str, (TimeZone) null);
        }

        public PatternDrivenDateDeserializer(String str, TimeZone timeZone2) {
            this.f513df = new DateFormatThreadLocal(str);
            this.timeZone = timeZone2;
            this.datePattern = str;
            C5058Ln.m4829d("In PatternDrivenDateDeserializer ctor. DatePattern[%s]", str);
        }

        public Date deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException {
            if (jsonParser.getCurrentToken() == JsonToken.VALUE_STRING) {
                return convertStringToDate(jsonParser.getText().trim());
            }
            return null;
        }

        private Date convertStringToDate(String str) {
            Date date = null;
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            try {
                Locale locale = IaaiApplication.getInstance().getResources().getConfiguration().locale;
                if (!locale.getLanguage().startsWith("ar") && !locale.getLanguage().startsWith("ko") && !locale.getLanguage().startsWith(Constants_MVVM.EXTRA_SPANISH_CODE)) {
                    if (!locale.getLanguage().startsWith("ch")) {
                        Date parse = this.f513df.get().parse(str);
                        try {
                            if (this.timeZone != null) {
                                parse = DateHelper.toDateInTimeZone(parse, this.timeZone);
                            }
                            return parse;
                        } catch (Exception e) {
                            e = e;
                            date = parse;
                            e.printStackTrace();
                            return date;
                        }
                    }
                }
                return new SimpleDateFormat(this.datePattern, Locale.ENGLISH).parse(str);
            } catch (Exception e2) {
                e = e2;
                e.printStackTrace();
                return date;
            }
        }
    }

    public static class ServerDateDeserializer extends PatternDrivenDateDeserializer {
        public ServerDateDeserializer() {
            super(Constants.DATE_PATTERN_DATE_TIME, Constants.TIMEZONE_SERVER);
        }
    }

    static class JsonDeserializationProblemHandler extends DeserializationProblemHandler {
        JsonDeserializationProblemHandler() {
        }

        public boolean handleUnknownProperty(DeserializationContext deserializationContext, JsonDeserializer<?> jsonDeserializer, Object obj, String str) throws IOException {
            C5058Ln.m4838v("Unable to deserialize class[%s].  Unknow property[%s]", obj.getClass().getName(), str);
            deserializationContext.getParser().skipChildren();
            return true;
        }
    }
}

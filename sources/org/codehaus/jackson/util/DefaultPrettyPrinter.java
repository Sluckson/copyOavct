package org.codehaus.jackson.util;

import java.io.IOException;
import java.util.Arrays;
import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.JsonGenerator;
import org.codehaus.jackson.PrettyPrinter;
import org.codehaus.jackson.impl.Indenter;

public class DefaultPrettyPrinter implements PrettyPrinter {
    protected Indenter _arrayIndenter = new FixedSpaceIndenter();
    protected int _nesting = 0;
    protected Indenter _objectIndenter = new Lf2SpacesIndenter();
    protected boolean _spacesInObjectEntries = true;

    public static class NopIndenter implements Indenter {
        public boolean isInline() {
            return true;
        }

        public void writeIndentation(JsonGenerator jsonGenerator, int i) {
        }
    }

    public void indentArraysWith(Indenter indenter) {
        if (indenter == null) {
            indenter = new NopIndenter();
        }
        this._arrayIndenter = indenter;
    }

    public void indentObjectsWith(Indenter indenter) {
        if (indenter == null) {
            indenter = new NopIndenter();
        }
        this._objectIndenter = indenter;
    }

    public void spacesInObjectEntries(boolean z) {
        this._spacesInObjectEntries = z;
    }

    public void writeRootValueSeparator(JsonGenerator jsonGenerator) throws IOException, JsonGenerationException {
        jsonGenerator.writeRaw(' ');
    }

    public void writeStartObject(JsonGenerator jsonGenerator) throws IOException, JsonGenerationException {
        jsonGenerator.writeRaw('{');
        if (!this._objectIndenter.isInline()) {
            this._nesting++;
        }
    }

    public void beforeObjectEntries(JsonGenerator jsonGenerator) throws IOException, JsonGenerationException {
        this._objectIndenter.writeIndentation(jsonGenerator, this._nesting);
    }

    public void writeObjectFieldValueSeparator(JsonGenerator jsonGenerator) throws IOException, JsonGenerationException {
        if (this._spacesInObjectEntries) {
            jsonGenerator.writeRaw(" : ");
        } else {
            jsonGenerator.writeRaw(':');
        }
    }

    public void writeObjectEntrySeparator(JsonGenerator jsonGenerator) throws IOException, JsonGenerationException {
        jsonGenerator.writeRaw(',');
        this._objectIndenter.writeIndentation(jsonGenerator, this._nesting);
    }

    public void writeEndObject(JsonGenerator jsonGenerator, int i) throws IOException, JsonGenerationException {
        if (!this._objectIndenter.isInline()) {
            this._nesting--;
        }
        if (i > 0) {
            this._objectIndenter.writeIndentation(jsonGenerator, this._nesting);
        } else {
            jsonGenerator.writeRaw(' ');
        }
        jsonGenerator.writeRaw('}');
    }

    public void writeStartArray(JsonGenerator jsonGenerator) throws IOException, JsonGenerationException {
        if (!this._arrayIndenter.isInline()) {
            this._nesting++;
        }
        jsonGenerator.writeRaw('[');
    }

    public void beforeArrayValues(JsonGenerator jsonGenerator) throws IOException, JsonGenerationException {
        this._arrayIndenter.writeIndentation(jsonGenerator, this._nesting);
    }

    public void writeArrayValueSeparator(JsonGenerator jsonGenerator) throws IOException, JsonGenerationException {
        jsonGenerator.writeRaw(',');
        this._arrayIndenter.writeIndentation(jsonGenerator, this._nesting);
    }

    public void writeEndArray(JsonGenerator jsonGenerator, int i) throws IOException, JsonGenerationException {
        if (!this._arrayIndenter.isInline()) {
            this._nesting--;
        }
        if (i > 0) {
            this._arrayIndenter.writeIndentation(jsonGenerator, this._nesting);
        } else {
            jsonGenerator.writeRaw(' ');
        }
        jsonGenerator.writeRaw(']');
    }

    public static class FixedSpaceIndenter implements Indenter {
        public boolean isInline() {
            return true;
        }

        public void writeIndentation(JsonGenerator jsonGenerator, int i) throws IOException, JsonGenerationException {
            jsonGenerator.writeRaw(' ');
        }
    }

    public static class Lf2SpacesIndenter implements Indenter {
        static final char[] SPACES = new char[64];
        static final int SPACE_COUNT = 64;
        static final String SYSTEM_LINE_SEPARATOR;

        public boolean isInline() {
            return false;
        }

        static {
            String str;
            try {
                str = System.getProperty("line.separator");
            } catch (Throwable unused) {
                str = null;
            }
            if (str == null) {
                str = "\n";
            }
            SYSTEM_LINE_SEPARATOR = str;
            Arrays.fill(SPACES, ' ');
        }

        public void writeIndentation(JsonGenerator jsonGenerator, int i) throws IOException, JsonGenerationException {
            jsonGenerator.writeRaw(SYSTEM_LINE_SEPARATOR);
            int i2 = i + i;
            while (i2 > 64) {
                jsonGenerator.writeRaw(SPACES, 0, 64);
                i2 -= SPACES.length;
            }
            jsonGenerator.writeRaw(SPACES, 0, i2);
        }
    }
}
